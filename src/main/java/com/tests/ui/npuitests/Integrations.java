package com.tests.ui.npuitests;

import org.testng.annotations.Test;

public class Integrations extends NPWebTest
{

	@Test
	public void createHerokuIntegrations()
	{
		mainPage.checkIsRendered()
				  .clickdrawerToggleBtn();
		mainPage.clickAdminBtn()
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
				  .checkMessage("Success", 2)
				  .clickcloseBtn();
		mainPage.createIntegrationDialog.clickCreate();
	}

	@Test
	public void createPostgreSQLIntegrations()
	{
		mainPage.checkIsRendered()
				  .clickdrawerToggleBtn();
		mainPage.clickAdminBtn()
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
				  .checkMessage("Success", 2)
				  .clickcloseBtn();
		mainPage.createIntegrationDialog.clickCreate();
	}

	@Test
	public void createFreshdesk()
	{
		mainPage.checkIsRendered()
				  .clickdrawerToggleBtn();
		mainPage.clickAdminBtn()
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
		mainPage.checkObjectInDataTableByName("FreshDesk", 5)
				  .clickObjectInDataTableByName("FreshDesk", 5);
	}

	@Test
	public void createFreshsales()
	{
		mainPage.checkIsRendered()
				  .clickdrawerToggleBtn();
		mainPage.clickAdminBtn()
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
		mainPage.checkObjectInDataTableByName("FreshSales", 5)
				  .clickObjectInDataTableByName("FreshSales", 5);
	}

	@Test
	public void createSalesforce()
	{
		mainPage.checkIsRendered()
				  .clickdrawerToggleBtn();
		mainPage.clickAdminBtn()
				  .openIntegrations()
				  .clickPlusBtn();
		mainPage.integrationsDropDown.checkIsRendered()
				  .clickSaasBtn();
		mainPage.createSaasDialog.checkIsRendered()
				  .clickSalesforceBtn();
		//Salesforce
		mainPage.saaSParametersDialog.checkIsRendered()
				  .enterloginField("slemma.dev@gmail.com")
				  .enterpasswordField("r4e3W@Q!")
				  .entertokenField("18B4xSXqcDm2LhLDggptoRI9")
				  .clickOkBtn();
		mainPage.checkObjectInDataTableByName("Salesforce", 5)
				  .clickObjectInDataTableByName("Salesforce", 5);
	}

	@Test
	public void createQB()
	{
		mainPage.checkIsRendered()
				  .clickdrawerToggleBtn();
		mainPage.clickAdminBtn()
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
		mainPage.checkObjectInDataTableByName("QuickBooks", 5)
				  .clickObjectInDataTableByName("QuickBooks", 5);
	}

	//    @Test
//	в разработке
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
	public void createZendesk()
	{
		mainPage.checkIsRendered()
				  .clickdrawerToggleBtn();
		mainPage.clickAdminBtn()
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
		mainPage.checkObjectInDataTableByName("Zendesk (d3v-newpeople)", 5)
				  .clickObjectInDataTableByName("Zendesk (d3v-newpeople)", 5);
	}

	@Test
	public void createWrike()
	{
		mainPage.checkIsRendered()
				  .clickdrawerToggleBtn();
		mainPage.clickAdminBtn()
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
		mainPage.checkObjectInDataTableByName("Wrike Andrey Dobzhansky", 5)
				  .clickObjectInDataTableByName("Wrike Andrey Dobzhansky", 5);
	}

	@Test
	public void createInfusionsoft()
	{
		mainPage.checkIsRendered()
				  .clickdrawerToggleBtn();
		mainPage.clickAdminBtn()
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
				  .enterPassInput("q1w2E#R$6")
				  .clicklogInBtn()
				  .clickAllowBtn();
		driver.switchToMainWindow();
		mainPage.checkObjectInDataTableByName("Infusionsoft", 5)
				  .clickObjectInDataTableByName("Infusionsoft", 5);
	}

	@Test
	public void createJira()
	{
		mainPage.checkIsRendered()
				  .clickdrawerToggleBtn();
		mainPage.clickAdminBtn()
				  .openIntegrations()
				  .clickPlusBtn();
		mainPage.integrationsDropDown.checkIsRendered()
				  .clickSaasBtn();
		mainPage.createSaasDialog.checkIsRendered()
				  .clickjiraBtn();
		//jira
		mainPage.saaSParametersDialog.checkIsRendered()
				  .enterserverURLField("https://npeople.atlassian.net")
				  .enterloginField("matveeva.e")
				  .enterAPItokenField("BC7Vo4grSjMP7Xv9wJ8EFDEA")
				  .clickOkBtn();
		mainPage.checkObjectInDataTableByName("Jira (https://npeople.atlassian.net)", 5)
				  .clickObjectInDataTableByName("Jira (https://npeople.atlassian.net)", 5);
	}

	@Test
	public void createFacebook()
	{
		mainPage.checkIsRendered()
				  .clickdrawerToggleBtn();
		mainPage.clickAdminBtn()
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
		mainPage.checkObjectInDataTableByName("Facebook (Andrey)", 5)
				  .clickObjectInDataTableByName("Facebook (Andrey)", 5);
	}

