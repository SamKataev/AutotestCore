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
    @Test
    public void createSalesforce(){
        mainPage.checkIsRendered()
                .clickAdminBtn()
                .openIntegrations()
                .clickPlusBtn();
        mainPage.integrationsDropDown.checkIsRendered()
                .clickSaasBtn();
        mainPage.createSaasDialog.checkIsRendered()
                .clickSalesforceBtn();
        //Salesforce
        mainPage.saaSParametersDialog.checkIsRendered()
                .enterloginField("slemma.dev@gmail.com")
                .enterpasswordField("Q!W@e3r4")
                .entertokenField("7erMm0tOS8bxJU4xeKLKJmzM9")
                .clickOkBtn();
    }
        @Test
    public void createQB(){
        mainPage.checkIsRendered()
                .clickAdminBtn()
                .openIntegrations()
                .clickPlusBtn();
        mainPage.integrationsDropDown.checkIsRendered()
                .clickSaasBtn();
        mainPage.createSaasDialog.checkIsRendered()
                .clickQuickbooksBtn();
        //QB
        driver.switchWindow(1);
        quickbooksLogIn.checkIsRendered()
                .enterEmailInput("developer@newpeople.co")
                .enterPassInput("q1w2E#R$")
                .clickSignInBt()
                .clickconnectBtn();
        driver.switchToMainWindow();
        mainPage.checkObjectInDataTableByName("QuickBooks",5)
                .clickObjectInDataTableByName("QuickBooks",5);
    }
