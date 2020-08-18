package com.objects.npobjects.pageelements.dropdown;

import com.objects.npobjects.pageobjects.ReportPage;
import com.service.ui.web.SeleniumDriverWrapper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CreateBlockDropDown extends DropDown
{
	private ReportPage parentPage;

	private final By ImageIcon = dropDownListItemWithTextIcon("Image", "ic_image");
	private final By embedIcon = dropDownListItemWithTextIcon("URL Embed", "ic_code");
	private final By textIcon = dropDownListItemWithTextIcon("Text", "ic_text");
	private final By chartTemplateIcon = dropDownListItemWithTextIcon("Chart Template", "ic_chart_template");
	private final By chartIcon = dropDownListItemWithTextIcon("Chart", "ic_chart");


	public CreateBlockDropDown(SeleniumDriverWrapper driver, ReportPage pageObj)
	{
		super(driver);
		parentPage = pageObj;
	}

	@Override
	public boolean validateElements()
	{
		return driver.waitUntilClickable(ImageIcon, 5)
				  && driver.waitUntilClickable(embedIcon)
				  && driver.waitUntilClickable(textIcon)
				  && driver.waitUntilExist(chartTemplateIcon)
				  && driver.waitUntilExist(chartIcon, 5);
	}

	public CreateBlockDropDown checkIsRendered()
	{
		super.checkIsRendered();
		return this;
	}

	public ReportPage clickChart()
	{
		driver.click(dropDownListItemWithText("Chart"));
		return parentPage;
	}

	public ReportPage clickChartTemplate()
	{
		driver.click(dropDownListItemWithText("Chart Template"));
		return parentPage;
	}

	public ReportPage clickText()
	{
		driver.click(dropDownListItemWithText("Text"));
		return parentPage;
	}

	public ReportPage clickURLEmbed()
	{
		driver.click(dropDownListItemWithText("URL Embed"));
		return parentPage;
	}

	public ReportPage clickImage()
	{
		driver.click(dropDownListItemWithText("Image"));
		return parentPage;
	}

	public ReportPage uploadFile(String text)
	{
		WebElement fileInput = driver.getElement(By.xpath("//input[@class='file-input']"));
		fileInput.sendKeys(text);
		return parentPage;
	}
}
