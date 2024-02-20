package src.in.valtech.cl.scenarios;
import org.apache.log4j.Logger;    
import static src.in.valtech.util.PropertyFileReader.ObjRepoProp;
import static src.in.valtech.util.PropertyFileReader.TextProp;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import src.in.valtech.cl.back.pages.AdyenPage;
import src.in.valtech.cl.back.pages.BackOfficePage;
import src.in.valtech.cl.back.pages.WMSPage;
import src.in.valtech.cl.front.pages.CartPage;
import src.in.valtech.cl.front.pages.CategoryLandingPage;
import src.in.valtech.cl.front.pages.CheckoutPage;
import src.in.valtech.cl.front.pages.HomePage;
import src.in.valtech.cl.front.pages.MyAccountPage;
import src.in.valtech.cl.front.pages.NewCustomerAccountPage;
import src.in.valtech.cl.front.pages.OrderConfirmationPage;
import src.in.valtech.cl.front.pages.PaymentPage;
import src.in.valtech.cl.front.pages.ProductDetailsPage;
import src.in.valtech.cl.front.pages.ProductListingPage;
import src.in.valtech.cl.front.pages.ShippingAddressPage;
import src.in.valtech.config.BaseTest;
import src.in.valtech.custom.CustomFun;
import src.in.valtech.uifunctions.GUIFunctions;
import src.in.valtech.util.Emails;

/**
* @author Veena
*
*/
public class TC_Scenario_06 extends BaseTest
{

	public Logger log = Logger.getLogger(this.getClass().getName());
	public static String OrderID;
	public String OrderStatus; 
	public MyAccountPage RMA_ID_FO;
	public String RefundMemoID;
	public static String RMAID;

	
	HomePage homepage;
	MyAccountPage myaccountpage;
	ProductListingPage productlistingpage;
	CategoryLandingPage categorylandingpage;
	ProductDetailsPage productdetailspage;
	CartPage cartpage;
	CheckoutPage checkoutpage;
	ShippingAddressPage shippingaddresspage;
	NewCustomerAccountPage newcustomeraccountpage;
	PaymentPage paymentpage;
	OrderConfirmationPage orderconfirmationpage;
	BackOfficePage backofficepage;
	WMSPage wmspage;
	AdyenPage adyenpage;
	
	@Test(priority=1,description="Navigated to CL Home Page")
	public void step01_NavigatedtoCLHomePage() throws Exception
	{
	logtest("Placing order with wrong credit card details.");
	System.out.println("Entry to the script ");
	System.out.println("The base url "+ baseUrl.get());
	homepage=HomePage.navigateToCLApplication_URL(driver.get(), baseUrl.get());
	}
	
	@Test(description="Open New Tab and Navigated to Magento BO", priority=2)
	public void step02_OpenNewTabAndNavigatedtoMagentoBO() throws Exception
	{
	backofficepage=new BackOfficePage(homepage.driver);
	CustomFun.OpenNewTabAndSwitchToNewTab(backofficepage.driver, "1");
	backofficepage.driver.navigate().to(CustomFun.getBODSDetails().get().getBO_URL());
	}

	@Test(description="Entered Username in Username Field", priority=3)
	public void step03_EnteredUsernameField() throws Exception
	{
	backofficepage.EnterUsername(CustomFun.getBODSDetails().get().getBO_Username());
	}

	@Test(description="Entered Password in Password Field", priority=4)
	public void step04_EnteredPasswordField() throws Exception
	{
	backofficepage.EnterPassword(CustomFun.getBODSDetails().get().getBO_Password());
	}

	@Test(description="Click on SignIn Button", priority=5)
	public void step05_ClickOnSignInButton() throws Exception
	{
	backofficepage.SignbtnClick();
	if(environmentName.contains("IntegrationEnv") | environmentName.contains("HomoEnv1") | environmentName.contains("StagingEnv") | environmentName.contains("Integration6Env") | environmentName.equals("HomoEnv"))
	    {
			Thread.sleep(5000);
			CustomFun.refreshPage(backofficepage.driver);
			Thread.sleep(5000);
		}
	}

	@Test(description="Verified Dashboard Header & check whether user is in Dashboard page", priority=6)
	public void step06_VerifiedDashboardHeaderInBO() throws Exception
	{
	backofficepage.VerifyDashboardHeader();
	}

	@Test(description="Click on Customers Icon", priority=7)
	public void step07_ClickOnCustomersIcon() throws Exception
	{
	backofficepage.CustomersIconClick();
	}

	@Test(description="Click on All Customers text from Customers Icon", priority=8)
	public void step08_ClickAllCustomerstxtFromCustomersIcon() throws Exception
	{
	backofficepage.AllCustomerstxtFromCustomersIconClick();
	}

