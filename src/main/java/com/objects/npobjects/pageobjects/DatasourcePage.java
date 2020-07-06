package com.objects.npobjects.pageobjects;

import com.objects.npobjects.NPPageObject;
import com.objects.npobjects.pageelements.dialogs.SettingsDataSourcesDialog;
import com.objects.npobjects.pageelements.dialogs.FieldSettingsDialog;
import com.objects.npobjects.pageelements.dialogs.DistinctCountSettingsDialog;
import com.objects.npobjects.pageelements.dialogs.CalculationFieldDialog;
import com.service.ui.web.SeleniumDriverWrapper;
import org.openqa.selenium.By;
import org.testng.Assert;

public class DatasourcePage extends NPPageObject
{

	public SettingsDataSourcesDialog settingsDataSourcesDialog;
	public FieldSettingsDialog fieldSettingsDialog;
	public DistinctCountSettingsDialog distinctCountSettingsDialog;
	public CalculationFieldDialog calculationFieldDialog;

	private By saveBtn = mdcIconFontBtn("ic_save");
	private By moreBtn = By.xpath("//div[@class='mdc-top-app-bar__row']//span[contains(@class, 'ic_more_vert')]");
	private By tuneBtn = mdcIconFontBtn("ic_tune");
	private By settingsBtn = mdcIconFontBtn("ic_settings");
	private By agViewport = By.cssSelector(".ag-body-viewport");
	private By queryBtn = mdcTextBtn("Run Query");
	private By codeMirror = By.xpath("//div[contains(@class,'CodeMirror cm-s-default')]");
	private By backBtn = mdcIconFontBtn("ic_arrow_back");
	private By editTextBtn = mdcIconFontBtn("ic_edit");
	private By chooseAfile = By.xpath("//div[contains(@class, 'mdc-button') and contains(text(), 'Choose a file...')]");
	private By calculationBtn = mdcIconFontBtn("ic_calculation");


	public DatasourcePage(SeleniumDriverWrapper driver)
	{
		super(driver.getBaseUrl() + "/datasources/new", driver);
		settingsDataSourcesDialog = new SettingsDataSourcesDialog(driver, this);
		fieldSettingsDialog = new FieldSettingsDialog(driver, this);
		distinctCountSettingsDialog = new DistinctCountSettingsDialog(driver, this);
		calculationFieldDialog = new CalculationFieldDialog(driver, this);
	}

	@Override
	public boolean validateElements()
	{
		return
//				driver.waitUntilClickable(agViewport, 10)
//				  &&
				  driver.waitUntilClickable(tuneBtn, 10);
	}

	public DatasourcePage checkIsRendered()
	{
		super.checkIsRendered();
		return this;
	}

	public DatasourcePage clickSave()
	{
		Assert.assertTrue(driver.click(saveBtn));
		return this;
	}

	public DatasourcePage clickTuneBtn()
	{
		Assert.assertTrue(driver.click(tuneBtn));
		return this;
	}

	public DatasourcePage clickMoreBtn()
	{
		Assert.assertTrue(driver.click(moreBtn));
		return this;
	}

	public DatasourcePage clickCodeMirror()
	{
		Assert.assertTrue(driver.click(codeMirror));
		return this;
	}

	public DatasourcePage clickQueryBtn()
	{
		Assert.assertTrue(driver.click(queryBtn));
		return this;
	}

	public DatasourcePage clickbackBtn()
	{
		Assert.assertTrue(driver.click(backBtn));
		return this;
	}

	public DatasourcePage clickAgViewport()
	{
		Assert.assertTrue(driver.waitUntilClickable(agViewport, 20));
		return this;
	}

	public DatasourcePage existSettingsBtn()
	{
		Assert.assertTrue(driver.waitUntilExist(settingsBtn, 10));
		Assert.assertTrue(driver.waitUntilClickable(settingsBtn, 10));
		return this;
	}

	public DatasourcePage existChooseAfile()
	{
		Assert.assertTrue(driver.waitUntilExist(chooseAfile, 10));
		Assert.assertTrue(driver.waitUntilClickable(chooseAfile, 10));
		return this;
	}

	public DatasourcePage clickCalculationBtn()
	{
		Assert.assertTrue(driver.click(calculationBtn));
		return this;
	}
}
