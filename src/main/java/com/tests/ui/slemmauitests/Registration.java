package com.tests.ui.slemmauitests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Registration extends SlemmaWebTest {

    @BeforeClass
    @Override
    public void startSlemmaTestClass(){
        registerPage.open().checkIsRendered();
    }

    @Test
    public void registerWithAllEmptyFieldsFails(){
        registerPage.clickPolicyCheckBox()
                .clickCreateAcc()
                .checkMessageDialogText("Некорректный эл. адрес");
    }

    @Test
    public void registerWithWrongEmailFails(){
        registerPage.clickPolicyCheckBox()
                .enterEmail("wrong@email")
                .clickCreateAcc()
                .checkMessageDialogText("Некорректный эл. адрес");
    }

    @Test
    public void registerWithoutPasswordFails(){
        registerPage.clickPolicyCheckBox()
                .enterEmail("slemmatest2@email.ru")
                .clickCreateAcc()
                .checkMessageDialogContainsText("Введенный вами пароль не соответствует нашим требованиям безопасности:");
    }

    @Test
    public void registerWithPasswordOfAllSpacesFails(){
        registerPage.clickPolicyCheckBox()
                .enterEmail("slemmatest2@email.ru")
                .enterPass("     ")
                .clickCreateAcc()
                .checkMessageDialogContainsText("Введенный вами пароль не соответствует нашим требованиям безопасности:");
    }

    @Test
    public void registerWithExistingUserDataFails(){
        registerPage.clickPolicyCheckBox()
                .enterEmail("slemmatest2@email.ru")
                .enterPass("jF!1234asd")
                .clickCreateAcc()
                .checkMessageDialogContainsText("Пользователь с такой электронной почтой уже существует");
    }

    @Test
    public void checkLoginButtonFromRegisterPage(){
        registerPage.clickSignIn();
        authPage.checkIsRendered();
    }

}

