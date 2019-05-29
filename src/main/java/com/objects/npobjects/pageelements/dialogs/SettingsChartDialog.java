package com.objects.npobjects.pageelements.dialogs;


import com.objects.npobjects.pageobjects.Main;
import com.objects.npobjects.pageobjects.ReportsCreate;
import com.service.ui.web.SeleniumDriverWrapper;
import junit.framework.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class SettingsChartDialog extends Dialog
{
	private ReportsCreate parentPage;
	public Select selectSize;

	private final By title = panelMdcAppBarTitle("Settings");
	private final By addDimensionBtn = panelMdcListItemWithTextIconBtn("Add a dimension", "ic_add");
	private final By addMeasureBtn = panelMdcListItemWithTextIconBtn("Add a Measure", "ic_add");
	private final By addFilterBtn = panelMdcListItemWithTextIconBtn("Add a Filter", "ic_add");
	private final By addFieldBtn = panelMdcListItemWithTextIconBtn("Add a field", "ic_add");
	private final By styleBtn = tabScrollerMdcWithTextBtn("Style");
	private final By fontSizeSelect = nodeMdcAppBarSelect("8");
	private final By lineWeight = mdcIconFontBtn("ic_line_weight");

	public SettingsChartDialog(SeleniumDriverWrapper driver, ReportsCreate pageObj)
	{
		super(driver);
		parentPage = pageObj;
	}

	@Override
	public boolean validateElements()
	{
		return true;
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

	public SettingsChartDialog clickTabStyleBtn()
	{
		Assert.assertTrue(driver.waitUntilClickable(styleBtn));
		Assert.assertTrue(driver.click(styleBtn));
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

	public SettingsChartDialog checkDimensionInPanelByName(String text)
	{
		Assert.assertTrue(driver.waitUntilExist(By.xpath("//div[contains(@class, 'block-settings-panel')]//span[contains(@class, 'mdc-list-item__text') and contains(text(), '" + text + "')]")));
		return this;
	}

	public SettingsChartDialog clickItemInPanelByName(String text, String iconClass)
	{
		Assert.assertTrue(driver.click(By.xpath("//div[contains(@class, 'block-settings-panel')]//span[contains(@class, 'mdc-list-item') and contains(text(), '" + text + "')]/preceding::span[contains(@class, '" + iconClass + "')]/parent::li")));
		return this;
	}

	public SettingsChartDialog clickAccordionByName(String text)
	{
		Assert.assertTrue(driver.waitUntilClickable(By.xpath("//div[contains(@class, 'settings-node')]//span[contains(@class, 'mdc-list-item__text') and contains(text(), '" + text + "')]")));
		Assert.assertTrue(driver.click(By.xpath("//div[contains(@class, 'settings-node')]//span[contains(@class, 'mdc-list-item__text') and contains(text(), '" + text + "')]")));
		return this;
	}

	public Select createSelectSize()
	{
		WebElement selectElem = driver.getElement(fontSizeSelect);
		Select selectSize = new Select(selectElem);
		return selectSize;
	}

	public SettingsChartDialog clickLineWeight()
	{
		Assert.assertTrue(driver.waitUntilClickable(lineWeight));
		Assert.assertTrue(driver.click(lineWeight));
		return this;
	}

	public SettingsChartDialog checkDialogTitle(String titleText, int time)
	{
		Assert.assertTrue(driver.waitUntilExist(By.xpath("//div[contains(@class, 'settings-node')]//span[contains(@class, 'mdc-top-app-bar__title') and contains(text(), '" + titleText + "')]"), time));
		return this;
	}
}


