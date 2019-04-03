package com.objects.npobjects.pageelements.dialogs;

import com.objects.npobjects.pageobjects.Main;
import com.service.ui.web.SeleniumDriverWrapper;
import junit.framework.Assert;
import org.openqa.selenium.By;

/**
 * Created by Kate on 03-Apr-19.

 */
public class ScheduleDeliveryDialog extends Dialog {

    private Main parentPage;

    private final By title = dialogMdcAppBarTitle("Schedule Delivery");
    private final By inputNameDelivery = dialogNpTextFieldWithLabel("New Delivery");
    private final By attachmentBtn = dialogMdcListItemWithTextIcon("Add attachment", "ic_add");
    private final By cancel = dialogMdcTextBtn("Cancel");
    private final By saveChanges = dialogMdcTextBtn("Save changes");
    private final By closeBtn = dialogMdcIconFontBtn("ic_close");

    public ScheduleDeliveryDialog (SeleniumDriverWrapper driver, Main pageObj) {
        super(driver);
        parentPage = pageObj;
    }
    @Override
    public boolean validateElements() {
        return driver.waitUntilExist(title, 5)
                && driver.waitUntilClickable(closeBtn)
                && driver.waitUntilClickable(inputNameDelivery)
                && driver.waitUntilClickable(attachmentBtn)
                && driver.waitUntilClickable(cancel)
                && driver.waitUntilClickable(saveChanges);
    }
    public ScheduleDeliveryDialog checkIsRendered() {
        super.checkIsRendered();
        return this;
    }

    public ScheduleDeliveryDialog ClickAttachmentBtn(){
        Assert.assertTrue(driver.click(attachmentBtn));
        return this;
    }


}
