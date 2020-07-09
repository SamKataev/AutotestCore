package com.objects.npobjects.pageelements.dialogs;

import com.objects.npobjects.pageelements.dropdown.SelectFileTypeDropDown;
import com.objects.npobjects.pageobjects.NavigatorPage;
import com.service.ui.web.SeleniumDriverWrapper;
import junit.framework.Assert;
import org.openqa.selenium.By;

/**
 * Created by User on 05-Apr-19.
 */
public class CreateDataSourceDialog extends Dialog
{

	private NavigatorPage parentPage;

	private final By title = dialogAppBarTitle("Create New Data Source");
	private final By uploadFile = dialogListItemWithText("Upload a File");

	public SelectFileTypeDropDown selectDatasourceTypeDialog;
	public ChooseCloudFileDialog chooseCloudFileDialog;
	public FileByUrlDialog fileByUrlDialog;

	private final By amazonMySQLBtn = dialogListItemWithTextIcon("Amazon RDS MySQL", "ic_amazon_rds");
	private final By amazonPostgreSQLBtn = dialogListItemWithTextIcon("Amazon RDS PostgreSQL", "ic_amazon_rds");
	private final By amazonRedshiftBtn = dialogListItemWithTextIcon("Amazon Redshift", "ic_amazon_redshi");
	private final By treasureDataBtn = dialogListItemWithTextIcon("Arm Treasure Data", "ic_treasure_data");
	private final By herokuPostgresBtn = dialogListItemWithTextIcon("Heroku Postgres", "ic_heroku_postgr");
	private final By iBMDB2Btn = dialogListItemWithTextIcon("IBM DB2", "ic_ibm_db2");
	private final By mariaDBBtn = dialogListItemWithTextIcon("MariaDB", "ic_mariadb");
	private final By microsoftAzureSQLBtn = dialogListItemWithTextIcon("Microsoft Azure SQL", "ic_microsoft_azu");
	private final By microsoftSQLServerBtn = dialogListItemWithTextIcon("Microsoft SQL Server", "ic_microsoft_sql");
	private final By mongoDBBtn = dialogListItemWithTextIcon("MongoDB", "ic_mongodb");
	private final By mySQLBtn = dialogListItemWithTextIcon("MySQL", "ic_mysql");
	private final By oracleBtn = dialogListItemWithTextIcon("Oracle", "ic_oracle");
	private final By postgreSQLBtn = dialogListItemWithTextIcon("PostgreSQL", "ic_postgresql");
	private final By prestoBtn = dialogListItemWithTextIcon("Presto", "ic_prestodb");
	private final By sAPHANABtn = dialogListItemWithTextIcon("SAP HANA", "ic_sap_hana");
	private final By teradataBtn = dialogListItemWithTextIcon("Teradata", "ic_teradata");
	private final By verticaBtn = dialogListItemWithTextIcon("Vertica", "ic_vertica");

	public CreateDataSourceDialog(SeleniumDriverWrapper driver, NavigatorPage pageObj)
	{
		super(driver);
		parentPage = pageObj;

		selectDatasourceTypeDialog = new SelectFileTypeDropDown(driver, this.parentPage);
		chooseCloudFileDialog = new ChooseCloudFileDialog(driver, this.parentPage);
		fileByUrlDialog = new FileByUrlDialog(driver, this.parentPage);
	}

	@Override
	public boolean validateElements()
	{
		return driver.waitUntilExist(title, 5)
				  && driver.waitUntilClickable(closeBtn)
				  && driver.waitUntilClickable(uploadFile);
	}


	public CreateDataSourceDialog checkIsRendered()
	{
		super.checkIsRendered();
		return this;
	}

	public SelectFileTypeDropDown clickUploadFile()
	{
		Assert.assertTrue(driver.click(uploadFile));
		return selectDatasourceTypeDialog;
	}

	public CreateDataSourceDialog ClickSearchBtn()
	{
		Assert.assertTrue(driver.click(searchBtn));
		return this;
	}

	//Click database
	public CreateDataSourceDialog ClickAmazonMySQLBtn()
	{
		Assert.assertTrue(driver.click(amazonMySQLBtn));
		return this;
	}

	public CreateDataSourceDialog ClickAmazonPostgreSQLBtn()
	{
		Assert.assertTrue(driver.click(amazonPostgreSQLBtn));
		return this;
	}

	public CreateDataSourceDialog ClickAmazonRedshiftBtn()
	{
		Assert.assertTrue(driver.click(amazonRedshiftBtn));
		return this;
	}

	public CreateDataSourceDialog ClickTreasureDataBtn()
	{
		Assert.assertTrue(driver.click(treasureDataBtn));
		return this;
	}

	public CreateDataSourceDialog сlickHerokuPostgresBtn()
	{
		Assert.assertTrue(driver.click(herokuPostgresBtn));
		return this;
	}

	public CreateDataSourceDialog ClickIBMDB2Btn()
	{
		Assert.assertTrue(driver.click(iBMDB2Btn));
		return this;
	}

	public CreateDataSourceDialog ClickMariaDBBtn()
	{
		Assert.assertTrue(driver.click(mariaDBBtn));
		return this;
	}

	public CreateDataSourceDialog ClickMicrosoftAzureSQLBtn()
	{
		Assert.assertTrue(driver.click(microsoftAzureSQLBtn));
		return this;
	}

	public CreateDataSourceDialog ClickMicrosoftSQLServerBtn()
	{
		Assert.assertTrue(driver.click(microsoftSQLServerBtn));
		return this;
	}

	public CreateDataSourceDialog ClickMongoDBBtn()
	{
		Assert.assertTrue(driver.click(mongoDBBtn));
		return this;
	}

	public CreateDataSourceDialog ClickMySQLBtn()
	{
		Assert.assertTrue(driver.click(mySQLBtn));
		return this;
	}

	public CreateDataSourceDialog ClickOracleBtn()
	{
		Assert.assertTrue(driver.click(oracleBtn));
		return this;
	}

	public CreateDataSourceDialog clickPostgreSQLBtn()
	{
		Assert.assertTrue(driver.click(postgreSQLBtn));
		return this;
	}

	public CreateDataSourceDialog ClickPrestoBtn()
	{
		Assert.assertTrue(driver.click(prestoBtn));
		return this;
	}

	public CreateDataSourceDialog ClickSAPHANABtn()
	{
		Assert.assertTrue(driver.click(sAPHANABtn));
		return this;
	}

	public CreateDataSourceDialog ClickTeradataBtn()
	{
		Assert.assertTrue(driver.click(teradataBtn));
		return this;
	}

	public CreateDataSourceDialog ClickVerticaBtn()
	{
		Assert.assertTrue(driver.click(verticaBtn));
		return this;
	}
}

