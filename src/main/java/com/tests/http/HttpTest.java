package com.tests.http;

import com.service.CommonService;
import com.service.http.HttpRequestWrapper;
import org.testng.Assert;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class HttpTest
{

	private HttpRequestWrapper request;
	private int order;

	HttpTest(HttpRequestWrapper request)
	{
		setRequest(request);
	}

	@Parameters({"ignoredProps"})
	@Test
	public void runTest(@Optional("") String ignoredProps)
	{
		Assert.assertTrue(request.send(), "error sending request");
		request.validateStatusCode();
		request.validateResponseBody(CommonService.parseStringByDelimeter(ignoredProps));
	}

	void setRequest(HttpRequestWrapper request)
	{
		this.request = request;
	}

	public int getOrder()
	{
		return order;
	}

	public void setOrder(int order)
	{
		this.order = order;
	}

	public String getRequestName()
	{
		return request.getName();
	}
}