	@Test(description="Verified Customers Header & check whether user is in Customers page", priority=9)
	public void step09_VerifyCustomersHeadertxtInBO() throws Exception
	{
	backofficepage.VerifyCustomersHeadertxt();
	}

	@Test(description="Enter Customer EmailID in Search Field and Search For Customer Account", priority=10)
	public void step10_SearchForCustomerAccount() throws Exception
	{
	CustomFun.waitObjectToLoad(backofficepage.driver, By.xpath("//button[text()='Clear all']"),Duration.ofSeconds(10));
	if(!backofficepage.driver.findElement(By.xpath("//button[text()='Clear all']")).isDisplayed())
	{
	backofficepage.driver.findElement(By.xpath("//input[@id='fulltext']")).sendKeys(CustomFun.getUserInfoDSDetails().get().getEmailDomain());
	CustomFun.waitObjectToLoad(backofficepage.driver, By.xpath("(//button[@class='action-submit'])[2]"),Duration.ofSeconds(10));
	backofficepage.driver.findElement(By.xpath("(//button[@class='action-submit'])[2]")).click();
	}
	else
	{
	GUIFunctions.JavaScriptClick(backofficepage.driver,backofficepage.driver.findElement(By.xpath("//button[text()='Clear all']")),"Click on Clear All button");
	backofficepage.driver.findElement(By.xpath("//input[@id='fulltext']")).sendKeys(CustomFun.getUserInfoDSDetails().get().getEmailDomain());
	CustomFun.waitObjectToLoad(backofficepage.driver, By.xpath("(//button[@class='action-submit'])[2]"),Duration.ofSeconds(10));
	GUIFunctions.JavaScriptClick(backofficepage.driver,backofficepage.driver.findElement(By.xpath("(//button[@class='action-submit'])[2]")),"Click on Search Icon");
	}
	}

	@Test(description="Delete The Existing Customer Account from Customer Grid Result", priority=11)
	public void step11_DeletedExistCustomerAccountFromCustomerGridResultInBO() throws Exception
	{
	backofficepage.DeletedExistCustomerAccountFromCustomerGridResultInBO();
	}   
	
	@Test(priority=12, description=" Clicking on My Account Icon ")
	public void step12_ClickMyAccountBtn() throws Exception
	{
	CustomFun.SwitchToSpecificTab(homepage.driver, "0");
	if(locale.get().contains("FR_FR") | bsValue.get().contains("YES") | locale.get().contains("CH_FR") | environmentName.equals("HomoEnv1") | locale.get().contains("UK_EN"))
	{
		for (int i = 0; i <= 1; i++)
		{
			Thread.sleep(5000);
			CustomFun.refreshPage(homepage.driver);
			Thread.sleep(5000);
		}
		homepage.clickMyaccountBtn();
	}
	else
	{
	   homepage.clickMyaccountBtn();
	}
	Reporter.log("<p>Successfully clicked on My account Icon from Homepage");
	}  

	@Test(priority=13, description=" Clicking on  Account create button ")
	public void step13_ClickAccountCreateBtn() throws Exception
	{	
	homepage.clickOn_Create_Account_btn();
	Reporter.log("<p>Successfully clicked on Account create button from Homepage");
	}  
		
	@Test(priority=14, description=" select value from prefix dropdown ")
	public void step14_SelectValFromPrefixDropdown() throws Exception
	{
		newcustomeraccountpage=new NewCustomerAccountPage(homepage.driver);		
		newcustomeraccountpage.VerifyPrefixDropdownIsAutoSelected(CustomFun.getUserInfoDSDetails().get().getNamePrefix());
		newcustomeraccountpage.SelectValueFromPrefixDropdown(CustomFun.getUserInfoDSDetails().get().getNamePrefix());		
	}  
		
	@Test(priority=15, description=" Enter last name field ")
	public void step15_EnterLastNameField() throws Exception
	{
		newcustomeraccountpage.EnterLastNameField(CustomFun.getUserInfoDSDetails().get().getLastName());	
	}  
	
	@Test(priority=16, description=" Enter first name field ")
	public void step16_EnterFirstNameField() throws Exception
	{
	newcustomeraccountpage.EnterFirstNameField(CustomFun.getUserInfoDSDetails().get().getFirstName());
	}  
	
	@Test(priority=17, description=" Enter email address field ")
	public void step17_EnterEmailAddressField() throws Exception
	{
	newcustomeraccountpage.EnterEmailAddress(CustomFun.getUserInfoDSDetails().get().getUserName());
	} 
	
	@Test(priority=18, description=" Enter password field ")
	public void step18_EnterPasswordField() throws Exception
	{
	newcustomeraccountpage.EnterPassword(CustomFun.getUserInfoDSDetails().get().getPassword());
	}
	
