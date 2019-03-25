package com.objects.slemmaobjects.pageelements;

import com.objects.PageElement;
import com.objects.slemmaobjects.pageobjects.Home;
import com.service.ui.web.SeleniumDriverWrapper;
import org.openqa.selenium.By;
import org.testng.Assert;

public class NewObjectBtnContent extends PageElement {

    private Home parentPage;

    private final By folderBtn = By.xpath("//div[contains(@class, 'lbl-cnt') and contains(text(), 'Folder')]/parent::div/following-sibling::div");
    private final By datasetBtn = By.xpath("//div[contains(@class, 'lbl-cnt') and contains(text(), 'Dataset')]/parent::div/following-sibling::div");
    private final By integrationBtn = By.xpath("//div[contains(@class, 'lbl-cnt') and contains(text(), 'Integration')]/parent::div/following-sibling::div");
    private final By presentationBtn = By.xpath("//div[contains(@class, 'lbl-cnt') and contains(text(), 'Presentation')]/parent::div/following-sibling::div");
    private final By savedChartBtn = By.xpath("//div[contains(@class, 'lbl-cnt') and contains(text(), 'Saved chart')]/parent::div/following-sibling::div");
    private final By dashboardBtn = By.xpath("//div[contains(@class, 'lbl-cnt') and contains(text(), 'Dashboard')]/parent::div/following-sibling::div");

    public NewObjectBtnContent(SeleniumDriverWrapper driver, Home pageObj){
        super(driver);
        parentPage = pageObj;
    }

    @Override
    public boolean validateElements() {
        return driver.waitUntilExist(folderBtn, 2)
                && driver.waitUntilExist(datasetBtn)
                && driver.waitUntilExist(integrationBtn)
                && driver.waitUntilExist(presentationBtn)
                && driver.waitUntilExist(savedChartBtn)
                && driver.waitUntilExist(dashboardBtn);
    }

    public NewObjectBtnContent checkIsRendered(){
        Assert.assertTrue(validateElements());
        return this;
    }

    public CreateNewFolderDialog clickNewFolder() {
        driver.click(folderBtn);
        return new CreateNewFolderDialog(driver, this.parentPage);
    }

    public ChooseDataSourceDialog clickNewDataset() {
        driver.click(folderBtn);
        return new ChooseDataSourceDialog(driver, this.parentPage);
    }

    public CreateNewIntegrationDialog clickNewIntegration() {
        driver.click(folderBtn);
        return new CreateNewIntegrationDialog(driver, this.parentPage);
    }

    public void newPresentation() {
        driver.click(folderBtn);
    }

    public ChooseDataSourceDialog clickNewSavedChart() {
        driver.click(folderBtn);
        return new ChooseDataSourceDialog(driver, this.parentPage);
    }

    public ChooseDashboardTemplateDialog clickNewDashboard() {
        driver.click(folderBtn);
        return new ChooseDashboardTemplateDialog(driver, this.parentPage);
    }
}
