package com.objects.slemmaobjects.pageelements;

import com.objects.PageElement;
import com.objects.slemmaobjects.SlemmaPageObject;
import com.service.ui.web.SeleniumDriverWrapper;
import org.openqa.selenium.By;
import org.testng.Assert;

public class RenameDialog extends PageElement{

    private SlemmaPageObject parentPage;

    String xpathBase= "//div[contains(@class, 'dialog__caption') and text()= 'Rename']/ancestor::div[@class='dropdown__content']";

    private final By nameInput = By.xpath(xpathBase + "//input");
    private final By cancelBtn = By.xpath(xpathBase + "//div[@class='btn__cont' and text()='Cancel']");
    private final By renameBtn = By.xpath(xpathBase + "//div[@class='btn__cont' and text()='Rename']");


    public RenameDialog(SeleniumDriverWrapper driver, SlemmaPageObject pageObj){
        super(driver);
        parentPage = pageObj ;
    }

    @Override
    public boolean validateElements() {
        return driver.waitUntilExist(nameInput, 10)
                && driver.waitUntilExist(cancelBtn)
                && driver.waitUntilExist(renameBtn);
    }

    public RenameDialog checkIsRendered(){
        Assert.assertTrue(validateElements());
        return this;
    }

    public RenameDialog typeName(String name){
        Assert.assertTrue(driver.type(nameInput, name));
        return this;
    }

    public SlemmaPageObject clickCancel(){
        Assert.assertTrue(driver.click(cancelBtn));
        return parentPage;
    }

    public SlemmaPageObject clickRename(){
        Assert.assertTrue(driver.click(renameBtn));
        return parentPage;
    }
}
