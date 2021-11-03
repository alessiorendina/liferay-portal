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

package com.liferay.commerce.order.importer.type.test;

import com.liferay.arquillian.extension.junit.bridge.junit.Arquillian;
import com.liferay.commerce.account.model.CommerceAccount;
import com.liferay.commerce.account.test.util.CommerceAccountTestUtil;
import com.liferay.commerce.context.CommerceContext;
import com.liferay.commerce.currency.model.CommerceCurrency;
import com.liferay.commerce.currency.test.util.CommerceCurrencyTestUtil;
import com.liferay.commerce.model.CommerceOrder;
import com.liferay.commerce.order.importer.item.CommerceOrderImporterItem;
import com.liferay.commerce.order.importer.type.CommerceOrderImporterType;
import com.liferay.commerce.order.importer.type.CommerceOrderImporterTypeRegistry;
import com.liferay.commerce.product.constants.CPInstanceConstants;
import com.liferay.commerce.product.constants.CommerceChannelConstants;
import com.liferay.commerce.product.model.CommerceCatalog;
import com.liferay.commerce.product.model.CommerceChannel;
import com.liferay.commerce.product.service.CommerceCatalogLocalService;
import com.liferay.commerce.product.service.CommerceChannelLocalServiceUtil;
import com.liferay.commerce.product.test.util.CPTestUtil;
import com.liferay.commerce.service.CommerceOrderLocalService;
import com.liferay.commerce.test.util.CommerceTestUtil;
import com.liferay.commerce.test.util.context.TestCommerceContext;
import com.liferay.document.library.kernel.model.DLFolderConstants;
import com.liferay.document.library.kernel.service.DLAppLocalServiceUtil;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.Company;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.security.auth.PrincipalThreadLocal;
import com.liferay.portal.kernel.security.permission.PermissionCheckerFactoryUtil;
import com.liferay.portal.kernel.security.permission.PermissionThreadLocal;
import com.liferay.portal.kernel.service.CompanyLocalServiceUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.test.rule.AggregateTestRule;
import com.liferay.portal.kernel.test.rule.DeleteAfterTestRun;
import com.liferay.portal.kernel.test.rule.Sync;
import com.liferay.portal.kernel.test.util.CompanyTestUtil;
import com.liferay.portal.kernel.test.util.GroupTestUtil;
import com.liferay.portal.kernel.test.util.RandomTestUtil;
import com.liferay.portal.kernel.test.util.ServiceContextTestUtil;
import com.liferay.portal.kernel.test.util.UserTestUtil;
import com.liferay.portal.kernel.util.FileUtil;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.MimeTypesUtil;
import com.liferay.portal.test.rule.Inject;
import com.liferay.portal.test.rule.LiferayIntegrationTestRule;
import com.liferay.portal.test.rule.PermissionCheckerMethodTestRule;

import java.io.File;
import java.io.InputStream;

import java.math.BigDecimal;

import java.util.List;
import java.util.stream.Stream;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.util.Assert;

/**
 * @author Andrea Sbarra
 */
@RunWith(Arquillian.class)
@Sync
public class CommerceOrderImporterTypeTest {

	@ClassRule
	@Rule
	public static AggregateTestRule aggregateTestRule = new AggregateTestRule(
		new LiferayIntegrationTestRule(),
		PermissionCheckerMethodTestRule.INSTANCE);

	@BeforeClass
	public static void setUpClass() throws Exception {
		_company = CompanyTestUtil.addCompany();
	}

	@AfterClass
	public static void tearDownClass() throws Exception {
		CompanyLocalServiceUtil.deleteCompany(_company);
	}

	@Before
	public void setUp() throws Exception {
		_group = GroupTestUtil.addGroup();

		_user = UserTestUtil.addUser();

		PrincipalThreadLocal.setName(_user.getUserId());

		PermissionThreadLocal.setPermissionChecker(
			PermissionCheckerFactoryUtil.create(_user));

		_commerceCurrency = CommerceCurrencyTestUtil.addCommerceCurrency(
			_company.getCompanyId());

		_serviceContext = ServiceContextTestUtil.getServiceContext(
			_group.getGroupId());

		_commerceChannel = CommerceChannelLocalServiceUtil.addCommerceChannel(
			null, _group.getGroupId(), "Test Channel",
			CommerceChannelConstants.CHANNEL_TYPE_SITE, null,
			_commerceCurrency.getCode(), _serviceContext);

		_commerceAccount = CommerceAccountTestUtil.addBusinessCommerceAccount(
			_user.getUserId(), RandomTestUtil.randomString(),
			RandomTestUtil.randomString() + "@liferay.com",
			RandomTestUtil.randomString(), new long[] {_user.getUserId()}, null,
			_serviceContext);

		_commerceOrder = CommerceTestUtil.addB2BCommerceOrder(
			_group.getGroupId(), _user.getUserId(),
			_commerceAccount.getCommerceAccountId(),
			_commerceCurrency.getCommerceCurrencyId());

		_commerceContext = new TestCommerceContext(
			_commerceCurrency, _commerceChannel, _user, _group,
			_commerceOrder.getCommerceAccount(), _commerceOrder);
	}

