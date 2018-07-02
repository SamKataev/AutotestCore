package com.objects.slemmaobjects.pageelements;

import com.objects.PageElement;
import com.objects.PageObject;
import com.service.ui.web.SeleniumDriverWrapper;
import org.openqa.selenium.By;

public class NavigatorObjectsList extends PageElement {

    public NavigatorObjectsList(SeleniumDriverWrapper driver, PageObject pageObj){
        super(driver, pageObj);
    }

    @Override
    public boolean validateElements() {
        return driver.waitUntilExist(classSelector("list-view__header-node"), 10)
                && driver.waitUntilExist(classSelector("list-view-listbox"));
    }

    ActionsMenu clickListItemByName(String name){
        driver.click(locatorOfItemByTitle(name));
        return new ActionsMenu(driver, this.parentPage);
    }

    ObjectContextMenu clickListItemContextBtnByName(String name){
        driver.click(locatorOfItemContextBtnByTitle(name));
        return new ObjectContextMenu(driver, this.parentPage);
    }

    protected By locatorOfItemByTitle(String title){
        return By.xpath("//div[contains(@title, '" + title + "')]/ancestor::div[contains(@class, 'listitem')]");
    }

    protected By locatorOfItemContextBtnByTitle(String title){
        return By.xpath("//div[contains(@title, '" + title + "')]/ancestor::div[contains(@class, 'listitem')]//div[contains(@class, 'btn_settings')]");
    }

    protected By locatorOfItemCheckboxByTitle(String title){
        return By.xpath("//div[contains(@title, '" + title + "')]/ancestor::div[contains(@class, 'listitem')]//div[contains(@class, 'listitem__img')]");
    }
}
