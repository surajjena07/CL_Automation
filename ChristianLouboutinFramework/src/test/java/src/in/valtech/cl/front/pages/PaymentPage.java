package src.in.valtech.cl.front.pages;
import org.openqa.selenium.WebDriver;    
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.apache.log4j.Logger;
import static src.in.valtech.util.PropertyFileReader.ObjRepoProp;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import src.in.valtech.config.BaseTest;
import src.in.valtech.custom.CustomFun;
import src.in.valtech.uifunctions.GUIFunctions;
import org.openqa.selenium.By;

public class PaymentPage extends BaseTest
{

	/**
	 * @author Priyanka
	 *
	 */

	public Logger log = Logger.getLogger(this.getClass().getName());

	public WebDriver driver;
	public Actions action;

	/**
	 * Verification of Payment Page Desc:Verification of payment page and its
	 * elements to place an order PaymentPage: Constructor
	 */
	public PaymentPage(WebDriver driver) {
		this.driver = driver;
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

// To fetch the Xpaths from Object Repository file
	By Checkout_Paymentoptions = By.xpath(ObjRepoProp.get().getProperty("Checkout_Paymentoptions"));
	By Checkout_Creditcard = By.xpath(ObjRepoProp.get().getProperty("Checkout_Creditcard"));
	By Checkout_Paypal = By.xpath(ObjRepoProp.get().getProperty("Checkout_Paypal"));
	By Checkout_Address = By.xpath(ObjRepoProp.get().getProperty("Checkout_Address"));
	By Checkout_CCDefeaultBillingadd = By.xpath(ObjRepoProp.get().getProperty("Checkout_CCDefeaultBillingadd"));
	By Checkout_CCCardnumber = By.xpath(ObjRepoProp.get().getProperty("Checkout_CCCardnumber"));
	By Checkout_CCExpirydate = By.xpath(ObjRepoProp.get().getProperty("Checkout_CCExpirydate"));
	By Checkout_CCV = By.xpath(ObjRepoProp.get().getProperty("Checkout_CCV"));
	By Checkout_Cardholdername = By.xpath(ObjRepoProp.get().getProperty("Checkout_Cardholdername"));
	By Checkout_Termsofuse = By.xpath(ObjRepoProp.get().getProperty("Checkout_Termsofuse"));
	By Checkout_Returnpolicy = By.xpath(ObjRepoProp.get().getProperty("Checkout_Returnpolicy"));
	By Checkout_Termsofuse_Staging = By.xpath(ObjRepoProp.get().getProperty("Checkout_Termsofuse_Staging"));
	By Checkout_Returnpolicy_Staging = By.xpath(ObjRepoProp.get().getProperty("Checkout_Returnpolicy_Staging"));
	By Checkout_Termsofuse1 = By.xpath(ObjRepoProp.get().getProperty("Checkout_Termsofuse1"));
	By Checkout_Returnpolicy1 = By.xpath(ObjRepoProp.get().getProperty("Checkout_Returnpolicy1"));
	By Checkout_CCBillingaddressdropdown = By.xpath(ObjRepoProp.get().getProperty("Checkout_CCBillingaddressdropdown"));
	By Checkout_CCNewaddessbtn = By.xpath(ObjRepoProp.get().getProperty("Checkout_CCNewaddessbtn"));
	By Checkout_CCNewaddress = By.xpath(ObjRepoProp.get().getProperty("Checkout_CCNewaddress"));
	By Checkout_CCnew_Addressname = By.xpath(ObjRepoProp.get().getProperty("Checkout_CCnew_Addressname"));
	By Checkout_CCnew_Address1 = By.xpath(ObjRepoProp.get().getProperty("Checkout_CCnew_Address1"));
	By Checkout_CCnew_Postcode = By.xpath(ObjRepoProp.get().getProperty("Checkout_CCnew_Postcode"));
	By Checkout_CCnew_City = By.xpath(ObjRepoProp.get().getProperty("Checkout_CCnew_City"));
	By Checkout_CCnew_Country = By.xpath(ObjRepoProp.get().getProperty("Checkout_CCnew_Country"));
	By Checkout_CCnew_Telephone = By.xpath(ObjRepoProp.get().getProperty("Checkout_CCnew_Telephone"));
	By Checkout_CCnew_Cancelbtn = By.xpath(ObjRepoProp.get().getProperty("Checkout_CCnew_Cancelbtn"));
	By Checkout_CCnew_Updatebtn = By.xpath(ObjRepoProp.get().getProperty("Checkout_CCnew_Updatebtn"));
	By Checkout_CC_ProceedbtnUnderCredit = By.xpath(ObjRepoProp.get().getProperty("Checkout_CC_ProceedbtnUnderCredit"));
	By Checkout_CC_ProceedbtnUnderPaypal = By.xpath(ObjRepoProp.get().getProperty("Checkout_CC_ProceedbtnUnderPaypal"));
	By Checkout_AutoCheckedForBAandSA = By.xpath(ObjRepoProp.get().getProperty("Checkout_AutoCheckedForBAandSA"));
	By Checkout_AutoCheckedForBAandSA1 = By.xpath(ObjRepoProp.get().getProperty("Checkout_AutoCheckedForBAandSA1"));
	By PPP_AcceptCookiesBtn = By.xpath(ObjRepoProp.get().getProperty("PPP_AcceptCookiesBtn"));
	By PPP_EmailIDField = By.xpath(ObjRepoProp.get().getProperty("PPP_EmailIDField"));
	By PPP_PasswordField = By.xpath(ObjRepoProp.get().getProperty("PPP_PasswordField"));
	By PPP_LoginBtn = By.xpath(ObjRepoProp.get().getProperty("PPP_LoginBtn"));
	By PPP_PaypalLogo = By.xpath(ObjRepoProp.get().getProperty("PPP_PaypalLogo"));
	By PPP_BankOfCardVisa = By.xpath(ObjRepoProp.get().getProperty("PPP_BankOfCardVisa"));
	By PPP_PayButton = By.xpath(ObjRepoProp.get().getProperty("PPP_PayButton"));
	By PPP_ConfirmPayBtn = By.xpath(ObjRepoProp.get().getProperty("PPP_ConfirmPayBtn"));
	By Checkout_DiffShippingAddress_Dropdown_xpath = By
			.xpath(ObjRepoProp.get().getProperty("Checkout_DiffShippingAddress_Dropdown"));
	By Checkout_DiffShippingAddress_Dropdown_xpath1 = By
			.xpath(ObjRepoProp.get().getProperty("Checkout_DiffShippingAddress_Dropdown1"));
	By Checkout_Termsofuse_credit = By.xpath(ObjRepoProp.get().getProperty("Checkout_Termsofuse_credit"));
	By Checkout_Returnpolicy_credit = By.xpath(ObjRepoProp.get().getProperty("Checkout_Returnpolicy_credit"));
	By Checkout_Termsofuse_credit_staging = By.xpath(ObjRepoProp.get().getProperty("Checkout_Termsofuse_credit_staging"));
	By Checkout_Returnpolicy_credit_staging  = By.xpath(ObjRepoProp.get().getProperty("Checkout_Returnpolicy_credit_staging"));
	By Checkout_CC_Proceedbtn = By.xpath(ObjRepoProp.get().getProperty("Checkout_CC_ProceedbtnUnderCredit"));
	By Checkout_UpdateBtn = By.xpath(ObjRepoProp.get().getProperty("Checkout_Updatebtn"));
	By DS_Username = By.xpath(ObjRepoProp.get().getProperty("3DS_Username"));
	By DS_Password = By.xpath(ObjRepoProp.get().getProperty("3DS_Password"));
	By DS_Submit = By.xpath(ObjRepoProp.get().getProperty("SubmitButton"));

	/**
	 * Verify if the payment section displays Check if the Creditcard payment option
	 * displays Check if the Paypal payment option display
	 */
	public PaymentPage checkout_Paymentoptions() throws Exception {
		GUIFunctions.scrollByJavaScriptExecutor(driver.findElement(Checkout_Paymentoptions), driver, "Payment Options");
		CustomFun.isElementVisible(Checkout_Paymentoptions, driver);
		CustomFun.isElementVisible(Checkout_Creditcard, driver);
		CustomFun.isElementVisible(Checkout_Paypal, driver);
		Thread.sleep(2000);
		log.info("Payment options are displayed");
		Reporter.log("Payment options are displayed");
		return new PaymentPage(driver);
	}
	
	/**
	* Verification of Credit card option details
	*/
	public PaymentPage VerifyCreditCardDetails() throws Exception
	{

	CustomFun.isElementVisible( Checkout_Creditcard, driver);
	CustomFun.isElementVisible(Checkout_AutoCheckedForBAandSA, driver);
	CustomFun.isElementVisible(Checkout_CC_Proceedbtn, driver);
	return new PaymentPage(driver);
	}

	/**
	 * Select the creditcard payment method Check the default billing address
	 * displays
	 */
	public PaymentPage checkout_Creditcard() throws Exception {
		GUIFunctions.JavaScriptClick(driver, driver.findElement(Checkout_Creditcard),
				"Click on Credit card Radio Button");
		Thread.sleep(2000);
		return new PaymentPage(driver);
	}

	/**
	 * MethodName: checkout_PaypalCard() Description: Select the Paypal payment
	 * method
	 * 
	 */
	public PaymentPage checkout_PaypalCard() throws Exception {
		//GUIFunctions.scrollByJavaScriptExecutor(driver.findElement(Checkout_Paypal), driver, "Paypal Card");
		GUIFunctions.JavaScriptClick(driver, driver.findElement(Checkout_Paypal), "Click on Paypal Card Radio Button");
		return new PaymentPage(driver);
	}

	/**
	 * Check if the default billing address radio button is selected or not
	 */
	public PaymentPage checkout_Addressradiobtn() throws Exception {
		GUIFunctions.selectRadioButton(driver, Checkout_Address, "Check the radio button is selected");
		return new PaymentPage(driver);
	}

	/**
	 * Check if the My billing and shipping address are the same checkbox is auto
	 * selected or not
	 */
	public PaymentPage VerfiedSAAndBABothSameCheckboxIsAutoSelected() throws Exception {
		GUIFunctions.VerifycheckboxIsAutoSelected(driver, Checkout_AutoCheckedForBAandSA,
				"My billing and shipping address are the same checkbox");
		return new PaymentPage(driver);
	}

	/**
	 * Check if the My billing and shipping address are the same checkbox is auto
	 * selected or not
	 */
	public PaymentPage VerfiedSAAndBABothSameCheckboxIsAutoSelectedForCredit() throws Exception {
		GUIFunctions.VerifycheckboxIsAutoSelected(driver, Checkout_AutoCheckedForBAandSA1,
				"My billing and shipping address are the same checkbox");
		return new PaymentPage(driver);
	}

	/**
	 * Uncheck My billing and shipping address are the same checkbox
	 */
	public PaymentPage UncheckedSAAndBABothSameCheckbox() throws Exception {
		GUIFunctions.scrollByJavaScriptExecutor(driver.findElement(Checkout_Paymentoptions), driver, "Payment Options");
		Thread.sleep(2000);
		CustomFun.isElementVisible(Checkout_Paymentoptions, driver);
		CustomFun.isElementVisible(Checkout_Creditcard, driver);
		CustomFun.isElementVisible(Checkout_Paypal, driver);
		//Actions action = new Actions(driver);
		//action.moveToElement(driver.findElement(Checkout_AutoCheckedForBAandSA)).build().perform();
		driver.findElement(Checkout_AutoCheckedForBAandSA).click();
		GUIFunctions.JavaScriptClick(driver, driver.findElement(Checkout_AutoCheckedForBAandSA), "Uncheck My billing and shipping address are the same checkbox");
		return new PaymentPage(driver);
	}

	/**
	 * Uncheck My billing and shipping address are the same checkbox for Credit
	 * payemnt method
	 */
	public PaymentPage UncheckedSAAndBABothSameCheckboxForCredit() throws Exception {
		GUIFunctions.JavaScriptClick(driver, driver.findElement(Checkout_AutoCheckedForBAandSA1),
				"Unchecked SAAndBA Both Same Checkbox For Credit");
		return new PaymentPage(driver);
	}

	/**
	 * Check if the default billing address is displayed
	 */
	public PaymentPage checkout_CCDefeaultBillingadd() throws Exception {
		CustomFun.isElementVisible(Checkout_CCDefeaultBillingadd, driver);
		return new PaymentPage(driver);
	}

	/**
	 * Click on Creditcard field and enter credit card number
	 */
	public PaymentPage checkout_CCCardnumber(String CCNumber) throws Exception {
		if(bsValue.get().contains("YES"))
		{
			//Perform all the required tasks in the frame 0
			//Switching back to the main window
			driver.switchTo().frame(0);
			Thread.sleep(2000);
			action = new Actions(driver);
			WebElement Cardnumber = (new WebDriverWait(driver,10)).until(ExpectedConditions.presenceOfElementLocated(By.id("encryptedCardNumber")));
			Cardnumber.click();
			Thread.sleep(2000);
			Cardnumber.sendKeys(CCNumber);
			Thread.sleep(2000);
			driver.switchTo().defaultContent();
			Thread.sleep(2000);
		}
		else
		{
		action = new Actions(driver);
		CustomFun.waitObjectToLoad(driver, Checkout_CCCardnumber, Duration.ofSeconds(20));
		WebElement Cardnumber = driver.findElement(Checkout_CCCardnumber);
		Cardnumber.click();
		Thread.sleep(2000);
		action.sendKeys(Cardnumber, CCNumber).perform();
		}
		log.info("Entered Credit card number : " + CCNumber);
		Reporter.log("<p>Entered Credit Card Number : " + CCNumber);
		return new PaymentPage(driver);
	}

	/**
	 * Click on Expiry date field and enter data
	 */
	public PaymentPage checkout_CCExpirydate(String Expirydate) throws Exception 
	{
		if(bsValue.get().contains("YES"))
		{
			//Perform all the required tasks in the frame 1
			//Switching back to the main window
			driver.switchTo().frame(1);
			Thread.sleep(2000);
			action = new Actions(driver);
			WebElement expirydate = (new WebDriverWait(driver,10)).until(ExpectedConditions.presenceOfElementLocated(By.id("encryptedExpiryDate")));
			expirydate.click();
			Thread.sleep(2000);
			expirydate.sendKeys(Expirydate);
			Thread.sleep(2000);
			driver.switchTo().defaultContent();
			Thread.sleep(2000);
		}
		else
		{
		    action = new Actions(driver);
		    WebElement expirydate = driver.findElement(Checkout_CCExpirydate);
		    expirydate.click();
		    Thread.sleep(2000);
		    action.sendKeys(expirydate, Expirydate).perform();
		    Thread.sleep(2000);
		}
		log.info("Entered Expiry date : " + Expirydate);
		Reporter.log("<p>Entered Expiry date : " + Expirydate);
		return new PaymentPage(driver);
	}
	
	/**
	 * Click on CCV field and enter credit CCV/CVV number
	 */
	public PaymentPage checkout_CCV(String CCV) throws Exception {
		
		if(bsValue.get().contains("YES"))
		{
			//Perform all the required tasks in the frame 1
			//Switching back to the main window
			driver.switchTo().frame(2);
			Thread.sleep(2000);
			action = new Actions(driver);
			WebElement cvv = (new WebDriverWait(driver,10)).until(ExpectedConditions.presenceOfElementLocated(By.id("encryptedSecurityCode")));
			cvv.click();
			Thread.sleep(2000);
			cvv.sendKeys(CCV);
			Thread.sleep(2000);
			driver.switchTo().defaultContent();
			Thread.sleep(2000);
		}
		else
		{
		action = new Actions(driver);
		WebElement cvv = driver.findElement(By.xpath("//div[contains(@class,'adyen-checkout__field--securityCode')]"));
		cvv.click();
		// Thread.sleep(2000);
		action.sendKeys(cvv, CCV).perform();
		Thread.sleep(2000);
		}
		log.info("Entered CCV number is : " + CCV);
		Reporter.log("<p>Entered CCV number is : " + CCV);
		return new PaymentPage(driver);
	}

	/**
	 * Click on Card holder name field and enter name
	 */
	public PaymentPage checkout_Cardholdername(String Cardholdername) throws Exception
	{
		if(bsValue.get().contains("YES"))
		{
			action = new Actions(driver);
			WebElement cardholdername = (new WebDriverWait(driver,10)).until(ExpectedConditions.presenceOfElementLocated(Checkout_Cardholdername));
			cardholdername.click();
			Thread.sleep(2000);
			cardholdername.sendKeys(Cardholdername);
			Thread.sleep(2000);
		}
		else
		{
		    action = new Actions(driver);
		    WebElement cardholdername = driver.findElement(Checkout_Cardholdername);
		    cardholdername.click();
		    action.sendKeys(cardholdername, Cardholdername).perform();
		}
		    log.info("Entered Card holder name is : " + Cardholdername);
		    Reporter.log("<p>Entered Card holder name is : " + Cardholdername);
		    return new PaymentPage(driver);
	}

	/**
	 * Select the policy and return agreements For Paypal Payment method
	 */
	public PaymentPage checkout_Agreements() throws Exception {
		GUIFunctions.JavaScriptClick(driver, driver.findElement(Checkout_Termsofuse), "Click on terms of use option");
		Thread.sleep(2000);
		GUIFunctions.JavaScriptClick(driver, driver.findElement(Checkout_Returnpolicy), "Click on return policy option");
		log.info("Selected Agreement checkboxes");
		Reporter.log("Selected Agreement checkboxes");
		return new PaymentPage(driver);
	}
	
	/**
	 * Select the policy and return agreements For Paypal Payment method
	 */
	public PaymentPage checkout_Agreements_Staging() throws Exception {
		GUIFunctions.JavaScriptClick(driver, driver.findElement(Checkout_Termsofuse_Staging), "Click on terms of use option");
		Thread.sleep(2000);
		GUIFunctions.JavaScriptClick(driver, driver.findElement(Checkout_Returnpolicy_Staging), "Click on return policy option");
		log.info("Selected Agreement checkboxes");
		Reporter.log("Selected Agreement checkboxes");
		return new PaymentPage(driver);
	}


	/**
	 * Click on Billing address dropdown Select the new address button to create the
	 * new address
	 */
	public PaymentPage checkout_CCBillingaddressdropdown() throws Exception {
		GUIFunctions.clickElement(driver, Checkout_CCBillingaddressdropdown, "Click on billing address dropdown ");
		GUIFunctions.clickElement(driver, Checkout_CCNewaddessbtn, "Click on new address option");
		return new PaymentPage(driver);
	}

	/**
	 * Check whether the address creation fields display
	 */
	public PaymentPage checkout_CCNewaddressfields() throws Exception {
		CustomFun.isElementVisible(Checkout_CCNewaddress, driver);
		return new PaymentPage(driver);
	}

	/**
	 * New billing address creation and fields to enter the billing address
	 */
	public PaymentPage checkout_CCcreatenewadress(String Addresname, String Address1, String Postcode, String City,
			String Telephone) throws Exception {
		GUIFunctions.clickElement(driver, Checkout_CCnew_Addressname, "Click on address name field");
		GUIFunctions.typeTxtboxValue(driver, Checkout_CCnew_Addressname, Addresname);
		log.info("Entered Addressname  is :" + Addresname);
		Reporter.log("Address name entered sucessfully");
		GUIFunctions.clickElement(driver, Checkout_CCnew_Address1, "Click on address name1 field");
		GUIFunctions.typeTxtboxValue(driver, Checkout_CCnew_Address1, Address1);
		log.info("Line address is :" + Address1);
		Reporter.log("Address entered sucessfully");
		GUIFunctions.clickElement(driver, Checkout_CCnew_Postcode, "Click on Postcode field");
		GUIFunctions.typeTxtboxValue(driver, Checkout_CCnew_Postcode, Postcode);
		log.info("Entered postcode  is :" + Postcode);
		Reporter.log("Postal code  number entered sucessfully");
		GUIFunctions.clickElement(driver, Checkout_CCnew_City, "Click on City field");
		GUIFunctions.typeTxtboxValue(driver, Checkout_CCnew_City, City);
		log.info("Entered City name is :" + City);
		Reporter.log("Cityr name entered sucessfully");
		GUIFunctions.clickElement(driver, Checkout_CCnew_Telephone, "Click on telephone field");
		GUIFunctions.typeTxtboxValue(driver, Checkout_CCnew_Telephone, Telephone);
		log.info("Entered telephone number is :" + Telephone);
		Reporter.log("Telephone number entered sucessfully");
		return new PaymentPage(driver);
	}

	/**
	 * Click on cancel button to unsave the created address
	 */
	public PaymentPage checkout_CCnew_Cancelbtn() throws Exception {
		GUIFunctions.clickElement(driver, Checkout_CCnew_Cancelbtn,
				"Click on cancel button to cancel the created address ");
		return new PaymentPage(driver);
	}

	/**
	 * Click on Update button to save the created address
	 */
	public PaymentPage checkout_CCnew_Updatebtn() throws Exception {
		GUIFunctions.clickElement(driver, Checkout_CCnew_Updatebtn,
				"Click on update button to save  the created address ");
		return new PaymentPage(driver);
	}

	/**
	 * Click on Proceed button to make the payment
	 */
	public PaymentPage checkout_CC_Proceedbtn() throws Exception {
		GUIFunctions.JavaScriptClick(driver, driver.findElement(Checkout_CC_ProceedbtnUnderPaypal),
				"Click on Proceed button to make the payment ");
		return new PaymentPage(driver);
	}

	/**
	 * Click on Proceed button to make the payment for credit card
	 */
	public PaymentPage checkout_CC_ProceedbtnForCreditCard() throws Exception {
		GUIFunctions.JavaScriptClick(driver, driver.findElement(Checkout_CC_ProceedbtnUnderCredit),
				"Click on Proceed button to make the payment ");
		return new PaymentPage(driver);
	}

	/**
	 * MethodName= VerifyPaypalLogo() Description:This function Verifies Paypal Logo
	 */

	public PaymentPage VerifyPaypalLogo() {
		// verify Paypal Logo
		Assert.assertTrue(CustomFun.isElementPresent(By.xpath(ObjRepoProp.get().getProperty("PPP_PaypalLogo")), driver),
				"Paypal Logo is not displayed");
		log.info("Successfully verified Paypal Logo");
		Reporter.log("<p>Successfully verified Existing Paypal Logo");
		return new PaymentPage(driver);
	}

	/**
	 * MethodName= BankOfCardVisaClick() Description:This function used to click on
	 * Bank of Card Visa Card
	 */
	public PaymentPage BankOfCardVisaClick() throws Exception {
		// GUIFunctions.clickElement(driver, PPP_BankOfCardVisa , "Click on existing
		// Bank of Card Visa Card");
		return new PaymentPage(driver);
	}

	/**
	 * MethodName= PayButtonClick() Description:This function used to click on Pay
	 * button
	 */
	public PaymentPage PayButtonClick() throws Exception {
		GUIFunctions.scrollByJavaScriptExecutor(driver.findElement(PPP_PayButton), driver, "Pay button");
		Thread.sleep(2000);
		GUIFunctions.JavaScriptClick(driver, driver.findElement(PPP_PayButton), "Click on Pay button");
		Thread.sleep(2000);
		return new PaymentPage(driver);
	}

	/**
	 * MethodName= PayButtonClick() Description:This function used to close Accept
	 * Cookies Pop up
	 */
	public PaymentPage CloseOnAcceptCookiesInPPP() throws Exception {
		GUIFunctions.JavaScriptClick(driver, driver.findElement(PPP_AcceptCookiesBtn),
				"Successfully Navigated to Paypal Payment Page & Closed Accept Cookies Popup");
		Thread.sleep(2000);
		return new PaymentPage(driver);
	}

	/**
	 * MethodName: EnterEmailIDInPPP() Description: This function used to enter
	 * Email ID
	 */
	public PaymentPage EnterEmailIDInPPP(String EmailID) throws Exception {
		GUIFunctions.typeTxtboxValue(driver, PPP_EmailIDField, EmailID);
		Thread.sleep(2000);
		log.info("Entered EmailID Successfully: " + EmailID);
		Reporter.log("<p>Entered EmailID Successfully: " + EmailID);
		return new PaymentPage(driver);
	}

	/**
	 * MethodName: EnterPasswordInPPP() Description: This function used to enter
	 * Password
	 */
	public PaymentPage EnterPasswordInPPP(String Password) throws Exception {
		GUIFunctions.typeTxtboxValue(driver, PPP_PasswordField, Password);
		log.info("Entered Password Successfully: " + Password);
		Reporter.log("<p>Entered Password Successfully: " + Password);
		return new PaymentPage(driver);
	}

	/**
	 * MethodName=clickOnLoginBtnInPPP() Description:This function used to click on
	 * Login Button
	 * @throws Exception 
	 */

	public PaymentPage clickOnLoginBtnInPPP() throws Exception {
		GUIFunctions.JavaScriptClick(driver, driver.findElement(PPP_LoginBtn), "Click on Login button");
		return new PaymentPage(driver);
	}

	public PaymentPage SelectExistingBillingAddressFromDropdown(String Index) throws Exception {
		WebElement DifferentShippingAddress = driver.findElement(Checkout_DiffShippingAddress_Dropdown_xpath);
		// select Different address from dropdown
		GUIFunctions.selectDropDownValue(DifferentShippingAddress, Index, "index", "Diff_shipping_address");
		return new PaymentPage(driver);
	}
	
	public PaymentPage SelectExistingBillingAddressFromDropdownForCredit() throws Exception {
		WebElement DifferentShippingAddress = driver.findElement(Checkout_DiffShippingAddress_Dropdown_xpath1);
		// select Different address from dropdown
		GUIFunctions.selectDropDownValue(DifferentShippingAddress, "0", "index", "Diff_shipping_address");
		return new PaymentPage(driver);
	}

	public PaymentPage clickOn_ShippingAddressDropdown() throws InterruptedException {
		GUIFunctions.clickElement(driver, Checkout_DiffShippingAddress_Dropdown_xpath,
				"click on ShippingAddress Dropdown ");
		Thread.sleep(2000);
		return new PaymentPage(driver);
	}

	public PaymentPage Select_valueFrom_ShippingAddressDropdown() throws Exception {
		WebElement DifferentShippingAddress = driver.findElement(Checkout_DiffShippingAddress_Dropdown_xpath1);
		// select Different address from dropdown
		GUIFunctions.selectDropDownValue(DifferentShippingAddress, "1", "index", "Diff_shipping_address");
		return new PaymentPage(driver);
	}

	public PaymentPage Select_valueFrom_ShippingAddressDropdownForCredit() throws Exception {
		WebElement DifferentShippingAddress = driver.findElement(Checkout_DiffShippingAddress_Dropdown_xpath);
		// select Different address from dropdown
		GUIFunctions.selectDropDownValue(DifferentShippingAddress, "1", "index", "Diff_shipping_address");
		return new PaymentPage(driver);
	}

	/**
	 * click on update btn
	 */
	public PaymentPage ClickOnUpdteBtn() throws Exception {
		GUIFunctions.JavaScriptClick(driver, driver.findElement(Checkout_UpdateBtn), "click on update btn");
		Thread.sleep(2000);
		return new PaymentPage(driver);
	}

	/**
	 * Verify privacy policy checkbox text 1 and text2
	 */
	public PaymentPage checkout_VerifyCheckboxText() throws Exception {
		GUIFunctions.verifyUIElementAndShowText(driver.findElement(Checkout_Termsofuse),
				" Verified privacy policy checkbox 1 text ");
		GUIFunctions.verifyUIElementAndShowText(driver.findElement(Checkout_Returnpolicy),
				" Verified privacy policy checkbox 2 text ");
		log.info("Selected Agreement checkboxes");
		Reporter.log("Selected Agreement checkboxes");
		return new PaymentPage(driver);
	}

	/**
	 * Select the policy and return agreements For Credit Card Payment method
	 */
	public PaymentPage checkout_Agreements_CreditCard() throws Exception {
		Thread.sleep(2000);
		GUIFunctions.JavaScriptClick(driver, driver.findElement(Checkout_Termsofuse_credit),
				"Click on terms of use option");
		Thread.sleep(2000);
		GUIFunctions.JavaScriptClick(driver, driver.findElement(Checkout_Returnpolicy_credit), "Click on return policy option");
		log.info("Selected Agreement checkboxes");
		Reporter.log("Selected Agreement checkboxes");
		return new PaymentPage(driver);
	}
	
	/**
	 * Select the policy and return agreements For Paypal Payment method
	 */
	public PaymentPage checkout_Agreements_CreditCard_Staging() throws Exception {
		Thread.sleep(2000);
		GUIFunctions.JavaScriptClick(driver, driver.findElement(Checkout_Termsofuse_credit_staging),
				"Click on terms of use option");
		Thread.sleep(2000);
		GUIFunctions.JavaScriptClick(driver, driver.findElement(Checkout_Returnpolicy_credit_staging), "Click on return policy option");
		log.info("Selected Agreement checkboxes");
		Reporter.log("Selected Agreement checkboxes");
		return new PaymentPage(driver);
	}

	/**
	 * Click on Proceed button to make the payment
	 */
	public PaymentPage checkout_CC_Proceedbtn_credit() throws Exception {
		GUIFunctions.clickElement(driver, Checkout_CC_Proceedbtn, "Click on Proceed button to make the payment ");
		return new PaymentPage(driver);
	}

	
	/**
	 * Click on Username field and enter Username
	 */
	public PaymentPage checkout_3DSUsername(String Username) throws Exception {
		if(bsValue.get().contains("YES"))
		{
			action = new Actions(driver);
			WebElement username = (new WebDriverWait(driver,10)).until(ExpectedConditions.presenceOfElementLocated(DS_Username));
			username.click();
			Thread.sleep(2000);
			username.sendKeys(Username);
			Thread.sleep(2000);
		}
		else
		{
		    action = new Actions(driver);
		    CustomFun.waitObjectToLoad(driver, DS_Username, Duration.ofSeconds(100));
		    WebElement Cardnumber = driver.findElement(DS_Username);
		    Cardnumber.click();
		    Thread.sleep(2000);
		    action.sendKeys(Cardnumber, Username).perform();
		}
		    log.info("Entered 3DS Username : " + Username);
		    Reporter.log("<p>Entered 3DS Username : " + Username);
	    	return new PaymentPage(driver);
	}

	/**
	 * Click on Password field and enter Password
	 */
	public PaymentPage checkout_3DSPassword(String Password) throws Exception {
		if(bsValue.get().contains("YES"))
		{
			action = new Actions(driver);
			WebElement password = (new WebDriverWait(driver,10)).until(ExpectedConditions.presenceOfElementLocated(DS_Password));
			password.click();
			Thread.sleep(2000);
			password.sendKeys(Password);
			Thread.sleep(2000);
		}
		else
		{
			Thread.sleep(1000);
			driver.switchTo().frame("threeDSIframe");
			Thread.sleep(2000);
			WebElement pwdfield = (new WebDriverWait(driver,10)).until(ExpectedConditions.presenceOfElementLocated(DS_Password));
			pwdfield.click();
			Thread.sleep(2000);
			pwdfield.sendKeys(Password);
			Thread.sleep(2000);
			driver.switchTo().defaultContent();
		}
		log.info("Entered 3DS Password : " + Password);
		Reporter.log("<p>Entered 3DS Password : " + Password);
		return new PaymentPage(driver);
	}
	
	/**
	 * Click on Submit button to make the payment
	 */
	public PaymentPage checkout_ClickOnSubmitButton() throws Exception 
	{
		driver.switchTo().frame("threeDSIframe");
		Thread.sleep(2000);
		WebElement SubmitBtn = (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(DS_Submit));
		SubmitBtn.click();
		Thread.sleep(2000);
		driver.switchTo().defaultContent();
		return new PaymentPage(driver);
	}
}
