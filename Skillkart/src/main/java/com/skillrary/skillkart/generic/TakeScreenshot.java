package com.skillrary.skillkart.generic;


import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TakeScreenshot
{
	public static String takePageScreenshot(WebDriver driver, String testCaseName)
	{
		String dateAndTime = LocalDateTime.now().toString().replace(':', '-');
		TakesScreenshot ts = (TakesScreenshot)driver;
		File srcFile=ts.getScreenshotAs(OutputType.FILE);
		String photPath="./errorshots/"+testCaseName+dateAndTime+".png";
		File destFile = new File(photPath);
		try 
		{
			FileUtils.copyFile(srcFile,destFile);
		} 
		catch(IOException e)
		{
			e.printStackTrace();
		}
		return photPath;
	}
	
	public static String takeElementScreenshot(WebElement target, String testCaseName)
	{
		String dateAndTime = LocalDateTime.now().toString().replace(':', '-');
		File srcFile=target.getScreenshotAs(OutputType.FILE);
		String photPath="./errorshots/"+testCaseName+dateAndTime+".png";
		File destFile = new File(photPath);
		try 
		{
			FileUtils.copyFile(srcFile,destFile);
		} 
		catch(IOException e)
		{
			e.printStackTrace();
		}
		return photPath;
	}
}
