package com.service.ui.web;

import com.service.ScreenShooter;
import com.service.ui.UIDriverWrapper;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.log4testng.Logger;

import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * purpose of this wrapper is to encapsulate usage of selenium WebDriver:
 * - all WebDriverExceptions should be caught in this class
 * - all methods should return void or boolean to simplify assertion
 * - all methods that use WebElement should accept wait timeout argument of type int
 * - implicitlyWait web driver prop is set to 0, it is "overridden" by defaultWaitTime prop for more flexible timeouts adjustment
 * - initDriver() is abstract to be implemented in a specific driver wrapper class
 */
public abstract class SeleniumDriverWrapper implements UIDriverWrapper
{

	WebDriver webDriver;
	private String mainHandle;
	private String baseUrl;
	private String userFolder;


	enum WaiterType
	{
		EXIST, VISIBLE, CLICKABLE, DISAPPEAR, FRAMEAVAILABLE
	}

	private int defaultWaitTime;

	private static final Logger log = Logger.getLogger(SeleniumDriverWrapper.class);

	public boolean init()
	{
		if (initDriver())
		{
			defaultWaitTime = 5;
			webDriver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
			webDriver.manage().window().maximize();
			setMainWindowHandle(getCurrentWindowHandle());
			return true;
		}
		return false;
	}

	abstract boolean initDriver();

	public void close()
	{
		try
		{
			webDriver.close();
		}
		catch (WebDriverException e)
		{
			System.out.println("error closing web driver in driver wrapper: " + e.getMessage());
			getScreenshot("close");
		}
	}

	public boolean click(Object object)
	{
		if (object instanceof By)
		{
			return clickWebElement((By) object, defaultWaitTime);
		}
		else
		{
			System.out.println("wrong argument type");
			getScreenshot("click");
		}
		return false;
	}

	public boolean type(Object object, String text)
	{
		if (object instanceof By)
		{
			return typeWebElement((By) object, text, defaultWaitTime);
		}
		else
		{
			System.out.println("wrong argument type");
			getScreenshot("type");
		}
		return false;
	}

	private boolean clickWebElement(By locator, int time)
	{
		if (waitUntilClickable(locator, time))
		{
			try
			{
				getElement(locator, time).click();
				return true;
			}
			catch (WebDriverException e)
			{
				System.out.println("error clicking web element" + getElement(locator, time).getLocation() + ": " + e.getMessage().substring(0, 200) + "...");
				getScreenshot("clickWebElement");
			}
		}
		return false;
	}

	private boolean typeWebElement(By locator, String text, int time)
	{
		if (waitUntilClickable(locator, time))
		{
			try
			{
				WebElement el = getElement(locator, time);
				el.clear();
				el.sendKeys(text);
				return true;
			}
			catch (WebDriverException e)
			{
				System.out.println("error typing in web element" + getElement(locator, time).getLocation() + ": " + e.getMessage().substring(0, 35) + "...");
				getScreenshot("typeWebElement");
			}
		}
		return false;
	}

	public void goToUrl(String url)
	{
		webDriver.get(url);
	}

	public void refreshPage()
	{
		goToUrl(getCurrentUrl());
	}

	public void switchWindow()
	{
		switchWindow(defaultWaitTime);
	}

	public void switchWindow(int timeout)
	{
		try
		{
			Thread.sleep(timeout * 1000);
			switchRandomWindow();
		}
		catch (InterruptedException e)
		{
			System.out.println("error switching window with timeout" + timeout + " seconds: " + e.getMessage());
			getScreenshot("switchWindow");
		}
	}

	/**
	 * switches to random window other than main window
	 */
	public void switchRandomWindow()
	{
		Set<String> windowHandles = webDriver.getWindowHandles();
		if (windowHandles.size() > 1)
		{
			windowHandles.forEach((handler) -> {
				if (!handler.equals(mainHandle))
				{
					webDriver.switchTo().window(handler);
				}
			});
		}
	}

	public void switchToMainWindow()
	{
		webDriver.switchTo().window(getMainWindowHandle());
	}

	public void switchToMainWindow(int timeout)
	{
		try
		{
			Thread.sleep(timeout * 1000);
			webDriver.switchTo().window(getMainWindowHandle());
		}
		catch (InterruptedException e)
		{
			System.out.println("error switching to main window with timeout" + timeout + " seconds: " + e.getMessage());
			getScreenshot("switchWindow");
		}
	}

	public void switchToDefaultContent()
	{
		switchToDefaultContent(defaultWaitTime);
	}

	public void switchToDefaultContent(int timeout)
	{
		try
		{
			Thread.sleep(timeout * 1000);
			webDriver.switchTo().defaultContent();
		}
		catch (InterruptedException e)
		{
			System.out.println("error switching to default content with timeout" + timeout + " seconds: " + e.getMessage());
			getScreenshot("switchToDefaultContent");
		}
	}

	public String getBaseUrl()
	{
		return baseUrl;
	}

	public String getCurrentUrl()
	{
		isAlertPresent();
		return webDriver.getCurrentUrl();
	}

