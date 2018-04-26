package com.objects;

import com.service.ui.web.SeleniumDriverWrapper;
import com.tests.ui.WebTest;

//Description:
//abstraction of web page with specific url
//inherited classes should specify their url in constructor
//inherited classes can contain complex page elements inherited from PageElement

public abstract class PageObject extends WebElementsContainer {

    protected String url;

    public PageObject(String pageUrl, SeleniumDriverWrapper webDriver, WebTest testClass){
        super(webDriver, testClass);
        url = pageUrl;
    }

    public boolean isOpened(){
        return driver.checkCurrentUrl(url);
        //TODO: add more checks
    }

    public PageObject open(){
        driver.goToUrl(url);
        setChildElements();
        return this;
    }

    public String getUrl(){
        return url;
    }

}
