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

package com.liferay.commerce.shipping.engine.fixed.service.persistence;

import com.liferay.commerce.shipping.engine.fixed.model.AccountEntryShippingOptionRel;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the account entry shipping option rel service. This utility wraps <code>com.liferay.commerce.shipping.engine.fixed.service.persistence.impl.AccountEntryShippingOptionRelPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Alessio Antonio Rendina
 * @see AccountEntryShippingOptionRelPersistence
 * @generated
 */
public class AccountEntryShippingOptionRelUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(
		AccountEntryShippingOptionRel accountEntryShippingOptionRel) {

		getPersistence().clearCache(accountEntryShippingOptionRel);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, AccountEntryShippingOptionRel>
		fetchByPrimaryKeys(Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<AccountEntryShippingOptionRel> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<AccountEntryShippingOptionRel> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<AccountEntryShippingOptionRel> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<AccountEntryShippingOptionRel> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static AccountEntryShippingOptionRel update(
		AccountEntryShippingOptionRel accountEntryShippingOptionRel) {

		return getPersistence().update(accountEntryShippingOptionRel);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static AccountEntryShippingOptionRel update(
		AccountEntryShippingOptionRel accountEntryShippingOptionRel,
		ServiceContext serviceContext) {

		return getPersistence().update(
			accountEntryShippingOptionRel, serviceContext);
	}

	/**
	 * Returns all the account entry shipping option rels where shippingOptionKey = &#63;.
	 *
	 * @param shippingOptionKey the shipping option key
	 * @return the matching account entry shipping option rels
	 */
	public static List<AccountEntryShippingOptionRel> findByShippingOptionKey(
		String shippingOptionKey) {

		return getPersistence().findByShippingOptionKey(shippingOptionKey);
	}

	/**
	 * Returns a range of all the account entry shipping option rels where shippingOptionKey = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AccountEntryShippingOptionRelModelImpl</code>.
	 * </p>
	 *
	 * @param shippingOptionKey the shipping option key
	 * @param start the lower bound of the range of account entry shipping option rels
	 * @param end the upper bound of the range of account entry shipping option rels (not inclusive)
	 * @return the range of matching account entry shipping option rels
	 */
	public static List<AccountEntryShippingOptionRel> findByShippingOptionKey(
		String shippingOptionKey, int start, int end) {

		return getPersistence().findByShippingOptionKey(
			shippingOptionKey, start, end);
	}

	/**
	 * Returns an ordered range of all the account entry shipping option rels where shippingOptionKey = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AccountEntryShippingOptionRelModelImpl</code>.
	 * </p>
	 *
	 * @param shippingOptionKey the shipping option key
	 * @param start the lower bound of the range of account entry shipping option rels
	 * @param end the upper bound of the range of account entry shipping option rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching account entry shipping option rels
	 */
	public static List<AccountEntryShippingOptionRel> findByShippingOptionKey(
		String shippingOptionKey, int start, int end,
		OrderByComparator<AccountEntryShippingOptionRel> orderByComparator) {

		return getPersistence().findByShippingOptionKey(
			shippingOptionKey, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the account entry shipping option rels where shippingOptionKey = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AccountEntryShippingOptionRelModelImpl</code>.
	 * </p>
	 *
	 * @param shippingOptionKey the shipping option key
	 * @param start the lower bound of the range of account entry shipping option rels
	 * @param end the upper bound of the range of account entry shipping option rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching account entry shipping option rels
	 */
	public static List<AccountEntryShippingOptionRel> findByShippingOptionKey(
		String shippingOptionKey, int start, int end,
		OrderByComparator<AccountEntryShippingOptionRel> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByShippingOptionKey(
			shippingOptionKey, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first account entry shipping option rel in the ordered set where shippingOptionKey = &#63;.
	 *
	 * @param shippingOptionKey the shipping option key
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching account entry shipping option rel
	 * @throws NoSuchAccountEntryShippingOptionRelException if a matching account entry shipping option rel could not be found
	 */
	public static AccountEntryShippingOptionRel findByShippingOptionKey_First(
			String shippingOptionKey,
			OrderByComparator<AccountEntryShippingOptionRel> orderByComparator)
		throws com.liferay.commerce.shipping.engine.fixed.exception.
			NoSuchAccountEntryShippingOptionRelException {

		return getPersistence().findByShippingOptionKey_First(
			shippingOptionKey, orderByComparator);
	}

	/**
	 * Returns the first account entry shipping option rel in the ordered set where shippingOptionKey = &#63;.
	 *
	 * @param shippingOptionKey the shipping option key
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching account entry shipping option rel, or <code>null</code> if a matching account entry shipping option rel could not be found
	 */
	public static AccountEntryShippingOptionRel fetchByShippingOptionKey_First(
		String shippingOptionKey,
		OrderByComparator<AccountEntryShippingOptionRel> orderByComparator) {

		return getPersistence().fetchByShippingOptionKey_First(
			shippingOptionKey, orderByComparator);
	}

	/**
	 * Returns the last account entry shipping option rel in the ordered set where shippingOptionKey = &#63;.
	 *
	 * @param shippingOptionKey the shipping option key
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching account entry shipping option rel
	 * @throws NoSuchAccountEntryShippingOptionRelException if a matching account entry shipping option rel could not be found
	 */
	public static AccountEntryShippingOptionRel findByShippingOptionKey_Last(
			String shippingOptionKey,
			OrderByComparator<AccountEntryShippingOptionRel> orderByComparator)
		throws com.liferay.commerce.shipping.engine.fixed.exception.
			NoSuchAccountEntryShippingOptionRelException {

		return getPersistence().findByShippingOptionKey_Last(
			shippingOptionKey, orderByComparator);
	}

	/**
	 * Returns the last account entry shipping option rel in the ordered set where shippingOptionKey = &#63;.
	 *
	 * @param shippingOptionKey the shipping option key
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching account entry shipping option rel, or <code>null</code> if a matching account entry shipping option rel could not be found
	 */
	public static AccountEntryShippingOptionRel fetchByShippingOptionKey_Last(
		String shippingOptionKey,
		OrderByComparator<AccountEntryShippingOptionRel> orderByComparator) {

		return getPersistence().fetchByShippingOptionKey_Last(
			shippingOptionKey, orderByComparator);
	}

	/**
	 * Returns the account entry shipping option rels before and after the current account entry shipping option rel in the ordered set where shippingOptionKey = &#63;.
	 *
	 * @param accountEntryShippingOptionRelId the primary key of the current account entry shipping option rel
	 * @param shippingOptionKey the shipping option key
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next account entry shipping option rel
	 * @throws NoSuchAccountEntryShippingOptionRelException if a account entry shipping option rel with the primary key could not be found
	 */
	public static AccountEntryShippingOptionRel[]
			findByShippingOptionKey_PrevAndNext(
				long accountEntryShippingOptionRelId, String shippingOptionKey,
				OrderByComparator<AccountEntryShippingOptionRel>
					orderByComparator)
		throws com.liferay.commerce.shipping.engine.fixed.exception.
			NoSuchAccountEntryShippingOptionRelException {

		return getPersistence().findByShippingOptionKey_PrevAndNext(
			accountEntryShippingOptionRelId, shippingOptionKey,
			orderByComparator);
	}

	/**
	 * Removes all the account entry shipping option rels where shippingOptionKey = &#63; from the database.
	 *
	 * @param shippingOptionKey the shipping option key
	 */
	public static void removeByShippingOptionKey(String shippingOptionKey) {
		getPersistence().removeByShippingOptionKey(shippingOptionKey);
	}

	/**
	 * Returns the number of account entry shipping option rels where shippingOptionKey = &#63;.
	 *
	 * @param shippingOptionKey the shipping option key
	 * @return the number of matching account entry shipping option rels
	 */
	public static int countByShippingOptionKey(String shippingOptionKey) {
		return getPersistence().countByShippingOptionKey(shippingOptionKey);
	}

	/**
	 * Returns the account entry shipping option rel where companyId = &#63; and accountEntryId = &#63; and channelId = &#63; or throws a <code>NoSuchAccountEntryShippingOptionRelException</code> if it could not be found.
	 *
	 * @param companyId the company ID
	 * @param accountEntryId the account entry ID
	 * @param channelId the channel ID
	 * @return the matching account entry shipping option rel
	 * @throws NoSuchAccountEntryShippingOptionRelException if a matching account entry shipping option rel could not be found
	 */
	public static AccountEntryShippingOptionRel findByC_A_C(
			long companyId, long accountEntryId, long channelId)
		throws com.liferay.commerce.shipping.engine.fixed.exception.
			NoSuchAccountEntryShippingOptionRelException {

		return getPersistence().findByC_A_C(
			companyId, accountEntryId, channelId);
	}

	/**
	 * Returns the account entry shipping option rel where companyId = &#63; and accountEntryId = &#63; and channelId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param companyId the company ID
	 * @param accountEntryId the account entry ID
	 * @param channelId the channel ID
	 * @return the matching account entry shipping option rel, or <code>null</code> if a matching account entry shipping option rel could not be found
	 */
	public static AccountEntryShippingOptionRel fetchByC_A_C(
		long companyId, long accountEntryId, long channelId) {

		return getPersistence().fetchByC_A_C(
			companyId, accountEntryId, channelId);
	}

	/**
	 * Returns the account entry shipping option rel where companyId = &#63; and accountEntryId = &#63; and channelId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param companyId the company ID
	 * @param accountEntryId the account entry ID
	 * @param channelId the channel ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching account entry shipping option rel, or <code>null</code> if a matching account entry shipping option rel could not be found
	 */
	public static AccountEntryShippingOptionRel fetchByC_A_C(
		long companyId, long accountEntryId, long channelId,
		boolean useFinderCache) {

		return getPersistence().fetchByC_A_C(
			companyId, accountEntryId, channelId, useFinderCache);
	}

	/**
	 * Removes the account entry shipping option rel where companyId = &#63; and accountEntryId = &#63; and channelId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param accountEntryId the account entry ID
	 * @param channelId the channel ID
	 * @return the account entry shipping option rel that was removed
	 */
	public static AccountEntryShippingOptionRel removeByC_A_C(
			long companyId, long accountEntryId, long channelId)
		throws com.liferay.commerce.shipping.engine.fixed.exception.
			NoSuchAccountEntryShippingOptionRelException {

		return getPersistence().removeByC_A_C(
			companyId, accountEntryId, channelId);
	}

	/**
	 * Returns the number of account entry shipping option rels where companyId = &#63; and accountEntryId = &#63; and channelId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param accountEntryId the account entry ID
	 * @param channelId the channel ID
	 * @return the number of matching account entry shipping option rels
	 */
	public static int countByC_A_C(
		long companyId, long accountEntryId, long channelId) {

		return getPersistence().countByC_A_C(
			companyId, accountEntryId, channelId);
	}

	/**
	 * Returns the account entry shipping option rel where companyId = &#63; and accountEntryId = &#63; and channelId = &#63; and shippingOptionKey = &#63; or throws a <code>NoSuchAccountEntryShippingOptionRelException</code> if it could not be found.
	 *
	 * @param companyId the company ID
	 * @param accountEntryId the account entry ID
	 * @param channelId the channel ID
	 * @param shippingOptionKey the shipping option key
	 * @return the matching account entry shipping option rel
	 * @throws NoSuchAccountEntryShippingOptionRelException if a matching account entry shipping option rel could not be found
	 */
	public static AccountEntryShippingOptionRel findByC_A_C_S(
			long companyId, long accountEntryId, long channelId,
			String shippingOptionKey)
		throws com.liferay.commerce.shipping.engine.fixed.exception.
			NoSuchAccountEntryShippingOptionRelException {

		return getPersistence().findByC_A_C_S(
			companyId, accountEntryId, channelId, shippingOptionKey);
	}

	/**
	 * Returns the account entry shipping option rel where companyId = &#63; and accountEntryId = &#63; and channelId = &#63; and shippingOptionKey = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param companyId the company ID
	 * @param accountEntryId the account entry ID
	 * @param channelId the channel ID
	 * @param shippingOptionKey the shipping option key
	 * @return the matching account entry shipping option rel, or <code>null</code> if a matching account entry shipping option rel could not be found
	 */
	public static AccountEntryShippingOptionRel fetchByC_A_C_S(
		long companyId, long accountEntryId, long channelId,
		String shippingOptionKey) {

		return getPersistence().fetchByC_A_C_S(
			companyId, accountEntryId, channelId, shippingOptionKey);
	}

	/**
	 * Returns the account entry shipping option rel where companyId = &#63; and accountEntryId = &#63; and channelId = &#63; and shippingOptionKey = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param companyId the company ID
	 * @param accountEntryId the account entry ID
	 * @param channelId the channel ID
	 * @param shippingOptionKey the shipping option key
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching account entry shipping option rel, or <code>null</code> if a matching account entry shipping option rel could not be found
	 */
	public static AccountEntryShippingOptionRel fetchByC_A_C_S(
		long companyId, long accountEntryId, long channelId,
		String shippingOptionKey, boolean useFinderCache) {

		return getPersistence().fetchByC_A_C_S(
			companyId, accountEntryId, channelId, shippingOptionKey,
			useFinderCache);
	}

	/**
	 * Removes the account entry shipping option rel where companyId = &#63; and accountEntryId = &#63; and channelId = &#63; and shippingOptionKey = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param accountEntryId the account entry ID
	 * @param channelId the channel ID
	 * @param shippingOptionKey the shipping option key
	 * @return the account entry shipping option rel that was removed
	 */
	public static AccountEntryShippingOptionRel removeByC_A_C_S(
			long companyId, long accountEntryId, long channelId,
			String shippingOptionKey)
		throws com.liferay.commerce.shipping.engine.fixed.exception.
			NoSuchAccountEntryShippingOptionRelException {

		return getPersistence().removeByC_A_C_S(
			companyId, accountEntryId, channelId, shippingOptionKey);
	}

	/**
	 * Returns the number of account entry shipping option rels where companyId = &#63; and accountEntryId = &#63; and channelId = &#63; and shippingOptionKey = &#63;.
	 *
	 * @param companyId the company ID
	 * @param accountEntryId the account entry ID
	 * @param channelId the channel ID
	 * @param shippingOptionKey the shipping option key
	 * @return the number of matching account entry shipping option rels
	 */
	public static int countByC_A_C_S(
		long companyId, long accountEntryId, long channelId,
		String shippingOptionKey) {

		return getPersistence().countByC_A_C_S(
			companyId, accountEntryId, channelId, shippingOptionKey);
	}

	/**
	 * Caches the account entry shipping option rel in the entity cache if it is enabled.
	 *
	 * @param accountEntryShippingOptionRel the account entry shipping option rel
	 */
	public static void cacheResult(
		AccountEntryShippingOptionRel accountEntryShippingOptionRel) {

		getPersistence().cacheResult(accountEntryShippingOptionRel);
	}

	/**
	 * Caches the account entry shipping option rels in the entity cache if it is enabled.
	 *
	 * @param accountEntryShippingOptionRels the account entry shipping option rels
	 */
	public static void cacheResult(
		List<AccountEntryShippingOptionRel> accountEntryShippingOptionRels) {

		getPersistence().cacheResult(accountEntryShippingOptionRels);
	}

	/**
	 * Creates a new account entry shipping option rel with the primary key. Does not add the account entry shipping option rel to the database.
	 *
	 * @param accountEntryShippingOptionRelId the primary key for the new account entry shipping option rel
	 * @return the new account entry shipping option rel
	 */
	public static AccountEntryShippingOptionRel create(
		long accountEntryShippingOptionRelId) {

		return getPersistence().create(accountEntryShippingOptionRelId);
	}

	/**
	 * Removes the account entry shipping option rel with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param accountEntryShippingOptionRelId the primary key of the account entry shipping option rel
	 * @return the account entry shipping option rel that was removed
	 * @throws NoSuchAccountEntryShippingOptionRelException if a account entry shipping option rel with the primary key could not be found
	 */
	public static AccountEntryShippingOptionRel remove(
			long accountEntryShippingOptionRelId)
		throws com.liferay.commerce.shipping.engine.fixed.exception.
			NoSuchAccountEntryShippingOptionRelException {

		return getPersistence().remove(accountEntryShippingOptionRelId);
	}

	public static AccountEntryShippingOptionRel updateImpl(
		AccountEntryShippingOptionRel accountEntryShippingOptionRel) {

		return getPersistence().updateImpl(accountEntryShippingOptionRel);
	}

	/**
	 * Returns the account entry shipping option rel with the primary key or throws a <code>NoSuchAccountEntryShippingOptionRelException</code> if it could not be found.
	 *
	 * @param accountEntryShippingOptionRelId the primary key of the account entry shipping option rel
	 * @return the account entry shipping option rel
	 * @throws NoSuchAccountEntryShippingOptionRelException if a account entry shipping option rel with the primary key could not be found
	 */
	public static AccountEntryShippingOptionRel findByPrimaryKey(
			long accountEntryShippingOptionRelId)
		throws com.liferay.commerce.shipping.engine.fixed.exception.
			NoSuchAccountEntryShippingOptionRelException {

		return getPersistence().findByPrimaryKey(
			accountEntryShippingOptionRelId);
	}

	/**
	 * Returns the account entry shipping option rel with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param accountEntryShippingOptionRelId the primary key of the account entry shipping option rel
	 * @return the account entry shipping option rel, or <code>null</code> if a account entry shipping option rel with the primary key could not be found
	 */
	public static AccountEntryShippingOptionRel fetchByPrimaryKey(
		long accountEntryShippingOptionRelId) {

		return getPersistence().fetchByPrimaryKey(
			accountEntryShippingOptionRelId);
	}

	/**
	 * Returns all the account entry shipping option rels.
	 *
	 * @return the account entry shipping option rels
	 */
	public static List<AccountEntryShippingOptionRel> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the account entry shipping option rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AccountEntryShippingOptionRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of account entry shipping option rels
	 * @param end the upper bound of the range of account entry shipping option rels (not inclusive)
	 * @return the range of account entry shipping option rels
	 */
	public static List<AccountEntryShippingOptionRel> findAll(
		int start, int end) {

		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the account entry shipping option rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AccountEntryShippingOptionRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of account entry shipping option rels
	 * @param end the upper bound of the range of account entry shipping option rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of account entry shipping option rels
	 */
	public static List<AccountEntryShippingOptionRel> findAll(
		int start, int end,
		OrderByComparator<AccountEntryShippingOptionRel> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the account entry shipping option rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AccountEntryShippingOptionRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of account entry shipping option rels
	 * @param end the upper bound of the range of account entry shipping option rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of account entry shipping option rels
	 */
	public static List<AccountEntryShippingOptionRel> findAll(
		int start, int end,
		OrderByComparator<AccountEntryShippingOptionRel> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the account entry shipping option rels from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of account entry shipping option rels.
	 *
	 * @return the number of account entry shipping option rels
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static AccountEntryShippingOptionRelPersistence getPersistence() {
		return _persistence;
	}

	private static volatile AccountEntryShippingOptionRelPersistence
		_persistence;

}