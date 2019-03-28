package com.objects.npobjects.pageelements.dialogs;

import com.objects.npobjects.pageobjects.Main;
import com.service.ui.web.SeleniumDriverWrapper;
import junit.framework.Assert;
import org.openqa.selenium.By;

public class SelectDatasourceTypeDialog extends Dialog {

	private Main parentPage;

	private final By title = dialogMdcAppBarTitle("Select type");
	private final By uploadFileBtn = dialogMdcListItemWithTextIcon("Upload a File", "ic_upload");
	private final By fileByUrlBtn = dialogMdcListItemWithTextIcon("File by URL", "ic_link");
	private final By closeBtn = dialogMdcIconFontBtn("ic_close");

	public SelectDatasourceTypeDialog(SeleniumDriverWrapper driver, Main pageObj) {
		super(driver);
		parentPage = pageObj;
	}

	@Override
	public boolean validateElements() {
	  return driver.waitUntilExist(title, 5)
				 && driver.waitUntilClickable(closeBtn)
				 && driver.waitUntilClickable(uploadFileBtn)
				 && driver.waitUntilClickable(fileByUrlBtn);
	}

	public SelectDatasourceTypeDialog checkIsRendered() {
		super.checkIsRendered();
		return this;
	}

	public SelectDatasourceTypeDialog clickUploadFile(){
		Assert.assertTrue(driver.click(uploadFileBtn));
		return this;
	}

	public SelectDatasourceTypeDialog clickFileByUrl(){
		Assert.assertTrue(driver.click(fileByUrlBtn));
		return this;
	}

}