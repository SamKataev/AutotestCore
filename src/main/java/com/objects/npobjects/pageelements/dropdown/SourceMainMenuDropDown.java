package com.objects.npobjects.pageelements.dropdown;

import com.objects.npobjects.pageobjects.DataSourcePage;
import com.service.ui.web.SeleniumDriverWrapper;
import org.openqa.selenium.By;
import org.testng.Assert;

public class SourceMainMenuDropDown extends DropDown
{

	private DataSourcePage parentPage;

	private final By saveBtn = dropDownListItemWithTextIcon("Save", "ic_save");
	private final By saveAsBtn = dropDownListItemWithText("Save as...");
	private final By renameBtn = dropDownListItemWithText("Rename");

	public SourceMainMenuDropDown(SeleniumDriverWrapper driver, DataSourcePage pageObj)
	{
		super(driver);
		parentPage = pageObj;
	}

	@Override
	public boolean validateElements()
	{
		return driver.waitUntilExist(root, 5)
				  && driver.waitUntilClickable(saveBtn)
				  && driver.waitUntilClickable(renameBtn);
	}

	public SourceMainMenuDropDown checkIsRendered()
	{
		super.checkIsRendered();
		return this;
	}

	public DataSourcePage clickSave()
	{
		Assert.assertTrue(driver.click(saveBtn));
		return this.parentPage;
	}
}