package com.zivame.mobile.sanity.scenarios;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.zivame.common.scenarios.BaseTest;
import com.zivame.android.application.KebbabMenuPage;
import com.zivame.android.application.LoginPage;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;

public class LoginTest extends BaseTest {

//public class LoginTest  {
	
	AndroidDriver<MobileElement> driver;
	String expectedusername = "dd test";
	

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
		  
		  
		  
		 KebbabMenuPage menu=new KebbabMenuPage(driver);
		 menu.userProfile();
		 
		 LoginPage Zlogin=new LoginPage(driver);
		 
		 Zlogin.Zivamelogin();
		 String actualusername = Zlogin.ZivameloginScreen();
		 
		 System.out.println(" actual user name is = " + actualusername);
		 
		 System.out.println("Inside VerifyValidLogin() method, user name should be matched");
		 expectedusername = "dd test";
	      AssertJUnit.assertEquals(actualusername, expectedusername, "Valid Login testcase passed");
		 			  
	  }
	  
		@AfterTest
		
		public void End()
		{
			  
		driver.quit(); 
			  
		}
	  
}