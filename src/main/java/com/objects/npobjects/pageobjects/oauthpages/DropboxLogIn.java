package com.objects.npobjects.pageobjects.oauthpages;

import com.objects.npobjects.NPPageObject;
import com.service.ui.web.SeleniumDriverWrapper;
import org.openqa.selenium.By;
import org.testng.Assert;

public class DropboxLogIn extends NPPageObject {
    private By emailInput = By.xpath("//input[@name='login_email']");
    private By passInput = By.xpath("//input[@name='login_password']");
    private By signInBtn = By.xpath("//button/div[contains(@class, 'sign-in-text') and text()='Sign in']");
    private By continueBtn = By.xpath("//button[@type='reset']");
    private By allowBtn = By.xpath("//div[@style='display: block;']//button[@name='allow_access']");
    private By securityBtn = By.xpath("//button[@id='primary-button']");
    private By wait = By.xpath("//span[@class='login-loading-indicator'");


    public DropboxLogIn(SeleniumDriverWrapper driver){
        super("", driver);
    }

    @Override
    public boolean validateElements() {
        return driver.waitUntilClickable(emailInput, 10)
                && driver.waitUntilClickable(passInput)
                && driver.waitUntilClickable(signInBtn);
    }
    public DropboxLogIn checkIsRendered() {
        super.checkIsRendered();
        return this;
    }

    public DropboxLogIn enteremailInput (String text){
        Assert.assertTrue(driver.type(emailInput ,text));
        return this;
    }

    public DropboxLogIn enterpassInput (String text){
        Assert.assertTrue(driver.type(passInput ,text));
        return this;
    }

    public DropboxLogIn clicksignInBtn(){
        Assert.assertTrue(driver.waitUntilClickable(signInBtn));
        Assert.assertTrue(driver.click(signInBtn));
        return this;
    }
    public DropboxLogIn clickcontinueBtn(){
        Assert.assertTrue(driver.waitUntilClickable(continueBtn,30));
        Assert.assertTrue(driver.click(continueBtn));
        return this;
    }
    public DropboxLogIn clickallowBtn()    {
        pause(5);
        Assert.assertTrue(driver.waitUntilClickable(allowBtn,30));
        Assert.assertTrue(driver.click(allowBtn));
        pause(5);
        return this;
    }

    public DropboxLogIn switchToWait(){
        Assert.assertTrue(driver.waitUntilDisappear(wait,10));
        return this;
    }
}