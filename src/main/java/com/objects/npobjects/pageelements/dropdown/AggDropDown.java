package com.objects.npobjects.pageelements.dropdown;


import com.objects.npobjects.pageobjects.ReportPage;
import com.service.ui.web.SeleniumDriverWrapper;
import org.openqa.selenium.By;
import org.testng.Assert;

public class AggDropDown extends DropDown
{
	private ReportPage parentPage;

	private final By sum = dropDownListItemWithText("Sum");
	private final By avg = dropDownListItemWithText("Average");
	private final By min = dropDownListItemWithText("Minimum");
	private final By max = dropDownListItemWithText("Maximum");
	private final By cntd = dropDownListItemWithText("Distinct Count");
	private final By median = dropDownListItemWithText("Median");

	public AggDropDown(SeleniumDriverWrapper driver, ReportPage pageObj)
	{
		super(driver);
		parentPage = pageObj;
	}

	@Override
	public boolean validateElements()
	{
		return driver.waitUntilClickable(sum)
				  && driver.waitUntilClickable(avg)
				  && driver.waitUntilClickable(min)
				  && driver.waitUntilClickable(max)
				  && driver.waitUntilClickable(cntd)
				  && driver.waitUntilClickable(median);
	}

	public AggDropDown checkIsRendered()
	{
		super.checkIsRendered();
		return this;
	}

	public void clickAgg(String agg)
	{
		switch (agg.toLowerCase())
		{
			case "sum":
				clickSum();
				break;
			case "avg":
				clickAverage();
				break;
			case "min":
				clickMinimum();
				break;
			case "max":
				clickMaximum();
				break;
			case "cntd":
				clickDistinctCount();
				break;
			case "median":
				clickMedian();
				break;
		}
	}

	public ReportPage clickSum()
	{
		Assert.assertTrue(driver.click(sum));
		return parentPage;
	}

	public ReportPage clickAverage()
	{
		Assert.assertTrue(driver.click(avg));
		return parentPage;
	}

	public ReportPage clickMinimum()
	{
		Assert.assertTrue(driver.click(min));
		return parentPage;
	}

	public ReportPage clickMaximum()
	{
		Assert.assertTrue(driver.click(max));
		return parentPage;
	}

	public ReportPage clickDistinctCount()
	{
		Assert.assertTrue(driver.click(cntd));
		return parentPage;
	}

	public ReportPage clickMedian()
	{
		Assert.assertTrue(driver.click(median));
		return parentPage;
	}
}
