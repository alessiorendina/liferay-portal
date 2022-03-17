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
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.jsonwebservice.JSONWebService;
import com.liferay.portal.kernel.security.access.control.AccessControlled;
import com.liferay.portal.kernel.service.BaseService;
import com.liferay.portal.kernel.spring.osgi.OSGiBeanProperties;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;

import java.util.List;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides the remote service interface for AccountEntryShippingOptionRel. Methods of this
 * service are expected to have security checks based on the propagated JAAS
 * credentials because this service can be accessed remotely.
 *
 * @author Alessio Antonio Rendina
 * @see AccountEntryShippingOptionRelServiceUtil
 * @generated
 */
@AccessControlled
@JSONWebService
@OSGiBeanProperties(
	property = {
		"json.web.service.context.name=commerce",
		"json.web.service.context.path=AccountEntryShippingOptionRel"
	},
	service = AccountEntryShippingOptionRelService.class
)
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface AccountEntryShippingOptionRelService extends BaseService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add custom service methods to <code>com.liferay.commerce.shipping.engine.fixed.service.impl.AccountEntryShippingOptionRelServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface. Consume the account entry shipping option rel remote service via injection or a <code>org.osgi.util.tracker.ServiceTracker</code>. Use {@link AccountEntryShippingOptionRelServiceUtil} if injection and service tracking are not available.
	 */
	public AccountEntryShippingOptionRel addAccountEntryShippingOptionRel(
			long accountEntryId, long channelId, String shippingMethodKey,
			String shippingOptionKey)
		throws PortalException;

	public void deleteAccountEntryShippingOptionRelsByShippingOptionKey(
			long accountEntryId, String shippingOptionKey)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public AccountEntryShippingOptionRel fetchAccountEntryShippingOptionRel(
			long accountEntryId, long channelId, long companyId)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public AccountEntryShippingOptionRel fetchAccountEntryShippingOptionRel(
			long accountEntryId, long channelId, long companyId,
			String shippingOptionKey)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<AccountEntryShippingOptionRel>
			getAccountEntryShippingOptionRelsByShippingOptionKey(
				long accountEntryId, String shippingOptionKey)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<AccountEntryShippingOptionRel>
			getAccountEntryShippingOptionRelsByShippingOptionKey(
				long accountEntryId, String shippingOptionKey, int start,
				int end)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getAccountEntryShippingOptionRelsByShippingOptionKeyCount(
			long accountEntryId, String shippingOptionKey)
		throws PortalException;

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public String getOSGiServiceIdentifier();

	public AccountEntryShippingOptionRel updateAccountEntryShippingOptionRel(
			long accountEntryShippingOptionRelId, long accountEntryId,
			long channelId, long companyId, String shippingMethodKey,
			String shippingOptionKey)
		throws PortalException;

}