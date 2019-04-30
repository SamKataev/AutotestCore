package com.objects.slemmaobjects.pageobjects;

import com.objects.WebElementsContainer;
import com.objects.slemmaobjects.SlemmaPageObject;
import com.objects.slemmaobjects.pageelements.*;
import com.service.ui.web.SeleniumDriverWrapper;
import org.openqa.selenium.By;
import org.testng.Assert;

public class Home extends SlemmaPageObject
{

	public NavigationPanel navigationPanel;
	public NavigatorObjectsList navigatorObjectsList;

	private final By waiter = classSelector("process-waiter__container");
	private final By pageModeLabel = classInParentClass("pageModeLbl", "lbl-cnt");
	private final By plusBtn = classSelector("new-object-button");
	private final By searchInput = classInParentClass("list-view__search-input", "input__nativeinput");
	private final By accountBtn = classSelector("accountBtn");

	public Home(SeleniumDriverWrapper driver)
	{
		super(driver.getBaseUrl() + "/home", driver);
		navigationPanel = new NavigationPanel(driver, this);
		navigatorObjectsList = new NavigatorObjectsList(driver, this);
	}

	@Override
	public boolean validateElements()
	{
		return driver.waitUntilDisappear(waiter, 10)
				  && driver.waitUntilExist(pageModeLabel, 10)
				  && driver.waitUntilClickable(plusBtn)
				  && driver.waitUntilClickable(accountBtn)
				  && navigationPanel.isRendered()
				  && navigatorObjectsList.isRendered();
	}

	public Home checkIsRendered()
	{
		super.checkIsRendered();
		return this;
	}

	public Home checkIsLoggedIn()
	{
		Assert.assertTrue(isRendered()
				  && checkMenuSection("Library", "/home"));
		//TODO: check account
		return this;
	}

	public boolean checkMenuSection(String name, String path)
	{
		return isRendered()
				  && driver.checkCurrentUrl(driver.getBaseUrl() + path)
				  && driver.getElement(pageModeLabel, 10).getText().equals(name);
	}

	public WebElementsContainer clickPlusBtn()
	{
		String currentUrl = driver.getCurrentUrl();
		Assert.assertTrue(driver.click(plusBtn));
		if (currentUrl.contains("infographics"))
		{
			return new ChooseDashboardTemplateDialog(driver, this);
		}
		if (currentUrl.contains("reports"))
		{
			return new ChooseDataSourceDialog(driver, this);
		}
		if (currentUrl.contains("presentations"))
		{
			return new Presentation(driver);
		}
		if (currentUrl.contains("datasources"))
		{
			return new CreateNewIntegrationDialog(driver, this);
		}
		return this;
	}

	public WebElementsContainer searchInNavigator(String text)
	{
		driver.type(searchInput, text);
		return this;
	}

	public AccountSettings clickAccountBtn()
	{
		Assert.assertTrue(driver.click(accountBtn));
		return new AccountSettings(driver, this);
	}

}
