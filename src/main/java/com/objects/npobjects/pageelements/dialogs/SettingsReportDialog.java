package com.objects.npobjects.pageelements.dialogs;

import com.objects.npobjects.pageobjects.ReportPage;
import com.service.ui.web.SeleniumDriverWrapper;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.By;
import org.testng.Assert;

public class SettingsReportDialog extends Dialog
{
	private ReportPage parentPage;
	public Select selectSize;
	public Select selectStartSheet;

	private final By title = nodeMdcAppBarTitle("Settings");
	private final By canvasSizeSelect = nodeMdcAppBarSelect("Floating");
	private final By tiledNode = By.className("dataview-tile-node");
	private final By startSheet = nodeMdcAppBarSelectWithLabel("Start sheet");


	public SettingsReportDialog(SeleniumDriverWrapper driver, ReportPage pageObj)
	{
		super(driver);
		parentPage = pageObj;
//		selectSize = new Select(driver.getElement(canvasSizeSelect,30));
	}

	@Override
	public boolean validateElements()
	{
		return driver.waitUntilExist(title, 5)
				  && driver.waitUntilExist(canvasSizeSelect, 5);
	}

	public SettingsReportDialog checkIsRendered()
	{
		super.checkIsRendered();
		return this;
	}

	public Select createSelectSize()
	{
		WebElement selectElem = driver.getElement(canvasSizeSelect);
		Select selectSize = new Select(selectElem);
		return selectSize;
	}

	public SettingsReportDialog tiledNodeTrue()
	{
		Assert.assertTrue(driver.waitUntilExist(tiledNode));
		return this;
	}

	public SettingsReportDialog FloatingNodeFalse()
	{
		Assert.assertFalse(driver.waitUntilExist(tiledNode));
		return this;
	}

	public Select createStartSheet()
	{
		WebElement selectElem = driver.getElement(startSheet);
		Select selectStartSheet = new Select(selectElem);
		return selectStartSheet;
	}
}
