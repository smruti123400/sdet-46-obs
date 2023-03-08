package com.obs.genericutility;

import java.awt.Dimension;
import java.io.IOException;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.google.j2objc.annotations.Property;

import io.github.bonigarcia.wdm.WebDriverManager;
/**
 * 
 * @author achar
 *
 */
public class Webdriverutility {
	/**
	 * This class contains reusable methods to handle web driver operations
	 */

	private WebDriver driver;

	/**
	 * This method will launch the browser
	 * 
	 * @param url
	 * @return
	 * @throws IOException
	 */
	public WebDriver launchBrowser(String browser) throws IOException {

		switch (browser) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		case "edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;
		case "ie":
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
		default:
			System.out.println("Enter proper key '" + browser + "'");
			break;
		}
		return driver;
	}


			/**
			 * This class contains reusable methods to handle web driver operations
			 */

			private WebDriver driver1;

			/**
			 * This method will launch the browser
			 * 
			 * @param url
			 * @return
			 * @throws IOException
			 */
			public WebDriver launchBrowser1(String browser) throws IOException {

				switch (browser) {
				case "chrome":
					WebDriverManager.chromedriver().setup();
					driver = new ChromeDriver();
					break;
				case "firefox":
					WebDriverManager.firefoxdriver().setup();
					driver = new FirefoxDriver();
					break;
				case "edge":
					WebDriverManager.edgedriver().setup();
					driver = new EdgeDriver();
					break;
				case "ie":
					WebDriverManager.iedriver().setup();
					driver = new InternetExplorerDriver();
					break;
				default:
					System.out.println("Enter proper key '" + browser + "'");
					break;
				}
				return driver;
			}
			

				/**
				 * this method is used to call the url
				 * @param url
				 * @throws IOException
				 */
				public void launchApplication(String url) throws IOException {
					driver.get(url);
				}

				/**
				 * this method is used to maximize the browser
				 * @param driver
				 */
				public void maximize() {
					driver.manage().window().maximize();
				}

				/**
				 * This method is used to close the tab
				 * 
				 * @throws IOException
				 */
				public void closeTab() throws IOException {
					driver.close();
				}
				/**
				 * this method is used to intialize alertpopup
				 * @param driver
				 */
				public  void alerta(WebDriver driver) {
					driver.switchTo().alert();
				}
				/**
				 * this method is used to accept alertpopup
				 */
				public void acceptAlert() {
					driver.switchTo().alert().accept();
				}
/**
 * this method is used to dismiss alertpopup
 */
				public void dismissAlert() {
					driver.switchTo().alert().dismiss();
				}
/**
 * this method is used to get the message
 * @return
 */
				public String getAlertMessage() {
					return driver.switchTo().alert().getText();
				}

				public void switchFrame(int index) {
					driver.switchTo().frame(index);
				}

				public void switchFrame(String nameOrId) {
					driver.switchTo().frame(nameOrId);
				}

				public void switchFrame(WebElement frameElement) {
					driver.switchTo().frame(frameElement);
				}

				public void switchbackFrame() {
					driver.switchTo().defaultContent();
				}

				public void scrollBar(int x, int y) {

					JavascriptExecutor js = (JavascriptExecutor) driver;
					js.executeScript("window.scrollBy(" + x + "," + y + ")");
				}

				public void performClickOpertion(WebElement element) {

					JavascriptExecutor js = (JavascriptExecutor) driver;
					js.executeScript("arguments[0].click();", element);
				}

				public boolean switchTabs(String expPageTitle) {

					Set<String> windows = driver.getWindowHandles();
					boolean found = false;
					for (String window : windows) {
						driver.switchTo().window(window);
						if (driver.getTitle().contains(expPageTitle)) {
							found = true;
							break;
						}
					}
					return found;
				}

				public void switchBackToParent(String parentWindow) {

					driver.switchTo().window(parentWindow);

					driver.manage();
					driver.navigate();
				}

				public String getCurrentUrl() {
					return driver.getCurrentUrl();
				}
				public String getPageSource() {
					return driver.getPageSource();
				}

				public String getPageTitle() {
					return driver.getTitle();
				}

				public void fullscreen() {
					driver.manage().window().fullscreen();
				}

				public void resizeBrowser(int width, int height) {
					driver.manage().window().setSize(null);
				}
public void customWaitMethod(int duration,int pollingtime,WebElement ele) throws InterruptedException {
	int count=0;

	while(count<duration) {
		try {
			ele.click();
			break;
		}
		catch(Exception e) {
			Thread.sleep(pollingtime);
			count++;
		}
}
				
				
				
				
}
}

		


