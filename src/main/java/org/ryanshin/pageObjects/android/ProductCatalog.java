package org.ryanshin.pageObjects.android;

import java.util.List;

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
	
	//-- Locator --//
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='ADD TO CART']")
	// findElements = List
	public List<WebElement> addToCart;
	
	
	@AndroidFindBy(xpath="com.androidsample.generalstore:id/appbar_btn_cart")
	public WebElement cart;
	
	//-- Actions --// --> Only calls action method not locator in Test class.
	
	public void addItemToCartByIndex(int index) {
		addToCart.get(index).click();
		
	}
	
	public  CartPage goToCartPage() throws InterruptedException {
		cart.click();
		Thread.sleep(2000);
		return new CartPage(androidDriver);
	}

}
