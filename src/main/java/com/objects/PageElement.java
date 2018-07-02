package com.objects;

/**
 * an abstraction of complex web element on a specific web page
 * parentPage prop is a PageObject instance that hosts(in browser) an instance of this class
 * PageObject that hosts an instance of this class should call isRendered() to check if necessary web elements are available by web driver
 * inherited classes can contain other complex page elements inherited from PageElement
 */
import com.service.ui.web.SeleniumDriverWrapper;

public abstract class PageElement extends WebElementsContainer {

    protected PageObject parentPage;

    public PageElement(SeleniumDriverWrapper driver, PageObject pageObj){
        super(driver);
        parentPage = pageObj;
    }

}
