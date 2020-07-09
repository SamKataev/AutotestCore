package com.objects.npobjects.pageelements.dropdown;

import com.objects.PageElement;
import com.service.ui.web.SeleniumDriverWrapper;
import junit.framework.Assert;
import org.openqa.selenium.By;

public abstract class DropDown extends PageElement
{
	protected final By root = By.cssSelector(".np-menu.dropdown_vis");

	public DropDown(SeleniumDriverWrapper driver)
	{
		super(driver);
	}

	@Override
	public boolean validateElements()
	{
		return driver.waitUntilClickable(root);
	}

	protected By dropDownListItemWithText(String text)
	{
		return By.xpath("//div[contains(@class, 'np-menu dropdown_vis')]//span[contains(@class, 'mdc-list-item__text') and contains(text(), '" + text + "')]/ancestor::li");
	}

	protected By dropDownListItemWithText(String text, String dialogClass)
	{
		return By.xpath("//div[contains(@class, 'np-menu dropdown_vis') and contains(@class, '" + dialogClass + "')]//span[contains(@class, 'mdc-list-item__text') and contains(text(), '" + text + "')]/ancestor::li");
	}

	protected By dropDownListItemWithTextIcon(String text, String iconClass)
	{
		return By.xpath("//div[contains(@class, 'np-menu dropdown_vis')]//span[contains(@class, 'mdc-list-item__text') and contains(text(), '" + text + "')]/preceding-sibling::span[contains(@class, '" + iconClass + "')]/ancestor::li");
	}

	protected By dropDownListItemWithTextIcon(String text, String iconClass, String dialogClass)
	{
		return By.xpath("//div[contains(@class, 'np-menu dropdown_vis') and contains(@class, '" + dialogClass + "')]//span[contains(@class, 'mdc-list-item__text') and contains(text(), '" + text + "')]/preceding-sibling::span[contains(@class, '" + iconClass + "')]/ancestor::li");
	}
}