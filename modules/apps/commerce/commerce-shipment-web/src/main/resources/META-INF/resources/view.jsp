<%--
/**
 * SPDX-FileCopyrightText: (c) 2000 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */
--%>

<%@ include file="/init.jsp" %>

<%
CommerceShipmentDisplayContext commerceShipmentDisplayContext = (CommerceShipmentDisplayContext)request.getAttribute(WebKeys.PORTLET_DISPLAY_CONTEXT);
%>

<liferay-ui:search-container
	cssClass="table-nowrap table-responsive"
	id="commerceShipments"
	searchContainer="<%= commerceShipmentDisplayContext.getSearchContainer() %>"
>
	<liferay-ui:search-container-row
		className="com.liferay.commerce.model.CommerceShipment"
		keyProperty="commerceShipmentId"
		modelVar="commerceShipment"
	>

		<%
		PortletURL rowURL = PortletURLBuilder.createRenderURL(
			renderResponse
		).setMVCRenderCommandName(
			"/commerce_shipment/view_commerce_shipment_items"
		).setRedirect(
			currentURL
		).setParameter(
			"commerceShipmentId", commerceShipment.getCommerceShipmentId()
		).buildPortletURL();
		%>

		<liferay-ui:search-container-column-text
			cssClass="font-weight-bold important table-list-title"
			href="<%= rowURL %>"
			name="shipment-number"
			property="commerceShipmentId"
		/>

		<liferay-ui:search-container-column-text
			name="customer-name"
			value="<%= HtmlUtil.escape(commerceShipmentDisplayContext.getCommerceShipmentAccountName(commerceShipment)) %>"
		/>

		<liferay-ui:search-container-column-text
			name="customer-id"
			value="<%= String.valueOf(commerceShipmentDisplayContext.getCommerceShipmentAccountId(commerceShipment)) %>"
		/>

		<liferay-ui:search-container-column-date
			name="shipping-date"
			property="shippingDate"
		/>

		<liferay-ui:search-container-column-date
			name="estimated-delivery-date"
			property="expectedDate"
		/>

		<liferay-ui:search-container-column-text
			name="status"
			value="<%= commerceShipmentDisplayContext.getCommerceShipmentStatusLabel(commerceShipment.getStatus()) %>"
		/>

		<liferay-ui:search-container-column-text>
			<liferay-ui:icon
				label="<%= true %>"
				message="view-details"
				url="<%= rowURL.toString() %>"
			/>
		</liferay-ui:search-container-column-text>
	</liferay-ui:search-container-row>

	<liferay-ui:search-iterator
		markupView="lexicon"
	/>
</liferay-ui:search-container>