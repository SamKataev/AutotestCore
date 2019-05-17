package com.objects.npobjects.pageelements.dialogs;

import com.objects.npobjects.pageobjects.ReportsCreate;
import com.service.ui.web.SeleniumDriverWrapper;
import org.openqa.selenium.By;
import org.testng.Assert;

public class CalculationsDialog extends Dialog
{
	private ReportsCreate parentPage;

	private final By title = dialogMdcAppBarTitle("Calculations");
	private final By SaveBtn = dialogMdcAppBarTextBtn("Save");
	private By codeMirror = By.xpath("//div[contains(@class,'CodeMirror cm-s-default')]");

	public CalculationsDialog(SeleniumDriverWrapper driver, ReportsCreate pageObj)
	{
		super(driver);
		parentPage = pageObj;
	}

	@Override
	public boolean validateElements()
	{
		return driver.waitUntilClickable(SaveBtn, 5)
				  && driver.waitUntilExist(title);
	}

	public CalculationsDialog checkIsRendered()
	{
		super.checkIsRendered();
		return this;
	}

	public CalculationsDialog clickSaveBtn()
	{
		Assert.assertTrue(driver.click(SaveBtn));
		return this;
	}

	public CalculationsDialog clickCodeMirror()
	{
		Assert.assertTrue(driver.click(codeMirror));
		return this;
	}

	public CalculationsDialog clickMetricsByName(String text)
	{
		Assert.assertTrue(driver.click(By.xpath("//div[contains(@class, 'calculations-edit__metrics')]//span[contains(@class, 'mdc-list-item__text') and contains(text(), '" + text + "')]/parent::li")));
		return this;
	}
}