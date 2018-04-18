package com.objects;

import com.service.ui.web.SeleniumDriverWrapper;

//Description:
//abstraction of web page with specific url.
//inherited classes can contain complex page elements inherited from PageElement

public abstract class PageObject extends WebElementsContainer {

    String url;

    public PageObject(String pageUrl, SeleniumDriverWrapper webDriver){
        super(webDriver);
        url = pageUrl;
        driver.goToUrl(url);
        setChildElements();
    }

}
