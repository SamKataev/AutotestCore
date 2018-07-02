package com.objects.slemmaobjects.pageelements;

import com.objects.PageElement;
import com.objects.PageObject;
import com.service.ui.web.SeleniumDriverWrapper;
import org.openqa.selenium.By;

public class CreateNewFolder extends PageElement{

    private final By labelNewFolder = containsText("New folder");
    private final By folderNameInput = containsValue("Untitled folder");
    private final By cancelBtn = classContainsText("btn__cont","Cancel");
    private final By createBtn = classContainsText("btn__cont","Create");

    public CreateNewFolder(SeleniumDriverWrapper driver, PageObject pageObj){
        super(driver, pageObj);
    }

    @Override
    public boolean validateElements() {
        return driver.waitUntilExist(folderNameInput, 2)
                && driver.waitUntilExist(labelNewFolder)
                && driver.waitUntilExist(cancelBtn)
                && driver.waitUntilExist(createBtn);
    }

    public CreateNewFolder enterFolderName(String text) {
        driver.type(folderNameInput, text);
        return this;
    }

    public void clickCancel() {
        driver.click(cancelBtn);
    }

    public void clickCreate() {
        driver.click(createBtn);
    }
}
