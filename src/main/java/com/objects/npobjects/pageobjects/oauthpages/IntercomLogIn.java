package com.objects.npobjects.pageobjects.oauthpages;

import com.objects.npobjects.NPPageObject;
import com.service.ui.web.SeleniumDriverWrapper;
import org.openqa.selenium.By;
import org.testng.Assert;

public class IntercomLogIn extends NPPageObject {

    private By emailInput = By.xpath("//input[@placeholder='name@company.com']");
    private By passwordInput = By.xpath("//input[@placeholder='password']");
    private By signIn = By.xpath("//button[@type='submit']");
    private By authorizeAccess = By.xpath("//button[@id='ember113']");

    public IntercomLogIn(SeleniumDriverWrapper driver){
        super("", driver);
    }

    @Override
    public boolean validateElements() {
        return driver.waitUntilClickable(emailInput, 15)
                && driver.waitUntilClickable(passwordInput)
                && driver.waitUntilExist(signIn);
    }

    public IntercomLogIn checkIsRendered() {
        super.checkIsRendered();
        return this;
    }

    public IntercomLogIn clickSignInBtn(){
        Assert.assertTrue(driver.click(signIn));
        return this;
    }

    public IntercomLogIn enterEmailInput (String text){
        Assert.assertTrue(driver.type(emailInput ,text));
        return this;
    }
    public IntercomLogIn enterPasswordInput (String text){
        Assert.assertTrue(driver.type(passwordInput ,text));
        return this;
    }
    public IntercomLogIn clickAuthorizeAccessn(){
        Assert.assertTrue(driver.click(authorizeAccess));
        return this;
    }
}
