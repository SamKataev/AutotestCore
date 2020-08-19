package com.objects.npobjects.pageelements.panels;

import com.objects.PageElement;
import com.service.ui.web.SeleniumDriverWrapper;
import org.openqa.selenium.By;
import org.testng.Assert;

public abstract class Panel extends PageElement
{
	protected final By waiterCover = By.cssSelector(".waiter-cover");

	public Panel(SeleniumDriverWrapper driver)
	{
		super(driver);
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

	protected By subPanelTwoLineListItemWithText(String text)
	{
		return By.xpath("//div[contains(@class, 'sub-panel')]//span[contains(@class, 'mdc-list-item__primary-text') and text() = '" + text + "']/ancestor::li");
	}

	protected By subPanelTwoLineListItemWithPrimeSecondText(String primeText, String secondText, String panelClass)
	{
		return By.xpath("//div[contains(@class, 'sub-panel') and contains(@class, '" + panelClass + "')]//span[contains(@class, 'mdc-list-item__primary-text') and text() = '" + primeText + "']/following-sibling::span[contains(@class, 'mdc-list-item__secondary-text') and text() = '" + secondText + "']/ancestor::li");
	}

	protected By subPanelTwoLineListItemWithPrimeSecondText(String primeText, String secondText)
	{
		return By.xpath("//div[contains(@class, 'sub-panel')]//span[contains(@class, 'mdc-list-item__primary-text') and text() = '" + primeText + "']/following-sibling::span[contains(@class, 'mdc-list-item__secondary-text') and text() = '" + secondText + "']/ancestor::li");
	}

	protected By subPanelTwoLineListItemWithText(String text, String panelClass)
	{
		return By.xpath("//div[contains(@class, 'sub-panel') and contains(@class, '" + panelClass + "')]//span[contains(@class, 'mdc-list-item__primary-text') and text() = '" + text + "']/ancestor::li");
	}

	protected By subPaneTwoLinelListItemWithTextIcon(String text, String iconClass)
	{
		return By.xpath("//div[contains(@class, 'sub-panel')]//span[contains(@class, 'mdc-list-item__primary-text') and text() = '" + text + "']/preceding-sibling::span[contains(@class, '" + iconClass +" ')]/ancestor::li");
	}

	protected By subPanelListItemWithText(String text)
	{
		return By.xpath("//div[contains(@class, 'sub-panel')]//span[contains(@class, 'mdc-list-item__text') and text() = '" + text + "']/ancestor::li");
	}

	protected By subPanelListItemWithText(String text, String panelClass)
	{
		return By.xpath("//div[contains(@class, 'sub-panel') and contains(@class, '" + panelClass + "')]//span[contains(@class, 'mdc-list-item__text') and text() = '" + text + "']/ancestor::li");
	}

	protected By subPanelListItemWithTextIcon(String text, String iconClass)
	{
		return By.xpath("//div[contains(@class, 'sub-panel')]//span[contains(@class, 'mdc-list-item__text') and text() = '" + text + "']/preceding-sibling::span[contains(@class, '" + iconClass +"')]/ancestor::li");
	}

	protected By subPanelIconFontBtn(String iconClass)
	{
		return By.xpath("//div[contains(@class, 'sub-panel')]//span[contains(@class, '" + iconClass + "')]/parent::span[contains(@class, 'mdc-icon-toggle')]");
	}

	protected By subPanelIconFontBtn(String iconClass, String panelClass)
	{
		return By.xpath("//div[contains(@class, 'sub-panel') and contains(@class, '" + panelClass + "')]//span[contains(@class, '" + iconClass + "')]/parent::span[contains(@class, 'mdc-icon-toggle')]");
	}

	protected By subPanelUnelevatedBtn(String btnText)
	{
		return By.xpath("//div[contains(@class, 'sub-panel')]//button[contains(@class, 'mdc-button--unelevated') and contains(text(), '" + btnText + "')]");
	}

	protected By subPanelUnelevatedBtn(String btnText, String panelClass)
	{
		return By.xpath("//div[contains(@class, 'sub-panel') and contains(@class, '" + panelClass + "')]//button[contains(@class, 'mdc-button--unelevated') and contains(text(), '" + btnText + "')]");
	}

	protected By subPanelTextBtn(String btnText, String panelClass)
	{
		return By.xpath("//div[contains(@class, 'sub-panel') and contains(@class, '" + panelClass + "')]//button[contains(@class, 'mdc-button--black') and contains(text(), '" + btnText + "')]");
	}

	protected By subPanelTextBtn(String btnText)
	{
		return By.xpath("//div[contains(@class, 'sub-panel')]//button[contains(@class, 'mdc-button--black') and contains(text(), '" + btnText + "')]");
	}

	protected By subPanelBtn(String btnText)
	{
		return By.xpath("//div[contains(@class, 'sub-panel')]//button[contains(@class, 'mdc-button') and contains(text(), '" + btnText + "')]");
	}
}