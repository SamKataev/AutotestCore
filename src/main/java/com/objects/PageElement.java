package com.objects;

//Description:
//abstraction of complex web element on a specific web page
//PageObject should call setChildElements() of PageElement when it is implied to be available by web driver
//inherited classes can contain other complex page elements inherited from PageElement

import com.service.ui.web.SeleniumDriverWrapper;
import com.tests.ui.WebTest;

public abstract class PageElement extends WebElementsContainer {

    protected SeleniumDriverWrapper driver;

    public PageElement(SeleniumDriverWrapper driver, WebTest testClass){
        super(driver, testClass);
    }

}
