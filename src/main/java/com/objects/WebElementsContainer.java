package com.objects;

import com.service.ui.web.SeleniumDriverWrapper;
import org.openqa.selenium.By;

//Description:
//Purpose of this class is to encapsulate formatting locators of web elements
//inherited class should call getChildElements() to check if necessary web elements are available by web driver
//TODO: add common methods to simplify instantiation and usage of web elements

public abstract class WebElementsContainer {

    protected SeleniumDriverWrapper driver;


    public WebElementsContainer(SeleniumDriverWrapper webDriver){
        driver = webDriver;
    }

    public abstract boolean getChildElements();

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
