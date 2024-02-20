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
public class TC_Scenario_10 extends BaseTest
{

	public Logger log = Logger.getLogger(this.getClass().getName());
	public static String OrderID;
	public String OrderStatus; 
	public MyAccountPage RMA_ID_FO;
	public String RefundMemoID;
	public static String RMAID;
	public static String BarCodeSKU;
	public static String Size;
	public static String ref_searchable_SKUID;
	public String ShippingBarCode;
	
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
	
	@Test(description="Navigated to CL Home Page")
	public void step01_NavigatedtoCLHomePage() throws Exception
	{
	logtest("Create an RMA for the order by changing wrong billing and shipping address & verify the RMA error");
	System.out.println("Entry to the script ");
	System.out.println("The base url "+ baseUrl.get());
	homepage=HomePage.navigateToCLApplication_URL(driver.get(), baseUrl.get());
	}

	@Test(priority=2, description=" Clicking on My Account Icon ")
	public void step02_ClickMyAccountBtn() throws Exception
	{
	System.out.println("step 2 begin");
	if(locale.get().contains("FR_FR") | bsValue.get().contains("YES") | locale.get().contains("CH_FR") | environmentName.equals("HomoEnv") | locale.get().contains("UK_EN"))
	{
		for (int i = 0; i <= 1; i++)
		{
			Thread.sleep(2000);
			CustomFun.refreshPage(homepage.driver);
			Thread.sleep(2000);
		}
		homepage.clickMyaccountBtn();
	}
	else
	{
		homepage.clickMyaccountBtn();
	}
	log.info("Successfully clicked on My account Icon from Homepage \n");
	Reporter.log("<p>Successfully clicked on My account Icon from Homepage");
	System.out.println("step 2 end");
	}  
	  
	
	@Test(priority=3, description=" Enter the Email in login field  ")
	public void step3_EnterEmailAddressInLogin() throws Exception
	{
	System.out.println("step 3 begin");
	homepage.EnterEmail(CustomFun.getUserInfoDSDetails().get().getEmailDomain());
	log.info("Successfully Entered Email Address in Login field");
	Reporter.log("<p>Successfully Entered Email Address in Login field");
	System.out.println("step 3 end");
    }
	
	@Test(priority=4, description=" Enter the password in login field  ")
	public void step4_EnterPasswordInLogin() throws Exception
	{
	System.out.println("step 4 begin");
	homepage.EnterPassword(CustomFun.getUserInfoDSDetails().get().getPassword());
	log.info("Successfully Entered password in Login field");
	Reporter.log("<p>Successfully Entered password in Login field");
	System.out.println("step 4 end");
    }
	
	@Test(priority=5, description=" Click on sign in Btn  in login field and verify user is in MyAccountpage  ")
	public void step5_ClickOnSignInBtnAndVerifyUserIsInMyAccountPage() throws Exception
	{
	System.out.println("step 5 begin");
	homepage.clickOnSignBtn();
	myaccountpage=new MyAccountPage(homepage.driver);
	myaccountpage.VerifyUserIsInMyAccountpage();	
	GUIFunctions.RemoveExistProductsFromMyCartIcon(homepage.driver);
	CustomFun.refreshPage(homepage.driver);
	System.out.println("step 5 end");
    }
	
	@Test(description="Mouse Over on Ladies L1 Category", priority=6)
	public void step06_MouseOverElementOnLadiesL1Category() throws Exception
	{
		categorylandingpage=new CategoryLandingPage(myaccountpage.driver);
		categorylandingpage.mouseOverCategory();
	}
	
	
	@Test(description="Click on L3 Ladies - Kate Category", priority=7)
	public void step07_ClickOnL3KateLadiesCategory() throws Exception
	{
		if(environmentName.contains("HomoEnv"))
        {
          categorylandingpage.ladiesL3KateCategoryClick();
          Thread.sleep(2000);
        }
        else
        if(environmentName.equals("StagingEnv"))
        {
          categorylandingpage.ladiesL3KateCategoryClick();
          Thread.sleep(2000);
        }
        else
        {
            categorylandingpage.driver.findElement(By.xpath("//span[contains(text(),'Iriza')]")).click();
            Thread.sleep(2000);
        }
	} 
	
	@Test(priority=8,description="Scroll down till last sealable product & Click on Sealable Product In Category Landing Page")
	public void step08_ScrollDownTillLastSealableProdAndClickOnLastSealableProductInCategoryLandingPage() throws Exception
	{ 
		GUIFunctions.ClickOnLastSealableProduct(categorylandingpage.driver);
		CustomFun.waitForPageLoaded(categorylandingpage.driver);
		productdetailspage=new ProductDetailsPage(categorylandingpage.driver);
	}

	@Test(description="Verified Product Name in Product Details Page", priority=9)
	public void step09_VerifiedProductNameinPDP() throws Exception
	{
		productdetailspage.VerifyProductNametxtInPDP();
	}
	
	@Test(description="Verified Product Price in Product Details Page", priority=10)
	public void step10_VerifiedProductPriceinPDP() throws Exception
	{
		productdetailspage.VerifyProductPricetxtInPDP();
	}
	
	
	@Test(description="Verified Brand name in Product Details Page", priority=11)
	public void step11_VerifiedBrandnameinPDP() throws Exception
	{
		productdetailspage.VerifyProductBrandNametxtInPDP();
	}
	
	@Test(priority=12,description="Verified Color swatches in PDP")
	public void step12_VerifiedColorSwatches() throws Exception
	{
	productdetailspage.pdpColorSwatches();
	}
	
	@Test(priority=13, description="Verified Add to cart button in Product Details Page" )
	public void step13_VerifiedAddtoCartbtnInPDP() throws Exception
	{
	productdetailspage.VerifyAddtoCartbtnInPDP();
	}
	
	@Test(description="Click on In_store_availability button and close overlay", priority=14)
	public void step14_ClickOnInStoreAvailabilityButtonAndCloseOverlay() throws Exception
	{
		productdetailspage.ClickonInStoreAvailabilitybtnAndCloseOverlayInPDP();
	}
	
	@Test(description="Verified Contact Us link", priority=15)
	public void step15_VerifiedContactUslink() throws Exception
	{
		productdetailspage.VerifyContactUsLinkInPDP();
	}
	
	
	@Test(description="Verified Size Guide option, Click on Size Guide and close overlay", priority=16)
	public void step16_ClickOnSizeGuideAndCloseOverlay() throws Exception
	{
	productdetailspage.pdpSizeguideInfo();
	}
	
	@Test(description="Click On Select_Your_Size Button and Select any Size", priority=17)
	public void step17_ClickOnSelectYourSizeButtonAndSelectAnySize() throws Exception {

		productdetailspage.ClickOnSelectYourSizeBtnAndSelectAnySizeInPDP();
		Size=ProductDetailsPage.GetSizeOfProd;
	}
	
	@Test(description="Click on Product Info and Verified content under Product Info section", priority=18)
	public void step18_ClickonProductInfoAndVerifiedContent() throws Exception
	{
		productdetailspage.pdpNotification_Closebtn();
		productdetailspage.pdpProductInfoBlock();
		ref_searchable_SKUID=ProductDetailsPage.Ref_searchable_sku;
	}
	
	@Test(description="Click on Product Care and Verified content under Product Care section", priority=19)
	public void step19_ClickonProductCareAndVerifiedContent() throws Exception
	{
		productdetailspage.pdpProductCareBlock();
	}
	
