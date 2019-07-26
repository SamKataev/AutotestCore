package com.objects.npobjects.pageelements.dialogs;

import com.objects.npobjects.pageobjects.ReportsCreate;
import com.service.ui.web.SeleniumDriverWrapper;
import org.openqa.selenium.By;
import org.testng.Assert;

public class CalculationsAddDialog extends Dialog
{
	private ReportsCreate parentPage;

	private final By closeBtn = dialogMdcIconFontBtn("ic_close");
	private final By title = dialogMdcAppBarTitle("Calculations");
	private final By addBtn = dialogMdcTextBtn("Add");


	public CalculationsAddDialog(SeleniumDriverWrapper driver, ReportsCreate pageObj)
	{
		super(driver);
		parentPage = pageObj;
	}

	@Override
	public boolean validateElements()
	{
		return driver.waitUntilClickable(closeBtn, 5)
				  && driver.waitUntilClickable(addBtn)
				  && driver.waitUntilExist(title);
	}

	public CalculationsAddDialog checkIsRendered()
	{
		super.checkIsRendered();
		return this;
	}

	public CalculationsAddDialog clickAddBtn()
	{
		Assert.assertTrue(driver.waitUntilClickable(addBtn, 10));
		Assert.assertTrue(driver.click(addBtn));
		return this;
	}

	public CalculationsAddDialog clickСloseBtn()
	{
		Assert.assertTrue(driver.click(closeBtn));
		return this;
	}

	public CalculationsAddDialog checkMeasureTableByName(String text, int time)
	{
		Assert.assertTrue(driver.waitUntilClickable(By.xpath("//span[contains(@class,'mdc-list-item__text')]//span[contains(@class,'mdc-list-item__primary-text') and (text()='" + text + "')]/ancestor::li"),time));
		return this;
	}
}
