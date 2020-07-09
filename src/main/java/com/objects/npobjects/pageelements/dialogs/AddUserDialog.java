package com.objects.npobjects.pageelements.dialogs;

import com.objects.npobjects.pageobjects.NavigatorPage;
import com.service.ui.web.SeleniumDriverWrapper;
import junit.framework.Assert;
import org.openqa.selenium.By;

/**
 * Created by Kate on 03-Apr-19.
 */
public class AddUserDialog extends Dialog
{
	public NavigatorPage parentPage;

	private final By title = dialogAppBarTitle("Add user");
	private final By emailInput = dialogTextFieldWithLabel("Email");
	private final By roleSelect = dialogSelectWithLabel("Role");
	private final By cancel = dialogUnelevatedBtn("Cancel");
	private final By addBtn = dialogUnelevatedBtn("Add");

	public AddUserDialog(SeleniumDriverWrapper driver, NavigatorPage pageObj)
	{
		super(driver);
		parentPage = pageObj;
	}

	@Override
	public boolean validateElements()
	{
		return driver.waitUntilExist(title, 5)
				  && driver.waitUntilClickable(emailInput)
				  && driver.waitUntilClickable(roleSelect)
				  && driver.waitUntilClickable(cancel)
				  && driver.waitUntilClickable(addBtn);
	}

	public AddUserDialog checkIsRendered()
	{
		super.checkIsRendered();
		return this;
	}

	public AddUserDialog ClickAddSourceBtn()
	{
		Assert.assertTrue(driver.click(emailInput));
		return this;
	}


}
