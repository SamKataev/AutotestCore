package com.objects.npobjects.pageobjects.oauthpages;

import com.objects.npobjects.NPPageObject;
import com.service.ui.web.SeleniumDriverWrapper;
import org.openqa.selenium.By;
import org.testng.Assert;

public class QuickbooksLogIn extends NPPageObject
{

	private By emailInput = By.xpath("//input[@name='Email']");
	private By passInput = By.xpath("//input[@name='Password']");
	private By signInBtn = By.xpath("//button[@name='SignIn']");
	private By connectBtn = By.xpath("//button[@class='btn ha-button ha-button-primary pull-right']");

	public QuickbooksLogIn(SeleniumDriverWrapper driver)
	{
		super("", driver);
	}

	@Override
	public boolean validateElements()
	{
		return driver.waitUntilClickable(emailInput, 10)
				  && driver.waitUntilClickable(passInput)
				  && driver.waitUntilExist(signInBtn);
	}

	public QuickbooksLogIn checkIsRendered()
	{
		super.checkIsRendered();
		return this;
	}

	public QuickbooksLogIn clickSignInBt()
	{
		Assert.assertTrue(driver.click(signInBtn));
		return this;
	}

	public QuickbooksLogIn enterEmailInput(String text)
	{
		Assert.assertTrue(driver.type(emailInput, text));
		return this;
	}

	public QuickbooksLogIn enterPassInput(String text)
	{
		Assert.assertTrue(driver.type(passInput, text));
		return this;
	}

	public QuickbooksLogIn clickconnectBtn()
	{
		Assert.assertTrue(driver.click(connectBtn));
		return this;
	}


}
