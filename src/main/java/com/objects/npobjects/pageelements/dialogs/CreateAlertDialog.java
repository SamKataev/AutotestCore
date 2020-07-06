package com.objects.npobjects.pageelements.dialogs;

import com.objects.npobjects.pageobjects.NavigatorPage;
import com.service.ui.web.SeleniumDriverWrapper;
import junit.framework.Assert;
import org.openqa.selenium.By;

/**
 * Created by Kate on 03-Apr-19.
 */
public class CreateAlertDialog extends Dialog
{

	private NavigatorPage parentPage;

	private final By title = dialogAppBarTitle("Create Alert");
	private final By inputNameAlert = dialogTextFieldWithLabel("New Alert");
	private final By addSourceBtn = dialogListItemWithTextIcon("Add data source", "ic_add");
	private final By cancel = dialogTextBtn("Cancel");
	private final By saveChanges = dialogTextBtn("Save changes");
	private final By closeBtn = dialogIconFontBtn("ic_close");

	public CreateAlertDialog(SeleniumDriverWrapper driver, NavigatorPage pageObj)
	{
		super(driver);
		parentPage = pageObj;
	}

	@Override
	public boolean validateElements()
	{
		return driver.waitUntilExist(title, 5)
				  && driver.waitUntilClickable(closeBtn)
				  && driver.waitUntilClickable(inputNameAlert)
				  && driver.waitUntilClickable(addSourceBtn)
				  && driver.waitUntilClickable(cancel)
				  && driver.waitUntilClickable(saveChanges);
	}

	public CreateAlertDialog checkIsRendered()
	{
		super.checkIsRendered();
		return this;
	}

	public CreateAlertDialog ClickAddSourceBtn()
	{
		Assert.assertTrue(driver.click(addSourceBtn));
		return this;
	}

}
