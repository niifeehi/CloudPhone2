package signUp;

//import java.util.regex.Pattern;
/*import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;*/
import java.sql.SQLException;
//import java.sql.SQLException;
/*import java.sql.Statement;*/
//import java.util.concurrent.TimeUnit;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
/*import org.openqa.selenium.support.ui.Select;*/
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

public class signUpDemo {
private WebDriver driver;
private String baseUrl;
  

/*  String smsCode;*/


  @BeforeClass
  public void beforeClass(){
	  
    driver = new FirefoxDriver();
    baseUrl = "https://cloudphone.voxox.com/vxportal/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }
     
	   @Test
	   public void test1 () throws ClassNotFoundException, SQLException, InterruptedException {
		    
		    driver.get(baseUrl + "/vxlogin");
		    driver.findElement(By.id("signupLink")).click();
		    driver.findElement(By.id("mobileNumber")).clear();
		    driver.findElement(By.id("mobileNumber")).sendKeys("2125550138");
		    driver.findElement(By.cssSelector("button.btn")).click();
		    driver.findElement(By.id("code")).click();
		    driver.findElement(By.id("code")).clear();
		    driver.findElement(By.id("code")).sendKeys("1204");
		    driver.findElement(By.cssSelector("button.btn")).click();
		    driver.findElement(By.linkText("I Dig it! Let’s Move On!")).click();
		    driver.findElement(By.id("firstName")).clear();
		    driver.findElement(By.id("firstName")).sendKeys("test1");
		    driver.findElement(By.id("lastName")).clear();
		    driver.findElement(By.id("lastName")).sendKeys("test2");
		    driver.findElement(By.id("companyName")).clear();
		    driver.findElement(By.id("companyName")).sendKeys("testing");
		    driver.findElement(By.id("email")).clear();
		    driver.findElement(By.id("email")).sendKeys("test1@tcoff.net");
		    driver.findElement(By.id("password")).clear();
		    driver.findElement(By.id("password")).sendKeys("testpass");
		    driver.findElement(By.id("password2")).clear();
		    driver.findElement(By.id("password2")).sendKeys("testpass");
		    driver.findElement(By.id("submitSignup")).click();
		  	    
			String exp1;
			exp1 = driver.getCurrentUrl();
			System.out.println("Expected Result 1: " +exp1);
			
			String exp2;
			exp2 = driver.getTitle();
			System.out.println("Expected Result 2: " +exp2);
		
			String expt3 ;
			expt3 =	driver.findElement(By.xpath("//*[@id='vxNotify']/div/p")).getText();
			System.out.println("Expected Result 3: " +expt3);  
	   } 
	   
	   
     @AfterClass
     public void afterClass() {
    driver.quit();  
  }
}