	@Test
	public void createFacebookAds()
	{
		mainPage.checkIsRendered()
				  .clickdrawerToggleBtn();
		mainPage.clickAdminBtn()
				  .openIntegrations()
				  .clickPlusBtn();
		mainPage.integrationsDropDown.checkIsRendered()
				  .clickSaasBtn();
		mainPage.createSaasDialog.checkIsRendered()
				  .clickFacebookAdsBtn();
		//FacebookAds
		driver.switchWindow(1);
		facebookLogIn.checkIsRendered()
				  .enterEmailInput("developer@newpeople.co")
				  .enterPassInput("Qwerty12345")
				  .clickSignInBtn();
		driver.switchToMainWindow();
		mainPage.checkObjectInDataTableByName("Facebook Ads", 5)
				  .clickObjectInDataTableByName("Facebook Ads", 5);
	}

	@Test
	public void createInstagram()
	{
		mainPage.checkIsRendered()
				  .clickdrawerToggleBtn();
		mainPage.clickAdminBtn()
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
		mainPage.checkObjectInDataTableByName("Instagram", 5)
				  .clickObjectInDataTableByName("Instagram", 5);
	}

	@Test
	public void createPayPal()
	{
		mainPage.checkIsRendered()
				  .clickdrawerToggleBtn();
		mainPage.clickAdminBtn()
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
				  .clickNextBtn()
				  .enterPassInput("q1w2E#R$")
				  .clickSignInBtn();
		driver.switchToMainWindow();
		mainPage.checkObjectInDataTableByName("PayPal", 5)
				  .clickObjectInDataTableByName("PayPal", 5);
	}

	@Test
	public void createIntercom()
	{
		mainPage.checkIsRendered()
				  .clickdrawerToggleBtn();
		mainPage.clickAdminBtn()
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
				  .clickAuthorizeAccess();
		driver.switchToMainWindow();
		mainPage.checkObjectInDataTableByName("Intercom", 5)
				  .clickObjectInDataTableByName("Intercom", 5);
	}

	@Test
	public void createPipedrive()
	{
		mainPage.checkIsRendered()
				  .clickdrawerToggleBtn();
		mainPage.clickAdminBtn()
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
		mainPage.checkObjectInDataTableByName("New People", 5)
				  .clickObjectInDataTableByName("New People", 5);
	}

	//cloud//
	@Test
	public void createBox()
	{
		mainPage.checkIsRendered()
				  .clickdrawerToggleBtn();
		mainPage.clickSettingsBtn();
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
		mainPage.checkObjectInDialogByName("Box", 5)
				  .clickObjectInDialogByName("Box", 5);
	}

	@Test
	public void createDropbox()
	{
		mainPage.checkIsRendered()
				  .clickdrawerToggleBtn();
		mainPage.clickSettingsBtn();
		mainPage.userSettingsDialog.checkIsRendered()
				  .clickItemCloudStorage()
				  .clickaddIntegrationBtn();
		mainPage.createCloudIntegrationDialog.checkIsRendered()
				  .clickDropboxBtn();
		//Dropbox
		driver.switchWindow(1);
		dropboxLogIn.checkIsRendered()
				  .enteremailInput("a.kotomin@slemma.com")
				  .enterpassInput("Q123#@!w")
				  .clicksignInBtn()
				  .switchToWait()
				  .clickcontinueBtn()
				  .clickallowBtn();
		pause(5);
		driver.switchToMainWindow();
		mainPage.checkObjectInDialogByName("Dropbox", 20)
				  .clickObjectInDialogByName("Dropbox", 20);
	}

	@Test
	public void createGoogleDrive()
	{
		mainPage.checkIsRendered()
				  .clickdrawerToggleBtn();
		mainPage.clickSettingsBtn();
		mainPage.userSettingsDialog.checkIsRendered()
				  .clickItemCloudStorage()
				  .clickaddIntegrationBtn();
		mainPage.createCloudIntegrationDialog.checkIsRendered()
				  .clickGoogledriveBtn();
		//GoogleDrive
		driver.switchWindow(1);
		googleLogIn.checkIsRendered()
				  .enteremailInput("s.kataev@slemma.com")
				  .clicknextBtn()
				  .enterpasswordInput("Q123#@!w")
				  .clicknextPassBtn()
				  .clickadvancedBtn()
				  .clickgotoBtn()
				  .clickallowBtn();
//        pause(5);
		driver.switchToMainWindow();
		mainPage.checkObjectInDialogByName("Google Drive", 10)
				  .clickObjectInDialogByName("Google Drive", 5);
	}

