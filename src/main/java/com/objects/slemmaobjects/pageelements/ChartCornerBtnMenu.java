package com.objects.slemmaobjects.pageelements;

import com.objects.PageElement;
import com.objects.slemmaobjects.pageobjects.Dashboard;
import com.service.ui.web.SeleniumDriverWrapper;
import org.openqa.selenium.By;
import org.testng.Assert;

public class ChartCornerBtnMenu extends PageElement{

    private Dashboard parentPage;

    private final By edit = classWithText("menu-item__cont", "Edit Chart");
    private final By layout = classWithText("menu-item__cont", "Layout");
    private final By filters = classWithText("menu-item__cont", "Filters");
    private final By sort = classWithText("menu-item__cont", "Sort");
    private final By format = classWithText("menu-item__cont", "Format");

    public ChartCornerBtnMenu(SeleniumDriverWrapper driver, Dashboard pageObj){
        super(driver);
        parentPage = pageObj;
    }

    @Override
    public boolean validateElements() {
        return driver.waitUntilClickable(edit, 10)
                && driver.waitUntilClickable(layout, 10)
                && driver.waitUntilClickable(filters, 10)
                && driver.waitUntilClickable(sort, 10)
                && driver.waitUntilClickable(format, 10);
    }

    public ChartCornerBtnMenu checkIsRendered(){
        validateElements();
        return this;
    }

    public void clickEdit(){
        Assert.assertTrue(driver.click(edit));
    }

    public ChartLayoutPanel clickLayout(){
        Assert.assertTrue(driver.click(layout));
        return new ChartLayoutPanel(driver, parentPage);
    }

    public ChartFiltersPanel clickFilters(){
        Assert.assertTrue(driver.click(filters));
        return new ChartFiltersPanel(driver, parentPage);
    }

    public ChartSortPanel clickSort(){
        Assert.assertTrue(driver.click(sort));
        return new ChartSortPanel(driver, parentPage);
    }

    public ChartFormatPanel clickFormat(){
        Assert.assertTrue(driver.click(format));
        return new ChartFormatPanel(driver, parentPage);
    }

}
