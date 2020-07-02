package com.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ProductPage {

public ProductPage(AndroidDriver<AndroidElement> driver){
	
	PageFactory.initElements(new AppiumFieldDecorator(driver), this);
}

@AndroidFindBy(xpath="//*[@text='ADD TO CART']")
public List<WebElement> product1;

@AndroidFindBy(xpath="//*[@text='ADD TO CART']")
public List<WebElement> product2;

@AndroidFindBy(id="com.androidsample.generalstore:id/appbar_btn_cart")
public WebElement cartBtn;

@AndroidFindBy(id="com.androidsample.generalstore:id/productPrice")
public List<WebElement> amount1;

@AndroidFindBy(id="com.androidsample.generalstore:id/productPrice")
public List<WebElement> amount2;

@AndroidFindBy(id="com.androidsample.generalstore:id/totalAmountLbl")
public WebElement toalAmount;

}