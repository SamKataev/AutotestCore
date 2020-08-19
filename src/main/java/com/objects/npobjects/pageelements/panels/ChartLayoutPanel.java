package com.objects.npobjects.pageelements.panels;


import com.objects.npobjects.pageobjects.ReportPage;
import com.service.ui.web.SeleniumDriverWrapper;
import junit.framework.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class ChartLayoutPanel extends Panel
{
	public ChooseDimensionPanel chooseDimensionPanel;
	public ChooseMeasurePanel chooseMeasurePanel;

	private ReportPage parentPage;

	private final By title = By.xpath("//div[contains(@class, 'block-settings-panel')]//span[contains(@class, 'mdc-top-app-bar__title') and contains(text(), 'Settings')]");
	private final By addDimensionBtn = subPanelListItemWithText("Add a Dimension", "chart-layout-panel");
	private final By addMeasureBtn = subPanelListItemWithText("Add a Measure", "chart-layout-panel");
	private final By addFilterBtn = subPanelListItemWithText("Add a Filter", "chart-layout-panel");
	private final By addFieldBtn = subPanelListItemWithText("Add a Field", "chart-layout-panel");
	private final By applyBtn = subPanelUnelevatedBtn("Apply");

	public ChartLayoutPanel(SeleniumDriverWrapper driver, ReportPage pageObj)
	{
		super(driver);
		parentPage = pageObj;

		chooseDimensionPanel = new ChooseDimensionPanel(driver , pageObj);
		chooseMeasurePanel = new ChooseMeasurePanel(driver , pageObj);
	}

	@Override
	public boolean validateElements()
	{
		return driver.waitUntilExist(applyBtn, 5)
				  && driver.waitUntilExist(title);
	}

	public ChartLayoutPanel checkIsRendered()
	{
		super.checkIsRendered();
		return this;
	}

	public ChartLayoutPanel checkChartType(String type)
	{
		Assert.assertTrue(driver.waitUntilClickable(subPanelTwoLineListItemWithPrimeSecondText("Chart Type", type)));
		return this;
	}

	public ChartLayoutPanel clickAddDimension()
	{
		Assert.assertTrue(driver.click(addDimensionBtn, 5));
		return this;
	}

	public ChartLayoutPanel clickAddMeasure()
	{
		Assert.assertTrue(driver.click(addMeasureBtn, 5));
		return this;
	}

	public ChartLayoutPanel clickAddFilter()
	{
		Assert.assertTrue(driver.click(addFilterBtn));
		return this;
	}

	public ChartLayoutPanel clickAddField()
	{
		Assert.assertTrue(driver.click(addFieldBtn));
		return this;
	}

	public ChartLayoutPanel checkDimensionExists(String name)
	{
		Assert.assertTrue(driver.waitUntilExist(subPanelListItemWithTextIcon(name, "ic_dimension")));
		return this;
	}

	public ChartLayoutPanel checkMeasureExists(String name)
	{
		Assert.assertTrue(driver.waitUntilExist(subPanelListItemWithTextIcon(name, "ic_measure")));
		return this;
	}

	public ChartLayoutPanel clickApplyBtn()
	{
		Assert.assertTrue(driver.click(applyBtn));
		return this;
	}
}


