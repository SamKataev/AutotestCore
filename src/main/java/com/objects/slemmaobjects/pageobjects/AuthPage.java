package com.objects.slemmaobjects.pageobjects;

import com.objects.PageObject;
import com.service.ui.web.SeleniumDriverWrapper;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class AuthPage extends PageObject{

    private WebElement emailInput;
    private WebElement passInput;
    private WebElement signInBtn;

    public AuthPage(String url, SeleniumDriverWrapper driver){
        super(url, driver);
    }

    @Override
    protected void setChildElements() {
        emailInput = getInputByParentDivClass("emailInput", 10);
        passInput = getInputByParentDivClass("passwordInput");
        signInBtn = getElementByClass("signInBtn");
    }

    public AuthPage logIn(String email, String pass){
        enterEmail(email);
        enterPass(pass);
        clickSignIn();
        return this;
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
