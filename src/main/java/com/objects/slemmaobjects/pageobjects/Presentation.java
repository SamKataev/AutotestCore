package com.objects.slemmaobjects.pageobjects;

import com.objects.slemmaobjects.SlemmaPageObject;
import com.service.ui.web.SeleniumDriverWrapper;

public class Presentation extends SlemmaPageObject
{

	public Presentation(SeleniumDriverWrapper driver)
	{
		super(driver.getBaseUrl() + "/auth", driver);
	}

	@Override
	public boolean validateElements()
	{
		return true;
	}

	public Presentation checkIsRendered()
	{
		super.checkIsRendered();
		return this;
	}
}
