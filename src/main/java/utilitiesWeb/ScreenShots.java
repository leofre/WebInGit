package utilitiesWeb;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class ScreenShots {
	
	public static String takeScreenShots(WebDriver driver, String fileName) throws IOException
	{
		fileName= fileName+".png";
		String directory= CommonVariables.pathForScreenShots;
		File sourceFile= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(sourceFile, new File(directory+fileName) );
		String destination = directory+fileName;
		return destination;
		
		// better way for the path:  https://www.udemy.com/appium-selenium-for-mobile-automation-testing/learn/v4/t/lecture/3318232  from 05:00		
		
	}

}
