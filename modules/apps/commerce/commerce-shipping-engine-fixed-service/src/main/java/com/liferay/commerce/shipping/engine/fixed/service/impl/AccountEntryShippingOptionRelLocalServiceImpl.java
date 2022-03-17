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

import com.liferay.commerce.shipping.engine.fixed.model.AccountEntryShippingOptionRel;
import com.liferay.commerce.shipping.engine.fixed.service.base.AccountEntryShippingOptionRelLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.User;

import java.util.List;

/**
 * @author Alessio Antonio Rendina
 */
public class AccountEntryShippingOptionRelLocalServiceImpl
	extends AccountEntryShippingOptionRelLocalServiceBaseImpl {

	@Override
	public AccountEntryShippingOptionRel addAccountEntryShippingOptionRel(
			long accountEntryId, long channelId, String shippingMethodKey,
			String shippingOptionKey, long userId)
		throws PortalException {

		User user = userLocalService.getUser(userId);

		long accountEntryShippingOptionRelId = counterLocalService.increment();

		AccountEntryShippingOptionRel accountEntryShippingOptionRel =
			accountEntryShippingOptionRelPersistence.create(
				accountEntryShippingOptionRelId);

		accountEntryShippingOptionRel.setCompanyId(user.getCompanyId());
		accountEntryShippingOptionRel.setUserId(user.getUserId());
		accountEntryShippingOptionRel.setUserName(user.getFullName());

		accountEntryShippingOptionRel.setAccountEntryId(accountEntryId);
		accountEntryShippingOptionRel.setChannelId(channelId);
		accountEntryShippingOptionRel.setShippingMethodKey(shippingMethodKey);
		accountEntryShippingOptionRel.setShippingOptionKey(shippingOptionKey);

		return accountEntryShippingOptionRelPersistence.update(
			accountEntryShippingOptionRel);
	}

	@Override
	public void deleteAccountEntryShippingOptionRelsByShippingOptionKey(
		String shippingOptionKey) {

		accountEntryShippingOptionRelPersistence.removeByShippingOptionKey(
			shippingOptionKey);
	}

	@Override
	public AccountEntryShippingOptionRel fetchAccountEntryShippingOptionRel(
		long accountEntryId, long channelId, long companyId) {

		return accountEntryShippingOptionRelPersistence.fetchByC_A_C(
			companyId, accountEntryId, channelId);
	}

	@Override
	public AccountEntryShippingOptionRel fetchAccountEntryShippingOptionRel(
		long accountEntryId, long channelId, long companyId,
		String shippingOptionKey) {

		return accountEntryShippingOptionRelPersistence.fetchByC_A_C_S(
			companyId, accountEntryId, channelId, shippingOptionKey);
	}

	@Override
	public List<AccountEntryShippingOptionRel>
		getAccountEntryShippingOptionRelsByShippingOptionKey(
			String shippingOptionKey) {

		return accountEntryShippingOptionRelPersistence.findByShippingOptionKey(
			shippingOptionKey);
	}

	@Override
	public List<AccountEntryShippingOptionRel>
		getAccountEntryShippingOptionRelsByShippingOptionKey(
			String shippingOptionKey, int start, int end) {

		return accountEntryShippingOptionRelPersistence.findByShippingOptionKey(
			shippingOptionKey, start, end);
	}

	@Override
	public int getAccountEntryShippingOptionRelsByShippingOptionKeyCount(
		String shippingOptionKey) {

		return accountEntryShippingOptionRelPersistence.
			countByShippingOptionKey(shippingOptionKey);
	}

	@Override
	public AccountEntryShippingOptionRel updateAccountEntryShippingOptionRel(
			long accountEntryShippingOptionRelId, long accountEntryId,
			long channelId, long companyId, String shippingMethodKey,
			String shippingOptionKey)
		throws PortalException {

		AccountEntryShippingOptionRel accountEntryShippingOptionRel =
			accountEntryShippingOptionRelPersistence.findByC_A_C(
				companyId, accountEntryId, channelId);

		accountEntryShippingOptionRel.setAccountEntryId(accountEntryId);
		accountEntryShippingOptionRel.setChannelId(channelId);
		accountEntryShippingOptionRel.setShippingMethodKey(shippingMethodKey);
		accountEntryShippingOptionRel.setShippingOptionKey(shippingOptionKey);

		return accountEntryShippingOptionRelPersistence.update(
			accountEntryShippingOptionRel);
	}

}