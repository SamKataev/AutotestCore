package com.objects.npobjects.pageelements.dialogs;

import com.objects.PageElement;
import com.service.ui.web.SeleniumDriverWrapper;
import org.openqa.selenium.By;

public abstract class Dialog extends PageElement
{
	protected final By closeBtn = dialogIconFontBtn("ic_close");
	protected final By cancelBtn = dialogTextBtn("Cancel");
	protected final By doneBtn = dialogTextBtn("Done");
	protected final By okBtn = dialogTextBtn("OK");


	public Dialog(SeleniumDriverWrapper driver)
	{
		super(driver);
	}

	public boolean validateElements()
	{
		return driver.waitUntilClickable(closeBtn);
	}

	public void clickOk()
	{
		driver.click(okBtn);
	}

	public void clickCancel()
	{
		driver.click(cancelBtn);
	}

	public void clickClose()
	{
		driver.click(closeBtn);
	}

	protected By dialogListItemWithText(String text)
	{
		return By.xpath("//div[contains(@class, 'mdc-dialog--open')]//span[contains(@class, 'mdc-list-item__text') and contains(text(), '" + text + "')]/parent::li");
	}

	protected By dialogListItemWithText(String text, String dialogClass)
	{
		return By.xpath("//div[contains(@class, 'mdc-dialog--open') and contains(@class, '" + dialogClass + "')]//span[contains(@class, 'mdc-list-item__text') and contains(text(), '" + text + "')]/parent::li");
	}

	protected By dialogListItemWithTextIcon(String text, String iconClass)
	{
		return By.xpath("//div[contains(@class, 'mdc-dialog--open')]//span[contains(@class, 'mdc-list-item__text') and contains(text(), '" + text + "')]/preceding-sibling::span[contains(@class, '" + iconClass + "')]/parent::li");
	}

	protected By dialogIconFontBtn(String iconClass)
	{
		return By.xpath("//div[contains(@class, 'mdc-dialog--open')]//span[contains(@class, '" + iconClass + "')]/parent::span[contains(@class, 'mdc-icon-toggle')]");
	}

	protected By dialogIconFontBtn(String iconClass, String dialogClass)
	{
		return By.xpath("//div[contains(@class, 'mdc-dialog--open') and contains(@class, '" + dialogClass + "')]//span[contains(@class, '" + iconClass + "')]/parent::span[contains(@class, 'mdc-icon-toggle')]");
	}

	protected By dialogTextBtn(String btnText)
	{
		return By.xpath("//div[contains(@class, 'mdc-dialog--open')]//button[contains(@class, 'mdc-button') and contains(text(), '" + btnText + "')]");
	}

	protected By dialogTextBtn(String btnText, String dialogClass)
	{
		return By.xpath("//div[contains(@class, 'mdc-dialog--open') and contains(@class, '" + dialogClass + "')]//button[contains(@class, 'mdc-button') and contains(text(), '" + btnText + "')]");
	}

	protected By dialogAppBarTitle(String titleText)
	{
		return By.xpath("//div[contains(@class, 'mdc-dialog--open')]//span[contains(@class, 'mdc-top-app-bar__title') and contains(text(), '" + titleText + "')]");
	}

	protected By dialogAppBarTitle(String titleText, String dialogClass)
	{
		return By.xpath("//div[contains(@class, 'mdc-dialog--open') and contains(@class, '" + dialogClass + "')]//span[contains(@class, 'mdc-top-app-bar__title') and contains(text(), '" + titleText + "')]");
	}

	protected By dialogTextFieldWithLabel(String label)
	{
		return By.xpath("//div[contains(@class, 'mdc-dialog--open')]//label[contains(@class, text-field__label) and contains(text(), '" + label + "')]/following-sibling::div[contains(@class, 'text-field__input-container')]/input");
	}

	protected By dialogTextFieldWithLabel(String label, String dialogClass)
	{
		return By.xpath("//div[contains(@class, 'mdc-dialog--open') and contains(@class, '" + dialogClass + "')]//label[contains(@class, text-field__label) and contains(text(), '" + label + "')]/following-sibling::div[contains(@class, 'text-field__input-container')]/input");
	}


