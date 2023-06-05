package org.ryanshin.utils;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;

// common method used in both Android and IOS util
public class AppiumUtils {
	
	AppiumDriver androidDriver;
	
	public AppiumUtils(AppiumDriver androidDriver) {
		this.androidDriver = androidDriver;
		
	}
	// remove $ and convert it to the double data type
	public Double getFormattedAmount(String amount) {
		double price = Double.parseDouble(amount.substring(1));
		return price;
	}
	
	public void waitForElementToAppear(WebElement ele) {
		WebDriverWait wait = new WebDriverWait(androidDriver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.attributeContains((ele), "text", "Cart"));
	}
	
	public String getScreenshot(String testCaseName, AppiumDriver androidDriver) throws IOException {
		File source = androidDriver.getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir")+"//reports"+testCaseName+".png";
		FileHandler.copy(source, new File(destinationFile));
		return destinationFile;
		// 1. capture and place in a folder
		// 2. extent report pick file and attach to report
		
	}

}
