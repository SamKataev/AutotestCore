package com.objects.npobjects.pageelements.dropdown;

import com.objects.npobjects.pageelements.dialogs.SelectDatasetDialog;
import com.objects.npobjects.pageelements.dialogs.SelectDatasourceTypeDialog;
import com.objects.npobjects.pageobjects.Main;
import com.objects.npobjects.pageobjects.ReportsCreate;
import com.service.ui.web.SeleniumDriverWrapper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class ChooseObjectDropDown extends DropDown {
    private ReportsCreate parentPage;

    private final By ImageIcon = dropDownMdcListItemWithTextIcon("Image","ic_image");
    private final By embedIcon = dropDownMdcListItemWithTextIcon("URL embed","ic_code");
    private final By textIcon = dropDownMdcListItemWithTextIcon("Text","ic_text");
    private final By chartTemplateIcon = dropDownMdcListItemWithTextIcon("Chart template","ic_chart_template");
    private final By chartIcon = dropDownMdcListItemWithTextIcon("Chart","ic_chart");


    public ChooseObjectDropDown (SeleniumDriverWrapper driver, ReportsCreate pageObj) {
        super(driver);
        parentPage = pageObj;
    }

    @Override
    public boolean validateElements() {
        return driver.waitUntilClickable(ImageIcon,5)
                && driver.waitUntilClickable(embedIcon)
                && driver.waitUntilClickable(textIcon)
                && driver.waitUntilClickable(chartTemplateIcon)
                && driver.waitUntilClickable(chartIcon);
    }
    public ChooseObjectDropDown checkIsRendered() {
        super.checkIsRendered();
        return this;
    }

    public ChooseObjectDropDown clickObjectByName(String text, String iconClass){
            Assert.assertTrue(driver.click(dropDownMdcListItemWithTextIcon(text,iconClass)));
        return this;
    }
    public ChooseObjectDropDown uploadFile (String text){
        WebElement fileInput = driver.getElement(By.xpath("//input[@class='file-input']"));
        fileInput.sendKeys(text);
        return this;
    }
}