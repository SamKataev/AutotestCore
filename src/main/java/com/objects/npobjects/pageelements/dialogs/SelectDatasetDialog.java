package com.objects.npobjects.pageelements.dialogs;

import com.objects.npobjects.pageobjects.Main;
import com.service.ui.web.SeleniumDriverWrapper;
import org.openqa.selenium.By;
import org.testng.Assert;

public class SelectDatasetDialog extends Dialog {
    private Main parentPage;

    private final By title = dialogMdcAppBarTitle("Select dataset");
    private final By closeBtn = dialogMdcIconFontBtn("ic_close");

    public SelectDatasetDialog (SeleniumDriverWrapper driver, Main pageObj) {
        super(driver);
        parentPage = pageObj;
    }
    @Override
    public boolean validateElements() {
        return driver.waitUntilExist(title, 5)
                && driver.waitUntilClickable(closeBtn);
    }
    public SelectDatasetDialog checkIsRendered() {
        super.checkIsRendered();
        return this;
    }
    public SelectDatasetDialog clickObjectInDialogByName(String text, String iconClass, int time){
        Assert.assertTrue(driver.waitUntilClickable(By.xpath("//div[contains(@class, 'mdc-dialog--open')]//span[contains(@class, 'mdc-list-item__text') and contains(text(), '" + text + "')]/preceding-sibling::span[contains(@class, '" + iconClass + "')]/parent::li"), time));
        Assert.assertTrue(driver.click(By.xpath("//div[contains(@class, 'mdc-dialog--open')]//span[contains(@class, 'mdc-list-item__text') and contains(text(), '" + text + "')]/preceding-sibling::span[contains(@class, '" + iconClass + "')]/parent::li")));
        return this;
    }
}

