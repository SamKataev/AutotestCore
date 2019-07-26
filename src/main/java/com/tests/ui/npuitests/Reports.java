package com.tests.ui.npuitests;


import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.By;

public class Reports extends NPWebTest

{
	@Test
	public void insertSimpleObject()
	{
		authPage.open().checkIsRendered();
		authPage.logIn("slemmatest@mail.ru", "Q123#@!w");
		changeTeam("TestTeam");
		mainPage.checkIsRendered()
				  .openReports()
				  .clickPlusBtn();
		reportsPage.checkIsRendered()
				  .clickInsertBtn();
		reportsPage.chooseObjectDropDown.checkIsRendered()
				  .uploadFile("C:\\resources\\1472058088_05.jpg")
				  .clickObjectByName("Text", "ic_text");
		reportsPage.clickInsertBtn();
		reportsPage.chooseObjectDropDown.checkIsRendered()
				  .clickObjectByName("URL embed", "ic_code");
		reportsPage.hTTPSwebAddressDialog.checkIsRendered()
				  .urlInput("http://app.newpeople.co/reports/2982")
				  .clickOk();
//		reportsPage.clickInsertBtn();
//		reportsPage.chooseObjectDropDown.checkIsRendered()
//				  .clickObjectByName("Chart template", "ic_chart_template");
//		mainPage.selectDatasetDialog.checkIsRendered()
//			  .checkDialogTitle("Select connection", 10)
//			  .clickFileInDialogByName("New People", "ic_pipedrive", 20)
//			  .clickBasedInDialogByName("Deals Pipeline", "ic_column", 20);
//		pause(5); //дописать вейтер или нахождение элемента на странице
		reportsPage.checkIsRendered()
				  .clickMoreBtn();
		mainPage.moreOptionDropDown.checkIsRendered()
				  .clickSaveIcon();
		reportsPage.saveAsDialog.checkIsRendered()
				  .enterInputName("SimpleObject")
				  .clickOkBtn();
		reportsPage.clickCloseBtn();
		mainPage.checkObjectInDataTableByName("SimpleObject", 15)
				  .clickObjectInDataTableByName("SimpleObject", 15);
	}

