package com.objects.slemmaobjects.pageelements;

import com.objects.PageElement;
import com.objects.slemmaobjects.pageobjects.Home;
import com.service.ui.web.SeleniumDriverWrapper;
import org.testng.Assert;

public class ObjectContextMenu extends PageElement
{

	private Home parentPage;

	public ObjectContextMenu(SeleniumDriverWrapper driver, Home pageObj)
	{
		super(driver);
		parentPage = pageObj;
	}

	@Override
	public boolean validateElements()
	{
		return driver.waitUntilExist(classSelector("dropmenu__content"), 10);
	}

	public ObjectContextMenu checkIsRendered()
	{
		Assert.assertTrue(validateElements());
		return this;
	}

}
