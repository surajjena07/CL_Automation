package src.in.valtech.util;
import src.in.valtech.util.ExtentReport;  
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

/**
 * 
 * @author Gopal M
 *
 *
 */

public class ExtentReport
{
	
	public static ExtentSparkReporter es;
    public static ExtentReports extent;
    public ThreadLocal<ExtentTest> extent_test = new ThreadLocal<ExtentTest>();
    public ExtentTest test;
    public static String TimeStamp=new SimpleDateFormat("MMM_dd_yyyy_hh_mm_ss").format(new Date());
  
    
    public static Properties commonprop;
    public static String environmentName;
    
    public static String DIR_PATH = System.getProperty("user.dir");
    public static String reportName;
    
    public static String reportPath;
    
    /**
	  *@method getExtentInstance() method which helps to generate the extent report to track the status of Test's
	  *@return object of ExtentReports
     * @throws IOException 
     * @throws FileNotFoundException 
	  */
    
    public static ExtentReports getExtentInstance() throws FileNotFoundException, IOException
    {
    	commonprop= new Properties();
        commonprop.load(new FileInputStream(System.getProperty("user.dir") + "/resources/front/common_execution.properties"));
        environmentName  = commonprop.getProperty("environmentName");
        
        reportPath=DIR_PATH+File.separator+"reports"+File.separator+"ExtentReport"+File.separator+environmentName+File.separator+"Build"+TimeStamp+File.separator;
    	reportName = reportPath+getReportName();
        es = new ExtentSparkReporter(reportName);
        es.config().setDocumentTitle("ChristianLouboutin_Automation_Report");
        es.config().setReportName("ChristianLouboutin_Automation_"+"Business_WorkFlow");
        extent = new ExtentReports();
        extent.attachReporter(es);
        return extent;
    }

    /**
	  *@method getReportName() method which helps to create the report name with time stamp
	  *@return String -- name of the extent report postfix with time stamp
	  */
    public static String getReportName()
    { 
        String reportName="ChristianLouboutin_Automation_"+"ExtentReportResults"+".html";
        return reportName;
    }
    
    /**
	  *@method getScreenshotnameofFailureTest() method which helps to create the screenshot name with time stamp
	  *@return String -- name of the extent report postfix with time stamp
	  */
    public static String getScreenshotnameofFailureTest(String testCasename) {
        return testCasename+"_"+TimeStamp;
	}
   
}
