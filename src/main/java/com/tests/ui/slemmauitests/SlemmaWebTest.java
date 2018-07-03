package com.tests.ui.slemmauitests;

import com.objects.slemmaobjects.pageobjects.*;
import com.service.TestProperties;
import com.tests.ui.WebTest;
import org.testng.annotations.BeforeClass;

public class SlemmaWebTest extends WebTest {

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

    protected boolean openHomePage(){
        return homePage.isRendered() || logIn();
    }

    protected boolean logIn(){
        authPage.open();
        authPage.logIn(TestProperties.getProp("email"), TestProperties.getProp("password"));
        return homePage.isRendered();
    }

}
