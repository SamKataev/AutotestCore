package com.tests.ui.npuitests;

import com.objects.npobjects.pageobjects.*;
import com.objects.npobjects.pageobjects.oauthpages.*;
import com.service.TestProperties;
import com.tests.ui.WebTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public abstract class NPWebTest extends WebTest
{

	AuthPage authPage;
	NavigatorPage mainPage;
	DatasourcePage datasourceCreatePage;
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

	/**
	 * each test class starts from reports page if not overridden
	 */
	@BeforeClass
	public void startTestClass()
	{
		openReportsPage();
	}

	/**
	 * each test method starts from reports page if not overridden
	 */
	@BeforeMethod
	public void startTestMethod()
	{
		openReportsPage();
	}

	@Override
	protected void initPages()
	{
		authPage = new AuthPage(driver);
		mainPage = new NavigatorPage(driver);
		datasourceCreatePage = new DatasourcePage(driver);
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

	protected void logIn()
	{
		authPage.open();
		authPage.logIn(TestProperties.getNPProp("email"), TestProperties.getNPProp("password"));
		mainPage.checkIsLoggedIn(TestProperties.getNPProp("user"), TestProperties.getNPProp("team"));
	}

	protected void changeTeam(String name)
	{
		mainPage.checkIsRendered();
		mainPage.selectTeam(name);
	}

}
