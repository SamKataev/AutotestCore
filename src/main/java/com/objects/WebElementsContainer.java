package com.objects;

import com.service.ui.web.SeleniumDriverWrapper;
import org.openqa.selenium.By;
import org.testng.Assert;

/**
 * purpose of this class is to encapsulate formatting locators of web elements
 * inherited class should call isRendered() or validateElements() to check if necessary web elements are rendered and available by web driver
 */
public abstract class WebElementsContainer
{

	protected SeleniumDriverWrapper driver;

	public WebElementsContainer(SeleniumDriverWrapper webDriver)
	{
		driver = webDriver;
	}

	public abstract boolean validateElements();

	public boolean isRendered()
	{
		return validateElements();
		//TODO: add more checks i.e all ajax requests resolved
	}

	public WebElementsContainer checkIsRendered()
	{
		Assert.assertTrue(isRendered());
		return this;
	}

	protected void pause(int timeInSeconds)
	{
		try
		{
			if (timeInSeconds > 0)
			{
				Thread.sleep(timeInSeconds * 1000);
			}
		}
		catch (InterruptedException e)
		{
			System.out.println("thread sleep interrupted: " + e.getMessage());
		}
	}

	/**
	 * @deprecated use By.cssSelector directly instead.
	 */
	@Deprecated
	protected By classSelector(String name)
	{
		return By.cssSelector("." + name);
	}

	protected By idSelector(String id)
	{
		return By.id(id);
	}

	protected By containsText(String text)
	{
		return By.xpath("//*[contains(text(), '" + text + "')]");
	}

	protected By containsValue(String text)
	{
		return By.xpath("//*[contains(@value, '" + text + "')]");
	}

	protected By classContainsText(String name, String text)
	{
		return By.xpath("//*[contains(@class, '" + name + "') and contains(text(), '" + text + "')]");
	}

	protected By classWithText(String name, String text)
	{
		return By.xpath("//*[contains(@class, '" + name + "') and text() = '" + text + "']");
	}

	protected By inputInParentDivClass(String name)
	{
		return By.xpath("//div[contains(@class, '" + name + "')]//input");
	}

	protected By classInParentClass(String className, String parentClassName)
	{
		return By.xpath("//*[contains(@class, '" + parentClassName + "')]//*[contains(@class, '" + className + "')]");
	}

	protected By classWithTextInParentClass(String className, String subClassName, String text)
	{
		return By.xpath("//*[contains(@class, '" + className + "')]//*[contains(@class, '" + subClassName + "') and contains(text(), '" + text + "')]");
	}

	protected By classWithTextInChildClass(String className, String subclassName, String text)
	{
		return By.xpath("//*[contains(@class, '" + subclassName + "') and contains(text(), '" + text + "')]/ancestor::*[contains(@class, '" + className + "')]");
	}

	protected By classBySubclass(String className, String subclassName)
	{
		return By.xpath("//*[contains(@class, '" + subclassName + "')]/ancestor::*[contains(@class, '" + className + "')]");
	}


	//mdc components xPath locators////////////////////////////////////////////////////////////////////////

	protected By mdcListItemWithText(String text)
	{
		return By.xpath("//span[contains(@class, 'mdc-list-item__text') and contains(text(), '" + text + "')]/parent::li");
	}

	protected By mdcListItemWithTextIcon(String text, String iconClass)
	{
		return By.xpath("//span[contains(@class, 'mdc-list-item__text') and contains(text(), '" + text + "')]/preceding-sibling::span[contains(@class, '" + iconClass + "')]/parent::li");
	}

	protected By mdcIconFontBtn(String iconClass)
	{
		return By.xpath("//span[contains(@class, '" + iconClass + "')]/parent::span[contains(@class, 'mdc-icon-toggle')]");
	}

	protected By mdcTextBtn(String btnText)
	{
		return By.xpath("//button[contains(@class, 'mdc-button') and contains(text(), '" + btnText + "')]");
	}

	protected By mdcAppBarTitle(String titleText)
	{
		return By.xpath("//span[contains(@class, 'mdc-top-app-bar__title') and contains(text(), '" + titleText + "')]");
	}

	protected By npTextFieldWithLabel(String label)
	{
		return By.xpath("//label[contains(@class, text-field__label) and contains(text(), '" + label + "')]/following-sibling::div[contains(@class, 'text-field__input-container')]/input");
	}


}
