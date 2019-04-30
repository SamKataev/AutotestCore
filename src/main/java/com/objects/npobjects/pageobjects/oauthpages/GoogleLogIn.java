package com.objects.npobjects.pageobjects.oauthpages;

import com.objects.npobjects.NPPageObject;
import com.service.ui.web.SeleniumDriverWrapper;
import org.openqa.selenium.By;
import org.testng.Assert;

public class GoogleLogIn extends NPPageObject
{
	private By emailInput = By.xpath("//input[@type='email']");
	private By nextBtn = By.xpath("//div[@role='button']");
	private By nextPassBtn = By.xpath("//div[@role='button' and @id='passwordNext']");
	private By passwordInput = By.xpath("//input[@type='password']");
	private By advancedBtn = By.xpath("//div/a[contains(text(), 'Advanced')]");
	private By gotoBtn = By.xpath("//a[contains(text(), 'Go to newpeople.co (unsafe)')]");
	private By allowBtn = By.xpath("//div[@role='button' and @id='submit_approve_access']");
	private By permissionBtn = By.xpath("//content/following-sibling::div//span[contains(text(), 'Allow')]");

	public GoogleLogIn(SeleniumDriverWrapper driver)
	{
		super("", driver);
	}

	@Override
	public boolean validateElements()
	{
		return driver.waitUntilClickable(emailInput, 10)
				  && driver.waitUntilClickable(nextBtn);

	}

	public GoogleLogIn checkIsRendered()
	{
		super.checkIsRendered();
		return this;
	}

	public GoogleLogIn enteremailInput(String text)
	{
		Assert.assertTrue(driver.type(emailInput, text));
		return this;
	}

	public GoogleLogIn enterpasswordInput(String text)
	{
		Assert.assertTrue(driver.type(passwordInput, text));
		return this;
	}

	public GoogleLogIn clicknextBtn()
	{
		Assert.assertTrue(driver.click(nextBtn));
		return this;
	}

	public GoogleLogIn clicknextPassBtn()
	{
		Assert.assertTrue(driver.click(nextPassBtn));
		return this;
	}

	public GoogleLogIn clickadvancedBtn()
	{
		Assert.assertTrue(driver.click(advancedBtn));
		return this;
	}

	public GoogleLogIn clickgotoBtn()
	{
		Assert.assertTrue(driver.waitUntilClickable(gotoBtn));
		Assert.assertTrue(driver.click(gotoBtn));
		return this;
	}

	public GoogleLogIn clickallowBtn()
	{
		Assert.assertTrue(driver.waitUntilClickable(allowBtn));
		Assert.assertTrue(driver.click(allowBtn));
		return this;
	}

	public GoogleLogIn clickPermissionBtn()
	{
		Assert.assertTrue(driver.waitUntilClickable(permissionBtn));
		Assert.assertTrue(driver.click(permissionBtn));
		return this;
	}

}
