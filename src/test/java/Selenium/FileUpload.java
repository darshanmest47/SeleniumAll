package Selenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import io.github.bonigarcia.wdm.WebDriverManager;

public class FileUpload {
	
	WebDriver driver = null;
	WebDriverWait wait=null;
	@BeforeClass
	public void beforeClass() {
		 String url = "https://the-internet.herokuapp.com/upload";
		 WebDriverManager.chromedriver().setup();
		 ChromeOptions options = new ChromeOptions();
		 options.addArguments("--headless=new");
		 driver = new ChromeDriver(options);
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
	public void firstTest() throws InterruptedException {
		  System.out.println("Test Method");
		  WebElement uploadButton = driver.findElement(By.cssSelector("#file-upload"));
		  wait.until(ExpectedConditions.visibilityOf(uploadButton));
		  uploadButton.sendKeys("C:\\Users\\DELL\\Downloads\\Darshan_Resume_2026.docx");
		  
		  WebElement submitButton = driver.findElement(By.cssSelector("#file-submit"));
		  wait.until(ExpectedConditions.visibilityOf(submitButton));
		  submitButton.click();
		  
		  WebElement fileUploadMessage = driver.findElement(By.xpath("//div/h3[contains(text(),'File Uploaded!')]"));
        Assert.assertTrue(fileUploadMessage.isDisplayed()); 
        Thread.sleep(5000);
	}
	
	@AfterClass
	public void afterClass() {
		  System.out.println("After Class");
		driver.quit();
	}

}
