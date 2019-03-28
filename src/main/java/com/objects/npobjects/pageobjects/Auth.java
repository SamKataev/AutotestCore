package com.objects.npobjects.pageobjects;

import com.objects.npobjects.NPPageObject;
import com.objects.npobjects.pageelements.dialogs.PasswordResetDialog;
import com.service.ui.web.SeleniumDriverWrapper;
import org.openqa.selenium.By;
import org.testng.Assert;

public class Auth extends NPPageObject {

    private By emailInput = By.xpath("//input[@placeholder='Email']");
    private By passInput = By.xpath("//input[@placeholder='Password']");
    private By signInBtn = mdcTextBtn("Sign in");
    private By googleSignInBtn = mdcTextBtn("Sign in with Google");
    private By registerBtn = mdcTextBtn("Sign up");
    private By errorMessage = By.cssSelector(".label--error");
    private By passResetBtn = mdcTextBtn("Forgot password?");

    public Auth(SeleniumDriverWrapper driver){
        super(driver.getBaseUrl()+"/auth", driver);
    }

    @Override
    public boolean validateElements(){
        return driver.waitUntilExist(emailInput, 10)
                && driver.waitUntilExist(passInput)
                && driver.waitUntilExist(googleSignInBtn)
                && driver.waitUntilExist(registerBtn)
                && driver.waitUntilExist(passResetBtn)
                && driver.waitUntilExist(signInBtn);
    }

    public Auth checkIsRendered() {
        super.checkIsRendered();
        return this;
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
        Assert.assertTrue(driver.click(registerBtn));
        return this;
    }

    public PasswordResetDialog clickPassReset(){
        Assert.assertTrue(driver.click(passResetBtn));
        return new PasswordResetDialog(driver, this);
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

    public void checkErrorMessageTextContains(String text){
        Assert.assertTrue(getErrorMessageText().contains(text));
    }

}