	@Test(priority=19, description=" Enter confirm password field ")
	public void step19_EnterConfirmPasswordField() throws Exception
	{
	 newcustomeraccountpage.EnterConfirmPassword(CustomFun.getUserInfoDSDetails().get().getConfirmPassword());
	 if(environmentName.equals("StagingEnv1") | environmentName.equals("IntegrationEnv"))	
	  {
			By PhoneNumField_xpath=By.xpath("//input[@name='telephone']");
			newcustomeraccountpage.driver.findElement(PhoneNumField_xpath).sendKeys(CustomFun.getAddressDSDetails().get().getPhoneNumber().substring(1)+"1");
			 Thread.sleep(1000);
	  }
	  else
	  {
		  By PhoneNumField_xpath=By.xpath("//input[@name='telephone']");
		  newcustomeraccountpage.driver.findElement(PhoneNumField_xpath).sendKeys(CustomFun.getAddressDSDetails().get().getPhoneNumber());
		  Thread.sleep(1000);
	  }
	}
	
	@Test(priority=20, description=" click on Terms and conditions 2 checkboxes ")
	public void step20_ClickTermsConditionCheckbox() throws Exception
	{
			newcustomeraccountpage.AgreementCheckbox();
	}
	
	@Test(priority=21, description=" click on create customer  account button ")
	public void step21_ClickCreateCustomerAccountBtn() throws Exception
	{
	newcustomeraccountpage.ClickOnCreateCLAccountBtn();
	}
	
	@Test(priority=22, description=" verify registered successfully msg text ")
	public void step22_VerifyRegisteredSuccessMsgTxt() throws Exception
	{
		myaccountpage=new MyAccountPage(newcustomeraccountpage.driver);
		CustomFun.waitForPageLoaded(myaccountpage.driver);
		myaccountpage.VerifySuccessMsgForRegister();
	}  
	
	
	@Test(priority=23, description=" Verify username text  ")
	public void step23_VerifyUserNameInMYAccount() throws Exception
	{	
	CustomFun.waitForPageLoaded(myaccountpage.driver);
	myaccountpage.Verify_Usernametxt();
    } 
    
	@Test(priority=24, description="Verified My account page content's")
	public void step24_VerifiedMyAccountPageContents() throws Exception
	{
	myaccountpage.VerifyMyAccountHeadertxt();
	/*
	 * Defect ID :- ECOM-15832 - [Revamp_Homo] - FR_FR : Consent Checkbox is not getting displayed in My Account page 
	 * Verify Consent Checkbox step and mention comment as per the defect requirement , 
	 * this checkbox is removed from Application .Hence not automated
	 */
 	//myaccountpage.Verify_ConsentCheckbox(); (Out Of Scope For Revamp Environment)
	myaccountpage.VerifyMyOrdersLink();
	myaccountpage.VerifyMyReturnsLink();
	myaccountpage.VerifyWishlistLink();
	myaccountpage.Verify_MyFavoriteAddressHeaderInMAP();
	myaccountpage.Verify_NewsLetterHeaderInMAP();
	homepage.Verify_FooterHeader_txt();
	log.info("Successfully Verified My account page content's");
	Reporter.log("<p>Successfully Verified My account page content's");
	} 
	
  @Test(priority=26,description="Mouse Over on Ladies L1 Category")
	public void step26_MouseOverElementOnLadiesL1Category() throws Exception
	{
		categorylandingpage=new CategoryLandingPage(homepage.driver);
		categorylandingpage.mouseOverCategory();
	}
	
	@Test(priority=27,description="Click on L3 Kate Category under L1 Ladies Category")
	public void step27_ClickOnL3KateLadiesCategory() throws Exception
	{
		categorylandingpage.ladiesL3KateCategoryClick();
	}
	
	@Test(priority=28, description=" Click on product from CLP ")
	public void step28_ClickOnProductImg() throws Exception
	{
   	categorylandingpage.Click_ProductImg();
	}
	
	@Test( priority=29, description="Verified Product Name in Product Details Page")
	public void step29_VerifiedProductNameinPDP() throws Exception
	{
	productdetailspage=new ProductDetailsPage(categorylandingpage.driver);
	productdetailspage.VerifyProductNametxtInPDP();
	}    

	@Test(priority=30, description="Verified Product Price in Product Details Page" )
	public void step30_VerifiedProductPriceinPDP() throws Exception
	{
	productdetailspage.VerifyProductPricetxtInPDP();
	}
		
	@Test(priority=31, description="Verified Product brand name in Product Details Page" )
	public void step31_VerifiedProductBrandNametxtInPDP() throws Exception
	{
	productdetailspage.VerifyProductBrandNametxtInPDP();
	}
	
