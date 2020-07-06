package com.objects.npobjects.pageelements.dialogs;

import com.objects.npobjects.pageobjects.NavigatorPage;
import com.service.ui.web.SeleniumDriverWrapper;
import junit.framework.Assert;
import org.openqa.selenium.By;

/**
 * Created by User on 05-Apr-19.
 */
public class CreateSaasDialog extends Dialog
{

	private NavigatorPage parentPage;

	private final By title = dialogAppBarTitle("Create new");
	private final By closeBtn = dialogIconFontBtn("ic_close");
	private final By searchBtn = dialogIconFontBtn("ic_search");

	private final By facebookBtn = dialogListItemWithTextIcon("Facebook", "ic_facebook");
	private final By facebookAdsBtn = dialogListItemWithTextIcon("Facebook Ads", "ic_facebook_ads");
	private final By freshdeskBtn = dialogListItemWithTextIcon("Freshdesk", "ic_freshdesk");
	private final By freshsalesBtn = dialogListItemWithTextIcon("Freshsales", "ic_freshsales");
	private final By googleAdsBtn = dialogListItemWithTextIcon("Google Ads", "ic_google_ads");
	private final By googleAnalyticsBtn = dialogListItemWithTextIcon("Google Analytics", "ic_google_analytics");
	private final By hubspotBtn = dialogListItemWithTextIcon("Hubspot", "ic_hubspot");
	private final By infusionsoftBtn = dialogListItemWithTextIcon("Infusionsoft", "ic_infusionsoft");
	private final By insightlyBtn = dialogListItemWithTextIcon("Insightly", "ic_insightly");
	private final By instagramBtn = dialogListItemWithTextIcon("Instagram", "ic_instagram");
	private final By intercomBtn = dialogListItemWithTextIcon("Intercom", "ic_intercom");
	private final By jiraBtn = dialogListItemWithTextIcon("Jira", "ic_jira");
	private final By mailchimpBtn = dialogListItemWithTextIcon("Mailchimp", "ic_mailchimp");
	private final By paypalBtn = dialogListItemWithTextIcon("PayPal", "ic_paypal");
	private final By pipedriveBtn = dialogListItemWithTextIcon("Pipedrive", "ic_pipedrive");
	private final By quickbooksBtn = dialogListItemWithTextIcon("QuickBooks", "ic_quickbooks");
	private final By salesforceBtn = dialogListItemWithTextIcon("Salesforce", "ic_salesforce");
	private final By shopifyBtn = dialogListItemWithTextIcon("Shopify", "ic_shopify");
	private final By smartsheetBtn = dialogListItemWithTextIcon("Smartsheet", "ic_smartsheet");
	private final By stripeBtn = dialogListItemWithTextIcon("Stripe", "ic_stripe");
	private final By surveymonkeyBtn = dialogListItemWithTextIcon("SurveyMonkey", "ic_surveymonkey");
	private final By wrikeBtn = dialogListItemWithTextIcon("Wrike", "ic_wrike");
	private final By zendeskBtn = dialogListItemWithTextIcon("Zendesk", "ic_zendesk");

	public CreateSaasDialog(SeleniumDriverWrapper driver, NavigatorPage pageObj)
	{
		super(driver);
		parentPage = pageObj;
	}

