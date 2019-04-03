package com.objects.npobjects.pageelements.dropdown;

import com.objects.PageElement;
import com.service.ui.web.SeleniumDriverWrapper;
import junit.framework.Assert;
import org.openqa.selenium.By;

public abstract class DropDown extends PageElement {



    public DropDown(SeleniumDriverWrapper driver) {
        super(driver);
    }


    protected By dropDownMdcListItemWithText(String text) {
        return By.xpath("//div[contains(@class, 'np-menu dropdown_vis')]//span[contains(@class, 'mdc-list-item__text') and contains(text(), '" + text + "')]/parent::li");
    }

    protected By dropDownMdcListItemWithText(String text, String dialogClass) {
        return By.xpath("//div[contains(@class, 'np-menu dropdown_vis') and contains(@class, '" + dialogClass + "')]//span[contains(@class, 'mdc-list-item__text') and contains(text(), '" + text + "')]/parent::li");
    }

    protected By dropDownMdcListItemWithTextIcon(String text, String iconClass) {
        return By.xpath("//div[contains(@class, 'np-menu dropdown_vis')]//span[contains(@class, 'mdc-list-item__text') and contains(text(), '" + text + "')]/preceding-sibling::span[contains(@class, '" + iconClass + "')]/parent::li");
    }

    protected By dropDownMdcListItemWithTextIcon(String text, String iconClass, String dialogClass) {
        return By.xpath("//div[contains(@class, 'np-menu dropdown_vis') and contains(@class, '" + dialogClass + "')]//span[contains(@class, 'mdc-list-item__text') and contains(text(), '" + text + "')]/preceding-sibling::span[contains(@class, '" + iconClass + "')]/parent::li");
    }


}