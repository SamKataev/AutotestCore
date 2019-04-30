package com.service;

import java.io.FileInputStream;
import java.io.IOException;

public class TestProperties extends java.util.Properties
{

	public static String getSlemmaProp(String propName)
	{
		FileInputStream fis;
		java.util.Properties property = new java.util.Properties();
		try
		{
			fis = new FileInputStream("src/main/resources/slemmatest.properties");
			property.load(fis);
		}
		catch (IOException e)
		{
			System.err.println("error reading properties file");
		}
		return property.getProperty(propName);
	}

	public static String getNPProp(String propName)
	{
		FileInputStream fis;
		java.util.Properties property = new java.util.Properties();
		try
		{
			fis = new FileInputStream("src/main/resources/nptest.properties");
			property.load(fis);
		}
		catch (IOException e)
		{
			System.err.println("error reading properties file");
		}
		return property.getProperty(propName);
	}

	public static int getSlemmaPropInt(String propName)
	{
		try
		{
			return Integer.parseInt(getSlemmaProp(propName));
		}
		catch (NumberFormatException e)
		{
			return 0;
		}
	}

	public static int getNPPropInt(String propName)
	{
		try
		{
			return Integer.parseInt(getNPProp(propName));
		}
		catch (NumberFormatException e)
		{
			return 0;
		}
	}
}
