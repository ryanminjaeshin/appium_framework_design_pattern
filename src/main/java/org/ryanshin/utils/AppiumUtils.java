package org.ryanshin.utils;

// common method used in both Android and IOS util
public class AppiumUtils {
	
	// remove $ and convert it to the double data type
	public Double getFormattedAmount(String amount) {
		double price = Double.parseDouble(amount.substring(1));
		return price;
	}

}
