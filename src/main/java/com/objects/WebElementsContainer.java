package com.objects;

import com.service.ui.web.SeleniumDriverWrapper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

//Description:
//abstraction of container that initializes and uses web elements.
//implementation of setChildElements() should initialize web elements used by inherited class methods
//inherited classes can contain other page elements inherited from this class
//TO DO: add common methods to simplify web elements initialization

public abstract class WebElementsContainer {

    protected SeleniumDriverWrapper driver;

    public WebElementsContainer(SeleniumDriverWrapper webDriver){
        driver = webDriver;
    }

    protected abstract void setChildElements();

    protected WebElement getElementByClass(String name, int time){
        return driver.getElement(By.cssSelector("." + name), time);
    }

    protected WebElement getElementByClass(String name){
        return getElementByClass(name, driver.getDefaultWaitTime());
    }

    protected WebElement getInputByParentDivClass(String name, int time){
        return driver.getElement(By.xpath("//div[contains(@class, '" + name + "')]/input"), time);
    }

    protected WebElement getInputByParentDivClass(String name){
        return getInputByParentDivClass(name, driver.getDefaultWaitTime());
    }

}
