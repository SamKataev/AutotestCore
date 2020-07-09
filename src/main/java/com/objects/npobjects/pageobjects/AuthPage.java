package com.objects.npobjects.pageobjects;

import com.objects.npobjects.NPPageObject;
import com.objects.npobjects.pageelements.dialogs.PasswordResetDialog;
import com.service.ui.web.SeleniumDriverWrapper;
import org.openqa.selenium.By;
import org.testng.Assert;

public class AuthPage extends NPPageObject
{
	private By emailInput = By.xpath("//input[@placeholder='Email']");
	private By passInput = By.xpath("//input[@placeholder='Password']");
	private By signInBtn = unelevatedBtn("Sign in");
	private By googleSignInBtn = unelevatedBtn("Sign in with Google");
	private By registerBtn = unelevatedBtn("Sign up");
	private By passResetBtn = unelevatedBtn("Forgot Password?");

	public AuthPage(SeleniumDriverWrapper driver)
	{
		super(driver.getBaseUrl() + "/auth", driver);
	}

	@Override
	public boolean validateElements()
	{
		return driver.waitUntilExist(emailInput, 10)
				  && driver.waitUntilExist(passInput)
				  && driver.waitUntilExist(googleSignInBtn)
				  && driver.waitUntilExist(registerBtn)
				  && driver.waitUntilExist(passResetBtn)
				  && driver.waitUntilExist(signInBtn);
	}

	public AuthPage checkIsRendered()
	{
		super.checkIsRendered();
		return this;
	}

	public void logIn(String email, String pass)
	{
		enterEmail(email);
		enterPass(pass);
		clickSignIn();
	}

	public AuthPage enterEmail(String text)
	{
		Assert.assertTrue(driver.type(emailInput, text));
		return this;
	}

	public AuthPage enterPass(String text)
	{
		Assert.assertTrue(driver.type(passInput, text));
		return this;
	}

	public AuthPage clickSignIn()
	{
		Assert.assertTrue(driver.click(signInBtn));
		return this;
	}


	public AuthPage clickGoogleSignIn()
	{
		//TODO: return google oauth form
		Assert.assertTrue(driver.click(googleSignInBtn));
		return this;
	}

	public AuthPage clickRegister()
	{
		Assert.assertTrue(driver.click(registerBtn));
		return this;
	}

	public PasswordResetDialog clickPassReset()
	{
		Assert.assertTrue(driver.click(passResetBtn));
		return new PasswordResetDialog(driver, this);
	}

	public void checkErrorMessage(String text)
	{
		Assert.assertTrue(driver.waitUntilVisible(classWithText("label--error", text), 2));
	}
}
