package com.objects.npobjects.pageelements.dialogs;

import com.objects.npobjects.pageobjects.DataSourcePage;
import com.service.ui.web.SeleniumDriverWrapper;
import org.openqa.selenium.By;
import org.testng.Assert;

public class SettingsDataSourcesDialog extends Dialog

{
	private DataSourcePage parentPage;

	private final By title = nodeMdcAppBarTitle("Settings");
	private final By fields = nodeMdcListAccordionWithText("Fields");


	public SettingsDataSourcesDialog(SeleniumDriverWrapper driver, DataSourcePage pageObj)
	{
		super(driver);
		parentPage = pageObj;
	}

	@Override
	public boolean validateElements()
	{
		return driver.waitUntilExist(title, 5)
				  && driver.waitUntilExist(fields, 5);
	}

	public SettingsDataSourcesDialog checkIsRendered()
	{
		super.checkIsRendered();
		return this;
	}

	public SettingsDataSourcesDialog clickField()
	{
		Assert.assertTrue(driver.click(fields));
		return this;
	}

	public SettingsDataSourcesDialog clickFieldsInDialogByName(String text, String iconClass, int time)
	{
		Assert.assertTrue(driver.waitUntilClickable(By.xpath("//div[contains(@class, 'settings-node')]//span[contains(@class, 'mdc-list-item__text') and contains(text(), '" + text + "')]/preceding-sibling::span[contains(@class, '" + iconClass + "')]/parent::li"), time));
		Assert.assertTrue(driver.click(By.xpath("//div[contains(@class, 'settings-node')]//span[contains(@class, 'mdc-list-item__text') and contains(text(), '" + text + "')]/preceding-sibling::span[contains(@class, '" + iconClass + "')]/parent::li")));
		return this;
	}

	public SettingsDataSourcesDialog checkFieldsInDialogByName(String text, String iconClass, int time)
	{
		Assert.assertTrue(driver.waitUntilClickable(By.xpath("//div[contains(@class, 'settings-node')]//span[contains(@class, 'mdc-list-item__text') and contains(text(), '" + text + "')]/preceding-sibling::span[contains(@class, '" + iconClass + "')]/parent::li"), time));
		return this;
	}
}
