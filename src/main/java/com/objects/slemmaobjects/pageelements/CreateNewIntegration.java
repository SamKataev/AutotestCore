package com.objects.slemmaobjects.pageelements;

import com.objects.PageElement;
import com.service.ui.web.SeleniumDriverWrapper;
import org.openqa.selenium.By;

public class CreateNewIntegration extends PageElement {

    private final By labelCreateNew = classContainsText("listitem__content", "Create new");
    private final By uploadFileBtn = containsText("Upload a File");
    private final By uploadByUrlBtn = containsText("File by URL");

    public CreateNewIntegration(SeleniumDriverWrapper driver) {
        super(driver);
    }

    @Override
    public boolean validateElements() {
        return driver.waitUntilExist(uploadFileBtn)
                && driver.waitUntilExist(uploadByUrlBtn)
                && driver.waitUntilExist(labelCreateNew);
    }
}
