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

public class signUp2 {
private WebDriver driver;
  private String baseUrl;
 
  String smsCode;

@BeforeClass
  public void beforeClass(){
	  
  

    }
 
  
  		@Test
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
	    
  		} 
  		
     
	  @Test
	   public void test2 () throws ClassNotFoundException, SQLException, InterruptedException {
		  
		  driver = new FirefoxDriver();
		    baseUrl = "https://ironfist.extranet.telcentris.com/";
		   driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		  
		  
	     driver.get(baseUrl + "/vxlogin");
	     driver.findElement(By.id("signupLink")).click();
	     new Select(driver.findElement(By.id("countryCode"))).selectByVisibleText("United States (+1)");
	     driver.findElement(By.id("mobileNumber")).clear();
	     driver.findElement(By.id("mobileNumber")).sendKeys("8583809176");
	     driver.findElement(By.cssSelector("button.btn")).click();
	     driver.manage().timeouts().pageLoadTimeout(300, TimeUnit.SECONDS);
	     
	     
	       String dbUrl = "jdbc:mysql://vdb-lab.telcentris.net:3306/acl"; 
		   String username = "basil.dzewu";
		   String password = "e(6YAns1Q4qr";
		   
		   String query1 = " Select smsCode from acl.users where login='+8583809176' ";
		   
		   Class.forName("com.mysql.jdbc.Driver");
		   
		   Connection conn = DriverManager.getConnection(dbUrl, username, password);
		   
		   Statement stmt = conn.createStatement();
		   
		   ResultSet rs = stmt.executeQuery(query1);
		   
		   while (rs.next()){
			   
			   smsCode = rs.getString(1);
			   System.out.println(smsCode);
		   }
		   
		 System.out.println(smsCode);
		   
		 driver.manage().timeouts().pageLoadTimeout(400, TimeUnit.SECONDS);
	     
	     driver.findElement(By.id("code")).clear();
	     
	     driver.manage().timeouts().pageLoadTimeout(1200, TimeUnit.SECONDS);
	     driver.findElement(By.id("code")).sendKeys(smsCode);
	     driver.manage().timeouts().pageLoadTimeout(2000, TimeUnit.SECONDS);
	     
	     driver.wait(20000);
	     
	     driver.findElement(By.cssSelector("button.btn")).click();
	     driver.manage().timeouts().pageLoadTimeout(2000, TimeUnit.SECONDS);
	     driver.findElement(By.linkText("I Dig it! Let’s Move On!")).click();
	     driver.findElement(By.id("firstName")).clear();
	     driver.findElement(By.id("firstName")).sendKeys("test2");
	     driver.findElement(By.id("lastName")).clear();
	     driver.findElement(By.id("lastName")).sendKeys("test3");
	     driver.findElement(By.id("companyName")).clear();
	     driver.findElement(By.id("companyName")).sendKeys("tester");
	     driver.findElement(By.id("email")).clear();
	     driver.findElement(By.id("email")).sendKeys("tester12@tcoff.net");
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
