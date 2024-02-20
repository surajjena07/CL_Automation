package src.in.valtech.util;
import src.in.valtech.config.BaseTest;  
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.TestListenerAdapter;

public class Screenshot extends TestListenerAdapter {

	public static Properties commonprop;
	// Get the root directory of the project
	private static String DIR_PATH = System.getProperty("user.dir");
	
	public static ExtentReport testobj;

	// For logging
	public Logger log = Logger.getLogger(this.getClass().getName());

	// create our "formatter" (our custom format)
	String pattern = "MM/dd/yyyy";

	static SimpleDateFormat formatter = new SimpleDateFormat("dd_MMM_yyyy_hh_mm_ss");
	Date date = new Date();
	long a = date.getTime();
	String screenshots = null;

	public static void getScreenshotForFailures(String screenshotName, WebDriver driver) 
	{
		try {
	        
			File srcFile = ((TakesScreenshot) BaseTest.driver.get()).getScreenshotAs(OutputType.FILE);
			File targetFile_Report = new File(ExtentReport.reportPath+screenshotName+".png");
			File targetFile_SS = new File(DIR_PATH + File.separator + "screenshots" + File.separator + BaseTest.environmentName + File.separator +screenshotName+".png");
			FileUtils.copyFile(srcFile, targetFile_Report);
			FileUtils.copyFile(srcFile, targetFile_SS);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			testobj=new ExtentReport();
			//ExtentReport.extent_test.get().fail("getScreenshot method failed, cannot attach screenshot");
		}
	}
}
