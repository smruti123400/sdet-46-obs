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

import com.obs.genericutility.Action;
import com.obs.genericutility.Constant;
import com.obs.genericutility.ExcelUtility;
import com.obs.genericutility.PropertyFileUtility;
import com.obs.genericutility.Webdriverutility;
import com.obs.genericutilityenum.Propertyfile;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ChangePasswordLoginByNewpwd {

	public static void main(String[] args) throws IOException {

		PropertyFileUtility propertyfile=new PropertyFileUtility();
		String url=	propertyfile.getPropertyData(Propertyfile.url);
		String username=propertyfile.getPropertyData(Propertyfile.staffun);
		String password=propertyfile.getPropertyData(Propertyfile.staffpwd);
	
      System.out.println(url);
      System.out.println(username);
      System.out.println(password);
      
      ExcelUtility excelut= new ExcelUtility(Constant.TEST_EXCEL_FILE_PATH);
    
    Map<String, String> map = excelut. getExcelData("ChangepwAndLoginBYNewPwTest", "StaffModule");
      
      
      
      
      
  /**    String exptname = "ChangepwAndLoginBYNewPwTest" ;
		DataFormatter df = new DataFormatter();
		FileInputStream fis1 = new FileInputStream("./src/main/resources/testcases/classpractise.xlsx");
		Workbook wb = WorkbookFactory.create(fis1);
		Sheet sheet = wb.getSheet("StaffModule");
		int rowcount = sheet.getLastRowNum();
		Map<String, String> map= new HashMap<String, String>();
		for (int i= 1;i<=rowcount;i++) {
			String tsname = df.formatCellValue(sheet.getRow(i).getCell(0));
			if(tsname.equals(exptname)) {
				for(int j=1;j<sheet.getRow(i).getLastCellNum();j++) {
					 String key = df.formatCellValue(sheet.getRow(i).getCell(j));
					String value = df.formatCellValue(sheet.getRow(i+1).getCell(j));
					map.put(key, value);
					
				}
				break;
			}
		}**/
System.out.println(map);

Webdriverutility webutilty=new Webdriverutility();
WebDriver driver = webutilty.launchBrowser("chrome");
webutilty.maximize();
webutilty.launchApplication(url);



 //     WebDriverManager.chromedriver().setup();
	//	WebDriver driver= new ChromeDriver();
	//	driver.manage().window().maximize();
	//	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
    //  driver.get(url);
     WebElement target = driver.findElement(By.xpath("//a[contains(text(),'Internet Banking')]"));
     
     
     Action act = new Action();
     act.initializeAction(driver);
     act.mouseHover(target);
     
     
    // Actions ac=new Actions(driver);
  //   ac.moveToElement(target).perform();
     
     driver.findElement(By.xpath("//li[contains(text()='Login')]")).click();
     
     driver.findElement(By.name("customer_id")).sendKeys(map.get("customer_id"));
     driver.findElement(By.name("password")).sendKeys(map.get("password"));
     driver.findElement(By.name("login-btn")).click();
     
     driver.findElement(By.xpath("//li[text()='Change Password']")).click();
     
     driver.findElement(By.name("oldpass")).sendKeys(map.get("oldpass"));
     driver.findElement(By.name("cnfrm")).sendKeys(map.get("cnfrm"));
     driver.findElement(By.name("newpass")).sendKeys(map.get("newpass"));
     driver.findElement(By.name("change_pass")).click();
     
     webutilty.alerta(driver);
     webutilty.getAlertMessage();
     webutilty.acceptAlert() ;
     
     
     
   //  Alert a = driver.switchTo().alert();
   //     a.getText();
   //  a.accept();
     
     driver.findElement(By.name("logout_btn")).click();
     
     driver.findElement(By.name("customer_id")).sendKeys(map.get("customer_id"));
     driver.findElement(By.name("password")).sendKeys(map.get("password"));
     driver.findElement(By.name("login-btn")).click();
     driver.close();

}
}

