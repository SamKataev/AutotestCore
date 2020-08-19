package com.objects.npobjects.pageelements.panels;


import com.objects.npobjects.pageobjects.ReportPage;
import com.service.ui.web.SeleniumDriverWrapper;
import junit.framework.Assert;
import org.openqa.selenium.By;

public class ChooseDimensionPanel extends Panel
{
	private ReportPage parentPage;

	private final By title = By.xpath("//div[contains(@class, 'block-settings-panel')]//span[contains(@class, 'mdc-top-app-bar__title') and contains(text(), 'Choose a Dimension')]");

	public ChooseDimensionPanel(SeleniumDriverWrapper driver, ReportPage pageObj)
	{
		super(driver);
		parentPage = pageObj;
	}

	@Override
	public boolean validateElements()
	{
		return driver.waitUntilExist(title);
	}

	public ChooseDimensionPanel checkIsRendered()
	{
		super.checkIsRendered();
		return this;
	}

	public ReportPage clickDimension(String name)
	{
		Assert.assertTrue(driver.click(subPanelListItemWithText(name)));
		return parentPage;
	}
}


