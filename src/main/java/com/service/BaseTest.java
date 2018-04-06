package com.service;

import org.testng.Assert;
import org.testng.annotations.*;


public abstract class BaseTest {

    private static WebDriverFactory driverFactory;
    protected WebDriverWrapper webDriver;
    protected String baseUrl;

    @BeforeSuite
    public void startTestSuite(){
        if (driverFactory == null) {
            driverFactory = new WebDriverFactory();
        }
    }

    @AfterSuite
    public void stopTestSuite(){
        if (driverFactory != null) {
            driverFactory.shutDown();
        }
    }

    @Parameters({"baseURL", "browserName", "threadId", "defaultWaitTime"})
    @BeforeClass
    public void startTestClass(String url, String browserName, String threadId, int defaultWaitTime){
        baseUrl = url;
        webDriver = driverFactory.createDriver(browserName, threadId);
        webDriver.setDefaultWaitTime(defaultWaitTime);
        Assert.assertNotEquals(webDriver, null);
    }

}
