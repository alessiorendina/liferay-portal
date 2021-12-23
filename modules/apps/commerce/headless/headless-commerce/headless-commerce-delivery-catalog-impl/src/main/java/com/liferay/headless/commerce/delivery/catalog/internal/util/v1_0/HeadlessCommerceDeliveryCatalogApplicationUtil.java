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

package com.liferay.headless.commerce.delivery.catalog.internal.util.v1_0;

import com.liferay.commerce.account.exception.NoSuchAccountException;
import com.liferay.commerce.account.model.CommerceAccount;
import com.liferay.commerce.account.service.CommerceAccountLocalService;
import com.liferay.commerce.account.util.CommerceAccountHelper;

/**
 * @author Alessio Antonio Rendina
 */
public class HeadlessCommerceDeliveryCatalogApplicationUtil {

	public static Long getCommerceAccountId(
			Long accountId, CommerceAccountHelper commerceAccountHelper,
			CommerceAccountLocalService commerceAccountLocalService,
			long commerceChannelGroupId, long companyId, long userId)
		throws Exception {

		int countUserCommerceAccounts =
			commerceAccountHelper.countUserCommerceAccounts(
				userId, commerceChannelGroupId);

		if (countUserCommerceAccounts > 1) {
			if (accountId == null) {
				throw new NoSuchAccountException();
			}
		}
		else {
			long[] commerceAccountIds =
				commerceAccountHelper.getUserCommerceAccountIds(
					userId, commerceChannelGroupId);

			if (commerceAccountIds.length == 0) {
				CommerceAccount commerceAccount =
					commerceAccountLocalService.getGuestCommerceAccount(
						companyId);

				commerceAccountIds = new long[] {
					commerceAccount.getCommerceAccountId()
				};
			}

			return commerceAccountIds[0];
		}

		return accountId;
	}

}