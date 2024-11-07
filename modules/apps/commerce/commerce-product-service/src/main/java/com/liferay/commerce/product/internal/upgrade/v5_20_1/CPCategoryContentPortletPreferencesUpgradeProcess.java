/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.commerce.product.internal.upgrade.v5_20_1;

import com.liferay.asset.kernel.model.AssetCategory;
import com.liferay.asset.kernel.service.AssetCategoryLocalService;
import com.liferay.commerce.product.constants.CPPortletKeys;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.dao.jdbc.AutoBatchPreparedStatementUtil;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.service.GroupLocalService;
import com.liferay.portal.kernel.upgrade.UpgradeProcess;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * @author Alessio Antonio Rendina
 */
public class CPCategoryContentPortletPreferencesUpgradeProcess
	extends UpgradeProcess {

	public CPCategoryContentPortletPreferencesUpgradeProcess(
		AssetCategoryLocalService assetCategoryLocalService,
		GroupLocalService groupLocalService) {

		_assetCategoryLocalService = assetCategoryLocalService;
		_groupLocalService = groupLocalService;
	}

	@Override
	protected void doUpgrade() throws Exception {
		try (PreparedStatement selectPreparedStatement =
				connection.prepareStatement(
					StringBundler.concat(
						"select PortletPreferenceValue.name, ",
						"PortletPreferenceValue.smallValue from ",
						"PortletPreferenceValue inner join PortletPreferences ",
						"on PortletPreferenceValue.portletPreferencesId = ",
						"PortletPreferences.portletPreferencesId where ",
						"PortletPreferences.portletId = '",
						CPPortletKeys.CP_CATEGORY_CONTENT_WEB,
						"' and (PortletPreferenceValue.name = ",
						"'displayStyleGroupId' or PortletPreferenceValue.name ",
						"= 'assetCategoryId')"));
			PreparedStatement updatePreparedStatement =
				AutoBatchPreparedStatementUtil.concurrentAutoBatch(
					connection,
					"update PortletPreferenceValue set name = ?, smallValue " +
						"= ? where name = ? and smallValue = ?")) {

			try (ResultSet resultSet = selectPreparedStatement.executeQuery()) {
				while (resultSet.next()) {
					String name = resultSet.getString(1);
					String smallValue = resultSet.getString(2);

					if (name.equals("assetCategoryId")) {
						updatePreparedStatement.setString(
							1, "assetCategoryExternalReferenceCode");

						AssetCategory assetCategory =
							_assetCategoryLocalService.fetchAssetCategory(
								Long.valueOf(smallValue));

						if (assetCategory == null) {
							updatePreparedStatement.setString(2, null);
						}
						else {
							updatePreparedStatement.setString(
								2, assetCategory.getExternalReferenceCode());
						}
					}
					else if (name.equals("displayStyleGroupId")) {
						updatePreparedStatement.setString(
							1, "displayStyleGroupExternalReferenceCode");

						Group group = _groupLocalService.fetchGroup(
							Long.valueOf(smallValue));

						if (group == null) {
							updatePreparedStatement.setString(2, null);
						}
						else {
							updatePreparedStatement.setString(
								2, group.getExternalReferenceCode());
						}
					}

					updatePreparedStatement.setString(3, name);
					updatePreparedStatement.setString(4, smallValue);

					updatePreparedStatement.addBatch();
				}
			}

			updatePreparedStatement.executeBatch();
		}
	}

	private final AssetCategoryLocalService _assetCategoryLocalService;
	private final GroupLocalService _groupLocalService;

}