	@Test(priority=32, description="Verified Add to cart button in Product Details Page" )
	public void step32_VerifiedAddtoCartbtnInPDP() throws Exception
	{
		productdetailspage.pdpColorSwatches();
	    productdetailspage.VerifyAddtoCartbtnInPDP();
	}
	
	@Test(priority=33,description="Click on In_store_availability button and close overlay" )
	public void step33_ClickOnInStoreAvailabilityButtonAndCloseOverlay() throws Exception
	{
	productdetailspage.ClickonInStoreAvailabilitybtnAndCloseOverlayInPDP();
	}

	@Test(priority=34,description="Verified Contact Us link")
	public void step34_VerifiedContactUslink() throws Exception
	{
	//productdetailspage.VerifyContactUsLinkInPDP();
	}

	@Test(priority=35,description="Verified Color swatches in PDP")
	public void step35_VerifiedColorSwatches() throws Exception
	{
	  productdetailspage.VerifyContactUsLinkInPDP();
	}
		
	@Test(priority=36,description="Verified Size Guide option, Click on Size Guide and close overlay")
	public void step36_ClickOnSizeGuideAndCloseOverlay() throws Exception
	{
		
	productdetailspage.pdpSizeguideInfo();
	}
		
	@Test( priority=37,description="Click On Select_Your_Size Button and Select any Size")
	public void step37_ClickOnSelectYourSizeButtonAndSelectAnySize() throws Exception
	{
	productdetailspage.ClickOnSelectYourSizeBtnAndSelectAnySizeInPDP();
	productdetailspage.pdpNotification_Closebtn();
	productdetailspage.pdpColorSwatches();
	}
		
	@Test(priority=38,description="Click on Product Info and Verified content under Product Info section")
	public void step38_ClickonProductInfoAndVerifiedContent() throws Exception
	{
	productdetailspage.pdpProductInfoBlock();
	}

	@Test(priority=39,description="Click on Product Care and Verified content under Product Care section")
	public void step39_ClickonProductCareAndVerifiedContent() throws Exception
	{
	productdetailspage.pdpProductCareBlock();
	}
	
	@Test(priority=40,description="Click on Shipping and Verified content under Shipping section")
	public void step40_ClickonShippingAndVerifiedContent() throws Exception
	{
	productdetailspage.pdpShippingBlock();
	}

	@Test(priority=41,description="Verify PDP main and thumbnail image ")
	public void step41_VerifyMainThumbnailImgAndColorSwatches() throws Exception
	{
	productdetailspage.pdpMainimage();	
	//productdetailspage.pdpColorSwatches();
	}

	@Test(priority=42,description="Click on Add To Cart Button")
	public void step42_ClickonAddToCartButton() throws Exception
	{
	productdetailspage.pdpAddtoCartbtn();	
	}
	
	@Test(priority=43,description="Verification of PDP notification block")
	public void step43_VerifiedPDPConfirmationMessagePopUPModal() throws Exception
	{
	productdetailspage.pdpProductadd_Notification();
	productdetailspage.pdpNotification_ContinebtnOrderNow();
	}
	
	@Test(priority=44,description="Click on Your cart link")
	public void step44_ClickonYourCartLnk() throws Exception
	{
		productdetailspage.Click_ON_YourCartLnk_Minicart();
	} 
	
	@Test(priority=45,description="Verify product details in Main cart page")
	public void step45_VerifyProductDetailsInMainCart() throws Exception
	{
		cartpage=new CartPage(productdetailspage.driver);
		cartpage.Verify_Product_Details_InMainCart();
		cartpage.Verify_All_Redbannertxt_InMainCart();
		cartpage.VerifyRemoveWishlistLnk_Maincart();
		cartpage.Verify_Product_price_Details_MainCart();
		cartpage.VerifyContactusCheckoutCTA_Maincart();
		cartpage.VerifyTotalAndDeliverySummary();
		cartpage.VerifyProductQtyIn_MainCart();
		cartpage.VerifyFixedLegaltxt();
		cartpage.VerifyPaymentNonClickable_sectionIcons_MainCart();
		cartpage.VerifyFAQSectionInMaincart();
	} 
	
	@Test(priority=46,description="Click on product quantity increment icon ")
	public void step46_ClickOnIncrIconforProductInMainCart() throws Exception
	{
		cartpage.Click_ON_IncrQuantity_Maincart();
	} 
	
	
	@Test(priority=47,description="click on proceed to checkout CTA")
	public void step47_ClickOnProceedToCheckOutCTA() throws Exception
	{
	cartpage.Click_ON_ProceedToCheckOut_Maincart();
	}
	
