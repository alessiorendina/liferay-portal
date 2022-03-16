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

package com.liferay.commerce.shipping.engine.fixed.service;

import com.liferay.commerce.shipping.engine.fixed.model.AccountEntryShippingOptionRel;
import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for AccountEntryShippingOptionRel. This utility wraps
 * <code>com.liferay.commerce.shipping.engine.fixed.service.impl.AccountEntryShippingOptionRelLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Alessio Antonio Rendina
 * @see AccountEntryShippingOptionRelLocalService
 * @generated
 */
public class AccountEntryShippingOptionRelLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.liferay.commerce.shipping.engine.fixed.service.impl.AccountEntryShippingOptionRelLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the account entry shipping option rel to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AccountEntryShippingOptionRelLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param accountEntryShippingOptionRel the account entry shipping option rel
	 * @return the account entry shipping option rel that was added
	 */
	public static AccountEntryShippingOptionRel
		addAccountEntryShippingOptionRel(
			AccountEntryShippingOptionRel accountEntryShippingOptionRel) {

		return getService().addAccountEntryShippingOptionRel(
			accountEntryShippingOptionRel);
	}

	public static AccountEntryShippingOptionRel
			addAccountEntryShippingOptionRel(
				long accountEntryId, long channelId, String shippingMethodKey,
				String shippingOptionKey, long userId)
		throws PortalException {

		return getService().addAccountEntryShippingOptionRel(
			accountEntryId, channelId, shippingMethodKey, shippingOptionKey,
			userId);
	}

	/**
	 * Creates a new account entry shipping option rel with the primary key. Does not add the account entry shipping option rel to the database.
	 *
	 * @param accountEntryShippingOptionRelId the primary key for the new account entry shipping option rel
	 * @return the new account entry shipping option rel
	 */
	public static AccountEntryShippingOptionRel
		createAccountEntryShippingOptionRel(
			long accountEntryShippingOptionRelId) {

		return getService().createAccountEntryShippingOptionRel(
			accountEntryShippingOptionRelId);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel createPersistedModel(
			Serializable primaryKeyObj)
		throws PortalException {

		return getService().createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the account entry shipping option rel from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AccountEntryShippingOptionRelLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param accountEntryShippingOptionRel the account entry shipping option rel
	 * @return the account entry shipping option rel that was removed
	 */
	public static AccountEntryShippingOptionRel
		deleteAccountEntryShippingOptionRel(
			AccountEntryShippingOptionRel accountEntryShippingOptionRel) {

		return getService().deleteAccountEntryShippingOptionRel(
			accountEntryShippingOptionRel);
	}

	/**
	 * Deletes the account entry shipping option rel with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AccountEntryShippingOptionRelLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param accountEntryShippingOptionRelId the primary key of the account entry shipping option rel
	 * @return the account entry shipping option rel that was removed
	 * @throws PortalException if a account entry shipping option rel with the primary key could not be found
	 */
	public static AccountEntryShippingOptionRel
			deleteAccountEntryShippingOptionRel(
				long accountEntryShippingOptionRelId)
		throws PortalException {

		return getService().deleteAccountEntryShippingOptionRel(
			accountEntryShippingOptionRelId);
	}

	public static void deleteAccountEntryShippingOptionRelsByShippingOptionKey(
		String shippingOptionKey) {

		getService().deleteAccountEntryShippingOptionRelsByShippingOptionKey(
			shippingOptionKey);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel deletePersistedModel(
			PersistedModel persistedModel)
		throws PortalException {

		return getService().deletePersistedModel(persistedModel);
	}

	public static <T> T dslQuery(DSLQuery dslQuery) {
		return getService().dslQuery(dslQuery);
	}

	public static int dslQueryCount(DSLQuery dslQuery) {
		return getService().dslQueryCount(dslQuery);
	}

	public static DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	public static <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.commerce.shipping.engine.fixed.model.impl.AccountEntryShippingOptionRelModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	public static <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.commerce.shipping.engine.fixed.model.impl.AccountEntryShippingOptionRelModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	public static <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator) {

		return getService().dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(DynamicQuery dynamicQuery) {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static AccountEntryShippingOptionRel
		fetchAccountEntryShippingOptionRel(
			long accountEntryShippingOptionRelId) {

		return getService().fetchAccountEntryShippingOptionRel(
			accountEntryShippingOptionRelId);
	}

	public static AccountEntryShippingOptionRel
		fetchAccountEntryShippingOptionRel(
			long accountEntryId, long channelId, long companyId) {

		return getService().fetchAccountEntryShippingOptionRel(
			accountEntryId, channelId, companyId);
	}

	public static AccountEntryShippingOptionRel
		fetchAccountEntryShippingOptionRel(
			long accountEntryId, long channelId, long companyId,
			String shippingOptionKey) {

		return getService().fetchAccountEntryShippingOptionRel(
			accountEntryId, channelId, companyId, shippingOptionKey);
	}

	/**
	 * Returns the account entry shipping option rel with the primary key.
	 *
	 * @param accountEntryShippingOptionRelId the primary key of the account entry shipping option rel
	 * @return the account entry shipping option rel
	 * @throws PortalException if a account entry shipping option rel with the primary key could not be found
	 */
	public static AccountEntryShippingOptionRel
			getAccountEntryShippingOptionRel(
				long accountEntryShippingOptionRelId)
		throws PortalException {

		return getService().getAccountEntryShippingOptionRel(
			accountEntryShippingOptionRelId);
	}

	/**
	 * Returns a range of all the account entry shipping option rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.commerce.shipping.engine.fixed.model.impl.AccountEntryShippingOptionRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of account entry shipping option rels
	 * @param end the upper bound of the range of account entry shipping option rels (not inclusive)
	 * @return the range of account entry shipping option rels
	 */
	public static List<AccountEntryShippingOptionRel>
		getAccountEntryShippingOptionRels(int start, int end) {

		return getService().getAccountEntryShippingOptionRels(start, end);
	}

	public static List<AccountEntryShippingOptionRel>
		getAccountEntryShippingOptionRelsByShippingOptionKey(
			String shippingOptionKey) {

		return getService().
			getAccountEntryShippingOptionRelsByShippingOptionKey(
				shippingOptionKey);
	}

	public static List<AccountEntryShippingOptionRel>
		getAccountEntryShippingOptionRelsByShippingOptionKey(
			String shippingOptionKey, int start, int end) {

		return getService().
			getAccountEntryShippingOptionRelsByShippingOptionKey(
				shippingOptionKey, start, end);
	}

	public static int getAccountEntryShippingOptionRelsByShippingOptionKeyCount(
		String shippingOptionKey) {

		return getService().
			getAccountEntryShippingOptionRelsByShippingOptionKeyCount(
				shippingOptionKey);
	}

	/**
	 * Returns the number of account entry shipping option rels.
	 *
	 * @return the number of account entry shipping option rels
	 */
	public static int getAccountEntryShippingOptionRelsCount() {
		return getService().getAccountEntryShippingOptionRelsCount();
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the account entry shipping option rel in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AccountEntryShippingOptionRelLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param accountEntryShippingOptionRel the account entry shipping option rel
	 * @return the account entry shipping option rel that was updated
	 */
	public static AccountEntryShippingOptionRel
		updateAccountEntryShippingOptionRel(
			AccountEntryShippingOptionRel accountEntryShippingOptionRel) {

		return getService().updateAccountEntryShippingOptionRel(
			accountEntryShippingOptionRel);
	}

	public static AccountEntryShippingOptionRel
			updateAccountEntryShippingOptionRel(
				long accountEntryShippingOptionRelId, long accountEntryId,
				long channelId, long companyId, String shippingMethodKey,
				String shippingOptionKey)
		throws PortalException {

		return getService().updateAccountEntryShippingOptionRel(
			accountEntryShippingOptionRelId, accountEntryId, channelId,
			companyId, shippingMethodKey, shippingOptionKey);
	}

	public static AccountEntryShippingOptionRelLocalService getService() {
		return _service;
	}

	private static volatile AccountEntryShippingOptionRelLocalService _service;

}