package com.objects.npobjects.pageelements.dialogs;

import com.objects.npobjects.pageobjects.ReportsCreate;
import com.service.ui.web.SeleniumDriverWrapper;
import junit.framework.Assert;
import org.openqa.selenium.By;

public class SettingsReportDialog extends Dialog
{
	private ReportsCreate parentPage;

	private final By title = nodeMdcAppBarTitle("Settings");
	private final By canvasSizeSelect = nodeMdcAppBarSelect("Layout type", "Floating");


	public SettingsReportDialog(SeleniumDriverWrapper driver, ReportsCreate pageObj)
	{
		super(driver);
		parentPage = pageObj;
	}

	@Override
	public boolean validateElements()
	{
		return driver.waitUntilExist(title, 5)
				  && driver.waitUntilClickable(canvasSizeSelect);
	}

	public SettingsReportDialog checkIsRendered()
	{
		super.checkIsRendered();
		return this;
	}

}
