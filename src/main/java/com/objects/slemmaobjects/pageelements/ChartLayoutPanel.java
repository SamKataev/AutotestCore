package com.objects.slemmaobjects.pageelements;

import com.objects.PageElement;
import com.objects.slemmaobjects.pageobjects.Dashboard;
import com.service.ui.web.SeleniumDriverWrapper;
import org.openqa.selenium.By;
import org.testng.Assert;

public class ChartLayoutPanel extends PageElement{

    private Dashboard parentPage;

    private final By layoutPanel = classSelector("chart-layout-panel");
    private final By applyBtn = classWithText("btn__cont", "Apply");

    public ChartLayoutPanel(SeleniumDriverWrapper driver, Dashboard pageObj){
        super(driver);
        parentPage = pageObj;
    }

    @Override
    public boolean validateElements() {
        return driver.waitUntilExist(layoutPanel, 10)
                && driver.waitUntilClickable(applyBtn);
    }

    public void checkFieldExist(String name){
        Assert.assertTrue(driver.waitUntilExist(By.xpath("//div[contains(@class, 'listitem_unselectable')]/div[@class='listitem__content' and text()='" + name + "']")));
    }

    public ChartLayoutPanel clickField(String name){
        Assert.assertTrue(driver.click(By.xpath("//div[contains(@class, 'listitem_unselectable')]/div[@class='listitem__content' and text()='" + name + "']")));
        return this;
    }

    public void clickApply(){
        Assert.assertTrue(driver.click(applyBtn));
    }
}