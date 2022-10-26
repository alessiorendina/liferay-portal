/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.commerce.inventory.internal.engine;

import com.liferay.commerce.inventory.configuration.CommerceInventoryGroupConfiguration;
import com.liferay.commerce.inventory.engine.CommerceInventoryEngine;
import com.liferay.commerce.inventory.engine.contributor.CommerceInventoryEngineContributor;
import com.liferay.commerce.inventory.engine.contributor.CommerceInventoryEngineContributorRegistry;
import com.liferay.commerce.inventory.method.CommerceInventoryMethod;
import com.liferay.commerce.inventory.method.CommerceInventoryMethodRegistry;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.module.configuration.ConfigurationProvider;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;

import java.util.Map;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Luca Pellizzon
 * @author Alessio Antonio Rendina
 * @author Ivica Cardic
 */
@Component(immediate = true, service = CommerceInventoryEngine.class)
public class CommerceInventoryEngineImpl implements CommerceInventoryEngine {

	@Override
	@Transactional(
		propagation = Propagation.REQUIRED, rollbackFor = Exception.class
	)
	public void consumeQuantity(
			long userId, long commerceChannelGroupId,
			long commerceInventoryWarehouseId, String sku, int quantity,
			long bookedQuantityId, Map<String, String> context)
		throws PortalException {

		CommerceInventoryMethod commerceInventoryMethod =
			getCommerceInventoryMethod(commerceChannelGroupId);

		commerceInventoryMethod.consumeQuantity(
			userId, commerceInventoryWarehouseId, sku, quantity,
			bookedQuantityId, context);

		for (CommerceInventoryEngineContributor
				commerceInventoryEngineContributor :
					_commerceInventoryEngineContributorRegistry.
						getCommerceInventoryEngineContributors()) {

			commerceInventoryEngineContributor.consumeQuantityContribute(
				userId, commerceInventoryWarehouseId, sku, quantity,
				bookedQuantityId, context);
		}
	}

	@Override
	@Transactional(
		propagation = Propagation.REQUIRED, rollbackFor = Exception.class
	)
	public void decreaseStockQuantity(
			long userId, long commerceChannelGroupId,
			long commerceInventoryWarehouseId, String sku, int quantity)
		throws PortalException {

		CommerceInventoryMethod commerceInventoryMethod =
			getCommerceInventoryMethod(commerceChannelGroupId);

		commerceInventoryMethod.decreaseStockQuantity(
			userId, commerceInventoryWarehouseId, sku, quantity);

		for (CommerceInventoryEngineContributor
				commerceInventoryEngineContributor :
					_commerceInventoryEngineContributorRegistry.
						getCommerceInventoryEngineContributors()) {

			commerceInventoryEngineContributor.decreaseStockQuantityContribute(
				userId, commerceInventoryWarehouseId, sku, quantity);
		}
	}

	@Override
	public CommerceInventoryMethod getCommerceInventoryMethod(
			long commerceChannelGroupId)
		throws PortalException {

		CommerceInventoryGroupConfiguration
			commerceInventoryGroupConfiguration =
				_configurationProvider.getGroupConfiguration(
					CommerceInventoryGroupConfiguration.class,
					commerceChannelGroupId);

		return _commerceInventoryMethodRegistry.getCommerceInventoryMethod(
			commerceInventoryGroupConfiguration.inventoryMethodKey());
	}

	@Override
	@Transactional(
		propagation = Propagation.REQUIRED, rollbackFor = Exception.class
	)
	public void increaseStockQuantity(
			long userId, long commerceChannelGroupId,
			long commerceInventoryWarehouseId, String sku, int quantity)
		throws PortalException {

		CommerceInventoryMethod commerceInventoryMethod =
			getCommerceInventoryMethod(commerceChannelGroupId);

		commerceInventoryMethod.increaseStockQuantity(
			userId, commerceInventoryWarehouseId, sku, quantity);

		for (CommerceInventoryEngineContributor
				commerceInventoryEngineContributor :
					_commerceInventoryEngineContributorRegistry.
						getCommerceInventoryEngineContributors()) {

			commerceInventoryEngineContributor.increaseStockQuantityContribute(
				userId, commerceInventoryWarehouseId, sku, quantity);
		}
	}

	@Reference
	private CommerceInventoryEngineContributorRegistry
		_commerceInventoryEngineContributorRegistry;

	@Reference
	private CommerceInventoryMethodRegistry _commerceInventoryMethodRegistry;

	@Reference
	private ConfigurationProvider _configurationProvider;

}