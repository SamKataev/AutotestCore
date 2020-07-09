package com.objects.npobjects.pageelements.dialogs;

import com.objects.PageObject;
import com.objects.npobjects.pageobjects.ReportPage;
import com.service.ui.web.SeleniumDriverWrapper;
import org.openqa.selenium.By;
import org.testng.Assert;

public class ChooseCloudFileDialog extends Dialog
{
	private PageObject parentPage;

	private final By title = dialogAppBarTitle("Choose a File...");

	public ChooseCloudFileDialog(SeleniumDriverWrapper driver, PageObject pageObj)
	{
		super(driver);
		parentPage = pageObj;
	}

	@Override
	public boolean validateElements()
	{
		return driver.waitUntilClickable(closeBtn, 5)
				  && driver.waitUntilExist(title);
	}

	public ChooseCloudFileDialog checkIsRendered()
	{
		processWaiter(10);
		super.checkIsRendered();
		return this;
	}

	public ChooseCloudFileDialog clickObjectByName(String name)
	{
		Assert.assertTrue(driver.click(dialogTwoLineListItemWithText(name)));
		return this;
	}

}