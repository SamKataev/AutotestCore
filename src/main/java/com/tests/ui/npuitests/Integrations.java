package com.tests.ui.npuitests;

import com.objects.npobjects.pageobjects.Main;
import com.objects.npobjects.pageobjects.oauthpages.ZendeskLogIn;
import org.testng.annotations.Test;

public class Integrations extends NPWebTest {

    @Test
    public void createHerokuIntegrations(){
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
    public void createPostgreSQLIntegrations(){
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
    public void createFreshdesk(){
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
    public void createFreshsales(){
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

//    @Test
//    public void createZendesk(){
//        mainPage.checkIsRendered()
//                .clickAdminBtn()
//                .openIntegrations()
//                .clickPlusBtn();
//        mainPage.integrationsDropDown.checkIsRendered()
//                .clickSaasBtn();
//        mainPage.createSaasDialog.checkIsRendered()
//                .clickzendeskBtn();
//        //zendesk
//        mainPage.saaSParametersDialog.checkIsRendered()
//                .enterserverURLField("https://d3v-newpeople.zendesk.com")
//                .clickOkBtn();
//        driver.switchWindow(1);
//        zendeskLogIn.checkIsRendered()
//                .enterEmailInput("developer@newpeople.co")
//                .enterPasswordInput("q1w2E#R$")
//                .clickSignInBtn();
//        driver.switchToMainWindow();
//        mainPage.checkObjectInDataTableByName("Zendesk",5)
//                .clickObjectInDataTableByName("Zendesk",5);
//    }

    @Test
    public void createJira(){
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
    public void createFacebook(){
        mainPage.checkIsRendered()
                .clickAdminBtn()
                .openIntegrations()
                .clickPlusBtn();
        mainPage.integrationsDropDown.checkIsRendered()
                .clickSaasBtn();
        mainPage.createSaasDialog.checkIsRendered()
                .clickFacebookBtn();
        //Facebook
        driver.switchWindow(1);
        facebookLogIn.checkIsRendered()
                .enterEmailInput("developer@newpeople.co")
                .enterPassInput("Qwerty12345")
                .clickSignInBtn()
                .clickconfirmBtn()
                .clickconfirmBtn()
                .clickconfirmBtn()
                .clickconfirmBtn();
                driver.switchToMainWindow();
        mainPage.checkObjectInDataTableByName("Facebook (Andrey)",5)
                .clickObjectInDataTableByName("Facebook (Andrey)",5);
    }

    @Test
    public void createInstagram(){
        mainPage.checkIsRendered()
                .clickAdminBtn()
                .openIntegrations()
                .clickPlusBtn();
        mainPage.integrationsDropDown.checkIsRendered()
                .clickSaasBtn();
        mainPage.createSaasDialog.checkIsRendered()
                .clickinstagramBtn();
        //Instagram
        driver.switchWindow(1);
        instagramLogIn.checkIsRendered()
                .enterEmailInput("Andrey@newpeople.co")
                .enterPassInput("q1w2E#R$")
//              .clickcheckboxBtn()
                .clickSignInBtn();
        driver.switchToMainWindow();
        mainPage.checkObjectInDataTableByName("Instagram",5)
                .clickObjectInDataTableByName("Instagram",5);
    }

    @Test
    public void createPayPal(){
        mainPage.checkIsRendered()
                .clickAdminBtn()
                .openIntegrations()
                .clickPlusBtn();
        mainPage.integrationsDropDown.checkIsRendered()
                .clickSaasBtn();
        mainPage.createSaasDialog.checkIsRendered()
                .clickpaypalBtn();
        //paypal
        driver.switchWindow(1);
        payPalLogIn.checkIsRendered();
        pause(5);
        payPalLogIn.enterEmailInput("developer@newpeople.co")
                .enterPassInput("q1w2E#R$")
                .clickSignInBtn();
       driver.switchToMainWindow();
        mainPage.checkObjectInDataTableByName("PayPal",5)
                .clickObjectInDataTableByName("PayPal",5);
    }

    @Test
    public void createIntercom(){
        mainPage.checkIsRendered()
                .clickAdminBtn()
                .openIntegrations()
                .clickPlusBtn();
        mainPage.integrationsDropDown.checkIsRendered()
                .clickSaasBtn();
        mainPage.createSaasDialog.checkIsRendered()
                .clickintercomBtn();
        driver.switchWindow(1);
        //intercom
        intercomLogIn.checkIsRendered();
        pause(5);
        intercomLogIn.enterEmailInput("developer@newpeople.co")
                .enterPasswordInput("q1w2E#R$")
                .clickSignInBtn()
                .clickAuthorizeAccessn();
        driver.switchToMainWindow();
        mainPage.checkObjectInDataTableByName("Intercom",5)
                .clickObjectInDataTableByName("Intercom",5);
    }

    @Test
    public void createPipedrive(){
        mainPage.checkIsRendered()
                .clickAdminBtn()
                .openIntegrations()
                .clickPlusBtn();
        mainPage.integrationsDropDown.checkIsRendered()
                .clickSaasBtn();
        mainPage.createSaasDialog.checkIsRendered()
                .clickPipedriveBtn();
        //pipedrive
        driver.switchWindow(1);
        pipedriveLogIn.checkIsRendered()
                .enterEmailInput("Andrey@newpeople.co")
                .enterPasswordInput("Qwerty12345")
                .clickSignInBtn()
                .clickcontinueBtn();
        driver.switchToMainWindow();
        mainPage.checkObjectInDataTableByName("New People",5)
                .clickObjectInDataTableByName("New People",5);
    }

}
