package com.objects.npobjects.pageelements.dialogs;

import com.objects.npobjects.pageobjects.NavigatorPage;
import com.service.ui.web.SeleniumDriverWrapper;
import junit.framework.Assert;
import org.openqa.selenium.By;

public class PasswordProtectedDialog extends Dialog
{
	private NavigatorPage parentPage;

	private final By title = dialogAppBarTitle("This link is password protected");
	private final By viewReportBtn = unelevatedBtn("View report");
	private final By passwordInput = dialogTextFieldWithLabel("Enter the password below to view the report");


	public PasswordProtectedDialog(SeleniumDriverWrapper driver, NavigatorPage pageObj)
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
