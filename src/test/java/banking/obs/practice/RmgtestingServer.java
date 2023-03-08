package banking.obs.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.mysql.cj.jdbc.Driver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RmgtestingServer {

	public static void main(String[] args) throws SQLException {
		String username = "rmgyantra";
		String pw = "rmgy@9999";
		String url = "http://rmgtestingserver:8084/";
		String projectname = "tyssproject-01";
		String projectmanager = "smruti ranjan";
		
		
		
		
		
	WebDriverManager.chromedriver().setup();
	Driver dbDriver=new Driver();
	DriverManager.registerDriver(dbDriver);
	Connection con = DriverManager.getConnection("jdbc:mysql://rmgtestingserver:3333/projects","root@%","root");
	Statement statement = con.createStatement();
	WebDriver driver=new ChromeDriver();
	
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	
	driver.get("url");
	driver.findElement(By.xpath("//label[text()='Username']/preceding-sibling::input")).sendKeys("username");
	driver.findElement(By.xpath("//label[text()='Password']/preceding-sibling::input")).sendKeys("pw");
	driver.findElement(By.xpath("//button[contains(text(),'Sign in')]")).click();
	driver.findElement(By.xpath("//a[text()='Projects']")).click();
		driver.findElement(By.xpath("//span[text()='Create Project']")).click();	
		driver.findElement(By.name("projectName")).sendKeys("projectname");
		driver.findElement(By.name("createdBy")).sendKeys("projectmanager");
		WebElement tar = driver.findElement(By.xpath("(//select[@name='status'])[last()]"));
Select s=new Select(tar);
s.selectByValue("Created");
driver.findElement(By.xpath("//input[@value='Add Project']")).click();













driver.findElement(By.xpath("//a[text()='Logout']")).click();

	}

}
