package com.objects.slemmaobjects;

import com.objects.PageObject;
import com.service.ui.web.SeleniumDriverWrapper;
import org.openqa.selenium.By;

public abstract class SlemmaPageObject extends PageObject{

    private By messageContent = By.xpath("//div[contains(@class, 'dialog__content') and contains(@class, 'textContent')]");

    public SlemmaPageObject(String pageUrl, SeleniumDriverWrapper webDriver){
        super(pageUrl ,webDriver);
    }

    public String getTextFromMessage(){
        if (driver.waitUntilExist(messageContent, 5)) {
            return driver.getElement(messageContent).getText();
        }
        return "";
    }

}
