package com.objects.npobjects.pageelements.panels;

import com.objects.npobjects.pageobjects.ReportPage;
import com.service.ui.web.SeleniumDriverWrapper;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.By;
import org.testng.Assert;

public class ReportSettingsPanel extends Panel
{
	private ReportPage parentPage;
	public Select selectSize;
	public Select selectStartSheet;

	private final By title = By.xpath("//div[contains(@class, 'doc-settings-panel')]//span[contains(@class, 'mdc-top-app-bar__title') and contains(text(), 'Settings')]");


	public ReportSettingsPanel(SeleniumDriverWrapper driver, ReportPage pageObj)
	{
		super(driver);
		parentPage = pageObj;
	}

	@Override
	public boolean validateElements()
	{
		return driver.waitUntilExist(title, 5);
	}

	public ReportSettingsPanel checkIsRendered()
	{
		super.checkIsRendered();
		return this;
	}
}
