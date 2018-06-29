package com.objects.slemmaobjects.pageelements;

import com.objects.PageElement;
import com.service.ui.web.SeleniumDriverWrapper;

public class ActionsMenu extends PageElement {

    public ActionsMenu(SeleniumDriverWrapper driver){
        super(driver);
    }

    @Override
    public boolean validateElements() {
        return driver.waitUntilExist(classSelector("list-view__header-node"), 10)
                && driver.waitUntilExist(classSelector("list-view-listbox"));
    }
}
