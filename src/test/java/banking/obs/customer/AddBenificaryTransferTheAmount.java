package banking.obs.customer;
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
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.obs.genericutility.Action;
import com.obs.genericutility.BaseClass;
import com.obs.genericutility.Constant;
import com.obs.genericutility.ExcelUtility;
import com.obs.genericutility.PropertyFileUtility;
import com.obs.genericutility.SelectUtility;
import com.obs.genericutility.Waitutility;
import com.obs.genericutility.Webdriverutility;
import com.obs.genericutility.Verificationutility;
import com.obs.genericutilityenum.Propertyfile;

import banking.onlinebankingsystem.AddbenificaryAndtheamount;
import banking.onlinebankingsystem.CustomerLogin;
import banking.onlinebankingsystem.HomePage;
import banking.onlinebankingsystem.TransferAmount;
import io.github.bonigarcia.wdm.WebDriverManager;

public class AddBenificaryTransferTheAmount extends BaseClass {
	

@Test(groups = "smoketesting")
public void addBenificaryTransferTheAmount() throws IOException {
     Map<String, String> map = excelutilty.getExcelData("AddBeneficiaryAndTransferFundTest","StaffModule" );
	
	System.out.println(map);

	

	HomePage homepage= new HomePage(driver);

homepage.getInternetBanking(act);
	
		  homepage.getiLogin();
		  SoftAssert s =new SoftAssert();

		  String actua=driver.getTitle();
		  String expected="Login Page";
		  s.assertEquals(actua, expected);

	      
			
			CustomerLogin customerLogin=new CustomerLogin(driver);
			customerLogin.customerloginmet(map);
	          
			String actua1=driver.getTitle();
			  String expected1="My Profile";
			  s.assertEquals(actua1, expected1);
		
			homepage.fundtransfer();
	       
			AddbenificaryAndtheamount abatm=new AddbenificaryAndtheamount(driver) ;
			
			abatm.addbenificary();
				abatm.benificaryDetails(map,selectu);
				abatm.addbenificiarybtns();
				webdriverutility.alerta(driver);
				webdriverutility.acceptAlert();
          
              abatm.fundtransfer();
              
              TransferAmount tansferamount= new TransferAmount(driver);
              tansferamount.transfermoney(map, selectu);   
           // driver.close();
              homepage.close();
s.assertAll();
	}

}
