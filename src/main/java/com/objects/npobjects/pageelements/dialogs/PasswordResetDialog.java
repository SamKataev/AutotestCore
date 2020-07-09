package com.objects.npobjects.pageelements.dialogs;

import com.objects.npobjects.pageobjects.AuthPage;
import com.service.ui.web.SeleniumDriverWrapper;
import org.openqa.selenium.By;
import org.testng.Assert;

public class PasswordResetDialog extends Dialog
{

	private AuthPage parentPage;

	private final By emailInput = dialogTextFieldWithLabel("Your e-mail:");
	private final By resetBtn = dialogUnelevatedBtn("Reset");

	public PasswordResetDialog(SeleniumDriverWrapper driver, AuthPage pageObj)
	{
		super(driver);
		parentPage = pageObj;
	}

	@Override
	public boolean validateElements()
	{
		return driver.waitUntilExist(emailInput)
				  && driver.waitUntilExist(resetBtn);
	}

	public PasswordResetDialog enterEmail(String pass)
	{
		Assert.assertTrue(driver.type(emailInput, pass));
		return this;
	}

	public void clickReset()
	{
		Assert.assertTrue(driver.click(resetBtn));
	}
}