package com.objects.slemmaobjects.pageobjects;

import com.objects.PageObject;
import com.service.ui.web.SeleniumDriverWrapper;
import com.tests.ui.WebTest;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class AuthPage extends PageObject{

    private WebElement emailInput;
    private WebElement passInput;
    private WebElement signInBtn;

    public AuthPage(SeleniumDriverWrapper driver, WebTest testClass){
        super(driver.getBaseUrl()+"/auth", driver, testClass);
    }

    public AuthPage setChildElements(){
        emailInput = getInputByParentDivClass("emailInput", 10);
        passInput = getInputByParentDivClass("passwordInput");
        signInBtn = getElementByClass("signInBtn");
        return this;
    }

    public void logIn(String email, String pass){
        enterEmail(email);
        enterPass(pass);
        clickSignIn();
    }

    public AuthPage enterEmail(String text){
        Assert.assertTrue(driver.type(emailInput ,text));
        return this;
    }

    public AuthPage enterPass(String text){
        Assert.assertTrue(driver.type(passInput ,text));
        return this;
    }

    public AuthPage clickSignIn(){
        Assert.assertTrue(driver.click(signInBtn));
        return this;
    }
}
