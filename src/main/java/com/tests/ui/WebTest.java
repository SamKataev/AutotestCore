package com.tests.ui;

import com.service.ui.UIDriverFactory;
import com.service.ui.web.SeleniumDriverWrapper;
import org.testng.Assert;
import org.testng.annotations.*;

/**
 * driverFactory instance is being instantiated by BeforeSuite method and is static for all test classes
 * each test class has threadID and gets driver from driverFactory by this threadID
 * each test class is set to use one specific url (baseUrl)
 * packages of particular app tests should contain "base" test class inherited from this class, this inherited "base" test class:
 *                       - implements initPages() method where PagObjects are to be instantiated
 *                       - declares BeforeTest methods common for app (such as log in, log out)
 */
public abstract class WebTest {

    private static UIDriverFactory driverFactory;
    protected SeleniumDriverWrapper driver;

    @BeforeSuite
    public void startSuite(){
        if (driverFactory == null) {
            driverFactory = new UIDriverFactory();
            driverFactory.startServices();
        }
    }

    @AfterSuite
    public void stopSuite(){
        if (driverFactory != null) {
            driverFactory.closeDrivers();
            driverFactory.stopServices();
        }
    }

    @Parameters({"threadId", "baseURL", "browserName", "defaultWaitTime"})
    @BeforeClass
    public void startClass(String threadId, String url,
                               @Optional("chrome") String browserName,
                               @Optional("5") String defaultWaitTime){
        driver = (SeleniumDriverWrapper) driverFactory.getDriver(browserName, threadId);
        Assert.assertNotEquals(driver, null, "");
        driver.setBaseUrl(url);
        driver.setDefaultWaitTime(Integer.parseInt(defaultWaitTime));
        initPages();
    }

    protected abstract void initPages();

    public SeleniumDriverWrapper getDriver(){
        return driver;
    }

    protected void pause(int timeInSeconds) {
        try {
            if (timeInSeconds > 0) {
                Thread.sleep(timeInSeconds * 1000);
            }
        } catch (InterruptedException e) {
            System.out.println("thread sleep interrupted: " + e.getMessage());
        }
    }


}
