package src.in.valtech.cl.scenarios;
import org.apache.log4j.Logger;    
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import static src.in.valtech.util.PropertyFileReader.ObjRepoProp;
import static src.in.valtech.util.PropertyFileReader.TextProp;
import src.in.valtech.cl.back.pages.AdyenPage;
import src.in.valtech.cl.back.pages.BackOfficePage;
import src.in.valtech.cl.back.pages.WMSPage;
import src.in.valtech.cl.front.pages.CartPage;
import src.in.valtech.cl.front.pages.CategoryLandingPage;
import src.in.valtech.cl.front.pages.CheckoutPage;
import src.in.valtech.cl.front.pages.HomePage;
import src.in.valtech.cl.front.pages.MyAccountPage;
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

public class TC_Scenario_01 extends BaseTest
{
	
	public static String OrderID;
	public String OrderStatus; 
	public MyAccountPage RMA_ID_FO;
	public String RefundMemoID;
	public static String RMAID;
	public String RMAIDStatus;
	public String ShipmentID;
	public String OrderPrice;
	public String BarCodeForScan;
	
	public static String BarCodeSKU;
	public static String Size;
	public static String ref_searchable_SKUID;


	public Logger log = Logger.getLogger(this.getClass().getName());
	
	HomePage homepage;
	MyAccountPage myaccountpage;
	ProductListingPage productlistingpage;
	CategoryLandingPage categorylandingpage;
	ProductDetailsPage productdetailspage;
	CartPage cartpage;
	CheckoutPage checkoutpage;
	ShippingAddressPage shippingaddresspage;
	PaymentPage paymentpage;
	OrderConfirmationPage orderconfirmationpage;
	BackOfficePage backofficepage;
	WMSPage wmspage;
	AdyenPage adyenpage;
	
	@Test(priority=01, description="Precondition: Open browser,Navigate to the CL URL and accept Cookies")
	public void step01_NavigatetoCLHomePage() throws Exception
	{
	logtest("Create a refund credit memo with only shipping fees");
	System.out.println("step 1 begin");
	homepage =HomePage.navigateToCLApplication_URL(driver.get(),baseUrl.get());
	log.info("Successfully navigated to application URL \n");
	Reporter.log("<p>Successfully navigated to application URL");
	System.out.println("step 1 end");
	}

	
    @Test(priority=02, description="Verification of Homepage Logo ")
	public void step02_VerificationOfHomepageLogo() throws Exception
	{
	System.out.println("step 2 begin");	
	homepage.Verify_LogoImg();
	log.info("Successfully Verified Homepage Logo  \n");
	Reporter.log("<p>Successfully Verified  Homepage Logo");
	System.out.println("step 2 end");
	}
	
    
    @Test(priority=03, description="Verification of Homepage Pictures")
	public void step03_VerificationOfHomepagePictures() throws Exception
	{
    	 for(int i=1;i<=2;i++)
	       {
	    	   Thread.sleep(10000);
	    	   homepage.driver.navigate().refresh();
	    	   Thread.sleep(10000);
	       }
	 homepage.VerifyPictures();
	}
	
	@Test(priority=04, description="Verification of Product Widgets")
	public void step04_VerificationOfProductWidgets() throws Exception
	{
	 homepage.VerifyProductWidgets();
	}
     
	@Test(priority=05, description="Verification of Header Main Navigation text")
	public void step05_VerificationOfHeaderNavigationText() throws Exception
	{
		
         GUIFunctions.pageScrollToTopOfPage(homepage.driver);
		
	    homepage.Verify_MainNavigationHeader_txt();
	    log.info("Successfully Verified Main Header Navigation text \n");
	    Reporter.log("<p>Successfully Verified Main Header Navigation text");
	}
	
	@Test(priority=06, description="Verification of Header Right icons")
	public void step06_VerificationOfHeaderRightIcons() throws Exception
	{
	homepage.verify_HeaderRightIcons();
	log.info("Successfully Verified Header Right icons \n");
	Reporter.log("<p>Successfully Verified Right icons");
	}
	
	@Test(priority=07, description="Verification of Footer header text ")
	public void step07_VerificationOfFooterHeaderText() throws Exception
	{
	homepage.Verify_FooterHeader_txt();
	log.info("Successfully Verified Footer Header text \n");
	Reporter.log("<p>Successfully Verified Footer  Header text");
	}
	
	@Test(priority=8, description="Verification of Footer links ")
	public void step08_VerificationOfFooterLinks() throws Exception
	{
		homepage.Verify_Footer_lnk();
		log.info("Successfully Verified Footer links \n");
		Reporter.log("<p>Successfully Verified Footer links");
	}      
	
	@Test(priority=9, description="Verification of Social Icon_text ")
	public void step09_VerificationOfFooterSocialIconText() throws Exception
	{
	homepage.Verify_SocialIcon_txt();
	log.info("Successfully Verified Footer Social Icon_txt \n");
	Reporter.log("<p>Successfully Verified Footer Social Icon_txt");
	}  
	
	@Test(priority=10, description="Verification of Social Icons ")
	public void step10_VerificationOfFooterSocialIcons() throws Exception
	{
	homepage.Verify_Footer_Social_lnk();
	log.info("Successfully Verified Footer Social Icons \n");
	Reporter.log("<p>Successfully Verified Footer Social Icons");
	}  
	
	@Test(priority=11, description=" Clicking on My Account Icon ")
	public void step11_ClickMyAccountBtn() throws Exception
	{
	homepage.clickMyaccountBtn();
	log.info("Successfully clicked on My account Icon from Homepage");
	Reporter.log("<p>Successfully clicked on My account Icon from Homepage");
	}  
	
	
	@Test(priority=12, description=" Verification of All text ,links and buttons in My Account Modal ")
	public void step12_VerificationOfAllTxtLnkBtn_InMyAccountModal() throws Exception
	{
	homepage.Verify_MyAccountModal_LoginHeaderTxt();
	homepage.Verify_MyAccountModal_Welcome_text();
	homepage.Verify_MyAccountModal_EmailPlaceholderTxt();
	homepage.Verify_MyAccountModal_PwdPlaceholderTxt();
	homepage.Verify_MyAccountModal_RequiredTxt();
	homepage.Verify_MyAccountModal_DoyouHaveAccount_txt();
	homepage.Verify_FrgtPwdLnk();
	homepage.Verify_LoginSignIN_Btn();
	homepage.Verify_LoginCreateAccount_Btn();
	homepage.Verify_LoginWishlist_Lnk();	
	log.info("Successfully Verified All text ,links and buttons in My Account Modal");
	Reporter.log("<p>Successfully Verified on All text ,links and buttons in My Account Modal");
	} 
	
	@Test(priority=13, description=" Enter the Email in login field  ")
	public void step13_EnterEmailAddressInLogin() throws Exception
	{
	homepage.EnterEmail(CustomFun.getUserInfoDSDetails().get().getEmailDomain());
	log.info("Successfully Entered Email Address in Login field");
	Reporter.log("<p>Successfully Entered Email Address in Login field");
    }
	
	@Test(priority=14, description=" Enter the password in login field  ")
	public void step14_EnterPasswordInLogin() throws Exception
	{
	homepage.EnterPassword(CustomFun.getUserInfoDSDetails().get().getPassword());
	log.info("Successfully Entered password in Login field ");
	Reporter.log("<p>Successfully Entered password in Login field");
    }
	
	@Test(priority=15, description=" Click on sign in Btn  in login field  ")
	public void step15_ClickOnSignInBtn() throws Exception
	{
	homepage.clickOnSignBtn();
	log.info("Successfully Clicked on sign in Btn in Login field");
	Reporter.log("<p>Successfully Clicked on sign in Btn in Login field ");
	GUIFunctions.RemoveExistProductsFromMyCartIcon(homepage.driver);
	CustomFun.refreshPage(homepage.driver);
    }
	
	/*
	 * Defect ID :- ECOM-15832 - [Revamp_Homo] - FR_FR : Consent Checkbox is not getting displayed in My Account page 
	 * Verify Consent Checkbox step and mention comment as per the defect requirement , 
	 * this checkbox is removed from Application .Hence not automated
	 */
	
 	@Test(priority=16, description=" Verification of consent checkbox ")
	public void step16_VerifyConsentChecbox() throws Exception
	{
	myaccountpage=new MyAccountPage(homepage.driver);
/*	myaccountpage.Verify_ConsentCheckbox();
	log.info("Successfully verified consent checkbox \n");
	Reporter.log("<p>Successfully verified consent checkbox");*/
	}    
	
 	@Test(priority=17, description=" Verify all right side sections in My account page")
	public void step17_VerifyAllRightSideProductSectionsDetailsINMAP() throws Exception
	{
	myaccountpage.VerifyAllRightSideProductSectionsDetailsINMAP();
	
	}  
 	
 	@Test(priority=18, description=" Verify all left side sections in My account page")
 	public void step18_VerifyAllLeftSideProductSectionsDetailsINMAP() throws Exception
 	{
 	myaccountpage.VerifyAllLeftSideProductSectionsDetailsINMAP();

 	log.info("Successfully Verified My account page left side link content's");
 	Reporter.log("<p>SSuccessfully Verified My account page left side link content's");
 	}
 	
	@Test(priority=19, description=" Mouseover on Men Header navigation ")
	public void step19_MouseOverOnMenHeaderNavigation() throws Exception
	{
	myaccountpage=new MyAccountPage(homepage.driver);
	if(environmentName.contains("HomoEnv"))
	{
		homepage.mousehoverOnLadiesHeaderNavigation();
		log.info("Mouseover on Men Header navigation");
	}
	else
	{
		homepage.mousehoverOnLadiesHeaderNavigation();
		log.info("Mouseover on Ladies Header navigation");
	}
	} 
	
