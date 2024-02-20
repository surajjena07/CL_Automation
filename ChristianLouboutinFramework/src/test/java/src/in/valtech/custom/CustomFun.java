package src.in.valtech.custom;
import src.in.valtech.config.BaseTest;   
import src.in.valtech.uifunctions.GUIFunctions;
import src.in.valtech.util.ExcelReader;
import src.in.valtech.util.PIM_DSDetails;
import src.in.valtech.util.PayPalPaymentDSDetails;
import src.in.valtech.util.PaymentDSDetails;
import src.in.valtech.util.SKUID_DSDetails;
import src.in.valtech.util.UserInfoDSDetails;
import src.in.valtech.util.WMSInfoDSDetails;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import static src.in.valtech.util.PropertyFileReader.ObjRepoProp;
import static src.in.valtech.util.PropertyFileReader.TextProp;
import static src.in.valtech.util.PropertyFileReader.commonProp;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.SystemUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import com.google.common.collect.ImmutableMap;
import src.in.valtech.util.Address_DSDetails;
import src.in.valtech.util.AdyenInfoDSDetails;
import src.in.valtech.util.BO_DSDetails;
import src.in.valtech.util.BillingAddress_DSDetails;

public class CustomFun  {

	private static final String TASKLIST = "tasklist";
	private static final String KILL = "taskkill /IM ";
	public static Logger log = Logger.getLogger(CustomFun.class.getName());
	public static ThreadLocal<UserInfoDSDetails> userInfoDSDetails = new ThreadLocal<UserInfoDSDetails>();
	public static ThreadLocal<PaymentDSDetails> paymentDSDetails = new ThreadLocal<PaymentDSDetails>();
	public static ThreadLocal<SKUID_DSDetails> skuidDSDetails = new ThreadLocal<SKUID_DSDetails>();
	public static ThreadLocal<PayPalPaymentDSDetails> payPalPaymentDSDetails = new ThreadLocal<PayPalPaymentDSDetails>();
	public static ThreadLocal<BO_DSDetails> boDSDetails = new ThreadLocal<BO_DSDetails>();
	public static ThreadLocal<Address_DSDetails> addressDSDetails = new ThreadLocal<Address_DSDetails>();
	public static ThreadLocal<BillingAddress_DSDetails> billingaddressDSDetails = new ThreadLocal<BillingAddress_DSDetails>();
	public static ThreadLocal<WMSInfoDSDetails> wmsInfoDSDetails = new ThreadLocal<WMSInfoDSDetails>();
	public static ThreadLocal<AdyenInfoDSDetails> adyenInfoDSDetails = new ThreadLocal<AdyenInfoDSDetails>();
	public static ThreadLocal<PIM_DSDetails> pimInfoDSDetails = new ThreadLocal<PIM_DSDetails>();
	public static BigDecimal taxAmtGST;
	public static BigDecimal taxAmtPST;
	public static BigDecimal taxAmtQST;
	public static BigDecimal taxAmtHST;
	public static BigDecimal taxAmtGSTSH;
	public static BigDecimal taxAmtPSTSH;
	public static BigDecimal taxAmtQSTSH;
	public static BigDecimal taxAmtHSTSH;
	public static AppiumDriver androidDriver;
	public static ArrayList<String> tabs;

	// public static String envValue = new String();

