package com.objects.npobjects.pageelements.dialogs;

import com.objects.npobjects.pageobjects.NavigatorPage;
import com.service.ui.web.SeleniumDriverWrapper;
import junit.framework.Assert;
import org.openqa.selenium.By;

/**
 * Created by User on 08-Apr-19.
 */
public class MessageDialog extends Dialog
{

	private NavigatorPage parentPage;

	private final By title = dialogAppBarTitle("Message");
	private final By closeBtn = unelevatedBtn("Close");
	private final By message = dialogTextMessage("Success");


	public MessageDialog(SeleniumDriverWrapper driver, NavigatorPage pageObj)
	{
		super(driver);
		parentPage = pageObj;
	}

	@Override
	public boolean validateElements()
	{
		return driver.waitUntilExist(title, 20)
				  && driver.waitUntilClickable(closeBtn);
//				  && driver.waitUntilClickable(message);
	}

	public MessageDialog checkIsRendered()
	{
		super.checkIsRendered();
		return this;
	}

	public MessageDialog clickcloseBtn()
	{
		Assert.assertTrue(driver.click(closeBtn));
		return this;
	}

	public MessageDialog checkMessage(String text, int time)
	{
		Assert.assertTrue(driver.waitUntilExist(By.xpath("//div[contains(@class, 'mdc-dialog--open')]//div[contains(@class, 'mdc-dialog__content') and text() = '" + text + "']"), time));
		return this;
	}
}