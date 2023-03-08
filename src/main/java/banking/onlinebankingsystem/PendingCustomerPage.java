package banking.onlinebankingsystem;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PendingCustomerPage {
	@FindBy(name = "application_no")
	private WebElement applicationNumberTxtField;
	@FindBy(name="search_application")
	private WebElement searchBtn;
	@FindBy(xpath="//input[@name='approve_cust']")
	private WebElement appBtn;
	 public PendingCustomerPage(WebDriver driver) {
		 PageFactory.initElements(driver, this);
	 }
    public void approveCustomer(String appnum) {
    	applicationNumberTxtField.sendKeys(appnum);
    	searchBtn.click();
    	appBtn.click();
    }
}
