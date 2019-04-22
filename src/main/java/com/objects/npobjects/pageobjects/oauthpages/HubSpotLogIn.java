package com.objects.npobjects.pageobjects.oauthpages;

import com.objects.npobjects.NPPageObject;
import com.service.ui.web.SeleniumDriverWrapper;
import org.openqa.selenium.By;
import org.testng.Assert;

public class HubSpotLogIn extends NPPageObject {
    private By emailInput = By.xpath("//input[@id='username']");
    private By passInput = By.xpath("//input[@id='password']");
    private By logInBtn= By.xpath ("//button[@id='loginBtn']");
    private By accountChoose= By.xpath ("//tr[@data-reactid='.0.1.1.0.0.0.1.$0']");

    public HubSpotLogIn(SeleniumDriverWrapper driver){
        super("", driver);
    }
    @Override
    public boolean validateElements() {
        return driver.waitUntilClickable(emailInput, 10)
                && driver.waitUntilClickable(passInput)
                && driver.waitUntilClickable(logInBtn);

    }

    public HubSpotLogIn checkIsRendered() {
        super.checkIsRendered();
        return this;
    }

    public HubSpotLogIn enterEmailInput (String text){
        Assert.assertTrue(driver.type(emailInput ,text));
        return this;
    }

    public HubSpotLogIn enterPassInput (String text){
        Assert.assertTrue(driver.type(passInput ,text));
        return this;
    }

    public HubSpotLogIn clickLogInBtn(){
        Assert.assertTrue(driver.click(logInBtn));
        return this;
    }

    public HubSpotLogIn clickAccountChoose(){
        Assert.assertTrue(driver.click(accountChoose));
        return this;
    }
}
