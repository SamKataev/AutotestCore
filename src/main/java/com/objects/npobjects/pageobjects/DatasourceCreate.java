package com.objects.npobjects.pageobjects;

import com.objects.npobjects.NPPageObject;
import com.objects.npobjects.pageelements.dialogs.SettingsDataSourcesDialog;
import com.objects.npobjects.pageelements.dialogs.FieldSettingsDialog;
import com.objects.npobjects.pageobjects.oauthpages.BoxLogIn;
import com.service.ui.web.SeleniumDriverWrapper;
import org.openqa.selenium.By;
import org.testng.Assert;

public class DatasourceCreate extends NPPageObject
{

	public SettingsDataSourcesDialog settingsDataSourcesDialog;
	public FieldSettingsDialog fieldSettingsDialog;

	private By saveBtn = mdcIconFontBtn("ic_save");
	private By moreBtn = By.xpath("//div[@class='mdc-top-app-bar__row']//span[contains(@class, 'ic_more_vert')]");
	private By settingsBtn = mdcIconFontBtn("ic_tune");
	private By agViewport = By.cssSelector(".ag-body-viewport");
	private By queryBtn = mdcTextBtn("Run Query");
	private By codeMirror = By.xpath("//div[contains(@class,'CodeMirror cm-s-default')]");
	private By backBtn = mdcIconFontBtn("ic_arrow_back");


	public DatasourceCreate(SeleniumDriverWrapper driver)
	{
		super(driver.getBaseUrl() + "/datasources/new", driver);
		settingsDataSourcesDialog = new SettingsDataSourcesDialog(driver, this);
		fieldSettingsDialog = new FieldSettingsDialog(driver,this);
	}

	@Override
	public boolean validateElements()
	{
		return
//				driver.waitUntilClickable(agViewport, 10)
//				  &&
				  driver.waitUntilClickable(settingsBtn, 10);
	}

	public DatasourceCreate checkIsRendered()
	{
		super.checkIsRendered();
		return this;
	}

	public DatasourceCreate clickSave()
	{
		Assert.assertTrue(driver.click(saveBtn));
		return this;
	}
	public DatasourceCreate clickSettingsBtn()
	{
		Assert.assertTrue(driver.click(settingsBtn));
		return this;
	}
	public DatasourceCreate clickMoreBtn()
	{
		Assert.assertTrue(driver.click(moreBtn));
		return this;
	}

	public DatasourceCreate clickCodeMirror()
	{
		Assert.assertTrue(driver.click(codeMirror));
		return this;
	}

	public DatasourceCreate clickQueryBtn()
	{
		Assert.assertTrue(driver.click(queryBtn));
		return this;
	}

	public DatasourceCreate clickbackBtn()
	{
		Assert.assertTrue(driver.click(backBtn));
		return this;
	}
	public DatasourceCreate clickAgViewport()
	{
		Assert.assertTrue(driver.waitUntilClickable(agViewport, 10));
		return this;
	}
}
