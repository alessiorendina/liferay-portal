<%--
/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */
--%>

<%@ include file="/init.jsp" %>

<%
ViewAnalyticsNavigationSectionDisplayContext viewAnalyticsNavigationSectionDisplayContext = (ViewAnalyticsNavigationSectionDisplayContext)request.getAttribute(ViewRoomsSectionDisplayContext.class.getName());
%>

<div>
	<div class="dsr-section custom-empty-state">
		<react:component
			module="{DSRAnalyticsNavigation} from site-dsr-site-initializer"
			props='<%=
				HashMapBuilder.<String, Object>put(
					"activeTab", viewAnalyticsNavigationSectionDisplayContext.getActiveTab()
				).put(
					"filtersJSONString", viewAnalyticsNavigationSectionDisplayContext.getAnalyticsStoreFilters()
				).put(
					"filterSettings", viewAnalyticsNavigationSectionDisplayContext.getFilterSettingsJSONObject()
				).put(
					"room", ""
				).build()
			%>'
		/>
	</div>
</div>