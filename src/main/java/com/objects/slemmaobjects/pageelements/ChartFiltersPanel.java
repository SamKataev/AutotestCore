package com.objects.slemmaobjects.pageelements;

import com.objects.PageElement;
import com.objects.slemmaobjects.pageobjects.Dashboard;
import com.service.ui.web.SeleniumDriverWrapper;

public class ChartFiltersPanel extends PageElement{

    private Dashboard parentPage;

    public ChartFiltersPanel(SeleniumDriverWrapper driver, Dashboard pageObj){
        super(driver);
        parentPage = pageObj;
    }

    @Override
    public boolean validateElements() {
        return true;
    }

}