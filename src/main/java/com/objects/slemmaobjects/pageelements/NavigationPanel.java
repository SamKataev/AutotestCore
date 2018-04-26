package com.objects.slemmaobjects.pageelements;

import com.objects.PageElement;
import com.service.ui.web.SeleniumDriverWrapper;
import com.tests.ui.WebTest;
import org.openqa.selenium.WebElement;

public class NavigationPanel extends PageElement {

    private WebElement libraryBtn;
    private WebElement dasboardsBtn;
    private WebElement reportsBtn;
    private WebElement presentationsBtn;
    private WebElement datasourcesBtn;
    private WebElement deliveryBtn;
    private WebElement activityBtn;
    private WebElement settingsBtn;
    private WebElement adminBtn;

    public NavigationPanel(SeleniumDriverWrapper driver, WebTest testClass){
        super(driver, testClass);
    }

    @Override
    public NavigationPanel setChildElements() {
        libraryBtn = getElementByClass("page-mode-panel__library-item");
        dasboardsBtn = getElementByClass("page-mode-panel__dashboards-item");
        reportsBtn = getElementByClass("page-mode-panel__reports-item");
        presentationsBtn = getElementByClass("page-mode-panel__presentations-item");
        datasourcesBtn = getElementByClass("page-mode-panel__data-sources-item");
        deliveryBtn = getElementByClass("page-mode-panel__delivery-item");
        activityBtn = getElementByClass("page-mode-panel__activity-item");
        settingsBtn = getElementByClass("page-mode-panel__account-item");
        adminBtn = getElementByClass("page-mode-panel__admin-item");
        return this;
    }

    public boolean openLibrary(){
        return driver.click(libraryBtn);
    }

    public boolean openDasboards(){
        return driver.click(dasboardsBtn);
    }

    public boolean openReports(){
        return driver.click(reportsBtn);
    }

    public boolean openPresentations(){
        return driver.click(presentationsBtn);
    }

    public boolean openDatasources(){
        return driver.click(datasourcesBtn);
    }

    public boolean openDelivery(){
        return driver.click(deliveryBtn);
    }

    public boolean openActivity(){
        return driver.click(activityBtn);
    }

    public boolean openSettings(){
        return driver.click(settingsBtn);
    }

    public boolean openAdmin(){
        return driver.click(adminBtn);
    }

}
