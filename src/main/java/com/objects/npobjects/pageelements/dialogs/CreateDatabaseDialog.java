package com.objects.npobjects.pageelements.dialogs;

import com.objects.npobjects.pageobjects.NavigatorPage;
import com.service.ui.web.SeleniumDriverWrapper;
import junit.framework.Assert;
import org.openqa.selenium.By;

/**
 * Created by User on 05-Apr-19.
 */
public class CreateDatabaseDialog extends Dialog
{

	private NavigatorPage parentPage;

	private final By title = dialogAppBarTitle("Create new");
	private final By closeBtn = dialogIconFontBtn("ic_close");
	private final By searchBtn = dialogIconFontBtn("ic_search");

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

	public CreateDatabaseDialog(SeleniumDriverWrapper driver, NavigatorPage pageObj)
	{
		super(driver);
		parentPage = pageObj;
	}

	@Override
	public boolean validateElements()
	{
		return driver.waitUntilExist(title, 5)
				  && driver.waitUntilClickable(closeBtn)
				  && driver.waitUntilClickable(searchBtn)
				  && driver.waitUntilClickable(teradataBtn)
				  && driver.waitUntilClickable(postgreSQLBtn)
				  && driver.waitUntilClickable(oracleBtn)
				  && driver.waitUntilClickable(microsoftAzureSQLBtn)
				  && driver.waitUntilClickable(mariaDBBtn)
				  && driver.waitUntilClickable(iBMDB2Btn)
				  && driver.waitUntilClickable(herokuPostgresBtn)
				  && driver.waitUntilClickable(amazonPostgreSQLBtn)
				  && driver.waitUntilClickable(verticaBtn);

	}


	public CreateDatabaseDialog checkIsRendered()
	{
		super.checkIsRendered();
		return this;
	}

	public CreateDatabaseDialog ClickSearchBtn()
	{
		Assert.assertTrue(driver.click(searchBtn));
		return this;
	}

	//Click database
	public CreateDatabaseDialog ClickAmazonMySQLBtn()
	{
		Assert.assertTrue(driver.click(amazonMySQLBtn));
		return this;
	}

	public CreateDatabaseDialog ClickAmazonPostgreSQLBtn()
	{
		Assert.assertTrue(driver.click(amazonPostgreSQLBtn));
		return this;
	}

	public CreateDatabaseDialog ClickAmazonRedshiftBtn()
	{
		Assert.assertTrue(driver.click(amazonRedshiftBtn));
		return this;
	}

	public CreateDatabaseDialog ClickTreasureDataBtn()
	{
		Assert.assertTrue(driver.click(treasureDataBtn));
		return this;
	}

	public CreateDatabaseDialog сlickHerokuPostgresBtn()
	{
		Assert.assertTrue(driver.click(herokuPostgresBtn));
		return this;
	}

	public CreateDatabaseDialog ClickIBMDB2Btn()
	{
		Assert.assertTrue(driver.click(iBMDB2Btn));
		return this;
	}

	public CreateDatabaseDialog ClickMariaDBBtn()
	{
		Assert.assertTrue(driver.click(mariaDBBtn));
		return this;
	}

	public CreateDatabaseDialog ClickMicrosoftAzureSQLBtn()
	{
		Assert.assertTrue(driver.click(microsoftAzureSQLBtn));
		return this;
	}

	public CreateDatabaseDialog ClickMicrosoftSQLServerBtn()
	{
		Assert.assertTrue(driver.click(microsoftSQLServerBtn));
		return this;
	}

	public CreateDatabaseDialog ClickMongoDBBtn()
	{
		Assert.assertTrue(driver.click(mongoDBBtn));
		return this;
	}

	public CreateDatabaseDialog ClickMySQLBtn()
	{
		Assert.assertTrue(driver.click(mySQLBtn));
		return this;
	}

	public CreateDatabaseDialog ClickOracleBtn()
	{
		Assert.assertTrue(driver.click(oracleBtn));
		return this;
	}

	public CreateDatabaseDialog clickPostgreSQLBtn()
	{
		Assert.assertTrue(driver.click(postgreSQLBtn));
		return this;
	}

	public CreateDatabaseDialog ClickPrestoBtn()
	{
		Assert.assertTrue(driver.click(prestoBtn));
		return this;
	}

	public CreateDatabaseDialog ClickSAPHANABtn()
	{
		Assert.assertTrue(driver.click(sAPHANABtn));
		return this;
	}

	public CreateDatabaseDialog ClickTeradataBtn()
	{
		Assert.assertTrue(driver.click(teradataBtn));
		return this;
	}

	public CreateDatabaseDialog ClickVerticaBtn()
	{
		Assert.assertTrue(driver.click(verticaBtn));
		return this;
	}
}

