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

package com.liferay.commerce.notification.service.impl;

import com.liferay.commerce.notification.model.CommerceNotificationQueueEntry;
import com.liferay.commerce.notification.service.base.CommerceNotificationQueueEntryServiceBaseImpl;
import com.liferay.commerce.product.model.CommerceChannel;
import com.liferay.commerce.product.service.CommerceChannelLocalService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.security.permission.ActionKeys;
import com.liferay.portal.kernel.security.permission.resource.ModelResourcePermission;
import com.liferay.portal.kernel.security.permission.resource.ModelResourcePermissionFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.spring.extender.service.ServiceReference;

import java.util.List;

/**
 * @author Alessio Antonio Rendina
 */
public class CommerceNotificationQueueEntryServiceImpl
	extends CommerceNotificationQueueEntryServiceBaseImpl {

	@Override
	public void deleteCommerceNotificationQueueEntry(
			long commerceNotificationQueueEntryId)
		throws PortalException {

		CommerceNotificationQueueEntry commerceNotificationQueueEntry =
			commerceNotificationQueueEntryLocalService.
				getCommerceNotificationQueueEntry(
					commerceNotificationQueueEntryId);

		CommerceChannel commerceChannel =
			_commerceChannelLocalService.getCommerceChannelByGroupId(
				commerceNotificationQueueEntry.getGroupId());

		_commerceChannelModelResourcePermission.check(
			getPermissionChecker(), commerceChannel, ActionKeys.UPDATE);

		commerceNotificationQueueEntryLocalService.
			deleteCommerceNotificationQueue(commerceNotificationQueueEntry);
	}

	@Override
	public List<CommerceNotificationQueueEntry>
			getCommerceNotificationQueueEntries(
				long groupId, int start, int end,
				OrderByComparator<CommerceNotificationQueueEntry>
					orderByComparator)
		throws PortalException {

		CommerceChannel commerceChannel =
			_commerceChannelLocalService.getCommerceChannelByGroupId(groupId);

		_commerceChannelModelResourcePermission.check(
			getPermissionChecker(), commerceChannel, ActionKeys.UPDATE);

		return commerceNotificationQueueEntryLocalService.
			getCommerceNotificationQueueEntries(
				groupId, start, end, orderByComparator);
	}

	@Override
	public int getCommerceNotificationQueueEntriesCount(long groupId)
		throws PortalException {

		CommerceChannel commerceChannel =
			_commerceChannelLocalService.getCommerceChannelByGroupId(groupId);

		_commerceChannelModelResourcePermission.check(
			getPermissionChecker(), commerceChannel, ActionKeys.UPDATE);

		return commerceNotificationQueueEntryLocalService.
			getCommerceNotificationQueueEntriesCount(groupId);
	}

	@Override
	public CommerceNotificationQueueEntry resendCommerceNotificationQueueEntry(
			long commerceNotificationQueueEntryId)
		throws PortalException {

		CommerceNotificationQueueEntry commerceNotificationQueueEntry =
			commerceNotificationQueueEntryLocalService.
				getCommerceNotificationQueueEntry(
					commerceNotificationQueueEntryId);

		CommerceChannel commerceChannel =
			_commerceChannelLocalService.getCommerceChannelByGroupId(
				commerceNotificationQueueEntry.getGroupId());

		_commerceChannelModelResourcePermission.check(
			getPermissionChecker(), commerceChannel, ActionKeys.UPDATE);

		return commerceNotificationQueueEntryLocalService.
			resendCommerceNotificationQueueEntry(
				commerceNotificationQueueEntryId);
	}

	private static volatile ModelResourcePermission<CommerceChannel>
		_commerceChannelModelResourcePermission =
			ModelResourcePermissionFactory.getInstance(
				CommerceNotificationQueueEntryServiceImpl.class,
				"_commerceChannelModelResourcePermission",
				CommerceChannel.class);

	@ServiceReference(type = CommerceChannelLocalService.class)
	private CommerceChannelLocalService _commerceChannelLocalService;

}