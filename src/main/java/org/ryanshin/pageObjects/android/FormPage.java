package org.ryanshin.pageObjects.android;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class FormPage {
	
	AndroidDriver androidDriver;
	
	public FormPage(AndroidDriver androidDriver) {
		
		this.androidDriver=androidDriver;
		PageFactory.initElements(new AppiumFieldDecorator(androidDriver), this);
	}
	
	
	// declare locator field
	// create and add action
	
	// Same as drver.findElement(By.id ~)
	@AndroidFindBy(id="come.androidsample.generalstore:id/nameField")
	private WebElement nameField;
	

}
