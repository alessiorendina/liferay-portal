<%@ page
	import="com.liferay.portlet.usersadmin.search.OrganizationDisplayTerms" %>
<%@ include file="/init.jsp" %>

<commerce-ui:modal-content
	submitButtonLabel='<%= LanguageUtil.get(request, "add") %>'
	title='<%= LanguageUtil.get(request, "add-shipping-option") %>'
>
	<portlet:actionURL name="/account_entry/edit_account_entry_shipping_option" var="editAccountEntryShippingOptionActionURL" />

	<aui:form cssClass="container-fluid container-fluid-max-xl" method="post" name="fm">
		<div class="lfr-form-content">

			<aui:select label="channels" name="commerceChannelId" required="<%= true %>" />

			<div id="options">

			</div>
		</div>
	</aui:form>

</commerce-ui:modal-content>
<aui:script use="liferay-dynamic-select" require="commerce-frontend-js/ServiceProvider/index as ServiceProvider">
	new Liferay.DynamicSelect([
		{
			select: '<portlet:namespace />commerceChannelId',
			selectData: function (callback, selectKey) {
				var CommerceChannelsResource = ServiceProvider.default.AdminChannelAPI(
					'v1'
				);
				CommerceChannelsResource.getShippingMethods(Number(selectKey))

	Liferay.Service(
					'/commerce.commercecountrymanagerimpl/get-billing-countries-by-channel-id',
					{
						channelId: <%= commerceContext.getCommerceChannelId() %>,
						end: -1,
						start: -1,
					},
					callback
				);
			},
			selectDesc: 'nameCurrentValue',
			selectId: 'countryId',
			selectSort: '<%= true %>',
			selectVal: '<%= countryId %>',
		},
	]);
</aui:script>