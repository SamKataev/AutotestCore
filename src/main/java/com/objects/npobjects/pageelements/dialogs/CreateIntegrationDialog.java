package com.objects.npobjects.pageelements.dialogs;

import com.objects.npobjects.pageobjects.Auth;
import com.objects.npobjects.pageobjects.Main;
import com.service.ui.web.SeleniumDriverWrapper;
import org.openqa.selenium.By;
import org.testng.Assert;

/**
 * Created by User on 08-Apr-19.
 */
public class CreateIntegrationDialog extends Dialog
{

	private Main parentPage;

	private final By title = dialogMdcAppBarTitle("Create integration");
	private final By closeBtn = dialogMdcIconFontBtn("ic_close");

	private final By general = dialogMdcListAccordionWithText("General");
	private final By security = dialogMdcListAccordionWithText("Security");
	private final By dataRefresh = dialogMdcListAccordionWithText("Data refresh");
	private final By displaynameField = dialogNpTextFieldWithLabel("Display name");

	private final By hostField = dialogNpTextFieldWithLabel("Host");
	private final By portField = dialogNpTextFieldWithLabel("Port");
	private final By databaseNameField = dialogNpTextFieldWithLabel("Database Name");
	private final By usernameField = dialogNpTextFieldWithLabel("Username");
	private final By passwordField = dialogNpTextFieldWithLabel("Password");
	private final By endpointField = dialogNpTextFieldWithLabel("Endpoint");


	private final By createBtn = mdcTextBtn("Create");
	private final By checkBtn = mdcTextBtn("Check connection");

	public CreateIntegrationDialog(SeleniumDriverWrapper driver, Main pageObj)
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
