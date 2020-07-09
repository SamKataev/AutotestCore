package com.tests.ui.npuitests;

import org.testng.annotations.Test;

public class NavigatorTest extends NPWebTest
{

	@Test
	public void goThroughNavigationMenu()
	{
		mainPage.checkIsRendered()
				  .openReports()
				  .checkIsNavMenuRendered()
				  .openDatasources()
				  .checkIsNavMenuRendered()
				  .clickAdminBtn()
				  .openIntegrations()
				  .checkIsNavMenuRendered(true)
				  .openUsers()
				  .checkIsNavMenuRendered(true);

		mainPage.clickSettingsBtn();
		mainPage.userSettingsDialog
				  .checkIsRendered()
				  .clickClose();

		mainPage.clickWorkspaceBtn();
		mainPage.workspaceSettingsDialog
				  .checkIsRendered()
				  .clickClose();
	}
}
