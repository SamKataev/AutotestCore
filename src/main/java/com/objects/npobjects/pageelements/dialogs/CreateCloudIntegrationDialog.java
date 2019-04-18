package com.objects.npobjects.pageelements.dialogs;

import com.objects.npobjects.pageobjects.Main;
import com.service.ui.web.SeleniumDriverWrapper;
import junit.framework.Assert;
import org.openqa.selenium.By;

public class CreateCloudIntegrationDialog extends Dialog {

    private Main parentPage;

    private final By title = dialogMdcAppBarTitle("Create new");
    private final By closeBtn = dialogMdcIconFontBtn("ic_close");
//    private final By searchBtn = dialogMdcIconFontBtn("ic_search");

    private final By boxBtn = dialogMdcListItemWithTextIcon("Box", "ic_box");
    private final By dropboxBtn = dialogMdcListItemWithTextIcon("Dropbox", "ic_dropbox");
    private final By dropboxBusinessBtn = dialogMdcListItemWithTextIcon("DropBox Business", "ic_dropbox");
    private final By googledriveBtn = dialogMdcListItemWithTextIcon("Google Drive", "ic_google_drive");
    private final By onedriveBtn = dialogMdcListItemWithTextIcon("OneDrive", "ic_onedrive");
    private final By yandexdiskBtn = dialogMdcListItemWithTextIcon("Yandex Disk", "ic_yandex_disk");


    public CreateCloudIntegrationDialog(SeleniumDriverWrapper driver, Main pageObj) {
        super(driver);
        parentPage = pageObj;
    }

    @Override
    public boolean validateElements() {
        return driver.waitUntilExist(title, 5)
                && driver.waitUntilClickable(closeBtn)
//                && driver.waitUntilClickable(searchBtn)
                && driver.waitUntilClickable(boxBtn)
                && driver.waitUntilClickable(dropboxBtn)
                && driver.waitUntilClickable(dropboxBusinessBtn)
                && driver.waitUntilClickable(googledriveBtn)
                && driver.waitUntilClickable(onedriveBtn)
                && driver.waitUntilClickable(yandexdiskBtn);
    }

    public CreateCloudIntegrationDialog checkIsRendered (){
         super.checkIsRendered();
         return this;
        }
    public CreateCloudIntegrationDialog clickBoxBtn () {
         Assert.assertTrue(driver.click(boxBtn));
         return this;
        }

    public CreateCloudIntegrationDialog clickDropboxBtn () {
         Assert.assertTrue(driver.click(dropboxBtn));
         return this;
        }

    public CreateCloudIntegrationDialog clickDropboxBusinessBtn () {
        Assert.assertTrue(driver.click(dropboxBusinessBtn));
        return this;
    }
    public CreateCloudIntegrationDialog clickGoogledriveBtn () {
        Assert.assertTrue(driver.click(googledriveBtn));
        return this;
    }
    public CreateCloudIntegrationDialog clickOnedriveBtn () {
        Assert.assertTrue(driver.click(onedriveBtn));
        return this;
    }
    public CreateCloudIntegrationDialog clickYandexdiskBtn () {
        Assert.assertTrue(driver.click(yandexdiskBtn));
        return this;
   }
    public CreateCloudIntegrationDialog clickcloseBtn () {
        Assert.assertTrue(driver.click(closeBtn));
        return this;
    }
}