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

package com.liferay.commerce.shipping.engine.fixed.service.impl;

import com.liferay.account.model.AccountEntry;
import com.liferay.commerce.shipping.engine.fixed.model.AccountEntryShippingOptionRel;
import com.liferay.commerce.shipping.engine.fixed.service.base.AccountEntryShippingOptionRelServiceBaseImpl;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.security.permission.ActionKeys;
import com.liferay.portal.kernel.security.permission.resource.ModelResourcePermission;
import com.liferay.portal.kernel.security.permission.resource.ModelResourcePermissionFactory;

import java.util.List;

/**
 * @author Alessio Antonio Rendina
 */
public class AccountEntryShippingOptionRelServiceImpl
	extends AccountEntryShippingOptionRelServiceBaseImpl {

	@Override
	public AccountEntryShippingOptionRel addAccountEntryShippingOptionRel(
		long accountEntryId, long channelId, String shippingMethodKey,
		String shippingOptionKey)
		throws PortalException {

		_checkAccountEntry(accountEntryId);

		return accountEntryShippingOptionRelLocalService.
			addAccountEntryShippingOptionRel(
				getUserId(), accountEntryId, shippingOptionKey,
				shippingMethodKey, channelId);
	}

	@Override
	public void deleteAccountEntryShippingOptionRelsByShippingOptionKey(
			long accountEntryId, String shippingOptionKey)
		throws PortalException {

		_checkAccountEntry(accountEntryId);

		accountEntryShippingOptionRelLocalService.
			deleteAccountEntryShippingOptionRelsByShippingOptionKey(
				shippingOptionKey);
	}

	@Override
	public AccountEntryShippingOptionRel fetchAccountEntryShippingOptionRel(
			long accountEntryId, long channelId, long companyId)
		throws PortalException {

		_checkAccountEntry(accountEntryId);

		return accountEntryShippingOptionRelLocalService.
			fetchAccountEntryShippingOptionRel(
				accountEntryId, channelId, companyId);
	}

	@Override
	public AccountEntryShippingOptionRel fetchAccountEntryShippingOptionRel(
			long accountEntryId, long channelId, long companyId,
			String shippingOptionKey)
		throws PortalException {

		_checkAccountEntry(accountEntryId);

		return accountEntryShippingOptionRelLocalService.fetchAccountEntryShippingOptionRel(
			companyId, accountEntryId, channelId, shippingOptionKey);
	}

	@Override
	public List<AccountEntryShippingOptionRel>
			getAccountEntryShippingOptionRelsByShippingOptionKey(
				long accountEntryId, String shippingOptionKey)
		throws PortalException {

		_checkAccountEntry(accountEntryId);

		return accountEntryShippingOptionRelLocalService.
			getAccountEntryShippingOptionRelsByShippingOptionKey(
				shippingOptionKey);
	}

	@Override
	public List<AccountEntryShippingOptionRel>
			getAccountEntryShippingOptionRelsByShippingOptionKey(
				long accountEntryId, String shippingOptionKey, int start,
				int end)
		throws PortalException {

		_checkAccountEntry(accountEntryId);

		return accountEntryShippingOptionRelLocalService.
			getAccountEntryShippingOptionRelsByShippingOptionKey(
				shippingOptionKey, start, end);
	}

	@Override
	public int getAccountEntryShippingOptionRelsByShippingOptionKeyCount(
			long accountEntryId, String shippingOptionKey)
		throws PortalException {

		_checkAccountEntry(accountEntryId);

		return accountEntryShippingOptionRelLocalService.
			getAccountEntryShippingOptionRelsByShippingOptionKeyCount(
				shippingOptionKey);
	}

	@Override
	public AccountEntryShippingOptionRel updateAccountEntryShippingOptionRel(
		long accountEntryShippingOptionRelId, long accountEntryId, long channelId, long companyId,
		String shippingMethodKey, String shippingOptionKey)
		throws PortalException {

		_checkAccountEntry(accountEntryId);

		return accountEntryShippingOptionRelLocalService.
			updateAccountEntryShippingOptionRel(
		accountEntryShippingOptionRelId,  accountEntryId,  channelId,  companyId,
		 shippingMethodKey,  shippingOptionKey);
	}

	private void _checkAccountEntry(long accountEntryId)
		throws PortalException {

		_accountEntryModelResourcePermission.check(
			getPermissionChecker(), accountEntryId, ActionKeys.UPDATE);
	}

	private static volatile ModelResourcePermission<AccountEntry>
		_accountEntryModelResourcePermission =
			ModelResourcePermissionFactory.getInstance(
				AccountEntryShippingOptionRelServiceImpl.class,
				"_accountEntryModelResourcePermission", AccountEntry.class);

}