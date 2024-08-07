/**
 * SPDX-FileCopyrightText: (c) 2000 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

import {mergeTests} from '@playwright/test';

import {loginTest} from '../../fixtures/loginTest';
import {ApiHelpers} from '../../helpers/ApiHelpers';
import {ApplicationsMenuPage} from '../../pages/product-navigation-applications-menu/ApplicationsMenuPage';
import {SCIMConfigurationPage} from '../../pages/scim-configuraiton-web/SCIMConfigurationPage';
import {getRandomInt} from '../../utils/getRandomInt';

export const test = mergeTests(loginTest());
