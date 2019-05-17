package com.objects.npobjects.pageelements.dialogs;

import com.objects.npobjects.pageobjects.DatasourceCreate;
import com.service.ui.web.SeleniumDriverWrapper;
import org.openqa.selenium.By;
import org.testng.Assert;

public class FieldSettingsDialog extends Dialog
{
	private DatasourceCreate parentPage;

	private final By title = dialogMdcAppBarTitle("Field settings");
	private final By fieldName = dialogNpTextFieldWithLabel ("Field name");
	private final By okBtn = dialogMdcTextBtn("OK");
	private final By cancelBtn = dialogMdcTextBtn("Cancel");

	public FieldSettingsDialog (SeleniumDriverWrapper driver, DatasourceCreate pageObj)
	{
		super(driver);
		parentPage = pageObj;
	}

	@Override
	public boolean validateElements()
	{
		return driver.waitUntilExist(title, 5)
				  &&driver.waitUntilClickable(fieldName, 5)
		        &&driver.waitUntilClickable(okBtn, 5)
		        &&driver.waitUntilClickable(cancelBtn, 5);
	}

	public FieldSettingsDialog checkIsRendered()
	{
		super.checkIsRendered();
		return this;
	}

	public FieldSettingsDialog fieldNameInput(String text)
	{
		Assert.assertTrue(driver.type(fieldName, text));
		return this;
	}
	public FieldSettingsDialog okBtn()
	{
		Assert.assertTrue(driver.click(okBtn));
		return this;
	}
	public FieldSettingsDialog cancelBtn()
	{
		Assert.assertTrue(driver.click(cancelBtn));
		return this;
	}


}

