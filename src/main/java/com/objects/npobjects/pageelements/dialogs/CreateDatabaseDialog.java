package com.objects.npobjects.pageelements.dialogs;

import com.objects.npobjects.pageobjects.Main;
import com.service.ui.web.SeleniumDriverWrapper;
import junit.framework.Assert;
import org.openqa.selenium.By;

/**
 * Created by User on 05-Apr-19.
 */
public class CreateDatabaseDialog extends Dialog {

    private Main parentPage;

    private final By title = dialogMdcAppBarTitle("Create new");
    private final By closeBtn = dialogMdcIconFontBtn("ic_close");
    private final By searchBtn = dialogMdcIconFontBtn("ic_search");

    private final By amazonMySQLBtn = dialogMdcListItemWithTextIcon("Amazon RDS MySQL", "ic_amazon_rds");
    private final By amazonPostgreSQLBtn = dialogMdcListItemWithTextIcon("Amazon RDS PostgreSQL", "ic_amazon_rds");
    private final By amazonRedshiftBtn = dialogMdcListItemWithTextIcon("Amazon Redshift", "ic_amazon_redshi");
    private final By treasureDataBtn = dialogMdcListItemWithTextIcon("Arm Treasure Data", "ic_treasure_data");
    private final By herokuPostgresBtn = dialogMdcListItemWithTextIcon("Heroku Postgres", "ic_heroku_postgr");
    private final By iBMDB2Btn = dialogMdcListItemWithTextIcon("IBM DB2", "ic_ibm_db2");
    private final By mariaDBBtn = dialogMdcListItemWithTextIcon("MariaDB", "ic_mariadb");
    private final By microsoftAzureSQLBtn = dialogMdcListItemWithTextIcon("Microsoft Azure SQL", "ic_microsoft_azu");
    private final By microsoftSQLServerBtn = dialogMdcListItemWithTextIcon("Microsoft SQL Server", "ic_microsoft_sql");
    private final By mongoDBBtn = dialogMdcListItemWithTextIcon("MongoDB", "ic_mongodb");
    private final By mySQLBtn = dialogMdcListItemWithTextIcon("MySQL", "ic_mysql");
    private final By oracleBtn = dialogMdcListItemWithTextIcon("Oracle", "ic_oracle");
    private final By postgreSQLBtn = dialogMdcListItemWithTextIcon("PostgreSQL", "ic_postgresql");
    private final By prestoBtn = dialogMdcListItemWithTextIcon("Presto", "ic_prestodb");
    private final By sAPHANABtn = dialogMdcListItemWithTextIcon("SAP HANA", "ic_sap_hana");
    private final By teradataBtn = dialogMdcListItemWithTextIcon("Teradata", "ic_teradata");
    private final By verticaBtn = dialogMdcListItemWithTextIcon("Vertica", "ic_vertica");





    public CreateDatabaseDialog (SeleniumDriverWrapper driver, Main pageObj) {
        super(driver);
        parentPage = pageObj;
    }

    @Override
    public boolean validateElements() {
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


    public CreateDatabaseDialog checkIsRendered() {
        super.checkIsRendered();
        return this;
    }

    public CreateDatabaseDialog ClickSearchBtn(){
        Assert.assertTrue(driver.click(searchBtn));
        return this;
    }

    //Click database
    public CreateDatabaseDialog ClickAmazonMySQLBtn(){
        Assert.assertTrue(driver.click(amazonMySQLBtn));
        return this;
    }
    public CreateDatabaseDialog ClickAmazonPostgreSQLBtn(){
        Assert.assertTrue(driver.click(amazonPostgreSQLBtn));
        return this;
    }
    public CreateDatabaseDialog ClickAmazonRedshiftBtn(){
        Assert.assertTrue(driver.click(amazonRedshiftBtn));
        return this;
    }

    public CreateDatabaseDialog ClickTreasureDataBtn(){
        Assert.assertTrue(driver.click(treasureDataBtn));
        return this;
    }

    public CreateDatabaseDialog ClickHerokuPostgresBtn(){
        Assert.assertTrue(driver.click(herokuPostgresBtn));
        return this;
    }

    public CreateDatabaseDialog ClickIBMDB2Btn(){
        Assert.assertTrue(driver.click(iBMDB2Btn));
        return this;
    }
    public CreateDatabaseDialog ClickMariaDBBtn(){
        Assert.assertTrue(driver.click(mariaDBBtn));
        return this;
    }
    public CreateDatabaseDialog ClickMicrosoftAzureSQLBtn(){
        Assert.assertTrue(driver.click(microsoftAzureSQLBtn));
        return this;
    }

    public CreateDatabaseDialog ClickMicrosoftSQLServerBtn(){
        Assert.assertTrue(driver.click(microsoftSQLServerBtn));
        return this;
    }
    public CreateDatabaseDialog ClickMongoDBBtn(){
        Assert.assertTrue(driver.click(mongoDBBtn));
        return this;
    }

    public CreateDatabaseDialog ClickMySQLBtn(){
        Assert.assertTrue(driver.click(mySQLBtn));
        return this;
    }
    public CreateDatabaseDialog ClickOracleBtn(){
        Assert.assertTrue(driver.click(oracleBtn));
        return this;
    }
    public CreateDatabaseDialog ClickPostgreSQLBtn(){
        Assert.assertTrue(driver.click(postgreSQLBtn));
        return this;
    }
    public CreateDatabaseDialog ClickPrestoBtn(){
        Assert.assertTrue(driver.click(prestoBtn));
        return this;
    }
    public CreateDatabaseDialog ClickSAPHANABtn(){
        Assert.assertTrue(driver.click(sAPHANABtn));
        return this;
    }
    public CreateDatabaseDialog ClickTeradataBtn(){
        Assert.assertTrue(driver.click(teradataBtn));
        return this;
    }
    public CreateDatabaseDialog ClickVerticaBtn(){
        Assert.assertTrue(driver.click(verticaBtn));
        return this;
    }
}

