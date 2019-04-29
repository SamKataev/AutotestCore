package com.objects.npobjects.pageobjects;

import com.objects.npobjects.NPPageObject;
import com.objects.npobjects.pageelements.dialogs.AddUserDialog;
import com.objects.npobjects.pageelements.dialogs.HTTPSwebAddressDialog;
import com.objects.npobjects.pageelements.dropdown.ChooseObjectDropDown;
import com.objects.npobjects.pageelements.dialogs.SaveAsDialog;

import com.objects.npobjects.pageobjects.oauthpages.DropboxLogIn;
import com.service.ui.web.SeleniumDriverWrapper;
import org.openqa.selenium.By;
import org.testng.Assert;

public class ReportsCreate extends NPPageObject {

    public ChooseObjectDropDown chooseObjectDropDown;
    public HTTPSwebAddressDialog hTTPSwebAddressDialog;
    public SaveAsDialog saveAsDialog;

        private final By closeBtn = mdcIconFontBtn("ic_close");
        private By moreBtn = By.xpath("//div[@class='mdc-top-app-bar__row']//span[contains(@class, 'ic_more_vert')]");
        private By settingsBtn = mdcIconFontBtn("ic_tune");
        private By insertBtn= By.xpath("//span[contains(@class, 'mdc-fab__label') and contains(text(), 'Insert')]/parent::button[contains(@class, 'mdc-fab')]");
        private By panelcontent = By.xpath("//div[@class='panelcontent']");
        private By wait = By.xpath("//div[@class='dropdown__frame']");

   public ReportsCreate (SeleniumDriverWrapper driver) {super(driver.getBaseUrl() + "/reports/new", driver);
       chooseObjectDropDown = new ChooseObjectDropDown (driver, this);
       hTTPSwebAddressDialog = new HTTPSwebAddressDialog (driver, this);
       saveAsDialog = new SaveAsDialog(driver, this);
    }

        @Override
        public boolean validateElements () {
        return driver.waitUntilClickable(settingsBtn, 10)
                && driver.waitUntilExist(moreBtn);
   }
        public ReportsCreate checkIsRendered () {
        super.checkIsRendered();
        return this;
    }
        public ReportsCreate clickSettingsBtn () {
        Assert.assertTrue(driver.click(settingsBtn));
        return this;
    }
    public ReportsCreate clickMoreBtn () {
        Assert.assertTrue(driver.click(moreBtn));
        return this;
    }
     public ReportsCreate clickCloseBtn () {
        Assert.assertTrue(driver.click(closeBtn));
        return this;
    }
    public ReportsCreate clickInsertBtn () {
        Assert.assertTrue(driver.click(insertBtn));
        return this;
    }
}