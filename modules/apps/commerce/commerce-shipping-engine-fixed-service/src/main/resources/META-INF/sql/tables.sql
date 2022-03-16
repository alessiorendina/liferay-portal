create table AccountEntryShippingOptionRel (
	mvccVersion LONG default 0 not null,
	AccountEntryCSOptionRelId LONG not null primary key,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	accountEntryId LONG,
	channelId LONG,
	shippingMethodKey VARCHAR(75) null,
	shippingOptionKey VARCHAR(75) null
);

create table CSFixedOptionQualifier (
	mvccVersion LONG default 0 not null,
	CSFixedOptionQualifierId LONG not null primary key,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	classNameId LONG,
	classPK LONG,
	commerceShippingFixedOptionId LONG
);

create table CShippingFixedOptionRel (
	mvccVersion LONG default 0 not null,
	CShippingFixedOptionRelId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	commerceShippingMethodId LONG,
	commerceShippingFixedOptionId LONG,
	commerceInventoryWarehouseId LONG,
	countryId LONG,
	regionId LONG,
	zip VARCHAR(75) null,
	weightFrom DOUBLE,
	weightTo DOUBLE,
	fixedPrice DECIMAL(30, 16) null,
	rateUnitWeightPrice DECIMAL(30, 16) null,
	ratePercentage DOUBLE
);

create table CommerceShippingFixedOption (
	mvccVersion LONG default 0 not null,
	commerceShippingFixedOptionId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	commerceShippingMethodId LONG,
	amount DECIMAL(30, 16) null,
	description STRING null,
	key_ VARCHAR(75) null,
	name STRING null,
	priority DOUBLE
);