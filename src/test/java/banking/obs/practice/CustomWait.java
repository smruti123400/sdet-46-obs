package banking.obs.practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CustomWait {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement ele = driver.findElement(By.xpath(null));
		
		
		
		int pollingtime = 1000;
		int duration = 10;
		int count=0;
		while(count<duration) {
			try {
				ele.click();
				break;
			}
			catch(Exception e) {
				Thread.sleep(pollingtime);
				count++;
			}
		}
	}

}
