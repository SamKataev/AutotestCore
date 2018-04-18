package com.tests.ui;

import com.service.ui.UIDriverFactory;
import com.service.ui.UIDriverWrapper;
import com.service.ui.web.SeleniumDriverWrapper;
import org.testng.Assert;
import org.testng.annotations.*;


public abstract class BaseWebTest {

    private static UIDriverFactory driverFactory;
    protected SeleniumDriverWrapper webDriver;
    protected String baseUrl;

    @BeforeSuite
    public void startTestSuite(){
        if (driverFactory == null) {
            driverFactory = new UIDriverFactory();
        }
    }

    @AfterSuite
    public void stopTestSuite(){
        if (driverFactory != null) {
            driverFactory.shutDown();
        }
    }

    @Parameters({"threadId", "baseURL", "browserName", "defaultWaitTime"})
    @BeforeClass
    public void startTestClass(String threadId, String url,
                               @Optional("chrome") String browserName,
                               @Optional("5") String defaultWaitTime){
        baseUrl = url;
        setWebDriver((SeleniumDriverWrapper) driverFactory.getDriver(browserName, threadId));
        Assert.assertNotEquals(webDriver, null, "");
        webDriver.setDefaultWaitTime(Integer.parseInt(defaultWaitTime));
    }

    protected SeleniumDriverWrapper getWebDriver(){return webDriver;}
    protected void setWebDriver(SeleniumDriverWrapper driver){webDriver = driver;}

}