	@Test(description="Click on Shipping and Verified content under Shipping section", priority=20)
	public void step20_ClickonShippingAndVerifiedContent() throws Exception
	{
		productdetailspage.pdpShippingBlock();
	
	}  
	
	@Test(priority=21,description="Verify PDP main and thumbnail image ")
	public void step21_VerifyMainThumbnailImg() throws Exception
	{
	productdetailspage.pdpMainimage();
	
	}
	
	@Test(description="Click on Add To Cart Button", priority=22)
	public void step22_ClickonAddToCartButton() throws Exception
	{
		productdetailspage.pdpAddtoCartbtn();
	} 

	
	@Test(priority=23,description="Verification of PDP notification block")
	public void step23_VerifiedPDPConfirmationMessagePopUPModal() throws Exception
	{
		productdetailspage.pdpProductadd_Notification();
	} 
	
	@Test(priority=24,description="Verification of Continue shopping and  order now btn in PDP notification block")
	public void step24_VerifiedContinueShoppingAndOrderNowBTn() throws Exception
	{
		productdetailspage.pdpNotification_ContinebtnOrderNow();
	}
	
	
	@Test(priority=25,description="Click on continue shopping btn")
	public void step25_ClickOnOrdernowBtn() throws Exception
	{
		productdetailspage.pdpNotification_Ordernowbtn();
	} 
			
	@Test(description="Open New Tab and Navigated to WMS", priority=26)
	public void step26_OpenNewTabAndNavigatedtoWMS() throws Exception
	{
	wmspage=new WMSPage(productdetailspage.driver);
	CustomFun.OpenNewTabAndSwitchToNewTab(wmspage.driver, "1");
	wmspage.driver.navigate().to(CustomFun.getWMSInfoDSDetails().get().getWMSURL());
	}

	@Test(description="Logged into WMS with valid crendentials", priority=27)
	public void step27_LoggedIntoWMS() throws Exception
	{
	wmspage.WMSLogIn(CustomFun.getWMSInfoDSDetails().get().getWmsUsername(),CustomFun.getWMSInfoDSDetails().get().getWmsPassword());
	}

	@Test(description="Click on OK button in WMS", priority=28)
	public void step28_ClickOnOKbutton() throws Exception
	{
	wmspage.Click_WMSOKBtn();
	}

	@Test(description="Mouse Over on Data Lists Menu", priority=29)
	public void step29_MouseOverElementOnDataListsMenu() throws Exception
	{
	wmspage.WMS_Datalistmenu();
	}

	@Test(description="Click on Products from Data Lists", priority=30)
	public void step30_ClickOnProductsFromDataLists() throws Exception
	{
	wmspage.WMS_Datalist_Productclick();
	}

	@Test(description="Enter Searchable SKU & Click on Submit Filter", priority=31)
	public void step31_EnterSearchableSKUAndClickOnSubmitFilter() throws Exception
	{
	wmspage.SearchSKUIDInListOfProducts(ref_searchable_SKUID, Size);
	BarCodeSKU=WMSPage.barcodeSKU;
	}

	@Test(description="Click on Details Button", priority=32)
	public void step32_ClickOnDetailsButton() throws Exception
	{
	wmspage.ClickOnDetailsButton(Size);
	}

	@Test(description="Scroll down till stocks grid and Verify Initial Saleable Stock", priority=33)
	public void step33_VerifyInitialSaleableStock() throws Exception
	{
	wmspage.VerifyInitialSaleableStock();
	}

	@Test(description="Verify Reserved Stock", priority=34)
	public void step34_VerifyReservedStock() throws Exception
	{
	wmspage.VerifyInitialReservedStock();
	}  
	
	
	@Test(description="Open New Tab and Navigated to Magento BO", priority=35)
    public void step35_OpenNewTabAndNavigatedtoMagentoBO() throws Exception
    {
		 backofficepage=new BackOfficePage(homepage.driver);
	      CustomFun.OpenNewTabAndSwitchToNewTab(backofficepage.driver, "2");
	      backofficepage.driver.navigate().to(CustomFun.getBODSDetails().get().getBO_URL());
    }
    
    @Test(description="Entered Username in Username Field", priority=36)
    public void step36_EnteredUsernameField() throws Exception
    {
    backofficepage.EnterUsername(CustomFun.getBODSDetails().get().getBO_Username());
    }
    
    @Test(description="Entered Password in Password Field", priority=37)
    public void step37_EnteredPasswordField() throws Exception
    {
    backofficepage.EnterPassword(CustomFun.getBODSDetails().get().getBO_Password());
    }
    
    @Test(description="Click on SignIn Button", priority=38)
    public void step38_ClickOnSignInButton() throws Exception
    {
      backofficepage.SignbtnClick();
      if(environmentName.contains("IntegrationEnv") | environmentName.contains("HomoEnv1") | environmentName.contains("StagingEnv") | environmentName.contains("Integration6Env"))
	    {
			Thread.sleep(5000);
			CustomFun.refreshPage(backofficepage.driver);
			Thread.sleep(5000);
		}
    }
    
    @Test(description="Verified Dashboard Header & check whether user is in Dashboard page", priority=39)
    public void step39_VerifiedDashboardHeaderInBO() throws Exception
    {
      CustomFun.waitForPageLoaded(backofficepage.driver);
      backofficepage.VerifyDashboardHeader();
    }
    
    @Test(description="Click on Catalog Icon", priority=40)
    public void step40_ClickOnCatalogIcon() throws Exception
    {
      backofficepage.CatalogIconClick();
    }
    
    @Test(description="Click on Products text from Catalog Icon", priority=41)
    public void step41_ClickProductstxtFromCatalogIcon() throws Exception
    {
      backofficepage.ProductstxtFromCatalogIconClick();
    }
    
    @Test(description="Search For Product Seleable Stock In BO", priority=42)
    public void step42_SearchForProductSeleableStockInBO() throws Exception
    {
     backofficepage.SearchForProductSeleableStockInBO(BarCodeSKU);
    }
    
    @Test(description="Verify Initial Saleable Stock", priority=43)
    public void step43_VerifyInitialSaleableStock() throws Exception
    {
       backofficepage.VerifyInitialSaleableStockInBO(BarCodeSKU);
    } 
	
	@Test(priority=44,description="Verify No wrap Gift and  wrap Gift img ")
	public void step44_VerifyNOWrapAndWRapGiftImg() throws Exception
	{
		CustomFun.SwitchToSpecificTab(homepage.driver, "0");
		checkoutpage=new CheckoutPage(backofficepage.driver);
		checkoutpage.VerifyGiftWrappingImg();	
	}
	
	@Test(priority=45,description="Verify Gift default no wrap img selected ")
	public void step45_VerifyDefaultGiftWrapSelected() throws Exception
	{
		checkoutpage.VerifyNoWarpImgIsSelected();
	}
	
	
	@Test(priority=46,description="Enter message in Gift msg fld ")
	public void step46_EnterMsgInGiftMsgFld() throws Exception
	{
		checkoutpage.ScrollDowntillYourMsgField_EnterMsg("test");
	
	}
	
	@Test(priority=47,description="Click on update button ")
	public void step47_ClickUpdateBtn() throws Exception
	{
		checkoutpage.UpdatebtnClick();	
	}
	