	@Test
	public void insertAllTypeChart()
	{
		authPage.open().checkIsRendered();
		authPage.logIn("slemmatest@mail.ru", "Q123#@!w");
		changeTeam("TestTeam");
		mainPage.checkIsRendered()
				  .openReports()
				  .clickPlusBtn();
		//тип чарта Column
		reportsPage.checkIsRendered()
				  .clickInsertBtn();
		reportsPage.chooseObjectDropDown.checkIsRendered()
				  .clickObjectByName("Chart", "ic_chart");
		reportsPage.selectaDataSourceDialog.checkIsRendered()
				  .clickDataSourceInDialogByName("For%20charts.csv", "ic_csv", 30);
		reportsPage.chooseaChartTypeDialog.checkIsRendered()
				  .clickTypeChartInDialogByName("Column", "ic_column", 10);
		reportsPage.settingsChartDialog.checkIsRendered()
				  .clickAddDimensionBtn()
				  .clickDimensionInPanelByName("Company")
				  .clickAddMeasureBtn()
				  .clickDimensionInPanelByName("Number of records");
		//Stacked column
		reportsPage.checkIsRendered()
				  .clickInsertBtn();
		reportsPage.chooseObjectDropDown.checkIsRendered()
				  .clickObjectByName("Chart", "ic_chart");
		reportsPage.selectaDataSourceDialog.checkIsRendered()
				  .clickDataSourceInDialogByName("For%20charts.csv", "ic_csv", 30);
		reportsPage.chooseaChartTypeDialog.checkIsRendered()
				  .clickTypeChartInDialogByName("Stacked column", "ic_stacked_column", 10);
		reportsPage.settingsChartDialog.checkIsRendered()
				  .clickAddDimensionBtn()
				  .clickDimensionInPanelByName("Company")
				  .clickAddMeasureBtn()
				  .clickDimensionInPanelByName("Number of records");
		//100% stacked column
		reportsPage.checkIsRendered()
				  .clickInsertBtn();
		reportsPage.chooseObjectDropDown.checkIsRendered()
				  .clickObjectByName("Chart", "ic_chart");
		reportsPage.selectaDataSourceDialog.checkIsRendered()
				  .clickDataSourceInDialogByName("For%20charts.csv", "ic_csv", 30);
		reportsPage.chooseaChartTypeDialog.checkIsRendered()
				  .clickTypeChartInDialogByName("100% stacked column", "ic_norm_stacked_col", 10);
		reportsPage.settingsChartDialog.checkIsRendered()
				  .clickAddDimensionBtn()
				  .clickDimensionInPanelByName("Company")
				  .clickAddMeasureBtn()
				  .clickDimensionInPanelByName("Number of records");
		//Bar
		reportsPage.checkIsRendered()
				  .clickInsertBtn();
		reportsPage.chooseObjectDropDown.checkIsRendered()
				  .clickObjectByName("Chart", "ic_chart");
		reportsPage.selectaDataSourceDialog.checkIsRendered()
				  .clickDataSourceInDialogByName("For%20charts.csv", "ic_csv", 30);
		reportsPage.chooseaChartTypeDialog.checkIsRendered()
				  .clickTypeChartInDialogByName("Bar", "ic_bar", 10);
		reportsPage.settingsChartDialog.checkIsRendered()
				  .clickAddDimensionBtn()
				  .clickDimensionInPanelByName("Company")
				  .clickAddMeasureBtn()
				  .clickDimensionInPanelByName("Number of records");
		//Stacked bar
		reportsPage.checkIsRendered()
				  .clickInsertBtn();
		reportsPage.chooseObjectDropDown.checkIsRendered()
				  .clickObjectByName("Chart", "ic_chart");
		reportsPage.selectaDataSourceDialog.checkIsRendered()
				  .clickDataSourceInDialogByName("For%20charts.csv", "ic_csv", 30);
		reportsPage.chooseaChartTypeDialog.checkIsRendered()
				  .clickTypeChartInDialogByName("Stacked bar", "ic_stacked_bar", 10);
		reportsPage.settingsChartDialog.checkIsRendered()
				  .clickAddDimensionBtn()
				  .clickDimensionInPanelByName("Company")
				  .clickAddMeasureBtn()
				  .clickDimensionInPanelByName("Number of records");
		//100% stacked bar
		reportsPage.checkIsRendered()
				  .clickInsertBtn();
		reportsPage.chooseObjectDropDown.checkIsRendered()
				  .clickObjectByName("Chart", "ic_chart");
		reportsPage.selectaDataSourceDialog.checkIsRendered()
				  .clickDataSourceInDialogByName("For%20charts.csv", "ic_csv", 30);
		reportsPage.chooseaChartTypeDialog.checkIsRendered()
				  .clickTypeChartInDialogByName("100% stacked bar", "ic_norm_stacked_bar", 10);
		reportsPage.settingsChartDialog.checkIsRendered()
				  .clickAddDimensionBtn()
				  .clickDimensionInPanelByName("Company")
				  .clickAddMeasureBtn()
				  .clickDimensionInPanelByName("Number of records");
		//Combo
		reportsPage.checkIsRendered()
				  .clickInsertBtn();
		reportsPage.chooseObjectDropDown.checkIsRendered()
				  .clickObjectByName("Chart", "ic_chart");
		reportsPage.selectaDataSourceDialog.checkIsRendered()
				  .clickDataSourceInDialogByName("For%20charts.csv", "ic_csv", 30);
		reportsPage.chooseaChartTypeDialog.checkIsRendered()
				  .clickTypeChartInDialogByName("Combo", "ic_combo_chart", 10);
		reportsPage.settingsChartDialog.checkIsRendered()
				  .clickAddDimensionBtn()
				  .clickDimensionInPanelByName("Company")
				  .clickAddMeasureBtn()
				  .clickDimensionInPanelByName("Number of records");
		//Line
		reportsPage.checkIsRendered()
				  .clickInsertBtn();
		reportsPage.chooseObjectDropDown.checkIsRendered()
				  .clickObjectByName("Chart", "ic_chart");
		reportsPage.selectaDataSourceDialog.checkIsRendered()
				  .clickDataSourceInDialogByName("For%20charts.csv", "ic_csv", 30);
		reportsPage.chooseaChartTypeDialog.checkIsRendered()
				  .clickTypeChartInDialogByName("Line", "ic_line_chart", 10);
		reportsPage.settingsChartDialog.checkIsRendered()
				  .clickAddDimensionBtn()
				  .clickDimensionInPanelByName("Company")
				  .clickAddMeasureBtn()
				  .clickDimensionInPanelByName("Number of records");
		//Area
		reportsPage.checkIsRendered()
				  .clickInsertBtn();
		reportsPage.chooseObjectDropDown.checkIsRendered()
				  .clickObjectByName("Chart", "ic_chart");
		reportsPage.selectaDataSourceDialog.checkIsRendered()
				  .clickDataSourceInDialogByName("For%20charts.csv", "ic_csv", 30);
		reportsPage.chooseaChartTypeDialog.checkIsRendered()
				  .clickTypeChartInDialogByName("Area", "ic_area_chart", 10);
		reportsPage.settingsChartDialog.checkIsRendered()
				  .clickAddDimensionBtn()
				  .clickDimensionInPanelByName("Company")
				  .clickAddMeasureBtn()
				  .clickDimensionInPanelByName("Number of records");
		//Stacked area
		reportsPage.checkIsRendered()
				  .clickInsertBtn();
		reportsPage.chooseObjectDropDown.checkIsRendered()
				  .clickObjectByName("Chart", "ic_chart");
		reportsPage.selectaDataSourceDialog.checkIsRendered()
				  .clickDataSourceInDialogByName("For%20charts.csv", "ic_csv", 30);
		reportsPage.chooseaChartTypeDialog.checkIsRendered()
				  .clickTypeChartInDialogByName("Stacked area", "ic_stacked_area", 10);
		reportsPage.settingsChartDialog.checkIsRendered()
				  .clickAddDimensionBtn()
				  .clickDimensionInPanelByName("Company")
				  .clickAddMeasureBtn()
				  .clickDimensionInPanelByName("Number of records");
		//100% stacked area
		reportsPage.checkIsRendered()
				  .clickInsertBtn();
		reportsPage.chooseObjectDropDown.checkIsRendered()
				  .clickObjectByName("Chart", "ic_chart");
		reportsPage.selectaDataSourceDialog.checkIsRendered()
				  .clickDataSourceInDialogByName("For%20charts.csv", "ic_csv", 30);
		reportsPage.chooseaChartTypeDialog.checkIsRendered()
				  .clickTypeChartInDialogByName("100% stacked area", "ic_norm_stacked_are", 10);
		reportsPage.settingsChartDialog.checkIsRendered()
				  .clickAddDimensionBtn()
				  .clickDimensionInPanelByName("Company")
				  .clickAddMeasureBtn()
				  .clickDimensionInPanelByName("Number of records");
		//Pie
		reportsPage.checkIsRendered()
				  .clickInsertBtn();
		reportsPage.chooseObjectDropDown.checkIsRendered()
				  .clickObjectByName("Chart", "ic_chart");
		reportsPage.selectaDataSourceDialog.checkIsRendered()
				  .clickDataSourceInDialogByName("For%20charts.csv", "ic_csv", 30);
		reportsPage.chooseaChartTypeDialog.checkIsRendered()
				  .clickTypeChartInDialogByName("Pie", "ic_pie", 10);
		reportsPage.settingsChartDialog.checkIsRendered()
				  .clickAddDimensionBtn()
				  .clickDimensionInPanelByName("Company")
				  .clickAddMeasureBtn()
				  .clickDimensionInPanelByName("Number of records");
		//Donut
		reportsPage.checkIsRendered()
				  .clickInsertBtn();
		reportsPage.chooseObjectDropDown.checkIsRendered()
				  .clickObjectByName("Chart", "ic_chart");
		reportsPage.selectaDataSourceDialog.checkIsRendered()
				  .clickDataSourceInDialogByName("For%20charts.csv", "ic_csv", 30);
		reportsPage.chooseaChartTypeDialog.checkIsRendered()
				  .clickTypeChartInDialogByName("Donut", "ic_donut", 10);
		reportsPage.settingsChartDialog.checkIsRendered()
				  .clickAddDimensionBtn()
				  .clickDimensionInPanelByName("Company")
				  .clickAddMeasureBtn()
				  .clickDimensionInPanelByName("Number of records");
		//Single value
		reportsPage.checkIsRendered()
				  .clickInsertBtn();
		reportsPage.chooseObjectDropDown.checkIsRendered()
				  .clickObjectByName("Chart", "ic_chart");
		reportsPage.selectaDataSourceDialog.checkIsRendered()
				  .clickDataSourceInDialogByName("For%20charts.csv", "ic_csv", 30);
		reportsPage.chooseaChartTypeDialog.checkIsRendered()
				  .clickTypeChartInDialogByName("Single value", "ic_single_value", 10);
		reportsPage.settingsChartDialog.checkIsRendered()
				  .clickAddMeasureBtn()
				  .clickDimensionInPanelByName("Number of records");
		//Treemap
		reportsPage.checkIsRendered()
				  .clickInsertBtn();
		reportsPage.chooseObjectDropDown.checkIsRendered()
				  .clickObjectByName("Chart", "ic_chart");
		reportsPage.selectaDataSourceDialog.checkIsRendered()
				  .clickDataSourceInDialogByName("For%20charts.csv", "ic_csv", 30);
		reportsPage.chooseaChartTypeDialog.checkIsRendered()
				  .clickTypeChartInDialogByName("Treemap", "ic_treemap", 10);
		reportsPage.settingsChartDialog.checkIsRendered()
				  .clickAddDimensionBtn()
				  .clickDimensionInPanelByName("Company")
				  .clickAddMeasureBtn()
				  .clickDimensionInPanelByName("Number of records");
		//	Scatter plot
		reportsPage.checkIsRendered()
				  .clickInsertBtn();
		reportsPage.chooseObjectDropDown.checkIsRendered()
				  .clickObjectByName("Chart", "ic_chart");
		reportsPage.selectaDataSourceDialog.checkIsRendered()
				  .clickDataSourceInDialogByName("For%20charts.csv", "ic_csv", 30);
		reportsPage.chooseaChartTypeDialog.checkIsRendered()
				  .clickTypeChartInDialogByName("Scatter plot", "ic_scatter_plot", 10);
		reportsPage.settingsChartDialog.checkIsRendered()
				  .clickAddDimensionBtn()
				  .clickDimensionInPanelByName("Company")
				  .clickAddMeasureBtn()
				  .clickDimensionInPanelByName("Number of records")
				  .clickAddMeasureBtn()
				  .clickDimensionInPanelByName("Value1");
		reportsPage.reportDropDown.checkIsRendered()
				  .clickObjectByName("Sum");
		//Funnel
		reportsPage.checkIsRendered()
				  .clickInsertBtn();
		reportsPage.chooseObjectDropDown.checkIsRendered()
				  .clickObjectByName("Chart", "ic_chart");
		reportsPage.selectaDataSourceDialog.checkIsRendered()
				  .clickDataSourceInDialogByName("For%20charts.csv", "ic_csv", 30);
		reportsPage.chooseaChartTypeDialog.checkIsRendered()
				  .clickTypeChartInDialogByName("Funnel", "ic_funnel", 10);
		reportsPage.settingsChartDialog.checkIsRendered()
				  .clickAddMeasureBtn()
				  .clickDimensionInPanelByName("Number of records")
				  .clickAddDimensionBtn()
				  .clickDimensionInPanelByName("Company");
		//Histogram
		reportsPage.checkIsRendered()
				  .clickInsertBtn();
		reportsPage.chooseObjectDropDown.checkIsRendered()
				  .clickObjectByName("Chart", "ic_chart");
		reportsPage.selectaDataSourceDialog.checkIsRendered()
				  .clickDataSourceInDialogByName("For%20charts.csv", "ic_csv", 30);
		reportsPage.chooseaChartTypeDialog.checkIsRendered()
				  .clickTypeChartInDialogByName("Histogram", "ic_histogram", 10);
		reportsPage.settingsChartDialog.checkIsRendered()
				  .clickAddMeasureBtn()
				  .clickDimensionInPanelByName("Number of records")
				  .clickAddDimensionBtn()
				  .clickDimensionInPanelByName("Company");
		//Simple table
		reportsPage.checkIsRendered()
				  .clickInsertBtn();
		reportsPage.chooseObjectDropDown.checkIsRendered()
				  .clickObjectByName("Chart", "ic_chart");
		reportsPage.selectaDataSourceDialog.checkIsRendered()
				  .clickDataSourceInDialogByName("For%20charts.csv", "ic_csv", 30);
		reportsPage.chooseaChartTypeDialog.checkIsRendered()
				  .clickTypeChartInDialogByName("Simple table", "ic_simple_table", 10);
		reportsPage.settingsChartDialog.checkIsRendered()
				  .clickAddFieldBtn()
				  .clickDimensionInPanelByName("Company");
		//Cross-table
		reportsPage.checkIsRendered()
				  .clickInsertBtn();
		reportsPage.chooseObjectDropDown.checkIsRendered()
				  .clickObjectByName("Chart", "ic_chart");
		reportsPage.selectaDataSourceDialog.checkIsRendered()
				  .clickDataSourceInDialogByName("For%20charts.csv", "ic_csv", 30);
		reportsPage.chooseaChartTypeDialog.checkIsRendered()
				  .clickTypeChartInDialogByName("Cross-table", "ic_cross_table", 10);
		reportsPage.settingsChartDialog.checkIsRendered()
				  .clickAddDimensionBtn()
				  .clickDimensionInPanelByName("Company")
				  .clickAddDimensionBtn()
				  .clickDimensionInPanelByName("Measure Names");
		//сохранение отчета
		reportsPage.checkIsRendered()
				  .clickMoreBtn();
		mainPage.moreOptionDropDown.checkIsRendered()
				  .clickSaveIcon();
		reportsPage.saveAsDialog.checkIsRendered()
				  .enterInputName("AllTypeChart")
				  .clickOkBtn();
		reportsPage.clickCloseBtn();
		mainPage.checkObjectInDataTableByName("AllTypeChart", 15)
				  .clickObjectInDataTableByName("AllTypeChart", 15);
	}

