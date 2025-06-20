<%--
/**
 * SPDX-FileCopyrightText: (c) 2000 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */
--%>

<%@ include file="/init.jsp" %>

<%
CPCompareMiniDisplayContext cpCompareMiniDisplayContext = (CPCompareMiniDisplayContext)request.getAttribute(WebKeys.PORTLET_DISPLAY_CONTEXT);

CPDataSourceResult cpDataSourceResult = cpCompareMiniDisplayContext.getCPDataSourceResult();
%>

<c:choose>
	<c:when test="<%= !cpCompareMiniDisplayContext.hasCommerceChannel() %>">
		<div class="alert alert-info mx-auto">
			<liferay-ui:message key="this-site-does-not-have-a-channel" />
		</div>
	</c:when>
	<c:when test="<%= cpCompareMiniDisplayContext.isSelectionStyleADT() %>">
		<liferay-ddm:template-renderer
			className="<%= CPCompareMiniPortlet.class.getName() %>"
			contextObjects='<%=
				HashMapBuilder.<String, Object>put(
					"cpCompareMiniDisplayContext", cpCompareMiniDisplayContext
				).build()
			%>'
			displayStyle="<%= cpCompareMiniDisplayContext.getDisplayStyle() %>"
			displayStyleGroupId="<%= cpCompareMiniDisplayContext.getDisplayStyleGroupId() %>"
			entries="<%= cpDataSourceResult.getCPCatalogEntries() %>"
		/>
	</c:when>
	<c:when test="<%= cpCompareMiniDisplayContext.isSelectionStyleCustomRenderer() %>">
		<liferay-commerce-product:product-list-renderer
			CPDataSourceResult="<%= cpCompareMiniDisplayContext.getCPDataSourceResult() %>"
			entryKeys="<%= cpCompareMiniDisplayContext.getCPContentListEntryRendererKeys() %>"
			key="<%= cpCompareMiniDisplayContext.getCPContentListRendererKey() %>"
		/>
	</c:when>
	<c:otherwise>
	</c:otherwise>
</c:choose>