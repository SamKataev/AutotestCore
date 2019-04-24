package com.objects.npobjects.pageelements.dropdown;

import com.objects.npobjects.pageobjects.Main;
import com.service.ui.web.SeleniumDriverWrapper;
import junit.framework.Assert;
import org.openqa.selenium.By;

/**
 * Created by Kate on 03-Apr-19.
 */
public class MoreOptionDropDown extends DropDown {

    private Main parentPage;;

    private final By shareIcon = dropDownMdcListItemWithTextIcon("Share","ic_person_add");
    private final By linkIcon = dropDownMdcListItemWithTextIcon("Get shareable link...","ic_link");
    private final By slackIcon = dropDownMdcListItemWithTextIcon("Share to Slack","ic_slack");
    private final By pdfIcon = dropDownMdcListItemWithTextIcon("Download as PDF","ic_download");
    private final By deliveryIcon = dropDownMdcListItemWithTextIcon("Create delivery","ic_download");
    private final By accessBtn = dropDownMdcListItemWithText("Who has access");
    private final By duplicateBtn = dropDownMdcListItemWithText("Duplicate");
    private final By renameBtn = dropDownMdcListItemWithText("Rename");
    private final By detailsBtn = dropDownMdcListItemWithText("View details");
    private final By removeBtn = dropDownMdcListItemWithText("Remove");
    private final By saveIcon = dropDownMdcListItemWithTextIcon("Save","ic_save");


    public MoreOptionDropDown (SeleniumDriverWrapper driver, Main pageObj) {
        super(driver);
        parentPage = pageObj;
    }

    @Override
    public boolean validateElements() {
        return driver.waitUntilClickable(renameBtn,5);
//                && driver.waitUntilClickable(linkIcon)
//                && driver.waitUntilClickable(slackIcon)
//                && driver.waitUntilClickable(linkIcon)
//                && driver.waitUntilClickable(pdfIcon)
//                && driver.waitUntilClickable(deliveryIcon)
//                && driver.waitUntilClickable(accessBtn)
//                && driver.waitUntilClickable(duplicateBtn)
//                && driver.waitUntilClickable(renameBtn)
//                && driver.waitUntilClickable(detailsBtn)
//                && driver.waitUntilClickable(removeBtn);

    }
    public MoreOptionDropDown checkIsRendered() {
        super.checkIsRendered();
        return this;
    }

    public MoreOptionDropDown ClickRenameBtn(){
        Assert.assertTrue(driver.click(renameBtn));
        return this;
    }
    public MoreOptionDropDown ClickDetailsBtn(){
        Assert.assertTrue(driver.click(detailsBtn));
        return this;
    }
    public MoreOptionDropDown ClickPdfIcon(){
        Assert.assertTrue(driver.click(pdfIcon));
        return this;
    }
    public MoreOptionDropDown ClickLinkIcon(){
        Assert.assertTrue(driver.click(linkIcon));
        return this;
    }
    public MoreOptionDropDown clickSaveIcon(){
        Assert.assertTrue(driver.waitUntilClickable(saveIcon));
        Assert.assertTrue(driver.click(saveIcon));
        return this;
    }

}
