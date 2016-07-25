package com.zivame.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;
import java.util.Properties;

public class CommonUtils {
	
private static Properties prop = new Properties();
	
	public final static int EXPLICIT_WAIT_TIME = 120;
	public final static int IMPLICIT_WAIT_TIME = 10;
	public final static int SETUP_WAIT_TIME=300;
	public static Date date;
	public static void loadConfigProps(String fileName) throws IOException
	{
		
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\resources\\properties\\RunConfig..properties");
		prop.load(fis);	
		
	}
	
	public static String  readUIProps(String UIProp, String testMode) 
	{
		String fileName;
		//System.out.println(UIProp+"\t"+testMode);
		if(testMode.equalsIgnoreCase("APP"))
		{
			
			   fileName= "UIMap.properties";
		}
	

		else
		{
			fileName = "UIMap_Selendroid.properties";
			
		}
		
Boolean fileExists = isFilePresent(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\"+fileName);
		
		if (fileExists)
		{
					try
					{
						FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\"+fileName);
						prop.load(new InputStreamReader(fis, "UTF-8"));
									
						prop.getProperty(UIProp);
								
						fis.close();
						return null;
					
					}
					catch(IOException e)
					{
						System.out.println("Unable to read property from  UIProperties File!!");
						e.printStackTrace();
						return null;
						//throw new Exception("Unable to read property from  UIProperties File!!", e);
					}
		}
		else
		{
			System.out.println("Path to UIProperties File incorrect!!");
			return null;
		}		

		
	}
		
	
		
	public static boolean isFilePresent(String strFilePath) {
		try {
			if ((strFilePath).trim() == "")
			{
				System.out.println("The passed file path paramenter is blank");
				return false;
			} 
			else
			{
				File file = new File(strFilePath);
				boolean exists = file.exists();
				if (exists) 
				{
					return true;
				} 
				else
				{
					return false;
				}
			}
		} 
		
		catch (Exception e)
		{
			e.printStackTrace();
			return false;
		}

	}
	
	public static Long getCurrentTimeStamp() {
		date = new Date();
		long dtime = date.getTime();
		return dtime;	
	}

}
