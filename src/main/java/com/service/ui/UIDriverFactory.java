package com.service.ui;

import com.service.ui.web.ChromeDriverWrapper;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriverService;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

//Description:
//creates instances of drivers for testing UI
//each driver instance is marked with test thread id, each test thread uses only one driver instance
//creates additional instances for drivers initialization such as OS services

public class UIDriverFactory {

    private ChromeDriverService genericChromeDriverService;
    private HashMap<String, UIDriverWrapper> driverPool = new HashMap<>();

    public UIDriverWrapper getDriver(String name, String threadId){
        if (driverPool.containsKey(threadId)) {
            return driverPool.get(threadId);
        }
        return createDriverByName(name, threadId);
    }

    public void closeDriver(String threadId){
        if (driverPool.containsKey(threadId)) {
            driverPool.get(threadId).close();
            System.out.println("web driver closed in thread" + threadId);
        }
    }

    public void startServices(){
        //add new services here
        startChromeService();
    }

    public void stopServices(){
        //add new services here
        stopChromeService();
    }

    private UIDriverWrapper createDriverByName(String name, String threadId){
        if (name.equals("chrome")) {
            return createChromeDriver(threadId) ? driverPool.get(threadId) : null;
        }
        System.out.println("invalid driver name: \"" + name + "\" in thread " + threadId);
        return null;
    }

    private boolean createChromeDriver(String threadId) {
        if (startChromeService()) {
            driverPool.put(threadId, new ChromeDriverWrapper(genericChromeDriverService));
            System.out.println("chrome driver instance created for thread " + threadId);
            return true;
        }
        return false;
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
            System.out.println("chrome driver service started");
        } catch (IOException e) {
            System.out.println("error starting chrome driver service: " + e.getMessage());
            return false;
        }
        return true;
    }

    private void stopChromeService(){
        if (genericChromeDriverService != null) {
            try {
                genericChromeDriverService.stop();
                System.out.println("chrome driver service stopped");
            }catch (WebDriverException e){
                System.out.println("error stopping chrome driver service: " + e.getMessage());
            }
        }
    }

}
