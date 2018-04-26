package com.objects.slemmaobjects.pageobjects;

import com.objects.PageObject;
import com.service.ui.web.SeleniumDriverWrapper;
import org.openqa.selenium.By;
import org.testng.Assert;

public class AuthPage extends PageObject{

    private By emailInput = locatorByInputInParentDivClass("emailInput");
    private By passInput = locatorByInputInParentDivClass("passwordInput");
    private By signInBtn = locatorByClass("signInBtn");

    public AuthPage(SeleniumDriverWrapper driver){
        super(driver.getBaseUrl()+"/auth", driver);
    }

    public boolean getChildElements(){
        return driver.waitUntilExist(emailInput, 10)
                && driver.waitUntilExist(passInput)
                && driver.waitUntilExist(signInBtn);
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
