/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

export function getReturnStatusLabel(value) {
	let label = 'label-secondary';

	if (value === 'cancelled' || value === 'rejected') {
		label = 'label-danger';
	}
	else if (value === 'completed') {
		label = 'label-success';
	}
	else if (value === 'pending') {
		label = 'label-warning';
	}
	else if (value === 'processing') {
		label = 'label-info';
	}

	return label;
}
