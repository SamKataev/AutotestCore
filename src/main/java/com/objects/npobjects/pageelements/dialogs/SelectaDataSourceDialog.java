package com.objects.npobjects.pageelements.dialogs;

import com.objects.npobjects.pageobjects.Main;
import com.objects.npobjects.pageobjects.ReportsCreate;
import com.service.ui.web.SeleniumDriverWrapper;
import org.openqa.selenium.By;
import org.testng.Assert;

public class SelectaDataSourceDialog extends Dialog
{
	private ReportsCreate parentPage;

	private final By closeBtn = dialogMdcIconFontBtn("ic_close");
	private final By searchBtn = dialogMdcIconFontBtn("ic_search");
	private final By filterBtn = dialogMdcIconFontBtn("ic_filter");
	private final By sortBtn = dialogMdcIconFontBtn("ic_sort");
	private final By title = dialogMdcAppBarTitle("Select a Data Source");
	private final By createNewDataSourceBtn = dialogMdcTextBtn("Create New Data Source");


	public SelectaDataSourceDialog(SeleniumDriverWrapper driver, ReportsCreate pageObj)
	{
		super(driver);
		parentPage = pageObj;
	}

	@Override
	public boolean validateElements()
	{
		return driver.waitUntilClickable(closeBtn, 5)
				  && driver.waitUntilClickable(searchBtn)
				  && driver.waitUntilClickable(filterBtn)
				  && driver.waitUntilClickable(sortBtn)
				  && driver.waitUntilExist(title);
	}

	public SelectaDataSourceDialog checkIsRendered()
	{
		super.checkIsRendered();
		return this;
	}

	public SelectaDataSourceDialog clickDataSourceInDialogByName(String text, String iconClass, int time)
	{
		Assert.assertTrue(driver.waitUntilClickable(By.xpath("//div[contains(@class, 'mdc-dialog--open')]//span[contains(@class, 'mdc-list-item__primary-text') and contains(text(), '" + text + "')]/parent::span/preceding-sibling::span[contains(@class, '" + iconClass + "')]"), time));
		Assert.assertTrue(driver.click(By.xpath("//div[contains(@class, 'mdc-dialog--open')]//span[contains(@class, 'mdc-list-item__primary-text') and contains(text(), '" + text + "')]/parent::span/preceding-sibling::span[contains(@class, '" + iconClass + "')]")));
		return this;
	}

	public SelectaDataSourceDialog clickCreateNewDataSourceBtn()
	{
		Assert.assertTrue(driver.click(createNewDataSourceBtn));
		return this;
	}

}