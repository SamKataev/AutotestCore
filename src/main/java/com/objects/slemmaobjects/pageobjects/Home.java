package com.objects.slemmaobjects.pageobjects;

import com.objects.PageObject;
import com.objects.WebElementsContainer;
import com.objects.slemmaobjects.pageelements.*;
import com.service.ui.web.SeleniumDriverWrapper;
import org.openqa.selenium.By;

public class Home extends PageObject {

    public NavigationPanel navigationPanel;
    public ObjectsList objectsList;

    private final By pageModeLabel = subclassInParentClass("pageModeLbl", "lbl-cnt");

    private final By plusBtn = classSelector("new-object-button");

    public Home(SeleniumDriverWrapper driver){
        super(driver.getBaseUrl() + "/home", driver);
        navigationPanel = new NavigationPanel(driver);
        objectsList = new ObjectsList(driver);
    }

    @Override
    public boolean validateElements() {
        return driver.waitUntilExist(pageModeLabel, 10)
                && driver.waitUntilExist(plusBtn)
                && navigationPanel.isRendered()
                && objectsList.isRendered();
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
            return new ChooseDashboardTemplate(driver);
        }
        if (currentUrl.contains("reports")){
            return new ChooseDataSource(driver);
        }
        if (currentUrl.contains("presentations")){
            return new Presentation(driver);
        }
        if (currentUrl.contains("datasources")){
            return new CreateNewIntegration(driver);
        }
        return this;
    }

}
