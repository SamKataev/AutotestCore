package com.objects.npobjects.pageelements.dropdown;

import com.objects.npobjects.pageelements.dialogs.CreateAlertDialog;
import com.objects.npobjects.pageobjects.Main;
import com.service.ui.web.SeleniumDriverWrapper;
import junit.framework.Assert;
import org.openqa.selenium.By;

/**
 * Created by Kate on 03-Apr-19.
 */
public class IntegrationsDropDown extends DropDown {

    private Main parentPage;

    private final By databaseBtn = dropDownMdcListItemWithText("Database");
    private final By saasBtn = dropDownMdcListItemWithText("SaaS");

    public IntegrationsDropDown (SeleniumDriverWrapper driver, com.objects.npobjects.pageobjects.Main pageObj) {
        super(driver);
        parentPage = pageObj;
    }

    @Override
    public boolean validateElements() {
        return driver.waitUntilClickable(databaseBtn,5)
                && driver.waitUntilClickable(saasBtn);
    }
    public IntegrationsDropDown checkIsRendered() {
        super.checkIsRendered();
        return this;
    }

    public IntegrationsDropDown clickSaasBtn(){
        Assert.assertTrue(driver.click(saasBtn));
        return this;
    }
    public IntegrationsDropDown clickDatabaseBtn(){
        Assert.assertTrue(driver.click(databaseBtn));
        return this;
    }


}
