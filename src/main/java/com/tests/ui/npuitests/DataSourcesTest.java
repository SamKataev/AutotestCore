package com.tests.ui.npuitests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DataSourcesTest extends NPWebTest
{
	@BeforeClass
	@Override
	public void startTestClass()
	{
		super.startTestClass();
		changeTeam("TestTeam");
	}

	@BeforeMethod
	@Override
	public void startTestMethod()
	{
		if (!driver.getCurrentWindowHandle().equals(driver.getMainWindowHandle()))
			driver.switchToMainWindow();

		openDataSourcesPage();
	}

	@Test
	public void uploadFileByUrl()
	{
		mainPage.checkIsRendered()
				  .openDatasources()
				  .clickCreateBtn();
		mainPage.createDatabaseDialog
				  .checkIsRendered()
				  .clickUploadFile();
		mainPage.createDatabaseDialog.selectDatasourceTypeDialog
				  .checkIsRendered()
				  .clickFileByUrl();
		mainPage.createDatabaseDialog.fileByUrlDialog
				  .checkIsRendered()
				  .typeUrl("https://www.dropbox.com/s/733wh1uh4ukk7xt/For%20charts.csv?dl=1")
				  .clickDone();
		dataSourceCreatePage
				  .checkIsRendered()
				  .clickMenuBtn();
		dataSourceCreatePage.mainMenu
				  .checkIsRendered()
				  .clickSave()
				  .processWaiter(10);
		dataSourceCreatePage
				  .clickClose();
		mainPage.checkIsRendered()
				  .checkObjectByName("For%20charts.csv");
	}

	@Test
	public void googleDriveIntegrationAndSource()
	{
		mainPage.checkIsRendered()
				  .openDatasources()
				  .clickCreateBtn();
		mainPage.createDatabaseDialog
				  .checkIsRendered()
				  .clickUploadFile();
		mainPage.createDatabaseDialog.selectDatasourceTypeDialog
				  .checkIsRendered()
				  .clickGoogleDriveBtn();

		driver.switchWindow(2);
		googleLogIn.enterEmailInput("s.kataev@slemma.com")
				  .clickEmailNextBtn()
				  .enterpasswordInput("Q123#@!w")
				  .clickPasswordNextBtn()
				  .clickAllowBtn();
		driver.switchToMainWindow(5);

		mainPage.createDatabaseDialog.chooseCloudFileDialog
				  .checkIsRendered()
				  .clickObjectByName("dates");
		dataSourceCreatePage
				  .checkIsRendered()
				  .clickMenuBtn();
		dataSourceCreatePage.mainMenu
				  .checkIsRendered()
				  .clickSave()
				  .processWaiter(10);
		dataSourceCreatePage
				  .clickClose();
		mainPage.checkIsRendered()
				  .checkObjectByName("For%20charts.csv");
	}

	@Test
	public void uploadFile()
	{
		mainPage.checkIsRendered()
				  .openDatasources()
				  .clickCreateBtn();
		mainPage.createDatabaseDialog
				  .checkIsRendered()
				  .clickUploadFile();
		mainPage.createDatabaseDialog.selectDatasourceTypeDialog
				  .checkIsRendered()
				  .uploadFile("D:\\test data\\source.csv");
		dataSourceCreatePage
				  .checkIsRendered()
				  .clickMenuBtn();
		dataSourceCreatePage.mainMenu
				  .checkIsRendered()
				  .clickSave()
				  .processWaiter(10);
		dataSourceCreatePage
				  .clickClose();
		mainPage.checkIsRendered()
				  .checkObjectByName("source");
	}
	
	
	
	
	
	
//	@Test
//	public void datasetGoogleAnalytics()
//	{
//		//коннектор в разработке
//		changeTeam("TestTeam");
//		mainPage.checkIsRendered()
//				  .openDatasources()
//				  .clickCreateBtn();
//		mainPage.selectDatasourceTypeDialog.checkIsRendered()
//				  .clickIntegration("Google Analytics");
//		mainPage.selectDatasetDialog.checkIsRendered()
//				  .checkDialogTitle("Select dataset", 10)
//				  .clickBasedInDialogByName("Slemma/slemma.com - STAG/slemma.com", "ic_google_analytics", 10);
//		driver.switchToMainWindow();
//		mainPage.checkObjectByName("Slemma/slemma.com - STAG/slemma.com - STAG - MASTER", 5)
//				  .clickObjectInDataTableByName("Slemma/slemma.com - STAG/slemma.com - STAG - MASTER", 5);
//	}

//	@Test
//	public void datasetZendesk()
//	{
//		changeTeam("TestTeam");
//		mainPage.checkIsRendered()
//				  .clickdrawerToggleBtn();
//		mainPage.openDatasources()
//				  .clickCreateBtn();
//		mainPage.selectDatasourceTypeDialog.checkIsRendered()
//				  .clickIntegration("Zendesk");
//		mainPage.selectDatasetDialog.checkIsRendered()
//				  .checkDialogTitle("Select dataset", 10)
//				  .clickBasedInDialogByName("Users", "ic_zendesk", 20);
////        pause(5);
//		mainPage.checkObjectByName("Users", 15)
//				  .clickObjectInDataTableByName("Users", 15);
//	}
//
//	@Test
//	public void datasetMailChimp()
//	{
//		changeTeam("TestTeam");
//		mainPage.checkIsRendered()
//				  .clickdrawerToggleBtn();
//		mainPage.openDatasources()
//				  .clickCreateBtn();
//		mainPage.selectDatasourceTypeDialog.checkIsRendered()
//				  .clickIntegration("MailChimp");
//		mainPage.selectDatasetDialog.checkIsRendered()
//				  .checkDialogTitle("Select dataset", 10)
//				  .clickBasedInDialogByName("Campaigns", "ic_mailchimp", 20);
////        pause(5);
//		mainPage.checkObjectByName("Campaigns", 15)
//				  .clickObjectInDataTableByName("Campaigns", 15);
//	}
//
//	@Test
//	public void datasetHubspot()
//	{
//		changeTeam("TestTeam");
//		mainPage.checkIsRendered()
//				  .clickdrawerToggleBtn();
//		mainPage.openDatasources()
//				  .clickCreateBtn();
//		mainPage.selectDatasourceTypeDialog.checkIsRendered()
//				  .clickIntegration("Hubspot");
//		mainPage.selectDatasetDialog.checkIsRendered()
//				  .checkDialogTitle("Select dataset", 10)
//				  .clickBasedInDialogByName("Deals", "ic_hubspot", 20);
////        pause(5);
//		mainPage.checkObjectByName("Deals", 15)
//				  .clickObjectInDataTableByName("Deals", 15);
//	}
//
//	@Test
//	public void datasetDropbox()
//	{
//		changeTeam("TestTeam");
//		mainPage.checkIsRendered()
//				  .clickdrawerToggleBtn();
//		mainPage.openDatasources()
//				  .clickCreateBtn();
//		mainPage.selectDatasourceTypeDialog.checkIsRendered()
//				  .clickIntegration("Dropbox");
//		mainPage.selectDatasetDialog.checkIsRendered()
//				  .checkDialogTitle("Dropbox", 10);
//		pause(5);
//		mainPage.selectDatasetDialog.clickFileInDialogByName("Testslemma.xls", "ic_file", 20);
//		dataSourceCreatePage.checkIsRendered()
//				  .clickSave();
//		mainPage.checkObjectByName("Testslemma", 15)
//				  .clickObjectInDataTableByName("Testslemma", 15);
//	}
//
//	@Test
//	public void datasetFreshSales()
//	{
//		changeTeam("TestTeam");
//		mainPage.checkIsRendered()
//				  .clickdrawerToggleBtn();
//		mainPage.openDatasources()
//				  .clickCreateBtn();
//		mainPage.selectDatasourceTypeDialog.checkIsRendered()
//				  .clickIntegration("FreshSales");
//		mainPage.selectDatasetDialog.checkIsRendered()
//				  .checkDialogTitle("Select dataset", 10)
//				  .clickBasedInDialogByName("Deals", "ic_freshsales", 20);
//		mainPage.checkObjectByName("Deals", 15)
//				  .clickObjectInDataTableByName("Deals", 15);
//	}
//
//	@Test
//	public void datasetFreshDesk()
//	{
//		changeTeam("TestTeam");
//		mainPage.checkIsRendered()
//				  .clickdrawerToggleBtn();
//		mainPage.openDatasources()
//				  .clickCreateBtn();
//		mainPage.selectDatasourceTypeDialog.checkIsRendered()
//				  .clickIntegration("FreshDesk");
//		mainPage.selectDatasetDialog.checkIsRendered()
//				  .checkDialogTitle("Select dataset", 10)
//				  .clickBasedInDialogByName("Tickets", "ic_freshdesk", 20);
//		mainPage.checkObjectByName("Tickets", 15)
//				  .clickObjectInDataTableByName("Tickets", 15);
//	}
//
//	@Test
//	public void datasetFacebook()
//	{
//		changeTeam("TestTeam");
//		mainPage.checkIsRendered()
//				  .clickdrawerToggleBtn();
//		mainPage.openDatasources()
//				  .clickCreateBtn();
//		mainPage.selectDatasourceTypeDialog.checkIsRendered()
//				  .clickIntegration("Facebook");
//		mainPage.selectDatasetDialog.checkIsRendered()
//				  .checkDialogTitle("Select dataset", 10)
//				  .clickBasedInDialogByName("Posts Stats Lifetime", "ic_facebook", 20);
//		mainPage.checkObjectByName("Posts Stats Lifetime", 15)
//				  .clickObjectInDataTableByName("Posts Stats Lifetime", 15);
//	}
//
//	@Test
//	public void datasetFacebookAds()
//	{
//		changeTeam("TestTeam");
//		mainPage.checkIsRendered()
//				  .clickdrawerToggleBtn();
//		mainPage.openDatasources()
//				  .clickCreateBtn();
//		mainPage.selectDatasourceTypeDialog.checkIsRendered()
//				  .clickIntegration("Facebook Ads");
//		mainPage.selectDatasetDialog.checkIsRendered()
//				  .checkDialogTitle("Select dataset", 10)
//				  .clickBasedInDialogByName("Ad Account Stats", "ic_facebook_ads", 20);
//		mainPage.saaSParametersDialog.checkIsRendered()
//				  .clickOkBtn();
//		mainPage.checkObjectByName("Ad Account Stats", 15)
//				  .clickObjectInDataTableByName("Ad Account Stats", 15);
//	}
//
//	@Test
//	public void datasetHerokuPostgreSQL()
//	{
//		changeTeam("TestTeam");
//		mainPage.checkIsRendered()
//				  .clickdrawerToggleBtn();
//		mainPage.openDatasources()
//				  .clickCreateBtn();
//		mainPage.selectDatasourceTypeDialog.checkIsRendered()
//				  .clickIntegration("Heroku PostgreSQL");
//		dataSourceCreatePage.checkIsRendered()
//				  .clickCodeMirror();
//		driver.keyboardImitate("SELECT * from calendar");
//		pause(5);
//		dataSourceCreatePage.clickQueryBtn()
//				  .clickAgViewport()
//				  .clickMenuBtn();
//		mainPage.moreOptionDropDown.checkIsRendered()
//				  .clickSaveBtn();
//		mainPage.renameDialog.checkIsRendered()
//				  .enterInputName("HerokuQuery")
//				  .clickRenameBtn();
//		mainPage.checkObjectByName("HerokuQuery", 15)
//				  .clickObjectInDataTableByName("HerokuQuery", 15);
//	}

//	@Test
//	public void datasetJira()
//	{
//		changeTeam("TestTeam");
//		mainPage.checkIsRendered()
//				  .clickdrawerToggleBtn();
//		mainPage.openDatasources()
//				  .clickCreateBtn();
//		mainPage.selectDatasourceTypeDialog.checkIsRendered()
//				  .clickIntegration("Jira (https://npeople.atlassian.net)");
//		mainPage.selectDatasetDialog.checkIsRendered()
//				  .checkDialogTitle("Select dataset", 10)
//				  .clickBasedInDialogByName("Jira ticket statuses", "ic_jira", 20);
//		mainPage.saaSParametersDialog.checkIsRendered()
//				  .clickOkBtn();
//		mainPage.checkObjectByName("Jira ticket statuses", 20)
//				  .clickObjectInDataTableByName("Jira ticket statuses", 20);
//	}

//	@Test
//	public void datasetYandexDisk()
//	{
//		changeTeam("TestTeam");
//		mainPage.checkIsRendered()
//				  .clickdrawerToggleBtn();
//		mainPage.openDatasources()
//				  .clickCreateBtn();
//		mainPage.selectDatasourceTypeDialog.checkIsRendered()
//				  .clickIntegration("Yandex Disk");
//		mainPage.selectDatasetDialog.checkIsRendered()
//				  .checkDialogTitle("Yandex Disk", 10)
//				  .clickFileInDialogByName("TestslemmaYandex.csv", "ic_file", 10);
//		dataSourceCreatePage.checkIsRendered()
//				  .clickAgViewport()
//				  .clickSave();
//		mainPage.checkObjectByName("TestslemmaYandex", 15)
//				  .clickObjectInDataTableByName("TestslemmaYandex", 15);
//	}
//
//	@Test
//	public void datasetOneDrive()
//	{
//		changeTeam("TestTeam");
//		mainPage.checkIsRendered()
//				  .clickdrawerToggleBtn();
//		mainPage.openDatasources()
//				  .clickCreateBtn();
//		mainPage.selectDatasourceTypeDialog.checkIsRendered()
//				  .clickIntegration("OneDrive");
//		mainPage.selectDatasetDialog.checkIsRendered()
//				  .checkDialogTitle("OneDrive", 10)
//				  .clickFileInDialogByName("African Mobile Transactions Dummy Data_values.csv", "ic_file", 10);
//		dataSourceCreatePage.checkIsRendered()
//				  .clickAgViewport()
//				  .clickSave();
//		mainPage.checkObjectByName("African Mobile Transactions Dummy Data_values", 15)
//				  .clickObjectInDataTableByName("African Mobile Transactions Dummy Data_values", 15);
//	}
//
//	@Test
//	public void datasetBox()
//	{
//		changeTeam("TestTeam");
//		mainPage.checkIsRendered()
//				  .clickdrawerToggleBtn();
//		mainPage.openDatasources()
//				  .clickCreateBtn();
//		mainPage.selectDatasourceTypeDialog.checkIsRendered()
//				  .clickIntegration("Box");
//		mainPage.selectDatasetDialog.checkIsRendered()
//				  .checkDialogTitle("Box", 10)
//				  .clickBasedInDialogByName("Testslemma.xls", "ic_file", 10);
//		dataSourceCreatePage.checkIsRendered()
//				  .clickAgViewport()
//				  .clickSave();
//		mainPage.checkObjectByName("Testslemma", 15)
//				  .clickObjectInDataTableByName("Testslemma", 15);
//	}

//	@Test
//	public void datasetPostgreSQLIntegrations()
//	{
//		changeTeam("TestTeam");
//		mainPage.checkIsRendered()
//				  .clickdrawerToggleBtn();
//		mainPage.openDatasources()
//				  .clickCreateBtn();
//		mainPage.selectDatasourceTypeDialog.checkIsRendered()
//				  .clickIntegration("PostgreSQL");
//		dataSourceCreatePage.checkIsRendered()
//				  .clickCodeMirror();
//		driver.keyboardImitate("SELECT * from action_log");
//		dataSourceCreatePage.clickQueryBtn()
//				  .clickAgViewport()
//				  .clickMenuBtn();
//		mainPage.moreOptionDropDown.checkIsRendered()
//				  .clickSaveBtn();
//		mainPage.renameDialog.checkIsRendered()
//				  .enterInputName("action_log")
//				  .clickRenameBtn();
//		mainPage.checkObjectByName("action_log", 15)
//				  .clickObjectInDataTableByName("action_log", 15);
//	}
//
//	@Test
//	public void datasetQuickBooks()
//	{
//		changeTeam("TestTeam");
//		mainPage.checkIsRendered()
//				  .clickdrawerToggleBtn();
//		mainPage.openDatasources()
//				  .clickCreateBtn();
//		mainPage.selectDatasourceTypeDialog.checkIsRendered()
//				  .clickIntegration("QuickBooks");
//		mainPage.selectDatasetDialog.checkIsRendered()
//				  .checkDialogTitle("Select dataset", 10)
//				  .clickBasedInDialogByName("Activities", "ic_quickbooks", 20);
//		mainPage.checkObjectByName("Activities", 15)
//				  .clickObjectInDataTableByName("Activities", 15);
//	}
//
//	@Test
//	public void datasetIntercom()
//	{
//		changeTeam("TestTeam");
//		mainPage.checkIsRendered()
//				  .clickdrawerToggleBtn();
//		mainPage.openDatasources()
//				  .clickCreateBtn();
//		mainPage.selectDatasourceTypeDialog.checkIsRendered()
//				  .clickIntegration("Intercom");
//		mainPage.selectDatasetDialog.checkIsRendered()
//				  .checkDialogTitle("Select dataset", 10)
//				  .clickBasedInDialogByName("Leads", "ic_intercom", 20);
//		mainPage.checkObjectByName("Leads", 15)
//				  .clickObjectInDataTableByName("Leads", 15);
//	}
//
//	@Test
//	public void datasetPayPal()
//	{
//		changeTeam("TestTeam");
//		mainPage.checkIsRendered()
//				  .clickdrawerToggleBtn();
//		mainPage.openDatasources()
//				  .clickCreateBtn();
//		mainPage.selectDatasourceTypeDialog.checkIsRendered()
//				  .clickIntegration("PayPal");
//		mainPage.selectDatasetDialog.checkIsRendered()
//				  .checkDialogTitle("Select dataset", 10)
//				  .clickBasedInDialogByName("Invoices", "ic_paypal", 20);
//		mainPage.checkObjectByName("Invoices", 15)
//				  .clickObjectInDataTableByName("Invoices", 15);
//	}

//	@Test
//	public void datasetPipedrive()
//	{
//		changeTeam("TestTeam");
//		mainPage.checkIsRendered()
//				  .clickdrawerToggleBtn();
//		mainPage.openDatasources()
//				  .clickCreateBtn();
//		mainPage.selectDatasourceTypeDialog.checkIsRendered()
//				  .clickIntegration("New People");
//		mainPage.selectDatasetDialog.checkIsRendered()
//				  .checkDialogTitle("Select dataset", 10)
//				  .clickBasedInDialogByName("Deals", "ic_pipedrive", 20);
//		mainPage.saaSParametersDialog.checkIsRendered()
//				  .clickOkBtn();
//		mainPage.checkObjectByName("Deals", 15)
//				  .clickObjectInDataTableByName("Deals", 15);
//	}

//	@Test
//	public void datasetInstagram()
//	{
//		changeTeam("TestTeam");
//		mainPage.checkIsRendered()
//				  .clickdrawerToggleBtn();
//		mainPage.openDatasources()
//				  .clickCreateBtn();
//		mainPage.selectDatasourceTypeDialog.checkIsRendered()
//				  .clickIntegration("Instagram");
//		mainPage.selectDatasetDialog.checkIsRendered()
//				  .checkDialogTitle("Select dataset", 10)
//				  .clickBasedInDialogByName("Instagram Overview", "ic_instagram", 20);
//		mainPage.checkObjectByName("Instagram Overview", 15)
//				  .clickObjectInDataTableByName("Instagram Overview", 15);
//	}

//	@Test
//	public void datasetGoogleAds()
//	{
//		changeTeam("TestTeam");
//		//коннектор в разработке
//		mainPage.checkIsRendered()
//				  .openDatasources()
//				  .clickCreateBtn();
//		mainPage.selectDatasourceTypeDialog.checkIsRendered()
//				  .clickIntegration("Google Analytics");
//		mainPage.selectDatasetDialog.checkIsRendered()
//				  .checkDialogTitle("Select dataset", 10)
//				  .clickBasedInDialogByName("Slemma/slemma.com - STAG/slemma.com", "ic_google_analytics", 10);
//		driver.switchToMainWindow();
//		mainPage.checkObjectByName("", 5)
//				  .clickObjectInDataTableByName("", 5);
//	}

//	@Test
//	public void datasetStripe()
//	{
//		changeTeam("TestTeam");
//		//Stripe коннектор в разработке
//		mainPage.checkIsRendered()
//				  .openDatasources()
//				  .clickCreateBtn();
//		mainPage.selectDatasourceTypeDialog.checkIsRendered()
//				  .clickIntegration("Stripe");
//		mainPage.selectDatasetDialog.checkIsRendered()
//				  .checkDialogTitle("Select dataset", 10)
//				  .clickBasedInDialogByName("", "", 10);
//		driver.switchToMainWindow();
//		mainPage.checkObjectByName("", 5)
//				  .clickObjectInDataTableByName("", 5);
//	}

//	@Test
//	public void datasetInfusionsoft()
//	{
//		changeTeam("TestTeam");
//		mainPage.checkIsRendered()
//				  .clickdrawerToggleBtn();
//		mainPage.openDatasources()
//				  .clickCreateBtn();
//		mainPage.selectDatasourceTypeDialog.checkIsRendered()
//				  .clickIntegration("Infusionsoft");
//		mainPage.selectDatasetDialog.checkIsRendered()
//				  .checkDialogTitle("Select dataset", 10)
//				  .clickBasedInDialogByName("Appointments", "ic_infusionsoft", 20);
//		mainPage.checkObjectByName("Appointments", 15)
//				  .clickObjectInDataTableByName("Appointments", 15);
//	}
//
//	@Test
//	public void datasetWrike()
//	{
//		changeTeam("TestTeam");
//		mainPage.checkIsRendered()
//				  .clickdrawerToggleBtn();
//		mainPage.openDatasources()
//				  .clickCreateBtn();
//		mainPage.selectDatasourceTypeDialog.checkIsRendered()
//				  .clickIntegration("Wrike");
//		mainPage.selectDatasetDialog.checkIsRendered()
//				  .checkDialogTitle("Select dataset", 10)
//				  .clickBasedInDialogByName("Contacts", "ic_wrike", 20);
//		mainPage.checkObjectByName("Contacts", 15)
//				  .clickObjectInDataTableByName("Contacts", 15);
//	}
//
//	@Test
//	public void renameMeusureDimentionCloud()
////TestTeam2
//	{
//		changeTeam("TestTeam2");
//		mainPage.checkIsRendered()
//				  .clickdrawerToggleBtn();
//		mainPage.openDatasources()
//				  .clickObjectInDataTableByName("Testslemma", 5);
//		dataSourceCreatePage.checkIsRendered();
//		dataSourceCreatePage.settingsDialog.checkIsRendered()
//				  .clickField()
//				  .clickFieldsInDialogByName("Name", "ic_dimension", 15);
//		dataSourceCreatePage.fieldSettingsDialog.checkIsRendered()
//				  .fieldNameInput("Name1")
//				  .okBtn();
//		dataSourceCreatePage.settingsDialog.clickFieldsInDialogByName("Summ", "ic_measure", 15);
//		dataSourceCreatePage.fieldSettingsDialog.checkIsRendered()
//				  .fieldNameInput("Summ1")
//				  .okBtn();
//		dataSourceCreatePage.clickMenuBtn();
//		mainPage.moreOptionDropDown.checkIsRendered()
//				  .clickSaveBtn();
//		//		проверка в отчете источника применение изменений
//		mainPage.checkIsRendered()
//				  .openReports()
//				  .clickObjectInDataTableByName("OneDriveSource", 5);
//		reportsPage.checkIsRendered()
//				  .clickEditBtn()
//				  .clickChartByName("changeMeusureDimention");
//		reportsPage.settingsChartDialog.checkIsRendered()
//				  .checkDimensionInPanelByName("Name1")
//				  .checkDimensionInPanelByName("Summ1");
//		reportsPage.clickCloseBtn();
//		//обратное переименование метрик
//		mainPage.checkIsRendered()
//				  .openDatasources()
//				  .clickObjectInDataTableByName("Testslemma", 5);
//		dataSourceCreatePage.checkIsRendered();
//		dataSourceCreatePage.settingsDialog.checkIsRendered()
//				  .clickField()
//				  .clickFieldsInDialogByName("Name1", "ic_dimension", 15);
//		dataSourceCreatePage.fieldSettingsDialog.checkIsRendered()
//				  .fieldNameInput("Name")
//				  .okBtn();
//		dataSourceCreatePage.settingsDialog.clickFieldsInDialogByName("Summ1", "ic_measure", 15);
//		dataSourceCreatePage.fieldSettingsDialog.checkIsRendered()
//				  .fieldNameInput("Summ")
//				  .okBtn();
//		dataSourceCreatePage.clickMenuBtn();
//		mainPage.moreOptionDropDown.checkIsRendered()
//				  .clickSaveBtn();
//	}
//
//	@Test
//	public void renameMeusureDimentionDB()
////TestTeam2
//	{
//		changeTeam("TestTeam2");
//		mainPage.checkIsRendered()
//				  .clickdrawerToggleBtn();
//		mainPage.openDatasources()
//				  .clickObjectInDataTableByName("dc3qukco027qjj", 5);
//		dataSourceCreatePage.checkIsRendered()
//				  .clickAgViewport()
//				  .clickTuneBtn();
//		dataSourceCreatePage.settingsDialog.checkIsRendered()
//				  .clickField()
//				  .clickFieldsInDialogByName("data_varchar", "ic_dimension", 15);
//		dataSourceCreatePage.fieldSettingsDialog.checkIsRendered()
//				  .fieldNameInput("data_varchar1")
//				  .okBtn();
//		dataSourceCreatePage.settingsDialog.clickFieldsInDialogByName("month", "ic_measure", 15);
//		dataSourceCreatePage.fieldSettingsDialog.checkIsRendered()
//				  .fieldNameInput("month1")
//				  .okBtn();
//		dataSourceCreatePage.clickMenuBtn();
//		mainPage.moreOptionDropDown.checkIsRendered()
//				  .clickSaveBtn();
//		pause(5);
//		//		проверка в отчете источника применение изменений
//		mainPage.checkIsRendered()
//				  .openReports()
//				  .clickObjectInDataTableByName("DBSource", 5);
//		reportsPage.checkIsRendered()
//				  .clickEditBtn()
//				  .clickChartByName("changeMeusureDimention");
//		reportsPage.settingsChartDialog.checkIsRendered()
//				  .checkDimensionInPanelByName("data_varchar1")
//				  .checkDimensionInPanelByName("month1");
//		reportsPage.clickCloseBtn();
//		//обратное переименование метрик
//		mainPage.checkIsRendered()
//				  .openDatasources()
//				  .clickObjectInDataTableByName("dc3qukco027qjj", 5);
//		dataSourceCreatePage.checkIsRendered()
//				  .clickAgViewport()
//				  .clickTuneBtn();
//		dataSourceCreatePage.settingsDialog.checkIsRendered()
//				  .clickField()
//				  .clickFieldsInDialogByName("data_varchar1", "ic_dimension", 15);
//		dataSourceCreatePage.fieldSettingsDialog.checkIsRendered()
//				  .fieldNameInput("data_varchar")
//				  .okBtn();
//		dataSourceCreatePage.settingsDialog.clickFieldsInDialogByName("month1", "ic_measure", 15);
//		dataSourceCreatePage.fieldSettingsDialog.checkIsRendered()
//				  .fieldNameInput("month")
//				  .okBtn();
//		dataSourceCreatePage.clickMenuBtn();
//		mainPage.moreOptionDropDown.checkIsRendered()
//				  .clickSaveBtn();
//		pause(5);
//	}
//
//	@Test
//	public void splitFileSource()
//	{
//		changeTeam("TestTeam2");
//		mainPage.checkIsRendered()
//				  .clickdrawerToggleBtn();
//		mainPage.openDatasources()
//				  .clickObjectInDataTableByName("Non-residential outliers", 5);
//		dataSourceCreatePage.checkIsRendered()
//				  .clickAgViewport();
//		dataSourceCreatePage.settingsDialog.checkIsRendered()
//				  .clickFieldsInDialogByName("Series_reference", "ic_dimension", 15);
//		dataSourceCreatePage.fieldSettingsDialog.checkIsRendered()
//				  .clickFieldsInDialogByName("Split...", "ic_check_box_outline", 2)
//				  .separatorInput(",")
//				  .okBtn();
////		String asd = driver.getElement(By.xpath("//div[@row-index='0']//div[@col-id='0']")).getText();
//		Assert.assertTrue(driver.getElement(By.xpath("//div[@row-index='0']//div[@col-id='0']")).getText().matches("BLDM.SLE2"));
//		dataSourceCreatePage.clickMenuBtn();
//		mainPage.moreOptionDropDown.checkIsRendered()
//				  .clickSaveBtn();
//		pause(5);
//		mainPage.clickObjectInDataTableByName("Non-residential outliers", 5);
//		dataSourceCreatePage.checkIsRendered()
//				  .clickAgViewport();
//		dataSourceCreatePage.settingsDialog.checkIsRendered()
//				  .clickFieldsInDialogByName("Series_reference", "ic_dimension", 15);
//		dataSourceCreatePage.fieldSettingsDialog.checkIsRendered()
//				  .clickFieldsInDialogByName("Split...", "ic_check_box", 2)
//				  .okBtn();
////		String asd = driver.getElement(By.xpath("//div[@row-index='0']//div[@col-id='0']")).getText();
//		Assert.assertTrue(driver.getElement(By.xpath("//div[@row-index='0']//div[@col-id='0']")).getText().matches("BLDM.SLE2"));
//		dataSourceCreatePage.clickMenuBtn();
//		mainPage.moreOptionDropDown.checkIsRendered()
//				  .clickSaveBtn();
//		pause(5);
//		mainPage.clickObjectInDataTableByName("Non-residential outliers", 5);
//		dataSourceCreatePage.checkIsRendered()
//				  .clickAgViewport();
//		Assert.assertTrue(driver.getElement(By.xpath("//div[@row-index='0']//div[@col-id='0']")).getText().matches("BLDM.SLE2"));
//		dataSourceCreatePage.clickbackBtn();
//	}
//
//	@Test
//	public void CVSrefresh()
//	{
//		changeTeam("TestTeam2");
//		mainPage.checkIsRendered()
//				  .clickdrawerToggleBtn();
//		mainPage.openDatasources()
//				  .contextClickObjectInDataTableByName("Testslemma", "ic_csv", 5);
//		mainPage.moreOptionDropDown.checkIsRendered()
//				  .clickRefreshIcon();
//		dataSourceCreatePage.checkIsRendered()
//				  .existChooseAfile()
//				  .existSettingsBtn()
//				  .clickbackBtn();
//	}
//
//	@Test
//	public void SaaSrefresh()
//	{
//		changeTeam("TestTeam2");
//		mainPage.checkIsRendered()
//				  .clickdrawerToggleBtn();
//		mainPage.openDatasources()
//				  .contextClickObjectInDataTableByName("Slemma/slemma.com - STAG/slemma.com - STAG - MASTER", "ic_google_analytics", 5);
//		mainPage.moreOptionDropDown.checkIsRendered()
//				  .clickRefreshIcon();
//		mainPage.messageDialog.checkIsRendered()
//				  .checkMessage("Done", 10)
//				  .clickcloseBtn();
//
//	}
//
//	@Test
//	public void AddingDistinctCount()
//	{
//		changeTeam("TestTeam2");
//		mainPage.checkIsRendered()
//				  .clickdrawerToggleBtn();
//		mainPage.openDatasources()
//				  .clickObjectInDataTableByName("countries", 5);
//		dataSourceCreatePage.checkIsRendered()
//				  .clickAgViewport();
//		dataSourceCreatePage.settingsDialog.clickField()
//				  .clickFieldsInDialogByName("Russian name", "ic_dimension", 15);
//		dataSourceCreatePage.fieldSettingsDialog.checkIsRendered()
//				  .clickFieldsInDialogByName("Add distinct-count measure", "ic_check_box_outline", 2)
//				  .clickDistinctCountSettingsBtn();
//		dataSourceCreatePage.distinctCountSettingsDialog.checkIsRendered()
//				  .enterMeasureName("")
//				  .enterMeasureName("New Name")
//				  .selectNumberFormat().selectByVisibleText("Number");
//		dataSourceCreatePage.distinctCountSettingsDialog.clickCloseBtn();
//		dataSourceCreatePage.fieldSettingsDialog.okBtn();
//		dataSourceCreatePage.clickbackBtn();
//		mainPage.saveChangeDialog.checkIsRendered()
//				  .clickSaveBtn();
//		//проверка метрики в отчете
//		pause(5);
//		mainPage.checkIsRendered()
//				  .openReports()
//				  .clickCreateBtn();
//		reportsPage.checkIsRendered()
//				  .clickInsertBtn();
//		reportsPage.chooseObjectDropDown.checkIsRendered()
//				  .clickObjectByName("Chart", "ic_chart");
//		reportsPage.selectaDataSourceDialog.checkIsRendered()
//				  .clickDataSourceInDialogByName("countries", "ic_dropbox", 30);
//		reportsPage.chooseaChartTypeDialog.checkIsRendered()
//				  .clickTypeChartInDialogByName("Column", "ic_column", 10);
//		reportsPage.settingsChartDialog.checkIsRendered()
//				  .checkDialogTitle("Settings", 2)
//				  .clickAddMeasureBtn()
//				  .checkDialogTitle("Choose measure", 5)
//				  .checkDimensionInPanelByName("New Name");
//		reportsPage.clickCloseBtn();
//		mainPage.saveChangeDialog.checkIsRendered()
//				  .clickDontSaveBtn();
//		//удалить distinct count
//		pause(5);
//		mainPage.checkIsRendered()
//				  .openDatasources()
//				  .clickObjectInDataTableByName("countries", 5);
//		dataSourceCreatePage.checkIsRendered()
//				  .clickAgViewport();
//		dataSourceCreatePage.settingsDialog.clickField()
//				  .clickFieldsInDialogByName("Russian name", "ic_dimension", 15);
//		dataSourceCreatePage.fieldSettingsDialog.checkIsRendered()
//				  .clickFieldsInDialogByName("Add distinct-count measure", "ic_check_box", 2)
//				  .okBtn();
//		dataSourceCreatePage.clickbackBtn();
//		mainPage.saveChangeDialog.checkIsRendered()
//				  .clickSaveBtn();
//	}
//
//	@Test
//	public void CalculationField()
//	{
//		changeTeam("TestTeam");
//		mainPage.checkIsRendered()
//				  .clickdrawerToggleBtn();
//		mainPage.openDatasources()
//				  .clickCreateBtn();
//		mainPage.selectDatasourceTypeDialog.checkIsRendered()
//				  .uploadFile("C:\\resources\\DemoData.csv");
//		dataSourceCreatePage.checkIsRendered()
//				  .clickAgViewport()
//				  //выч. поле case when Region= 'Central' then 1 else 0 end
//				  .clickCalculationBtn();
//		dataSourceCreatePage.calculationFieldDialog.checkIsRendered()
//				  .fieldNameInput("")
//				  .fieldNameInput("region_central")
//				  .clickCodeMirror();
//		driver.keyboardImitate("case when Region= 'Central' then 1 else 0 end");
//		dataSourceCreatePage.calculationFieldDialog.clickOkBtn();
//		dataSourceCreatePage.checkIsRendered()
//				  .clickAgViewport();
//		pause(5);
//		//преобразование типа cast
//		dataSourceCreatePage.checkIsRendered()
//				  .clickCalculationBtn();
//		dataSourceCreatePage.calculationFieldDialog.checkIsRendered()
//				  .fieldNameInput("")
//				  .fieldNameInput("OrderDate_Text")
//				  .clickCodeMirror();
//		driver.keyboardImitate("cast(Order Date as Text) ");
//		dataSourceCreatePage.calculationFieldDialog.clickOkBtn();
//		dataSourceCreatePage.checkIsRendered()
//				  .clickAgViewport();
//		pause(5);
//		//работа с датой
//		dataSourceCreatePage.checkIsRendered()
//				  .clickCalculationBtn();
//		dataSourceCreatePage.calculationFieldDialog.checkIsRendered()
//				  .fieldNameInput("")
//				  .fieldNameInput("OrderDate_timestamp")
//				  .clickCodeMirror();
//		driver.keyboardImitate("Order Date::timestamp + '1 year' ");
//		dataSourceCreatePage.calculationFieldDialog.clickOkBtn();
//		dataSourceCreatePage.checkIsRendered()
//				  .clickAgViewport();
//		pause(5);
//		//проверка в настройках добавленных полей
//		dataSourceCreatePage.settingsDialog.checkIsRendered()
//				  .checkFieldsInDialogByName("region_central", "ic_calculation", 5)
//				  .checkFieldsInDialogByName("OrderDate_Text", "ic_dimension", 5)
//				  .checkFieldsInDialogByName("OrderDate_timestamp", "ic_date_range", 5);
//		//проверка в таблице добавленных полей
//		dataSourceCreatePage.checkIsRendered()
//				  .clickAgViewport();
//		Assert.assertTrue(driver.getElement(By.xpath("//div[@row-index='0']//div[@col-id='17']")).getText().matches("1"));
////	Assert.assertTrue(driver.getElement(By.xpath("//div[@row-index='0']//div[@col-id='18']")).getText().matches("2012-03-09 19:00:00+03"));
////	Assert.assertTrue(driver.getElement(By.xpath("//div[@row-index='0']//div[@col-id='19']")).getText().matches("2013-03-09 22:00:00.0"));
//		dataSourceCreatePage.checkIsRendered()
//				  .clickSave()
//				  .clickbackBtn();
//	}
}
