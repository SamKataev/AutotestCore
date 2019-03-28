package com.objects;

/**
 * an abstraction of complex web element on a specific web page
 * PageObject that hosts an instance of this class should call isRendered() to check if necessary web elements are available by web driver
 * inherited classes can contain other complex page elements inherited from PageElement
 */
import com.service.ui.web.SeleniumDriverWrapper;

public abstract class PageElement extends WebElementsContainer {

	public PageElement(SeleniumDriverWrapper driver){
		super(driver);
	}

}
