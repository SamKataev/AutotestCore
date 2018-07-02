package com.objects.slemmaobjects.pageelements;

import com.objects.PageElement;
import com.objects.PageObject;
import com.service.ui.web.SeleniumDriverWrapper;

public class ObjectContextMenu extends PageElement {

    public ObjectContextMenu(SeleniumDriverWrapper driver, PageObject pageObj){
        super(driver, pageObj);
    }

    @Override
    public boolean validateElements() {
        return driver.waitUntilExist(classSelector("dropmenu__content"), 10);
    }

}
