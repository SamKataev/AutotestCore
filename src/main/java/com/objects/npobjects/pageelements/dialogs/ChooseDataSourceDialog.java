package com.objects.npobjects.pageelements.dialogs;

import com.objects.PageObject;
import com.service.ui.web.SeleniumDriverWrapper;
import org.openqa.selenium.By;
import org.testng.Assert;

public class ChooseDataSourceDialog extends Dialog
{
	private PageObject parentPage;

	private final By title = dialogAppBarTitle("Choose a Data Source");
	private final By createNewSource = dialogBtn("Create New Data Source");

	public ChooseDataSourceDialog(SeleniumDriverWrapper driver, PageObject pageObj)
	{
		super(driver);
		parentPage = pageObj;
	}

	@Override
	public boolean validateElements()
	{
		return driver.waitUntilClickable(closeBtn, 5)
				  && driver.waitUntilExist(searchBtn)
				  && driver.waitUntilExist(createNewSource)
				  && driver.waitUntilExist(title);
	}

	public ChooseDataSourceDialog checkIsRendered()
	{
		processWaiter(10);
		super.checkIsRendered();
		return this;
	}

	public ChooseDataSourceDialog clickObjectByName(String name)
	{
		Assert.assertTrue(driver.click(dialogTwoLineListItemWithText(name)));
		return this;
	}

}