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

package com.liferay.commerce.shipping.engine.fixed.model.impl;

import com.liferay.commerce.shipping.engine.fixed.model.AccountEntryShippingOptionRel;
import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.MVCCModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing AccountEntryShippingOptionRel in entity cache.
 *
 * @author Alessio Antonio Rendina
 * @generated
 */
public class AccountEntryShippingOptionRelCacheModel
	implements CacheModel<AccountEntryShippingOptionRel>, Externalizable,
			   MVCCModel {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof AccountEntryShippingOptionRelCacheModel)) {
			return false;
		}

		AccountEntryShippingOptionRelCacheModel
			accountEntryShippingOptionRelCacheModel =
				(AccountEntryShippingOptionRelCacheModel)object;

		if ((accountEntryShippingOptionRelId ==
				accountEntryShippingOptionRelCacheModel.
					accountEntryShippingOptionRelId) &&
			(mvccVersion ==
				accountEntryShippingOptionRelCacheModel.mvccVersion)) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		int hashCode = HashUtil.hash(0, accountEntryShippingOptionRelId);

		return HashUtil.hash(hashCode, mvccVersion);
	}

	@Override
	public long getMvccVersion() {
		return mvccVersion;
	}

	@Override
	public void setMvccVersion(long mvccVersion) {
		this.mvccVersion = mvccVersion;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{mvccVersion=");
		sb.append(mvccVersion);
		sb.append(", accountEntryShippingOptionRelId=");
		sb.append(accountEntryShippingOptionRelId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", accountEntryId=");
		sb.append(accountEntryId);
		sb.append(", channelId=");
		sb.append(channelId);
		sb.append(", shippingMethodKey=");
		sb.append(shippingMethodKey);
		sb.append(", shippingOptionKey=");
		sb.append(shippingOptionKey);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public AccountEntryShippingOptionRel toEntityModel() {
		AccountEntryShippingOptionRelImpl accountEntryShippingOptionRelImpl =
			new AccountEntryShippingOptionRelImpl();

		accountEntryShippingOptionRelImpl.setMvccVersion(mvccVersion);
		accountEntryShippingOptionRelImpl.setAccountEntryShippingOptionRelId(
			accountEntryShippingOptionRelId);
		accountEntryShippingOptionRelImpl.setCompanyId(companyId);
		accountEntryShippingOptionRelImpl.setUserId(userId);

		if (userName == null) {
			accountEntryShippingOptionRelImpl.setUserName("");
		}
		else {
			accountEntryShippingOptionRelImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			accountEntryShippingOptionRelImpl.setCreateDate(null);
		}
		else {
			accountEntryShippingOptionRelImpl.setCreateDate(
				new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			accountEntryShippingOptionRelImpl.setModifiedDate(null);
		}
		else {
			accountEntryShippingOptionRelImpl.setModifiedDate(
				new Date(modifiedDate));
		}

		accountEntryShippingOptionRelImpl.setAccountEntryId(accountEntryId);
		accountEntryShippingOptionRelImpl.setChannelId(channelId);

		if (shippingMethodKey == null) {
			accountEntryShippingOptionRelImpl.setShippingMethodKey("");
		}
		else {
			accountEntryShippingOptionRelImpl.setShippingMethodKey(
				shippingMethodKey);
		}

		if (shippingOptionKey == null) {
			accountEntryShippingOptionRelImpl.setShippingOptionKey("");
		}
		else {
			accountEntryShippingOptionRelImpl.setShippingOptionKey(
				shippingOptionKey);
		}

		accountEntryShippingOptionRelImpl.resetOriginalValues();

		return accountEntryShippingOptionRelImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		mvccVersion = objectInput.readLong();

		accountEntryShippingOptionRelId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		accountEntryId = objectInput.readLong();

		channelId = objectInput.readLong();
		shippingMethodKey = objectInput.readUTF();
		shippingOptionKey = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(mvccVersion);

		objectOutput.writeLong(accountEntryShippingOptionRelId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		objectOutput.writeLong(accountEntryId);

		objectOutput.writeLong(channelId);

		if (shippingMethodKey == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(shippingMethodKey);
		}

		if (shippingOptionKey == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(shippingOptionKey);
		}
	}

	public long mvccVersion;
	public long accountEntryShippingOptionRelId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long accountEntryId;
	public long channelId;
	public String shippingMethodKey;
	public String shippingOptionKey;

}