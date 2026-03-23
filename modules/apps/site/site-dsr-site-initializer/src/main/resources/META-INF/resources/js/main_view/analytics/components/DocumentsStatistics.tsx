/**
 * SPDX-FileCopyrightText: (c) 2000 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

import ClayIcon from '@clayui/icon';
import ClaySticker from '@clayui/sticker';
import {FrontendDataSet} from '@liferay/frontend-data-set-web';
import classNames from 'classnames';
import {sub} from 'frontend-js-web';
import React from 'react';

import '../../../../css/components/DocumentsStatistics.scss';

type TDocumentsStatisticsData = {
	download: number;
	lastViewed: string;
	title: string;
	totalTimeViewingAsset: number;
	totalViews: number;
	type: string;
	userInvolved: string[];
};

type TDocumentsStatisticsProps = {
	items: TDocumentsStatisticsData[];
	namespace: string;
};

const AverageTimeDataRenderer = ({
	itemData,
}: {
	itemData: TDocumentsStatisticsData;
}) => {
	const {totalTimeViewingAsset, totalViews} = itemData || {};

	const averageTimeSeconds = Math.round(totalTimeViewingAsset / totalViews);

	const hours = Math.floor(averageTimeSeconds / 3600);
	const minutes = Math.floor((averageTimeSeconds % 3600) / 60);

	return sub(`${Liferay.Language.get('x-h-x-min')}`, hours, minutes);
};

const DocumentTitleDataRenderer = ({
	itemData,
}: {
	itemData: TDocumentsStatisticsData;
}) => {
	const {title, type} = itemData;

	return (
		<div>
			<ClaySticker
				className={classNames(
					'c-mr-2',
					'flex-shrink-0',
					'inline-item',
					'inline-item-before',
					type === 'pdf' ? 'file-icon-color-0' : 'file-icon-color-6'
				)}
				inline
				size="lg"
			>
				<ClayIcon
					aria-label={Liferay.Language.get(type)}
					symbol={type === 'pdf' ? 'document-pdf' : 'document-text'}
				/>
			</ClaySticker>

			<span
				aria-label={Liferay.Language.get(title)}
				className="table-list-title"
			>
				{Liferay.Language.get(title)}
			</span>
		</div>
	);
};

const LastViewedDataRenderer = ({
	itemData,
}: {
	itemData: TDocumentsStatisticsData;
}) => {
	const {lastViewed} = itemData;

	return new Intl.DateTimeFormat(Liferay.ThemeDisplay.getBCP47LanguageId(), {
		dateStyle: 'medium',
	}).format(new Date(lastViewed));
};

const UserInvolvedDataRenderer = ({
	itemData,
}: {
	itemData: TDocumentsStatisticsData;
}) => {
	const {userInvolved = []} = itemData;

	if (!userInvolved.length) {
		return 0;
	}

	return sub(Liferay.Language.get('x-users'), [new Set(userInvolved).size]);
};

const DocumentsStatistics = ({
	items = [],
	namespace,
}: TDocumentsStatisticsProps) => {
	return (
		<div className="document-statistics-fds">
			<FrontendDataSet
				customDataRenderers={{
					averageTimeDataRenderer: AverageTimeDataRenderer,
					documentNameDataRenderer: DocumentTitleDataRenderer,
					lastViewedDataRenderer: LastViewedDataRenderer,
					userInvolvedDataRenderer: UserInvolvedDataRenderer,
				}}
				id={namespace}
				items={items}
				showManagementBar={false}
				showPagination={false}
				showSearch={false}
				showSelectAll={false}
				views={[
					{
						contentRenderer: 'table',
						label: Liferay.Language.get('table'),
						name: 'table',
						schema: {
							fields: [
								{
									contentRenderer: 'documentNameDataRenderer',
									fieldName: 'title',
									label: Liferay.Language.get('title'),
								},
								{
									fieldName: 'totalViews',
									label: Liferay.Language.get('total-views'),
								},
								{
									contentRenderer: 'lastViewedDataRenderer',
									fieldName: 'lastViewed',
									label: Liferay.Language.get('last-viewed'),
								},
								{
									fieldName: 'download',
									label: Liferay.Language.get('download'),
								},
								{
									contentRenderer: 'averageTimeDataRenderer',
									fieldName: 'averageTime',
									label: Liferay.Language.get('average-time'),
								},
								{
									contentRenderer: 'userInvolvedDataRenderer',
									fieldName: 'userInvolved',
									label: Liferay.Language.get(
										'user-involved'
									),
								},
							],
						},
						thumbnail: 'table',
					},
				]}
			/>
		</div>
	);
};

export default DocumentsStatistics;
