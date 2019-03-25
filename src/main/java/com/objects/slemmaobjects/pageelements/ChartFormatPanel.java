package com.objects.slemmaobjects.pageelements;

import com.objects.PageElement;
import com.objects.slemmaobjects.pageobjects.Dashboard;
import com.service.ui.web.SeleniumDriverWrapper;
import org.openqa.selenium.By;
import org.testng.Assert;

public class ChartFormatPanel extends PageElement{

    private Dashboard parentPage;

    public ChartFormatPanel(SeleniumDriverWrapper driver, Dashboard pageObj){
        super(driver);
        parentPage = pageObj;
    }

    @Override
    public boolean validateElements() {
        return true;
    }

    public ChartFormatPanel checkIsRendered(){
        Assert.assertTrue(validateElements());
        return this;
    }

}