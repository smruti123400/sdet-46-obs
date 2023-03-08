package banking.onlinebankingsystem;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.fasterxml.jackson.core.sym.Name;
import com.obs.genericutility.SelectUtility;

public class TransferAmount {
	@FindBy (name = "beneficiary")
	private WebElement benficiaryname;
	
	@FindBy (name = "trnsf_amount")
	private WebElement transferamount;
	
	
	@FindBy (name = "fnd_trns_btn")
	private WebElement fndtransferbtn;
	
	@FindBy (id = "logout")
	private WebElement logoutbtn;
	
	
	 public TransferAmount(WebDriver driver) {
		 PageFactory.initElements(driver,this);
	 }
          
	 public void transfermoney(Map<String, String> map,SelectUtility selct){
		 transferamount.sendKeys(map.get("trnsf_amount")); 
		   selct.initializeSelect(benficiaryname);
           selct.selectByValue1(map.get("beneficiary_acno"));
           fndtransferbtn.click();
   		
           logoutbtn.click();
	 }
}
