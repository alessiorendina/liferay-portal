/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

import {ApiHelper} from '@liferay/site-cms-site-initializer';

import {
	TAnalyticsFilter,
	TAnalyticsFilterValue,
} from '../../main_view/analytics/types';

const QUERY_ANALYTICS_URL = '';
const STORE_ANALYTICS_FILTERS_URL = '/dsr/analytics/store_filters';

function get(query: string, filters: TAnalyticsFilter) {
	console.log('fetch');

	// TODO implement fetch for GQL endpoint

}

const AJAX = {
	POST(url: string, json = {}, customOptions = {}, params = {}) {
		const options = {
			body: JSON.stringify(json),
			method: 'POST',
			...customOptions,
		};

		return _fetch(url, options, params);
	},
};

function _fetch(url: string, options = {}, params = {}) {
	const formattedURL = new URL(url, Liferay.ThemeDisplay.getPortalURL());

	Object.entries(params).map(([key, value]) => {
		formattedURL.searchParams.append(key, String(value));
	});

	return fetch(formattedURL.pathname + formattedURL.search, {
		...{
			headers: new Headers({
				'Accept': 'application/json',
				'Accept-Language': Liferay.ThemeDisplay.getBCP47LanguageId(),
				'Content-Type': 'application/json',
			}),
		},
		...options,
	})
		.then((response) => {
			if (!response.ok) {
				return response
					.json()
					.catch((parseError) =>
						Promise.reject(new Error(parseError))
					)
					.then((reason) => Promise.reject(reason));
			}

			if (response.status === 204) {
				return Promise.resolve();
			}

			return response.json().catch(() => {
				const contentType = response.headers.get('content-type');

				if (!contentType && response.status === 200) {
					return response;
				}
			});
		})
		.catch((error) => Promise.reject(error));
}

function storeFilters(filters: TAnalyticsFilterValue) {
	return AJAX.POST(
		Liferay.ThemeDisplay.getPathMain() + STORE_ANALYTICS_FILTERS_URL,
		{},
		{},
		{
			filters: JSON.stringify(filters),
		}
	);
}

export default {get, storeFilters};
