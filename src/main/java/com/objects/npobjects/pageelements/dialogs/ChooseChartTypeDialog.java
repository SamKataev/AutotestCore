package com.objects.npobjects.pageelements.dialogs;

import com.objects.npobjects.pageobjects.ReportPage;
import com.service.ui.web.SeleniumDriverWrapper;
import org.openqa.selenium.By;
import org.testng.Assert;

public class ChooseChartTypeDialog extends Dialog
{
	private ReportPage parentPage;

	private final By closeBtn = dialogIconFontBtn("ic_close");
	private final By title = dialogAppBarTitle("Choose a Chart Type");

	public ChooseChartTypeDialog(SeleniumDriverWrapper driver, ReportPage pageObj)
	{
		super(driver);
		parentPage = pageObj;
	}

	@Override
	public boolean validateElements()
	{
		return driver.waitUntilClickable(closeBtn, 5)
				  && driver.waitUntilExist(title);
	}

	public ChooseChartTypeDialog checkIsRendered()
	{
		super.checkIsRendered();
		return this;
	}

	public ReportPage clickChartType(String text)
	{
		Assert.assertTrue(driver.click(dialogListItemWithText(text)));
		return parentPage;
	}
}