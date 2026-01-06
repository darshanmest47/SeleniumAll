package Analyzers;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import Selenium.AllActions;

public class RetryAnalyzer implements IRetryAnalyzer {
     private int count=0;
     private static final int MAX_RETRY_COUNT = 3;
     
     
     @Override
     public boolean retry(ITestResult result) {
		 Object currentClass = result.getInstance();
		 WebDriver driver = ((AllActions) currentClass).getDriver();
		 File folder = new File("./FailedScreenShots");
		 if(folder.exists()) {
			 try {
				FileUtils.deleteDirectory(folder);
			 } catch (IOException e) {
				e.printStackTrace();
			 }
		 } else {
			 if(driver!=null) {
				 try {
				 TakesScreenshot ts = ((TakesScreenshot)driver);
				 File source = ts.getScreenshotAs(OutputType.FILE);
				 File destination = new File("./FailedScreenShots/ "+result.getName()+" _ "+System.currentTimeMillis()+".png");
				 FileUtils.copyFile(source,destination);
					 
				 }catch (Exception e) {
					 e.printStackTrace();
				}
			 }
		 }

		 
		 
    	 if(count < MAX_RETRY_COUNT) {
    		 count++;
    		 return true;
    	 }
    	 return false;
     }

}