	/**
	 * Method Name: isElementPresent Description:Method to verify the Element
	 * 
	 * @param by
	 *            :Element locator
	 * @param driver
	 *            :WebDriver
	 * @return true: if element is present, false: if element is not present
	 */
	public static boolean isElementPresent(By by, WebDriver driver) {
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	/**
	 * Method Name: getRootDir Description: Method to get Root directory
	 * 
	 * @return :rootDir
	 */
	public static String getRootDir() {
		String rootDir = System.getProperty("user.dir");
		return rootDir;
	}

	/**
	 * Method Name: refreshPage Description: Method to used refresh a page after
	 * doing some action (if required page refresh)
	 * 
	 * @param driver
	 *            :WebDriver
	 * @return driver
	 */
	public static WebDriver refreshPage(WebDriver driver) {

		driver.navigate().refresh();
		CustomFun.waitForPageLoaded(driver);
		return (driver);
	}

	/**
	 * Method Name: switchToNewWindow Description: This function switches the
	 * browser control to new window and verifies title
	 * 
	 * @param driver
	 *            : WebDriver
	 * @param pageTitle
	 *            : title of the page
	 * @return newWindow(driver)
	 * @throws InterruptedException
	 */
	public static WebDriver switchToNewWindow(WebDriver driver, String pageTitle) throws InterruptedException {

		String parent = driver.getWindowHandle();
		WebDriver newWindow = null;
		Set<String> windowIterator = driver.getWindowHandles();

		System.err.println("No of windows :  " + windowIterator.size());
		for (String s : windowIterator) {
			String windowHandle = s;
			if (!parent.equalsIgnoreCase(windowHandle)) {
				newWindow = driver.switchTo().window(windowHandle);
				Thread.sleep(3000);
				JavascriptExecutor javascript = (JavascriptExecutor) driver;

				//Get current page title
				String pagetitle = javascript.executeScript("return document.title").toString().trim();  
				System.out.println("Page Title Is  : "+pagetitle);

				log.info("Window Url : " + newWindow.getCurrentUrl());
				Assert.assertTrue(newWindow.getTitle().contains(pagetitle));
				if (newWindow.getTitle().equals(pagetitle)) {

					log.info("Selected Window Title : " + newWindow.getTitle());
					return newWindow;
				}
			}
		}
		log.info("Window Title :" + newWindow.getTitle());
		return newWindow;
	}

	/**
	 * This function switches back the handle to parent window.
	 * 
	 * @param driver
	 * @param winHandleBefore
	 */
	public static void switchBackToParentWindow(WebDriver driver, String winHandleBefore) {

		try {
			// Close opened browser
			driver.close();

			// Switch back to parent window
			driver.switchTo().window(winHandleBefore);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Method Name: isElementHighlighted Description: This function verifies whether
	 * the element is highlighted or not on rollover/mouseOver of the element based
	 * on the action specified
	 * 
	 * @param driver
	 *            : WebDriver instance
	 * 
	 * @param WebElement
	 *            : WebElement that needs to rollover or click to check element is
	 *            highlighted or not
	 * 
	 * @param isHighlight
	 *            : If true checks element is highlighted If false checks element is
	 *            not highlighted
	 * 
	 * @param action
	 *            : "rollOver" : mousehover / roll overs on specified element
	 *            "click" : clicks on specified element
	 * 
	 * @param eleName
	 *            : Name of the element
	 * 
	 * @param prop
	 *            : property of the element
	 * 
	 * @throws Exception
	 *             ,ElementNotHiglightedException, ElementHiglightedException
	 * 
	 */
	public static void isElementHighlighted(WebDriver driver, By by, boolean isHighlight, String action, String eleName,
			String prop) throws
	// ElementNotHiglightedException, ElementHiglightedException,
	Exception {

		// Initialize WebElement
		WebElement ele = driver.findElement(by);

		// Storing color before roll over
		String eleCssBefore = ele.getCssValue(prop);
		log.info("Before Property :" + eleCssBefore);
		if (action.equals("rollOver")) {
			Thread.sleep(2000);

			// Mouse hover/roll over on element
			GUIFunctions.mouseOverElement(driver, ele, eleName);

			Thread.sleep(4000);
		} else if (action.equals("click")) {
			Thread.sleep(2000);

			// Click on element
			GUIFunctions.mouseOverElementAndClick(driver, ele, eleName);

		}

		// Initialize WebElement
		WebElement element = driver.findElement(by);

		Thread.sleep(1000);
		// Storing color after roll over
		String eleCssAfter = element.getCssValue(prop);
		log.info("After Property :" + eleCssAfter);

		if (isHighlight == true) {
			// comparing before and after colors
			if (!(eleCssBefore.equals(eleCssAfter))) {
				log.info("Element " + eleName + " is highlighted and underlined");
				Reporter.log("Element " + eleName + " is highlighted and underlined");

			} else {
				log.error("Element " + eleName + " is not highlighted");
				Reporter.log("Element " + eleName + " is not highlighted");

				// throw new ElementNotHiglightedException("Element is not
				// Higlighted");
			}
		} else if (isHighlight == false) {
			// comparing before and after colors
			if (eleCssBefore.equals(eleCssAfter)) {
				log.info("Element " + eleName + " is not highlighted");
				Reporter.log("Element " + eleName + " is not highlighted");

			} else {
				log.error("Element " + eleName + " is highlighted");
				Reporter.log("Element " + eleName + " is highlighted");

				// throw new ElementHiglightedException("Element is
				// Higlighted");
			}

		}
	}
	
	/**
	 * Method Name: waitObjectToLoad Description: This function waits until the
	 * specific element to load
	 * 
	 * @param driver
	 *            : WebDriver instance
	 * @param by
	 *            :Element locator
	 * @param timeSec
	 *            :time in seconds
	 * @return 
	 */
	public static boolean waitObjectToLoad(WebDriver driver, By by, Duration timeSec) {

		WebDriverWait wait = new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.presenceOfElementLocated(by));
		return true;
	}

	/**
	 * Method Name:isStringUpperCase Description:Verifies String is in uppercase or
	 * in lowercase
	 * 
	 * @param str
	 * @param isUpper
	 *            : true: if string needs to be checked for uppercase false:if
	 *            string needs to be checked for lowercase
	 * @return true,if string is in upper case false, if string is not in upper case
	 * 
	 */
	public static boolean isStringUpperCase(String str, boolean isUpper) {

		String newStr = null;

		if (str.contains("&") || str.contains(",") || str.contains(">")) {
			// Remove special characters and spaces in the string
			newStr = str.replaceAll("[,&>]+", "").replaceAll("\\s+", "");

		} else {
			// Remove spaces present in the string
			newStr = str.replaceAll("\\s+", "");

		}

		if (isUpper) {
			// Check string is in upper case
			boolean isUpperCase = StringUtils.isAllUpperCase(newStr);

			if (isUpperCase) {
				log.info("Text is in uppercase: " + str);
				Reporter.log("Text is in uppercase: " + str);

				return true;

			}
			log.error("Text is not in uppercase: " + str);
			Reporter.log("Text is not in uppercase: " + str);
			return false;
		} else {
			boolean isLowerCase = StringUtils.isAllLowerCase(newStr);

			if (isLowerCase) {
				log.info("Text is in LowerCase: " + str);
				Reporter.log("Text is in LowerCase: " + str);

				return true;

			}
			log.error("Text is not in lowercase: " + str);
			Reporter.log("Text is not in lowercase: " + str);
			return false;

		}
	}

	/**
	 * MethodName: isObjectAlignedLeft Description: To check object is aligned left
	 * or not
	 * 
	 * @param ele
	 *            : WebElement
	 * @return
	 */
	public static boolean isObjectAlignedLeft(WebElement ele) {

		int eleOffsetLeft = Integer.parseInt(ele.getAttribute("offsetLeft"));

		/*
		 * check the eleOffsetLeft,if eleOffsetLeft is "0", then object is aligned left
		 */
		if (eleOffsetLeft == 0) {

			return true;

		}

		return false;
	}

	/**
	 * Method Name:verifyEqualSpaceBetweenElements Description: To verify equal
	 * space between elements (Ex: space between links,space between icons)
	 * 
	 * @param eleList
	 *            :List of elements for which space between elements need to be
	 *            checked
	 * @param Msg
	 *            : Customized message based on elements Ex:Equal space is present
	 *            b/w header main navigation links
	 * @return: true: if equal space is present b/w elements false:if equal space is
	 *          not present
	 */
	public static boolean verifyEqualSpaceBetweenElements(List<WebElement> eleList, String msg) {

		// Array list declaration
		List<Integer> eleLeft = new ArrayList<Integer>();
		List<Integer> eleRight = new ArrayList<Integer>();
		List<Integer> spaceDiff = new ArrayList<Integer>();
		int sum = 0;

		// Store each element left position and right position
		for (int i = 0; i < eleList.size(); i++) {
			int eleWidth;
			eleLeft.add(Integer.parseInt(eleList.get(i).getAttribute("offsetLeft")));

			eleWidth = Integer.parseInt(eleList.get(i).getAttribute("offsetWidth"));

			eleRight.add(eleLeft.get(i) + eleWidth);

		}

		// Calculate difference between two elements
		for (int j = 0; j < (eleList.size() - 1); j++) {

			spaceDiff.add(eleLeft.get(j + 1) - eleRight.get(j));

		}

		for (int k = 0; k < spaceDiff.size(); k++) {

			sum = sum + spaceDiff.get(k);

		}

		// Calculate average difference
		double average = sum / (eleList.size() - 1);

		// Check the average difference among all elements
		if ((average - (double) (spaceDiff.get(0))) <= 1) {

			// if it is <= 1, equal difference is present
			log.info(msg);
			Reporter.log("<p>" + msg);
			return true;

		} else {

			// if not, log error message
			log.error("No equal space present between the objects");
			Reporter.log("<p>No equal space present between the objects");
			return false;
		}

	}

	/**
	 * MethodName: isElementClickable Description: To check whether element is
	 * clickable or not
	 * 
	 * @param ele
	 *            : WebElement
	 * @param eleName
	 *            : Element for which Clickable need to be checked
	 * 
	 * 
	 * @return Boolean value
	 * 
	 * 
	 */
	public static boolean isElementClickable(WebElement ele, String eleName) {

		String eleCursor = ele.getCssValue("cursor");

		boolean match = false;

		// Check element is not clickable
		if (eleCursor.equals("auto") || eleCursor.equals("text")) {

			// If not clickable, log success message
			log.info(eleName + " is not clickable");
			Reporter.log("<p>" + eleName + " is not clickable");

			match = false;

		}
		// Check element is clickable
		else if (eleCursor.equals("pointer")) {
			// if element is clickable, log error message
			log.info(eleName + " is clickable");
			Reporter.log("<p>" + eleName + " is clickable");
			match = true;
		}

		return match;
	}

	/**
	 * Method checkObjectPositionOnScreen Description: To verify footer is at the
	 * bottom of the page. (Ex:Footer link Change location is at the bottom of the
	 * page )
	 * 
	 * @param element
	 *            : Web Element
	 * @param driver
	 *            : WebDriver Instance
	 * @param message
	 *            : Customized message based on element location Ex:Element is not
	 *            at the position as expected
	 */
	public static void checkObjectPositionOnScreen(WebElement element, WebDriver driver, String message) {

		Point eleLocation;
		Dimension eleSize;
		Dimension pageSize;

		eleLocation = element.getLocation();
		eleSize = element.getSize();
		pageSize = driver.findElement(By.className("page")).getSize();

		if (eleLocation.y + eleSize.height == pageSize.height) {
			log.info(message);
		} else {

			log.error("Object/Element is not aligned as expected.");
		}

	}

	/**
	 * Method isTextOverlapped Description: To verify text is overlapping between
	 * elements (Ex:Footer link Apps is overlapping on Help )
	 * 
	 * @param ele
	 *            : Customized message based on elements Ex:Footer link 3 is
	 *            overlapping on link 2
	 * @param msg
	 *            : Customized message based on elements Ex:Footer link 3 is not
	 *            overlapping link 2 @return; true: Their is no overlapping of text
	 *            false:if Their is overlapping of text
	 */
	public static boolean isTextOverlapped(WebElement ele, String msg) {

		String eleMarginLeft = ele.getCssValue("margin-left").toString();

		int elePixel = Integer.parseInt(eleMarginLeft.replace("px", ""));

		// Check the text is overlapped
		if (elePixel < 0) {

			// if it is < 0, text is overlapped
			log.info(msg);
			Reporter.log("<p>" + msg);
			return false;

		} else {

			// if no, log error message
			log.info("Their is no overlapping of text");
			Reporter.log("<p>Their is no overlapping of text");
			return true;
		}

	}

	/**
	 * 
	 * @param eleList
	 *            : List of elements for which width and position one under other to
	 *            be checked
	 * @param driver
	 *            : WebDriver driver
	 * @param msg
	 *            : Customized message based on elements
	 * @return true: pushes are displayed one under other false: if pushes are not
	 *         displayed one under other
	 */
	public static boolean isPushesDisplayedOneUnderOther(List<WebElement> eleList, WebDriver driver, String msg) {
		// Width of the page on screen
		Dimension winPoint = driver.findElement(By.className("page")).getSize();
		int screenWidth = winPoint.width;
		boolean flag = false;
		int widthSecondPush = 0;
		int secondPushYCoordinate = 0;

		// Check the pushes location one under other with same width
		for (int i = 0; i < eleList.size(); i++) {
			Point eleLocation = eleList.get(i).getLocation();
			Dimension eleHeight = eleList.get(i).getSize();
			// Width of first push
			int widthFirstPush = eleList.get(i).getSize().width;
			int firstPushYCoordinate = eleLocation.y;
			int firstPushHeight = eleHeight.height;

			for (int j = 1; j < eleList.size(); j++) {
				Point eleLocation2 = eleList.get(j).getLocation();
				// Width of Second push
				widthSecondPush = eleList.get(j).getSize().width;
				secondPushYCoordinate = eleLocation2.y;
			}
			if ((secondPushYCoordinate - (firstPushYCoordinate + firstPushHeight) <= 1)
					&& ((widthFirstPush == screenWidth) && (screenWidth == widthSecondPush))) {

				flag = true;

			}

		}

		if (flag) {
			// pushes are displayed one under other
			log.info(msg);
			Reporter.log("<p>" + msg);
			return true;

		} else {

			// pushes are not displayed one under other
			log.info("pushes are not displayed one under other");
			Reporter.log("<p>pushes are not displayed one under other");
			return true;
		}

	}

	/**
	 * Check the given process is running or not return true -if exists else false.
	 * 
	 * @param serviceName
	 * @return
	 * @throws Exception
	 */
	public static boolean isProcessRunging(String serviceName, String driverName) throws Exception {
		if (driverName.equalsIgnoreCase("IOS") && driverName.equalsIgnoreCase("ANDROID")) {
			Process p = Runtime.getRuntime().exec(TASKLIST);
			BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
			String line;
			while ((line = reader.readLine()) != null) {
				// Log the running processes
				log.info(line);
				if (line.contains(serviceName)) {
					return true;
				}
			}
		}
		return false;

	}

	/**
	 * MethodName:calculateCardExpiryYear
	 * 
	 * Description:Calculates Credit Card Expiry Year
	 */
	public static String calculateCardExpiryYear() throws Exception {

		// To Select current year +4 in card expiration Year dropdown
		Calendar now = Calendar.getInstance();
		int year = now.get(Calendar.YEAR);
		int expYear = year + 4;
		String expYearInString = String.valueOf(expYear);

		return expYearInString;
	}

	/**
	 * MethodName:isImgSelected Description: This function checks image is selected
	 * or not
	 * 
	 * @param ele
	 *            : WebElement
	 * @return
	 * @throws Exception
	 */
	public static boolean isImgSelected(WebElement ele) throws Exception {
		boolean match = false;
		if ((ele.getAttribute("class")).contains("selected")) {
			match = true;
		}
		return match;
	}

	/**
	 * MethodName:generateTimeStamp Description: This method generates timestamp
	 * 
	 * @return newDate
	 */
	public static String generateTimeStamp() {

		Calendar calendar = Calendar.getInstance();
		Date date = calendar.getTime();
		SimpleDateFormat stringDate = new SimpleDateFormat("ddMMyyhhmmss");

		String newDate = stringDate.format(date);

		return newDate;

	}

	/**
	 * MethodName:verifyDropdownValues
	 * 
	 * Description: This method verifies the dropdown options
	 * 
	 * @param Webelement
	 *            ele
	 * @param dropDownValuesArray
	 * @throws Exception
	 */
	public static boolean verifyDropdownValues(WebElement ele, String[] dropDownValuesArray) throws Exception {

		boolean match = false;

		try {
			Select dropDown = new Select(ele);

			List<WebElement> options = dropDown.getOptions();

			if (options.size() == dropDownValuesArray.length) {

				for (WebElement we : options) {

					for (int i = 0; i < dropDownValuesArray.length; i++) {

						String act = we.getText().replace("\n", "").trim();

						if (act.equalsIgnoreCase(dropDownValuesArray[i])) {

							match = true;
							Reporter.log("Dropdown options: " + we.getText());
							log.info("Dropdown options: " + we.getText());

						}
					}

				}
			} else {
				log.error("Dropdown values size is not matching");
				Reporter.log("<p>Dropdown values size is not matching");
			}
		} catch (NoSuchElementException e) {
			log.error("Element to type data is not present " + e);
			Reporter.log("<p>Element to type data is not present");

		}
		return match;

	}

	/**
	 * MethodName:verifySelectedDropdownValue
	 * 
	 * Description: This method verifies the Selected dropdown value
	 * 
	 * @param Webelement
	 *            ele
	 * @param shippingmethodarray
	 * @throws Exception
	 */
	public static boolean verifySelectedDropdownValue(WebElement dropDown, String dropDownValue) throws Exception {

		boolean match = false;

		// Dropdown element initialization
		Select dropDownEle = new Select(dropDown);

		// Get Selected dropdown value
		String defaultoption = dropDownEle.getFirstSelectedOption().getText();

		defaultoption = defaultoption.replace("\n", "").trim();

		log.info("Verified Default DropDown option: " + defaultoption);
		log.info("Verified DropDown Value: " + dropDownValue);
		Reporter.log("Verified Default DropDown option: " + defaultoption);
		Reporter.log("Verified DropDown Value: " + dropDownValue);

		// Verify selected value
		if (defaultoption.equalsIgnoreCase(dropDownValue)) {
			match = true;
		}

		return match;
	}

	/**
	 * MethodName:verifyTitleDropdownValue
	 * 
	 * Description: This method verifies the Selected dropdown value
	 * 
	 * @param Webelement
	 *            ele
	 * @param shippingmethodarray
	 * @throws Exception
	 */
	public static boolean verifyTitleDropdownValue(String driverName, WebElement dropDown, String dropDownValue)
			throws Exception {

		boolean match = false;

		// Dropdown element initialization
		Select dropDownEle = new Select(dropDown);

		// Get Selected dropdown value
		String defaultoption = "";
		if (driverName.equalsIgnoreCase("CHROME") || driverName.equalsIgnoreCase("ANDROID")) {
			defaultoption = dropDownEle.getFirstSelectedOption().getAttribute("innerText").toString();
		} else {
			defaultoption = dropDownEle.getFirstSelectedOption().getText();
		}

		defaultoption = defaultoption.replace(" ", "").replace("\n", "");
		defaultoption = defaultoption.trim();

		// Verify selected value
		if (defaultoption.equalsIgnoreCase(dropDownValue)) {
			match = true;
		}

		return match;
	}

	/**
	 * MethodName:compareNumericValues
	 * 
	 * Description: This method compares the 2 values
	 * 
	 * @param int
	 *            value1
	 * @param int
	 *            value2
	 */
	public static boolean compareNumericValues(float value1, float value2) throws Exception {

		boolean match;

		if (value1 > value2) {

			match = true;
		} else {
			match = false;
		}

		return match;

	}

	/**
	 * MethodName:verify Credit Card Selected
	 * 
	 * Description: This method verifies which card is selected
	 * 
	 * 
	 */
	public static void verifyCardSelected(WebDriver driver) throws Exception {
		String cardType = paymentDSDetails.get().getCardType().replace(" ", "");

		switch (cardType) {
		case "VISA":

			Assert.assertTrue(
					CustomFun.isImgSelected(
							driver.findElement(By.xpath(ObjRepoProp.get().getProperty("visaCardImg_XPATH")))),
					"Visa card is not selected");

			log.info("Visa card is selected \n");
			Reporter.log("<p>Visa card is selected");

			break;
		case "MASTER CARD":
			Assert.assertTrue(
					CustomFun.isImgSelected(
							driver.findElement(By.xpath(ObjRepoProp.get().getProperty("masterCardImg_XPATH")))),
					"Master Card is not selected");
			log.info("Master Card is selected \n");
			Reporter.log("<p>Master Card is selected");
			break;
		
		}

	}

	/**
	 * MethodName:verifyDropdownAttributeValues
	 * 
	 * Description: This method verifies the dropdown attribute values
	 * 
	 * @param Webelement
	 *            ele
	 * @param dropDownValuesArray
	 * @throws Exception
	 */
	public static boolean verifyDropdownAttributeValues(WebElement ele, String[] dropDownValuesArray, String type,
			boolean lengthCheck) throws Exception {

		boolean match = false;

		try {
			Select dropDown = new Select(ele);

			List<WebElement> options = dropDown.getOptions();

			if (!lengthCheck) {
				int i = 0;
				for (WebElement we : options) {
					log.info("----dropdown---" + we.getText());
					if (we.getText().trim().equalsIgnoreCase(dropDownValuesArray[i])) {

						match = true;
					}
				}

			}

			else {
				int actualsize = options.size();
				log.info("Dropdown options1: " + actualsize);
				int expectedSize = dropDownValuesArray.length;
				log.info("Dropdown options2....: " + expectedSize);
				if (actualsize == expectedSize) {

					int i = 0;

					for (WebElement we : options) {

						// for (int i = 0; i < dropDownValuesArray.length; i++)
						// {

						if (type.equalsIgnoreCase("value")) {
							if (we.getAttribute("value").equals(dropDownValuesArray[i])) {
								match = true;
								Reporter.log("Dropdown options: " + we.getAttribute("value"));
								log.info("Dropdown options: " + we.getAttribute("value"));
							}
						} else if (type.equalsIgnoreCase("text")) {

							if (we.getText().trim().equalsIgnoreCase(dropDownValuesArray[i])) {
								match = true;
								Reporter.log("Dropdown options: " + we.getText());

								log.info("Dropdown options: " + we.getText());
							}

						}
						i++;

						// }
					}
				} else {
					log.error("Dropdown values size is not matching");
					Reporter.log("<p>Dropdown values size is not matching");
				}
			}

		} catch (NoSuchElementException e) {
			log.error("Element to type data is not present " + e);
			Reporter.log("<p>Element to type data is not present");

		}
		return match;

	}



	

	/**
	 * MethodName:verifyTextboxCursorFocus
	 * 
	 * Description: This method verifies Textbox Cursor Focus
	 * 
	 * @param: driver
	 * 
	 * @return boolean value
	 * 
	 * @throws Exception
	 */
	public static boolean verifyTextboxCursorFocus(WebDriver driver) throws Exception {

		boolean match = false;
		try {
			WebElement currentElement = driver.switchTo().activeElement();
			// Check that current element is Search field
			if ("text".equals(currentElement.getAttribute("type"))) {
				match = true;

				log.info("Cursor is focused on textbox\n");
				Reporter.log("<p> Cursor is focused on textbox");
			} else {
				log.error("Cursor is not focused on textbox\n");
				Reporter.log("<p> Cursor is not focused on textbox");
			}

		} catch (NoSuchElementException e) {
			log.error("exception" + e);

		}

		return match;

	}

	/**
	 * Verifies the element is editable
	 * 
	 * @param ele
	 * @return
	 * @throws Exception
	 */
	public static boolean isElementEditable(WebElement ele) throws Exception {

		boolean match = false;
		try {
			log.info("Property Editable : " + ele.getAttribute("readOnly"));

			if (!ele.getAttribute("readOnly").contains("true")) {

				match = true;
			} else {
				match = false;
			}

		} catch (NullPointerException e) {
			return match;
		}

		return match;
	}

	/**
	 * This function round offs price value to decimal point two digits
	 * 
	 * @param amt
	 * @return
	 * @throws Exception
	 */
	public static BigDecimal priceValueRoundOffToTwoDigits(BigDecimal amt) throws Exception {

		BigDecimal doundOffAmt = null;
		try {
			// Round off price value to decimal point two digits
			doundOffAmt = amt.setScale(2, RoundingMode.HALF_UP);

		} catch (Exception e) {
			log.error("Number format exception" + e);
		}

		return doundOffAmt;
	}

	/**
	 * This function Replaces "," , " ", ".", "\n" with null for canadian price
	 * 
	 * @param amt
	 * @return
	 * @throws Exception
	 */
	public static String replaceSymbolsInCandainPrice(String amt) throws Exception {
		String amtvalue = null;

		try {
			// Replace "," , " ", ".", "\n" with null
			amtvalue = amt.substring(1).replace(",", "").replace(" ", "").replace(".", "").replace("\n", "").trim();
		} catch (Exception e) {
			log.error("exception" + e);
		}

		return amtvalue;
	}

	/**
	 * This element verifies element is displayed or not
	 * 
	 * @param ele
	 * @param driver
	 * @return
	 * @throws Exception
	 */
	public static boolean isElementVisible(By ele, WebDriver driver) throws Exception {
		try {
			driver.findElement(ele).isDisplayed();
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	/**
	 * This Function Switches the WebDriver control to the provided iFrame.
	 * 
	 * @param frameName
	 *            : Name of the IFrame to which WebDriver need to be switched.
	 * @param driver
	 *            : WebDriver instance whose control should be shifted to iFrame.
	 */

	public static void switchToFrame(String frameValue, WebDriver driver, String type) {

		try {
			if (type.equals("name"))
				driver.switchTo().frame(frameValue);

			else if (type.equals("index")) {

				int index = Integer.parseInt(frameValue);
				driver.switchTo().frame(index);
			}
		}

		catch (Exception e) {

			log.error("Exception while SwitchingFrame " + frameValue + " : " + e);

		}
	}

	/**
	 * This Function Switches the WebDriver control to the provided iFrame.
	 * 
	 * @param frameName
	 *            : WebElement of the IFrame to which WebDriver need to be switched.
	 * @param driver
	 *            : WebDriver instance whose control should be shifted to iFrame.
	 */

	public static void switchToFrameByEle(WebElement farmeEle, WebDriver driver) {

		try {
			driver.switchTo().frame(farmeEle);
		}

		catch (Exception e) {

			log.error("Exception while SwitchingFrame " + e);

		}
	}

	/**
	 * This Function Switches the WebDriver Control to main Window from an iFrame.
	 * 
	 * @param driver
	 *            : WebDriver instance.
	 */

	public static void switchToMainWindowFromIFrame(WebDriver driver) {

		try {
			driver.switchTo().defaultContent();
		}

		catch (Exception e) {

			log.error("Exception while Switching to Main Window : " + e);
		}

	}

	/**
	 * Verifies Currency with the locale
	 * 
	 * @param priceValue
	 * @param locale
	 * @return
	 * @throws Exception
	 */
	public static boolean verifyCurrencyAgainstLocale(String priceValue, String locale) throws Exception {
		char[] price = priceValue.toCharArray();
		String currency = "";
		boolean match = false;
		for (int i = 0; i < price.length; i++) {
			if (price[i] != '.' && price[i] != ',' && price[i] != ' ') {
				try {
					Integer.parseInt(Character.toString(price[i]));
				} catch (NumberFormatException nfe) {
					currency = currency + price[i];
				}
			}
		}
		switch (locale) {
		case "UK":
			Assert.assertEquals(TextProp.get().get("currency"), currency);
			match = true;
			break;

		case "FR":
			Assert.assertEquals(TextProp.get().get("currency"), currency);
			match = true;
		}
		return match;
	}


	/**
	 * Verifies the Tab is selected or not
	 * 
	 * @param ele
	 * @param eleName
	 * @return Boolean value
	 * @throws Exception
	 */
	public static boolean isTabSelected(WebElement ele, String eleName) throws Exception {

		boolean match = false;
		try {

			if (ele.getAttribute("class").contains("active")) {

				match = true;
				log.info(eleName + " is selected");
				Reporter.log(eleName + " is selected");
			} else {
				log.error(eleName + " is not selected");
				Reporter.log(eleName + " is not selected");
			}

		} catch (Exception e) {
			log.error("exception" + e);
		}

		return match;
	}

	/**
	 * Method Name:isAsteriskPresentWithLabel
	 * 
	 * Description: This method will return boolean Value True if the Label is
	 * containing "*" in it. else it will return a false.
	 * 
	 * @param driver
	 * @param by
	 * @param LabelName
	 * @return
	 * @throws Exception
	 */
	public static boolean isAsteriskPresentWithLabel(WebDriver driver, By by, String LabelName) throws Exception {

		boolean flag = false;
		flag = driver.findElement(by).getText().contains("*");
		if (flag == true) {
			log.info(LabelName + "contains Arstric sign at the end");
			Reporter.log("<p>" + LabelName + "contains Arstric sign at the end");
		} else {

			log.error(LabelName + " does not contain Arstric sign at the end");
			Reporter.log("<p>" + LabelName + " does not contain Arstric sign at the end");
		}
		return flag;
	}

	/**
	 * 
	 * @param driverName
	 * @param driver
	 * @param breakPoint
	 * @param rootDir
	 * @param process
	 * @throws Exception
	 * @throws IOException
	 * @throws InterruptedException
	 * @throws MalformedURLException
	 */
	public static RemoteWebDriver initializeDriver(String driverName, RemoteWebDriver driver, String breakPoint,
			String rootDir, String bsValue, String environment, String testCaseName, String browserDeviceDetails)
			throws Exception, IOException, InterruptedException, MalformedURLException, WebDriverException {

		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		String strDate = formatter.format(date);
		log.info(strDate);
        
		
		String ciExecution = commonProp.get().getProperty("cl.jenkins.value");
		String ciExecutionBuildValue = commonProp.get().getProperty("cl.jenkins.value");
		String browserstackFolder = "BS_";
		String ciCycleValue = "";
		String osValue = "";
		String deviceName = "";
		String browserVersionValue = browserDeviceDetails;

		log.info("--CI Value--" + ciExecutionBuildValue);
		String browserstackURL = commonProp.get().getProperty("cl.browserstack.url.value");
		if (ciExecution.equals("true")) {
			browserstackFolder = "BS_" + commonProp.get().getProperty("cl.jenkins.folder.value") + "_";
			ciCycleValue = commonProp.get().getProperty("cl.jenkins.project.value");
		}

		if (driverName.equals("ANDROID") || driverName.equals("IOS"))
		// recordset.getField("DRIVER").equals("IOS")
		{
			String deviceArr[] = browserDeviceDetails.split(":");
			osValue = deviceArr[0];
			deviceName = deviceArr[1];
			browserVersionValue = deviceArr[2];

		}

		if (bsValue.equals("YES")) {

			switch (driverName) {
			case "CHROME":
				// replace <browserstack-accesskey> with your key. You can also set an environment variable - "BROWSERSTACK_ACCESS_KEY".
		    	
		    	// starts the Local instance with the required arguments  	
				DesiredCapabilities capsCH = new DesiredCapabilities();
				capsCH.setCapability("browser", driverName);
				capsCH.setCapability("browser_version", browserVersionValue);
				capsCH.setCapability("os", "Windows");
				capsCH.setCapability("os_version", "10");
				capsCH.setCapability("resolution", "1680x1050");
				capsCH.setCapability("browserstack.networkLogs", "false");
				capsCH.setCapability("browserstack.debug", "true");
				capsCH.setCapability("browserstack.local", "true");
				capsCH.setCapability("browserstack.localIdentifier","EVENTS1");
				capsCH.setCapability("chromeOptions", ImmutableMap.of("w3c", false));


				capsCH.setCapability("name", testCaseName);
				// capsCH.setCapability("browserstack.geoLocation","US");
				capsCH.setCapability("browserstack.console", "info");
				capsCH.setCapability("build", browserstackFolder + environment + "_" + strDate);
				ChromeOptions options = new ChromeOptions();
				Map<String, Object> prefs = new HashMap<String, Object>();
				Map<String, Object> profile = new HashMap<String, Object>();
				Map<String, Object> contentSettings = new HashMap<String, Object>();

				// SET CHROME OPTIONS
				contentSettings.put("geolocation", 1); // 2 to disable
				profile.put("managed_default_content_settings", contentSettings);
				prefs.put("profile", profile);
				options.setExperimentalOption("prefs", prefs);

				// SET CAPABILITY
				capsCH.setCapability(ChromeOptions.CAPABILITY, options);

				// driver = new RemoteWebDriver(new URL(browserstackURL), capsCH);
				if (ciExecution.equals("true")) {
					capsCH.setCapability("project", ciCycleValue);
				}

				driver = new RemoteWebDriver(new URL(browserstackURL), capsCH);
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				driver.manage().deleteAllCookies();

				break;
			case "SAFARI":

				// *******************//***BrowserStack****/**************************
				
				// replace <browserstack-accesskey> with your key. You can also set an environment variable - "BROWSERSTACK_ACCESS_KEY".
		    	
		    	// starts the Local instance with the required arguments
		    	BaseTest.bsLocal.start(BaseTest.bsLocalArgs);
				DesiredCapabilities capsSF = new DesiredCapabilities();
				//capsSF.setCapability("os", "OS X");
				//capsSF.setCapability("os_version", "Sierra");
				//capsSF.setCapability("os_version", "14");
				capsSF.setCapability("browser", driverName);
				capsSF.setCapability("os_version", osValue);
				capsSF.setCapability("real_mobile", "true");
				capsSF.setCapability("browser_version", browserVersionValue);
				capsSF.setCapability("resolution", "1600x1200");
				capsSF.setCapability("browserstack.networkLogs", "false");
				capsSF.setCapability("browserstack.debug", "true");
				capsSF.setCapability("browserstack.local", "true");
				capsSF.setCapability("browserstack.force", "true");
				capsSF.setCapability("browserstack.forcelocal", "true");
				//capsSF.setCapability("browserstack.selenium_version", "3.7.0");
				//capsSF.setCapability("browserstack.localIdentifier","g");
				capsSF.setCapability("safariOptions", ImmutableMap.of("w3c", false));

				capsSF.setCapability("name", testCaseName);
				capsSF.setCapability("build", browserstackFolder + environment + "_" + strDate);
				if (ciExecution.equals("true")) {
					capsSF.setCapability("project", ciCycleValue);
				}

				driver = new RemoteWebDriver(new URL(browserstackURL), capsSF);
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				driver.manage().deleteAllCookies();
				break;
				
			case "IOS":

				// *******************//***BrowserStack
				// AS****/**************************
				if (breakPoint.equalsIgnoreCase("AS")) {
					DesiredCapabilities capsiOS_AS = new DesiredCapabilities();
					capsiOS_AS.setCapability("browserName", driverName);
					capsiOS_AS.setCapability("os_version", osValue);
					capsiOS_AS.setCapability("device", deviceName);
					capsiOS_AS.setCapability("real_mobile", "true");
					capsiOS_AS.setCapability("acceptSslCerts", "true");
					capsiOS_AS.setCapability("browserstack.networkLogs", "false");
					capsiOS_AS.setCapability("browserstack.debug", "true");
					capsiOS_AS.setCapability("browserstack.local", "true");
					capsiOS_AS.setCapability("browserstack.video", "true");
					capsiOS_AS.setCapability("name", testCaseName);
				    capsiOS_AS.setCapability("browserstack.localIdentifier","gopal");
				    capsiOS_AS.setCapability("forcelocal", "true");
				   // bsLocalArgs.put("forcelocal", "true");

					capsiOS_AS.setCapability("build", browserstackFolder + environment + "_" + strDate);

					if (ciExecution.equals("true")) {
						capsiOS_AS.setCapability("project", ciCycleValue);
					}

					if (SystemUtils.IS_OS_LINUX || SystemUtils.IS_OS_SOLARIS || SystemUtils.IS_OS_AIX
							|| SystemUtils.IS_OS_UNIX) {
						System.getProperties().put("https.proxyHost",
								commonProp.get().getProperty("cl.linux.proxyhost.value"));
						System.getProperties().put("https.proxyPort",
								commonProp.get().getProperty("cl.linux.proxyport.value"));
					}

					androidDriver = new IOSDriver(new URL(browserstackURL), capsiOS_AS);
					driver = androidDriver;
					driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
					driver.manage().deleteAllCookies();

					Thread.sleep(6000);
					break;
				}

				else if (breakPoint.equalsIgnoreCase("M")) {

					DesiredCapabilities capsiOS_M = new DesiredCapabilities();
					capsiOS_M.setCapability("browserName", driverName);
					capsiOS_M.setCapability("os_version", osValue);
					capsiOS_M.setCapability("device", deviceName);
					capsiOS_M.setCapability("real_mobile", "true");
					capsiOS_M.setCapability("browserstack.video", "true");
					capsiOS_M.setCapability("acceptSslCerts", "true");
					capsiOS_M.setCapability("browserstack.networkLogs", "false");
					capsiOS_M.setCapability("browserstack.debug", "true");
					capsiOS_M.setCapability("browserstack.local", "true");
					capsiOS_M.setCapability("browserstack.localIdentifier","gopal");

					capsiOS_M.setCapability("name", testCaseName);

					capsiOS_M.setCapability("build", browserstackFolder + environment + "_" + strDate);

					if (ciExecution.equals("true")) {
						capsiOS_M.setCapability("project", ciCycleValue);
					}

					// System.getProperties().put("https.proxyHost",
					// "proxy.srvc.cvf");
					// System.getProperties().put("https.proxyPort", "3128");

					if (SystemUtils.IS_OS_LINUX || SystemUtils.IS_OS_SOLARIS || SystemUtils.IS_OS_AIX
							|| SystemUtils.IS_OS_UNIX) {
						System.getProperties().put("https.proxyHost",
								commonProp.get().getProperty("cl.linux.proxyhost.value"));
						System.getProperties().put("https.proxyPort",
								commonProp.get().getProperty("cl.linux.proxyport.value"));
					}
					
					androidDriver = new IOSDriver(new URL(browserstackURL), capsiOS_M);
					driver = androidDriver;
					driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
					driver.manage().deleteAllCookies();
					//driver = new RemoteWebDriver(new URL(browserstackURL), capsiOS_M);

					driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
					driver.manage().deleteAllCookies();

					Thread.sleep(6000);
				}
				break;

			default:
				// By default initiating the Firefox driver.
				driver = new FirefoxDriver();
				// Maximizing the webdriver browser window.
				driver.manage().window().maximize();
				driver.manage().deleteAllCookies();
			}

		}
		else 
		{
			switch (driverName) {
			
				case "CHROME":
				// Chrome driver set up
				DesiredCapabilities capabilities =  new DesiredCapabilities();
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--incognito");
				capabilities.setCapability(ChromeOptions.CAPABILITY, options);
				System.setProperty("webdriver.chrome.driver", rootDir + "/resources/drivers/chromedriver.exe");
				driver = new ChromeDriver(options); 
				// // Initiating the Chrome Driver.
				//ChromeOptions options = new ChromeOptions();
			//	options.addArguments("--disable-extensions");
				//driver = new ChromeDriver(options);
				// Maximizing the webdriver browser window.
				// Set the BP at browser screen level desktop
				// driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				driver.manage().deleteAllCookies();
				break;
				
			case "SAFARI":

				// To quit all opened safari broswers

				String cmd2 = "osascript -e \"tell app \\\"Safari\\\" to quit\"";

				List<String> command2 = new ArrayList<String>();

				command2.add("/bin/sh");

				command2.add("-c");

				command2.add(cmd2);

				ProcessBuilder pb2 = new ProcessBuilder(command2);

				pb2.start();

				Thread.sleep(3000);

				DesiredCapabilities cap = new DesiredCapabilities();
				
				cap.setCapability(CapabilityType.BROWSER_NAME, "SAFARI");
				
				driver = new SafariDriver();

				driver.manage().window().maximize();

				driver.manage().deleteAllCookies();

				

				// To make the browser window active on screen

				String cmd = "osascript -e \"tell app \\\"Safari\\\" to activate\"";

				List<String> command1 = new ArrayList<String>();

				command1.add("/bin/sh");

				command1.add("-c");

				command1.add(cmd);

				ProcessBuilder pb = new ProcessBuilder(command1);

				pb.start();

				log.info("SafariDriver Started");
				break;
				
			case "IOS":

				/*
				 * NOTE: 1. check iOS version and update:MobileCapabilityType.PLATFORM_VERSION
				 * 2. check UDID and update: MobileCapabilityType.UDID
				 * 
				 */
				Thread.sleep(1000);
				// Starts appium and webkit servers
				// StartServers_iOS.startAppiumServer();
				// StartServers_iOS.startWebKitProxyServer();

				log.info("iOS Device starting");

				DesiredCapabilities capabilitiesIOS = new DesiredCapabilities();

				capabilitiesIOS.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10.0.1");
				capabilitiesIOS.setCapability(MobileCapabilityType.PLATFORM_NAME, "iOS");
				capabilitiesIOS.setCapability(MobileCapabilityType.DEVICE_NAME, "iPad Simulator");
				capabilitiesIOS.setCapability(MobileCapabilityType.UDID, "4fb7b8fc5c810874677152add7aedcaddd359d77");
				capabilitiesIOS.setCapability(MobileCapabilityType.AUTO_WEBVIEW, true);

				capabilitiesIOS.setCapability("safariAllowPopups", false);
				capabilitiesIOS.setCapability("safariIgnoreFraudWarning", true);

				capabilitiesIOS.setCapability(MobileCapabilityType.BROWSER_NAME, "SAFARI");

				capabilitiesIOS.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITest");

				Thread.sleep(1000);

				driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilitiesIOS);

				Thread.sleep(10000);

				driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilitiesIOS);
				Thread.sleep(10000);

				log.info("iOS Device started");

				Thread.sleep(1000);

				// To verify webview
				driver.get("https://www.google.com");

				Thread.sleep(6000);

				break;

			case "IOS_SIMULATOR":

				Thread.sleep(5000);
				log.info("iOS Simulator starting");
				DesiredCapabilities capabilitiesIOS_Simulator = new DesiredCapabilities();

				capabilitiesIOS_Simulator.setCapability("platformName", "iOS");
				capabilitiesIOS_Simulator.setCapability("platformVersion", "10.2");
				capabilitiesIOS_Simulator.setCapability("safariAllowPopups", false);
				capabilitiesIOS_Simulator.setCapability("safariIgnoreFraudWarning", true);
				capabilitiesIOS_Simulator.setCapability("deviceName", "iPhone 6");
				capabilitiesIOS_Simulator.setCapability("browserName", "Safari");
				driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilitiesIOS_Simulator);
				log.info("iOS Simulator started");

				break;

			default:
				// By default initiating the Firefox driver.
				driver = new FirefoxDriver();
				// Maximizing the webdriver browser window.
				driver.manage().window().maximize();
				driver.manage().deleteAllCookies();
			}

		}
		return driver;
	}

	/**
	 * Method: This method will check whether the tab is high lighted After clicking
	 * on it
	 * 
	 * 
	 * @param prop
	 * @param ele
	 * @return
	 * @throws Exception
	 */
	public static boolean isTabLableHighLighted(String prop, WebElement ele) throws Exception {
		boolean flag = false;
		try {
			log.info("Txt color : " + TextProp.get().getProperty("tabLabelColor"));
			log.info("Lable color : " + ele.getCssValue(prop));
			if (ele.getCssValue(prop).replace(" ", "")
					.equalsIgnoreCase(TextProp.get().getProperty("tabLabelColor").replace(" ", ""))) {

				flag = true;
			} else {
				flag = false;
			}
		} catch (Exception e) {
			log.error("exception" + e);
		}

		return flag;
	}


	public static void waitForPageLoaded(WebDriver driver) {

		ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
			}
		};

