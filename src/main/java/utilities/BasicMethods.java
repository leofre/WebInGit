package utilities;


import java.io.PrintWriter;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class BasicMethods {
	
	

	private    WebDriver _driver ;
	private    WebDriverWait _wait ;
	private ExtentTest _test;
	
	public BasicMethods()
	{
		_driver= null;
		_wait=null;
	}
   
	
    public BasicMethods(WebDriver driver, WebDriverWait wait, ExtentTest test)
    {
    	_driver = driver; 	
    	_wait = wait;
    	_test = test;
    }
    


    public WebDriver InitializeFireFox()
    {
    	System.setProperty("webdriver.gecko.driver"  , "C:\\Users\\leonid\\Desktop\\firefoxdriver\\geckodriver.exe");
    	WebDriver driver = new FirefoxDriver(); 
    	return driver;
    	
    }
    
    public WebDriverWait InitializeWait(WebDriver driver)
    {
    	WebDriverWait wait = new WebDriverWait(driver, 20);     
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize(); 
        return wait;
    	
    }
    
    

      public void Cleanup(WebDriver driver)
      {

           driver.quit();

      }
     
    
      public static ExtentReports  getReportInstance(String name)
      {
    	  ExtentReports report = new ExtentReports(CommonVariables.pathOfDirectoryThatContainsReports+name+".html", true);
    	  
    	  return report;
      }
      
    
      
      
     public  void WaitUntilElementIsVisible( WebElement element , String theExceptionthrown) throws Exception
     {

           

         try
         {
          
             _wait.until(ExpectedConditions.visibilityOf(element));

         }


         catch (Exception a )
         {
        	 _test.log(LogStatus.FAIL, theExceptionthrown);
        	 throw new Exception(theExceptionthrown);

         }

     }
     
     
     
     public  void WaitUntilTitleExists(String title, String theExceptionthrown) throws Exception
     {

        	 
             try
             {
              
            	 _wait.until(ExpectedConditions.titleIs(title));

             }


             catch ( Exception TimeoutException )
             {
            	 _test.log(LogStatus.FAIL, theExceptionthrown);
                 throw new Exception(theExceptionthrown);

             }

     }
     
     
     public  WebElement FindElementByXpath(String TheXpath, String exception) throws Exception
     {

          try
          {
              return _driver.findElement(By.xpath(TheXpath));
              
                     
          }
         

          catch (Exception TimeoutException)
          {
        	  _test.log(LogStatus.FAIL, exception);
              throw new Exception(exception);

          }

     }
     
     
     public  WebElement FindElementByName(String name, String exception) throws Exception
     {

         try
         {
        	 return _driver.findElement(By.name(name));
        	 
        	 
                           
         }
        

         catch (Exception TimeoutException)
         {
        	 _test.log(LogStatus.FAIL, exception);
             throw new Exception(exception);
             

         }

     }
     
     
     public  WebElement FindElementById(String id, String exception) throws Exception
     {

         try
         {
        	 return _driver.findElement(By.id(id));
        	 
                           
         }
        

         catch (Exception TimeoutException)
         {
        	 _test.log(LogStatus.FAIL, exception);
             throw new Exception(exception);

         }
         
 
     }
     
    
     
    
     
     
     
     


}
