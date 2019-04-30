package com.objects.npobjects.pageobjects.oauthpages;

import com.objects.npobjects.NPPageObject;
import com.service.ui.web.SeleniumDriverWrapper;
import org.openqa.selenium.By;
import org.testng.Assert;

public class WrikeLogIn extends NPPageObject
{

	private By emailInput = By.xpath("//input[@placeholder='Email or corporate ID']");
	private By nextButton = By.xpath("//button[@data-application='login-next']");
	private By passInput = By.xpath("//input[@placeholder='Password']");
	private By forgetBtn = By.xpath("//button[@data-application='login-forget']");

	public WrikeLogIn(SeleniumDriverWrapper driver)
	{
		super("", driver);
	}

	@Override
	public boolean validateElements()
	{
		return driver.waitUntilClickable(emailInput, 15)
				  && driver.waitUntilClickable(nextButton);
	}

	public WrikeLogIn checkIsRendered()
	{
		super.checkIsRendered();
		return this;
	}

	public WrikeLogIn clickNextButton()
	{
		Assert.assertTrue(driver.click(nextButton));
		return this;
	}

	public WrikeLogIn enterEmailInput(String text)
	{
		Assert.assertTrue(driver.type(emailInput, text));
		return this;
	}

	public WrikeLogIn enterPassInput(String text)
	{
		Assert.assertTrue(driver.type(passInput, text));
		return this;
	}

	public WrikeLogIn clickForgetInput()
	{
		Assert.assertTrue(driver.click(forgetBtn));
		return this;
	}
}