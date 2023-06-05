package org.ryanshin;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.ryanshin.pageObjects.android.FormPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class Appium extends BaseTest {
	
	@Test
	public void WifiSettingTest() throws MalformedURLException {
		
		FormPage formPage = new FormPage(androidDriver);
		
		formPage.setNameField("Ryan Shin");	
		formPage.setGender("female");
		formPage.setCountrySelection("Argentina");
		formPage.submitForm();

		// Actual Automation
		// Xpath, id, className, androidUIAutomtor(AppiumBy.), accessibilityId(AppiumBy.)
		androidDriver.findElement(AppiumBy.accessibilityId("Preference")).click();
		androidDriver.findElement(AppiumBy.accessibilityId("3. Preference dependencies")).click();
		androidDriver.findElement(By.id("android:id/checkbox")).click();
		androidDriver.findElement(By.xpath("(//android.widget.RelativeLayout)[2]")).click();
		String alertTitle = androidDriver.findElement(By.id("android:id/alerTitle")).getText();
		Assert.assertEquals(alertTitle, "WiFi settings");
		androidDriver.findElement(By.id("android:id/edit")).sendKeys("Ryan wifi");
		androidDriver.findElements(AppiumBy.className("android.widget.Button")).get(1).click();
	}



}
