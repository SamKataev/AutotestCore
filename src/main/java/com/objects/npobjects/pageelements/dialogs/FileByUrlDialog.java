package com.objects.npobjects.pageelements.dialogs;

import com.objects.npobjects.pageobjects.NavigatorPage;
import com.service.ui.web.SeleniumDriverWrapper;
import junit.framework.Assert;
import org.openqa.selenium.By;

public class FileByUrlDialog extends Dialog
{

	private NavigatorPage parentPage;

	private final By title = dialogAppBarTitle("File by URL");
	private final By urlInput = dialogTextFieldWithLabel("Url to upload");

	public FileByUrlDialog(SeleniumDriverWrapper driver, NavigatorPage pageObj)
	{
		super(driver);
		parentPage = pageObj;
	}

	@Override
	public boolean validateElements()
	{
		return driver.waitUntilExist(title, 5)
				  && driver.waitUntilClickable(urlInput)
				  && driver.waitUntilClickable(cancelBtn)
				  && driver.waitUntilClickable(okBtn);
	}

	public FileByUrlDialog typeUrl(String url)
	{
		Assert.assertTrue(driver.type(urlInput, url));
		return this;
	}

	public FileByUrlDialog checkIsRendered()
	{
		super.checkIsRendered();
		return this;
	}
}