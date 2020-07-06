package com.objects.npobjects.pageelements.dialogs;

import com.objects.npobjects.pageobjects.NavigatorPage;
import com.service.ui.web.SeleniumDriverWrapper;
import org.openqa.selenium.By;

/**
 * Created by Kate on 03-Apr-19.
 */
public class ScheduleDeliveryDialog extends Dialog
{

	private NavigatorPage parentPage;

	private final By title = dialogAppBarTitle("Schedule Delivery");
	private final By inputNameDelivery = dialogTextFieldWithLabel("New Delivery");
	private final By attachmentBtn = dialogListItemWithTextIcon("Add attachment", "ic_add");
	private final By cancel = dialogTextBtn("Cancel");
	private final By saveChanges = dialogTextBtn("Save changes");
	private final By closeBtn = dialogIconFontBtn("ic_close");

	public ScheduleDeliveryDialog(SeleniumDriverWrapper driver, NavigatorPage pageObj)
	{
		super(driver);
		parentPage = pageObj;
	}

	@Override
	public boolean validateElements()
	{
		return driver.waitUntilExist(title, 5)
				  && driver.waitUntilClickable(closeBtn)
				  && driver.waitUntilClickable(inputNameDelivery)
				  && driver.waitUntilClickable(attachmentBtn)
				  && driver.waitUntilClickable(cancel)
				  && driver.waitUntilClickable(saveChanges);
	}

	public ScheduleDeliveryDialog checkIsRendered()
	{
		super.checkIsRendered();
		return this;
	}

}
