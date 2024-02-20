package src.in.valtech.cl.front.pages;
import static src.in.valtech.util.PropertyFileReader.ObjRepoProp;
import static src.in.valtech.util.PropertyFileReader.TextProp;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;
import src.in.valtech.config.BaseTest;
import src.in.valtech.custom.CustomFun;
import src.in.valtech.uifunctions.GUIFunctions;

/**
 * @author Gopalaswamy.M
 *
 */
public class CheckoutPage {
	public Logger log = Logger.getLogger(this.getClass().getName());

	public WebDriver driver;

	/**
	 * Desc:Proper navigation to Checkout Page CheckoutPage : Constructor
	 */
	public CheckoutPage(WebDriver driver) {
		this.driver = driver;
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	/**
	 * To fetch the Xpath's from Object Repository file - Checkout Page
	 */

	By ImgNoWrapAndGiftWrappingActive_xpath = By
			.xpath(ObjRepoProp.get().getProperty("ImgNoWrap&GiftWrappingActive_xpath"));
	By ImgGiftwrapping_xpath = By.xpath(ObjRepoProp.get().getProperty("ImgGiftwrapping_xpath"));
	By YourMsgtxtField_xpath = By.xpath(ObjRepoProp.get().getProperty("YourMsgtxtField_xpath"));
	By Updatebtn_xpath = By.xpath(ObjRepoProp.get().getProperty("Updatebtn_xpath"));
	By EmailAddressFieldAsGU_xpath = By.xpath(ObjRepoProp.get().getProperty("EmailAddressFieldAsGU_xpath"));
	By PasswordFieldAsGU_xpath = By.xpath(ObjRepoProp.get().getProperty("PasswordFieldAsGU_xpath"));
	By LoginbtnAsGU_xpath = By.xpath(ObjRepoProp.get().getProperty("LoginbtnAsGU_xpath"));
	By ProductNametxtInCP_xpath = By.xpath(ObjRepoProp.get().getProperty("ProductNametxtInCP_xpath"));
	By ProductPricetxtInCP_xpath = By.xpath(ObjRepoProp.get().getProperty("ProductPricetxtInCP_xpath"));
	By CartSubtotalLabelInCP_xpath = By.xpath(ObjRepoProp.get().getProperty("CartSubtotalLabelInCP_xpath"));
	By CartSubtotalvalueInCP_xpath = By.xpath(ObjRepoProp.get().getProperty("CartSubtotalvalueInCP_xpath"));
	By OrderTotalIncTaxLabelInCP_xpath = By.xpath(ObjRepoProp.get().getProperty("OrderTotalIncTaxLabelInCP_xpath"));
	By OrderTotalIncTaxValueInCP_xpath = By.xpath(ObjRepoProp.get().getProperty("OrderTotalIncTaxValueInCP_xpath"));
	By ProductQtyInCP_xpath = By.xpath(ObjRepoProp.get().getProperty("ProductQtyInCP_xpath"));
	By ShippingLabelInCP_xpath = By.xpath(ObjRepoProp.get().getProperty("ShippingLabelInCP_xpath"));
	By ShippingMethodtxtInCP_xpath = By.xpath(ObjRepoProp.get().getProperty("ShippingMethodtxtInCP_xpath"));
	By GiftHeadertxt_xpath = By.xpath(ObjRepoProp.get().getProperty("GiftHeadertxt_xpath"));
	By Checkout_EmailAddress_Login = By.xpath(ObjRepoProp.get().getProperty("Checkout_EmailAddress_Login"));
	By Checkout_Password_Login = By.xpath(ObjRepoProp.get().getProperty("Checkout_Password_Login"));
	By Checkout_SubmitBtn_Login = By.xpath(ObjRepoProp.get().getProperty("Checkout_SubmitBtn_Login"));
	By Checkout_FN_LN = By.xpath(ObjRepoProp.get().getProperty("Checkout_FN_LN"));
	By Checkout_Emailtext = By.xpath(ObjRepoProp.get().getProperty("Checkout_Emailtext"));
	By Checkout_Logoutlink = By.xpath(ObjRepoProp.get().getProperty("Checkout_Logoutlink"));

	/**
	 * MethodName=VerifyGiftHeadertxt Description:This function Verifies the Gift
	 * Header text in the Checkout Page
	 */

	public CheckoutPage VerifyGiftHeadertxt() {
		// verify Gift Header text
		Assert.assertTrue(
				CustomFun.waitObjectToLoad(driver, By.xpath(ObjRepoProp.get().getProperty("GiftHeadertxt_xpath")), Duration.ofSeconds(20)),
				"Gift Header text is not displayed");
		log.info("Successfully verified Gift Header text");
		Reporter.log("<p>Successfully verified Gift Header text");
		return new CheckoutPage(driver);
	}

	/**
	 * MethodName=VerifyNoWarpImgIsSelected Description:This function Verifies the
	 * No Warp Img is selected or not at Gift section
	 */

	public CheckoutPage VerifyNoWarpImgIsSelected() throws Exception {
		// Check whether No Warn Img is selected or not
		Assert.assertTrue(
				CustomFun.isTabSelected(driver.findElement(ImgNoWrapAndGiftWrappingActive_xpath), "No Warn Img"),
				"No Warn Img is not selected");
		return new CheckoutPage(driver);
	}

	/**
	 * MethodName=GiftWrappingImgClick() Description:This function used to click on
	 * Gift Wrapping Img at Gift section
	 */

	public CheckoutPage GiftWrappingImgClick() throws InterruptedException {
		GUIFunctions.scrollByJavaScriptExecutor(driver.findElement(ImgGiftwrapping_xpath), driver, "Gift Wrapping Img");
		GUIFunctions.clickElement(driver, ImgGiftwrapping_xpath, "Click on Gift Wrapping Img");
		return new CheckoutPage(driver);
	}

	/**
	 * MethodName=ScrollDowntillYourMsgField_EnterMsg Description:This function used
	 * to scroll down till Message field and enter wishes in your message field
	 */

	public CheckoutPage ScrollDowntillYourMsgField_EnterMsg(String YourMsg) throws InterruptedException {
	/*	Thread.sleep(2000);
		By giftcheckbox=By.xpath("(//div[contains(@class,'gift-options')]//div[contains(@class,'gift-options-content')])[2]");
		GUIFunctions.clickElement(driver, giftcheckbox, "Click on Gift Wrapping Img");
		Thread.sleep(2000);
		GUIFunctions.typeTxtboxValue(driver, YourMsgtxtField_xpath, YourMsg);
		Thread.sleep(2000);*/
		log.info("Entered message successfully in your message field");
		Reporter.log("<p>Entered message successfully in your message field");
		return new CheckoutPage(driver);
	}

	/**
	 * MethodName=UpdatebtnClick() Description:This function used to click on Update
	 * button at Gift section
	 * @throws Exception 
	 */

	public CheckoutPage UpdatebtnClick() throws Exception {
		GUIFunctions.JavaScriptClick(driver, driver.findElement(Updatebtn_xpath), "Click on Update button");
		return new CheckoutPage(driver);
	}

	/**
	 * MethodName=VerifyLoginHeadertxt_AsGU() Description:This function Verifies the
	 * Login Header text in the Checkout Page as Guest User
	 */

	public CheckoutPage VerifyLoginHeadertxt_AsGU() {
		// verify Login Header text
		Assert.assertTrue(
				CustomFun.waitObjectToLoad(driver, By.xpath(ObjRepoProp.get().getProperty("LoginHeadertxt_xpath")), Duration.ofSeconds(20)),
				"Login Header text is not displayed");
		log.info("Successfully verified Login Header text");
		Reporter.log("<p>Successfully verified Login Header text");
		return new CheckoutPage(driver);
	}

	/**
	 * MethodName=EnterEmailAddress_asGU Description:This function enters Email id
	 * as Guest user
	 */

	public CheckoutPage EnterEmailAddress_asGU(String emailaddress) throws InterruptedException {
		GUIFunctions.typeTxtboxValue(driver, EmailAddressFieldAsGU_xpath, emailaddress);
		Thread.sleep(2000);
		log.info("Entered Username Successfully: " + emailaddress);
		Reporter.log("<p>Entered Username Successfully: " + emailaddress);
		return new CheckoutPage(driver);
	}

	/**
	 * MethodName=EnterPassword_asGU Description:This function enters Password as
	 * Guest user
	 */

	public CheckoutPage EnterPassword_asGU(String password) throws InterruptedException {
		GUIFunctions.typeTxtboxValue(driver, PasswordFieldAsGU_xpath, password);
		Thread.sleep(2000);
		log.info("Entered Password Successfully: " + password);
		Reporter.log("<p>Entered Password Successfully: " + password);
		return new CheckoutPage(driver);
	}

	/**
	 * MethodName=click on Login Btn Description:This function Clicks On login
	 * button
	 */

	public CheckoutPage LoginBtnClick_AsGU() throws InterruptedException {
		GUIFunctions.clickElement(driver, LoginbtnAsGU_xpath, "Click on Login button");
		Thread.sleep(2000);
		return new CheckoutPage(driver);
	}

	/**
	 * MethodName=VerifyProductImgInCP Description:This function used to verify
	 * product image in Checkout page
	 */

	public CheckoutPage VerifyProductImgInCP() throws InterruptedException {
		Assert.assertTrue(
				CustomFun.isElementPresent(By.xpath(ObjRepoProp.get().getProperty("ProductImgInCP_xpath")), driver),
				"Product image is not displaying in Checkout page");
		log.info("Successfully verified Product image in Checkout page");
		Reporter.log("<p>Successfully verified Product image in Checkout page");
		return new CheckoutPage(driver);
	}

	/**
	 * MethodName=VerifyProductNametxtInCP Description:This function used to verify
	 * product name in Checkout page and show product name in reports
	 */

	public CheckoutPage VerifyProductNametxtInCP() throws InterruptedException {
		GUIFunctions.verifyUIElementAndShowText(driver.findElement(ProductNametxtInCP_xpath),
				"Product Name under order summary in Checkout Page");
		return new CheckoutPage(driver);
	}

	/**
	 * MethodName=VerifyProductPricetxtInCP Description:This function used to verify
	 * product price in Checkout page and show product price in reports
	 */

	public CheckoutPage VerifyProductPricetxtInCP() throws InterruptedException {
		GUIFunctions.verifyUIElementAndShowText(driver.findElement(ProductPricetxtInCP_xpath),
				"Product Price under order summary in Checkout Page");
		return new CheckoutPage(driver);
	}

	/**
	 * MethodName=VerifyProductQtyInCP() Description:This function used to verify
	 * product quantity in Checkout page and show product quantity in reports
	 */

	public CheckoutPage VerifyProductQtyInCP() throws InterruptedException {
		GUIFunctions.verifyUIElementAndShowText(driver.findElement(ProductQtyInCP_xpath),
				"Product Quantity in Checkout Page");
		return new CheckoutPage(driver);
	}

	/**
	 * MethodName=VerifyCartSubtotalLabelInCP Description:This function used to
	 * verify cart subtotal label in Checkout page
	 */

	public CheckoutPage VerifyCartSubtotalLabelInCP() throws InterruptedException {
		BaseTest.expected = driver.findElement(CartSubtotalLabelInCP_xpath).getText();
		Assert.assertEquals(TextProp.get().getProperty("CartSubtotalLabelInCP_txt"), BaseTest.expected);
		System.out.println("Successfully verified Cart Subtotal Label");
		log.info("Successfully verified Cart Subtotal Label \n");
		return new CheckoutPage(driver);
	}

	/**
	 * MethodName=VerifyCartSubtotalValueInCP() Description:This function used to
	 * verify cart subtotal value in Checkout page and show subtotal value in
	 * reports
	 */

	public CheckoutPage VerifyCartSubtotalValueInCP() throws InterruptedException {
		GUIFunctions.verifyUIElementAndShowText(driver.findElement(CartSubtotalvalueInCP_xpath), "Cart Subtotal Value");
		return new CheckoutPage(driver);
	}

	/**
	 * MethodName=VerifyOrderTotalIncLabelInCP() Description:This function used to
	 * verify Order Total Incl. Tax label in Checkout page
	 */

	public CheckoutPage VerifyOrderTotalIncLabelInCP() throws InterruptedException {
		BaseTest.expected = driver.findElement(OrderTotalIncTaxLabelInCP_xpath).getText();
		Assert.assertEquals(TextProp.get().getProperty("OrderTotalTaxOrderLabelInCP_txt"), BaseTest.expected);
		System.out.println("Successfully verified  Order Total Incl. Tax Label");
		log.info("Successfully verified Order Total Incl. Tax Label \n");
		return new CheckoutPage(driver);
	}

	/**
	 * MethodName=VerifyOrderTotalIncValuelInCP() Description:This function used to
	 * verify OrderTotalIncl.Tax value in Checkout page and show OrderTotalIncl.Tax
	 * value in reports
	 */

	public CheckoutPage VerifyOrderTotalIncValuelInCP() throws InterruptedException {
		GUIFunctions.verifyUIElementAndShowText(driver.findElement(OrderTotalIncTaxValueInCP_xpath),
				"Order Total Incl. Tax Value");
		return new CheckoutPage(driver);
	}

	/**
	 * MethodName=VerifyShippingLabelInCP() Description:This function used to verify
	 * Shipping label in Checkout page
	 */

	public CheckoutPage VerifyShippingLabelInCP() throws InterruptedException {
		BaseTest.expected = driver.findElement(ShippingLabelInCP_xpath).getText();
		Assert.assertEquals(TextProp.get().getProperty("ShippingLabelInCP_txt"), BaseTest.expected);
		System.out.println("Successfully verified Shipping Label");
		log.info("Successfully verified Order Shipping Label \n");
		return new CheckoutPage(driver);
	}

	/**
	 * MethodName=VerifyShipMethodUnderShipLbl() Description:This function used to
	 * verify shipping method under shipping label in Checkout page
	 */

	public CheckoutPage VerifyShipMethodUnderShipLbl() throws InterruptedException {
		GUIFunctions.verifyUIElementAndShowText(driver.findElement(ShippingMethodtxtInCP_xpath), "Shipping Method");
		return new CheckoutPage(driver);
	}

	/**
	 * MethodName=VerifyLoginSectionAtCheckoutStep1() Description:This function used
	 * to verifies login section in Checkout page
	 */

	public CheckoutPage VerifyLoginSectionAtCheckoutStep1() throws InterruptedException {
		CustomFun.waitObjectToLoad(driver, Checkout_FN_LN, Duration.ofSeconds(20));
		GUIFunctions.verifyUIElementAndShowText(driver.findElement(Checkout_FN_LN), "First & Last Name text");
		GUIFunctions.verifyUIElementAndShowText(driver.findElement(Checkout_Emailtext), "Email text");
		GUIFunctions.verifyUIElementAndShowText(driver.findElement(Checkout_Logoutlink), "Logout text");
		return new CheckoutPage(driver);
	}
	
	/**
	 * MethodName=VerifyGiftSectionIsDisAppearOrNot() Description:This function used to
	 * verify gift section is disappear or not in Checkout page
	 */

	public CheckoutPage VerifyGiftSectionIsDisAppearOrNot() throws InterruptedException
	{
		GUIFunctions.VerifyUIElementNotExists(ImgGiftwrapping_xpath, driver, "Gift Section is disappeared");
		return new CheckoutPage(driver);
	}
	
	
	/**
	* MethodName=Verify NoWarpGift Img and Wrap Gift img is present
	* Description:This function Verifies the NoWarpGift Img and Wrap Gift img is present
	* @throws Exception
	*/
	public CheckoutPage VerifyGiftWrappingImg() throws Exception
	{
	CustomFun.isElementVisible(ImgNoWrapAndGiftWrappingActive_xpath, driver);
	CustomFun.isElementVisible(ImgGiftwrapping_xpath, driver);
	return new CheckoutPage(driver);
	}


}
