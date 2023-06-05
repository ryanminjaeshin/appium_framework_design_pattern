package org.ryanshin;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.ryanshin.pageObjects.android.FormPage;
import org.ryanshin.pageObjects.android.ProductCatalog;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class Appium extends BaseTest {
	
	@Test
	public void FillForm() throws MalformedURLException {
		
		FormPage formPage = new FormPage(androidDriver);
		
		formPage.setNameField("Ryan Shin");	
		formPage.setGender("female");
		formPage.setCountrySelection("Argentina");
		formPage.submitForm();
		
		ProductCatalog productCatalog = new ProductCatalog(androidDriver);
		productCatalog.addItemToCartByIndex(0);
		
	}



}
