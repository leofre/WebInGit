package analystPage;

import pom.*;
import utilities.*;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITest;
import org.testng.ITestClass;
import org.testng.ITestMethodFinder;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.ExtentX;
import com.relevantcodes.extentreports.LogStatus;






public class DiscussionFeature {


	private    WebDriver _driver;
	private WebDriverWait _wait;
	private LoginPage login;
	private BasicMethods basic = new BasicMethods();
	private ExtentReports report;
	private ExtentTest test;
	private String nameOfThisSuite= "Discussion Feature maven";

	

	
	@BeforeSuite
	public void Initialize()
	{
		_driver= basic.InitializeFireFox();
		_wait= basic.InitializeWait(_driver);
		report = basic.getReportInstance(nameOfThisSuite);
	}
	
	
	
	
	@Test //(priority = 0)
  
	public void preConditionBeforeTestingDiscussionFeature() throws Exception
	{
		String nameOfTestWithoutSpaces = new Object(){}.getClass().getEnclosingMethod().getName();
		String nameOfTestWithSpaces= UtilitiesForWeb.splitStringWithCamelCase(nameOfTestWithoutSpaces);
		test = report.startTest(nameOfTestWithSpaces);
		login = new LoginPage(_driver, _wait, test);
		Reporter.log("Thread : "+Thread.currentThread().getId()+" is started", true);
		test.log(LogStatus.INFO, "Starting test: " + nameOfTestWithSpaces);
		login.LoginToAuguryStaging();
		test.log(LogStatus.PASS, "Finished test: " + nameOfTestWithSpaces);
		Reporter.log("Thread : "+Thread.currentThread().getId()+" is ended", true);
	}
	
	


@AfterSuite


	public void clean()
	{
		
		basic.Cleanup(_driver);
		report.flush();
	}






@AfterMethod

public void afterMethod(ITestResult methodResult) throws IOException
{
	if (methodResult.getStatus()== ITestResult.FAILURE)
	{
		String methodName = methodResult.getName();
		String path= ScreenShots.takeScreenShots(_driver, methodResult.getName());
		String imagePath= test.addScreenCapture(path);
		test.log(LogStatus.FAIL, imagePath);	
	}
	
	report.endTest(test);
	
}

}
