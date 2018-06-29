package com.objects.slemmaobjects.pageobjects;

import com.objects.PageObject;
import com.service.ui.web.SeleniumDriverWrapper;

public class Dashboard extends PageObject {

    public Dashboard(SeleniumDriverWrapper driver){
        super(driver.getBaseUrl()+"/auth", driver);
    }

    @Override
    public boolean validateElements(){
        return true;
    }
}
