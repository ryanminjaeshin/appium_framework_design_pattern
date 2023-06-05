package org.ryanshin;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.ryanshin.pageObjects.android.CartPage;
import org.ryanshin.pageObjects.android.FormPage;
import org.ryanshin.pageObjects.android.ProductCatalog;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class Appium extends BaseTest {
	
	@Test(dataProvider="getData")
	public void FillForm(String name, String gender, String country) throws MalformedURLException, InterruptedException {
				
		//-- Page Object Model --//
		
		formPage.setNameField(name);	
		formPage.setGender(gender);
		formPage.setCountrySelection(country);
		
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

	@DataProvider // it always expect to return two dimensional array object.
	public Object[][] getData() {
		return new Object[][] {
			{"ryan shin", "female", "Argentina"}
		};
	}


}
