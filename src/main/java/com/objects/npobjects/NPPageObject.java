package com.objects.npobjects;

import com.objects.PageObject;
import com.service.ui.web.SeleniumDriverWrapper;
import org.openqa.selenium.By;
import org.testng.Assert;

public abstract class NPPageObject extends PageObject
{

	private By messageDialog = classWithTextInChildClass("mdc-dialog__container", "mdc-top-app-bar__title", "Message");
	private By messageDialogContent = By.xpath("//span[@class='mdc-top-app-bar__title' and text()='Message']/ancestor::div[@class='mdc-dialog__surface']//div[contains(@class, 'mdc-dialog__content')]");
	protected final By waiterCover = By.cssSelector(".waiter-cover");


	public PageObject checkIsRendered()
	{
		super.checkIsRendered();
		checkWaiterDisappeared(10);
		return this;
	}

	public NPPageObject(String pageUrl, SeleniumDriverWrapper webDriver)
	{
		super(pageUrl, webDriver);
	}

	public void checkWaiterDisplayed(int timeout)
	{
		Assert.assertTrue(driver.waitUntilExist(waiterCover, timeout));
	}

	public void checkWaiterDisappeared(int timeout)
	{
		Assert.assertTrue(driver.waitUntilDisappear(waiterCover, timeout));
	}

	public void processWaiter(int timeout)
	{
		if (driver.waitUntilExist(waiterCover, 1, false))
			checkWaiterDisappeared(timeout);
	}

	public boolean isMessageDialogAppears()
	{
		return driver.waitUntilExist(messageDialog, 2);
	}

	public void checkMessageDialogText(String text)
	{
		Assert.assertTrue(isMessageDialogAppears());
		Assert.assertTrue(driver.waitUntilExist(messageDialogContent, 2)
				  && driver.getElement(messageDialogContent).getText().equals(text));
	}

	public void checkMessageDialogContainsText(String text)
	{
		Assert.assertTrue(isMessageDialogAppears());
		Assert.assertTrue(driver.waitUntilExist(messageDialogContent, 2)
				  && driver.getElement(messageDialogContent).getText().contains(text));
	}
}
