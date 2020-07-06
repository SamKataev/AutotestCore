package com.tests.ui.npuitests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginPageTest extends NPWebTest
{

	@BeforeClass
	@Override
	public void startTestClass()
	{
		//empty to cancel default behavior
	}

	@BeforeMethod
	public void startTestMethod()
	{
		authPage.open().checkIsRendered();
	}

	@Test
	public void loginWithAllEmptyFieldsFails()
	{
		authPage.logIn("", "");
		authPage.checkErrorMessage("Invalid Email or Password");
	}

	@Test
	public void loginWithEmptyPassFails()
	{
		authPage.logIn("slemmatest@mail.ru", "");
		authPage.checkErrorMessage("Invalid Email or Password");
	}

	@Test
	public void loginWithWrongPassFails()
	{
		authPage.logIn("slemmatest@mail.ru", "111111");
		authPage.checkErrorMessage("Invalid Email or Password");
	}

	@Test
	public void loginWithWrongEmailFails()
	{
		authPage.logIn("slemmatest222@mail.ru", "jF!1234asd");
		authPage.checkErrorMessage("Invalid Email or Password");
	}

	@Test
	public void loginWithEmptyEmailFails()
	{
		authPage.logIn("", "111111");
		authPage.checkErrorMessage("Invalid Email or Password");
	}

//    @Test
//    public void checkRegisterButtonFromLoginPage(){
//        authPage.clickRegister();
//        registerPage.checkIsRendered();
//    }

//    @Test
//    public void resetPasswordWithWrongEmailClickFails(){
//        authPage.enterEmail("1@2.3")
//                .clickPassReset()
//                .checkIsRendered()
//                .clickReset();
//        authPage.checkMessageDialogText("Invalid Email or Password");
//    }
}
