package org.ryanshin;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.ryanshin.pageObjects.android.CartPage;
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
	public void FillForm() throws MalformedURLException, InterruptedException {
				
		//-- Page Object Model --//
		
		formPage.setNameField("Ryan Shin");	
		formPage.setGender("female");
		formPage.setCountrySelection("Argentina");
		
		ProductCatalog productCatalog = formPage.submitForm();
		
		productCatalog.addItemToCartByIndex(0);
		productCatalog.addItemToCartByIndex(0);
		
		CartPage cartPage = productCatalog.goToCartPage();

		double totalSum = cartPage.getProductSum();
		double displayFormattedSum = cartPage.getTotalAmountDisplayed();
		Assert.assertEquals(totalSum, displayFormattedSum);
		cartPage.acceptTermsConditions();
		cartPage.submitOrder();
	}



}
