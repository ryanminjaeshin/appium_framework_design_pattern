package org.ryanshin.utils;

import org.openqa.selenium.WebElement;

import io.appium.java_client.android.AndroidDriver;

public class AndroidActions {
	
	AndroidDriver androidDriver;
	
	public AndroidActions(AndroidDriver androidDriver) {
		this.androidDriver = androidDriver;
	}
	
	public void longPressAction(WebElement ele) {}
	
	public void scrollToEndAction() {}
	
	public void scrollToText(String text) {System.out.println("WIP");}
	
	public void swipeAction(WebElement ele, String direction) {}

}