	@Test(description="Verified Shipping Address Header in Checkout Page at Shipping Address Section", priority=48)
	public void step48_VerifiedShippingAddressHeaderInCP() throws Exception
	{
	shippingaddresspage=new ShippingAddressPage(checkoutpage.driver);
	shippingaddresspage.VerifyShippingAddressHeader();
	shippingaddresspage.VerfiedSAAndBABothSameCheckboxIsAutoSelectedForCredit();
	}
	
	@Test(description="Click on New Address Button in Checkout Page at Shipping Address Section", priority=49)
	public void step49_ClickOnNewAddressButtonInSAP() throws Exception
	{	
	shippingaddresspage.NewAddressbtnClick_AsEU();
	}
	
	@Test(description="Verify shipping address text, close icon ,address book checkbox in Shipping Address Section", priority=50)
	public void step50_VerifyShippingAddressPopupInSAP() throws Exception
	{	
	shippingaddresspage.VerifyShippingAddressPopup();
	}
	
	@Test(description="Entered Address Name in Address Name Field", priority=51)
	public void step51_EnteredAddressNameField() throws Exception
	{
			shippingaddresspage.EnterAddressNameAsEUToAddNewSA(CustomFun.getAddressDSDetails().get().getAddressName());
	}

	@Test(description="Verified Prefix Name Dropdown is Auto Selected or not at Shipping Address Section", priority=52)
	public void step52_VerifiedPrefixNameDpdIsAutoSelectedOrNot() throws Exception
	{
			 shippingaddresspage.VerifyPrefixDpdIsAutoSelected_AsEU(CustomFun.getAddressDSDetails().get().getNamePrefix());
	}

	@Test(description="Entered First Name in First Name Field", priority=53)
	public void step53_EnteredFirstNameField() throws Exception
	{
			shippingaddresspage.EnterFirstNameAsEUToAddNewSA(CustomFun.getAddressDSDetails().get().getFirstName());
	}

	@Test(description="Entered Last Name in Last Name Field", priority=54)
	public void step54_EnteredLastNameField() throws Exception
	{
			shippingaddresspage.EnterLastNameAsEUToAddNewSA(CustomFun.getAddressDSDetails().get().getLastName());
	}

	@Test(description="Entered Address in Address Field", priority=55)
	public void step55_EnteredAddressField() throws Exception
	{
			shippingaddresspage.EnterAddressDetailsAsEUToAddNewSA(CustomFun.getAddressDSDetails().get().getAddress1());
	}

	@Test(description="Entered PostCode in PostCode Field", priority=56)
	public void step56_EnteredPostCodeField() throws Exception
	{
			shippingaddresspage.EnterPostcodeAsEUToAddNewSA(CustomFun.getAddressDSDetails().get().getPostcode());
	}

	@Test(description="Entered City in City Field", priority=57)
	public void step57_EnteredCityField() throws Exception
	{
		if(locale.get().contains("CH_FR") & environmentName.equals("HomoEnv1"))
		{
			//shippingaddresspage.EnterCity_AsEU(CustomFun.getAddressDSDetails().get().getCity());
			  shippingaddresspage.driver.findElement(By.xpath("(//input[contains(@name,'city')])[2]")).sendKeys(CustomFun.getAddressDSDetails().get().getCity());
			  Thread.sleep(1000);
			  WebElement ActionsDropdown=shippingaddresspage.driver.findElement(By.xpath("//div[@id='shipping-new-address-form']//select[@name='region_id']"));
			  ActionsDropdown.click();
			  Thread.sleep(1000);
		        // select Launch Selected Options from Actions dropdown
		      //GUIFunctions.selectDropDownValue(ActionsDropdown, "Schaffhausen" , "text", "Launch Selected dropdown");
			  shippingaddresspage.driver.findElement(By.xpath("//div[@id='shipping-new-address-form']//select[@name='region_id']//option[contains(text(),'Schaffhouse')]")).click();
		      Thread.sleep(1000);
		}
		else
		if(environmentName.equals("StagingEnv1"))
		{
			shippingaddresspage.EnterCityAsEUToAddNewSA(CustomFun.getAddressDSDetails().get().getCity());
		}
		else
		{
			// shippingaddresspage.EnterCity_AsEU(CustomFun.getAddressDSDetails().get().getCity());
			 shippingaddresspage.driver.findElement(By.xpath("(//input[contains(@name,'city')])[2]")).sendKeys(CustomFun.getAddressDSDetails().get().getCity());
			 Thread.sleep(1000);
		}
	}

	@Test(description="verified default Country selected in country Field", priority=58)
	public void step58_VerifiedCountryField() throws Exception
	{
			shippingaddresspage.VerifyCountryDpdIsAutoSelected_AsEU(CustomFun.getAddressDSDetails().get().getCountry());
	}
	
	@Test(description="Entered Phone Number in Phone Number Field", priority=59)
	public void step59_EnteredPhoneNumberField() throws Exception
	{
		if(environmentName.equals("StagingEnv1") || environmentName.equals("IntegrationEnv"))	
		{
			shippingaddresspage.EnterPhoneNumAsEUToAddNewSA(CustomFun.getAddressDSDetails().get().getPhoneNumber().substring(1)+"1");
		}
		else
		{
			//shippingaddresspage.EnterPhoneNum_AsEU(CustomFun.getAddressDSDetails().get().getPhoneNumber());
			shippingaddresspage.driver.findElement(By.xpath("(//input[contains(@name,'telephone')])[2]")).sendKeys(CustomFun.getAddressDSDetails().get().getPhoneNumber());
			Thread.sleep(1000);
		}
	}

	@Test(description="Click on SHIP HERE button in shipping address Overlay and Verify Address Updated Message", priority=60)
	public void step60_ClickOnSHIPHEREButton() throws Exception
	{
	shippingaddresspage.ShipHerebtnClick();
	shippingaddresspage.VerifyAddressUpdatedSuccessMsg();
	Thread.sleep(1000);
	}
	

	@Test(description="Verify Newly added Radio button is selected and also Edit link text is displayed and verified shipped header txt", priority=61)
	public void step61_VerifyNewlyAddedShippingAddressRadioBtnAndEditLnkTxtAndShippingHeaderTxt() throws Exception
	{
	shippingaddresspage.VerifyNewlyAddedShippingAddressRadioBtn();
	shippingaddresspage.VerifyShippingMethodAndDescLabel();
	}   
	
	
	@Test(description="Click on Third Shipping Method radio button in Checkout page", priority=62)
	public void step62_ClickOnThirdShippingMethodRadioButton() throws Exception
	{
		if(environmentName.contains("Integration6Env"))
		{
			WebElement ele=shippingaddresspage.driver.findElement(By.xpath(ObjRepoProp.get().getProperty("ConfirmThisAddress_xpath")));
			GUIFunctions.JavaScriptClick(shippingaddresspage.driver,
					ele,"Click on Confirm This Address button");
		}
		shippingaddresspage.VerifyAndClickOnSecondShippingmethod();
	}
		
	
	@Test(description="Click on Continue To Payemnt button in Checkout page", priority=63)
	public void step63_ClickOnContinueToPayemntButton() throws Exception
	{
	shippingaddresspage.ContinuetopaymentbtnClick();

	}
	
