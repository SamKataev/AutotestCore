package com.service;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ThreadGuard;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class ChromeDriverWrapper extends WebDriverWrapper {

    private ChromeDriverService service;

    public ChromeDriverWrapper(ChromeDriverService genericService){
        service = genericService;
        init();
    }

    public boolean init(){
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("profile.default_content_setting_values.notifications", 2);
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", prefs);
        driver = ThreadGuard.protect(new ChromeDriver(service, options));
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        mainHandle = getCurrentWindowHandle();
        return true;
    }


}
