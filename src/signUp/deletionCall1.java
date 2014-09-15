package signUp;

//import java.util.regex.Pattern;


//import java.sql.SQLException;

//import java.util.concurrent.TimeUnit;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

public class deletionCall1 {
  private WebDriver driver;
  private String baseUrl;
  
  
  @BeforeClass
  public void beforeClass(){
	  
   driver = new FirefoxDriver();
    baseUrl = "http://svcs.telcentris.net/api/Rest/params/method/runQuery/queryId/149/format/plain?mobile=18582153006";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }
     
	   @Test
	   public void test1 ()  {
	     driver.get(baseUrl);       
	   } 
	   
     @AfterClass
     public void afterClass() {

     driver.quit();
    
    
  }


}
