package banking.onlinebankingsystem;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StaffLogin {
	
	
	
public StaffLogin(WebDriver driver) {
	PageFactory.initElements(driver,this);
}

	@FindBy(name="staff_id")
	private WebElement staffid;
	
	
	@FindBy(name="password")
	private WebElement staffpwd;
	
	
@FindBy(name="staff_login-btn")
private WebElement loginbtn;




public WebElement getstaffid() {
	return staffid;
}
public WebElement getstaffpwd() {
	return staffpwd;
}

public WebElement getlogin() {
	return loginbtn;
}
}

