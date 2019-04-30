package com.service.http;

import com.service.CustomTestListener;
import com.tests.http.HttpTest;
import org.testng.*;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * sorts tests received from httpTestsFactory before they are runned by testRunner
 */
public class HttpTestListener extends CustomTestListener implements IMethodInterceptor
{

	@Override
	public List<IMethodInstance> intercept(List<IMethodInstance> testsInTestNG, ITestContext testRunner)
	{
		Collections.sort(testsInTestNG, new TestComparator());
		testsInTestNG.forEach(testInTestNG -> {
			HttpTest test = (HttpTest) testInTestNG.getInstance();
			testInTestNG.getMethod().setDescription(test.getRequestName());
		});
		return testsInTestNG;
	}

	class TestComparator implements Comparator<IMethodInstance>
	{
		@Override
		public int compare(IMethodInstance test1, IMethodInstance test2)
		{
			HttpTest testInstance1 = (HttpTest) test1.getMethod().getInstance();
			HttpTest testInstance2 = (HttpTest) test2.getMethod().getInstance();
			return Integer.compare(testInstance1.getOrder(), testInstance2.getOrder());
		}
	}

	@Override
	public void onTestFailure(ITestResult tr)
	{
		Throwable thr = tr.getThrowable();
		HttpTest test = (HttpTest) tr.getMethod().getInstance();
		tr.setThrowable(new CustomThrowable("test \"" + test.getRequestName() + "\", " + thr.getMessage()));
	}
}