	@Test(description="Scroll down till Payment options and Verified Payment options in Checkout Page", priority=64)
	public void step64_ClickOnContinueToPayemntButton() throws Exception
	{
	paymentpage=new PaymentPage(shippingaddresspage.driver);
	paymentpage.checkout_Paymentoptions();
	
	}
	
	
	@Test(description="Click on Credit card Radio button under Payment option", priority=65)
	public void step65_ClickOnCreditCardRadioBtn() throws Exception
	{
	paymentpage.checkout_Creditcard();

	}
	

	@Test(description="Verify Credit Card Details under Payment option", priority=66)
	public void step66_VerifyCreditCardDetailsInPayment() throws Exception
	{
	paymentpage.VerifyCreditCardDetails();
	}
	
	@Test(description="Verified My billing and shipping address are the same checkbox is auto selected", priority=67)
	public void step67_VerifiedMyBAandSABothSame_CheckboxIsAutoSelected() throws Exception
	{
		/*if(environmentName.equals("HomoEnv1"))	
		{	
	       paymentpage.VerfiedSAAndBABothSameCheckboxIsAutoSelected();
		} */
	}
	
	
	@Test(description="Verification of Credit card fields and privacy policy checkbox", priority=68)
	public void step68_VerifyCreditCardFieldsAndCheckbox() throws Exception
	{
	paymentpage.checkout_Paymentoptions();
	paymentpage.checkout_VerifyCheckboxText();
	}
	
	
	@Test(description="Entered Credit Number in Credit Number Field", priority=69)
	public void step69_EnteredCreditNumberField() throws Exception
	{
	paymentpage.checkout_CCCardnumber(CustomFun.getPaymentDSDetails().get().getCardNumber());
		
	}
	
	@Test(description="Entered Expiry Date in Expiry Date Field", priority=70)
	public void step70_EnteredExpiryDateField() throws Exception
	{
	paymentpage.checkout_CCExpirydate(CustomFun.getPaymentDSDetails().get().getCardExpiryDate());
	}
	
	@Test(description="Entered CVV in CVV Field", priority=71)
	public void step71_EnteredCVVField() throws Exception
	{
	paymentpage.checkout_CCV(CustomFun.getPaymentDSDetails().get().getCardCVV());
	}	
	
	@Test(description="Entered CardHolder Name in CardHolder Name Field", priority=72)
	public void step72_EnteredCardHolderField() throws Exception
	{
	paymentpage.checkout_Cardholdername(CustomFun.getPaymentDSDetails().get().getCardHolderName());
	}
	
	@Test(description="Checked on Privacy Policy and Return Policy checkbox", priority=73)
	public void step73_CheckedOnPrivacyPolicyAndReturnPolicyCheckbox() throws Exception
	{
		paymentpage.checkout_Agreements_CreditCard();
	}
	
	@Test(description="Click on Proceed button in Checkout page at Payment Section", priority=74)
	public void step74_ClickOnProceedButton() throws Exception
	{
	if(environmentName.contains("IntegrationEnv"))
	  {
		  paymentpage.driver.findElement(By.xpath("(//button[contains(@class,'action primary checkout')])[1]")).click();
		  Thread.sleep(1000);
	  }
	  else
	  {
		  paymentpage.checkout_CC_Proceedbtn_credit();
	  }
	}
	
	@Test(description="Verified Success Message in Order Confirmation page after placing the order", priority=75)
	public void step75_VerifiedSuccessMsgAfterPlacingOrder() throws Exception
	{
	orderconfirmationpage=new OrderConfirmationPage(paymentpage.driver);
	orderconfirmationpage.Verify_SuccessOrder_Msg_txt();
	}
	
	@Test(description="Verified Continue Shopping Button in Order Confirmation page", priority=76)
	public void step76_VerifiedContinueShoppingButton() throws Exception
	{
	orderconfirmationpage.VerifyContinueShopping_Btn();
	}
	
	@Test(description="Verified Your OrderID in Order Confirmation page", priority=77)
	public void step77_VerifiedYourOrderID() throws Exception
	{
	orderconfirmationpage.VerifyOrderIDInOCP();
	}
	
	@Test(description="Initialised OrderID in OrderID variable for further execution", priority=78)
	public void step78_InitialisedOrderID() throws Exception
	{
		if(environmentName.contains("IntegrationEnv"))
		{
			OrderID=OrderConfirmationPage.OrderConfirmationId.replaceAll("[^0-9.]", "").substring(1);
	        System.out.println("Successfully Saved Order ID for further execution - "+OrderID);
		}
		else
		{
         	OrderID=OrderConfirmationPage.OrderConfirmationId.replaceAll("[^0-9.]", "");
	        System.out.println("Successfully Saved Order ID for further execution - "+OrderID);
		}
	}
	
	
	@Test(priority=79, description=" Clicking on My Account Icon ")
	public void step79_ClickMyAccountBtn() throws Exception
	{
	homepage=new HomePage(orderconfirmationpage.driver);
	CustomFun.waitForPageLoaded(homepage.driver);
	homepage.driver.findElement(By.xpath(ObjRepoProp.get().getProperty("HP_MyAccount_Icon"))).click();
	} 
	
	@Test(priority=80, description=" Clicking on My orders link ")
	public void step80_ClickMyOrdersLink() throws Exception
	{
	 myaccountpage=new MyAccountPage(homepage.driver);
	 myaccountpage.MyOrders_LnkClick();	
	}
	
	@Test(priority=81, description=" Verify order status ")
	public void step81_VerifyOrderStatus() throws Exception
	{
	myaccountpage.VerifyOrderStatus(OrderID);
	myaccountpage.VerifyOrderPriceInOrderspage(OrderID);
	MyAccountPage.PriceVal_OrderPage= myaccountpage.driver.findElement(By.xpath("//*[contains(text(),'"+OrderID+"')]/..//p[contains(@class, 'price')]")).getText().replaceAll(",","\\.").replaceAll("[^0-9.]", "");   
    myaccountpage.VerifyOrderItemInOrderspage(OrderID);
	myaccountpage.VerifyOrderDateInOrderspage(OrderID);
	if(locale.get().contains("FR_FR"))
	{
	 for(int i=0;i<=2;i++)
	 {
	    Thread.sleep(30000);
	    CustomFun.refreshPage(myaccountpage.driver);
	    Thread.sleep(5000);
      	myaccountpage.VerifyOrderStatus(OrderID);
     	OrderStatus=MyAccountPage.OrderStatusFromFO;
     	if(OrderStatus.contains(TextProp.get().getProperty("OrderBeingValidatedtxt_FR")))
		{
     	Assert.assertEquals(MyAccountPage.OrderStatusFromFO,TextProp.get().getProperty("OrderBeingValidatedtxt_FR"));
     	break;
		}
	  }
	}
	else
		 for(int i=0;i<=2;i++)
		 {
		    Thread.sleep(30000);
		    CustomFun.refreshPage(myaccountpage.driver);
		    Thread.sleep(5000);
	    	myaccountpage.VerifyOrderStatus(OrderID);
	    	OrderStatus=MyAccountPage.OrderStatusFromFO;
	    	if(OrderStatus.contains(TextProp.get().getProperty("OrderPendingSecurityChecktxt_UK")))
			{
	    	Assert.assertEquals(OrderStatus,TextProp.get().getProperty("OrderPendingSecurityChecktxt_UK"));
	    	break;
			}
		 }
	}     
	
	@Test(description="Click on Sales Icon", priority=83)
	public void step83_ClickOnSalesIcon() throws Exception
	{
	CustomFun.SwitchToSpecificTab(backofficepage.driver, "2");
	backofficepage.SalesIconClick();
	}

