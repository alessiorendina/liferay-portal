/**
 * SPDX-FileCopyrightText: (c) 2000 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

import {expect, mergeTests} from '@playwright/test';

import {featureFlagsTest} from '../../fixtures/featureFlagsTest';
import {loginTest} from '../../fixtures/loginTest';
import { SCIMConfigurationPage } from '../../pages/scim-configuraiton-web/SCIMConfigurationPage';
import { getRandomInt } from '../../utils/getRandomInt';
import { ApiHelpers } from '../../helpers/ApiHelpers';

export const test = mergeTests(
	featureFlagsTest({
		'LPS-96845': true,
	}),
	loginTest()
);

test('LPD-33284 verify that post and get users requests work with oauth token', async ({
	page,
}) => {
	const scimConfigurationPage = new SCIMConfigurationPage(page);

	await scimConfigurationPage.goTo();

	await scimConfigurationPage.configureSCIM('email', 'Test SCIM Client');

	await scimConfigurationPage.generateToken();

	const accessToken =
		await scimConfigurationPage.accessTokenField.inputValue();

	const randomNumber = getRandomInt();

	const newUser = {
		active: true,
		emails: [
			{
				primary: true,
				type: 'default',
				value: `able${randomNumber}@liferay.com`,
			},
		],
		name: {
			familyName: `Baker ${randomNumber}`,
			givenName: `Able ${randomNumber}`,
		},
		userName: `able${randomNumber}.baker`,
	};

	const apiHelper = new ApiHelpers(page);

	await apiHelper.scim.postUserWithOAuth(newUser, accessToken);

	const response = await (
		await apiHelper.scim.getUsersWithOAuth(accessToken)
	).text();

	expect(response).not.toContain('"totalResults":0');
});

test('LPD-33284 verify that post and get groups requests work with oauth token', async ({
	page,
}) => {
	const scimConfigurationPage = new SCIMConfigurationPage(page);

	await scimConfigurationPage.goTo();

	await scimConfigurationPage.configureSCIM('email', 'Test SCIM Client');

	await scimConfigurationPage.generateToken();

	const accessToken =
		await scimConfigurationPage.accessTokenField.inputValue();

	const randomNumber = getRandomInt();

	const newGroup = {
		displayName: `Foo${randomNumber}`,
	};

	const apiHelper = new ApiHelpers(page);

	await apiHelper.scim.postGroupWithOAuth(newGroup, accessToken);

	const response = await (
		await apiHelper.scim.getGroupsWithOAuth(accessToken)
	).text();

	expect(response).not.toContain('"totalResults":0');
});