	@Test
	public void addCalculatedMeasure()
	{
		authPage.open().checkIsRendered();
		authPage.logIn("slemmatest@mail.ru", "Q123#@!w");
		changeTeam("TestTeam");
		mainPage.checkIsRendered()
				  .openReports()
				  .clickPlusBtn();
		reportsPage.checkIsRendered()
				  .clickInsertBtn();
		reportsPage.chooseObjectDropDown.checkIsRendered()
				  .clickObjectByName("Chart", "ic_chart");
		reportsPage.selectaDataSourceDialog.checkIsRendered()
				  .clickDataSourceInDialogByName("For%20charts.csv", "ic_csv", 30);
		reportsPage.chooseaChartTypeDialog.checkIsRendered()
				  .clickTypeChartInDialogByName("Column", "ic_column", 10);
		reportsPage.settingsChartDialog.checkIsRendered()
				  .checkDialogTitle("Settings", 2)
				  .clickAddDimensionBtn()
				  .checkDialogTitle("Choose dimension", 5)
				  .clickDimensionInPanelByName("Company")
				  .checkDialogTitle("Settings", 2)
				  .clickItemInPanelByName("Data source", "ic_csv");
		reportsPage.reportDropDown.checkIsRendered()
				  .clickObjectByName("Calculations");
		reportsPage.сalculationsAddDialog.checkIsRendered()
				  .clickAddBtn();
	pause(5);
		reportsPage.reportDropDown.checkIsRendered()
				  .clickObjectByName("Measure Names");
		reportsPage.calculationsDialog.checkIsRendered()
				  .clickCodeMirror();
		driver.keyboardImitate("[Measures].[Fact Count]*[Measures].[Fact Count]");
		reportsPage.calculationsDialog.clickSaveBtn();
		reportsPage.сalculationsAddDialog.checkIsRendered()
              .checkMeasureTableByName("New measure",5)
				  .clickСloseBtn();
		reportsPage.settingsChartDialog.checkIsRendered()
				  .checkDialogTitle("Settings", 2)
				  .clickAddMeasureBtn()
				  .clickDimensionInPanelByName("New measure");
		//сохранение отчета
		reportsPage.checkIsRendered()
				  .clickMoreBtn();
		mainPage.moreOptionDropDown.checkIsRendered()
				  .clickSaveIcon();
		reportsPage.saveAsDialog.checkIsRendered()
				  .enterInputName("CalculatedMeasure")
				  .clickOkBtn();
		reportsPage.clickCloseBtn();
		mainPage.checkObjectInDataTableByName("CalculatedMeasure", 15)
				  .clickObjectInDataTableByName("CalculatedMeasure", 15);
	}

