package com.wc.reportutility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.mysql.cj.Constants;
import com.obs.genericutility.Javautility;

public class ScreenshotUtility {
	//private WebDriver driver;
	TakesScreenshot t=null;
	/**
	 * This constructor will initialize the TakesScreenshot instance
	 * @param driver
	 */
	public ScreenshotUtility(WebDriver driver) {
		 t=(TakesScreenshot) driver;	
	}
/**
 * This generic method will take the screenshot
 * @return 
 */
public String getScreenshot(String testScriptName,Javautility javaUtility) {
	File src=t.getScreenshotAs(OutputType.FILE);
	File dest=new File(testScriptName+javaUtility.getCurrentStringDateTime()+".png");
	try {
		FileUtils.copyFile(src,dest);
	} catch (IOException e) {
		e.printStackTrace();
	}
	return dest.getAbsolutePath();
	
	
}
/**
 * This method will take the screenshot at particular WebElement
 * @param element
 * @param text
 * @param javaUtility
 * @return
 */
public String getScreenshot(WebElement element,String text,Javautility javaUtility) {
	File src=element.getScreenshotAs(OutputType.FILE);
	File dest = new File(text+javaUtility.getCurrentStringDateTime()+".png");
	try {
		FileUtils.copyFile(src, dest);
		
	} catch (IOException e) {
		e.printStackTrace();
	}
	return dest.getAbsolutePath();
	
}
public String getScreenshot() {
	String path=t.getScreenshotAs(OutputType.BASE64);
	return path;
	
	
}
}

