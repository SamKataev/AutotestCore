package com.objects.npobjects.pageelements.dialogs;

import com.objects.PageElement;
import com.service.ui.web.SeleniumDriverWrapper;
import junit.framework.Assert;
import org.openqa.selenium.By;

public abstract class Dialog extends PageElement
{
	protected final By cancelBtn = dialogMdcTextBtn("Cancel");
	protected final By okBtn = dialogMdcTextBtn("OK");


	public Dialog(SeleniumDriverWrapper driver) {
		super(driver);
	}

	public void clickOk(){
		Assert.assertTrue(driver.click(okBtn));
	}

	public void clickCancel(){
		Assert.assertTrue(driver.click(cancelBtn));
	}

	protected By dialogMdcListItemWithText(String text){
		return By.xpath("//div[contains(@class, 'mdc-dialog--open')]//span[contains(@class, 'mdc-list-item__text') and contains(text(), '" + text + "')]/parent::li");
	}

	protected By dialogMdcListItemWithText(String text, String dialogClass){
		return By.xpath("//div[contains(@class, 'mdc-dialog--open') and contains(@class, '" + dialogClass + "')]//span[contains(@class, 'mdc-list-item__text') and contains(text(), '" + text + "')]/parent::li");
	}

	protected By dialogMdcListItemWithTextIcon(String text, String iconClass){
		return By.xpath("//div[contains(@class, 'mdc-dialog--open')]//span[contains(@class, 'mdc-list-item__text') and contains(text(), '" + text + "')]/preceding-sibling::span[contains(@class, '" + iconClass + "')]/parent::li");
	}

	protected By dialogMdcListItemWithTextIcon(String text, String iconClass, String dialogClass){
		return By.xpath("//div[contains(@class, 'mdc-dialog--open') and contains(@class, '" + dialogClass + "')]//span[contains(@class, 'mdc-list-item__text') and contains(text(), '" + text + "')]/preceding-sibling::span[contains(@class, '" + iconClass + "')]/parent::li");
	}

	protected By dialogMdcIconFontBtn(String iconClass){
		return By.xpath("//div[contains(@class, 'mdc-dialog--open')]//span[contains(@class, '" + iconClass + "')]/parent::span[contains(@class, 'mdc-icon-toggle')]");
	}

	protected By dialogMdcIconFontBtn(String iconClass, String dialogClass){
		return By.xpath("//div[contains(@class, 'mdc-dialog--open') and contains(@class, '" + dialogClass + "')]//span[contains(@class, '" + iconClass + "')]/parent::span[contains(@class, 'mdc-icon-toggle')]");
	}

	protected By dialogMdcTextBtn(String btnText){
		return By.xpath("//div[contains(@class, 'mdc-dialog--open')]//button[contains(@class, 'mdc-button') and contains(text(), '" + btnText + "')]");
	}

	protected By dialogMdcTextBtn(String btnText, String dialogClass){
		return By.xpath("//div[contains(@class, 'mdc-dialog--open') and contains(@class, '" + dialogClass + "')]//button[contains(@class, 'mdc-button') and contains(text(), '" + btnText + "')]");
	}

	protected By dialogMdcAppBarTitle(String titleText){
		return By.xpath("//div[contains(@class, 'mdc-dialog--open')]//span[contains(@class, 'mdc-top-app-bar__title') and contains(text(), '" + titleText + "')]");
	}

	protected By dialogMdcAppBarTitle(String titleText, String dialogClass){
		return By.xpath("//div[contains(@class, 'mdc-dialog--open') and contains(@class, '" + dialogClass + "')]//span[contains(@class, 'mdc-top-app-bar__title') and contains(text(), '" + titleText + "')]");
	}

	protected By dialogNpTextFieldWithLabel(String label){
		return By.xpath("//div[contains(@class, 'mdc-dialog--open')]//label[contains(@class, text-field__label) and contains(text(), '" + label + "')]/following-sibling::div[contains(@class, 'text-field__input-container')]/input");
	}

	protected By dialogNpTextFieldWithLabel(String label, String dialogClass){
		return By.xpath("//div[contains(@class, 'mdc-dialog--open') and contains(@class, '" + dialogClass + "')]//label[contains(@class, text-field__label) and contains(text(), '" + label + "')]/following-sibling::div[contains(@class, 'text-field__input-container')]/input");
	}
}
