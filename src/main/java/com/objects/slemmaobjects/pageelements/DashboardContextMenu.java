package com.objects.slemmaobjects.pageelements;

import com.objects.PageElement;
import com.objects.PageObject;
import com.objects.slemmaobjects.pageobjects.Dashboard;
import com.service.ui.web.SeleniumDriverWrapper;
import org.openqa.selenium.By;

public class DashboardContextMenu extends PageElement{

    private final By panelLabel = classSelector("sub-panel__header-label");
    private final By saveBtn = classWithText("listitem__content", "Save");
    private final By saveAsBtn = classWithText("listitem__content", "Save as...");
    private final By shareAndExportBtn = classWithText("listitem__content", "Share & export");
    private final By detailsBtn = classWithText("listitem__content", "Details");
    private final By dataRefreshSettingsBtn = classWithText("listitem__content", "Data Refresh Settings");
    private final By settingsBtn = classWithText("listitem__content", "Settings");
    private final By downloadTemplBtn = classWithText("listitem__content", "Download template");

    public DashboardContextMenu(SeleniumDriverWrapper driver, PageObject pageObj){
        super(driver, pageObj);
    }

    @Override
    public boolean validateElements() {
        return driver.waitUntilExist(panelLabel , 10)
                && driver.waitUntilExist(shareAndExportBtn)
                && driver.waitUntilExist(detailsBtn)
                && driver.waitUntilExist(dataRefreshSettingsBtn)
                && driver.waitUntilExist(downloadTemplBtn)
                && (!((Dashboard) parentPage).isEditable() || driver.waitUntilExist(saveBtn))
                && (!((Dashboard) parentPage).isEditable() || driver.waitUntilExist(saveAsBtn))
                && (!((Dashboard) parentPage).isEditable() || driver.waitUntilExist(settingsBtn));
    }
}
