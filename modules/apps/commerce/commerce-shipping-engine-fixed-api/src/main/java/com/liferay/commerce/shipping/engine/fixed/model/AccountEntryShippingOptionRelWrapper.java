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

package com.liferay.commerce.shipping.engine.fixed.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link AccountEntryShippingOptionRel}.
 * </p>
 *
 * @author Alessio Antonio Rendina
 * @see AccountEntryShippingOptionRel
 * @generated
 */
public class AccountEntryShippingOptionRelWrapper
	extends BaseModelWrapper<AccountEntryShippingOptionRel>
	implements AccountEntryShippingOptionRel,
			   ModelWrapper<AccountEntryShippingOptionRel> {

	public AccountEntryShippingOptionRelWrapper(
		AccountEntryShippingOptionRel accountEntryShippingOptionRel) {

		super(accountEntryShippingOptionRel);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("mvccVersion", getMvccVersion());
		attributes.put(
			"accountEntryShippingOptionRelId",
			getAccountEntryShippingOptionRelId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("accountEntryId", getAccountEntryId());
		attributes.put("channelId", getChannelId());
		attributes.put("shippingMethodKey", getShippingMethodKey());
		attributes.put("shippingOptionKey", getShippingOptionKey());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long mvccVersion = (Long)attributes.get("mvccVersion");

		if (mvccVersion != null) {
			setMvccVersion(mvccVersion);
		}

		Long accountEntryShippingOptionRelId = (Long)attributes.get(
			"accountEntryShippingOptionRelId");

		if (accountEntryShippingOptionRelId != null) {
			setAccountEntryShippingOptionRelId(accountEntryShippingOptionRelId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Long accountEntryId = (Long)attributes.get("accountEntryId");

		if (accountEntryId != null) {
			setAccountEntryId(accountEntryId);
		}

		Long channelId = (Long)attributes.get("channelId");

		if (channelId != null) {
			setChannelId(channelId);
		}

		String shippingMethodKey = (String)attributes.get("shippingMethodKey");

		if (shippingMethodKey != null) {
			setShippingMethodKey(shippingMethodKey);
		}

		String shippingOptionKey = (String)attributes.get("shippingOptionKey");

		if (shippingOptionKey != null) {
			setShippingOptionKey(shippingOptionKey);
		}
	}

	@Override
	public AccountEntryShippingOptionRel cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the account entry ID of this account entry shipping option rel.
	 *
	 * @return the account entry ID of this account entry shipping option rel
	 */
	@Override
	public long getAccountEntryId() {
		return model.getAccountEntryId();
	}

	/**
	 * Returns the account entry shipping option rel ID of this account entry shipping option rel.
	 *
	 * @return the account entry shipping option rel ID of this account entry shipping option rel
	 */
	@Override
	public long getAccountEntryShippingOptionRelId() {
		return model.getAccountEntryShippingOptionRelId();
	}

	/**
	 * Returns the channel ID of this account entry shipping option rel.
	 *
	 * @return the channel ID of this account entry shipping option rel
	 */
	@Override
	public long getChannelId() {
		return model.getChannelId();
	}

	/**
	 * Returns the company ID of this account entry shipping option rel.
	 *
	 * @return the company ID of this account entry shipping option rel
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this account entry shipping option rel.
	 *
	 * @return the create date of this account entry shipping option rel
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the modified date of this account entry shipping option rel.
	 *
	 * @return the modified date of this account entry shipping option rel
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the mvcc version of this account entry shipping option rel.
	 *
	 * @return the mvcc version of this account entry shipping option rel
	 */
	@Override
	public long getMvccVersion() {
		return model.getMvccVersion();
	}

	/**
	 * Returns the primary key of this account entry shipping option rel.
	 *
	 * @return the primary key of this account entry shipping option rel
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the shipping method key of this account entry shipping option rel.
	 *
	 * @return the shipping method key of this account entry shipping option rel
	 */
	@Override
	public String getShippingMethodKey() {
		return model.getShippingMethodKey();
	}

	/**
	 * Returns the shipping option key of this account entry shipping option rel.
	 *
	 * @return the shipping option key of this account entry shipping option rel
	 */
	@Override
	public String getShippingOptionKey() {
		return model.getShippingOptionKey();
	}

	/**
	 * Returns the user ID of this account entry shipping option rel.
	 *
	 * @return the user ID of this account entry shipping option rel
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this account entry shipping option rel.
	 *
	 * @return the user name of this account entry shipping option rel
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this account entry shipping option rel.
	 *
	 * @return the user uuid of this account entry shipping option rel
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the account entry ID of this account entry shipping option rel.
	 *
	 * @param accountEntryId the account entry ID of this account entry shipping option rel
	 */
	@Override
	public void setAccountEntryId(long accountEntryId) {
		model.setAccountEntryId(accountEntryId);
	}

	/**
	 * Sets the account entry shipping option rel ID of this account entry shipping option rel.
	 *
	 * @param accountEntryShippingOptionRelId the account entry shipping option rel ID of this account entry shipping option rel
	 */
	@Override
	public void setAccountEntryShippingOptionRelId(
		long accountEntryShippingOptionRelId) {

		model.setAccountEntryShippingOptionRelId(
			accountEntryShippingOptionRelId);
	}

	/**
	 * Sets the channel ID of this account entry shipping option rel.
	 *
	 * @param channelId the channel ID of this account entry shipping option rel
	 */
	@Override
	public void setChannelId(long channelId) {
		model.setChannelId(channelId);
	}

	/**
	 * Sets the company ID of this account entry shipping option rel.
	 *
	 * @param companyId the company ID of this account entry shipping option rel
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this account entry shipping option rel.
	 *
	 * @param createDate the create date of this account entry shipping option rel
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the modified date of this account entry shipping option rel.
	 *
	 * @param modifiedDate the modified date of this account entry shipping option rel
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the mvcc version of this account entry shipping option rel.
	 *
	 * @param mvccVersion the mvcc version of this account entry shipping option rel
	 */
	@Override
	public void setMvccVersion(long mvccVersion) {
		model.setMvccVersion(mvccVersion);
	}

	/**
	 * Sets the primary key of this account entry shipping option rel.
	 *
	 * @param primaryKey the primary key of this account entry shipping option rel
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the shipping method key of this account entry shipping option rel.
	 *
	 * @param shippingMethodKey the shipping method key of this account entry shipping option rel
	 */
	@Override
	public void setShippingMethodKey(String shippingMethodKey) {
		model.setShippingMethodKey(shippingMethodKey);
	}

	/**
	 * Sets the shipping option key of this account entry shipping option rel.
	 *
	 * @param shippingOptionKey the shipping option key of this account entry shipping option rel
	 */
	@Override
	public void setShippingOptionKey(String shippingOptionKey) {
		model.setShippingOptionKey(shippingOptionKey);
	}

	/**
	 * Sets the user ID of this account entry shipping option rel.
	 *
	 * @param userId the user ID of this account entry shipping option rel
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this account entry shipping option rel.
	 *
	 * @param userName the user name of this account entry shipping option rel
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this account entry shipping option rel.
	 *
	 * @param userUuid the user uuid of this account entry shipping option rel
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	@Override
	protected AccountEntryShippingOptionRelWrapper wrap(
		AccountEntryShippingOptionRel accountEntryShippingOptionRel) {

		return new AccountEntryShippingOptionRelWrapper(
			accountEntryShippingOptionRel);
	}

}