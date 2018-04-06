package com.service;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.HashMap;

public abstract class WebDriverWrapper {

    protected WebDriver driver;
    protected String mainHandle;
    protected int threadId;

    enum WaiterType {EXIST, VISIBLE, CLICKABLE, DISAPPEAR}
    private int defaultWaitTime = 5;

    abstract boolean init();

    public void close(){
        driver.close();
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

    public int getThreadId(){
        return threadId;
    }

    public void setThreadId(int arg){
        threadId = arg;
    }

    public void setDefaultWaitTime(int time){
        defaultWaitTime = time;
    }

    public int getDefaultWaitTime(){
        return defaultWaitTime;
    }

    protected boolean waitUntilExist(By locator) {
        return waitUntilConditions(locator, defaultWaitTime, WaiterType.EXIST);
    }

    protected boolean waitUntilExist(By locator, int time) {
        return waitUntilConditions(locator, time, WaiterType.EXIST);
    }

    protected boolean waitUntilVisible(By locator) {
        return waitUntilConditions(locator, defaultWaitTime, WaiterType.VISIBLE);
    }

    protected boolean waitUntilVisible(By locator, int time) {
        return waitUntilConditions(locator, time, WaiterType.VISIBLE);
    }

    protected boolean waitUntilClickable(By locator) {
        return waitUntilConditions(locator, defaultWaitTime, WaiterType.CLICKABLE);
    }

    protected boolean waitUntilClickable(By locator, int time) {
        return waitUntilConditions(locator, time, WaiterType.CLICKABLE);
    }

    protected boolean waitUntilDisappear(By locator) {
        return waitUntilConditions(locator, defaultWaitTime, WaiterType.DISAPPEAR);
    }

    protected boolean waitUntilDisappear(By locator, int time) {
        return waitUntilConditions(locator, time, WaiterType.DISAPPEAR);
    }

    private boolean waitUntilConditions(By locator, int time, WaiterType type) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, time);
            if (type == WaiterType.EXIST) {
                wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
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
            System.out.println("timeout " + time + " expired, " + type.toString() + " by locator: " + locator.toString());
            return false;
        }
        return true;
    }

}
