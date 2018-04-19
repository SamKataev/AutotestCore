package com.tests.ui;

import com.service.ui.UIDriverFactory;
import com.service.ui.web.SeleniumDriverWrapper;
import org.testng.Assert;
import org.testng.annotations.*;

//Description:
//driverFactory instance is being initialized in before test-suite method and is static for all test classes
//each test class has threadID and gets driver from driverFactory by this threadID

public abstract class WebTest {

    private static UIDriverFactory driverFactory;
    protected SeleniumDriverWrapper webDriver;
    protected String baseUrl;

    @BeforeSuite
    public void startTestSuite(){
        if (driverFactory == null) {
            driverFactory = new UIDriverFactory();
            driverFactory.startServices();
        }
    }

    @AfterSuite
    public void stopTestSuite(){
        if (driverFactory != null) {
            driverFactory.stopServices();
        }
    }

    @Parameters({"threadId", "baseURL", "browserName", "defaultWaitTime"})
    @BeforeTest
    public void startTestClass(String threadId, String url,
                               @Optional("chrome") String browserName,
                               @Optional("5") String defaultWaitTime){
        baseUrl = url;
        webDriver = (SeleniumDriverWrapper) driverFactory.getDriver(browserName, threadId);
        Assert.assertNotEquals(webDriver, null, "");
        webDriver.setDefaultWaitTime(Integer.parseInt(defaultWaitTime));
    }

    @Parameters({"threadId"})
    @AfterTest
    public void stopTestClass(String threadId){
        if (driverFactory != null) {
            driverFactory.closeDriver(threadId);
        }
    }
}
