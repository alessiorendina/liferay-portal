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

package com.liferay.commerce.shipping.engine.fixed.service.persistence.impl;

import com.liferay.commerce.shipping.engine.fixed.exception.NoSuchAccountEntryShippingOptionRelException;
import com.liferay.commerce.shipping.engine.fixed.model.AccountEntryShippingOptionRel;
import com.liferay.commerce.shipping.engine.fixed.model.AccountEntryShippingOptionRelTable;
import com.liferay.commerce.shipping.engine.fixed.model.impl.AccountEntryShippingOptionRelImpl;
import com.liferay.commerce.shipping.engine.fixed.model.impl.AccountEntryShippingOptionRelModelImpl;
import com.liferay.commerce.shipping.engine.fixed.service.persistence.AccountEntryShippingOptionRelPersistence;
import com.liferay.commerce.shipping.engine.fixed.service.persistence.AccountEntryShippingOptionRelUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.security.auth.CompanyThreadLocal;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.spring.extender.service.ServiceReference;

import java.io.Serializable;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * The persistence implementation for the account entry shipping option rel service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Alessio Antonio Rendina
 * @generated
 */
public class AccountEntryShippingOptionRelPersistenceImpl
	extends BasePersistenceImpl<AccountEntryShippingOptionRel>
	implements AccountEntryShippingOptionRelPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>AccountEntryShippingOptionRelUtil</code> to access the account entry shipping option rel persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		AccountEntryShippingOptionRelImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByShippingOptionKey;
	private FinderPath _finderPathWithoutPaginationFindByShippingOptionKey;
	private FinderPath _finderPathCountByShippingOptionKey;

	/**
	 * Returns all the account entry shipping option rels where shippingOptionKey = &#63;.
	 *
	 * @param shippingOptionKey the shipping option key
	 * @return the matching account entry shipping option rels
	 */
	@Override
	public List<AccountEntryShippingOptionRel> findByShippingOptionKey(
		String shippingOptionKey) {

		return findByShippingOptionKey(
			shippingOptionKey, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<AccountEntryShippingOptionRel> findByShippingOptionKey(
		String shippingOptionKey, int start, int end) {

		return findByShippingOptionKey(shippingOptionKey, start, end, null);
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
	@Override
	public List<AccountEntryShippingOptionRel> findByShippingOptionKey(
		String shippingOptionKey, int start, int end,
		OrderByComparator<AccountEntryShippingOptionRel> orderByComparator) {

		return findByShippingOptionKey(
			shippingOptionKey, start, end, orderByComparator, true);
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
	@Override
	public List<AccountEntryShippingOptionRel> findByShippingOptionKey(
		String shippingOptionKey, int start, int end,
		OrderByComparator<AccountEntryShippingOptionRel> orderByComparator,
		boolean useFinderCache) {

		shippingOptionKey = Objects.toString(shippingOptionKey, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindByShippingOptionKey;
				finderArgs = new Object[] {shippingOptionKey};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByShippingOptionKey;
			finderArgs = new Object[] {
				shippingOptionKey, start, end, orderByComparator
			};
		}

		List<AccountEntryShippingOptionRel> list = null;

		if (useFinderCache) {
			list = (List<AccountEntryShippingOptionRel>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (AccountEntryShippingOptionRel
						accountEntryShippingOptionRel : list) {

					if (!shippingOptionKey.equals(
							accountEntryShippingOptionRel.
								getShippingOptionKey())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_ACCOUNTENTRYSHIPPINGOPTIONREL_WHERE);

			boolean bindShippingOptionKey = false;

			if (shippingOptionKey.isEmpty()) {
				sb.append(_FINDER_COLUMN_SHIPPINGOPTIONKEY_SHIPPINGOPTIONKEY_3);
			}
			else {
				bindShippingOptionKey = true;

				sb.append(_FINDER_COLUMN_SHIPPINGOPTIONKEY_SHIPPINGOPTIONKEY_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(AccountEntryShippingOptionRelModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindShippingOptionKey) {
					queryPos.add(shippingOptionKey);
				}

				list = (List<AccountEntryShippingOptionRel>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first account entry shipping option rel in the ordered set where shippingOptionKey = &#63;.
	 *
	 * @param shippingOptionKey the shipping option key
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching account entry shipping option rel
	 * @throws NoSuchAccountEntryShippingOptionRelException if a matching account entry shipping option rel could not be found
	 */
	@Override
	public AccountEntryShippingOptionRel findByShippingOptionKey_First(
			String shippingOptionKey,
			OrderByComparator<AccountEntryShippingOptionRel> orderByComparator)
		throws NoSuchAccountEntryShippingOptionRelException {

		AccountEntryShippingOptionRel accountEntryShippingOptionRel =
			fetchByShippingOptionKey_First(
				shippingOptionKey, orderByComparator);

		if (accountEntryShippingOptionRel != null) {
			return accountEntryShippingOptionRel;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("shippingOptionKey=");
		sb.append(shippingOptionKey);

		sb.append("}");

		throw new NoSuchAccountEntryShippingOptionRelException(sb.toString());
	}

	/**
	 * Returns the first account entry shipping option rel in the ordered set where shippingOptionKey = &#63;.
	 *
	 * @param shippingOptionKey the shipping option key
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching account entry shipping option rel, or <code>null</code> if a matching account entry shipping option rel could not be found
	 */
	@Override
	public AccountEntryShippingOptionRel fetchByShippingOptionKey_First(
		String shippingOptionKey,
		OrderByComparator<AccountEntryShippingOptionRel> orderByComparator) {

		List<AccountEntryShippingOptionRel> list = findByShippingOptionKey(
			shippingOptionKey, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last account entry shipping option rel in the ordered set where shippingOptionKey = &#63;.
	 *
	 * @param shippingOptionKey the shipping option key
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching account entry shipping option rel
	 * @throws NoSuchAccountEntryShippingOptionRelException if a matching account entry shipping option rel could not be found
	 */
	@Override
	public AccountEntryShippingOptionRel findByShippingOptionKey_Last(
			String shippingOptionKey,
			OrderByComparator<AccountEntryShippingOptionRel> orderByComparator)
		throws NoSuchAccountEntryShippingOptionRelException {

		AccountEntryShippingOptionRel accountEntryShippingOptionRel =
			fetchByShippingOptionKey_Last(shippingOptionKey, orderByComparator);

		if (accountEntryShippingOptionRel != null) {
			return accountEntryShippingOptionRel;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("shippingOptionKey=");
		sb.append(shippingOptionKey);

		sb.append("}");

		throw new NoSuchAccountEntryShippingOptionRelException(sb.toString());
	}

	/**
	 * Returns the last account entry shipping option rel in the ordered set where shippingOptionKey = &#63;.
	 *
	 * @param shippingOptionKey the shipping option key
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching account entry shipping option rel, or <code>null</code> if a matching account entry shipping option rel could not be found
	 */
	@Override
	public AccountEntryShippingOptionRel fetchByShippingOptionKey_Last(
		String shippingOptionKey,
		OrderByComparator<AccountEntryShippingOptionRel> orderByComparator) {

		int count = countByShippingOptionKey(shippingOptionKey);

		if (count == 0) {
			return null;
		}

		List<AccountEntryShippingOptionRel> list = findByShippingOptionKey(
			shippingOptionKey, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public AccountEntryShippingOptionRel[] findByShippingOptionKey_PrevAndNext(
			long accountEntryShippingOptionRelId, String shippingOptionKey,
			OrderByComparator<AccountEntryShippingOptionRel> orderByComparator)
		throws NoSuchAccountEntryShippingOptionRelException {

		shippingOptionKey = Objects.toString(shippingOptionKey, "");

		AccountEntryShippingOptionRel accountEntryShippingOptionRel =
			findByPrimaryKey(accountEntryShippingOptionRelId);

		Session session = null;

		try {
			session = openSession();

			AccountEntryShippingOptionRel[] array =
				new AccountEntryShippingOptionRelImpl[3];

			array[0] = getByShippingOptionKey_PrevAndNext(
				session, accountEntryShippingOptionRel, shippingOptionKey,
				orderByComparator, true);

			array[1] = accountEntryShippingOptionRel;

			array[2] = getByShippingOptionKey_PrevAndNext(
				session, accountEntryShippingOptionRel, shippingOptionKey,
				orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected AccountEntryShippingOptionRel getByShippingOptionKey_PrevAndNext(
		Session session,
		AccountEntryShippingOptionRel accountEntryShippingOptionRel,
		String shippingOptionKey,
		OrderByComparator<AccountEntryShippingOptionRel> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_ACCOUNTENTRYSHIPPINGOPTIONREL_WHERE);

		boolean bindShippingOptionKey = false;

		if (shippingOptionKey.isEmpty()) {
			sb.append(_FINDER_COLUMN_SHIPPINGOPTIONKEY_SHIPPINGOPTIONKEY_3);
		}
		else {
			bindShippingOptionKey = true;

			sb.append(_FINDER_COLUMN_SHIPPINGOPTIONKEY_SHIPPINGOPTIONKEY_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(AccountEntryShippingOptionRelModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindShippingOptionKey) {
			queryPos.add(shippingOptionKey);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						accountEntryShippingOptionRel)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<AccountEntryShippingOptionRel> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the account entry shipping option rels where shippingOptionKey = &#63; from the database.
	 *
	 * @param shippingOptionKey the shipping option key
	 */
	@Override
	public void removeByShippingOptionKey(String shippingOptionKey) {
		for (AccountEntryShippingOptionRel accountEntryShippingOptionRel :
				findByShippingOptionKey(
					shippingOptionKey, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(accountEntryShippingOptionRel);
		}
	}

	/**
	 * Returns the number of account entry shipping option rels where shippingOptionKey = &#63;.
	 *
	 * @param shippingOptionKey the shipping option key
	 * @return the number of matching account entry shipping option rels
	 */
	@Override
	public int countByShippingOptionKey(String shippingOptionKey) {
		shippingOptionKey = Objects.toString(shippingOptionKey, "");

		FinderPath finderPath = _finderPathCountByShippingOptionKey;

		Object[] finderArgs = new Object[] {shippingOptionKey};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_ACCOUNTENTRYSHIPPINGOPTIONREL_WHERE);

			boolean bindShippingOptionKey = false;

			if (shippingOptionKey.isEmpty()) {
				sb.append(_FINDER_COLUMN_SHIPPINGOPTIONKEY_SHIPPINGOPTIONKEY_3);
			}
			else {
				bindShippingOptionKey = true;

				sb.append(_FINDER_COLUMN_SHIPPINGOPTIONKEY_SHIPPINGOPTIONKEY_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindShippingOptionKey) {
					queryPos.add(shippingOptionKey);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String
		_FINDER_COLUMN_SHIPPINGOPTIONKEY_SHIPPINGOPTIONKEY_2 =
			"accountEntryShippingOptionRel.shippingOptionKey = ?";

	private static final String
		_FINDER_COLUMN_SHIPPINGOPTIONKEY_SHIPPINGOPTIONKEY_3 =
			"(accountEntryShippingOptionRel.shippingOptionKey IS NULL OR accountEntryShippingOptionRel.shippingOptionKey = '')";

	private FinderPath _finderPathFetchByC_A_C;
	private FinderPath _finderPathCountByC_A_C;

	/**
	 * Returns the account entry shipping option rel where companyId = &#63; and accountEntryId = &#63; and channelId = &#63; or throws a <code>NoSuchAccountEntryShippingOptionRelException</code> if it could not be found.
	 *
	 * @param companyId the company ID
	 * @param accountEntryId the account entry ID
	 * @param channelId the channel ID
	 * @return the matching account entry shipping option rel
	 * @throws NoSuchAccountEntryShippingOptionRelException if a matching account entry shipping option rel could not be found
	 */
	@Override
	public AccountEntryShippingOptionRel findByC_A_C(
			long companyId, long accountEntryId, long channelId)
		throws NoSuchAccountEntryShippingOptionRelException {

		AccountEntryShippingOptionRel accountEntryShippingOptionRel =
			fetchByC_A_C(companyId, accountEntryId, channelId);

		if (accountEntryShippingOptionRel == null) {
			StringBundler sb = new StringBundler(8);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("companyId=");
			sb.append(companyId);

			sb.append(", accountEntryId=");
			sb.append(accountEntryId);

			sb.append(", channelId=");
			sb.append(channelId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchAccountEntryShippingOptionRelException(
				sb.toString());
		}

		return accountEntryShippingOptionRel;
	}

	/**
	 * Returns the account entry shipping option rel where companyId = &#63; and accountEntryId = &#63; and channelId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param companyId the company ID
	 * @param accountEntryId the account entry ID
	 * @param channelId the channel ID
	 * @return the matching account entry shipping option rel, or <code>null</code> if a matching account entry shipping option rel could not be found
	 */
	@Override
	public AccountEntryShippingOptionRel fetchByC_A_C(
		long companyId, long accountEntryId, long channelId) {

		return fetchByC_A_C(companyId, accountEntryId, channelId, true);
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
	@Override
	public AccountEntryShippingOptionRel fetchByC_A_C(
		long companyId, long accountEntryId, long channelId,
		boolean useFinderCache) {

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {companyId, accountEntryId, channelId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(_finderPathFetchByC_A_C, finderArgs);
		}

		if (result instanceof AccountEntryShippingOptionRel) {
			AccountEntryShippingOptionRel accountEntryShippingOptionRel =
				(AccountEntryShippingOptionRel)result;

			if ((companyId != accountEntryShippingOptionRel.getCompanyId()) ||
				(accountEntryId !=
					accountEntryShippingOptionRel.getAccountEntryId()) ||
				(channelId != accountEntryShippingOptionRel.getChannelId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(5);

			sb.append(_SQL_SELECT_ACCOUNTENTRYSHIPPINGOPTIONREL_WHERE);

			sb.append(_FINDER_COLUMN_C_A_C_COMPANYID_2);

			sb.append(_FINDER_COLUMN_C_A_C_ACCOUNTENTRYID_2);

			sb.append(_FINDER_COLUMN_C_A_C_CHANNELID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(companyId);

				queryPos.add(accountEntryId);

				queryPos.add(channelId);

				List<AccountEntryShippingOptionRel> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByC_A_C, finderArgs, list);
					}
				}
				else {
					AccountEntryShippingOptionRel
						accountEntryShippingOptionRel = list.get(0);

					result = accountEntryShippingOptionRel;

					cacheResult(accountEntryShippingOptionRel);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (AccountEntryShippingOptionRel)result;
		}
	}

	/**
	 * Removes the account entry shipping option rel where companyId = &#63; and accountEntryId = &#63; and channelId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param accountEntryId the account entry ID
	 * @param channelId the channel ID
	 * @return the account entry shipping option rel that was removed
	 */
	@Override
	public AccountEntryShippingOptionRel removeByC_A_C(
			long companyId, long accountEntryId, long channelId)
		throws NoSuchAccountEntryShippingOptionRelException {

		AccountEntryShippingOptionRel accountEntryShippingOptionRel =
			findByC_A_C(companyId, accountEntryId, channelId);

		return remove(accountEntryShippingOptionRel);
	}

	/**
	 * Returns the number of account entry shipping option rels where companyId = &#63; and accountEntryId = &#63; and channelId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param accountEntryId the account entry ID
	 * @param channelId the channel ID
	 * @return the number of matching account entry shipping option rels
	 */
	@Override
	public int countByC_A_C(
		long companyId, long accountEntryId, long channelId) {

		FinderPath finderPath = _finderPathCountByC_A_C;

		Object[] finderArgs = new Object[] {
			companyId, accountEntryId, channelId
		};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_COUNT_ACCOUNTENTRYSHIPPINGOPTIONREL_WHERE);

			sb.append(_FINDER_COLUMN_C_A_C_COMPANYID_2);

			sb.append(_FINDER_COLUMN_C_A_C_ACCOUNTENTRYID_2);

			sb.append(_FINDER_COLUMN_C_A_C_CHANNELID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(companyId);

				queryPos.add(accountEntryId);

				queryPos.add(channelId);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_C_A_C_COMPANYID_2 =
		"accountEntryShippingOptionRel.companyId = ? AND ";

	private static final String _FINDER_COLUMN_C_A_C_ACCOUNTENTRYID_2 =
		"accountEntryShippingOptionRel.accountEntryId = ? AND ";

	private static final String _FINDER_COLUMN_C_A_C_CHANNELID_2 =
		"accountEntryShippingOptionRel.channelId = ?";

	private FinderPath _finderPathFetchByC_A_C_S;
	private FinderPath _finderPathCountByC_A_C_S;

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
	@Override
	public AccountEntryShippingOptionRel findByC_A_C_S(
			long companyId, long accountEntryId, long channelId,
			String shippingOptionKey)
		throws NoSuchAccountEntryShippingOptionRelException {

		AccountEntryShippingOptionRel accountEntryShippingOptionRel =
			fetchByC_A_C_S(
				companyId, accountEntryId, channelId, shippingOptionKey);

		if (accountEntryShippingOptionRel == null) {
			StringBundler sb = new StringBundler(10);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("companyId=");
			sb.append(companyId);

			sb.append(", accountEntryId=");
			sb.append(accountEntryId);

			sb.append(", channelId=");
			sb.append(channelId);

			sb.append(", shippingOptionKey=");
			sb.append(shippingOptionKey);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchAccountEntryShippingOptionRelException(
				sb.toString());
		}

		return accountEntryShippingOptionRel;
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
	@Override
	public AccountEntryShippingOptionRel fetchByC_A_C_S(
		long companyId, long accountEntryId, long channelId,
		String shippingOptionKey) {

		return fetchByC_A_C_S(
			companyId, accountEntryId, channelId, shippingOptionKey, true);
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
	@Override
	public AccountEntryShippingOptionRel fetchByC_A_C_S(
		long companyId, long accountEntryId, long channelId,
		String shippingOptionKey, boolean useFinderCache) {

		shippingOptionKey = Objects.toString(shippingOptionKey, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {
				companyId, accountEntryId, channelId, shippingOptionKey
			};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByC_A_C_S, finderArgs);
		}

		if (result instanceof AccountEntryShippingOptionRel) {
			AccountEntryShippingOptionRel accountEntryShippingOptionRel =
				(AccountEntryShippingOptionRel)result;

			if ((companyId != accountEntryShippingOptionRel.getCompanyId()) ||
				(accountEntryId !=
					accountEntryShippingOptionRel.getAccountEntryId()) ||
				(channelId != accountEntryShippingOptionRel.getChannelId()) ||
				!Objects.equals(
					shippingOptionKey,
					accountEntryShippingOptionRel.getShippingOptionKey())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(6);

			sb.append(_SQL_SELECT_ACCOUNTENTRYSHIPPINGOPTIONREL_WHERE);

			sb.append(_FINDER_COLUMN_C_A_C_S_COMPANYID_2);

			sb.append(_FINDER_COLUMN_C_A_C_S_ACCOUNTENTRYID_2);

			sb.append(_FINDER_COLUMN_C_A_C_S_CHANNELID_2);

			boolean bindShippingOptionKey = false;

			if (shippingOptionKey.isEmpty()) {
				sb.append(_FINDER_COLUMN_C_A_C_S_SHIPPINGOPTIONKEY_3);
			}
			else {
				bindShippingOptionKey = true;

				sb.append(_FINDER_COLUMN_C_A_C_S_SHIPPINGOPTIONKEY_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(companyId);

				queryPos.add(accountEntryId);

				queryPos.add(channelId);

				if (bindShippingOptionKey) {
					queryPos.add(shippingOptionKey);
				}

				List<AccountEntryShippingOptionRel> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByC_A_C_S, finderArgs, list);
					}
				}
				else {
					AccountEntryShippingOptionRel
						accountEntryShippingOptionRel = list.get(0);

					result = accountEntryShippingOptionRel;

					cacheResult(accountEntryShippingOptionRel);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (AccountEntryShippingOptionRel)result;
		}
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
	@Override
	public AccountEntryShippingOptionRel removeByC_A_C_S(
			long companyId, long accountEntryId, long channelId,
			String shippingOptionKey)
		throws NoSuchAccountEntryShippingOptionRelException {

		AccountEntryShippingOptionRel accountEntryShippingOptionRel =
			findByC_A_C_S(
				companyId, accountEntryId, channelId, shippingOptionKey);

		return remove(accountEntryShippingOptionRel);
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
	@Override
	public int countByC_A_C_S(
		long companyId, long accountEntryId, long channelId,
		String shippingOptionKey) {

		shippingOptionKey = Objects.toString(shippingOptionKey, "");

		FinderPath finderPath = _finderPathCountByC_A_C_S;

		Object[] finderArgs = new Object[] {
			companyId, accountEntryId, channelId, shippingOptionKey
		};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(5);

			sb.append(_SQL_COUNT_ACCOUNTENTRYSHIPPINGOPTIONREL_WHERE);

			sb.append(_FINDER_COLUMN_C_A_C_S_COMPANYID_2);

			sb.append(_FINDER_COLUMN_C_A_C_S_ACCOUNTENTRYID_2);

			sb.append(_FINDER_COLUMN_C_A_C_S_CHANNELID_2);

			boolean bindShippingOptionKey = false;

			if (shippingOptionKey.isEmpty()) {
				sb.append(_FINDER_COLUMN_C_A_C_S_SHIPPINGOPTIONKEY_3);
			}
			else {
				bindShippingOptionKey = true;

				sb.append(_FINDER_COLUMN_C_A_C_S_SHIPPINGOPTIONKEY_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(companyId);

				queryPos.add(accountEntryId);

				queryPos.add(channelId);

				if (bindShippingOptionKey) {
					queryPos.add(shippingOptionKey);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_C_A_C_S_COMPANYID_2 =
		"accountEntryShippingOptionRel.companyId = ? AND ";

	private static final String _FINDER_COLUMN_C_A_C_S_ACCOUNTENTRYID_2 =
		"accountEntryShippingOptionRel.accountEntryId = ? AND ";

	private static final String _FINDER_COLUMN_C_A_C_S_CHANNELID_2 =
		"accountEntryShippingOptionRel.channelId = ? AND ";

	private static final String _FINDER_COLUMN_C_A_C_S_SHIPPINGOPTIONKEY_2 =
		"accountEntryShippingOptionRel.shippingOptionKey = ?";

	private static final String _FINDER_COLUMN_C_A_C_S_SHIPPINGOPTIONKEY_3 =
		"(accountEntryShippingOptionRel.shippingOptionKey IS NULL OR accountEntryShippingOptionRel.shippingOptionKey = '')";

	public AccountEntryShippingOptionRelPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put(
			"accountEntryShippingOptionRelId", "AccountEntryCSOptionRelId");

		setDBColumnNames(dbColumnNames);

		setModelClass(AccountEntryShippingOptionRel.class);

		setModelImplClass(AccountEntryShippingOptionRelImpl.class);
		setModelPKClass(long.class);

		setTable(AccountEntryShippingOptionRelTable.INSTANCE);
	}

	/**
	 * Caches the account entry shipping option rel in the entity cache if it is enabled.
	 *
	 * @param accountEntryShippingOptionRel the account entry shipping option rel
	 */
	@Override
	public void cacheResult(
		AccountEntryShippingOptionRel accountEntryShippingOptionRel) {

		entityCache.putResult(
			AccountEntryShippingOptionRelImpl.class,
			accountEntryShippingOptionRel.getPrimaryKey(),
			accountEntryShippingOptionRel);

		finderCache.putResult(
			_finderPathFetchByC_A_C,
			new Object[] {
				accountEntryShippingOptionRel.getCompanyId(),
				accountEntryShippingOptionRel.getAccountEntryId(),
				accountEntryShippingOptionRel.getChannelId()
			},
			accountEntryShippingOptionRel);

		finderCache.putResult(
			_finderPathFetchByC_A_C_S,
			new Object[] {
				accountEntryShippingOptionRel.getCompanyId(),
				accountEntryShippingOptionRel.getAccountEntryId(),
				accountEntryShippingOptionRel.getChannelId(),
				accountEntryShippingOptionRel.getShippingOptionKey()
			},
			accountEntryShippingOptionRel);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the account entry shipping option rels in the entity cache if it is enabled.
	 *
	 * @param accountEntryShippingOptionRels the account entry shipping option rels
	 */
	@Override
	public void cacheResult(
		List<AccountEntryShippingOptionRel> accountEntryShippingOptionRels) {

		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (accountEntryShippingOptionRels.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (AccountEntryShippingOptionRel accountEntryShippingOptionRel :
				accountEntryShippingOptionRels) {

			if (entityCache.getResult(
					AccountEntryShippingOptionRelImpl.class,
					accountEntryShippingOptionRel.getPrimaryKey()) == null) {

				cacheResult(accountEntryShippingOptionRel);
			}
		}
	}

	/**
	 * Clears the cache for all account entry shipping option rels.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(AccountEntryShippingOptionRelImpl.class);

		finderCache.clearCache(AccountEntryShippingOptionRelImpl.class);
	}

	/**
	 * Clears the cache for the account entry shipping option rel.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(
		AccountEntryShippingOptionRel accountEntryShippingOptionRel) {

		entityCache.removeResult(
			AccountEntryShippingOptionRelImpl.class,
			accountEntryShippingOptionRel);
	}

	@Override
	public void clearCache(
		List<AccountEntryShippingOptionRel> accountEntryShippingOptionRels) {

		for (AccountEntryShippingOptionRel accountEntryShippingOptionRel :
				accountEntryShippingOptionRels) {

			entityCache.removeResult(
				AccountEntryShippingOptionRelImpl.class,
				accountEntryShippingOptionRel);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(AccountEntryShippingOptionRelImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				AccountEntryShippingOptionRelImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		AccountEntryShippingOptionRelModelImpl
			accountEntryShippingOptionRelModelImpl) {

		Object[] args = new Object[] {
			accountEntryShippingOptionRelModelImpl.getCompanyId(),
			accountEntryShippingOptionRelModelImpl.getAccountEntryId(),
			accountEntryShippingOptionRelModelImpl.getChannelId()
		};

		finderCache.putResult(_finderPathCountByC_A_C, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByC_A_C, args,
			accountEntryShippingOptionRelModelImpl);

		args = new Object[] {
			accountEntryShippingOptionRelModelImpl.getCompanyId(),
			accountEntryShippingOptionRelModelImpl.getAccountEntryId(),
			accountEntryShippingOptionRelModelImpl.getChannelId(),
			accountEntryShippingOptionRelModelImpl.getShippingOptionKey()
		};

		finderCache.putResult(_finderPathCountByC_A_C_S, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByC_A_C_S, args,
			accountEntryShippingOptionRelModelImpl);
	}

	/**
	 * Creates a new account entry shipping option rel with the primary key. Does not add the account entry shipping option rel to the database.
	 *
	 * @param accountEntryShippingOptionRelId the primary key for the new account entry shipping option rel
	 * @return the new account entry shipping option rel
	 */
	@Override
	public AccountEntryShippingOptionRel create(
		long accountEntryShippingOptionRelId) {

		AccountEntryShippingOptionRel accountEntryShippingOptionRel =
			new AccountEntryShippingOptionRelImpl();

		accountEntryShippingOptionRel.setNew(true);
		accountEntryShippingOptionRel.setPrimaryKey(
			accountEntryShippingOptionRelId);

		accountEntryShippingOptionRel.setCompanyId(
			CompanyThreadLocal.getCompanyId());

		return accountEntryShippingOptionRel;
	}

	/**
	 * Removes the account entry shipping option rel with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param accountEntryShippingOptionRelId the primary key of the account entry shipping option rel
	 * @return the account entry shipping option rel that was removed
	 * @throws NoSuchAccountEntryShippingOptionRelException if a account entry shipping option rel with the primary key could not be found
	 */
	@Override
	public AccountEntryShippingOptionRel remove(
			long accountEntryShippingOptionRelId)
		throws NoSuchAccountEntryShippingOptionRelException {

		return remove((Serializable)accountEntryShippingOptionRelId);
	}

	/**
	 * Removes the account entry shipping option rel with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the account entry shipping option rel
	 * @return the account entry shipping option rel that was removed
	 * @throws NoSuchAccountEntryShippingOptionRelException if a account entry shipping option rel with the primary key could not be found
	 */
	@Override
	public AccountEntryShippingOptionRel remove(Serializable primaryKey)
		throws NoSuchAccountEntryShippingOptionRelException {

		Session session = null;

		try {
			session = openSession();

			AccountEntryShippingOptionRel accountEntryShippingOptionRel =
				(AccountEntryShippingOptionRel)session.get(
					AccountEntryShippingOptionRelImpl.class, primaryKey);

			if (accountEntryShippingOptionRel == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchAccountEntryShippingOptionRelException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(accountEntryShippingOptionRel);
		}
		catch (NoSuchAccountEntryShippingOptionRelException
					noSuchEntityException) {

			throw noSuchEntityException;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected AccountEntryShippingOptionRel removeImpl(
		AccountEntryShippingOptionRel accountEntryShippingOptionRel) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(accountEntryShippingOptionRel)) {
				accountEntryShippingOptionRel =
					(AccountEntryShippingOptionRel)session.get(
						AccountEntryShippingOptionRelImpl.class,
						accountEntryShippingOptionRel.getPrimaryKeyObj());
			}

			if (accountEntryShippingOptionRel != null) {
				session.delete(accountEntryShippingOptionRel);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (accountEntryShippingOptionRel != null) {
			clearCache(accountEntryShippingOptionRel);
		}

		return accountEntryShippingOptionRel;
	}

	@Override
	public AccountEntryShippingOptionRel updateImpl(
		AccountEntryShippingOptionRel accountEntryShippingOptionRel) {

		boolean isNew = accountEntryShippingOptionRel.isNew();

		if (!(accountEntryShippingOptionRel instanceof
				AccountEntryShippingOptionRelModelImpl)) {

			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(
					accountEntryShippingOptionRel.getClass())) {

				invocationHandler = ProxyUtil.getInvocationHandler(
					accountEntryShippingOptionRel);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in accountEntryShippingOptionRel proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom AccountEntryShippingOptionRel implementation " +
					accountEntryShippingOptionRel.getClass());
		}

		AccountEntryShippingOptionRelModelImpl
			accountEntryShippingOptionRelModelImpl =
				(AccountEntryShippingOptionRelModelImpl)
					accountEntryShippingOptionRel;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (accountEntryShippingOptionRel.getCreateDate() == null)) {
			if (serviceContext == null) {
				accountEntryShippingOptionRel.setCreateDate(date);
			}
			else {
				accountEntryShippingOptionRel.setCreateDate(
					serviceContext.getCreateDate(date));
			}
		}

		if (!accountEntryShippingOptionRelModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				accountEntryShippingOptionRel.setModifiedDate(date);
			}
			else {
				accountEntryShippingOptionRel.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(accountEntryShippingOptionRel);
			}
			else {
				accountEntryShippingOptionRel =
					(AccountEntryShippingOptionRel)session.merge(
						accountEntryShippingOptionRel);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			AccountEntryShippingOptionRelImpl.class,
			accountEntryShippingOptionRelModelImpl, false, true);

		cacheUniqueFindersCache(accountEntryShippingOptionRelModelImpl);

		if (isNew) {
			accountEntryShippingOptionRel.setNew(false);
		}

		accountEntryShippingOptionRel.resetOriginalValues();

		return accountEntryShippingOptionRel;
	}

	/**
	 * Returns the account entry shipping option rel with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the account entry shipping option rel
	 * @return the account entry shipping option rel
	 * @throws NoSuchAccountEntryShippingOptionRelException if a account entry shipping option rel with the primary key could not be found
	 */
	@Override
	public AccountEntryShippingOptionRel findByPrimaryKey(
			Serializable primaryKey)
		throws NoSuchAccountEntryShippingOptionRelException {

		AccountEntryShippingOptionRel accountEntryShippingOptionRel =
			fetchByPrimaryKey(primaryKey);

		if (accountEntryShippingOptionRel == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchAccountEntryShippingOptionRelException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return accountEntryShippingOptionRel;
	}

	/**
	 * Returns the account entry shipping option rel with the primary key or throws a <code>NoSuchAccountEntryShippingOptionRelException</code> if it could not be found.
	 *
	 * @param accountEntryShippingOptionRelId the primary key of the account entry shipping option rel
	 * @return the account entry shipping option rel
	 * @throws NoSuchAccountEntryShippingOptionRelException if a account entry shipping option rel with the primary key could not be found
	 */
	@Override
	public AccountEntryShippingOptionRel findByPrimaryKey(
			long accountEntryShippingOptionRelId)
		throws NoSuchAccountEntryShippingOptionRelException {

		return findByPrimaryKey((Serializable)accountEntryShippingOptionRelId);
	}

	/**
	 * Returns the account entry shipping option rel with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param accountEntryShippingOptionRelId the primary key of the account entry shipping option rel
	 * @return the account entry shipping option rel, or <code>null</code> if a account entry shipping option rel with the primary key could not be found
	 */
	@Override
	public AccountEntryShippingOptionRel fetchByPrimaryKey(
		long accountEntryShippingOptionRelId) {

		return fetchByPrimaryKey((Serializable)accountEntryShippingOptionRelId);
	}

	/**
	 * Returns all the account entry shipping option rels.
	 *
	 * @return the account entry shipping option rels
	 */
	@Override
	public List<AccountEntryShippingOptionRel> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<AccountEntryShippingOptionRel> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<AccountEntryShippingOptionRel> findAll(
		int start, int end,
		OrderByComparator<AccountEntryShippingOptionRel> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<AccountEntryShippingOptionRel> findAll(
		int start, int end,
		OrderByComparator<AccountEntryShippingOptionRel> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindAll;
				finderArgs = FINDER_ARGS_EMPTY;
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindAll;
			finderArgs = new Object[] {start, end, orderByComparator};
		}

		List<AccountEntryShippingOptionRel> list = null;

		if (useFinderCache) {
			list = (List<AccountEntryShippingOptionRel>)finderCache.getResult(
				finderPath, finderArgs);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_ACCOUNTENTRYSHIPPINGOPTIONREL);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_ACCOUNTENTRYSHIPPINGOPTIONREL;

				sql = sql.concat(
					AccountEntryShippingOptionRelModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<AccountEntryShippingOptionRel>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the account entry shipping option rels from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (AccountEntryShippingOptionRel accountEntryShippingOptionRel :
				findAll()) {

			remove(accountEntryShippingOptionRel);
		}
	}

	/**
	 * Returns the number of account entry shipping option rels.
	 *
	 * @return the number of account entry shipping option rels
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(
					_SQL_COUNT_ACCOUNTENTRYSHIPPINGOPTIONREL);

				count = (Long)query.uniqueResult();

				finderCache.putResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	public Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	@Override
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "AccountEntryCSOptionRelId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_ACCOUNTENTRYSHIPPINGOPTIONREL;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return AccountEntryShippingOptionRelModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the account entry shipping option rel persistence.
	 */
	public void afterPropertiesSet() {
		_valueObjectFinderCacheListThreshold = GetterUtil.getInteger(
			PropsUtil.get(PropsKeys.VALUE_OBJECT_FINDER_CACHE_LIST_THRESHOLD));

		_finderPathWithPaginationFindAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathCountAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0], new String[0], false);

		_finderPathWithPaginationFindByShippingOptionKey = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByShippingOptionKey",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"shippingOptionKey"}, true);

		_finderPathWithoutPaginationFindByShippingOptionKey = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByShippingOptionKey", new String[] {String.class.getName()},
			new String[] {"shippingOptionKey"}, true);

		_finderPathCountByShippingOptionKey = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByShippingOptionKey", new String[] {String.class.getName()},
			new String[] {"shippingOptionKey"}, false);

		_finderPathFetchByC_A_C = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByC_A_C",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName()
			},
			new String[] {"companyId", "accountEntryId", "channelId"}, true);

		_finderPathCountByC_A_C = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByC_A_C",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName()
			},
			new String[] {"companyId", "accountEntryId", "channelId"}, false);

		_finderPathFetchByC_A_C_S = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByC_A_C_S",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Long.class.getName(), String.class.getName()
			},
			new String[] {
				"companyId", "accountEntryId", "channelId", "shippingOptionKey"
			},
			true);

		_finderPathCountByC_A_C_S = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByC_A_C_S",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Long.class.getName(), String.class.getName()
			},
			new String[] {
				"companyId", "accountEntryId", "channelId", "shippingOptionKey"
			},
			false);

		_setAccountEntryShippingOptionRelUtilPersistence(this);
	}

	public void destroy() {
		_setAccountEntryShippingOptionRelUtilPersistence(null);

		entityCache.removeCache(
			AccountEntryShippingOptionRelImpl.class.getName());
	}

	private void _setAccountEntryShippingOptionRelUtilPersistence(
		AccountEntryShippingOptionRelPersistence
			accountEntryShippingOptionRelPersistence) {

		try {
			Field field =
				AccountEntryShippingOptionRelUtil.class.getDeclaredField(
					"_persistence");

			field.setAccessible(true);

			field.set(null, accountEntryShippingOptionRelPersistence);
		}
		catch (ReflectiveOperationException reflectiveOperationException) {
			throw new RuntimeException(reflectiveOperationException);
		}
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;

	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_ACCOUNTENTRYSHIPPINGOPTIONREL =
		"SELECT accountEntryShippingOptionRel FROM AccountEntryShippingOptionRel accountEntryShippingOptionRel";

	private static final String
		_SQL_SELECT_ACCOUNTENTRYSHIPPINGOPTIONREL_WHERE =
			"SELECT accountEntryShippingOptionRel FROM AccountEntryShippingOptionRel accountEntryShippingOptionRel WHERE ";

	private static final String _SQL_COUNT_ACCOUNTENTRYSHIPPINGOPTIONREL =
		"SELECT COUNT(accountEntryShippingOptionRel) FROM AccountEntryShippingOptionRel accountEntryShippingOptionRel";

	private static final String _SQL_COUNT_ACCOUNTENTRYSHIPPINGOPTIONREL_WHERE =
		"SELECT COUNT(accountEntryShippingOptionRel) FROM AccountEntryShippingOptionRel accountEntryShippingOptionRel WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS =
		"accountEntryShippingOptionRel.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No AccountEntryShippingOptionRel exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No AccountEntryShippingOptionRel exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		AccountEntryShippingOptionRelPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"accountEntryShippingOptionRelId"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}