/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.headless.commerce.delivery.catalog.internal.resource.v1_0;

import com.liferay.commerce.account.service.CommerceAccountLocalService;
import com.liferay.commerce.account.util.CommerceAccountHelper;
import com.liferay.commerce.context.CommerceContext;
import com.liferay.commerce.context.CommerceContextFactory;
import com.liferay.commerce.product.constants.CPField;
import com.liferay.commerce.product.exception.NoSuchCPDefinitionException;
import com.liferay.commerce.product.model.CPDefinition;
import com.liferay.commerce.product.model.CommerceChannel;
import com.liferay.commerce.product.permission.CommerceProductViewPermission;
import com.liferay.commerce.product.service.CPDefinitionLocalService;
import com.liferay.commerce.product.service.CommerceChannelLocalService;
import com.liferay.commerce.shop.by.diagram.model.CSDiagramEntry;
import com.liferay.headless.commerce.delivery.catalog.dto.v1_0.MappedProduct;
import com.liferay.headless.commerce.delivery.catalog.internal.dto.v1_0.converter.MappedProductDTOConverter;
import com.liferay.headless.commerce.delivery.catalog.internal.dto.v1_0.converter.MappedProductDTOConverterContext;
import com.liferay.headless.commerce.delivery.catalog.internal.util.v1_0.HeadlessCommerceDeliveryCatalogApplicationUtil;
import com.liferay.headless.commerce.delivery.catalog.resource.v1_0.MappedProductResource;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.security.permission.PermissionThreadLocal;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HashMapBuilder;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.vulcan.pagination.Page;
import com.liferay.portal.vulcan.pagination.Pagination;
import com.liferay.portal.vulcan.util.SearchUtil;

import java.io.Serializable;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ServiceScope;

/**
 * @author Andrea Sbarra
 * @author Alessio Antonio Rendina
 */
@Component(
	enabled = false,
	properties = "OSGI-INF/liferay/rest/v1_0/mapped-product.properties",
	scope = ServiceScope.PROTOTYPE, service = MappedProductResource.class
)
public class MappedProductResourceImpl extends BaseMappedProductResourceImpl {

	@Override
	public Page<MappedProduct> getChannelProductMappedProductsPage(
			Long channelId, Long productId, Long accountId, String search,
			Pagination pagination, Sort[] sorts)
		throws Exception {

		CPDefinition cpDefinition =
			_cpDefinitionLocalService.fetchCPDefinitionByCProductId(productId);

		if (cpDefinition == null) {
			throw new NoSuchCPDefinitionException(
				"Unable to find product with ID " + productId);
		}

		CommerceChannel commerceChannel =
			_commerceChannelLocalService.getCommerceChannel(channelId);

		Long commerceAccountId =
			HeadlessCommerceDeliveryCatalogApplicationUtil.getCommerceAccountId(
				accountId, _commerceAccountHelper, _commerceAccountLocalService,
				commerceChannel.getGroupId(), contextCompany.getCompanyId(),
				contextUser.getUserId());

		_commerceProductViewPermission.check(
			PermissionThreadLocal.getPermissionChecker(), commerceAccountId,
			commerceChannel.getGroupId(), cpDefinition.getCPDefinitionId());

		CommerceContext commerceContext = _commerceContextFactory.create(
			contextCompany.getCompanyId(), commerceChannel.getGroupId(),
			contextUser.getUserId(), 0, commerceAccountId);

		return _getMappedProductsPage(
			commerceAccountId, commerceChannel.getGroupId(), commerceContext,
			cpDefinition.getCPDefinitionId(), pagination, search, sorts);
	}

	private Page<MappedProduct> _getMappedProductsPage(
			long commerceAccountId, long commerceChannelGroupId,
			CommerceContext commerceContext, long cpDefinitionId,
			Pagination pagination, String search, Sort[] sorts)
		throws Exception {

		return SearchUtil.search(
			null,
			booleanQuery -> {
			},
			null, CSDiagramEntry.class.getName(), search, pagination,
			queryConfig -> queryConfig.setSelectedFieldNames(
				Field.ENTRY_CLASS_PK),
			searchContext -> {
				searchContext.setCompanyId(contextCompany.getCompanyId());

				if (Validator.isNotNull(search)) {
					searchContext.setKeywords(search);
				}

				searchContext.setAttributes(
					HashMapBuilder.<String, Serializable>put(
						CPField.CP_DEFINITION_ID, cpDefinitionId
					).put(
						"commerceAccountGroupIds",
						_commerceAccountHelper.getCommerceAccountGroupIds(
							commerceAccountId)
					).put(
						"commerceChannelGroupId", commerceChannelGroupId
					).put(
						"secure", true
					).build());
			},
			sorts,
			document -> _mappedProductDTOConverter.toDTO(
				new MappedProductDTOConverterContext(
					commerceContext, contextCompany.getCompanyId(),
					GetterUtil.getLong(document.get(Field.ENTRY_CLASS_PK)),
					contextAcceptLanguage.getPreferredLocale())));
	}

	@Reference
	private CommerceAccountHelper _commerceAccountHelper;

	@Reference
	private CommerceAccountLocalService _commerceAccountLocalService;

	@Reference
	private CommerceChannelLocalService _commerceChannelLocalService;

	@Reference
	private CommerceContextFactory _commerceContextFactory;

	@Reference
	private CommerceProductViewPermission _commerceProductViewPermission;

	@Reference
	private CPDefinitionLocalService _cpDefinitionLocalService;

	@Reference
	private MappedProductDTOConverter _mappedProductDTOConverter;

}