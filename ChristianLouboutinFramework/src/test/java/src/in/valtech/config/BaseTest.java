package src.in.valtech.config;
import static src.in.valtech.util.PropertyFileReader.commonProp;  
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.browserstack.local.Local;
import src.in.valtech.custom.CustomFun;
import src.in.valtech.util.ExtentReport;
import src.in.valtech.util.GenerateFrontXMLfile;
import src.in.valtech.util.PropertyFileReader;
import src.in.valtech.util.Screenshot;

/**
 * 
 * @author Gopalaswamy.M
 * 
 */

public class BaseTest extends ExtentReport
{

	public static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<RemoteWebDriver>();
	public static ThreadLocal<Logger> log = new ThreadLocal<Logger>();
	public String rootDir = CustomFun.getRootDir();
	public static ThreadLocal<String> baseUrl = new ThreadLocal<String>();
	public static ThreadLocal<String> locale = new ThreadLocal<String>();
	public static ThreadLocal<ITestResult> results = new ThreadLocal<ITestResult>();
	public static ThreadLocal<String> breakPoint = new ThreadLocal<String>();
	public static ThreadLocal<String> driverName = new ThreadLocal<String>();
	public static ThreadLocal<Boolean> isE_Commerce = new ThreadLocal<Boolean>();
	public static ThreadLocal<Process> process = new ThreadLocal<Process>();
	public static ThreadLocal<String> timeStamp = new ThreadLocal<String>();
	public static ThreadLocal<String> dataSet_Config = new ThreadLocal<String>();
	public static Map<Long, WebDriver> driverMap = new HashMap<Long, WebDriver>();
	public static ThreadLocal<String> bsValue = new ThreadLocal<String>();
	public static ThreadLocal<String> environment = new ThreadLocal<String>();
	public static ThreadLocal<String> testCaseName = new ThreadLocal<String>();
	public static ThreadLocal<String> browserVersion = new ThreadLocal<String>();
	public static String fileName = new String();
	public static String envValue = new String();
	public static String Actual;
	public static String expected;
	public static Local bsLocal = new Local();
	public String MthdNm;
	
//	public static String environmentName;
	
	public static ExtentReports extent;
	public static String testCaseNameSS = null;
	public static HashMap<String, String> bsLocalArgs;


	// static TimeOut tim;

	@BeforeSuite
	public void suiteSetUp() throws Exception
	{
		// For logging
		log.set(Logger.getLogger(this.getClass().getName()));
		
		extent = ExtentReport.getExtentInstance();
	     
		BasicConfigurator.configure();
		 
		PropertyConfigurator.configure(System.getProperty("user.dir")+"//resources//log4j_"+environmentName+".properties");

		 // configuration for common execution property file path
		GenerateFrontXMLfile.commonProp = new Properties();
		GenerateFrontXMLfile.commonProp.load(new FileInputStream(System.getProperty("user.dir") + "/resources/front/common_execution.properties"));
		Thread.sleep(1000);
			
		// Fetching the Test data values & generating the XML file for execution.
		GenerateFrontXMLfile.generateXMLfile(environmentName);
		Thread.sleep(2000);
		
		 String bssValue=GenerateFrontXMLfile.commonProp.getProperty("bssValue");
		 if(bssValue.equals("YES"))
		   {
			bsLocalArgs = new HashMap<String, String>();
	    	bsLocalArgs.put("key", GenerateFrontXMLfile.commonProp.getProperty("cl.browserstack.accesskey.value"));
	    	bsLocalArgs.put("forcelocal", "true");//FORCE LOCAL
	    	bsLocalArgs.put("force", "true");
	    	bsLocalArgs.put("onlyAutomate", "true");
	    	bsLocalArgs.put("proxyHost", GenerateFrontXMLfile.commonProp.getProperty("cl.browserstack.proxyhost.value"));
	        bsLocalArgs.put("proxyPort", GenerateFrontXMLfile.commonProp.getProperty("cl.browserstack.proxyport.value"));
	    	bsLocalArgs.put("forceproxy", "true");
	    	bsLocalArgs.put("localIdentifier", "EVENTS1");
	    	
	        //starting the locale in browser stack 
	    	BaseTest.bsLocal.start(BaseTest.bsLocalArgs);
	    	System.out.println("-------------Started the locale server in browser stack--------------- : "+BaseTest.bsLocal.isRunning());
		   }	

	}

