package com.tests.ui.npuitests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginPage extends NPWebTest
{

	@BeforeClass
	@Override
	public void startNPTestClass()
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
		authPage.checkErrorMessageText("Invalid email or password");
	}

	@Test
	public void loginWithEmptyPassFails()
	{
		authPage.logIn("slemmatest@mail.ru", "");
		authPage.checkErrorMessageText("Invalid email or password");
	}

	@Test
	public void loginWithWrongPassFails()
	{
		authPage.logIn("slemmatest@mail.ru", "111111");
		authPage.checkErrorMessageText("Invalid email or password");
	}

	@Test
	public void loginWithWrongEmailFails()
	{
		authPage.logIn("slemmatest222@mail.ru", "jF!1234asd");
		authPage.checkErrorMessageText("Invalid email or password");
	}

	@Test
	public void loginWithEmptyEmailFails()
	{
		authPage.logIn("", "111111");
		authPage.checkErrorMessageText("Invalid email or password");
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
//        authPage.checkMessageDialogText("Invalid email or password");
//    }
}
