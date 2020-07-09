package com.objects.npobjects.pageobjects;

import com.objects.npobjects.NPPageObject;
import com.objects.npobjects.pageelements.dialogs.SettingsDataSourcesDialog;
import com.objects.npobjects.pageelements.dialogs.FieldSettingsDialog;
import com.objects.npobjects.pageelements.dialogs.DistinctCountSettingsDialog;
import com.objects.npobjects.pageelements.dialogs.CalculationFieldDialog;
import com.objects.npobjects.pageelements.dropdown.DropDown;
import com.objects.npobjects.pageelements.dropdown.SourceMainMenuDropDown;
import com.service.ui.web.SeleniumDriverWrapper;
import org.openqa.selenium.By;
import org.testng.Assert;

public class DataSourcePage extends NPPageObject
{
	public SourceMainMenuDropDown mainMenu;

	public FieldSettingsDialog fieldSettingsDialog;
	public DistinctCountSettingsDialog distinctCountSettingsDialog;
	public CalculationFieldDialog calculationFieldDialog;

	private By closeBtn = By.xpath("//div[contains(@class, 'new-schemabox__left-node')]//span[@class='ic_close']/parent::span");
	private By menuBtn = By.xpath("//div[@class='mdc-top-app-bar__row']//span[contains(@class, 'ic_menu_')]");
	private By settingsBtn = iconFontBtn("ic_tune");
	private By uploadAFileBtn = textBtn("Upload a File");
	private By optionsBtn = textBtn("Options");
	private By queryBtn = unelevatedBtn("Run Query");
	private By previewPanel = By.cssSelector(".import-preview-panel");
	private By codeMirror = By.xpath("//div[contains(@class,'CodeMirror cm-s-default')]");
	private By calculationBtn = iconFontBtn("ic_calculation");


	public DataSourcePage(SeleniumDriverWrapper driver)
	{
		super(driver.getBaseUrl() + "/datasources/new", driver);

		mainMenu = new SourceMainMenuDropDown(driver, this);

		fieldSettingsDialog = new FieldSettingsDialog(driver, this);
		distinctCountSettingsDialog = new DistinctCountSettingsDialog(driver, this);
		calculationFieldDialog = new CalculationFieldDialog(driver, this);
	}

	@Override
	public boolean validateElements()
	{
		return
			driver.waitUntilClickable(previewPanel, 10)
					  && driver.waitUntilClickable(closeBtn)
					  && driver.waitUntilClickable(menuBtn)
					  && driver.waitUntilClickable(uploadAFileBtn)
					  && driver.waitUntilClickable(optionsBtn)
					  && driver.waitUntilClickable(settingsBtn);
	}

	public DataSourcePage checkIsRendered()
	{
		processWaiter(10);
		super.checkIsRendered();
		return this;
	}

	public DataSourcePage clickSettingsBtn()
	{
		Assert.assertTrue(driver.click(settingsBtn));
		return this;
	}

	public DataSourcePage clickMenuBtn()
	{
		Assert.assertTrue(driver.click(menuBtn));
		return this;
	}

	public DataSourcePage clickCodeMirror()
	{
		Assert.assertTrue(driver.click(codeMirror));
		return this;
	}

	public DataSourcePage clickQueryBtn()
	{
		Assert.assertTrue(driver.click(queryBtn));
		return this;
	}

	public DataSourcePage existSettingsBtn()
	{
		Assert.assertTrue(driver.waitUntilExist(settingsBtn, 10));
		Assert.assertTrue(driver.waitUntilClickable(settingsBtn, 10));
		return this;
	}

	public DataSourcePage clickCalculationBtn()
	{
		Assert.assertTrue(driver.click(calculationBtn));
		return this;
	}

	public void clickClose()
	{
		Assert.assertTrue(driver.click(closeBtn));
	}
}
