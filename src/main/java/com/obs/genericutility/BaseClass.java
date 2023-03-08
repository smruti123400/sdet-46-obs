package com.obs.genericutility;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.obs.genericutilityenum.Propertyfile;
import com.wc.reportutility.ScreenshotUtility;

import banking.onlinebankingsystem.OnlineAccountOpeningForm;

public class BaseClass extends BaseClassDeclaration {
	
	/**
	 * 
	 */
//	@BeforeTest

	@BeforeClass(alwaysRun=true)
		
	public void intializationsetup() {
		propertyfileutility = new PropertyFileUtility();
		excelutilty=new ExcelUtility(Constant.TEST_EXCEL_FILE_PATH);
	    webdriverutility= new Webdriverutility();
		waitutility=new Waitutility();
		verification=new Verificationutility();
		selectu=new SelectUtility();
		javautil=new Javautility();
		act=new Action();
		
		browser=propertyfileutility.getPropertyData(Propertyfile.browser);
		url = propertyfileutility.getPropertyData(Propertyfile.url);
        username = propertyfileutility.getPropertyData(Propertyfile.staffun);
		password = propertyfileutility.getPropertyData(Propertyfile.staffpwd);
		
	}
	/**
	 * 
	 * @throws IOException
	 */
@BeforeMethod(alwaysRun=true)
public void setup() throws IOException  {
	
driver=webdriverutility.launchBrowser(browser);
screenshotutility=new ScreenshotUtility(driver);
webdriverutility.launchApplication(url);
webdriverutility.maximize();
waitutility.setImplicitWait(driver, 10);
}
/**
 * 
 */
@AfterMethod(alwaysRun=true)
public void teardown() {
	
	
}

@AfterClass(alwaysRun=true)

//@AfterTest
public void intializationteardown() throws IOException {
	
	excelutilty.closeWorkBook();
}

}