	@After
	public void tearDown() throws PortalException {
		_commerceOrderLocalService.deleteCommerceOrder(_commerceOrder);
	}

	@Test
	public void testFailCsvImport() throws Exception {
		CommerceCatalog catalog =
			_commerceCatalogLocalService.addCommerceCatalog(
				null, RandomTestUtil.randomString(),
				_commerceCurrency.getCode(), LocaleUtil.US.getDisplayLanguage(),
				_serviceContext);

		CPTestUtil.addCPInstanceFromCatalogWithERC(
			catalog.getGroupId(), "erc-test", new BigDecimal(100),
			CPInstanceConstants.DEFAULT_SKU);

		CommerceOrderImporterType commerceOrderImporterType =
			_commerceOrderImporterTypeRegistry.getCommerceOrderImporterType(
				"csv");

		String fileName = "testFailCsvImport.csv";

		InputStream inputStream =
			CommerceOrderImporterTypeTest.class.getResourceAsStream(
				"dependencies/" + fileName);

		File file = null;

		String mimeType = MimeTypesUtil.getContentType(file, fileName);

		file = FileUtil.createTempFile(inputStream);

		List<CommerceOrderImporterItem> commerceOrderImporterItems =
			commerceOrderImporterType.getCommerceOrderImporterItems(
				_commerceOrderLocalService.addCommerceOrder(
					_user.getUserId(), _commerceChannel.getGroupId(),
					_commerceAccount.getCommerceAccountId(),
					_commerceCurrency.getCommerceCurrencyId(), 0),
				DLAppLocalServiceUtil.addFileEntry(
					null, _serviceContext.getUserId(),
					_serviceContext.getScopeGroupId(),
					DLFolderConstants.DEFAULT_PARENT_FOLDER_ID, fileName,
					mimeType, fileName, StringPool.BLANK, StringPool.BLANK,
					file, null, null, _serviceContext));

		Stream<CommerceOrderImporterItem> commerceOrderImporterItemsStream =
			commerceOrderImporterItems.stream();

		commerceOrderImporterItemsStream.map(
			CommerceOrderImporterItem::getErrorMessages
		).forEach(
			errorMessages -> Assert.notEmpty(
				errorMessages,
				"Import should fail because of not found product instance")
		);
	}

	@Test
	public void testSuccesfullCsvImport() throws Exception {
		CommerceCatalog catalog =
			_commerceCatalogLocalService.addCommerceCatalog(
				null, RandomTestUtil.randomString(),
				_commerceCurrency.getCode(), LocaleUtil.US.getDisplayLanguage(),
				_serviceContext);

		CPTestUtil.addCPInstanceFromCatalogWithERC(
			catalog.getGroupId(), "erc-test", new BigDecimal(100),
			CPInstanceConstants.DEFAULT_SKU);

		CommerceOrderImporterType commerceOrderImporterType =
			_commerceOrderImporterTypeRegistry.getCommerceOrderImporterType(
				"csv");

		String fileName = "testSuccesfullCsvImport.csv";

		InputStream inputStream =
			CommerceOrderImporterTypeTest.class.getResourceAsStream(
				"dependencies/" + fileName);

		File file = null;

		String mimeType = MimeTypesUtil.getContentType(file, fileName);

		file = FileUtil.createTempFile(inputStream);

		List<CommerceOrderImporterItem> commerceOrderImporterItems =
			commerceOrderImporterType.getCommerceOrderImporterItems(
				_commerceOrderLocalService.addCommerceOrder(
					_user.getUserId(), _commerceChannel.getGroupId(),
					_commerceAccount.getCommerceAccountId(),
					_commerceCurrency.getCommerceCurrencyId(), 0),
				DLAppLocalServiceUtil.addFileEntry(
					null, _serviceContext.getUserId(),
					_serviceContext.getScopeGroupId(),
					DLFolderConstants.DEFAULT_PARENT_FOLDER_ID, fileName,
					mimeType, fileName, StringPool.BLANK, StringPool.BLANK,
					file, null, null, _serviceContext));

		Assert.notEmpty(
			commerceOrderImporterItems, "Import should import one item");
	}

	@Inject
	private static CommerceOrderImporterTypeRegistry
		_commerceOrderImporterTypeRegistry;

	private static Company _company;
	private static User _user;

	private CommerceAccount _commerceAccount;

	@Inject
	private CommerceCatalogLocalService _commerceCatalogLocalService;

	@DeleteAfterTestRun
	private CommerceChannel _commerceChannel;

	private CommerceContext _commerceContext;

	@DeleteAfterTestRun
	private CommerceCurrency _commerceCurrency;

	private CommerceOrder _commerceOrder;

	@Inject
	private CommerceOrderLocalService _commerceOrderLocalService;

	private Group _group;
	private ServiceContext _serviceContext;

}