package com.objects.npobjects.pageelements.dialogs;

import com.objects.npobjects.pageobjects.DataSourcePage;
import com.service.ui.web.SeleniumDriverWrapper;
import org.openqa.selenium.By;
import org.testng.Assert;

public class FieldSettingsDialog extends Dialog
{
	private DataSourcePage parentPage;

	private final By title = dialogAppBarTitle("Field settings");
	private final By fieldName = dialogTextFieldWithLabel("Field name");
	private final By okBtn = dialogUnelevatedBtn("OK");
	private final By cancelBtn = dialogUnelevatedBtn("Cancel");
	private final By splitBtn = dialogListItemWithTextIcon("Split...", "ic_check_box_outline");
	private final By separatorInput = dialogTextFieldWithLabel("Set multi dimension separator");
	private final By distinctCountSettingsBtn = unelevatedBtn("Distinct-count settings");

	public FieldSettingsDialog(SeleniumDriverWrapper driver, DataSourcePage pageObj)
	{
		super(driver);
		parentPage = pageObj;
	}

	@Override
	public boolean validateElements()
	{
		return driver.waitUntilExist(title, 5)
				  && driver.waitUntilClickable(fieldName, 5)
				  && driver.waitUntilClickable(okBtn, 5)
				  && driver.waitUntilClickable(cancelBtn, 5);
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

	public FieldSettingsDialog clickSplitBtn()
	{
		Assert.assertTrue(driver.click(splitBtn));
		return this;
	}

	public FieldSettingsDialog separatorInput(String text)
	{
		Assert.assertTrue(driver.type(separatorInput, text));
		return this;
	}
}

