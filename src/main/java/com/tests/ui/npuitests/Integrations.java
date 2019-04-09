package com.tests.ui.npuitests;

import org.testng.annotations.Test;

/**
 * Created by User on 03-Apr-19.
 */
public class Integrations extends NPWebTest {

    @Test
    public void CreateHerokuIntegrations(){
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
                .enterHost("ec2-54-235-151-252.compute-1.amazonaws.com")
                .enterDataBaseName("dc3qukco027qjj")
                .enterUsername("dxhfuxbpnspyrj")
                .enterPassword("ctrD2qQOwwDU5MfvLdSSYRzhtE")
                //для того чтобы убрать фокус с поля
                .сlickGeneral()
                .clickCheck();
        mainPage.messageDialog.checkIsRendered()
                .clickcloseBtn();
        mainPage.createIntegrationDialog.clickCreate();
    }

    @Test
    public void CreatePostgreSQLIntegrations(){
        mainPage.checkIsRendered()
                .clickAdminBtn()
                .openIntegrations()
                .clickPlusBtn();
        mainPage.integrationsDropDown.checkIsRendered()
                .clickDatabaseBtn();
        mainPage.createDatabaseDialog.checkIsRendered()
                .clickPostgreSQLBtn();
        mainPage.createIntegrationDialog.checkIsRendered()
                //PostgreSQL
                .enterHost("77.247.243.161")
                .enterDataBaseName("log")
                .enterUsername("slemma")
                .enterPassword("slemma")
                .сlickGeneral()
                .clickCheck();
        mainPage.messageDialog.checkIsRendered()
                .clickcloseBtn();
        mainPage.createIntegrationDialog.clickCreate();
    }

    @Test
    public void CreateFreshdesk(){
        mainPage.checkIsRendered()
                .clickAdminBtn()
                .openIntegrations()
                .clickPlusBtn();
        mainPage.integrationsDropDown.checkIsRendered()
                .clickSaasBtn();
        mainPage.createSaasDialog.checkIsRendered()
                .clickfreshdeskBtn();
        mainPage.saaSParametersDialog.checkIsRendered();
                //Freshdesk
        mainPage.saaSParametersDialog.enterDomain("https://slemma.freshdesk.com")
                .enterAPI("9xmgaF4hddDHrOw2ay6e")
                .clickOkBtn();
    }

    @Test
    public void CreateFreshsales(){
        mainPage.checkIsRendered()
                .clickAdminBtn()
                .openIntegrations()
                .clickPlusBtn();
        mainPage.integrationsDropDown.checkIsRendered()
                .clickSaasBtn();
        mainPage.createSaasDialog.checkIsRendered()
                .clickfreshsalesBtn();
        mainPage.saaSParametersDialog.checkIsRendered();
        //Freshsales
        mainPage.saaSParametersDialog.enterDomain("https://slemma.freshsales.io/")
                .enterAPI("ne3XTHy_Zu438e0ZN9s7OA")
                .clickOkBtn();
    }

    @Test
    public void CreateZendesk(){
        mainPage.checkIsRendered()
                .clickAdminBtn()
                .openIntegrations()
                .clickPlusBtn();
        mainPage.integrationsDropDown.checkIsRendered()
                .clickSaasBtn();
        mainPage.createSaasDialog.checkIsRendered()
                .clickzendeskBtn();
        mainPage.saaSParametersDialog.checkIsRendered();
        //zendesk
        mainPage.saaSParametersDialog.enterserverURLField("https://d3v-newpeople.zendesk.com")
                .clickOkBtn();
    }

    @Test
    public void CreateJira(){
        mainPage.checkIsRendered()
                .clickAdminBtn()
                .openIntegrations()
                .clickPlusBtn();
        mainPage.integrationsDropDown.checkIsRendered()
                .clickSaasBtn();
        mainPage.createSaasDialog.checkIsRendered()
                .clickjiraBtn();
        mainPage.saaSParametersDialog.checkIsRendered();
        //jira
        mainPage.saaSParametersDialog.enterserverURLField ("https://npeople.atlassian.net")
                .enterloginField("matveeva.e")
                .enterpasswordField("Matveeva0414")
                .clickOkBtn();
    }


}
