package com.objects.npobjects.pageobjects;

import com.objects.npobjects.NPPageObject;
import com.objects.npobjects.pageelements.dialogs.*;
import com.objects.npobjects.pageelements.dropdown.ChooseObjectDropDown;
import com.objects.npobjects.pageelements.dropdown.ReportDropDown;

import com.service.ui.web.SeleniumDriverWrapper;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.sql.Time;

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
	public ReportFiltersDialog reportFiltersDialog;
	public DataRangeSelectionDialog dataRangeSelectionDialog;

	private final By closeBtn = mdcIconFontBtn("ic_close");
	private By moreBtn = By.xpath("//div[@class='mdc-top-app-bar__row']//span[contains(@class, 'ic_more_vert')]");
	private By settingsBtn = mdcIconFontBtn("ic_tune");
	private By insertBtn = By.xpath("//span[contains(@class, 'mdc-fab__label') and contains(text(), 'Insert')]/parent::button[contains(@class, 'mdc-fab')]");
	private By panelcontent = By.xpath("//div[@class='panelcontent']");
	private By wait = By.xpath("//div[@class='dropdown__frame']");
	private By editBtn = mdcTextBtn("Edit");
	private By filterBtn = mdcIconFontBtn("ic_filter");
	private By shareBtn = mdcIconFontBtn("ic_person_add");
	private final By refreshBtn = mdcIconFontBtn("ic_refresh");
	private By editTextBtn = mdcIconFontBtn("ic_edit");
	private By sheetBtn = mdcTabWithText ("+");


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
		reportFiltersDialog = new ReportFiltersDialog(driver, this);
		dataRangeSelectionDialog = new DataRangeSelectionDialog(driver, this);
	}

	@Override
	public boolean validateElements()
	{
		return driver.waitUntilExist(moreBtn)
				  && driver.waitUntilExist(settingsBtn, 10);
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

	public ReportsCreate checkEditBtn()
	{
		Assert.assertTrue(driver.waitUntilExist(editBtn));
		return this;
	}

	public ReportsCreate checkAbsenceEditBtn()
	{
		Assert.assertTrue(driver.waitUntilExist(By.xpath("//button[contains(@class, 'mdc-button--black hide') and contains(text(), 'Edit')]")));
		return this;
	}

	public ReportsCreate clickChartByName(String text)
	{
		Assert.assertTrue(driver.waitUntilClickable(By.xpath("//div[contains(@class,'lbl-cnt') and contains(text(),'" + text + "')]/ancestor::div[contains(@class,'blockcontainer')]")));
		Assert.assertTrue(driver.click(By.xpath("//div[contains(@class,'lbl-cnt') and contains(text(),'" + text + "')]/ancestor::div[contains(@class,'blockcontainer')]")));
		return this;
	}

	public ReportsCreate clickFilterBtn()
	{
		Assert.assertTrue(driver.click(filterBtn));
		return this;
	}

	public ReportsCreate checkChartNoDate()
	{
		Assert.assertFalse(driver.waitUntilExist(By.xpath("//div[contains(@class,'blockcontainer')]/following::div[contains(@class,'nodata_node') and contains(text(),'No data')]"), 5));
		return this;
	}

	public ReportsCreate checkChartNoNaN()
	{
		Assert.assertFalse(driver.waitUntilExist(By.xpath("//div[contains(@title,'NaN')]"), 5));
		return this;
	}

	public ReportsCreate contextClick(String text, int time)
	{
		Assert.assertFalse(driver.contextClick(By.xpath("//div[contains(@class,'lbl-cnt') and contains(text(),'" + text + "')]/ancestor::div[contains(@class,'blockcontainer')]"), 10));
		return this;
	}

	public ReportsCreate clickRefreshBtn()
	{
		Assert.assertTrue(driver.click(refreshBtn));
		return this;
	}

	public ReportsCreate clickShareBtn()
	{
		Assert.assertTrue(driver.click(shareBtn));
		return this;
	}

	public ReportsCreate clickEditTextBtn()
	{
		Assert.assertTrue(driver.click(editTextBtn));
		return this;
	}

	public ReportsCreate clickSheetBtn()
	{
		Assert.assertTrue(driver.click(sheetBtn));
		return this;
	}

	public ReportsCreate contextClickSheet(String text, int time)
	{
		Assert.assertFalse(driver.contextClick(By.xpath("//span[contains(@class,'mdc-tab__text-label') and contains(text(), '" + text + "')]/ancestor::button[contains(@class, 'mdc-tab')]"),10));
		return this;
	}

	public ReportsCreate checkActiveSheet (String text, String buttonClass, int time)
	{
		Assert.assertFalse(driver.waitUntilClickable(By.xpath("//span[contains(@class,'mdc-tab__text-label') and contains(text(), '" + text + "')]/ancestor::button[contains(@class, 'mdc-tab') and contains(@class, '" + buttonClass + "')]"),5));
		return this;
	}

}
