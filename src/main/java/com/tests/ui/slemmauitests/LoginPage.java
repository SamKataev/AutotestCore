package com.tests.ui.slemmauitests;

import com.objects.slemmaobjects.pageelements.PasswordResetDialog;
import com.service.TestProperties;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginPage extends SlemmaWebTest
{

	@BeforeClass
	@Override
	public void startSlemmaTestClass()
	{
		//empty to cancel default behavior
	}

	@BeforeMethod
	public void startMethod()
	{
		authPage.open().checkIsRendered();
	}

	@Test
	public void loginWithAllEmptyFieldsFails()
	{
		authPage.logIn("", "");
		authPage.checkErrorMessageText("Пожалуйста, введите ваш эл. адрес");
	}

	@Test
	public void loginWithEmptyPassFails()
	{
		authPage.logIn("slemmatest2@mail.ru", "");
		authPage.checkErrorMessageText("Пожалуйста, введите ваш пароль");
	}

	@Test
	public void loginWithWrongPassFails()
	{
		authPage.logIn("slemmatest2@mail.ru", "111111");
		authPage.checkErrorMessageText("Неверное имя пользователя или пароль");
	}

	@Test
	public void loginWithWrongEmailFails()
	{
		authPage.logIn("slemmatest222@mail.ru", "jF!1234asd");
		authPage.checkErrorMessageText("Неверное имя пользователя или пароль");
	}

	@Test
	public void loginWithEmptyEmailFails()
	{
		authPage.logIn("", "111111");
		authPage.checkErrorMessageText("Пожалуйста, введите ваш эл. адрес");
	}

	@Test
	public void checkRegisterButtonFromLoginPage()
	{
		authPage.clickRegister();
		registerPage.checkIsRendered();
	}

	@Test
	public void resetPasswordWithoutEmailClickFails()
	{
		PasswordResetDialog passResetDiag = authPage.enterEmail("")
				  .clickPassReset();
		passResetDiag.checkIsRendered()
				  .clickReset();
		pause(1);
		passResetDiag.checkIsRendered(); //check is not disappear
	}

	@Test
	public void resetPasswordWithWrongEmailClickFails()
	{
		authPage.enterEmail("1@2.3")
				  .clickPassReset()
				  .checkIsRendered()
				  .clickReset();
		authPage.checkMessageDialogText("Некорректный эл. адрес");
	}

	@Test
	public void samlLoginWithEmptymailClickFails()
	{
		authPage.clickSamlSignIn();
		samlAuthPage.enterEmail("")
				  .clickSignIn();
		samlAuthPage.checkErrorMessageText("Пожалуйста, введите ваш эл. адрес");
	}

	@Test
	public void samlLoginWithWrongEmailClickFails()
	{
		authPage.clickSamlSignIn();
		samlAuthPage.enterEmail("1@2.3")
				  .clickSignIn();
		samlAuthPage.checkErrorMessageText("There are no teams associated with this domain.");
	}

	@Test
	public void goSamlLoginFromLoginPageAndBack()
	{
		authPage.clickSamlSignIn();
		samlAuthPage.checkIsRendered()
				  .clickBackToLogin();
		authPage.checkIsRendered();
	}

//    loginWithOkta
//
//    loginWithOneLogin

}
