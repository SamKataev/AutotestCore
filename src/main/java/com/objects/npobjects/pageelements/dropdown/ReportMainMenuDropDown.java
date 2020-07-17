package com.objects.npobjects.pageelements.dropdown;

import com.objects.npobjects.pageobjects.NavigatorPage;
import com.objects.npobjects.pageobjects.ReportPage;
import com.service.ui.web.SeleniumDriverWrapper;
import junit.framework.Assert;
import org.openqa.selenium.By;

public class ReportMainMenuDropDown extends DropDown
{

	private ReportPage parentPage;

	private final By saveBtn = dropDownListItemWithTextIcon("Save", "ic_save");
	private final By saveAsBtn = dropDownListItemWithText("Save as...");
	private final By renameBtn = dropDownListItemWithText("Rename");
	private final By shareBtn = dropDownListItemWithTextIcon("Share", "ic_share");
	private final By linkBtn = dropDownListItemWithTextIcon("Get Shareable Link...", "ic_link");
	private final By slackBtn = dropDownListItemWithTextIcon("Share to Slack", "ic_slack");
	private final By pdfBtn = dropDownListItemWithTextIcon("Download as PDF", "ic_download");
	private final By deliveryBtn = dropDownListItemWithText("Schedule Delivery");

	public ReportMainMenuDropDown(SeleniumDriverWrapper driver, ReportPage pageObj)
	{
		super(driver);
		parentPage = pageObj;
	}

	@Override
	public boolean validateElements()
	{
		return driver.waitUntilClickable(saveBtn, 5)
                && driver.waitUntilClickable(saveAsBtn)
                && driver.waitUntilClickable(renameBtn);
	}

	public ReportMainMenuDropDown checkIsRendered()
	{
		super.checkIsRendered();
		return this;
	}

	public ReportMainMenuDropDown clickSave()
	{
		Assert.assertTrue(driver.click(saveBtn));
		return this;
	}

	public ReportMainMenuDropDown clickSaveAs()
	{
		Assert.assertTrue(driver.click(saveAsBtn));
		return this;
	}

	public ReportMainMenuDropDown clickRename()
	{
		Assert.assertTrue(driver.click(renameBtn));
		return this;
	}
}
