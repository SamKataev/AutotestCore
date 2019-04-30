package com.objects.npobjects.pageelements.dialogs;

import com.objects.npobjects.pageobjects.Main;
import com.objects.npobjects.pageobjects.ReportsCreate;
import com.service.ui.web.SeleniumDriverWrapper;
import org.openqa.selenium.By;
import org.testng.Assert;

public class ChooseaChartTypeDialog extends Dialog
{
	private ReportsCreate parentPage;

	private final By closeBtn = dialogMdcIconFontBtn("ic_close");
	private final By title = dialogMdcAppBarTitle("Choose a chart type");

	public ChooseaChartTypeDialog(SeleniumDriverWrapper driver, ReportsCreate pageObj)
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

	public ChooseaChartTypeDialog checkIsRendered()
	{
		super.checkIsRendered();
		return this;
	}

	public ChooseaChartTypeDialog clickTypeChartInDialogByName(String text, String iconClass, int time)
	{
		Assert.assertTrue(driver.waitUntilClickable(By.xpath("//div[contains(@class, 'mdc-dialog--open')]//span[contains(@class, 'mdc-list-item__text') and contains(text(), '" + text + "')]/preceding-sibling::span[contains(@class, '" + iconClass + "')]/parent::li"), time));
		Assert.assertTrue(driver.click(By.xpath("//div[contains(@class, 'mdc-dialog--open')]//span[contains(@class, 'mdc-list-item__text') and contains(text(), '" + text + "')]/preceding-sibling::span[contains(@class, '" + iconClass + "')]/parent::li")));
		return this;
	}

}