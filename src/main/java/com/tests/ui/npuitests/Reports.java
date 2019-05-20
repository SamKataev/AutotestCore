package com.tests.ui.npuitests;

import com.service.ui.web.SeleniumDriverWrapper;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Reports extends NPWebTest
{

    @Test
    public void insertSimpleObject() {
        mainPage.checkIsRendered()
                .openReports()
                .clickPlusBtn();
        reportsPage.checkIsRendered()
                .clickInsertBtn();
        reportsPage.chooseObjectDropDown.checkIsRendered()
                .uploadFile("C:\\Users\\User\\Downloads\\1472058088_05.jpg")
                .clickObjectByName("Text","ic_text");
        reportsPage.clickInsertBtn();
        reportsPage.chooseObjectDropDown.checkIsRendered()
                .clickObjectByName("URL embed","ic_code");
        reportsPage.hTTPSwebAddressDialog.checkIsRendered()
                .urlInput("http://app.newpeople.co/reports/1287")
                .clickOk();
        reportsPage.clickInsertBtn();
        reportsPage.chooseObjectDropDown.checkIsRendered()
                .clickObjectByName("Chart template","ic_chart_template");
        mainPage.selectDatasetDialog.checkIsRendered()
                .checkDialogTitle("Select connection",10)
                .clickFileInDialogByName("New People", "ic_pipedrive", 20)
                .clickBasedInDialogByName("Deals Pipeline", "ic_column", 20);
        pause(5); //дописать вейтер или нахождение элемента на странице
        reportsPage.checkIsRendered()
                   .clickMoreBtn();
        mainPage.moreOptionDropDown.checkIsRendered()
                .clickSaveIcon();
        reportsPage.saveAsDialog.checkIsRendered()
                .enterInputName("SimpleObject")
                .clickOkBtn();
        reportsPage.clickCloseBtn();
        mainPage.checkObjectInDataTableByName("SimpleObject",15)
                .clickObjectInDataTableByName("SimpleObject",15);
   }
	@Test
	public void insertAllTypeChart()
	{
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
						.clickAddDimensionBtn()
						.clickDimensionInPanelByName("Company")
						.clickItemInPanelByName("Data source", "ic_csv");
			 reportsPage.reportDropDown.checkIsRendered()
						.clickObjectByName("Calculations");
			 reportsPage.сalculationsAddDialog.checkIsRendered()
						.clickAddBtn();
			 reportsPage.reportDropDown.checkIsRendered()
						.clickObjectByName("Measure Names");
			 reportsPage.calculationsDialog.checkIsRendered()
						.clickMetricsByName("Number of records")
						.clickCodeMirror();
			 driver.keyboardImitate("*"); //переписать после доработки выч. метрик
			 reportsPage.calculationsDialog.clickMetricsByName("Number of records")
						.clickSaveBtn();
			 reportsPage.сalculationsAddDialog.clickСloseBtn();
			 reportsPage.settingsChartDialog.clickAddMeasureBtn()
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
		mainPage.checkIsRendered()
				  .openReports()
				  .clickObjectInDataTableByName("filter", 5);
		reportsPage.checkIsRendered()
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
}