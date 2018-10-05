package com.objects.slemmaobjects.pageobjects;

import com.objects.slemmaobjects.SlemmaPageObject;
import com.objects.slemmaobjects.pageelements.DatasetFieldSettings;
import com.service.ui.web.SeleniumDriverWrapper;
import org.openqa.selenium.By;
import org.testng.Assert;

public class Datasource extends SlemmaPageObject{

    DatasetFieldSettings fieldSettings;

    private final String xpathBase = "//div[@class='new-schemabox_header-left-node']/ancestor::div[@class='dropdown__content']";

    private final By fieldsTab = classWithText("lbl-cnt", "Fields");
    private final By dataTableTab = classWithText("lbl-cnt", "Data table");
    private final By doneBtn = classWithText("btn__cont", "Done");

    public Datasource(SeleniumDriverWrapper driver){
        super(driver.getBaseUrl()+"/datasources", driver);
    }

    @Override
    public boolean validateElements(){
        return driver.waitUntilDisappear(waiter, 20)
                && driver.waitUntilExist(fieldsTab, 10)
                && driver.waitUntilExist(dataTableTab);
    }

    public Datasource checkIsRendered() {
        super.checkIsRendered();
        return this;
    }

    public Datasource clickDone(){
        Assert.assertTrue(driver.click(doneBtn));
        return this;
    }

    public Datasource clickFieldsTab(){
        Assert.assertTrue(driver.click(fieldsTab));
        return this;
    }

    public Datasource clickDataTableTab(){
        Assert.assertTrue(driver.click(dataTableTab));
        return this;
    }

    public DatasetFieldSettings clickField(String name){
        Assert.assertTrue(driver.click(By.xpath(xpathBase + "//div[@class='listitem__content' and text()='" + name + "']")));
        return new DatasetFieldSettings(driver, this);
    }

}
