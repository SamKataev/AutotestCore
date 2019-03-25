package com.service.ui.web;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ThreadGuard;

import java.util.HashMap;
import java.util.Map;

public class ChromeDriverWrapper extends SeleniumDriverWrapper {

    private ChromeDriverService service;

    public ChromeDriverWrapper(ChromeDriverService genericService){
        service = genericService;
        init();
    }

    public boolean initDriver(){
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("profile.default_content_setting_values.notifications", 2);
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", prefs);
        options.addArguments("--lang=ru");
        webDriver = new ChromeDriver(service, options);
        return true;
    }

}