	@Test
	public void checkFloatingTiled()
	{
		authPage.open().checkIsRendered();
		authPage.logIn("slemmatest@mail.ru", "Q123#@!w");
		changeTeam("TestTeam");
		mainPage.checkIsRendered()
				  .openReports()
				  .clickPlusBtn();
		reportsPage.checkIsRendered();
		reportsPage.settingsReportDialog.checkIsRendered()
				  .createSelectSize().selectByVisibleText("Floating");
		reportsPage.settingsReportDialog.FloatingNodeFalse();
		reportsPage.settingsReportDialog.checkIsRendered()
				  .createSelectSize().selectByVisibleText("Tiled");
		reportsPage.settingsReportDialog.tiledNodeTrue();
//		сохранение отчета
		reportsPage.checkIsRendered()
				  .clickMoreBtn();
		mainPage.moreOptionDropDown.checkIsRendered()
				  .clickSaveIcon();
		reportsPage.saveAsDialog.checkIsRendered()
				  .enterInputName("Tiled")
				  .clickOkBtn();
		reportsPage.clickCloseBtn();
		mainPage.checkObjectInDataTableByName("Tiled", 15)
				  .clickObjectInDataTableByName("Tiled", 15);
	}

	@Test
	public void checkDateRangeFilter()
	{
		//TestTeam2
		authPage.open().checkIsRendered();
		authPage.logIn("slemmatest@mail.ru", "Q123#@!w");
		changeTeam("TestTeam2");
		mainPage.checkIsRendered()
				  .openReports()
				  .clickObjectInDataTableByName("filter", 5);
		reportsPage.checkIsRendered();
		pause(5);
		reportsPage.clickEditBtn()
				  .clickFilterBtn();
		reportsPage.reportFiltersDialog.checkIsRendered()
				  .clickFilterInNodeByName("Date range - (Last 365 days)");
		reportsPage.dataRangeSelectionDialog.checkIsRendered()
				  .clickFilterInNodeByName("Last N weeks")
				  .clickDoneBtn();
		reportsPage.reportFiltersDialog.checkIsRendered()
				  .checkFilterInNodeByName("Date range - (Last 365 weeks)");
		reportsPage.clickCloseBtn();
	}