	@Test(priority=48,description="Verify Gift header text and default no wrap img selected ")
	public void step48_VerifyGiftHeadertextAndDefaultGiftWrapSelected() throws Exception
	{
	checkoutpage=new CheckoutPage(cartpage.driver);	
	checkoutpage.VerifyGiftHeadertxt();
	checkoutpage.VerifyNoWarpImgIsSelected();
	}
	
	@Test(priority=49,description="Enter message in Gift msg fld ")
	public void step49_EnterMsgInGiftMsgFld() throws Exception
	{
	checkoutpage.ScrollDowntillYourMsgField_EnterMsg("test");	
	}
	
	@Test(priority=50,description="Click on update button ")
	public void step50_ClickUpdateBtn() throws Exception
	{	
	checkoutpage.UpdatebtnClick();
	}
	
	@Test(description="Verified Shipping Address Header in Checkout Page at Shipping Address Section", priority=51)
	public void step51_VerifiedShippingAddressHeaderInCP() throws Exception
	{
	shippingaddresspage=new ShippingAddressPage(checkoutpage.driver);
	shippingaddresspage.VerifyShippingAddressHeader();
	}
	
	@Test(description="Entered Address Name in Address Name Field", priority=52)
	public void step52_EnteredAddressNameField() throws Exception
	{
	shippingaddresspage.EnterAddressName_AsEU(CustomFun.getAddressDSDetails().get().getAddressName());

	}

	@Test(description="Verified Prefix Name Dropdown is Auto Selected or not at Shipping Address Section", priority=53)
	public void step53_VerifiedPrefixNameDpdIsAutoSelectedOrNot() throws Exception
	{
	shippingaddresspage.VerifyPrefixDpdIsAutoSelected_AsEU(CustomFun.getAddressDSDetails().get().getNamePrefix());

	}

	@Test(description="Entered First Name in First Name Field", priority=54)
	public void step54_EnteredFirstNameField() throws Exception
	{
	shippingaddresspage.EnterFirstNameField_AsEU(CustomFun.getAddressDSDetails().get().getFirstName());

	}

	@Test(description="Entered Last Name in Last Name Field", priority=55)
	public void step55_EnteredLastNameField() throws Exception
	{
	shippingaddresspage.EnterLastNameField_AsEU(CustomFun.getAddressDSDetails().get().getLastName());

	}

	@Test(description="Entered Address in Address Field", priority=56)
	public void step56_EnteredAddressField() throws Exception
	{
	shippingaddresspage.EnterAddressDetails_AsEU(CustomFun.getAddressDSDetails().get().getAddress1());
	}

	@Test(description="Entered PostCode in PostCode Field", priority=57)
	public void step57_EnteredPostCodeField() throws Exception
	{
	shippingaddresspage.EnterPostcode_AsEU(CustomFun.getAddressDSDetails().get().getPostcode());
	}

	@Test(description="Entered City in City Field", priority=58)
	public void step58_EnteredCityField() throws Exception
	{
	shippingaddresspage.EnterCity_AsEU(CustomFun.getAddressDSDetails().get().getCity());
	}

	@Test(description="verified default Country selected in country Field", priority=59)
	public void step59_VerifiedCountryField() throws Exception
	{ 
	  if(locale.get().contains("CH_FR"))
	  {
		  shippingaddresspage.VerifyCountryDpdIsAutoSelected_AsEU(CustomFun.getAddressDSDetails().get().getCountry());
		  Thread.sleep(1000);
		  WebElement ActionsDropdown=shippingaddresspage.driver.findElement(By.xpath("//select[@name='region_id']"));
		  ActionsDropdown.click();
		  Thread.sleep(1000);
	        // select Launch Selected Options from Actions dropdown
	      //GUIFunctions.selectDropDownValue(ActionsDropdown, "Schaffhausen" , "text", "Launch Selected dropdown");
		  shippingaddresspage.driver.findElement(By.xpath("//select[@name='region_id']//option[contains(text(),'Schaffhouse')]")).click();
	      Thread.sleep(1000);
	  }
	  else
	  {
	    shippingaddresspage.VerifyCountryDpdIsAutoSelected_AsEU(CustomFun.getAddressDSDetails().get().getCountry());
	  }
	}
	
	@Test(description="Entered Phone Number in Phone Number Field", priority=60)
	public void step60_EnteredPhoneNumberField() throws Exception
	{
		if(environmentName.equals("StagingEnv1") | environmentName.equals("IntegrationEnv"))	
		{
			shippingaddresspage.EnterPhoneNum_AsEU(CustomFun.getAddressDSDetails().get().getPhoneNumber().substring(1)+"1");
		}
		else
		{
			shippingaddresspage.EnterPhoneNum_AsEU(CustomFun.getAddressDSDetails().get().getPhoneNumber());
		}
	}

