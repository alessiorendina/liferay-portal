/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.commerce.product.service.test;

import com.liferay.arquillian.extension.junit.bridge.junit.Arquillian;
import com.liferay.commerce.product.model.CPDefinition;
import com.liferay.commerce.product.model.CProduct;
import com.liferay.commerce.product.model.CommerceCatalog;
import com.liferay.commerce.product.service.CPDefinitionLocalService;
import com.liferay.commerce.product.service.CProductLocalService;
import com.liferay.commerce.product.service.CommerceCatalogLocalServiceUtil;
import com.liferay.petra.lang.SafeCloseable;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.lazy.referencing.LazyReferencingThreadLocal;
import com.liferay.portal.kernel.model.Company;
import com.liferay.portal.kernel.service.CompanyLocalService;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.test.rule.AggregateTestRule;
import com.liferay.portal.kernel.test.util.RandomTestUtil;
import com.liferay.portal.kernel.test.util.ServiceContextTestUtil;
import com.liferay.portal.kernel.test.util.TestPropsValues;
import com.liferay.portal.kernel.util.HashMapBuilder;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.test.rule.Inject;
import com.liferay.portal.test.rule.LiferayIntegrationTestRule;
import com.liferay.portal.test.rule.PermissionCheckerMethodTestRule;

import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @author Alessio Antonio Rendina
 */
@RunWith(Arquillian.class)
public class CPDefinitionLazyReferenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(),
			PermissionCheckerMethodTestRule.INSTANCE);

	@Before
	public void setUp() throws Exception {
		Company company = _companyLocalService.getCompany(
			TestPropsValues.getCompanyId());

		_serviceContext = ServiceContextTestUtil.getServiceContext(
			company.getGroupId(), TestPropsValues.getUserId());

		ServiceContextThreadLocal.pushServiceContext(_serviceContext);

		_commerceCatalog = CommerceCatalogLocalServiceUtil.addCommerceCatalog(
			null, RandomTestUtil.randomString(), RandomTestUtil.randomString(),
			LocaleUtil.US.getDisplayLanguage(), _serviceContext);
	}

	@After
	public void tearDown() throws Exception {
		List<CPDefinition> cpDefinitions =
			_cpDefinitionLocalService.getCPDefinitions(
				_commerceCatalog.getGroupId(), WorkflowConstants.STATUS_ANY,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS);

		for (CPDefinition cpDefinition : cpDefinitions) {
			_cpDefinitionLocalService.deleteCPDefinition(cpDefinition);
		}
	}

	@Test
	public void testGetOrAddEmptyCPDefinitionCompletesStub() throws Exception {
		String externalReferenceCode = RandomTestUtil.randomString();

		CPDefinition stubCPDefinition = _getOrAddEmptyCPDefinition(
			externalReferenceCode, _PRODUCT_TYPE_NAME);

		long cpDefinitionId = stubCPDefinition.getCPDefinitionId();

		Date displayDate = stubCPDefinition.getDisplayDate();

		CPDefinition completedCPDefinition =
			_cpDefinitionLocalService.updateCPDefinition(
				cpDefinitionId, stubCPDefinition.getCPTaxCategoryId(), false,
				false, null, 0, Collections.emptyMap(), displayDate.getDate(),
				displayDate.getHours(), displayDate.getMinutes(),
				displayDate.getMonth(), displayDate.getYear(), 0, 0, 0, 0, 0,
				true, 0, false, Collections.emptyMap(), Collections.emptyMap(),
				Collections.emptyMap(),
				HashMapBuilder.put(
					LocaleUtil.US, RandomTestUtil.randomString()
				).build(),
				true, true, false, false, 0, Collections.emptyMap(), false,
				false, Collections.emptyMap(), 0, 0,
				ServiceContextTestUtil.getServiceContext(
					_commerceCatalog.getGroupId()));

		Assert.assertEquals(
			cpDefinitionId, completedCPDefinition.getCPDefinitionId());
		Assert.assertNotEquals(
			WorkflowConstants.STATUS_EMPTY, completedCPDefinition.getStatus());
		Assert.assertEquals(1, completedCPDefinition.getVersion());
	}

	@Test
	public void testGetOrAddEmptyCPDefinitionCreatesStubInImport()
		throws Exception {

		String externalReferenceCode = RandomTestUtil.randomString();

		CPDefinition cpDefinition = _getOrAddEmptyCPDefinition(
			externalReferenceCode, _PRODUCT_TYPE_NAME);

		Assert.assertEquals(
			WorkflowConstants.STATUS_EMPTY, cpDefinition.getStatus());
		Assert.assertEquals(
			externalReferenceCode,
			cpDefinition.getCProductExternalReferenceCode());
		Assert.assertEquals(
			_PRODUCT_TYPE_NAME, cpDefinition.getProductTypeName());
		Assert.assertEquals(1, cpDefinition.getVersion());
		Assert.assertFalse(cpDefinition.isPublished());

		CProduct cProduct = _cProductLocalService.getCProduct(
			cpDefinition.getCProductId());

		Assert.assertEquals(
			externalReferenceCode, cProduct.getExternalReferenceCode());
		Assert.assertEquals(
			cpDefinition.getCPDefinitionId(),
			cProduct.getPublishedCPDefinitionId());
	}

	@Test
	public void testGetOrAddEmptyCPDefinitionIsIdempotent() throws Exception {
		String externalReferenceCode = RandomTestUtil.randomString();

		CPDefinition cpDefinition1 = _getOrAddEmptyCPDefinition(
			externalReferenceCode, _PRODUCT_TYPE_NAME);
		CPDefinition cpDefinition2 = _getOrAddEmptyCPDefinition(
			externalReferenceCode, _PRODUCT_TYPE_NAME);

		Assert.assertEquals(
			cpDefinition1.getCPDefinitionId(),
			cpDefinition2.getCPDefinitionId());
	}

	@Test
	public void testGetOrAddEmptyCPDefinitionOutsideImportDoesNotCreateStub()
		throws Exception {

		String externalReferenceCode = RandomTestUtil.randomString();

		CPDefinition cpDefinition =
			_cpDefinitionLocalService.getOrAddEmptyCPDefinition(
				externalReferenceCode, _PRODUCT_TYPE_NAME,
				TestPropsValues.getCompanyId(), TestPropsValues.getUserId(),
				_commerceCatalog.getGroupId());

		Assert.assertNull(cpDefinition);

		Assert.assertNull(
			_cProductLocalService.fetchCProductByExternalReferenceCode(
				externalReferenceCode, TestPropsValues.getCompanyId()));
	}

	private CPDefinition _getOrAddEmptyCPDefinition(
			String externalReferenceCode, String productTypeName)
		throws Exception {

		try (SafeCloseable safeCloseable =
				LazyReferencingThreadLocal.setEnabledWithSafeCloseable(true)) {

			return _cpDefinitionLocalService.getOrAddEmptyCPDefinition(
				externalReferenceCode, productTypeName,
				TestPropsValues.getCompanyId(), TestPropsValues.getUserId(),
				_commerceCatalog.getGroupId());
		}
	}

	private static final String _PRODUCT_TYPE_NAME = "simple";

	private CommerceCatalog _commerceCatalog;

	@Inject
	private CompanyLocalService _companyLocalService;

	@Inject
	private CPDefinitionLocalService _cpDefinitionLocalService;

	@Inject
	private CProductLocalService _cProductLocalService;

	private ServiceContext _serviceContext;

}