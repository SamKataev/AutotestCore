package com.tests.ui;

import com.objects.PageObject;
import com.objects.WebElementsContainer;
import com.service.ui.UIDriverFactory;
import com.service.ui.web.SeleniumDriverWrapper;
import com.tests.ui.slemmauitests.SlemmaWebTest;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.HashMap;

//Description:
//driverFactory instance is being initialized in BeforeSuite method and is static for all test classes
//each test class has threadID and gets driver from driverFactory by this threadID
//each test class is set to use one specific url (baseUrl)
//test packages of app should contain "base" test class inherited from this class, this inherited "base" test class:
//                      - implements initPages() method where PagObjects are to be instantiated
//                      - declares BeforeTest methods common for app (such as log in, log out)


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
}
