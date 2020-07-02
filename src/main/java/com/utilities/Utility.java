package com.utilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class Utility {
	
	AndroidDriver<AndroidElement> driver;
	
	public Utility(AndroidDriver<AndroidElement> driver){
		
		this.driver= driver;
	}
	
	public void scrollTest(String text){
	
	driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\""+text+"\"))");

}

}
