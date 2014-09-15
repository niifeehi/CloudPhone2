package signUp;

//import java.util.regex.Pattern;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
//import java.sql.SQLException;
import java.sql.Statement;
//import java.util.concurrent.TimeUnit;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

public class prodSignUpCloud1 {

  
  private WebDriver driver;
  private String baseUrl;
  
  String strsmsCode;
  String smsCode;

  @BeforeClass
   public void beforeClass(){
 	  
    }

  		/*@Test
  		public void test1 () throws ClassNotFoundException, SQLException, InterruptedException {
    
    
  	   String dbUrl = "jdbc:mysql://vdb-lab.telcentris.net:3306/acl"; 
	   String username = "basil.dzewu";
	   String password = "e(6YAns1Q4qr";
	   
	   String query = "Delete from acl.users where login='+18583809176'";
	   
	   Class.forName("com.mysql.jdbc.Driver");
	   
	   Connection conn = DriverManager.getConnection(dbUrl, username, password);
	   
	   Statement stmt = conn.createStatement();
	   
	   stmt.executeUpdate(query);
	
	   
	    stmt.close() ;
	    conn.close() ;
	    
  		} */
  		
     
	  @Test
	   public void test2 () throws ClassNotFoundException, SQLException, InterruptedException {
		  
		  driver = new FirefoxDriver();
		    baseUrl = "https://cloudphone.voxox.com/";
		   driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		  
		  
	     driver.get(baseUrl + "/vxlogin");
	     driver.findElement(By.id("signupLink")).click();
	     new Select(driver.findElement(By.id("countryCode"))).selectByVisibleText("United States (+1)");
	     driver.findElement(By.id("mobileNumber")).clear();
	     driver.findElement(By.id("mobileNumber")).sendKeys("8582153006");
	     driver.findElement(By.cssSelector("button.btn")).click();
	     driver.manage().timeouts().pageLoadTimeout(300, TimeUnit.SECONDS);
	     
	     Thread.sleep(3000);
	     
	       String dbUrl = "jdbc:mysql://vdb-warehouse.telcentris.net:3306/acl"; 
		   String username = "basil.dzewu";
		   String password = "lHcYZ~)jw9";
		   
		   String query1 = " Select smsCode from acl.users where login='+18582153006' ";
		   
		   Class.forName("com.mysql.jdbc.Driver");
		   
		   Connection conn = DriverManager.getConnection(dbUrl, username, password);
		   
		   Statement stmt = conn.createStatement();
		   
		   ResultSet rs = stmt.executeQuery(query1);
		   
		   while (rs.next()){
			   
			   smsCode = rs.getString(1);
			   System.out.println(smsCode);
		   }
		   
		   
		 Thread.sleep(12000);
		 driver.manage().timeouts().pageLoadTimeout(900, TimeUnit.SECONDS);
	     
	     driver.findElement(By.id("code")).clear();
	     
	     driver.manage().timeouts().pageLoadTimeout(2400, TimeUnit.SECONDS);
	     driver.findElement(By.id("code")).sendKeys(smsCode);
	     driver.manage().timeouts().pageLoadTimeout(6000, TimeUnit.SECONDS);
	     
	     Thread.sleep(3000);
	     
	     driver.findElement(By.cssSelector("button.btn")).click();
	     driver.manage().timeouts().pageLoadTimeout(2000, TimeUnit.SECONDS);
	     driver.findElement(By.linkText("I Dig it! Let’s Move On!")).click();
	     
	     // incase request is made for CC info to be provided.
	     
	     
	     new Select(driver.findElement(By.id("ccType"))).selectByVisibleText("VISA");
	     driver.findElement(By.id("ccNumber")).clear();
	     driver.findElement(By.id("ccNumber")).sendKeys("4815880006441135");
	     driver.findElement(By.id("ccCVV")).clear();
	     driver.findElement(By.id("ccCVV")).sendKeys("822");
	     
	     new Select(driver.findElement(By.id("ccExpMonth"))).selectByVisibleText("Dec");
	     new Select(driver.findElement(By.id("ccExpYear"))).selectByVisibleText("2017");
	     driver.findElement(By.id("ccName")).clear();
	     driver.findElement(By.id("ccName")).sendKeys("Test QA");
	     driver.findElement(By.id("billingAddress")).clear();
	     
	     driver.findElement(By.id("billingAddress")).sendKeys("9276 Scranton Road Suite 300");
	     driver.findElement(By.id("billingCity")).clear();
	     driver.findElement(By.id("billingCity")).sendKeys("San Diego");
	     new Select(driver.findElement(By.id("billingState"))).selectByVisibleText("CA");
	     driver.findElement(By.id("billingZip")).clear();
	     driver.findElement(By.id("billingZip")).sendKeys("92121");
	     driver.findElement(By.id("submitBilling")).click();
	     
	     
	     driver.findElement(By.id("firstName")).clear();
	     driver.findElement(By.id("firstName")).sendKeys("Tester");
	     driver.findElement(By.id("lastName")).clear();
	     driver.findElement(By.id("lastName")).sendKeys("QAtester");
	     driver.findElement(By.id("companyName")).clear();
	     driver.findElement(By.id("companyName")).sendKeys("Voxox-QA");
	     driver.findElement(By.id("email")).clear();
	     driver.findElement(By.id("email")).sendKeys("tester-qa-tester@tcoff.net");
	     driver.findElement(By.id("password")).clear();
	     driver.findElement(By.id("password")).sendKeys("testpass");
	     driver.findElement(By.id("password2")).clear();
	     driver.findElement(By.id("password2")).sendKeys("testpass");
	     driver.findElement(By.id("submitSignup")).click();
	     driver.manage().timeouts().pageLoadTimeout(300, TimeUnit.SECONDS);
	     
	     String exp1;
   		 exp1 = driver.getCurrentUrl();
   		 System.out.println("Expected Result 1: " +exp1);
   		
   		 String exp2;
   		 exp2 = driver.getTitle();
   		 System.out.println("Expected Result 2: " +exp2);
   		 
   		 Thread.sleep(3000);
   		 
   		
   		 String expt3 ;
   		 expt3 = driver.findElement(By.xpath("//*[@id='vxNotify']/div/p")).getText();
   		 System.out.println("Expected Result 3: " +expt3);  
   		 
   		 String exp4;
   		 exp4 = driver.findElement(By.xpath("//*[@id='3641']/article/h3")).getText();
   		 System.out.println("Expected Result 4 : " +exp4);
   		 
   		 String exp5;
  		 exp5 = driver.findElement(By.xpath("//*[@id='3641']/article/div/strong[1]")).getText();
  		 System.out.println("Expected Result 5: " +exp5);
  		 
  		 String exp6;
  		 exp6 = driver.findElement(By.xpath("//*[@id='3641']/article/div/strong[2]")).getText();
  		 System.out.println("Expected Result 5: " +exp6);
  		 
  		 String exp7;
  		 exp7 = driver.findElement(By.xpath("//*[@id='3641']/article/div/p/span")).getText();
  		 System.out.println("Expected Result 5: " +exp7);
   	
        rs.close() ;
   	    stmt.close() ;
   	    conn.close() ;
   	    
	   } 
	   
	  
   @AfterClass
     public void afterClass() {
	   
    driver.quit();
    
  }


}
