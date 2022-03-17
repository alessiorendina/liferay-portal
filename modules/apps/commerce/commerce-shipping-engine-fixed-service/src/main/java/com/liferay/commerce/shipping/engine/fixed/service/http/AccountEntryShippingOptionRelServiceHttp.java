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

package com.liferay.commerce.shipping.engine.fixed.service.http;

import com.liferay.commerce.shipping.engine.fixed.service.AccountEntryShippingOptionRelServiceUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.security.auth.HttpPrincipal;
import com.liferay.portal.kernel.service.http.TunnelUtil;
import com.liferay.portal.kernel.util.MethodHandler;
import com.liferay.portal.kernel.util.MethodKey;

/**
 * Provides the HTTP utility for the
 * <code>AccountEntryShippingOptionRelServiceUtil</code> service
 * utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it requires an additional
 * <code>HttpPrincipal</code> parameter.
 *
 * <p>
 * The benefits of using the HTTP utility is that it is fast and allows for
 * tunneling without the cost of serializing to text. The drawback is that it
 * only works with Java.
 * </p>
 *
 * <p>
 * Set the property <b>tunnel.servlet.hosts.allowed</b> in portal.properties to
 * configure security.
 * </p>
 *
 * <p>
 * The HTTP utility is only generated for remote services.
 * </p>
 *
 * @author Alessio Antonio Rendina
 * @generated
 */
public class AccountEntryShippingOptionRelServiceHttp {

