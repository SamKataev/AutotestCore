package com.objects.slemmaobjects.pageobjects;

import com.objects.slemmaobjects.SlemmaPageObject;
import com.service.ui.web.SeleniumDriverWrapper;
import org.openqa.selenium.By;
import org.testng.Assert;

public class Register extends SlemmaPageObject
{

	private By emailInput = inputInParentDivClass("emailInput");
	private By passInput = inputInParentDivClass("passwordInput");
	private By createAccBtn = classSelector("createBtn");
	private By policyCheckBox = By.xpath("//span[contains(text(), 'Я подтверждаю, что прочитал и согласен с ')]/preceding-sibling::span");
	private By signInBtn = classContainsText("btn__cont", "Войти");

	public Register(SeleniumDriverWrapper driver)
	{
		super(driver.getBaseUrl() + "/register", driver);
	}

	@Override
	public boolean validateElements()
	{
		return driver.waitUntilExist(emailInput)
				  && driver.waitUntilExist(passInput)
				  && driver.waitUntilExist(createAccBtn);
	}

	public Register checkIsRendered()
	{
		super.checkIsRendered();
		return this;
	}

	public Register enterEmail(String text)
	{
		Assert.assertTrue(driver.type(emailInput, text));
		return this;
	}

	public Register enterPass(String text)
	{
		Assert.assertTrue(driver.type(passInput, text));
		return this;
	}

	public Register clickCreateAcc()
	{
		Assert.assertTrue(driver.click(createAccBtn));
		return this;
	}

	public Register clickPolicyCheckBox()
	{
		Assert.assertTrue(driver.click(policyCheckBox));
		return this;
	}

	public Auth clickSignIn()
	{
		Assert.assertTrue(driver.click(signInBtn));
		return new Auth(driver);
	}

	public void checkCreateAccBtnIsUnavailable()
	{
		Assert.assertFalse(driver.click(createAccBtn));
	}

}