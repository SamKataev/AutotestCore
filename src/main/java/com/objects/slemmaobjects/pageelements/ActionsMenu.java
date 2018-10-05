package com.objects.slemmaobjects.pageelements;

import com.objects.PageElement;
import com.objects.slemmaobjects.pageobjects.Home;
import com.service.ui.web.SeleniumDriverWrapper;
import org.openqa.selenium.By;
import org.testng.Assert;

public class ActionsMenu extends PageElement {

    private Home parentPage;

    private final By editor = classWithText("listitem__content", "Dataset editor");
    private final By dashboard = classWithText("listitem__content", "Create dashboard");
    private final By savedChart = classWithText("listitem__content", "Create saved chart");
    private final By presentation = classWithText("listitem__content", "Create presentation");
    private final By share = classWithText("listitem__content", "Share");

    public ActionsMenu(SeleniumDriverWrapper driver, Home pageObj){
        super(driver);
        parentPage = pageObj ;
    }

    @Override
    public boolean validateElements() {
        return driver.waitUntilExist(classWithText("dialog__caption", "Choose an action"), 10)
                && driver.waitUntilExist(editor)
                && driver.waitUntilExist(dashboard)
                && driver.waitUntilExist(savedChart)
                && driver.waitUntilExist(presentation)
                && driver.waitUntilExist(share);
    }

    public ActionsMenu checkIsRendered(){
        Assert.assertTrue(validateElements());
        return this;
    }

    public boolean clickEditor(){
        return driver.click(editor);
    }

    public boolean clickDashboard(){
        return driver.click(dashboard);
    }

    public boolean clickSavedChart(){
        return driver.click(savedChart);
    }

    public boolean clickPresentation(){
        return driver.click(presentation);
    }

    public SharePanel clickshare(){
       driver.click(share);
       return new SharePanel(driver, parentPage);
    }
}
