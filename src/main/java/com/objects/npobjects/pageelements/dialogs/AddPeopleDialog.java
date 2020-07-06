package com.objects.npobjects.pageelements.dialogs;

import com.objects.npobjects.pageobjects.NavigatorPage;
import com.service.ui.web.SeleniumDriverWrapper;
import junit.framework.Assert;
import org.openqa.selenium.By;

public class AddPeopleDialog extends Dialog
{
	public NavigatorPage parentPage;

	private final By title = dialogAppBarTitle("Add people");
	private final By closeBtn = dialogIconFontBtn("ic_close");
	private final By searchBtn = dialogIconFontBtn("ic_search");
	private final By sendBtn = By.xpath("//div[contains(@class, 'mdc-dialog--open')]//span[contains(@class, 'ic_send')]/parent::button[contains(@class, 'mdc-fab')]");

	public AddPeopleDialog(SeleniumDriverWrapper driver, NavigatorPage pageObj)
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

	public AddPeopleDialog checkIsRendered()
	{
		super.checkIsRendered();
		return this;
	}

	public AddPeopleDialog clickSendBtn()
	{
		Assert.assertTrue(driver.waitUntilClickable(sendBtn, 2));
		Assert.assertTrue(driver.click(sendBtn));
		return this;
	}

	public AddPeopleDialog selectPeople(String text, int time)
	{
		org.testng.Assert.assertTrue(driver.waitUntilClickable(By.xpath("//div[contains(@class, 'mdc-dialog--open')]//span[contains(@class, 'mdc-list-item__secondary-text') and contains(text(), '" + text + "')]/parent::span/parent::li"), time));
		org.testng.Assert.assertTrue(driver.click(By.xpath("//div[contains(@class, 'mdc-dialog--open')]//span[contains(@class, 'mdc-list-item__secondary-text') and contains(text(), '" + text + "')]/parent::span/parent::li")));
		return this;
	}
}
