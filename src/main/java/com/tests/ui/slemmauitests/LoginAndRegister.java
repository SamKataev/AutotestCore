package com.tests.ui.slemmauitests;

import com.objects.slemmaobjects.pageobjects.AuthPage;
import com.tests.ui.WebTest;
import org.testng.annotations.Test;

public class LoginAndRegister extends WebTest {

    @Test
    public void login(){
        AuthPage page = new AuthPage(baseUrl, webDriver);
        page.logIn("","");
    }

}
