package pom;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.sql.ResultSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Properties;
import java.util.TreeSet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.apache.poi.xssf.usermodel.XSSFCell;
//import org.apache.poi.xssf.usermodel.XSSFSheet;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilitiesWeb.BasicMethods;

public class LoginPage   

{
	
	private String email_Field_Id= "email" ;
	private String email_Field_Exception= "While trying to login, the email field hasn't been found" ;
	private String password_Field_Id= "password" ;
	private String password_Field_Exception= "While trying to login, the password field hasn't been found" ;
	private String login_Button_Id= "login-buttons" ;
	private String login_Button_Exception= "While trying to login, the login-button hasn't been found" ;
	By locator_Of_Title_After_Login_As_Analyst = By.xpath("//*[text()='Augury - Inbox - Visits']");
	private    WebDriver _driver ;
	private    WebDriverWait _wait ;
    private ExtentTest _test;
	
    
	private WebElement emailField, passwordField, loginButton;
	
	String emaila= "test@test.com";
	
	private BasicMethods basic; 
	
	
	
	public LoginPage(WebDriver driver, WebDriverWait wait, ExtentTest test)
	{	
		_driver = driver;
		_wait= wait;
		basic = new BasicMethods(_driver, _wait, test) ;
		_test = test;
	}
	
	
	public void setReport(ExtentTest test)
	{
		_test = test;
	}
	
	
	private void LoginToSite(String url, String email, String password) throws Exception
	{
		
		_driver.get(url);
		_test.log(LogStatus.INFO, "Web application opened");
			
		emailField = basic.FindElementById(email_Field_Id, email_Field_Exception);
		
		passwordField = basic.FindElementById(password_Field_Id, password_Field_Exception);
			
		loginButton =  basic.FindElementById(login_Button_Id, login_Button_Exception);
		
		emailField.sendKeys(email);
		_test.log(LogStatus.INFO, "Entered email: "+ email);
		
		passwordField.sendKeys(password);
		_test.log(LogStatus.INFO, "Entered password: "+ password);
				
		//loginButton.click();
		//_test.log(LogStatus.INFO, "Clicked on login button");
		
		
		
		 	
	}
	
	
	public  void LoginToAuguryStaging() throws Exception
    {
			
		 
			LoginToSite("http://www.google.com", emaila, "1111" );
			_test.log(LogStatus.INFO, "Logged in to Staging");	
    }

}
