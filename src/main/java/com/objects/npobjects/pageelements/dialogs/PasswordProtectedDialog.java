package com.objects.npobjects.pageelements.dialogs;

import com.objects.npobjects.pageobjects.Main;
import com.service.ui.web.SeleniumDriverWrapper;
import junit.framework.Assert;
import org.openqa.selenium.By;

public class PasswordProtectedDialog extends Dialog
{
	private Main parentPage;

	private final By title = dialogMdcAppBarTitle("This link is password protected");
	private final By viewReportBtn = mdcTextBtn("View report");
	private final By passwordInput = dialogNpTextFieldWithLabel("Enter the password below to view the report");


	public PasswordProtectedDialog (SeleniumDriverWrapper driver, Main pageObj)
	{
		super(driver);
		parentPage = pageObj;
	}

	@Override
	public boolean validateElements()
	{
		return driver.waitUntilExist(title, 5)
				  && driver.waitUntilClickable(viewReportBtn)
				  && driver.waitUntilClickable(passwordInput);
	}

	public PasswordProtectedDialog checkIsRendered()
	{
		super.checkIsRendered();
		return this;
	}

	public PasswordProtectedDialog clickViewReportBtn()
	{
		Assert.assertTrue(driver.click(viewReportBtn));
		return this;
	}

	public PasswordProtectedDialog enterPasswordInput(String text)
	{
		Assert.assertTrue(driver.type(passwordInput, text));
		return this;
	}

}