	@Parameters({"LOCALE", "DS_CONFIG", "APPLICATION", "BREAKPOINT", "URL", "DRIVER", "ACTUAL_TC",
			"BROWSERSTACK", "ENVIRONMENT", "TESTCASENAME", "BROWSER_DEVICE_VERSION" })
	@BeforeTest
	public void setUp(String appLocale, String dataSet, String application,
			String deviceResolution, String url, String nativeDriver, String actualTestCase, String browserStack,
			String environmentValue, String testCaseValue, String browserDeviceDetails) throws Exception {
				
		log.set(Logger.getLogger(this.getClass().getName()));
		environment.set(environmentValue);
		Thread.sleep(500);
		envValue = environmentValue;
		// Assigning default value to ITestResult variable
		results.set(null);

		log.get().info("*****************************" + actualTestCase);
		log.get().info("Test case->" + actualTestCase);

		// Assigning locale value
		locale.set(appLocale);
		log.get().info("Locale->" + locale.get());

		// Assigning locale value
		bsValue.set(browserStack);
		log.get().info("browserStack->" + bsValue.get());

		if (nativeDriver.equals("ANDROID") || nativeDriver.equals("IOS"))

		{
			String deviceArr[] = browserDeviceDetails.split(":");
			String osValue = deviceArr[0];
			String deviceName = deviceArr[1];
			String browserVersionValue = deviceArr[2];
			// Assigning driver value
			browserVersion.set(browserVersionValue);
			log.get().info("Browser Version->" + browserVersion.get());
		} else {
			// Assigning driver value
			browserVersion.set(browserDeviceDetails);
			log.get().info("Browser Version->" + browserVersion.get());
		}

		// Assigning driver value
		driverName.set(nativeDriver);
		log.get().info("Driver->" + driverName.get());

		// Assigning driver value
		dataSet_Config.set(dataSet);
		log.get().info("Test dataSet_Config->" + dataSet_Config.get());

		// ************* Load Property File********************
		PropertyFileReader.loadProprtyFile(locale.get(), application);
		testCaseName.set(testCaseValue);
		
		if (environmentName.equalsIgnoreCase("HomoEnv")) 
		{
			fileName = commonProp.get().getProperty("cl.automation.excel.path.homoenv");
		} else if (environmentName.equalsIgnoreCase("StagingEnv")) 
		{
			fileName = commonProp.get().getProperty("cl.automation.excel.path.stagingenv");
		}else if (environmentName.equalsIgnoreCase("IntegrationEnv")) 
		{
			fileName = commonProp.get().getProperty("cl.automation.excel.path.integrationenv");
		}
		else if (environmentName.equalsIgnoreCase("Integration6Env")) 
		{
			fileName = commonProp.get().getProperty("cl.automation.excel.path.integration6env");
		}
		else if (environmentName.equalsIgnoreCase("HomoEnv1")) 
		{
			fileName = commonProp.get().getProperty("cl.automation.excel.path.homoenv1");
		}
		else if (environmentName.equalsIgnoreCase("StagingEnv1")) 
		{
			fileName = commonProp.get().getProperty("cl.automation.excel.path.stagingenv1");
		}
		else if (environmentName.equalsIgnoreCase("HomoEnv2")) 
		{
			fileName = commonProp.get().getProperty("cl.automation.excel.path.homoenv2");
		}
		else
		{
			log.get().info("--------------------Env is empty------------" + testCaseValue);
		}

		// Get Test Data set Details
		CustomFun.getTestDataSetDetails(dataSet_Config.get(), fileName);

		// Assigning baseUrl value
		baseUrl.set(url);
		log.get().info("BaseURL->" + baseUrl.get());

		// Assigning breakPoint value
		breakPoint.set(deviceResolution);
		log.get().info("Breakpoint->" + breakPoint.get());
		log.get().info("*****************************");

		// ********e-Commerce or Non e-commerce value assignment based on
		// locale******

		if (locale.get().equals("FR_FR") || locale.get().equals("UK_EN") || locale.get().equals("CH_FR"))
			isE_Commerce.set(Boolean.TRUE);
		else {
			log.get().error("Not a valid locale: Please specify valid locale");
			Reporter.log("Not a valid locale: Please specify valid locale");

		}
		
		  	
		/*
		 * Select the relative drive as configured at BasicConfig.csv file using
		 * switch-case.
		 */
		// String count = "1";

		try {
			log.get().info("Before InitializeDriver");
			driver.set(CustomFun.initializeDriver(driverName.get(), driver.get(), breakPoint.get(), rootDir,bsValue.get(), environmentName, testCaseValue, browserDeviceDetails));
			log.get().info("After InitializeDriver");
			driverWindowSize();
		} catch (Exception e) {
			log.get().info("---------Inside Exception in BAse TEst------");
			// count = "2";
			try {
				
				  log.get().info("-------Retry-----------" + e.getMessage());
				  TimeUnit.MINUTES.sleep(2); //
				  driver.set(CustomFun.initializeDriver(driverName.get(), driver.get(),
				  breakPoint.get(), rootDir,bsValue.get(), environmentValue, testCaseValue,
				  browserDeviceDetails)); driverWindowSize();
				 
			} catch (Exception x) {
				log.get().info("---------Catching Exception in Base Test After Retry------");
				log.get().info("------Message----" + x.getMessage());
			}

		}
	
	}

