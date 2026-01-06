package Selenium;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import io.github.bonigarcia.wdm.WebDriverManager;


public class AuthPopUp {
	WebDriver driver = null;
	WebDriverWait wait=null;
	
	@BeforeClass
	public void beforeClass() {
		 String url = "https://admin:admin@the-internet.herokuapp.com/basic_auth";
		 WebDriverManager.chromedriver().setup();
		 driver = new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.get(url);
		 System.out.println("Before class");
	}
	
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("Before Method");
		wait = new WebDriverWait(driver,Duration.ofSeconds(5000));
	}
	
	@Test
	public void testMethod() {
		WebElement authMessage = driver.findElement(By.xpath("//div/p[contains(text(),'Congratulations!')]"));
		Assert.assertTrue(authMessage.isDisplayed());
	}
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
	


}
