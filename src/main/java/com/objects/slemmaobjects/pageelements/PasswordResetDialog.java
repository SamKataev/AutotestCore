package com.objects.slemmaobjects.pageelements;

import com.objects.PageElement;
import com.objects.slemmaobjects.pageobjects.Auth;
import com.service.ui.web.SeleniumDriverWrapper;
import org.openqa.selenium.By;
import org.testng.Assert;

public class PasswordResetDialog extends PageElement {

    private Auth parentPage;

    private final By caption = classWithText("dialog__caption", "Сбросить пароль");
    private final By emailInput = inputInParentDivClass("input_hide-chrome-autocomplete");
    private final By resetBtn = classWithText("btn__cont", "Сбросить");

    public PasswordResetDialog(SeleniumDriverWrapper driver, Auth pageObj) {
        super(driver);
        parentPage = pageObj;
    }

    @Override
    public boolean validateElements() {
        return driver.waitUntilExist(caption, 5)
                && driver.waitUntilExist(emailInput)
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