package com.service;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class CommonService
{

	public static ArrayList<String> parseStringByDelimeter(String data)
	{
		ArrayList<String> res = new ArrayList<>(Arrays.asList(data.split(";")));
		res.replaceAll(String::trim);
		res.removeIf(String::isEmpty);
		return res;
	}
}
