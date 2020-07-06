package com.objects.npobjects.pageobjects;

import com.objects.npobjects.NPPageObject;
import com.objects.npobjects.pageelements.dialogs.*;
import com.objects.npobjects.pageelements.dropdown.IntegrationsDropDown;
import com.objects.npobjects.pageelements.dropdown.MoreOptionDropDown;
import com.service.ui.web.SeleniumDriverWrapper;
import org.openqa.selenium.By;
import org.testng.Assert;

public class NavigatorPage extends NPPageObject
{

	public SelectDatasourceTypeDialog selectDatasourceTypeDialog;
	public FileByUrlDialog fileByUrlDialog;
	public ScheduleDeliveryDialog scheduleDeliveryDialog;
	public CreateAlertDialog createAlertDialog;
	public UserSettingsDialog userSettingsDialog;
	public WorkspaceSettingsDialog workspaceSettingsDialog;
	public IntegrationsDropDown integrationsDropDown;
	public AddUserDialog addUserDialog;
	public MoreOptionDropDown moreOptionDropDown;
	public CreateDatabaseDialog createDatabaseDialog;
	public CreateSaasDialog createSaasDialog;
	public CreateIntegrationDialog createIntegrationDialog;
	public MessageDialog messageDialog;
	public SaaSParametersDialog saaSParametersDialog;
	public CreateCloudIntegrationDialog createCloudIntegrationDialog;
	public SelectDatasetDialog selectDatasetDialog;
	public RenameDialog renameDialog;
	public AddPeopleDialog addPeopleDialog;
	public PermissionsDialog permissionsDialog;
	public LinkSharingDialog linkSharingDialog;
	public SaveChangeDialog saveChangeDialog;
	public PasswordProtectedDialog passwordProtectedDialog;
	public RequestAccessDialog requestAccessDialog;
	public ConfirmDialog confirmDialog;


	private final By pageModeLabel = classInParentClass("mdc-top-app-bar__title", "librarybox__content-node");
	private final By createBtn = mdcTextBtn("Create");
	private final By addBtn = mdcTextBtn("Add");
	private final By searchBtn = mdcIconFontBtn("ic_search");
	private final By searchInput = By.cssSelector(".mdc-top-app-bar__search-input");
	private final By startSearchBtn = By.xpath("//input[contains(@class, 'mdc-top-app-bar__search-input')]/preceding-sibling::span[contains(@class, 'mdc-icon-toggle')]");
	private final By accountName = By.xpath("//div[contains(@class, 'page-mode-panel__footer')]//span[contains(@class, 'mdc-list-item__primary-text')]");
	private final By currentTeam = By.xpath("//div[contains(@class, 'page-mode-panel__footer')]//span[contains(@class, 'mdc-list-item__secondary-text')]");
	private final By drawerToggleBtn = mdcIconFontBtn("ic_menu");

	private final By liReports = mdcListItemWithText("Reports");
	private final By liDataSources = mdcListItemWithText("Data Sources");
	private final By liSettings = mdcListItemWithText("Settings");
	private final By liHelp = mdcListItemWithText("Help");
	private final By liAdmin = mdcListItemWithText("Admin");
	private final By liIntegrations = mdcListItemWithText("Integrations");
	private final By liUsers = mdcListItemWithText("Users");
	private final By liWorkspace = mdcListItemWithText("Workspace Settings");
	private final By liSignOut = mdcListItemWithText("Sign out");


