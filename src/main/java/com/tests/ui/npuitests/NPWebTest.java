package com.tests.ui.npuitests;

import com.google.gson.JsonArray;
import com.objects.npobjects.pageobjects.*;
import com.objects.npobjects.pageobjects.oauthpages.*;
import com.service.TestProperties;
import com.service.http.HttpRequestWrapper;
import com.tests.ui.WebTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public abstract class NPWebTest extends WebTest
{

	AuthPage authPage;
	NavigatorPage mainPage;
	DataSourcePage dataSourceCreatePage;
	ReportPage reportsPage;

	FacebookLogIn facebookLogIn;
	InstagramLogIn instagramLogIn;
	PayPalLogIn payPalLogIn;
	IntercomLogIn intercomLogIn;
	PipedriveLogIn pipedriveLogIn;
	ZendeskLogIn zendeskLogIn;
	WrikeLogIn wrikeLogIn;
	InfusionsoftLogIn infusionsoftLogIn;
	StripeLogIn stripeLogIn;
	QuickbooksLogIn quickbooksLogIn;
	BoxLogIn boxLogIn;
	DropboxLogIn dropboxLogIn;
	GoogleLogIn googleLogIn;
	OneDriveLogIn oneDriveLogIn;
	YandexDiskLogIn yandexDiskLogIn;
	HubSpotLogIn hubSpotLogIn;
	MailChimpLogIn mailChimpLogIn;

	@BeforeSuite
	@Override
	public void startSuite()
	{
		super.startSuite();
		deleteTeamObjects(TestProperties.getNPProp("apiURL"));
	}

	/**
	 * each test class starts from reports page if not overridden
	 */
	@BeforeClass
	public void startTestClass()
	{
		openReportsPage();
	}

	/**
	 * switch to main window to handle a case when previous method switched focus to another window and hadn't switched it back to main window (e.g. due to test fail)
	 * each test method starts from reports page if not overridden
	 */
	@BeforeMethod
	public void startTestMethod()
	{
		if (!driver.getCurrentWindowHandle().equals(driver.getMainWindowHandle()))
			driver.switchToMainWindow();

		openReportsPage();
	}

	@Override
	protected void initPages()
	{
		authPage = new AuthPage(driver);
		mainPage = new NavigatorPage(driver);
		dataSourceCreatePage = new DataSourcePage(driver);
		reportsPage = new ReportPage(driver);
		facebookLogIn = new FacebookLogIn(driver);
		instagramLogIn = new InstagramLogIn(driver);
		payPalLogIn = new PayPalLogIn(driver);
		intercomLogIn = new IntercomLogIn(driver);
		pipedriveLogIn = new PipedriveLogIn(driver);
		zendeskLogIn = new ZendeskLogIn(driver);
		wrikeLogIn = new WrikeLogIn(driver);
		infusionsoftLogIn = new InfusionsoftLogIn(driver);
		stripeLogIn = new StripeLogIn(driver);
		quickbooksLogIn = new QuickbooksLogIn(driver);
		boxLogIn = new BoxLogIn(driver);
		dropboxLogIn = new DropboxLogIn(driver);
		googleLogIn = new GoogleLogIn(driver);
		oneDriveLogIn = new OneDriveLogIn(driver);
		yandexDiskLogIn = new YandexDiskLogIn(driver);
		hubSpotLogIn = new HubSpotLogIn(driver);
		mailChimpLogIn = new MailChimpLogIn(driver);
	}

	protected void openHomePage()
	{
		driver.goToUrl(driver.getBaseUrl() + "/home");
	}

	protected void openReportsPage()
	{
		driver.goToUrl(driver.getBaseUrl() + "/reports");
		if (!driver.getCurrentUrl().equals(driver.getBaseUrl() + "/reports"))
		{
			logIn();
		}
	}

	protected void openDataSourcesPage()
	{
		driver.goToUrl(driver.getBaseUrl() + "/datasources");
		if (!driver.getCurrentUrl().equals(driver.getBaseUrl() + "/datasources"))
		{
			logIn();
		}
	}

	protected void openReport(String key)
	{
		driver.goToUrl(driver.getBaseUrl() + "/reports/" + key);
		if (!driver.getCurrentUrl().equals(driver.getBaseUrl() + "/reports/" + key))
		{
			logIn();
		}
	}

	protected void logIn()
	{
		authPage.open();
		authPage.logIn(TestProperties.getNPProp("email"), TestProperties.getNPProp("password"));
		mainPage.checkIsLoggedIn(TestProperties.getNPProp("user"), TestProperties.getNPProp("team"));
	}

	protected void changeTeam(String name)
	{
		mainPage.checkIsRendered()
				  .clickAccount();
		mainPage.selectTeamDropDown
				  .clickTeam(name);
		mainPage.checkTeam(name);
	}

	protected void deleteTeamObjects(String url)
	{
		HttpRequestWrapper request = new HttpRequestWrapper();
		request.setName("delete test team objects");
		request.setHeader("teamid", TestProperties.getNPProp("teamid"));
		request.setHeader("sig", TestProperties.getNPProp("sig"));
		request.setHeader("Content-Type", "application/json");
		request.setEndpoint(url + "/api/v1/");
		request.setMethod("objects/");
		request.setType("get");
		request.setExpectedStatusCode(200);
		request.send();
		request.validateStatusCode();

		JsonArray teamObjects = request.getResponseJsonArray();

		request.setType("delete");
		teamObjects.forEach(teamObject -> {
			request.setMethodKey(teamObject.getAsJsonObject().get("Key").toString());
			request.send();
		});
	}
}