	@Test
	public void checkSelectFilter()
	{
		authPage.open().checkIsRendered();
		authPage.logIn("slemmatest@mail.ru", "Q123#@!w");
		changeTeam("TestTeam2");
		mainPage.checkIsRendered()
				  .openReports()
				  .clickObjectInDataTableByName("ChartRefresh", 5);
		reportsPage.checkIsRendered()
				  .clickEditBtn()
				  .clickFilterBtn();
		reportsPage.reportFiltersDialog.checkIsRendered()
				  .checkDialogTitle("Report Filters", 5)
				  .clickAddBtn()
				  .checkDialogTitle("Choose item", 5)
				  .clickFieldsInDialogByName("Name", "ic_dimension", 5);
		reportsPage.reportDropDown.checkIsRendered()
				  .clickObjectByName("Select");
		reportsPage.reportFiltersDialog.checkIsRendered()
				  .checkDialogTitle("Dependent objects", 5)
				  .clickDoneBtn()
				  .clickFieldsInDialogByName("One", "ic_check_box_outline", 5)
				  .clickFieldsInDialogByName("Two", "ic_check_box_outline", 5)
				  .clickFieldsInDialogByName("Three", "ic_check_box_outline", 5)
				  .clickDoneBtn()
				  .checkDialogTitle("Report Filters", 5)
				  .checkFilterInNodeByName("3 of 9");
		reportsPage.checkIsRendered()
				  .checkChartNoDate()
				  .clickCloseBtn();
	}

