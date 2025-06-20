<%--
/**
 * SPDX-FileCopyrightText: (c) 2000 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */
--%>

<%@ include file="/init.jsp" %>

<%
CPCategoryDisplayContext cpCategoryDisplayContext = (CPCategoryDisplayContext)request.getAttribute(WebKeys.PORTLET_DISPLAY_CONTEXT);

AssetCategory assetCategory = cpCategoryDisplayContext.getAssetCategory();

List<AssetCategory> assetCategoryList = new ArrayList<>();

assetCategoryList.add(assetCategory);
%>

<liferay-ddm:template-renderer
	className="<%= CPCategoryPortlet.class.getName() %>"
	contextObjects='<%=
		HashMapBuilder.<String, Object>put(
			"assetCategory", assetCategory
		).put(
			"cpCategoryDisplayContext", cpCategoryDisplayContext
		).build()
	%>'
	displayStyle="<%= cpCategoryDisplayContext.getDisplayStyle() %>"
	displayStyleGroupId="<%= cpCategoryDisplayContext.getDisplayStyleGroupId() %>"
	entries="<%= assetCategoryList %>"
>
	<c:if test="<%= assetCategory != null %>">
		<div class="category-detail">

			<%
			String imgURL = cpCategoryDisplayContext.getDefaultImageSrc();
			%>

			<c:if test="<%= Validator.isNotNull(imgURL) %>">
				<div class="category-image">
					<img class="img-fluid" src="<%= HtmlUtil.escapeAttribute(imgURL) %>" />
				</div>
			</c:if>

			<div class="container-fluid">
				<h1 class="category-title"><%= HtmlUtil.escape(assetCategory.getTitle(languageId)) %></h1>

				<p class="category-description"><%= HtmlUtil.stripHtml(assetCategory.getDescription(languageId)) %></p>
			</div>
		</div>
	</c:if>
</liferay-ddm:template-renderer>