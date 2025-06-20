<%--
/**
 * SPDX-FileCopyrightText: (c) 2000 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */
--%>

<%@ include file="/init.jsp" %>

<%
CommerceCartDisplayContext commerceCartDisplayContext = (CommerceCartDisplayContext)request.getAttribute(WebKeys.PORTLET_DISPLAY_CONTEXT);

Map<String, Object> contextObjects = HashMapBuilder.<String, Object>put(
	"commerceCartDisplayContext", commerceCartDisplayContext
).build();

SearchContainer<CommerceOrderItem> commerceOrderItemSearchContainer = commerceCartDisplayContext.getSearchContainer();

PortletURL portletURL = PortletURLBuilder.create(
	commerceCartDisplayContext.getPortletURL()
).setParameter(
	"searchContainerId", "commerceOrderItems"
).buildPortletURL();

request.setAttribute("view.jsp-portletURL", portletURL);

List<CommerceOrderValidatorResult> commerceOrderValidatorResults = new ArrayList<>();

Map<Long, List<CommerceOrderValidatorResult>> commerceOrderValidatorResultsMap = commerceCartDisplayContext.getCommerceOrderValidatorResults();
%>

<liferay-ui:error exception="<%= CommerceOrderValidatorException.class %>">

	<%
	CommerceOrderValidatorException commerceOrderValidatorException = (CommerceOrderValidatorException)errorException;

	if (commerceOrderValidatorException != null) {
		commerceOrderValidatorResults = commerceOrderValidatorException.getCommerceOrderValidatorResults();
	}

	for (CommerceOrderValidatorResult commerceOrderValidatorResult : commerceOrderValidatorResults) {
	%>

		<liferay-ui:message key="<%= HtmlUtil.escape(commerceOrderValidatorResult.getLocalizedMessage()) %>" />

	<%
	}
	%>

</liferay-ui:error>

<liferay-ddm:template-renderer
	className="<%= CommerceCartPortlet.class.getName() %>"
	contextObjects="<%= contextObjects %>"
	displayStyle="<%= commerceCartDisplayContext.getDisplayStyle() %>"
	displayStyleGroupId="<%= commerceCartDisplayContext.getDisplayStyleGroupId() %>"
	entries="<%= commerceOrderItemSearchContainer.getResults() %>"
