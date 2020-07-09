package com.objects.npobjects.pageelements.dropdown;

import com.objects.npobjects.pageelements.dialogs.Dialog;
import com.objects.npobjects.pageobjects.NavigatorPage;
import com.service.ui.web.SeleniumDriverWrapper;
import junit.framework.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SelectTeamDropDown extends DropDown
{

	private NavigatorPage parentPage;

	public SelectTeamDropDown(SeleniumDriverWrapper driver, NavigatorPage pageObj)
	{
		super(driver);
		parentPage = pageObj;
	}

	public SelectTeamDropDown checkIsRendered()
	{
		super.checkIsRendered();
		return this;
	}

	public NavigatorPage clickTeam(String name)
	{
		Assert.assertTrue(driver.click(dropDownListItemWithText(name)));
		return parentPage;
	}
}