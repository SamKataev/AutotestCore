package com.objects.npobjects.pageobjects.oauthpages;

import com.objects.npobjects.NPPageObject;
import com.service.ui.web.SeleniumDriverWrapper;
import org.openqa.selenium.By;
import org.testng.Assert;

public class ZendeskLogIn extends NPPageObject {

    private By emailInput = By.xpath("//input[@id='user_email']");
    private By passwordInput = By.xpath("//input[@type='password']");
    private By signIn = By.xpath("//input[@type='submit']");

    public ZendeskLogIn(SeleniumDriverWrapper driver){
        super("", driver);
    }

    @Override
    public boolean validateElements() {
        return driver.waitUntilExist(emailInput, 10)
                && driver.waitUntilExist(passwordInput)
                && driver.waitUntilExist(signIn);
    }

    public ZendeskLogIn checkIsRendered() {
        super.checkIsRendered();
        return this;
    }
    public ZendeskLogIn clickSignInBtn(){
        Assert.assertTrue(driver.click(signIn));
        return this;
    }
    public ZendeskLogIn enterEmailInput (String text){
        Assert.assertTrue(driver.type(emailInput ,text));
        return this;
    }
    public ZendeskLogIn enterPasswordInput (String text){
        Assert.assertTrue(driver.type(passwordInput ,text));
        return this;
    }
}


