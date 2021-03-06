package com.objects.npobjects.pageelements.dialogs;

import com.objects.npobjects.pageobjects.ReportPage;
import com.service.ui.web.SeleniumDriverWrapper;
import junit.framework.Assert;
import org.openqa.selenium.By;

public class SaveAsDialog extends Dialog
{

	private ReportPage parentPage;

	private final By cancelBtn = dialogUnelevatedBtn("Cancel");
	private final By okBtn = dialogUnelevatedBtn("OK");
	private final By inputName = dialogTextFieldWithLabel("Name");


	public SaveAsDialog(SeleniumDriverWrapper driver, ReportPage pageObj)
	{
		super(driver);
		parentPage = pageObj;
	}

	@Override
	public boolean validateElements()
	{
		return driver.waitUntilExist(okBtn, 5)
				  && driver.waitUntilClickable(cancelBtn);
	}

	public SaveAsDialog checkIsRendered()
	{
		super.checkIsRendered();
		return this;
	}

	public SaveAsDialog enterInputName(String text)
	{
		Assert.assertTrue(driver.type(inputName, text));
		return this;
	}
}
