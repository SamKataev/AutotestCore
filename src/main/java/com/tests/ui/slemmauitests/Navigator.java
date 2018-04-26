package com.tests.ui.slemmauitests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Navigator extends SlemmaWebTest {

    @Test
    public void goThroughNavigationMenu(){
        Assert.assertTrue(homePage.isOpened());
        Assert.assertTrue(homePage.navigationPanel.openLibrary() && homePage.checkPageMode("Library"));
        Assert.assertTrue(homePage.navigationPanel.openDasboards() && homePage.checkPageMode("Dashboards"));
        Assert.assertTrue(homePage.navigationPanel.openReports() && homePage.checkPageMode("Saved charts"));
        Assert.assertTrue(homePage.navigationPanel.openPresentations() && homePage.checkPageMode("Presentations"));
        Assert.assertTrue(homePage.navigationPanel.openDatasources() && homePage.checkPageMode("Data sources"));
    }

}
