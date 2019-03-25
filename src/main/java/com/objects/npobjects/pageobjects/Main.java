package com.objects.npobjects.pageobjects;

import com.objects.npobjects.NPPageObject;
import com.service.ui.web.SeleniumDriverWrapper;
import org.openqa.selenium.By;
import org.testng.Assert;

public class Main extends NPPageObject
{
	private final By pageModeLabel = classInParentClass("mdc-top-app-bar__title", "librarybox__content-node");
	private final By createBtn = By.xpath("//span[contains(@class, 'mdc-fab__label') and contains(text(), 'Create')]/parent::button[contains(@class, 'mdc-fab')]");
	private final By addBtn = By.xpath("//span[contains(@class, 'mdc-fab__label') and contains(text(), 'Add')]/parent::button[contains(@class, 'mdc-fab')]");
	private final By searchBtn = mdcIconFontBtn("ic_search");
	private final By searchInput = By.cssSelector(".mdc-top-app-bar__search-input");
	private final By startSearchBtn = By.xpath("//input[contains(@class, 'mdc-top-app-bar__search-input')]/preceding-sibling::span[contains(@class, 'mdc-icon-toggle')]");
	private final By accountName = By.xpath("//div[contains(@class, 'account-panel__about-node')]//div[contains(@class, 'mdc-top-app-bar__title')]");
	private final By currentTeam = By.xpath("//div[contains(@class, 'account-panel__about-node')]//div[contains(@class, 'account-panel__about-node_email-nod')]");
	private final By teamsMenuToggle = By.xpath("//div[contains(@class, 'account-panel__about-node')]//span[contains(@class, 'mdc-icon-toggle')]");
	private final By drawerToggleBtn = mdcIconFontBtn("ic_menu");
	private final By liReports = mdcLictItemWithText("Reports");
	private final By liDataSources = mdcLictItemWithText("Data sources");
	private final By liDelivery = mdcLictItemWithText("Delivery");
	private final By liAlerts = mdcLictItemWithText("Alerts");
	private final By liSettings = mdcLictItemWithText("Settings");
	private final By liHelp = mdcLictItemWithText("Help");
	private final By liAdmin = mdcLictItemWithText("Admin");
	private final By liSignOut = mdcLictItemWithText("Sign out");

	public Main(SeleniumDriverWrapper driver){
		super(driver.getBaseUrl() + "/reports", driver);
	}

	@Override
	public boolean validateElements() {
		return driver.waitUntilExist(pageModeLabel, 10)
					&& driver.waitUntilClickable(createBtn)
					&& (isNavMenuRendered()
				  			|| driver.waitUntilClickable(drawerToggleBtn));
	}

	public Main checkIsRendered() {
		super.checkIsRendered();
		return this;
	}

	public Main checkIsLoggedIn(){
		checkIsRendered();
		checkNavSection("Reports", "/reports");
		//TODO: check account
		return this;
	}

	public void checkNavSection(String name, String path){
		checkIsRendered();
		Assert.assertTrue(driver.checkCurrentUrl(driver.getBaseUrl() + path));
		Assert.assertTrue(driver.getElement(pageModeLabel, 10).getText().equals(name));
	}

	private boolean isNavMenuRendered(){
		return driver.waitUntilClickable(liReports, 10)
				  && driver.waitUntilClickable(liDataSources)
				  && driver.waitUntilClickable(liDelivery)
				  && driver.waitUntilClickable(liAlerts)
				  && driver.waitUntilClickable(liSettings)
				  && driver.waitUntilClickable(liHelp)
				  && driver.waitUntilClickable(liAdmin)
				  && driver.waitUntilClickable(liSignOut);
	}

	public void checkIsNavMenuRendered(){
		Assert.assertTrue(isNavMenuRendered());
	}

	private boolean isTeamSelected(String name){
		return driver.getElement(currentTeam).getText().equals(name);
	}

	public void checkIsTeamSelected(String name){
		Assert.assertTrue(driver.waitUntilClickable(currentTeam, 2));
		Assert.assertTrue(isTeamSelected(name));
	}

	public Main selectTeam(String name){
		if (!isTeamSelected(name))
		{
			Assert.assertTrue(driver.click(teamsMenuToggle));
			Assert.assertTrue(driver.waitUntilClickable(By.xpath("//li[contains(@class, 'mdc-list-item') and contains(text(), '" + name + "')]"), 2));
			Assert.assertTrue(driver.click(mdcLictItemWithText(name)));
			checkIsTeamSelected(name);
			checkIsNavMenuRendered();
		}
		return this;
	}

	public Main clickPlusBtn(){
		String currentUrl = driver.getCurrentUrl();
		if (currentUrl.contains("reports")){
			Assert.assertTrue(driver.click(createBtn));

		}
		if (currentUrl.contains("datasources")){
			Assert.assertTrue(driver.click(createBtn));

		}

		if (currentUrl.contains("delivery")){
			Assert.assertTrue(driver.click(createBtn));

		}
		if (currentUrl.contains("alerts")){
			Assert.assertTrue(driver.click(createBtn));

		}
		if (currentUrl.contains("integrations")){
			Assert.assertTrue(driver.click(createBtn));

		}
		if (currentUrl.contains("users")){
			Assert.assertTrue(driver.click(addBtn));

		}
		return this;
	}

	public Main clickSearchBtn(){
		Assert.assertTrue(driver.click(searchBtn));
		return this;
	}

	public Main searchInNavigator(String text){
		clickSearchBtn();
		Assert.assertTrue(driver.type(searchInput, text));
		Assert.assertTrue(driver.click(startSearchBtn));
		return this;
	}


	//simple actions/////////////////////

	public Main openReports(){
		Assert.assertTrue(driver.click(liReports));
		checkNavSection("Reports", "/reports");
		return this;
	}

	public Main openDatasources(){
		Assert.assertTrue(driver.click(liDataSources));
		checkNavSection("Data sources", "/datasources");
		return this;
	}

	public Main openDelivery(){
		Assert.assertTrue(driver.click(liDelivery));
		checkNavSection("Delivery", "/delivery");
		return this;
	}

	public Main openAlerts(){
		Assert.assertTrue(driver.click(liAlerts));
		checkNavSection("Alerts", "/alerts");
		return this;
	}
}
