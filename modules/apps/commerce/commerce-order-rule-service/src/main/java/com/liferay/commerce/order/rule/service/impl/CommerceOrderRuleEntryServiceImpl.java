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

package com.liferay.commerce.order.rule.service.impl;

import com.liferay.commerce.order.rule.model.CommerceOrderRuleEntry;
import com.liferay.commerce.order.rule.service.base.CommerceOrderRuleEntryServiceBaseImpl;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.service.ServiceContext;

import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * @author Luca Pellizzon
 */
@Component(
	enabled = false,
	property = {
		"json.web.service.context.name=commerce",
		"json.web.service.context.path=CommerceOrderRuleEntry"
	},
	service = AopService.class
)
public class CommerceOrderRuleEntryServiceImpl
	extends CommerceOrderRuleEntryServiceBaseImpl {

	@Override
	public CommerceOrderRuleEntry addCommerceOrderRuleEntry(
			boolean active, String description, String name, int priority,
			String type, String typeSettings, ServiceContext serviceContext)
		throws PortalException {

		return commerceOrderRuleEntryLocalService.addCommerceOrderRuleEntry(
			active, description, name, priority, type, typeSettings,
			serviceContext);
	}

	@Override
	public CommerceOrderRuleEntry deleteCommerceOrderRuleEntry(
			long commerceOrderRuleEntryId)
		throws PortalException {

		return commerceOrderRuleEntryLocalService.deleteCommerceOrderRuleEntry(
			commerceOrderRuleEntryId);
	}

	@Override
	public List<CommerceOrderRuleEntry> getCommerceOrderRuleEntries(
		boolean active, int start, int end, ServiceContext serviceContext) {

		return commerceOrderRuleEntryLocalService.getCommerceOrderRuleEntries(
			active, start, end, serviceContext);
	}

	@Override
	public List<CommerceOrderRuleEntry> getCommerceOrderRuleEntries(
		boolean active, String type, int start, int end,
		ServiceContext serviceContext) {

		return commerceOrderRuleEntryLocalService.getCommerceOrderRuleEntries(
			active, type, start, end, serviceContext);
	}

	@Override
	public List<CommerceOrderRuleEntry> getCommerceOrderRuleEntries(
		String type, int start, int end, ServiceContext serviceContext) {

		return commerceOrderRuleEntryLocalService.getCommerceOrderRuleEntries(
			type, start, end, serviceContext);
	}

	@Override
	public CommerceOrderRuleEntry updateCommerceOrderRuleEntry(
			long commerceOrderRuleEntryId, boolean active, String description,
			String name, int priority, String typeSettings)
		throws PortalException {

		return commerceOrderRuleEntryLocalService.updateCommerceOrderRuleEntry(
			commerceOrderRuleEntryId, active, description, name, priority,
			typeSettings);
	}

}