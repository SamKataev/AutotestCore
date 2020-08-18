package com.objects.npobjects.pageelements.dialogs;

import com.objects.npobjects.pageobjects.ReportPage;
import com.service.ui.web.SeleniumDriverWrapper;
import junit.framework.Assert;
import org.openqa.selenium.By;

public class HTTPSwebAddressDialog extends Dialog
{

	private ReportPage parentPage;

	private final By title = dialogAppBarTitle("HTTPS Web Address");
	private final By urlInput = By.xpath("//div[contains(@class, 'mdc-dialog--open')]//following-sibling::div[contains(@class, 'text-field__input-container')]/input");

	public HTTPSwebAddressDialog(SeleniumDriverWrapper driver, ReportPage pageObj)
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

	public HTTPSwebAddressDialog checkIsRendered()
	{
		super.checkIsRendered();
		return this;
	}

	public HTTPSwebAddressDialog typeUrl(String url)
	{
		Assert.assertTrue(driver.type(urlInput, url));
		return this;
	}


}