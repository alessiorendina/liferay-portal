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
import com.liferay.portal.kernel.exception.PortalException;

import java.util.List;

/**
 * Provides the remote service utility for AccountEntryShippingOptionRel. This utility wraps
 * <code>com.liferay.commerce.shipping.engine.fixed.service.impl.AccountEntryShippingOptionRelServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Alessio Antonio Rendina
 * @see AccountEntryShippingOptionRelService
 * @generated
 */
public class AccountEntryShippingOptionRelServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.liferay.commerce.shipping.engine.fixed.service.impl.AccountEntryShippingOptionRelServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static AccountEntryShippingOptionRel
			addAccountEntryShippingOptionRel(
				long accountEntryId, long channelId, String shippingMethodKey,
				String shippingOptionKey)
		throws PortalException {

		return getService().addAccountEntryShippingOptionRel(
			accountEntryId, channelId, shippingMethodKey, shippingOptionKey);
	}

	public static void deleteAccountEntryShippingOptionRelsByShippingOptionKey(
			long accountEntryId, String shippingOptionKey)
		throws PortalException {

		getService().deleteAccountEntryShippingOptionRelsByShippingOptionKey(
			accountEntryId, shippingOptionKey);
	}

	public static AccountEntryShippingOptionRel
			fetchAccountEntryShippingOptionRel(
				long accountEntryId, long channelId, long companyId)
		throws PortalException {

		return getService().fetchAccountEntryShippingOptionRel(
			accountEntryId, channelId, companyId);
	}

	public static AccountEntryShippingOptionRel
			fetchAccountEntryShippingOptionRel(
				long accountEntryId, long channelId, long companyId,
				String shippingOptionKey)
		throws PortalException {

		return getService().fetchAccountEntryShippingOptionRel(
			accountEntryId, channelId, companyId, shippingOptionKey);
	}

	public static List<AccountEntryShippingOptionRel>
			getAccountEntryShippingOptionRelsByShippingOptionKey(
				long accountEntryId, String shippingOptionKey)
		throws PortalException {

		return getService().
			getAccountEntryShippingOptionRelsByShippingOptionKey(
				accountEntryId, shippingOptionKey);
	}

	public static List<AccountEntryShippingOptionRel>
			getAccountEntryShippingOptionRelsByShippingOptionKey(
				long accountEntryId, String shippingOptionKey, int start,
				int end)
		throws PortalException {

		return getService().
			getAccountEntryShippingOptionRelsByShippingOptionKey(
				accountEntryId, shippingOptionKey, start, end);
	}

	public static int getAccountEntryShippingOptionRelsByShippingOptionKeyCount(
			long accountEntryId, String shippingOptionKey)
		throws PortalException {

		return getService().
			getAccountEntryShippingOptionRelsByShippingOptionKeyCount(
				accountEntryId, shippingOptionKey);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
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

	public static AccountEntryShippingOptionRelService getService() {
		return _service;
	}

	private static volatile AccountEntryShippingOptionRelService _service;

}