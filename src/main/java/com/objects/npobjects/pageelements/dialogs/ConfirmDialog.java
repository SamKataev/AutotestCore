package com.objects.npobjects.pageelements.dialogs;

import com.objects.npobjects.pageobjects.Main;
import com.service.ui.web.SeleniumDriverWrapper;
import junit.framework.Assert;
import org.openqa.selenium.By;

public class ConfirmDialog extends Dialog
{
	private Main parentPage;

	private final By title = dialogMdcAppBarTitle("Confirm");
	private final By deleteBtn = dialogMdcTextBtn("Delete");


	public ConfirmDialog(SeleniumDriverWrapper driver, Main pageObj)
	{
		super(driver);
		parentPage = pageObj;
	}

	@Override
	public boolean validateElements()
	{
		return driver.waitUntilExist(title, 20)
				  && driver.waitUntilClickable(cancelBtn)
				  && driver.waitUntilClickable(deleteBtn);
	}

	public ConfirmDialog checkIsRendered()
	{
		super.checkIsRendered();
		return this;
	}

	public ConfirmDialog clickCancelBtn()
	{
		Assert.assertTrue(driver.click(cancelBtn));
		return this;
	}

	public ConfirmDialog clickDeleteBtn()
	{
		Assert.assertTrue(driver.click(deleteBtn));
		return this;
	}
}