	//Accordion
	protected By dialogListAccordionWithText(String text)
	{
		return By.xpath("//div[contains(@class, 'mdc-dialog--open')]//span[contains(@class, 'mdc-list-item__text') and contains(text(), '" + text + "')]");
	}
//селект

	protected By dialogSelectWithLabel(String text)
	{
		return By.xpath("//div[contains(@class, 'mdc-dialog--open')]//label[contains(@class, text-field__label) and contains(text(), '" + text + "')]/following-sibling::div[contains(@class, 'select__native-control-container')]");
	}

	//текст сообщения
	protected By dialogTextMessage(String text)
	{
		return By.xpath("//div[contains(@class, 'mdc-dialog--open')]//div[contains(@class, 'mdc-dialog__content') and contains(text(), '" + text + "')]");
	}

	//block-setting-panel
	protected By panelAppBarTitle(String titleText)
	{
		return By.xpath("//div[contains(@class, 'block-settings-panel')]//span[contains(@class, 'mdc-top-app-bar__title') and contains(text(), '" + titleText + "')]");
	}

	protected By panelListItemWithTextIconBtn(String text, String iconClass)
	{
		return By.xpath("//div[contains(@class, 'block-settings-panel')]//span[contains(@class, 'mdc-list-item__text') and contains(text(), '" + text + "')]/preceding-sibling::span[contains(@class, '" + iconClass + "')]/parent::li");
	}

	//app-bar btn
	protected By dialogAppBarTextBtn(String btnText)
	{
		return By.xpath("//div[contains(@class, 'mdc-top-app-bar')]//button[contains(@class, 'mdc-button') and contains(text(), '" + btnText + "')]");
	}

	//settings-node
	protected By nodeMdcAppBarTitle(String titleText)
	{
		return By.xpath("//div[contains(@class, 'settings-node')]//span[contains(@class, 'mdc-top-app-bar__title') and contains(text(), '" + titleText + "')]");
	}

	//settings-node select
	protected By nodeMdcAppBarSelect(String titleText)
	{
		return By.xpath("//option[contains(text(), '" + titleText + "')]//parent::select[@class='select__native-control']");
	}

	//settings-node select with label
	protected By nodeMdcAppBarSelectWithLabel(String text)
	{
		return By.xpath("//label[contains(@class, 'select__label') and contains(text(), '" + text + "')]/following-sibling::div/child::select[contains(@class, 'select__native-control')]");
	}

	//settings-node accordion
	protected By nodeMdcListAccordionWithText(String text)
	{
		return By.xpath("//div[contains(@class, 'settings-node')]//span[contains(@class, 'mdc-list-item__text') and contains(text(), '" + text + "')]");
	}

	//settings-node input
	protected By nodeNpTextFieldWithLabel(String label)
	{
		return By.xpath("//div[contains(@class, 'settings-node')]//label[contains(@class, text-field__label) and contains(text(), '" + label + "')]/following-sibling::div[contains(@class, 'text-field__input-container')]/input");
	}

	//node btn
	protected By nodeMdcAppBarTextBtn(String btnText)
	{
		return By.xpath("//div[contains(@class, 'settings-node')]//button[contains(@class, 'mdc-button') and contains(text(), '" + btnText + "')]");
	}

	//node btn with icon
	protected By nodeMdcListItemWithTextIconBtn(String text, String iconClass)
	{
		return By.xpath("//div[contains(@class, 'settings-node')]//span[contains(@class, 'mdc-list-item__text') and contains(text(), '" + text + "')]/preceding-sibling::span[contains(@class, '" + iconClass + "')]/parent::li");
	}

	//mdc-tab-scroller
	protected By tabScrollerMdcWithTextBtn(String text)
	{
		return By.xpath("//div[contains(@class, 'mdc-tab-scroller')]//span[contains(@class, 'mdc-tab__text-label') and contains(text(), '" + text + "')]//ancestor::button");
	}

}