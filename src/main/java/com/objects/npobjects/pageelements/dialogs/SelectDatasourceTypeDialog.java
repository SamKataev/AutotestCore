package com.objects.npobjects.pageelements.dialogs;

import com.objects.npobjects.pageobjects.NavigatorPage;
import com.service.ui.web.SeleniumDriverWrapper;
import junit.framework.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SelectDatasourceTypeDialog extends Dialog
{

	private NavigatorPage parentPage;

	private final By title = dialogAppBarTitle("Select type");
	private final By uploadFileBtn = dialogListItemWithTextIcon("Upload a File", "ic_upload");
	private final By fileByUrlBtn = dialogListItemWithTextIcon("File by URL", "ic_link");
	private final By closeBtn = dialogIconFontBtn("ic_close");

	public SelectDatasourceTypeDialog(SeleniumDriverWrapper driver, NavigatorPage pageObj)
	{
		super(driver);
		parentPage = pageObj;
	}

	@Override
	public boolean validateElements()
	{
		return driver.waitUntilExist(title, 5)
				  && driver.waitUntilClickable(closeBtn)
				  && driver.waitUntilClickable(uploadFileBtn)
				  && driver.waitUntilClickable(fileByUrlBtn);
	}

	public SelectDatasourceTypeDialog checkIsRendered()
	{
		super.checkIsRendered();
		return this;
	}

	public SelectDatasourceTypeDialog clickUploadFile()
	{
		Assert.assertTrue(driver.click(uploadFileBtn));
		return this;
	}

	public SelectDatasourceTypeDialog clickFileByUrl()
	{
		Assert.assertTrue(driver.click(fileByUrlBtn));
		return this;
	}

	public SelectDatasourceTypeDialog clickIntegration(String text)
	{
		Assert.assertTrue(driver.click(By.xpath("//div[contains(@class, 'mdc-dialog--open')]//span[contains(@class, 'mdc-list-item__primary-text') and contains(text(), '" + text + "')]")));
		return this;
	}

	public SelectDatasourceTypeDialog uploadFile(String text)
	{
		WebElement fileInput = driver.getElement(By.xpath("//input[@class='file-input']"));
		fileInput.sendKeys(text);
		return this;
	}
}