	@Test
	public void createOneDrive()
	{
		mainPage.checkIsRendered()
				  .clickdrawerToggleBtn();
		mainPage.clickSettingsBtn();
		mainPage.userSettingsDialog.checkIsRendered()
				  .clickItemCloudStorage()
				  .clickaddIntegrationBtn();
		mainPage.createCloudIntegrationDialog.checkIsRendered()
				  .clickOnedriveBtn();
		driver.switchWindow(1);
		oneDriveLogIn.checkIsRendered()
				  .enterEmailInput("s.kataev@slemma.com")
				  .clickNextBtn()
				  .enterPassInput("Q123#@!w")
				  .clickNextBtn();
		driver.switchToMainWindow();
		mainPage.checkObjectInDialogByName("OneDrive", 5)
				  .clickObjectInDialogByName("OneDrive", 5);
	}

	@Test
	public void createYandexDisk()
	{
		mainPage.checkIsRendered()
				  .clickdrawerToggleBtn();
		mainPage.clickSettingsBtn();
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
		mainPage.checkObjectInDialogByName("Yandex Disk", 5)
				  .clickObjectInDialogByName("Yandex Disk", 5);
	}

	@Test
	public void createHubSpot()
	{
		mainPage.checkIsRendered()
				  .clickdrawerToggleBtn();
		mainPage.clickAdminBtn()
				  .openIntegrations()
				  .clickPlusBtn();
		mainPage.integrationsDropDown.checkIsRendered()
				  .clickSaasBtn();
		mainPage.createSaasDialog.checkIsRendered()
				  .clickHubspotBtn();
		//HubSpot
		driver.switchWindow(1);
		hubSpotLogIn.checkIsRendered()
				  .enterEmailInput("andrew@slemma.com")
				  .enterPassInput("Red_Herring123")
				  .clickLogInBtn()
				  .clickAccountChoose();
		driver.switchToMainWindow();
		mainPage.checkObjectInDataTableByName("Hubspot", 5)
				  .clickObjectInDataTableByName("Hubspot", 5);
	}

	@Test
	public void createMailchimp()
	{
		mainPage.checkIsRendered()
				  .clickdrawerToggleBtn();
		mainPage.clickAdminBtn()
				  .openIntegrations()
				  .clickPlusBtn();
		mainPage.integrationsDropDown.checkIsRendered()
				  .clickSaasBtn();
		mainPage.createSaasDialog.checkIsRendered()
				  .clickMailchimpBtn();
		//mailchimp
		driver.switchWindow(1);
		mailChimpLogIn.checkIsRendered()
				  .enterEmailInput("dobzhansky")
				  .enterPasswordInput("Zurbagan0!")
				  .clickLogIn();
		driver.switchToMainWindow();
		mainPage.checkObjectInDataTableByName("MailChimp (a.dobzhansky@slemma.com)", 5)
				  .clickObjectInDataTableByName("MailChimp (a.dobzhansky@slemma.com)", 5);
	}

//	@Test
//	public void createGoogleAds()
//			  //коннектор в разработке
//	{
//		mainPage.checkIsRendered()
//				  .clickdrawerToggleBtn();
//		mainPage.clickAdminBtn()
//				  .openIntegrations()
//				  .clickPlusBtn();
//		mainPage.integrationsDropDown.checkIsRendered()
//				  .clickSaasBtn();
//		mainPage.createSaasDialog.checkIsRendered()
//				  .clickgoogleAdsBtn();
//		//googleAds коннектор не работает
//		mainPage.saaSParametersDialog.checkIsRendered()
//				  .enterCustomerIDField("634-468-0664")
//				  .clickOkBtn();
//		driver.switchWindow(1);
//		googleLogIn.checkIsRendered()
//				  .enteremailInput("s.kataev@slemma.com")
//				  .clicknextBtn()
//				  .enterpasswordInput("Q123#@!w")
//				  .clicknextPassBtn()
//				  .clickallowBtn();
//		pause(5);
//		driver.switchToMainWindow();
//		mainPage.checkObjectInDataTableByName("GoogleAds", 10)
//				  .clickObjectInDataTableByName("GoogleAds", 5);
//	}
//
//	@Test
//	public void createGoogleAnalytics()
//	{
//		//коннектор в разработке
//		mainPage.checkIsRendered()
//				  .clickdrawerToggleBtn();
//		mainPage.clickAdminBtn()
//				  .openIntegrations()
//				  .clickPlusBtn();
//		mainPage.integrationsDropDown.checkIsRendered()
//				  .clickSaasBtn();
//		mainPage.createSaasDialog.checkIsRendered()
//				  .clickGoogleAnalyticsBtn();
//		//googleAnalytics
//		driver.switchWindow(1);
//		googleLogIn.checkIsRendered()
//				  .enteremailInput("s.kataev@slemma.com")
//				  .clicknextBtn()
//				  .enterpasswordInput("Q123#@!w")
//				  .clicknextPassBtn();
////        pause(5);
////        googleLogIn.clickPermissionBtn();
////        pause(5);
//		googleLogIn.clickallowBtn();
//		driver.switchToMainWindow();
//		mainPage.checkObjectInDataTableByName("Google Analytics - s.kataev@slemma.com", 5)
//				  .clickObjectInDataTableByName("Google Analytics - s.kataev@slemma.com", 5);
//	}
}