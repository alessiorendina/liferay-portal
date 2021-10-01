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

package com.liferay.commerce.order.rule.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link CommerceOrderRuleEntryService}.
 *
 * @author Luca Pellizzon
 * @see CommerceOrderRuleEntryService
 * @generated
 */
public class CommerceOrderRuleEntryServiceWrapper
	implements CommerceOrderRuleEntryService,
			   ServiceWrapper<CommerceOrderRuleEntryService> {

	public CommerceOrderRuleEntryServiceWrapper(
		CommerceOrderRuleEntryService commerceOrderRuleEntryService) {

		_commerceOrderRuleEntryService = commerceOrderRuleEntryService;
	}

	@Override
	public com.liferay.commerce.order.rule.model.CommerceOrderRuleEntry
			addCommerceOrderRuleEntry(
				boolean active, String description, String name, int priority,
				String type, String typeSettings,
				com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _commerceOrderRuleEntryService.addCommerceOrderRuleEntry(
			active, description, name, priority, type, typeSettings,
			serviceContext);
	}

	@Override
	public com.liferay.commerce.order.rule.model.CommerceOrderRuleEntry
			deleteCommerceOrderRuleEntry(long commerceOrderRuleEntryId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _commerceOrderRuleEntryService.deleteCommerceOrderRuleEntry(
			commerceOrderRuleEntryId);
	}

	@Override
	public java.util.List
		<com.liferay.commerce.order.rule.model.CommerceOrderRuleEntry>
			getCommerceOrderRuleEntries(
				boolean active, int start, int end,
				com.liferay.portal.kernel.service.ServiceContext
					serviceContext) {

		return _commerceOrderRuleEntryService.getCommerceOrderRuleEntries(
			active, start, end, serviceContext);
	}

	@Override
	public java.util.List
		<com.liferay.commerce.order.rule.model.CommerceOrderRuleEntry>
			getCommerceOrderRuleEntries(
				boolean active, String type, int start, int end,
				com.liferay.portal.kernel.service.ServiceContext
					serviceContext) {

		return _commerceOrderRuleEntryService.getCommerceOrderRuleEntries(
			active, type, start, end, serviceContext);
	}

	@Override
	public java.util.List
		<com.liferay.commerce.order.rule.model.CommerceOrderRuleEntry>
			getCommerceOrderRuleEntries(
				String type, int start, int end,
				com.liferay.portal.kernel.service.ServiceContext
					serviceContext) {

		return _commerceOrderRuleEntryService.getCommerceOrderRuleEntries(
			type, start, end, serviceContext);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _commerceOrderRuleEntryService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.commerce.order.rule.model.CommerceOrderRuleEntry
			updateCommerceOrderRuleEntry(
				long commerceOrderRuleEntryId, boolean active,
				String description, String name, int priority,
				String typeSettings)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _commerceOrderRuleEntryService.updateCommerceOrderRuleEntry(
			commerceOrderRuleEntryId, active, description, name, priority,
			typeSettings);
	}

	@Override
	public CommerceOrderRuleEntryService getWrappedService() {
		return _commerceOrderRuleEntryService;
	}

	@Override
	public void setWrappedService(
		CommerceOrderRuleEntryService commerceOrderRuleEntryService) {

		_commerceOrderRuleEntryService = commerceOrderRuleEntryService;
	}

	private CommerceOrderRuleEntryService _commerceOrderRuleEntryService;

}