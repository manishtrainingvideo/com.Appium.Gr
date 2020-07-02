package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class SignUpPage {
	
public SignUpPage (AndroidDriver<AndroidElement> driver){
		
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/nameField")
	public WebElement name;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/radioFemale")
	private WebElement femalbth;
	
	public WebElement getfemalbth(){
		
		return femalbth;
	}
	@AndroidFindBy(id="android:id/text1")
	private WebElement dropdown;
	
	public WebElement getdropdown(){
		
		return dropdown;
	}
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Austria']")
	public WebElement austria;
	
	@AndroidFindBy(id = "com.androidsample.generalstore:id/btnLetsShop")
	public WebElement letsShop;


}
