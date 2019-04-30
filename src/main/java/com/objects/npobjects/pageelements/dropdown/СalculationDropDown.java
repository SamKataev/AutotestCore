package com.objects.npobjects.pageelements.dropdown;


import com.objects.npobjects.pageobjects.ReportsCreate;
import com.service.ui.web.SeleniumDriverWrapper;
import org.openqa.selenium.By;
import org.testng.Assert;

public class СalculationDropDown extends DropDown
{
	private ReportsCreate parentPage;

	private final By sumBtn = dropDownMdcListItemWithText("Sum");
	private final By averageBtn = dropDownMdcListItemWithText("Average");

	public СalculationDropDown(SeleniumDriverWrapper driver, ReportsCreate pageObj)
	{
		super(driver);
		parentPage = pageObj;
	}

	@Override
	public boolean validateElements()
	{
		return driver.waitUntilClickable(sumBtn, 5)
				  && driver.waitUntilClickable(averageBtn);
	}

	public СalculationDropDown checkIsRendered()
	{
		super.checkIsRendered();
		return this;
	}

	public СalculationDropDown clickObjectByName(String text)
	{
		Assert.assertTrue(driver.click(By.xpath("//div[contains(@class, 'np-menu dropdown_vis')]//span[contains(@class, 'mdc-list-item__text') and contains(text(), '" + text + "')]/parent::li")));
		return this;
	}
}
