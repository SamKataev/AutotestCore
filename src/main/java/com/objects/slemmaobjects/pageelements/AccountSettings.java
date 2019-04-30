package com.objects.slemmaobjects.pageelements;

import com.objects.PageElement;
import com.objects.slemmaobjects.pageobjects.Home;
import com.service.ui.web.SeleniumDriverWrapper;
import org.openqa.selenium.By;
import org.testng.Assert;

public class AccountSettings extends PageElement
{

	private Home parentPage;

	private final By email = classSelector("account-panel__email");
	private final By teamsList = classSelector("account-panel__teams");


	public AccountSettings(SeleniumDriverWrapper driver, Home pageObj)
	{
		super(driver);
		parentPage = pageObj;
	}

	@Override
	public boolean validateElements()
	{
		return driver.waitUntilExist(email, 10)
				  && driver.waitUntilExist(teamsList, 10);
	}

	public AccountSettings checkIsRendered()
	{
		Assert.assertTrue(validateElements());
		return this;
	}

	public void selectTeam(String name)
	{
		Assert.assertTrue(driver.click(classWithTextInParentClass("account-panel__teams", "listitem__content", name)));
	}
}