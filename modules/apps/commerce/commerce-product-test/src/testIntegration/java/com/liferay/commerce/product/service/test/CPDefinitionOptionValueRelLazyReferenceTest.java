/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.commerce.product.service.test;

import com.liferay.arquillian.extension.junit.bridge.junit.Arquillian;
import com.liferay.commerce.product.exception.NoSuchCPDefinitionOptionValueRelException;
import com.liferay.commerce.product.model.CPDefinitionOptionValueRel;
import com.liferay.commerce.product.service.CPDefinitionOptionValueRelLocalService;
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
public class CPDefinitionOptionValueRelLazyReferenceTest {

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
	public void testGetOrAddEmptyCPDefinitionOptionValueRelCreatesStubInImport()
		throws Exception {

		String externalReferenceCode = RandomTestUtil.randomString();

		CPDefinitionOptionValueRel cpDefinitionOptionValueRel =
			_getOrAddEmptyCPDefinitionOptionValueRel(externalReferenceCode);

		Assert.assertEquals(
			externalReferenceCode,
			cpDefinitionOptionValueRel.getExternalReferenceCode());
		Assert.assertEquals(
			WorkflowConstants.STATUS_EMPTY,
			cpDefinitionOptionValueRel.getStatus());
	}

	@Test
	public void testGetOrAddEmptyCPDefinitionOptionValueRelIsIdempotent()
		throws Exception {

		String externalReferenceCode = RandomTestUtil.randomString();

		CPDefinitionOptionValueRel cpDefinitionOptionValueRel1 =
			_getOrAddEmptyCPDefinitionOptionValueRel(externalReferenceCode);
		CPDefinitionOptionValueRel cpDefinitionOptionValueRel2 =
			_getOrAddEmptyCPDefinitionOptionValueRel(externalReferenceCode);

		Assert.assertEquals(
			cpDefinitionOptionValueRel1.getCPDefinitionOptionValueRelId(),
			cpDefinitionOptionValueRel2.getCPDefinitionOptionValueRelId());
	}

	@Test(expected = NoSuchCPDefinitionOptionValueRelException.class)
	public void testGetOrAddEmptyCPDefinitionOptionValueRelOutsideImportThrows()
		throws Exception {

		_cpDefinitionOptionValueRelLocalService.
			getOrAddEmptyCPDefinitionOptionValueRel(
				RandomTestUtil.randomString(), _group.getCompanyId(),
				_user.getUserId(), _group.getGroupId());
	}

	private CPDefinitionOptionValueRel _getOrAddEmptyCPDefinitionOptionValueRel(
			String externalReferenceCode)
		throws Exception {

		try (SafeCloseable safeCloseable =
				LazyReferencingThreadLocal.setEnabledWithSafeCloseable(true)) {

			return _cpDefinitionOptionValueRelLocalService.
				getOrAddEmptyCPDefinitionOptionValueRel(
					externalReferenceCode, _group.getCompanyId(),
					_user.getUserId(), _group.getGroupId());
		}
	}

	@Inject
	private CPDefinitionOptionValueRelLocalService
		_cpDefinitionOptionValueRelLocalService;

	@DeleteAfterTestRun
	private Group _group;

	private ServiceContext _serviceContext;

	@DeleteAfterTestRun
	private User _user;

}