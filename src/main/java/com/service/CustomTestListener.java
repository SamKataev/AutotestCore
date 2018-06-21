package com.service;

import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

public class CustomTestListener extends TestListenerAdapter implements ITestListener {

    @Override
    public void onTestFailure(ITestResult tr) {
        tr.setThrowable(new CustomThrowable("test \"" + tr.getMethod().getMethodName() + "\", " + tr.getThrowable().getMessage()));
    }

    protected class CustomThrowable extends Throwable{

        public CustomThrowable(String message){
            super(message,null,false,false);
        }

        public CustomThrowable(){
            super("",null,false,false);
        }
    }
}
