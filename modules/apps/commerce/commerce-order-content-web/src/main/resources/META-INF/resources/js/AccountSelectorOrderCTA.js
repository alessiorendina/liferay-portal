/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

import {openModal} from 'frontend-js-components-web';
import React from 'react';
import ClayButton from "@clayui/button";

export default function AccountSelectorOrderCTA() {

	return (
		<ClayButton onClick={
			() => {
				openModal({
					bodyHTML: `<h1>HEY</h1>`,
					title: Liferay.Language.get('todo'),
			})}
		}>
			Open Modal
		</ClayButton>
	);
}