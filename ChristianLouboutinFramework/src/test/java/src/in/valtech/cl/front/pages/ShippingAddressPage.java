package src.in.valtech.cl.front.pages;
import static src.in.valtech.util.PropertyFileReader.ObjRepoProp; 
import static src.in.valtech.util.PropertyFileReader.TextProp;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.Reporter;
import src.in.valtech.config.BaseTest;
import src.in.valtech.custom.CustomFun;
import src.in.valtech.uifunctions.GUIFunctions;

/**
* @author Gopalaswamy.M
*
*/
public class ShippingAddressPage
{
	public Logger log = Logger.getLogger(this.getClass().getName());
	
	public WebDriver driver;
	/**
	 * Desc:Proper navigation to Shipping Address section in checkout page
	 * CheckoutPage : Constructor
	 */
	public ShippingAddressPage(WebDriver driver)
	{
	      this.driver= driver;
	      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
     /** 
      *  To fetch the Xpath's from Object Repository file - Shipping Address section in checkout page
      */
	
     By ShippingHeadertxt_xpath = By.xpath(ObjRepoProp.get().getProperty("ShippingHeadertxt_xpath"));
     By AddressNameField_xpath = By.xpath(ObjRepoProp.get().getProperty("AddressNameField_xpath"));
     By PrefixDropDown_xpath = By.xpath(ObjRepoProp.get().getProperty("PrefixDropDown_xpath"));
     By FirstnameField_xpath = By.xpath(ObjRepoProp.get().getProperty("FirstnameField_xpath"));
     By LastnameField_xpath = By.xpath(ObjRepoProp.get().getProperty("LastnameField_xpath"));
     By AddressField_xpath = By.xpath(ObjRepoProp.get().getProperty("AddressField_xpath"));
     By PostcodeField_xpath = By.xpath(ObjRepoProp.get().getProperty("PostcodeField_xpath"));
     By CityField_xpath = By.xpath(ObjRepoProp.get().getProperty("CityField_xpath"));
     By CountryDropDown_xpath = By.xpath(ObjRepoProp.get().getProperty("CountryDropDown_xpath"));
     By PhoneNumField_xpath = By.xpath(ObjRepoProp.get().getProperty("PhoneNumField_xpath"));
     By ShippingMethodsHeader_xpath = By.xpath(ObjRepoProp.get().getProperty("ShippingMethodsHeader_xpath"));
     By FirstShipMethodRadioBtn_xpath = By.xpath(ObjRepoProp.get().getProperty("FirstShipMethodRadioBtn_xpath"));
     By ContinuetoPaymentbtn_xpath = By.xpath(ObjRepoProp.get().getProperty("ContinuetoPaymentbtn_xpath"));
     By NewAddressbtn_xpath = By.xpath(ObjRepoProp.get().getProperty("NewAddressbtn_xpath"));
     By ShipAddPopuptitle_xpath = By.xpath(ObjRepoProp.get().getProperty("ShipAddPopuptitle_xpath"));
     By Shipherebtn_xpath = By.xpath(ObjRepoProp.get().getProperty("Shipherebtn_xpath"));
     By Editbtn_xpath = By.xpath(ObjRepoProp.get().getProperty("Editbtn_xpath"));
     By AddressUpdatedSuccessfullyMsg_xpath = By.xpath(ObjRepoProp.get().getProperty("AddressUpdatedSuccessfullyMsg_xpath"));
     By SecondShippingMethodRadioBtn_xpath = By.xpath(ObjRepoProp.get().getProperty("SecondShippingMethodRadioBtn"));
     By ThirdShippingMethodRadioBtn = By.xpath(ObjRepoProp.get().getProperty("ThirdShippingMethodRadioBtn"));
     By SecondShippingMethod_xpath = By.xpath(ObjRepoProp.get().getProperty("SecondShippingMethod"));
     By ThirdShippingMethod_xpath = By.xpath(ObjRepoProp.get().getProperty("ThirdShippingMethod"));
     By ShippingMethodDesc_txt =By.xpath(ObjRepoProp.get().getProperty("ShippingMethodDesc"));
     By NewlyAdded_ShippingMethodRadioBtn =By.xpath(ObjRepoProp.get().getProperty("NewlyAddedShippingMethodRadioBtn"));
     By EditLnkInShippingAddress_Txt =By.xpath(ObjRepoProp.get().getProperty("EditLnkInShippingAddress"));
     By AddressNameField_NU_xpath = By.xpath(ObjRepoProp.get().getProperty("AddressNameField_NU_xpath"));
     By PrefixDropDown_NU_xpath = By.xpath(ObjRepoProp.get().getProperty("PrefixDropDown_NU_xpath"));
     By FirstnameField_NU_xpath = By.xpath(ObjRepoProp.get().getProperty("FirstnameField_NU_xpath"));
     By LastnameField_NU_xpath = By.xpath(ObjRepoProp.get().getProperty("LastnameField_NU_xpath"));
     By AddressField_NU_xpath = By.xpath(ObjRepoProp.get().getProperty("AddressField_NU_xpath"));
     By PostcodeField_NU_xpath = By.xpath(ObjRepoProp.get().getProperty("PostcodeField_NU_xpath"));
     By CityField_NU_xpath = By.xpath(ObjRepoProp.get().getProperty("CityField_NU_xpath"));
     By CountryDropDown_NU_xpath = By.xpath(ObjRepoProp.get().getProperty("CountryDropDown_NU_xpath"));
     By PhoneNumField_NU_xpath = By.xpath(ObjRepoProp.get().getProperty("PhoneNumField_NU_xpath"));
     By ShippingAdressCloseIcon =By.xpath(ObjRepoProp.get().getProperty("ShippingAdressCloseIcn"));
     By ShippingAdressBookCheckbox =By.xpath(ObjRepoProp.get().getProperty("ShippingAdressBookChckbox"));
     By AddNewSA_AddressNameField_xpath = By.xpath(ObjRepoProp.get().getProperty("AddNewSA_AddressNameField_xpath"));
     By AddNewSA_FirstnameField_xpath = By.xpath(ObjRepoProp.get().getProperty("AddNewSA_FirstnameField_xpath"));
     By AddNewSA_LastnameField_xpath = By.xpath(ObjRepoProp.get().getProperty("AddNewSA_LastnameField_xpath"));
     By AddNewSA_AddressField_xpath = By.xpath(ObjRepoProp.get().getProperty("AddNewSA_AddressField_xpath"));
     By AddNewSA_PostcodeField_xpath = By.xpath(ObjRepoProp.get().getProperty("AddNewSA_PostcodeField_xpath"));
     By AddNewSA_CityField_xpath = By.xpath(ObjRepoProp.get().getProperty("AddNewSA_CityField_xpath"));
     By AddNewSA_CountryDropDown_xpath = By.xpath(ObjRepoProp.get().getProperty("AddNewSA_CountryDropDown_xpath"));
     By AddNewSA_PhoneNumField_xpath = By.xpath(ObjRepoProp.get().getProperty("AddNewSA_PhoneNumField_xpath"));
     By Checkout_AutoCheckedForBAandSA1 = By.xpath(ObjRepoProp.get().getProperty("Checkout_AutoCheckedForBAandSA1"));
     By Checkout_UpdateBtn_SA = By.xpath(ObjRepoProp.get().getProperty("Checkout_Updatebtn_SA"));
     

     /**MethodName=EnterAddressName_AsNU()
     *Description:This function used to scroll down till address name field and enter address name as new user
     */
     public ShippingAddressPage EnterAddressName_AsNU(String AddressName) throws InterruptedException
     {
    // GUIFunctions.scrollByJavaScriptExecutor(driver.findElement(AddressNameField_NU_xpath), driver , "Address Name Field");
     Thread.sleep(2000);
     GUIFunctions.typeTxtboxValue(driver, AddressNameField_NU_xpath, AddressName);
     Thread.sleep(2000);
     log.info("Entered Address Name successfully in Address Name field");
     Reporter.log("<p>Entered Address Name successfully in Address Name field");
     return new ShippingAddressPage(driver);
     }
     /**MethodName=VerifyPrefixDropdownIsAutoSelected()
     *Description:This function verifies prefix drop down is auto selected or not as new user
     * @throws Exception
     */
     public ShippingAddressPage VerifyPrefixDropdownIsAutoSelected_AsNU(String Prefix) throws Exception
     {
     CustomFun.verifySelectedDropdownValue(driver.findElement(PrefixDropDown_NU_xpath), Prefix);
     Thread.sleep(2000);
     return new ShippingAddressPage( driver);
     }
     
     /**MethodName=EnterFirstNameField_AsEU()
     *Description:This function used to enter first name field in Shipping Address popup as exist user
     * @throws Exception
     */
     public ShippingAddressPage EnterFirstNameField_AsNU(String FirstName) throws Exception
     {
     GUIFunctions.typeTxtboxValue(driver, FirstnameField_NU_xpath, FirstName);
     log.info("Entered First Name successfully in First Name field");
     Reporter.log("<p>Entered First Name successfully in First Name field");
     return new ShippingAddressPage(driver);
     }
     
     /**MethodName=EnterLastNameField_AsEU()
     *Description:This function used to enter last name field in Shipping Address popup as exist user
     * @throws Exception
     */
     public ShippingAddressPage EnterLastNameField_AsNU(String LastName) throws Exception
     {
     GUIFunctions.typeTxtboxValue(driver, LastnameField_NU_xpath, LastName);
     log.info("Entered Last Name successfully in Last Name field");
     Reporter.log("<p>Entered Last Name successfully in Last Name field");
     return new ShippingAddressPage(driver);
     }
     /**MethodName=VerifyFirstNameFieldIsAutoFilled()
     *Description:This function verifies first name field is auto filled or not as new user
     * @throws Exception
     */
     public ShippingAddressPage VerifyFirstNameFieldIsAutoFilled_AsNU(String FirstName) throws Exception
     {
     GUIFunctions.VerifyExistingTextInField(driver.findElement(FirstnameField_xpath), FirstName);
     Thread.sleep(2000);
     log.info("Successfully verified First Name field is auto filled with :"+FirstName);
     Reporter.log("<p>Successfully verified First Name field is auto filled with :"+FirstName);
     return new ShippingAddressPage( driver);
     }
     /**MethodName=VerifyLastNameFieldIsAutoFilled()
     *Description:This function verifies last name field is auto filled or not
     * @throws Exception
     */
     public ShippingAddressPage VerifyLastNameFieldIsAutoFilled_AsNU(String LastName) throws Exception
     {
     GUIFunctions.VerifyExistingTextInField(driver.findElement(LastnameField_xpath), LastName);
     Thread.sleep(2000);
     log.info("Successfully verified Last Name field is auto filled with :"+LastName);
     Reporter.log("<p>Successfully verified Last Name field is auto filled with :"+LastName);
     return new ShippingAddressPage( driver);
     }
     /**MethodName=EnterAddressDetails()
     *Description:This function used to enter address details in address field
     */
     public ShippingAddressPage EnterAddressDetails_AsNU(String AddressInfo) throws InterruptedException
     {
     GUIFunctions.typeTxtboxValue(driver,AddressField_NU_xpath, AddressInfo);
     Thread.sleep(2000);
     log.info("Entered Address Details successfully in Address field");
     Reporter.log("<p>Entered Address Details successfully in Address field");
     return new ShippingAddressPage(driver);
     }
     /**MethodName=EnterPostcode()
     *Description:This function used to enter post code in post code field
     */
     public ShippingAddressPage EnterPostcode_AsNU(String PostCode) throws InterruptedException
     {
     GUIFunctions.typeTxtboxValue(driver,PostcodeField_NU_xpath, PostCode);
     Thread.sleep(2000);
     log.info("Entered PostCode successfully in PostCode field");
     Reporter.log("<p>Entered PostCode successfully in PostCode field");
     return new ShippingAddressPage(driver);
     }
     /**MethodName=EnterCity()
     *Description:This function used to enter city in city field
     */
     public ShippingAddressPage EnterCity_AsNU(String City) throws InterruptedException
     {
     GUIFunctions.typeTxtboxValue(driver,CityField_NU_xpath, City);
     Thread.sleep(2000);
     log.info("Entered City successfully in City field");
     Reporter.log("<p>Entered City successfully in City field");
     return new ShippingAddressPage(driver);
     }
     /**MethodName=VerifyCountyDropdownIsAutoSelected()
     *Description:This function verifies County drop down is auto selected or not
     * @throws Exception
     */
     public ShippingAddressPage VerifyCountyDropdownIsAutoSelected_AsNU(String County) throws Exception
     {
     CustomFun.verifySelectedDropdownValue(driver.findElement(CountryDropDown_NU_xpath), County);
     Thread.sleep(2000);
     return new ShippingAddressPage( driver);
     }
     /**MethodName=EnterPhoneNum()s
     *Description:This function used to enter phone number in phone number field
     */
     public ShippingAddressPage EnterPhoneNum_AsNU(String PhoneNumber) throws InterruptedException
     {
     GUIFunctions.typeTxtboxValue(driver,PhoneNumField_NU_xpath, PhoneNumber);
     Thread.sleep(2000);
     log.info("Entered phone number successfully in phone number field");
     Reporter.log("<p>Entered phone number successfully in phone number field");
     return new ShippingAddressPage(driver);
     }
     
     /**
     * MethodName= VerifyShippingAddressHeader()
     * Description:This function Verifies the Shipping Address header in the Checkout Page
     * @throws InterruptedException
     */

     public ShippingAddressPage VerifyShippingAddressHeader() throws InterruptedException
     {
     GUIFunctions.scrollByJavaScriptExecutor(driver.findElement(ShippingHeadertxt_xpath), driver , "Address Name Field");
     // verify shipping address header text
     Assert.assertTrue(CustomFun.isElementPresent(ShippingHeadertxt_xpath, driver), "shipping address Header text is not displayed");
     log.info("Successfully verified shipping address Header text");
     Reporter.log("<p>Successfully verified shipping address Header text");
     return new ShippingAddressPage(driver);
     }


	 	
	 	/** MethodName=VerifyShippingMethodHeader()
		 * Description:This function used to verify shipping method label in Checkout page
		 */
		
		public ShippingAddressPage VerifyShippingMethodLabel() throws InterruptedException
		{
			BaseTest.expected=driver.findElement(ShippingMethodsHeader_xpath).getText();
			Assert.assertEquals(TextProp.get().getProperty("ShippingMethods_txt"), BaseTest.expected);
			System.out.println("Successfully verified  Shipping Methods Label");
			log.info("Successfully verified Shipping Methods Label \n");
			return new ShippingAddressPage(driver);
		}
		
		/** MethodName=FirstShippingMethodRadioBtnClick()
		 * Description:This function used to click on First Shipping Method Radio button
		 * @throws Exception 
		 */
		
		public ShippingAddressPage FirstShippingMethodRadioBtnClick() throws Exception
		{
			GUIFunctions.JavaScriptClick(driver, driver.findElement(FirstShipMethodRadioBtn_xpath), "Click on First Shipping Method Radio button");
			return new ShippingAddressPage(driver);
		}
		
		

		/** MethodName=ContinuetopaymentbtnClick()
		 * Description:This function used to click on Continue to payment button
		 * @throws Exception 
		 */
		
		public ShippingAddressPage ContinuetopaymentbtnClick() throws Exception
		{
			GUIFunctions.JavaScriptClick(driver, driver.findElement(ContinuetoPaymentbtn_xpath), "Click on Continue to payment button");
			Thread.sleep(2000);
			return new ShippingAddressPage(driver);
		}
	

	     /**
	      *  MethodName= VerifyExistShippingAddress_AsEU()
	 	  *  Description:This function Verifies the Existing Shipping Address under Shipping Address Label in the Checkout Page as exist user
	 	  */
	     
	     public ShippingAddressPage VerifyExistShippingAddress_AsEU()
	 	 {
	 		// verify exist shipping address
	 	    Assert.assertTrue(CustomFun.isElementPresent(By.xpath(ObjRepoProp.get().getProperty("ExistShippingAddress_xpath")), driver),
	 	    "Existing Shipping Address is not displayed");
	 	    log.info("Successfully verified Existing Shipping Address");
	 	    Reporter.log("<p>Successfully verified Existing Shipping Address");
	 		return new ShippingAddressPage(driver);
	      }
	     
	      
	     /**
	      *  MethodName= VerifyEditbtn_AsEU()
	 	  *  Description:This function Verifies the Edit button next to exist shipping address in the Checkout Page as exist user
	 	  */
	     
	     public ShippingAddressPage VerifyEditbtn_AsEU()
	 	 {
	 		// verify Edit button
	 	    Assert.assertTrue(CustomFun.isElementPresent(By.xpath(ObjRepoProp.get().getProperty("Editbtn_xpath")), driver),
	 	    "Edit button is not displayed");
	 	    log.info("Successfully verified Edit button");
	 	    Reporter.log("<p>Successfully verified Edit button");
	 		return new ShippingAddressPage(driver);
	      }
	     
	     
	     /**
	      *  MethodName= ClickOnEditButtonInCP()
	 	  *  Description:This function use to click on  Edit button next to exist shipping address in the Checkout Page
	     * @throws Exception 
	 	  */
	     
	     public ShippingAddressPage ClickOnEditButtonInCP() throws Exception
	 	 {
	 	    GUIFunctions.JavaScriptClick(driver, driver.findElement(Editbtn_xpath), "Click on Edit button");
	 		return new ShippingAddressPage(driver);
	      }
	     
	     /** MethodName=NewAddressbtnClick_AsEU()
			 * Description:This function used to click on New Address button as exist user
			 * @throws Exception 
			 */
			
		  public ShippingAddressPage NewAddressbtnClick_AsEU() throws Exception
		  {
			GUIFunctions.scrollByJavaScriptExecutor(driver.findElement(NewAddressbtn_xpath), driver , "New Address Name Button");
			Thread.sleep(2000);
			GUIFunctions.JavaScriptClick(driver, driver.findElement(NewAddressbtn_xpath), "Click on New Address button");
			return new ShippingAddressPage(driver);
		  }
		  
		  /** MethodName=VerifyShipAddPopup_AsEU()
			 * Description:This function used to verify shipping Address Popup in Checkout page
			 */
			
			public ShippingAddressPage VerifyShipAddPopup_AsEU() throws InterruptedException
			{
				BaseTest.expected=driver.findElement(ShipAddPopuptitle_xpath).getText();
				Assert.assertEquals(TextProp.get().getProperty("ShippingAddress_txt"), BaseTest.expected);
				System.out.println("Successfully verified Shipping Address popup");
				log.info("Successfully verified Shipping Address popup \n");
				return new ShippingAddressPage(driver);
			}
		
			
			  /**MethodName=EnterAddressName_AsEU()
		 	 *Description:This function used to enter address name in Address Name field as exist user
		 	 */
		 	
		 	public ShippingAddressPage EnterAddressName_AsEU(String AddressName) throws InterruptedException
		 	{
		 		GUIFunctions.typeTxtboxValue(driver, AddressNameField_xpath, AddressName);
		 		log.info("Successfully Entered Address Name : "+AddressName);
				Reporter.log("<p>Successfully Entered Address Name : "+AddressName);
		 		return new ShippingAddressPage(driver);
		 	}
		 	
		 	 /**MethodName=EnterAddressNameAsEUToAddNewSA()
		 	 *Description:This function used to enter address name in Address Name field as exist user
		 	 */
		 	
		 	public ShippingAddressPage EnterAddressNameAsEUToAddNewSA(String AddressName) throws InterruptedException
		 	{
		 		GUIFunctions.typeTxtboxValue(driver, AddNewSA_AddressNameField_xpath, AddressName);
		 		log.info("Successfully Entered Address Name : "+AddressName);
				Reporter.log("<p>Successfully Entered Address Name : "+AddressName);
		 		return new ShippingAddressPage(driver);
		 	}
		 	
		 	
			/**MethodName=VerifyPrefixDpdIsAutoSelected_AsEU()
			 *Description:This function verifies prefix drop down is auto selected or not as exist user
			 * @throws Exception 
			 */
			
			public ShippingAddressPage VerifyPrefixDpdIsAutoSelected_AsEU(String Prefix) throws Exception
			{
				CustomFun.verifySelectedDropdownValue(driver.findElement(PrefixDropDown_xpath), Prefix);
				return new ShippingAddressPage( driver);
			}
			
			
			/**MethodName=EnterFirstNameField_AsEU()
			 *Description:This function used to enter first name field in Shipping Address popup as exist user
			 * @throws Exception 
			 */
			
			public ShippingAddressPage EnterFirstNameField_AsEU(String FirstName) throws Exception
			{
				GUIFunctions.typeTxtboxValue(driver, FirstnameField_xpath, FirstName);
		 		log.info("Entered First Name successfully in First Name field");
				Reporter.log("<p>Entered First Name successfully in First Name field");
		 		return new ShippingAddressPage(driver);
			}
			
			/**MethodName=EnterFirstNameAsEUToAddNewSA()
			 *Description:This function used to enter first name field in Shipping Address popup as exist user
			 * @throws Exception 
			 */
			
			public ShippingAddressPage EnterFirstNameAsEUToAddNewSA(String FirstName) throws Exception
			{
				GUIFunctions.typeTxtboxValue(driver, AddNewSA_FirstnameField_xpath, FirstName);
		 		log.info("Entered First Name successfully in First Name field");
				Reporter.log("<p>Entered First Name successfully in First Name field");
		 		return new ShippingAddressPage(driver);
			}
			
			
			/**MethodName=EnterLastNameField_AsEU()
			 *Description:This function used to enter last name field in Shipping Address popup as exist user
			 * @throws Exception 
			 */
			
			public ShippingAddressPage EnterLastNameField_AsEU(String LastName) throws Exception
			{
				GUIFunctions.typeTxtboxValue(driver, LastnameField_xpath, LastName);
		 		log.info("Entered Last Name successfully in Last Name field");
				Reporter.log("<p>Entered Last Name successfully in Last Name field");
		 		return new ShippingAddressPage(driver);
			}
			
			/**MethodName=EnterLastNameAsEUToAddNewSA()
			 *Description:This function used to enter last name field in Shipping Address popup as exist user
			 * @throws Exception 
			 */
			
			public ShippingAddressPage EnterLastNameAsEUToAddNewSA(String LastName) throws Exception
			{
				GUIFunctions.typeTxtboxValue(driver, AddNewSA_LastnameField_xpath, LastName);
		 		log.info("Entered Last Name successfully in Last Name field");
				Reporter.log("<p>Entered Last Name successfully in Last Name field");
		 		return new ShippingAddressPage(driver);
			}
			
			
			 /**MethodName=EnterAddressDetailsAsEUToAddNewSA()
		 	 *Description:This function used to enter address details in address field as exist user
			 * @throws Exception 
		 	 */
		 	
		 	public ShippingAddressPage EnterAddressDetailsAsEUToAddNewSA(String AddressInfo) throws Exception
		 	{
		 		GUIFunctions.mouseOverElementAndClick(driver,driver.findElement(AddNewSA_AddressField_xpath), AddressInfo);
		 		GUIFunctions.typeTxtboxValue(driver,AddNewSA_AddressField_xpath, AddressInfo);
		 		Thread.sleep(2000);
		 		log.info("Entered Address Details successfully in Address field");
				Reporter.log("<p>Entered Address Details successfully in Address field");
		 		return new ShippingAddressPage(driver);
		 	}
		 	
		 	 /**MethodName=EnterAddressDetails_AsEU()
		 	 *Description:This function used to enter address details in address field as exist user
			 * @throws Exception 
		 	 */
		 	
		 	public ShippingAddressPage EnterAddressDetails_AsEU(String AddressInfo) throws Exception
		 	{
		 		GUIFunctions.mouseOverElementAndClick(driver,driver.findElement(AddressField_xpath), AddressInfo);
		 		GUIFunctions.typeTxtboxValue(driver,AddressField_xpath, AddressInfo);
		 		Thread.sleep(2000);
		 		log.info("Entered Address Details successfully in Address field");
				Reporter.log("<p>Entered Address Details successfully in Address field");
		 		return new ShippingAddressPage(driver);
		 	}
		 	
		 	
		 	 /**MethodName=EnterPostcodeAsEUToAddNewSA()
		 	 *Description:This function used to enter post code in post code field as exist user
		 	 */
		 	
		 	public ShippingAddressPage EnterPostcodeAsEUToAddNewSA(String PostCode) throws InterruptedException
		 	{
		 		GUIFunctions.typeTxtboxValue(driver,AddNewSA_PostcodeField_xpath, PostCode);
		 		Thread.sleep(2000);
		 		log.info("Entered PostCode successfully in PostCode field");
				Reporter.log("<p>Entered PostCode successfully in PostCode field");
		 		return new ShippingAddressPage(driver);
		 	}
		 	
		 	 /**MethodName=EnterPostcode_AsEU()
		 	 *Description:This function used to enter post code in post code field as exist user
		 	 */
		 	
		 	public ShippingAddressPage EnterPostcode_AsEU(String PostCode) throws InterruptedException
		 	{
		 		GUIFunctions.typeTxtboxValue(driver,PostcodeField_xpath, PostCode);
		 		Thread.sleep(2000);
		 		log.info("Entered PostCode successfully in PostCode field");
				Reporter.log("<p>Entered PostCode successfully in PostCode field");
		 		return new ShippingAddressPage(driver);
		 	}
		 	
		 	
		 	 /**MethodName=EnterCityAsEUToAddNewSA()
		 	 *Description:This function used to enter city in city field as exist user
		 	 */
		 	
		 	public ShippingAddressPage EnterCityAsEUToAddNewSA(String City) throws InterruptedException
		 	{
		 		GUIFunctions.typeTxtboxValue(driver,AddNewSA_CityField_xpath, City);
		 		Thread.sleep(2000);
		 		log.info("Entered City successfully in City field");
				Reporter.log("<p>Entered City successfully in City field");
		 		return new ShippingAddressPage(driver);
		 	}
		 	
		 	/**MethodName=EnterCity_AsEU()
		 	 *Description:This function used to enter city in city field as exist user
		 	 */
		 	
		 	public ShippingAddressPage EnterCity_AsEU(String City) throws InterruptedException
		 	{
		 		GUIFunctions.typeTxtboxValue(driver,CityField_xpath, City);
		 		Thread.sleep(2000);
		 		log.info("Entered City successfully in City field");
				Reporter.log("<p>Entered City successfully in City field");
		 		return new ShippingAddressPage(driver);
		 	}
		 	
		 	
		 	/**MethodName=VerifyCountryDpdIsAutoSelected_AsEU()
			 *Description:This function verifies County drop down is auto selected or not
			 * @throws Exception 
			 */
			
			public ShippingAddressPage VerifyCountryDpdIsAutoSelected_AsEU(String County) throws Exception
			{
				CustomFun.verifySelectedDropdownValue(driver.findElement(CountryDropDown_xpath), County);
				Thread.sleep(2000);
				return new ShippingAddressPage( driver);
			}
		 	
		 	
			 /**MethodName=EnterPhoneNum_AsEU
		 	 *Description:This function used to enter phone number in phone number field
		 	 */
		 	
		 	public ShippingAddressPage EnterPhoneNum_AsEU(String PhoneNumber) throws InterruptedException
		 	{
		 		WebElement PhoneNumField=driver.findElement(PhoneNumField_xpath);
		 		PhoneNumField.click();
		 		GUIFunctions.typeTxtboxValue(driver,PhoneNumField_xpath, PhoneNumber);
		 		Thread.sleep(2000);
		 		log.info("Entered phone number successfully in phone number field");
				Reporter.log("<p>Entered phone number successfully in phone number field");
		 		return new ShippingAddressPage(driver);
		 	}
		 	
		 	 /**MethodName=EnterPhoneNumAsEUToAddNewSA
		 	 *Description:This function used to enter phone number in phone number field
		 	 */
		 	
		 	public ShippingAddressPage EnterPhoneNumAsEUToAddNewSA(String PhoneNumber) throws InterruptedException
		 	{
		 		WebElement PhoneNumField=driver.findElement(AddNewSA_PhoneNumField_xpath);
		 		PhoneNumField.click();
		 		GUIFunctions.typeTxtboxValue(driver,AddNewSA_PhoneNumField_xpath, PhoneNumber);
		 		Thread.sleep(2000);
		 		log.info("Entered phone number successfully in phone number field");
				Reporter.log("<p>Entered phone number successfully in phone number field");
		 		return new ShippingAddressPage(driver);
		 	}
		 	
		 	
		 	  /** MethodName=ShipHerebtnClick()
			 * Description:This function used to click on Ship Here button in shipping address popup as exist user
			 * @throws Exception 
			 */
			
		  public ShippingAddressPage ShipHerebtnClick() throws Exception
		  {
			GUIFunctions.JavaScriptClick(driver, driver.findElement(Shipherebtn_xpath), "Click on Ship Here button");
			return new ShippingAddressPage(driver);
		  }
		  
		  
		  /** MethodName=VerifyAddressUpdatedSuccessMsg()
			 * Description:This function used to verify address updated successfully message
			 */
			
			public ShippingAddressPage VerifyAddressUpdatedSuccessMsg() throws InterruptedException
			{
			  Assert.assertTrue(CustomFun.waitObjectToLoad(driver, By.xpath(ObjRepoProp.get().getProperty("AddressUpdatedSuccessfullyMsg_xpath")), Duration.ofSeconds(20)),
					 	    "Success Message text is not displayed");
		      GUIFunctions.verifyUIElementAndShowText(driver.findElement(AddressUpdatedSuccessfullyMsg_xpath),"Success Message");
			  return new ShippingAddressPage(driver);
			}
			
			
			/**
			* MethodName= Verify new address button exist
			* Description:This function Verifies the Existing new address button in the Checkout Page
			*/

			public ShippingAddressPage VerifyNewAdressBtn()
			{
			// verify exist shipping address
			Assert.assertTrue(CustomFun.isElementPresent(By.xpath(ObjRepoProp.get().getProperty("NewAddressbtn_xpath")), driver),
			"new Address btn is not displayed");
			log.info("Successfully verified New Address btn");
			Reporter.log("<p>Successfully verified New Address btn");
			return new ShippingAddressPage(driver);
			}
			
			/** MethodName=Verify and click on second shipping method
			* Description:This function used to verify and click on second shipping method
			* @throws Exception
			*/

			public ShippingAddressPage VerifyAndClickOnSecondShippingmethod() throws Exception
			{
			GUIFunctions.verifyUIElementAndShowText(driver.findElement(SecondShippingMethod_xpath),"verified second shipping method");
			GUIFunctions.clickElement(driver, SecondShippingMethodRadioBtn_xpath, "Click on second shipping method");
			return new ShippingAddressPage(driver);
			}
			
			/** MethodName=Verify and click on Third shipping method
			* Description:This function used to verify and click on third shipping method
			* @throws Exception
			*/

			public ShippingAddressPage VerifyAndClickOnThirdShippingmethod() throws Exception
			{
			GUIFunctions.verifyUIElementAndShowText(driver.findElement(ThirdShippingMethod_xpath),"verified second shipping method");
			GUIFunctions.JavaScriptClick(driver, driver.findElement(ThirdShippingMethodRadioBtn), "Click on second shipping method");
			return new ShippingAddressPage(driver);
			}
			
			
			/**
			* MethodName= Verify newly added shipping address radio button is selected
			* Description:This function Verifies newly added shipping address radio button is selected
			*/
			public ShippingAddressPage VerifyNewlyAddedShippingAddressRadioBtn() throws Exception
			{
			Thread.sleep(4000);
			CustomFun.isRadioButtonSelected(driver.findElement(NewlyAdded_ShippingMethodRadioBtn));
			log.info(" Newly Added ShippingAddress Radio Btn is selected");
			Reporter.log("Newly Added ShippingAddress Radio Btn is selected");
			Thread.sleep(4000);
			GUIFunctions.verifyUIElementAndShowText(driver.findElement(EditLnkInShippingAddress_Txt),"Edit link in newly created shipping address");
			return new ShippingAddressPage(driver);
			}

			/** MethodName=Verify Shipping Method Header and desc text()
			* Description:This function used to verify Verify Shipping Method Header and desc text
			*/ public ShippingAddressPage VerifyShippingMethodAndDescLabel() throws InterruptedException
			{
			BaseTest.expected=driver.findElement(ShippingMethodsHeader_xpath).getText();
			Assert.assertEquals(TextProp.get().getProperty("ShippingMethods_txt"), BaseTest.expected); 
			System.out.println("Successfully verified Shipping Methods Label");
			log.info("Successfully verified Shipping Methods Label \n");
			GUIFunctions.verifyUIElementAndShowText(driver.findElement(ShippingMethodDesc_txt),"Shipping method desc text");
			return new ShippingAddressPage(driver);
			}

			/**
			* MethodName= Verify shipping address text, checkbox and close icon in shipping address popup
			* Description:This function Verifies shipping address text, checkbox and close icon in shipping address popup
			*/
			public ShippingAddressPage VerifyShippingAddressPopup() throws Exception
			{
			Assert.assertTrue(CustomFun.isElementPresent(By.xpath(ObjRepoProp.get().getProperty("ShippingHeadertxt_xpath")), driver),
			"shipping address Header text is not displayed");
			CustomFun.isElementVisible(ShippingAdressCloseIcon, driver);
			Thread.sleep(1000);
			GUIFunctions.VerifycheckboxIsAutoSelected(driver,ShippingAdressBookCheckbox,"Address book checkbox is auto checked");
			GUIFunctions.verifyUIElementAndShowText(driver.findElement(ShippingAdressBookCheckbox),"Address book text");
			return new ShippingAddressPage(driver);
			}
			
			/**
			 * Check if the My billing and shipping address are the same checkbox is auto
			 * selected or not
			 */
			public ShippingAddressPage VerfiedSAAndBABothSameCheckboxIsAutoSelectedForCredit() throws Exception {
				GUIFunctions.VerifycheckboxIsAutoSelected(driver, Checkout_AutoCheckedForBAandSA1,
						"My billing and shipping address are the same checkbox");
				return new ShippingAddressPage(driver);
			}

			
			 public ShippingAddressPage AddBillingAddressatShippingAddressPage() throws Exception
		     {
		     Thread.sleep(2000);
		     GUIFunctions.typeTxtboxValue(driver, AddressNameField_NU_xpath, CustomFun.getBillingAddressDSDetails().get().getAddressName());
		     log.info("Entered Address Name successfully in Address Name field");
		     Reporter.log("<p>Entered Address Name successfully in Address Name field");
		     
		     GUIFunctions.typeTxtboxValue(driver, FirstnameField_NU_xpath, CustomFun.getBillingAddressDSDetails().get().getFirstName());
		     log.info("Entered First Name successfully in First Name field");
		     Reporter.log("<p>Entered First Name successfully in First Name field");
		     
		     GUIFunctions.typeTxtboxValue(driver, LastnameField_NU_xpath, CustomFun.getBillingAddressDSDetails().get().getLastName());
		     log.info("Entered Last Name successfully in Last Name field");
		     Reporter.log("<p>Entered Last Name successfully in Last Name field");
		     
		     GUIFunctions.typeTxtboxValue(driver,AddressField_NU_xpath, CustomFun.getBillingAddressDSDetails().get().getAddress1());
		     Thread.sleep(5000);
		     log.info("Entered Address Details successfully in Address field");
		     Reporter.log("<p>Entered Address Details successfully in Address field");
		     
		      Actions actions = new Actions(driver);
		      actions.moveToElement(driver.findElement(PostcodeField_NU_xpath)).perform();
		      Thread.sleep(2000);
		      WebElement PostcodeField = driver.findElement(PostcodeField_NU_xpath);
		      PostcodeField.click();
		 	  Thread.sleep(2000);
		 	  actions.sendKeys(PostcodeField, CustomFun.getBillingAddressDSDetails().get().getPostcode()).perform();
		      log.info("Entered PostCode successfully in PostCode field");
		      Reporter.log("<p>Entered PostCode successfully in PostCode field");
		      
		     actions.moveToElement(driver.findElement(CityField_NU_xpath)).perform();
		     Thread.sleep(2000);
		     GUIFunctions.typeTxtboxValue(driver,CityField_NU_xpath, CustomFun.getBillingAddressDSDetails().get().getCity());
		     Thread.sleep(5000);
		     log.info("Entered City successfully in City field");
		     Reporter.log("<p>Entered City successfully in City field");
		     
	/*	      WebElement ActionsDropdown=driver.findElement(By.xpath("//div[@name='billingAddress.region_id']//select"));
			  ActionsDropdown.click();
			  Thread.sleep(1000);
			  String Statetxt=CustomFun.getBillingAddressDSDetails().get().getState();
			  driver.findElement(By.xpath("//div[@name='billingAddress.region_id']//select[@name='region_id']//option[contains(text(),'"+Statetxt+"')]")).click();
			  Thread.sleep(1000);	*/
		     
		     actions.moveToElement(driver.findElement(By.xpath("(//input[contains(@name,'telephone')])[3]"))).perform();
		     Thread.sleep(2000);
		     GUIFunctions.typeTxtboxValue(driver,By.xpath("(//input[contains(@name,'telephone')])[3]"), CustomFun.getBillingAddressDSDetails().get().getPhoneNumber());
		     Thread.sleep(5000);
		     log.info("Entered phone number successfully in phone number field");
		     Reporter.log("<p>Entered phone number successfully in phone number field");
		     
		     GUIFunctions.JavaScriptClick(driver, driver.findElement(Checkout_UpdateBtn_SA), "click on update btn");
				Thread.sleep(2000);
		     
		     return new ShippingAddressPage(driver);
		     }
}
