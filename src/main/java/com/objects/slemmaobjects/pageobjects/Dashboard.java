package com.objects.slemmaobjects.pageobjects;

import com.objects.slemmaobjects.SlemmaPageObject;
import com.objects.slemmaobjects.pageelements.ChartContextMenu;
import com.objects.slemmaobjects.pageelements.DashboardHeaderPanel;
import com.service.ui.web.SeleniumDriverWrapper;
import org.openqa.selenium.By;

public class Dashboard extends SlemmaPageObject {

    DashboardHeaderPanel headerPanel;
    ChartContextMenu contextMenu;

    private final By waiter = classSelector("process-waiter__container");

    public Dashboard(SeleniumDriverWrapper driver){
        super(driver.getBaseUrl()+"/auth", driver);
        headerPanel = new DashboardHeaderPanel(driver, this);
        contextMenu = new ChartContextMenu(driver, this);
    }

    @Override
    public boolean validateElements(){
        return driver.waitUntilDisappear(waiter, 10)
                && headerPanel.isRendered();
    }

    public boolean isEditable() {
        return  headerPanel.isRendered() && headerPanel.isEditable();
    }
}

