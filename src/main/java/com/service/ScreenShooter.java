package com.service;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenShooter {
	private String folder;

	public ScreenShooter(String folder) {
		this.folder = folder;
	}

	public boolean getScreenShot(WebDriver driver, String problem) {
		if (!isDriverAlive(driver)) {
			return false;
		}
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String fileName = folder + "scr_" + "_" +getCurrentDateTime()+"_"+problem + ".png";
		try {
			FileUtils.copyFile(scrFile, new File(fileName));
		} catch (IOException e) {
			System.out.println("Error making screenshot:" + fileName + " Error-" + e.getMessage());
			return  false;
		}
		return true;
	}

	public String getCurrentDateTime(){
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("dd-MM=hh_mm");
		return format.format(date);
	}

	private boolean isDriverAlive(WebDriver driver) {
		try {
			driver.getTitle();
			return true;
		} catch (Exception e) {
			System.out.println("Driver is not respond! " + e.getMessage());
			return false;
		}
	}
}
