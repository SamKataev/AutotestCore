package com.objects.slemmaobjects.pageobjects;

import com.objects.PageObject;
import com.service.ui.web.SeleniumDriverWrapper;

public class HomePage extends PageObject {

    public HomePage(String url, SeleniumDriverWrapper driver){
        super(url, driver);
    }

    @Override
    protected void setChildElements() {

    }
}
