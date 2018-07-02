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
    public void registerWithAllEmptyFieldsFails(){
        registerPage.clickPolicyCheckBox()
                    .clickCreateAcc();
        Assert.assertEquals(registerPage.getTextFromMessage(), "Некорректный эл. адрес");
    }

}

