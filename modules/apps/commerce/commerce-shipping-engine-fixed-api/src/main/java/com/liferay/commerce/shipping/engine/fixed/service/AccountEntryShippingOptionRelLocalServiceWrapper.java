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

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link AccountEntryShippingOptionRelLocalService}.
 *
 * @author Alessio Antonio Rendina
 * @see AccountEntryShippingOptionRelLocalService
 * @generated
 */
public class AccountEntryShippingOptionRelLocalServiceWrapper
	implements AccountEntryShippingOptionRelLocalService,
			   ServiceWrapper<AccountEntryShippingOptionRelLocalService> {

	public AccountEntryShippingOptionRelLocalServiceWrapper() {
		this(null);
	}

	public AccountEntryShippingOptionRelLocalServiceWrapper(
		AccountEntryShippingOptionRelLocalService
			accountEntryShippingOptionRelLocalService) {

		_accountEntryShippingOptionRelLocalService =
			accountEntryShippingOptionRelLocalService;
	}

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
	@Override
	public com.liferay.commerce.shipping.engine.fixed.model.
		AccountEntryShippingOptionRel addAccountEntryShippingOptionRel(
			com.liferay.commerce.shipping.engine.fixed.model.
				AccountEntryShippingOptionRel accountEntryShippingOptionRel) {

		return _accountEntryShippingOptionRelLocalService.
			addAccountEntryShippingOptionRel(accountEntryShippingOptionRel);
	}

	@Override
	public com.liferay.commerce.shipping.engine.fixed.model.
		AccountEntryShippingOptionRel addAccountEntryShippingOptionRel(
				long accountEntryId, long channelId, String shippingMethodKey,
				String shippingOptionKey, long userId)
			throws com.liferay.portal.kernel.exception.PortalException {

		return _accountEntryShippingOptionRelLocalService.
			addAccountEntryShippingOptionRel(
				accountEntryId, channelId, shippingMethodKey, shippingOptionKey,
				userId);
	}

	/**
	 * Creates a new account entry shipping option rel with the primary key. Does not add the account entry shipping option rel to the database.
	 *
	 * @param accountEntryShippingOptionRelId the primary key for the new account entry shipping option rel
	 * @return the new account entry shipping option rel
	 */
	@Override
	public com.liferay.commerce.shipping.engine.fixed.model.
		AccountEntryShippingOptionRel createAccountEntryShippingOptionRel(
			long accountEntryShippingOptionRelId) {

		return _accountEntryShippingOptionRelLocalService.
			createAccountEntryShippingOptionRel(
				accountEntryShippingOptionRelId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _accountEntryShippingOptionRelLocalService.createPersistedModel(
			primaryKeyObj);
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
	@Override
	public com.liferay.commerce.shipping.engine.fixed.model.
		AccountEntryShippingOptionRel deleteAccountEntryShippingOptionRel(
			com.liferay.commerce.shipping.engine.fixed.model.
				AccountEntryShippingOptionRel accountEntryShippingOptionRel) {

		return _accountEntryShippingOptionRelLocalService.
			deleteAccountEntryShippingOptionRel(accountEntryShippingOptionRel);
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
	@Override
	public com.liferay.commerce.shipping.engine.fixed.model.
		AccountEntryShippingOptionRel deleteAccountEntryShippingOptionRel(
				long accountEntryShippingOptionRelId)
			throws com.liferay.portal.kernel.exception.PortalException {

		return _accountEntryShippingOptionRelLocalService.
			deleteAccountEntryShippingOptionRel(
				accountEntryShippingOptionRelId);
	}

	@Override
	public void deleteAccountEntryShippingOptionRelsByShippingOptionKey(
		String shippingOptionKey) {

		_accountEntryShippingOptionRelLocalService.
			deleteAccountEntryShippingOptionRelsByShippingOptionKey(
				shippingOptionKey);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _accountEntryShippingOptionRelLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _accountEntryShippingOptionRelLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _accountEntryShippingOptionRelLocalService.dslQueryCount(
			dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _accountEntryShippingOptionRelLocalService.dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _accountEntryShippingOptionRelLocalService.dynamicQuery(
			dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _accountEntryShippingOptionRelLocalService.dynamicQuery(
			dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _accountEntryShippingOptionRelLocalService.dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _accountEntryShippingOptionRelLocalService.dynamicQueryCount(
			dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return _accountEntryShippingOptionRelLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.liferay.commerce.shipping.engine.fixed.model.
		AccountEntryShippingOptionRel fetchAccountEntryShippingOptionRel(
			long accountEntryShippingOptionRelId) {

		return _accountEntryShippingOptionRelLocalService.
			fetchAccountEntryShippingOptionRel(accountEntryShippingOptionRelId);
	}

	@Override
	public com.liferay.commerce.shipping.engine.fixed.model.
		AccountEntryShippingOptionRel fetchAccountEntryShippingOptionRel(
			long accountEntryId, long channelId, long companyId) {

		return _accountEntryShippingOptionRelLocalService.
			fetchAccountEntryShippingOptionRel(
				accountEntryId, channelId, companyId);
	}

	@Override
	public com.liferay.commerce.shipping.engine.fixed.model.
		AccountEntryShippingOptionRel fetchAccountEntryShippingOptionRel(
			long accountEntryId, long channelId, long companyId,
			String shippingOptionKey) {

		return _accountEntryShippingOptionRelLocalService.
			fetchAccountEntryShippingOptionRel(
				accountEntryId, channelId, companyId, shippingOptionKey);
	}

	/**
	 * Returns the account entry shipping option rel with the primary key.
	 *
	 * @param accountEntryShippingOptionRelId the primary key of the account entry shipping option rel
	 * @return the account entry shipping option rel
	 * @throws PortalException if a account entry shipping option rel with the primary key could not be found
	 */
	@Override
	public com.liferay.commerce.shipping.engine.fixed.model.
		AccountEntryShippingOptionRel getAccountEntryShippingOptionRel(
				long accountEntryShippingOptionRelId)
			throws com.liferay.portal.kernel.exception.PortalException {

		return _accountEntryShippingOptionRelLocalService.
			getAccountEntryShippingOptionRel(accountEntryShippingOptionRelId);
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
	@Override
	public java.util.List
		<com.liferay.commerce.shipping.engine.fixed.model.
			AccountEntryShippingOptionRel> getAccountEntryShippingOptionRels(
				int start, int end) {

		return _accountEntryShippingOptionRelLocalService.
			getAccountEntryShippingOptionRels(start, end);
	}

	@Override
	public java.util.List
		<com.liferay.commerce.shipping.engine.fixed.model.
			AccountEntryShippingOptionRel>
				getAccountEntryShippingOptionRelsByShippingOptionKey(
					String shippingOptionKey) {

		return _accountEntryShippingOptionRelLocalService.
			getAccountEntryShippingOptionRelsByShippingOptionKey(
				shippingOptionKey);
	}

	@Override
	public java.util.List
		<com.liferay.commerce.shipping.engine.fixed.model.
			AccountEntryShippingOptionRel>
				getAccountEntryShippingOptionRelsByShippingOptionKey(
					String shippingOptionKey, int start, int end) {

		return _accountEntryShippingOptionRelLocalService.
			getAccountEntryShippingOptionRelsByShippingOptionKey(
				shippingOptionKey, start, end);
	}

	@Override
	public int getAccountEntryShippingOptionRelsByShippingOptionKeyCount(
		String shippingOptionKey) {

		return _accountEntryShippingOptionRelLocalService.
			getAccountEntryShippingOptionRelsByShippingOptionKeyCount(
				shippingOptionKey);
	}

	/**
	 * Returns the number of account entry shipping option rels.
	 *
	 * @return the number of account entry shipping option rels
	 */
	@Override
	public int getAccountEntryShippingOptionRelsCount() {
		return _accountEntryShippingOptionRelLocalService.
			getAccountEntryShippingOptionRelsCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _accountEntryShippingOptionRelLocalService.
			getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _accountEntryShippingOptionRelLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _accountEntryShippingOptionRelLocalService.
			getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _accountEntryShippingOptionRelLocalService.getPersistedModel(
			primaryKeyObj);
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
	@Override
	public com.liferay.commerce.shipping.engine.fixed.model.
		AccountEntryShippingOptionRel updateAccountEntryShippingOptionRel(
			com.liferay.commerce.shipping.engine.fixed.model.
				AccountEntryShippingOptionRel accountEntryShippingOptionRel) {

		return _accountEntryShippingOptionRelLocalService.
			updateAccountEntryShippingOptionRel(accountEntryShippingOptionRel);
	}

	@Override
	public com.liferay.commerce.shipping.engine.fixed.model.
		AccountEntryShippingOptionRel updateAccountEntryShippingOptionRel(
				long accountEntryShippingOptionRelId, long accountEntryId,
				long channelId, long companyId, String shippingMethodKey,
				String shippingOptionKey)
			throws com.liferay.portal.kernel.exception.PortalException {

		return _accountEntryShippingOptionRelLocalService.
			updateAccountEntryShippingOptionRel(
				accountEntryShippingOptionRelId, accountEntryId, channelId,
				companyId, shippingMethodKey, shippingOptionKey);
	}

	@Override
	public AccountEntryShippingOptionRelLocalService getWrappedService() {
		return _accountEntryShippingOptionRelLocalService;
	}

	@Override
	public void setWrappedService(
		AccountEntryShippingOptionRelLocalService
			accountEntryShippingOptionRelLocalService) {

		_accountEntryShippingOptionRelLocalService =
			accountEntryShippingOptionRelLocalService;
	}

	private AccountEntryShippingOptionRelLocalService
		_accountEntryShippingOptionRelLocalService;

}