	@Test(priority=20, description=" Click On shoes Subcategory ")
	public void step20_ClickOnShoesSubcategory() throws Exception
	{
	if(environmentName.contains("HomoEnv"))
	{
		homepage.ClickOnL2IrizaCategory();
		log.info("Click On shoes Subcategory");
	}
	else
	if(environmentName.contains("IntegrationEnv"))	
	{
		homepage.ClickOnL2HotChickCategory();
	}
	else
	{
		homepage.ClickOnL2IrizaCategory();
		log.info("Click On shoes Subcategory");
	}
	} 

	
	@Test(priority=21, description=" Click On Filter Button  and verify shop by text")
	public void step21_ClickOnFilterButtonFromPLP() throws Exception
	{
        productlistingpage=new ProductListingPage(homepage.driver);
        productlistingpage.Click_Filter_btn();
	    productlistingpage.Verify_ShopBy_txt();
     	log.info("Clicked On Filter Button and verified shop by text");
	}  

    @Test(priority=22, description=" Select color from filter ")
	public void step22_SelectColorFromFilter() throws Exception
	{
	productlistingpage.ClickonRadioBtn_ForBlackColor();
	log.info("Select color from filter");
	}    
     
	@Test(priority=23, description=" Click on product from PLP ")
	public void step23_ClickOnProductImg() throws Exception
	{
    productlistingpage.Click_ProductImg();
	}
	
	@Test( priority=24, description="Verified Product Name in Product Details Page")
	public void step24_VerifiedProductNameinPDP() throws Exception
	{
	productdetailspage=new ProductDetailsPage(productlistingpage.driver);
	productdetailspage.VerifyProductNametxtInPDP();
	}    

	@Test(priority=25, description="Verified Product Price in Product Details Page" )
	public void step25_VerifiedProductPriceinPDP() throws Exception
	{
	productdetailspage.VerifyProductPricetxtInPDP();
	}
		
	@Test(priority=26, description="Verified Product brand name in Product Details Page" )
	public void step26_VerifiedProductBrandNametxtInPDP() throws Exception
	{
	productdetailspage.VerifyProductBrandNametxtInPDP();
	}
	
	@Test(priority=27, description="Verified Add to cart button in Product Details Page" )
	public void step27_VerifiedAddtoCartbtnInPDP() throws Exception
	{
	productdetailspage.VerifyAddtoCartbtnInPDP();
	}
	
	@Test(priority=28,description="Click on In_store_availability button and close overlay" )
	public void step28_ClickOnInStoreAvailabilityButtonAndCloseOverlay() throws Exception
	{
	productdetailspage.ClickonInStoreAvailabilitybtnAndCloseOverlayInPDP();
	}

	@Test(priority=29,description="Verified Contact Us link")
	public void step29_VerifiedContactUslink() throws Exception
	{
	productdetailspage.VerifyContactUsLinkInPDP();
	}

	@Test(priority=30,description="Verified Color swatches in PDP")
	public void step30_VerifiedColorSwatches() throws Exception
	{
	productdetailspage.pdpColorSwatches();
	}
		
	@Test(priority=31,description="Verified Size Guide option, Click on Size Guide and close overlay")
	public void step31_ClickOnSizeGuideAndCloseOverlay() throws Exception
	{
	productdetailspage.pdpSizeguideInfo();
	}
		
	@Test( priority=32,description="Click On Select_Your_Size Button and Select any Size")
	public void step32_ClickOnSelectYourSizeButtonAndSelectAnySize() throws Exception
	{
	productdetailspage.ClickOnSelectYourSizeBtnAndSelectAnySizeInPDP();
	Size=ProductDetailsPage.GetSizeOfProd;
	GUIFunctions.mouseOverElement(productdetailspage.driver, productdetailspage.driver.findElement(By.xpath(ObjRepoProp.get().getProperty("HP_MyAccount_Icon"))),"My Account");
	}
	
	@Test(priority=33,description="close the Confirmation Message PopUP Modal")
	public void step33_ClosePDPConfirmationMessagePopUPModal() throws Exception
	{	
	productdetailspage.pdpNotification_Closebtn();
	}
		
	@Test(priority=34,description="Click on Product Info and Verified content under Product Info section")
	public void step34_ClickonProductInfoAndVerifiedContent() throws Exception
	{
	productdetailspage.pdpProductInfoBlock();
	ref_searchable_SKUID=ProductDetailsPage.Ref_searchable_sku;
	}

	@Test(priority=35,description="Click on Product Care and Verified content under Product Care section")
	public void step35_ClickonProductCareAndVerifiedContent() throws Exception
	{
	productdetailspage.pdpProductCareBlock();
	}
	
	@Test(priority=36,description="Click on Shipping and Verified content under Shipping section")
	public void step36_ClickonShippingAndVerifiedContent() throws Exception
	{
	productdetailspage.pdpShippingBlock();
	}

	@Test(priority=37,description="Verify PDP main and thumbnail image")
	public void step37_VerifyMainThumbnailImg() throws Exception
	{
	productdetailspage.pdpMainimage();	
	}

	@Test(priority=38,description="Click on Add To Cart Button")
	public void step38_ClickonAddToCartButton() throws Exception
	{
	productdetailspage.pdpAddtoCartbtn();	
	}
	
	@Test(priority=39,description="Verification of PDP notification block")
	public void step39_VerifiedPDPConfirmationMessagePopUPModal() throws Exception
	{
	productdetailspage.pdpProductadd_Notification();
	productdetailspage.pdpNotification_ContinebtnOrderNow();
	productdetailspage.pdpNotification_Closebtn();
	}
			
	@Test(description="Open New Tab and Navigated to WMS", priority=40)
	public void step40_OpenNewTabAndNavigatedtoWMS() throws Exception
	{
	wmspage=new WMSPage(productdetailspage.driver);
	CustomFun.OpenNewTabAndSwitchToNewTab(wmspage.driver, "1");
	wmspage.driver.navigate().to(CustomFun.getWMSInfoDSDetails().get().getWMSURL());
	}

	@Test(description="Logged into WMS with valid crendentials", priority=41)
	public void step41_LoggedIntoWMS() throws Exception
	{
	wmspage.WMSLogIn(CustomFun.getWMSInfoDSDetails().get().getWmsUsername(),CustomFun.getWMSInfoDSDetails().get().getWmsPassword());
	}

	@Test(description="Click on OK button in WMS", priority=42)
	public void step42_ClickOnOKbutton() throws Exception
	{
		    wmspage.Click_WMSOKBtn();
	}

	@Test(description="Mouse Over on Data Lists Menu", priority=43)
	public void step43_MouseOverElementOnDataListsMenu() throws Exception
	{
	wmspage.WMS_Datalistmenu();
	}

	@Test(description="Click on Products from Data Lists", priority=44)
	public void step44_ClickOnProductsFromDataLists() throws Exception
	{
	wmspage.WMS_Datalist_Productclick();
	}

	@Test(description="Enter Searchable SKU & Click on Submit Filter", priority=45)
	public void step45_EnterSearchableSKUAndClickOnSubmitFilter() throws Exception
	{
	wmspage.SearchSKUIDInListOfProducts(ref_searchable_SKUID, Size);
	BarCodeSKU=WMSPage.barcodeSKU;
	}

	@Test(description="Click on Details Button", priority=46)
	public void step46_ClickOnDetailsButton() throws Exception
	{
	wmspage.ClickOnDetailsButton(Size);
	}

	@Test(description="Scroll down till stocks grid and Verify Initial Saleable Stock", priority=47)
	public void step47_VerifyInitialSaleableStock() throws Exception
	{
	wmspage.VerifyInitialSaleableStock();
	}

	@Test(description="Verify Reserved Stock", priority=48)
	public void step48_VerifyReservedStock() throws Exception
	{
	wmspage.VerifyInitialReservedStock();
	}
	
	
	@Test(description="Open New Tab and Navigated to Magento BO", priority=49)
    public void step49_OpenNewTabAndNavigatedtoMagentoBO() throws Exception
    {
      backofficepage=new BackOfficePage(homepage.driver);
      CustomFun.OpenNewTabAndSwitchToNewTab(backofficepage.driver, "2");
      backofficepage.driver.navigate().to(CustomFun.getBODSDetails().get().getBO_URL());
    }
    
    @Test(description="Entered Username in Username Field", priority=50)
    public void step50_EnteredUsernameField() throws Exception
    {
    backofficepage.EnterUsername(CustomFun.getBODSDetails().get().getBO_Username());
    }
    
    @Test(description="Entered Password in Password Field", priority=51)
    public void step51_EnteredPasswordField() throws Exception
    {
    backofficepage.EnterPassword(CustomFun.getBODSDetails().get().getBO_Password());
    }
    
    @Test(description="Click on SignIn Button", priority=52)
    public void step52_ClickOnSignInButton() throws Exception
    {
        backofficepage.SignbtnClick();
        if(environmentName.contains("IntegrationEnv") | environmentName.contains("HomoEnv1") | environmentName.contains("StagingEnv") | environmentName.contains("Integration6Env"))
  	    {
  			Thread.sleep(5000);
  			CustomFun.refreshPage(backofficepage.driver);
  			Thread.sleep(5000);
  		}
    }
    
    @Test(description="Verified Dashboard Header & check whether user is in Dashboard page", priority=53)
    public void step53_VerifiedDashboardHeaderInBO() throws Exception
    {
          CustomFun.waitForPageLoaded(backofficepage.driver);
          backofficepage.VerifyDashboardHeader();
    }
    
    @Test(description="Click on Catalog Icon", priority=54)
    public void step54_ClickOnCatalogIcon() throws Exception
    {
          backofficepage.CatalogIconClick();
    }
    
    @Test(description="Click on Products text from Catalog Icon", priority=55)
    public void step55_ClickProductstxtFromCatalogIcon() throws Exception
    {
          backofficepage.ProductstxtFromCatalogIconClick();
          CustomFun.waitForPageLoaded(backofficepage.driver);
    }
    
