package com.tests.ui.npuitests;

import com.objects.npobjects.pageobjects.*;
import com.objects.npobjects.pageobjects.oauthpages.*;
import com.service.TestProperties;
import com.tests.ui.WebTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public abstract class NPWebTest extends WebTest {

	Auth authPage;
	Main mainPage;
	DatasourceCreate datasourceCreatePage;
	FacebookLogIn facebookLogIn;
	InstagramLogIn instagramLogIn;
	PayPalLogIn payPalLogIn;
	IntercomLogIn intercomLogIn;
	PipedriveLogIn pipedriveLogIn;
	ZendeskLogIn zendeskLogIn;
    WrikeLogIn wrikeLogIn;
	InfusionsoftLogIn infusionsoftLogIn;
	StripeLogIn stripeLogIn;
	QuickbooksLogIn quickbooksLogIn;

	/**
	 * each test class starts from reports page if not overridden
	 */
	@BeforeClass
	public void startNPTestClass(){
		openReportsPage();
	}

	/**
	 * each test method starts from reports page if not overridden
	 */
	@BeforeMethod
	public void startNPTestMethod(){
		openReportsPage();
	}

	@Override
	protected void initPages() {
		authPage = new Auth(driver);
		mainPage = new Main(driver);
		datasourceCreatePage = new DatasourceCreate(driver);
		facebookLogIn = new FacebookLogIn(driver);
		instagramLogIn = new InstagramLogIn(driver);
		payPalLogIn = new PayPalLogIn(driver);
		intercomLogIn=new IntercomLogIn(driver);
		pipedriveLogIn=new PipedriveLogIn(driver);
		zendeskLogIn = new ZendeskLogIn(driver);
        wrikeLogIn = new WrikeLogIn(driver);
		infusionsoftLogIn = new InfusionsoftLogIn(driver);
		stripeLogIn = new StripeLogIn(driver);
		quickbooksLogIn = new QuickbooksLogIn(driver);
	}

	protected void openHomePage(){
	  driver.goToUrl(driver.getBaseUrl()+"/home");
	}

	protected void openReportsPage(){
		driver.goToUrl(driver.getBaseUrl()+"/reports");
		if (!driver.getCurrentUrl().equals(driver.getBaseUrl()+"/reports")) {
			logIn();
		}
	}

	protected void logIn(){
		authPage.open();
		authPage.logIn(TestProperties.getNPProp("email"), TestProperties.getNPProp("password"));
		mainPage.checkIsLoggedIn();
		changeTeam(TestProperties.getNPProp("team"));
	}

	protected void changeTeam(String name){
		mainPage.checkIsRendered();
		mainPage.selectTeam(name);
	}

}
