/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

export function getReturnItemStatusLabel(value) {
	let label = 'label-secondary';

	if (
		value === 'authorized' ||
		value === 'completed' ||
		value === 'defined' ||
		value === 'partiallyAuthorized' ||
		value === 'partiallyReceived' ||
		value === 'processed' ||
		value === 'received'
	) {
		label = 'label-success';
	}
	else if (label === 'notAuthorized' || label === 'receiptRejected') {
		label = 'label-danger';
	}

	return label;
};
