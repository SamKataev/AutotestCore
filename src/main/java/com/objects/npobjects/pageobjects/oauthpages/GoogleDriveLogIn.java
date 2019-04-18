package com.objects.npobjects.pageobjects.oauthpages;

import com.objects.npobjects.NPPageObject;
import com.service.ui.web.SeleniumDriverWrapper;
import org.openqa.selenium.By;
import org.testng.Assert;

public class GoogleDriveLogIn extends NPPageObject {
    private By emailInput=By.xpath("//input[@type='email']");
    private By nextBtn =By.xpath("//div[@role='button']");
    private By nextPassBtn =By.xpath("//div[@role='button' and @id='passwordNext']");
    private By passwordInput =By.xpath("//input[@type='password']");
    private By advancedBtn =By.xpath("//div/a[contains(text(), 'Advanced')]");
    private By gotoBtn =By.xpath("//a[contains(text(), 'Go to newpeople.co (unsafe)')]");
    private By allowBtn =By.xpath("//div[@role='button' and @id='submit_approve_access']");

    public GoogleDriveLogIn(SeleniumDriverWrapper driver){
        super("", driver);
    }

    @Override
    public boolean validateElements() {
        return driver.waitUntilClickable(emailInput, 10)
                && driver.waitUntilClickable(nextBtn);

    }

    public GoogleDriveLogIn checkIsRendered() {
        super.checkIsRendered();
        return this;
    }

    public GoogleDriveLogIn enteremailInput (String text){
        Assert.assertTrue(driver.type(emailInput ,text));
        return this;
    }

    public GoogleDriveLogIn enterpasswordInput (String text){
        Assert.assertTrue(driver.type(passwordInput ,text));
        return this;
    }

    public GoogleDriveLogIn clicknextBtn(){
        Assert.assertTrue(driver.click(nextBtn));
        return this;
    }
    public GoogleDriveLogIn clicknextPassBtn(){
        Assert.assertTrue(driver.click(nextPassBtn));
        return this;
    }

      public GoogleDriveLogIn clickadvancedBtn(){
        Assert.assertTrue(driver.click(advancedBtn));
        return this;
    }
    public GoogleDriveLogIn clickgotoBtn(){
        Assert.assertTrue(driver.waitUntilClickable(gotoBtn));
        Assert.assertTrue(driver.click(gotoBtn));
        return this;
    }
    public GoogleDriveLogIn clickallowBtn(){
        Assert.assertTrue(driver.waitUntilClickable(allowBtn));
        Assert.assertTrue(driver.click(allowBtn));
        return this;
    }
}
