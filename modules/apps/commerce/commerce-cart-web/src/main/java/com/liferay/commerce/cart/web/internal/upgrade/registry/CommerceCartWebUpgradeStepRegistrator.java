/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.asset.categories.navigation.web.internal.upgrade.registry;

import com.liferay.commerce.cart.web.internal.portlet.configuration.CommerceCartMiniPortletInstanceConfiguration;
import com.liferay.commerce.cart.web.internal.portlet.configuration.CommerceCartPortletInstanceConfiguration;
import com.liferay.commerce.cart.web.internal.portlet.configuration.CommerceCartTotalPortletInstanceConfiguration;
import com.liferay.commerce.constants.CommercePortletKeys;
import com.liferay.portal.configuration.persistence.upgrade.ConfigurationUpgradeStepFactory;
import com.liferay.portal.kernel.upgrade.BasePortletIdUpgradeProcess;
import com.liferay.portal.upgrade.registry.UpgradeStepRegistrator;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Alessio Antonio Rendina
 */
@Component(service = UpgradeStepRegistrator.class)
public class CommerceCartWebUpgradeStepRegistrator
	implements UpgradeStepRegistrator {

	@Override
	public void register(Registry registry) {
		registry.registerInitialization();

		registry.register(
			"0.0.1", "1.0.0",
			new BasePortletIdUpgradeProcess() {

				@Override
				protected String[][] getRenamePortletIdsArray() {
					return new String[][] {
						{
							"com_liferay_commerce_cart_content_web_internal_portlet_CommerceCartPortlet",
							CommercePortletKeys.COMMERCE_CART
						},
						{
							"com_liferay_commerce_cart_content_web_internal_portlet_CommerceCartMiniPortlet",
							CommercePortletKeys.COMMERCE_CART_MINI
						},
						{
							"com_liferay_commerce_cart_content_web_internal_portlet_CommerceCartTotalPortlet",
							CommercePortletKeys.COMMERCE_CART_TOTAL
						}
					};
				}

			});

		registry.register(
			"1.0.0", "1.0.1",
			_configurationUpgradeStepFactory.createUpgradeStep(
				"com.liferay.commerce.content.web.configuration." +
					"CommerceCartContentPortletInstanceConfiguration",
				CommerceCartPortletInstanceConfiguration.class.getName()),
			_configurationUpgradeStepFactory.createUpgradeStep(
				"com.liferay.commerce.content.web.configuration." +
					"CommerceCartMiniContentPortletInstanceConfiguration",
				CommerceCartMiniPortletInstanceConfiguration.class.getName()),
			_configurationUpgradeStepFactory.createUpgradeStep(
				"com.liferay.commerce.content.web.configuration." +
					"CommerceCartTotalContentPortletInstanceConfiguration",
				CommerceCartTotalPortletInstanceConfiguration.class.getName()));
	}

	@Reference
	private ConfigurationUpgradeStepFactory _configurationUpgradeStepFactory;

}