package com.service;

import org.openqa.selenium.chrome.ChromeDriverService;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

public class WebDriverFactory {

    private ChromeDriverService genericChromeDriverService;
    private HashMap<String, WebDriverWrapper> driverPool = new HashMap<>();

    public WebDriverWrapper createDriver(String name, String threadId){
        if (driverPool.containsKey(threadId)){
            return driverPool.get(threadId);
        }
        if (name == "chrome") {
            return createChromeDriver(threadId) ? driverPool.get(threadId) : null;
        }
        System.out.println("invalid driver name: " + name + " in thread " + threadId);
        return null;
    }

    private boolean createChromeDriver(String threadId) {
        if (startChromeService()) {
            driverPool.put(threadId, new ChromeDriverWrapper(genericChromeDriverService));
            return true;
        }
        return false;
    }

    public void shutDown(){
        driverPool.forEach((k,v) -> {
            v.close();
            System.out.println("web driver closed in thread " + k);
        });
        stopChromeService();
    }

    private boolean startChromeService() {
        if (genericChromeDriverService != null) {
            return true;
        }
        genericChromeDriverService = new ChromeDriverService.Builder()
                .usingDriverExecutable(new File(System.getProperty("user.dir") + "/vendors/chromedriver.exe"))
                .usingAnyFreePort()
                .build();

        try {
            genericChromeDriverService.start();
        } catch (IOException e) {
            System.out.println("error starting chrome driver service: " + e.getMessage());
            return false;
        }
        return true;
    }

    private void stopChromeService(){
        if (genericChromeDriverService != null) {
            genericChromeDriverService.stop();
        }
    }

}
