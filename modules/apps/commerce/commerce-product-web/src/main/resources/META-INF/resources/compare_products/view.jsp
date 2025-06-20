<%--
/**
 * SPDX-FileCopyrightText: (c) 2000 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */
--%>

<%@ include file="/init.jsp" %>

<%
CPCompareDisplayContext cpCompareDisplayContext = (CPCompareDisplayContext)request.getAttribute(WebKeys.PORTLET_DISPLAY_CONTEXT);

CPDataSourceResult cpDataSourceResult = cpCompareDisplayContext.getCPDataSourceResult();
%>

<c:choose>
	<c:when test="<%= !cpCompareDisplayContext.hasCommerceChannel() %>">
		<div class="alert alert-info mx-auto">
			<liferay-ui:message key="this-site-does-not-have-a-channel" />
		</div>
	</c:when>
	<c:when test="<%= cpCompareDisplayContext.isSelectionStyleADT() %>">
		<liferay-ddm:template-renderer
			className="<%= CPComparePortlet.class.getName() %>"
			contextObjects='<%=
				HashMapBuilder.<String, Object>put(
					"cpCompareDisplayContext", cpCompareDisplayContext
				).build()
			%>'
			displayStyle="<%= cpCompareDisplayContext.getDisplayStyle() %>"
			displayStyleGroupId="<%= cpCompareDisplayContext.getDisplayStyleGroupId() %>"
			entries="<%= cpDataSourceResult.getCPCatalogEntries() %>"
		/>
	</c:when>
	<c:when test="<%= cpCompareDisplayContext.isSelectionStyleCustomRenderer() %>">
		<liferay-commerce-product:product-list-renderer
			CPDataSourceResult="<%= cpCompareDisplayContext.getCPDataSourceResult() %>"
			entryKeys="<%= cpCompareDisplayContext.getCPContentListEntryRendererKeys() %>"
			key="<%= cpCompareDisplayContext.getCPContentListRendererKey() %>"
		/>
	</c:when>
	<c:otherwise>
	</c:otherwise>
</c:choose>