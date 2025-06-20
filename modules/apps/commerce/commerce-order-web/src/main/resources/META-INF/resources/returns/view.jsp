<%@ page import="com.liferay.commerce.order.web.internal.display.context.CommerceReturnDisplayContext" %>

<%--
/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */
--%>

<%@ include file="/returns/init.jsp" %>

<%
CommerceReturnDisplayContext commerceReturnDisplayContext = (CommerceReturnDisplayContext)request.getAttribute(WebKeys.PORTLET_DISPLAY_CONTEXT);

long commerceChannelId = commerceReturnDisplayContext.getCommerceChannelId();
%>

<c:choose>
	<c:when test="<%= commerceChannelId == 0 %>">
		<div class="alert alert-info mx-auto">
			<liferay-ui:message key="the-site-does-not-belong-to-any-channel" />
		</div>
	</c:when>
	<c:otherwise>
		<div id="<portlet:namespace />return-content-container">
			<frontend-data-set:headless-display
				apiURL="<%= commerceReturnDisplayContext.getAPIURL() %>"
				fdsActionDropdownItems="<%= commerceReturnDisplayContext.getFDSActionDropdownItems() %>"
				formName="fm"
				id="<%= CommerceOrderFDSNames.RETURNS %>"
				itemsPerPage="<%= 10 %>"
				propsTransformer="{commerceReturnPropsTransformer} from commerce-order-content-web"
				style="fluid"
			/>
		</div>
	</c:otherwise>
</c:choose>