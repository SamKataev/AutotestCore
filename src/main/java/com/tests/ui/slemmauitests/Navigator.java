package com.tests.ui.slemmauitests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Navigator extends SlemmaWebTest {

    @Test
    public void goThroughNavigationMenu(){
        Assert.assertTrue(homePage.navigationPanel.openLibrary()
                && homePage.checkMenuSection("Library", "/home"));
        Assert.assertTrue(homePage.navigationPanel.openDasboards()
                && homePage.checkMenuSection("Dashboards", "/infographics"));
        Assert.assertTrue(homePage.navigationPanel.openReports()
                && homePage.checkMenuSection("Saved charts", "/reports"));
        Assert.assertTrue(homePage.navigationPanel.openPresentations()
                && homePage.checkMenuSection("Presentations", "/presentations"));
        Assert.assertTrue(homePage.navigationPanel.openDatasources()
                && homePage.checkMenuSection("Data sources", "/datasources"));
    }

}
