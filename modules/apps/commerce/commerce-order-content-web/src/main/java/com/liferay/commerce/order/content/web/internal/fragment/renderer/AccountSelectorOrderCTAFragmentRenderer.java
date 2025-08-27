/**
 * SPDX-FileCopyrightText: (c) 2000 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.commerce.order.content.web.internal.fragment.renderer;

import com.liferay.fragment.renderer.FragmentRenderer;
import com.liferay.fragment.renderer.FragmentRendererContext;
import com.liferay.portal.kernel.language.Language;
import com.liferay.portal.kernel.theme.PortletDisplay;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.HashMapBuilder;
import com.liferay.portal.kernel.util.Portal;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.template.react.renderer.ComponentDescriptor;
import com.liferay.portal.template.react.renderer.ReactRenderer;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.io.IOException;
import java.util.Locale;

/**
 * @author Alec Sloan
 * @author Alessio Antonio Rendina
 */
@Component(service = FragmentRenderer.class)
public class AccountSelectorOrderCTAFragmentRenderer implements FragmentRenderer {

	@Override
	public String getCollectionKey() {
		return "COMMERCE_ACCOUNT_FRAGMENTS";
	}

	@Override
	public String getLabel(Locale locale) {
		return _language.get(locale, "account-selector-order-cta");
	}

	@Override
	public boolean isSelectable(HttpServletRequest httpServletRequest) {
		return true;
	}

	@Override
	public void render(
			FragmentRendererContext fragmentRendererContext,
			HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse)
		throws IOException {

		try {
			String randomKey = _portal.generateRandomKey(
				httpServletRequest, "account.selector.cta.renderer");

			String componentId = randomKey + "AccountSelectorOrderCTA";

			ThemeDisplay themeDisplay =
				(ThemeDisplay)httpServletRequest.getAttribute(
					WebKeys.THEME_DISPLAY);

			_reactRenderer.renderReact(
				new ComponentDescriptor(
					"{AccountSelectorOrderCTA} from commerce-order-content-web",
					componentId),
				HashMapBuilder.<String, Object>put(
					"namespace",
					() -> {
						PortletDisplay portletDisplay =
							themeDisplay.getPortletDisplay();

						return portletDisplay.getNamespace();
					}
				).build(),
				httpServletRequest, httpServletResponse.getWriter());
		}
		catch (Exception exception) {
			throw new RuntimeException(exception);
		}
	}

	@Reference
	private ReactRenderer _reactRenderer;

	@Reference
	private Portal _portal;

	@Reference
	private Language _language;

}