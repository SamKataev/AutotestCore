package com.objects.npobjects.pageelements.dialogs;

import com.objects.npobjects.pageobjects.NavigatorPage;
import com.service.ui.web.SeleniumDriverWrapper;
import org.openqa.selenium.By;
import org.testng.Assert;

/**
 * Created by User on 08-Apr-19.
 */
public class CreateIntegrationDialog extends Dialog
{

	private NavigatorPage parentPage;

	private final By title = dialogAppBarTitle("Create integration");
	private final By closeBtn = dialogIconFontBtn("ic_close");

	private final By general = dialogListAccordionWithText("General");
	private final By security = dialogListAccordionWithText("Security");
	private final By dataRefresh = dialogListAccordionWithText("Data refresh");
	private final By displaynameField = dialogTextFieldWithLabel("Display name");

	private final By hostField = dialogTextFieldWithLabel("Host");
	private final By portField = dialogTextFieldWithLabel("Port");
	private final By databaseNameField = dialogTextFieldWithLabel("Database Name");
	private final By usernameField = dialogTextFieldWithLabel("Username");
	private final By passwordField = dialogTextFieldWithLabel("Password");
	private final By endpointField = dialogTextFieldWithLabel("Endpoint");


	private final By createBtn = unelevatedBtn("Create");
	private final By checkBtn = unelevatedBtn("Check connection");

	public CreateIntegrationDialog(SeleniumDriverWrapper driver, NavigatorPage pageObj)
	{
		super(driver);
		parentPage = pageObj;
	}

	@Override
	public boolean validateElements()
	{
		return driver.waitUntilExist(title, 5)
				  && driver.waitUntilClickable(closeBtn)
				  && driver.waitUntilClickable(general)
				  && driver.waitUntilClickable(security)
				  && driver.waitUntilClickable(dataRefresh)
				  && driver.waitUntilClickable(displaynameField)
				  && driver.waitUntilClickable(hostField)
				  && driver.waitUntilClickable(portField)
				  && driver.waitUntilClickable(databaseNameField)
				  && driver.waitUntilClickable(usernameField)
				  && driver.waitUntilClickable(passwordField)
				  && driver.waitUntilExist(createBtn)
				  && driver.waitUntilExist(checkBtn);

	}

	public CreateIntegrationDialog checkIsRendered()
	{
		super.checkIsRendered();
		return this;
	}

	public CreateIntegrationDialog enterHost(String text)
	{
		Assert.assertTrue(driver.type(hostField, text));
		return this;
	}

	public CreateIntegrationDialog enterDataBaseName(String text)
	{
		Assert.assertTrue(driver.type(databaseNameField, text));
		return this;
	}


	public CreateIntegrationDialog enterUsername(String text)
	{
		Assert.assertTrue(driver.type(usernameField, text));
		return this;
	}

	public CreateIntegrationDialog enterPassword(String text)
	{
		Assert.assertTrue(driver.type(passwordField, text));
		return this;
	}

	public CreateIntegrationDialog clickCreate()
	{
		Assert.assertTrue(driver.click(createBtn));
		return this;
	}

	public CreateIntegrationDialog clickCheck()
	{
		Assert.assertTrue(driver.click(checkBtn));
		return this;
	}

	//для того чтобы убрать фокуc с поля "пароль"
	public CreateIntegrationDialog сlickGeneral()
	{
		Assert.assertTrue(driver.click(general));
		return this;
	}

}
