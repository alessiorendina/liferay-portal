/**
 * SPDX-FileCopyrightText: (c) 2000 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

const panels = [];
const accountSelectorDropdown = fragmentElement.querySelector('#account-selector-dropdown');
const testButton = fragmentElement.querySelector('#testButton');
let accountSelectorDropdownHeader;
let dropdownPrevButton;
let dropdownNextButton;

testButton.addEventListener('click', () => {
	const dropdownPanels = document.querySelectorAll('.account-selector-panel-content');

	dropdownPanels.forEach((value, index) => {
		panels.push({index, value});
	})

	accountSelectorDropdown.classList.remove('hide');

	dropdownPrevButton = fragmentElement.querySelector('#dropdown-prev-button');
	dropdownNextButton = fragmentElement.querySelector('#dropdown-next-button');

	accountSelectorDropdownHeader = fragmentElement.querySelector('#account-selector-dropdown-header');

	dropdownPrevButton.addEventListener('click', () => {
		const step = Number(accountSelectorDropdownHeader.dataset.step);

		handleNav(step, step - 1);
	});

	dropdownNextButton.addEventListener('click', () => {
		const step = Number(accountSelectorDropdownHeader.dataset.step);

		handleNav(step, step + 1);
	});
});

function handleNav(step, nextStep) {
	const curPanel = panels[step];

	if (curPanel.index === (panels.length - 1)) {
		dropdownNextButton.classList.add('hide');
		dropdownPrevButton.classList.remove('hide');
	}

	if (curPanel.index === 0) {
		dropdownPrevButton.classList.add('hide');
		dropdownNextButton.classList.remove('hide');
	}

	accountSelectorDropdownHeader.dataset.step = nextStep;

	curPanel.value.classList.add('hide');
	panels[nextStep].value.classList.remove('hide');
}