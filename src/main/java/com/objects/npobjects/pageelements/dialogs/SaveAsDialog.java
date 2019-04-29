package com.objects.npobjects.pageelements.dialogs;

import com.objects.npobjects.pageobjects.Main;
import com.objects.npobjects.pageobjects.ReportsCreate;
import com.service.ui.web.SeleniumDriverWrapper;
import junit.framework.Assert;
import org.openqa.selenium.By;

public class SaveAsDialog extends Dialog {

    private ReportsCreate parentPage;

    private final By cancelBtn = dialogMdcTextBtn("Cancel");
    private final By okBtn = dialogMdcTextBtn("OK");
    private final By inputName = dialogNpTextFieldWithLabel("Name");


    public SaveAsDialog(SeleniumDriverWrapper driver, ReportsCreate pageObj) {
        super(driver);
        parentPage = pageObj;
    }

    @Override
    public boolean validateElements() {
        return driver.waitUntilExist(okBtn, 5)
                && driver.waitUntilClickable(cancelBtn);
    }
    public SaveAsDialog checkIsRendered() {
        super.checkIsRendered();
        return this;
    }
    public SaveAsDialog clickOkBtn(){
        Assert.assertTrue(driver.click(okBtn));
        return this;
    }
    public SaveAsDialog enterInputName (String text){
        org.testng.Assert.assertTrue(driver.type(inputName ,text));
        return this;
    }
}
