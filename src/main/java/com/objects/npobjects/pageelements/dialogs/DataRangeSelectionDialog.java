package com.objects.npobjects.pageelements.dialogs;

import com.objects.npobjects.pageobjects.ReportPage;
import com.service.ui.web.SeleniumDriverWrapper;
import junit.framework.Assert;
import org.openqa.selenium.By;

public class DataRangeSelectionDialog extends Dialog
{
	private ReportPage parentPage;

	private final By title = nodeMdcAppBarTitle("Selection");
	private final By nInput = nodeNpTextFieldWithLabel("N");
	private final By doneBtn = nodeMdcAppBarTextBtn("Done");


	public DataRangeSelectionDialog(SeleniumDriverWrapper driver, ReportPage pageObj)
	{
		super(driver);
		parentPage = pageObj;
	}

	@Override
	public boolean validateElements()
	{
		return driver.waitUntilExist(title, 5)
				  && driver.waitUntilClickable(doneBtn);
	}

	public DataRangeSelectionDialog checkIsRendered()
	{
		super.checkIsRendered();
		return this;
	}

	public DataRangeSelectionDialog clickFilterInNodeByName(String text)
	{
		Assert.assertTrue(driver.waitUntilClickable(By.xpath("//div[contains(@class, 'settings-node')]//span[contains(@class, 'mdc-list-item__text') and contains(text(), '" + text + "')]/parent::li")));
		Assert.assertTrue(driver.click(By.xpath("//div[contains(@class, 'settings-node')]//span[contains(@class, 'mdc-list-item__text') and contains(text(), '" + text + "')]/parent::li")));
		return this;
	}

	public DataRangeSelectionDialog enterNInput(String text)
	{
		Assert.assertTrue(driver.type(nInput, text));
		return this;
	}

	public DataRangeSelectionDialog clickDoneBtn()
	{
		Assert.assertTrue(driver.click(doneBtn));
		return this;
	}

}
