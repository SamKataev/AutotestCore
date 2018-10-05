package com.objects.slemmaobjects.pageobjects;

import com.objects.slemmaobjects.SlemmaPageObject;
import com.service.ui.web.SeleniumDriverWrapper;
import org.openqa.selenium.By;
import org.testng.Assert;

public class SamlAuth extends SlemmaPageObject {

    private By emailInput = inputInParentDivClass("emailInput");
    private By signInBtn = classSelector("signInBtn");
    private By backToLoginBtn = classWithText("lbl-cnt", "Войти без SSO");
    private By errorMessage = classInParentClass("login-panel__error", "lbl-cnt");

    public SamlAuth(SeleniumDriverWrapper driver){
        super(driver.getBaseUrl()+"/saml-auth", driver);
    }

    @Override
    public boolean validateElements(){
        return driver.waitUntilClickable(emailInput, 10)
                && driver.waitUntilClickable(backToLoginBtn, 10)
                && driver.waitUntilClickable(signInBtn, 10);
    }

    public SamlAuth checkIsRendered() {
        super.checkIsRendered();
        return this;
    }

    public SamlAuth enterEmail(String text){
        Assert.assertTrue(driver.type(emailInput ,text));
        return this;
    }

    public void clickSignIn(){
        Assert.assertTrue(driver.click(signInBtn));
    }

    public void clickBackToLogin(){
        Assert.assertTrue(driver.click(backToLoginBtn));
    }


    public String getErrorMessageText(){
        if (driver.waitUntilClickable(errorMessage, 2)){
            return driver.getElement(errorMessage).getText();
        }
        return "";
    }

    public void checkErrorMessageText(String text){
        Assert.assertTrue(getErrorMessageText().equals(text));
    }
}