	@Test
	public void checkCopyStyle()
	{
		authPage.open().checkIsRendered();
		authPage.logIn("slemmatest@mail.ru", "Q123#@!w");
		changeTeam("TestTeam2");
		mainPage.checkIsRendered()
				  .openReports()
				  .clickObjectInDataTableByName("filter", 5);
		reportsPage.checkIsRendered()
				  .clickEditBtn()
				  .contextClick("jira tickets", 10);
		reportsPage.reportDropDown.checkIsRendered()
				  .clickObjectByName("Copy style");
		pause(5);
		reportsPage.checkIsRendered()
				  .contextClick("chart Copy style", 10);
		reportsPage.reportDropDown.checkIsRendered()
				  .clickObjectByName("Paste style");
		//проверка применимости стилей
		reportsPage.settingsChartDialog.checkIsRendered()
				  .clickTabStyleBtn()
				  .clickAccordionByName("Title");
		Assert.assertTrue(reportsPage.settingsChartDialog.createSelectSize().getFirstSelectedOption().getText().matches("24"));
		reportsPage.settingsChartDialog.clickAccordionByName("General")
				  .clickLineWeight();
		reportsPage.reportDropDown.checkIsRendered()
				  .checkSelectedItem("4px", "ic_check");
		reportsPage.checkIsRendered()
				  .clickCloseBtn();
	}

	@Test
	public void checkChartRefresh()
	{
		//TestTeam2
		authPage.open().checkIsRendered();
		authPage.logIn("slemmatest@mail.ru", "Q123#@!w");
		changeTeam("TestTeam2");
		mainPage.checkIsRendered()
				  .openReports()
				  .clickObjectInDataTableByName("ChartRefresh", 5);
		reportsPage.checkIsRendered()
				  .clickEditBtn()
				  .clickChartByName("Refresh")
				  .clickRefreshBtn()
				  .checkChartNoDate()
				  .clickCloseBtn();
	}

	@Test
	public void createShare()
	{
		authPage.open().checkIsRendered();
		authPage.logIn("slemmatest@mail.ru", "Q123#@!w");
		changeTeam("TestTeam");
		mainPage.checkIsRendered()
				  .openReports()
				  .clickPlusBtn();
		reportsPage.checkIsRendered()
				  .clickInsertBtn();
		reportsPage.chooseObjectDropDown.checkIsRendered()
				  .clickObjectByName("Text", "ic_text");
		reportsPage.checkIsRendered()
				  .clickEditTextBtn();
		driver.keyboardImitate("Здесь вставляется новый текст!");
		reportsPage.checkIsRendered()
				  .clickMoreBtn();
		mainPage.moreOptionDropDown.checkIsRendered()
				  .clickSaveIcon();
		reportsPage.saveAsDialog.checkIsRendered()
				  .enterInputName("shareObject")
				  .clickOk();
		reportsPage.checkIsRendered()
				  .clickShareBtn();
		mainPage.addPeopleDialog.checkIsRendered()
				  .selectPeople("s.kataev@slemma.com", 2)
				  .clickSendBtn();
		reportsPage.clickCloseBtn();
		mainPage.checkObjectInDataTableByName("shareObject", 5)
				  .contextClickObjectInDataTableByName("shareObject", 5);
		mainPage.moreOptionDropDown.checkIsRendered()
				  .clickPermissionsIcon();
		mainPage.permissionsDialog.checkIsRendered()
				  .checkSelectPeople("s.kataev@slemma.com", 2)
				  .clickCloseBtn();
	}

	@Test
	public void checkPermissions()
	{
		authPage.open().checkIsRendered();
		authPage.logIn("slemmatest2@mail.ru", "Q123#@!w");
		mainPage.checkIsRendered()
				  .openReports()
				  .clickObjectInDataTableByName("filter", 5);
		//проверить что есть кнопка "edit"
		reportsPage.checkIsRendered()
				  .checkEditBtn()
				  .clickCloseBtn();
		mainPage.checkIsRendered()
				  .openReports()
				  .clickObjectInDataTableByName("ChartRefresh", 5);
		//проверить что НЕТ кнопки "edit"
		reportsPage.checkIsRendered()
				  .checkAbsenceEditBtn()
				  .clickCloseBtn();
		mainPage.clickSignOutBtn();
	}

