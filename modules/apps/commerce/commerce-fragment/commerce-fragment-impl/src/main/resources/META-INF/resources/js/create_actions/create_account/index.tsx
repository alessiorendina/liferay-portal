/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

import ClayButton from '@clayui/button';
import {useModal} from '@clayui/modal';

import {
	AccountUtils,
	AccountCreationModal,
	CommerceNotificationUtils,
	commerceEvents,

// @ts-ignore

} from 'commerce-frontend-js';
import React from 'react';

interface CreateAccountProps {
	checkoutURL: string | '';
	setCurrentAccountURL: string;
	hasAddAccountsPermission: boolean;
	label: string;
}

const CreateAccountAction = ({
	checkoutURL,
	setCurrentAccountURL,
	hasAddAccountsPermission,
	label,
}: CreateAccountProps) => {
	const {observer, onOpenChange, open} = useModal();

	const onAccountChange = ({account, doCheckout}: OnAccountChangeParams) => {
		AccountUtils.selectAccount(account.id, setCurrentAccountURL)
			.then(() => {
				Liferay.fire(commerceEvents.CURRENT_ACCOUNT_UPDATED, {
					...(doCheckout ? {checkoutURL} : {}),
					id: account.id,
				});
			})
			.catch(CommerceNotificationUtils.showErrorNotification);
	};

	return (
		<>
			<ClayButton
				className="btn-create-account"
				disabled={!hasAddAccountsPermission}
				onClick={() => onOpenChange(true)}
			>
				{label}
			</ClayButton>

			{open && (
				<AccountCreationModal
					closeModal={() => onOpenChange(false)}
					observer={observer}
					onAccountChange={onAccountChange}
				/>
			)}
		</>
	);
};

export default CreateAccountAction;
