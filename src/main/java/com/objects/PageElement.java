package com.objects;



//Description:
//abstraction of complex web element on a specific web page
//inherited classes can contain other complex page elements inherited from PageElement

import com.service.ui.web.SeleniumDriverWrapper;

public abstract class PageElement extends WebElementsContainer {

    PageObject page;

    public PageElement(PageObject parentPage, SeleniumDriverWrapper webDriver){
        super(webDriver);
        page = parentPage;
        setChildElements();
    }

}
