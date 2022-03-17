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

import com.liferay.commerce.shipping.engine.fixed.exception.NoSuchAccountEntryShippingOptionRelException;
import com.liferay.commerce.shipping.engine.fixed.model.AccountEntryShippingOptionRel;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the account entry shipping option rel service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Alessio Antonio Rendina
 * @see AccountEntryShippingOptionRelUtil
 * @generated
 */
@ProviderType
public interface AccountEntryShippingOptionRelPersistence
	extends BasePersistence<AccountEntryShippingOptionRel> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link AccountEntryShippingOptionRelUtil} to access the account entry shipping option rel persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the account entry shipping option rels where shippingOptionKey = &#63;.
	 *
	 * @param shippingOptionKey the shipping option key
	 * @return the matching account entry shipping option rels
	 */
	public java.util.List<AccountEntryShippingOptionRel>
		findByShippingOptionKey(String shippingOptionKey);

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
	public java.util.List<AccountEntryShippingOptionRel>
		findByShippingOptionKey(String shippingOptionKey, int start, int end);

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
	public java.util.List<AccountEntryShippingOptionRel>
		findByShippingOptionKey(
			String shippingOptionKey, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<AccountEntryShippingOptionRel> orderByComparator);

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
	public java.util.List<AccountEntryShippingOptionRel>
		findByShippingOptionKey(
			String shippingOptionKey, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<AccountEntryShippingOptionRel> orderByComparator,
			boolean useFinderCache);

	/**
	 * Returns the first account entry shipping option rel in the ordered set where shippingOptionKey = &#63;.
	 *
	 * @param shippingOptionKey the shipping option key
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching account entry shipping option rel
	 * @throws NoSuchAccountEntryShippingOptionRelException if a matching account entry shipping option rel could not be found
	 */
	public AccountEntryShippingOptionRel findByShippingOptionKey_First(
			String shippingOptionKey,
			com.liferay.portal.kernel.util.OrderByComparator
				<AccountEntryShippingOptionRel> orderByComparator)
		throws NoSuchAccountEntryShippingOptionRelException;

	/**
	 * Returns the first account entry shipping option rel in the ordered set where shippingOptionKey = &#63;.
	 *
	 * @param shippingOptionKey the shipping option key
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching account entry shipping option rel, or <code>null</code> if a matching account entry shipping option rel could not be found
	 */
	public AccountEntryShippingOptionRel fetchByShippingOptionKey_First(
		String shippingOptionKey,
		com.liferay.portal.kernel.util.OrderByComparator
			<AccountEntryShippingOptionRel> orderByComparator);

	/**
	 * Returns the last account entry shipping option rel in the ordered set where shippingOptionKey = &#63;.
	 *
	 * @param shippingOptionKey the shipping option key
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching account entry shipping option rel
	 * @throws NoSuchAccountEntryShippingOptionRelException if a matching account entry shipping option rel could not be found
	 */
	public AccountEntryShippingOptionRel findByShippingOptionKey_Last(
			String shippingOptionKey,
			com.liferay.portal.kernel.util.OrderByComparator
				<AccountEntryShippingOptionRel> orderByComparator)
		throws NoSuchAccountEntryShippingOptionRelException;

	/**
	 * Returns the last account entry shipping option rel in the ordered set where shippingOptionKey = &#63;.
	 *
	 * @param shippingOptionKey the shipping option key
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching account entry shipping option rel, or <code>null</code> if a matching account entry shipping option rel could not be found
	 */
	public AccountEntryShippingOptionRel fetchByShippingOptionKey_Last(
		String shippingOptionKey,
		com.liferay.portal.kernel.util.OrderByComparator
			<AccountEntryShippingOptionRel> orderByComparator);

	/**
	 * Returns the account entry shipping option rels before and after the current account entry shipping option rel in the ordered set where shippingOptionKey = &#63;.
	 *
	 * @param accountEntryShippingOptionRelId the primary key of the current account entry shipping option rel
	 * @param shippingOptionKey the shipping option key
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next account entry shipping option rel
	 * @throws NoSuchAccountEntryShippingOptionRelException if a account entry shipping option rel with the primary key could not be found
	 */
	public AccountEntryShippingOptionRel[] findByShippingOptionKey_PrevAndNext(
			long accountEntryShippingOptionRelId, String shippingOptionKey,
			com.liferay.portal.kernel.util.OrderByComparator
				<AccountEntryShippingOptionRel> orderByComparator)
		throws NoSuchAccountEntryShippingOptionRelException;

	/**
	 * Removes all the account entry shipping option rels where shippingOptionKey = &#63; from the database.
	 *
	 * @param shippingOptionKey the shipping option key
	 */
	public void removeByShippingOptionKey(String shippingOptionKey);

	/**
	 * Returns the number of account entry shipping option rels where shippingOptionKey = &#63;.
	 *
	 * @param shippingOptionKey the shipping option key
	 * @return the number of matching account entry shipping option rels
	 */
	public int countByShippingOptionKey(String shippingOptionKey);

	/**
	 * Returns the account entry shipping option rel where companyId = &#63; and accountEntryId = &#63; and channelId = &#63; or throws a <code>NoSuchAccountEntryShippingOptionRelException</code> if it could not be found.
	 *
	 * @param companyId the company ID
	 * @param accountEntryId the account entry ID
	 * @param channelId the channel ID
	 * @return the matching account entry shipping option rel
	 * @throws NoSuchAccountEntryShippingOptionRelException if a matching account entry shipping option rel could not be found
	 */
	public AccountEntryShippingOptionRel findByC_A_C(
			long companyId, long accountEntryId, long channelId)
		throws NoSuchAccountEntryShippingOptionRelException;

	/**
	 * Returns the account entry shipping option rel where companyId = &#63; and accountEntryId = &#63; and channelId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param companyId the company ID
	 * @param accountEntryId the account entry ID
	 * @param channelId the channel ID
	 * @return the matching account entry shipping option rel, or <code>null</code> if a matching account entry shipping option rel could not be found
	 */
	public AccountEntryShippingOptionRel fetchByC_A_C(
		long companyId, long accountEntryId, long channelId);

	/**
	 * Returns the account entry shipping option rel where companyId = &#63; and accountEntryId = &#63; and channelId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param companyId the company ID
	 * @param accountEntryId the account entry ID
	 * @param channelId the channel ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching account entry shipping option rel, or <code>null</code> if a matching account entry shipping option rel could not be found
	 */
	public AccountEntryShippingOptionRel fetchByC_A_C(
		long companyId, long accountEntryId, long channelId,
		boolean useFinderCache);

	/**
	 * Removes the account entry shipping option rel where companyId = &#63; and accountEntryId = &#63; and channelId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param accountEntryId the account entry ID
	 * @param channelId the channel ID
	 * @return the account entry shipping option rel that was removed
	 */
	public AccountEntryShippingOptionRel removeByC_A_C(
			long companyId, long accountEntryId, long channelId)
		throws NoSuchAccountEntryShippingOptionRelException;

	/**
	 * Returns the number of account entry shipping option rels where companyId = &#63; and accountEntryId = &#63; and channelId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param accountEntryId the account entry ID
	 * @param channelId the channel ID
	 * @return the number of matching account entry shipping option rels
	 */
	public int countByC_A_C(
		long companyId, long accountEntryId, long channelId);

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
	public AccountEntryShippingOptionRel findByC_A_C_S(
			long companyId, long accountEntryId, long channelId,
			String shippingOptionKey)
		throws NoSuchAccountEntryShippingOptionRelException;

	/**
	 * Returns the account entry shipping option rel where companyId = &#63; and accountEntryId = &#63; and channelId = &#63; and shippingOptionKey = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param companyId the company ID
	 * @param accountEntryId the account entry ID
	 * @param channelId the channel ID
	 * @param shippingOptionKey the shipping option key
	 * @return the matching account entry shipping option rel, or <code>null</code> if a matching account entry shipping option rel could not be found
	 */
	public AccountEntryShippingOptionRel fetchByC_A_C_S(
		long companyId, long accountEntryId, long channelId,
		String shippingOptionKey);

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
	public AccountEntryShippingOptionRel fetchByC_A_C_S(
		long companyId, long accountEntryId, long channelId,
		String shippingOptionKey, boolean useFinderCache);

	/**
	 * Removes the account entry shipping option rel where companyId = &#63; and accountEntryId = &#63; and channelId = &#63; and shippingOptionKey = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param accountEntryId the account entry ID
	 * @param channelId the channel ID
	 * @param shippingOptionKey the shipping option key
	 * @return the account entry shipping option rel that was removed
	 */
	public AccountEntryShippingOptionRel removeByC_A_C_S(
			long companyId, long accountEntryId, long channelId,
			String shippingOptionKey)
		throws NoSuchAccountEntryShippingOptionRelException;

	/**
	 * Returns the number of account entry shipping option rels where companyId = &#63; and accountEntryId = &#63; and channelId = &#63; and shippingOptionKey = &#63;.
	 *
	 * @param companyId the company ID
	 * @param accountEntryId the account entry ID
	 * @param channelId the channel ID
	 * @param shippingOptionKey the shipping option key
	 * @return the number of matching account entry shipping option rels
	 */
	public int countByC_A_C_S(
		long companyId, long accountEntryId, long channelId,
		String shippingOptionKey);

	/**
	 * Caches the account entry shipping option rel in the entity cache if it is enabled.
	 *
	 * @param accountEntryShippingOptionRel the account entry shipping option rel
	 */
	public void cacheResult(
		AccountEntryShippingOptionRel accountEntryShippingOptionRel);

	/**
	 * Caches the account entry shipping option rels in the entity cache if it is enabled.
	 *
	 * @param accountEntryShippingOptionRels the account entry shipping option rels
	 */
	public void cacheResult(
		java.util.List<AccountEntryShippingOptionRel>
			accountEntryShippingOptionRels);

	/**
	 * Creates a new account entry shipping option rel with the primary key. Does not add the account entry shipping option rel to the database.
	 *
	 * @param accountEntryShippingOptionRelId the primary key for the new account entry shipping option rel
	 * @return the new account entry shipping option rel
	 */
	public AccountEntryShippingOptionRel create(
		long accountEntryShippingOptionRelId);

	/**
	 * Removes the account entry shipping option rel with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param accountEntryShippingOptionRelId the primary key of the account entry shipping option rel
	 * @return the account entry shipping option rel that was removed
	 * @throws NoSuchAccountEntryShippingOptionRelException if a account entry shipping option rel with the primary key could not be found
	 */
	public AccountEntryShippingOptionRel remove(
			long accountEntryShippingOptionRelId)
		throws NoSuchAccountEntryShippingOptionRelException;

	public AccountEntryShippingOptionRel updateImpl(
		AccountEntryShippingOptionRel accountEntryShippingOptionRel);

	/**
	 * Returns the account entry shipping option rel with the primary key or throws a <code>NoSuchAccountEntryShippingOptionRelException</code> if it could not be found.
	 *
	 * @param accountEntryShippingOptionRelId the primary key of the account entry shipping option rel
	 * @return the account entry shipping option rel
	 * @throws NoSuchAccountEntryShippingOptionRelException if a account entry shipping option rel with the primary key could not be found
	 */
	public AccountEntryShippingOptionRel findByPrimaryKey(
			long accountEntryShippingOptionRelId)
		throws NoSuchAccountEntryShippingOptionRelException;

	/**
	 * Returns the account entry shipping option rel with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param accountEntryShippingOptionRelId the primary key of the account entry shipping option rel
	 * @return the account entry shipping option rel, or <code>null</code> if a account entry shipping option rel with the primary key could not be found
	 */
	public AccountEntryShippingOptionRel fetchByPrimaryKey(
		long accountEntryShippingOptionRelId);

	/**
	 * Returns all the account entry shipping option rels.
	 *
	 * @return the account entry shipping option rels
	 */
	public java.util.List<AccountEntryShippingOptionRel> findAll();

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
	public java.util.List<AccountEntryShippingOptionRel> findAll(
		int start, int end);

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
	public java.util.List<AccountEntryShippingOptionRel> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<AccountEntryShippingOptionRel> orderByComparator);

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
	public java.util.List<AccountEntryShippingOptionRel> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<AccountEntryShippingOptionRel> orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the account entry shipping option rels from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of account entry shipping option rels.
	 *
	 * @return the number of account entry shipping option rels
	 */
	public int countAll();

}