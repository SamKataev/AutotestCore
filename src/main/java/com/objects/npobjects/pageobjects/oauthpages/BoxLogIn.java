package com.objects.npobjects.pageobjects.oauthpages;

import com.objects.npobjects.NPPageObject;
import com.service.ui.web.SeleniumDriverWrapper;
import org.openqa.selenium.By;
import org.testng.Assert;

public class BoxLogIn extends NPPageObject {

    private By loginInput =By.xpath("//input[@id='login']");
    private By passInput =By.xpath("//input[@id='password']");
    private By authorizeBtn =By.xpath("//input[@title='Authorize']");
    private By accessBtn =By.xpath("//button[@id='consent_accept_button']");

    public BoxLogIn(SeleniumDriverWrapper driver){
        super("", driver);
    }

    @Override
    public boolean validateElements() {
        return driver.waitUntilClickable(loginInput, 10)
                && driver.waitUntilClickable(passInput)
                && driver.waitUntilClickable(authorizeBtn);
    }

    public BoxLogIn checkIsRendered() {
        super.checkIsRendered();
        return this;
    }

    public BoxLogIn enterloginInput (String text){
        Assert.assertTrue(driver.type(loginInput ,text));
        return this;
    }

    public BoxLogIn enterpassInput (String text){
        Assert.assertTrue(driver.type(passInput ,text));
        return this;
    }

    public BoxLogIn clickauthorizeBtn(){
        Assert.assertTrue(driver.click(authorizeBtn));
        return this;
    }
    public BoxLogIn clickaccessBtn(){
        Assert.assertTrue(driver.click(accessBtn));
        return this;
    }
}
