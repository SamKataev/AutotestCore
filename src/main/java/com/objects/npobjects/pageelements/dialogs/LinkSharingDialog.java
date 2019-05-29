package com.objects.npobjects.pageelements.dialogs;

import com.objects.npobjects.pageobjects.Main;
import com.service.ui.web.SeleniumDriverWrapper;
import junit.framework.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class LinkSharingDialog extends Dialog
{
	private Main parentPage;

	private final By title = dialogMdcAppBarTitle("Link sharing");
	private final By closeBtn = dialogMdcIconFontBtn("ic_close");
	private final By searchBtn = dialogMdcIconFontBtn("ic_delete");
	private final By linkInput = dialogNpTextFieldWithLabel("Link to share");


	public LinkSharingDialog (SeleniumDriverWrapper driver, Main pageObj)
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

	public LinkSharingDialog checkIsRendered()
	{
		super.checkIsRendered();
		return this;
	}

	public LinkSharingDialog clickCloseBtn()
	{
		Assert.assertTrue(driver.click(closeBtn));
		return this;
	}

	}
