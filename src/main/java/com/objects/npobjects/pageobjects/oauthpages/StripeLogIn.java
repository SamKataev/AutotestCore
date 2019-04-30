package com.objects.npobjects.pageobjects.oauthpages;

import com.objects.npobjects.NPPageObject;
import com.service.ui.web.SeleniumDriverWrapper;
import org.openqa.selenium.By;
import org.testng.Assert;

public class StripeLogIn extends NPPageObject
{

	private By signInStripeBtn = By.xpath("//button[@class='button medium blue']");
	private By emailInput = By.xpath("//input[@placeholder='Email']");
	private By passInput = By.xpath("//input[@placeholder='Password']");
	private By signInStripeAccountBtn = By.xpath("//button[@type='submit']");

	public StripeLogIn(SeleniumDriverWrapper driver)
	{
		super("", driver);
	}

	@Override
	public boolean validateElements()
	{
		return driver.waitUntilClickable(signInStripeBtn, 15);
	}

	public StripeLogIn checkIsRendered()
	{
		super.checkIsRendered();
		return this;
	}

	public StripeLogIn clicksignInStripeBtn()
	{
		Assert.assertTrue(driver.click(signInStripeBtn));
		return this;
	}

	public StripeLogIn enterEmailInput(String text)
	{
		Assert.assertTrue(driver.type(emailInput, text));
		return this;
	}

	public StripeLogIn enterPassInput(String text)
	{
		Assert.assertTrue(driver.type(passInput, text));
		return this;
	}

	public StripeLogIn clicksignInStripeAccountBtn()
	{
		Assert.assertTrue(driver.click(signInStripeAccountBtn));
		return this;
	}
}

