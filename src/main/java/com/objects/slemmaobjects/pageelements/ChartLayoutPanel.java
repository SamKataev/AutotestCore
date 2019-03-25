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
    private final By datasourceBtn = classWithText("listitem__content", "Data source");
    private final By editDatasourceBtn = classWithText("listitem__content", "Edit dataset");

    public ChartLayoutPanel(SeleniumDriverWrapper driver, Dashboard pageObj){
        super(driver);
        parentPage = pageObj;
    }

    @Override
    public boolean validateElements() {
        return driver.waitUntilExist(layoutPanel, 10)
                && driver.waitUntilClickable(datasourceBtn);
    }

    public ChartLayoutPanel checkIsRendered(){
        Assert.assertTrue(validateElements());
        return this;
    }

    public ChartLayoutPanel checkFieldExist(String name){
        Assert.assertTrue(driver.waitUntilExist(By.xpath("//div[contains(@class, 'listitem_unselectable')]/div[@class='listitem__content' and text()='" + name + "']")));
        return this;
    }

    public ChartLayoutPanel checkDataSourceName(String name){
        Assert.assertTrue(driver.waitUntilExist(By.xpath("//div[@class='listitem__content' and text()='Data source']/following-sibling::div[contains(@class, 'label')]/div[text()='" + name + "']")));
        return this;
    }

    public ChartLayoutPanel clickField(String name){
        Assert.assertTrue(driver.click(By.xpath("//div[contains(@class, 'listitem_unselectable')]/div[@class='listitem__content' and text()='" + name + "']")));
        return this;
    }

    public ChartLayoutPanel clickDatasource(){
        Assert.assertTrue(driver.click(datasourceBtn));
        return this;
    }

    public ChartLayoutPanel clickEditDataset(){
        Assert.assertTrue(driver.click(editDatasourceBtn));
        return this;
    }

    public ChartLayoutPanel clickApply(){
        Assert.assertTrue(driver.click(applyBtn));
        return this;
    }
}