	public static com.liferay.commerce.shipping.engine.fixed.model.
		AccountEntryShippingOptionRel addAccountEntryShippingOptionRel(
				HttpPrincipal httpPrincipal, long accountEntryId,
				long channelId, String shippingMethodKey,
				String shippingOptionKey)
			throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(
				AccountEntryShippingOptionRelServiceUtil.class,
				"addAccountEntryShippingOptionRel",
				_addAccountEntryShippingOptionRelParameterTypes0);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, accountEntryId, channelId, shippingMethodKey,
				shippingOptionKey);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				if (exception instanceof
						com.liferay.portal.kernel.exception.PortalException) {

					throw (com.liferay.portal.kernel.exception.PortalException)
						exception;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (com.liferay.commerce.shipping.engine.fixed.model.
				AccountEntryShippingOptionRel)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static void deleteAccountEntryShippingOptionRelsByShippingOptionKey(
			HttpPrincipal httpPrincipal, long accountEntryId,
			String shippingOptionKey)
		throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(
				AccountEntryShippingOptionRelServiceUtil.class,
				"deleteAccountEntryShippingOptionRelsByShippingOptionKey",
				_deleteAccountEntryShippingOptionRelsByShippingOptionKeyParameterTypes1);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, accountEntryId, shippingOptionKey);

			try {
				TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				if (exception instanceof
						com.liferay.portal.kernel.exception.PortalException) {

					throw (com.liferay.portal.kernel.exception.PortalException)
						exception;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.liferay.commerce.shipping.engine.fixed.model.
		AccountEntryShippingOptionRel fetchAccountEntryShippingOptionRel(
				HttpPrincipal httpPrincipal, long accountEntryId,
				long channelId, long companyId)
			throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(
				AccountEntryShippingOptionRelServiceUtil.class,
				"fetchAccountEntryShippingOptionRel",
				_fetchAccountEntryShippingOptionRelParameterTypes2);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, accountEntryId, channelId, companyId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				if (exception instanceof
						com.liferay.portal.kernel.exception.PortalException) {

					throw (com.liferay.portal.kernel.exception.PortalException)
						exception;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (com.liferay.commerce.shipping.engine.fixed.model.
				AccountEntryShippingOptionRel)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.liferay.commerce.shipping.engine.fixed.model.
		AccountEntryShippingOptionRel fetchAccountEntryShippingOptionRel(
				HttpPrincipal httpPrincipal, long accountEntryId,
				long channelId, long companyId, String shippingOptionKey)
			throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(
				AccountEntryShippingOptionRelServiceUtil.class,
				"fetchAccountEntryShippingOptionRel",
				_fetchAccountEntryShippingOptionRelParameterTypes3);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, accountEntryId, channelId, companyId,
				shippingOptionKey);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				if (exception instanceof
						com.liferay.portal.kernel.exception.PortalException) {

					throw (com.liferay.portal.kernel.exception.PortalException)
						exception;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (com.liferay.commerce.shipping.engine.fixed.model.
				AccountEntryShippingOptionRel)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static java.util.List
		<com.liferay.commerce.shipping.engine.fixed.model.
			AccountEntryShippingOptionRel>
					getAccountEntryShippingOptionRelsByShippingOptionKey(
						HttpPrincipal httpPrincipal, long accountEntryId,
						String shippingOptionKey)
				throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(
				AccountEntryShippingOptionRelServiceUtil.class,
				"getAccountEntryShippingOptionRelsByShippingOptionKey",
				_getAccountEntryShippingOptionRelsByShippingOptionKeyParameterTypes4);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, accountEntryId, shippingOptionKey);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				if (exception instanceof
						com.liferay.portal.kernel.exception.PortalException) {

					throw (com.liferay.portal.kernel.exception.PortalException)
						exception;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (java.util.List
				<com.liferay.commerce.shipping.engine.fixed.model.
					AccountEntryShippingOptionRel>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static java.util.List
		<com.liferay.commerce.shipping.engine.fixed.model.
			AccountEntryShippingOptionRel>
					getAccountEntryShippingOptionRelsByShippingOptionKey(
						HttpPrincipal httpPrincipal, long accountEntryId,
						String shippingOptionKey, int start, int end)
				throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(
				AccountEntryShippingOptionRelServiceUtil.class,
				"getAccountEntryShippingOptionRelsByShippingOptionKey",
				_getAccountEntryShippingOptionRelsByShippingOptionKeyParameterTypes5);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, accountEntryId, shippingOptionKey, start, end);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				if (exception instanceof
						com.liferay.portal.kernel.exception.PortalException) {

					throw (com.liferay.portal.kernel.exception.PortalException)
						exception;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (java.util.List
				<com.liferay.commerce.shipping.engine.fixed.model.
					AccountEntryShippingOptionRel>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static int getAccountEntryShippingOptionRelsByShippingOptionKeyCount(
			HttpPrincipal httpPrincipal, long accountEntryId,
			String shippingOptionKey)
		throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(
				AccountEntryShippingOptionRelServiceUtil.class,
				"getAccountEntryShippingOptionRelsByShippingOptionKeyCount",
				_getAccountEntryShippingOptionRelsByShippingOptionKeyCountParameterTypes6);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, accountEntryId, shippingOptionKey);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				if (exception instanceof
						com.liferay.portal.kernel.exception.PortalException) {

					throw (com.liferay.portal.kernel.exception.PortalException)
						exception;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return ((Integer)returnObj).intValue();
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.liferay.commerce.shipping.engine.fixed.model.
		AccountEntryShippingOptionRel updateAccountEntryShippingOptionRel(
				HttpPrincipal httpPrincipal,
				long accountEntryShippingOptionRelId, long accountEntryId,
				long channelId, long companyId, String shippingMethodKey,
				String shippingOptionKey)
			throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(
				AccountEntryShippingOptionRelServiceUtil.class,
				"updateAccountEntryShippingOptionRel",
				_updateAccountEntryShippingOptionRelParameterTypes7);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, accountEntryShippingOptionRelId, accountEntryId,
				channelId, companyId, shippingMethodKey, shippingOptionKey);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				if (exception instanceof
						com.liferay.portal.kernel.exception.PortalException) {

					throw (com.liferay.portal.kernel.exception.PortalException)
						exception;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (com.liferay.commerce.shipping.engine.fixed.model.
				AccountEntryShippingOptionRel)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	private static Log _log = LogFactoryUtil.getLog(
		AccountEntryShippingOptionRelServiceHttp.class);

	private static final Class<?>[]
		_addAccountEntryShippingOptionRelParameterTypes0 = new Class[] {
			long.class, long.class, String.class, String.class
		};
	private static final Class<?>[]
		_deleteAccountEntryShippingOptionRelsByShippingOptionKeyParameterTypes1 =
			new Class[] {long.class, String.class};
	private static final Class<?>[]
		_fetchAccountEntryShippingOptionRelParameterTypes2 = new Class[] {
			long.class, long.class, long.class
		};
	private static final Class<?>[]
		_fetchAccountEntryShippingOptionRelParameterTypes3 = new Class[] {
			long.class, long.class, long.class, String.class
		};
	private static final Class<?>[]
		_getAccountEntryShippingOptionRelsByShippingOptionKeyParameterTypes4 =
			new Class[] {long.class, String.class};
	private static final Class<?>[]
		_getAccountEntryShippingOptionRelsByShippingOptionKeyParameterTypes5 =
			new Class[] {long.class, String.class, int.class, int.class};
	private static final Class<?>[]
		_getAccountEntryShippingOptionRelsByShippingOptionKeyCountParameterTypes6 =
			new Class[] {long.class, String.class};
	private static final Class<?>[]
		_updateAccountEntryShippingOptionRelParameterTypes7 = new Class[] {
			long.class, long.class, long.class, long.class, String.class,
			String.class
		};

}