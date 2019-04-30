package com.objects.npobjects.pageelements.dialogs;

import com.objects.npobjects.pageobjects.Main;
import com.service.ui.web.SeleniumDriverWrapper;
import junit.framework.Assert;
import org.openqa.selenium.By;

/**
 * Created by Kate on 03-Apr-19.
 */
public class WorkspaceSettingsDialog extends Dialog
{
	private Main parentPage;

	private final By title = dialogMdcAppBarTitle("Workspace settings");
	private final By closeBtn = dialogMdcIconFontBtn("ic_close");
	private final By itemWorkspaceName = dialogMdcListAccordionWithText("Workspace name");
	private final By itemSecurity = dialogMdcListAccordionWithText("Security");
	private final By itemOwner = dialogMdcListAccordionWithText("Owner");


	public WorkspaceSettingsDialog(SeleniumDriverWrapper driver, Main pageObj)
	{
		super(driver);
		parentPage = pageObj;
	}

	@Override
	public boolean validateElements()
	{
		return driver.waitUntilExist(title, 5)
				  && driver.waitUntilClickable(closeBtn)
				  && driver.waitUntilClickable(itemWorkspaceName)
				  && driver.waitUntilClickable(itemSecurity)
				  && driver.waitUntilClickable(itemOwner);

	}

	public WorkspaceSettingsDialog checkIsRendered()
	{
		super.checkIsRendered();
		return this;
	}

	public WorkspaceSettingsDialog clickitemDetails()
	{
		Assert.assertTrue(driver.click(itemWorkspaceName));
		return this;
	}
}
