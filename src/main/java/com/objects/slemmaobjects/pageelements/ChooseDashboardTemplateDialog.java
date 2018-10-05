package com.objects.slemmaobjects.pageelements;

import com.objects.PageElement;
import com.objects.slemmaobjects.pageobjects.Home;
import com.service.ui.web.SeleniumDriverWrapper;
import org.openqa.selenium.By;
import org.testng.Assert;

public class ChooseDashboardTemplateDialog extends PageElement {

    private Home parentPage;

    private final By labelTemplates = classContainsText("listitem__content", "Templates");
    private final By blankBtn = classSelector("listitem_blank-object");

    public ChooseDashboardTemplateDialog(SeleniumDriverWrapper driver, Home pageObj) {
        super(driver);
        parentPage = pageObj;
    }

    @Override
    public boolean validateElements() {
        return driver.waitUntilExist(labelTemplates)
                && driver.waitUntilExist(blankBtn);
    }

    public ChooseDashboardTemplateDialog checkIsRendered(){
        Assert.assertTrue(validateElements());
        return this;
    }
}
