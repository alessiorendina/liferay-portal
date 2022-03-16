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

package com.liferay.commerce.shipping.engine.fixed.service.persistence.test;

import com.liferay.arquillian.extension.junit.bridge.junit.Arquillian;
import com.liferay.commerce.shipping.engine.fixed.exception.NoSuchAccountEntryShippingOptionRelException;
import com.liferay.commerce.shipping.engine.fixed.model.AccountEntryShippingOptionRel;
import com.liferay.commerce.shipping.engine.fixed.service.AccountEntryShippingOptionRelLocalServiceUtil;
import com.liferay.commerce.shipping.engine.fixed.service.persistence.AccountEntryShippingOptionRelPersistence;
import com.liferay.commerce.shipping.engine.fixed.service.persistence.AccountEntryShippingOptionRelUtil;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.test.ReflectionTestUtil;
import com.liferay.portal.kernel.test.rule.AggregateTestRule;
import com.liferay.portal.kernel.test.util.RandomTestUtil;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.util.IntegerWrapper;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.OrderByComparatorFactoryUtil;
import com.liferay.portal.kernel.util.Time;
import com.liferay.portal.test.rule.LiferayIntegrationTestRule;
import com.liferay.portal.test.rule.PersistenceTestRule;
import com.liferay.portal.test.rule.TransactionalTestRule;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @generated
 */
