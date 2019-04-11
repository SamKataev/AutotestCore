package com.objects.npobjects.pageobjects.oauthpages;


import com.objects.npobjects.NPPageObject;
import com.service.ui.web.SeleniumDriverWrapper;
import org.openqa.selenium.By;
import org.testng.Assert;

public class FacebookLogIn extends NPPageObject {

    private By emailInput = By.xpath("//div[@id='email_container']/input");
    private By passInput = By.xpath("//input[@name='pass']");
    private By signInBtn = By.xpath("//button[@id='loginbutton']");
    private By confirmBtn = By.xpath("//button[@data-testid='nextBtn']");


    public FacebookLogIn(SeleniumDriverWrapper driver){
        super("", driver);
    }

    @Override
    public boolean validateElements() {
        return driver.waitUntilClickable(emailInput, 10)
                && driver.waitUntilClickable(passInput)
                && driver.waitUntilClickable(signInBtn);
    }

      public FacebookLogIn checkIsRendered() {
        super.checkIsRendered();
        return this;
    }

     public FacebookLogIn clickSignInBtn(){
        Assert.assertTrue(driver.click(signInBtn));
        return this;
    }

    public FacebookLogIn enterEmailInput (String text){
        Assert.assertTrue(driver.type(emailInput ,text));
        return this;
    }

    public FacebookLogIn enterPassInput (String text){
        Assert.assertTrue(driver.type(passInput ,text));
        return this;
    }

    public FacebookLogIn clickconfirmBtn (){
        Assert.assertTrue(driver.click(confirmBtn));
        return this;
    }

}