	@Override
	public boolean validateElements()
	{
		return driver.waitUntilExist(title, 5)
				  && driver.waitUntilClickable(closeBtn)
				  && driver.waitUntilClickable(searchBtn)
				  && driver.waitUntilClickable(facebookBtn)
				  && driver.waitUntilClickable(facebookAdsBtn)
				  && driver.waitUntilClickable(freshdeskBtn)
				  && driver.waitUntilClickable(freshsalesBtn)
				  && driver.waitUntilClickable(googleAdsBtn)
				  && driver.waitUntilClickable(googleAnalyticsBtn)
				  && driver.waitUntilClickable(hubspotBtn)
				  && driver.waitUntilClickable(infusionsoftBtn)
				  && driver.waitUntilClickable(insightlyBtn)
				  && driver.waitUntilClickable(instagramBtn)
				  && driver.waitUntilClickable(intercomBtn)
				  && driver.waitUntilClickable(jiraBtn)
				  && driver.waitUntilClickable(mailchimpBtn)
				  && driver.waitUntilClickable(paypalBtn)
				  && driver.waitUntilClickable(pipedriveBtn)
				  && driver.waitUntilClickable(quickbooksBtn)
				  && driver.waitUntilClickable(salesforceBtn)
				  && driver.waitUntilClickable(shopifyBtn)
				  && driver.waitUntilClickable(smartsheetBtn)
				  && driver.waitUntilClickable(stripeBtn)
				  && driver.waitUntilClickable(surveymonkeyBtn)
				  && driver.waitUntilClickable(wrikeBtn)
				  && driver.waitUntilClickable(zendeskBtn);
	}


	public CreateSaasDialog checkIsRendered()
	{
		super.checkIsRendered();
		return this;
	}

	public CreateSaasDialog clickSearchBtn()
	{
		Assert.assertTrue(driver.click(searchBtn));
		return this;
	}

	//click saas
	public CreateSaasDialog clickFacebookBtn()
	{
		Assert.assertTrue(driver.click(facebookBtn));
		return this;
	}

	public CreateSaasDialog clickFacebookAdsBtn()
	{
		Assert.assertTrue(driver.click(facebookAdsBtn));
		return this;
	}

	public CreateSaasDialog clickfreshdeskBtn()
	{
		Assert.assertTrue(driver.click(freshdeskBtn));
		return this;
	}

	public CreateSaasDialog clickfreshsalesBtn()
	{
		Assert.assertTrue(driver.click(freshsalesBtn));
		return this;
	}

	public CreateSaasDialog clickzendeskBtn()
	{
		Assert.assertTrue(driver.click(zendeskBtn));
		return this;
	}

	public CreateSaasDialog clickgoogleAdsBtn()
	{
		Assert.assertTrue(driver.click(googleAdsBtn));
		return this;
	}

	public CreateSaasDialog clickGoogleAnalyticsBtn()
	{
		Assert.assertTrue(driver.click(googleAnalyticsBtn));
		return this;
	}

	public CreateSaasDialog clickjiraBtn()
	{
		Assert.assertTrue(driver.click(jiraBtn));
		return this;
	}

	public CreateSaasDialog clickinstagramBtn()
	{
		Assert.assertTrue(driver.click(instagramBtn));
		return this;
	}

	public CreateSaasDialog clickpaypalBtn()
	{
		Assert.assertTrue(driver.click(paypalBtn));
		return this;
	}

	public CreateSaasDialog clickintercomBtn()
	{
		Assert.assertTrue(driver.click(intercomBtn));
		return this;
	}

	public CreateSaasDialog clickPipedriveBtn()
	{
		Assert.assertTrue(driver.click(pipedriveBtn));
		return this;
	}

	public CreateSaasDialog clickWrikeBtn()
	{
		Assert.assertTrue(driver.click(wrikeBtn));
		return this;
	}

	public CreateSaasDialog clickInfusionsoftBtn()
	{
		Assert.assertTrue(driver.click(infusionsoftBtn));
		return this;
	}

	public CreateSaasDialog clickSalesforceBtn()
	{
		Assert.assertTrue(driver.click(salesforceBtn));
		return this;
	}

	public CreateSaasDialog clickStripeBtn()
	{
		Assert.assertTrue(driver.click(stripeBtn));
		return this;
	}

	public CreateSaasDialog clickQuickbooksBtn()
	{
		Assert.assertTrue(driver.click(quickbooksBtn));
		return this;
	}

	public CreateSaasDialog clickHubspotBtn()
	{
		Assert.assertTrue(driver.click(hubspotBtn));
		return this;
	}

	public CreateSaasDialog clickMailchimpBtn()
	{
		Assert.assertTrue(driver.click(mailchimpBtn));
		return this;
	}
}

