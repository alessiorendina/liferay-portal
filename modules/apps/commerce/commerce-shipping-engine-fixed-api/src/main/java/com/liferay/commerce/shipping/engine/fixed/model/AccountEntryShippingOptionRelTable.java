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

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

import java.util.Date;

/**
 * The table class for the &quot;AccountEntryShippingOptionRel&quot; database table.
 *
 * @author Alessio Antonio Rendina
 * @see AccountEntryShippingOptionRel
 * @generated
 */
public class AccountEntryShippingOptionRelTable
	extends BaseTable<AccountEntryShippingOptionRelTable> {

	public static final AccountEntryShippingOptionRelTable INSTANCE =
		new AccountEntryShippingOptionRelTable();

	public final Column<AccountEntryShippingOptionRelTable, Long> mvccVersion =
		createColumn(
			"mvccVersion", Long.class, Types.BIGINT, Column.FLAG_NULLITY);
	public final Column<AccountEntryShippingOptionRelTable, Long>
		accountEntryShippingOptionRelId = createColumn(
			"AccountEntryCSOptionRelId", Long.class, Types.BIGINT,
			Column.FLAG_PRIMARY);
	public final Column<AccountEntryShippingOptionRelTable, Long> companyId =
		createColumn(
			"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<AccountEntryShippingOptionRelTable, Long> userId =
		createColumn("userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<AccountEntryShippingOptionRelTable, String> userName =
		createColumn(
			"userName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<AccountEntryShippingOptionRelTable, Date> createDate =
		createColumn(
			"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<AccountEntryShippingOptionRelTable, Date> modifiedDate =
		createColumn(
			"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<AccountEntryShippingOptionRelTable, Long>
		accountEntryId = createColumn(
			"accountEntryId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<AccountEntryShippingOptionRelTable, Long> channelId =
		createColumn(
			"channelId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<AccountEntryShippingOptionRelTable, String>
		shippingMethodKey = createColumn(
			"shippingMethodKey", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<AccountEntryShippingOptionRelTable, String>
		shippingOptionKey = createColumn(
			"shippingOptionKey", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);

	private AccountEntryShippingOptionRelTable() {
		super(
			"AccountEntryShippingOptionRel",
			AccountEntryShippingOptionRelTable::new);
	}

}