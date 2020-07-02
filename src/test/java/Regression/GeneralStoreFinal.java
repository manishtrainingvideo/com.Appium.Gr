package Regression;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.pages.SignUpPage;
import com.utilities.BaseClass;
import com.utilities.Utility;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class GeneralStoreFinal extends BaseClass{
	
  @Test
  
  public void startExecution() throws IOException, InterruptedException{
	
	service= startServer();
	System.out.println("Appium Server Started.");
		
		
	
		AndroidDriver<AndroidElement> driver= capabilities("GeneralStoreApp");
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		
		SignUpPage sp= new SignUpPage(driver);
		
		sp.name.sendKeys("testname");
		sp.getfemalbth().click();
		
		sp.getdropdown().click();
		
		Utility u= new Utility(driver);
		u.scrollTest("Austria");
		
		sp.austria.click();
		
		
	}


}
