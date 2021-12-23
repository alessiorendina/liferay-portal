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

package com.liferay.commerce.shop.by.diagram.internal.search.spi.model.query.contributor;

import com.liferay.commerce.product.constants.CPField;
import com.liferay.commerce.product.model.CommerceCatalog;
import com.liferay.commerce.product.service.CommerceCatalogService;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.search.BooleanClauseOccur;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.filter.BooleanFilter;
import com.liferay.portal.kernel.search.filter.Filter;
import com.liferay.portal.kernel.search.filter.TermFilter;
import com.liferay.portal.kernel.search.filter.TermsFilter;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.search.spi.model.query.contributor.ModelPreFilterContributor;
import com.liferay.portal.search.spi.model.registrar.ModelSearchSettings;

import java.util.List;
import java.util.stream.Stream;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Andrea Sbarra
 * @author Alessio Antonio Rendina
 */
@Component(
	enabled = false, immediate = true,
	property = "indexer.class.name=com.liferay.commerce.shop.by.diagram.model.CSDiagramEntry",
	service = ModelPreFilterContributor.class
)
public class CSDiagramEntryModelPreFilterContributor
	implements ModelPreFilterContributor {

	@Override
	public void contribute(
		BooleanFilter booleanFilter, ModelSearchSettings modelSearchSettings,
		SearchContext searchContext) {

		_filterByCPDefinitionId(booleanFilter, searchContext);
		_filterByCPDefinitionVisibility(booleanFilter, searchContext);
	}

	private void _filterByCPDefinitionId(
		BooleanFilter booleanFilter, SearchContext searchContext) {

		long cpDefinitionId = GetterUtil.getLong(
			searchContext.getAttribute(CPField.CP_DEFINITION_ID));

		if (cpDefinitionId > 0) {
			booleanFilter.addRequiredTerm(
				CPField.CP_DEFINITION_ID, cpDefinitionId);
		}
	}

	private void _filterByCPDefinitionVisibility(
		BooleanFilter booleanFilter, SearchContext searchContext) {

		if (GetterUtil.getBoolean(searchContext.getAttribute("secure"))) {
			long commerceChannelId = GetterUtil.getLong(
				searchContext.getAttribute("commerceChannelGroupId"));

			BooleanFilter commerceChannelBooleanFilter = new BooleanFilter();

			BooleanFilter commerceChannelFilterEnableBooleanFilter =
				new BooleanFilter();

			commerceChannelFilterEnableBooleanFilter.addTerm(
				CPField.CHANNEL_FILTER_ENABLED, Boolean.TRUE.toString(),
				BooleanClauseOccur.MUST);

			if (commerceChannelId > 0) {
				commerceChannelFilterEnableBooleanFilter.addTerm(
					CPField.COMMERCE_CHANNEL_GROUP_IDS,
					String.valueOf(commerceChannelId), BooleanClauseOccur.MUST);
			}
			else {
				commerceChannelFilterEnableBooleanFilter.addTerm(
					CPField.COMMERCE_CHANNEL_GROUP_IDS, "-1",
					BooleanClauseOccur.MUST);
			}

			commerceChannelBooleanFilter.add(
				commerceChannelFilterEnableBooleanFilter,
				BooleanClauseOccur.SHOULD);
			commerceChannelBooleanFilter.addTerm(
				CPField.CHANNEL_FILTER_ENABLED, Boolean.FALSE.toString(),
				BooleanClauseOccur.SHOULD);

			booleanFilter.add(
				commerceChannelBooleanFilter, BooleanClauseOccur.MUST);

			long[] commerceAccountGroupIds = GetterUtil.getLongValues(
				searchContext.getAttribute("commerceAccountGroupIds"), null);

			BooleanFilter commerceAccountGroupsBooleanFilter =
				new BooleanFilter();

			BooleanFilter commerceAccountGroupsFilterEnableBooleanFilter =
				new BooleanFilter();

			commerceAccountGroupsFilterEnableBooleanFilter.addTerm(
				CPField.ACCOUNT_GROUP_FILTER_ENABLED, Boolean.TRUE.toString(),
				BooleanClauseOccur.MUST);

			if ((commerceAccountGroupIds != null) &&
				(commerceAccountGroupIds.length > 0)) {

				BooleanFilter commerceAccountGroupIdsBooleanFilter =
					new BooleanFilter();

				for (long commerceAccountGroupId : commerceAccountGroupIds) {
					Filter termFilter = new TermFilter(
						"commerceAccountGroupIds",
						String.valueOf(commerceAccountGroupId));

					commerceAccountGroupIdsBooleanFilter.add(
						termFilter, BooleanClauseOccur.SHOULD);
				}

				commerceAccountGroupsFilterEnableBooleanFilter.add(
					commerceAccountGroupIdsBooleanFilter,
					BooleanClauseOccur.MUST);
			}
			else {
				commerceAccountGroupsFilterEnableBooleanFilter.addTerm(
					"commerceAccountGroupIds", "-1", BooleanClauseOccur.MUST);
			}

			commerceAccountGroupsBooleanFilter.add(
				commerceAccountGroupsFilterEnableBooleanFilter,
				BooleanClauseOccur.SHOULD);
			commerceAccountGroupsBooleanFilter.addTerm(
				CPField.ACCOUNT_GROUP_FILTER_ENABLED, Boolean.FALSE.toString(),
				BooleanClauseOccur.SHOULD);

			booleanFilter.add(
				commerceAccountGroupsBooleanFilter, BooleanClauseOccur.MUST);
		}
		else {
			long[] commerceCatalogIds = _getUserCommerceCatalogIds(
				searchContext);

			if (commerceCatalogIds.length > 0) {
				TermsFilter termsFilter = new TermsFilter("commerceCatalogId");

				termsFilter.addValues(
					ArrayUtil.toStringArray(commerceCatalogIds));

				booleanFilter.add(termsFilter, BooleanClauseOccur.MUST);
			}
			else {
				long[] groupIds = searchContext.getGroupIds();

				if ((groupIds == null) || (groupIds.length == 0)) {
					booleanFilter.addTerm(
						Field.GROUP_ID, "-1", BooleanClauseOccur.MUST);
				}
			}
		}
	}

	private long[] _getUserCommerceCatalogIds(SearchContext searchContext) {
		List<CommerceCatalog> commerceCatalogs =
			_commerceCatalogService.getCommerceCatalogs(
				searchContext.getCompanyId(), QueryUtil.ALL_POS,
				QueryUtil.ALL_POS);

		if (commerceCatalogs.isEmpty()) {
			return new long[0];
		}

		Stream<CommerceCatalog> stream = commerceCatalogs.stream();

		return stream.mapToLong(
			commerceCatalog -> commerceCatalog.getCommerceCatalogId()
		).toArray();
	}

	@Reference
	private CommerceCatalogService _commerceCatalogService;

}