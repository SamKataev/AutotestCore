package com.service;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.service.http.HttpRequestWrapper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;

public class CustomJsonParser
{

	public static JsonArray getFileContentAsJsonArray(String filePath)
	{
		String fileContent = getFileContentAsString(filePath);
		if (fileContent != null)
		{
			JsonParser jsonParser = new JsonParser();
			try
			{
				return jsonParser.parse(fileContent).getAsJsonArray();
			}
			catch (Exception e)
			{
				System.out.println("errors in content of \"" + filePath + "\", can't read as JSON Array");
			}
		}
		return null;
	}

	public static JsonObject getFileContentAsJsonObject(String filePath)
	{
		String fileContent = getFileContentAsString(filePath);
		if (fileContent != null)
		{
			JsonParser jsonParser = new JsonParser();
			try
			{
				return jsonParser.parse(fileContent).getAsJsonObject();
			}
			catch (Exception e)
			{
				System.out.println("errors in content of \"" + filePath + "\", can't read as JSON Object");
			}
		}
		return null;
	}

	public static String getFileContentAsString(String filePath)
	{
		try
		{
			return String.join("\n", Files.readAllLines(Paths.get(filePath)));
		}
		catch (IOException e)
		{
			System.out.println("error reading " + filePath);
			return null;
		}
	}

	/**
	 * requests must be stored in json array format, with following structure:
	 * [
	 * {
	 * "name": "<name of the api-test>",
	 * "endpoint": "<api endpoint>" 									//unnecessary prop, overrides default
	 * "headers_set": "<name of header_set>", 					//unnecessary prop, overrides default
	 * "body": {<request body>}, 										//unnecessary prop
	 * "type": "<http request method: get|post|put|delete>",
	 * "method": "<api method>",
	 * "code": <expected response status code>,
	 * "response": {<expected response body>} 					//unnecessary prop
	 * }
	 * [
	 */
	public static ArrayList<HttpRequestWrapper> parseHttpRequests(JsonArray data)
	{
		ArrayList<HttpRequestWrapper> list = new ArrayList<>();
		if (data != null)
		{
			data.forEach((el) -> {
				JsonObject requestContent = el.getAsJsonObject();
				if (validateHttpRequestContent(requestContent))
				{
					HttpRequestWrapper request = new HttpRequestWrapper();
					parseHttpRequestContentToHttpRequest(request, requestContent);
					list.add(request);
				}
				else
				{
					String testName = requestContent.get("name") != null ? requestContent.get("name").getAsString() : "name is missing";
					System.out.println("test \"" + testName + "\", invalid content, can't create request wrapper instance\n");
				}
			});
		}
		return list;
	}

	/**
	 * headers must be stored in json object format, with following structure:
	 * {"<headers set name>": [{"name": "<header name>", "value": "header value"}]}
	 * warning: "default" headers set must be declared in headers file to prevent npe
	 */
	public static HashMap<String, HashMap<String, String>> parseHttpHeaders(JsonObject data)
	{
		HashMap<String, HashMap<String, String>> headersSets = new HashMap<>();
		data.entrySet().forEach(
				  entry -> headersSets.put(
							 entry.getKey(),
							 parseHeadersSetFromJsonArray(entry.getKey(), entry.getValue().getAsJsonArray()))
		);
		return headersSets;
	}

	private static HashMap<String, String> parseHeadersSetFromJsonArray(String setName, JsonArray data)
	{
		HashMap<String, String> headers = new HashMap<>();
		if (data != null)
		{
			data.forEach(el -> {
				JsonObject header = el.getAsJsonObject();
				String name = getStringFromJsonObject("name", header);
				String value = getStringFromJsonObject("value", header);
				if (name != null && value != null)
				{
					headers.put(name, value);
				}
			});
		}
		return headers;
	}

	/**
	 * validates content of http request to have all mandatory props set
	 */
	private static boolean validateHttpRequestContent(JsonObject content)
	{
		return content.get("name") != null && getStringFromJsonObject("name", content) != null
				  && content.get("method") != null && getStringFromJsonObject("method", content) != null
				  && content.get("type") != null && getStringFromJsonObject("type", content) != null
				  && content.get("code") != null && getIntFromJsonObject("code", content) != 0;
	}

	private static void parseHttpRequestContentToHttpRequest(HttpRequestWrapper request, JsonObject content)
	{
		parseValidatedProps(request, content);
		parseOptionalProps(request, content);
	}

