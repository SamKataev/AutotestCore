package com.objects.slemmaobjects.pageelements;

import com.objects.PageElement;
import com.objects.slemmaobjects.pageobjects.Home;
import com.service.ui.web.SeleniumDriverWrapper;
import org.openqa.selenium.By;
import org.testng.Assert;

public class NavigatorObjectsList extends PageElement {

    private Home parentPage;

    public NavigatorObjectsList(SeleniumDriverWrapper driver, Home pageObj){
        super(driver);
        parentPage = pageObj;
    }

    @Override
    public boolean validateElements() {
        return driver.waitUntilExist(classSelector("list-view__header-node"), 10)
                && driver.waitUntilExist(classSelector("list-view-listbox"));
    }

    public NavigatorObjectsList checkIsRendered(){
        Assert.assertTrue(validateElements());
        return this;
    }

    public ActionsMenu clickDatasourceByName(String name){
        Assert.assertTrue(driver.click(itemByNameAndType(name, "Schema")));
        return new ActionsMenu(driver, parentPage);
    }

    public void clickDashboardByName(String name){
        Assert.assertTrue(driver.click(itemByNameAndType(name, "Dashboard")));
    }

    public ObjectContextMenu clickListItemContextBtnByName(String name){
        driver.click(itemContextBtnByTitle(name));
        return new ObjectContextMenu(driver, this.parentPage);
    }

    protected By itemByName(String name){
        return By.xpath("//span[@class='nameSpan' and text()='" + name + "']/ancestor::div[contains(@class, 'listitem')]");
    }

    protected By itemByNameAndType(String name, String type){
        return By.xpath("//span[@class='nameSpan' and text()='" + name + "']/ancestor::div[contains(@class, 'listitem') and contains(@class, '" + type + "')]");
    }

    protected By itemContextBtnByName(String name){
        return By.xpath("//span[@class='nameSpan' and text()='" + name + "']/ancestor::div[contains(@class, 'listitem')]//div[contains(@class, 'btn_settings')]");
    }

    protected By itemCheckboxByName(String name){
        return By.xpath("//span[@class='nameSpan' and text()='" + name + "']/ancestor::div[contains(@class, 'listitem')]//div[contains(@class, 'listitem__img')]");
    }

    protected By itemByTitle(String title){
        return By.xpath("//div[contains(@title, '" + title + "')]/ancestor::div[contains(@class, 'listitem')]");
    }

    protected By itemContextBtnByTitle(String title){
        return By.xpath("//div[contains(@title, '" + title + "')]/ancestor::div[contains(@class, 'listitem')]//div[contains(@class, 'btn_settings')]");
    }

    protected By itemCheckboxByTitle(String title){
        return By.xpath("//div[contains(@title, '" + title + "')]/ancestor::div[contains(@class, 'listitem')]//div[contains(@class, 'listitem__img')]");
    }
}
