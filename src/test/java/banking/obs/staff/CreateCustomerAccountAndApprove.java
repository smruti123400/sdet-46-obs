package banking.obs.staff;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.obs.genericutility.BaseClass;
import com.obs.genericutility.Constant;
import com.obs.genericutility.ExcelUtility;
import com.obs.genericutility.PropertyFileUtility;
import com.obs.genericutility.SelectUtility;
import com.obs.genericutility.Waitutility;
import com.obs.genericutility.Webdriverutility;
import com.obs.genericutility.Javautility;
import com.obs.genericutility.Popup;
import com.obs.genericutility.Verificationutility;
import com.obs.genericutilityenum.Propertyfile;
import com.obs.genericutilityenum.excel;

import banking.onlinebankingsystem.CommonStaffTab;
import banking.onlinebankingsystem.CommonTabs;
import banking.onlinebankingsystem.CreateAccAttr;
import banking.onlinebankingsystem.CustomerDetailsPage;
import banking.onlinebankingsystem.HomePage;
import banking.onlinebankingsystem.OnlineAccountOpeningForm;
import banking.onlinebankingsystem.PendingCustomerPage;
import banking.onlinebankingsystem.StaffHomePage;
import banking.onlinebankingsystem.StaffPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateCustomerAccountAndApprove extends BaseClass {

	@Test(groups = "smoketesting")
	public  void createCustomerAccountAndApprove() throws IOException {

		Map<String, String> map = excelutilty.getExcelData("CreateCustomerAndApproveByStaffTest","staffmodule" );
System.out.println(map);
excelutilty.closeWorkBook();
//creating object using pom classes
HomePage homePage=new HomePage(driver);
OnlineAccountOpeningForm o= new OnlineAccountOpeningForm(driver);
StaffPage staffPage=new StaffPage(driver);
StaffHomePage staffhomePage=new StaffHomePage(driver);
PendingCustomerPage pendingCustomerPage=new PendingCustomerPage(driver);
CustomerDetailsPage customerDetailspage=new CustomerDetailsPage(driver);




homePage.getFundTransferOrOpenAccntOrApplyDebitCard(CommonTabs.OPEN_ACCOUNT);

String actual=driver.getTitle();
String expected="Registration Form";
Assert.assertEquals(actual, expected);


o.registerAccount(map);

WebElement gender =o.genderAction();
selectu.initializeSelect(gender);
  selectu.selectByValue1(map.get("gender"));
  o.dobAction().click();
  o.dobAction().sendKeys(map.get("dob"));

     WebElement state =o.stateAction();
     selectu.initializeSelect(state);
	 selectu.selectByVisibleText(map.get("state"));
	   WebElement city = o.cityAction();
	     selectu.initializeSelect(city);
	     selectu.selectByVisibleText(map.get("city"));

         WebElement accountype =   o.accTypeAction();
        selectu.initializeSelect(accountype);
         selectu.selectByVisibleText(map.get("acctype"));
        o.submitAction();
        o.confirmAction();
           
				                   webdriverutility.alerta(driver);
				                  
				                 String txt1 = webdriverutility.getAlertMessage();
				               String Appnum = javautil.getAcnoFromAlertString(txt1);
				                      System.out.println("Application number is "+Appnum);
				                        
				                        webdriverutility.acceptAlert();
				                homePage.getStafflogin();
				                String actual2 = driver.getTitle();
				                String expected2="Staff Page";
				                    Assert.assertEquals(actual2, expected2);
				                  
				                     
				                       staffPage.setStaffLogin(propertyfileutility);
				                   	
				                      
				                       staffhomePage.clickOnStaffHomePage(CommonStaffTab.APPROVE_PENDING_ACC);
				                       String actual3 = driver.getTitle();
				                       String expected3="Pending Customers";
				                       Assert.assertEquals(actual3, expected3);
				                      
				                      
				                      pendingCustomerPage.approveCustomer(Appnum);
				                      
				                     String txt2 = webdriverutility.getAlertMessage();
					                 String Accnum = javautil.getAcnoFromAlertString(txt2);
				                        System.out.println("Account number is "+Accnum);
				                      
				                         webdriverutility.acceptAlert();
				                    
				                       homePage.getHomePage();
				                     String  actual4=driver.getTitle();
				                     String  expected4="Online Banking System";
				                       Assert.assertEquals(actual4, expected4);
				                     
				                       homePage.getStafflogin();
				                      
				                       staffhomePage.clickOnStaffHomePage(CommonStaffTab.VIEW_CUSTOMER_BY_AC);
				                       customerDetailspage.getCustomerDetails(Accnum);
				                       homePage.close();
				                     //  driver.close();
				
			}

			}

				           
				           
				           
