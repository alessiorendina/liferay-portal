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

package com.liferay.commerce.shop.by.diagram.internal.search.spi.model.index.contributor;

import com.liferay.commerce.account.model.CommerceAccountGroupRel;
import com.liferay.commerce.account.service.CommerceAccountGroupRelLocalService;
import com.liferay.commerce.product.constants.CPField;
import com.liferay.commerce.product.model.CPDefinition;
import com.liferay.commerce.product.model.CommerceChannel;
import com.liferay.commerce.product.model.CommerceChannelRel;
import com.liferay.commerce.product.service.CPDefinitionLocalService;
import com.liferay.commerce.product.service.CPInstanceLocalService;
import com.liferay.commerce.product.service.CommerceChannelLocalService;
import com.liferay.commerce.product.service.CommerceChannelRelLocalService;
import com.liferay.commerce.shop.by.diagram.model.CSDiagramEntry;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.search.spi.model.index.contributor.ModelDocumentContributor;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Alessio Antonio Rendina
 */
@Component(
	enabled = false, immediate = true,
	property = "indexer.class.name=com.liferay.commerce.shop.by.diagram.model.CSDiagramEntry",
	service = ModelDocumentContributor.class
)
public class CSDiagramEntryModelDocumentContributor
	implements ModelDocumentContributor<CSDiagramEntry> {

	@Override
	public void contribute(Document document, CSDiagramEntry csDiagramEntry) {
		document.addNumber(
			CPField.CP_DEFINITION_ID, csDiagramEntry.getCPDefinitionId());
		document.addText(CPField.SKU, csDiagramEntry.getSku());
		document.addNumber("quantity", csDiagramEntry.getQuantity());
		document.addText("sequence", csDiagramEntry.getSequence());

		CPDefinition cpDefinition =
			_cpDefinitionLocalService.fetchCPDefinitionByCProductId(
				csDiagramEntry.getCProductId());

		if (cpDefinition != null) {
			List<Long> commerceChannelGroupIds = new ArrayList<>();

			for (CommerceChannelRel commerceChannelRel :
					_commerceChannelRelLocalService.getCommerceChannelRels(
						cpDefinition.getModelClassName(),
						cpDefinition.getCPDefinitionId(), QueryUtil.ALL_POS,
						QueryUtil.ALL_POS, null)) {

				CommerceChannel commerceChannel =
					_commerceChannelLocalService.fetchCommerceChannel(
						commerceChannelRel.getCommerceChannelId());

				if (commerceChannel != null) {
					commerceChannelGroupIds.add(commerceChannel.getGroupId());
				}
			}

			document.addNumber(
				CPField.COMMERCE_CHANNEL_GROUP_IDS,
				ArrayUtil.toLongArray(commerceChannelGroupIds));

			List<CommerceAccountGroupRel> commerceAccountGroupRels =
				_commerceAccountGroupRelLocalService.
					getCommerceAccountGroupRels(
						CPDefinition.class.getName(),
						cpDefinition.getCPDefinitionId(), QueryUtil.ALL_POS,
						QueryUtil.ALL_POS, null);

			Stream<CommerceAccountGroupRel> stream =
				commerceAccountGroupRels.stream();

			long[] commerceAccountGroupIds = stream.mapToLong(
				CommerceAccountGroupRel::getCommerceAccountGroupId
			).toArray();

			document.addNumber(
				"commerceAccountGroupIds", commerceAccountGroupIds);
		}
	}

	@Reference
	private CommerceAccountGroupRelLocalService
		_commerceAccountGroupRelLocalService;

	@Reference
	private CommerceChannelLocalService _commerceChannelLocalService;

	@Reference
	private CommerceChannelRelLocalService _commerceChannelRelLocalService;

	@Reference
	private CPDefinitionLocalService _cpDefinitionLocalService;

	@Reference
	private CPInstanceLocalService _cpInstanceLocalService;

}