package com.objects.npobjects.pageelements.panels;


import com.objects.npobjects.pageelements.dropdown.AggDropDown;
import com.objects.npobjects.pageobjects.ReportPage;
import com.service.ui.web.SeleniumDriverWrapper;
import junit.framework.Assert;
import org.openqa.selenium.By;

public class ChooseMeasurePanel extends Panel
{
	private ReportPage parentPage;

	public AggDropDown aggDropDown;

	private final By title = By.xpath("//div[contains(@class, 'block-settings-panel')]//span[contains(@class, 'mdc-top-app-bar__title') and contains(text(), 'Choose a Measure')]");

	public ChooseMeasurePanel(SeleniumDriverWrapper driver, ReportPage pageObj)
	{
		super(driver);
		parentPage = pageObj;

		aggDropDown = new AggDropDown(driver, parentPage);
	}

	@Override
	public boolean validateElements()
	{
		return driver.waitUntilExist(title);
	}

	public ChooseMeasurePanel checkIsRendered()
	{
		super.checkIsRendered();
		return this;
	}

	public AggDropDown clickMeasure(String name)
	{
		Assert.assertTrue(driver.click(subPanelListItemWithText(name)));
		return aggDropDown;
	}
}


