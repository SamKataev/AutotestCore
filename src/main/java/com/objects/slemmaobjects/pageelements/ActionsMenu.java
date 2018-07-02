package com.objects.slemmaobjects.pageelements;

import com.objects.PageElement;
import com.objects.PageObject;
import com.service.ui.web.SeleniumDriverWrapper;

public class ActionsMenu extends PageElement {

    public ActionsMenu(SeleniumDriverWrapper driver, PageObject pageObj){
        super(driver, pageObj);
    }

    @Override
    public boolean validateElements() {
        return driver.waitUntilExist(classSelector("list-view__header-node"), 10)
                && driver.waitUntilExist(classSelector("list-view-listbox"));
    }
}
