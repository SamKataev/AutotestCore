package com.objects.slemmaobjects.pageelements;

import com.objects.PageElement;
import com.objects.slemmaobjects.pageobjects.Home;
import com.service.ui.web.SeleniumDriverWrapper;
import org.openqa.selenium.By;

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

    ActionsMenu clickListItemByName(String name){
        driver.click(itemByTitle(name));
        return new ActionsMenu(driver, this.parentPage);
    }

    ObjectContextMenu clickListItemContextBtnByName(String name){
        driver.click(itemContextBtnByTitle(name));
        return new ObjectContextMenu(driver, this.parentPage);
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
