package Selenium;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.*;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AllActions {
	
	WebDriver driver = null;
	WebDriverWait wait=null;
	String currentWindowId= null;
	
	@BeforeClass
	public void beforeClass() {
		 String url = "https://omayo.blogspot.com/";
		 WebDriverManager.chromedriver().setup();
		 driver = new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.get(url);
		 System.out.println("Before class");
	}
	
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("Before Method");
		wait = new WebDriverWait(driver,Duration.ofSeconds(10000));
	}
	
	public WebDriver getDriver() {
		return this.driver;
	}
	
	@Test(description = "Handling Multi Select dropdown" , priority=0 )
	public void firstTest() throws InterruptedException {
		WebElement multiSelect = driver.findElement(By.id("multiselect1"));
		Select select = new Select(multiSelect);
		List<WebElement> options = select.getOptions();
		if(select.isMultiple()) {
		for(WebElement option : options) {
						
			if(option.getText().equals("Volvo")) {
				option.click();
			}else if(option.getText().equals("Audi")) {
				option.click();
			}
		}
		}
	}
	
	
	
	@Test(description="Handling single select dropdown",priority = 1)
	public void secondTest() {
		WebElement singleSelect = driver.findElement(By.id("drop1"));
		Select select = new Select(singleSelect);
		List<WebElement> options = select.getOptions();
		if(!select.isMultiple()) {
			select.selectByVisibleText("doc 3");
		}

	}
	
	@Test(description = "Clicking on disable button using JS Executor",priority = 2)
	public void thirdTest() {
		WebElement disabledButton=null;
		try {
		 disabledButton = driver.findElement(By.xpath("//button[contains(text(),'Button1')]"));
			JavascriptExecutor js =   ((JavascriptExecutor)driver);
			js.executeScript("arguments[0].click();", disabledButton);
			System.out.println("Clicked on disabled element using javascript executor");
		}catch(Exception e) {
			System.out.println("In the Catch block as we are unable to perform click action on disabled button");

		}
		
	}
	
	@Test(description="Entering value in text box with JS Executor",priority=3)
	public void fourthTest() throws Exception{
		WebElement username = driver.findElement(By.xpath("//input[@name='userid']"));
		WebElement password = driver.findElement(By.xpath("//input[@name='pswrd']"));
		WebElement clear = driver.findElement(By.xpath("//input[@type='reset']"));
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView()",username);
		js.executeScript("arguments[0].value='abcd'", username);
		Thread.sleep(2000);
		js.executeScript("arguments[0].value='efgh'", password);
		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", clear);

	}
	
	@Test(description="Switching to JavaScript alert and accepting the same",priority = 4)
	public void fifthTest() throws Exception {
		WebElement button = driver.findElement(By.cssSelector("#alert1"));
		button.click();
		Alert alert = driver.switchTo().alert();
		System.out.println(alert.getText());
		Thread.sleep(3000);
		alert.accept();
	}
	
	@Test(description="Switching to JavaScript alert and dismissing the same",priority=5)
	public void sixthTest() throws Exception {
		WebElement button = driver.findElement(By.xpath("//input[@value='GetConfirmation']"));
		button.click();
		Alert alert = driver.switchTo().alert();
		System.out.println(alert.getText());
		Thread.sleep(3000);
		alert.dismiss();
	}
	
	@Test(description = "Entering value into prompt and accepting the alert",priority=6)
	public void seventhTest() throws Exception{
		WebElement prompt = driver.findElement(By.xpath("//input[@value='GetPrompt']"));
		prompt.click();
		Alert alert = driver.switchTo().alert();
		wait.until(ExpectedConditions.alertIsPresent());
		alert.sendKeys("abcd");
		Thread.sleep(3000);
		alert.accept();
		
	}
	
	@Test(description = "Switching into popup",priority = 7,groups = "window switching")
	public void eightTest() {
		WebElement popuplink = driver.findElement(By.xpath("//a[contains(text(),'Open a popup window')]"));
		popuplink.click();
		currentWindowId = driver.getWindowHandle();
		System.out.println("Current winodw id is "+currentWindowId);
		 Set<String> windows = driver.getWindowHandles();
         Set<String>hs = new LinkedHashSet<>();	
         hs.addAll(windows);
         
         for(String id : hs) {
        	 System.out.println("Current id is "+id);
        	 if(!id.equals(currentWindowId)) {
        		 driver.switchTo().window(id);
        		 System.out.println("Switched to the window successfully");
        		 if(driver.getCurrentUrl().contains("https://the-internet.herokuapp.com/windows/new")) {
        			 WebElement element = driver.findElement(By.xpath("//h3[contains(text(),'New Window')]"));
        			 Assert.assertTrue(element.getText().contains("New Window"));
        		 }
        		 
        	 }
         }
	}
	
	@Test(description = "Handling file upload",priority = 8,dependsOnMethods = "eightTest",groups = "window switching")
	public void ninthMethod() throws Exception {
		driver.switchTo().window(currentWindowId);
		WebElement uploadButton = driver.findElement(By.cssSelector("#uploadfile"));
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		js.executeScript("arguments[0].scrollIntoView()", uploadButton);
		uploadButton.sendKeys("C:\\Users\\DELL\\Downloads\\Darshan_Resume_2026 (1).pdf");
		Thread.sleep(5000);
	}
	
	@Test(description="Explicit wait and navigating backwards and page refresh",priority = 9,dependsOnGroups ="window switching" )
	public void tenthMethod() {
		WebElement dropdown = driver.findElement(By.xpath("//button[contains(text(),'Dropdown')]"));
		dropdown.click();
		WebElement flipkart = driver.findElement(By.xpath("//a[contains(text(),'Flipkart')]"));
		wait.until(ExpectedConditions.visibilityOf(flipkart));
		flipkart.click();
		wait.until(ExpectedConditions.urlContains("https://www.flipkart.com/"));
		wait.until(ExpectedConditions.titleContains("Online Shopping"));
		WebElement flipkartImage = driver.findElement(By.xpath("//img[contains(@title,'Flipkart')]"));
		Assert.assertTrue(flipkartImage.isDisplayed());
		driver.navigate().back();
		driver.navigate().refresh();
		Assert.assertFalse(driver.getTitle().contains("omayo"));
		
		
	}
	
	@Test(description="Taking screenshot in selenium and saving to folder",priority = 10)
	public void eleventhMethod() throws IOException {
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("./ScreenShots/Screen.png"));
	}
	
	
	
	
	
	
	
	
	@AfterClass
	public void afterClass() {
	driver.quit();
	}
}
