/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * The contents of this file are subject to the terms of the Liferay Enterprise
 * Subscription License ("License"). You may not use this file except in
 * compliance with the License. You can obtain a copy of the License by
 * contacting Liferay, Inc. See the License for the specific language governing
 * permissions and limitations under the License, including but not limited to
 * distribution rights of the Software.
 *
 *
 *
 */

package com.liferay.headless.commerce.shop.by.diagram.internal.dto.v1_0.converter;

import com.liferay.commerce.product.model.CPDefinition;
import com.liferay.commerce.product.model.CPInstance;
import com.liferay.commerce.product.model.CProduct;
import com.liferay.commerce.product.service.CPDefinitionService;
import com.liferay.commerce.product.service.CPInstanceService;
import com.liferay.commerce.shop.by.diagram.model.CPDefinitionDiagramEntry;
import com.liferay.commerce.shop.by.diagram.service.CPDefinitionDiagramEntryService;
import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.headless.commerce.shop.by.diagram.dto.v1_0.DiagramEntry;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.vulcan.dto.converter.DTOConverter;
import com.liferay.portal.vulcan.dto.converter.DTOConverterContext;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Alessio Antonio Rendina
 */
@Component(
	enabled = false,
	property = "model.class.name=com.liferay.commerce.shop.by.diagram.model.CPDefinitionDiagramEntry",
	service = {DiagramEntryDTOConverter.class, DTOConverter.class}
)
public class DiagramEntryDTOConverter
	implements DTOConverter<CPDefinitionDiagramEntry, DiagramEntry> {

	@Override
	public String getContentType() {
		return DiagramEntry.class.getSimpleName();
	}

	@Override
	public DiagramEntry toDTO(DTOConverterContext dtoConverterContext)
		throws Exception {

		CPDefinitionDiagramEntry cpDefinitionDiagramEntry =
			_cpDefinitionDiagramEntryService.getCPDefinitionDiagramEntry(
				(Long)dtoConverterContext.getId());

		ExpandoBridge expandoBridge =
			cpDefinitionDiagramEntry.getExpandoBridge();

		return new DiagramEntry() {
			{
				diagram = cpDefinitionDiagramEntry.isDiagram();
				expando = expandoBridge.getAttributes();
				id = cpDefinitionDiagramEntry.getCPDefinitionDiagramEntryId();

				setProductExternalReferenceCode(
					() -> {
						CPDefinition cpDefinition =
							_cpDefinitionService.fetchCPDefinitionByCProductId(
								cpDefinitionDiagramEntry.getCProductId());

						if (cpDefinition == null) {
							return StringPool.BLANK;
						}

						CProduct cProduct = cpDefinition.getCProduct();

						return cProduct.getExternalReferenceCode();
					});

				productId = cpDefinitionDiagramEntry.getCProductId();
				quantity = cpDefinitionDiagramEntry.getQuantity();
				sequence = cpDefinitionDiagramEntry.getSequence();

				setSkuExternalReferenceCode(
					() -> {
						CPInstance cpInstance = _cpInstanceService.fetchCPInstance(
							GetterUtil.getLong(cpDefinitionDiagramEntry.getCPInstanceUuid()));

						if (cpInstance == null) {
							return StringPool.BLANK;
						}

						return cpInstance.getExternalReferenceCode();
					});

				sku = cpDefinitionDiagramEntry.getSku();
				skuUuid = cpDefinitionDiagramEntry.getCPInstanceUuid();
			}
		};
	}

	@Reference
	private CPDefinitionDiagramEntryService _cpDefinitionDiagramEntryService;

	@Reference
	private CPDefinitionService _cpDefinitionService;

	@Reference
	private CPInstanceService _cpInstanceService;

}