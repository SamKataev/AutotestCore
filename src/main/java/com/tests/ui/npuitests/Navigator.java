package com.tests.ui.npuitests;

import org.testng.annotations.Test;

public class Navigator extends NPWebTest {

    @Test
    public void goThroughNavigationMenu(){
        mainPage.openReports()
					 .openDatasources()
					 .openDelivery()
					 .openAlerts();
    }

}
