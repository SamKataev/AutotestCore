package com.tests.ui.slemmauitests;

import com.objects.slemmaobjects.pageobjects.*;
import com.service.TestProperties;
import com.tests.ui.WebTest;
import org.testng.annotations.BeforeClass;

public abstract class SlemmaWebTest extends WebTest {

    Home homePage;
    Auth authPage;
    SamlAuth samlAuthPage;
    Dashboard dashboardPage;
    Presentation presentationPage;
    Register registerPage;

    /**
     * each test class starts from home page if not overridden
     */
    @BeforeClass
    public void startSlemmaTestClass(){
        openHomePage();
    }

    @Override
    protected void initPages() {
        homePage = new Home(driver);
        authPage = new Auth(driver);
        samlAuthPage = new SamlAuth(driver);
        dashboardPage = new Dashboard(driver);
        presentationPage = new Presentation(driver);
        registerPage = new Register(driver);
    }

    protected void openHomePage(){
        driver.goToUrl(driver.getBaseUrl()+"/home");
        if (!driver.getCurrentUrl().equals(driver.getBaseUrl()+"/home")) {
            logIn();
        }
    }

    protected void logIn(){
        authPage.open();
        authPage.logIn(TestProperties.getProp("email"), TestProperties.getProp("password"));
        changeTeam(TestProperties.getProp("team"));
    }

    protected void changeTeam(String name){
        homePage.checkIsRendered();
        homePage.clickAccountBtn()
                .selectTeam(name);
    }

}
