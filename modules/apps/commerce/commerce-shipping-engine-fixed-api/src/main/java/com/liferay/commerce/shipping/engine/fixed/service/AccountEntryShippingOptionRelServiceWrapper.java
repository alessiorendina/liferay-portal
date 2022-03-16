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
 * Provides a wrapper for {@link AccountEntryShippingOptionRelService}.
 *
 * @author Alessio Antonio Rendina
 * @see AccountEntryShippingOptionRelService
 * @generated
 */
public class AccountEntryShippingOptionRelServiceWrapper
	implements AccountEntryShippingOptionRelService,
			   ServiceWrapper<AccountEntryShippingOptionRelService> {

	public AccountEntryShippingOptionRelServiceWrapper() {
		this(null);
	}

	public AccountEntryShippingOptionRelServiceWrapper(
		AccountEntryShippingOptionRelService
			accountEntryShippingOptionRelService) {

		_accountEntryShippingOptionRelService =
			accountEntryShippingOptionRelService;
	}

	@Override
	public com.liferay.commerce.shipping.engine.fixed.model.
		AccountEntryShippingOptionRel addAccountEntryShippingOptionRel(
				long accountEntryId, long channelId, String shippingMethodKey,
				String shippingOptionKey)
			throws com.liferay.portal.kernel.exception.PortalException {

		return _accountEntryShippingOptionRelService.
			addAccountEntryShippingOptionRel(
				accountEntryId, channelId, shippingMethodKey,
				shippingOptionKey);
	}

	@Override
	public void deleteAccountEntryShippingOptionRelsByShippingOptionKey(
			long accountEntryId, String shippingOptionKey)
		throws com.liferay.portal.kernel.exception.PortalException {

		_accountEntryShippingOptionRelService.
			deleteAccountEntryShippingOptionRelsByShippingOptionKey(
				accountEntryId, shippingOptionKey);
	}

	@Override
	public com.liferay.commerce.shipping.engine.fixed.model.
		AccountEntryShippingOptionRel fetchAccountEntryShippingOptionRel(
				long accountEntryId, long channelId, long companyId)
			throws com.liferay.portal.kernel.exception.PortalException {

		return _accountEntryShippingOptionRelService.
			fetchAccountEntryShippingOptionRel(
				accountEntryId, channelId, companyId);
	}

	@Override
	public com.liferay.commerce.shipping.engine.fixed.model.
		AccountEntryShippingOptionRel fetchAccountEntryShippingOptionRel(
				long accountEntryId, long channelId, long companyId,
				String shippingOptionKey)
			throws com.liferay.portal.kernel.exception.PortalException {

		return _accountEntryShippingOptionRelService.
			fetchAccountEntryShippingOptionRel(
				accountEntryId, channelId, companyId, shippingOptionKey);
	}

	@Override
	public java.util.List
		<com.liferay.commerce.shipping.engine.fixed.model.
			AccountEntryShippingOptionRel>
					getAccountEntryShippingOptionRelsByShippingOptionKey(
						long accountEntryId, String shippingOptionKey)
				throws com.liferay.portal.kernel.exception.PortalException {

		return _accountEntryShippingOptionRelService.
			getAccountEntryShippingOptionRelsByShippingOptionKey(
				accountEntryId, shippingOptionKey);
	}

	@Override
	public java.util.List
		<com.liferay.commerce.shipping.engine.fixed.model.
			AccountEntryShippingOptionRel>
					getAccountEntryShippingOptionRelsByShippingOptionKey(
						long accountEntryId, String shippingOptionKey,
						int start, int end)
				throws com.liferay.portal.kernel.exception.PortalException {

		return _accountEntryShippingOptionRelService.
			getAccountEntryShippingOptionRelsByShippingOptionKey(
				accountEntryId, shippingOptionKey, start, end);
	}

	@Override
	public int getAccountEntryShippingOptionRelsByShippingOptionKeyCount(
			long accountEntryId, String shippingOptionKey)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _accountEntryShippingOptionRelService.
			getAccountEntryShippingOptionRelsByShippingOptionKeyCount(
				accountEntryId, shippingOptionKey);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _accountEntryShippingOptionRelService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.commerce.shipping.engine.fixed.model.
		AccountEntryShippingOptionRel updateAccountEntryShippingOptionRel(
				long accountEntryShippingOptionRelId, long accountEntryId,
				long channelId, long companyId, String shippingMethodKey,
				String shippingOptionKey)
			throws com.liferay.portal.kernel.exception.PortalException {

		return _accountEntryShippingOptionRelService.
			updateAccountEntryShippingOptionRel(
				accountEntryShippingOptionRelId, accountEntryId, channelId,
				companyId, shippingMethodKey, shippingOptionKey);
	}

	@Override
	public AccountEntryShippingOptionRelService getWrappedService() {
		return _accountEntryShippingOptionRelService;
	}

	@Override
	public void setWrappedService(
		AccountEntryShippingOptionRelService
			accountEntryShippingOptionRelService) {

		_accountEntryShippingOptionRelService =
			accountEntryShippingOptionRelService;
	}

	private AccountEntryShippingOptionRelService
		_accountEntryShippingOptionRelService;

}