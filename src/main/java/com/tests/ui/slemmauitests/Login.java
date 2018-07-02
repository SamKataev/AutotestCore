package com.tests.ui.slemmauitests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Login extends SlemmaWebTest {

    @BeforeClass
    @Override
    public void startSlemmaTestClass(){
        Assert.assertTrue(authPage.open().isRendered());
    }

    @Test
    public void loginWithTrueCredentials(){
        Assert.assertTrue(logIn());
        Assert.assertTrue(homePage.isLoggedIn());
    }

}
