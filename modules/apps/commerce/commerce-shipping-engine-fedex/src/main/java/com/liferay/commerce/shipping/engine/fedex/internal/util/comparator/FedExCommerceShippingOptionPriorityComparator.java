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

package com.liferay.commerce.shipping.engine.fedex.internal.util.comparator;

import com.liferay.commerce.model.CommerceShippingOption;

import java.io.Serializable;

import java.util.Comparator;

/**
 * @author Crescenzo Rega
 */
public class FedExCommerceShippingOptionPriorityComparator
	implements Comparator<CommerceShippingOption>, Serializable {

	public FedExCommerceShippingOptionPriorityComparator() {
		_ascending = false;
	}

	public FedExCommerceShippingOptionPriorityComparator(boolean ascending) {
		_ascending = ascending;
	}

	@Override
	public int compare(
		CommerceShippingOption commerceShippingOption1,
		CommerceShippingOption commerceShippingOption2) {

		int value = Double.compare(
			commerceShippingOption1.getPriority(),
			commerceShippingOption2.getPriority());

		if (_ascending) {
			return value;
		}

		return Math.negateExact(value);
	}

	private final boolean _ascending;

}