package com.objects.npobjects.pageelements.dialogs;

import com.objects.npobjects.pageobjects.NavigatorPage;
import com.service.ui.web.SeleniumDriverWrapper;
import junit.framework.Assert;
import org.openqa.selenium.By;

public class SaveChangeDialog extends Dialog
{

	private NavigatorPage parentPage;

	private final By cancelBtn = dialogUnelevatedBtn("Cancel");
	private final By saveBtn = dialogUnelevatedBtn("Save");
	private final By dontSaveBtn = dialogUnelevatedBtn("t save");
	private final By title = dialogAppBarTitle("Save changes?");


	public SaveChangeDialog(SeleniumDriverWrapper driver, NavigatorPage pageObj)
	{
		super(driver);
		parentPage = pageObj;
	}

	@Override
	public boolean validateElements()
	{
		return driver.waitUntilExist(title, 5)
				  && driver.waitUntilClickable(cancelBtn);
	}

	public SaveChangeDialog checkIsRendered()
	{
		super.checkIsRendered();
		return this;
	}

	public SaveChangeDialog clickSaveBtn()
	{
		Assert.assertTrue(driver.click(saveBtn));
		return this;
	}

	public SaveChangeDialog clickDontSaveBtn()
	{
		Assert.assertTrue(driver.click(dontSaveBtn));
		return this;
	}


}
