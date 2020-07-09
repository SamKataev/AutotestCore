package com.objects.npobjects.pageobjects;

import com.objects.npobjects.NPPageObject;
import com.objects.npobjects.pageelements.dialogs.*;
import com.objects.npobjects.pageelements.dropdown.IntegrationsDropDown;
import com.objects.npobjects.pageelements.dropdown.MoreOptionDropDown;
import com.objects.npobjects.pageelements.dropdown.SelectTeamDropDown;
import com.service.ui.web.SeleniumDriverWrapper;
import org.openqa.selenium.By;
import org.testng.Assert;

public class NavigatorPage extends NPPageObject
{

	public SelectTeamDropDown selectTeamDropDown;
	public ScheduleDeliveryDialog scheduleDeliveryDialog;
	public CreateAlertDialog createAlertDialog;
	public UserSettingsDialog userSettingsDialog;
	public WorkspaceSettingsDialog workspaceSettingsDialog;
	public IntegrationsDropDown integrationsDropDown;
	public AddUserDialog addUserDialog;
	public MoreOptionDropDown moreOptionDropDown;
	public CreateDataSourceDialog createDatabaseDialog;
	public CreateSaasDialog createSaasDialog;
	public CreateIntegrationDialog createIntegrationDialog;
	public MessageDialog messageDialog;
	public SaaSParametersDialog saaSParametersDialog;
	public CreateCloudIntegrationDialog createCloudIntegrationDialog;
	public RenameDialog renameDialog;
	public AddPeopleDialog addPeopleDialog;
	public PermissionsDialog permissionsDialog;
	public LinkSharingDialog linkSharingDialog;
	public SaveChangeDialog saveChangeDialog;
	public PasswordProtectedDialog passwordProtectedDialog;
	public RequestAccessDialog requestAccessDialog;
	public ConfirmDialog confirmDialog;


	private final By pageModeLabel = classInParentClass("mdc-top-app-bar__title", "librarybox__content-node");
	private final By createBtn = unelevatedBtn("Create");
	private final By addBtn = unelevatedBtn("Add");
	private final By searchBtn = iconFontBtn("ic_search");
	private final By searchInput = By.cssSelector(".mdc-top-app-bar__search-input");
	private final By startSearchBtn = By.xpath("//input[contains(@class, 'mdc-top-app-bar__search-input')]/preceding-sibling::span[contains(@class, 'mdc-icon-toggle')]");
	private final By accountNode = By.xpath("//div[contains(@class, 'page-mode-panel__footer')]//li");
	private final By accountName = By.xpath("//div[contains(@class, 'page-mode-panel__footer')]//span[contains(@class, 'mdc-list-item__primary-text')]");
	private final By currentTeam = By.xpath("//div[contains(@class, 'page-mode-panel__footer')]//span[contains(@class, 'mdc-list-item__secondary-text')]");
	private final By drawerToggleBtn = iconFontBtn("ic_menu");

	private final By liReports = listItemWithText("Reports");
	private final By liDataSources = listItemWithText("Data Sources");
	private final By liSettings = listItemWithText("Settings");
	private final By liHelp = listItemWithText("Help");
	private final By liAdmin = listItemWithText("Admin");
	private final By liIntegrations = listItemWithText("Integrations");
	private final By liUsers = listItemWithText("Users");
	private final By liWorkspace = listItemWithText("Workspace Settings");
	private final By liSignOut = listItemWithText("Sign out");


	public NavigatorPage(SeleniumDriverWrapper driver)
	{
		super(driver.getBaseUrl() + "/reports", driver);
		selectTeamDropDown = new SelectTeamDropDown(driver, this);
		scheduleDeliveryDialog = new ScheduleDeliveryDialog(driver, this);
		createAlertDialog = new CreateAlertDialog(driver, this);
		userSettingsDialog = new UserSettingsDialog(driver, this);
		workspaceSettingsDialog = new WorkspaceSettingsDialog(driver, this);
		integrationsDropDown = new IntegrationsDropDown(driver, this);
		addUserDialog = new AddUserDialog(driver, this);
		moreOptionDropDown = new MoreOptionDropDown(driver, this);
		createDatabaseDialog = new CreateDataSourceDialog(driver, this);
		createSaasDialog = new CreateSaasDialog(driver, this);
		createIntegrationDialog = new CreateIntegrationDialog(driver, this);
		messageDialog = new MessageDialog(driver, this);
		saaSParametersDialog = new SaaSParametersDialog(driver, this);
		createCloudIntegrationDialog = new CreateCloudIntegrationDialog(driver, this);
		renameDialog = new RenameDialog(driver, this);
		addPeopleDialog = new AddPeopleDialog(driver, this);
		permissionsDialog = new PermissionsDialog(driver, this);
		linkSharingDialog = new LinkSharingDialog(driver, this);
		saveChangeDialog = new SaveChangeDialog(driver, this);
		passwordProtectedDialog = new PasswordProtectedDialog(driver, this);
		requestAccessDialog = new RequestAccessDialog(driver, this);
		confirmDialog = new ConfirmDialog(driver, this);
	}

