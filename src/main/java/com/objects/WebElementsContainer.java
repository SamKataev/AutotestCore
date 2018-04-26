package com.objects;

import com.service.ui.web.SeleniumDriverWrapper;
import com.tests.ui.WebTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

//Description:
//Purpose of this class is to encapsulate usage of web elements
//inherited class should call setChildElements() when it is implied to be available by web driver (i.e. when PageObject is opened in browser, when PageElement is clickable)
//purpose of currentTest prop is to access other WebElementsContainers (commonly PageObjects) that are declared in current test class
//TODO: add common methods to simplify instantiation and usage of web elements

public abstract class WebElementsContainer {

    protected SeleniumDriverWrapper driver;
    protected WebTest currentTest;

    public WebElementsContainer(SeleniumDriverWrapper webDriver, WebTest testClass){
        driver = webDriver;
        currentTest = testClass;
    }

    public abstract WebElementsContainer setChildElements();

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

    protected WebElement getElementBySubclassInParentClass(String className, String subclassName, int time){
        return driver.getElement(By.xpath("//div[contains(@class, '" + className + "')]//div[contains(@class, '" + subclassName + "')]"), time);
    }

    protected WebElement getElementBySubclassInParentClass(String className, String subclassName){
        return getElementBySubclassInParentClass(className, subclassName, driver.getDefaultWaitTime());
    }

}
