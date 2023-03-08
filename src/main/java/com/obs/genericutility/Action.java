package com.obs.genericutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Action {
/**
 * this method is used to intialize action class
 */
	Actions a=null;
	public void initializeAction(WebDriver driver) {
		a=new Actions(driver);
	}
/**
 * this method is used to move the mouse pointer
 * @param element
 */
	public void mouseHover(WebElement element) {
		a.moveToElement(element).perform();

	}
/**
 * this method is used to drag and drop
 * @param src
 * @param dest
 */
	public void dragAndDropWebElement(WebElement src,WebElement dest) {
		a.dragAndDrop(src, dest).perform();
	}
/**
 * this method is used for doubleclick the element
 * @param element
 */
	public void doubleClickWebElement(WebElement element) {
		a.doubleClick(element).perform();
	}
	
	 /**
	  * this method is used to right click on element
	  * @param element
	  */
	public void contextClickWebElement(WebElement element) {
		a.contextClick(element).perform();
	}
}


