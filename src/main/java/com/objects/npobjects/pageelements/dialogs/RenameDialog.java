package com.objects.npobjects.pageelements.dialogs;

import com.objects.npobjects.pageobjects.NavigatorPage;
import com.service.ui.web.SeleniumDriverWrapper;
import junit.framework.Assert;
import org.openqa.selenium.By;

public class RenameDialog extends Dialog
{
	private NavigatorPage parentPage;

	private final By title = dialogAppBarTitle("Rename");
	private final By cancelBtn = dialogUnelevatedBtn("Cancel");
	private final By renameBtn = dialogUnelevatedBtn("Rename");
	private final By inputName = dialogTextFieldWithLabel("Please enter a new name for the item:");


	public RenameDialog(SeleniumDriverWrapper driver, NavigatorPage pageObj)
	{
		super(driver);
		parentPage = pageObj;
	}

	@Override
	public boolean validateElements()
	{
		return driver.waitUntilExist(title, 5)
				  && driver.waitUntilClickable(cancelBtn)
				  && driver.waitUntilClickable(renameBtn);
	}

	public RenameDialog checkIsRendered()
	{
		super.checkIsRendered();
		return this;
	}

	public RenameDialog clickRenameBtn()
	{
		Assert.assertTrue(driver.click(renameBtn));
		return this;
	}

	public RenameDialog enterInputName(String text)
	{
		Assert.assertTrue(driver.type(inputName, text));
		return this;
	}
}
