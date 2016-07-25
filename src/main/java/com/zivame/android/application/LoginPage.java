package com.zivame.android.application;

import org.openqa.selenium.By;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class LoginPage {
	
	AndroidDriver<MobileElement> driver;

	public LoginPage (AndroidDriver<MobileElement> driver)

	{ 
		this.driver = driver; 
		
	}
	
	By zivamesignIn=By.id("com.zivame.consumer:id/signin_txtview");
	By email=By.id("com.zivame.consumer:id/signin_email");
	By password=By.id("com.zivame.consumer:id/signin_password");
	By signInSubmit=By.id("com.zivame.consumer:id/signin_tv");
	By username=By.id("com.zivame.consumer:id/user_profile_name");
	   
	   public void Zivamelogin(){
		driver.findElement(zivamesignIn).click();
		   
	   }
	   
	   public String ZivameloginScreen(){
			driver.findElement(email).sendKeys("plm@gmail.com");
			driver.findElement(password).sendKeys("qwerty");
			driver.findElement(signInSubmit).click();
			String usernametext = driver.findElement(username).getText();
			return usernametext;
		   }
	
}