>
	<div class="commerce-order-items container-fluid container-fluid-max-xl" id="<portlet:namespace />orderItemsContainer">
		<div class="commerce-order-items-container" id="<portlet:namespace />entriesContainer">
			<liferay-ui:search-container
				id="commerceOrderItems"
				iteratorURL="<%= portletURL %>"
				searchContainer="<%= commerceOrderItemSearchContainer %>"
			>
				<liferay-ui:search-container-row
					className="com.liferay.commerce.model.CommerceOrderItem"
					keyProperty="CommerceOrderItemId"
					modelVar="commerceOrderItem"
				>

					<%
					CPInstance cpInstance = commerceOrderItem.fetchCPInstance();

					long cpDefinitionId = 0;

					StringJoiner stringJoiner = new StringJoiner(StringPool.COMMA);

					String cpInstanceCDNURL = commerceCartDisplayContext.getCPInstanceCDNURL(commerceOrderItem);

					if (cpInstance != null) {
						CPDefinition cpDefinition = commerceOrderItem.getCPDefinition();

						cpDefinitionId = cpDefinition.getCPDefinitionId();

						for (KeyValuePair keyValuePair : commerceCartDisplayContext.getKeyValuePairs(commerceOrderItem.getCPDefinitionId(), commerceOrderItem.getJson(), locale)) {
							stringJoiner.add(keyValuePair.getValue());
						}
					}
					%>

					<liferay-ui:search-container-column-text
						name="product"
					>
						<span class="sticker sticker-xl">
							<span class="sticker-overlay">
								<c:choose>
									<c:when test="<%= Validator.isNotNull(cpInstanceCDNURL) %>">
										<img alt="thumbnail" class="sticker-img" src="<%= cpInstanceCDNURL %>" />
									</c:when>
									<c:otherwise>
										<liferay-adaptive-media:img
											alt="thumbnail"
											class="sticker-img"
											fileVersion="<%= commerceCartDisplayContext.getCPInstanceImageFileVersion(commerceOrderItem) %>"
										/>
									</c:otherwise>
								</c:choose>
							</span>
						</span>
					</liferay-ui:search-container-column-text>

					<liferay-ui:search-container-column-text
						name="description"
					>
						<a class="font-weight-bold" href="<%= (cpDefinitionId == 0) ? StringPool.BLANK : commerceCartDisplayContext.getCPDefinitionURL(cpDefinitionId, themeDisplay) %>">
							<%= HtmlUtil.escape(commerceOrderItem.getName(languageId)) %>
						</a>

						<div class="h6 text-default">
							<%= HtmlUtil.escape(stringJoiner.toString()) %>
						</div>

						<c:if test="<%= !commerceOrderValidatorResultsMap.isEmpty() %>">

							<%
							commerceOrderValidatorResults = commerceOrderValidatorResultsMap.get(commerceOrderItem.getCommerceOrderItemId());

							for (CommerceOrderValidatorResult commerceOrderValidatorResult : commerceOrderValidatorResults) {
							%>

								<div class="alert-danger commerce-alert-danger">
									<liferay-ui:message key="<%= HtmlUtil.escape(commerceOrderValidatorResult.getLocalizedMessage()) %>" />
								</div>

							<%
							}
							%>

						</c:if>
					</liferay-ui:search-container-column-text>

					<liferay-ui:search-container-column-text
						name="price"
					>
						<c:if test="<%= commerceCartDisplayContext.hasViewPricePermission() %>">

							<%
							CommerceMoney unitPriceCommerceMoney = commerceCartDisplayContext.getUnitPriceCommerceMoney(commerceOrderItem);
							CommerceMoney unitPromoPriceCommerceMoney = commerceCartDisplayContext.getUnitPromoPriceCommerceMoney(commerceOrderItem);
							%>

							<c:choose>
								<c:when test="<%= commerceCartDisplayContext.isUnitPromoPriceActive(commerceOrderItem) %>">
									<%= HtmlUtil.escape(unitPromoPriceCommerceMoney.format(locale)) %>
								</c:when>
								<c:otherwise>
									<%= HtmlUtil.escape(unitPriceCommerceMoney.format(locale)) %>
								</c:otherwise>
							</c:choose>
						</c:if>
					</liferay-ui:search-container-column-text>

					<liferay-ui:search-container-column-text
						name="discount"
					>
						<c:if test="<%= commerceCartDisplayContext.hasViewPricePermission() %>">

							<%
							CommerceMoney discountAmountCommerceMoney = commerceCartDisplayContext.getDiscountAmountCommerceMoney(commerceOrderItem);
							%>

							<%= HtmlUtil.escape(discountAmountCommerceMoney.format(locale)) %>
						</c:if>
					</liferay-ui:search-container-column-text>

					<liferay-ui:search-container-column-text
						cssClass="quantity-control-column"
						name="quantity"
					>
						<liferay-commerce-cart:quantity-control
							commerceOrderItemId="<%= commerceOrderItem.getCommerceOrderItemId() %>"
							useSelect="<%= false %>"
						/>
					</liferay-ui:search-container-column-text>

					<liferay-ui:search-container-column-text
						name="total"
					>
						<c:if test="<%= commerceCartDisplayContext.hasViewPricePermission() %>">

							<%
							CommerceMoney finalPriceCommerceMoney = commerceCartDisplayContext.getFinalPriceCommerceMoney(commerceOrderItem);
							%>

							<%= HtmlUtil.escape(finalPriceCommerceMoney.format(locale)) %>

							<commerce-ui:product-subscription-info
								CPInstanceId="<%= commerceOrderItem.getCPInstanceId() %>"
								showDuration="<%= false %>"
							/>
						</c:if>
					</liferay-ui:search-container-column-text>

					<liferay-ui:search-container-column-text>
						<c:if test="<%= commerceCartDisplayContext.hasPermission(ActionKeys.UPDATE) %>">
							<liferay-ui:icon-delete
								label="<%= true %>"
								url="<%= commerceCartDisplayContext.getDeleteURL(commerceOrderItem) %>"
							/>
						</c:if>
					</liferay-ui:search-container-column-text>
				</liferay-ui:search-container-row>

				<liferay-ui:search-iterator
					displayStyle="list"
					markupView="lexicon"
					searchContainer="<%= commerceOrderItemSearchContainer %>"
				/>
			</liferay-ui:search-container>
		</div>
	</div>

	<liferay-frontend:component
		module="{cartView} from commerce-cart-web"
	/>
</liferay-ddm:template-renderer>