	public void setBaseUrl(String url)
	{
		baseUrl = url;
	}

	public String getMainWindowHandle()
	{
		return mainHandle;
	}

	public void setMainWindowHandle(String arg)
	{
		mainHandle = arg;
	}

	public void setUserFolder(String Folder)
	{
		userFolder = Folder;
	}

	public String getUserFolder()
	{
		return userFolder;
	}

	public String getCurrentWindowHandle()
	{
		return webDriver.getWindowHandle();
	}

	public void setDefaultWaitTime(int time)
	{
		defaultWaitTime = time;
	}

	public int getDefaultWaitTime()
	{
		return defaultWaitTime;
	}

	public WebElement getElement(By locator, int time)
	{
		return waitUntilExist(locator, time) ? webDriver.findElement(locator) : null;
	}

	public WebElement getElement(By locator)
	{
		return getElement(locator, defaultWaitTime);
	}

	public boolean waitUntilExist(By locator, int time, boolean log)
	{
		return waitUntilConditions(locator, time, WaiterType.EXIST, log);
	}

	public boolean waitUntilExist(By locator, int time)
	{
		return waitUntilConditions(locator, time, WaiterType.EXIST, true);
	}

	public boolean waitUntilExist(By locator)
	{
		return waitUntilExist(locator, defaultWaitTime);
	}

	public boolean waitUntilVisible(By locator, int time)
	{
		return waitUntilConditions(locator, time, WaiterType.VISIBLE, true);
	}

	public boolean waitUntilVisible(By locator)
	{
		return waitUntilVisible(locator, defaultWaitTime);
	}

	public boolean waitUntilClickable(By locator, int time, boolean log)
	{
		return waitUntilConditions(locator, time, WaiterType.CLICKABLE, log);
	}

	public boolean waitUntilClickable(By locator, int time)
	{
		return waitUntilConditions(locator, time, WaiterType.CLICKABLE, true);
	}

	public boolean waitUntilClickable(By locator)
	{
		return waitUntilClickable(locator, defaultWaitTime);
	}

	public boolean waitUntilDisappear(By locator, int time, boolean log)
	{
		return waitUntilConditions(locator, time, WaiterType.DISAPPEAR, log);
	}

	public boolean waitUntilDisappear(By locator, int time)
	{
		return waitUntilConditions(locator, time, WaiterType.DISAPPEAR, true);
	}

	public boolean waitUntilDisappear(By locator)
	{
		return waitUntilDisappear(locator, defaultWaitTime);
	}

	public boolean waitUntilFrameAvailableAndSwitchToIt(By locator)
	{
		return waitUntilFrameAvailableAndSwitchToIt(locator, defaultWaitTime);
	}

	public boolean waitUntilFrameAvailableAndSwitchToIt(By locator, int time)
	{
		return waitUntilConditions(locator, time, WaiterType.FRAMEAVAILABLE, true);
	}

	private boolean waitUntilConditions(By locator, int time, WaiterType type, boolean log)
	{
		try
		{
			WebDriverWait wait = new WebDriverWait(webDriver, time);
			if (type == WaiterType.EXIST)
			{
				wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			}
			if (type == WaiterType.VISIBLE)
			{
				wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
			}
			if (type == WaiterType.CLICKABLE)
			{
				wait.until(ExpectedConditions.elementToBeClickable(locator));
			}
			if (type == WaiterType.DISAPPEAR)
			{
				wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
			}
			if (type == WaiterType.FRAMEAVAILABLE)
			{
				wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(locator));
			}
		}
		catch (TimeoutException ex)
		{
			if (log)
			{
				System.out.println("timeout " + time + " expired, " + type.toString() + ", " + locator.toString());
				getScreenshot("waitUntilConditions");
			}
			return false;
		}

		return true;

	}

	public void keyboardImitate(CharSequence keys)
	{
		try
		{
			Actions actions = new Actions(webDriver);
			actions.sendKeys(keys).build().perform();
		}
		catch (Exception e)
		{
			System.out.println("Error imitating keys press");
			getScreenshot("keyboardImitate");
		}
	}

	public boolean contextClick(By locator, int time)
	{
		Actions action = new Actions(webDriver);
		WebElement element = webDriver.findElement(locator);
		action.contextClick(element).perform();
		return false;
	}

	public boolean doubleClick(By locator, int time)
	{
		Actions action = new Actions(webDriver);
		WebElement element = webDriver.findElement(locator);
		action.doubleClick(element).perform();
		return false;
	}

	public void getScreenshot(String problem)
	{
		ScreenShooter shooter = new ScreenShooter((getUserFolder() == null ? System.getProperty("user.dir") : getUserFolder()) + "/screenshots/");
		shooter.getScreenShot(webDriver, problem);
	}


	public void isAlertPresent()
	{
		try
		{
			Alert alert=webDriver.switchTo().alert();
   		System.out.println("Всплывающее окно-"+alert.getText());
			alert.accept();
		}
		catch(NoAlertPresentException e)
		{
		}

	}




}