package com.objects.npobjects.pageelements.dialogs;

import com.objects.npobjects.pageobjects.NavigatorPage;
import com.service.ui.web.SeleniumDriverWrapper;
import org.openqa.selenium.By;
import org.testng.Assert;

/**
 * Created by User on 09-Apr-19.
 */
public class SaaSParametersDialog extends Dialog
{


	private NavigatorPage parentPage;

	private final By title = dialogAppBarTitle("Parameters");
	private final By domainField = dialogTextFieldWithLabel("Domain");
	private final By serverURLField = dialogTextFieldWithLabel("Server URL");
	private final By apiField = dialogTextFieldWithLabel("API key");
	private final By customerIDField = dialogTextFieldWithLabel("Customer ID");
	private final By loginField = dialogTextFieldWithLabel("Login");
	private final By passwordField = dialogTextFieldWithLabel("Password");
	private final By apitokenField = dialogTextFieldWithLabel("API token");
	private final By tokenField = dialogTextFieldWithLabel("Security token");
	private final By cancelBtn = dialogUnelevatedBtn("Cancel");
	private final By okBtn = dialogUnelevatedBtn("OK");

	public SaaSParametersDialog(SeleniumDriverWrapper driver, NavigatorPage pageObj)
	{
		super(driver);
		parentPage = pageObj;
	}

	@Override
	public boolean validateElements()
	{
		return driver.waitUntilExist(title, 5)
				  && driver.waitUntilClickable(cancelBtn)
				  && driver.waitUntilClickable(okBtn);
	}

	public SaaSParametersDialog checkIsRendered()
	{
		super.checkIsRendered();
		return this;
	}

	public SaaSParametersDialog enterDomain(String text)
	{
		Assert.assertTrue(driver.type(domainField, text));
		return this;
	}

	public SaaSParametersDialog enterAPI(String text)
	{
		Assert.assertTrue(driver.type(apiField, text));
		return this;
	}

	public SaaSParametersDialog clickOkBtn()
	{
		Assert.assertTrue(driver.click(okBtn));
		return this;
	}

	public SaaSParametersDialog enterserverURLField(String text)
	{
		Assert.assertTrue(driver.type(serverURLField, text));
		return this;
	}

	public SaaSParametersDialog enterCustomerIDField(String text)
	{
		Assert.assertTrue(driver.type(customerIDField, text));
		return this;
	}

	public SaaSParametersDialog enterloginField(String text)
	{
		Assert.assertTrue(driver.type(loginField, text));
		return this;
	}

	public SaaSParametersDialog enterpasswordField(String text)
	{
		Assert.assertTrue(driver.type(passwordField, text));
		return this;
	}

	public SaaSParametersDialog enterAPItokenField(String text)
	{
		Assert.assertTrue(driver.type(apitokenField, text));
		return this;
	}

	public SaaSParametersDialog entertokenField(String text)
	{
		Assert.assertTrue(driver.type(tokenField, text));
		return this;
	}


}
