package com.objects;

import com.service.ui.web.SeleniumDriverWrapper;
import org.openqa.selenium.By;
import org.testng.Assert;

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

    public void checkIsRendered(){
        Assert.assertTrue(isRendered());
    }

    protected By classSelector(String name){
        return By.cssSelector("." + name);
    }

    protected By idSelector(String id){
        return By.id(id);
    }

    protected By containsText(String text){
        return By.xpath("//*[contains(text(), '" + text + "')]");
    }

    protected By containsValue(String text){
        return By.xpath("//*[contains(@value, '" + text + "')]");
    }

    protected By classContainsText(String name, String text){
        return By.xpath("//*[contains(@class, '" + name + "') and contains(text(), '" + text + "')]");
    }

    protected By classWithText(String name, String text){
        return By.xpath("//*[contains(@class, '" + name + "') and text() = '" + text + "']");
    }

    protected By inputInParentDivClass(String name){
        return By.xpath("//div[contains(@class, '" + name + "')]//input");
    }

    protected By subclassInParentClass(String className, String subclassName){
        return By.xpath("//div[contains(@class, '" + className + "')]//div[contains(@class, '" + subclassName + "')]");
    }

}
