/**
 * SPDX-FileCopyrightText: (c) 2000 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.headless.commerce.admin.pricing.internal.util.v2_0;

import com.liferay.asset.kernel.exception.NoSuchCategoryException;
import com.liferay.asset.kernel.model.AssetCategory;
import com.liferay.asset.kernel.service.AssetCategoryLocalService;
import com.liferay.asset.kernel.service.AssetCategoryService;
import com.liferay.commerce.discount.model.CommerceDiscount;
import com.liferay.commerce.discount.model.CommerceDiscountRel;
import com.liferay.commerce.discount.service.CommerceDiscountRelService;
import com.liferay.headless.commerce.admin.pricing.dto.v2_0.DiscountCategory;
import com.liferay.headless.commerce.core.helper.ServiceContextHelper;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.lazy.referencing.LazyReferencingThreadLocal;
import com.liferay.portal.kernel.util.Validator;

/**
 * @author Riccardo Alberti
 */
public class DiscountCategoryUtil {

	public static CommerceDiscountRel addCommerceDiscountRel(
			long groupId, AssetCategoryLocalService assetCategoryLocalService,
			AssetCategoryService assetCategoryService,
			CommerceDiscountRelService commerceDiscountRelService,
			DiscountCategory discountCategory,
			CommerceDiscount commerceDiscount,
			ServiceContextHelper serviceContextHelper)
		throws PortalException {

		AssetCategory assetCategory;

		if (Validator.isNull(
				discountCategory.getCategoryExternalReferenceCode())) {

			assetCategory = assetCategoryLocalService.getCategory(
				discountCategory.getCategoryId());
		}
		else {
			assetCategory =
				assetCategoryLocalService.
					fetchAssetCategoryByExternalReferenceCode(
						discountCategory.getCategoryExternalReferenceCode(),
						groupId);

			if (assetCategory == null) {
				String categoryExternalReferenceCode =
					discountCategory.getCategoryExternalReferenceCode();

				if (!LazyReferencingThreadLocal.isEnabled()) {
					throw new NoSuchCategoryException(
						"Unable to find category with external reference " +
							"code " + categoryExternalReferenceCode);
				}

				assetCategory = assetCategoryService.getOrAddEmptyCategory(
					categoryExternalReferenceCode, groupId);
			}
		}

		return commerceDiscountRelService.addCommerceDiscountRel(
			commerceDiscount.getCommerceDiscountId(),
			AssetCategory.class.getName(), assetCategory.getCategoryId(), null,
			serviceContextHelper.getServiceContext());
	}

}