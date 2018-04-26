package com.objects.slemmaobjects.pageelements;

import com.objects.PageElement;
import com.service.ui.web.SeleniumDriverWrapper;
import org.openqa.selenium.By;

public class NavigationPanel extends PageElement {

    private final By libraryBtn = locatorByClass("page-mode-panel__library-item");
    private final By dashboardsBtn = locatorByClass("page-mode-panel__dashboards-item");
    private final By reportsBtn = locatorByClass("page-mode-panel__reports-item");
    private final By presentationsBtn = locatorByClass("page-mode-panel__presentations-item");
    private final By dataSourcesBtn = locatorByClass("page-mode-panel__data-sources-item");
    private final By deliveryBtn = locatorByClass("page-mode-panel__delivery-item");
    private final By activityBtn = locatorByClass("page-mode-panel__activity-item");
    private final By settingsBtn = locatorByClass("page-mode-panel__account-item");
    private final By adminBtn = locatorByClass("page-mode-panel__admin-item");

    public NavigationPanel(SeleniumDriverWrapper driver){
        super(driver);
    }

    @Override
    public boolean getChildElements() {
        return driver.waitUntilExist(libraryBtn, 10)
                && driver.waitUntilExist(dashboardsBtn)
                && driver.waitUntilExist(reportsBtn)
                && driver.waitUntilExist(presentationsBtn)
                && driver.waitUntilExist(dataSourcesBtn)
                && driver.waitUntilExist(deliveryBtn)
                && driver.waitUntilExist(activityBtn)
                && driver.waitUntilExist(settingsBtn)
                && driver.waitUntilExist(adminBtn);
    }

    public boolean openLibrary(){
        return driver.click(libraryBtn);
    }

    public boolean openDasboards(){
        return driver.click(dashboardsBtn);
    }

    public boolean openReports(){
        return driver.click(reportsBtn);
    }

    public boolean openPresentations(){
        return driver.click(presentationsBtn);
    }

    public boolean openDatasources(){
        return driver.click(dataSourcesBtn);
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
