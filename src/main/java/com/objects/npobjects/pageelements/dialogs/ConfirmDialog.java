package com.objects.npobjects.pageelements.dialogs;

import com.objects.npobjects.pageobjects.NavigatorPage;
import com.service.ui.web.SeleniumDriverWrapper;
import junit.framework.Assert;
import org.openqa.selenium.By;

public class ConfirmDialog extends Dialog
{
	private NavigatorPage parentPage;

	private final By title = dialogAppBarTitle("Confirm");
	private final By deleteBtn = dialogUnelevatedBtn("Delete");


	public ConfirmDialog(SeleniumDriverWrapper driver, NavigatorPage pageObj)
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
