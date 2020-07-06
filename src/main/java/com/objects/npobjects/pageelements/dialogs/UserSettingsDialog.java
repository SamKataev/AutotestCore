package com.objects.npobjects.pageelements.dialogs;

import com.objects.npobjects.pageobjects.NavigatorPage;
import com.service.ui.web.SeleniumDriverWrapper;
import junit.framework.Assert;
import org.openqa.selenium.By;

/**
 * Created by Kate on 03-Apr-19.
 */
public class UserSettingsDialog extends Dialog
{

	private NavigatorPage parentPage;

	private final By title = dialogAppBarTitle("Settings");
	private final By moreOptionsBtn = dialogIconFontBtn("ic_menu_");
	private final By itemDetails = dialogListAccordionWithText("Details");
	private final By itemPassword = dialogListAccordionWithText("Password");
	private final By itemLanguage = dialogListAccordionWithText("Region Settings");
	private final By itemCloudStorage = dialogListAccordionWithText("Integrations and Apps");
	private final By itemNotification = dialogListAccordionWithText("Notification Settings");
	private final By addIntegrationBtn = dialogListItemWithTextIcon("Add integration", "ic_add");


	public UserSettingsDialog(SeleniumDriverWrapper driver, NavigatorPage pageObj)
	{
		super(driver);
		parentPage = pageObj;
	}

	@Override
	public boolean validateElements()
	{
		return driver.waitUntilExist(title, 5)
				  && driver.waitUntilClickable(closeBtn)
				  && driver.waitUntilClickable(moreOptionsBtn)
				  && driver.waitUntilClickable(itemDetails)
				  && driver.waitUntilClickable(itemPassword)
				  && driver.waitUntilClickable(itemLanguage)
				  && driver.waitUntilClickable(itemCloudStorage)
				  && driver.waitUntilClickable(itemNotification);
	}

	public UserSettingsDialog checkIsRendered()
	{
		super.checkIsRendered();
		return this;
	}

	public UserSettingsDialog clickitemDetails()
	{
		Assert.assertTrue(driver.click(itemDetails));
		return this;
	}

	public UserSettingsDialog clickItemCloudStorage()
	{
		Assert.assertTrue(driver.click(itemCloudStorage));
		return this;
	}

	public UserSettingsDialog clickaddIntegrationBtn()
	{
		Assert.assertTrue(driver.click(addIntegrationBtn));
		return this;
	}

}