	@Test(description="Verify and click on second shipping method", priority=61)
	public void step61_VerifyAndClickOnSecondShippingMethod() throws Exception
	{
		if(environmentName.contains("Integration6Env"))
		{
			WebElement ele=shippingaddresspage.driver.findElement(By.xpath(ObjRepoProp.get().getProperty("ConfirmThisAddress_xpath")));
			GUIFunctions.JavaScriptClick(shippingaddresspage.driver,
					ele,"Click on Confirm This Address button");
		}
	    shippingaddresspage.VerifyAndClickOnSecondShippingmethod();
	}   
	
	
	@Test(description="Click on Continue To Payemnt button in Checkout page", priority=62)
	public void step62_ClickOnContinueToPayemntButton() throws Exception
	{
		shippingaddresspage.ContinuetopaymentbtnClick();
	}
	
	@Test(description="Scroll down till Payment options and Verified Payment options in Checkout Page", priority=63)
	public void step63_VerifyPaymentOptions() throws Exception
	{
		paymentpage=new PaymentPage(shippingaddresspage.driver);
		paymentpage.checkout_Paymentoptions();
	}
	
	@Test(description="Click on Credit card Radio button under Payment option", priority=64)
	public void step64_ClickOnCreditCardRadioBtn() throws Exception
	{
		paymentpage.checkout_Creditcard();
	}

	@Test(description="Verify Credit Card Details under Payment option", priority=65)
	public void step65_VerifyCreditCardDetailsInPayment() throws Exception
	{
		paymentpage.VerifyCreditCardDetails();
	}
	
	@Test(description="Verified My billing and shipping address are the same checkbox is auto selected", priority=66)
	public void step67_VerifiedMyBAandSABothSame_CheckboxIsAutoSelected() throws Exception
	{
	/*	if(environmentName.equals("HomoEnv1"))	
		{
		paymentpage.VerfiedSAAndBABothSameCheckboxIsAutoSelected();
		}  */
	}
	
	@Test(description="uncheck My billing and shipping address are the same checkbox", priority=67)
	public void step68_UncheckMyBAandSABothSame_Checkbox() throws Exception
	{
	/*	if(environmentName.equals("HomoEnv1"))	
		{
		paymentpage.UncheckedSAAndBABothSameCheckboxForCredit();	
		}  */
	}
	
	@Test(priority=69,description="Entered Address Name in Address Name Field")
	public void step69_EnteredAddressNameField() throws Exception
	{
		shippingaddresspage=new ShippingAddressPage(paymentpage.driver);
	}
		
	@Test(priority=70,description="select Prefix Name Dropdown in Shipping Address Section")
	public void step70_SelectPrefixNameDpdn() throws Exception
	{
	
	}

	@Test(priority=71,description="Entered First Name in First Name Field")
	public void step71_EnteredFirstNameField() throws Exception
	{
		
	}

	@Test(priority=72,description="Entered Last Name in Last Name Field")
	public void step72_EnteredLastNameField() throws Exception
	{
		
	}

	@Test(priority=73,description="Entered Address in Address Field")
	public void step73_EnteredAddressField() throws Exception
	{
		
	}

	@Test(priority=74,description="Entered PostCode in PostCode Field")
	public void step74_EnteredPostCodeField() throws Exception
	{
		
	}

	@Test(priority=75,description="Entered City in City Field")
	public void step75_EnteredCityField() throws Exception
	{
		
	}

	@Test(priority=76,description="verified default Country selected in country Field")
	public void step76_VerifiedCountryField() throws Exception
	{
		 
	}
	
	@Test(priority=77,description="Entered Phone Number in Phone Number Field")
	public void step77_EnterPhoneNumField() throws Exception
	{
		
	}
	
	@Test(priority=78,description="click on update btn")
	public void step78_ClickOnUpdateBtn() throws Exception
	{
	   paymentpage=new PaymentPage(shippingaddresspage.driver);
	}
	
	@Test(priority=79,description="Entered Credit Number in Credit Number Field")
	public void step79_EnteredCreditNumberField() throws Exception
	{
		GUIFunctions.scrollByJavaScriptExecutor(paymentpage.driver.findElement(By.xpath("//li[@id='payment']")), paymentpage.driver, "Payment Options");
		paymentpage.checkout_CCCardnumber(CustomFun.getPaymentDSDetails().get().getCardNumber());
	}
	
	@Test(priority=80,description="Entered Expiry Date in Expiry Date Field")
	public void step80_EnteredExpiryDateField() throws Exception
	{
		paymentpage.checkout_CCExpirydate(CustomFun.getPaymentDSDetails().get().getCardExpiryDate());
	}
	
	@Test(priority=81,description="Entered CVV in CVV Field")
	public void step81_EnteredCVVField() throws Exception
	{
		paymentpage.checkout_CCV(CustomFun.getPaymentDSDetails().get().getCardCVV());
	}	
	
