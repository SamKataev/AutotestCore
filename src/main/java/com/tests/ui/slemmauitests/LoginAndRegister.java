package com.tests.ui.slemmauitests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginAndRegister extends SlemmaWebTest {

    @BeforeClass
    @Override
    public void startSlemmaTestClass(){
        initPages(this);
        Assert.assertTrue(authPage.open().isOpened());
    }

    @Test
    public void checkLoginWithTrueCredentials(){
        Assert.assertTrue(logIn());
        Assert.assertTrue(homePage.isLoggedIn());
    }

}
