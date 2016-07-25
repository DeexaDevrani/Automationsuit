package com.zivame.mobile.sanity.scenarios;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;

public class learn {
	
	AndroidDriver<MobileElement> driver;
	
	@BeforeTest
	
	 public void setUp() throws MalformedURLException {	
	
	
	DesiredCapabilities cap= new DesiredCapabilities();
	
	cap.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
	cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Device");
	
	cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "100");
	
	driver=new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"),cap );
	
	driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS); 

}
	 @Test
  	 
	   public void VerifyValidLogin() {
		 
		 By userprofile=By.id("com.zivame.consumer:id/user_profile_name");
		 
		driver.findElement(userprofile).click();
				   		  
		
	}
			@AfterTest
			
			public void End()
			{
				  
			driver.quit(); 
				  
			}
		  
	}


