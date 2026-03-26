/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

import ClayButton from '@clayui/button';
import {ClaySelect} from '@clayui/form';
import ClayNavigationBar from '@clayui/navigation-bar';
import {navigate} from 'frontend-js-web';
import React from 'react';

import {Breadcrumb} from '@liferay/site-cms-site-initializer';

export default function AnalyticsToolbar({
    activeTab = 'overview',
    overviewURL,
    timelineURL,
}: {
    activeTab?: string;
    overviewURL: string;
    timelineURL: string;
}) {
    const rooms = [
        {
            id: 12345, name: "test1"
        },
        {
            id: 67890, name: "test2"
        }
    ];

    function handleSelectChange(event: any) {
        const value = Number(event.currentTarget.value);

        window.location.reload();
    }

    return (
        <div>
            <div className="d-flex">
                <Breadcrumb
                    breadcrumbItems={[
                        {
                            active: true,
                            label: Liferay.Language.get('analytics'),
                        },
                    ]}
                    hideSpace
                />

                <ClaySelect
                    name="roomSelect"
                    onChange={handleSelectChange}
                >
                    <ClaySelect.Option
                        aria-label={Liferay.Language.get('all-rooms')}
                        label={Liferay.Language.get('all-rooms')}
                        value=""
                    />

                    {rooms.map((room: any) => (
                        <ClaySelect.Option
                            key={room.id}
                            label={`${room.name}`}
                            value={room.id}
                        />
                    ))}
                </ClaySelect>
            </div>

            <ClayNavigationBar
                aria-label={Liferay.Language.get('navigation')}
                fluidSize={false}
                triggerLabel={activeTab}
            >
                <ClayNavigationBar.Item
                    active={activeTab.includes('overview')}
                    key={Liferay.Language.get('overview')}
                >
                    <ClayButton onClick={() => navigate(overviewURL)}>
                        {Liferay.Language.get('overview')}
                    </ClayButton>
                </ClayNavigationBar.Item>

                <ClayNavigationBar.Item
                    active={activeTab.includes('timeline')}
                    key={Liferay.Language.get('timeline')}
                >
                    <ClayButton onClick={() => navigate(timelineURL)}>
                        {Liferay.Language.get('timeline')}
                    </ClayButton>
                </ClayNavigationBar.Item>
            </ClayNavigationBar>
        </div>
    );
}
