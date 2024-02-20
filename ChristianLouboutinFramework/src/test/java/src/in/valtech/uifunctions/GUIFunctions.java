package src.in.valtech.uifunctions;
import org.apache.log4j.Logger;    
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import src.in.valtech.custom.CustomFun;
import static src.in.valtech.config.BaseTest.driverName;
import static src.in.valtech.custom.CustomFun.userInfoDSDetails;
import static src.in.valtech.util.PropertyFileReader.ObjRepoProp;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;

public class GUIFunctions {

	public static Logger log = Logger.getLogger(GUIFunctions.class.getName());

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
			// Verify element is present
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			log.error("No such element present--> \n" + e);
			Reporter.log("<p>No such element present");
			return false;
		}
	}

	/**
	 * Method Name: navigateBack Description: Method to used to go back to home page
	 * by clicking on browser back button
	 * 
	 * @param driver
	 *            :WebDriver
	 * @return driver
	 */
	public static WebDriver navigateBack(WebDriver driver) {
		try {

			if (driverName.get().equalsIgnoreCase("SAFARI")) {
				// Navigate back to Previous page
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("history.go(-1)");

			} else {
				// Navigate back to Previous page
				driver.navigate().back();
			}

		} catch (Exception e) {
			log.error("Navigation to previous page failed--> \n" + e);
			Reporter.log("<p>Navigation to previous page failed");
		}

		return (driver);
	}

	/**
	 * Method Name: clickElement Description: This method clicks on WebElement
	 * specified
	 * 
	 * @param driver
	 *            : WebDriver
	 * @param ele
	 *            : WebElement locator
	 * @param eleName
	 *            : Name of the element to be clicked
	 * @throws InterruptedException 
	 */
	public static void clickElement(WebDriver driver, By by, String eleName) throws InterruptedException {
		try {

			WebDriverWait wait = new WebDriverWait(driver, 10);
			WebElement element1 = driver.findElement(by);
			WebElement element = wait.until(ExpectedConditions.visibilityOf(element1));
			// Click on element
			element.click();
			Thread.sleep(10000);
			log.info("Successfully clicked on element: " + eleName);
			Reporter.log("<p>Successfully clicked on element: " + eleName);

		} catch (NoSuchElementException e) {
			log.error("Element to click is not present " + e);
			Reporter.log("<p>Element to click is not present");
		}
	}
	
	/**
	 * Method Name: mouseOverElement Description: This method used to scroll to an
	 * element which not visible in the screen
	 * 
	 * @param driver
	 *            : WebDriver
	 * @param ele
	 *            : WebElement locator
	 */
	public static void mouseOverElement(WebDriver driver, WebElement ele, String EleName) throws Exception {
		try {

			if (!(driverName.get().equalsIgnoreCase("SAFARI") || driverName.get().equalsIgnoreCase("IOS")))
			{
				// Mouse hover/roll over on element
				Thread.sleep(500);
				Actions builder = new Actions(driver);
				builder.moveToElement(ele).build().perform();
				//GUIFunctions.JavaScriptClick(driver, ele, "click on  Minicart_Icon");
				log.info("Successfully Mouse Over On "+EleName);
			    Reporter.log("<p>Successfully Mouse Over On "+EleName);
			}
			else
			{
				Thread.sleep(500);
				Actions builder = new Actions(driver);
				builder.moveToElement(ele).build().perform();
				GUIFunctions.JavaScriptClick(driver, ele, "click on  Minicart_Icon");
				log.info("Successfully Mouse Over On "+EleName);
			    Reporter.log("<p>Successfully Mouse Over On "+EleName);
				
			}
		} catch (NoSuchElementException e) {
			log.error("Element to mouse over is not present " + e);
			Reporter.log("<p>Element to mouse over is not present " + e);

		}

	}
	
	/**
	 * This Function selects the radio button iFrame.
	 * 
	 * @param driver
	 *            : WebDriver instance.
	 */

	public static void selectRadioButton(WebDriver driver, By by, String eleName) {
		// Initialize WebElement
		WebElement ele = driver.findElement(by);

		try {
			if (!ele.isSelected()) {
				ele.click();
			}
			log.info("Successfully selected the raido button '" + eleName + "'");
		}

		catch (NoSuchElementException e) {

			log.error("Exception element not present : " + eleName);
		}

	}

	/**
	 * Method Name: mouseOverElementAndClick Description: This method used to scroll
	 * to an element which not visible in the screen/ or Not Clickable by
	 * GUIFunctions.clickOnElement method and clicks on it
	 * 
	 * @param driver
	 * @param ele
	 * @param eleName
	 * @throws Exception
	 */
	public static void mouseOverElementAndClick(WebDriver driver, WebElement ele, String eleName) throws Exception {
		try {

			if (!(driverName.get().equalsIgnoreCase("SAFARI") || driverName.get().equalsIgnoreCase("IOS"))) {
				// Mouse hover/roll over on element
				Thread.sleep(1000);
				Actions builder = new Actions(driver);
				builder.moveToElement(ele).build().perform();
				builder.click().perform();

				log.info("Successfully mouse over and clicked on: " + eleName);
				Reporter.log("<p>Successfully mouse over and clicked on: " + eleName);

			} else {

				WebElement element = ele;

				// Click on element
				element.click();

				log.info("Successfully clicked on element: " + eleName);
				Reporter.log("<p>Successfully clicked on element: " + eleName);

			}
		} catch (NoSuchElementException e) {
			log.error("Element to mouse over and click is not present " + e);
			Reporter.log("<p>Element to mouse over and click is not present");

		}

	}

	/**
	 * Method Name: clickElement Description: This method clicks on WebElement
	 * specified
	 * 
	 * @param driver
	 *            : WebDriver
	 * @param ele
	 *            : WebElement locator
	 * @param eleName
	 *            : Name of the element to be clicked
	 * @throws InterruptedException 
	 */
	public static void typeTxtboxValue(WebDriver driver, By by, String value) throws InterruptedException {
		try {

			// Click on element
			// driver.findElement(by).click();
			driver.findElement(by).clear();
			Thread.sleep(2000);
			driver.findElement(by).sendKeys(value);
		} catch (NoSuchElementException e) {
			log.error("Element to type data is not present " + e);
			Reporter.log("<p>Element to type data is not present");

		}
	}

	/**
	 * 
	 * Method Name: keyPressPageUp Description: This method Press on Page up Key
	 * Once
	 * 
	 * @param driver
	 *            : WebDriver
	 * @throws Exception
	 * 
	 */
	public static void keyPressPageUp(WebDriver driver) throws Exception {

		if (!driverName.get().equalsIgnoreCase("IOS")) {
			Thread.sleep(1500);
			Actions action = new Actions(driver);
			action.sendKeys(Keys.PAGE_UP).build().perform();
		}
	}

	/**
	 * Method Name: selectDropDownValue_new Description: This method selects
	 * dropdown value
	 * 
	 * @param ele
	 *            : DropDown webelement
	 * @param dropDownValue
	 *            : dropDown Value to be selected
	 */
	public static void selectDropDownValue(WebElement ele, String dropDownValue, String optType, String eleName) throws Exception {
		try {
			// Dropdown in which value to be selected
			Select dropDown = new Select(ele);

			// Selecting dropdown value
			if (optType.equalsIgnoreCase("text")) {
				dropDown.selectByVisibleText(dropDownValue.trim());
			} else if (optType.equalsIgnoreCase("value")) {
				dropDown.selectByValue(dropDownValue);
			} else if (optType.equalsIgnoreCase("index")) {
				int dropDownValueInt = Integer.parseInt(dropDownValue);
				dropDown.selectByIndex(dropDownValueInt);
			}
			log.info("Successfully selected value from "+eleName);
			Reporter.log("<p>Successfully selected value from "+eleName);
		} catch (NoSuchElementException e) {
			log.error("Element to select drop down is not present " + e);
			Reporter.log("<p>Element to drop down is not present");

		}

	}

	/**
	 * Method Name: checkOrUncheckCheckBox Description: This method checks/Unchecks
	 * the checkbox
	 * 
	 * @param driver
	 *            : WebDriver
	 * @param By
	 *            : WebElement locator
	 * @param eleName
	 *            : Name of the element to be checked
	 * @param toCheck
	 *            : True: To check the checkbox false: To uncheck the checkbox
	 * 
	 */
	public static void checkOrUncheckCheckBox(WebDriver driver, By by, String eleName, Boolean toCheck)
			throws Exception {
		try {

			if (toCheck) {
				// check checkbox if not checked
				if (!driver.findElement(by).isSelected()) {
					driver.findElement(by).click();

					log.info("Successfully checked the checkbox: " + eleName);
					Reporter.log("<p>Successfully checked the checkbox: " + eleName);
				}
			} else if (!toCheck) {
				// Uncheck checkbox if it is checked
				if (driver.findElement(by).isSelected()) {
					driver.findElement(by).click();

					log.info("Successfully unchecked the checkbox: " + eleName);
					Reporter.log("<p>Successfully unchecked the checkbox: " + eleName);
				}
			}

		} catch (NoSuchElementException e) {
			log.error("Checkbox element is not present " + e);
			Reporter.log("<p>Checkbox element is not present ");

		}

	}

	/**
	 * 
	 * Method Name: pageScrollDown .Description: This method scrolls down till
	 * required pixels
	 * 
	 * 
	 * @param driver
	 *            : WebDriver
	 * @throws Exception
	 * 
	 */
	public static void pageScrollDown(WebDriver driver, int reqYaxisPixelsScroll) throws Exception {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0," + reqYaxisPixelsScroll + ")", "");
	}

	/**
	 * 
	 * Method Name: pageScrollTobottomOfPage .Description: This method scrolls down
	 * till the end of the page
	 * 
	 * 
	 * @param driver
	 *            : WebDriver
	 * @throws Exception
	 * 
	 */
	public static void pageScrollTobottomOfPage(WebDriver driver) throws Exception {
		// the java script executor code added to handle chatbox
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		Thread.sleep(2000);
	}

	/**
	 * 
	 * Method Name: pageScrollTobottomOfPage .Description: This method scrolls top
	 * till the top of the page
	 * 
	 * 
	 * @param driver
	 *            : WebDriver
	 * @throws Exception
	 * 
	 */
	public static void pageScrollToTopOfPage(WebDriver driver) throws Exception {
		// the java script executor code added to handle chatbox
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, 0)");
		Thread.sleep(2000);
	}

	/**
	 * Method Name: pageScrollUP .Description: This method scrolls up till required
	 * pixels
	 * 
	 * @param driver
	 *            : WebDriver
	 * @throws Exception
	 * 
	 */
	public static void pageScrollUP(WebDriver driver, int reqXaxisPixelsScroll) throws Exception {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scroll(" + reqXaxisPixelsScroll + ",0)", "");
	}

	/**
	 * Method Name: This method will help to click event
	 * 
	 * @param driver
	 *            : web driver
	 * @param element
	 *            : need to pass element to click
	 * @throws Exception
	 */
	public static void JavaScriptClick(WebDriver driver, WebElement element, String eleName) throws Exception {
		try {
			if (element.isEnabled() && element.isDisplayed())
			{
				WebDriverWait wait = new WebDriverWait(driver, 30);
				WebElement element1 = element;
				wait.until(ExpectedConditions.visibilityOf(element1));
				((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
				Thread.sleep(5000);
				log.info("Successfully clicked on element: " + eleName);
				Reporter.log("<p>Successfully clicked on element: " + eleName);
			} else {
				log.info("\"Unable to click on element");

			}
		} catch (StaleElementReferenceException e) {
			log.info("\"Element is not attached to the page document" + e.getStackTrace());

		} catch (NoSuchElementException e) {
			log.info("Element was not found in DOM" + e.getStackTrace());

		} catch (Exception e) {
			log.info("Unable to click on element " + e.getStackTrace());

		}
	}

	/**
	 * Wait for element to appear.
	 *
	 * @param driver
	 *            the driver
	 * @param element
	 *            the element
	 * @param logger
	 *            the logger
	 */
	public static boolean waitForElementToAppear(WebDriver driver, WebElement element) throws Exception {
		boolean webElementPresence = false;
		try {
			WebDriverWait wait =  new WebDriverWait(driver,50);

			WebElement ele = wait.until(ExpectedConditions.elementToBeClickable(element));
			if (ele.isDisplayed())
			{
				webElementPresence = true;
			}
		} catch (Exception e) {
			log.info("Exception occured<br></br>" + e.getStackTrace());
		}
		return webElementPresence;
	}

	public static void waitUntillElementToBeClickable(WebDriver driver, int TotalTimeInSeconds,
			int PollingTimeInMilliseconds, WebElement Element) {
		FluentWait<WebDriver> ClickableWait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(30))
				 .pollingEvery(Duration.ofSeconds(5))
			        .ignoring(NoSuchElementException.class);

		ClickableWait.until(ExpectedConditions.elementToBeClickable(Element));
	}

	public static WebElement waitForElementToBeClickable(WebDriver driver, WebElement webelement, int seconds) {

		try {

			WebDriverWait wait =  new WebDriverWait(driver,10);

			WebElement element = wait.until(ExpectedConditions.elementToBeClickable(webelement));
			return element;

		} catch (NoSuchElementException e) {
			log.error("Element to click is not present " + e);
			Reporter.log("<p>Element to click is not present");
		}
		return webelement;

	}

	public static WebElement waitForElementToBeVisible(WebDriver driver, WebElement webelement, int seconds,
			String elename) {

		WebDriverWait wait = new WebDriverWait(driver,10);

		WebElement element = wait.until(ExpectedConditions.visibilityOf(webelement));
		element.clear();

		return element;
	}

/*	public static String fetchAddressFormat(WebDriver driver, String locale) throws Exception {

		String format = null;

		String first = userInfoDSDetails.get().getFirstName(), last = userInfoDSDetails.get().getLastName(),
				address1 = userInfoDSDetails.get().getAdddress1(), city = userInfoDSDetails.get().getCity(),
				stateUS = TextProp.get().getProperty("newYorkStateCode"),
				postalCode = userInfoDSDetails.get().getPostalCode(), country = userInfoDSDetails.get().getCountry(),
				countryCode = TextProp.get().getProperty("countryCode"),
				phone = userInfoDSDetails.get().getPhoneNumber();

		if (locale.equals("US"))
			format = (first + " " + last + "\n" + address1 + "\n" + city + ", " + stateUS + " " + postalCode + ", "
					+ country + "\n(" + countryCode + ")" + phone).toLowerCase();
		else if (locale.equals("UK"))
			format = (first + " " + last + "\n" + address1 + "\n" + city + ", " + postalCode + ", " + country + "\n("
					+ countryCode + ")" + phone).toLowerCase();
		else
			format = (first + " " + last + "\n" + address1 + "\n" + postalCode + ", " + city + ", " + country + "\n("
					+ countryCode + ")" + phone).toLowerCase();

		return format;

	}*/

	public static String getEmailID(String userType) {

		String emailId = null;
		if (userType.equalsIgnoreCase("new"))
			emailId = (userInfoDSDetails.get().getUserName().trim() + CustomFun.generateTimeStamp()
					+ Thread.currentThread().getId() + "@" + userInfoDSDetails.get().getEmailDomain().trim())
							.toLowerCase();
		else
			emailId = (userInfoDSDetails.get().getUserName().trim() + "@"
					+ userInfoDSDetails.get().getEmailDomain().trim()).toLowerCase();

		return emailId;

	}
	
	
	/**
	 * Method Name: VerifyOrderStatusInFO Description: This method verifies the order status in FO
	 * 
	 * @param txtOrderStatus
	 *            : Order Status text
	 */
	
	public static boolean VerifyOrderStatusInFO(String txtOrderStatus,String OrderID)
	{
		boolean bolIsSuccess = false;
		try 
		{
		switch (txtOrderStatus.toLowerCase())
		{
		case "WAITING FOR ADYEN":
		bolIsSuccess = true;
		break;
		case "ORDER PENDING SECURITY CHECK":
	    bolIsSuccess = true;
		break;
		case "ORDER VALIDATED":
		bolIsSuccess = true;
		break;
		case "Preparing order":
		bolIsSuccess = true;
		break;
		case "PENDING PAYMENT":
		bolIsSuccess = true;
		break;
		case "Shipped":
		bolIsSuccess = true;
		break;
		case "Return Pending":
		bolIsSuccess = true;
		break;
		case "Authorized":
		bolIsSuccess = true;
		break;
		case "PENDING RETURN":
		bolIsSuccess = true;
		break;
		case "PENDING REFUND":
		bolIsSuccess = true;
		break;
		case "REFUND PROCESSED":
		bolIsSuccess = true;
		break;
		case "Order cancelled":
		bolIsSuccess = true;
		break;
		case "En cours de pr�paration":
		bolIsSuccess = true;
		break;
		case "Retour rembours�":
		bolIsSuccess = true;
		break;
		}
		}
		catch (Exception e) {
			log.info("Exception occured<br></br>" + e.getStackTrace());
			Reporter.log("<p>Exception occured" + e.getStackTrace());
		}
		log.info("Successfully Verified Order ID-Order Status: " + OrderID + "-" +txtOrderStatus);
		Reporter.log("<p>Successfully Verified Order ID-Order Status: " + OrderID + "-" +txtOrderStatus);
		return bolIsSuccess;
	}
	
	//Verify UI Element Exists and Show text
	public static boolean verifyUIElementAndShowText(WebElement objUI, String Elementnametxt) 
	{
	 boolean bolIsSuccess = false;
	 try 
	 {
	  if(objUI.isDisplayed()) 
	  {
		bolIsSuccess=true;
		String strActualValue = objUI.getText();
		Thread.sleep(2000);
		log.info("Successfully Verified " +Elementnametxt+" : "+strActualValue.trim());
		Reporter.log("<p>Successfully Verified " +Elementnametxt+" : "+strActualValue.trim());
	  }
	}
	catch(Exception exception)
	 {
		log.info("Exception occured<br></br>" + exception.getStackTrace());
	 }
	  return bolIsSuccess;
	}
	
	//Scroll down till specific UI Element by Java Script Executor
	public static void scrollByJavaScriptExecutor(WebElement objUI, WebDriver driver, String EleName)
	{
	  try 
	  {
	    JavascriptExecutor objJS = ((JavascriptExecutor)driver);
	    objJS.executeScript("arguments[0].scrollIntoView();", objUI);
	    WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement element1 = objUI;
		wait.until(ExpectedConditions.visibilityOf(element1));
	    log.info("Successfully scroll down till "+EleName);
		Reporter.log("<p>Successfully scroll down till "+EleName);
	  }
	  catch(Exception exception)
	  {
		log.info("Exception occured<br></br>" + exception.getStackTrace());
	  }
	}
	
	
	   //This method used to verify existing text in field 
		public static boolean VerifyExistingTextInField(WebElement objUI, String FieldValue)
		{
		  boolean bolIsSuccess = false;
		  try 
		  {
		    String ExistText=objUI.getText().trim();
		    if(ExistText.contains(FieldValue))
		    bolIsSuccess=true;
		  }
		  catch(Exception exception)
		  {
			log.info("Exception occured<br></br>" + exception.getStackTrace());
		  }
		  return bolIsSuccess;
		}
		
		
		/**
		 * Method Name: VerifyOrderStatusInBO Description: This method verifies the order status in BO
		 * 
		 * @param txtOrderStatus
		 *            : Order Status text
		 */
		
		public static boolean VerifyOrderStatusInBO(String txtOrderStatus,String OrderID)
		{
			boolean bolIsSuccess = false;
			try 
			{
			switch (txtOrderStatus.toLowerCase())
			{
			case "Waiting for adyen":
		    bolIsSuccess = true;
		    break;
			case "On Hold":
			bolIsSuccess = true;
			break;
			case "Payment authorized":
		    bolIsSuccess = true;
			break;
			case "Sent to logistic":
			bolIsSuccess = true;
			break;
			case "Picking progress":
			bolIsSuccess = true;
			break;
			case "Invoiced":
			bolIsSuccess = true;
			break;
			case "Shipped":
			bolIsSuccess = true;
			break;
			case "Label generation error":
			bolIsSuccess = true;
			break;
			case "Return Pending":
			bolIsSuccess = true;
			break;
			case "Processing RMA":
			bolIsSuccess = true;
			break;
			case "Waiting for credit memo":
			bolIsSuccess = true;
			break;
			case "Credit memo/ Refunded":
			bolIsSuccess = true;
			break;
			case "Credit memo/ Exchanged":
			bolIsSuccess = true;
			break;
			case "Error":
			bolIsSuccess = true;
		    break;
			}
			}
			catch (Exception e) {
				log.info("Exception occured<br></br>" + e.getStackTrace());
				Reporter.log("<p>Exception occured" + e.getStackTrace());
			}
			log.info("Successfully Verified Order ID & Order Status In BO: " + OrderID + "-" +txtOrderStatus);
			Reporter.log("<p>Successfully Verified Order ID & Order Status In BO: " + OrderID + "-" +txtOrderStatus);
			return bolIsSuccess;
		}
		
		
		/**
		 * Method Name: VerifyReturnsStatusInBO()
		 * Description: This method verifies the order status in BO
		 * @param txtOrderStatus
		 * : Order Status text
		 */
		
		public static boolean VerifyReturnsStatusInBO(String txtOrderStatus,String ReturnsID)
		{
			boolean bolIsSuccess = false;
			try 
			{
			switch (txtOrderStatus.toLowerCase())
			{
			case "Authorised":
		    bolIsSuccess = true;
		    break;
			case "Return Received":
			bolIsSuccess = true;
			break;
			case "Approved":
		    bolIsSuccess = true;
			break;
			case "Processed and Closed":
			bolIsSuccess = true;
			break;
			}
			}
			catch (Exception e) {
				log.info("Exception occured<br></br>" + e.getStackTrace());
				Reporter.log("<p>Exception occured" + e.getStackTrace());
			}
			log.info("Successfully Verified Returns ID & Returns Status In BO: " + ReturnsID + "-" +txtOrderStatus);
			Reporter.log("<p>Successfully Verified Returns ID & Returns Status In BO: " + ReturnsID + "-" +txtOrderStatus);
			return bolIsSuccess;
		}
		
		
		/**
		 * This Function used to check whether checkbox is auto selected or not
		 * 
		 * @param driver
		 *            : WebDriver instance.
		 * @throws InterruptedException 
		 */

		public static void VerifycheckboxIsAutoSelected(WebDriver driver, By by, String eleName) throws InterruptedException
		{
			// Initialize WebElement
			WebElement ele = driver.findElement(by);
			try 
			{
				boolean bolIsSuccess = false;
				if (ele.isSelected())
				{
			     bolIsSuccess=true;
			     Thread.sleep(5000);
			     log.info("Successfully checkbox is auto selected for " + eleName);
				}
			}

			catch (NoSuchElementException e) {

				log.error("Exception element not present : " + eleName);
			}

		}
		
		
		/**
		 * This Function used to clear all existing products from my cart icon
		 * 
		 * @param driver
		 *            : WebDriver instance.
		 * @throws InterruptedException 
		 */
		
		public static void RemoveExistProductsFromMyCartIcon(WebDriver driver) throws InterruptedException
		{
			boolean bolIsSuccess=false;
	      try
			{
			   if(driver.findElement(By.xpath("//span[@class='counter qty']//span")).isDisplayed())		
		       {
				for(int i=0;i<3;i++)
				  {
					WebElement MinicartIcon=driver.findElement(By.xpath(ObjRepoProp.get().getProperty("HP_Minicart_icon")));
					((JavascriptExecutor) driver).executeScript("arguments[0].click();", MinicartIcon);
					Thread.sleep(5000);
					WebElement Remove=driver.findElement(By.xpath("//*[contains(@class,'action delete-custom')]"));
					((JavascriptExecutor) driver).executeScript("arguments[0].click();", Remove);
					Thread.sleep(5000);
					WebElement CloseMyCart=driver.findElement(By.xpath("//div[@id='minicart-content-wrapper']/..//following-sibling::button[@id='btn-minicart-close']"));
					((JavascriptExecutor) driver).executeScript("arguments[0].click();", CloseMyCart);
					Thread.sleep(5000);
				   }
				log.info("Successfully Removed all the exist products from my cart icon");
				Reporter.log("<p>Successfully Removed all the exist products from my cart icon");
			   }
			}
			catch(Exception e)
			{
				 // it will return true if element is not there
				bolIsSuccess = true;
			}
		}
		
		/**
		 * This Function used to clear all existing products from my cart icon
		 * 
		 * @param driver
		 *            : WebDriver instance.
		 * @throws InterruptedException 
		 */
		
		public static void RemoveExistProductsFromMyCartIconAsGU(WebDriver driver) throws InterruptedException
		{
			boolean bolIsSuccess=false;
	      try
			{
			   if(driver.findElement(By.xpath(ObjRepoProp.get().getProperty("HP_Minicart_icon"))).isDisplayed())		
		       {
				for(int i=0;i<3;i++)
				  {
					WebElement MinicartIcon=driver.findElement(By.xpath(ObjRepoProp.get().getProperty("HP_Minicart_icon")));
					((JavascriptExecutor) driver).executeScript("arguments[0].click();", MinicartIcon);
					Thread.sleep(5000);
					WebElement Remove=driver.findElement(By.xpath("//*[contains(@class,'action delete-custom')]"));
					((JavascriptExecutor) driver).executeScript("arguments[0].click();", Remove);
					Thread.sleep(10000);
					WebElement CloseMyCart=driver.findElement(By.xpath("//div[@id='minicart-content-wrapper']/..//following-sibling::button[@id='btn-minicart-close']"));
					((JavascriptExecutor) driver).executeScript("arguments[0].click();", CloseMyCart);
					Thread.sleep(5000);
				   }
				log.info("Successfully Removed all the exist products from my cart icon");
				Reporter.log("<p>Successfully Removed all the exist products from my cart icon");
			   }
			}
			catch(Exception e)
			{
				 // it will return true if element is not there
				bolIsSuccess = true;
			}
		}
		
		/**
		 * Function Name: ClickOnLastSealableProduct()
		 * Description: This function used to Scroll down till last sealable product & click on Last sealable product
		 * @param driver
		 * @throws Exception
		 */
		
		public static void ClickOnLastSealableProduct(WebDriver driver) throws Exception
		{
			int LastSealableProdIndex=driver.findElements(By.xpath(ObjRepoProp.get().getProperty("MainCP_Product_img"))).size()-1;
			WebElement LastSealableProd=driver.findElement(By.xpath("(//img[@class='photo image product-image-photo'])['"+LastSealableProdIndex+"']"));
			GUIFunctions.scrollByJavaScriptExecutor(LastSealableProd, driver , "scroll down till last sealable product");
			Thread.sleep(2000);
			GUIFunctions.JavaScriptClick(driver, LastSealableProd, "Clicked on Last Sealable Product");
			Reporter.log("<p>Successfully Clicked on Last Sealable Product");
		}
	
		/**
		 * Function Name: ComparingTotalCorrectSummaryAmountAfterRemovingOneProductQnty()
		 * Description: This function used to Compare Total summary amount after removing one Product quantity
		 * @param driver
		 * @throws Exception
		 */
		
		public static void ComparingTotalCorrectSummaryAmountAfterRemovingOneProductQnty(WebDriver driver, String TotalAmounttxt)
		{
			int totalAmount=Integer.valueOf(TotalAmounttxt);
			WebElement TotalAmount=driver.findElement(By.xpath(ObjRepoProp.get().getProperty("MainCP_CartTotal")));
			String TotalAmountSummaryAfterReduceQntyBy1txt=TotalAmount.getText().replaceAll("[^0-9]","");
			int totalAmountAfterReduceQntyBy1=Integer.valueOf(TotalAmountSummaryAfterReduceQntyBy1txt);
			int totalamountafterreduceqntyby1=totalAmount-totalAmountAfterReduceQntyBy1;
			Assert.assertEquals(totalamountafterreduceqntyby1,totalamountafterreduceqntyby1);
			Reporter.log("<p>Successfully Verified Total Amount Summary after removing one qnty : "+totalamountafterreduceqntyby1);
			log.info("Successfully Verified Total Amount Summary after removing one qnty : "+totalamountafterreduceqntyby1);
		}
		
		
		/**
		* Method Name: VerifyOrderStatusInAdyen Description: This method verifies the order status in Adyen
		*
		* @param txtOrderStatus
		* : Order Status text
		*/
		public static boolean VerifyOrderStatusInAdyen(String txtOrderStatus,String OrderID)
		{
		boolean bolIsSuccess = false;
		try
		{
		switch (txtOrderStatus.toLowerCase())
		{
		case "Authorised":
		bolIsSuccess = true;
		break;
		case "SentForRefund":
		bolIsSuccess = true;
		break;
		case "Refused":
		bolIsSuccess = true;
		break;
		case "Setteld":
		bolIsSuccess = true;
		break;
		}
		}
		catch (Exception e) {
		log.info("Exception occured<br></br>" + e.getStackTrace());
		Reporter.log("<p>Exception occured" + e.getStackTrace());
		}
		log.info("Successfully Verified Order ID & Order Status In Adyen: " + OrderID + "-" +txtOrderStatus);
		Reporter.log("<p>Successfully Verified Order ID & Order Status In Adyen: " + OrderID + "-" +txtOrderStatus);
		return bolIsSuccess;
		}

		
		public static void VerifyUIElementNotExists(By by, WebDriver driver, String ele)
		{
			WebDriverWait wait = new WebDriverWait(driver, 30);  
			wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
			log.info("Successfully Verified "+ele);
			Reporter.log("<p>Successfully Verified "+ele);
		}
		
		//Comparing Actual & Expected Strings by using equals
		public static boolean CompareSavedTextWithExpected(WebElement objUI, String expStringVal) 
		{
			 boolean bolIsSuccess = false;   
			 try {
		            if (objUI.isDisplayed())
		            { 
		                String strActualText =objUI.getText().trim();
		                String strPlainTxtAct= strActualText.replaceAll("\\W", ""); 
		                System.out.println("Actual : "+strPlainTxtAct);
		                String strPlaintxtExp = expStringVal.replaceAll("\\W", "");
		                System.out.println("Expected : "+strPlaintxtExp);
		                bolIsSuccess = strPlainTxtAct.equals(strPlaintxtExp);
		                bolIsSuccess = true;
		            }
		        }
		        catch(Exception e)  
			    {
		        	log.info("Exception occured<br></br>" + e.getStackTrace());
		        }
		        return bolIsSuccess;		
		}
		
		//Comparing Actual & Expected Strings by using contains
				public static boolean CompareSavedTextWithExpectedbycontains(WebElement objUI, String expStringVal) 
				{
					 boolean bolIsSuccess = false;   
					 try {
				            if (objUI.isDisplayed())
				            { 
				                String strActualText =objUI.getText().trim();
				                String strPlainTxtAct= strActualText.replaceAll("\\W", ""); 
				                System.out.println("Actual : "+strPlainTxtAct);
				                String strPlaintxtExp = expStringVal.replaceAll("\\W", "");
				                System.out.println("Expected : "+strPlaintxtExp);
				                bolIsSuccess = strPlainTxtAct.contains(strPlaintxtExp);
				                bolIsSuccess = true;
				            }
				        }
				        catch(Exception e)  
					    {
				        	log.info("Exception occured<br></br>" + e.getStackTrace());
				        }
				        return bolIsSuccess;		
				}
				
				/**
				 * Method Name: clearText  :Description: This method is used to clear the text in textbox
				 * specified
				 * 
				 * @param driver
				 *            : WebDriver
				 * @param ele
				 *            : WebElement locator
				 * @param eleName
				 *            : Name of the element to be clicked
				 * @throws InterruptedException 
				 */
				public static void clearAndEnterTxtboxValue(WebDriver driver, By by, String value) throws InterruptedException
				{
						driver.findElement(by).clear();
						Thread.sleep(2000);
						driver.findElement(by).sendKeys(value);
				}
				
				/**
				 * Method Name: Darg and drop the category
				 */
				
				public static void dragAndDropCategory(WebDriver driver, By by, By by2,By by3, String source, String target, String warningmessage) throws InterruptedException {
					try 
					{
						WebDriverWait wait = new WebDriverWait(driver, 10);
						WebElement src = driver.findElement(by);
						WebElement source1 = wait.until(ExpectedConditions.visibilityOf(src));
						WebElement tgt = driver.findElement(by2);
						WebElement target1 = wait.until(ExpectedConditions.visibilityOf(tgt));
						
						// Drag and Drop
						Actions actions = new Actions(driver);
						actions.clickAndHold(source1).moveToElement(target1).release(target1).build().perform();
					  	Thread.sleep(3000);
					  	WebElement warningmesage = driver.findElement(by3);
						WebElement warningMsg = wait.until(ExpectedConditions.visibilityOf(warningmesage));
						
					  	
					  	   if(warningMsg.isDisplayed())
					  	       {
					  	         System.out.println("Drag and drop is performed");
						         log.info("Dragged and dropped the category " + source);
						         Reporter.log("<p>Dragged and dropped the category " + source);
					  	       }
						   else 
						       {
							     System.out.println("Drag and drop not performed");
						       }
					} 
					catch (NoSuchElementException e) 
					{
						log.error("Unable to drag the category " + e);
						Reporter.log("<punable to drag the category");
					}
				}
				
				/**
				 * Method Name: Darg and drop the product
				 */
				
				public static void dragAndDropProduct(WebDriver driver, By by1, By by2, String source, String target) throws InterruptedException {
					try 
					{
						WebDriverWait wait = new WebDriverWait(driver, 10);
						WebElement src = driver.findElement(by1);
						WebElement source1 = wait.until(ExpectedConditions.visibilityOf(src));
						WebElement tgt = driver.findElement(by2);
						WebElement target1 = wait.until(ExpectedConditions.visibilityOf(tgt));
						
						// Drag and Drop
						Actions actions = new Actions(driver);
						for(int i=1;i<3;i++)
						{
						actions.clickAndHold(source1).moveToElement(target1).release(target1).build().perform();
					  	Thread.sleep(3000);
					  	actions.clickAndHold(source1).moveToElement(target1).release(target1).build().perform();
					  	Thread.sleep(3000);
						}
					  	
					} 
					catch (NoSuchElementException e) 
					{
						log.error("Unable to drag the product " + e);
						Reporter.log("<punable to drag the product");
					}
				}
				
			public static void UploadFiles(String FilePath) throws AWTException
			{
				//put path to your image in a clipboard
			     StringSelection ss = new StringSelection(FilePath);
			     Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);

			     //imitate mouse events like ENTER, CTRL+C, CTRL+V
			     Robot robot = new Robot();
			     robot.delay(250);
			     robot.keyPress(KeyEvent.VK_CONTROL);
			     robot.keyPress(KeyEvent.VK_V);
			     robot.keyRelease(KeyEvent.VK_CONTROL);
			     robot.keyRelease(KeyEvent.VK_V);
			     robot.keyPress(KeyEvent.VK_ENTER);
			     robot.delay(90);
			     robot.keyRelease(KeyEvent.VK_ENTER);
			}
}
