package com.objects.slemmaobjects.pageelements;

import com.objects.PageElement;
import com.objects.PageObject;
import com.service.ui.web.SeleniumDriverWrapper;
import org.openqa.selenium.By;

public class NewObjectBtnContent extends PageElement {

    private final By folderBtn = By.xpath("//div[contains(@class, 'lbl-cnt') and contains(text(), 'Folder')]/parent::div/following-sibling::div");
    private final By datasetBtn = By.xpath("//div[contains(@class, 'lbl-cnt') and contains(text(), 'Dataset')]/parent::div/following-sibling::div");
    private final By integrationBtn = By.xpath("//div[contains(@class, 'lbl-cnt') and contains(text(), 'Integration')]/parent::div/following-sibling::div");
    private final By presentationBtn = By.xpath("//div[contains(@class, 'lbl-cnt') and contains(text(), 'Presentation')]/parent::div/following-sibling::div");
    private final By savedChartBtn = By.xpath("//div[contains(@class, 'lbl-cnt') and contains(text(), 'Saved chart')]/parent::div/following-sibling::div");
    private final By dashboardBtn = By.xpath("//div[contains(@class, 'lbl-cnt') and contains(text(), 'Dashboard')]/parent::div/following-sibling::div");

    public NewObjectBtnContent(SeleniumDriverWrapper driver, PageObject pageObj){
        super(driver, pageObj);
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

    public CreateNewFolder clickNewFolder() {
        driver.click(folderBtn);
        return new CreateNewFolder(driver, this.parentPage);
    }

    public ChooseDataSource clickNewDataset() {
        driver.click(folderBtn);
        return new ChooseDataSource(driver, this.parentPage);
    }

    public CreateNewIntegration clickNewIntegration() {
        driver.click(folderBtn);
        return new CreateNewIntegration(driver, this.parentPage);
    }

    public void newPresentation() {
        driver.click(folderBtn);
    }

    public ChooseDataSource clickNewSavedChart() {
        driver.click(folderBtn);
        return new ChooseDataSource(driver, this.parentPage);
    }

    public ChooseDashboardTemplate clickNewDashboard() {
        driver.click(folderBtn);
        return new ChooseDashboardTemplate(driver, this.parentPage);
    }
}
