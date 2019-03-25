package com.objects.npobjects.pageelements;

import com.objects.PageElement;
import com.objects.npobjects.pageobjects.Auth;
import com.service.ui.web.SeleniumDriverWrapper;
import org.openqa.selenium.By;
import org.testng.Assert;

public class PasswordResetDialog extends PageElement {

    private Auth parentPage;

    private final By emailInput = inputInParentDivClass("//div[contains(@class, 'mdc-dialog__container')]//input[contains(@class, 'text-field__input false') and @name='email']");
    private final By resetBtn = mdcTextBtn("Reset");

    public PasswordResetDialog(SeleniumDriverWrapper driver, Auth pageObj) {
        super(driver);
        parentPage = pageObj;
    }

    @Override
    public boolean validateElements() {
        return driver.waitUntilExist(emailInput)
                && driver.waitUntilExist(resetBtn);
    }

    public PasswordResetDialog checkIsRendered() {
        super.checkIsRendered();
        return this;
    }

    public PasswordResetDialog enterEmail(String pass) {
        Assert.assertTrue(driver.type(emailInput, pass));
        return this;
    }

    public void clickReset() {
        Assert.assertTrue(driver.click(resetBtn));
    }

}