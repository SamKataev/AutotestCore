package com.objects.npobjects.pageelements.dialogs;

import com.objects.npobjects.pageobjects.NavigatorPage;
import com.service.ui.web.SeleniumDriverWrapper;
import org.openqa.selenium.By;

/**
 * Created by Kate on 03-Apr-19.
 */
public class WorkspaceSettingsDialog extends Dialog
{
	private NavigatorPage parentPage;

	private final By title = dialogAppBarTitle("Workspace Settings");
	private final By inputWorkspaceName = dialogTextFieldWithLabel("Workspace Name");
	private final By itemShareableLinks = dialogListItemWithText("Allow Users to Generate Shareable Links");
	private final By inputOwner = dialogSelectWithLabel("Owner");


	public WorkspaceSettingsDialog(SeleniumDriverWrapper driver, NavigatorPage pageObj)
	{
		super(driver);
		parentPage = pageObj;
	}

	@Override
	public boolean validateElements()
	{
		return driver.waitUntilExist(title, 5)
				  && driver.waitUntilClickable(closeBtn)
				  && driver.waitUntilVisible(doneBtn)
				  && !driver.waitUntilClickable(doneBtn, 1, false)
				  && driver.waitUntilClickable(inputWorkspaceName)
				  && driver.waitUntilClickable(itemShareableLinks)
				  && driver.waitUntilClickable(inputOwner);

	}

	public WorkspaceSettingsDialog checkIsRendered()
	{
		super.checkIsRendered();
		return this;
	}
}
