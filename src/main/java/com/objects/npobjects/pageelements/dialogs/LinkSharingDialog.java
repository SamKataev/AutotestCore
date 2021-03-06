package com.objects.npobjects.pageelements.dialogs;

import com.objects.npobjects.pageobjects.NavigatorPage;
import com.service.ui.web.SeleniumDriverWrapper;
import junit.framework.Assert;
import org.openqa.selenium.By;

public class LinkSharingDialog extends Dialog
{
	private NavigatorPage parentPage;

	private final By title = dialogAppBarTitle("Link sharing");
	private final By closeBtn = dialogIconFontBtn("ic_close");
	private final By searchBtn = dialogIconFontBtn("ic_delete");
	private final By linkInput = dialogTextFieldWithLabel("Link to share");
	private final By EmbedCodeInput = dialogTextFieldWithLabel("Embed code");

	public LinkSharingDialog(SeleniumDriverWrapper driver, NavigatorPage pageObj)
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

	public String getLinkSharing()
	{
		return driver.getElement(linkInput, 2).getAttribute("value");
	}

	public String getEmbedCode()
	{
		return driver.getElement(EmbedCodeInput, 2).getAttribute("value");
	}
}
