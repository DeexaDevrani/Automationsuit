package com.zivame.android.application;

import org.openqa.selenium.By;

import com.zivame.common.pages.BaseClass;

/**
 * @author deexa
 *
 */

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class KebbabMenuPage extends BaseClass{
	
//	AndroidDriver<MobileElement> driver;

		public KebbabMenuPage (AndroidDriver<MobileElement> driver)

		{ 
			
			super(adriver, TEST_MODE);
			System.out.println("Inside KebbabMenuPage Constructor");
			
//			this.driver = driver; 
			
		}
		
		
		By userprofile = readObjectLoc("Kebbab.user.profile.tab");
	
	   //By userprofile=By.id("com.zivame.consumer:id/user_profile_name");
	   
	   public void userProfile(){
		driver.findElement(userprofile).click();
		   
	   }
	   	

}
