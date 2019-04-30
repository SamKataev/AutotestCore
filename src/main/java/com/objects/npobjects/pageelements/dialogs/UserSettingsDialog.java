package com.objects.npobjects.pageelements.dialogs;

import com.objects.npobjects.pageobjects.Main;
import com.service.ui.web.SeleniumDriverWrapper;
import junit.framework.Assert;
import org.openqa.selenium.By;

/**
 * Created by Kate on 03-Apr-19.
 */
public class UserSettingsDialog extends Dialog
{

	private Main parentPage;

	private final By title = dialogMdcAppBarTitle("Settings");
	private final By closeBtn = dialogMdcIconFontBtn("ic_close");
	private final By moreOptionsBtn = dialogMdcIconFontBtn("ic_more_vert");
	private final By itemDetails = dialogMdcListAccordionWithText("Details");
	private final By itemPassword = dialogMdcListAccordionWithText("Password");
	private final By itemLanguage = dialogMdcListAccordionWithText("Language and region settings");
	private final By itemCloudStorage = dialogMdcListAccordionWithText("Cloud storage integrations");
	private final By itemNotification = dialogMdcListAccordionWithText("Notification settings");
	private final By addIntegrationBtn = dialogMdcListItemWithTextIcon("Add integration", "ic_add");


	public UserSettingsDialog(SeleniumDriverWrapper driver, Main pageObj)
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
