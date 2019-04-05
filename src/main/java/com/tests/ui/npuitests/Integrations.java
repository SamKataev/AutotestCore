package com.tests.ui.npuitests;

import org.testng.annotations.Test;

/**
 * Created by User on 03-Apr-19.
 */
public class Integrations extends NPWebTest {

    @Test
    public void CreateNewIntegrations(){
        mainPage.checkIsRendered();
        mainPage.clickAdminBtn();
        mainPage.openIntegrations()
                 .clickPlusBtn();
        mainPage.integrationsDropDown.checkIsRendered()
                .clickDatabaseBtn();
        mainPage.createDatabaseDialog.checkIsRendered()
                .ClickHerokuPostgresBtn();
    }
}
