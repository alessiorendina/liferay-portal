/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.commerce.product.service.test;

import com.liferay.arquillian.extension.junit.bridge.junit.Arquillian;
import com.liferay.commerce.product.exception.NoSuchCPDefinitionOptionRelException;
import com.liferay.commerce.product.model.CPDefinitionOptionRel;
import com.liferay.commerce.product.service.CPDefinitionOptionRelLocalService;
import com.liferay.petra.lang.SafeCloseable;
import com.liferay.portal.kernel.lazy.referencing.LazyReferencingThreadLocal;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.test.rule.AggregateTestRule;
import com.liferay.portal.kernel.test.rule.DeleteAfterTestRun;
import com.liferay.portal.kernel.test.util.GroupTestUtil;
import com.liferay.portal.kernel.test.util.RandomTestUtil;
import com.liferay.portal.kernel.test.util.ServiceContextTestUtil;
import com.liferay.portal.kernel.test.util.UserTestUtil;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.test.rule.Inject;
import com.liferay.portal.test.rule.LiferayIntegrationTestRule;
import com.liferay.portal.test.rule.PermissionCheckerMethodTestRule;

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
public class CPDefinitionOptionRelLazyReferenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(),
			PermissionCheckerMethodTestRule.INSTANCE);

	@Before
	public void setUp() throws Exception {
		_group = GroupTestUtil.addGroup();

		_user = UserTestUtil.addUser();

		_serviceContext = ServiceContextTestUtil.getServiceContext(
			_group.getGroupId(), _user.getUserId());

		ServiceContextThreadLocal.pushServiceContext(_serviceContext);
	}

	@After
	public void tearDown() throws Exception {
		ServiceContextThreadLocal.popServiceContext();
	}

	@Test
	public void testGetOrAddEmptyCPDefinitionOptionRelCreatesStubInImport()
		throws Exception {

		String externalReferenceCode = RandomTestUtil.randomString();

		CPDefinitionOptionRel cpDefinitionOptionRel =
			_getOrAddEmptyCPDefinitionOptionRel(externalReferenceCode);

		Assert.assertEquals(
			externalReferenceCode,
			cpDefinitionOptionRel.getExternalReferenceCode());
		Assert.assertEquals(
			WorkflowConstants.STATUS_EMPTY, cpDefinitionOptionRel.getStatus());
	}

	@Test
	public void testGetOrAddEmptyCPDefinitionOptionRelIsIdempotent()
		throws Exception {

		String externalReferenceCode = RandomTestUtil.randomString();

		CPDefinitionOptionRel cpDefinitionOptionRel1 =
			_getOrAddEmptyCPDefinitionOptionRel(externalReferenceCode);
		CPDefinitionOptionRel cpDefinitionOptionRel2 =
			_getOrAddEmptyCPDefinitionOptionRel(externalReferenceCode);

		Assert.assertEquals(
			cpDefinitionOptionRel1.getCPDefinitionOptionRelId(),
			cpDefinitionOptionRel2.getCPDefinitionOptionRelId());
	}

	@Test(expected = NoSuchCPDefinitionOptionRelException.class)
	public void testGetOrAddEmptyCPDefinitionOptionRelOutsideImportThrows()
		throws Exception {

		_cpDefinitionOptionRelLocalService.getOrAddEmptyCPDefinitionOptionRel(
			RandomTestUtil.randomString(), _group.getCompanyId(),
			_user.getUserId(), _group.getGroupId());
	}

	private CPDefinitionOptionRel _getOrAddEmptyCPDefinitionOptionRel(
			String externalReferenceCode)
		throws Exception {

		try (SafeCloseable safeCloseable =
				LazyReferencingThreadLocal.setEnabledWithSafeCloseable(true)) {

			return _cpDefinitionOptionRelLocalService.
				getOrAddEmptyCPDefinitionOptionRel(
					externalReferenceCode, _group.getCompanyId(),
					_user.getUserId(), _group.getGroupId());
		}
	}

	@Inject
	private CPDefinitionOptionRelLocalService
		_cpDefinitionOptionRelLocalService;

	@DeleteAfterTestRun
	private Group _group;

	private ServiceContext _serviceContext;

	@DeleteAfterTestRun
	private User _user;

}