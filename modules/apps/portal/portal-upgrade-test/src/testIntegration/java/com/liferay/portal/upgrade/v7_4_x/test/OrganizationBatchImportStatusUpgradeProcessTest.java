/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.portal.upgrade.v7_4_x.test;

import com.liferay.arquillian.extension.junit.bridge.junit.Arquillian;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.BatchImportStatusModel;
import com.liferay.portal.kernel.model.ListTypeConstants;
import com.liferay.portal.kernel.model.Organization;
import com.liferay.portal.kernel.model.OrganizationConstants;
import com.liferay.portal.kernel.service.ListTypeLocalService;
import com.liferay.portal.kernel.service.OrganizationLocalService;
import com.liferay.portal.kernel.test.randomizerbumpers.UniqueStringRandomizerBumper;
import com.liferay.portal.kernel.test.util.RandomTestUtil;
import com.liferay.portal.kernel.test.util.TestPropsValues;
import com.liferay.portal.kernel.upgrade.BaseBatchImportStatusUpgradeProcess;
import com.liferay.portal.kernel.version.Version;
import com.liferay.portal.test.rule.Inject;
import com.liferay.portal.upgrade.registry.UpgradeStepRegistrator;
import com.liferay.portal.upgrade.test.util.BaseBatchImportStatusUpgradeProcessTestCase;

import org.junit.runner.RunWith;

/**
 * @author Alessio Antonio Rendina
 */
@RunWith(Arquillian.class)
public class OrganizationBatchImportStatusUpgradeProcessTest
	extends BaseBatchImportStatusUpgradeProcessTestCase {

	@Override
	protected BatchImportStatusModel[] addBatchImportStatusModels(
			String tableName)
		throws PortalException {

		try {
			Organization organization =
				_organizationLocalService.addOrganization(
					RandomTestUtil.randomString(
						UniqueStringRandomizerBumper.INSTANCE),
					TestPropsValues.getUserId(),
					OrganizationConstants.DEFAULT_PARENT_ORGANIZATION_ID,
					RandomTestUtil.randomString(),
					OrganizationConstants.TYPE_ORGANIZATION, 0, 0,
					_listTypeLocalService.getListTypeId(
						serviceContext.getCompanyId(),
						ListTypeConstants.ORGANIZATION_STATUS_DEFAULT,
						ListTypeConstants.ORGANIZATION_STATUS),
					null, false, serviceContext);

			return new BatchImportStatusModel[] {organization};
		}
		catch (Exception exception) {
			throw new PortalException(exception);
		}
	}

	@Override
	protected BatchImportStatusModel fetchBatchImportStatusModel(
			BatchImportStatusModel batchImportStatusModel, String tableName)
		throws PortalException {

		Organization organization = (Organization)batchImportStatusModel;

		return _organizationLocalService.fetchOrganization(
			organization.getOrganizationId());
	}

	@Override
	protected String[] getTableNames() {
		return new String[] {"Organization_"};
	}

	@Override
	protected BaseBatchImportStatusUpgradeProcess getUpgradeProcess() {
		return new BaseBatchImportStatusUpgradeProcess() {

			@Override
			protected String[] getTableNames() {
				return new String[] {"Organization_"};
			}

		};
	}

	@Override
	protected UpgradeStepRegistrator getUpgradeStepRegistrator() {
		return null;
	}

	@Override
	protected Version getVersion() {
		return null;
	}

	@Inject
	private ListTypeLocalService _listTypeLocalService;

	@Inject
	private OrganizationLocalService _organizationLocalService;

}