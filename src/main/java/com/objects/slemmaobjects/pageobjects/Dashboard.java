package com.objects.slemmaobjects.pageobjects;

import com.objects.slemmaobjects.SlemmaPageObject;
import com.objects.slemmaobjects.pageelements.ChartContextMenu;
import com.objects.slemmaobjects.pageelements.ChartCornerBtnMenu;
import com.service.ui.web.SeleniumDriverWrapper;
import org.openqa.selenium.By;
import org.testng.Assert;

public class Dashboard extends SlemmaPageObject
{

	public ChartContextMenu contextMenu;

	private final By logo = classSelector("logo-button");
	private final By title = classInParentClass("main-title-button", "btn__cont");
	private final By homeBtn = idSelector("designerHomeButton");
	private final By rightPanel = classSelector("context-header-node__right-part");
	private final By switcher = classSelector("designer-view-edit-switcher");
	private final By saveBtn = By.xpath("//div[contains(@class, 'designer-save-button') and not(contains(@class, 'hide'))]");


	public Dashboard(SeleniumDriverWrapper driver)
	{
		super(driver.getBaseUrl() + "/infographics", driver);
		contextMenu = new ChartContextMenu(driver, this);
	}

	@Override
	public boolean validateElements()
	{
		return driver.waitUntilDisappear(waiter, 20)
				  && driver.waitUntilExist(logo, 20)
				  && driver.waitUntilExist(title)
				  && driver.waitUntilExist(rightPanel)
				  && driver.waitUntilExist(homeBtn);
	}

	public Dashboard checkIsRendered()
	{
		super.checkIsRendered();
		return this;
	}

	public boolean isEditable()
	{
		return driver.waitUntilExist(By.xpath("//div[contains(@class, 'switcher_checked')]"), 10)
				  && driver.waitUntilExist(saveBtn, 10);
	}

	public Dashboard switchEdit()
	{
		Assert.assertTrue(driver.click(switcher));
		return this;
	}

	public Dashboard checkIsEditable()
	{
		Assert.assertTrue(isEditable());
		return this;
	}

	public Dashboard clickChartByName(String name)
	{
		Assert.assertTrue(driver.click(By.xpath("//div[@class='lbl-cnt' and text()='" + name + "']/ancestor::div[contains(@class, 'blockcontainer')]")));
		return this;
	}

	public ChartCornerBtnMenu clickChartCornerButton(String name)
	{
		Assert.assertTrue(driver.click(By.xpath("//div[@class='lbl-cnt' and text()='" + name + "']/ancestor::div[@class='blockcaption']/preceding-sibling::div[contains(@class, 'block__corner-node')]/div[contains(@class, 'block__corner-button')]")));
		return new ChartCornerBtnMenu(driver, this);
	}
}