@RunWith(Arquillian.class)
public class AccountEntryShippingOptionRelPersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED,
				"com.liferay.commerce.shipping.engine.fixed.service"));

	@Before
	public void setUp() {
		_persistence = AccountEntryShippingOptionRelUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<AccountEntryShippingOptionRel> iterator =
			_accountEntryShippingOptionRels.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		AccountEntryShippingOptionRel accountEntryShippingOptionRel =
			_persistence.create(pk);

		Assert.assertNotNull(accountEntryShippingOptionRel);

		Assert.assertEquals(accountEntryShippingOptionRel.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		AccountEntryShippingOptionRel newAccountEntryShippingOptionRel =
			addAccountEntryShippingOptionRel();

		_persistence.remove(newAccountEntryShippingOptionRel);

		AccountEntryShippingOptionRel existingAccountEntryShippingOptionRel =
			_persistence.fetchByPrimaryKey(
				newAccountEntryShippingOptionRel.getPrimaryKey());

		Assert.assertNull(existingAccountEntryShippingOptionRel);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addAccountEntryShippingOptionRel();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		AccountEntryShippingOptionRel newAccountEntryShippingOptionRel =
			_persistence.create(pk);

		newAccountEntryShippingOptionRel.setMvccVersion(
			RandomTestUtil.nextLong());

		newAccountEntryShippingOptionRel.setCompanyId(
			RandomTestUtil.nextLong());

		newAccountEntryShippingOptionRel.setUserId(RandomTestUtil.nextLong());

		newAccountEntryShippingOptionRel.setUserName(
			RandomTestUtil.randomString());

		newAccountEntryShippingOptionRel.setCreateDate(
			RandomTestUtil.nextDate());

		newAccountEntryShippingOptionRel.setModifiedDate(
			RandomTestUtil.nextDate());

		newAccountEntryShippingOptionRel.setAccountEntryId(
			RandomTestUtil.nextLong());

		newAccountEntryShippingOptionRel.setChannelId(
			RandomTestUtil.nextLong());

		newAccountEntryShippingOptionRel.setShippingMethodKey(
			RandomTestUtil.randomString());

		newAccountEntryShippingOptionRel.setShippingOptionKey(
			RandomTestUtil.randomString());

		_accountEntryShippingOptionRels.add(
			_persistence.update(newAccountEntryShippingOptionRel));

		AccountEntryShippingOptionRel existingAccountEntryShippingOptionRel =
			_persistence.findByPrimaryKey(
				newAccountEntryShippingOptionRel.getPrimaryKey());

		Assert.assertEquals(
			existingAccountEntryShippingOptionRel.getMvccVersion(),
			newAccountEntryShippingOptionRel.getMvccVersion());
		Assert.assertEquals(
			existingAccountEntryShippingOptionRel.
				getAccountEntryShippingOptionRelId(),
			newAccountEntryShippingOptionRel.
				getAccountEntryShippingOptionRelId());
		Assert.assertEquals(
			existingAccountEntryShippingOptionRel.getCompanyId(),
			newAccountEntryShippingOptionRel.getCompanyId());
		Assert.assertEquals(
			existingAccountEntryShippingOptionRel.getUserId(),
			newAccountEntryShippingOptionRel.getUserId());
		Assert.assertEquals(
			existingAccountEntryShippingOptionRel.getUserName(),
			newAccountEntryShippingOptionRel.getUserName());
		Assert.assertEquals(
			Time.getShortTimestamp(
				existingAccountEntryShippingOptionRel.getCreateDate()),
			Time.getShortTimestamp(
				newAccountEntryShippingOptionRel.getCreateDate()));
		Assert.assertEquals(
			Time.getShortTimestamp(
				existingAccountEntryShippingOptionRel.getModifiedDate()),
			Time.getShortTimestamp(
				newAccountEntryShippingOptionRel.getModifiedDate()));
		Assert.assertEquals(
			existingAccountEntryShippingOptionRel.getAccountEntryId(),
			newAccountEntryShippingOptionRel.getAccountEntryId());
		Assert.assertEquals(
			existingAccountEntryShippingOptionRel.getChannelId(),
			newAccountEntryShippingOptionRel.getChannelId());
		Assert.assertEquals(
			existingAccountEntryShippingOptionRel.getShippingMethodKey(),
			newAccountEntryShippingOptionRel.getShippingMethodKey());
		Assert.assertEquals(
			existingAccountEntryShippingOptionRel.getShippingOptionKey(),
			newAccountEntryShippingOptionRel.getShippingOptionKey());
	}

	@Test
	public void testCountByShippingOptionKey() throws Exception {
		_persistence.countByShippingOptionKey("");

		_persistence.countByShippingOptionKey("null");

		_persistence.countByShippingOptionKey((String)null);
	}

	@Test
	public void testCountByC_A_C() throws Exception {
		_persistence.countByC_A_C(
			RandomTestUtil.nextLong(), RandomTestUtil.nextLong(),
			RandomTestUtil.nextLong());

		_persistence.countByC_A_C(0L, 0L, 0L);
	}

	@Test
	public void testCountByC_A_C_S() throws Exception {
		_persistence.countByC_A_C_S(
			RandomTestUtil.nextLong(), RandomTestUtil.nextLong(),
			RandomTestUtil.nextLong(), "");

		_persistence.countByC_A_C_S(0L, 0L, 0L, "null");

		_persistence.countByC_A_C_S(0L, 0L, 0L, (String)null);
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		AccountEntryShippingOptionRel newAccountEntryShippingOptionRel =
			addAccountEntryShippingOptionRel();

		AccountEntryShippingOptionRel existingAccountEntryShippingOptionRel =
			_persistence.findByPrimaryKey(
				newAccountEntryShippingOptionRel.getPrimaryKey());

		Assert.assertEquals(
			existingAccountEntryShippingOptionRel,
			newAccountEntryShippingOptionRel);
	}

	@Test(expected = NoSuchAccountEntryShippingOptionRelException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<AccountEntryShippingOptionRel>
		getOrderByComparator() {

		return OrderByComparatorFactoryUtil.create(
			"AccountEntryShippingOptionRel", "mvccVersion", true,
			"accountEntryShippingOptionRelId", true, "companyId", true,
			"userId", true, "userName", true, "createDate", true,
			"modifiedDate", true, "accountEntryId", true, "channelId", true,
			"shippingMethodKey", true, "shippingOptionKey", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		AccountEntryShippingOptionRel newAccountEntryShippingOptionRel =
			addAccountEntryShippingOptionRel();

		AccountEntryShippingOptionRel existingAccountEntryShippingOptionRel =
			_persistence.fetchByPrimaryKey(
				newAccountEntryShippingOptionRel.getPrimaryKey());

		Assert.assertEquals(
			existingAccountEntryShippingOptionRel,
			newAccountEntryShippingOptionRel);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		AccountEntryShippingOptionRel missingAccountEntryShippingOptionRel =
			_persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingAccountEntryShippingOptionRel);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		AccountEntryShippingOptionRel newAccountEntryShippingOptionRel1 =
			addAccountEntryShippingOptionRel();
		AccountEntryShippingOptionRel newAccountEntryShippingOptionRel2 =
			addAccountEntryShippingOptionRel();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newAccountEntryShippingOptionRel1.getPrimaryKey());
		primaryKeys.add(newAccountEntryShippingOptionRel2.getPrimaryKey());

		Map<Serializable, AccountEntryShippingOptionRel>
			accountEntryShippingOptionRels = _persistence.fetchByPrimaryKeys(
				primaryKeys);

		Assert.assertEquals(2, accountEntryShippingOptionRels.size());
		Assert.assertEquals(
			newAccountEntryShippingOptionRel1,
			accountEntryShippingOptionRels.get(
				newAccountEntryShippingOptionRel1.getPrimaryKey()));
		Assert.assertEquals(
			newAccountEntryShippingOptionRel2,
			accountEntryShippingOptionRels.get(
				newAccountEntryShippingOptionRel2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, AccountEntryShippingOptionRel>
			accountEntryShippingOptionRels = _persistence.fetchByPrimaryKeys(
				primaryKeys);

		Assert.assertTrue(accountEntryShippingOptionRels.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		AccountEntryShippingOptionRel newAccountEntryShippingOptionRel =
			addAccountEntryShippingOptionRel();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newAccountEntryShippingOptionRel.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, AccountEntryShippingOptionRel>
			accountEntryShippingOptionRels = _persistence.fetchByPrimaryKeys(
				primaryKeys);

		Assert.assertEquals(1, accountEntryShippingOptionRels.size());
		Assert.assertEquals(
			newAccountEntryShippingOptionRel,
			accountEntryShippingOptionRels.get(
				newAccountEntryShippingOptionRel.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, AccountEntryShippingOptionRel>
			accountEntryShippingOptionRels = _persistence.fetchByPrimaryKeys(
				primaryKeys);

		Assert.assertTrue(accountEntryShippingOptionRels.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		AccountEntryShippingOptionRel newAccountEntryShippingOptionRel =
			addAccountEntryShippingOptionRel();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newAccountEntryShippingOptionRel.getPrimaryKey());

		Map<Serializable, AccountEntryShippingOptionRel>
			accountEntryShippingOptionRels = _persistence.fetchByPrimaryKeys(
				primaryKeys);

		Assert.assertEquals(1, accountEntryShippingOptionRels.size());
		Assert.assertEquals(
			newAccountEntryShippingOptionRel,
			accountEntryShippingOptionRels.get(
				newAccountEntryShippingOptionRel.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			AccountEntryShippingOptionRelLocalServiceUtil.
				getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod
				<AccountEntryShippingOptionRel>() {

				@Override
				public void performAction(
					AccountEntryShippingOptionRel
						accountEntryShippingOptionRel) {

					Assert.assertNotNull(accountEntryShippingOptionRel);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		AccountEntryShippingOptionRel newAccountEntryShippingOptionRel =
			addAccountEntryShippingOptionRel();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			AccountEntryShippingOptionRel.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"accountEntryShippingOptionRelId",
				newAccountEntryShippingOptionRel.
					getAccountEntryShippingOptionRelId()));

		List<AccountEntryShippingOptionRel> result =
			_persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		AccountEntryShippingOptionRel existingAccountEntryShippingOptionRel =
			result.get(0);

		Assert.assertEquals(
			existingAccountEntryShippingOptionRel,
			newAccountEntryShippingOptionRel);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			AccountEntryShippingOptionRel.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"accountEntryShippingOptionRelId", RandomTestUtil.nextLong()));

		List<AccountEntryShippingOptionRel> result =
			_persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		AccountEntryShippingOptionRel newAccountEntryShippingOptionRel =
			addAccountEntryShippingOptionRel();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			AccountEntryShippingOptionRel.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(
			ProjectionFactoryUtil.property("accountEntryShippingOptionRelId"));

		Object newAccountEntryShippingOptionRelId =
			newAccountEntryShippingOptionRel.
				getAccountEntryShippingOptionRelId();

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"accountEntryShippingOptionRelId",
				new Object[] {newAccountEntryShippingOptionRelId}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Object existingAccountEntryShippingOptionRelId = result.get(0);

		Assert.assertEquals(
			existingAccountEntryShippingOptionRelId,
			newAccountEntryShippingOptionRelId);
	}

	@Test
	public void testDynamicQueryByProjectionMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			AccountEntryShippingOptionRel.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(
			ProjectionFactoryUtil.property("accountEntryShippingOptionRelId"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"accountEntryShippingOptionRelId",
				new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testResetOriginalValues() throws Exception {
		AccountEntryShippingOptionRel newAccountEntryShippingOptionRel =
			addAccountEntryShippingOptionRel();

		_persistence.clearCache();

		_assertOriginalValues(
			_persistence.findByPrimaryKey(
				newAccountEntryShippingOptionRel.getPrimaryKey()));
	}

	@Test
	public void testResetOriginalValuesWithDynamicQueryLoadFromDatabase()
		throws Exception {

		_testResetOriginalValuesWithDynamicQuery(true);
	}

	@Test
	public void testResetOriginalValuesWithDynamicQueryLoadFromSession()
		throws Exception {

		_testResetOriginalValuesWithDynamicQuery(false);
	}

	private void _testResetOriginalValuesWithDynamicQuery(boolean clearSession)
		throws Exception {

		AccountEntryShippingOptionRel newAccountEntryShippingOptionRel =
			addAccountEntryShippingOptionRel();

		if (clearSession) {
			Session session = _persistence.openSession();

			session.flush();

			session.clear();
		}

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			AccountEntryShippingOptionRel.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"accountEntryShippingOptionRelId",
				newAccountEntryShippingOptionRel.
					getAccountEntryShippingOptionRelId()));

		List<AccountEntryShippingOptionRel> result =
			_persistence.findWithDynamicQuery(dynamicQuery);

		_assertOriginalValues(result.get(0));
	}

	private void _assertOriginalValues(
		AccountEntryShippingOptionRel accountEntryShippingOptionRel) {

		Assert.assertEquals(
			Long.valueOf(accountEntryShippingOptionRel.getCompanyId()),
			ReflectionTestUtil.<Long>invoke(
				accountEntryShippingOptionRel, "getColumnOriginalValue",
				new Class<?>[] {String.class}, "companyId"));
		Assert.assertEquals(
			Long.valueOf(accountEntryShippingOptionRel.getAccountEntryId()),
			ReflectionTestUtil.<Long>invoke(
				accountEntryShippingOptionRel, "getColumnOriginalValue",
				new Class<?>[] {String.class}, "accountEntryId"));
		Assert.assertEquals(
			Long.valueOf(accountEntryShippingOptionRel.getChannelId()),
			ReflectionTestUtil.<Long>invoke(
				accountEntryShippingOptionRel, "getColumnOriginalValue",
				new Class<?>[] {String.class}, "channelId"));

		Assert.assertEquals(
			Long.valueOf(accountEntryShippingOptionRel.getCompanyId()),
			ReflectionTestUtil.<Long>invoke(
				accountEntryShippingOptionRel, "getColumnOriginalValue",
				new Class<?>[] {String.class}, "companyId"));
		Assert.assertEquals(
			Long.valueOf(accountEntryShippingOptionRel.getAccountEntryId()),
			ReflectionTestUtil.<Long>invoke(
				accountEntryShippingOptionRel, "getColumnOriginalValue",
				new Class<?>[] {String.class}, "accountEntryId"));
		Assert.assertEquals(
			Long.valueOf(accountEntryShippingOptionRel.getChannelId()),
			ReflectionTestUtil.<Long>invoke(
				accountEntryShippingOptionRel, "getColumnOriginalValue",
				new Class<?>[] {String.class}, "channelId"));
		Assert.assertEquals(
			accountEntryShippingOptionRel.getShippingOptionKey(),
			ReflectionTestUtil.invoke(
				accountEntryShippingOptionRel, "getColumnOriginalValue",
				new Class<?>[] {String.class}, "shippingOptionKey"));
	}

	protected AccountEntryShippingOptionRel addAccountEntryShippingOptionRel()
		throws Exception {

		long pk = RandomTestUtil.nextLong();

		AccountEntryShippingOptionRel accountEntryShippingOptionRel =
			_persistence.create(pk);

		accountEntryShippingOptionRel.setMvccVersion(RandomTestUtil.nextLong());

		accountEntryShippingOptionRel.setCompanyId(RandomTestUtil.nextLong());

		accountEntryShippingOptionRel.setUserId(RandomTestUtil.nextLong());

		accountEntryShippingOptionRel.setUserName(
			RandomTestUtil.randomString());

		accountEntryShippingOptionRel.setCreateDate(RandomTestUtil.nextDate());

		accountEntryShippingOptionRel.setModifiedDate(
			RandomTestUtil.nextDate());

		accountEntryShippingOptionRel.setAccountEntryId(
			RandomTestUtil.nextLong());

		accountEntryShippingOptionRel.setChannelId(RandomTestUtil.nextLong());

		accountEntryShippingOptionRel.setShippingMethodKey(
			RandomTestUtil.randomString());

		accountEntryShippingOptionRel.setShippingOptionKey(
			RandomTestUtil.randomString());

		_accountEntryShippingOptionRels.add(
			_persistence.update(accountEntryShippingOptionRel));

		return accountEntryShippingOptionRel;
	}

	private List<AccountEntryShippingOptionRel>
		_accountEntryShippingOptionRels =
			new ArrayList<AccountEntryShippingOptionRel>();
	private AccountEntryShippingOptionRelPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}