package org.ryanshin.pageObjects.android;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class CartPage {
	
	
	//Driver invocation.
	AndroidDriver androidDriver;

	public ProductCatalog(AndroidDriver androidDriver) {
		super(androidDriver);
		this.androidDriver = androidDriver;
		PageFactory.initElements(new AppiumFieldDecorator(androidDriver), this);
		
	}

}