	@Test(description="Click on Orders text from Sales Icon", priority=84)
	public void step84_ClickOrderstxtFromSalesIcon() throws Exception
	{
	backofficepage.OrderstxtFromSalesIconClick();	
	CustomFun.waitForPageLoaded(backofficepage.driver);
	backofficepage.VerifyOrdersHeadertxt();
	}

	@Test(priority=85,description="Navigated Into Magento and Verified Order Status in Orders page")
	public void step85_NavigatedIntoMangetoAndVerifiedOrderStatusInOrdersPage() throws Exception
	{
		CustomFun.waitObjectToLoad(backofficepage.driver, By.xpath("//button[text()='Clear all']"), Duration.ofSeconds(10));
		if (!backofficepage.driver.findElement(By.xpath("//button[text()='Clear all']")).isDisplayed()) {
			backofficepage.driver.findElement(By.xpath("//input[@id='fulltext']")).sendKeys(OrderID);
			CustomFun.waitObjectToLoad(backofficepage.driver, By.xpath("(//button[@class='action-submit'])[2]"), Duration.ofSeconds(10));
			backofficepage.driver.findElement(By.xpath("(//button[@class='action-submit'])[2]")).click();
			backofficepage.VerifyOrderStatusInBO_OrdersPage(OrderID);
		} else {
			GUIFunctions.JavaScriptClick(backofficepage.driver,
					backofficepage.driver.findElement(By.xpath("//button[text()='Clear all']")),
					"Click on Clear All button");
			backofficepage.driver.findElement(By.xpath("//input[@id='fulltext']")).sendKeys(OrderID);
			CustomFun.waitObjectToLoad(backofficepage.driver, By.xpath("(//button[@class='action-submit'])[2]"), Duration.ofSeconds(10));
			GUIFunctions.JavaScriptClick(backofficepage.driver,
					backofficepage.driver.findElement(By.xpath("(//button[@class='action-submit'])[2]")),
					"Click on Search Icon");
			backofficepage.VerifyOrderStatusInBO_OrdersPage(OrderID);
		}
		// OrderStatus=BackOfficePage.OrderStatus;
		for (int i = 0; i <= 8; i++) {
			Thread.sleep(60000);
			CustomFun.refreshPage(backofficepage.driver);
			Thread.sleep(5000);
			backofficepage.ClearTheFilterInBO(OrderID);
			 backofficepage.VerifyOrderStatusInBO_OrdersPage(OrderID);
		     OrderStatus=BackOfficePage.OrderStatus;
			if (OrderStatus.contains(TextProp.get().getProperty("SenttoLogistictxt"))) {
				OrderStatus = BackOfficePage.OrderStatus;
				Assert.assertEquals(TextProp.get().getProperty("SenttoLogistictxt"), OrderStatus);
				log.info("Successfully Verified Order Status in Magento After Placing the order in FO: " + OrderStatus);
				Reporter.log("<p>Successfully Verified Order Status in Magento After Placing the order in FO: "
						+ OrderStatus);
				break;
			}
		}
	}
	
	@Test(description="Navigated Into BO and Verified Seleable Stock Quantity Decremented By 1", priority=86)
    public void step86_VerifiedSaleableStockQntyDecBy1InBOAferPlacingTheOrder() throws Exception
    {
    CustomFun.refreshPage(backofficepage.driver);
    CustomFun.waitForPageLoaded(backofficepage.driver);
    backofficepage.CatalogIconClick();
    backofficepage.ProductstxtFromCatalogIconClick();
    backofficepage.SearchForProductSeleableStockInBO(BarCodeSKU);
    backofficepage.VerifySaleableStockQntyDecBy1InBOAferPlacingTheOrder(BarCodeSKU);
    }
    
    @Test(description="Navigated Into WMS and Verified Seleable Stock Quantity Decremented By 1", priority=87)
    public void step87_VerifySaleableStockDecBy1InWMSAferPlacingTheOrder() throws Exception
    {
          CustomFun.SwitchToSpecificTab(wmspage.driver, "1");
          CustomFun.refreshPage(wmspage.driver);
          CustomFun.waitForPageLoaded(wmspage.driver);
          wmspage.VerifySaleableStockDecBy1InWMSAferPlacingTheOrder();
    }
    
    @Test(description="Comparing the Seleable stock in the WMS and the BO Magento", priority=88)
    public void step88_ComparedSeleableStockInWMSAndBOBothAreSame() throws Exception
    {
  
    CustomFun.refreshPage(wmspage.driver);
    CustomFun.waitForPageLoaded(wmspage.driver);
    wmspage.VerifyInitialSaleableStock();
    CustomFun.SwitchToSpecificTab(backofficepage.driver, "2");
    backofficepage.CatalogIconClick();
    backofficepage.ProductstxtFromCatalogIconClick();
    backofficepage.SearchForProductSeleableStockInBO(BarCodeSKU);
    backofficepage.VerifyInitialSaleableStockInBO(BarCodeSKU);
    }
	
	@Test(description="Navigated Back to FO ", priority=89)
	public void step89_NavigateBackToFO() throws Exception
	{
	homepage=new HomePage(backofficepage.driver);
	CustomFun.SwitchToSpecificTab(homepage.driver, "0");	
	}   
	
	@Test(description="Navigated Back to FO and click on My orders link From My account icon ", priority=90)
	public void step90_NavigateBackToFOAndClickOnMyOrdersLnk() throws Exception
	{
		myaccountpage=new MyAccountPage(homepage.driver);
		homepage.driver.findElement(By.xpath(ObjRepoProp.get().getProperty("HP_MyAccount_Icon"))).click();	
		Thread.sleep(2000);
		myaccountpage.MyOrders_LnkClick();
	}    
	
	@Test(description="Verify order status in My orders page  ", priority=91)
	public void step91_VerifiedOrderStatusInMyOrdersPage() throws Exception
	{
	myaccountpage.VerifyOrderStatus(OrderID);
	if(locale.get().contains("FR_FR") | locale.get().contains("CH_FR"))
	{
	Assert.assertEquals(MyAccountPage.OrderStatusFromFO,TextProp.get().getProperty("OrderInPreparationtxt_FR"));
	}
	else
	{
		 for(int i=0;i<=2;i++)
		 {
		    Thread.sleep(30000);
		    CustomFun.refreshPage(myaccountpage.driver);
		    Thread.sleep(5000);
	    	myaccountpage.VerifyOrderStatus(OrderID);
	    	OrderStatus=MyAccountPage.OrderStatusFromFO;
	    	if(OrderStatus.contains(TextProp.get().getProperty("OrderPlacedtxt_UK")))
			{
	    	Assert.assertEquals(MyAccountPage.OrderStatusFromFO,TextProp.get().getProperty("OrderPlacedtxt_UK"));
	    	break;
			}
		 }	
	}
	}
	
	@Test(description="Picking Order Process", priority=92)
	public void step92_PickingOrderProcess() throws Exception
	{
		CustomFun.SwitchToSpecificTab(wmspage.driver, "1");
		wmspage.PickingOrderProcess(OrderID);
	}

	@Test(description="Verified Picking order for # XXXXX", priority=93)
	public void step93_VerifiedPickingOrderSuccessMsg() throws Exception
	{
	    wmspage.VerifyPickingOrderSuccessMsg();	
	}
	

