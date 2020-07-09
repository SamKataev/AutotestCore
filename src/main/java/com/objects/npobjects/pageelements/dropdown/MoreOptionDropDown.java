package com.objects.npobjects.pageelements.dropdown;

import com.objects.npobjects.pageobjects.NavigatorPage;
import com.service.ui.web.SeleniumDriverWrapper;
import junit.framework.Assert;
import org.openqa.selenium.By;

/**
 * Created by Kate on 03-Apr-19.
 */
public class MoreOptionDropDown extends DropDown
{

	private NavigatorPage parentPage;

	private final By shareIcon = dropDownListItemWithTextIcon("Share", "ic_person_add");
	private final By linkIcon = dropDownListItemWithTextIcon("Get shareable link...", "ic_link");
	private final By slackIcon = dropDownListItemWithTextIcon("Share to Slack", "ic_slack");
	private final By pdfIcon = dropDownListItemWithTextIcon("Download as PDF", "ic_download");
	private final By deliveryIcon = dropDownListItemWithTextIcon("Create delivery", "ic_download");
	private final By accessBtn = dropDownListItemWithText("Who has access");
	private final By duplicateBtn = dropDownListItemWithText("Duplicate");
	private final By renameBtn = dropDownListItemWithText("Rename");
	private final By detailsBtn = dropDownListItemWithText("View details");
	private final By removeBtn = dropDownListItemWithText("Remove");
	private final By saveIcon = dropDownListItemWithTextIcon("Save", "ic_save");
	private final By permissionsIcon = dropDownListItemWithText("Who has access");
	private final By refreshIcon = dropDownListItemWithTextIcon("Refresh", "ic_refresh");


	public MoreOptionDropDown(SeleniumDriverWrapper driver, NavigatorPage pageObj)
	{
		super(driver);
		parentPage = pageObj;
	}

	@Override
	public boolean validateElements()
	{
		return driver.waitUntilClickable(renameBtn, 5);
//                && driver.waitUntilClickable(linkIcon)
//                && driver.waitUntilClickable(slackIcon)
//                && driver.waitUntilClickable(linkIcon)
//                && driver.waitUntilClickable(pdfIcon)
//                && driver.waitUntilClickable(deliveryIcon)
//                && driver.waitUntilClickable(accessBtn)
//                && driver.waitUntilClickable(duplicateBtn)
//                && driver.waitUntilClickable(renameBtn)
//                && driver.waitUntilClickable(detailsBtn)
//                && driver.waitUntilClickable(removeBtn);

	}

	public MoreOptionDropDown checkIsRendered()
	{
		super.checkIsRendered();
		return this;
	}

	public MoreOptionDropDown clickRenameBtn()
	{
		Assert.assertTrue(driver.click(renameBtn));
		return this;
	}

	public MoreOptionDropDown ClickDetailsBtn()
	{
		Assert.assertTrue(driver.click(detailsBtn));
		return this;
	}

	public MoreOptionDropDown ClickPdfIcon()
	{
		Assert.assertTrue(driver.click(pdfIcon));
		return this;
	}

	public MoreOptionDropDown clickLinkIcon()
	{
		Assert.assertTrue(driver.click(linkIcon));
		return this;
	}

	public MoreOptionDropDown clickSaveIcon()
	{
		Assert.assertTrue(driver.waitUntilClickable(saveIcon));
		Assert.assertTrue(driver.click(saveIcon));
		return this;
	}

	public MoreOptionDropDown clickPermissionsIcon()
	{
		Assert.assertTrue(driver.click(permissionsIcon));
		return this;
	}

	public MoreOptionDropDown clickRefreshIcon()
	{
		Assert.assertTrue(driver.click(refreshIcon));
		return this;
	}

	public MoreOptionDropDown clickRemoveBtn()
	{
		Assert.assertTrue(driver.click(removeBtn));
		return this;
	}

}
