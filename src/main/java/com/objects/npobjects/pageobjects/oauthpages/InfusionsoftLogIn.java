package com.objects.npobjects.pageobjects.oauthpages;

import com.objects.npobjects.NPPageObject;
import com.service.ui.web.SeleniumDriverWrapper;
import org.openqa.selenium.By;
import org.testng.Assert;

public class InfusionsoftLogIn extends NPPageObject
{

	private By emailInput = By.xpath("//input[@type='email']");
	private By passInput = By.xpath("//input[@type='password']");
	private By logInBtn = By.xpath("//button[@id='btn-login']");
	private By allowBtn = By.xpath("//button[@name='allow']");

	public InfusionsoftLogIn(SeleniumDriverWrapper driver)
	{
		super("", driver);
	}

	@Override
	public boolean validateElements()
	{
		return driver.waitUntilClickable(emailInput, 10)
				  && driver.waitUntilClickable(passInput)
				  && driver.waitUntilExist(logInBtn);
	}

	public InfusionsoftLogIn checkIsRendered()
	{
		super.checkIsRendered();
		return this;
	}

	public InfusionsoftLogIn clicklogInBtn()
	{
		Assert.assertTrue(driver.click(logInBtn));
		return this;
	}

	public InfusionsoftLogIn enterEmailInput(String text)
	{
		Assert.assertTrue(driver.type(emailInput, text));
		return this;
	}

	public InfusionsoftLogIn enterPassInput(String text)
	{
		Assert.assertTrue(driver.type(passInput, text));
		return this;
	}

	public InfusionsoftLogIn clickAllowBtn()
	{
		Assert.assertTrue(driver.click(allowBtn));
		return this;
	}
}
