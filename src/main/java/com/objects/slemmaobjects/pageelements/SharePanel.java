package com.objects.slemmaobjects.pageelements;

import com.objects.PageElement;
import com.objects.slemmaobjects.pageobjects.Home;
import com.service.ui.web.SeleniumDriverWrapper;

public class SharePanel extends PageElement {

    private Home parentPage;

    public SharePanel(SeleniumDriverWrapper driver, Home pageObj){
        super(driver);
        parentPage = pageObj ;
    }

    @Override
    public boolean validateElements() {
        return driver.waitUntilExist(classWithText("sub-panel__header-label", "Share"), 10);
    }
}