	private void driverWindowSize() {
		if (driverName.get().equalsIgnoreCase("FF") || driverName.get().equalsIgnoreCase("CHROME")
				|| driverName.get().equalsIgnoreCase("SAFARI") || driverName.get().equalsIgnoreCase("IE")) {
			if (breakPoint.get().equalsIgnoreCase("L")) {
				// driver.get().manage().window().setSize(new Dimension(1350,
				// 730));
				driver.get().manage().window().maximize();
			} else if (breakPoint.get().equalsIgnoreCase("M")) {
				// driver.get().manage().window().setSize(new Dimension(897, 568));
				driver.get().manage().window().setSize(new Dimension(1080, 680));
			} else if (breakPoint.get().equalsIgnoreCase("AS")) {
				// driver.get().manage().window().setSize(new Dimension(400, 600));
				driver.get().manage().window().setSize(new Dimension(500, 700));
			}
			log.get().info("Window size ---" + driver.get().manage().window().getSize());
		}

		driverMap.put(Thread.currentThread().getId(), driver.get());
	}

	@AfterTest
	public  void tearDown() throws Exception {

		// Closing the driver once the suite execution is finished.
		//driver.get().close();
		// Quitting the driver once the suite execution is finished.
		driver.get().quit();
		
		log.get().info("In After Test");
		driver.remove();
		baseUrl.remove();
		driverName.remove();
		isE_Commerce.remove();
		process.remove();
		locale.remove();
		breakPoint.remove();
	}

	@BeforeMethod
	public void methodLevelSetup() throws Exception {

		/*
		 * Checks for exceptions like IllegalStateException or SkipException or
		 * SessionNotFoundException or UnreachableBrowserException, If found skips the
		 * test method
		 */
	
	
		
	 if(results.get() != null) {
			if ((results.get().getThrowable().toString().contains("IllegalStateException")
					|| results.get().getThrowable().toString().contains("SkipException")
					|| results.get().getThrowable().toString().contains("SessionNotFoundException")
					|| results.get().getThrowable().toString().contains("UnreachableBrowserException"))) {

				throw new SkipException("Skip Methods");
			}
	 } 
	}

	@AfterMethod
	public void methodLevelTearDown(ITestResult result) throws Exception {

		/*
		 * Checks for exceptions like IllegalStateException or SkipException or
		 * SessionNotFoundException or UnreachableBrowserException, If found skips the
		 * test method
		 */
	
		testCaseNameSS=result.getMethod().getMethodName();
		if (result.getStatus() == ITestResult.FAILURE)
        {
			String logtext="<b>***"+testCaseNameSS+" failed...</b>";
			Markup m= MarkupHelper.createLabel(logtext, ExtentColor.RED);
			extent_test.get().log(Status.FAIL,m);
			
			try {
	        String screenshotName=ExtentReport.getScreenshotnameofFailureTest(testCaseNameSS);
	        if(BaseTest.driver.get()!=null)
	        {
	        Screenshot.getScreenshotForFailures(screenshotName, BaseTest.driver.get());
	        extent_test.get().fail(MediaEntityBuilder.createScreenCaptureFromPath(screenshotName + ".png").build());
	        extent_test.get().fail(result.getThrowable()).toString();
	        }
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
				extent_test.get().fail("Test failed, cannot attach screenshot" + extent_test.get().fail(result.getThrowable()));
			}

        } else if (result.getStatus() == ITestResult.SKIP)
        {
        	extent_test.get().skip("Test Case Has Been Skipped");
        } else
        {
        	String logtext="<b>***"+testCaseNameSS+"test successfully...</b>";
    		Markup m= MarkupHelper.createLabel(logtext, ExtentColor.GREEN);
    		extent_test.get().log(Status.PASS,m);
        }
		
		if (results.get() != null) {
			if ((results.get().getThrowable().toString().contains("IllegalStateException")
					|| results.get().getThrowable().toString().contains("SkipException")
					|| results.get().getThrowable().toString().contains("SessionNotFoundException")
					|| results.get().getThrowable().toString().contains("UnreachableBrowserException"))) {

				throw new SkipException("Skip Methods");
			}
		}

	}

