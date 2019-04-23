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
	           .clickObjectInDialogByName("Slemma/slemma.com - STAG/slemma.com", "ic_google_analytics", 10);
	   driver.switchToMainWindow();
	   mainPage.checkObjectInDataTableByName("Slemma/slemma.com - STAG/slemma.com - STAG - MASTER",5)
			   .clickObjectInDataTableByName("Slemma/slemma.com - STAG/slemma.com - STAG - MASTER",5);
   }
}

