package com.obs.genericutility;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
/**
 *  * This class contains all the reusable methods for Javascript execution
 * @author achar
 *
 */
public class JavaScript {

	JavascriptExecutor j=null;
	/**
	 * This constructor will initialize Javascript instance
	 * @param driver
	 */
	public JavaScript(WebDriver driver) {
		initializeJavascript(driver);
	}
	/**
	 * This method will initialize javascript instance 
	 * @param driver
	 */
		public void initializeJavascript(WebDriver driver) {
			 j=(JavascriptExecutor) driver;
		}
		/**
		 * This method will scroll the window to particular x location and y location
		 * @param driver
		 * @param x
		 * @param y
		 */
		public void scroll(WebDriver driver,int x,int y) {
		
		j.executeScript("window.scrollBy("+x+","+y+")");
	}
		/**
		 * This method will scroll the window to particular WebElement
		 * @param element
		 */
		public void scroll(WebElement element) {
			int y=element.getLocation().getY();
			j.executeScript("window.scrollBy(0,"+y+")");
		}
		/**
		 * This method will scroll the window to bottom of the page
		 */
		public void scrollBottom() {
			j.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		}
		/**
		 * This method will enter the value in the disabled WebElement
		 * @param id
		 * @param value
		 */
		public void enterValueDisabledElement(String id,String value) {
			j.executeScript("document.getElementByid("+id+").click("+value+")");
		}
		/**
		 * This method will click the disabled WebElement
		 * @param id
		 */
		public void clickDisabledElement(String id) {
			j.executeScript("document.getElementByid("+id+").click()");
		}
	}