	@Test(priority=94,description="Navigated Into WMS and Get BarCode From Picking Process")
	public void step94_NavigatedIntoWMSAndGetBarcodeFromPickingProcess() throws Exception
	{
		wmspage.getBarCodeFromPickingProcess(OrderID);
		ShippingBarCode=WMSPage.BarCodeId;
	}
	
	@Test(priority=95,description="Navigated Into Magento and Verified Order Status in Orders page")
	public void step95_NaviagtedIntoMangetoAndVerifiedOrderStatusInOrdersPage() throws Exception
	{
		CustomFun.SwitchToSpecificTab(backofficepage.driver, "2");
		backofficepage.SalesIconClick();
        backofficepage.OrderstxtFromSalesIconClick();
		CustomFun.waitForPageLoaded(backofficepage.driver);
		backofficepage.ClearTheFilterInBO(OrderID);
		backofficepage.VerifyOrderStatusInBO_OrdersPage(OrderID);
	    OrderStatus=BackOfficePage.OrderStatus;
	    for(int i=0;i<=2;i++)
		{
		  Thread.sleep(30000);
		  CustomFun.refreshPage(backofficepage.driver);
		  Thread.sleep(5000);
		  backofficepage.ClearTheFilterInBO(OrderID);
		  backofficepage.VerifyOrderStatusInBO_OrdersPage(OrderID);
	      OrderStatus=BackOfficePage.OrderStatus;
		  if(BackOfficePage.OrderStatus.contains(TextProp.get().getProperty("PickingProgresstxt")))
		  {
	        Assert.assertEquals(TextProp.get().getProperty("PickingProgresstxt"), OrderStatus);
	        log.info("Successfully Verified Order Status in Magento After Picking Process: " + OrderStatus);
		    Reporter.log("<p>Successfully Verified Order Status in Magento After Picking Process: " + OrderStatus);
		    break;
		  }
		}
	 }
	
	@Test(priority=96,description="Navigated Into FO and Verified Order Status in My Orders page")
  	public void step96_NaviagtedIntoFOAndVerifiedOrderStatusInMyOrdersPage() throws Exception
  	{
  		CustomFun.SwitchToSpecificTab(homepage.driver, "0");
		CustomFun.refreshPage(homepage.driver);
		CustomFun.waitForPageLoaded(homepage.driver);
		myaccountpage=new MyAccountPage(homepage.driver);
		myaccountpage.VerifyOrderStatus(OrderID);
	    if(locale.get().contains("FR_FR") | locale.get().contains("CH_FR"))
		{
		Assert.assertEquals(MyAccountPage.OrderStatusFromFO,TextProp.get().getProperty("OrderInPreparationtxt_FR"));
		}
		else
		{
		Assert.assertEquals(MyAccountPage.OrderStatusFromFO,TextProp.get().getProperty("Processingtxt_UK"));	
		}
	    log.info("Successfully Verified Order Status in My orders page: " + MyAccountPage.OrderStatusFromFO);
		Reporter.log("<p>Successfully Verified Order Status in My orders page: " + MyAccountPage.OrderStatusFromFO);
  	 } 
	
	
	@Test(priority=97,description="Navigated Into WMS and Click on Packing Button")
	public void step97_NavigatedIntoWMSAndClickOnPackingBtn() throws Exception
	{
		CustomFun.SwitchToSpecificTab(wmspage.driver, "1");
		wmspage.Click_WMSPackingBtn();
	}
	
	@Test(priority=98,description="Entered BarcodeID in Barcode Field And Search For Packing")
	public void step98_EnteredBarcodeAndSearchForPacking() throws Exception
	{
		wmspage.EnterBarcodeAndSearchForPacking(ShippingBarCode);
	}
	
	@Test(priority=99,description="Copy SKUID And Enter in Search Field For Scanning Products In Packing")
	public void step99_CopySKUIDAndEnterinSearchFeildForScanningProductsInPacking() throws Exception
	{
		wmspage.CopySKUIDAndEnterinSearchFldForScanningProductsInPacking();
	}
	
	@Test(priority=100,description="Click on Complete Packing button")
	public void step100_ClickOnCompletePackingBtn() throws Exception
	{
		wmspage.Click_CompletePackingBtn();
	}
	
	@Test(priority=101,description="Enter quantity in front of any row")
	public void step101_EnteredQuantityInAnyRow() throws Exception
	{
		wmspage.EnterQuantity_Packing("1");
	}
	
	@Test(priority=102,description="Click on Validate button")
	public void step102_ClickOnValidateBtn() throws Exception
	{
		wmspage.ClickValidate_Packing();
	}
	
	@Test(priority=103,description="Click on Home Popup button")
	public void step103_ClickOnHomePopupBtn() throws Exception
	{
		wmspage.ClickHomeBtn_PopUp();
	}
	
	@Test(priority=104,description="Navigated Into Magento and Verified Order Status in Orders page")
	public void step104_NavigatedIntoMangetoAndVerifiedOrderStatusInOrdersPage() throws Exception
	{
		CustomFun.SwitchToSpecificTab(backofficepage.driver, "2");
        CustomFun.refreshPage(backofficepage.driver);
        CustomFun.waitForPageLoaded(backofficepage.driver);
        backofficepage.ClearTheFilterInBO(OrderID);
        backofficepage.VerifyOrderStatusInBO_OrdersPage(OrderID);
        OrderStatus=BackOfficePage.OrderStatus;
        Assert.assertEquals(TextProp.get().getProperty("Invoicedtxt"), OrderStatus);
        log.info("Successfully Verified Order Status in Magento After Packing Process is completed: " + OrderStatus);
        Reporter.log("<p>Successfully Verified Order Status in Magento After Packing Process is completed: " + OrderStatus);
	 }
	
	@Test(priority=105,description="Navigated Into FO and Verified Order Status in My Orders page")
	public void step105_NaviagtedIntoFOAndVerifiedOrderStatusInMyOrdersPage() throws Exception
	{
		CustomFun.SwitchToSpecificTab(homepage.driver, "0");
		CustomFun.refreshPage(homepage.driver);
        CustomFun.waitForPageLoaded(homepage.driver);
		myaccountpage=new MyAccountPage(homepage.driver);
		myaccountpage.VerifyOrderStatus(OrderID);
		if(locale.get().contains("FR_FR") | locale.get().contains("CH_FR"))
		{
		Assert.assertEquals(MyAccountPage.OrderStatusFromFO,TextProp.get().getProperty("OrderInPreparationtxt_FR"));
		}
		else
		{
		Assert.assertEquals(MyAccountPage.OrderStatusFromFO,TextProp.get().getProperty("Processingtxt_UK"));	
		}
	    log.info("Successfully Verified Order Status in My orders page: " + MyAccountPage.OrderStatusFromFO);
		Reporter.log("<p>Successfully Verified Order Status in My orders page: " + MyAccountPage.OrderStatusFromFO);
	 } 
	
	
	@Test(priority=106,description="Navigated Into WMS and Processed with Shipping Process")
	public void step106_NavigatedIntoWMSAndProcessedwithShippingProcess() throws Exception
	{
		 CustomFun.SwitchToSpecificTab(wmspage.driver, "1");
		wmspage.ShippingOrderProcess_LGE(ShippingBarCode);
	}
	
	@Test(priority=107,description="Verified Label Generation Error Message")
	public void step107_VerifiedLabelGenerationErrorMessageMsg() throws Exception
	{
		wmspage.VerifyLabelGenerationErrorMsg();
	}
	
