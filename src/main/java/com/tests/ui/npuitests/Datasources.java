package com.tests.ui.npuitests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Datasources extends NPWebTest
{

	@Test
	public void uploadFileByUrl()
	{
		mainPage.checkIsRendered()
				  .openDatasources()
				  .clickPlusBtn();
		mainPage.selectDatasourceTypeDialog.checkIsRendered()
				  .clickFileByUrl();
		mainPage.fileByUrlDialog.checkIsRendered()
				  .typeUrl("https://www.dropbox.com/s/733wh1uh4ukk7xt/For%20charts.csv?dl=1")
				  .clickOk();
		datasourceCreatePage.checkIsRendered()
				  .clickAgViewport()
				  .clickSave();
	}

	@Test
	public void uploadFile()
	{
		mainPage.checkIsRendered()
				  .openDatasources()
				  .clickPlusBtn();
		mainPage.selectDatasourceTypeDialog.checkIsRendered()
				  .uploadFile("C:\\Users\\User\\Downloads\\csv\\Testslemma.csv");
		datasourceCreatePage.checkIsRendered()
				  .clickAgViewport()
				  .clickSave();
		mainPage.checkObjectInDataTableByName("Testslemma", 5)
				  .clickObjectInDataTableByName("Testslemma", 5);
	}

	@Test
	public void datasetGoogleAnalytics()
	{
		mainPage.checkIsRendered()
				  .openDatasources()
				  .clickPlusBtn();
		mainPage.selectDatasourceTypeDialog.checkIsRendered()
				  .clickIntegration("Google Analytics");
		mainPage.selectDatasetDialog.checkIsRendered()
				  .checkDialogTitle("Select dataset", 10)
				  .clickBasedInDialogByName("Slemma/slemma.com - STAG/slemma.com", "ic_google_analytics", 10);
		driver.switchToMainWindow();
		mainPage.checkObjectInDataTableByName("Slemma/slemma.com - STAG/slemma.com - STAG - MASTER", 5)
				  .clickObjectInDataTableByName("Slemma/slemma.com - STAG/slemma.com - STAG - MASTER", 5);
	}

	@Test
	public void datasetZendesk()
	{
		mainPage.checkIsRendered()
				  .openDatasources()
				  .clickPlusBtn();
		mainPage.selectDatasourceTypeDialog.checkIsRendered()
				  .clickIntegration("Zendesk");
		mainPage.selectDatasetDialog.checkIsRendered()
				  .checkDialogTitle("Select dataset", 10)
				  .clickBasedInDialogByName("Users", "ic_zendesk", 20);
//        pause(5);
		mainPage.checkObjectInDataTableByName("Users", 15)
				  .clickObjectInDataTableByName("Users", 15);
	}

	@Test
	public void datasetMailChimp()
	{
		mainPage.checkIsRendered()
				  .openDatasources()
				  .clickPlusBtn();
		mainPage.selectDatasourceTypeDialog.checkIsRendered()
				  .clickIntegration("MailChimp");
		mainPage.selectDatasetDialog.checkIsRendered()
				  .checkDialogTitle("Select dataset", 10)
				  .clickBasedInDialogByName("Campaigns", "ic_mailchimp", 20);
//        pause(5);
		mainPage.checkObjectInDataTableByName("Campaigns", 15)
				  .clickObjectInDataTableByName("Campaigns", 15);
	}

	@Test
	public void datasetHubspot()
	{
		mainPage.checkIsRendered()
				  .openDatasources()
				  .clickPlusBtn();
		mainPage.selectDatasourceTypeDialog.checkIsRendered()
				  .clickIntegration("Hubspot");
		mainPage.selectDatasetDialog.checkIsRendered()
				  .checkDialogTitle("Select dataset", 10)
				  .clickBasedInDialogByName("Deals", "ic_hubspot", 20);
//        pause(5);
		mainPage.checkObjectInDataTableByName("Deals", 15)
				  .clickObjectInDataTableByName("Deals", 15);
	}

	@Test
	public void datasetDropbox()
	{
		mainPage.checkIsRendered()
				  .openDatasources()
				  .clickPlusBtn();
		mainPage.selectDatasourceTypeDialog.checkIsRendered()
				  .clickIntegration("Dropbox");
		mainPage.selectDatasetDialog.checkIsRendered()
				  .checkDialogTitle("Dropbox", 10);
		pause(5);
		mainPage.selectDatasetDialog.clickFileInDialogByName("Testslemma.xls", "ic_file", 20);
		datasourceCreatePage.checkIsRendered()
				  .clickSave();
		mainPage.checkObjectInDataTableByName("Testslemma", 15)
				  .clickObjectInDataTableByName("Testslemma", 15);
	}

	@Test
	public void datasetFreshSales()
	{
		mainPage.checkIsRendered()
				  .openDatasources()
				  .clickPlusBtn();
		mainPage.selectDatasourceTypeDialog.checkIsRendered()
				  .clickIntegration("FreshSales");
		mainPage.selectDatasetDialog.checkIsRendered()
				  .checkDialogTitle("Select dataset", 10)
				  .clickBasedInDialogByName("Deals", "ic_freshsales", 20);
		mainPage.checkObjectInDataTableByName("Deals", 15)
				  .clickObjectInDataTableByName("Deals", 15);
	}

	@Test
	public void datasetFreshDesk()
	{
		mainPage.checkIsRendered()
				  .openDatasources()
				  .clickPlusBtn();
		mainPage.selectDatasourceTypeDialog.checkIsRendered()
				  .clickIntegration("FreshDesk");
		mainPage.selectDatasetDialog.checkIsRendered()
				  .checkDialogTitle("Select dataset", 10)
				  .clickBasedInDialogByName("Tickets", "ic_freshdesk", 20);
		mainPage.checkObjectInDataTableByName("Tickets", 15)
				  .clickObjectInDataTableByName("Tickets", 15);
	}

	@Test
	public void datasetFacebook()
	{
		mainPage.checkIsRendered()
				  .openDatasources()
				  .clickPlusBtn();
		mainPage.selectDatasourceTypeDialog.checkIsRendered()
				  .clickIntegration("Facebook");
		mainPage.selectDatasetDialog.checkIsRendered()
				  .checkDialogTitle("Select dataset", 10)
				  .clickBasedInDialogByName("Posts Stats Lifetime", "ic_facebook", 20);
		mainPage.checkObjectInDataTableByName("Posts Stats Lifetime", 15)
				  .clickObjectInDataTableByName("Posts Stats Lifetime", 15);
	}

	@Test
	public void datasetFacebookAds()
	{
		mainPage.checkIsRendered()
				  .openDatasources()
				  .clickPlusBtn();
		mainPage.selectDatasourceTypeDialog.checkIsRendered()
				  .clickIntegration("Facebook Ads");
		mainPage.selectDatasetDialog.checkIsRendered()
				  .checkDialogTitle("Select dataset", 10)
				  .clickBasedInDialogByName("Ad Account Stats", "ic_facebook_ads", 20);
		mainPage.saaSParametersDialog.checkIsRendered()
				  .clickOkBtn();
		mainPage.checkObjectInDataTableByName("Ad Account Stats", 15)
				  .clickObjectInDataTableByName("Ad Account Stats", 15);
	}

	@Test
	public void datasetHerokuPostgreSQL()
	{
		mainPage.checkIsRendered()
				  .openDatasources()
				  .clickPlusBtn();
		mainPage.selectDatasourceTypeDialog.checkIsRendered()
				  .clickIntegration("Heroku PostgreSQL");
		datasourceCreatePage.checkIsRendered()
				  .clickCodeMirror();
		driver.keyboardImitate("SELECT * from calendar");
		pause(5);
		datasourceCreatePage.clickQueryBtn()
				  .clickAgViewport()
				  .clickMoreBtn();
		mainPage.moreOptionDropDown.checkIsRendered()
				  .clickSaveIcon();
		mainPage.renameDialog.checkIsRendered()
				  .enterInputName("HerokuQuery")
				  .clickRenameBtn();
		mainPage.checkObjectInDataTableByName("HerokuQuery", 15)
				  .clickObjectInDataTableByName("HerokuQuery", 15);
	}

	@Test
	public void datasetJira()
	{
		mainPage.checkIsRendered()
				  .openDatasources()
				  .clickPlusBtn();
		mainPage.selectDatasourceTypeDialog.checkIsRendered()
				  .clickIntegration("Jira");
		mainPage.selectDatasetDialog.checkIsRendered()
				  .checkDialogTitle("Select dataset", 10)
				  .clickBasedInDialogByName("Jira ticket statuses", "ic_jira", 20);
		mainPage.saaSParametersDialog.checkIsRendered()
				  .clickOkBtn();
		mainPage.checkObjectInDataTableByName("Jira ticket statuses", 20)
				  .clickObjectInDataTableByName("Jira ticket statuses", 20);
	}

	@Test
	public void datasetYandexDisk()
	{
		mainPage.checkIsRendered()
				  .openDatasources()
				  .clickPlusBtn();
		mainPage.selectDatasourceTypeDialog.checkIsRendered()
				  .clickIntegration("Yandex Disk");
		mainPage.selectDatasetDialog.checkIsRendered()
				  .checkDialogTitle("Yandex Disk", 10)
				  .clickFileInDialogByName("Testslemma.csv", "ic_file", 10);
		datasourceCreatePage.checkIsRendered()
				  .clickAgViewport()
				  .clickSave();
		mainPage.checkObjectInDataTableByName("Testslemma", 15)
				  .clickObjectInDataTableByName("Testslemma", 15);
	}

	@Test
	public void datasetOneDrive()
	{
		mainPage.checkIsRendered()
				  .openDatasources()
				  .clickPlusBtn();
		mainPage.selectDatasourceTypeDialog.checkIsRendered()
				  .clickIntegration("OneDrive");
		mainPage.selectDatasetDialog.checkIsRendered()
				  .checkDialogTitle("OneDrive", 10)
				  .clickFileInDialogByName("Testslemma.csv", "ic_file", 10);
		datasourceCreatePage.checkIsRendered()
				  .clickAgViewport()
				  .clickSave();
		mainPage.checkObjectInDataTableByName("Testslemma", 15)
				  .clickObjectInDataTableByName("Testslemma", 15);
	}

	@Test
	public void datasetBox()
	{
		mainPage.checkIsRendered()
				  .openDatasources()
				  .clickPlusBtn();
		mainPage.selectDatasourceTypeDialog.checkIsRendered()
				  .clickIntegration("Box");
		mainPage.selectDatasetDialog.checkIsRendered()
				  .checkDialogTitle("Box", 10)
				  .clickBasedInDialogByName("Testslemma.xls", "ic_file", 10);
		datasourceCreatePage.checkIsRendered()
				  .clickAgViewport()
				  .clickSave();
		mainPage.checkObjectInDataTableByName("Testslemma", 15)
				  .clickObjectInDataTableByName("Testslemma", 15);
	}

	@Test
	public void datasetGoogleDrive()
	{
		mainPage.checkIsRendered()
				  .openDatasources()
				  .clickPlusBtn();
		mainPage.selectDatasourceTypeDialog.checkIsRendered()
				  .clickIntegration("Google Drive");
		mainPage.selectDatasetDialog.checkIsRendered()
				  .checkDialogTitle("Google Drive", 10)
				  .clickFileInDialogByName("Test team number two.csv", "ic_file", 10);
		datasourceCreatePage.checkIsRendered()
				  .clickAgViewport()
				  .clickSave();
		mainPage.checkObjectInDataTableByName("Test team number two", 15)
				  .clickObjectInDataTableByName("Test team number two", 15);
	}

	@Test
	public void datasetPostgreSQLIntegrations()
	{
		mainPage.checkIsRendered()
				  .openDatasources()
				  .clickPlusBtn();
		mainPage.selectDatasourceTypeDialog.checkIsRendered()
				  .clickIntegration("PostgreSQL");
		datasourceCreatePage.checkIsRendered()
				  .clickCodeMirror();
		driver.keyboardImitate("SELECT * from action_log");
		datasourceCreatePage.clickQueryBtn()
				  .clickAgViewport()
				  .clickMoreBtn();
		mainPage.moreOptionDropDown.checkIsRendered()
				  .clickSaveIcon();
		mainPage.renameDialog.checkIsRendered()
				  .enterInputName("action_log")
				  .clickRenameBtn();
		mainPage.checkObjectInDataTableByName("action_log", 15)
				  .clickObjectInDataTableByName("action_log", 15);
	}

	@Test
	public void datasetQuickBooks()
	{
		mainPage.checkIsRendered()
				  .openDatasources()
				  .clickPlusBtn();
		mainPage.selectDatasourceTypeDialog.checkIsRendered()
				  .clickIntegration("QuickBooks");
		mainPage.selectDatasetDialog.checkIsRendered()
				  .checkDialogTitle("Select dataset", 10)
				  .clickBasedInDialogByName("Activities", "ic_quickbooks", 20);
		mainPage.checkObjectInDataTableByName("Activities", 15)
				  .clickObjectInDataTableByName("Activities", 15);
	}

	@Test
	public void datasetIntercom()
	{
		mainPage.checkIsRendered()
				  .openDatasources()
				  .clickPlusBtn();
		mainPage.selectDatasourceTypeDialog.checkIsRendered()
				  .clickIntegration("Intercom");
		mainPage.selectDatasetDialog.checkIsRendered()
				  .checkDialogTitle("Select dataset", 10)
				  .clickBasedInDialogByName("Leads", "ic_intercom", 20);
		mainPage.checkObjectInDataTableByName("Leads", 15)
				  .clickObjectInDataTableByName("Leads", 15);
	}

	@Test
	public void datasetPayPal()
	{
		mainPage.checkIsRendered()
				  .openDatasources()
				  .clickPlusBtn();
		mainPage.selectDatasourceTypeDialog.checkIsRendered()
				  .clickIntegration("PayPal");
		mainPage.selectDatasetDialog.checkIsRendered()
				  .checkDialogTitle("Select dataset", 10)
				  .clickBasedInDialogByName("Invoices", "ic_paypal", 20);
		mainPage.checkObjectInDataTableByName("Invoices", 15)
				  .clickObjectInDataTableByName("Invoices", 15);
	}

	@Test
	public void datasetPipedrive()
	{
		mainPage.checkIsRendered()
				  .openDatasources()
				  .clickPlusBtn();
		mainPage.selectDatasourceTypeDialog.checkIsRendered()
				  .clickIntegration("New People");
		mainPage.selectDatasetDialog.checkIsRendered()
				  .checkDialogTitle("Select dataset", 10)
				  .clickBasedInDialogByName("Deals", "ic_pipedrive", 20);
		mainPage.saaSParametersDialog.checkIsRendered()
				  .clickOkBtn();
		mainPage.checkObjectInDataTableByName("Deals", 15)
				  .clickObjectInDataTableByName("Deals", 15);
	}

	@Test
	public void datasetInstagram()
	{
		mainPage.checkIsRendered()
				  .openDatasources()
				  .clickPlusBtn();
		mainPage.selectDatasourceTypeDialog.checkIsRendered()
				  .clickIntegration("Instagram");
		mainPage.selectDatasetDialog.checkIsRendered()
				  .checkDialogTitle("Select dataset", 10)
				  .clickBasedInDialogByName("Instagram Overview", "ic_instagram", 20);
		mainPage.checkObjectInDataTableByName("Instagram Overview", 15)
				  .clickObjectInDataTableByName("Instagram Overview", 15);
	}

	@Test
	public void datasetGoogleAds()
	{
		//коннектор в разработке
		mainPage.checkIsRendered()
				  .openDatasources()
				  .clickPlusBtn();
		mainPage.selectDatasourceTypeDialog.checkIsRendered()
				  .clickIntegration("Google Analytics");
		mainPage.selectDatasetDialog.checkIsRendered()
				  .checkDialogTitle("Select dataset", 10)
				  .clickBasedInDialogByName("Slemma/slemma.com - STAG/slemma.com", "ic_google_analytics", 10);
		driver.switchToMainWindow();
		mainPage.checkObjectInDataTableByName("", 5)
				  .clickObjectInDataTableByName("", 5);
	}

	@Test
	public void datasetStripe()
	{
		//Stripe коннектор в разработке
		mainPage.checkIsRendered()
				  .openDatasources()
				  .clickPlusBtn();
		mainPage.selectDatasourceTypeDialog.checkIsRendered()
				  .clickIntegration("Stripe");
		mainPage.selectDatasetDialog.checkIsRendered()
				  .checkDialogTitle("Select dataset", 10)
				  .clickBasedInDialogByName("", "", 10);
		driver.switchToMainWindow();
		mainPage.checkObjectInDataTableByName("", 5)
				  .clickObjectInDataTableByName("", 5);
	}

	@Test
	public void datasetInfusionsoft()
	{
		mainPage.checkIsRendered()
				  .openDatasources()
				  .clickPlusBtn();
		mainPage.selectDatasourceTypeDialog.checkIsRendered()
				  .clickIntegration("Infusionsoft");
		mainPage.selectDatasetDialog.checkIsRendered()
				  .checkDialogTitle("Select dataset", 10)
				  .clickBasedInDialogByName("Appointments", "ic_infusionsoft", 20);
		mainPage.checkObjectInDataTableByName("Appointments", 15)
				  .clickObjectInDataTableByName("Appointments", 15);
	}

	@Test
	public void datasetWrike()
	{
		mainPage.checkIsRendered()
				  .openDatasources()
				  .clickPlusBtn();
		mainPage.selectDatasourceTypeDialog.checkIsRendered()
				  .clickIntegration("Wrike");
		mainPage.selectDatasetDialog.checkIsRendered()
				  .checkDialogTitle("Select dataset", 10)
				  .clickBasedInDialogByName("Contacts", "ic_wrike", 20);
		mainPage.checkObjectInDataTableByName("Contacts", 15)
				  .clickObjectInDataTableByName("Contacts", 15);
	}

	@Test
	public void renameMeusureDimentionCloud()
//TestTeam2
	{
		changeTeam("TestTeam2");
		mainPage.checkIsRendered()
				  .openDatasources()
				  .clickObjectInDataTableByName("Testslemma", 5);
		datasourceCreatePage.checkIsRendered();
		datasourceCreatePage.settingsDataSourcesDialog.checkIsRendered()
				  .clickField()
				  .clickFieldsInDialogByName("Name", "ic_dimension", 15);
		datasourceCreatePage.fieldSettingsDialog.checkIsRendered()
				  .fieldNameInput("Name1")
				  .okBtn();
		datasourceCreatePage.settingsDataSourcesDialog.clickFieldsInDialogByName("Summ", "ic_measure", 15);
		datasourceCreatePage.fieldSettingsDialog.checkIsRendered()
				  .fieldNameInput("Summ1")
				  .okBtn();
		datasourceCreatePage.clickMoreBtn();
		mainPage.moreOptionDropDown.checkIsRendered()
				  .clickSaveIcon();
		//		проверка в отчете источника применение изменений
		mainPage.checkIsRendered()
				  .openReports()
				  .clickObjectInDataTableByName("OneDriveSource", 5);
		reportsPage.checkIsRendered()
				  .clickEditBtn()
				  .clickChartByName("changeMeusureDimention");
		reportsPage.settingsChartDialog.checkIsRendered()
				  .checkDimensionInPanelByName("Name1")
				  .checkDimensionInPanelByName("Summ1");
		reportsPage.clickCloseBtn();
		//обратное переименование метрик
		mainPage.checkIsRendered()
				  .openDatasources()
				  .clickObjectInDataTableByName("Testslemma", 5);
		datasourceCreatePage.checkIsRendered();
		datasourceCreatePage.settingsDataSourcesDialog.checkIsRendered()
				  .clickField()
				  .clickFieldsInDialogByName("Name1", "ic_dimension", 15);
		datasourceCreatePage.fieldSettingsDialog.checkIsRendered()
				  .fieldNameInput("Name")
				  .okBtn();
		datasourceCreatePage.settingsDataSourcesDialog.clickFieldsInDialogByName("Summ1", "ic_measure", 15);
		datasourceCreatePage.fieldSettingsDialog.checkIsRendered()
				  .fieldNameInput("Summ")
				  .okBtn();
		datasourceCreatePage.clickMoreBtn();
		mainPage.moreOptionDropDown.checkIsRendered()
				  .clickSaveIcon();
	}

	@Test
	public void renameMeusureDimentionDB()
//TestTeam2
	{
		changeTeam("TestTeam2");
		mainPage.checkIsRendered()
				  .openDatasources()
				  .clickObjectInDataTableByName("dc3qukco027qjj", 5);
		datasourceCreatePage.checkIsRendered()
				  .clickAgViewport()
				  .clickTuneBtn();
		datasourceCreatePage.settingsDataSourcesDialog.checkIsRendered()
				  .clickField()
				  .clickFieldsInDialogByName("data_varchar", "ic_dimension", 15);
		datasourceCreatePage.fieldSettingsDialog.checkIsRendered()
				  .fieldNameInput("data_varchar1")
				  .okBtn();
		datasourceCreatePage.settingsDataSourcesDialog.clickFieldsInDialogByName("month", "ic_measure", 15);
		datasourceCreatePage.fieldSettingsDialog.checkIsRendered()
				  .fieldNameInput("month1")
				  .okBtn();
		datasourceCreatePage.clickMoreBtn();
		mainPage.moreOptionDropDown.checkIsRendered()
				  .clickSaveIcon();
		pause(5);
		//		проверка в отчете источника применение изменений
		mainPage.checkIsRendered()
				  .openReports()
				  .clickObjectInDataTableByName("DBSource", 5);
		reportsPage.checkIsRendered()
				  .clickEditBtn()
				  .clickChartByName("changeMeusureDimention");
		reportsPage.settingsChartDialog.checkIsRendered()
				  .checkDimensionInPanelByName("data_varchar1")
				  .checkDimensionInPanelByName("month1");
		reportsPage.clickCloseBtn();
		//обратное переименование метрик
		mainPage.checkIsRendered()
				  .openDatasources()
				  .clickObjectInDataTableByName("dc3qukco027qjj", 5);
		datasourceCreatePage.checkIsRendered()
				  .clickAgViewport()
				  .clickTuneBtn();
		datasourceCreatePage.settingsDataSourcesDialog.checkIsRendered()
				  .clickField()
				  .clickFieldsInDialogByName("data_varchar1", "ic_dimension", 15);
		datasourceCreatePage.fieldSettingsDialog.checkIsRendered()
				  .fieldNameInput("data_varchar")
				  .okBtn();
		datasourceCreatePage.settingsDataSourcesDialog.clickFieldsInDialogByName("month1", "ic_measure", 15);
		datasourceCreatePage.fieldSettingsDialog.checkIsRendered()
				  .fieldNameInput("month")
				  .okBtn();
		datasourceCreatePage.clickMoreBtn();
		mainPage.moreOptionDropDown.checkIsRendered()
				  .clickSaveIcon();
		pause(5);
	}

	@Test
	public void splitFileSource()
	{
		changeTeam("TestTeam2");
		mainPage.checkIsRendered()
				  .openDatasources()
				  .clickObjectInDataTableByName("Non-residential outliers", 5);
		datasourceCreatePage.checkIsRendered()
				  .clickAgViewport();
		datasourceCreatePage.settingsDataSourcesDialog.checkIsRendered()
				  .clickFieldsInDialogByName("Series_reference", "ic_dimension", 15);
		datasourceCreatePage.fieldSettingsDialog.checkIsRendered()
				  .clickFieldsInDialogByName("Split...", "ic_check_box_outline", 2)
				  .separatorInput(",")
				  .okBtn();
//		String asd = driver.getElement(By.xpath("//div[@row-index='0']//div[@col-id='0']")).getText();
		Assert.assertTrue(driver.getElement(By.xpath("//div[@row-index='0']//div[@col-id='0']")).getText().matches("BLDM.SLE2"));
		datasourceCreatePage.clickMoreBtn();
		mainPage.moreOptionDropDown.checkIsRendered()
				  .clickSaveIcon();
		pause(5);
		mainPage.clickObjectInDataTableByName("Non-residential outliers", 5);
		datasourceCreatePage.checkIsRendered()
				  .clickAgViewport();
		datasourceCreatePage.settingsDataSourcesDialog.checkIsRendered()
				  .clickFieldsInDialogByName("Series_reference", "ic_dimension", 15);
		datasourceCreatePage.fieldSettingsDialog.checkIsRendered()
				  .clickFieldsInDialogByName("Split...", "ic_check_box", 2)
				  .okBtn();
//		String asd = driver.getElement(By.xpath("//div[@row-index='0']//div[@col-id='0']")).getText();
		Assert.assertTrue(driver.getElement(By.xpath("//div[@row-index='0']//div[@col-id='0']")).getText().matches("BLDM.SLE2"));
		datasourceCreatePage.clickMoreBtn();
		mainPage.moreOptionDropDown.checkIsRendered()
				  .clickSaveIcon();
		pause(5);
		mainPage.clickObjectInDataTableByName("Non-residential outliers", 5);
		datasourceCreatePage.checkIsRendered()
				  .clickAgViewport();
		Assert.assertTrue(driver.getElement(By.xpath("//div[@row-index='0']//div[@col-id='0']")).getText().matches("BLDM.SLE2"));
		datasourceCreatePage.clickbackBtn();
	}

	@Test
	public void CVSrefresh()
	{
		mainPage.checkIsRendered()
				  .openDatasources()
				  .contextClickObjectInDataTableByName("Testslemma", "ic_csv", 5);
		mainPage.moreOptionDropDown.checkIsRendered()
				  .clickRefreshIcon();
		datasourceCreatePage.checkIsRendered()
				  .existChooseAfile()
				  .existSettingsBtn()
				  .clickbackBtn();
	}

	@Test
	public void SaaSrefresh()
	{
		mainPage.checkIsRendered()
				  .openDatasources()
				  .contextClickObjectInDataTableByName("Slemma/slemma.com - STAG/slemma.com - STAG - MASTER", "ic_google_analytics", 5);
		mainPage.moreOptionDropDown.checkIsRendered()
				  .clickRefreshIcon();
		mainPage.messageDialog.checkIsRendered()
				  .checkMessage("Done", 10)
				  .clickcloseBtn();

	}

	@Test
	public void AddingDistinctCount()
	{
		changeTeam("TestTeam2");
		mainPage.checkIsRendered()
				  .openDatasources()
				  .clickObjectInDataTableByName("countries", 5);
		datasourceCreatePage.checkIsRendered()
				  .clickAgViewport();
		datasourceCreatePage.settingsDataSourcesDialog.clickField()
				  .clickFieldsInDialogByName("Russian name", "ic_dimension", 15);
		datasourceCreatePage.fieldSettingsDialog.checkIsRendered()
				  .clickFieldsInDialogByName("Add distinct-count measure", "ic_check_box_outline", 2)
				  .clickDistinctCountSettingsBtn();
		datasourceCreatePage.distinctCountSettingsDialog.checkIsRendered()
				  .enterMeasureName("")
				  .enterMeasureName("New Name")
				  .selectNumberFormat().selectByVisibleText("Number");
		datasourceCreatePage.distinctCountSettingsDialog.clickCloseBtn();
		datasourceCreatePage.fieldSettingsDialog.okBtn();
		datasourceCreatePage.clickbackBtn();
		mainPage.saveChangeDialog.checkIsRendered()
				  .clickSaveBtn();
		//проверка метрики в отчете
		pause(5);
		mainPage.checkIsRendered()
				  .openReports()
				  .clickPlusBtn();
		reportsPage.checkIsRendered()
				  .clickInsertBtn();
		reportsPage.chooseObjectDropDown.checkIsRendered()
				  .clickObjectByName("Chart", "ic_chart");
		reportsPage.selectaDataSourceDialog.checkIsRendered()
				  .clickDataSourceInDialogByName("countries", "ic_dropbox", 30);
		reportsPage.chooseaChartTypeDialog.checkIsRendered()
				  .clickTypeChartInDialogByName("Column", "ic_column", 10);
		reportsPage.settingsChartDialog.checkIsRendered()
				  .checkDialogTitle("Settings", 2)
				  .clickAddMeasureBtn()
				  .checkDialogTitle("Choose measure", 5)
				  .checkDimensionInPanelByName("New Name");
		reportsPage.clickCloseBtn();
		mainPage.saveChangeDialog.checkIsRendered()
				  .clickDontSaveBtn();
		//удалить distinct count
		pause(5);
		mainPage.checkIsRendered()
				  .openDatasources()
				  .clickObjectInDataTableByName("countries", 5);
		datasourceCreatePage.checkIsRendered()
				  .clickAgViewport();
		datasourceCreatePage.settingsDataSourcesDialog.clickField()
				  .clickFieldsInDialogByName("Russian name", "ic_dimension", 15);
		datasourceCreatePage.fieldSettingsDialog.checkIsRendered()
				  .clickFieldsInDialogByName("Add distinct-count measure", "ic_check_box", 2)
				  .okBtn();
		datasourceCreatePage.clickbackBtn();
		mainPage.saveChangeDialog.checkIsRendered()
				  .clickSaveBtn();
	}

	@Test
public void CalculationField()
{
	mainPage.checkIsRendered()
			  .openDatasources()
			  .clickPlusBtn();
	mainPage.selectDatasourceTypeDialog.checkIsRendered()
			  .uploadFile("C:\\Users\\User\\Downloads\\csv\\DemoData.csv");
	datasourceCreatePage.checkIsRendered()
			  .clickAgViewport()
			  //выч. поле case when Region= 'Central' then 1 else 0 end
           .clickCalculationBtn();
	datasourceCreatePage.calculationFieldDialog.checkIsRendered()
           .fieldNameInput("")
			  .fieldNameInput("region_central")
			  .clickCodeMirror();
	driver.keyboardImitate("case when Region= 'Central' then 1 else 0 end");
	datasourceCreatePage.calculationFieldDialog.clickOkBtn();
	datasourceCreatePage.checkIsRendered()
			  .clickAgViewport();
	pause(5);
	//преобразование типа cast
	datasourceCreatePage.checkIsRendered()
			  .clickCalculationBtn();
	datasourceCreatePage.calculationFieldDialog.checkIsRendered()
			  .fieldNameInput("")
			  .fieldNameInput("OrderDate_Text")
			  .clickCodeMirror();
	driver.keyboardImitate("cast(Order Date as Text) ");
	datasourceCreatePage.calculationFieldDialog.clickOkBtn();
	datasourceCreatePage.checkIsRendered()
			  .clickAgViewport();
	pause(5);
	//работа с датой
	datasourceCreatePage.checkIsRendered()
			  .clickCalculationBtn();
	datasourceCreatePage.calculationFieldDialog.checkIsRendered()
			  .fieldNameInput("")
			  .fieldNameInput("OrderDate_timestamp")
			  .clickCodeMirror();
	driver.keyboardImitate("Order Date::timestamp + '1 year' ");
	datasourceCreatePage.calculationFieldDialog.clickOkBtn();
	datasourceCreatePage.checkIsRendered()
			  .clickAgViewport();
	pause(5);
//// дописать и допроверить после починки
	//проверка в настройках добавленных полей
	datasourceCreatePage.settingsDataSourcesDialog.checkIsRendered()
			  .checkFieldsInDialogByName("region_central", "ic_calculation", 5)
			  .checkFieldsInDialogByName("OrderDate_Text", "ic_dimension", 5)
			  .checkFieldsInDialogByName("OrderDate_timestamp","ic_date_range",5);
	//проверка в таблице добавленных полей
//	datasourceCreatePage.checkIsRendered()
//			  .clickAgViewport();
//	Assert.assertTrue(driver.getElement(By.xpath("//div[@row-index='0']//div[@col-id='17']")).getText().matches("1"));
//	Assert.assertTrue(driver.getElement(By.xpath("//div[@row-index='0']//div[@col-id='17']")).getText().matches("2012-03-09 19:00:00+03"));
//	Assert.assertTrue(driver.getElement(By.xpath("//div[@row-index='0']//div[@col-id='17']")).getText().matches("2013-03-09 22:00:00.0"));
//	datasourceCreatePage.checkIsRendered()
//			  .clickSave()
	datasourceCreatePage.clickbackBtn();
}


}
