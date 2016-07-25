package com.zivame.common.scenarios;

import java.io.File;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class Appiumstartstop {
	
	AndroidDriver<MobileElement> driver;

	public static void main(String[] args)  {
		
		
		AppiumDriverLocalService service= AppiumDriverLocalService.buildService(new AppiumServiceBuilder()
				                                   .usingDriverExecutable(new File("C:\\Program Files\\nodejs\\node.exe"))
				                                   .withAppiumJS(new File("C:\\Program Files\\Appium\\node_modules\\appium\\bin\\appium.exe"))
				                                   .withLogFile(new File("C:\\appiumlogs\\logs.txt")));
		service.start();
		
		DesiredCapabilities capabilities = new DesiredCapabilities(); 
		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "testng");
		capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "");
		capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "4.4.2"); 
		
		capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.zivame.consumer"); 
		capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, ".splashActivity"); 
		

	}

}
