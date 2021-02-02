package com.tests.ui.slemmauitests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegistrationPage extends SlemmaWebTest
{

	@BeforeClass
	@Override
	public void startClass()
	{
		//empty to cancel default behavior
	}

	@BeforeMethod
	public void startMethod()
	{
		registerPage.open().checkIsRendered();
	}

	@Test
	public void registerWithAllEmptyFieldsFails()
	{
		registerPage.clickPolicyCheckBox()
				  .clickCreateAcc()
				  .checkMessageDialogText("Некорректный эл. адрес");
	}

	@Test
	public void registerWithWrongEmailFails()
	{
		registerPage.clickPolicyCheckBox()
				  .enterEmail("wrong@email")
				  .clickCreateAcc()
				  .checkMessageDialogText("Некорректный эл. адрес");
	}

	@Test
	public void registerWithoutPasswordFails()
	{
		registerPage.clickPolicyCheckBox()
				  .enterEmail("slemmatest2@mail.ru")
				  .clickCreateAcc()
				  .checkMessageDialogContainsText("Введенный вами пароль не соответствует нашим требованиям безопасности:");
	}

	@Test
	public void registerWithPasswordOfAllSpacesFails()
	{
		registerPage.clickPolicyCheckBox()
				  .enterEmail("slemmatest2@mail.ru")
				  .enterPass("     ")
				  .clickCreateAcc()
				  .checkMessageDialogContainsText("Введенный вами пароль не соответствует нашим требованиям безопасности:");
	}

	@Test
	public void registerWithExistingUserDataFails()
	{
		registerPage.clickPolicyCheckBox()
				  .enterEmail("slemmatest2@mail.ru")
				  .enterPass("jF!1234asd")
				  .clickCreateAcc()
				  .checkMessageDialogContainsText("Пользователь с такой электронной почтой уже существует");
	}

	@Test
	public void registerWithShortPasswordFails()
	{
		registerPage.clickPolicyCheckBox()
				  .enterEmail("slemmatest2@mail.ru")
				  .enterPass("123456")
				  .clickCreateAcc()
				  .checkMessageDialogContainsText("Введенный вами пароль не соответствует нашим требованиям безопасности");
	}

	@Test
	public void registerWithAllDigitsPasswordFails()
	{
		registerPage.clickPolicyCheckBox()
				  .enterEmail("slemmatest2@mail.ru")
				  .enterPass("123456789")
				  .clickCreateAcc()
				  .checkMessageDialogContainsText("Введенный вами пароль не соответствует нашим требованиям безопасности");
	}

	@Test
	public void registerWithAllCharsPasswordFails()
	{
		registerPage.clickPolicyCheckBox()
				  .enterEmail("slemmatest2@mail.ru")
				  .enterPass("Abcdefghij")
				  .clickCreateAcc()
				  .checkMessageDialogContainsText("Введенный вами пароль не соответствует нашим требованиям безопасности");
	}

	@Test
	public void registerWithLowercaseCharsAndUpcaseCharsPasswordFails()
	{
		registerPage.clickPolicyCheckBox()
				  .enterEmail("slemmatest2@mail.ru")
				  .enterPass("abcdefghijABC")
				  .clickCreateAcc()
				  .checkMessageDialogContainsText("Введенный вами пароль не соответствует нашим требованиям безопасности");
	}

	@Test
	public void registerWithDigitsAndSymbolsPasswordFails()
	{
		registerPage.clickPolicyCheckBox()
				  .enterEmail("slemmatest2@mail.ru")
				  .enterPass("12345!#^@$")
				  .clickCreateAcc()
				  .checkMessageDialogContainsText("Введенный вами пароль не соответствует нашим требованиям безопасности");
	}

	@Test
	public void registerNotAvailableWithAgreeCheckboxOff()
	{
		registerPage.enterEmail("slemmatest2@mail.ru")
				  .enterPass("jF!1234asd")
				  .checkCreateAccBtnIsUnavailable();
	}

	@Test
	public void checkLoginButtonFromRegisterPage()
	{
		registerPage.clickSignIn();
		authPage.checkIsRendered();
	}

}

