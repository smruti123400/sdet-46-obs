package com.obs.genericutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
/**
 * 
 * @author achar
 *
 */
public class frameutility {
	/**
	 * This method will switch the frame using index
	 * @param driver
	 * @param index
	 */
	public void switchFrame(WebDriver driver,int index) {
		driver.switchTo().frame(index);
	}
	/**
	 * This method will switch the frame using frame id
	 * @param driver
	 * @param id
	 */
	public void switchFrame(WebDriver driver,String id) {
		driver.switchTo().frame(id);
	}
	/**
	 * This method will switch the frame using WebElement frame
	 * @param driver
	 * @param frame
	 */
	public void switchFrame(WebDriver driver,WebElement frame) {
		driver.switchTo().frame(frame);
	}
}