    @Test(description="Search For Product Seleable Stock In BO", priority=56)
    public void step56_SearchForProductSeleableStockInBO() throws Exception
    {
        backofficepage.SearchForProductSeleableStockInBO(BarCodeSKU);
    }
    
    @Test(description="Verify Initial Saleable Stock", priority=57)
    public void step57_VerifyInitialSaleableStock() throws Exception
    {
       backofficepage.SearchForProductSeleableStockInBO(BarCodeSKU);
       backofficepage.VerifyInitialSaleableStockInBO(BarCodeSKU);
    }

	@Test(priority=58,description="click on mini cart icon")
	public void step58_ClickOnMinicartIcon() throws Exception
	{
	homepage=new HomePage(productdetailspage.driver);
	CustomFun.SwitchToSpecificTab(homepage.driver, "0");
	homepage.ScrollTillMinicartAndclickOn_Minicart_Icon();
	}
	
	@Test(priority=59,description="Verification of all details inside mini cart")
	public void step59_VerifiedAllDetailsInsideMiniCart() throws Exception
	{
	cartpage=new CartPage(homepage.driver);	
	cartpage.Verify_All_txt_InMiniCart();
	cartpage.Verify_Product_Details_IN_MiniCart();
	cartpage.VerifyProductQtyIn_MiniCart();
	cartpage.Verify_Product_price_Details_MiniCart();
	cartpage.Verify_Product_NavigationLnks_MiniCart();
	}
	
	@Test(priority=60,description="click on complete cart link inside mini cart and verify product details in main cart")
	public void step60_ClickOnCompletecartLnkAndVerifyDetails_MainCart() throws Exception
	{
	cartpage.Click_ON_CompleteCartLnk_Minicart();
	cartpage.Verify_All_Redbannertxt_InMainCart();
	cartpage.Verify_Product_Details_InMainCart();
	cartpage.VerifyRemoveWishlistLnk_Maincart();
	cartpage.Verify_Product_price_Details_MainCart();
	cartpage.VerifyContactusCheckoutCTA_Maincart();
	cartpage.VerifyProductQtyIn_MainCart();
	cartpage.VerifyFAQSectionInMaincart();
	}
	
	
	@Test(priority=61,description="click on proceed to checkout CTA")
	public void step61_ClickOnProceedToCheckOutCTA() throws Exception
	{
	cartpage.Click_ON_ProceedToCheckOut_Maincart();
	}
	
	@Test(priority=62,description="Verify Gift header text and default no wrap img selected ")
	public void step62_VerifyGiftHeadertextAndDefaultGiftWrapSelected() throws Exception
	{
	checkoutpage=new CheckoutPage(cartpage.driver);	
	checkoutpage.VerifyGiftHeadertxt();
	checkoutpage.VerifyNoWarpImgIsSelected();
	}
	
	@Test(priority=63,description="Enter message in Gift msg fld ")
	public void step63_EnterMsgInGiftMsgFld() throws Exception
	{
	checkoutpage.ScrollDowntillYourMsgField_EnterMsg("Happy Birthday");
	}
	
	@Test(priority=64,description="Click on update button ")
	public void step64_ClickUpdateBtn() throws Exception
	{	
	checkoutpage.UpdatebtnClick();
	}
	
	@Test(priority=65,description="Click on any existing address")
	public void step65_ClickonExistingAdressinShipping() throws Exception
	{
	shippingaddresspage=new ShippingAddressPage(checkoutpage.driver);	
	shippingaddresspage.VerifyShippingAddressHeader();
	shippingaddresspage.driver.findElement(By.xpath(ObjRepoProp.get().getProperty("ExistShippingAddress_xpath"))).click();
	}
	
	@Test(priority=66,description="Verify Default Values selected in Shipping ")
	public void step66_VerifyDefaultValuesinShipping() throws Exception
	{	
	shippingaddresspage.VerifyExistShippingAddress_AsEU();
	shippingaddresspage.VerifyEditbtn_AsEU();
	shippingaddresspage.VerifyNewAdressBtn();
	}
	
	@Test(priority=67,description="Verify Shipping Method selected in Shipping ")
	public void step67_VerifyShippingMethod() throws Exception
	{
	shippingaddresspage.VerifyShippingMethodAndDescLabel();
	}
	
	@Test(priority=68,description="Click on continue to payment button  ")
	public void step68_ClickOnShippingmethodAndContinuePaymentBtn() throws Exception
	{
		if(environmentName.contains("Integration6Env"))
		{
			WebElement ele=shippingaddresspage.driver.findElement(By.xpath(ObjRepoProp.get().getProperty("ConfirmThisAddress_xpath")));
			GUIFunctions.JavaScriptClick(shippingaddresspage.driver,
					ele,"Click on Confirm This Address button");
		}
	   shippingaddresspage.VerifyAndClickOnSecondShippingmethod();
	   shippingaddresspage.ContinuetopaymentbtnClick();
	}  
	
	@Test(priority=69,description="Click on Credit card Radio button under Payment option")
	public void step69_ClickOnCreditCardRadioBtnAndVerifyPaymentoptions() throws Exception
	{
	paymentpage=new PaymentPage(shippingaddresspage.driver);	
	paymentpage.checkout_Paymentoptions();
	paymentpage.checkout_Creditcard();
	}
	
	@Test(priority=70,description="Verify Payment section")
	public void step70_VerifyPaymentSection() throws Exception
	{	
	
	} 
	
	@Test(priority=71,description="select different shipping address option from payment")
	public void step71_Click_DiffShippingAddressFromPayment() throws Exception
	{
		
	} 
	
	@Test(priority=72,description="Entered Credit Number in Credit Number Field" )
	public void step72_EnteredCreditNumberField() throws Exception
	{
	paymentpage.checkout_CCCardnumber(CustomFun.getPaymentDSDetails().get().getCardNumber());
	}
	
	@Test(priority=73,description="Entered Expiry Date in Expiry Date Field")
	public void step73_EnteredExpiryDateField() throws Exception
	{
	paymentpage.checkout_CCExpirydate(CustomFun.getPaymentDSDetails().get().getCardExpiryDate());
	}
	
	@Test(priority=74,description="Entered CVV in CVV Field")
	public void step74_EnteredCVVField() throws Exception
	{
	paymentpage.checkout_CCV(CustomFun.getPaymentDSDetails().get().getCardCVV());
	}	
	
	@Test(priority=75,description="Entered CardHolder Name in CardHolder Name Field")
	public void step75_EnteredCardHolderField() throws Exception
	{
	paymentpage.checkout_Cardholdername(CustomFun.getPaymentDSDetails().get().getCardHolderName());
	}

	@Test(priority=76,description="Verified privacy policy checkbox 1 and 2 text ")
	public void step76_VerifiedAndCheckedPaymentPrivacyPolicyCheckbox() throws Exception
	{
		paymentpage.checkout_Agreements_CreditCard();	
	}

	@Test( priority=77,description="Click on Proceed button in Checkout page at Payment Section")
	public void step77_ClickOnProceedButton() throws Exception
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

	@Test(priority=78,description="Verified Success Message in Order Confirmation page after placing the order")
	public void step78_VerifiedSuccessMsgAfterPlacingOrder() throws Exception
	{		
	orderconfirmationpage=new OrderConfirmationPage(paymentpage.driver);
	CustomFun.waitForPageLoaded(orderconfirmationpage.driver);
	orderconfirmationpage.Verify_SuccessOrder_Msg_txt();
	}
	
	@Test(priority=79,description="Verified Continue Shopping Button in Order Confirmation page")
	public void step79_VerifiedContinueShoppingButton() throws Exception
	{
	orderconfirmationpage.VerifyContinueShopping_Btn();
	}
	
