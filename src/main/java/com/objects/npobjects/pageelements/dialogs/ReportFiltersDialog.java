package com.objects.npobjects.pageelements.dialogs;

import com.objects.npobjects.pageobjects.ReportsCreate;
import com.service.ui.web.SeleniumDriverWrapper;
import junit.framework.Assert;
import org.openqa.selenium.By;

public class ReportFiltersDialog extends Dialog
{
	private ReportsCreate parentPage;

	private final By title = nodeMdcAppBarTitle("Report Filters");


	public ReportFiltersDialog (SeleniumDriverWrapper driver, ReportsCreate pageObj)
	{
		super(driver);
		parentPage = pageObj;
	}

	@Override
	public boolean validateElements()
	{
		return driver.waitUntilExist(title, 5);
	}

	public ReportFiltersDialog checkIsRendered()
	{
		super.checkIsRendered();
		return this;
	}

	public ReportFiltersDialog clickFilterInNodeByName(String text)
	{
		Assert.assertTrue(driver.waitUntilClickable(By.xpath("//div[contains(@class, 'settings-node')]//li[contains(@title, '"+ text +"')]")));
		Assert.assertTrue(driver.click(By.xpath("//div[contains(@class, 'settings-node')]//li[contains(@title, '"+ text +"')]")));
		return this;
	}
	public ReportFiltersDialog checkFilterInNodeByName(String text)
	{
		Assert.assertTrue(driver.waitUntilExist(By.xpath("//div[contains(@class, 'settings-node')]//li[contains(@title, '"+ text +"')]")));
		return this;
	}
}
