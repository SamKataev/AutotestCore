package com.objects;

import com.service.ui.web.SeleniumDriverWrapper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.HashMap;

//Description:
//abstraction of container that initializes and uses web elements.
//implementation of setChildElements() should initialize web elements used by inherited class methods
//inherited classes can contain other page elements inherited from this class

public abstract class WebElementsContainer {

    protected SeleniumDriverWrapper driver;

    public WebElementsContainer(SeleniumDriverWrapper webDriver){
        driver = webDriver;
    }

    protected abstract void setChildElements();

}