	@Test(priority=80,description="Verified Your OrderID in Order Confirmation page")
	public void step80_VerifiedYourOrderID() throws Exception
	{	
	orderconfirmationpage.VerifyOrderIDInOCP();
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
	
	@Test(priority=81,description="Verified processing order text in Order Confirmation page")
	public void step81_VerifiedProcessingOrderTxt() throws Exception
	{
	orderconfirmationpage.Verify_ProcessingOrder_Txt();
    orderconfirmationpage.VerifyOrderIDInOCP();
    orderconfirmationpage.VerifyContactusLnkInOCP();
    orderconfirmationpage.VerifyFAQSectionInOCP();
	}  
	
	@Test(priority=82, description=" Clicking on My Account Icon ")
	public void step82_ClickMyAccountBtn() throws Exception
	{
	homepage=new HomePage(orderconfirmationpage.driver);
	CustomFun.waitForPageLoaded(homepage.driver);
	homepage.driver.findElement(By.xpath(ObjRepoProp.get().getProperty("HP_MyAccount_Icon"))).click();	
	} 
	
	@Test(priority=83, description=" Clicking on My orders link ")
	public void step83_ClickMyOrdersLink() throws Exception
	{
	 myaccountpage=new MyAccountPage(homepage.driver);
	 myaccountpage.MyOrders_LnkClick();	
	} 
	
	@Test(priority=84, description=" Verify Order Details In Myorders Page ")
	public void step84_VerifyOrderdetailsInOrderspage() throws Exception
	{
	myaccountpage.VerifyOrderStatus(OrderID);
	OrderStatus=MyAccountPage.OrderStatusFromFO;
	myaccountpage.VerifyOrderPriceInOrderspage(OrderID);
	OrderPrice=MyAccountPage.PriceVal_OrderPage;
	MyAccountPage.PriceVal_OrderPage= myaccountpage.driver.findElement(By.xpath("//*[contains(text(),'"+OrderID+"')]/..//p[contains(@class, 'price')]")).getText().replaceAll(",","\\.").replaceAll("[^0-9.]", ""); 
	myaccountpage.VerifyOrderItemInOrderspage(OrderID);
	myaccountpage.VerifyOrderDateInOrderspage(OrderID);
	if(locale.get().contains("FR_FR"))
	{
	Assert.assertEquals(MyAccountPage.OrderStatusFromFO,TextProp.get().getProperty("OrderBeingValidatedtxt_FR"));
	}
	else
	{
	Assert.assertEquals(MyAccountPage.OrderStatusFromFO,TextProp.get().getProperty("OrderPendingSecurityChecktxt_UK"));	
	}
	}  
	
    @Test(description="Navigated Back to Magento & Click on Sales Icon", priority=86)
   	public void step86_NavigatedBackToBOAndClickOnSalesIcon() throws Exception
   	{
        CustomFun.SwitchToSpecificTab(backofficepage.driver, "2");
   		backofficepage.SalesIconClick();
   	}
   	
   	@Test(description="Click on Orders text from Sales Icon", priority=87)
   	public void step87_ClickOrderstxtFromSalesIcon() throws Exception
   	{
   		backofficepage.OrderstxtFromSalesIconClick();
   	}
   	
   	@Test(description="Enter order Id in serach bar and click on search ", priority=88)
   	public void step88_EnterOrderIDInBOSearchFld() throws Exception
   	{
   		backofficepage.EnterOrderId(OrderID);
   		backofficepage.SearchIconClick();	
   	}   
   	
   	@Test(description="Verified Order Status in Orders page", priority=89)
   	public void step89_VerifiedOrderStatusInOrdersPage() throws Exception
   	{
   		backofficepage.ClearTheFilterInBO(OrderID);
		backofficepage.VerifyOrderStatusInBO_OrdersPage(OrderID);
   		OrderStatus=BackOfficePage.OrderStatus;
   		for(int i=0;i<=1;i++)
		{
		Thread.sleep(30000);
		backofficepage.ClearTheFilterInBO(OrderID);
		backofficepage.VerifyOrderStatusInBO_OrdersPage(OrderID);	
		OrderStatus=BackOfficePage.OrderStatus;
		if(OrderStatus.contains(TextProp.get().getProperty("OnHoldtxt")))
		{
		OrderStatus=BackOfficePage.OrderStatus;
		Assert.assertEquals(TextProp.get().getProperty("OnHoldtxt"), OrderStatus);
		log.info("Successfully Verified Order Status in Magento After Placing the order in FO: " + OrderStatus);
		Reporter.log("<p>Successfully Verified Order Status in Magento After Placing the order in FO: " + OrderStatus);
		break;
		}
		}
   	} 
   	
   	@Test(description="Enter order Id in serach bar and click on search ", priority=90)
	public void step90_EnterOrderIDInBOSearchFld() throws Exception
	{
		backofficepage.Click_viewBtnForPdt();	
		CustomFun.waitForPageLoaded(backofficepage.driver);
		backofficepage.Verify_OderDetails_BO(OrderID);
		backofficepage.Click_BackBtnForBOPrct();
	}  
	
    @Test(description="Open New Tab and Navigated to Adyen", priority=91)
    public void step91_OpenNewTabAndNavigatedtoAdyen() throws Exception
    {
         adyenpage=new AdyenPage(homepage.driver);
         CustomFun.OpenNewTabAndSwitchToNewTab(adyenpage.driver, "3");
         adyenpage.driver.navigate().to(CustomFun.getAdyenInfoDSDetails().get().getAdyenUrl());
    }
    
    @Test(description="Logged into Adyen with valid crendentials", priority=92)
    public void step92_LoggedIntoAdyen() throws Exception
    {
    adyenpage=new AdyenPage(backofficepage.driver);
    adyenpage.AdyenLogIn(CustomFun.getAdyenInfoDSDetails().get().getAdyenUsername(),CustomFun.getAdyenInfoDSDetails().get().getAdyenAccount(),CustomFun.getAdyenInfoDSDetails().get().getAdyenPassword());
    }
    
    @Test(description="Click on Risk option from Case management", priority=93)
    public void step93_ClickCaseMgmtOPtionINAdyen() throws Exception
    {
    	adyenpage.Click_AdyenRiskTab();
        adyenpage.Click_AdyenCaseMgmtTab();
    }
    
    @Test(description="verify the order id in Adyen and select the checkbox", priority=94)
    public void step94_ClickOrderIDCheckbox() throws Exception
    {
          adyenpage.Verify_OrderIDandClickCheckbox(OrderID);  
    }  

    @Test(description="Click on accept and ok in Adyen", priority=95)
    public void step95_ClickOnAcceptBtn() throws Exception
    {
          adyenpage.Click_AdyenOrderAcceptBtn();
    } 
    
    @Test(description="Navigated Into Magento and Verified Order Status in Orders page", priority=96)
    public void step96_NavigatedIntoMangetoAndVerifiedOrderStatusInOrdersPage() throws Exception
    {
        CustomFun.SwitchToSpecificTab(backofficepage.driver, "2");
        CustomFun.refreshPage(backofficepage.driver);
        CustomFun.waitForPageLoaded(backofficepage.driver);
        backofficepage.ClearTheFilterInBO(OrderID);
		backofficepage.VerifyOrderStatusInBO_OrdersPage(OrderID);
   
        for(int i=0;i<=12;i++)
          {
            Thread.sleep(50000);
            backofficepage.driver.findElement(By.xpath("//button[text()='Clear all']")).click();
    		backofficepage.EnterOrderId(OrderID);
    		backofficepage.SearchIconClick();
    		backofficepage.VerifyOrderStatusInBO_OrdersPage(OrderID);
            OrderStatus=BackOfficePage.OrderStatus;
            if(OrderStatus.contains(TextProp.get().getProperty("SenttoLogistictxt")))
            {
                 Assert.assertEquals(TextProp.get().getProperty("SenttoLogistictxt"), OrderStatus);
                 log.info("Successfully Verified Order Status in Magento After accepted order in adyen: " + OrderStatus);
                 Reporter.log("<p>Successfully Verified Order Status in Magento After accepted order in adyen: " + OrderStatus);
                 break;
            }
          }  
    }  
  
    
    @Test(description="Navigated Into BO and Verified Seleable Stock Quantity Decremented By 1", priority=97)
    public void step97_VerifiedSaleableStockQntyDecBy1InBOAferPlacingTheOrder() throws Exception
    {
          CustomFun.refreshPage(backofficepage.driver);
          CustomFun.waitForPageLoaded(backofficepage.driver);
          backofficepage.CatalogIconClick();
          backofficepage.ProductstxtFromCatalogIconClick();
          CustomFun.waitForPageLoaded(backofficepage.driver);
          backofficepage.SearchForProductSeleableStockInBO(BarCodeSKU);
          backofficepage.VerifySaleableStockQntyDecBy1InBOAferPlacingTheOrder(BarCodeSKU);
    }
    
    @Test(description="Navigated Into WMS and Verified Seleable Stock Quantity Decremented By 1", priority=98)
    public void step98_VerifySaleableStockDecBy1InWMSAferPlacingTheOrder() throws Exception
    {
          CustomFun.SwitchToSpecificTab(wmspage.driver, "1");
          CustomFun.refreshPage(wmspage.driver);
          CustomFun.waitForPageLoaded(wmspage.driver);
          wmspage.VerifySaleableStockDecBy1InWMSAferPlacingTheOrder();
          wmspage.VerifyInitialSaleableStock();
    }


	@Test(description="Comparing the Seleable stock in the WMS and the BO Magento", priority=99)
    public void step99_ComparedSeleableStockInWMSAndBOBothAreSame() throws Exception
    {
    CustomFun.SwitchToSpecificTab(backofficepage.driver, "2");
    backofficepage.CatalogIconClick();
    backofficepage.ProductstxtFromCatalogIconClick();
    CustomFun.waitForPageLoaded(backofficepage.driver);
    backofficepage.SearchForProductSeleableStockInBO(BarCodeSKU);
    backofficepage.VerifyInitialSaleableStockInBO(BarCodeSKU);
    //Assert.assertEquals(BackOfficePage.InitialSaleableStock_BO, WMSPage.InitialSaleableStock_WMS, "Stock in the WMS and the Bo Magento both are same");
    }
	

    @Test(description="Navigated into WMS & Picking Order Process", priority=100)
    public void step100_NavigatedBackIntoWMSANDPickingOrderProcess() throws Exception
    {
          CustomFun.SwitchToSpecificTab(backofficepage.driver, "1");
          wmspage.PickingOrderProcess(OrderID);
    }
    
    @Test(description="Verified Picking order for # XXXXX", priority=101)
    public void step101_VerifiedPickingOrderSuccessMsg() throws Exception
    {
          wmspage.VerifyPickingOrderSuccessMsg();
    }
    
    @Test(description="Verified Gift Msg from Picking in Wms", priority=102)
    public void step102_VerifiedGiftMsg_INPicking() throws Exception
    {
         // wmspage.WMS_VerifyGiftMsg_INPicking();
    }
    
    @Test(description=" Get BarCode From Picking Process", priority=103)
    public void step103_NavigatedIntoWMSAndGetBarcodeFromPickingProcess() throws Exception
    {
          wmspage.getBarCodeFromPickingProcess(OrderID);
          BarCodeForScan=WMSPage.BarCodeId;
    }    

    @Test(description="Navigated Into Magento and Verified Order Status in Orders page", priority=104)
    public void step104_NaviagtedIntoMangetoAndVerifiedOrderStatusInOrdersPage() throws Exception
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
    
    @Test(description="Navigated Into FO and Verified Order Status in My Orders page", priority=105)
	public void step105_NaviagtedIntoFOAndVerifiedOrderStatusInMyOrdersPage() throws Exception
	{
		CustomFun.SwitchToSpecificTab(homepage.driver, "0");
		myaccountpage=new MyAccountPage(homepage.driver);
		myaccountpage.driver.findElement(By.xpath(ObjRepoProp.get().getProperty("HP_MyAccount_Icon"))).click();
		Thread.sleep(2000);
		myaccountpage.MyOrders_LnkClick();
		CustomFun.waitForPageLoaded(myaccountpage.driver);
		Thread.sleep(2000);
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
    
   @Test(description="Navigated Into WMS and Click on Packing Button", priority=106)
    public void step106_NavigatedIntoWMSAndClickOnPackingBtn() throws Exception
    {
          CustomFun.SwitchToSpecificTab(wmspage.driver, "1");
          wmspage.Click_WMSPackingBtn();
    }
    
    @Test(description="Entered BarcodeID in Barcode Field And Search For Packing", priority=107)
    public void step107_EnteredBarcodeAndSearchForPacking() throws Exception
    {
          wmspage.EnterBarcodeAndSearchForPacking(BarCodeForScan);
    }
    
    @Test(description="Copy SKUID And Enter in Search Field For Scanning Products In Packing", priority=108)
    public void step108_CopySKUIDAndEnterinSearchFeildForScanningProductsInPacking() throws Exception
    {
           wmspage.CopySKUIDAndEnterinSearchFldForScanningProductsInPacking();
    }
    
    @Test(description="Click on Complete Packing button", priority=109)
    public void step109_ClickOnCompletePackingBtn() throws Exception
    {
          wmspage.Click_CompletePackingBtn();
    }
    
    @Test(description="Enter quantity in front of any row", priority=110)
    public void step110_EnteredQuantityInAnyRow() throws Exception
    {
          wmspage.EnterQuantity_Packing("1");
    }
    
    @Test(description="Click on Validate button", priority=111)
    public void step111_ClickOnValidateBtn() throws Exception
    {
          wmspage.ClickValidate_Packing();
    }
    
    @Test(description="Click on Home Popup button", priority=112)
    public void step112_ClickOnHomePopupBtn() throws Exception
    {
          wmspage.ClickHomeBtn_PopUp();
    }   
    
    @Test(description="Navigated Into Magento and Verified Order Status in Orders page", priority=113)
    public void step113_NavigatedIntoMangetoAndVerifiedOrderStatusInOrdersPage() throws Exception
    {
          CustomFun.SwitchToSpecificTab(backofficepage.driver, "2");
          CustomFun.refreshPage(backofficepage.driver);
          CustomFun.waitForPageLoaded(backofficepage.driver);
          backofficepage.ClearTheFilterInBO(OrderID);
          CustomFun.refreshPage(backofficepage.driver);
          CustomFun.waitForPageLoaded(backofficepage.driver);
  		  backofficepage.VerifyOrderStatusInBO_OrdersPage(OrderID);
          OrderStatus=BackOfficePage.OrderStatus;
          Assert.assertEquals(TextProp.get().getProperty("Invoicedtxt"), OrderStatus);
          log.info("Successfully Verified Order Status in Magento After Packing Process is completed: " + OrderStatus);
          Reporter.log("<p>Successfully Verified Order Status in Magento After Packing Process is completed: " + OrderStatus);
    }
    
    @Test(description="Navigated Into FO and Verified Order Status in My Orders page", priority=114)
	public void step114_NaviagtedIntoFOAndVerifiedOrderStatusInMyOrdersPage() throws Exception
	{
    	CustomFun.SwitchToSpecificTab(homepage.driver, "0");
		myaccountpage.MyOrders_LnkClick();
		CustomFun.waitForPageLoaded(myaccountpage.driver);
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
    
    @Test(description="Navigated Into WMS and Processed with Shipping Process", priority=115)
    public void step115_NavigatedIntoWMSAndProcessedwithShippingProcess() throws Exception
    {
          CustomFun.SwitchToSpecificTab(wmspage.driver, "1");
          wmspage.ShippingOrderProcess(BarCodeForScan);
    }
    
    @Test(description="Navigated Into Magento and Verified Order Status in Orders page", priority=116)
    public void step116_NavigatedIntoMangetoAndVerifiedOrderStatusInOrdersPage() throws Exception
    {
          CustomFun.SwitchToSpecificTab(backofficepage.driver, "2");
          for(int i=0;i<=2;i++)
          {
        	Thread.sleep(30000);
        	backofficepage.ClearTheFilterInBO(OrderID);
    		backofficepage.VerifyOrderStatusInBO_OrdersPage(OrderID);
            OrderStatus=BackOfficePage.OrderStatus;
            if(OrderStatus.contains(TextProp.get().getProperty("Shippedtxt")))
            break;
          }
          backofficepage.ClearTheFilterInBO(OrderID);
  		  backofficepage.VerifyOrderStatusInBO_OrdersPage(OrderID);
          OrderStatus=BackOfficePage.OrderStatus;
          Assert.assertEquals(TextProp.get().getProperty("Shippedtxt"), OrderStatus);
          log.info("Successfully Verified Order Status in Magento After Shipping Process is completed: " + OrderStatus);
          Reporter.log("<p>Successfully Verified Order Status in Magento After Shipping Process is completed: " + OrderStatus);
    }   
    
    @Test(description="Navigated Into FO and Verified Order Status in My Orders page", priority=117)
	public void step117_NaviagtedIntoFOAndVerifiedOrderStatusInMyOrdersPage() throws Exception
	{
		CustomFun.SwitchToSpecificTab(homepage.driver, "0");
		myaccountpage.MyOrders_LnkClick();
		CustomFun.waitForPageLoaded(myaccountpage.driver);
		myaccountpage.VerifyOrderStatus(OrderID);
		if(locale.get().contains("FR_FR") | locale.get().contains("CH_FR"))
		{
		Assert.assertEquals(MyAccountPage.OrderStatusFromFO,TextProp.get().getProperty("OrderShippedtxt_FR"));
		}
		else
		{
		Assert.assertEquals(MyAccountPage.OrderStatusFromFO,TextProp.get().getProperty("OrderShippedtxt_UK"));	
		}
	    log.info("Successfully Verified Order Status in My orders page: " + MyAccountPage.OrderStatusFromFO);
	    Reporter.log("<p>Successfully Verified Order Status in My orders page: " + MyAccountPage.OrderStatusFromFO);
	 } 
    
    @Test(description="Navigated back to Adyen and click on payment tab ", priority=118)
    public void step118_NavigatedIntoAdyenAndClickOnPaymentTab() throws Exception
    {
        CustomFun.SwitchToSpecificTab(adyenpage.driver, "3");
      	CustomFun.refreshPage(adyenpage.driver);
    	CustomFun.waitForPageLoaded(adyenpage.driver);
    	if(!GUIFunctions.isElementPresent((By.xpath("//input[@name='password']")), adyenpage.driver))
		{	
		   adyenpage.Click_AdyenTransactionTab();
		   adyenpage.Click_AdyenTransactionPaymentTab();
		}
		else
		{
			adyenpage.driver.findElement(By.xpath("//input[@name='password']")).sendKeys(CustomFun.getAdyenInfoDSDetails().get().getAdyenPassword());
	    	adyenpage.driver.findElement(By.xpath("//button[@type='submit']")).click();
			/*
			 * By CLInterSABtn=By.
			 * xpath("//button[contains(@class,'app-sidebar-account-trigger adl-button adl-button')]"
			 * ); CustomFun.waitForPageLoaded(adyenpage.driver);
			 * GUIFunctions.JavaScriptClick(adyenpage.driver,
			 * adyenpage.driver.findElement(CLInterSABtn)
			 * ,"Click on CLInternationalSA button"); By
			 * CLInterSALink=By.xpath("//a[@title='CLInternationalSA']");
			 * GUIFunctions.JavaScriptClick(adyenpage.driver,
			 * adyenpage.driver.findElement(CLInterSALink),"Click on CLInternationalSA link"
			 * ); CustomFun.waitForPageLoaded(adyenpage.driver);
			 */
	    	adyenpage.Click_AdyenTransactionTab();
	    	adyenpage.Click_AdyenTransactionPaymentTab();
		}
    }
    

    @Test(description="Enter order Id in serach bar", priority=119)
    public void step119_EnterOrderIDinPaymentTab_adyen() throws Exception
    {
          adyenpage.Enter_AdyenPaymentSearchField(OrderID);
    }
    
    @Test(description="Verify order total amount in Adyen ", priority=120)
    public void step120_VerifyOrderTotalAmtIN_adyen() throws Exception
    {
          adyenpage.Verify_AdyenOrderAmount(OrderID, OrderPrice);
    }  

    @Test(description="Comparing the Seleable stock in the WMS and the BO Magento after shipping the order", priority=121)
    public void step121_ComparedSeleableStockInWMSAndBOBothAreSameAfterShippingTheOrder() throws Exception
    {
          //Verify Seleable Stock in WMS after Shipping the order
    CustomFun.SwitchToSpecificTab(wmspage.driver, "1");
    wmspage.WMS_Datalistmenu();
    wmspage.WMS_Datalist_Productclick();
    wmspage.ClickOnDetailsButton(Size);
    wmspage.VerifyInitialSaleableStock();
    wmspage.VerifyInitialReservedStock();
    //Verify Seleable Stock in BO after Shipping the order
    CustomFun.SwitchToSpecificTab(backofficepage.driver, "2");
    backofficepage.CatalogIconClick();
    backofficepage.ProductstxtFromCatalogIconClick();
    CustomFun.waitForPageLoaded(backofficepage.driver);
    backofficepage.SearchForProductSeleableStockInBO(BarCodeSKU);
    backofficepage.VerifyInitialSaleableStockInBO(BarCodeSKU);
    }
    
   
    @Test(description="Navigated back to Fo and click on RMA Product Return Btn", priority=122)
    public void step122_ClickOnRMAProductReturnBtn() throws Exception
    {
          CustomFun.SwitchToSpecificTab(homepage.driver, "0");
          CustomFun.refreshPage(homepage.driver);
          CustomFun.waitForPageLoaded(homepage.driver);
          myaccountpage.ClickOnMyorders_RMAProductReturnBtn(OrderID);
    }
    
    @Test(description="Creating RMA from FO", priority=123)
    public void step123_CreatingRMAFromFO() throws Exception
    {    
    	  if(environmentName.contains("StagingEnv1") | environmentName.contains("HomoEnv1") | environmentName.contains("IntegrationEnv"))
		  {
    		  myaccountpage.CreateRMAReturnsinFOForStagingEU1();
          }
    	  else
    	  {
    		  myaccountpage.ClickOnMyorders_RMAProductReturnChkbox();
              myaccountpage.ClickOnMyorders_RMAProductReturnReasonDrpdown();
              myaccountpage.ClickMyorders_RMAProductReturnReasonSubmit_Btn();
              WebElement ContactAddressField=myaccountpage.driver.findElement(By.xpath(ObjRepoProp.get().getProperty("MyOrders_RMAContactEmailAddressField_xpath")));
              ContactAddressField.sendKeys(CustomFun.getUserInfoDSDetails().get().getEmailDomain());
              myaccountpage.driver.findElement(By.xpath(ObjRepoProp.get().getProperty("Myorders_RMAProductReturnReason_submitBtn2"))).click();
              myaccountpage.ClickMyorders_RMAProductReturnReasonDateDrpdown();
              myaccountpage.ClickMyorders_RMAProductReturnValidateBtn(); 
    	  }
    }
    
    @Test(description="Saved RMA from FO  ", priority=124)
    public void step124_SavedRMAFromFO() throws Exception
    {
        RMA_ID_FO=  myaccountpage.SaveANdStore_RMAProductReturnID_FO();
        System.out.println("Successfully Saved RMA ID for further execution - "+RMA_ID_FO);
    } 

    @Test(description="Navigated back to BO and click on Returns from sales tab", priority=125)
    public void step125_NavigatedIntoMangetoAndClickOnReturnsFromSales() throws Exception
    {
    CustomFun.SwitchToSpecificTab(backofficepage.driver, "2");
    CustomFun.waitForPageLoaded(backofficepage.driver);
    backofficepage.SalesIconClick();
    backofficepage.ReturnstxtFromSalesIconClick();
    }

    @Test(description="Click on filters and enter RMA ID", priority=126)
    public void step126_ClickONFiltersAndEnterRMAID() throws Exception
    {
          Thread.sleep(5000);
          if(!backofficepage.driver.findElement(By.xpath("//button[text()='Clear all']")).isDisplayed())
          {
        	  backofficepage.ClearTheFilterInBOForReturnsOrder(OrderID);
          }
          else
          {
        	  backofficepage.ClearTheFilterInBOForReturnsOrder(OrderID);
          }
          //Fetch RMAID From BO
          RMAID=backofficepage.driver.findElement(By.xpath("//div[contains(text(),'"+OrderID+"')]/../preceding-sibling::td//div")).getText();
          Thread.sleep(2000);
          backofficepage.driver.findElement(By.xpath("//button[text()='Clear all']")).click();
          Thread.sleep(5000);
          backofficepage.SearchForRMAOrder(OrderID);
          backofficepage.VerifyReturnsStatusInBO_ReturnsPage(OrderID);
          
          for(int i=0;i<=5;i++)
          {
        	 Thread.sleep(30000);
        	 backofficepage.ClearTheFilterInBOForReturnsOrder(OrderID);
             backofficepage.VerifyReturnsStatusInBO_ReturnsPage(OrderID);
  			 OrderStatus=BackOfficePage.RMAIDStatus;
  		    if(OrderStatus.contains(TextProp.get().getProperty("Authorizedtxt")))
  		    {
  	          Assert.assertEquals(TextProp.get().getProperty("Authorizedtxt"), OrderStatus);
  	          OrderStatus=BackOfficePage.RMAIDStatus;
  	          log.info("Successfully Verified Order Status in Returns Page After Returns submit is completed: " + OrderStatus);
  			  Reporter.log("<p>Successfully Verified Order Status in Returns Page After Returns submit is completed: " + OrderStatus);
  			  break;
  		    }
          }
    }

    @Test(description="Click on Sales Icon", priority=128)
    public void step128_ClickOnSalesIcon() throws Exception
    {
    backofficepage.SalesIconClick();
    }

    @Test(description="Click on Orders text from Sales Icon", priority=129)
    public void step129_ClickOrderstxtFromSalesIcon() throws Exception
    {
    backofficepage.OrderstxtFromSalesIconClick();
    }

    @Test(description="Verified Order Status in Orders page", priority=130)
    public void step130_VerifiedOrderStatusInOrdersPage() throws Exception
    { 
    CustomFun.waitForPageLoaded(backofficepage.driver);
    backofficepage.ClearTheFilterInBO(OrderID);
	backofficepage.VerifyOrderStatusInBO_OrdersPage(OrderID);
    OrderStatus=BackOfficePage.OrderStatus;
    Assert.assertEquals(TextProp.get().getProperty("ProcessingRMAtxt"), OrderStatus);
    log.info("Successfully Verified Order Status in Orders Page After Returns submit is completed: " + OrderStatus);
    Reporter.log("<p>Successfully Verified Order Status in Orders Page After Returns submit is completed: " + OrderStatus);
    }

    
    @Test(description="Navigated Into FO and Verified Order Status in My Orders page", priority=131)
   	public void step131_NaviagtedIntoFOAndVerifiedOrderStatusInMyOrdersPage() throws Exception
   	{
   		CustomFun.SwitchToSpecificTab(homepage.driver, "0");
   		homepage.clickMyaccountBtn();
   		CustomFun.waitForPageLoaded(homepage.driver);
   		myaccountpage=new MyAccountPage(homepage.driver);
   		homepage.clickMyaccountBtn();
		myaccountpage.MyOrders_LnkClick();
   		CustomFun.waitForPageLoaded(homepage.driver);
   		myaccountpage.VerifyOrderStatus(OrderID);
   		if(locale.get().contains("FR_FR") | locale.get().contains("CH_FR"))
		{
		Assert.assertEquals(MyAccountPage.OrderStatusFromFO,TextProp.get().getProperty("Returntxt_FR"));
		}
		else
		{
		Assert.assertEquals(MyAccountPage.OrderStatusFromFO,TextProp.get().getProperty("Pendingreturntxt_UK"));	
		}
   	 }  
    
    @Test(description="Navigated Into WMS and Validate the RMA reception in the WMS", priority=133)
    public void step133_ClickOnRMALink() throws Exception
    {
    CustomFun.SwitchToSpecificTab(wmspage.driver, "1");
    CustomFun.waitForPageLoaded(wmspage.driver);
    wmspage.Click_RMALnk();
    }

    @Test(description="Enter RMA ID in RMA Field, Click on Submit Filter button & Reception button in WMS", priority=134)
    public void step134_EnterRMAID_SearchForOrderDetails_ClickOnReceptionButton() throws Exception
    {
    	for (int i = 0; i <= 6; i++)
		{
			Thread.sleep(60000);
			CustomFun.refreshPage(wmspage.driver);
			Thread.sleep(5000);
			String ExpectedRMAID=wmspage.driver.findElement(By.xpath(ObjRepoProp.get().getProperty("OrderIDtxt_xpath"))).getText();
			if(ExpectedRMAID.contains(RMAID))
			{
			break;
			}
		}
		wmspage.EnterRMAID_SearchForOrderDetails_ClickOnReceptionButton(RMAID);
    }

    @Test(description="Execute RMA Process in WMS", priority=135)
    public void step135_ExecuteRMAProcessinWMS() throws Exception
    {
    wmspage.ExecuteRMAProcess();
    } 
    
    @Test(description="Navigated Into Magento and Click on Sales Icon", priority=137)
    public void step137_NavigatedIntoMangetoAndVerifiedOrderStatusInOrdersPage() throws Exception
    {
    CustomFun.SwitchToSpecificTab(backofficepage.driver, "2");
    backofficepage.SalesIconClick();
    }

    @Test(description="Click on Returns link from Sales Tab", priority=138)
    public void step138_ReturnstxtFromSalesIconClick() throws Exception
    {
    backofficepage.ReturnstxtFromSalesIconClick();
    }

    @Test(description="Verified Order Status in Returns page", priority=139)
    public void step139_VerifiedOrderStatusInReturnsPage() throws Exception
    {
    for(int i=0;i<=5;i++)
    {
  	     Thread.sleep(30000);
  	     backofficepage.ClearTheFilterInBOForReturnsOrder(OrderID);
         backofficepage.VerifyReturnsStatusInBO_ReturnsPage(OrderID);
		 OrderStatus=BackOfficePage.RMAIDStatus;
	    if(OrderStatus.contains(TextProp.get().getProperty("ReturnReceivedtxt")))
	    {
	        OrderStatus=BackOfficePage.RMAIDStatus;
	        Assert.assertEquals(TextProp.get().getProperty("ReturnReceivedtxt"), OrderStatus);
	        log.info("Successfully Verified Order Status in Returns Page After RMA Reception Process is done : " + OrderStatus);
	        Reporter.log("<p>Successfully Verified Order Status in Returns Page After RMA Reception Process is done : " + OrderStatus);
		  break;
	    }
    }
    }

    @Test(description="Click on View option under order grid", priority=140)
    public void step140_ClickonViewOptioninOrderGrid() throws Exception
    {
    backofficepage.ClickOnOrderGrid(OrderID);     
    }

    @Test(description="Click on Return Items Tab", priority=141)
    public void step141_ClickOnReturnItems() throws Exception
    {
    backofficepage.ReturnsItemsClick();
    }

    @Test(description="Entered Approved value in Approved Field under RMA Items Requested for Grid", priority=142)
    public void step142_EnterValueInApprovedField() throws Exception
    {
    CustomFun.waitForPageLoaded(backofficepage.driver);
    backofficepage.EnterValueInApprovedField("1");
    }

    @Test(description="Select Approved option from Status Dropdown", priority=143)
    public void step143_SelectApprovedOptionFromStatusDropdown() throws Exception
    {
    backofficepage.SelectApprovedOptionFromStatusDropdown();
    }

    @Test(description="Click on Save Button", priority=144)
    public void step144_ClickOnSaveButton() throws Exception
    {
    backofficepage.ClickOnSaveButton();
    }

    @Test(description="Verify Success Msg For RMA Request after submit returns", priority=145)
    public void step145_VerifySuccessMsgForSavedRMARequest() throws Exception
    {
    backofficepage.VerifySuccessMsgForSavedRMARequest();
    }

    @Test(description="Click on Sales Icon", priority=146)
    public void step146_ClickOnSalesIcon() throws Exception
    {
    backofficepage.SalesIconClick();
    }

    @Test(description="Click on Orders text from Sales Icon", priority=147)
    public void step147_ClickOrderstxtFromSalesIcon() throws Exception
    {
    backofficepage.OrderstxtFromSalesIconClick();
    }

    @Test(description="Verified Order Status in Orders page", priority=148)
    public void step148_VerifiedOrderStatusInOrdersPage() throws Exception
    {    
    CustomFun.waitForPageLoaded(backofficepage.driver);
    backofficepage.ClearTheFilterInBO(OrderID);
	backofficepage.VerifyOrderStatusInBO_OrdersPage(OrderID);
    OrderStatus=BackOfficePage.OrderStatus;
    Assert.assertEquals(TextProp.get().getProperty("WaitingForCreditMemotxt"), OrderStatus);
    log.info("Successfully Verified Order Status in Orders Page After RMA Approved : " + OrderStatus);
    Reporter.log("<p>Successfully Verified Order Status in Orders Page After RMA Approved: " + OrderStatus);
/*    backofficepage.Click_viewBtnForPdt();	
	CustomFun.waitForPageLoaded(backofficepage.driver);
	backofficepage.driver.findElement(By.xpath("//span[contains(text(),'Comments History')]")).click();
	Thread.sleep(2000);
	ShipmentID=backofficepage.driver.findElement(By.xpath("//span[contains(text(),'Shipment #')]")).getText().replaceAll("[^0-9.]", "");  */
    }
    
    @Test(description="Click on Sales Icon", priority=149)
    public void step149_ClickOnSalesIcon() throws Exception
    {
    backofficepage.SalesIconClick();
    }

    @Test(description="Click on Returns link from Sales Tab", priority=150)
    public void step150_ReturnstxtFromSalesIconClick() throws Exception
    {
    backofficepage.ReturnstxtFromSalesIconClick();
    }

    @Test(description="Verified Order Status in Returns page", priority=151)
    public void step151_VerifiedOrderStatusInReturnsPage() throws Exception
    {
          CustomFun.waitForPageLoaded(backofficepage.driver);
          backofficepage.ClearTheFilterInBOForReturnsOrder(OrderID);
          backofficepage.VerifyReturnsStatusInBO_ReturnsPage(OrderID);
          OrderStatus=BackOfficePage.RMAIDStatus;
          Assert.assertEquals(TextProp.get().getProperty("Approvedtxt"), OrderStatus);
          log.info("Successfully Verified Order Status in Returns Page After RMA Approved : " + OrderStatus);
          Reporter.log("<p>Successfully Verified Order Status in Returns Page After RMA Approved : " + OrderStatus);
    }
    
    @Test(description="Click on View option under order grid", priority=152)
    public void step152_ClickonViewOptioninOrderGrid() throws Exception
    {
    backofficepage.ClickOnOrderGrid(OrderID);
    CustomFun.waitForPageLoaded(backofficepage.driver);
    }

    @Test(description="Click On Refund/Exchange Button in Order Details Page", priority=153)
    public void step153_ClickOnRefundOrExchangeButton() throws Exception
    {
    backofficepage.ClickOnRefundOrExchangeButton();
    String[] NewMemoID=backofficepage.driver.findElement(By.xpath("//h1")).getText().split(" ");
    RefundMemoID=NewMemoID[3];
    }
    
    @Test(description="clear the Qnt to refund field and click on update quantity ", priority=154)
    public void step154_ClearQuntAndClickOnUpdateQTY_CreditMemo() throws Exception
    {
    backofficepage.ClearQuntAndClickOnUpdateQTY_CreditMemo();
    }

    @Test(description="enter shipping fee in shipping fee field and click on Update total", priority=155)
    public void step155_EnterShippingFeeAndClickOnUpdate_CreditMemo() throws Exception
    {
    backofficepage.EnterShippingFeeAndClickOnUpdate_CreditMemo();
    }

    @Test(description="Scroll down till Refund button in New Memo Page & Click on Refund Button", priority=156)
    public void step156_ClickOnRefundButtonInNewMemoPage() throws Exception
    {
    backofficepage.ClickOnRefundButtonInNewMemoPage();
    }

    @Test(description="Verify Success Msg For Create Credit Memo after Refund created", priority=157)
    public void step157_VerifySuccessMsgForCreateCreditMemo() throws Exception
    {  
    CustomFun.waitForPageLoaded(backofficepage.driver);
    backofficepage.VerifySuccessMsgForCreateCreditMemo();
    }

    @Test(description="Click on Sales Icon", priority=158)
    public void step158_ClickOnSalesIcon() throws Exception
    {
    backofficepage.SalesIconClick();
    }

    @Test(description="Click on Orders text from Sales Icon", priority=159)
    public void step159_ClickOrderstxtFromSalesIcon() throws Exception
    {
    backofficepage.OrderstxtFromSalesIconClick();
    }

    @Test(description="Verified Order Status in Orders page", priority=160)
    public void step160_VerifiedOrderStatusInOrdersPage() throws Exception
    {
    	for (int i = 0; i <= 3; i++)
		{
			Thread.sleep(30000);
			backofficepage.ClearTheFilterInBO(OrderID);
			backofficepage.VerifyOrderStatusInBO_OrdersPage(OrderID);
			OrderStatus = BackOfficePage.OrderStatus;
			if(OrderStatus.contains(TextProp.get().getProperty("CreditOrRefundedtxt")))
			{
			Assert.assertEquals(TextProp.get().getProperty("CreditOrRefundedtxt"), OrderStatus);
			log.info("Successfully Verified Order Status in Orders Page After Refund Created: " + OrderStatus);
			Reporter.log("<p>Successfully Verified Order Status in Orders Page After Refund Created: " + OrderStatus);
			break;
			}
		}
    }

    @Test(description="Click on Sales Icon", priority=161)
    public void step161_ClickOnSalesIcon() throws Exception
    {
    backofficepage.SalesIconClick();
    }

    @Test(description="Click on Returns link from Sales Tab", priority=162)
    public void step162_ReturnstxtFromSalesIconClick() throws Exception
    {
    backofficepage.ReturnstxtFromSalesIconClick();
    }

    @Test(description="Verified Order Status in Returns page", priority=163)
    public void step163_VerifiedOrderStatusInReturnsPage() throws Exception
    {
    CustomFun.waitForPageLoaded(backofficepage.driver);
    backofficepage.ClearTheFilterInBOForReturnsOrder(OrderID);
    backofficepage.VerifyReturnsStatusInBO_ReturnsPage(OrderID);
    OrderStatus=BackOfficePage.RMAIDStatus;
    Assert.assertEquals(TextProp.get().getProperty("ProcessedandClosedtxt"), OrderStatus);
    log.info("Successfully Verified Order Status in Returns Page After Refund Created : " + OrderStatus);
    Reporter.log("<p>Successfully Verified Order Status in Returns Page After Refund Created : " + OrderStatus);
    }
    
    @Test(description="Swich to FO Tab & Click on My Account Icon", priority=164)
    public void step164_SwitchToFOTabAndClickOnMyAccountIcon() throws Exception
    {
    CustomFun.SwitchToSpecificTab(homepage.driver, "0");
    homepage.clickMyaccountBtn();
    }

    @Test(description="Click on My Orders Link", priority=165)
    public void step165_ClickOnMyOrdersLink() throws Exception
    {
    myaccountpage.MyOrders_LnkClick();
    CustomFun.waitForPageLoaded(myaccountpage.driver);
    }

    @Test(description="Verified Order Status in My Orders page", priority=166)
    public void step166_VerifiedOrderStatusInMyOrdersPage() throws Exception
    {
	if(locale.get().contains("FR_FR") | locale.get().contains("CH_FR"))
	{
		for (int i = 0; i <= 3; i++)
		{
		Thread.sleep(30000);
	    CustomFun.refreshPage(homepage.driver);
		Thread.sleep(10000);
	    myaccountpage.VerifyOrderStatus(OrderID);
	    if(MyAccountPage.OrderStatusFromFO.contains(TextProp.get().getProperty("Refundedtxt_FR")))
	    {
	    Assert.assertEquals(MyAccountPage.OrderStatusFromFO,TextProp.get().getProperty("Refundedtxt_FR"));
	    break;
	    }
		}
	}
	else
	{
		for (int i = 0; i <= 3; i++)
		{
		Thread.sleep(30000);
	    CustomFun.refreshPage(homepage.driver);
		Thread.sleep(10000);
	    myaccountpage.VerifyOrderStatus(OrderID);
	    if(MyAccountPage.OrderStatusFromFO.contains(TextProp.get().getProperty("Refundedtxt_UK")))
	    {
        	Assert.assertEquals(MyAccountPage.OrderStatusFromFO,TextProp.get().getProperty("Refundedtxt_UK"));	
	    }
	    }
	}
  } 

    @Test(description="Navigated back to Adyen and click on payment tab ", priority=168)
    public void step168_NavigatedIntoAdyenAndClickOnPaymentTab() throws Exception
    {
    	CustomFun.SwitchToSpecificTab(adyenpage.driver, "3");
    	CustomFun.refreshPage(adyenpage.driver);
    	CustomFun.waitForPageLoaded(adyenpage.driver);
    if(!adyenpage.driver.findElement(By.xpath("//input[@name='password']")).isDisplayed())
    {
    	adyenpage.Click_AdyenTransactionTab();
    	adyenpage.Click_AdyenTransactionPaymentTab();
     }
        else
       {
    	adyenpage.driver.findElement(By.xpath("//input[@name='password']")).sendKeys(CustomFun.getAdyenInfoDSDetails().get().getAdyenPassword());
    	adyenpage.driver.findElement(By.xpath("//button[@type='submit']")).click();
		/*
		 * By CLInterSABtn=By.
		 * xpath("//button[contains(@class,'app-sidebar-account-trigger adl-button adl-button')]"
		 * ); CustomFun.waitForPageLoaded(adyenpage.driver);
		 * GUIFunctions.JavaScriptClick(adyenpage.driver,
		 * adyenpage.driver.findElement(CLInterSABtn)
		 * ,"Click on CLInternationalSA button"); By
		 * CLInterSALink=By.xpath("//a[@title='CLInternationalSA']");
		 * GUIFunctions.JavaScriptClick(adyenpage.driver,
		 * adyenpage.driver.findElement(CLInterSALink),"Click on CLInternationalSA link"
		 * );
		 */
    	CustomFun.waitForPageLoaded(adyenpage.driver);
    	adyenpage.Click_AdyenTransactionTab();
    	adyenpage.Click_AdyenTransactionPaymentTab();
    	}
    }
    
    @Test(description="Enter order Id in serach bar ", priority=169)
    public void step169_EnterOrderIDinPaymentTab_adyen() throws Exception
    {
    adyenpage.Enter_AdyenPaymentSearchField(OrderID);
    }

    @Test(description="Verify order total amount in Adyen ", priority=170)
    public void step170_VerifyOrderTotalAmtIN_adyen() throws Exception
    {
    adyenpage.Verify_AdyenOrderAmount(OrderID, OrderPrice);
    }

   @Test(description="Verify order status of SentForRefund in Adyen ", priority=171)
    public void step171_VerifyOrderRMAStatusIN_adyen() throws Exception
    {
    	  CustomFun.waitForPageLoaded(backofficepage.driver);
    	  adyenpage.Verify_AdyenOrderIDStatus(OrderID);
    	  OrderStatus=AdyenPage.OrderStatusFromAdyen;
    	  log.info("Successfully Verified Order Status in Adyen Page for sent for refund status: " + OrderStatus);
    	  Reporter.log("<p>Successfully Verified Order Status in Adyen Page  for sent for refund status: " + OrderStatus);
    } 
    
    
    @Test(description="Comparing the Seleable stock in the WMS and the BO Magento after Refund the order", priority=172)
    public void step172_ComparedSeleableStockInWMSAndBOBothAreSameAfterRefundTheOrder() throws Exception
    {
    //Verify Seleable Stock in WMS after Refund the order
    CustomFun.SwitchToSpecificTab(wmspage.driver, "1");
    wmspage.WMS_Datalistmenu();
    wmspage.WMS_Datalist_Productclick();
    wmspage.ClickOnDetailsButton(Size);
    wmspage.VerifySaleableStockIncBy1InWMSAfterRefundTheOrder();
    wmspage.VerifyInitialReservedStock();
    //Verify Seleable Stock in BO after Refund the order
    CustomFun.SwitchToSpecificTab(backofficepage.driver, "2");
    backofficepage.CatalogIconClick();
    backofficepage.ProductstxtFromCatalogIconClick();
    CustomFun.waitForPageLoaded(backofficepage.driver);
    backofficepage.SearchForProductSeleableStockInBO(BarCodeSKU);
    backofficepage.VerifySaleableStockQntyIncBy1InBOAferRefundTheOrder(BarCodeSKU);
    //Assert.assertEquals(BackOfficePage.InitialSaleableStock_BO, WMSPage.InitialSaleableStock_WMS, "Stock in the WMS and the Bo Magento both are same after refund the order");
    }
	
    @Test(description = "Verified Order Confirmation Mail and Subject line of Mail in Customer Gmail Account", priority = 173)
	public void step173_VerifiedOrderConfirmationMailAndSubjectLineInCustomerGmailAccount() throws Exception
    {
    	String EmailID=CustomFun.getUserInfoDSDetails().get().getEmailDomain();
    	String Password=CustomFun.getUserInfoDSDetails().get().getAppPassword();	
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
	    
	    
	     @Test(description="Verify Shipping Confirmation Mail Contents", priority=174)
	     public void step174_VerifyShippingConfirmationMailContents() throws Exception
	     {
	    	    String EmailID=CustomFun.getUserInfoDSDetails().get().getEmailDomain();
	     	    String Password=CustomFun.getUserInfoDSDetails().get().getAppPassword();
				if(locale.get().contains("FR_FR"))
				{
					Emails.verifyEmailSubjectLine(""+EmailID+""+":"+""+Password+"", "Christian Louboutin Europe Online Boutique - Nouveau retour #"+RMAID);
				}
				else
				if(locale.get().contains("UK_EN"))
			    {
					Emails.verifyEmailSubjectLine("" + EmailID + "" + ":" + "" + Password + "", 
							"Christian Louboutin Europe Online Boutique: Shipment # "+"'"+RMAID+"'"+" for Order # "+"'"+OrderID+"'");
				}
				else
				{
					Emails.verifyEmailSubjectLine("" + EmailID + "" + ":" + "" + Password + "", 
							"Christian Louboutin Europe Online Boutique: Shipment # "+"'"+RMAID+"'"+"forOrder # "+"'"+OrderID+"'");
				}
				Reporter.log("Successfully Verified Shipping Confirmation Mail & Subject Line : " + Emails.strMailSubject);
				Reporter.log("<p>Successfully Verified Shipping Confirmation Mail Received Time : " + Emails.strReceivedMailTime);
         }
	
	   
	     @Test(description="Verify Return Request Confirmation Mail Contents", priority=175)
	     public void step175_VerifyReturnRequestConfirmationMailContents() throws Exception
	     {
	    	    String EmailID=CustomFun.getUserInfoDSDetails().get().getEmailDomain();
	     	    String Password=CustomFun.getUserInfoDSDetails().get().getAppPassword();
				if(locale.get().contains("FR_FR"))
				{
					Emails.verifyEmailSubjectLine(""+EmailID+""+":"+""+Password+"", "Christian Louboutin Europe Online Boutique - Nouveau retour #"+RMAID);
				}
				else
				if(locale.get().contains("UK_EN"))
			    {
					Emails.verifyEmailSubjectLine("" + EmailID + "" + ":" + "" + Password + "", 
							"CHRISTIAN LOUBOUTIN : Return request confirmation #"+"'"+RMAID);
				}
				else
				{
					Emails.verifyEmailSubjectLine("" + EmailID + "" + ":" + "" + Password + "", 
							"CHRISTIAN LOUBOUTIN : Return request confirmation #"+"'"+RMAID);
				}
				Reporter.log("Successfully Verified Return Request Confirmation Mail & Subject Line : " + Emails.strMailSubject);
				Reporter.log("<p>Successfully Verified Return Request Confirmation Mail Received Time : " + Emails.strReceivedMailTime);
	     }


	     @Test(description="Verify Return Reception Confirmation Mail Contents", priority=176)
	     public void step176_VerifyReturnReceptionConfirmationMailContents() throws Exception
	     {     
	    	    String EmailID=CustomFun.getUserInfoDSDetails().get().getEmailDomain();
	    	    String Password=CustomFun.getUserInfoDSDetails().get().getAppPassword();
	    	 
				if(locale.get().contains("FR_FR"))
				{
					Emails.verifyEmailSubjectLine("" + EmailID + "" + ":" + "" + Password + "", 
							"Réception du retour # "+RMAID);
				}
				else
				if(locale.get().contains("UK_EN"))
			    {
					Emails.verifyEmailSubjectLine("" + EmailID + "" + ":" + "" + Password + "", 
							"Confirmation return # "+RMAID);
				}
				else
				{
					Emails.verifyEmailSubjectLine("" + EmailID + "" + ":" + "" + Password + "", 
							"Confirmation return # "+RMAID);
				}
				Reporter.log("Successfully Verified Return Request Confirmation Mail & Subject Line : " + Emails.strMailSubject);
				Reporter.log("<p>Successfully Verified Return Request Confirmation Mail Received Time : " + Emails.strReceivedMailTime);
	     }

	     @Test(description="Verify Credit Memo Confirmation Mail Contents", priority=177)
	     public void step177_VerifyCreditMemoConfirmationMailContents() throws Exception
	     {
	    	   String EmailID=CustomFun.getUserInfoDSDetails().get().getEmailDomain();
	     	   String Password=CustomFun.getUserInfoDSDetails().get().getAppPassword();
				if(locale.get().contains("FR_FR"))
				{
				    Emails.verifyEmailSubjectLine(""+EmailID+""+":"+""+Password+"","Christian Louboutin Europe Online Boutique: Retour # "+"'"+RefundMemoID+"'"+"pour la commande #"+"'"+OrderID+"'");
				}
				else
				if(locale.get().contains("UK_EN"))
			    {
					Emails.verifyEmailSubjectLine("" + EmailID + "" + ":" + "" + Password + "", 
							"Christian Louboutin Europe Online Boutique: Credit Memo #"+"'"+RefundMemoID+"'"+" for Order # "+"'"+OrderID+"'");
				}
				else
				{
					Emails.verifyEmailSubjectLine("" + EmailID + "" + ":" + "" + Password + "", 
							"Christian Louboutin Europe Online Boutique: Credit Memo #"+"'"+RefundMemoID+"'"+" for Order # "+"'"+OrderID+"'");
				}
				Reporter.log("Successfully Verified Refund Confirmation Mail & Subject Line : " + Emails.strMailSubject);
				Reporter.log("<p>Successfully Verified Refund Confirmation Mail Received Time : " + Emails.strReceivedMailTime);
	     }   
}
