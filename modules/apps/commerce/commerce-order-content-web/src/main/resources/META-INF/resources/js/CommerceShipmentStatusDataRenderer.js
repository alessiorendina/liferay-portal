/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

import StatusLabelsUtils from 'commerce-frontend-js';
import ClayLabel from '@clayui/label';
import PropTypes from 'prop-types';
import React from 'react';

const CommerceShipmentStatusDataRenderer = ({value}) => {
	const {displayType, label_i18n} = StatusLabelsUtils.getShipmentStatusLabel(value);

	return (
		<ClayLabel displayType={displayType}>
			{Liferay.Language.get(label_i18n)}
		</ClayLabel>
	);
};

export default CommerceShipmentStatusDataRenderer;

CommerceShipmentStatusDataRenderer.propTypes = {
	value: PropTypes.string,
};
