package com.service;

import java.io.FileInputStream;
import java.io.IOException;

public class TestProperties extends java.util.Properties {

    public static String getProp(String propName) {
        FileInputStream fis;
        java.util.Properties property = new java.util.Properties();
        try {
            fis = new FileInputStream("src/main/resources/test.properties");
            property.load(fis);
        } catch (IOException e) {
            System.err.println("error reading properties file");
        }
        return property.getProperty(propName);
    }

    public static int getPropInt(String propName) {
        try {
            return Integer.parseInt(getProp(propName));
        } catch (NumberFormatException e) {
            return 0;
        }
    }
}
