package org.ryanshin.pageObjects.android;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.ryanshin.utils.AndroidActions;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ProductCatalog extends AndroidActions {
	
	AndroidDriver androidDriver;

	public ProductCatalog(AndroidDriver androidDriver) {
		super(androidDriver);
		this.androidDriver = androidDriver;
		PageFactory.initElements(new AppiumFieldDecorator(androidDriver), this);
		
	}
	
	// Locator
	@AndroidFindBy(xpath="//android.widget.TextView[@text='ADD TO CART']")
	public List<WebElement> addToCart;
	
	
	
	//-- Actions --//
	
	public void addItemToCartByIndex() {
		
	}

}
