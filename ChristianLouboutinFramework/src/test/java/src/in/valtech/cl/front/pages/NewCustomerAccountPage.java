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
 * @author Gopalaswamy M
 *
 */
public class NewCustomerAccountPage {

	public Logger log = Logger.getLogger(this.getClass().getName());

	public WebDriver driver;

	/**
	 * Verification of NewCustomerAccountPage Desc:Proper navigation to
	 * NewCustomerAccountPage MyAccountPage : Constructor
	 */
	public NewCustomerAccountPage(WebDriver driver) {
		this.driver = driver;
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	/**
	 * To fetch the Xpath's from Object Repository file - NewCustomerAccount Page
	 */

	By NCAP_NewCustomerAcctxt_xpath = By.xpath(ObjRepoProp.get().getProperty("NCAP_CreateNewCustomerAcctxt_xpath"));
	By NCAP_PrefixDropDown_xpath = By.xpath(ObjRepoProp.get().getProperty("NCAP_PrefixDropDown_xpath"));
	By NCAP_FirstnameField_xpath = By.xpath(ObjRepoProp.get().getProperty("NCAP_FirstnameField_xpath"));
	By NCAP_LastnameField_xpath = By.xpath(ObjRepoProp.get().getProperty("NCAP_LastnameField_xpath"));
	By NCAP_EmailAddressField_xpath = By.xpath(ObjRepoProp.get().getProperty("NCAP_EmailAddressField_xpath"));
	By NCAP_PasswordField_xpath = By.xpath(ObjRepoProp.get().getProperty("NCAP_PasswordField_xpath"));
	By NCAP_ConfirmPasswordField_xpath = By.xpath(ObjRepoProp.get().getProperty("NCAP_ConfirmPasswordField_xpath"));
	By NCAP_cgvcheckbox_xpath = By.xpath(ObjRepoProp.get().getProperty("NCAP_cgvcheckbox_xpath"));
	By NCAP_newslettercheckbox_xpath = By.xpath(ObjRepoProp.get().getProperty("NCAP_newslettercheckbox_xpath"));
	By NCAP_CreateCLAccountBtn_xpath = By.xpath(ObjRepoProp.get().getProperty("NCAP_CreateCLAccountBtn_xpath"));
	By NCAP_SuccessMsgForRegister_xpath = By.xpath(ObjRepoProp.get().getProperty("NCAP_SuccessMsgForRegister_xpath"));
	By NCAP_newslettercheckbox2INAccountCreationPage_xpath = By.xpath(ObjRepoProp.get().getProperty("NCAP_newslettercheckbox2INAccountCreationPage_xpath"));

	/**
	 * MethodName=VerifyNewCustomerAccHeadertxt Description:This function Verifies
	 * the Create New Customer Account Header text in NewCustomerAccount Page
	 */

	public NewCustomerAccountPage VerifyNewCustomerAccHeadertxt() {
		// Create New Customer Account Header text
		Assert.assertTrue(
				CustomFun.isElementPresent(
						By.xpath(ObjRepoProp.get().getProperty("NCAP_CreateNewCustomerAcctxt_xpath")), driver),
				"Create New Customer Account Header text is not displayed");
		log.info("Successfully navigated to Create New Customer Account Page");
		Reporter.log("<p>Successfully navigated to Create New Customer Account Page");
		return new NewCustomerAccountPage(driver);
	}

	/**
	 * MethodName=VerifyPrefixDropdownIsAutoSelected() Description:This function
	 * verifies prefix drop down is auto selected or not as guest user
	 * 
	 * @throws Exception
	 */

	public NewCustomerAccountPage VerifyPrefixDropdownIsAutoSelected(String Prefix) throws Exception {
		CustomFun.verifySelectedDropdownValue(driver.findElement(NCAP_PrefixDropDown_xpath), Prefix);
		Thread.sleep(2000);
		return new NewCustomerAccountPage(driver);
	}

	/**
	 * MethodName=SelectValueFromPrefixDropdown() Description:This function used to
	 * select value from prefix drop down as guest user
	 * 
	 * @throws Exception
	 */

	public NewCustomerAccountPage SelectValueFromPrefixDropdown(String Prefix) throws Exception {
		GUIFunctions.selectDropDownValue(driver.findElement(NCAP_PrefixDropDown_xpath), Prefix, "text",
				"Prefix DropDown");
		Thread.sleep(2000);
		return new NewCustomerAccountPage(driver);
	}

	/*
	 * MethodName=EnterFirstNameField() Description:This function used to enter
	 * First Name in First Name Field
	 */

	public NewCustomerAccountPage EnterFirstNameField(String FirstName) throws InterruptedException {
		GUIFunctions.typeTxtboxValue(driver, NCAP_FirstnameField_xpath, FirstName);
		Thread.sleep(2000);
		log.info("Entered First Name successfully in First Name Field: " + FirstName);
		Reporter.log("<p>Entered First Name successfully in First Name Field: " + FirstName);
		return new NewCustomerAccountPage(driver);
	}

	/*
	 * MethodName=EnterLastNameField() Description:This function used to enter Last
	 * Name in Last Name Field
	 */

	public NewCustomerAccountPage EnterLastNameField(String LastName) throws InterruptedException {
		GUIFunctions.typeTxtboxValue(driver, NCAP_LastnameField_xpath, LastName);
		Thread.sleep(2000);
		log.info("Entered Last Name successfully in Last Name Field: " + LastName);
		Reporter.log("<p>Entered Last Name successfully in Last Name Field: " + LastName);
		return new NewCustomerAccountPage(driver);
	}

	/**
	 * MethodName=EnterEmailAddress Description:This function enters Email id in the
	 * field
	 */

	public NewCustomerAccountPage EnterEmailAddress(String emailaddress) throws InterruptedException {
		GUIFunctions.typeTxtboxValue(driver, NCAP_EmailAddressField_xpath, emailaddress);
		Thread.sleep(2000);
		log.info("Entered Username Successfully: " + emailaddress);
		Reporter.log("<p>Entered Username Successfully: " + emailaddress);
		return new NewCustomerAccountPage(driver);
	}

	/**
	 * MethodName=EnterPassword Description:This function enters Password in the
	 * field
	 */

	public NewCustomerAccountPage EnterPassword(String password) throws InterruptedException {
		GUIFunctions.typeTxtboxValue(driver, NCAP_PasswordField_xpath, password);
		Thread.sleep(2000);
		log.info("Entered Password Successfully: " + password);
		Reporter.log("<p>Entered Password Successfully: " + password);
		return new NewCustomerAccountPage(driver);
	}

	/**
	 * MethodName=EnterConfirmPassword Description:This function enters Confirm
	 * Password in the field
	 */

	public NewCustomerAccountPage EnterConfirmPassword(String confirmpassword) throws InterruptedException {
		GUIFunctions.typeTxtboxValue(driver, NCAP_ConfirmPasswordField_xpath, confirmpassword);
		Thread.sleep(2000);
		log.info("Entered Confirm Password Successfully: " + confirmpassword);
		Reporter.log("<p>Entered Confirm Password Successfully: " + confirmpassword);
		return new NewCustomerAccountPage(driver);
	}

	/**
	 * MethodName=AgreementCheckbox Description: This function used to click on News
	 * letter and CGV Checkbox in Create New Customer Account Page
	 */
	public NewCustomerAccountPage AgreementCheckbox() throws Exception {
		GUIFunctions.clickElement(driver, NCAP_newslettercheckbox_xpath, "Click on NewsLetter Checkbox");
		//GUIFunctions.clickElement(driver, NCAP_newslettercheckbox2INAccountCreationPage_xpath, "Click on NewsLetter Checkbox2");
		GUIFunctions.clickElement(driver, NCAP_cgvcheckbox_xpath, "Click on Cgv Checkbox");
		return new NewCustomerAccountPage(driver);
	}

	/**
	 * MethodName= ClickOnCreateCLAccountBtn(() Description:This function use to
	 * click on Create CL Account Button in Create New Customer Account Page
	 * 
	 * @throws Exception
	 */

	public NewCustomerAccountPage ClickOnCreateCLAccountBtn() throws Exception {
		// GUIFunctions.JavaScriptClick(driver,
		// driver.findElement(NCAP_CreateCLAccountBtn_xpath), "Click on Create CL
		// Account Button");
		driver.findElement(NCAP_CreateCLAccountBtn_xpath).click();
		return new NewCustomerAccountPage(driver);
	}

	/**
	 * MethodName=VerifySuccessMsgForRegister() Description:This function used to
	 * verify success message for register
	 */

	public NewCustomerAccountPage VerifySuccessMsgForRegister() throws InterruptedException {
		GUIFunctions.verifyUIElementAndShowText(driver.findElement(NCAP_SuccessMsgForRegister_xpath),
				"Register Success Message");
		return new NewCustomerAccountPage(driver);
	}

}
