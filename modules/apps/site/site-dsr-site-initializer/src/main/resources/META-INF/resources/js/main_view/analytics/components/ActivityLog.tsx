/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

import ClayIcon from '@clayui/icon';
import {sub} from 'frontend-js-web';
import React, {useEffect, useRef, useState} from 'react';
import AccountSticker from "../../../common/components/AccountSticker";
import useAnalyticsQuery from "../../../common/hooks/useAnalyticsQuery";
import './../../../../css/components/ActivityLog.scss';

export const TYPES = [
	{
		icon: 'comments',
		key: 'comment',
		label: Liferay.Language.get('commented-on'),
	},
	{
		icon: 'upload',
		key: 'upload',
		label: Liferay.Language.get('uploaded-a-x'),
	},
	{
		icon: 'view',
		key: 'view',
		label: Liferay.Language.get('viewed-a-x'),
	},
];

export interface ILogEntry extends IRawDataEntry {
	icon: string;
	time: string;
}

export interface IUserLogsEntry {
	logs: ILogEntry[];
	userName: string;
}

export type TActivityLog = Record<string, IUserLogsEntry[]>;

export interface IRawDataEntry {
	createDate: number;
	description?: string;
	label?: string;
	title: string;
	type: string;
	userName: string;
}

const formatData = (data: IRawDataEntry[]) => {
	return data.reduce((activityLog: TActivityLog, item: IRawDataEntry) => {
		const date = new Date(item.createDate);
		const dateKey = date.toISOString().split('T')[0];
		const timeString = date.toLocaleTimeString('en-US', {
			hour: 'numeric',
			hour12: true,
			minute: '2-digit',
		});

		if (!activityLog[dateKey]) {
			activityLog[dateKey] = [];
		}

		const type = TYPES.find((type) => type.key === item.type);

		const logEntry: ILogEntry = {
			...item,
			icon: type ? type.icon : '',
			label: type
				? sub(
						Liferay.Language.get(type.label),
						Liferay.Language.get(item.label || '')
					)
				: '',
			time: timeString,
		};

		const dayGroup = activityLog[dateKey];
		const lastUserBlock = dayGroup[dayGroup.length - 1];

		if (lastUserBlock && lastUserBlock.userName === item.userName) {
			lastUserBlock.logs.push(logEntry);
		}
		else {
			dayGroup.push({
				logs: [logEntry],
				userName: item.userName,
			});
		}

		return activityLog;
	}, {});
};

function ActivityLog() {
	const [activityLogs, setActivityLogs] = useState<TActivityLog>({});

	const activityLogRef = useRef<HTMLDivElement>(null);

	const graphqlQuery = {
		query: `
			query UserSession($channelId: String!, $entityId: String, $entityType: EntityType!, $keywords: String, $page: Int!, $rangeEnd: String, $rangeKey: Int, $rangeStart: String, $size: Int!) {
			  eventsByUserSessions(
				channelId: $channelId
				entityId: $entityId
				entityType: $entityType
				keywords: $keywords
				page: $page
				rangeEnd: $rangeEnd
				rangeKey: $rangeKey
				rangeStart: $rangeStart
				size: $size
			  ) {
				userSessions {
				  ... on UserSession {
					events {
					  createDate
					  emailAddressHashed
					  name
					  __typename
					}
					__typename
				  }
				  __typename
				}
				totalEvents
				__typename
			  }
			}
		  `,
		variables: {
			rangeEnd: null,
			rangeKey: 7,
			rangeStart: null,
			channelId: "808122315193619922",
			entityType: "INDIVIDUAL",
			keywords: "",
			page: 1,
			size: 20
		}
	};

	//useAnalyticsQuery(activityLogRef.current!, graphqlQuery);

	useEffect(() => {
		const data = [
			{
				createDate: 1772757506000,
				label: 'tab',
				title: 'Shared Document',
				type: 'view',
				userName: 'John Doe',
			},
			{
				createDate: 1772774004000,
				description: 'Lorem ipsum dolor sit amet...',
				title: 'Technical Requirements',
				type: 'comment',
				userName: 'John Doe',
			},
			{
				createDate: 1772788091000,
				label: 'document',
				title: 'Quote Software License.pdf',
				type: 'upload',
				userName: 'John Doe',
			},
			{
				createDate: 1772831368491,
				description: 'Lorem ipsum dolor sit amet...',
				title: 'Quote Software License',
				type: 'comment',
				userName: 'Paul Gerome',
			},
			{
				createDate: 1772795460014,
				description: 'Lorem ipsum dolor sit amet...',
				title: 'Roadmap Plan 2026',
				type: 'comment',
				userName: 'Emily Blunt',
			},
			{
				createDate: 1772857149296,
				description: 'Lorem ipsum dolor sit amet...',
				title: 'Quote Software License',
				type: 'comment',
				userName: 'Paul Gerome',
			},
			{
				createDate: 1772859315713,
				description: 'Lorem ipsum dolor sit amet...',
				title: 'Roadmap Plan 2026',
				type: 'comment',
				userName: 'Emily Blunt',
			},
			{
				createDate: 1772902574223,
				description: 'Lorem ipsum dolor sit amet...',
				title: 'Roadmap Plan 2026',
				type: 'comment',
				userName: 'Paul Gerome',
			},
		];

		const formattedData = formatData(data);

		setActivityLogs(formattedData);
	}, []);

	function getUserInitials(name: string | undefined): string {
		if (name) {
			const trimmedName = name.trim();

			if (trimmedName.length) {
				return trimmedName[0].toUpperCase();
			}
		}

		return '';
	}

	return (
		<div ref={activityLogRef}>
			{Object.entries(activityLogs).map(
				([date, userLogs]: [string, IUserLogsEntry[]]) => (
					<>
						<div className="activity-logs-date fw-600 mb-3 px-3 py-2 text-secondary">
							{date}
						</div>

						{userLogs.map((userLogsEntry: IUserLogsEntry) => (
							<>
								<div className="inline-item d-flex pl-3">
									<AccountSticker
										className="sticker-user-icon"
										name={userLogsEntry.userName}
										shape="circle"
										size="lg"
									/>

									<span className="fw-600 ml-2">
										{userLogsEntry.userName}
									</span>
								</div>

								<ul className="pl-5 timeline">
									{userLogsEntry.logs.map(
										(logEntry: ILogEntry) => (
											<li
												className="timeline-item"
												key={logEntry.createDate}
											>
												<div className="panel">
													<div
														className={`sticker sticker-circle timeline-increment timeline-increment-${logEntry.type}`}
													>
														<span
															className={`timeline-increment-icon timeline-increment-icon-${logEntry.type}`}
														>
															<ClayIcon
																className="log-icon"
																symbol={
																	logEntry.icon
																}
															/>
														</span>
													</div>

													<div className="panel-body pl-0">
														<div className="log-time text-secondary">
															{logEntry.time}
														</div>

														<div className="fw-600 log-label">
															{logEntry.label}
														</div>

														<div className="log-title">
															{logEntry.title}
														</div>

														{logEntry.description && (
															<div className="log-description px-2 py-1">
																{
																	logEntry.description
																}
															</div>
														)}
													</div>
												</div>
											</li>
										)
									)}
								</ul>
							</>
						))}
					</>
				)
			)}
		</div>
	);
}

export default ActivityLog;
