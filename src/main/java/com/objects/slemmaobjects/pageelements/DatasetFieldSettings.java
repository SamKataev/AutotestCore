package com.objects.slemmaobjects.pageelements;

import com.objects.PageElement;
import com.objects.slemmaobjects.pageobjects.Datasource;
import com.service.ui.web.SeleniumDriverWrapper;
import org.openqa.selenium.By;
import org.testng.Assert;

public class DatasetFieldSettings extends PageElement {

    private Datasource parentPage;

    private final String xpathBase = "//div[contains(@class, 'dialog__caption') and text()='Field settings']/ancestor::div[@class='dropdown__content']";

    private final By fieldName = By.xpath(xpathBase + "//div[contains(@class,'input__floating-label') and text()='Field name']/preceding-sibling::input[contains(@class,'input__nativeinput')]");
    private final By fieldType = By.xpath(xpathBase + "//div[contains(@class,'combo__floating-label') and text()='Type']/following-sibling::div[@class='content']//input[contains(@class,'input__nativeinput')]");
    private final By okBtn = By.xpath(xpathBase + "//div[@class='btn__cont' and text()='OK']");
    private final By cancelBtn = By.xpath(xpathBase + "//div[@class='btn__cont' and text()='Cancel']");

    public DatasetFieldSettings(SeleniumDriverWrapper driver, Datasource pageObj){
        super(driver);
        parentPage = pageObj;
    }

    @Override
    public boolean validateElements() {
        return driver.waitUntilExist(fieldName, 10)
                && driver.waitUntilExist(fieldType)
                && driver.waitUntilExist(okBtn)
                && driver.waitUntilExist(cancelBtn);
    }

    public DatasetFieldSettings checkIsRendered(){
        Assert.assertTrue(validateElements());
        return this;
    }

    public Datasource clickOK(){
        Assert.assertTrue(driver.click(okBtn));
        return parentPage;
    }

    public Datasource clickCancel(){
        Assert.assertTrue(driver.click(cancelBtn));
        return parentPage;
    }

    public DatasetFieldSettings typeFieldName(String name){
        Assert.assertTrue(driver.type(fieldName, name));
        return this;
    }

}
