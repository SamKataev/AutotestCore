package com.objects.npobjects.pageobjects.oauthpages;

import com.objects.npobjects.NPPageObject;
import com.service.ui.web.SeleniumDriverWrapper;
import org.openqa.selenium.By;
import org.testng.Assert;

public class PipedriveLogIn extends NPPageObject {

    private By emailInput = By.xpath("//input[@id='login']");
    private By passwordInput = By.xpath("//input[@id='password']");
    private By signIn = By.xpath("//button[@type='submit']");
    private By continueBtn = By.xpath("//button[@id='continue']");

    public PipedriveLogIn(SeleniumDriverWrapper driver){
        super("", driver);
    }

    @Override
    public boolean validateElements() {
        return driver.waitUntilClickable(emailInput, 15)
                && driver.waitUntilClickable(passwordInput)
                && driver.waitUntilExist(signIn);
    }
        public PipedriveLogIn checkIsRendered() {
            super.checkIsRendered();
            return this;
        }

        public PipedriveLogIn clickSignInBtn(){
            Assert.assertTrue(driver.click(signIn));
            return this;
        }
        public PipedriveLogIn enterEmailInput (String text){
            Assert.assertTrue(driver.type(emailInput ,text));
            return this;
        }
        public PipedriveLogIn enterPasswordInput (String text){
            Assert.assertTrue(driver.type(passwordInput ,text));
            return this;
        }
        public PipedriveLogIn clickcontinueBtn(){
            Assert.assertTrue(driver.click(continueBtn));
            return this;
        }
    }


