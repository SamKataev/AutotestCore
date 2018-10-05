package com.objects.slemmaobjects.pageelements;

import com.objects.PageElement;
import com.objects.slemmaobjects.pageobjects.Dashboard;
import com.service.ui.web.SeleniumDriverWrapper;
import org.openqa.selenium.By;
import org.testng.Assert;

public class SaveAsDialog extends PageElement {

    private Dashboard parentPage;

    private final By caption = classWithText("dialog__caption", "Save dashboard as");
    private final By nameInput = inputInParentDivClass("dialog__content");
    private final By foldersCombo = classWithText("content", "Root Folder");
    private final By cancelBtn = classWithText("btn__cont", "Cancel");
    private final By okBtn = classWithText("btn__cont", "OK");

    public SaveAsDialog(SeleniumDriverWrapper driver, Dashboard pageObj){
        super(driver);
        parentPage = pageObj;
    }

    @Override
    public boolean validateElements() {
        return driver.waitUntilExist(caption, 5)
                && driver.waitUntilExist(nameInput)
                && driver.waitUntilExist(foldersCombo)
                && driver.waitUntilExist(cancelBtn)
                && driver.waitUntilExist(okBtn);
    }

    public SaveAsDialog checkIsRendered(){
        Assert.assertTrue(validateElements());
        return this;
    }

    public SaveAsDialog typeName(String name){
        driver.type(nameInput, name);
        return this;
    }

    public Dashboard clickCancel(){
        driver.click(cancelBtn);
        return this.parentPage;
    }

    public Dashboard clickOk(){
        driver.click(okBtn);
        return this.parentPage;
    }
}
