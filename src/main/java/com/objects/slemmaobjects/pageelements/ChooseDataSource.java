package com.objects.slemmaobjects.pageelements;

import com.objects.PageElement;
import com.objects.PageObject;
import com.service.ui.web.SeleniumDriverWrapper;
import org.openqa.selenium.By;

public class ChooseDataSource extends PageElement {

    private final By labelChooseDataSource = classContainsText("dialog__caption", "Choose a Data Source");
    private final By createNewBtn = classContainsText("btn__cont", "Create new");

    public ChooseDataSource(SeleniumDriverWrapper driver, PageObject pageObj) {
        super(driver, pageObj);
    }

    @Override
    public boolean validateElements() {
        return driver.waitUntilExist(classSelector("listbox-connections"), 10)
                && driver.waitUntilExist(createNewBtn)
                && driver.waitUntilExist(labelChooseDataSource);
    }


}
