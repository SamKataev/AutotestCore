package com.objects.slemmaobjects.pageelements;

import com.objects.PageElement;
import com.objects.slemmaobjects.pageobjects.Dashboard;
import com.service.ui.web.SeleniumDriverWrapper;
import org.openqa.selenium.By;

public class DashboardHeaderPanel extends PageElement {

    private Dashboard parentPage;

    private final By logo = classSelector("logo-button");
    private final By title = classInParentClass("main-title-button", "btn__cont");
    private final By homeBtn = idSelector("designerHomeButton");
    private final By rightPanel = classSelector("context-header-node__right-part");
    private final By switcher = classSelector("switcher__axis");


    public DashboardHeaderPanel(SeleniumDriverWrapper driver, Dashboard pageObj){
        super(driver);
        parentPage = pageObj;
    }

    @Override
    public boolean validateElements() {
        return driver.waitUntilExist(logo , 10)
                && driver.waitUntilExist(title)
                && driver.waitUntilExist(rightPanel)
                && driver.waitUntilExist(homeBtn);
    }

    public boolean isEditable(){
        return driver.waitUntilExist(By.xpath("//div[contains(@class, 'switcher_checked')]"), 1);
    }

    public void switchEdit(){
        driver.click(switcher);
    }

}
