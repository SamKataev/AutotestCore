package com.objects.npobjects.pageelements.dialogs;

import com.objects.npobjects.pageobjects.DataSourcePage;
import com.service.ui.web.SeleniumDriverWrapper;
import junit.framework.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DistinctCountSettingsDialog extends Dialog
{
	private DataSourcePage parentPage;

	private Select selectNumberFormat;

	private final By measureNameInput = dialogTextFieldWithLabel("Distinct-count measure name");
	private final By numberFormatSelect = By.xpath("(//option[contains(text(), 'Same as source data')]//parent::select[@class='select__native-control'])[2]");
	private final By title = dialogAppBarTitle("Distinct-count settings");
	private final By closeBtn = iconFontBtn("ic_close");


	public DistinctCountSettingsDialog(SeleniumDriverWrapper driver, DataSourcePage pageObj)
	{
		super(driver);
		parentPage = pageObj;
	}

	@Override
	public boolean validateElements()
	{
		return driver.waitUntilExist(title, 5);

	}

	public DistinctCountSettingsDialog checkIsRendered()
	{
		super.checkIsRendered();
		return this;
	}

	public Select selectNumberFormat()
	{
		WebElement selectElem = driver.getElement(numberFormatSelect);
		Select selectNumberFormat = new Select(selectElem);
		return selectNumberFormat;
	}

	public DistinctCountSettingsDialog enterMeasureName(String text)
	{
		Assert.assertTrue(driver.type(measureNameInput, text));
		return this;
	}

	public DistinctCountSettingsDialog clickCloseBtn()
	{
		Assert.assertTrue(driver.click(closeBtn));
		return this;
	}
}
