/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.portal.upgrade.test.util;

import com.liferay.petra.function.transform.TransformUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.cache.MultiVMPool;
import com.liferay.portal.kernel.dao.db.DB;
import com.liferay.portal.kernel.dao.db.DBInspector;
import com.liferay.portal.kernel.dao.db.DBManagerUtil;
import com.liferay.portal.kernel.dao.db.IndexMetadata;
import com.liferay.portal.kernel.dao.jdbc.DataAccess;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.BatchImportStatusModel;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.test.rule.AggregateTestRule;
import com.liferay.portal.kernel.test.rule.DeleteAfterTestRun;
import com.liferay.portal.kernel.test.util.GroupTestUtil;
import com.liferay.portal.kernel.test.util.ServiceContextTestUtil;
import com.liferay.portal.kernel.upgrade.UpgradeProcess;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.InfrastructureUtil;
import com.liferay.portal.kernel.util.ListUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.version.Version;
import com.liferay.portal.test.rule.Inject;
import com.liferay.portal.test.rule.LiferayIntegrationTestRule;
import com.liferay.portal.test.rule.PermissionCheckerMethodTestRule;
import com.liferay.portal.upgrade.registry.UpgradeStepRegistrator;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.util.List;

import javax.sql.DataSource;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;

/**
 * @author Alessio Antonio Rendina
 */
public abstract class BaseBatchImportStatusUpgradeProcessTestCase {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(),
			PermissionCheckerMethodTestRule.INSTANCE);

	@BeforeClass
	public static void setUpClass() throws Exception {
		dataSource = InfrastructureUtil.getDataSource();
		db = DBManagerUtil.getDB();
	}

	@Before
	public void setUp() throws Exception {
		group = GroupTestUtil.addGroup();

		serviceContext = ServiceContextTestUtil.getServiceContext(
			group.getGroupId());

		ServiceContextThreadLocal.pushServiceContext(serviceContext);
	}

	@After
	public void tearDown() {
		ServiceContextThreadLocal.popServiceContext();
	}

	@Test
	public void testUpgradeProcess() throws Exception {
		for (String tableName : getTableNames()) {
			BatchImportStatusModel[] batchImportStatusModels =
				addBatchImportStatusModels(tableName);

			List<IndexMetadata> indexMetadatas = _dropIndexes(tableName);

			try {
				_prepareDatabaseForUpgradeProcess(
					batchImportStatusModels, _hasColumn(tableName, "groupId"),
					tableName);

				_runUpgrade();

				_assertDatabaseAfterUpgradeProcess(
					batchImportStatusModels, tableName);
			}
			finally {
				_addIndexes(indexMetadatas);
			}
		}
	}

	protected abstract BatchImportStatusModel[] addBatchImportStatusModels(
			String tableName)
		throws PortalException;

	protected void assertBatchImportStatus(
			Integer[] batchImportStatuses, boolean hasGroupIdColumn,
			String tableName)
		throws Exception {

		String sql = StringBundler.concat(
			"select 1 from ", tableName, " where batchImportStatus in ('",
			ArrayUtil.toString(batchImportStatuses, StringPool.BLANK, "', '"),
			"')");

		if (hasGroupIdColumn) {
			sql = sql + " AND groupId = ?";
		}

		try (Connection connection = dataSource.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(
				sql)) {

			if (hasGroupIdColumn) {
				preparedStatement.setLong(1, group.getGroupId());
			}

			try (ResultSet resultSet = preparedStatement.executeQuery()) {
				Assert.assertFalse(resultSet.next());
			}
		}
	}

	protected abstract BatchImportStatusModel fetchBatchImportStatusModel(
			BatchImportStatusModel batchImportStatusModel, String tableName)
		throws PortalException;

	protected int getBatchImportStatus(
		BatchImportStatusModel batchImportStatusModel, String tableName) {

		return batchImportStatusModel.getBatchImportStatus();
	}

	protected abstract String[] getTableNames();

	protected UpgradeProcess getUpgradeProcess() {
		UpgradeProcess[] upgradeProcesses = UpgradeTestUtil.getUpgradeSteps(
			getUpgradeStepRegistrator(), getVersion());

		return upgradeProcesses[0];
	}

	protected abstract UpgradeStepRegistrator getUpgradeStepRegistrator();

	protected abstract Version getVersion();

	protected void updateBatchImportStatus(
			Integer[] batchImportStatuses, boolean hasGroupIdColumn,
			String tableName)
		throws Exception {

		String sql = StringBundler.concat(
			"update ", tableName, " set batchImportStatus = null where ",
			"batchImportStatus in ('",
			ArrayUtil.toString(batchImportStatuses, StringPool.BLANK, "', '"),
			"')");

		if (hasGroupIdColumn) {
			sql = StringBundler.concat(
				sql, " and groupId = ", group.getGroupId());
		}

		db.runSQL(sql);

		entityCache.clearCache();
		multiVMPool.clear();
	}

	protected static DataSource dataSource;
	protected static DB db;

	@Inject
	protected EntityCache entityCache;

	@DeleteAfterTestRun
	protected Group group;

	@Inject
	protected MultiVMPool multiVMPool;

	protected ServiceContext serviceContext;

	private void _addIndexes(List<IndexMetadata> indexMetadatas)
		throws Exception {

		try (Connection connection = dataSource.getConnection()) {
			if (ListUtil.isNotEmpty(indexMetadatas)) {
				db.addIndexes(connection, indexMetadatas);
			}
		}
	}

	private void _assertDatabaseAfterUpgradeProcess(
			BatchImportStatusModel[] batchImportStatusModels, String tableName)
		throws Exception {

		for (BatchImportStatusModel batchImportStatusModel :
				batchImportStatusModels) {

			BatchImportStatusModel updatedBatchImportStatusModel =
				fetchBatchImportStatusModel(batchImportStatusModel, tableName);

			Assert.assertTrue(
				Validator.isNotNull(
					updatedBatchImportStatusModel.getBatchImportStatus()));
			Assert.assertEquals(
				getBatchImportStatus(updatedBatchImportStatusModel, tableName),
				updatedBatchImportStatusModel.getBatchImportStatus());
		}
	}

	private List<IndexMetadata> _dropIndexes(String tableName)
		throws Exception {

		try (Connection connection = dataSource.getConnection()) {
			return db.dropIndexes(connection, tableName, "batchImportStatus");
		}
	}

	private boolean _hasColumn(String tableName, String columnName)
		throws Exception {

		try (Connection connection = DataAccess.getConnection()) {
			DBInspector dbInspector = new DBInspector(connection);

			return dbInspector.hasColumn(tableName, columnName);
		}
	}

	private void _prepareDatabaseForUpgradeProcess(
			BatchImportStatusModel[] batchImportStatusModels,
			boolean hasGroupIdColumn, String tableName)
		throws Exception {

		Integer[] batchImportStatuses = TransformUtil.transform(
			batchImportStatusModels,
			BatchImportStatusModel::getBatchImportStatus, Integer.class);

		updateBatchImportStatus(
			batchImportStatuses, hasGroupIdColumn, tableName);

		assertBatchImportStatus(
			batchImportStatuses, hasGroupIdColumn, tableName);
	}

	private void _runUpgrade() throws Exception {
		UpgradeProcess upgradeProcess = getUpgradeProcess();

		upgradeProcess.upgrade();

		entityCache.clearCache();
		multiVMPool.clear();
	}

}