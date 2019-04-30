package com.tests.ui.slemmauitests;

import org.testng.annotations.Test;

public class Editors extends SlemmaWebTest
{

	@Test
	public void renameSource()
	{
		homePage.navigatorObjectsList.clickDashboardByName("rename tests");
		dashboardPage.checkIsRendered()
				  .switchEdit().checkIsEditable()
				  .clickChartByName("GDrive")
				  .clickChartCornerButton("GDrive").checkIsRendered()
				  .clickLayout().checkIsRendered()
				  .checkDataSourceName("Source")
				  .clickDatasource()
				  .clickEditDataset();
		datasourcePage.checkIsRendered()
				  .clickCaption().checkIsRendered()
				  .typeName("Source after rename")
				  .clickRename();
		datasourcePage.checkIsRendered()
				  .checkCaption("Source after rename")
				  .clickDone();
		pause(5);
		dashboardPage.checkIsRendered()
				  .clickChartByName("GDrive")
				  .clickChartCornerButton("GDrive").checkIsRendered()
				  .clickLayout().checkIsRendered()
				  .checkDataSourceName("Source after rename")

				  //restore initial test data
				  .clickDatasource()
				  .clickEditDataset();
		datasourcePage.checkIsRendered()
				  .clickCaption().checkIsRendered()
				  .typeName("Source")
				  .clickRename();
		datasourcePage.checkIsRendered()
				  .checkCaption("Source")
				  .clickDone();
	}

	@Test
	public void renameDatasetFields()
	{
		homePage.navigatorObjectsList.clickDashboardByName("rename tests");
		dashboardPage.checkIsRendered()
				  .switchEdit().checkIsEditable()
				  .clickChartByName("GDrive")
				  .clickChartCornerButton("GDrive").checkIsRendered()
				  .clickLayout().checkIsRendered()
				  .checkFieldExist("Company")
				  .checkFieldExist("Value")
				  .clickDatasource()
				  .clickEditDataset();
		datasourcePage.checkIsRendered()
				  .clickField("Company").checkIsRendered()
				  .typeFieldName("Company after rename")
				  .clickOK()
				  .clickField("Value").checkIsRendered()
				  .typeFieldName("Value after rename")
				  .clickOK()
				  .clickDone();
		dashboardPage.checkIsRendered();
		driver.refreshPage();
		pause(5);
		dashboardPage.checkIsRendered()
				  .switchEdit().checkIsEditable()
				  .clickChartByName("GDrive")
				  .clickChartCornerButton("GDrive").checkIsRendered()
				  .clickLayout().checkIsRendered()
				  .checkFieldExist("Company after rename")
				  .checkFieldExist("Value after rename")

				  //restore initial test data
				  .clickDatasource()
				  .clickEditDataset();
		datasourcePage.checkIsRendered()
				  .clickField("Company after rename").checkIsRendered()
				  .typeFieldName("Company")
				  .clickOK()
				  .clickField("Value after rename").checkIsRendered()
				  .typeFieldName("Value")
				  .clickOK()
				  .clickDone();
	}
}