	@Test
	public void goToShareLink()
	{
		authPage.open().checkIsRendered();
		authPage.logIn("slemmatest@mail.ru", "Q123#@!w");
		changeTeam("TestTeam2");
		mainPage.checkIsRendered()
				  .checkObjectInDataTableByName("with share link", 5)
				  .contextClickObjectInDataTableByName("with share link", 5);
		mainPage.moreOptionDropDown.checkIsRendered()
				  .clickLinkIcon();
		mainPage.linkSharingDialog.checkIsRendered()
				  .getLinkSharing();
		String url = mainPage.linkSharingDialog.getLinkSharing();
		driver.goToUrl(url);
		reportsPage.checkIsRendered()
				  .checkChartNoDate()
				  .checkAbsenceEditBtn()
				  .clickCloseBtn();
	}

	@Test
	public void getEmbedCode()
	{
		authPage.open().checkIsRendered();
		authPage.logIn("slemmatest@mail.ru", "Q123#@!w");
		changeTeam("TestTeam2");
		mainPage.checkIsRendered()
				  .checkObjectInDataTableByName("with share link", 5)
				  .contextClickObjectInDataTableByName("with share link", 5);
		mainPage.moreOptionDropDown.checkIsRendered()
				  .clickLinkIcon();
		mainPage.linkSharingDialog.checkIsRendered()
				  .getEmbedCode();
		String embedCode = mainPage.linkSharingDialog.getEmbedCode();
		mainPage.linkSharingDialog.clickCloseBtn();
		changeTeam("TestTeam");
		mainPage.clickPlusBtn();
		reportsPage.checkIsRendered()
				  .clickInsertBtn();
		reportsPage.chooseObjectDropDown.checkIsRendered()
				  .clickObjectByName("URL embed", "ic_code");
		reportsPage.hTTPSwebAddressDialog.checkIsRendered()
				  .urlInput(embedCode)
				  .clickOk();
		reportsPage.checkIsRendered()
				  .checkChartNoDate();
		reportsPage.checkIsRendered()
				  .clickMoreBtn();
		mainPage.moreOptionDropDown.checkIsRendered()
				  .clickSaveIcon();
		reportsPage.saveAsDialog.checkIsRendered()
				  .enterInputName("EmbedCode")
				  .clickOkBtn();
		reportsPage.clickCloseBtn();
		mainPage.checkObjectInDataTableByName("EmbedCode", 15)
				  .clickObjectInDataTableByName("EmbedCode", 15);
	}

	@Test
	public void checkAllFiltersReport()
	{
		authPage.open().checkIsRendered();
		authPage.logIn("slemmatest2@mail.ru", "Q123#@!w");
		mainPage.checkIsRendered();
		driver.goToUrl("http://app.newpeople.co/share/filters");
		mainPage.passwordProtectedDialog.checkIsRendered()
				  .enterPasswordInput("123!@#qwe")
				  .clickViewReportBtn();
		reportsPage.checkIsRendered()
				  .checkChartNoDate()
				  .clickCloseBtn();
	}

	@Test
	public void checkGrandTotal()
	{
		authPage.open().checkIsRendered();
		authPage.logIn("slemmatest2@mail.ru", "Q123#@!w");
		mainPage.checkIsRendered();
		driver.goToUrl("http://app.newpeople.co/share/mediana");
		reportsPage.checkIsRendered()
				  .checkChartNoDate()
				  .checkChartNoNaN()
				  .clickCloseBtn();
	}

	@Test
	public void checkLevelByDay()
	{
		authPage.open().checkIsRendered();
		authPage.logIn("slemmatest2@mail.ru", "Q123#@!w");
		mainPage.checkIsRendered();
		driver.goToUrl("http://app.newpeople.co/share/levelbyday");
		reportsPage.checkIsRendered()
				  .checkChartNoDate()
				  .checkChartNoNaN()
				  .clickCloseBtn();
	}

	@Test
	public void checkOpenDashByChangingAccount()
	{
		authPage.open().checkIsRendered();
		authPage.logIn("e.matveeva@slemma.com", "Matveeva0414");
		mainPage.checkIsRendered();
		driver.goToUrl("http://app.newpeople.co/reports/4108");
		mainPage.requestAccessDialog.checkIsRendered()
				  .checkLogoutBtn()
				  .checkRequestBtn()
				  .clickCloseBtn();
	}

