package org.ryanshin.pageObjects.android;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.ryanshin.utils.AndroidActions;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class CartPage extends AndroidActions {
	
	
	//Driver invocation.
	AndroidDriver androidDriver;

	public CartPage(AndroidDriver androidDriver) {
		super(androidDriver);
		this.androidDriver = androidDriver;
		PageFactory.initElements(new AppiumFieldDecorator(androidDriver), this);
		
	}
	
	//-- Locator --//
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/productPrice")
	private List<WebElement> productList;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/totalAmountLbl")
	private WebElement totalAmount;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/teramsButton")
	private WebElement terms;
	
	@AndroidFindBy(id="android:id/button1")
	private WebElement acceptButton;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/btnProceed")
	private WebElement proceed;
	
	@AndroidFindBy(className="android.widget.CheckBox")
	private WebElement checlBox;
	
	//-- Action --//
	
	public List<WebElement> getProductList(){
		return productList;
	}
	
	public double getProductSum() {
		int count = productList.size();
		double totalSum = 0;
		for(int i=0; i<count; i++) {
			String amountString = productList.get(i).getText();
			Double price = getFormattedAmount(amountString);
			totalSum = totalSum + price;
		}
		return totalSum;
	}
	
	public Double getTotalAmountDisplayed() {
		return getFormattedAmount(totalAmount.getText());
	}
	
	public void acceptTermsConditions() {
		longPressAction(terms);
		acceptButton.click();
	}
	
	public Double getFormattedAmount(String amount) {
		double price = Double.parseDouble(amount.substring(1));
		return price;
	}
	
	public void submitOrder() {
		
	}
	
	
}
