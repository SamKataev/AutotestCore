package com.service;

import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

public class CustomTestListener extends TestListenerAdapter {

    @Override
    public void onTestFailure(ITestResult tr) {
        String errorMessage = tr.getThrowable().getMessage();
        String testName = tr.getMethod().getMethodName();
        if (errorMessage.startsWith("expected")) {
            errorMessage = "assertion error";
        }
        System.out.println("test \"" + testName + "\" failed: " + errorMessage + "\n");
    }
}