	/**
	 * parses only mandatory props validated by validateHttpRequestContent
	 */
	private static void parseValidatedProps(HttpRequestWrapper request, JsonObject content)
	{
		request.setName(getStringFromJsonObject("name", content));
		request.setMethod(getStringFromJsonObject("method", content));
		request.setType(getStringFromJsonObject("type", content));
		request.setExpectedStatusCode(getIntFromJsonObject("code", content));
	}

	/**
	 * parses optional props that are not necessary to set in http test-content file
	 */
	private static void parseOptionalProps(HttpRequestWrapper request, JsonObject content)
	{
		JsonObject body = getJsonObjectFromJsonObject("body", content, false);
		if (body != null)
		{
			request.setBody(body.toString());
		}

		JsonObject response = getJsonObjectFromJsonObject("response", content, false);
		if (response != null)
		{
			request.setExpectedResponseBody(response);
		}

		String endpoint = getStringFromJsonObject("endpoint", content, false);
		if (endpoint != null)
		{
			request.setEndpoint(endpoint);
		}

		String headersSet = getStringFromJsonObject("headers_set", content, false);
		if (headersSet != null)
		{
			request.setHeadersSetName(headersSet);
		}
		else
		{
			request.setHeadersSetName("default");
		}
	}

	public static JsonObject getJsonObjectFromJsonObject(String propName, JsonObject content, boolean logError)
	{
		try
		{
			return content.get(propName).getAsJsonObject();
		}
		catch (Exception e)
		{
			if (logError)
			{
				String testName = content.get("name") != null ? content.get("name").getAsString() : "name is missing";
				System.out.println("test \"" + testName + "\", error parsing JsonObject \"" + propName + "\" from JsonObject");
			}
			return null;
		}
	}

	public static JsonObject getJsonObjectFromJsonObject(String propName, JsonObject content)
	{
		return getJsonObjectFromJsonObject(propName, content, true);
	}

	public static JsonArray getJsonArrayFromJsonObject(String propName, JsonObject content, boolean logError)
	{
		try
		{
			return content.get(propName).getAsJsonArray();
		}
		catch (Exception e)
		{
			if (logError)
			{
				String testName = content.get("name") != null ? content.get("name").getAsString() : "name is missing";
				System.out.println("test \"" + testName + "\", error parsing JsonArray \"" + propName + "\" from JsonObject");
			}
			return null;
		}
	}

	public static JsonArray getJsonArrayFromJsonObject(String propName, JsonObject content)
	{
		return getJsonArrayFromJsonObject(propName, content, true);
	}

	public static String getStringFromJsonObject(String propName, JsonObject content, boolean logError)
	{
		try
		{
			return content.get(propName).getAsString();
		}
		catch (Exception e)
		{
			if (logError)
			{
				String testName = content.get("name") != null ? content.get("name").getAsString() : "name is missing";
				System.out.println("test \"" + testName + "\", error parsing String \"" + propName + "\" from JsonObject");
			}
			return null;
		}
	}

	public static String getStringFromJsonObject(String propName, JsonObject content)
	{
		return getStringFromJsonObject(propName, content, true);
	}

	public static int getIntFromJsonObject(String propName, JsonObject content, boolean logError)
	{
		try
		{
			return content.get(propName).getAsInt();
		}
		catch (Exception e)
		{
			if (logError)
			{
				String testName = content.get("name") != null ? content.get("name").getAsString() : "name is missing";
				System.out.println("test \"" + testName + "\", error parsing int \"" + propName + "\" from JsonObject");
			}
			return 0;
		}
	}

	public static int getIntFromJsonObject(String propName, JsonObject content)
	{
		return getIntFromJsonObject(propName, content, true);
	}

	public static JsonObject initJsonObject(String input)
	{
		JsonParser jsonParser = new JsonParser();
		try
		{
			return jsonParser.parse(input).getAsJsonObject();
		}
		catch (Exception e)
		{
			return new JsonObject();
		}
	}

	public static void removeJsonElements(ArrayList<String> elements, JsonObject obj)
	{
		elements.forEach((el) -> removeJsonElement(el, obj));
	}

	public static void removeJsonElement(String el, JsonObject obj)
	{
		if (obj.get(el) != null)
		{
			obj.remove(el);
		}
	}
}
