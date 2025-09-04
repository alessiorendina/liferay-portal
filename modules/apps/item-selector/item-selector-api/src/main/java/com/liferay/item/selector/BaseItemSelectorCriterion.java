/**
 * SPDX-FileCopyrightText: (c) 2000 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.item.selector;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.security.permission.ActionKeys;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.service.permission.GroupPermissionUtil;
import com.liferay.portal.kernel.util.ListUtil;

import java.util.List;

/**
 * @author Iván Zaera
 */
public abstract class BaseItemSelectorCriterion
	implements ItemSelectorCriterion {

	@Override
	public boolean hasPermission(Group group, PermissionChecker permissionChecker)
		throws PortalException {

		return permissionChecker.isGroupAdmin(group.getGroupId()) ||
		   GroupPermissionUtil.contains(
			   permissionChecker, group, ActionKeys.VIEW);
	}

	@Override
	public List<ItemSelectorReturnType> getDesiredItemSelectorReturnTypes() {
		return _desiredItemSelectorReturnTypes;
	}

	@Override
	public void setDesiredItemSelectorReturnTypes(
		ItemSelectorReturnType... desiredItemSelectorReturnType) {

		_desiredItemSelectorReturnTypes = ListUtil.fromArray(
			desiredItemSelectorReturnType);
	}

	@Override
	public void setDesiredItemSelectorReturnTypes(
		List<ItemSelectorReturnType> desiredItemSelectorReturnTypes) {

		_desiredItemSelectorReturnTypes = desiredItemSelectorReturnTypes;
	}

	private List<ItemSelectorReturnType> _desiredItemSelectorReturnTypes;

}