	@BeforeClass
	public void classLevelSetUP(ITestContext context) throws Exception {
		/*
		 * Checks for exceptions like IllegalStateException or SkipException or
		 * UnreachableBrowserException, If found skips the test cases
		 */
        
		startTest(context.getName());
		
    	if (results.get() != null) {
			if ((results.get().getThrowable().toString().contains("IllegalStateException")
					|| results.get().getThrowable().toString().contains("SkipException")
					|| results.get().getThrowable().toString().contains("SessionNotFoundException")
					|| results.get().getThrowable().toString().contains("UnreachableBrowserException"))) {

				throw new SkipException("Skip classes");
			}
		} 
	}

	@AfterClass
	public void classLevelTearDown() throws Exception {
		/*
		 * Checks for exceptions like IllegalStateException or SkipException or
		 * UnreachableBrowserException, If found skips the test cases
		 */
		
		if (results.get() != null) {
			if ((results.get().getThrowable().toString().contains("IllegalStateException")
					|| results.get().getThrowable().toString().contains("SkipException")
					|| results.get().getThrowable().toString().contains("SessionNotFoundException")
					|| results.get().getThrowable().toString().contains("UnreachableBrowserException"))) {

				throw new SkipException("Skip classes");
			}
		}
		//ExtentReportListener.endTest();
	}

	@AfterSuite
	public void clearThreadLocalValues() throws Exception {
		// stop the Local instance
		//endTest();
	//	ExtentReportListener.closeTest();
		BaseTest.endTest();
		bsLocal.stop();
		System.out.println("-------------Stopped the locale server in browser stack--------------- : "+BaseTest.bsLocal.isRunning());
		driver.remove();
		baseUrl.remove();
		driverName.remove();
		isE_Commerce.remove();
		process.remove();
		locale.remove();
		breakPoint.remove();
		dataSet_Config.remove();
		timeStamp.remove();
	}

	public ThreadLocal<RemoteWebDriver> getDriver() {
		return driver;
	}

	public void setDriver(ThreadLocal<RemoteWebDriver> driver) {
		BaseTest.driver = driver;
	}

	public ThreadLocal<String> getBaseUrl() {
		return baseUrl;
	}

	public void setBaseUrl(ThreadLocal<String> baseUrl) {
		BaseTest.baseUrl = baseUrl;
	}

	public ThreadLocal<String> getLocale() {
		return locale;
	}

	public void setLocale(ThreadLocal<String> locale) {
		BaseTest.locale = locale;
	}

	public ThreadLocal<String> getBreakPoint() {
		return breakPoint;
	}

	public void setBreakPoint(ThreadLocal<String> breakPoint) {
		BaseTest.breakPoint = breakPoint;
	}

	public ThreadLocal<Boolean> getIsE_Commerce() {
		return isE_Commerce;
	}

	public void setIsE_Commerce(ThreadLocal<Boolean> isE_Commerce) {
		BaseTest.isE_Commerce = isE_Commerce;
	}

	public ThreadLocal<Process> getProcess() {
		return process;
	}

	public void setProcess(ThreadLocal<Process> process) {
		BaseTest.process = process;
	}

	public ThreadLocal<String> getDriverName() {
		return driverName;
	}

	public void setDriverName(ThreadLocal<String> driverName) {
		BaseTest.driverName = driverName;
	}

	public static ThreadLocal<String> getBsValue() {
		return bsValue;
	}

	public static void setBsValue(ThreadLocal<String> bsValue) {
		BaseTest.bsValue = bsValue;
	}

	public static ThreadLocal<String> getEnvironment() {
		return environment;
	}

	public void setEnvironment(ThreadLocal<String> environment) {
		BaseTest.environment = environment;
	}

	public static String getEnvValue() {
		return envValue;
	}

	public static void setEnvValue(String envValue) {
		BaseTest.envValue = envValue;
	}
	public static ThreadLocal<String> getTestCaseName() {
		return testCaseName;
	}

	public static void setTestCaseName(ThreadLocal<String> testCaseName) {
		BaseTest.testCaseName = testCaseName;
	}
	
	public synchronized static void getTest() {
	//	return (ExtentTest) extentTestMap.get((int) (long) (Thread.currentThread().getId()));
	}

	public synchronized static void endTest() {
		extent.flush();
	}

	public synchronized  ThreadLocal<ExtentTest> startTest(String testName)
	{
		test = extent.createTest(testName);
		extent_test.set(test);
	//	extentTestMap.put((int) (long) (Thread.currentThread().getId()), ExtentReport.extent_test);
		return extent_test;
	}
	
	public void logtest(String testDescription) {
		
		String logtext = "<b>*** " + testDescription + " ***</b>";
		Markup m = MarkupHelper.createLabel(logtext, ExtentColor.CYAN);
		extent_test.get().log(Status.INFO, m);
	}

}
