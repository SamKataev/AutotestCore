package com.objects.npobjects.pageelements.dialogs;

import com.objects.npobjects.pageobjects.ReportPage;
import com.service.ui.web.SeleniumDriverWrapper;
import org.openqa.selenium.By;
import org.testng.Assert;

public class SelectaDataSourceDialog extends Dialog
{
	private ReportPage parentPage;

	private final By closeBtn = dialogIconFontBtn("ic_close");
	private final By searchBtn = dialogIconFontBtn("ic_search");
	private final By filterBtn = dialogIconFontBtn("ic_filter");
	private final By sortBtn = dialogIconFontBtn("ic_sort");
	private final By title = dialogAppBarTitle("Select a Data Source");
	private final By createNewDataSourceBtn = dialogTextBtn("Create New Data Source");


	public SelectaDataSourceDialog(SeleniumDriverWrapper driver, ReportPage pageObj)
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