package com.objects.npobjects.pageelements.dialogs;

import com.objects.npobjects.pageobjects.DatasourceCreate;
import com.service.ui.web.SeleniumDriverWrapper;
import org.openqa.selenium.By;
import org.testng.Assert;

public class FieldSettingsDialog extends Dialog
{
	private DatasourceCreate parentPage;

	private final By title = dialogMdcAppBarTitle("Field settings");
	private final By fieldName = dialogNpTextFieldWithLabel("Field name");
	private final By okBtn = dialogMdcTextBtn("OK");
	private final By cancelBtn = dialogMdcTextBtn("Cancel");
	private final By splitBtn = dialogMdcListItemWithTextIcon("Split...", "ic_check_box_outline");
	private final By separatorInput = dialogNpTextFieldWithLabel("Set multi dimension separator");

	public FieldSettingsDialog(SeleniumDriverWrapper driver, DatasourceCreate pageObj)
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

	public FieldSettingsDialog clickFieldsInDialogByName(String text, String iconClass, int time)
	{
		Assert.assertTrue(driver.waitUntilClickable(By.xpath("//div[contains(@class, 'mdc-dialog--open')]//span[contains(@class, 'mdc-list-item__text') and contains(text(), '" + text + "')]/preceding-sibling::span[contains(@class, '" + iconClass + "')]/parent::li"), time));
		Assert.assertTrue(driver.click(By.xpath("//div[contains(@class, 'mdc-dialog--open')]//span[contains(@class, 'mdc-list-item__text') and contains(text(), '" + text + "')]/preceding-sibling::span[contains(@class, '" + iconClass + "')]/parent::li")));
		return this;
	}
}

