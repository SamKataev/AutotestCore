package com.tests.ui.slemmauitests;

import org.testng.annotations.Test;

public class Navigator extends SlemmaWebTest {

    @Test
    public void goThroughNavigationMenu(){
        homePage.navigationPanel.openLibrary();
        homePage.checkPageMode("Library");
        homePage.navigationPanel.openDasboards();
        homePage.checkPageMode("Dashboards");
        homePage.navigationPanel.openReports();
        homePage.checkPageMode("Saved charts");
        homePage.navigationPanel.openPresentations();
        homePage.checkPageMode("Presentations");
        homePage.navigationPanel.openDatasources();
        homePage.checkPageMode("Data sources");
    }

}
