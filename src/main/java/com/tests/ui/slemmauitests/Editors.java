package com.tests.ui.slemmauitests;

import org.testng.annotations.Test;

public class Editors extends SlemmaWebTest {

    @Test
    public void renameDatasetField(){
        homePage.navigatorObjectsList.clickDashboardByName("fields rename test");
        dashboardPage.checkIsRendered()
                .switchEdit()
                .checkIsEditable()
                .clickChartByName("DB table fields rename")
                .clickChartCornerButton("DB table fields rename").checkIsRendered()
                .clickLayout().checkIsRendered()
                .checkFieldExist("alias before rename")
                .checkFieldExist("amount before rename")
                .clickDatasource()
                .clickEditDataset();
        datasourcePage.checkIsRendered()
                .clickField("alias before rename").checkIsRendered()
                .typeFieldName("alias after rename")
                .clickOK()
                .clickField("amount before rename").checkIsRendered()
                .typeFieldName("amount after rename")
                .clickOK()
                .clickDone();
        dashboardPage.checkIsRendered();
        driver.refreshPage();
        dashboardPage.checkIsRendered()
                .switchEdit()
                .checkIsEditable()
                .clickChartByName("DB table fields rename")
                .clickChartCornerButton("DB table fields rename")
                .checkIsRendered()
                .clickLayout().checkIsRendered()
                .checkFieldExist("alias after rename")
                .checkFieldExist("amount after rename")
                //restore initial test data
                .clickDatasource()
                .clickEditDataset();
        datasourcePage.checkIsRendered()
                .clickField("alias after rename").checkIsRendered()
                .typeFieldName("alias before rename")
                .clickOK()
                .clickField("amount after rename").checkIsRendered()
                .typeFieldName("amount before rename")
                .clickOK()
                .clickDone();
    }
}
