package com.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.ServerSocket;
import java.net.URL;
import java.util.Properties;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class BaseClass {
	
	public static AndroidDriver<AndroidElement>  driver;
	
	// Start Appium Server Programmatically
	
	public static AppiumDriverLocalService service;	
	
	public static AppiumDriverLocalService startServer()
	{
		boolean flag=	checkIfServerIsRunnning(4723);
		
	if(!flag)
	{
		
		service=AppiumDriverLocalService.buildDefaultService();
		service.start();
	}
		return service;
		
	}
	public static boolean checkIfServerIsRunnning(int port) {
		
		boolean isServerRunning = false;
		ServerSocket serverSocket;
		try {
			serverSocket = new ServerSocket(port);
			
			serverSocket.close();
		} catch (IOException e) {
			//If control comes here, then it means that the port is in use
			isServerRunning = true;
		} finally {
			serverSocket = null;
		}
		return isServerRunning;
	}
	
//------------------------------------------------------------------------------
	
	// Start Emulator 	
		public static void startEmulator() throws IOException, InterruptedException{
			
			Runtime.getRuntime().exec(System.getProperty("user.dir")+"\\src\\main\\java\\resourses\\startEmulator.bat");
			Thread.sleep(10000);
		}
	//--------------------------------------	
	
	public static  AndroidDriver<AndroidElement> capabilities(String appName) throws IOException, InterruptedException
	{
		
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\com\\utilities\\global.properties");
		Properties prop = new Properties();
		prop.load(fis);
		
		//Appium Config.
		File f = new File("src");
		File fs= new File(f,(String) prop.get(appName));
		DesiredCapabilities capabilities = new DesiredCapabilities();
	     
		//Read device name from properties file
				String deviceName = (String) prop.get("device");
				
				//if(deviceName.contains("Pixel"))
				if(deviceName.contains("Pixel3"))
				{
					startEmulator();
				}
		
	    capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel3");
	    capabilities.setCapability(MobileCapabilityType.APP, fs.getAbsolutePath());
	    
	    driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		
		return driver;
	}
	
	@AfterTest
	
	// Close Emulator & Appium Server
	public static void closeEmulatorAndKIllServer() throws IOException{
		
		// Close Emulator
		Runtime.getRuntime().exec("adb -s emulator-5554 emu kill");
		System.out.println("Emulator has Closed Successfully.");
		
		// Close Appium Server
		Runtime.getRuntime().exec("taskkill /F /IM node.exe");
		
		System.out.println("Appium Server has Closed Successfully.");
	}

}
