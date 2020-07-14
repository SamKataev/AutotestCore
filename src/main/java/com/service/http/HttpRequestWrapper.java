package com.service.http;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.service.CustomJsonParser;
import org.apache.http.HttpResponse;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.TrustAllStrategy;
import org.apache.http.entity.StringEntity;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.*;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.ssl.SSLContextBuilder;
import org.testng.Assert;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class HttpRequestWrapper
{

	private String name;
	private String body;
	private String type;
	private String enpoint;
	private String method;
	private String key;
	private String headersSetName;
	private HashMap<String, String> headers = new HashMap<>();
	private int expectedStatusCode;
	private JsonObject expectedResponseBody;
	private HttpResponse response;

	public boolean send()
	{
		HttpClient client;
		RequestConfig config = RequestConfig.custom().setSocketTimeout(60000).build();

		try
		{
			client = HttpClientBuilder.create()
					  .setSSLContext(new SSLContextBuilder().loadTrustMaterial(null, TrustAllStrategy.INSTANCE).build())  //disable ssl verify for using with local build
					  .setSSLHostnameVerifier(NoopHostnameVerifier.INSTANCE)  //disable host verify for using with local build
					  .setDefaultRequestConfig(config)
					  .build();
		}
		catch (KeyStoreException | KeyManagementException | NoSuchAlgorithmException e)
		{
			System.out.println("test \"" + name + "\", error creating SSL context");
			return false;
		}

		System.out.println("test \"" + name + "\", send request: " + type + " " + getUrl());
		if (type.equals("get") || type.equals("delete"))
		{
			return sendWithoutEntity(client, initRequestWithoutEntity());
		}
		if (type.equals("post") || type.equals("put"))
		{
			return sendWithEntity(client, initRequestWithEntity());
		}
		System.out.println("test \"" + name + "\", invalid request type: " + type);
		return false;
	}

	private boolean sendWithoutEntity(HttpClient client, HttpRequestBase request)
	{
		return request != null
				  && addHeaders(request)
				  && execute(client, request);
	}

	private boolean sendWithEntity(HttpClient client, HttpEntityEnclosingRequestBase request)
	{
		return request != null
				  && addHeaders(request)
				  && setEntity(request)
				  && execute(client, request);
	}

	private boolean addHeaders(HttpRequestBase request)
	{
		if (headers.size() > 0)
		{
			headers.forEach(request::addHeader);
			return true;
		}
		System.out.println("test \"" + name + "\", headers are missing");
		return false;
	}

	private boolean execute(HttpClient client, HttpRequestBase request)
	{
		try
		{
			response = client.execute(request);
			if (response != null)
			{
				return true;
			}
		}
		catch (IOException e)
		{
			System.out.println("test \"" + name + "\", error sending request: " + type);
		}
		return false;
	}

	private HttpRequestBase initRequestWithoutEntity()
	{
		switch (type)
		{
			case "get":
				return new HttpGet(getUrl());
			case "delete":
				return new HttpDelete(getUrl());
			default:
				System.out.println("test \"" + name + "\", invalid request type: " + type);
				return null;
		}
	}

	private HttpEntityEnclosingRequestBase initRequestWithEntity()
	{
		switch (type)
		{
			case "put":
				return new HttpPut(getUrl());
			case "post":
				return new HttpPost(getUrl());
			default:
				System.out.println("test \"" + name + "\", invalid request type: " + type);
				return null;
		}
	}

	private boolean setEntity(HttpEntityEnclosingRequestBase request)
	{
		if (body != null && body.length() > 0)
		{
			try
			{
				request.setEntity(new StringEntity(body));
				return true;
			}
			catch (UnsupportedEncodingException e)
			{
				System.out.println("test \"" + name + "\", invalid request body format");
				return false;
			}
		}
		return true;
	}

	public void validateStatusCode()
	{
		if (response != null)
		{
			Assert.assertEquals(response.getStatusLine().getStatusCode(), expectedStatusCode, "validate status code failed");
		}
	}

	public JsonObject getResponseJsonObject()
	{
		String responseBodyContent = "";
		try
		{
			responseBodyContent = new Scanner(response.getEntity().getContent()).useDelimiter("\\Z").next();
		}
		catch (Exception e)
		{
			System.out.println("test \"" + name + "\", error reading entity from response");
			return new JsonObject();
		}
		return CustomJsonParser.initJsonObject(responseBodyContent);
	}

	public JsonArray getResponseJsonArray()
	{
		String responseBodyContent = "";
		try
		{
			responseBodyContent = new Scanner(response.getEntity().getContent()).useDelimiter("\\Z").next();
		}
		catch (Exception e)
		{
			System.out.println("test \"" + name + "\", error reading entity from response");
			return new JsonArray();
		}
		return CustomJsonParser.initJsonArray(responseBodyContent);
	}

	public void validateResponseBodyAsObject(ArrayList<String> ignoredProps)
	{
		if (expectedResponseBody != null)
		{
			JsonObject responseBody = getResponseJsonObject();
			CustomJsonParser.removeJsonElements(ignoredProps, responseBody);
			Assert.assertEquals(responseBody.toString(), expectedResponseBody.toString(), "validate response body as JSON object failed");
		}
	}

	public void validateResponseBodyAsObject()
	{
		validateResponseBodyAsObject(new ArrayList<>());
	}

	public void validateResponseBodyAsArray()
	{
		if (expectedResponseBody != null)
		{
			JsonArray responseBody = getResponseJsonArray();
			Assert.assertEquals(responseBody.toString(), expectedResponseBody.toString(), "validate response body as JSON array failed");
		}
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getName()
	{
		return this.name;
	}

	public void setType(String type)
	{
		this.type = type;
	}

	public void setHeadersSetName(String headersSetName)
	{
		this.headersSetName = headersSetName;
	}

	public String getHeadersSetName()
	{
		return this.headersSetName;
	}

	public void setBody(String body)
	{
		this.body = body;
	}

	public void setEndpoint(String endpoint)
	{
		this.enpoint = endpoint;
	}

	public String getEndpoint()
	{
		return this.enpoint;
	}

	public void setMethod(String method)
	{
		this.method = method;
	}

	public void setMethodKey(String key)
	{
		this.key = key;
	}

	public void setExpectedStatusCode(int expectedStatusCode)
	{
		this.expectedStatusCode = expectedStatusCode;
	}

	public void setExpectedResponseBody(JsonObject expectedResponseBody)
	{
		this.expectedResponseBody = expectedResponseBody;
	}

	public void setHeader(String name, String value)
	{
		this.headers.put(name, value);
	}

	public void setHeaders(HashMap<String, String> headers)
	{
		clearHeaders();
		this.headers.putAll(headers);
	}

	public HashMap<String, String> getHeaders()
	{
		return this.headers;
	}

	public void clearHeaders()
	{
		this.headers.clear();
	}

	private String getUrl()
	{
		String url = (enpoint != null ? enpoint : "")
				  + (method != null ? method : "")
				  + (key != null ? key : "");
		return url.replaceAll("\\/{2,}", "/").replaceAll(":\\/", "://");
	}
}
