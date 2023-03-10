package banking.onlinebankingsystem;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.obs.genericutility.Webdriverutility;

public class CustomerDetailsPage {
	@FindBy(name = "account_no")
	private WebElement custmerAcno;
	@FindBy(name = "submit_view")
	private WebElement submitBtn;
	@FindBy(name="logout_btn")
	private WebElement logoutBtn;
	public CustomerDetailsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
    
    public void getCustomerDetails(String accnum) {
    	custmerAcno.sendKeys(accnum);
    	submitBtn.click();
    	logoutBtn.click();
    }
}
