package com.objects;

import com.service.ui.web.SeleniumDriverWrapper;
import org.openqa.selenium.By;

/**
 * purpose of this class is to encapsulate formatting locators of web elements
 * inherited class should call isRendered() or validateElements() to check if necessary web elements are rendered and available by web driver
 */
public abstract class WebElementsContainer {

    protected SeleniumDriverWrapper driver;

    public WebElementsContainer(SeleniumDriverWrapper webDriver){
        driver = webDriver;
    }

    public abstract boolean validateElements();

    public boolean isRendered(){
        return validateElements();
        //TODO: add more checks i.e all ajax requests resolved
    }

    protected By locatorByClass(String name){
        return By.cssSelector("." + name);
    }

    protected By locatorByInputInParentDivClass(String name){
        return By.xpath("//div[contains(@class, '" + name + "')]/input");
    }

    protected By locatorBySubclassInParentClass(String className, String subclassName){
        return By.xpath("//div[contains(@class, '" + className + "')]//div[contains(@class, '" + subclassName + "')]");
    }

}
