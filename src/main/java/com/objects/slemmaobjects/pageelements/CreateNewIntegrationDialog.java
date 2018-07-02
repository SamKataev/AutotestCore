package com.objects.slemmaobjects.pageelements;

import com.objects.PageElement;
import com.objects.slemmaobjects.pageobjects.Home;
import com.service.ui.web.SeleniumDriverWrapper;
import org.openqa.selenium.By;

public class CreateNewIntegrationDialog extends PageElement {

    private Home parentPage;

    private final By labelCreateNew = classContainsText("listitem__content", "Create new");
    private final By uploadFileBtn = containsText("Upload a File");
    private final By uploadByUrlBtn = containsText("File by URL");

    public CreateNewIntegrationDialog(SeleniumDriverWrapper driver, Home pageObj) {
        super(driver);
        parentPage = pageObj;
    }

    @Override
    public boolean validateElements() {
        return driver.waitUntilExist(uploadFileBtn)
                && driver.waitUntilExist(uploadByUrlBtn)
                && driver.waitUntilExist(labelCreateNew);
    }
}
