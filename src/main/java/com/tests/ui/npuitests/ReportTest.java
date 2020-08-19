package com.tests.ui.npuitests;


import com.service.TestProperties;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ReportTest extends NPWebTest
{
	String reportKey;

	@BeforeClass
	@Override
	public void startTestClass()
	{
		super.startTestClass();
		changeTeam("TestTeam");

		mainPage.checkIsRendered()
				  .openReports()
				  .clickCreateBtn();
		reportsPage.checkIsRendered()
				  .clickMenuBtn();
		reportsPage.mainMenuDropDown
				  .checkIsRendered()
				  .clickSaveAs();
		reportsPage.saveAsDialog
				  .enterInputName("AutotestReport")
				  .clickDone();

		pause(2);
		String[] url = driver.getCurrentUrl().split("/");
		reportKey = url[url.length - 1];

		reportsPage.clickCloseBtn();
		mainPage.checkIsRendered()
				  .checkObjectByName("AutotestReport");
	}

	/**
	 * reload report page before methods
	 */
	@BeforeMethod
	@Override
	public void startTestMethod()
	{
		if (!driver.getCurrentWindowHandle().equals(driver.getMainWindowHandle()))
			driver.switchToMainWindow();

		openReport(reportKey);
		reportsPage.checkIsRendered();
	}

	@Test
	public void insertImage()
	{
		reportsPage.clickEditBtn()
				  .clickInsertBtn();
		reportsPage.insertBlockDropDown
				  .checkIsRendered()
				  .uploadFile(TestProperties.getNPProp("imgFilePath"));
		reportsPage.checkImageBlockExists()
				  .clickMenuBtn();
		reportsPage.mainMenuDropDown
				  .checkIsRendered()
				  .clickSave();
	}

	@Test
	public void insertEmbed()
	{
		reportsPage.clickEditBtn()
				  .clickInsertBtn();
		reportsPage.insertBlockDropDown
				  .checkIsRendered()
				  .clickURLEmbed();
		reportsPage.hTTPSwebAddressDialog.checkIsRendered()
				  .typeUrl("https://repapplic.com")
				  .clickOk();
		reportsPage.checkWebContentBlockExists()
				  .clickMenuBtn();
		reportsPage.mainMenuDropDown
				  .checkIsRendered()
				  .clickSave();
	}

	@Test
	public void insertColumnChart()
	{
		insertChartOfType("Column", "source");
		addDimension("Company");
		addMeasure("Value", "sum");
		saveReport();
	}

	@Test
	public void insertStackedColumnChart()
	{
		insertChartOfType("Stacked Column", "source");
		addDimension("Company");
		addMeasure("Value", "sum");
		saveReport();
	}

	@Test
	public void insertFullStackedColumnChart()
	{
		insertChartOfType("100% Stacked Column", "source");
		addDimension("Company");
		addMeasure("Value", "sum");
		saveReport();
	}

	@Test
	public void insertBarChart()
	{
		insertChartOfType("Bar", "source");
		addDimension("Company");
		addMeasure("Value", "sum");
		saveReport();
	}

	@Test
	public void insertStackedBarChart()
	{
		insertChartOfType("Stacked Bar", "source");
		addDimension("Company");
		addMeasure("Value", "sum");
		saveReport();
	}

	@Test
	public void insertFullStackedBarChart()
	{
		insertChartOfType("100% Stacked Bar", "source");
		addDimension("Company");
		addMeasure("Value", "sum");
		saveReport();
	}

	@Test
	public void insertLineChart()
	{
		insertChartOfType("Line", "source");
		addDimension("Company");
		addMeasure("Value", "sum");
		saveReport();
	}

	@Test
	public void insertAreaChart()
	{
		insertChartOfType("Area", "source");
		addDimension("Company");
		addMeasure("Value", "sum");
		saveReport();
	}

	@Test
	public void insertStackedAreaChart()
	{
		insertChartOfType("Stacked Area", "source");
		addDimension("Company");
		addMeasure("Value", "sum");
		saveReport();
	}

	@Test
	public void insertFullStackedAreaChart()
	{
		insertChartOfType("100% Stacked Area", "source");
		addDimension("Company");
		addMeasure("Value", "sum");
		saveReport();
	}

	@Test
	public void insertPieChart()
	{
		insertChartOfType("Donut", "source");
		addDimension("Company");
		addMeasure("Value", "sum");
		saveReport();
	}

	@Test
	public void insertDonutChart()
	{
		insertChartOfType("Donut", "source");
		addDimension("Company");
		addMeasure("Value", "sum");
		saveReport();
	}

	@Test
	public void insertSingleValueChart()
	{
		insertChartOfType("Single Value", "source");
		addMeasure("Value", "sum");
		saveReport();
	}

	@Test
	public void insertTreemapChart()
	{
		insertChartOfType("Treemap", "source");
		addDimension("Company");
		addMeasure("Value", "sum");
		saveReport();
	}

	@Test
	public void insertBubbleChart()
	{
		insertChartOfType("Bubble Chart", "source");
		addDimension("Company");
		addMeasure("Value", "sum");
		saveReport();
	}

	@Test
	public void insertFunnelChart()
	{
		insertChartOfType("Funnel", "source");
		addDimension("Company");
		addMeasure("Value", "sum");
		saveReport();
	}

	@Test
	public void insertPyramidChart()
	{
		insertChartOfType("Pyramid", "source");
		addDimension("Company");
		addMeasure("Value", "sum");
		saveReport();
	}

//	@Test
//	public void addCalculatedMeasure()
//	{
//		authPage.open().checkIsRendered();
//		authPage.logIn("slemmatest@mail.ru", "Q123#@!w");
//		changeTeam("TestTeam");
//		mainPage.checkIsRendered()
//				  .clickdrawerToggleBtn();
//		mainPage.openReports()
//				  .clickCreateBtn();
//		reportsPage.checkIsRendered()
//				  .clickInsertBtn();
//		reportsPage.insertBlockDropDown.checkIsRendered()
//				  .clickObjectByName("Chart", "ic_chart");
//		reportsPage.selectaDataSourceDialog.checkIsRendered()
//				  .clickDataSourceInDialogByName("For%20charts.csv", "ic_csv", 30);
//		reportsPage.chooseChartTypeDialog.checkIsRendered()
//				  .clickTypeChartInDialogByName("Column", "ic_column", 10);
//		reportsPage.chartLayoutPanel.checkIsRendered()
//				  .checkDialogTitle("Settings", 2)
//				  .clickAddDimension()
//				  .checkDialogTitle("Choose dimension", 5)
//				  .clickDimensionInPanelByName("Company")
//				  .checkDialogTitle("Settings", 2)
//				  .clickItemInPanelByName("Data source", "ic_csv");
//		reportsPage.reportDropDown.checkIsRendered()
//				  .clickObjectByName("Calculations");
//		reportsPage.сalculationsAddDialog.checkIsRendered()
//				  .clickAddBtn();
//	pause(5);
//		reportsPage.reportDropDown.checkIsRendered()
//				  .clickObjectByName("Measure Names");
//		reportsPage.calculationsDialog.checkIsRendered()
//				  .clickCodeMirror();
//		driver.keyboardImitate("[Measures].[Fact Count]*[Measures].[Fact Count]");
//		reportsPage.calculationsDialog.clickSaveBtn();
//		reportsPage.сalculationsAddDialog.checkIsRendered()
//              .checkMeasureTableByName("New measure",5)
//				  .clickСloseBtn();
//		reportsPage.chartLayoutPanel.checkIsRendered()
//				  .checkDialogTitle("Settings", 2)
//				  .clickAddMeasure()
//				  .clickDimensionInPanelByName("New measure");
//		//сохранение отчета
//		reportsPage.checkIsRendered()
//				  .clickMenuBtn();
//		mainPage.moreOptionDropDown.checkIsRendered()
//				  .clickSaveBtn();
//		reportsPage.saveAsDialog.checkIsRendered()
//				  .enterInputName("CalculatedMeasure")
//				  .clickOkBtn();
//		reportsPage.clickCloseBtn();
//		mainPage.checkObjectByName("CalculatedMeasure", 15)
//				  .clickObjectInDataTableByName("CalculatedMeasure", 15);
//	}
//
//	@Test
//	public void checkFloatingTiled()
//	{
//		authPage.open().checkIsRendered();
//		authPage.logIn("slemmatest@mail.ru", "Q123#@!w");
//		changeTeam("TestTeam");
//		mainPage.checkIsRendered()
//				  .clickdrawerToggleBtn();
//		mainPage.openReports()
//				  .clickCreateBtn();
//		reportsPage.checkIsRendered();
//		reportsPage.settingsReportPanel.checkIsRendered()
//				  .createSelectSize().selectByVisibleText("Floating");
//		reportsPage.settingsReportPanel.FloatingNodeFalse();
//		reportsPage.settingsReportPanel.checkIsRendered()
//				  .createSelectSize().selectByVisibleText("Tiled");
//		reportsPage.settingsReportPanel.tiledNodeTrue();
////		сохранение отчета
//		reportsPage.checkIsRendered()
//				  .clickMenuBtn();
//		mainPage.moreOptionDropDown.checkIsRendered()
//				  .clickSaveBtn();
//		reportsPage.saveAsDialog.checkIsRendered()
//				  .enterInputName("Tiled")
//				  .clickOkBtn();
//		reportsPage.clickCloseBtn();
//		mainPage.checkObjectByName("Tiled", 15)
//				  .clickObjectInDataTableByName("Tiled", 15);
//	}
//
//	@Test
//	public void checkDateRangeFilter()
//	{
//		//TestTeam2
//		authPage.open().checkIsRendered();
//		authPage.logIn("slemmatest@mail.ru", "Q123#@!w");
//		changeTeam("TestTeam2");
//		mainPage.checkIsRendered()
//				  .clickdrawerToggleBtn();
//		mainPage.openReports()
//				  .clickObjectInDataTableByName("filter", 5);
//		reportsPage.checkIsRendered();
//		pause(5);
//		reportsPage.clickEditBtn()
//				  .clickFilterBtn();
//		reportsPage.reportFiltersDialog.checkIsRendered()
//				  .clickFilterInNodeByName("Date range - (Last 365 days)");
//		reportsPage.dataRangeSelectionDialog.checkIsRendered()
//				  .clickFilterInNodeByName("Last N weeks")
//				  .clickDoneBtn();
//		reportsPage.reportFiltersDialog.checkIsRendered()
//				  .checkFilterInNodeByName("Date range - (Last 365 weeks)");
//		reportsPage.clickCloseBtn();
//	}
//
//	@Test
//	public void checkSelectFilter()
//	{
//		authPage.open().checkIsRendered();
//		authPage.logIn("slemmatest@mail.ru", "Q123#@!w");
//		changeTeam("TestTeam2");
//		mainPage.checkIsRendered()
//				  .clickdrawerToggleBtn();
//		mainPage.openReports()
//				  .clickObjectInDataTableByName("ChartRefresh", 5);
//		reportsPage.checkIsRendered()
//				  .clickEditBtn()
//				  .clickFilterBtn();
//		reportsPage.reportFiltersDialog.checkIsRendered()
//				  .checkDialogTitle("Report Filters", 5)
//				  .clickAddBtn()
//				  .checkDialogTitle("Choose item", 5)
//				  .clickFieldsInDialogByName("Name", "ic_dimension", 5);
//		reportsPage.reportDropDown.checkIsRendered()
//				  .clickObjectByName("Select");
//		reportsPage.reportFiltersDialog.checkIsRendered()
//				  .checkDialogTitle("Dependent objects", 5)
//				  .clickDoneBtn()
//				  .clickFieldsInDialogByName("One", "ic_check_box_outline", 5)
//				  .clickFieldsInDialogByName("Two", "ic_check_box_outline", 5)
//				  .clickFieldsInDialogByName("Three", "ic_check_box_outline", 5)
//				  .clickDoneBtn()
//				  .checkDialogTitle("Report Filters", 5)
//				  .checkFilterInNodeByName("3 of 9");
//		reportsPage.checkIsRendered()
//				  .checkChartNoDate()
//				  .clickCloseBtn();
//	}
//
//	@Test
//	public void checkCopyStyle()
//	{
//		authPage.open().checkIsRendered();
//		authPage.logIn("slemmatest@mail.ru", "Q123#@!w");
//		changeTeam("TestTeam2");
//		mainPage.checkIsRendered()
//				  .clickdrawerToggleBtn();
//		mainPage.openReports()
//				  .clickObjectInDataTableByName("filter", 5);
//		reportsPage.checkIsRendered()
//				  .clickEditBtn()
//				  .contextClick("jira tickets", 10);
//		reportsPage.reportDropDown.checkIsRendered()
//				  .clickObjectByName("Copy style");
//		pause(5);
//		reportsPage.checkIsRendered()
//				  .contextClick("chart Copy style", 10);
//		reportsPage.reportDropDown.checkIsRendered()
//				  .clickObjectByName("Paste style");
//		//проверка применимости стилей
//		reportsPage.chartLayoutPanel.checkIsRendered()
//				  .clickTabStyleBtn()
//				  .clickAccordionByName("Title");
//		Assert.assertTrue(reportsPage.chartLayoutPanel.createSelectSize().getFirstSelectedOption().getText().matches("24"));
//		reportsPage.chartLayoutPanel.clickAccordionByName("General")
//				  .clickLineWeight();
//		reportsPage.reportDropDown.checkIsRendered()
//				  .checkSelectedItem("4px", "ic_check");
//		reportsPage.checkIsRendered()
//				  .clickCloseBtn();
//	}
//
//	@Test
//	public void checkChartRefresh()
//	{
//		//TestTeam2
//		authPage.open().checkIsRendered();
//		authPage.logIn("slemmatest@mail.ru", "Q123#@!w");
//		changeTeam("TestTeam2");
//		mainPage.checkIsRendered()
//				  .clickdrawerToggleBtn();
//		mainPage.openReports()
//				  .clickObjectInDataTableByName("ChartRefresh", 5);
//		reportsPage.checkIsRendered()
//				  .clickEditBtn()
//				  .clickChartByName("Refresh")
//				  .clickRefreshBtn()
//				  .checkChartNoDate()
//				  .clickCloseBtn();
//	}
//
//	@Test
//	public void createShare()
//	{
//		authPage.open().checkIsRendered();
//		authPage.logIn("slemmatest@mail.ru", "Q123#@!w");
//		changeTeam("TestTeam");
//		mainPage.checkIsRendered()
//				  .clickdrawerToggleBtn();
//		mainPage.openReports()
//				  .clickCreateBtn();
//		reportsPage.checkIsRendered()
//				  .clickInsertBtn();
//		reportsPage.insertBlockDropDown.checkIsRendered()
//				  .clickObjectByName("Text", "ic_text");
//		reportsPage.checkIsRendered()
//				  .clickEditTextBtn();
//		driver.keyboardImitate("Здесь вставляется новый текст!");
//		reportsPage.checkIsRendered()
//				  .clickMenuBtn();
//		mainPage.moreOptionDropDown.checkIsRendered()
//				  .clickSaveBtn();
//		reportsPage.saveAsDialog.checkIsRendered()
//				  .enterInputName("shareObject")
//				  .clickDone();
//		reportsPage.checkIsRendered()
//				  .clickShareBtn();
//		mainPage.addPeopleDialog.checkIsRendered()
//				  .selectPeople("s.kataev@slemma.com", 2)
//				  .clickSendBtn();
//		reportsPage.clickCloseBtn();
//		mainPage.checkObjectByName("shareObject", 5)
//				  .contextClickObjectInDataTableByName("shareObject", 5);
//		mainPage.moreOptionDropDown.checkIsRendered()
//				  .clickPermissionsIcon();
//		mainPage.permissionsDialog.checkIsRendered()
//				  .checkSelectPeople("s.kataev@slemma.com", 2)
//				  .clickCloseBtn();
//	}
//
//	@Test
//	public void checkPermissions()
//	{
//		authPage.open().checkIsRendered();
//		authPage.logIn("slemmatest2@mail.ru", "Q123#@!w");
//		mainPage.checkIsRendered()
//				  .clickdrawerToggleBtn();
//		mainPage.openReports()
//				  .clickObjectInDataTableByName("filter", 5);
//		//проверить что есть кнопка "edit"
//		reportsPage.checkIsRendered()
//				  .checkEditBtn()
//				  .clickCloseBtn();
//		mainPage.checkIsRendered()
//				  .openReports()
//				  .clickObjectInDataTableByName("ChartRefresh", 5);
//		//проверить что НЕТ кнопки "edit"
//		reportsPage.checkIsRendered()
//				  .checkAbsenceEditBtn()
//				  .clickCloseBtn();
//		mainPage.clickSignOutBtn();
//	}
//
//	@Test
//	public void goToShareLink()
//	{
//		authPage.open().checkIsRendered();
//		authPage.logIn("slemmatest@mail.ru", "Q123#@!w");
//		changeTeam("TestTeam2");
//		mainPage.checkIsRendered()
//				  .checkObjectByName("with share link", 5)
//				  .contextClickObjectInDataTableByName("with share link", 5);
//		mainPage.moreOptionDropDown.checkIsRendered()
//				  .clickLinkIcon();
//		mainPage.linkSharingDialog.checkIsRendered()
//				  .getLinkSharing();
//		String url = mainPage.linkSharingDialog.getLinkSharing();
//		driver.goToUrl(url);
//		reportsPage.checkIsRendered()
//				  .checkChartNoDate()
//				  .checkAbsenceEditBtn()
//				  .clickCloseBtn();
//	}
//
//	@Test
//	public void getEmbedCode()
//	{
//		authPage.open().checkIsRendered();
//		authPage.logIn("slemmatest@mail.ru", "Q123#@!w");
//		changeTeam("TestTeam2");
//		mainPage.checkIsRendered()
//				  .checkObjectByName("with share link", 5)
//				  .contextClickObjectInDataTableByName("with share link", 5);
//		mainPage.moreOptionDropDown.checkIsRendered()
//				  .clickLinkIcon();
//		mainPage.linkSharingDialog.checkIsRendered()
//				  .getEmbedCode();
//		String embedCode = mainPage.linkSharingDialog.getEmbedCode();
//		mainPage.linkSharingDialog.clickCloseBtn();
//		changeTeam("TestTeam");
//		mainPage.clickCreateBtn();
//		reportsPage.checkIsRendered()
//				  .clickInsertBtn();
//		reportsPage.insertBlockDropDown.checkIsRendered()
//				  .clickObjectByName("URL embed", "ic_code");
//		reportsPage.hTTPSwebAddressDialog.checkIsRendered()
//				  .typeUrl(embedCode)
//				  .clickDone();
//		reportsPage.checkIsRendered()
//				  .checkChartNoDate();
//		reportsPage.checkIsRendered()
//				  .clickMenuBtn();
//		mainPage.moreOptionDropDown.checkIsRendered()
//				  .clickSaveBtn();
//		reportsPage.saveAsDialog.checkIsRendered()
//				  .enterInputName("EmbedCode")
//				  .clickOkBtn();
//		reportsPage.clickCloseBtn();
//		mainPage.checkObjectByName("EmbedCode", 15)
//				  .clickObjectInDataTableByName("EmbedCode", 15);
//	}
//
//	@Test
//	public void checkAllFiltersReport()
//	{
//		authPage.open().checkIsRendered();
//		authPage.logIn("slemmatest2@mail.ru", "Q123#@!w");
//		mainPage.checkIsRendered();
//		driver.goToUrl("http://app.newpeople.co/share/filters");
//		mainPage.passwordProtectedDialog.checkIsRendered()
//				  .enterPasswordInput("123!@#qwe")
//				  .clickViewReportBtn();
//		reportsPage.checkIsRendered()
//				  .checkChartNoDate()
//				  .clickCloseBtn();
//	}
//
//	@Test
//	public void checkGrandTotal()
//	{
//		authPage.open().checkIsRendered();
//		authPage.logIn("slemmatest2@mail.ru", "Q123#@!w");
//		mainPage.checkIsRendered();
//		driver.goToUrl("http://app.newpeople.co/share/mediana");
//		reportsPage.checkIsRendered()
//				  .checkChartNoDate()
//				  .checkChartNoNaN()
//				  .clickCloseBtn();
//	}
//
//	@Test
//	public void checkLevelByDay()
//	{
//		authPage.open().checkIsRendered();
//		authPage.logIn("slemmatest2@mail.ru", "Q123#@!w");
//		mainPage.checkIsRendered();
//		driver.goToUrl("http://app.newpeople.co/share/levelbyday");
//		reportsPage.checkIsRendered()
//				  .checkChartNoDate()
//				  .checkChartNoNaN()
//				  .clickCloseBtn();
//	}
//
//	@Test
//	public void checkOpenDashByChangingAccount()
//	{
//		authPage.open().checkIsRendered();
//		authPage.logIn("e.matveeva@slemma.com", "Matveeva0414");
//		mainPage.checkIsRendered();
//		driver.goToUrl("http://app.newpeople.co/reports/4108");
//		mainPage.requestAccessDialog.checkIsRendered()
//				  .checkLogoutBtn()
//				  .checkRequestBtn()
//				  .clickCloseBtn();
//	}
//
//	@Test
//	public void addNewItem()
//	{
//		authPage.open().checkIsRendered();
//		authPage.logIn("slemmatest@mail.ru", "Q123#@!w");
//		changeTeam("TestTeam");
//		mainPage.checkIsRendered()
//				  .openReports()
//				  .clickCreateBtn();
//		reportsPage.checkIsRendered()
//				  .clickInsertBtn();
//		reportsPage.insertBlockDropDown.checkIsRendered()
//				  .clickObjectByName("Chart", "ic_chart");
//		reportsPage.selectaDataSourceDialog.checkIsRendered()
//				  .clickDataSourceInDialogByName("DemoData", "ic_csv", 30);
//		reportsPage.chooseChartTypeDialog.checkIsRendered()
//				  .clickTypeChartInDialogByName("Column", "ic_column", 5);
//		reportsPage.chartLayoutPanel.checkIsRendered()
//				  .checkDialogTitle("Settings", 2)
//				  .clickItemInPanelByName("Data source", "ic_csv");
//		reportsPage.reportDropDown.checkIsRendered()
//				  .clickObjectByName("Calculations");
//		reportsPage.сalculationsAddDialog.checkIsRendered()
//				  .clickAddBtn();
//		pause(5);
//		reportsPage.reportDropDown.checkIsRendered()
//				  .clickObjectByName("Region");
//		reportsPage.calculationsDialog.checkIsRendered()
//				  .enterNameInput("Region item")
//				  .clickCodeMirror();
//		driver.keyboardImitate("[Region.Hierarchy].[Central]-[Region.Hierarchy].[West]");
////		pause(5);
//		reportsPage.calculationsDialog.clickSaveBtn();
//		reportsPage.сalculationsAddDialog.checkIsRendered()
//				  .checkMeasureTableByName("Region item",5)
//				  .clickСloseBtn();
//		reportsPage.chartLayoutPanel.clickAddDimension()
//				  .checkDialogTitle("Choose dimension", 5)
//				  .clickDimensionInPanelByName("Region")
//				  .clickAddMeasure()
//				  .checkDialogTitle("Choose measure", 5)
//				  .clickDimensionInPanelByName("Sales");
//		reportsPage.reportDropDown.checkIsRendered()
//				  .clickObjectByName("Sum");
//		//проверка что измерение добавилось фильтры-селект-проверка самого значения
//		reportsPage.chartLayoutPanel.checkIsRendered()
//				  .clickAddFilterBtn();
//		reportsPage.reportFiltersDialog.checkIsRendered()
//				  .checkDialogTitle("Choose item", 2);
//		Assert.assertTrue(driver.click(By.xpath("(//div[contains(@class, 'block-settings-panel')]//span[contains(@class, 'mdc-list-item__text') and contains(text(), 'Region')])[2]")));
//		reportsPage.reportDropDown.checkIsRendered()
//				  .clickObjectByName("Select");
//		reportsPage.chartLayoutPanel.checkIsRendered()
//				  .checkDialogTitle("Selection", 5)
//				  .clickItemInSelectByName("Region item", "ic_check_box_outline", 5)
//				  .clickItemInSelectByName("Central", "ic_check_box_outline", 5)
//				  .clickApplyBtn();
//		reportsPage.checkIsRendered()
//				  .clickMenuBtn();
//		mainPage.moreOptionDropDown.checkIsRendered()
//				  .clickSaveBtn();
//		reportsPage.saveAsDialog.checkIsRendered()
//				  .enterInputName("CalculatedItem")
//				  .clickOkBtn();
//	}
//

	protected void saveReport()
	{
		reportsPage.clickMenuBtn();
		reportsPage.mainMenuDropDown
				  .checkIsRendered()
				  .clickSave();
	}

	protected void insertChartOfType(String type, String sourceName)
	{
		reportsPage.clickEditBtn()
				  .clickInsertBtn();
		reportsPage.insertBlockDropDown
				  .checkIsRendered()
				  .clickChart();
		reportsPage.chooseDataSourceDialog
				  .checkIsRendered()
				  .clickObjectByName(sourceName);
		reportsPage.chooseChartTypeDialog
				  .checkIsRendered()
				  .clickChartType(type);
		reportsPage.chartLayoutPanel
				  .checkIsRendered()
				  .checkChartType(type);

	}

	protected void addDimension(String name)
	{
		reportsPage.chartLayoutPanel
				  .checkIsRendered()
				  .clickAddDimension();
		reportsPage.chartLayoutPanel.chooseDimensionPanel
				  .checkIsRendered()
				  .clickDimension(name);
		reportsPage.chartLayoutPanel
				  .checkDimensionExists(name);
	}

	protected void addMeasure(String name, String agg)
	{
		reportsPage.chartLayoutPanel
				  .checkIsRendered()
				  .clickAddMeasure();
		reportsPage.chartLayoutPanel.chooseMeasurePanel
				  .checkIsRendered()
				  .clickMeasure(name);
		reportsPage.chartLayoutPanel.chooseMeasurePanel.aggDropDown
				  .checkIsRendered()
				  .clickAgg(agg);
		reportsPage.chartLayoutPanel
				  .checkMeasureExists(agg.toUpperCase() + " (" + name + ")");
	}
}
