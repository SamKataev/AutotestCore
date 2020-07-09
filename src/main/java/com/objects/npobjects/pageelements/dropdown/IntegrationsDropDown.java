package com.objects.npobjects.pageelements.dropdown;

import com.objects.npobjects.pageobjects.NavigatorPage;
import com.service.ui.web.SeleniumDriverWrapper;
import junit.framework.Assert;
import org.openqa.selenium.By;

/**
 * Created by Kate on 03-Apr-19.
 */
public class IntegrationsDropDown extends DropDown
{

	private NavigatorPage parentPage;

	private final By databaseBtn = dropDownListItemWithText("Database");
	private final By saasBtn = dropDownListItemWithText("SaaS");

	public IntegrationsDropDown(SeleniumDriverWrapper driver, NavigatorPage pageObj)
	{
		super(driver);
		parentPage = pageObj;
	}

	@Override
	public boolean validateElements()
	{
		return driver.waitUntilClickable(databaseBtn, 5)
				  && driver.waitUntilClickable(saasBtn);
	}

	public IntegrationsDropDown checkIsRendered()
	{
		super.checkIsRendered();
		return this;
	}

	public IntegrationsDropDown clickSaasBtn()
	{
		Assert.assertTrue(driver.click(saasBtn));
		return this;
	}

	public IntegrationsDropDown clickDatabaseBtn()
	{
		Assert.assertTrue(driver.click(databaseBtn));
		return this;
	}


}