//    @Test
//    public void createStripe(){
//        mainPage.checkIsRendered()
//                .clickAdminBtn()
//                .openIntegrations()
//                .clickPlusBtn();
//        mainPage.integrationsDropDown.checkIsRendered()
//                .clickSaasBtn();
//        mainPage.createSaasDialog.checkIsRendered()
//                .clickStripeBtn();
//        //Stripe коннектор в разработке
//        driver.switchWindow(1);
//        stripeLogIn.checkIsRendered()
//                .clicksignInStripeBtn()
//                .enterEmailInput("developer@newpeople.co")
//                .enterPassInput("q1w2E#R$")
//                .clicksignInStripeAccountBtn();
//        driver.switchToMainWindow();
//        mainPage.checkObjectInDataTableByName("Stripe",5)
//                .clickObjectInDataTableByName("Stripe",5);
//    }

    @Test
    public void createZendesk(){
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
        driver.switchWindow(2);
        zendeskLogIn.switchToIFrame()
                .checkIsRendered()
                .enterEmailInput("developer@newpeople.co")
                .enterPasswordInput("q1w2E#R$")
                .clickSignInBtn();
        driver.switchToMainWindow();
        mainPage.checkObjectInDataTableByName("Zendesk",5)
                .clickObjectInDataTableByName("Zendesk",5);
    }

    @Test
    public void createWrike(){
        mainPage.checkIsRendered()
                .clickAdminBtn()
                .openIntegrations()
                .clickPlusBtn();
        mainPage.integrationsDropDown.checkIsRendered()
                .clickSaasBtn();
        mainPage.createSaasDialog.checkIsRendered()
                .clickWrikeBtn();
        //wrike
        driver.switchWindow(1);
        wrikeLogIn.checkIsRendered()
                .enterEmailInput("developer@newpeople.co")
                .clickNextButton()
                .enterPassInput("q1w2E#R$")
                .clickNextButton();
//                .clickForgetInput();
        driver.switchToMainWindow();
        mainPage.checkObjectInDataTableByName("Wrike Andrey Dobzhansky",5)
                .clickObjectInDataTableByName("Wrike Andrey Dobzhansky",5);
    }
    @Test
    public void createInfusionsoft(){
        mainPage.checkIsRendered()
                .clickAdminBtn()
                .openIntegrations()
                .clickPlusBtn();
        mainPage.integrationsDropDown.checkIsRendered()
                .clickSaasBtn();
        mainPage.createSaasDialog.checkIsRendered()
                .clickInfusionsoftBtn();
        //Infusionsoft
        driver.switchWindow(1);
        infusionsoftLogIn.checkIsRendered()
                .enterEmailInput("developer@newpeople.co")
                .enterPassInput("q1w2E#R$")
                .clicklogInBtn()
                .clickAllowBtn();
        driver.switchToMainWindow();
        mainPage.checkObjectInDataTableByName("Infusionsoft",5)
                .clickObjectInDataTableByName("Infusionsoft",5);
    }
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
    //cloud//
    @Test
    public void createBox(){
        mainPage.checkIsRendered()
                .clickSettingsBtn();
        mainPage.userSettingsDialog.checkIsRendered()
                .clickItemCloudStorage()
                .clickaddIntegrationBtn();
        mainPage.createCloudIntegrationDialog.checkIsRendered()
                .clickBoxBtn();
        //Box
        driver.switchWindow(1);
        boxLogIn.checkIsRendered()
                .enterloginInput("a.kotomin@slemma.com")
                .enterpassInput("123654")
                .clickauthorizeBtn()
                .clickaccessBtn();
        driver.switchToMainWindow();
        mainPage.checkObjectInDialogByName("Box",5)
                .clickObjectInDialogByName("Box",5);
    }
    @Test
    public void createDropbox(){
        mainPage.checkIsRendered()
                .clickSettingsBtn();
        mainPage.userSettingsDialog.checkIsRendered()
                .clickItemCloudStorage()
                .clickaddIntegrationBtn();
        mainPage.createCloudIntegrationDialog.checkIsRendered()
                .clickDropboxBtn();
        //Dropbox
        driver.switchWindow(1);
        dropboxLogIn.checkIsRendered()
                .enteremailInput("developer@newpeople.co")
                .enterpassInput("q1w2E#R$")
                .clicksignInBtn()
                .clickcontinueBtn();
        pause(5);
        dropboxLogIn.clickallowBtn();
        pause(5);
        driver.switchToMainWindow();
        mainPage.checkObjectInDialogByName("Dropbox",20)
                .clickObjectInDialogByName("Dropbox",5);
    }
    @Test
    public void createGoogleDrive(){
        mainPage.checkIsRendered()
                .clickSettingsBtn();
        mainPage.userSettingsDialog.checkIsRendered()
                .clickItemCloudStorage()
                .clickaddIntegrationBtn();
        mainPage.createCloudIntegrationDialog.checkIsRendered()
                .clickGoogledriveBtn();
        //GoogleDrive
        driver.switchWindow(1);
        googleDriveLogIn.checkIsRendered()
                .enteremailInput("s.kataev@slemma.com")
                .clicknextBtn()
                .enterpasswordInput("Q123#@!w")
                .clicknextPassBtn()
                .clickadvancedBtn()
                .clickgotoBtn()
                .clickallowBtn();
        pause(5);
        driver.switchToMainWindow();
        mainPage.checkObjectInDialogByName("Google Drive",10)
                .clickObjectInDialogByName("Google Drive",5);
    }
    @Test
    public void createOneDrive(){
        mainPage.checkIsRendered()
                .clickSettingsBtn();
        mainPage.userSettingsDialog.checkIsRendered()
                .clickItemCloudStorage()
                .clickaddIntegrationBtn();
        mainPage.createCloudIntegrationDialog.checkIsRendered()
                .clickOnedriveBtn();
        driver.switchWindow(1);
        oneDriveLogIn.checkIsRendered()
                .enterEmailInput("s.kataev@slemma.com")
                .clickNextBtn()
                .clickPersonalAccount()
                .enterPassInput("Q123#@!w")
                .clickNextBtn();
        driver.switchToMainWindow();
        mainPage.checkObjectInDialogByName("OneDrive",5)
                .clickObjectInDialogByName("OneDrive",5);
    }
        @Test
    public void createYandexDisk(){
        mainPage.checkIsRendered()
                .clickSettingsBtn();
        mainPage.userSettingsDialog.checkIsRendered()
                .clickItemCloudStorage()
                .clickaddIntegrationBtn();
        mainPage.createCloudIntegrationDialog.checkIsRendered()
                .clickYandexdiskBtn();
        driver.switchWindow(1);
        //yandex disk
        yandexDiskLogIn.checkIsRendered()
                .enterEmailInput("e.matveevaslemma.com")
                .clicklogInBtn()
                .enterPassInput("Matveeva0414")
                .clicklogInBtn()
                .clickallowBtn();
        driver.switchToMainWindow();
        pause(5);
        mainPage.checkObjectInDialogByName("Yandex Disk",5)
                .clickObjectInDialogByName("Yandex Disk",5);
    }
}
