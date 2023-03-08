package banking.onlinebankingsystem;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.obs.genericutility.PropertyFileUtility;
import com.obs.genericutilityenum.Propertyfile;

public class StaffPage {
@FindBy(name = "staff_id")
private WebElement staffIdTextField;
@FindBy(name="password")
private WebElement passwordTextBox;
@FindBy(name="staff_login-btn")
private WebElement staffLoginBtn;
public StaffPage(WebDriver driver) {
	PageFactory.initElements(driver,this);
}

public void setStaffLogin(PropertyFileUtility p) {
	staffIdTextField.sendKeys(p.getPropertyData(Propertyfile.staffun));
	passwordTextBox.sendKeys(p.getPropertyData(Propertyfile.staffpwd));
	staffLoginBtn.click();
}
}
