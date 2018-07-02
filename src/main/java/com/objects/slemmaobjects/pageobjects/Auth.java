package com.objects.slemmaobjects.pageobjects;

import com.objects.slemmaobjects.SlemmaPageObject;
import com.service.ui.web.SeleniumDriverWrapper;
import org.openqa.selenium.By;
import org.testng.Assert;

public class Auth extends SlemmaPageObject {

    private By emailInput = inputInParentDivClass("emailInput");
    private By passInput = inputInParentDivClass("passwordInput");
    private By signInBtn = classSelector("signInBtn");
    private By googleSignInBtn = classSelector("login-panel__google-button");
    private By registerBtn = subclassInParentClass("login-panel__register","btn__cont");
    private By samlSignInBtn = subclassInParentClass("login-panel__saml-button","btn__cont");

    public Auth(SeleniumDriverWrapper driver){
        super(driver.getBaseUrl()+"/auth", driver);
    }

    @Override
    public boolean validateElements(){
        return driver.waitUntilExist(emailInput, 10)
                && driver.waitUntilExist(passInput)
                && driver.waitUntilExist(signInBtn);
    }

    public void logIn(String email, String pass){
        enterEmail(email);
        enterPass(pass);
        clickSignIn();
    }

    public Auth enterEmail(String text){
        Assert.assertTrue(driver.type(emailInput ,text));
        return this;
    }

    public Auth enterPass(String text){
        Assert.assertTrue(driver.type(passInput ,text));
        return this;
    }

    public Auth clickSignIn(){
        Assert.assertTrue(driver.click(signInBtn));
        return this;
    }

    public Auth clickGoogleSignIn(){
        //TODO: return google oauth form
        Assert.assertTrue(driver.click(googleSignInBtn));
        return this;
    }

    public Auth clickRegister(){
        //TODO: return Register page
        Assert.assertTrue(driver.click(registerBtn));
        return this;
    }

    public Auth clickSamlSignIn(){
        //TODO: return Saml page
        Assert.assertTrue(driver.click(samlSignInBtn));
        return this;
    }
}
