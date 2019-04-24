package com.objects.npobjects.pageelements.dialogs;

import com.objects.npobjects.pageobjects.Main;
import com.service.ui.web.SeleniumDriverWrapper;
import org.openqa.selenium.By;
import org.testng.Assert;

public class SelectDatasetDialog extends Dialog {
    private Main parentPage;

    private final By closeBtn = dialogMdcIconFontBtn("ic_close");

    public SelectDatasetDialog (SeleniumDriverWrapper driver, Main pageObj) {
        super(driver);
        parentPage = pageObj;
    }
    @Override
    public boolean validateElements() {
        return driver.waitUntilClickable(closeBtn, 5);
    }
    public SelectDatasetDialog checkIsRendered() {
        super.checkIsRendered();
        return this;
    }
    public SelectDatasetDialog clickBasedInDialogByName(String text, String iconClass, int time){
        Assert.assertTrue(driver.waitUntilClickable(By.xpath("//div[contains(@class, 'mdc-dialog--open')]//span[contains(@class, 'mdc-list-item__text') and contains(text(), '" + text + "')]/preceding-sibling::span[contains(@class, '" + iconClass + "')]/parent::li"), time));
        Assert.assertTrue(driver.click(By.xpath("//div[contains(@class, 'mdc-dialog--open')]//span[contains(@class, 'mdc-list-item__text') and contains(text(), '" + text + "')]/preceding-sibling::span[contains(@class, '" + iconClass + "')]/parent::li")));
        return this;
    }

    public SelectDatasetDialog clickFileInDialogByName(String text, String iconClass, int time){
        Assert.assertTrue(driver.waitUntilClickable(By.xpath("//div[contains(@class, 'mdc-dialog--open')]//span[contains(@class, 'mdc-list-item__primary-text') and contains(text(), '" + text + "')]/parent::span/preceding-sibling::span[contains(@class, '" + iconClass + "')]"), time));
        Assert.assertTrue(driver.click(By.xpath("//div[contains(@class, 'mdc-dialog--open')]//span[contains(@class, 'mdc-list-item__primary-text') and contains(text(), '" + text + "')]/parent::span/preceding-sibling::span[contains(@class, '" + iconClass + "')]")));
        return this;
    }
    public SelectDatasetDialog checkDialogTitle(String titleText){
        Assert.assertTrue(driver.waitUntilExist(By.xpath("//div[contains(@class, 'mdc-dialog--open')]//span[contains(@class, 'mdc-top-app-bar__title') and contains(text(), '" + titleText + "')]")));
        return this;
    }

}

