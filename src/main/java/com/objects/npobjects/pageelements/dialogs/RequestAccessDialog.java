package com.objects.npobjects.pageelements.dialogs;

import com.objects.npobjects.pageobjects.NavigatorPage;
import com.service.ui.web.SeleniumDriverWrapper;
import org.openqa.selenium.By;
import org.testng.Assert;

public class RequestAccessDialog extends Dialog
{
	private NavigatorPage parentPage;

	private By logoutBtn = unelevatedBtn("Switch Account");
	private By requestBtn = unelevatedBtn("Request Access");
	private By closeBtn = iconFontBtn("ic_close");
	private By message = By.xpath("//div[contains(@class, 'mdc-dialog--open')]//div[contains(@class, 'mdc-dialog__content')]//span[contains(text(),'You need permission')]");

	public RequestAccessDialog(SeleniumDriverWrapper driver, NavigatorPage pageObj)
	{
		super(driver);
		parentPage = pageObj;
	}

	@Override
	public boolean validateElements()
	{
		return driver.waitUntilExist(closeBtn, 5)
				  && driver.waitUntilClickable(logoutBtn)
				  && driver.waitUntilExist(message)
				  && driver.waitUntilClickable(requestBtn);
	}

	public RequestAccessDialog checkIsRendered()
	{
		super.checkIsRendered();
		return this;
	}

	public RequestAccessDialog checkLogoutBtn()
	{
		Assert.assertTrue(driver.waitUntilClickable(logoutBtn,10));
		return this;
	}

	public RequestAccessDialog checkRequestBtn()
	{
		Assert.assertTrue(driver.waitUntilClickable(requestBtn));
		return this;
	}

	public RequestAccessDialog clickCloseBtn()
	{
		Assert.assertTrue(driver.click(closeBtn));
		return this;
	}
}
