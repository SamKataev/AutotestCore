package com.objects.npobjects.pageelements.dropdown;

import com.objects.PageObject;
import com.objects.npobjects.pageobjects.NavigatorPage;
import com.service.ui.web.SeleniumDriverWrapper;
import junit.framework.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SelectFileTypeDropDown extends DropDown
{

	private PageObject parentPage;

	private final By uploadFileBtn = dropDownListItemWithTextIcon("Your Computer", "ic_computer");
	private final By fileByUrlBtn = dropDownListItemWithTextIcon("by URL", "ic_link");
	private final By googleDriveBtn = dropDownListItemWithTextIcon("Google Drive", "ic_google_drive");

	public SelectFileTypeDropDown(SeleniumDriverWrapper driver, PageObject pageObj)
	{
		super(driver);
		parentPage = pageObj;
	}

	@Override
	public boolean validateElements()
	{
		return driver.waitUntilExist(root, 5)
				  && driver.waitUntilClickable(uploadFileBtn)
				  && driver.waitUntilClickable(fileByUrlBtn);
	}

	public SelectFileTypeDropDown checkIsRendered()
	{
		super.checkIsRendered();
		return this;
	}

	public SelectFileTypeDropDown clickUploadFile()
	{
		Assert.assertTrue(driver.click(uploadFileBtn));
		return this;
	}

	public SelectFileTypeDropDown clickFileByUrl()
	{
		Assert.assertTrue(driver.click(fileByUrlBtn));
		return this;
	}

	public SelectFileTypeDropDown clickGoogleDriveBtn()
	{
		Assert.assertTrue(driver.click(googleDriveBtn));
		return this;
	}

	public SelectFileTypeDropDown clickIntegration(String text)
	{
		Assert.assertTrue(driver.click(By.xpath("//div[contains(@class, 'mdc-dialog--open')]//span[contains(@class, 'mdc-list-item__primary-text') and text() = '" + text + "']")));
		return this;
	}

	public SelectFileTypeDropDown uploadFile(String text)
	{
		WebElement fileInput = driver.getElement(By.xpath("//input[@class='file-input']"));
		fileInput.sendKeys(text);
		return this;
	}
}