	@Test(priority=108,description="Navigated Into Magento and Verified Order Status in Orders page")
	public void step108_NaviagtedIntoMangetoAndVerifiedOrderStatusInOrdersPage() throws Exception
	{
		CustomFun.SwitchToSpecificTab(backofficepage.driver, "2");
		CustomFun.refreshPage(backofficepage.driver);
		backofficepage.ClearTheFilterInBO(OrderID);
		backofficepage.VerifyOrderStatusInBO_OrdersPage(OrderID);
	    OrderStatus=BackOfficePage.OrderStatus;
	    Assert.assertEquals(TextProp.get().getProperty("LabelGenerationErrortxt"), OrderStatus);
	    log.info("Successfully Verified Order Status in Magento After Label generatio Error: " + OrderStatus);
		Reporter.log("<p>Successfully Verified Order Status in Magento After Label generatio Error: " + OrderStatus);
	}
	
	@Test(priority=109,description="Switch to FO Tab & Click on My Account Icon")
	public void step109_SwitchToFOTabAndClickOnMyAccountIcon() throws Exception
	{
		CustomFun.SwitchToSpecificTab(homepage.driver, "0");
		homepage.driver.findElement(By.xpath(ObjRepoProp.get().getProperty("HP_MyAccount_Icon"))).click();
	}
	
	@Test(priority=110,description="Verified Order Status in My Orders page")
	public void step110_VerifiedOrderStatusInMyOrdersPage() throws Exception
	{
		myaccountpage.VerifyOrderStatus(OrderID);
	}
	
	@Test(priority=111,description="Navigated Into Magento")
	public void step111_NavigatedIntoMangetoAndRefreshThePage() throws Exception
	{
		CustomFun.SwitchToSpecificTab(backofficepage.driver, "2");
		CustomFun.refreshPage(backofficepage.driver);
	}
	
	@Test(priority=112,description="Click on View option under order grid")
	public void step112_ClickonViewOptioninOrderGrid() throws Exception
	{
		backofficepage.ClearTheFilterInBO(OrderID);
		backofficepage.VerifyOrderStatusInBO_OrdersPage(OrderID);
	    backofficepage.ClickOnOrderGrid(OrderID);
	}
	
	@Test(priority=113,description="Edited Exist Shipping & Billing Address with New Shipping Address For RMA")
	public void step113_EditExistShippingAndBillingAddressWithNewShippingAddressForRMA() throws Exception
	{
		if(locale.get().contains("FR_FR"))
	    {
		backofficepage.EditExistShippingAddressWithCorrectZipCodeForRMA("29000");
		backofficepage.EditExistBillingAddressWithCorrectZipCodeForRMA("29000");
	    }
		else
	    if(locale.get().contains("UK_EN"))
	    {
				 backofficepage.EditExistShippingAddressWithCorrectZipCodeForRMA("PH22 8UJ");
				 backofficepage.EditExistBillingAddressWithCorrectZipCodeForRMA("PH22 8UJ");
				 Thread.sleep(10000);
		}
		else
	    {
				 backofficepage.EditExistShippingAddressWithCorrectZipCodeForRMA("3086");
				 backofficepage.EditExistBillingAddressWithCorrectZipCodeForRMA("3086");
				 Thread.sleep(10000);
		}
	}
	
	@Test(priority=114,description="Naviagted Back Into WMS & Generate Orders With Label Ready To Be Reprinted In WMS")
	public void step114_GenerateOrdersWithLabelReadyToBeReprintedInWMS() throws Exception
	{
		CustomFun.SwitchToSpecificTab(wmspage.driver, "1");
		wmspage.OrdersWithLabelReadyToBeReprintedInWMS(OrderID);
	}
	
	@Test(priority=115,description=" Navigated Into Magento and Click on Sales Icon")
	public void step115_NavigatedIntoMangetoAndClickOnSalesIcon() throws Exception
	{
		CustomFun.SwitchToSpecificTab(backofficepage.driver, "2");
		backofficepage.SalesIconClick();
	}
	
	@Test(priority=116,description="Click on Orders text from Sales Icon")
	public void step116_ClickOrderstxtFromSalesIcon() throws Exception
	{
		backofficepage.OrderstxtFromSalesIconClick();
	}
	
	@Test(priority=117,description="Verified Order Status in Orders page")
	public void step117_VerifiedOrderStatusInOrdersPage() throws Exception
	{
		CustomFun.SwitchToSpecificTab(backofficepage.driver, "2");
		 for(int i=0;i<=2;i++)
         {
       	Thread.sleep(30000);
   		CustomFun.refreshPage(backofficepage.driver);
   		Thread.sleep(5000);
   		backofficepage.ClearTheFilterInBO(OrderID);
   		backofficepage.VerifyOrderStatusInBO_OrdersPage(OrderID);
           OrderStatus=BackOfficePage.OrderStatus;
           if(OrderStatus.contains(TextProp.get().getProperty("Shippedtxt")))
           break;
         }
        backofficepage.VerifyOrderStatusInBO_OrdersPage(OrderID);
        OrderStatus=BackOfficePage.OrderStatus;
        Assert.assertEquals(TextProp.get().getProperty("Shippedtxt"), OrderStatus);
        log.info("Successfully Verified Order Status in Magento After Shipping Process is completed: " + OrderStatus);
        Reporter.log("<p>Successfully Verified Order Status in Magento After Shipping Process is completed: " + OrderStatus);
	}
	

	@Test(priority=118,description="Navigated Into FO and Verified Order Status in My Orders page")
	public void step118_NaviagtedIntoFOAndVerifiedOrderStatusInMyOrdersPage() throws Exception
	{
		CustomFun.SwitchToSpecificTab(homepage.driver, "0");		
		CustomFun.refreshPage(homepage.driver);
		CustomFun.waitForPageLoaded(homepage.driver);
		myaccountpage=new MyAccountPage(homepage.driver);
		myaccountpage.VerifyOrderStatus(OrderID);
		if(locale.get().contains("FR_FR") | locale.get().contains("CH_FR"))
		{
		Assert.assertEquals(MyAccountPage.OrderStatusFromFO,TextProp.get().getProperty("OrderShippedtxt_FR"));
		}
		else
		{
		 for(int i=0;i<=5;i++)
		 {
		    Thread.sleep(30000);
		    CustomFun.refreshPage(myaccountpage.driver);
		    Thread.sleep(5000);
	    	myaccountpage.VerifyOrderStatus(OrderID);
	    	OrderStatus=MyAccountPage.OrderStatusFromFO;
	    	if(OrderStatus.contains(TextProp.get().getProperty("OrderShippedtxt_UK")))
			{
	    	Assert.assertEquals(MyAccountPage.OrderStatusFromFO,TextProp.get().getProperty("OrderShippedtxt_UK"));
	    	break;
			}
		 }	
		}
	 }
	
	@Test(priority=119,description="Navigated Into Magento and click on order grid")
	public void step119_NavigatedIntoMangetoAndClickOnOrderGrid() throws Exception
	{
		CustomFun.SwitchToSpecificTab(backofficepage.driver, "2");
		CustomFun.refreshPage(backofficepage.driver);
		backofficepage.ClearTheFilterInBO(OrderID);
		backofficepage.ClickOnOrderGrid(OrderID);	
		CustomFun.waitForPageLoaded(backofficepage.driver);
	}
	
