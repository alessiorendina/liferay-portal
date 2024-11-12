/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.portal.kernel.upgrade;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.LoggingTimer;
import com.liferay.portal.kernel.util.StringBundler;

/**
 * @author Alessio Antonio Rendina
 */
public abstract class BaseBatchImportStatusUpgradeProcess
	extends UpgradeProcess {

	@Override
	protected void doUpgrade() throws Exception {
		for (String tableName : getTableNames()) {
			upgradeBatchImportStatus(tableName);
		}
	}

	protected abstract String[] getTableNames();

	protected void upgradeBatchImportStatus(String tableName) throws Exception {
		if (!hasTable(tableName)) {
			_log.error("Skip nonexistent table " + tableName);

			return;
		}

		if (_log.isInfoEnabled()) {
			_log.info("Upgrade table " + tableName);
		}

		if (!hasColumn(tableName, "batchImportStatus")) {
			alterTableAddColumn(tableName, "batchImportStatus", "INTEGER");
		}

		try (LoggingTimer loggingTimer = new LoggingTimer()) {
			StringBundler updateSB = new StringBundler(4);

			updateSB.append("update ");
			updateSB.append(tableName);
			updateSB.append(" set batchImportStatus = 0 where ");
			updateSB.append("batchImportStatus is null");

			runSQL(updateSB.toString());
		}
	}

	private static final Log _log = LogFactoryUtil.getLog(
		BaseBatchImportStatusUpgradeProcess.class);

}