	@Override
	public boolean validateElements()
	{
		return driver.waitUntilExist(pageModeLabel, 10)
				  && (isNavMenuRendered()
				  || driver.waitUntilClickable(drawerToggleBtn));
	}

	public NavigatorPage checkIsRendered()
	{
		processWaiter(10);
		super.checkIsRendered();
		return this;
	}

	public NavigatorPage checkIsLoggedIn(String accountName, String teamName)
	{
		checkIsRendered();
		checkNavSection("Reports", "/reports");
		checkAccount(accountName);
		checkTeam(teamName);
		return this;
	}

	public void checkNavSection(String name, String path)
	{
		Assert.assertEquals(driver.getCurrentUrl(), driver.getBaseUrl() + path);
		Assert.assertEquals(driver.getElement(pageModeLabel, 10).getText(), name);
	}

	private boolean isNavMenuRendered(boolean withAdmin)
	{
		return driver.waitUntilClickable(liReports, 10)
				  && driver.waitUntilClickable(liDataSources)
				  && driver.waitUntilClickable(liSettings)
				  && driver.waitUntilClickable(liHelp)
				  && driver.waitUntilExist(liAdmin)
				  && driver.waitUntilClickable(liSignOut)
				  && (!withAdmin || driver.waitUntilClickable(liIntegrations)
				  			&& driver.waitUntilClickable(liUsers)
				  			&& driver.waitUntilClickable(liWorkspace));
	}

	private boolean isNavMenuRendered()
	{
		return isNavMenuRendered(false);
	}

	public NavigatorPage checkIsNavMenuRendered(boolean withAdmin)
	{
		Assert.assertTrue(isNavMenuRendered(withAdmin));
		return this;
	}

	public NavigatorPage checkIsNavMenuRendered()
	{
		Assert.assertTrue(isNavMenuRendered());
		return this;
	}

	private String getAccountText()
	{
		return driver.getElement(accountName).getText();
	}

	public void checkAccount(String name)
	{
		Assert.assertTrue(driver.waitUntilClickable(accountName, 2));
		Assert.assertEquals(getAccountText(), name);
	}

	private String getTeamText()
	{
		return driver.getElement(currentTeam).getText();
	}

	public void checkTeam(String name)
	{
		Assert.assertTrue(driver.waitUntilClickable(currentTeam, 2));
		Assert.assertEquals(getTeamText(), name);
	}

	public SelectTeamDropDown clickAccount()
	{
		Assert.assertTrue(driver.click(accountNode));
		return selectTeamDropDown;
	}

	public NavigatorPage clickCreateBtn()
	{
		String currentUrl = driver.getCurrentUrl();
		if (currentUrl.contains("library")
				  || currentUrl.contains("reports")
				  || currentUrl.contains("datasources")
				  || currentUrl.contains("integrations"))
			Assert.assertTrue(driver.click(createBtn));
		else if (currentUrl.contains("users"))
			Assert.assertTrue(driver.click(addBtn));
		return this;
	}

	public NavigatorPage clickSearchBtn()
	{
		Assert.assertTrue(driver.click(searchBtn));
		return this;
	}

	public NavigatorPage searchInNavigator(String text)
	{
		clickSearchBtn();
		Assert.assertTrue(driver.type(searchInput, text));
		Assert.assertTrue(driver.click(startSearchBtn));
		return this;
	}


	//simple actions/////////////////////

	public NavigatorPage openReports()
	{
		Assert.assertTrue(driver.click(liReports));
		checkNavSection("Reports", "/reports");
		return this;
	}

	public NavigatorPage openDatasources()
	{
		Assert.assertTrue(driver.click(liDataSources));
		checkNavSection("Data Sources", "/datasources");
		return this;
	}

	public NavigatorPage openIntegrations()
	{
		Assert.assertTrue(driver.click(liIntegrations));
		checkNavSection("Integrations", "/integrations");
		return this;
	}

	public NavigatorPage openUsers()
	{
		Assert.assertTrue(driver.click(liUsers));
		checkNavSection("Users", "/users");
		return this;
	}

