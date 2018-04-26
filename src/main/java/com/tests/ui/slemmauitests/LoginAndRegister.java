package com.tests.ui.slemmauitests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginAndRegister extends SlemmaWebTest {

    @BeforeClass
    @Override
    public void setStartPage(){
        Assert.assertTrue(authPage.open().isOpened());
    }

    @Test
    public void checkLoginWithTrueCredentials(){
        Assert.assertTrue(login().isLoggedIn());
    }

}
