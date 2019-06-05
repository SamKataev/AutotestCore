package com.objects.npobjects.pageelements.dialogs;

import com.objects.npobjects.pageobjects.Main;
import com.objects.npobjects.pageobjects.ReportsCreate;
import com.service.ui.web.SeleniumDriverWrapper;
import junit.framework.Assert;
import org.openqa.selenium.By;

public class SaveChangeDialog extends Dialog
{

	private Main parentPage;

	private final By cancelBtn = dialogMdcTextBtn("Cancel");
	private final By saveBtn = dialogMdcTextBtn("Save");
	private final By dontSaveBtn = dialogMdcTextBtn("t save");
	private final By title = dialogMdcAppBarTitle("Save changes?");


	public SaveChangeDialog(SeleniumDriverWrapper driver, Main pageObj)
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
