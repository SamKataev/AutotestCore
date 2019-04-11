package com.objects.npobjects.pageobjects.oauthpages;

import com.objects.npobjects.NPPageObject;
import com.service.ui.web.SeleniumDriverWrapper;
import org.openqa.selenium.By;
import org.testng.Assert;

public class PayPalLogIn extends NPPageObject {

    private By emailInput = By.xpath("//input[@id='email']");
    private By passInput = By.xpath("//input[@id='password']");
    private By signInBtn = By.xpath("//button[@id='btnLogin']");



    public PayPalLogIn(SeleniumDriverWrapper driver){
        super("", driver);
    }

    @Override
    public boolean validateElements() {
        return driver.waitUntilClickable(emailInput, 10)
                && driver.waitUntilClickable(passInput)
                && driver.waitUntilClickable(signInBtn);
    }

    public PayPalLogIn checkIsRendered() {
        super.checkIsRendered();
        return this;
    }

    public PayPalLogIn clickSignInBtn(){
        Assert.assertTrue(driver.click(signInBtn));
        return this;
    }

    public PayPalLogIn enterEmailInput (String text){
        Assert.assertTrue(driver.type(emailInput ,text));
        return this;
    }

    public PayPalLogIn enterPassInput (String text){
        Assert.assertTrue(driver.type(passInput ,text));
        return this;
    }
}
