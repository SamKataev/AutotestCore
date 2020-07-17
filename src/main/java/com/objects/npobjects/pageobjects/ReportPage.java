package com.objects.npobjects.pageobjects;

import com.objects.npobjects.NPPageObject;
import com.objects.npobjects.pageelements.dialogs.*;
import com.objects.npobjects.pageelements.dropdown.ChooseObjectDropDown;
import com.objects.npobjects.pageelements.dropdown.ReportDropDown;

import com.objects.npobjects.pageelements.dropdown.ReportMainMenuDropDown;
import com.service.ui.web.SeleniumDriverWrapper;
import org.openqa.selenium.By;
import org.testng.Assert;

public class ReportPage extends NPPageObject
{

	public ChooseObjectDropDown chooseObjectDropDown;
	public ReportMainMenuDropDown mainMenuDropDown;

	public HTTPSwebAddressDialog hTTPSwebAddressDialog;
	public SaveAsDialog saveAsDialog;
	public ChooseaChartTypeDialog chooseaChartTypeDialog;
	public SettingsChartDialog settingsChartDialog;
	public ReportDropDown reportDropDown;
	public CalculationsAddDialog сalculationsAddDialog;
	public CalculationsDialog calculationsDialog;
	public SettingsReportDialog settingsReportDialog;
	public ReportFiltersDialog reportFiltersDialog;
	public DataRangeSelectionDialog dataRangeSelectionDialog;

	private final By closeBtn = iconFontBtn("ic_close");
	private By menuBtn = By.xpath("//div[@class='mdc-top-app-bar__row']//span[contains(@class, 'ic_menu_')]");
	private By settingsBtn = iconFontBtn("ic_tune");
	private By insertBtn = By.xpath("//span[contains(@class, 'mdc-fab__label') and contains(text(), 'Insert')]/parent::button[contains(@class, 'mdc-fab')]");
	private By panelcontent = By.xpath("//div[@class='panelcontent']");
	private By wait = By.xpath("//div[@class='dropdown__frame']");
	private By editBtn = unelevatedBtn("Edit");
	private By filterBtn = iconFontBtn("ic_filter");
	private By shareBtn = iconFontBtn("ic_person_add");
	private final By refreshBtn = iconFontBtn("ic_refresh");
	private By editTextBtn = iconFontBtn("ic_edit");
	private By sheetBtn = tabWithText("+");


	public ReportPage(SeleniumDriverWrapper driver)
	{
		super(driver.getBaseUrl() + "/reports/new", driver);

		chooseObjectDropDown = new ChooseObjectDropDown(driver, this);
		mainMenuDropDown = new ReportMainMenuDropDown(driver, this);

		hTTPSwebAddressDialog = new HTTPSwebAddressDialog(driver, this);
		saveAsDialog = new SaveAsDialog(driver, this);
		chooseaChartTypeDialog = new ChooseaChartTypeDialog(driver, this);
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
		return driver.waitUntilExist(menuBtn)
				  && driver.waitUntilExist(settingsBtn, 10);
	}

	public ReportPage checkIsRendered()
	{
		processWaiter(10);
		super.checkIsRendered();
		return this;
	}

	public ReportPage clickSettingsBtn()
	{
		Assert.assertTrue(driver.click(settingsBtn));
		return this;
	}

	public ReportPage clickMenuBtn()
	{
		Assert.assertTrue(driver.click(menuBtn));
		return this;
	}

	public ReportPage clickCloseBtn()
	{
		Assert.assertTrue(driver.click(closeBtn));
		return this;
	}

	public ReportPage clickInsertBtn()
	{
		Assert.assertTrue(driver.click(insertBtn));
		return this;
	}

	public ReportPage clickEditBtn()
	{
		Assert.assertTrue(driver.click(editBtn));
		return this;
	}

	public ReportPage checkEditBtn()
	{
		Assert.assertTrue(driver.waitUntilExist(editBtn));
		return this;
	}

	public ReportPage checkAbsenceEditBtn()
	{
		Assert.assertTrue(driver.waitUntilExist(By.xpath("//button[contains(@class, 'mdc-button--black hide') and contains(text(), 'Edit')]")));
		return this;
	}

	public ReportPage clickChartByName(String text)
	{
		Assert.assertTrue(driver.waitUntilClickable(By.xpath("//div[contains(@class,'lbl-cnt') and contains(text(),'" + text + "')]/ancestor::div[contains(@class,'blockcontainer')]")));
		Assert.assertTrue(driver.click(By.xpath("//div[contains(@class,'lbl-cnt') and contains(text(),'" + text + "')]/ancestor::div[contains(@class,'blockcontainer')]")));
		return this;
	}

	public ReportPage clickFilterBtn()
	{
		Assert.assertTrue(driver.click(filterBtn));
		return this;
	}

	public ReportPage checkChartNoDate()
	{
		Assert.assertFalse(driver.waitUntilExist(By.xpath("//div[contains(@class,'blockcontainer')]/following::div[contains(@class,'nodata_node') and contains(text(),'No data')]"), 5));
		return this;
	}

	public ReportPage checkChartNoNaN()
	{
		Assert.assertFalse(driver.waitUntilExist(By.xpath("//div[contains(@title,'NaN')]"), 5));
		return this;
	}

	public ReportPage contextClick(String text, int time)
	{
		Assert.assertFalse(driver.contextClick(By.xpath("//div[contains(@class,'lbl-cnt') and contains(text(),'" + text + "')]/ancestor::div[contains(@class,'blockcontainer')]"), 10));
		return this;
	}

	public ReportPage clickRefreshBtn()
	{
		Assert.assertTrue(driver.click(refreshBtn));
		return this;
	}

	public ReportPage clickShareBtn()
	{
		Assert.assertTrue(driver.click(shareBtn));
		return this;
	}

	public ReportPage clickEditTextBtn()
	{
		Assert.assertTrue(driver.click(editTextBtn));
		return this;
	}

	public ReportPage clickSheetBtn()
	{
		Assert.assertTrue(driver.click(sheetBtn));
		return this;
	}

	public ReportPage contextClickSheet(String text, int time)
	{
		Assert.assertFalse(driver.contextClick(By.xpath("//span[contains(@class,'mdc-tab__text-label') and contains(text(), '" + text + "')]/ancestor::button[contains(@class, 'mdc-tab')]"), 10));
		return this;
	}

	public ReportPage checkActiveSheet(String text, String buttonClass, int time)
	{
		Assert.assertFalse(driver.waitUntilClickable(By.xpath("//span[contains(@class,'mdc-tab__text-label') and contains(text(), '" + text + "')]/ancestor::button[contains(@class, 'mdc-tab') and contains(@class, '" + buttonClass + "')]"), 5));
		return this;
	}

}
