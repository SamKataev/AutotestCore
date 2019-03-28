package com.objects.npobjects.pageobjects;

import com.objects.npobjects.NPPageObject;
import com.service.ui.web.SeleniumDriverWrapper;
import org.openqa.selenium.By;
import org.testng.Assert;

public class DatasourceCreate extends NPPageObject {

	private By saveBtn = mdcIconFontBtn("ic_save");
	private By agViewport = By.cssSelector(".ag-body-viewport");

	public DatasourceCreate(SeleniumDriverWrapper driver){
	  super(driver.getBaseUrl()+"/datasources/new", driver);
	}

	@Override
	public boolean validateElements(){
		return driver.waitUntilClickable(agViewport, 10)
				  && driver.waitUntilClickable(saveBtn, 5);
	}

	public DatasourceCreate checkIsRendered() {
		super.checkIsRendered();
		return this;
	}

	public DatasourceCreate clickSave() {
		Assert.assertTrue(driver.click(saveBtn));
		return this;
	}

}
