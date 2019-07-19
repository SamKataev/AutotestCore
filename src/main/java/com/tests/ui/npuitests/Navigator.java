package com.tests.ui.npuitests;

import org.testng.annotations.Test;

public class Navigator extends NPWebTest
{

	@Test
	public void goThroughNavigationMenu()
	{
		mainPage.checkIsRendered()
				  .openLibrary()
				  .checkIsRendered()
				  .openReports()
				  .checkIsRendered()
				  .openDatasources()
				  .checkIsRendered()
				  .openNotifications();
//				  .openDelivery()
//				  .openAlerts();
	}

}
