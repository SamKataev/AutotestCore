package com.tests.ui.npuitests;

import org.testng.annotations.Test;

public class Datasources extends NPWebTest {

	@Test
	public void uploadFileByUrl(){
		mainPage.checkIsRendered()
				  .openDatasources()
				  .clickPlusBtn();
		mainPage.selectDatasourceTypeDialog.checkIsRendered()
				  .clickFileByUrl();
		mainPage.fileByUrlDialog.checkIsRendered()
				  .typeUrl("https://www.dropbox.com/s/733wh1uh4ukk7xt/For%20charts.csv?dl=1")
				  .clickOk();
		datasourceCreatePage.checkIsRendered()
				  .clickSave();
	}
   @Test
    public void datasetGoogleAnalytics(){
	   mainPage.checkIsRendered()
			   .openDatasources()
			   .clickPlusBtn();
	   mainPage.selectDatasourceTypeDialog.checkIsRendered()
               .clickIntegration("Google Analytics");
	   mainPage.selectDatasetDialog.checkIsRendered()
			   .checkDialogTitle("Select dataset")
	           .clickBasedInDialogByName("Slemma/slemma.com - STAG/slemma.com", "ic_google_analytics", 10);
	   driver.switchToMainWindow();
	   mainPage.checkObjectInDataTableByName("Slemma/slemma.com - STAG/slemma.com - STAG - MASTER",5)
			   .clickObjectInDataTableByName("Slemma/slemma.com - STAG/slemma.com - STAG - MASTER",5);
   }
	@Test
	public void datasetZendesk(){
		mainPage.checkIsRendered()
				.openDatasources()
				.clickPlusBtn();
		mainPage.selectDatasourceTypeDialog.checkIsRendered()
				.clickIntegration("Zendesk");
		mainPage.selectDatasetDialog.checkIsRendered()
				.checkDialogTitle("Select dataset")
				.clickBasedInDialogByName("Users", "ic_zendesk", 20);
//        pause(5);
		mainPage.checkObjectInDataTableByName("Users",15)
				.clickObjectInDataTableByName("Users",15);
	}
		@Test
	public void datasetMailChimp(){
		mainPage.checkIsRendered()
				.openDatasources()
				.clickPlusBtn();
		mainPage.selectDatasourceTypeDialog.checkIsRendered()
				.clickIntegration("MailChimp");
		mainPage.selectDatasetDialog.checkIsRendered()
				.checkDialogTitle("Select dataset")
				.clickBasedInDialogByName("Campaigns", "ic_mailchimp", 20);
//        pause(5);
		mainPage.checkObjectInDataTableByName("Campaigns",15)
				.clickObjectInDataTableByName("Campaigns",15);
	}
	@Test
	public void datasetHubspot(){
		mainPage.checkIsRendered()
				.openDatasources()
				.clickPlusBtn();
		mainPage.selectDatasourceTypeDialog.checkIsRendered()
				.clickIntegration("Hubspot");
		mainPage.selectDatasetDialog.checkIsRendered()
	            .checkDialogTitle("Select dataset")
				.clickBasedInDialogByName("Deals", "ic_hubspot", 20);
//        pause(5);
		mainPage.checkObjectInDataTableByName("Deals",15)
				.clickObjectInDataTableByName("Deals",15);
	}
	@Test
	public void datasetDropbox(){
		mainPage.checkIsRendered()
				.openDatasources()
				.clickPlusBtn();
		mainPage.selectDatasourceTypeDialog.checkIsRendered()
				.clickIntegration("Dropbox");
		mainPage.selectDatasetDialog.checkIsRendered()
				.checkDialogTitle("Dropbox");
        pause(5);
		mainPage.selectDatasetDialog.clickFileInDialogByName("Testslemma.xls", "ic_file", 20);
		datasourceCreatePage.checkIsRendered()
				  .clickSave();
		mainPage.checkObjectInDataTableByName("Testslemma",15)
				.clickObjectInDataTableByName("Testslemma",15);
	}
	@Test
	public void datasetFreshSales(){
		mainPage.checkIsRendered()
				.openDatasources()
				.clickPlusBtn();
		mainPage.selectDatasourceTypeDialog.checkIsRendered()
				.clickIntegration("FreshSales");
		mainPage.selectDatasetDialog.checkIsRendered()
	            .checkDialogTitle("Select dataset")
				.clickBasedInDialogByName("Deals", "ic_freshsales", 20);
		mainPage.checkObjectInDataTableByName("Deals",15)
				.clickObjectInDataTableByName("Deals",15);
	}
	@Test
	public void datasetFreshDesk(){
		mainPage.checkIsRendered()
				.openDatasources()
				.clickPlusBtn();
		mainPage.selectDatasourceTypeDialog.checkIsRendered()
				.clickIntegration("FreshDesk");
		mainPage.selectDatasetDialog.checkIsRendered()
				.checkDialogTitle("Select dataset")
				.clickBasedInDialogByName("Tickets", "ic_freshdesk", 20);
		mainPage.checkObjectInDataTableByName("Tickets",15)
				.clickObjectInDataTableByName("Tickets",15);
	}
	@Test
	public void datasetFacebook(){
		mainPage.checkIsRendered()
				.openDatasources()
				.clickPlusBtn();
		mainPage.selectDatasourceTypeDialog.checkIsRendered()
				.clickIntegration("Facebook");
		mainPage.selectDatasetDialog.checkIsRendered()
				.checkDialogTitle("Select dataset")
				.clickBasedInDialogByName("Posts Stats Lifetime", "ic_facebook", 20);
		mainPage.checkObjectInDataTableByName("Posts Stats Lifetime",15)
				.clickObjectInDataTableByName("Posts Stats Lifetime",15);
	}
	@Test
	public void datasetHerokuPostgreSQL(){
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
		mainPage.checkObjectInDataTableByName("HerokuQuery",15)
				.clickObjectInDataTableByName("HerokuQuery",15);
	}
}