	@Test(priority=120,description="Click on Create Returns button to create New Return")
	public void step120_ClickOnCreateReturnsButton() throws Exception
	{
		backofficepage.CreateReturnsBtnClick();
	}
	
	@Test(priority=121,description="Edited Exist Shipping Address with Wrong Zipcode")
	public void step121_EditExistShippingAddressWithWrongZipCodeForRMA() throws Exception
	{	
		backofficepage.EditExistShippingAddressWithWrongZipCodeForRMA();
	}
	
	@Test(priority=122,description="Verify Success Msg For RMA Updated Address")
	public void step122_VerifySuccessMsgForRMAAddressUpdate() throws Exception
	{
		backofficepage.VerifySuccessMsgForRMAAddressUpdate();	
	}
	
	@Test(priority=123,description="Select Pickup date to create New Return")
	public void step123_SelectPickupDate() throws Exception
	{		
		backofficepage.PickupdateRadioBtnClick();
	}
	
	@Test(priority=124,description="Click on Return Items Tab")
	public void step124_ClickOnReturnItems() throws Exception
	{
		backofficepage.ReturnsItemsClick();
	}
	
	@Test(priority=125,description="Click on Add Product Button")
	public void step125_ClickOnAddProductButton() throws Exception
	{
		backofficepage.AddProductsBtnClick();
	}
	
	@Test(priority=126,description="Click on Checkbox to select the product")
	public void step126_ClickOnCheckboxToSelectTheProduct() throws Exception
	{
		backofficepage.CheckboxProdToAddClick();
	}
	
	@Test(priority=127,description="Click on Add Select Product To Returns Button")
	public void step127_ClickOnAddSelProdToReturnsBtn() throws Exception
	{
		backofficepage.AddSelProdToReturnsBtnClick();	
	}
	
	@Test(priority=128,description="Entered Requested value in Requested Field under RMA Items Requested for Grid")
	public void step128_EnterValueInRequestedField() throws Exception
	{
		backofficepage.EnterValueInRequestedField("1");
	}
	
	@Test(priority=129,description="Select any Return Reason option from Return Reason Dropdown")
	public void step129_SelectAnyOptionFromReturnReasonDropdown() throws Exception
	{
		backofficepage.SelectOptionFromReturnReasonDropdown();		
	}
	
	@Test(priority=130,description="Select any Item Condition option from Item Condition Dropdown")
	public void step130_SelectOptionFromItemConditionDropdown() throws Exception
	{
		backofficepage.SelectOptionFromItemConditionDropdown();
	}
	
	@Test(priority=131,description="Select any Resolution Reason option from Resolution Dropdown")
	public void step131_SelectOptionFromResolutionDropdown() throws Exception
	{
		backofficepage.SelectOptionFromResolutionDropdown("Refund");
	}
	
	@Test(priority=132,description="Click on Submit Returns Button")
	public void step132_ClickOnSubmitReturnsButton() throws Exception
	{
		backofficepage.SubmitReturnsBtnClick();	
	}
	
	@Test(priority=133,description="Verify Success Msg For RMA Request after submit returns")
	public void step133_VerifySuccessMsgForRMARequest() throws Exception
	{
		backofficepage.VerifySuccessfulMsgForRMARequest();
	}

	/**step134  Verify RMA error in Returns Page  ->
	RMA Order ID status is not auto changing from pending to authorized after Creating RMA Request in FO so created defect (ECOM-16776)
	*/

	@Test(priority=134,description="Verified RMA Order ID Status in Returns page")
	public void step134_SearchFORRMAIDAndVerifyErrorStatus() throws Exception
	{
	CustomFun.waitObjectToLoad(backofficepage.driver, By.xpath("//button[text()='Clear all']"),Duration.ofSeconds(10));
	if(!backofficepage.driver.findElement(By.xpath("//button[text()='Clear all']")).isDisplayed())
	{
	backofficepage.SearchForRMAOrder(OrderID);
	CustomFun.refreshPage(backofficepage.driver);
	 backofficepage.driver.findElement(By.xpath("//button[text()='Clear all']")).click();
     Thread.sleep(5000);
     backofficepage.SearchForRMAOrder(OrderID);
     backofficepage.VerifyReturnsStatusInBO_ReturnsPage(OrderID);
    }  	
	else
	{
	backofficepage.driver.findElement(By.xpath("//button[text()='Clear all']")).click();
	backofficepage.SearchForRMAOrder(OrderID);	
	CustomFun.refreshPage(backofficepage.driver);
	 backofficepage.driver.findElement(By.xpath("//button[text()='Clear all']")).click();
     Thread.sleep(5000);
     backofficepage.SearchForRMAOrder(OrderID);
     backofficepage.VerifyReturnsStatusInBO_ReturnsPage(OrderID);
    }  
	for(int i=0;i<=6;i++)
	{
	  backofficepage.ClearTheFilterInBOForReturnsOrder(OrderID);
      backofficepage.VerifyReturnsStatusInBO_ReturnsPage(OrderID);
      OrderStatus=BackOfficePage.RMAIDStatus;
	  if(BackOfficePage.OrderStatus.contains(TextProp.get().getProperty("RMAErrortxt")))
	  {
		  OrderStatus=BackOfficePage.OrderStatus;
		  Assert.assertEquals(TextProp.get().getProperty("RMAErrortxt"), OrderStatus);
		  log.info("Successfully Verified Order Status in Magento After entering wrong value for shipping address of RMA: " + OrderStatus);
	      Reporter.log("<p>Successfully Verified Order Status in Magento After entering wrong value for shipping address of RMA: " + OrderStatus);
		  break;
	  }
	}
	 //Assert.assertEquals(TextProp.get().getProperty("RMAErrortxt"), OrderStatus);
    }
	
	//step135  Verify for RMA error mail -> not getting mail so created defect (ECOM-15783)
	
	@Test(description="Verified RMA Error Mail Confirmation and Subject line of Mail in Customer Gmail Account", priority=135)
	public void step135_VerifiedRMAErrorMailAndSubjectLineInCustomerGmailAccount() throws Exception
	{
		//Code will be developed once after the defect is fixed. As this is issue is exist on all the applications.
	}
		
	    @Test(description="Verify Order Confirmation Mail Contents", priority=136)
		public void step136_VerifyOrderConfirmationMailContents() throws InterruptedException
		{
	    	String EmailID = CustomFun.getUserInfoDSDetails().get().getEmailDomain();
			String Password = CustomFun.getUserInfoDSDetails().get().getAppPassword();
			if(locale.get().contains("FR_FR"))
			{
			    Emails.verifyEmailSubjectLine("" + EmailID + "" + ":" + "" + Password + "", "Christian Louboutin Europe Online Boutique: Nouvelle commande # " + OrderID);
			}
			else
			if(locale.get().contains("UK_EN"))
			{
				Emails.verifyEmailSubjectLine("" + EmailID + "" + ":" + "" + Password + "", "Christian Louboutin Europe Online Boutique: New order # " + OrderID);
			}
			else
			{
				Emails.verifyEmailSubjectLine("" + EmailID + "" + ":" + "" + Password + "", "Christian Louboutin Europe Online Boutique: New order # " + OrderID);
			}
			Reporter.log("Successfully Verified Order Confirmation Mail & Subject Line : " + Emails.strMailSubject);
			Reporter.log("<p>Successfully Verified Order Confirmation Mail Received Time : " + Emails.strReceivedMailTime);
	    	
		}  
}