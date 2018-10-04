package com.tests.ui.slemmauitests;

import org.testng.annotations.Test;

public class Editors extends SlemmaWebTest {

    @Test
    public void renameDatasetField(){
        homePage.navigatorObjectsList.clickDashboardByName("fields rename test");
    }
}
