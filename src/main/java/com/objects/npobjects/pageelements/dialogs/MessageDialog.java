package com.objects.npobjects.pageelements.dialogs;

import com.objects.npobjects.pageobjects.Main;
import com.service.ui.web.SeleniumDriverWrapper;
import junit.framework.Assert;
import org.openqa.selenium.By;

/**
 * Created by User on 08-Apr-19.
 */
public class MessageDialog extends Dialog
{

	private Main parentPage;

	private final By title = dialogMdcAppBarTitle("Message");
	private final By closeBtn = mdcTextBtn("Close");
	private final By message = dialogNpTextMessage("Success");


	public MessageDialog(SeleniumDriverWrapper driver, Main pageObj)
	{
		super(driver);
		parentPage = pageObj;
	}

	@Override
	public boolean validateElements()
	{
		return driver.waitUntilExist(title, 5)
				  && driver.waitUntilClickable(closeBtn)
				  && driver.waitUntilClickable(message);
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
}