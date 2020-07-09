package com.objects.npobjects.pageobjects.oauthpages;

import com.objects.npobjects.NPPageObject;
import com.service.ui.web.SeleniumDriverWrapper;
import org.openqa.selenium.By;
import org.testng.Assert;

public class GoogleLogIn extends NPPageObject
{
	private By emailInput = By.xpath("//input[@type='email']");
	private By nextBtnEmail = By.xpath("//div[@id='identifierNext']");
	private By nextBtnPassword = By.xpath("//div[@id='passwordNext']");
	private By passwordInput = By.xpath("//input[@type='password']");
	private By allowBtn = By.xpath("//div[@id='submit_approve_access']");

	public GoogleLogIn(SeleniumDriverWrapper driver)
	{
		super("", driver);
	}

	@Override
	public boolean validateElements()
	{
		return driver.waitUntilClickable(emailInput, 5, logIsRenderingCheck)
				  && driver.waitUntilClickable(nextBtnEmail);
	}

	public GoogleLogIn checkIsRendered()
	{
		super.checkIsRendered();
		return this;
	}

	public GoogleLogIn enterEmailInput(String text)
	{
		Assert.assertTrue(driver.type(emailInput, text));
		return this;
	}

	public GoogleLogIn enterpasswordInput(String text)
	{
		Assert.assertTrue(driver.type(passwordInput, text));
		return this;
	}

	public GoogleLogIn clickEmailNextBtn()
	{
		Assert.assertTrue(driver.click(nextBtnEmail));
		return this;
	}

	public GoogleLogIn clickPasswordNextBtn()
	{
		Assert.assertTrue(driver.click(nextBtnPassword));
		return this;
	}

	public GoogleLogIn clickAllowBtn()
	{
		Assert.assertTrue(driver.click(allowBtn));
		return this;
	}
}
