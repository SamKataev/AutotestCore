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
        //PostgreSQL
        mainPage.createIntegrationDialog.checkIsRendered()
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
        //Freshdesk
        mainPage.saaSParametersDialog.checkIsRendered()
                .enterDomain("https://slemma.freshdesk.com")
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
        //Freshsales
        mainPage.saaSParametersDialog.checkIsRendered()
                .enterDomain("https://slemma.freshsales.io/")
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
        //zendesk
        mainPage.saaSParametersDialog.checkIsRendered()
                .enterserverURLField("https://d3v-newpeople.zendesk.com")
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
        //jira
        mainPage.saaSParametersDialog.checkIsRendered()
                .enterserverURLField ("https://npeople.atlassian.net")
                .enterloginField("matveeva.e")
                .enterpasswordField("Matveeva0414")
                .clickOkBtn();
    }
    @Test
    public void CreateFacebook(){
        mainPage.checkIsRendered()
                .clickAdminBtn()
                .openIntegrations()
                .clickPlusBtn();
        mainPage.integrationsDropDown.checkIsRendered()
                .clickSaasBtn();
        mainPage.createSaasDialog.checkIsRendered()
                .clickFacebookBtn();
        //Facebook
        driver.switchWindow();
        facebookLogIn.checkIsRendered()
                .enterEmailInput("developer@newpeople.co")
                .enterPassInput("Qwerty12345")
                .clickSignInBtn()
                .clickconfirmBtn()
                .clickconfirmBtn();
        driver.switchToMainWindow();
    }

    @Test
    public void CreateInstagram(){
        mainPage.checkIsRendered()
                .clickAdminBtn()
                .openIntegrations()
                .clickPlusBtn();
        mainPage.integrationsDropDown.checkIsRendered()
                .clickSaasBtn();
        mainPage.createSaasDialog.checkIsRendered()
                .clickinstagramBtn();
        //Instagram
        driver.switchWindow();
        instagramLogIn.checkIsRendered()
                .enterEmailInput("Andrey@newpeople.co")
                .enterPassInput("q1w2E#R$")
                .clickcheckboxBtn()
                .clickSignInBtn();
        driver.switchToMainWindow();
    }
    @Test
    public void CreatePayPal(){
        mainPage.checkIsRendered()
                .clickAdminBtn()
                .openIntegrations()
                .clickPlusBtn();
        mainPage.integrationsDropDown.checkIsRendered()
                .clickSaasBtn();
        mainPage.createSaasDialog.checkIsRendered()
                .clickpaypalBtn();
        //paypal
        driver.switchWindow();
        payPalLogIn.checkIsRendered()
                .enterEmailInput("developer@newpeople.co")
                .enterPassInput("q1w2E#R$")
                .clickSignInBtn();
        driver.switchToMainWindow();
    }
}
