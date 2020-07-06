package com.objects.npobjects.pageelements.dialogs;

import com.objects.npobjects.pageobjects.DatasourcePage;
import com.service.ui.web.SeleniumDriverWrapper;
import org.openqa.selenium.By;
import org.testng.Assert;

public class CalculationFieldDialog extends Dialog
{
	private DatasourcePage parentPage;

	private final By title = dialogAppBarTitle("Calculation field");
	private final By fieldName = dialogTextFieldWithLabel("Name");
	private final By codeMirror = By.xpath("//div[contains(@class,'CodeMirror cm-s-default')]");
	private final By okBtn = dialogTextBtn("OK");
	private final By cancelBtn = dialogTextBtn("Cancel");

	public CalculationFieldDialog(SeleniumDriverWrapper driver, DatasourcePage pageObj)
	{
		super(driver);
		parentPage = pageObj;
	}

	@Override
	public boolean validateElements()
	{
		return driver.waitUntilExist(title, 5)
				  && driver.waitUntilClickable(fieldName, 5)
				  && driver.waitUntilClickable(codeMirror, 5)
				  && driver.waitUntilClickable(okBtn, 5)
				  && driver.waitUntilClickable(cancelBtn, 5);
	}

	public CalculationFieldDialog checkIsRendered()
	{
		super.checkIsRendered();
		return this;
	}

	public CalculationFieldDialog fieldNameInput(String text)
	{
		Assert.assertTrue(driver.type(fieldName, text));
		return this;
	}

	public CalculationFieldDialog clickCodeMirror()
	{
		Assert.assertTrue(driver.click(codeMirror));
		return this;
	}

	public CalculationFieldDialog clickOkBtn()
	{
		Assert.assertTrue(driver.click(okBtn));
		return this;
	}
}
