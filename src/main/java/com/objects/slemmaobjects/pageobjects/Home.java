package com.objects.slemmaobjects.pageobjects;

import com.objects.PageObject;
import com.objects.WebElementsContainer;
import com.objects.slemmaobjects.pageelements.*;
import com.service.ui.web.SeleniumDriverWrapper;
import org.openqa.selenium.By;

public class Home extends PageObject {

    public NavigationPanel navigationPanel;
    public NavigatorObjectsList navigatorObjectsList;

    private final By waiter = classSelector("process-waiter__container");
    private final By pageModeLabel = subclassInParentClass("pageModeLbl", "lbl-cnt");
    private final By plusBtn = classSelector("new-object-button");

    public Home(SeleniumDriverWrapper driver){
        super(driver.getBaseUrl() + "/home", driver);
        navigationPanel = new NavigationPanel(driver, this);
        navigatorObjectsList = new NavigatorObjectsList(driver, this);
    }

    @Override
    public boolean validateElements() {
        return driver.waitUntilDisappear(waiter, 10)
                && driver.waitUntilExist(pageModeLabel, 10)
                && driver.waitUntilExist(plusBtn)
                && navigationPanel.isRendered()
                && navigatorObjectsList.isRendered();
    }

    public boolean isLoggedIn(){
        return isRendered()
                && checkMenuSection("Library", "/home");
                //TODO: check account
    }

    public boolean checkMenuSection(String name, String path){
        return isRendered()
                && driver.checkCurrentUrl(driver.getBaseUrl() + path)
                && driver.getElement(pageModeLabel, 10).getText().equals(name);
    }

    public WebElementsContainer clickPlusBtn(){
        String currentUrl = driver.getCurrentUrl();
        driver.click(plusBtn);
        if (currentUrl.contains("infographics")){
            return new ChooseDashboardTemplate(driver, this);
        }
        if (currentUrl.contains("reports")){
            return new ChooseDataSource(driver, this);
        }
        if (currentUrl.contains("presentations")){
            return new Presentation(driver);
        }
        if (currentUrl.contains("datasources")){
            return new CreateNewIntegration(driver, this);
        }
        return this;
    }

}
