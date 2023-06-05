package org.ryanshin.pageObjects.android;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.ryanshin.utils.AndroidActions;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class FormPage extends AndroidActions {
	
	AndroidDriver androidDriver;
	
	public FormPage(AndroidDriver androidDriver) {
		
		super(androidDriver); // call parent class = AndroidActions
		this.androidDriver=androidDriver;
		
		// this combine AndroidFindBy and androidDriver
		PageFactory.initElements(new AppiumFieldDecorator(androidDriver), this);
	}
	
	
	// declare locator field
	// create locator and add action
	
	
	//-- Locators --//
	
	// Same as drver.findElement(By.id ~)
	@AndroidFindBy(id="come.androidsample.generalstore:id/nameField")
	private WebElement nameField;
	
	@AndroidFindBy(xpath="//android.widget.RadioButton[@text='Female']")
	private WebElement femaleOption;
	
	
	@AndroidFindBy(xpath="//android.widget.RadioButton[@text='Male']")
	private WebElement maleOption;
	
	@AndroidFindBy(id="android:id/text1")
	private WebElement countrySelection;
	
	//-- Actions --//
	
	public void setNameField(String name) {
		nameField.sendKeys(name);
		androidDriver.hideKeyboard();
	}
	
	public void setGender(String gender) {
		if(gender.contains("female"))
			femaleOption.click();
		else
			maleOption.click();
	}

}
