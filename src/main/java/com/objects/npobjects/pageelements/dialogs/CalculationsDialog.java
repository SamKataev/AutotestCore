package com.objects.npobjects.pageelements.dialogs;

import com.objects.npobjects.pageobjects.ReportPage;
import com.service.ui.web.SeleniumDriverWrapper;
import org.openqa.selenium.By;
import org.testng.Assert;

public class CalculationsDialog extends Dialog
{
	private ReportPage parentPage;

	private final By title = dialogAppBarTitle("Calculations");
	private final By SaveBtn = dialogAppBarTextBtn("Save");
	private By codeMirror = By.xpath("//div[contains(@class,'CodeMirror cm-s-default')]");
	private final By NameInput = By.xpath("//div[contains(@class, 'dropdown__content')]//label[contains(@class, control-label) and contains(text(), 'Name')]/following-sibling::div[contains(@class, 'text-field__input-container')]/input");

	public CalculationsDialog(SeleniumDriverWrapper driver, ReportPage pageObj)
	{
		super(driver);
		parentPage = pageObj;
	}

	@Override
	public boolean validateElements()
	{
		return driver.waitUntilClickable(SaveBtn, 5)
				  && driver.waitUntilExist(title)
				  && driver.waitUntilExist(NameInput);
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

	public CalculationsDialog enterNameInput(String text)
	{
		Assert.assertTrue(driver.type(NameInput, text));
		return this;
	}


}
