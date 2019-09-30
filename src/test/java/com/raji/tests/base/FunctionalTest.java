
package com.raji.tests.base;

import com.raji.config.AppConfiguration;
import com.raji.config.Configuration;
import org.apache.commons.io.FileUtils;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class FunctionalTest {

	protected static WebDriver driver;

	@BeforeClass
	public static void setUpClass() throws Exception {
		driver = AppConfiguration.ConfigureDriver();
		driver.get(AppConfiguration.BaseUrl);
	}

	@AfterClass
	public static void tearDownClass() {
		AppConfiguration.ExitDriver();
	}

	//Takes screenshot in PNG image format
	public void TakeScreenshot(String screenshotName) {

		File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		String screenShotsDirectory = Configuration.ScreenShotsDirectory;
		try {
			FileUtils.copyFile(screenshotFile, new File(screenShotsDirectory + screenshotName + ".png"));
		} catch (IOException ioe) {
			System.out.println("Error taking a screen shot for \"" + screenshotName + "\". \n Error message is : " + ioe.getMessage());
		}

	}


}