package com.objects.slemmaobjects.pageelements;

import com.objects.PageElement;
import com.objects.slemmaobjects.pageobjects.Home;
import com.service.ui.web.SeleniumDriverWrapper;

public class ObjectContextMenu extends PageElement {

    private Home parentPage;

    public ObjectContextMenu(SeleniumDriverWrapper driver, Home pageObj){
        super(driver);
        parentPage = pageObj;
    }

    @Override
    public boolean validateElements() {
        return driver.waitUntilExist(classSelector("dropmenu__content"), 10);
    }

}
