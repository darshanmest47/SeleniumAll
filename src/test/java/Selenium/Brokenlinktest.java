package Selenium;

import java.net.URL;

import javax.net.ssl.HttpsURLConnection;
import java.util.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Brokenlinktest {
	public static void main(String[] args) {
		String url = "https://practice-automation.com/broken-links/";
		
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
//		options.addArguments("--incognito");
//		options.addArguments("--headless=new");
		WebDriver driver = new ChromeDriver(options);
//		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get(url);
		List<WebElement> links = driver.findElements(By.tagName("a"));
		for(int i=0;i<links.size();i++) {
			String URL = links.get(i).getAttribute("href");
			try {
				HttpsURLConnection connection = (HttpsURLConnection) new  URL(URL).openConnection();
                connection.setConnectTimeout(5000);
                connection.setRequestMethod("HEAD");
                connection.connect();
                
                int statusCode = connection.getResponseCode();
                if(statusCode>=400) {
                	System.out.println("Link "+URL+" is broken with status code "+statusCode);
                }else {
                	System.out.println("Link "+URL+" is working fine with status code "+statusCode);
                }
			}catch (Exception e) {
				System.out.println("Exception in inspecting the link "+URL);
			}
		}
	}

}
