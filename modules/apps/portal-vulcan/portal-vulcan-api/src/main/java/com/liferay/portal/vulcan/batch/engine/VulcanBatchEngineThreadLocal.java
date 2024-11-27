/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.portal.vulcan.batch.engine;

import com.liferay.petra.lang.CentralizedThreadLocal;

/**
 * @author Alessio Antonio Rendina
 */
public class VulcanBatchEngineThreadLocal {

	public static boolean isLazyLoad() {
		return _lazyLoad.get();
	}

	public static void setLazyLoad(boolean lazyLoad) {
		_lazyLoad.set(lazyLoad);
	}

	private static final ThreadLocal<Boolean> _lazyLoad =
		new CentralizedThreadLocal<>(
			VulcanBatchEngineThreadLocal.class + "._lazyLoad",
			() -> Boolean.FALSE);

}