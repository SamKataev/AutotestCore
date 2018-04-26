package com.objects.slemmaobjects.pageobjects;

import com.objects.PageObject;
import com.objects.slemmaobjects.pageelements.NavigationPanel;
import com.service.ui.web.SeleniumDriverWrapper;
import org.openqa.selenium.By;

public class HomePage extends PageObject {

    public NavigationPanel navigationPanel;

    private final By pageModeLabel = locatorBySubclassInParentClass("pageModeLbl", "lbl-cnt");

    public HomePage(SeleniumDriverWrapper driver){
        super(driver.getBaseUrl() + "/home", driver);
        navigationPanel = new NavigationPanel(driver);
    }

    @Override
    public boolean getChildElements() {
        return driver.waitUntilExist(pageModeLabel, 10)
                && navigationPanel.getChildElements();
    }

    public boolean isLoggedIn(){
        return isOpened()
                && checkPageMode("Library");
                //TODO: check account
    }

    public boolean checkPageMode(String name){
        return driver.getElement(pageModeLabel, 10).getText().equals(name);
    }

}
