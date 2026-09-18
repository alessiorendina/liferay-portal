/**
 * SPDX-FileCopyrightText: (c) 2000 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.headless.commerce.admin.pricing.internal.util.v2_0;

import com.liferay.commerce.currency.service.CommerceCurrencyService;
import com.liferay.commerce.discount.model.CommerceDiscount;
import com.liferay.commerce.discount.model.CommerceDiscountRel;
import com.liferay.commerce.discount.service.CommerceDiscountRelService;
import com.liferay.commerce.product.exception.NoSuchCProductException;
import com.liferay.commerce.product.model.CPDefinition;
import com.liferay.commerce.product.model.CProduct;
import com.liferay.commerce.product.model.CommerceCatalog;
import com.liferay.commerce.product.service.CPDefinitionService;
import com.liferay.commerce.product.service.CProductLocalService;
import com.liferay.commerce.product.service.CommerceCatalogService;
import com.liferay.commerce.product.type.simple.constants.SimpleCPTypeConstants;
import com.liferay.headless.commerce.admin.pricing.dto.v2_0.DiscountProduct;
import com.liferay.headless.commerce.admin.pricing.internal.util.CommerceCatalogUtil;
import com.liferay.headless.commerce.core.helper.ServiceContextHelper;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.lazy.referencing.LazyReferencingThreadLocal;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.Validator;

/**
 * @author Alessio Antonio Rendina
 */
public class DiscountProductUtil {

	public static CommerceDiscountRel addCommerceDiscountRel(
			CommerceCatalogService commerceCatalogService,
			CommerceCurrencyService commerceCurrencyService,
			CommerceDiscountRelService commerceDiscountRelService,
			CPDefinitionService cpDefinitionService,
			CProductLocalService cProductLocalService,
			DiscountProduct discountProduct, CommerceDiscount commerceDiscount,
			ServiceContextHelper serviceContextHelper)
		throws PortalException {

		ServiceContext serviceContext =
			serviceContextHelper.getServiceContext();

		CProduct cProduct;

		if (Validator.isNull(
				discountProduct.getProductExternalReferenceCode())) {

			cProduct = cProductLocalService.getCProduct(
				discountProduct.getProductId());
		}
		else {
			cProduct =
				cProductLocalService.fetchCProductByExternalReferenceCode(
					discountProduct.getProductExternalReferenceCode(),
					serviceContext.getCompanyId());

			if (cProduct == null) {
				String productExternalReferenceCode =
					discountProduct.getProductExternalReferenceCode();

				if (!LazyReferencingThreadLocal.isEnabled()) {
					throw new NoSuchCProductException(
						"Unable to find product with external reference code " +
							productExternalReferenceCode);
				}

				CommerceCatalog commerceCatalog =
					CommerceCatalogUtil.getCommerceCatalog(
						discountProduct.getCatalogCurrencyCode(),
						discountProduct.
							getCatalogCurrencyExternalReferenceCode(),
						discountProduct.getCatalogExternalReferenceCode(),
						commerceCatalogService, commerceCurrencyService,
						serviceContext);

				CPDefinition cpDefinition =
					cpDefinitionService.getOrAddEmptyCPDefinition(
						productExternalReferenceCode,
						commerceCatalog.getGroupId(),
						GetterUtil.getString(
							discountProduct.getProductType(),
							SimpleCPTypeConstants.NAME));

				cProduct = cProductLocalService.getCProduct(
					cpDefinition.getCProductId());
			}
		}

		return commerceDiscountRelService.addCommerceDiscountRel(
			commerceDiscount.getCommerceDiscountId(),
			CPDefinition.class.getName(), cProduct.getPublishedCPDefinitionId(),
			null, serviceContext);
	}

}