package com.objects.npobjects.pageobjects.oauthpages;

import com.objects.npobjects.NPPageObject;
import com.service.ui.web.SeleniumDriverWrapper;
import org.openqa.selenium.By;
import org.testng.Assert;

public class MailChimpLogIn extends NPPageObject {
    private By userNameInput= By.xpath("//input[@id='username']");
    private By passInput= By.xpath("//input[@id='password']");
    private By logInBtn = By.xpath("//input[@value='Log In']");

    public MailChimpLogIn (SeleniumDriverWrapper driver){
        super("", driver);
    }

    @Override
    public boolean validateElements() {
        return driver.waitUntilClickable(userNameInput, 15)
                && driver.waitUntilClickable(passInput)
                && driver.waitUntilExist(logInBtn);
    }

    public MailChimpLogIn checkIsRendered() {
        super.checkIsRendered();
        return this;
    }
    public MailChimpLogIn enterEmailInput (String text){
        Assert.assertTrue(driver.type(userNameInput ,text));
        return this;
    }
    public MailChimpLogIn enterPasswordInput (String text){
        Assert.assertTrue(driver.type(passInput ,text));
        return this;
    }
    public MailChimpLogIn clickLogIn(){
        Assert.assertTrue(driver.click(logInBtn));
        return this;
    }
}