	public NavigatorPage clickAdminBtn()
	{
		Assert.assertTrue(driver.click(liAdmin));
		return this;
	}

	public UserSettingsDialog clickSettingsBtn()
	{
		Assert.assertTrue(driver.click(liSettings));
		return userSettingsDialog;
	}

	public WorkspaceSettingsDialog clickWorkspaceBtn()
	{
		Assert.assertTrue(driver.click(liWorkspace));
		return workspaceSettingsDialog;
	}

	public NavigatorPage clickSignOutBtn()
	{
		Assert.assertTrue(driver.click(liSignOut));
		return this;
	}

	public NavigatorPage checkObjectByName(String name)
	{
		Assert.assertTrue(driver.waitUntilExist(By.xpath("//div[contains(@class , 'mdc-data-table')]//span[contains(@class, 'mdc-list-item__primary-text') and text()='" + name + "']")));
		return this;
	}

	public NavigatorPage checkObjectByName(String name, int time)
	{
		Assert.assertTrue(driver.waitUntilExist(By.xpath("//div[contains(@class , 'mdc-data-table')]//span[contains(@class, 'mdc-list-item__primary-text') and text()='" + name + "']"), time));
		return this;
	}

	public NavigatorPage checkObjectInDialogByName(String name, int time)
	{
		Assert.assertTrue(driver.waitUntilExist(By.xpath("//div[contains(@class , 'accordion__item__body')]//span[contains(@class, 'mdc-list-item') and text()='" + name + "']"), time));
		return this;
	}

	public NavigatorPage clickObjectInDataTableByName(String name)
	{
		Assert.assertTrue(driver.waitUntilClickable(By.xpath("//div[contains(@class , 'mdc-data-table')]//span[contains(@class, 'mdc-list-item__primary-text') and text()='" + name + "']/ancestor::li[contains(@class, 'mdc-list-item')]")));
		Assert.assertTrue(driver.click(By.xpath("//div[contains(@class , 'mdc-data-table')]//span[contains(@class, 'mdc-list-item__primary-text') and text()='" + name + "']/ancestor::li[contains(@class, 'mdc-list-item')]")));
		return this;
	}

	public NavigatorPage clickObjectInDataTableByName(String name, int time)
	{
		Assert.assertTrue(driver.waitUntilClickable(By.xpath("//div[contains(@class , 'mdc-data-table')]//span[contains(@class, 'mdc-list-item__primary-text') and text()='" + name + "']/ancestor::li[contains(@class, 'mdc-list-item')]"), time));
		Assert.assertTrue(driver.click(By.xpath("//div[contains(@class , 'mdc-data-table')]//span[contains(@class, 'mdc-list-item__primary-text') and text()='" + name + "']/ancestor::li[contains(@class, 'mdc-list-item')]")));
		return this;
	}

	public NavigatorPage clickObjectInDialogByName(String name, int time)
	{
		Assert.assertTrue(driver.waitUntilClickable(By.xpath("//div[contains(@class , 'mdc-dialog__content')]//span[contains(@class, 'mdc-list-item') and text()='" + name + "']/ancestor::li[contains(@class, 'mdc-list-item')]"), time));
		Assert.assertTrue(driver.click(By.xpath("//div[contains(@class , 'mdc-dialog__content')]//span[contains(@class, 'mdc-list-item') and text()='" + name + "']/ancestor::li[contains(@class, 'mdc-list-item')]")));
		return this;
	}

	public NavigatorPage contextClickObjectInDataTableByName(String name, int time)
	{
		Assert.assertFalse(driver.contextClick(By.xpath("//div[contains(@class , 'mdc-data-table')]//span[contains(@class, 'mdc-list-item__primary-text') and text()='" + name + "']/ancestor::li[contains(@class, 'mdc-list-item')]"), time));
		return this;
	}

	public NavigatorPage contextClickObjectInDataTableByName(String name, String iconClass, int time)
	{
		Assert.assertFalse(driver.contextClick(By.xpath("//div[contains(@class , 'mdc-data-table')]//span[contains(@class, 'mdc-list-item__primary-text') and text()='" + name + "']/parent::span/preceding-sibling::span[contains(@class, '" + iconClass + "')]/ancestor::li[contains(@class, 'mdc-list-item')]"), time));
		return this;
	}

	public boolean clickdrawerToggleBtn()
	{
		return driver.waitUntilExist(drawerToggleBtn, 5, false) ? driver.click(drawerToggleBtn) : false;
	}
}
