package com.service.ui.web;

import com.service.ui.UIDriverWrapper;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.log4testng.Logger;
import java.util.Set;
import java.util.concurrent.TimeUnit;

//Description:
//Purpose of this wrapper is to encapsulate usage of selenium WebDriver:
//    - all WebDriverExceptions should be caught in this class
//    - all methods should return void or boolean to simplify assertion
//    - all methods that use WebElement should accept wait timeout argument of type int
//    - implicitlyWait web driver prop is set to 0, it is "overridden" by defaultWaitTime prop for more flexible timeouts adjustment
//    - initDriver() is abstract to be implemented in a specific driver wrapper class


public abstract class SeleniumDriverWrapper implements UIDriverWrapper {

    protected WebDriver webDriver;
    protected String mainHandle;
    protected String baseUrl;

    enum WaiterType {EXIST, VISIBLE, CLICKABLE, DISAPPEAR}
    private int defaultWaitTime;

    private static final Logger log = Logger.getLogger(SeleniumDriverWrapper.class);

    public boolean init(){
        if (initDriver()) {
            defaultWaitTime = 5;
            webDriver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
            webDriver.manage().window().maximize();
            setMainWindowHandle(getCurrentWindowHandle());
            return true;
        }
        return false;
    }

    abstract boolean initDriver();

    public void close(){
        try {
            webDriver.close();
        }catch (WebDriverException e){
            System.out.println("error closing web driver in driver wrapper: " + e.getMessage());
        }
    }

    public boolean click(Object object){
        if (object instanceof By){
           return clickWebElement((By) object, defaultWaitTime);
        }
        else{
            System.out.println("wrong argument type");
        }
        return false;
    }

    public boolean type(Object object, String text){
        if (object instanceof By){
            return typeWebElement((By) object, text, defaultWaitTime);
        }
        else{
            System.out.println("wrong argument type");
        }
        return false;
    }

    public boolean click(By locator, int time){
        return clickWebElement(locator, time);
    }

    public boolean type(By locator, String text, int time){
        return typeWebElement(locator, text, time);
    }

    private boolean clickWebElement(By locator, int time){
        if (waitUntilClickable(locator, time)) {
            try {
                getElement(locator, time).click();
                return true;
            }catch (WebDriverException e){
                System.out.println("error clicking web element" + getElement(locator, time).getLocation() + ": " + e.getMessage().substring(0,35) + "...");
            }
        }
        return false;
    }

    private boolean typeWebElement(By locator, String text, int time){
        if (waitUntilClickable(locator, time) && clickWebElement(locator, time)){
            try {
                getElement(locator, time).sendKeys(text);
                return true;
            }catch (WebDriverException e){
                System.out.println("error typing in web element" + getElement(locator, time).getLocation() + ": " + e.getMessage().substring(0,35) + "...");
            }
        }
        return false;
    }

    public void goToUrl(String url){
        webDriver.get(url);
    }

    public boolean checkCurrentUrl(String url){
        return webDriver.getCurrentUrl().equals(url);
    }

    public void switchWindow(){ //switches to random window other than main window
        Set<String> windowHandles = webDriver.getWindowHandles();
        if (windowHandles.size() > 1){
            windowHandles.forEach((handler)-> {
                if (!handler.equals(mainHandle)){
                    webDriver.switchTo().window(handler);
                }
            });
        }
    }

    public void switchToMainWindow(){
        webDriver.switchTo().window(getMainWindowHandle());
    }

    public String getBaseUrl(){
        return baseUrl;
    }

    public void setBaseUrl(String url){
        baseUrl = url;
    }

    public String getMainWindowHandle(){
        return mainHandle;
    }

    public void setMainWindowHandle(String arg){
        mainHandle = arg;
    }

    public String getCurrentWindowHandle(){
        return webDriver.getWindowHandle();
    }

    public void setDefaultWaitTime(int time){
        defaultWaitTime = time;
    }

    public int getDefaultWaitTime(){
        return defaultWaitTime;
    }

    public WebElement getElement(By locator, int time){
        return waitUntilExist(locator, time) ? webDriver.findElement(locator) : null;
    }

    public WebElement getElement(By locator){
        return getElement(locator, defaultWaitTime);
    }

    public boolean waitUntilExist(By locator, int time){
        return waitUntilConditions(locator, time, WaiterType.EXIST);
    }

    public boolean waitUntilExist(By locator){
       return waitUntilExist(locator, defaultWaitTime);
    }

    public boolean waitUntilVisible(By locator, int time) {
       return waitUntilConditions(locator, time, WaiterType.VISIBLE);
    }

    public boolean waitUntilVisible(By locator) {
       return waitUntilVisible(locator, defaultWaitTime);
    }

    public boolean waitUntilClickable(By locator, int time) {
        return waitUntilConditions(locator, time, WaiterType.CLICKABLE);
    }

    public boolean waitUntilClickable(By locator) {
        return waitUntilClickable(locator, defaultWaitTime);
    }

    public boolean waitUntilDisappear(By locator, int time) {
        return waitUntilConditions(locator, time, WaiterType.DISAPPEAR);
    }

    public boolean waitUntilDisappear(By locator) {
        return waitUntilDisappear(locator, defaultWaitTime);
    }

    private boolean waitUntilConditions(By locator, int time, WaiterType type) {
        try {
            WebDriverWait wait = new WebDriverWait(webDriver, time);
            if (type == WaiterType.EXIST) {
                wait.until(ExpectedConditions.presenceOfElementLocated(locator));
            }
            if (type == WaiterType.VISIBLE) {
                wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            }
            if (type == WaiterType.CLICKABLE) {
                wait.until(ExpectedConditions.elementToBeClickable(locator));
            }
            if (type == WaiterType.DISAPPEAR) {
                wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
            }
        } catch (TimeoutException ex) {
            System.out.println("timeout " + time + " expired, " + type.toString());
            return false;
        }
        return true;
    }

}
