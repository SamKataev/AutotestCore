package com.objects.npobjects.pageelements.dialogs;

import com.objects.npobjects.pageobjects.ReportsCreate;
import com.service.ui.web.SeleniumDriverWrapper;
import junit.framework.Assert;
import org.openqa.selenium.By;

public class ReportFiltersDialog extends Dialog
{
	private ReportsCreate parentPage;

	private final By addBtn = nodeMdcListItemWithTextIconBtn ("Add a Filter", "ic_add");
	private final By doneBtn = nodeMdcAppBarTextBtn("Done");

	public ReportFiltersDialog (SeleniumDriverWrapper driver, ReportsCreate pageObj)
	{
		super(driver);
		parentPage = pageObj;
	}

	@Override
	public boolean validateElements()
	{
		return true;
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
	public ReportFiltersDialog clickAddBtn ()
	{
		Assert.assertTrue(driver.click(addBtn));
		return this;
	}

	public ReportFiltersDialog clickFieldsInDialogByName(String text, String iconClass, int time)
	{
		Assert.assertTrue(driver.waitUntilClickable(By.xpath("//div[contains(@class, 'settings-node')]//span[contains(@class, 'mdc-list-item__text') and contains(text(), '" + text + "')]/preceding-sibling::span[contains(@class, '" + iconClass + "')]/parent::li"), time));
		Assert.assertTrue(driver.click(By.xpath("//div[contains(@class, 'settings-node')]//span[contains(@class, 'mdc-list-item__text') and contains(text(), '" + text + "')]/preceding-sibling::span[contains(@class, '" + iconClass + "')]/parent::li")));
		return this;
	}
	public ReportFiltersDialog clickDoneBtn ()
	{
		Assert.assertTrue(driver.click(doneBtn));
		return this;
	}
	public ReportFiltersDialog checkDialogTitle(String titleText, int time)
	{
		org.testng.Assert.assertTrue(driver.waitUntilExist(By.xpath("//div[contains(@class, 'settings-node')]//span[contains(@class, 'mdc-top-app-bar__title') and contains(text(), '" + titleText + "')]"), time));
		return this;
	}
}
