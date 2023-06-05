package org.ryanshin.pageObjects.android;

import org.openqa.selenium.support.PageFactory;
import org.ryanshin.utils.AndroidActions;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class CartPage extends AndroidActions {
	
	
	//Driver invocation.
	AndroidDriver androidDriver;

	public CartPage(AndroidDriver androidDriver) {
		super(androidDriver);
		this.androidDriver = androidDriver;
		PageFactory.initElements(new AppiumFieldDecorator(androidDriver), this);
		
	}


}
