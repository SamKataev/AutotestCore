package com.objects;

import com.service.ui.web.SeleniumDriverWrapper;

//Description:
//abstraction of web page with specific url
//inherited classes should specify their url in constructor
//inherited classes can contain complex page elements inherited from PageElement

public abstract class PageObject extends WebElementsContainer {

    protected String url;

    public PageObject(String pageUrl, SeleniumDriverWrapper webDriver){
        super(webDriver);
        url = pageUrl;
    }

    public boolean isOpened(){
        return getChildElements();
        //TODO: add more checks
    }

    public PageObject open(){
        driver.goToUrl(url);
        return this;
    }

    public String getUrl(){
        return url;
    }

}
