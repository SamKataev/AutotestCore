package com.objects.slemmaobjects;

import com.objects.PageObject;
import com.service.ui.web.SeleniumDriverWrapper;
import org.openqa.selenium.By;
import org.testng.Assert;

public abstract class SlemmaPageObject extends PageObject{

    private By messageDialog = classInParentClass("dropdown__content", "dialog__content");
    private By messageDialogContent = By.xpath("//div[contains(@class, 'dialog__content') and contains(@class, 'textContent')]");

    public SlemmaPageObject(String pageUrl, SeleniumDriverWrapper webDriver){
        super(pageUrl ,webDriver);
    }

    public boolean isMessageDialogAppears(){
        return driver.waitUntilExist(messageDialog, 2);
    }

    public void checkMessageDialogText(String text){
        Assert.assertTrue(isMessageDialogAppears());
        Assert.assertTrue(driver.waitUntilExist(messageDialogContent, 2)
                && driver.getElement(messageDialogContent).getText().equals(text));
    }

    public void checkMessageDialogContainsText(String text){
        Assert.assertTrue(isMessageDialogAppears());
        Assert.assertTrue(driver.waitUntilExist(messageDialogContent, 2)
                && driver.getElement(messageDialogContent).getText().contains(text));
    }

}
