package com.objects.npobjects.pageelements.dialogs;

import com.objects.npobjects.pageobjects.Main;
import com.service.ui.web.SeleniumDriverWrapper;
import junit.framework.Assert;
import org.openqa.selenium.By;

public class PermissionsDialog extends Dialog
{
	public Main parentPage;

	private final By title = dialogMdcAppBarTitle("Permissions");
	private final By closeBtn = dialogMdcIconFontBtn("ic_close");
	private final By searchBtn = dialogMdcIconFontBtn("ic_search");

	public PermissionsDialog (SeleniumDriverWrapper driver, Main pageObj)
	{
		super(driver);
		parentPage = pageObj;
	}
	@Override
	public boolean validateElements()
	{
		return driver.waitUntilClickable(closeBtn, 5)
				  && driver.waitUntilExist(searchBtn)
				  && driver.waitUntilExist(title);
	}
	public PermissionsDialog checkIsRendered()
	{
		super.checkIsRendered();
		return this;
	}
	public PermissionsDialog clickCloseBtn()
	{
		Assert.assertTrue(driver.click(closeBtn));
		return this;
	}
	public PermissionsDialog checkSelectPeople(String text, int time)
	{
		Assert.assertTrue(driver.waitUntilExist(By.xpath("//div[contains(@class, 'mdc-dialog--open')]//span[contains(@class, 'mdc-list-item__secondary-text') and contains(text(), '" + text + "')]/parent::span/parent::li"), time));
		return this;
	}
}