	@Test(priority=82,description="Entered CardHolder Name in CardHolder Name Field")
	public void step82_EnteredCardHolderField() throws Exception
	{
		paymentpage.checkout_Cardholdername(CustomFun.getPaymentDSDetails().get().getCardHolderName());
	}
	
	@Test(priority=83,description="Checked on Privacy Policy and Return Policy checkbox")
	public void step83_CheckedOnPrivacyPolicyAndReturnPolicyCheckbox() throws Exception
	{
		paymentpage.checkout_Agreements_CreditCard();
	}
	
	@Test(priority=84,description="Click on Proceed button in Checkout page at Payment Section")
	public void step84_ClickOnProceedButtonAtPaymentSection() throws Exception
	{
		  if(environmentName.contains("IntegrationEnv"))
		  {
			  paymentpage.driver.findElement(By.xpath("(//button[contains(@class,'action primary checkout')])[1]")).click();
			  Thread.sleep(1000);
		  }
		  else
		  {
			  paymentpage.checkout_CC_ProceedbtnForCreditCard();
		  }
	}

	@Test(priority = 85,description = "Click on Proceed button in Checkout page at Payment Section & Entered 3DS Credentials")
	public void step85_ClickOnProceedButtonAndEntered3DSCredentials() throws Exception {
	CustomFun.waitForPageLoaded(paymentpage.driver);
	//paymentpage.checkout_3DSUsername(CustomFun.getPaymentDSDetails().get().get3DS_Username());
	paymentpage.checkout_3DSPassword(CustomFun.getPaymentDSDetails().get().get3DS_Password());
	paymentpage.checkout_ClickOnSubmitButton();
	CustomFun.waitForPageLoaded(paymentpage.driver);
	}
	
	
	 @Test(priority=86,description="verify unsuccess msg")
	    public void step86_VerifyUnsuccesfullOrderplacedWithInvalid3DSCardMsg() throws Exception
	    {
	          cartpage=new CartPage(paymentpage.driver);
	          CustomFun.waitForPageLoaded(cartpage.driver);
	          cartpage.VerifyUnsuccesfullOrderplacedWithInvalid3DSCardMsg();
	    }
		
		@Test(description="Click on Sales Icon", priority=87)
		public void step87_ClickOnSalesIcon() throws Exception
		{
		CustomFun.SwitchToSpecificTab(backofficepage.driver, "1");
		backofficepage.SalesIconClick();
		}

		@Test(description="Click on Orders text from Sales Icon", priority=88)
		public void step88_ClickOrderstxtFromSalesIcon() throws Exception
		{
		backofficepage.OrderstxtFromSalesIconClick();	
		CustomFun.waitForPageLoaded(backofficepage.driver);
		}
		
		@Test(priority=89,description="Verified Order Status in Orders page")
		public void step89_NavigatedIntoMangetoAndVerifiedOrderStatusInOrdersPage() throws Exception
		{
			if(!backofficepage.driver.findElement(By.xpath(ObjRepoProp.get().getProperty("ClearAllLink_xpath"))).isDisplayed())
			{
			//backofficepage.SearchFor_ERPID(environmentName, locale.get());
			}
			else
			{
			backofficepage.driver.findElement(By.xpath(ObjRepoProp.get().getProperty("ClearAllLink_xpath"))).click();
			CustomFun.waitForPageLoaded(backofficepage.driver);
			//backofficepage.SearchFor_ERPID(environmentName, locale.get());
			}
			
			
			if(environmentName.equals("StagingEnv1"))
			{
			OrderID=backofficepage.driver.findElement(By.xpath("//div[contains(text(),'B520000000043') or contains(text(),'B520000000026') or contains(text(),'B520000000057')]/../..//div[@class='data-grid-cell-content']")).getText();
			backofficepage.VerifyOrderStatusInBO_OrdersPage(OrderID);
			}
			else
		    if(environmentName.equals("HomoEnv1"))
		    {
		    	OrderID=backofficepage.driver.findElement(By.xpath("//div[contains(text(),'+33204773644') or contains(text(),'B520004241175') or contains(text(),'B520004241187')]/../..//div[@class='data-grid-cell-content']")).getText();
				backofficepage.VerifyOrderStatusInBO_OrdersPage(OrderID);
		    }
		    else
		    {
			OrderID=backofficepage.driver.findElement(By.xpath("//div[contains(text(),'B520000000020') or contains(text(),'B520003316120') or contains(text(),' B520003316140')]/../..//div[@class='data-grid-cell-content']")).getText();
			backofficepage.VerifyOrderStatusInBO_OrdersPage(OrderID);
			}
			
	    	for(int i=0;i<=5;i++)
			{
	    		backofficepage.ClearTheFilterInBO(OrderID);
			  backofficepage.VerifyOrderStatusInBO_OrdersPage(OrderID);
			  OrderStatus=BackOfficePage.OrderStatus;
			  if(OrderStatus.contains(TextProp.get().getProperty("Canceltxt")))
			  {
				  OrderStatus=BackOfficePage.OrderStatus;
				  Assert.assertEquals(TextProp.get().getProperty("Canceltxt"), OrderStatus);
				  log.info("Successfully Verified Order Status in Magento After Placing the order with wrong credit card details: " + OrderStatus);
				  Reporter.log("<p>Successfully Verified Order Status in Magento After Placing the order with wrong credit card details: " + OrderStatus);
				  break;
			  }
			}
		}
	    
