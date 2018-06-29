package com.objects.slemmaobjects.pageobjects;

import com.objects.PageObject;
import com.service.ui.web.SeleniumDriverWrapper;
import org.openqa.selenium.By;
import org.testng.Assert;

public class Register extends PageObject {

    private By emailInput = inputInParentDivClass("emailInput");
    private By passInput = inputInParentDivClass("passwordInput");
    private By createAccBtn = classSelector("createBtn");

    public Register(SeleniumDriverWrapper driver) {
        super(driver.getBaseUrl() + "/register", driver);
    }

    @Override
    public boolean validateElements() {
        return driver.waitUntilExist(emailInput)
                && driver.waitUntilExist(passInput)
                && driver.waitUntilExist(createAccBtn);
    }

    public Register enterEmail(String text){
        Assert.assertTrue(driver.type(emailInput ,text));
        return this;
    }

    public Register enterPass(String text){
        Assert.assertTrue(driver.type(passInput ,text));
        return this;
    }

    public Register clickCreateAcc(){
        Assert.assertTrue(driver.click(createAccBtn));
        return this;
    }

}