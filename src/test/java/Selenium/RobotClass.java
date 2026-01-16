package Selenium;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RobotClass {
	
	public static void main(String[] args) throws AWTException {
      WebDriverManager.chromedriver().setup();
      WebDriver driver = new ChromeDriver();
      driver.manage().window().maximize();
      driver.get("https://www.ilovepdf.com/word_to_pdf");
		WebElement fileButton = driver.findElement(By.cssSelector("#uploader > a"));
		fileButton.click();
		
		Robot robot = new Robot();
		robot.delay(5000);
		
		StringSelection selection = new StringSelection("C:\\Users\\DELL\\Downloads\\jenkinsintegration (1).docx");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);
		
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		
		robot.delay(2000);
		robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
	
	
	}
}
