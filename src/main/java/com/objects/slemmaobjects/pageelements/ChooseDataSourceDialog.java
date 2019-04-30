package com.objects.slemmaobjects.pageelements;

import com.objects.PageElement;
import com.objects.slemmaobjects.pageobjects.Home;
import com.service.ui.web.SeleniumDriverWrapper;
import org.openqa.selenium.By;
import org.testng.Assert;

public class ChooseDataSourceDialog extends PageElement
{

	private Home parentPage;

	private final By labelChooseDataSource = classContainsText("dialog__caption", "Choose a Data Source");
	private final By createNewBtn = classContainsText("btn__cont", "Create new");

	public ChooseDataSourceDialog(SeleniumDriverWrapper driver, Home pageObj)
	{
		super(driver);
		parentPage = pageObj;
	}

	@Override
	public boolean validateElements()
	{
		return driver.waitUntilExist(classSelector("listbox-connections"), 10)
				  && driver.waitUntilExist(createNewBtn)
				  && driver.waitUntilExist(labelChooseDataSource);
	}

	public ChooseDataSourceDialog checkIsRendered()
	{
		Assert.assertTrue(validateElements());
		return this;
	}

}
