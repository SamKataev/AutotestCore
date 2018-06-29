package com.objects.slemmaobjects.pageelements;

import com.objects.PageElement;
import com.service.ui.web.SeleniumDriverWrapper;

public class ContextMenu extends PageElement {

    public ContextMenu(SeleniumDriverWrapper driver){
        super(driver);
    }

    @Override
    public boolean validateElements() {
        return driver.waitUntilExist(classSelector("dropmenu__content"), 10);
    }

}
