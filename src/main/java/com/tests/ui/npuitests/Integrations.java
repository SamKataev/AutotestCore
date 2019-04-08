package com.tests.ui.npuitests;

import org.testng.annotations.Test;

/**
 * Created by User on 03-Apr-19.
 */
public class Integrations extends NPWebTest {

    @Test
    public void CreateNewIntegrations(){
        mainPage.checkIsRendered()
                .clickAdminBtn()
                .openIntegrations()
                .clickPlusBtn();
        mainPage.integrationsDropDown.checkIsRendered()
                .clickDatabaseBtn();
        mainPage.createDatabaseDialog.checkIsRendered()
                .сlickHerokuPostgresBtn();
        mainPage.createIntegrationDialog.checkIsRendered()
                //heroku
                .integrationIn("ec2-54-235-151-252.compute-1.amazonaws.com","dc3qukco027qjj","dxhfuxbpnspyrj", "ctrD2qQOwwDU5MfvLdSSYRzhtE");
        mainPage.createIntegrationDialog.сlickGeneral()
                .clickCheck();
        mainPage.messageDialog.checkIsRendered()
                .clickcloseBtn();
        mainPage.createIntegrationDialog.clickCreate();

    }
}