	 @Test(description="Open New Tab and Navigated to Adyen", priority=90)
	    public void step90_OpenNewTabAndNavigatedtoAdyen() throws Exception
	    {
	         adyenpage=new AdyenPage(homepage.driver);
	         CustomFun.OpenNewTabAndSwitchToNewTab(adyenpage.driver, "2");
	         adyenpage.driver.navigate().to(CustomFun.getAdyenInfoDSDetails().get().getAdyenUrl());
	    }
	    
	    @Test(description="Logged into Adyen with valid crendentials", priority=91)
	    public void step91_LoggedIntoAdyen() throws Exception
	    {
	    adyenpage.AdyenLogIn(CustomFun.getAdyenInfoDSDetails().get().getAdyenUsername(),CustomFun.getAdyenInfoDSDetails().get().getAdyenAccount(),CustomFun.getAdyenInfoDSDetails().get().getAdyenPassword());
	    }
	    
	    @Test(description="Click on Transaction", priority=92)
	    public void step92_ClickTransactionINAdyen() throws Exception
	    {
	          adyenpage.Click_AdyenTransactionTab();
	    }
	    
	    @Test(description="Click on payment option from transactions", priority=93)
	    public void step93_ClickPaymentOPtionINAdyen() throws Exception
	    {
	    	adyenpage.Click_AdyenTransactionPaymentTab();
	    }
	    
	    @Test(description="Enter order Id in serach bar ", priority=94)
	    public void step94_EnterOrderIDinPaymentTab_adyen() throws Exception
	    {
	    adyenpage.Enter_AdyenPaymentSearchField(OrderID);
	    } 
	
	    @Test(description="Verify order status of refused in Adyen ", priority=95)
	    public void step95_VerifyOrderStatusIN_Adyen() throws Exception
	    {
	    	  CustomFun.waitForPageLoaded(backofficepage.driver);
	    	  adyenpage.Verify_AdyenOrderIDStatus(OrderID);
	    	  OrderStatus=AdyenPage.OrderStatusFromAdyen;
	    	  Assert.assertEquals(TextProp.get().getProperty("Adyen_RefusedStatus"), OrderStatus);
	    	  log.info("Successfully Verified Order Status in Adyen Page After entering wrong credit card details: " + OrderStatus);
	    	  Reporter.log("<p>Successfully Verified Order Status in Adyen Page After entering wrong credit card details: " + OrderStatus);
	    }
        
        @Test(description="Verify Account creation Confirmation Mail Contents", priority=96)
	    public void step96_VerifyAccountCreationConfirmationMailContents() throws InterruptedException
	    {
           String EmailID=CustomFun.getUserInfoDSDetails().get().getEmailDomain();
           String Password=CustomFun.getUserInfoDSDetails().get().getAppPassword();
      	   String FirstName=CustomFun.getUserInfoDSDetails().get().getFirstName();
      	   String LastName=CustomFun.getUserInfoDSDetails().get().getLastName();
      	   if(locale.get().contains("FR_FR"))
 			   {
      	          Emails.verifyEmailSubjectLine(""+EmailID+""+":"+""+Password+"", "Bonjour "+LastName +""+LastName+""+ FirstName+"!");
 			   }else
 			   if(locale.get().contains("UK_EN"))
 			   {
 				  Emails.verifyEmailSubjectLine(""+EmailID+""+":"+""+Password+"", "Welcome, Mr. "+FirstName+" "+LastName+"!");
 			   }
 			   else
 			   {
 				 Emails.verifyEmailSubjectLine(""+EmailID+""+":"+""+Password+"", "Welcome, Mr. "+FirstName+" "+LastName+"!"); 
 			   }
      	   Reporter.log("Successfully Verified Account Creation Confirmation Mail & Subject Line : " + Emails.strMailSubject);
      	   Reporter.log("<p>Successfully Verified Account Creation Confirmation Mail Received Time : " + Emails.strReceivedMailTime);	
	    }   
}
