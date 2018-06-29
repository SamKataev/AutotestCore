package com.tests.ui.slemmauitests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Registration extends SlemmaWebTest {

    @BeforeClass
    @Override
    public void startSlemmaTestClass(){
        Assert.assertTrue(registerPage.open().isRendered());
    }

    @Test
    public void checkRegisterWithTrueCredentials(){
        Assert.assertTrue(logIn());
        Assert.assertTrue(homePage.isLoggedIn());
    }

}
