package com.objects.slemmaobjects.pageelements;

import com.objects.PageElement;
import com.objects.slemmaobjects.pageobjects.Home;
import com.service.ui.web.SeleniumDriverWrapper;
import org.openqa.selenium.By;
import org.testng.Assert;

public class CreateNewFolderDialog extends PageElement{

    private Home parentPage;

    private final By labelNewFolder = containsText("New folder");
    private final By folderNameInput = containsValue("Untitled folder");
    private final By cancelBtn = classContainsText("btn__cont","Cancel");
    private final By createBtn = classContainsText("btn__cont","Create");

    public CreateNewFolderDialog(SeleniumDriverWrapper driver, Home pageObj){
        super(driver);
        parentPage = pageObj;
    }

    @Override
    public boolean validateElements() {
        return driver.waitUntilExist(folderNameInput, 2)
                && driver.waitUntilExist(labelNewFolder)
                && driver.waitUntilExist(cancelBtn)
                && driver.waitUntilExist(createBtn);
    }

    public CreateNewFolderDialog checkIsRendered(){
        Assert.assertTrue(validateElements());
        return this;
    }

    public CreateNewFolderDialog enterFolderName(String text) {
        driver.type(folderNameInput, text);
        return this;
    }

    public Home clickCancel() {
        driver.click(cancelBtn);
        return parentPage;
    }

    public Home clickCreate() {
        driver.click(createBtn);
        return parentPage;
    }
}
