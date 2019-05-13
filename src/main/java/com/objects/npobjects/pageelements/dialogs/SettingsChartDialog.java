package com.objects.npobjects.pageelements.dialogs;


import com.objects.npobjects.pageobjects.Main;
import com.objects.npobjects.pageobjects.ReportsCreate;
import com.service.ui.web.SeleniumDriverWrapper;
import junit.framework.Assert;
import org.openqa.selenium.By;

public class SettingsChartDialog extends Dialog
{
	private ReportsCreate parentPage;

	private final By title = panelMdcAppBarTitle("Settings");
	private final By addDimensionBtn = panelMdcListItemWithTextIconBtn("Add a dimension", "ic_add");
	private final By addMeasureBtn = panelMdcListItemWithTextIconBtn("Add a Measure", "ic_add");
	private final By addFilterBtn = panelMdcListItemWithTextIconBtn("Add a Filter", "ic_add");
	private final By addFieldBtn = panelMdcListItemWithTextIconBtn("Add a field", "ic_add");

	public SettingsChartDialog(SeleniumDriverWrapper driver, ReportsCreate pageObj)
	{
		super(driver);
		parentPage = pageObj;
	}

	@Override
	public boolean validateElements()
	{
		return driver.waitUntilExist(title, 5)
				  && driver.waitUntilClickable(addFilterBtn);
	}

	public SettingsChartDialog checkIsRendered()
	{
		super.checkIsRendered();
		return this;
	}

	public SettingsChartDialog clickAddDimensionBtn()
	{
		Assert.assertTrue(driver.click(addDimensionBtn));
		return this;
	}

	public SettingsChartDialog clickAddMeasureBtn()
	{
		Assert.assertTrue(driver.click(addMeasureBtn));
		return this;
	}

	public SettingsChartDialog clickAddFilterBtn()
	{
		Assert.assertTrue(driver.click(addFilterBtn));
		return this;
	}

	public SettingsChartDialog clickAddFieldBtn()
	{
		Assert.assertTrue(driver.click(addFieldBtn));
		return this;
	}

	public SettingsChartDialog clickDimensionInPanelByName(String text)
	{
		Assert.assertTrue(driver.click(By.xpath("//div[contains(@class, 'block-settings-panel')]//span[contains(@class, 'mdc-list-item__text') and contains(text(), '" + text + "')]")));
		return this;
	}

	public SettingsChartDialog clickItemInPanelByName(String text, String iconClass)
	{
		Assert.assertTrue(driver.click(By.xpath("//div[contains(@class, 'block-settings-panel')]//span[contains(@class, 'mdc-list-item') and contains(text(), '" + text + "')]/preceding::span[contains(@class, '" + iconClass + "')]/parent::li")));
		return this;
	}

}


