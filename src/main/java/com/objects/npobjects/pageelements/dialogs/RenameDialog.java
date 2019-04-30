package com.objects.npobjects.pageelements.dialogs;

import com.objects.npobjects.pageobjects.Main;
import com.objects.npobjects.pageobjects.oauthpages.DropboxLogIn;
import com.service.ui.web.SeleniumDriverWrapper;
import junit.framework.Assert;
import org.openqa.selenium.By;

public class RenameDialog extends Dialog
{
	private Main parentPage;

	private final By title = dialogMdcAppBarTitle("Rename");
	private final By cancelBtn = dialogMdcTextBtn("Cancel");
	private final By renameBtn = dialogMdcTextBtn("Rename");
	private final By inputName = dialogNpTextFieldWithLabel("Please enter a new name for the item:");


	public RenameDialog(SeleniumDriverWrapper driver, Main pageObj)
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
		org.testng.Assert.assertTrue(driver.type(inputName, text));
		return this;
	}
}