		Wait<WebDriver> wait = new WebDriverWait(driver,50);
		try {
			wait.until(expectation);
		} catch (Throwable error) {
			Assert.assertFalse(false, "Timeout waiting for Page Load Request to complete.");
		}

	}

	/*
	 * This function: Kill's cmd from task manager if it is running Kill's adb.exe
	 * from task manager if it is running[Presently not using] Restarts appium
	 * server again using batch file in C drive
	 * 
	 */

	public static void KillAndStartAppium() throws IOException, InterruptedException {

		String line;
		String pidInfo = "";

		Process p = Runtime.getRuntime().exec(System.getenv("windir") + "\\system32\\" + "tasklist.exe");

		BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()));

		while ((line = input.readLine()) != null) {
			pidInfo += line;
		}

		input.close();

		if (pidInfo.contains("cmd.exe")) {
			log.info("cmd.exe PROCESS present, hence killing");
			Runtime.getRuntime().exec(KILL + "cmd.exe");

		}

		Thread.sleep(5000);

		String[] cmd = { "cmd.exe", "/C", "Start", "C:\\Jars\\Appium.bat" };

		Process pro = Runtime.getRuntime().exec(cmd);

		Thread.sleep(20000);

	}

	/**
	 * MethodName:getTestDataSetDetails
	 * 
	 * Description: This method retrieves Data Config details
	 * 
	 * @param dataSetConfig
	 * @throws Exception
	 */
	public static void getTestDataSetDetails(String dataSetConfig, String fileName) throws Exception {

		// Get Root directory
		String rootDir = System.getProperty("user.dir");
		Boolean flag = false;

		// Create instanses
		userInfoDSDetails.set(new UserInfoDSDetails());
		skuidDSDetails.set(new SKUID_DSDetails());
		paymentDSDetails.set(new PaymentDSDetails());
		payPalPaymentDSDetails.set(new PayPalPaymentDSDetails());
		boDSDetails.set(new BO_DSDetails());
		addressDSDetails.set(new Address_DSDetails());
		wmsInfoDSDetails.set(new WMSInfoDSDetails());
		adyenInfoDSDetails.set(new AdyenInfoDSDetails());
		billingaddressDSDetails.set(new BillingAddress_DSDetails());
		pimInfoDSDetails.set(new PIM_DSDetails());
		//sfccDSDetails.set(new SFCC_DSDetails());
		
		String[] SKUDataSetArray = new String[10];

		// Split dataSetConfig by ","
		String[] dataSet_array = dataSetConfig.split(",");

		for (int i = 0; i < dataSet_array.length; i++) {

			// Add SKU dataset to array
			if (dataSet_array[i].contains("GDS_")) {
				flag = true;
				SKUDataSetArray[i] = dataSet_array[i];

			}
			
			else {

				// Split dataset by "-" (sheet name and version)
				String[] str_array = dataSet_array[i].split("-");    // SFCC_DS-V1
				if (str_array[0].equalsIgnoreCase("PAYMENT_DS")) {
					paymentDSDetails.get().setDataVersion(ExcelReader.getDataConfigDetails(rootDir + "/" + fileName,
							"PAYMENT_DS", "DATA_VERSION", str_array[1]));
					paymentDSDetails.get().setLocale(ExcelReader.getDataConfigDetails(rootDir + "/" + fileName,
							"PAYMENT_DS", "LOCALE", str_array[1]));
					paymentDSDetails.get().setCardType(ExcelReader.getDataConfigDetails(rootDir + "/" + fileName,
							"PAYMENT_DS", "CARD_TYPE", str_array[1]));
					paymentDSDetails.get().setCardNumber(ExcelReader.getDataConfigDetails(rootDir + "/" + fileName,
							"PAYMENT_DS", "CARD_NUMBER", str_array[1]));
					paymentDSDetails.get().setCardHolderName(ExcelReader.getDataConfigDetails(rootDir + "/" + fileName,
							"PAYMENT_DS", "CARDHOLDER_NAME", str_array[1]));
					paymentDSDetails.get().setCardExpiryDate(ExcelReader.getDataConfigDetails(rootDir + "/" + fileName, 
							"PAYMENT_DS", "CARDEXPIRY_DATE", str_array[1]));
					paymentDSDetails.get().setCardCVV(ExcelReader.getDataConfigDetails(rootDir + "/" + fileName,
							"PAYMENT_DS", "CARD_CVV", str_array[1]));
					paymentDSDetails.get().set3DS_Username(ExcelReader.getDataConfigDetails(
							rootDir + "/" + fileName, "PAYMENT_DS", "3DS_USERNAME", str_array[1]));
					paymentDSDetails.get().set3DS_Password(ExcelReader.getDataConfigDetails(
							rootDir + "/" + fileName, "PAYMENT_DS", "3DS_PASSWORD", str_array[1]));
				}
				if (str_array[0].equalsIgnoreCase("USERINFO_DS")) {

					userInfoDSDetails.get().setDataVersion(ExcelReader.getDataConfigDetails(rootDir + "/" + fileName,
							"USERINFO_DS", "DATA_VERSION", str_array[1]));
					userInfoDSDetails.get().setNamePrefix(ExcelReader.getDataConfigDetails(rootDir + "/" + fileName,
							"USERINFO_DS", "NAME_PREFIX", str_array[1]));
					userInfoDSDetails.get().setFirstName(ExcelReader.getDataConfigDetails(rootDir + "/" + fileName,
							"USERINFO_DS", "FIRSTNAME", str_array[1]));
					userInfoDSDetails.get().setLastName(ExcelReader.getDataConfigDetails(rootDir + "/" + fileName,
							"USERINFO_DS", "LASTNAME", str_array[1]));
					userInfoDSDetails.get().setAdddress1(ExcelReader.getDataConfigDetails(rootDir + "/" + fileName,
							"USERINFO_DS", "ADDRESS1", str_array[1]));
					userInfoDSDetails.get().setCity(ExcelReader.getDataConfigDetails(rootDir + "/" + fileName,
							"USERINFO_DS", "CITY", str_array[1]));
					userInfoDSDetails.get().setState(ExcelReader.getDataConfigDetails(rootDir + "/" + fileName,
							"USERINFO_DS", "STATE", str_array[1]));
					userInfoDSDetails.get().setPostalCode(ExcelReader.getDataConfigDetails(rootDir + "/" + fileName,
							"USERINFO_DS", "POSTALCODE", str_array[1]));
					userInfoDSDetails.get().setPhoneNumber(ExcelReader.getDataConfigDetails(rootDir + "/" + fileName,
							"USERINFO_DS", "PHONE_NUMBER", str_array[1]));
					userInfoDSDetails.get().setUserName(ExcelReader.getDataConfigDetails(rootDir + "/" + fileName,
							"USERINFO_DS", "USER_NAME", str_array[1]));
					userInfoDSDetails.get().setEmailDomain(ExcelReader.getDataConfigDetails(rootDir + "/" + fileName,
							"USERINFO_DS", "EMAILDOMAIN", str_array[1]));
					userInfoDSDetails.get().setPassword(ExcelReader.getDataConfigDetails(rootDir + "/" + fileName,
							"USERINFO_DS", "PASSWORD", str_array[1]));
					userInfoDSDetails.get().setConfirmPassword(ExcelReader.getDataConfigDetails(rootDir + "/" + fileName,
							"USERINFO_DS", "CONFIRMPASSWORD", str_array[1]));
					userInfoDSDetails.get().setAppPassword(ExcelReader.getDataConfigDetails(rootDir + "/" + fileName,
							"USERINFO_DS", "APP_PASSWORD", str_array[1]));
				}
				if (str_array[0].equalsIgnoreCase("PAYPALPAYMENT_DS")) {

					payPalPaymentDSDetails.get().setDataVersion(ExcelReader.getDataConfigDetails(
							rootDir + "/" + fileName, "PAYPALPAYMENT_DS", "DATA_VERSION", str_array[1]));
					payPalPaymentDSDetails.get().setLocale(ExcelReader.getDataConfigDetails(rootDir + "/" + fileName,
							"PAYPALPAYMENT_DS", "LOCALE", str_array[1]));
					payPalPaymentDSDetails.get().setPayPalPassword(ExcelReader.getDataConfigDetails(
							rootDir + "/" + fileName, "PAYPALPAYMENT_DS", "PAYPAL_PASSWORD", str_array[1]));
					payPalPaymentDSDetails.get().setPayPalUsername(ExcelReader.getDataConfigDetails(
							rootDir + "/" + fileName, "PAYPALPAYMENT_DS", "PAYPAL_USERNAME", str_array[1]));
				}
				if (str_array[0].equalsIgnoreCase("BO_DS")) {

					boDSDetails.get().setDataVersion(ExcelReader.getDataConfigDetails(
							rootDir + "/" + fileName, "BO_DS", "DATA_VERSION", str_array[1]));
					boDSDetails.get().setBO_URL(ExcelReader.getDataConfigDetails(
							rootDir + "/" + fileName, "BO_DS", "BO_URL", str_array[1]));
					boDSDetails.get().setBO_Username(ExcelReader.getDataConfigDetails(
							rootDir + "/" + fileName, "BO_DS", "BO_USERNAME", str_array[1]));
					boDSDetails.get().setBO_Password(ExcelReader.getDataConfigDetails(
							rootDir + "/" + fileName, "BO_DS", "BO_PASSWORD", str_array[1]));
				}
				if (str_array[0].equalsIgnoreCase("ADDRESS_DS")) {

					addressDSDetails.get().setDataVersion(ExcelReader.getDataConfigDetails(
							rootDir + "/" + fileName, "ADDRESS_DS", "DATA_VERSION", str_array[1]));
					addressDSDetails.get().setAddressName(ExcelReader.getDataConfigDetails(
							rootDir + "/" + fileName, "ADDRESS_DS", "ADDRESS_NAME", str_array[1]));
					addressDSDetails.get().setNamePrefix(ExcelReader.getDataConfigDetails(
							rootDir + "/" + fileName, "ADDRESS_DS", "NAME_PREFIX", str_array[1]));
					addressDSDetails.get().setFirstName(ExcelReader.getDataConfigDetails(
							rootDir + "/" + fileName, "ADDRESS_DS", "FIRST_NAME", str_array[1]));
					addressDSDetails.get().setLastName(ExcelReader.getDataConfigDetails(
							rootDir + "/" + fileName, "ADDRESS_DS", "LAST_NAME", str_array[1]));
					addressDSDetails.get().setAddress1(ExcelReader.getDataConfigDetails(
							rootDir + "/" + fileName, "ADDRESS_DS", "ADDRESS1", str_array[1]));
					addressDSDetails.get().setPostcode(ExcelReader.getDataConfigDetails(
							rootDir + "/" + fileName, "ADDRESS_DS", "POSTCODE", str_array[1]));
					addressDSDetails.get().setCity(ExcelReader.getDataConfigDetails(
							rootDir + "/" + fileName, "ADDRESS_DS", "CITY", str_array[1]));
					addressDSDetails.get().setCountry(ExcelReader.getDataConfigDetails(
							rootDir + "/" + fileName, "ADDRESS_DS", "COUNTRY", str_array[1]));
					addressDSDetails.get().setPhoneNumber(ExcelReader.getDataConfigDetails(
							rootDir + "/" + fileName, "ADDRESS_DS", "PHONE_NUMBER", str_array[1]));
				}
				if (str_array[0].equalsIgnoreCase("WMS_DS"))
				{ 
					wmsInfoDSDetails.get().setDataVersion(ExcelReader.getDataConfigDetails(
					rootDir + "/" + fileName, "WMS_DS", "DATA_VERSION", str_array[1]));
					wmsInfoDSDetails.get().setWMSURL(ExcelReader.getDataConfigDetails(
							rootDir + "/" + fileName, "WMS_DS", "WMS_URL", str_array[1]));
					wmsInfoDSDetails.get().setWmsUsername(ExcelReader.getDataConfigDetails(rootDir + "/" + fileName,
						"WMS_DS", "WMS_USERNAME", str_array[1]));
					wmsInfoDSDetails.get().setWmsPassword(ExcelReader.getDataConfigDetails(
						rootDir + "/" + fileName, "WMS_DS", "WMS_PASSWORD", str_array[1]));
				}
				if (str_array[0].equalsIgnoreCase("ADYEN_DS")) 
				{ 
					adyenInfoDSDetails.get().setDataVersion(ExcelReader.getDataConfigDetails(
						rootDir + "/" + fileName, "ADYEN_DS", "DATA_VERSION", str_array[1]));
					adyenInfoDSDetails.get().setAdyenUrl(ExcelReader.getDataConfigDetails(rootDir + "/" + fileName,
							"ADYEN_DS", "ADYEN_URL", str_array[1]));
					adyenInfoDSDetails.get().setAdyenUsername(ExcelReader.getDataConfigDetails(rootDir + "/" + fileName,
						"ADYEN_DS", "ADYEN_USERNAME", str_array[1]));
					adyenInfoDSDetails.get().setAdyenAccount(ExcelReader.getDataConfigDetails(
						rootDir + "/" + fileName, "ADYEN_DS", "ADYEN_ACCOUNT", str_array[1]));
					adyenInfoDSDetails.get().setAdyenPassword(ExcelReader.getDataConfigDetails(
						rootDir + "/" + fileName, "ADYEN_DS", "ADYEN_PASSWORD", str_array[1]));
				}
				if (str_array[0].equalsIgnoreCase("BILLINGADDRESS_DS")) {

					billingaddressDSDetails.get().setDataVersion(ExcelReader.getDataConfigDetails(
							rootDir + "/" + fileName, "BILLINGADDRESS_DS", "DATA_VERSION", str_array[1]));
					billingaddressDSDetails.get().setAddressName(ExcelReader.getDataConfigDetails(
							rootDir + "/" + fileName, "BILLINGADDRESS_DS", "ADDRESS_NAME", str_array[1]));
					billingaddressDSDetails.get().setNamePrefix(ExcelReader.getDataConfigDetails(
							rootDir + "/" + fileName, "BILLINGADDRESS_DS", "NAME_PREFIX", str_array[1]));
					billingaddressDSDetails.get().setFirstName(ExcelReader.getDataConfigDetails(
							rootDir + "/" + fileName, "BILLINGADDRESS_DS", "FIRST_NAME", str_array[1]));
					billingaddressDSDetails.get().setLastName(ExcelReader.getDataConfigDetails(
							rootDir + "/" + fileName, "BILLINGADDRESS_DS", "LAST_NAME", str_array[1]));
					billingaddressDSDetails.get().setAddress1(ExcelReader.getDataConfigDetails(
							rootDir + "/" + fileName, "BILLINGADDRESS_DS", "ADDRESS1", str_array[1]));
					billingaddressDSDetails.get().setPostcode(ExcelReader.getDataConfigDetails(
							rootDir + "/" + fileName, "BILLINGADDRESS_DS", "POSTCODE", str_array[1]));
					billingaddressDSDetails.get().setCity(ExcelReader.getDataConfigDetails(
							rootDir + "/" + fileName, "BILLINGADDRESS_DS", "CITY", str_array[1]));
					billingaddressDSDetails.get().setCountry(ExcelReader.getDataConfigDetails(
							rootDir + "/" + fileName, "BILLINGADDRESS_DS", "COUNTRY", str_array[1]));
					billingaddressDSDetails.get().setPhoneNumber(ExcelReader.getDataConfigDetails(
							rootDir + "/" + fileName, "BILLINGADDRESS_DS", "PHONE_NUMBER", str_array[1]));
				}
				if (str_array[0].equalsIgnoreCase("PIM_DS"))
                {
                    pimInfoDSDetails.get().setDataVersion(ExcelReader.getDataConfigDetails(
                        rootDir + "/" + fileName, "PIM_DS", "DATA_VERSION", str_array[1]));
                    pimInfoDSDetails.get().setpimUrl(ExcelReader.getDataConfigDetails(rootDir + "/" + fileName,
                            "PIM_DS", "PIM_URL", str_array[1]));
                    pimInfoDSDetails.get().setpimUsername(ExcelReader.getDataConfigDetails(rootDir + "/" + fileName,
                        "PIM_DS", "PIM_USERNAME", str_array[1]));
                    pimInfoDSDetails.get().setpimPassword(ExcelReader.getDataConfigDetails(
                        rootDir + "/" + fileName, "PIM_DS", "PIM_PASSWORD", str_array[1]));
                }
				
				if (str_array[0].equalsIgnoreCase("SKUID_DS"))
                {
					skuidDSDetails.get().setDataVersion(ExcelReader.getDataConfigDetails(
                        rootDir + "/" + fileName, "SKUID_DS", "DATA_VERSION", str_array[1]));
					skuidDSDetails.get().setSkuID(ExcelReader.getDataConfigDetails(rootDir + "/" + fileName,
                            "SKUID_DS", "SKU_ID", str_array[1]));
					skuidDSDetails.get().setQTY(ExcelReader.getDataConfigDetails(rootDir + "/" + fileName,
                        "SKUID_DS", "QTY", str_array[1]));
					skuidDSDetails.get().setDescription(ExcelReader.getDataConfigDetails(
                        rootDir + "/" + fileName, "SKUID_DS", "DESCRIPTION", str_array[1]));
                }

			}

			
		
		}

	}


	public static ThreadLocal<UserInfoDSDetails> getUserInfoDSDetails() {
		return userInfoDSDetails;
	}

	public static void setUserInfoDSDetails(ThreadLocal<UserInfoDSDetails> userInfoDSDetails) {
		CustomFun.userInfoDSDetails = userInfoDSDetails;
	}

	public static ThreadLocal<PaymentDSDetails> getPaymentDSDetails() {
		return paymentDSDetails;
	}

	public static void setPaymentDSDetails(ThreadLocal<PaymentDSDetails> paymentDSDetails) {
		CustomFun.paymentDSDetails = paymentDSDetails;
	}

	public static ThreadLocal<SKUID_DSDetails> getskuidDSDetails() {
		return skuidDSDetails;
	}

	public static void setskuidDSDetails(ThreadLocal<SKUID_DSDetails> sKUdataSetList) {
		CustomFun.skuidDSDetails = sKUdataSetList;
	}

	public static ThreadLocal<PayPalPaymentDSDetails> getPayPalPaymentDSDetails() {
		return payPalPaymentDSDetails;
	}

	public static void setPayPalPaymentDSDetails(ThreadLocal<PayPalPaymentDSDetails> payPalPaymentDSDetails) {
		CustomFun.payPalPaymentDSDetails = payPalPaymentDSDetails;
	}
	
	public static ThreadLocal<BO_DSDetails> getBODSDetails() {
		return boDSDetails;
	}
	
	public static void setBODSDetails(ThreadLocal<BO_DSDetails> boDSDetails) {
		CustomFun.boDSDetails = boDSDetails;
	}
	
	public static ThreadLocal<Address_DSDetails> getAddressDSDetails() {
		return addressDSDetails;
	}
	
	public static void setAddressDSDetails(ThreadLocal<Address_DSDetails> addressDSDetails) {
		CustomFun.addressDSDetails = addressDSDetails;
	}
	
	public static ThreadLocal<BillingAddress_DSDetails> getBillingAddressDSDetails() {
		return billingaddressDSDetails;
	}
	
	public static void setBillingAddressDSDetails(ThreadLocal<BillingAddress_DSDetails> billingaddressDSDetails) {
		CustomFun.billingaddressDSDetails = billingaddressDSDetails;
	}
	
	public static ThreadLocal<WMSInfoDSDetails> getWMSInfoDSDetails() {
		return wmsInfoDSDetails;
	}
	
	public static void setWMSInfoDSDetails(ThreadLocal<WMSInfoDSDetails> wmsInfoDSDetails) {
		CustomFun.wmsInfoDSDetails = wmsInfoDSDetails;
	}
	
	public static ThreadLocal<AdyenInfoDSDetails> getAdyenInfoDSDetails() {
		return adyenInfoDSDetails;
	}
	
	public static void setAdyenInfoDSDetails(ThreadLocal<AdyenInfoDSDetails> adyenInfoDSDetails) {
		CustomFun.adyenInfoDSDetails = adyenInfoDSDetails;
	}
	
	public static ThreadLocal<PIM_DSDetails> getPIMInfoDSDetails() {
        return pimInfoDSDetails;
    }
    
    public static void setPIMInfoDSDetails(ThreadLocal<PIM_DSDetails> pimInfoDSDetails) {
        CustomFun.pimInfoDSDetails =pimInfoDSDetails;
    }
	
	/**
	 * This Function used to open new tab and switch to new tab
	 * 
	 * @param driver: WebDriver instance.
	 * @return 
	 * @throws InterruptedException 
	 */

	public static WebDriver OpenNewTabAndSwitchToNewTab(WebDriver driver, String TabIndex) throws InterruptedException
	{
		 //Open New Tab
		 ((JavascriptExecutor)driver).executeScript("window.open()");
		 tabs = new ArrayList<String>(driver.getWindowHandles());
		 //Switch to other Tab
		 Integer index=Integer.valueOf(TabIndex);
	     driver.switchTo().window(tabs.get(index));
	     Thread.sleep(2000);
	     return driver;
	}
	

	/**
	 * This Function used to switch to desired tab
	 * 
	 * @param driver: WebDriver instance.
	 * @return 
	 * @throws InterruptedException 
	 */

	public static WebDriver SwitchToSpecificTab(WebDriver driver, String TabIndex) throws InterruptedException
	{
		 tabs = new ArrayList<String>(driver.getWindowHandles());
		 //Switch to other Tab
		 Integer index=Integer.valueOf(TabIndex);
	     driver.switchTo().window(tabs.get(index));
	     Thread.sleep(2000);
	     return driver;
	}
	/**
	* MethodName:isImgSelected Description: This function checks image is selected
	* or not
	*
	* @param ele
	* : WebElement
	* @return
	* @throws Exception
	*/
	public static boolean isRadioButtonSelected(WebElement ele) throws Exception {
	boolean match = false;
	if ((ele.getAttribute("class")).contains("selected")) {
	match = true;
	}
	return match;
	}
	

}
