package banking.obs.customer;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
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
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.obs.genericutility.Action;
import com.obs.genericutility.BaseClass;
import com.obs.genericutility.Constant;
import com.obs.genericutility.ExcelUtility;
import com.obs.genericutility.PropertyFileUtility;
import com.obs.genericutility.Waitutility;
import com.obs.genericutility.Webdriverutility;
import com.obs.genericutilityenum.Propertyfile;

import banking.onlinebankingsystem.Acountholderregisterpage;
import banking.onlinebankingsystem.Applydebitcard;
import banking.onlinebankingsystem.CustomerDetailsPage;
import banking.onlinebankingsystem.CustomerLogin;
import banking.onlinebankingsystem.HomePage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class AplyDebitcardAndRegd extends BaseClass{

	@Test(groups = "smoketesting")
	
	public void AplyDebitcardAndRegd() throws IOException {
	
		Map<String, String> map = excelutilty.getExcelData("ApplyDebitCardAndRegisterForIBTest","staffmodule" );
		
System.out.println(map);

		Applydebitcard applydebitcard =new Applydebitcard(driver);
		HomePage homepage=new HomePage(driver);
		CustomerLogin customerlogin =new CustomerLogin(driver);
		Acountholderregisterpage regdpage = new Acountholderregisterpage(driver);
		applydebitcard.debitcard();
		applydebitcard.getdebitcarddat(map);

		webdriverutility.alerta(driver);
		webdriverutility.acceptAlert();
	
				 homepage.homebtn();
		    
				 homepage.getInternetBanking(act);
		  
				 homepage.getibReg();
		       
	       
	        regdpage.registerpage(map);
	     
	        webdriverutility.alerta(driver);
	        webdriverutility.getAlertMessage();
	        webdriverutility.acceptAlert();
		      
	        homepage.homebtn();
	        homepage.getInternetBanking(act);
		 
	        homepage.getiLogin();
		          
		    
		          customerlogin.customerloginmet(map);
		          customerlogin.statement();
		          customerlogin.logout();
		          homepage.close();
		        // driver.close();
	}
}




		
