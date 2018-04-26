package com.tests.ui.slemmauitests;

import com.objects.slemmaobjects.pageobjects.AuthPage;
import com.objects.slemmaobjects.pageobjects.HomePage;
import com.service.TestProperties;
import com.tests.ui.WebTest;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;

public class SlemmaWebTest extends WebTest {

    public HomePage homePage;
    public AuthPage authPage;

    @BeforeClass
    public void setStartPage(){
        Assert.assertTrue(openHomePage().isOpened());  //each test class starts from home page if not overridden
    }

    @Override
    protected void initPages(WebTest testClass) {
        homePage = new HomePage(driver, testClass);
        authPage = new AuthPage(driver, testClass);
    }

    protected HomePage openHomePage(){
        if (homePage.isOpened()) {
            return homePage.setChildElements();
        }
        return login().setChildElements();
    }

    public HomePage login(){
        authPage.open();
        authPage.logIn(TestProperties.getProp("email"), TestProperties.getProp("password"));
        return  homePage.setChildElements();
    }

}
