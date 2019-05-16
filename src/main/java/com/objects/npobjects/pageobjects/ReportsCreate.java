package com.objects.npobjects.pageobjects;

import com.objects.npobjects.NPPageObject;
import com.objects.npobjects.pageelements.dialogs.*;
import com.objects.npobjects.pageelements.dropdown.ChooseObjectDropDown;
import com.objects.npobjects.pageelements.dropdown.ReportDropDown;

import com.service.ui.web.SeleniumDriverWrapper;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class ReportsCreate extends NPPageObject
{

	public ChooseObjectDropDown chooseObjectDropDown;
	public HTTPSwebAddressDialog hTTPSwebAddressDialog;
	public SaveAsDialog saveAsDialog;
	public ChooseaChartTypeDialog chooseaChartTypeDialog;
	public SelectaDataSourceDialog selectaDataSourceDialog;
	public SettingsChartDialog settingsChartDialog;
	public ReportDropDown reportDropDown;
	public CalculationsAddDialog сalculationsAddDialog;
	public CalculationsDialog calculationsDialog;
	public SettingsReportDialog settingsReportDialog;

	private final By closeBtn = mdcIconFontBtn("ic_close");
	private By moreBtn = By.xpath("//div[@class='mdc-top-app-bar__row']//span[contains(@class, 'ic_more_vert')]");
	private By settingsBtn = mdcIconFontBtn("ic_tune");
	private By insertBtn = By.xpath("//span[contains(@class, 'mdc-fab__label') and contains(text(), 'Insert')]/parent::button[contains(@class, 'mdc-fab')]");
	private By panelcontent = By.xpath("//div[@class='panelcontent']");
	private By wait = By.xpath("//div[@class='dropdown__frame']");
	private By editBtn = mdcTextBtn("Edit");

	public ReportsCreate(SeleniumDriverWrapper driver)
	{
		super(driver.getBaseUrl() + "/reports/new", driver);
		chooseObjectDropDown = new ChooseObjectDropDown(driver, this);
		hTTPSwebAddressDialog = new HTTPSwebAddressDialog(driver, this);
		saveAsDialog = new SaveAsDialog(driver, this);
		chooseaChartTypeDialog = new ChooseaChartTypeDialog(driver, this);
		selectaDataSourceDialog = new SelectaDataSourceDialog(driver, this);
		settingsChartDialog = new SettingsChartDialog(driver, this);
		reportDropDown = new ReportDropDown(driver, this);
		сalculationsAddDialog = new CalculationsAddDialog(driver, this);
		calculationsDialog = new CalculationsDialog(driver, this);
		settingsReportDialog = new SettingsReportDialog(driver, this);
	}

	@Override
	public boolean validateElements()
	{
		return driver.waitUntilClickable(settingsBtn, 10)
				  && driver.waitUntilExist(moreBtn);
	}

	public ReportsCreate checkIsRendered()
	{
		super.checkIsRendered();
		return this;
	}

	public ReportsCreate clickSettingsBtn()
	{
		Assert.assertTrue(driver.click(settingsBtn));
		return this;
	}

	public ReportsCreate clickMoreBtn()
	{
		Assert.assertTrue(driver.click(moreBtn));
		return this;
	}

	public ReportsCreate clickCloseBtn()
	{
		Assert.assertTrue(driver.click(closeBtn));
		return this;
	}

	public ReportsCreate clickInsertBtn()
	{
		Assert.assertTrue(driver.click(insertBtn));
		return this;
	}
	public ReportsCreate clickEditBtn()
	{
		Assert.assertTrue(driver.click(editBtn));
		return this;
	}
}
