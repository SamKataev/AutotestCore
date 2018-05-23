package com.tests.ui.slemmauitests;

import com.objects.slemmaobjects.pageobjects.AuthPage;
import com.objects.slemmaobjects.pageobjects.HomePage;
import com.service.TestProperties;
import com.tests.ui.WebTest;
import org.testng.annotations.BeforeClass;

public class SlemmaWebTest extends WebTest {

    HomePage homePage;
    AuthPage authPage;

    @BeforeClass
    public void startSlemmaTestClass(){
        openHomePage();  //each test class starts from home page if not overridden
    }

    @Override
    protected void initPages() {
        homePage = new HomePage(driver);
        authPage = new AuthPage(driver);
    }

    protected boolean openHomePage(){
        return homePage.isOpened() || logIn();
    }

    protected boolean logIn(){
        authPage.open();
        authPage.logIn(TestProperties.getProp("email"), TestProperties.getProp("password"));
        return homePage.isOpened();
    }

}
