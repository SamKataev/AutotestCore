package com.service.ui.web;

import com.service.ui.UIDriverWrapper;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.log4testng.Logger;

import java.util.HashMap;
import java.util.Set;
import java.util.concurrent.TimeUnit;

//Description:
//implicityWait web driver prop is set to 0, it is overriden by defaultWaitTime prop for more flexible timeouts adjustment
//initDriver() is abstract to be implemented in a specific driver wrapper class

public abstract class SeleniumDriverWrapper implements UIDriverWrapper {

    protected WebDriver driver;
    protected String mainHandle;

    enum WaiterType {VISIBLE, CLICKABLE, DISAPPEAR}
    private int defaultWaitTime;

    private static final Logger log = Logger.getLogger(SeleniumDriverWrapper.class);

    public boolean init(){
        if (initDriver()) {
            defaultWaitTime = 5;
            driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
            driver.manage().window().maximize();
            setMainWindowHandle(getCurrentWindowHandle());
            return true;
        }
        return false;
    }

    abstract boolean initDriver();

    public void close(){
        driver.close();
    }

    public void goToUrl(String url){
        driver.get(url);
    }

    public boolean checkCurrentUrl(String url){
        return driver.getCurrentUrl() == url;
    }

    public void switchWindow(){ //switches to random window other than main window
        Set<String> windowHandles = driver.getWindowHandles();
        if (windowHandles.size() > 1){
            windowHandles.forEach((handler)-> {
                if (!handler.equals(mainHandle)){
                    driver.switchTo().window(handler);
                }
            });
        }
    }

    public void switchToMainWindow(){
        driver.switchTo().window(getMainWindowHandle());
    }

    public String getMainWindowHandle(){
        return mainHandle;
    }

    public void setMainWindowHandle(String arg){
        mainHandle = arg;
    }

    public String getCurrentWindowHandle(){
        return driver.getWindowHandle();
    }

    public void setDefaultWaitTime(int time){
        defaultWaitTime = time;
    }

    public int getDefaultWaitTime(){
        return defaultWaitTime;
    }

    public WebElement getElement(By locator, int time){
        return waitUntilExist(locator, time) ? driver.findElement(locator) : null;
    }

    public WebElement getElement(By locator){
        return getElement(locator, defaultWaitTime);
    }

    private boolean waitUntilExist(By locator, int time){
       try {
           WebDriverWait wait = new WebDriverWait(driver, time);
           wait.until(ExpectedConditions.presenceOfElementLocated(locator));
       } catch (TimeoutException ex) {
           System.out.println("timeout " + time + " expired, EXIST by locator: " + locator.toString());
           return false;
       }
       return true;
    }

    public boolean waitUntilVisible(WebElement element, int time) {
        return waitUntilConditions(element, time, WaiterType.VISIBLE);
    }

    public boolean waitUntilVisible(WebElement element) {
       return waitUntilVisible(element, defaultWaitTime);
    }

    public boolean waitUntilClickable(WebElement element, int time) {
        return waitUntilConditions(element, time, WaiterType.CLICKABLE);
    }

    public boolean waitUntilClickable(WebElement element) {
        return waitUntilClickable(element, defaultWaitTime);
    }

    public boolean waitUntilDisappear(WebElement element, int time) {
        return waitUntilConditions(element, time, WaiterType.DISAPPEAR);
    }

    public boolean waitUntilDisappear(WebElement element) {
        return waitUntilDisappear(element, defaultWaitTime);
    }

    private boolean waitUntilConditions(WebElement element, int time, WaiterType type) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, time);
            if (type == WaiterType.VISIBLE) {
                wait.until(ExpectedConditions.visibilityOf(element));
            }
            if (type == WaiterType.CLICKABLE) {
                wait.until(ExpectedConditions.elementToBeClickable(element));
            }
            if (type == WaiterType.DISAPPEAR) {
                wait.until(ExpectedConditions.invisibilityOf(element));
            }
        } catch (TimeoutException ex) {
            System.out.println("timeout " + time + " expired, " + type.toString());
            return false;
        }
        return true;
    }

}
