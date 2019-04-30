package com.objects.npobjects.pageelements.dialogs;

import com.objects.npobjects.pageobjects.Auth;
import com.service.ui.web.SeleniumDriverWrapper;
import org.openqa.selenium.By;
import org.testng.Assert;

public class PasswordResetDialog extends Dialog
{

	private Auth parentPage;

	private final By emailInput = dialogNpTextFieldWithLabel("Your e-mail:");
	private final By resetBtn = dialogMdcTextBtn("Reset");

	public PasswordResetDialog(SeleniumDriverWrapper driver, Auth pageObj)
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