package src.in.valtech.cl.front.pages;
import static src.in.valtech.util.PropertyFileReader.ObjRepoProp;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;
import src.in.valtech.custom.CustomFun;
import src.in.valtech.uifunctions.GUIFunctions;

/**
 * @author Veenashree.CM
 *
 */

public class OrderConfirmationPage {

	public Logger log = Logger.getLogger(this.getClass().getName());

	public WebDriver driver;

	public static String OrderConfirmationId;

	/**
	 * Verification of Order Confirmation Page Desc:Proper navigation to Order
	 * Confirmation Page OrderConfirmationPage: Constructor
	 */
	public OrderConfirmationPage(WebDriver driver) {
		this.driver = driver;
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	// To fetch the Xpaths from Object Repository file

	By OCP_Header_Txt = By.xpath(ObjRepoProp.get().getProperty("OCP_Header_Txt_xpath"));
	By OCP_SuccessOrder_Msg = By.xpath(ObjRepoProp.get().getProperty("OCP_SuccessOrder_Msg_xpath"));
	By OCP_OrderID = By.xpath(ObjRepoProp.get().getProperty("OCP_OrderID_xpath"));
	By OCP_ProcessingOrder_Txt = By.xpath(ObjRepoProp.get().getProperty("OCP_ProcessingOrder_Txt_xpath"));
	By OCP_ContinueShopping_btn = By.xpath(ObjRepoProp.get().getProperty("OCP_ContinueShopping_btn_xpath"));
	By FAQSection = By.xpath(ObjRepoProp.get().getProperty("FAQSection"));
	By MainCP_ContactUs_Lnk = By.xpath(ObjRepoProp.get().getProperty("MainCP_ContactUs_lnk"));

	/**
	 * MethodName=Verify Header welcome text in order confirmation page
	 * Description:This function used to verify Header welcome text in order
	 * confirmation page
	 */

	public OrderConfirmationPage VerifyHeadertxtInOCP() throws InterruptedException {
		GUIFunctions.verifyUIElementAndShowText(driver.findElement(OCP_Header_Txt),
				"Header welcome text in order confirmation page ");
		return new OrderConfirmationPage(driver);
	}

	/**
	 * Verification of Success Order Message text
	 * 
	 * @return :ProductListingPage
	 */

	public OrderConfirmationPage Verify_SuccessOrder_Msg_txt() throws InterruptedException {
		Assert.assertTrue(CustomFun.waitObjectToLoad(driver, OCP_SuccessOrder_Msg, Duration.ofSeconds(40)),
				"Order Success Message text is not displayed");
		GUIFunctions.verifyUIElementAndShowText(driver.findElement(OCP_SuccessOrder_Msg), "Order Success Message");
		return new OrderConfirmationPage(driver);
	}

	/**
	 * MethodName= Verify order Id in order confirmation page Description:This
	 * function used to verify order Id value in order confirmation page
	 */

	public OrderConfirmationPage VerifyOrderIDInOCP() throws InterruptedException {
		GUIFunctions.verifyUIElementAndShowText(driver.findElement(OCP_OrderID),
				"Order ID value from order confirmation page ");
		By ele = By.xpath(ObjRepoProp.get().getProperty("OCP_OrderID_xpath"));
		OrderConfirmationId = driver.findElement(ele).getText();
		return new OrderConfirmationPage(driver);
	}

	/**
	 * MethodName= Verify processing order text in order confirmation page
	 * Description:This function used to verify processing order text in order
	 * confirmation page
	 */

	public OrderConfirmationPage Verify_ProcessingOrder_Txt() throws InterruptedException {
		GUIFunctions.verifyUIElementAndShowText(driver.findElement(OCP_ProcessingOrder_Txt),
				"processing order text from order confirmation page ");
		return new OrderConfirmationPage(driver);
	}

	/**
	 * Click on continue shopping button from OCP
	 * 
	 * @return :OrderConfirmationPage
	 */

	public OrderConfirmationPage Click_ContinueShopping_Btn() throws InterruptedException {
		GUIFunctions.clickElement(driver, OCP_ContinueShopping_btn, "Click on continue shopping btn ");
		return new OrderConfirmationPage(driver);
	}

	/**
	 * MethodName=VerifyContinueShopping_Btn() Description:This function Verifies
	 * Continue Shopping Button in the Order Confirmation Page
	 */

	public OrderConfirmationPage VerifyContinueShopping_Btn() {
		// verify Continue Shopping Button
		Assert.assertTrue(CustomFun
				.isElementPresent(By.xpath(ObjRepoProp.get().getProperty("OCP_ContinueShopping_btn_xpath")), driver),
				"Continue Shopping Button is not displayed");
		log.info("Successfully verified Continue Shopping Button in Order Confirmation Page");
		Reporter.log("<p>Successfully verified Continue Shopping Button in Order Confirmation Page");
		return new OrderConfirmationPage(driver);
	}

	/**
	 * verify FAQ section in main cart
	 * 
	 * @return :OrderConfirmationPage
	 */
	public OrderConfirmationPage VerifyFAQSectionInOCP() throws InterruptedException {
		GUIFunctions.verifyUIElementAndShowText(driver.findElement(FAQSection),
				"verified FAQ section in Main cart Page");
		return new OrderConfirmationPage(driver);
	}

	/**
	 * verify contactus lnk in order confirmation page
	 * 
	 * @return :OrderConfirmationPage
	 */
	public OrderConfirmationPage VerifyContactusLnkInOCP() throws InterruptedException {
		GUIFunctions.verifyUIElementAndShowText(driver.findElement(MainCP_ContactUs_Lnk),
				"verified contact us link in order confirmation Page");
		return new OrderConfirmationPage(driver);
	}

}
