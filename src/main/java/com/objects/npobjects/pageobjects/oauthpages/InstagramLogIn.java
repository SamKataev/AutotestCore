package com.objects.npobjects.pageobjects.oauthpages;

import com.objects.npobjects.NPPageObject;
import com.service.ui.web.SeleniumDriverWrapper;
import org.openqa.selenium.By;
import org.testng.Assert;

public class InstagramLogIn extends NPPageObject {

    private By emailInput = By.xpath("//input[@aria-label='Phone number, username, or email']");
    private By passInput = By.xpath("//input[@aria-label='Password']");
    private By checkboxBtn = By.xpath("//input[@type='checkbox']");
    private By LogInBtn = By.xpath("//button[@type='submit']");

    public InstagramLogIn(SeleniumDriverWrapper driver){
        super("", driver);
    }

    @Override
    public boolean validateElements() {
        return driver.waitUntilClickable(emailInput, 10)
                && driver.waitUntilClickable(passInput)
                && driver.waitUntilExist(LogInBtn);
    }

    public InstagramLogIn checkIsRendered() {
        super.checkIsRendered();
        return this;
    }

    public InstagramLogIn clickSignInBtn(){
        Assert.assertTrue(driver.click(LogInBtn));
        return this;
    }

    public InstagramLogIn enterEmailInput (String text){
        Assert.assertTrue(driver.type(emailInput ,text));
        return this;
    }

    public InstagramLogIn enterPassInput (String text){
        Assert.assertTrue(driver.type(passInput ,text));
        return this;
    }

    public InstagramLogIn clickcheckboxBtn (){
        Assert.assertTrue(driver.click(checkboxBtn));
        return this;
    }

}
