/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

import {Locator, Page, expect} from '@playwright/test';

import {FormsPage} from './FormsPage';

export class FormBuilderPage {
	readonly entriesTab: Locator;
	readonly formsPage: FormsPage;
	readonly formSettingsButton: Locator;
	readonly formSettingsDoneButton: Locator;
	readonly formTitle: Locator;
	readonly openFormButton: Locator;
	readonly page: Page;
	readonly previewButton: Locator;
	readonly publishButton: Locator;
	readonly newFormHeading: Locator;
	readonly newPageButton: Locator;
	readonly requireCaptchaToggle: Locator;

	constructor(page: Page) {
		this.entriesTab = page.getByRole('button', {name: 'Entries'});
		this.formsPage = new FormsPage(page);
		this.formSettingsButton = page.getByRole('button', {name: 'Settings'});
		this.formSettingsDoneButton = page.getByRole('button', {name: 'Done'});
		this.formTitle = page.getByPlaceholder('Untitled Form');
		this.openFormButton = page.getByRole('button', {
			name: 'Open Form',
		});
		this.page = page;
		this.previewButton = page.getByRole('button', {name: 'Preview'});
		this.publishButton = page.getByRole('button', {name: 'Publish'});
		this.newFormHeading = page.getByRole('heading', {name: 'New Form'});
		this.newPageButton = page.getByRole('button', {name: 'New Page'});
		this.requireCaptchaToggle = page.getByLabel('Require CAPTCHA');
	}

	async clickPreviewButton() {
		await this.previewButton.click();
	}

	async fillFormTitle(title: string) {
		await this.formTitle.fill(title);
	}

	async goToNew() {
		await this.formsPage.goTo();

		await expect(this.formsPage.formsHeader).toBeVisible();

		await this.formsPage.clickManagementToolbarNewButton();
	}

	async openFormSubmission() {
		await this.publishButton.click();

		await this.page
			.locator('#ToastAlertContainer')
			.getByLabel('Close')
			.click();

		await this.openFormButton.click();
	}
}
