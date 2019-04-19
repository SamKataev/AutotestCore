package com.objects.npobjects.pageobjects.oauthpages;

import com.objects.npobjects.NPPageObject;
import com.service.ui.web.SeleniumDriverWrapper;
import org.openqa.selenium.By;
import org.testng.Assert;

public class YandexDiskLogIn extends NPPageObject {
    private By emailInput = By.xpath("//input[@id='passp-field-login']");
    private By logInBtn =By.xpath("//button[@type='submit']");
    private By passInput =By.xpath("//input[@id='passp-field-passwd']");
    private By allowBtn =By.xpath("//div[@class='block submit-once_allow']");

    public YandexDiskLogIn(SeleniumDriverWrapper driver){
        super("", driver);
    }

    @Override
    public boolean validateElements() {
        return driver.waitUntilClickable(emailInput, 10)
                && driver.waitUntilClickable(logInBtn);
    }

    public YandexDiskLogIn checkIsRendered() {
        super.checkIsRendered();
        return this;
    }

    public YandexDiskLogIn enterEmailInput (String text){
        Assert.assertTrue(driver.type(emailInput ,text));
        return this;
    }

    public YandexDiskLogIn enterPassInput (String text){
        Assert.assertTrue(driver.type(passInput ,text));
        return this;
    }

    public YandexDiskLogIn clicklogInBtn() {
        Assert.assertTrue(driver.click(logInBtn));
        return this;
    }
    public YandexDiskLogIn clickallowBtn() {
        Assert.assertTrue(driver.click(allowBtn));
        return this;
    }

}
