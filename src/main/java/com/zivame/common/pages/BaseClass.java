package com.zivame.common.pages;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.zivame.utils.CommonUtils;

public class BaseClass {
	
	public AndroidDriver<MobileElement> driver;
	public String testMode;
	
	
	public BaseClass (AndroidDriver<MobileElement> adriver, String TEST_MODE)
	{
		driver = adriver;
		testMode = TEST_MODE;
		
		System.out.println("Inside BaseClass Constructor "+testMode);
	}
	
	
	public WebElement iterateList_find(List <WebElement> elements , String searchAttribute, String searchString )
	{
		int listSize = elements.size();
		WebElement foundElement=null;
		driver.manage().timeouts().implicitlyWait(CommonUtils.IMPLICIT_WAIT_TIME, TimeUnit.SECONDS);
		for (int iter=0; iter <listSize; iter++)
		{
			if (elements.get(iter).getAttribute(searchAttribute).equalsIgnoreCase(searchString))
			{
				foundElement = elements.get(iter);
				break;
			}
		}
		
		if (foundElement!=null)
		{
			return foundElement ;
		}
		else
		{
			return null;
		}
		
	}
	
	public By readObjectLoc(String key)
	{
		//System.out.println("Inside read Object Loc "+key);
		By loc=null;
		String str = null;
		
		str = CommonUtils.readUIProps(key,this.testMode);
		
		String[] value = str.split("::");			
		System.out.println("Locate By value is "+value[0]);
		 switch (value[0])
		 {
		 	case "By.className": loc = By.className(value[1]); break;
		 	case "By.id":  	/* if (this.testMode.equalsIgnoreCase("APP"))
		 						{
		 							String idExtn = commonUtils.readUIProps("appium.id.ext");
		 							String locn = idExtn.trim()+value[1].trim();
		 							loc = By.id(locn);
		 						}
		 						else
		 						{*/
		 							loc = By.id(value[1].trim());break;
		 						//}
		 						
		 	case "By.name" : loc = By.name(value[1].trim());break;
		 	case "By.xpath" : loc = By.xpath(value[1].trim());break;
		 									 
		 							//By abc = By.xpath("//android.widget.TextView[contains(@text,'Topics')]");
		 	case "MobileBy.AndroidUIAutomator": loc = MobileBy.AndroidUIAutomator(value[1]); break;
		 }
	
	
		 str=null;
		 value=null;
		 return(loc);
	}	
		
	public WebElement readObject(By key)
	{
		//System.out.println("Inside read Object ");
		WebElement element ; 
		try
		{
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			element = driver.findElement(key);
			return (element);
		}
		catch(Exception ElementNotFoundException)
		{
			System.out.println("Element Not found!! Please check object identifier and try again");
			return (null);
		}
		
	}
	
	public List <MobileElement> readObjectList(By key)
	{
		List<MobileElement> elList;
		try 
		{
			driver.manage().timeouts().implicitlyWait(CommonUtils.IMPLICIT_WAIT_TIME, TimeUnit.SECONDS);
			elList = driver.findElements(key);
			return elList;
		}
		catch(Exception ElementNotFoundException)
		{
			System.out.println("Element Not found!! Please check object identifier and try again");
			return (null);
		}
			
	}
	
	public MobileElement mobileElementConverter (WebElement element)
	{
		MobileElement mobElement = (MobileElement) element;
		return (mobElement);
	}
	
	public String readObjectAttrib(String key)	
	{
		String str = CommonUtils.readUIProps(key,this.testMode);
		return str;
		
	}

	public void ramdomTap(int x,int y)
	{
		  TouchAction action = new TouchAction(driver);
		   action.tap(x, y).perform();
	}
		
}