	@Test
	public void addNewItem()
	{
		authPage.open().checkIsRendered();
		authPage.logIn("slemmatest@mail.ru", "Q123#@!w");
		changeTeam("TestTeam");
		mainPage.checkIsRendered()
				  .openReports()
				  .clickPlusBtn();
		reportsPage.checkIsRendered()
				  .clickInsertBtn();
		reportsPage.chooseObjectDropDown.checkIsRendered()
				  .clickObjectByName("Chart", "ic_chart");
		reportsPage.selectaDataSourceDialog.checkIsRendered()
				  .clickDataSourceInDialogByName("DemoData", "ic_csv", 30);
		reportsPage.chooseaChartTypeDialog.checkIsRendered()
				  .clickTypeChartInDialogByName("Column", "ic_column", 5);
		reportsPage.settingsChartDialog.checkIsRendered()
				  .checkDialogTitle("Settings", 2)
				  .clickItemInPanelByName("Data source", "ic_csv");
		reportsPage.reportDropDown.checkIsRendered()
				  .clickObjectByName("Calculations");
		reportsPage.сalculationsAddDialog.checkIsRendered()
				  .clickAddBtn();
		pause(5);
		reportsPage.reportDropDown.checkIsRendered()
				  .clickObjectByName("Region");
		reportsPage.calculationsDialog.checkIsRendered()
				  .enterNameInput("Region item")
				  .clickCodeMirror();
		driver.keyboardImitate("[Region.Hierarchy].[Central]-[Region.Hierarchy].[West]");
//		pause(5);
		reportsPage.calculationsDialog.clickSaveBtn();
		reportsPage.сalculationsAddDialog.checkIsRendered()
				  .checkMeasureTableByName("Region item",5)
				  .clickСloseBtn();
		reportsPage.settingsChartDialog.clickAddDimensionBtn()
				  .checkDialogTitle("Choose dimension", 5)
				  .clickDimensionInPanelByName("Region")
				  .clickAddMeasureBtn()
				  .checkDialogTitle("Choose measure", 5)
				  .clickDimensionInPanelByName("Sales");
		reportsPage.reportDropDown.checkIsRendered()
				  .clickObjectByName("Sum");
		//проверка что измерение добавилось фильтры-селект-проверка самого значения
		reportsPage.settingsChartDialog.checkIsRendered()
				  .clickAddFilterBtn();
		reportsPage.reportFiltersDialog.checkIsRendered()
				  .checkDialogTitle("Choose item", 2);
		Assert.assertTrue(driver.click(By.xpath("(//div[contains(@class, 'block-settings-panel')]//span[contains(@class, 'mdc-list-item__text') and contains(text(), 'Region')])[2]")));
		reportsPage.reportDropDown.checkIsRendered()
				  .clickObjectByName("Select");
		reportsPage.settingsChartDialog.checkIsRendered()
				  .checkDialogTitle("Selection", 5)
				  .clickItemInSelectByName("Region item", "ic_check_box_outline", 5)
				  .clickItemInSelectByName("Central", "ic_check_box_outline", 5)
				  .clickApplyBtn();
		reportsPage.checkIsRendered()
				  .clickMoreBtn();
		mainPage.moreOptionDropDown.checkIsRendered()
				  .clickSaveIcon();
		reportsPage.saveAsDialog.checkIsRendered()
				  .enterInputName("CalculatedItem")
				  .clickOkBtn();
	}

	@Test
	public void addNewSheet()
	{
		authPage.open().checkIsRendered();
		authPage.logIn("slemmatest@mail.ru", "Q123#@!w");
		changeTeam("TestTeam");
		mainPage.checkIsRendered()
				  .openReports()
				  .clickPlusBtn();
		reportsPage.checkIsRendered()
				  .clickSheetBtn()
				  .clickSheetBtn()
				  .contextClickSheet("Sheet 2", 10);
		reportsPage.reportDropDown.checkIsRendered()
				  .clickObjectByName("Rename");
		mainPage.renameDialog.checkIsRendered()
				  .enterInputName("New name sheet")
				  .clickRenameBtn();
		reportsPage.settingsReportDialog.checkIsRendered()
				  .createStartSheet().selectByVisibleText("New name sheet");
		reportsPage.clickMoreBtn();
		mainPage.moreOptionDropDown.checkIsRendered()
				  .clickSaveIcon();
		reportsPage.saveAsDialog.checkIsRendered()
				  .enterInputName("addSheet")
				  .clickOkBtn();
		reportsPage.clickCloseBtn();
		mainPage.checkIsRendered()
				  .clickObjectInDataTableByName("addSheet", 5);
		reportsPage.checkIsRendered()
				  .checkActiveSheet("New name sheet", "mdc-tab--active", 5)
				  .clickCloseBtn();
	}

	@Test
	public void deleteAddNewSheet()
	{
		authPage.open().checkIsRendered();
		authPage.logIn("slemmatest@mail.ru", "Q123#@!w");
		changeTeam("TestTeam");
		mainPage.checkIsRendered()
				  .openReports()
				  .contextClickObjectInDataTableByName("addSheet", 5);
		mainPage.moreOptionDropDown.checkIsRendered()
				  .clickRemoveBtn();
		mainPage.confirmDialog.checkIsRendered()
				  .clickDeleteBtn();
		mainPage.checkIsRendered();
		Assert.assertFalse(driver.waitUntilExist(By.xpath("//div[contains(@class , 'accordion__item__body')]//span[contains(@class, 'mdc-list-item') and text()='addSheet']")));
	}

}