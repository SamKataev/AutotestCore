package com.objects.slemmaobjects.pageelements;

import com.objects.PageElement;
import com.objects.slemmaobjects.pageobjects.Dashboard;
import com.service.ui.web.SeleniumDriverWrapper;
import org.openqa.selenium.By;

public class ChartContextMenu extends PageElement{

    private Dashboard parentPage;

    private final By panelLabel = classSelector("sub-panel__header-label");
    private final By saveBtn = classWithText("listitem__content", "Save");
    private final By saveAsBtn = classWithText("listitem__content", "Save as...");
    private final By shareAndExportBtn = classWithText("listitem__content", "Share & export");
    private final By detailsBtn = classWithText("listitem__content", "Details");
    private final By dataRefreshSettingsBtn = classWithText("listitem__content", "Data Refresh Settings");
    private final By settingsBtn = classWithText("listitem__content", "Settings");
    private final By downloadTemplBtn = classWithText("listitem__content", "Download template");

    public ChartContextMenu(SeleniumDriverWrapper driver, Dashboard pageObj){
        super(driver);
        parentPage = pageObj;
    }

    @Override
    public boolean validateElements() {
        return driver.waitUntilExist(panelLabel , 10)
                && driver.waitUntilExist(shareAndExportBtn)
                && driver.waitUntilExist(detailsBtn)
                && driver.waitUntilExist(dataRefreshSettingsBtn)
                && driver.waitUntilExist(downloadTemplBtn)
                && (!parentPage.isEditable() || driver.waitUntilExist(saveBtn))
                && (!parentPage.isEditable() || driver.waitUntilExist(saveAsBtn))
                && (!parentPage.isEditable() || driver.waitUntilExist(settingsBtn));
    }
}
