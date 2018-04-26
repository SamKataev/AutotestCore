package com.objects.slemmaobjects.pageobjects;

import com.objects.PageObject;
import com.objects.slemmaobjects.pageelements.NavigationPanel;
import com.service.ui.web.SeleniumDriverWrapper;
import com.tests.ui.WebTest;
import org.openqa.selenium.WebElement;

public class HomePage extends PageObject {

    public NavigationPanel navigationPanel;

    private WebElement pageModeLabel;

    public HomePage(SeleniumDriverWrapper driver, WebTest testClass){
        super(driver.getBaseUrl() + "/home", driver, testClass);
    }

    @Override
    public HomePage setChildElements() {
        pageModeLabel = getElementBySubclassInParentClass("pageModeLbl", "lbl-cnt", 10);
        navigationPanel = new NavigationPanel(driver, currentTest).setChildElements();
        return this;
    }

    public boolean isLoggedIn(){
        return isOpened()
                && checkPageMode("Library");
                //TODO: check account
    }

    public boolean checkPageMode(String name){
        return pageModeLabel.getText().equals(name);
    }

}
