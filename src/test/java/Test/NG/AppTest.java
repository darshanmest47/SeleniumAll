package Test.NG;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * Unit test for simple App.
 */
public class AppTest {

    /**
     * Rigorous Test :-)
     */
	@BeforeSuite
	public void beforeSuite() {
	System.out.println("Before Suite")	;
	}
	
	@BeforeClass
	public void beforeClass() {
		System.out.println("BeforeClass");
	}
	
	@BeforeMethod()
	public void beforeMethod() {
		System.out.println("Before Method");
	}
	
    @Test
    public void shouldAnswerWithTrue() {
        System.out.println("Hello from test method");

    }
    
    @AfterMethod()
    	public void afterMethod() {
            System.out.println("After method");

    	}
    
	@AfterClass
	public void afterClass() {
		System.out.println("After Class");
	}
	
	@AfterSuite
	public void afterSuite() {
	System.out.println("After Suite")	;
	}
    
}

