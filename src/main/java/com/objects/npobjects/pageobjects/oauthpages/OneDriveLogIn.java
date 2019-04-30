package com.objects.npobjects.pageobjects.oauthpages;

import com.objects.npobjects.NPPageObject;
import com.service.ui.web.SeleniumDriverWrapper;
import org.openqa.selenium.By;
import org.testng.Assert;

public class OneDriveLogIn extends NPPageObject
{
	private By emailInput = By.xpath("//input[@type='email']");
	private By nextBtn = By.xpath("//input[@type='submit']");
	private By passInput = By.xpath("//input[@name='passwd']");
	private By personalAccount = By.xpath("//div[@id='msaTile']");


	public OneDriveLogIn(SeleniumDriverWrapper driver)
	{
		super("", driver);
	}

	@Override
	public boolean validateElements()
	{
		return driver.waitUntilClickable(emailInput, 10)
				  && driver.waitUntilClickable(nextBtn);
	}

	public OneDriveLogIn checkIsRendered()
	{
		super.checkIsRendered();
		return this;
	}

	public OneDriveLogIn enterEmailInput(String text)
	{
		Assert.assertTrue(driver.type(emailInput, text));
		return this;
	}

	public OneDriveLogIn enterPassInput(String text)
	{
		Assert.assertTrue(driver.type(passInput, text));
		return this;
	}

	public OneDriveLogIn clickNextBtn()
	{
		Assert.assertTrue(driver.click(nextBtn));
		return this;
	}

	public OneDriveLogIn clickPersonalAccount()
	{
		Assert.assertTrue(driver.click(personalAccount));
		return this;
	}
}
