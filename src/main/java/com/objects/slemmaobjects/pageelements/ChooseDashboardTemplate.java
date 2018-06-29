package com.objects.slemmaobjects.pageelements;

import com.objects.PageElement;
import com.service.ui.web.SeleniumDriverWrapper;
import org.openqa.selenium.By;

public class ChooseDashboardTemplate extends PageElement {

    private final By labelTemplates = classContainsText("listitem__content", "Templates");
    private final By blankBtn = classSelector("listitem_blank-object");

    public ChooseDashboardTemplate(SeleniumDriverWrapper driver) {
        super(driver);
    }

    @Override
    public boolean validateElements() {
        return driver.waitUntilExist(labelTemplates)
                && driver.waitUntilExist(blankBtn);
    }
}