	public NavigatorPage(SeleniumDriverWrapper driver)
	{
		super(driver.getBaseUrl() + "/reports", driver);
		selectDatasourceTypeDialog = new SelectDatasourceTypeDialog(driver, this);
		fileByUrlDialog = new FileByUrlDialog(driver, this);
		scheduleDeliveryDialog = new ScheduleDeliveryDialog(driver, this);
		createAlertDialog = new CreateAlertDialog(driver, this);
		userSettingsDialog = new UserSettingsDialog(driver, this);
		workspaceSettingsDialog = new WorkspaceSettingsDialog(driver, this);
		integrationsDropDown = new IntegrationsDropDown(driver, this);
		addUserDialog = new AddUserDialog(driver, this);
		moreOptionDropDown = new MoreOptionDropDown(driver, this);
		createDatabaseDialog = new CreateDatabaseDialog(driver, this);
		createSaasDialog = new CreateSaasDialog(driver, this);
		createIntegrationDialog = new CreateIntegrationDialog(driver, this);
		messageDialog = new MessageDialog(driver, this);
		saaSParametersDialog = new SaaSParametersDialog(driver, this);
		createCloudIntegrationDialog = new CreateCloudIntegrationDialog(driver, this);
		selectDatasetDialog = new SelectDatasetDialog(driver, this);
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

	public NavigatorPage selectTeam(String name)
	{
		Assert.assertTrue(driver.waitUntilClickable(mdcListItemWithText(name), 5));
		Assert.assertTrue(driver.click(mdcListItemWithText(name)));
		checkTeam(name);
		checkIsNavMenuRendered();
		return this;
	}

	public NavigatorPage clickPlusBtn()
	{
		String currentUrl = driver.getCurrentUrl();
		if (currentUrl.contains("library"))
		{
			Assert.assertTrue(driver.click(createBtn));
		}
		if (currentUrl.contains("reports"))
		{
			Assert.assertTrue(driver.click(createBtn));
		}
		if (currentUrl.contains("datasources"))
		{
			Assert.assertTrue(driver.click(createBtn));
		}
		if (currentUrl.contains("notifications"))
		{
			Assert.assertTrue(driver.click(createBtn));
		}
		if (currentUrl.contains("integrations"))
		{
			Assert.assertTrue(driver.click(createBtn));
		}
		if (currentUrl.contains("users"))
		{
			Assert.assertTrue(driver.click(addBtn));
		}
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
		driver.click(liReports);
		checkNavSection("Reports", "/reports");
		return this;
	}

	public NavigatorPage openDatasources()
	{
		driver.click(liDataSources);
		checkNavSection("Data Sources", "/datasources");
		return this;
	}

	public NavigatorPage openIntegrations()
	{
		driver.click(liIntegrations);
		checkNavSection("Integrations", "/integrations");
		return this;
	}

	public NavigatorPage openUsers()
	{
		driver.click(liUsers);
		checkNavSection("Users", "/users");
		return this;
	}

	public NavigatorPage clickAdminBtn()
	{
		driver.click(liAdmin);
		return this;
	}

	public UserSettingsDialog clickSettingsBtn()
	{
		driver.click(liSettings);
		return userSettingsDialog;
	}

	public WorkspaceSettingsDialog clickWorkspaceBtn()
	{
		driver.click(liWorkspace);
		return workspaceSettingsDialog;
	}

	public NavigatorPage clickSignOutBtn()
	{
		Assert.assertTrue(driver.click(liSignOut));
		return this;
	}

	public NavigatorPage checkObjectInDataTableByName(String name)
	{
		Assert.assertTrue(driver.waitUntilExist(By.xpath("//div[contains(@class , 'mdc-data-table')]//span[contains(@class, 'mdc-list-item__text') and text()='" + name + "']")));
		return this;
	}

	public NavigatorPage checkObjectInDataTableByName(String name, int time)
	{
		Assert.assertTrue(driver.waitUntilExist(By.xpath("//div[contains(@class , 'mdc-data-table')]//span[contains(@class, 'mdc-list-item__text') and text()='" + name + "']"), time));
		return this;
	}


	public NavigatorPage checkObjectInDialogByName(String name, int time)
	{
		Assert.assertTrue(driver.waitUntilExist(By.xpath("//div[contains(@class , 'accordion__item__body')]//span[contains(@class, 'mdc-list-item') and text()='" + name + "']"), time));
		return this;
	}

	public NavigatorPage clickObjectInDataTableByName(String name)
	{
		Assert.assertTrue(driver.waitUntilClickable(By.xpath("//div[contains(@class , 'mdc-data-table')]//span[contains(@class, 'mdc-list-item__text') and text()='" + name + "']/ancestor::li[contains(@class, 'mdc-list-item')]")));
		Assert.assertTrue(driver.click(By.xpath("//div[contains(@class , 'mdc-data-table')]//span[contains(@class, 'mdc-list-item__text') and text()='" + name + "']/ancestor::li[contains(@class, 'mdc-list-item')]")));
		return this;
	}

	public NavigatorPage clickObjectInDataTableByName(String name, int time)
	{
		Assert.assertTrue(driver.waitUntilClickable(By.xpath("//div[contains(@class , 'mdc-data-table')]//span[contains(@class, 'mdc-list-item__text') and text()='" + name + "']/ancestor::li[contains(@class, 'mdc-list-item')]"), time));
		Assert.assertTrue(driver.click(By.xpath("//div[contains(@class , 'mdc-data-table')]//span[contains(@class, 'mdc-list-item__text') and text()='" + name + "']/ancestor::li[contains(@class, 'mdc-list-item')]")));
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
		Assert.assertFalse(driver.contextClick(By.xpath("//div[contains(@class , 'mdc-data-table')]//span[contains(@class, 'mdc-list-item__text') and text()='" + name + "']/ancestor::li[contains(@class, 'mdc-list-item')]"), time));
		return this;
	}

	public NavigatorPage contextClickObjectInDataTableByName(String name, String iconClass, int time)
	{
		Assert.assertFalse(driver.contextClick(By.xpath("//div[contains(@class , 'mdc-data-table')]//span[contains(@class, 'mdc-list-item__text') and text()='" + name + "']/parent::span/preceding-sibling::span[contains(@class, '" + iconClass + "')]/ancestor::li[contains(@class, 'mdc-list-item')]"), time));
		return this;
	}

	public boolean clickdrawerToggleBtn()
	{
		return driver.waitUntilExist(drawerToggleBtn, 5, false) ? driver.click(drawerToggleBtn) : false;
	}
}
