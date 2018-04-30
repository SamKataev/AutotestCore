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
                && checkMenuSection("Library", "/home");
                //TODO: check account
    }

    public boolean checkMenuSection(String name, String path){
        return isOpened()
                && driver.checkCurrentUrl(driver.getBaseUrl() + path)
                && driver.getElement(pageModeLabel, 10).getText().equals(name);
    }

}
