package com.tests.ui.npuitests;

import com.objects.npobjects.pageobjects.*;
import com.service.TestProperties;
import com.tests.ui.WebTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public abstract class NPWebTest extends WebTest {

    Auth authPage;
	 Main mainPage;

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