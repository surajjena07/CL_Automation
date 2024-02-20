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
public class TC_Scenario_04 extends BaseTest
{

	public static String OrderID;
	public static String CreatedRMAOrderID_FromOffline=BackOfficePage.NewOrderFor_RMAOffline;
	public String OrderStatus; 
	public MyAccountPage RMA_ID_FO;
	public String RefundMemoID;
	public static String RMAID;
	public String ShipmentID;
	public static String BarCodeSKU;
	public static String Size;
	public static String ref_searchable_SKUID;
	public String OrderPrice;
	public String BarCodeForScan;
	public String ExpProductLineItem;
	public String ExpSubTotal;
	public String ExpTax;
	public String ExpGrandTotal;
	public String ExpShippingAndHandling;
	
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
	
	@Test(priority=1, description="Precondition: Open browser,Navigate to the CL URL and accept Cookies")
	public void step01_NavigatetoCLHomePage() throws Exception
	{
	logtest("Create an exchange with an available product with Paypal Payment Method");
	System.out.println("step 1 begin");
	homepage =HomePage.navigateToCLApplication_URL(driver.get(),baseUrl.get());
	log.info("Successfully navigated to application URL \n");
	Reporter.log("<p>Successfully navigated to application URL");
	System.out.println("step 1 end");
	}

	
	@Test(priority=2, description="Mouseover on L1 Category")
	public void step02_MouseoverOnL1CategoryAndClickL2KateCategory() throws Exception
	{
		if(locale.get().contains("FR_FR") | bsValue.get().contains("YES") | locale.get().contains("CH_FR") | environmentName.contains("IntegrationEnv") | locale.get().contains("UK_EN") | environmentName.equals("HomoEnv") | environmentName.contains("StagingEnv"))
		{
			for (int i = 0; i <= 1; i++)
			{
				Thread.sleep(5000);
				CustomFun.refreshPage(homepage.driver);
				Thread.sleep(5000);
			}
			GUIFunctions.pageScrollToTopOfPage(homepage.driver);
			homepage.mousehoverOnLadiesHeaderNavigation();
			if(environmentName.contains("IntegrationEnv"))
			homepage.ClickOnL2HotChickCategory();
			else
			homepage.ClickOnL2KateCategory();
		}
		else
		{
			GUIFunctions.pageScrollToTopOfPage(homepage.driver);
			homepage.mousehoverOnLadiesHeaderNavigation();
			homepage.ClickOnL2KateCategory();
		}
	}
	
	@Test(priority=3, description="Verification of Category page ")
	public void step03_VerifiedCategoryPage() throws Exception
	{	
		categorylandingpage=new CategoryLandingPage(homepage.driver);
		categorylandingpage.VerifyProductWidgets();
	}
	
	@Test(priority=4, description=" Click on product from CLP ")
	public void step4_ClickOnProductImg() throws Exception
	{
     	categorylandingpage.Click_ProductImg();
     	productdetailspage=new ProductDetailsPage(categorylandingpage.driver);
	}
	
	@Test( priority=5, description="Verified Product Name in Product Details Page")
	public void step5_VerifiedProductNameinPDP() throws Exception
	{	
	productdetailspage.VerifyProductNametxtInPDP();
	}    

	@Test(priority=6, description="Verified Product Price in Product Details Page" )
	public void step6_VerifiedProductPriceinPDP() throws Exception
	{
	productdetailspage.VerifyProductPricetxtInPDP();
	}
	
	
	@Test(priority=7, description="Verified Product brand name in Product Details Page" )
	public void step7_VerifiedProductBrandNametxtInPDP() throws Exception
	{
	productdetailspage.VerifyProductBrandNametxtInPDP();
	}
	
	@Test(priority=8, description="Verified Add to cart button in Product Details Page" )
	public void step8_VerifiedAddtoCartbtnInPDP() throws Exception
	{
	productdetailspage.VerifyAddtoCartbtnInPDP();
	}
	
	@Test(priority=9,description="Click on In_store_availability button and close overlay" )
	public void step9_ClickOnInStoreAvailabilityButtonAndCloseOverlay() throws Exception
	{
	productdetailspage.ClickonInStoreAvailabilitybtnAndCloseOverlayInPDP();
	}

	@Test(priority=10,description="Verified Contact Us link")
	public void step10_VerifiedContactUslink() throws Exception
	{
	productdetailspage.VerifyContactUsLinkInPDP();
	}

	@Test(priority=11,description="Verified Color swatches in PDP")
	public void step11_VerifiedColorSwatches() throws Exception
	{
	productdetailspage.pdpColorSwatches();
	}
	
	@Test(priority=12,description="Verified Size Guide option, Click on Size Guide and close overlay")
	public void step12_ClickOnSizeGuideAndCloseOverlay() throws Exception
	{
	productdetailspage.pdpSizeguideInfo();
	}
	
	@Test( priority=13,description="Click On Select_Your_Size Button and Select any Size")
	public void step13_ClickOnSelectYourSizeButtonAndSelectAnySize() throws Exception
	{
	productdetailspage.ClickOnSelectYourSizeBtnAndSelectAnySizeInPDP();
	Size=ProductDetailsPage.GetSizeOfProd;
	GUIFunctions.mouseOverElement(productdetailspage.driver, productdetailspage.driver.findElement(By.xpath(ObjRepoProp.get().getProperty("HP_MyAccount_Icon"))),"My Account");
	}
	
	
	@Test(priority=14,description="Click on Product Info and Verified content under Product Info section")
	public void step14_ClickonProductInfoAndVerifiedContent() throws Exception
	{
		productdetailspage.pdpNotification_Closebtn();
		productdetailspage.pdpProductInfoBlock();
		ref_searchable_SKUID=ProductDetailsPage.Ref_searchable_sku;
	}

	@Test(priority=15,description="Click on Product Care and Verified content under Product Care section")
	public void step15_ClickonProductCareAndVerifiedContent() throws Exception
	{
		productdetailspage.pdpProductCareBlock();
	}
	

	@Test(priority=16,description="Click on Shipping and Verified content under Shipping section")
	public void step16_ClickonShippingAndVerifiedContent() throws Exception
	{
	productdetailspage.pdpShippingBlock();
	}


	@Test(priority=17,description="Verify PDP main and thumbnail image ")
	public void step17_VerifyMainThumbnailImg() throws Exception
	{
	productdetailspage.pdpMainimage();
	}
	
	@Test(priority=18,description="Click on Add To Cart Button")
	public void step18_ClickonAddToCartButton() throws Exception
	{
	productdetailspage.pdpAddtoCartbtn();
	
	}
	
	@Test(priority=19,description="Verification of PDP notification block")
	public void step19_VerifiedPDPConfirmationMessagePopUPModal() throws Exception
	{
	productdetailspage.pdpProductadd_Notification();
	productdetailspage.pdpNotification_ContinebtnOrderNow();
	}
	
	@Test(priority=20,description="close the Confirmation Message PopUP Modal")
	public void step20_ClosePDPConfirmationMessagePopUPModal() throws Exception
	{
	productdetailspage.pdpNotification_Closebtn();
	}
	
	@Test(priority=21, description=" Again Mouseover on L1 Category and click on L1 sub category")
	public void step21_MouseoverOnL1Category() throws Exception
	{
		homepage=new HomePage(productdetailspage.driver);
		homepage.mousehoverOnLadiesHeaderNavigation();
		Thread.sleep(1000);
		if(environmentName.equals("StagingEnv1"))
		{
			homepage.ClickOnL2IrizaCategory();
		}
		else
		{
			homepage.ClickOnL2IrizaCategory();
		}
	}
	
	@Test(priority=22, description=" Click on product from CLP ")
	public void step22_ClickOnProductImg() throws Exception
	{
		if(environmentName.contains("IntegrationEnv"))
		{
			categorylandingpage=new CategoryLandingPage(homepage.driver);
			categorylandingpage.Click_ProductImg2();
			productdetailspage.pdpProductInfoBlock();
			GUIFunctions.pageScrollToTopOfPage(productdetailspage.driver);
			Thread.sleep(1000);
		}
		else
		{
		categorylandingpage=new CategoryLandingPage(homepage.driver);
		if(locale.get().contains("UK_EN"))		
	    categorylandingpage.Click_ProductImg();
		else
     	categorylandingpage.Click_ProductImg2();
		}
	}
	
	
	@Test( priority=23,description="Click On Select_Your_Size Button and Select any Size and verify PDP notification")
	public void step23_ClickOnSelectYourSizeButtonAndSelectAnySizeAndVerifyPDP() throws Exception
	{
		if(environmentName.contains("IntegrationEnv"))
		{
			productdetailspage.driver.findElement(By.xpath(ObjRepoProp.get().getProperty("PDP_Sizebtn"))).click();
			Thread.sleep(1000);
			productdetailspage.driver.findElement(By.xpath(ObjRepoProp.get().getProperty("PDP_SelectedSecondSize"))).click();
			Thread.sleep(1000);
			productdetailspage.pdpAddtoCartbtn();
		}
		else
		{
			productdetailspage.pdpProductInfoBlock();
			GUIFunctions.pageScrollToTopOfPage(productdetailspage.driver);
		    productdetailspage.ClickOnSelectYourSizeBtnAndSelectSecondSizeInPDP();
		    GUIFunctions.mouseOverElement(homepage.driver, homepage.driver.findElement(By.xpath("//span[@class='view']")),"My Account");
		    productdetailspage.pdpAddtoCartbtn();
			productdetailspage.pdpProductadd_Notification();
			productdetailspage.pdpNotification_ContinebtnOrderNow();	
		}    
	}
		
	@Test(priority=24,description="close the Confirmation Message PopUP Modal")
	public void step24_ClosePDPConfirmationMessagePopUPModal() throws Exception
	{		
	productdetailspage.pdpNotification_Closebtn();	
	} 
	
	@Test(description="Open New Tab and Navigated to WMS", priority=25)
	public void step25_OpenNewTabAndNavigatedtoWMS() throws Exception
	{
	wmspage=new WMSPage(productdetailspage.driver);
	CustomFun.OpenNewTabAndSwitchToNewTab(wmspage.driver, "1");
	wmspage.driver.navigate().to(CustomFun.getWMSInfoDSDetails().get().getWMSURL());
	}

	@Test(description="Logged into WMS with valid crendentials", priority=26)
	public void step26_LoggedIntoWMS() throws Exception
	{
	wmspage.WMSLogIn(CustomFun.getWMSInfoDSDetails().get().getWmsUsername(),CustomFun.getWMSInfoDSDetails().get().getWmsPassword());
	}

	@Test(description="Click on OK button in WMS", priority=27)
	public void step27_ClickOnOKbutton() throws Exception
	{
	wmspage.Click_WMSOKBtn();
	}

	@Test(description="Mouse Over on Data Lists Menu", priority=28)
	public void step28_MouseOverElementOnDataListsMenu() throws Exception
	{
	wmspage.WMS_Datalistmenu();
	}

	@Test(description="Click on Products from Data Lists", priority=29)
	public void step29_ClickOnProductsFromDataLists() throws Exception
	{
	wmspage.WMS_Datalist_Productclick();
	}

	@Test(description="Enter Searchable SKU & Click on Submit Filter", priority=30)
	public void step30_EnterSearchableSKUAndClickOnSubmitFilter() throws Exception
	{
	wmspage.SearchSKUIDInListOfProducts(ref_searchable_SKUID, Size);
	BarCodeSKU=WMSPage.barcodeSKU;
	}

	@Test(description="Click on Details Button", priority=31)
	public void step31_ClickOnDetailsButton() throws Exception
	{
	wmspage.ClickOnDetailsButton(Size);
	}

	@Test(description="Scroll down till stocks grid and Verify Initial Saleable Stock", priority=32)
	public void step32_VerifyInitialSaleableStock() throws Exception
	{
	wmspage.VerifyInitialSaleableStock();
	}

	@Test(description="Verify Reserved Stock", priority=33)
	public void step33_VerifyReservedStock() throws Exception
	{
	wmspage.VerifyInitialReservedStock();
	}
	
	
	@Test(description="Open New Tab and Navigated to Magento BO", priority=34)
    public void step34_OpenNewTabAndNavigatedtoMagentoBO() throws Exception
    {
		 backofficepage=new BackOfficePage(homepage.driver);
	     CustomFun.OpenNewTabAndSwitchToNewTab(backofficepage.driver, "2");
	     backofficepage.driver.navigate().to(CustomFun.getBODSDetails().get().getBO_URL());
    }
    
    @Test(description="Entered Username in Username Field", priority=35)
    public void step35_EnteredUsernameField() throws Exception
    {
    backofficepage.EnterUsername(CustomFun.getBODSDetails().get().getBO_Username());
    }
    
    @Test(description="Entered Password in Password Field", priority=36)
    public void step36_EnteredPasswordField() throws Exception
    {
    backofficepage.EnterPassword(CustomFun.getBODSDetails().get().getBO_Password());
    }
    
    @Test(description="Click on SignIn Button", priority=37)
    public void step37_ClickOnSignInButton() throws Exception
    {
        backofficepage.SignbtnClick();
        if(environmentName.contains("IntegrationEnv") | environmentName.contains("HomoEnv1") | environmentName.contains("StagingEnv") | environmentName.contains("Integration6Env"))
  	    {
  			Thread.sleep(5000);
  			CustomFun.refreshPage(backofficepage.driver);
  			Thread.sleep(5000);
  		}
    }
    
    @Test(description="Verified Dashboard Header & check whether user is in Dashboard page", priority=38)
    public void step38_VerifiedDashboardHeaderInBO() throws Exception
    {
          CustomFun.waitForPageLoaded(backofficepage.driver);
          backofficepage.VerifyDashboardHeader();
    }
    
    @Test(description="Click on Catalog Icon", priority=39)
    public void step39_ClickOnCatalogIcon() throws Exception
    {
          backofficepage.CatalogIconClick();
    }
    
    @Test(description="Click on Products text from Catalog Icon", priority=40)
    public void step40_ClickProductstxtFromCatalogIcon() throws Exception
    {
          backofficepage.ProductstxtFromCatalogIconClick();
    }
    
    @Test(description="Search For Product Seleable Stock In BO", priority=41)
    public void step41_SearchForProductSeleableStockInBO() throws Exception
    {
        backofficepage.SearchForProductSeleableStockInBO(BarCodeSKU);
    }
    
    @Test(description="Verify Initial Saleable Stock", priority=42)
    public void step42_VerifyInitialSaleableStock() throws Exception
    {
       backofficepage.VerifyInitialSaleableStockInBO(BarCodeSKU);
    }

	
	@Test(priority=43,description="click on mini cart icon")
	public void step43_ClickOnMinicartIcon() throws Exception
	{
		 CustomFun.SwitchToSpecificTab(homepage.driver, "0");
	    homepage=new HomePage(productdetailspage.driver);	
	    homepage.ScrollTillMinicartAndclickOn_Minicart_Icon();
	} 
	
	@Test(priority=44,description="Verification of all details inside mini cart")
	public void step44_VerifiedAllDetailsInsideMiniCart() throws Exception
	{
	cartpage=new CartPage(homepage.driver);	
	cartpage.Verify_All_txt_InMiniCart();
	cartpage. Verify_Product_Details_IN_MiniCart();
	cartpage.VerifyProductQtyIn_MiniCart();
	cartpage.Verify_Product_price_Details_MiniCart();
	cartpage.Verify_Product_NavigationLnks_MiniCart();
	}
	
	@Test(priority=45,description="click on complete cart link inside mini cart ")
	public void step45_ClickOnCompletecartLnk_MainCart() throws Exception
	{	
	cartpage.Click_ON_CompleteCartLnk_Minicart();
	CustomFun.waitForPageLoaded(cartpage.driver);
	}  
	
	@Test(priority=46,description="verify product details in main cart")
	public void step46_VerifyDetails_MainCart() throws Exception
	{
	cartpage.Verify_All_Redbannertxt_InMainCart();
	cartpage.Verify_Product_Details_InMainCart();
	cartpage.VerifyRemoveWishlistLnk_Maincart();
	cartpage.Verify_Product_price_Details_MainCart();
	cartpage.VerifyContactusCheckoutCTA_Maincart();
	cartpage.VerifyProductQtyIn_MainCart();
	cartpage.VerifyFAQSectionInMaincart();
	}
	
	@Test(priority=47,description="click on proceed to checkout CTA")
	public void step47_ClickOnProceedToCheckOutCTA() throws Exception
	{	
		cartpage.Click_ON_ProceedToCheckOut_Maincart();
		CustomFun.waitForPageLoaded(cartpage.driver);
	}    
	
	@Test(priority=48,description="Enter Username for Login field from checkout page  ")
	public void step48_EnterUsername_ForLoginINCheckoutpage() throws Exception
	{
		checkoutpage=new CheckoutPage(cartpage.driver);	
		checkoutpage.EnterEmailAddress_asGU(CustomFun.getUserInfoDSDetails().get().getEmailDomain());
	}
	
	@Test(priority=49,description="Enter password for Login field from checkout page  ")
	public void step49_EnterPassword_ForLoginINCheckoutpage() throws Exception
	{	
		checkoutpage.EnterPassword_asGU(CustomFun.getUserInfoDSDetails().get().getPassword());
	}
	
	@Test(priority=50, description="Click on SignIn Button for Login field from checkout page")
	public void step50_ClickOnLoginInButton_ForLoginINCheckoutpage() throws Exception
	{
		checkoutpage.LoginBtnClick_AsGU();	
	}
	
	@Test(priority=51,description="Verify Gift header text and default no wrap img selected ")
	public void step51_VerifyGiftHeadertextAndDefaultGiftWrapSelected() throws Exception
	{
		checkoutpage.VerifyGiftHeadertxt();
		checkoutpage.VerifyNoWarpImgIsSelected();
	}
	
	@Test(priority=52,description="Enter message in Gift msg fld ")
	public void step52_EnterMsgInGiftMsgFld() throws Exception
	{
		checkoutpage.ScrollDowntillYourMsgField_EnterMsg("HBD");
	}
	
	@Test(priority=53,description="Click on update button ")
	public void step53_ClickUpdateBtn() throws Exception
	{	
		checkoutpage.UpdatebtnClick();
	}

	@Test(priority=54,description="Click on any existing address")
	public void step54_ClickonExistingAdressinShipping() throws Exception
	{
		shippingaddresspage=new ShippingAddressPage(checkoutpage.driver);	
		shippingaddresspage.VerifyShippingAddressHeader();		
		if(!GUIFunctions.isElementPresent((By.xpath(ObjRepoProp.get().getProperty("ExistShippingAddress_xpath"))), shippingaddresspage.driver))
    	{
			for(int i=0;i<=2;i++)
			{
			 CustomFun.refreshPage(shippingaddresspage.driver);
			 Thread.sleep(5000);
	    	 CustomFun.waitForPageLoaded(shippingaddresspage.driver);
			}
			shippingaddresspage.driver.findElement(By.xpath(ObjRepoProp.get().getProperty("ExistShippingAddress_xpath"))).click();
    	}
    	else
    	{
    		shippingaddresspage.driver.findElement(By.xpath(ObjRepoProp.get().getProperty("ExistShippingAddress_xpath"))).click();
    	}
	}
	
	@Test(priority=55,description="Verify Default Values selected in Shipping ")
	public void step55_VerifyDefaultValuesinShipping() throws Exception
	{	
		shippingaddresspage.VerifyExistShippingAddress_AsEU();
		shippingaddresspage.VerifyEditbtn_AsEU();
		shippingaddresspage.VerifyNewAdressBtn();
	}
	
	@Test(priority=56,description="Verify Shipping Method selected in Shipping ")
	public void step56_VerifyShippingMethod() throws Exception
	{
		shippingaddresspage.VerifyShippingMethodAndDescLabel();
		shippingaddresspage.VerfiedSAAndBABothSameCheckboxIsAutoSelectedForCredit();
	}
	
	@Test(priority=57,description="Click on first Shipping method  ")
	public void step57_ClickOnShippingmethod() throws Exception
	{	
		if(environmentName.contains("Integration6Env"))
		{
			WebElement ele=shippingaddresspage.driver.findElement(By.xpath(ObjRepoProp.get().getProperty("ConfirmThisAddress_xpath")));
			GUIFunctions.JavaScriptClick(shippingaddresspage.driver,
					ele,"Click on Confirm This Address button");
		}
		shippingaddresspage.VerifyAndClickOnSecondShippingmethod();
		//shippingaddresspage.VerifyAndClickOnThirdShippingmethod();
	}  
	
	@Test(priority=58,description="Click on Continue to payment btn  ")
	public void step58_ClickOnContinuetopaymentbtn() throws Exception
	{	
		shippingaddresspage.ContinuetopaymentbtnClick();
	}  
	
	@Test(priority=59,description="Verification of Payment section")
	public void step59_VerifyPaymentSection() throws Exception
	{
	    paymentpage=new PaymentPage(shippingaddresspage.driver);			
		paymentpage.checkout_Paymentoptions();
		paymentpage.VerifyCreditCardDetails();
	}
	
	@Test(priority=60, description="Click on Paypal card Radio button under Payment option" )
	public void step60_ClickOnPaypalCardRadioBtn() throws Exception
	{
		paymentpage.checkout_PaypalCard();
		Thread.sleep(2000);
	}
	
	@Test(priority=61,description="Verified 'My billing and shipping address are the same' checkbox is auto selected or not")
	public void step61_VerifiedMyBAandSABothSame_CheckboxIsAutoSelected() throws Exception
	{  
		
	}
	
	@Test(priority=62,description="Unchecked the 'My billing and shipping address are the same' checkbox")
	public void step62_UncheckedMyBAandSABothSameCheckbox() throws Exception
	{
		
	}
	
	@Test(priority=63,description="Checked on Privacy Policy and Return Policy checkbox")
	public void step63_CheckedOnPrivacyPolicyAndReturnPolicyCheckbox() throws Exception
	{
			paymentpage.checkout_Agreements();
	}
	
	@Test(priority=64,description="Click on Proceed button in Checkout page at Payment Section")
	public void step64_ClickOnProceedButton() throws Exception
	{
			  paymentpage.checkout_CC_Proceedbtn();
	}
	
	@Test(priority=65,description="Entered Email ID in Email ID Field")
	public void step65_EnteredEmailField() throws Exception
	{
		paymentpage.EnterEmailIDInPPP(CustomFun.payPalPaymentDSDetails.get().getPayPalUsername());
	}
	
	@Test(priority=66,description="Entered Password in Password Field")
	public void step66_EnteredPasswordField() throws Exception
	{
        paymentpage.EnterPasswordInPPP(CustomFun.payPalPaymentDSDetails.get().getPayPalPassword());
	}
	
	@Test(priority=67,description="Click on SignIn Button")
	public void step67_ClickOnSignInButton() throws Exception
	{
		paymentpage.clickOnLoginBtnInPPP();
	}
	
	@Test(priority=68,description="Select Existing Paypal Card")
	public void step68_SelectBankOfVisaCard() throws Exception
	{
		paymentpage.BankOfCardVisaClick();
	}
	
	@Test(priority=69,description="Click on Pay Button")
	public void step69_PayButtonClick() throws Exception
	{
		paymentpage.PayButtonClick();
	}
	
	@Test(priority=70,description="Verified Success Message in Order Confirmation page after placing the order")
	public void step70_VerifiedSuccessMsgAfterPlacingOrder() throws Exception
	{	
		orderconfirmationpage=new OrderConfirmationPage(paymentpage.driver);
		orderconfirmationpage.Verify_SuccessOrder_Msg_txt();
	}
	
	@Test(priority=71,description="Verified Continue Shopping Button in Order Confirmation page")
	public void step71_VerifiedContinueShoppingButton() throws Exception
	{
		orderconfirmationpage.VerifyContinueShopping_Btn();
	}
	
	@Test(priority=72,description="Verified processing order text in Order Confirmation page")
	public void step72_VerifiedProcessingOrderTxt() throws Exception
	{
		orderconfirmationpage.Verify_ProcessingOrder_Txt();
	}  
	
	@Test(priority=73,description="Verified Your OrderID in Order Confirmation page")
	public void step73_VerifiedYourOrderID() throws Exception
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
	
	@Test(priority=74, description=" Clicking on My Account Icon ")
	public void step74_ClickMyAccountBtn() throws Exception
	{
	homepage=new HomePage(orderconfirmationpage.driver);
	homepage.driver.findElement(By.xpath(ObjRepoProp.get().getProperty("HP_MyAccount_Icon"))).click();	
	} 
	
	
	@Test(priority=75, description=" Clicking on My orders link ")
	public void step75_ClickAddressBookLink() throws Exception
	{
	myaccountpage=new MyAccountPage(homepage.driver);
	myaccountpage.ClickAddressBook_Lnk();		
	MyAccountPage.BillingAddress_ForProduct= myaccountpage.driver.findElement(By.xpath("//div[@class='box-content']")).getText();			
	MyAccountPage.ShippingAddress_ForProduct= myaccountpage.driver.findElement(By.xpath("//div[@class='block-content address-item']")).getText();	
	System.out.println("MyAccountPage.BillingAddress_ForProduct" +MyAccountPage.BillingAddress_ForProduct);
	System.out.println("MyAccountPage.ShippingAddress_ForProduct"+MyAccountPage.ShippingAddress_ForProduct);
	}
	
	
	@Test(priority=76, description=" Verify Order Details In Myorders Page ")
	public void step76_VerifyOrderdetailsInOrderspage() throws Exception
	{
		myaccountpage.MyOrders_LnkClick();	
		myaccountpage.VerifyOrderStatus(OrderID);
		myaccountpage.VerifyOrderPriceInOrderspage(OrderID);	
		OrderPrice=MyAccountPage.PriceVal_OrderPage;
		MyAccountPage.PriceVal_OrderPage= myaccountpage.driver.findElement(By.xpath("//*[contains(text(),'"+OrderID+"')]/..//p[contains(@class, 'price')]")).getText().replaceAll(",","\\.").replaceAll("[^0-9.]", ""); 
		myaccountpage.VerifyOrderItemInOrderspage(OrderID);
		myaccountpage.VerifyOrderDateInOrderspage(OrderID);
		if(locale.get().contains("FR_FR"))
		{
			for (int i = 0; i <= 3; i++)
			{
				Thread.sleep(30000);
				CustomFun.refreshPage(myaccountpage.driver);
				Thread.sleep(10000);
				myaccountpage.VerifyOrderStatus(OrderID);
				    if(MyAccountPage.OrderStatusFromFO.contains(TextProp.get().getProperty("OrderInPreparationtxt_FR")))
				    {
				    Assert.assertEquals(MyAccountPage.OrderStatusFromFO,TextProp.get().getProperty("OrderInPreparationtxt_FR"));
				    break;
				    }
			}
		}
		else
		{
			for (int i = 0; i <= 3; i++)
			{
				Thread.sleep(30000);
				CustomFun.refreshPage(myaccountpage.driver);
				Thread.sleep(10000);
				myaccountpage.VerifyOrderStatus(OrderID);
				if(MyAccountPage.OrderStatusFromFO.contains(TextProp.get().getProperty("OrderPlacedtxt_UK")))
				{
				  Assert.assertEquals(MyAccountPage.OrderStatusFromFO,TextProp.get().getProperty("OrderPlacedtxt_UK"));
				  break;
				}
			}
		}
	} 
	
	@Test(priority=78,description="Click on Sales Icon")
	public void step78_ClickOnSalesIcon() throws Exception
	{
		CustomFun.SwitchToSpecificTab(backofficepage.driver, "2");
		backofficepage.SalesIconClick();
	}
	
	@Test(priority=79,description="Click on Orders text from Sales Icon")
	public void step79_ClickOrderstxtFromSalesIcon() throws Exception
	{
		backofficepage.OrderstxtFromSalesIconClick();
		CustomFun.waitForPageLoaded(backofficepage.driver);
	}  
	
	@Test(priority=81,description="Verified Order Status in Orders page")
	public void step81_VerifiedOrderStatusInOrdersPage() throws Exception
	{
		if(!backofficepage.driver.findElement(By.xpath("//button[text()='Clear all']")).isDisplayed())
		{
			backofficepage.driver.findElement(By.xpath("//input[@id='fulltext']")).sendKeys(OrderID);
			backofficepage.driver.findElement(By.xpath("(//button[@class='action-submit'])[2]")).click();
			CustomFun.waitForPageLoaded(backofficepage.driver);
			backofficepage.driver.findElement(By.xpath("//button[text()='Clear all']")).click();
			  backofficepage.EnterOrderId(OrderID);
			  backofficepage.SearchIconClick();
			  backofficepage.VerifyOrderStatusInBO_OrdersPage(OrderID);
		}
		else
		{
		  backofficepage.driver.findElement(By.xpath("//button[text()='Clear all']")).click();
		  CustomFun.waitForPageLoaded(backofficepage.driver);
		  backofficepage.driver.findElement(By.xpath("//input[@id='fulltext']")).sendKeys(OrderID);
		  Thread.sleep(5000);
		  backofficepage.driver.findElement(By.xpath("(//button[@class='action-submit'])[2]")).click();
		  CustomFun.waitForPageLoaded(backofficepage.driver);
		  backofficepage.driver.findElement(By.xpath("//button[text()='Clear all']")).click();
		  backofficepage.EnterOrderId(OrderID);
		  backofficepage.SearchIconClick();
		  backofficepage.VerifyOrderStatusInBO_OrdersPage(OrderID);
		}
		//OrderStatus=BackOfficePage.OrderStatus;
		for(int i=0;i<=2;i++)
		{
		  Thread.sleep(30000);
		
		  backofficepage.ClearTheFilterInBO(OrderID);
		  backofficepage.VerifyOrderStatusInBO_OrdersPage(OrderID);
	      OrderStatus=BackOfficePage.OrderStatus;
		  if(BackOfficePage.OrderStatus.contains(TextProp.get().getProperty("OnHoldtxt")))
		  {
			  OrderStatus=BackOfficePage.OrderStatus;
			  Assert.assertEquals(TextProp.get().getProperty("OnHoldtxt"), OrderStatus);
			  log.info("Successfully Verified Order Status in Magento After Placing the order in FO: " + OrderStatus);
			  Reporter.log("<p>Successfully Verified Order Status in Magento After Placing the order in FO: " + OrderStatus);
			  break;
		  }
		} 
	} 
	
	@Test(priority=82,description="Open New Tab and Navigated to Adyen")
	public void step82_OpenNewTabAndNavigatedtoAdyen() throws Exception
	{
	   adyenpage=new AdyenPage(backofficepage.driver);
       CustomFun.OpenNewTabAndSwitchToNewTab(adyenpage.driver, "3");
       adyenpage.driver.navigate().to(CustomFun.getAdyenInfoDSDetails().get().getAdyenUrl());
	} 

	
	@Test(priority=83,description="Logged into Adyen with valid crendentials")
	public void step83_LoggedIntoAdyen() throws Exception
	{
		adyenpage=new AdyenPage(backofficepage.driver);
		adyenpage.AdyenLogIn(CustomFun.getAdyenInfoDSDetails().get().getAdyenUsername(),CustomFun.getAdyenInfoDSDetails().get().getAdyenAccount(),CustomFun.getAdyenInfoDSDetails().get().getAdyenPassword());
	}
	
    @Test(priority=84,description="Click on Risk option from Case management")
	public void step84_ClickCaseMgmtOPtionINAdyen() throws Exception
	{
    	adyenpage.Click_AdyenRiskTab();
		adyenpage.Click_AdyenCaseMgmtTab();
	}
	
	
	@Test(priority=85,description="verify the order id in Adyen and select the checkbox")
	public void step85_ClickOrderIDCheckbox() throws Exception
	{
		adyenpage.Verify_OrderIDandClickCheckbox(OrderID);
			
	}  
	
	@Test(priority=86,description="Click on accept and ok in Adyen")
	public void step86_ClickOnAcceptBtn() throws Exception
	{
		adyenpage.Click_AdyenOrderAcceptBtn();	
	} 
	
	@Test(priority=87,description="Navigated Into Magento and Verified Order Status in Orders page")
	public void step87_NavigatedIntoMangetoAndVerifiedOrderStatusInOrdersPage() throws Exception
	{
		    CustomFun.SwitchToSpecificTab(backofficepage.driver, "2");
	        backofficepage.SalesIconClick();
	        backofficepage.OrderstxtFromSalesIconClick();
	    	Thread.sleep(1000);
	        CustomFun.waitForPageLoaded(backofficepage.driver);
	        for(int i=0;i<=9;i++)
			{
			  Thread.sleep(30000);
			  
			  backofficepage.ClearTheFilterInBO(OrderID);
			  backofficepage.VerifyOrderStatusInBO_OrdersPage(OrderID);
		      OrderStatus=BackOfficePage.OrderStatus;
			  if(OrderStatus.contains(TextProp.get().getProperty("SenttoLogistictxt")))
			  {
				  OrderStatus=BackOfficePage.OrderStatus;
				  Assert.assertEquals(TextProp.get().getProperty("SenttoLogistictxt"), OrderStatus);
				  log.info("Successfully Verified Order Status in Magento After Placing the order in FO: " + OrderStatus);
				  Reporter.log("<p>Successfully Verified Order Status in Magento After Placing the order in FO: " + OrderStatus);
				  break;
			  }
			}
	  }
     		
	
	 @Test(description="Navigated Into BO and Verified Seleable Stock Quantity Decremented By 1", priority=88)
	    public void step88_VerifiedSaleableStockQntyDecBy1InBOAferPlacingTheOrder() throws Exception
	    {
	          CustomFun.refreshPage(backofficepage.driver);
	          CustomFun.waitForPageLoaded(backofficepage.driver);
	          backofficepage.CatalogIconClick();
	          backofficepage.ProductstxtFromCatalogIconClick();
	          CustomFun.waitForPageLoaded(backofficepage.driver);
	          backofficepage.SearchForProductSeleableStockInBO(BarCodeSKU);
	          backofficepage.VerifySaleableStockQntyDecBy1InBOAferPlacingTheOrder(BarCodeSKU);
	    }
	    
	    @Test(description="Navigated Into WMS and Verified Seleable Stock Quantity Decremented By 1", priority=89)
	    public void step89_VerifySaleableStockDecBy1InWMSAferPlacingTheOrder() throws Exception
	    {
	          CustomFun.SwitchToSpecificTab(wmspage.driver, "1");
	          CustomFun.refreshPage(wmspage.driver);
	          CustomFun.waitForPageLoaded(wmspage.driver);
	          wmspage.VerifySaleableStockDecBy1InWMSAferPlacingTheOrder();
	    }
	    
	    @Test(description="Comparing the Seleable stock in the WMS and the BO Magento", priority=90)
	    public void step90_ComparedSeleableStockInWMSAndBOBothAreSame() throws Exception
	    {
	  
	    CustomFun.refreshPage(wmspage.driver);
	    CustomFun.waitForPageLoaded(wmspage.driver);
	    wmspage.VerifyInitialSaleableStock();
	    CustomFun.SwitchToSpecificTab(backofficepage.driver, "2");
	    backofficepage.CatalogIconClick();
	    backofficepage.ProductstxtFromCatalogIconClick();
	    CustomFun.waitForPageLoaded(backofficepage.driver);
	    backofficepage.SearchForProductSeleableStockInBO(BarCodeSKU);
	    backofficepage.VerifyInitialSaleableStockInBO(BarCodeSKU);
	  //  Assert.assertEquals(BackOfficePage.InitialSaleableStock_BO, WMSPage.InitialSaleableStock_WMS, "Stock in the WMS and the Bo Magento both are same");
	    }
     
  	@Test(priority=91,description="Picking Order Process")
  	public void step91_PickingOrderProcess() throws Exception
  	{
  	   CustomFun.SwitchToSpecificTab(wmspage.driver, "1");
  		wmspage.PickingOrderProcess(OrderID);
  	}
  	
  	@Test(priority=92,description="Verified Picking order for # XXXXX")
  	public void step92_VerifiedPickingOrderSuccessMsg() throws Exception
  	{
  		wmspage.VerifyPickingOrderSuccessMsg();

  	}
  	
  	@Test(priority=93,description="Verified Gift Msg from Picking in Wms")
  	public void step93_VerifiedGiftMsg_INPicking() throws Exception
  	{
  		//wmspage.WMS_VerifyGiftMsg_INPicking();
  	}
  	
  	@Test(priority=94,description=" Get BarCode From Picking Process")
  	public void step94_NavigatedIntoWMSAndGetBarcodeFromPickingProcess() throws Exception
  	{
  		wmspage.getBarCodeFromPickingProcess(OrderID);
  		BarCodeForScan=WMSPage.BarCodeId;
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
		myaccountpage=new MyAccountPage(homepage.driver);
		homepage.driver.findElement(By.xpath(ObjRepoProp.get().getProperty("HP_MyAccount_Icon"))).click();
		Thread.sleep(1000);
		myaccountpage.MyOrders_LnkClick();
		Thread.sleep(1000);
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
  	
      
     @Test(priority=97,description="Navigated Into WMS and Click on Packing Button")
	public void step97_NavigatedIntoWMSAndClickOnPackingBtn() throws Exception
	{
    	CustomFun.SwitchToSpecificTab(wmspage.driver, "1");
		wmspage.Click_WMSPackingBtn();
	}
	
	
	@Test(priority=98,description="Entered BarcodeID in Barcode Field And Search For Packing")
	public void step98_EnteredBarcodeAndSearchForPacking() throws Exception
	{
		wmspage.EnterBarcodeAndSearchForPacking(BarCodeForScan);
	}
	
	@Test(priority=99,description="Copy SKUID And Enter in Search Field For Scanning Products In Packing")
	public void step99_CopySKUIDAndEnterinSearchFeildForScanningProductsInPacking() throws Exception
	{
		By ele=By.xpath(ObjRepoProp.get().getProperty("WMS_SKUID_xpath"));  
		for(int i=0;i<1;i++)
		{
		  String SkuId=wmspage.driver.findElements(ele).get(i).getText().replaceAll("[^0-9.]", "");
		  Thread.sleep(2000);
		  By WMS_SKUID_serachfield= By.xpath(ObjRepoProp.get().getProperty("WMS_SKUID_serachfield_xpath"));  
	      GUIFunctions.typeTxtboxValue(wmspage.driver,WMS_SKUID_serachfield, SkuId);
	      Thread.sleep(2000);
		}
	}
	
	@Test(priority=100,description="Click on Partial Packing button")
	public void step100_ClickOnPartialPackingBtn() throws Exception
	{
		wmspage.Click_PartialPackingBtn();
	}
	
	@Test(priority=101,description="Verify ConfirmPacking And GoBackTOPacking Btn in Partial Packing")
	public void step101_VerifyConfirmPackingAndGoBackTOPackingBtn_PartialPacking() throws Exception
	{
		wmspage.VerifyConfirmPackingAndGoBackTOPackingBtn();
	}
	
	@Test(priority=102,description="Click on ConfirmPacking  Btn in Partial Packing")
	public void step102_ClickOnConfirmPackingBtn_PartialPacking() throws Exception
	{
		wmspage.Click_ConfirmPackingBTN();
		try
		{
			Thread.sleep(2000);
			wmspage.driver.findElement(By.xpath("//button[@class='btn btn-success']")).click();
			Thread.sleep(2000);
		}
		catch(Exception e)
		{
			
		}
	}
	
	@Test(priority=103,description="Enter quantity in front of any row")
	public void step103_EnteredQuantityInAnyRow() throws Exception
	{
		wmspage.EnterSingleQuantity_ForPartialPacking();
	}
	
	@Test(priority=104,description="Click on Validate button")
	public void step104_ClickOnValidateBtn() throws Exception
	{
		wmspage.ClickValidate_Packing();
	}
	
	
	@Test(priority=105,description="Click on Home Popup button")
	public void step105_ClickOnHomePopupBtn() throws Exception
	{
		wmspage.ClickHomeBtn_PopUp();
	}   
	
	@Test(priority=106,description="Navigated Into Magento and Verified Order Status in Orders page")
	public void step106_NavigatedIntoMangetoAndVerifiedOrderStatusInOrdersPage() throws Exception
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

	
	@Test(priority=107,description="Navigated Into FO and Verified Order Status in My Orders page")
	public void step107_NaviagtedIntoFOAndVerifiedOrderStatusInMyOrdersPage() throws Exception
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
	
      
	@Test(priority=108,description="Navigated Into WMS and Processed with Shipping Process")
	public void step108_NavigatedIntoWMSAndProcessedwithShippingProcess() throws Exception
	{
        CustomFun.SwitchToSpecificTab(wmspage.driver, "1");
		wmspage.ShippingOrderProcess_PartialPacking(BarCodeForScan);
	}
	
	@Test(priority=109,description="Navigated Into Magento and Verified Order Status in Orders page")
	public void step109_NavigatedIntoMangetoAndVerifiedOrderStatusInOrdersPage() throws Exception
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
        Assert.assertEquals("Partial Shipped", OrderStatus);
        log.info("Successfully Verified Order Status in Magento After Shipping Process is completed: " + OrderStatus);
        Reporter.log("<p>Successfully Verified Order Status in Magento After Shipping Process is completed: " + OrderStatus);
	}
	

	@Test(priority=110,description="Navigated Into FO and Verified Order Status in My Orders page")
	public void step110_NaviagtedIntoFOAndVerifiedOrderStatusInMyOrdersPage() throws Exception
	{
		CustomFun.SwitchToSpecificTab(homepage.driver, "0");
		myaccountpage.MyOrders_LnkClick();
		CustomFun.waitForPageLoaded(myaccountpage.driver);
		myaccountpage.VerifyOrderStatus(OrderID);
		if(locale.get().contains("FR_FR") | locale.get().contains("CH_FR"))
		{
		Assert.assertEquals(MyAccountPage.OrderStatusFromFO,TextProp.get().getProperty("OrderPartialShippedtxt_FR"));
		}
		else
		{
		Assert.assertEquals(MyAccountPage.OrderStatusFromFO,TextProp.get().getProperty("OrderPartialShippedtxt_UK"));	
		}
	    log.info("Successfully Verified Order Status in My orders page: " + MyAccountPage.OrderStatusFromFO);
	    Reporter.log("<p>Successfully Verified Order Status in My orders page: " + MyAccountPage.OrderStatusFromFO);
	 } 
	
	@Test(priority=111,description="Navigated back to Adyen and click on payment tab ")
	public void step111_NavigatedIntoAdyenAndClickOnPaymentTab() throws Exception
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
					 * );
					 */		        	
		        	CustomFun.waitForPageLoaded(adyenpage.driver);
		        	adyenpage.Click_AdyenTransactionTab();
		        	adyenpage.Click_AdyenTransactionPaymentTab();
		    	}
			}
		  
	          

	@Test(priority=112,description="Enter order Id in serach bar  ")
	public void step112_EnterOrderIDinPaymentTab_adyen() throws Exception
	{
		adyenpage.Enter_AdyenPaymentSearchField(OrderID);
	}
	
	@Test(priority=113,description="Verify order total amount in Adyen ")
	public void step113_VerifyOrderTotalAmtIN_adyen() throws Exception
	{	
		adyenpage.Verify_AdyenOrderAmount(OrderID, OrderPrice);
	} 
	
	 @Test(description="Comparing the Seleable stock in the WMS and the BO Magento after shipping the order", priority=114)
	    public void step114_ComparedSeleableStockInWMSAndBOBothAreSameAfterShippingTheOrder() throws Exception
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
	    backofficepage.SearchForProductSeleableStockInBO(BarCodeSKU);
	    backofficepage.VerifyInitialSaleableStockInBO(BarCodeSKU);
	    }
      
	@Test(priority=115,description="Switch to FO Tab & Click on My Account Icon")
	public void step115_SwitchToFOTabAndClickOnMyAccountIcon() throws Exception
	{
		CustomFun.SwitchToSpecificTab(homepage.driver, "0");
		homepage.clickMyaccountBtn();
	}
	
	@Test(priority=116,description="Click on My Orders Link")
	public void step116_ClickOnMyOrdersLink() throws Exception
	{
		myaccountpage.MyOrders_LnkClick();
	}
	
	@Test(priority=117,description="Verified Order Status in My Orders page")
	public void step117_VerifiedOrderStatusInMyOrdersPage() throws Exception
	{
		myaccountpage.VerifyOrderStatus(OrderID);
	}

	
	@Test(priority=118,description="Click on Order Grid and Verified Order details page")
	public void step118_ClickOnOrderGridAndVerifiedOrderDetailsPage() throws Exception
	{
		CustomFun.SwitchToSpecificTab(backofficepage.driver, "2");
		backofficepage.SalesIconClick();
		backofficepage.OrderstxtFromSalesIconClick();
		backofficepage.ClearTheFilterInBO(OrderID);
		backofficepage.ClickOnOrderGrid(OrderID);
		BackOfficePage.SKUIDVal= backofficepage.driver.findElement(By.xpath("//div[@class='product-sku-block']")).getText().replaceAll("[^0-9.]", ""); 
        System.out.println("BackOfficePage.SKUIDVal"+ BackOfficePage.SKUIDVal);
	}
	
	@Test(priority=119,description="Click on Create Returns button to create New Return")
	public void step119_ClickOnCreateReturnsButton() throws Exception
	{
		backofficepage.CreateReturnsBtnClick();
	}
	
	@Test(priority=120,description="Enter contact email address in create returns ")
	public void step120_EnterContactEmailAdd_CreateReturns() throws Exception
	{
		backofficepage.EnterContactEmailAdd_CreateReturns(CustomFun.userInfoDSDetails.get().getEmailDomain());
	}
	
	@Test(priority=121,description="Select Pickup date to create New Return")
	public void step121_SelectPickupDate() throws Exception
	{
		backofficepage.PickupdateRadioBtnClick();
	}
	
	@Test(priority=122,description="Click on Return Items Tab")
	public void step122_ClickOnReturnItems() throws Exception
	{
		backofficepage.ReturnsItemsClick();
	}
	
	@Test(priority=123,description="Click on Add Product Button")
	public void step123_ClickOnAddProductButton() throws Exception
	{
		backofficepage.AddProductsBtnClick();
	}
	
	@Test(priority=124,description="Click on Checkbox to select the product")
	public void step124_ClickOnCheckboxToSelectTheProduct() throws Exception
	{
		backofficepage.CheckboxProdToAddClick();
	}
	
	@Test(priority=125,description="Click on Add Select Product To Returns Button")
	public void step125_ClickOnAddSelProdToReturnsBtn() throws Exception
	{
		backofficepage.AddSelProdToReturnsBtnClick();
	}
	
	@Test(priority=126,description="Entered Requested value in Requested Field under RMA Items Requested for Grid")
	public void step126_EnterValueInRequestedField() throws Exception
	{
		backofficepage.EnterValueInRequestedField("1");
	}
	
	@Test(priority=127,description="Select any Return Reason option from Return Reason Dropdown")
	public void step127_SelectAnyOptionFromReturnReasonDropdown() throws Exception
	{
		backofficepage.SelectTooSmallOptionFromReturnReasonDropdown();
	}
	
	@Test(priority=128,description="Select any Item Condition option from Item Condition Dropdown")
	public void step128_SelectOptionFromItemConditionDropdown() throws Exception
	{
		backofficepage.SelectOptionFromItemConditionDropdown();
	}
	
	@Test(priority=129,description="Select any Resolution Reason option from Resolution Dropdown")
	public void step129_SelectOptionFromResolutionDropdown() throws Exception
	{
		backofficepage.SelectExchangeOptionFromResolutionDropdown();
	}

	@Test(priority=130,description="Click on Submit Returns Button")
	public void step130_ClickOnSubmitReturnsButton() throws Exception
	{
		backofficepage.SubmitReturnsBtnClick();
	}
	
	@Test(priority=131,description="Verify Success Msg For RMA Request after submit returns")
	public void step131_VerifySuccessMsgForRMARequest() throws Exception
	{
		backofficepage.VerifySuccessfulMsgForRMARequest();
	}
	
	@Test(priority=132,description=" In Magento Click on Sales Icon")
	public void step132_NavigatedIntoMangetoAndClickOnSalesIcon() throws Exception
	{
	backofficepage.SalesIconClick();
	}

	@Test(priority=133,description="Click on Returns link from Sales Tab")
	public void step133_ReturnstxtFromSalesIconClick() throws Exception
	{		
	backofficepage.ReturnstxtFromSalesIconClick();
	}
	
	@Test(priority=134,description="Click on filters and enter order ID")
	public void step134_ClickONFiltersAndEnterOrderID() throws Exception
	{

		if(!backofficepage.driver.findElement(By.xpath("//button[text()='Clear all']")).isDisplayed())
		{
		 Thread.sleep(5000);
		 backofficepage.SearchForRMAOrder(OrderID);
		 Thread.sleep(2000);
		 CustomFun.refreshPage(backofficepage.driver);
		 Thread.sleep(5000);
		}
		else
		{
		  backofficepage.driver.findElement(By.xpath("//button[text()='Clear all']")).click();
		  Thread.sleep(5000);
		  backofficepage.SearchForRMAOrder(OrderID);
		  Thread.sleep(2000);
		  CustomFun.refreshPage(backofficepage.driver);
		  Thread.sleep(5000);
		}
	}
	
	@Test(priority=135,description="Click on  order grid")
	public void step135_ClickonOrderGrid() throws Exception
	{
	 backofficepage.ClearTheFilterInBOForReturnsOrder(OrderID);
	 backofficepage.ClickOnOrderGrid(OrderID);
	}
	
	@Test(priority=136,description="Verify Order Details After Creating RMA From BO in returns page()")
	public void step136_Verify_OrderDetailsAfterCreatingRMAFromBO() throws Exception
	{
	backofficepage.Verify_OrderDetailsAfterCreatingRMAFromBO();
	}
	
	@Test(priority=137,description="Edited Exist Shipping Address with New Shipping Address For RMA")
	public void step137_EditExistShippingAddressWithNewShippingAddressForRMA() throws Exception
	{
		backofficepage.EditExistShippingAddressWithNewShippingAddressForRMA();
	}
	
	@Test(priority=138,description="Verify Success Msg For RMA Updated Address")
	public void step138_VerifySuccessMsgForRMAAddressUpdate() throws Exception
	{
		backofficepage.VerifySuccessMsgForRMAAddressUpdate();	
		backofficepage.Click_BackBtnForBOPrct();
	}
	
	@Test(priority=139,description="Verified Order Status in Returns page")
	public void step139_VerifiedOrderStatusInReturnsPage() throws Exception
	{

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

		 backofficepage.ClearTheFilterInBOForReturnsOrder(OrderID);
         backofficepage.VerifyReturnsStatusInBO_ReturnsPage(OrderID);
		
		for(int i=0;i<=3;i++)
		{
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

	@Test(priority=141,description="Click on Sales Icon")
	public void step141_ClickOnSalesIcon() throws Exception
	{
	backofficepage.SalesIconClick();
	}

	@Test(priority=142,description="Click on Orders text from Sales Icon")
	public void step142_ClickOrderstxtFromSalesIcon() throws Exception
	{
	backofficepage.OrderstxtFromSalesIconClick();
	
	}

	@Test(priority=143,description="Verified Order Status in Orders page")
	public void step143_VerifiedOrderStatusInOrdersPage() throws Exception
	{
	backofficepage.ClearTheFilterInBO(OrderID);
	backofficepage.VerifyOrderStatusInBO_OrdersPage(OrderID);
	OrderStatus=BackOfficePage.OrderStatus;
	Assert.assertEquals(TextProp.get().getProperty("ProcessingRMAtxt"), OrderStatus);
	log.info("Successfully Verified Order Status in Orders Page After Returns submit is completed: " + OrderStatus);
	Reporter.log("<p>Successfully Verified Order Status in Orders Page After Returns submit is completed: " + OrderStatus);
	}

	
	@Test(description="Navigated Into FO and Verified Order Status in My Orders page", priority=144)
   	public void step144_NaviagtedIntoFOAndVerifiedOrderStatusInMyOrdersPage() throws Exception
   	{
   		CustomFun.SwitchToSpecificTab(homepage.driver, "0");
   		homepage.clickMyaccountBtn();
   		CustomFun.waitForPageLoaded(homepage.driver);
   		myaccountpage=new MyAccountPage(homepage.driver);
   		myaccountpage.MyOrders_LnkClick();
   		CustomFun.waitForPageLoaded(homepage.driver);
   		myaccountpage.VerifyOrderStatus(OrderID);
   		if(locale.get().contains("FR_FR") | locale.get().contains("CH_FR"))
		{
   			for (int i = 0; i <= 3; i++)
   			{
   			Thread.sleep(30000);
   		    CustomFun.refreshPage(homepage.driver);
   			Thread.sleep(10000);
   		    myaccountpage.VerifyOrderStatus(OrderID);
   		    if(MyAccountPage.OrderStatusFromFO.contains(TextProp.get().getProperty("Returntxt_FR")))
   		    {
   		    Assert.assertEquals(MyAccountPage.OrderStatusFromFO,TextProp.get().getProperty("Returntxt_FR"));
   		    break;
   		    }
   			}
		}
		else
		{
		Assert.assertEquals(MyAccountPage.OrderStatusFromFO,TextProp.get().getProperty("Pendingreturntxt_UK"));	
		}
   	 }  
	
	@Test(priority=146,description="Navigated Into WMS and Validate the RMA reception in the WMS")
	public void step146_ClickOnRMALink() throws Exception
	{
		CustomFun.SwitchToSpecificTab(wmspage.driver, "1");		
		wmspage.Click_RMALnk();
	}
	
	@Test(priority=147,description="Enter RMA ID in RMA Field, Click on Submit Filter button & Reception button in WMS")
	public void step147_EnterRMAID_SearchForOrderDetails_ClickOnReceptionButton() throws Exception
	{
		for (int i = 0; i <= 4; i++)
	{
	Thread.sleep(60000);
	CustomFun.refreshPage(wmspage.driver);
	Thread.sleep(5000);
	String ExpectedRMAID=wmspage.driver.findElement(By.xpath("//td[contains(@class,'vuetable-td-incrementId')]")).getText();
	if(ExpectedRMAID.contains(RMAID))
	{
	break;
	}
	}
	wmspage.EnterRMAID_SearchForOrderDetails_ClickOnReceptionButton(RMAID);
	}
	
	
	@Test(priority=148,description="Execute RMA Process in WMS")
	public void step148_ExecuteRMAProcessinWMS() throws Exception
	{
		wmspage.ExecuteRMAProcess();
	}  
	
	@Test(priority=150,description="Navigated Into Magento and Click on Sales Icon")
	public void step150_NavigatedIntoMangetoAndClickOnSalesIcon() throws Exception
	{
	CustomFun.SwitchToSpecificTab(backofficepage.driver, "2");
	backofficepage.SalesIconClick();
	}

	@Test(priority=151,description="Click on Orders text from Sales Icon")
	public void step151_ClickOrderstxtFromSalesIcon() throws Exception
	{
	backofficepage.OrderstxtFromSalesIconClick();
	}

	@Test(priority=152,description="Verified Order Status in Orders page")
	public void step152_VerifiedOrderStatusInOrdersPage() throws Exception
	{
	backofficepage.ClearTheFilterInBO(OrderID);
	backofficepage.VerifyOrderStatusInBO_OrdersPage(OrderID);
	OrderStatus=BackOfficePage.OrderStatus;
	Assert.assertEquals(TextProp.get().getProperty("ProcessingRMAtxt"), OrderStatus);
	log.info("Successfully Verified Order Status in Orders Page After Returns submit is completed: " + OrderStatus);
	Reporter.log("<p>Successfully Verified Order Status in Orders Page After Returns submit is completed: " + OrderStatus);
	}

	@Test(priority=153,description="Click on Sales Icon")
	public void step153_ClickOnSalesIcon() throws Exception
	{
	backofficepage.SalesIconClick();
	}
	
	@Test(priority=154,description="Click on Returns link from Sales Tab")
	public void step154_ReturnstxtFromSalesIconClick() throws Exception
	{
		backofficepage.ReturnstxtFromSalesIconClick();
	}
	
	@Test(priority=155,description="Verified Order Status in Returns page")
	public void step155_VerifiedOrderStatusInReturnsPage() throws Exception
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
	
	@Test(priority=156,description="Click on View option under order grid")
	public void step156_ClickonViewOptioninOrderGrid() throws Exception
	{
		backofficepage.ClickOnOrderGrid(OrderID);
	}
	
	@Test(priority=157,description="Click on Return Items Tab")
	public void step157_ClickOnReturnItems() throws Exception
	{
		backofficepage.ReturnsItemsClick();	
	}
	
	@Test(priority=158,description="Entered Approved value in Approved Field under RMA Items Requested for Grid")
	public void step158_EnterValueInApprovedField() throws Exception
	{
		backofficepage.EnterValueInApprovedField("1");
	}
	
	@Test(priority=159,description="Select Approved option from Status Dropdown")
	public void step159_SelectApprovedOptionFromStatusDropdown() throws Exception
	{
		backofficepage.SelectApprovedOptionFromStatusDropdown();
	}
	
	@Test(priority=160,description="Click on Save Button")
	public void step160_ClickOnSaveButton() throws Exception
	{
		backofficepage.ClickOnSaveButton();
	}
	
	@Test(priority=161,description="Verify Success Msg For RMA Request after submit returns")
	public void step161_VerifySuccessMsgForSavedRMARequest() throws Exception
	{
		backofficepage.VerifySuccessMsgForSavedRMARequest();
	}
	
	@Test(priority=162,description="Click on Sales Icon")
	public void step162_ClickOnSalesIcon() throws Exception
	{
		backofficepage.SalesIconClick();
	}
	
	@Test(priority=163,description="Click on Orders text from Sales Icon")
	public void step163_ClickOrderstxtFromSalesIcon() throws Exception
	{
		backofficepage.OrderstxtFromSalesIconClick();
	}
	
	@Test(priority=164,description="Verified Order Status in Orders page")
	public void step164_VerifiedOrderStatusInOrdersPage() throws Exception
	{
		backofficepage.ClearTheFilterInBO(OrderID);
		backofficepage.VerifyOrderStatusInBO_OrdersPage(OrderID);
	    OrderStatus=BackOfficePage.OrderStatus;
	    Assert.assertEquals(TextProp.get().getProperty("WaitingForCreditMemotxt"), OrderStatus);
	    log.info("Successfully Verified Order Status in Orders Page After RMA Approved : " + OrderStatus);
		Reporter.log("<p>Successfully Verified Order Status in Orders Page After RMA Approved: " + OrderStatus);
		backofficepage.Click_viewBtnForPdt();	
	    CustomFun.waitForPageLoaded(backofficepage.driver);
	    backofficepage.driver.findElement(By.xpath("//span[contains(text(),'Comments History')]")).click();
		Thread.sleep(2000);
		ShipmentID=backofficepage.driver.findElement(By.xpath("//span[contains(text(),'Shipment #')]")).getText().replaceAll("[^0-9.]", "");
	}
	
	
	@Test(priority=165,description="Click on Sales Icon")
	public void step165_ClickOnSalesIcon() throws Exception
	{
	backofficepage.SalesIconClick();
	}

	@Test(priority=166,description="Click on Returns link from Sales Tab")
	public void step166_ReturnstxtFromSalesIconClick() throws Exception
	{
	backofficepage.ReturnstxtFromSalesIconClick();
	}
	
	@Test(priority=167,description="Verified Order Status in Returns page")
	public void step167_VerifiedOrderStatusInReturnsPage() throws Exception
	{
		 backofficepage.ClearTheFilterInBOForReturnsOrder(OrderID);
         backofficepage.VerifyReturnsStatusInBO_ReturnsPage(OrderID);
	OrderStatus=BackOfficePage.RMAIDStatus;
	Assert.assertEquals(TextProp.get().getProperty("Approvedtxt"), OrderStatus);
	log.info("Successfully Verified Order Status in Returns Page After RMA Approved : " + OrderStatus);
	Reporter.log("<p>Successfully Verified Order Status in Returns Page After RMA Approved : " + OrderStatus);
	}
	
	@Test(priority=168,description="Click on View option under order grid")
	public void step168_ClickonViewOptioninOrderGrid() throws Exception
	{
	backofficepage.ClickOnOrderGrid(OrderID);
	}
	
	@Test(priority=169,description="Click On Refund/Exchange Button in Order Details Page")
	public void step169_ClickOnRefundOrExchangeButton() throws Exception
	{
		backofficepage.ClickOnRefundOrExchangeButton();	
		String[] NewMemoID=backofficepage.driver.findElement(By.xpath("//h1")).getText().split(" ");
		RefundMemoID=NewMemoID[3];
	}
	
	@Test(priority=170,description="Verified Order Return Details In New Memo Page")
	public void step170_VerifyOrderReturnDetailsInNewMemoPage() throws Exception
	{
		backofficepage.VerifyOrderReturnDetailsInNewMemoPage();	
		backofficepage.VerifyGrandTotalAndOrderToralInNewMemopage();
	}
	
	@Test(priority=171,description="Scroll down till Refund offline button in New Memo Page & Click on Refund ofline Button")
	public void step171_ClickOnRefundOfflineButtonInNewMemoPage() throws Exception
	{
		backofficepage.Click_RefundOfflineBtnForRMA();
	}
	
	@Test(priority=172,description="Verify Success Msg For Create Credit Memo after Refund created")
	public void step172_VerifySuccessMsgForCreateCreditMemo() throws Exception
	{
		backofficepage.VerifySuccessMsgForCreateCreditMemo();
	}
	
	@Test(priority=174,description="Navigated back to Adyen and click on payment tab ")
	public void step174_NavigatedIntoAdyenAndClickOnPaymentTab() throws Exception
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

	@Test(priority=175,description="Verify order total amount in Adyen ")
	public void step175_VerifyOrderTotalAmtIN_adyen() throws Exception
	{
	adyenpage.Verify_AdyenOrderAmount(OrderID, OrderPrice);
	}  
	
	@Test(description="Navigated Into FO and Verified Order Status in My Orders page", priority=175)
   	public void step176_NaviagtedIntoFOAndVerifiedOrderStatusInMyOrdersPage() throws Exception
   	{
   		CustomFun.SwitchToSpecificTab(homepage.driver, "0");
   		homepage.clickMyaccountBtn();
   		CustomFun.waitForPageLoaded(homepage.driver);
   		myaccountpage=new MyAccountPage(homepage.driver);
   		myaccountpage.MyOrders_LnkClick();
   		CustomFun.waitForPageLoaded(homepage.driver);
   		myaccountpage.VerifyOrderStatus(OrderID);
   	 }  
		
	@Test(priority=177,description="Navigated Into Magento and click on Add products By SKU CTA ")
	public void step177_NavigatedIntoMangetoAndClickAddPctsBySKU() throws Exception
	{
	CustomFun.SwitchToSpecificTab(backofficepage.driver, "2");
	backofficepage.Click_AddProductsBySKUBtnForRMA();
	}
	
	@Test(priority=178,description="Enter SKU ID in the field  ")
	public void step178_EnterSKUIDINAddPctsBySKUFld() throws Exception
	{
	backofficepage.EnterSKUID_InFld();
	}
	
	@Test(priority=179,description="Enter Quantity in the field  ")
	public void step179_EnterQutyINAddPctsByQTYFld() throws Exception
	{
	backofficepage.EnterQTY_InFld();
	}
	
	@Test(priority=180,description=" Click on Add to order btn ")
	public void step180_ClickOnAddToOrderBtn() throws Exception
	{
	backofficepage.Click_AddToOrderBtnForRefundoffline();
	}
	
	@Test(priority=181,description=" Verify_Address Details in  BO from RMA ")
	public void step181_Verify_AddressDetails_BOInRMA() throws Exception
	{
	backofficepage.Verify_AddressDetails_BOInRMA();
	}
	
	@Test(priority=182,description=" Click On Exchange Payment Radio Btn in  BO from RMA ")
	public void step182_ClickOnExchangePaymentRadioBtn() throws Exception
	{
	backofficepage.ExchangePaymentRadioBtn();
	}
	
	@Test(priority=183,description=" Click On_Shipping Method_Link For Refundoffline in RMA ")
	public void step183_Click_ShippingMethod_LinkForRefundoffline() throws Exception
	{
	backofficepage.Click_ShippingMethod_LinkForRefundoffline();
	}
	
	@Test(priority=184,description=" Verify_ShippingMethods_RadioOption For Refundoffline in RMA ")
	public void step184_Verify_ShippingMethods_RadioOptionForRefundofflineAndClickOnShippingMethod() throws Exception
	{
	backofficepage.Verify_ShippingMethods_RadioOptionForRefundoffline();
	backofficepage.Click_FirstShippingMethod_BtnForRefundoffline();
	}
		
	@Test(priority=185,description=" Verify Order Totals For Refundoffline in RMA ")
	public void step185_Verify_OrderTotals_ForRefundoffline() throws Exception
	{
	backofficepage.Verify_OrderTotals_ForRefundoffline();
	}
	
	@Test(priority=186,description=" Click on Submit Order For Exchange Btn For Refund offline ")
	public void step186_Click_SubmitOrderForExchange_BtnForRefundoffline() throws Exception
	{
	backofficepage.Click_SubmitOrderForExchange_BtnForRefundoffline();
	}
	
	@Test(priority=187,description="  Click on OK from Alert popup  For Exchange Btn For Refund offline ")
	public void step187_Click_OKFromAlertPopupForRefundoffline() throws Exception
	{
	backofficepage.Click_OKFromAlertPopupForRefundoffline();
	}
	
	@Test(priority=188,description=" Verify Success Msg For Created Order For RMA Offline Request ")
	public void step188_VerifySuccessMsgForCreatedOrderForRMAOfflineRequest() throws Exception
	{
	backofficepage.VerifySuccessMsgForCreatedOrderForRMAOfflineRequest();
	}
	
	@Test(priority=189,description=" Verify created order with -1 value  ")
	public void step189_VerifyCreatedOrderInRMAOfflineWithNewVal() throws Exception
	{
	backofficepage.VerifyCreatedOrderInRMAOffline();
	}
		
	@Test(priority=190,description="Refresh the BO page and Verify the order status")
	public void step190_RefreshAndVerifyOrderStatusInOrdersPage() throws Exception
	{
		CustomFun.refreshPage(backofficepage.driver);
		backofficepage.Click_BackBtnForBOPrct();
		
		for (int i = 0; i <=6; i++)
		{
		Thread.sleep(30000);
		CustomFun.refreshPage(backofficepage.driver);
		Thread.sleep(5000);
		backofficepage.driver.findElement(By.xpath("//button[text()='Clear all']")).click();
		  backofficepage.EnterOrderId(BackOfficePage.NewOrderFor_RMAOffline);
		  backofficepage.SearchIconClick();
		backofficepage.VerifyOrderStatusInBO_OrdersPage(BackOfficePage.NewOrderFor_RMAOffline);
		OrderStatus = BackOfficePage.OrderStatus;
		if(OrderStatus.contains(TextProp.get().getProperty("SenttoLogistictxt")))
		{
			Assert.assertEquals(TextProp.get().getProperty("SenttoLogistictxt"), OrderStatus);
			log.info("Successfully Verified Order Status in Magento After created order from RMA offline : " + OrderStatus);
			Reporter.log("<p>Successfully Verified Order Status in Magento After created order from RMA offline: " + OrderStatus);
		break;
		}
		}
	}
		 
	@Test(priority=191,description="Swich to FO Tab & Click on My Account Icon")
	public void step191_SwitchToFOTabAndClickOnMyAccountIcon() throws Exception
	{
	CustomFun.SwitchToSpecificTab(homepage.driver, "0");
	homepage.clickMyaccountBtn();	
	}

	@Test(priority=192,description="Click on My Orders Link")
	public void step192_ClickOnMyOrdersLink() throws Exception
	{
	myaccountpage=new MyAccountPage(backofficepage.driver);
	myaccountpage.MyOrders_LnkClick();	
	}

	@Test(priority=193,description="Verified Order Status in My Orders page")
	public void step193_VerifiedOrderStatusInMyOrdersPage() throws Exception
	{
	myaccountpage.VerifyOrderStatus(BackOfficePage.NewOrderFor_RMAOffline);
	} 
	
	@Test(priority=195,description="Navigated back to Adyen and click on payment tab ")
	public void step195_NavigatedIntoAdyenAndClickOnPaymentTab() throws Exception
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
		    adyenpage.Click_AdyenTransactionTab();
		    adyenpage.Click_AdyenTransactionPaymentTab();
		 }
	 }

	@Test(priority=196,description="Verify order total amount in Adyen ")
	public void step196_VerifyOrderTotalAmtIN_adyen() throws Exception
	{
	adyenpage.Verify_AdyenOrderAmount(OrderID, OrderPrice);
	}

	@Test(description="Verify order status of SentForRefund in Adyen ", priority=197)
    public void step197_VerifyOrderRMAStatusIN_adyen() throws Exception
    {
    	  CustomFun.waitForPageLoaded(backofficepage.driver);
    	  adyenpage.Verify_AdyenOrderIDStatus(OrderID);
    	  OrderStatus=AdyenPage.OrderStatusFromAdyen;
    	  log.info("Successfully Verified Order Status in Adyen Page for sent for refund status: " + OrderStatus);
    	  Reporter.log("<p>Successfully Verified Order Status in Adyen Page  for sent for refund status: " + OrderStatus);
    } 
    
    
    @Test(description="Comparing the Seleable stock in the WMS and the BO Magento after Refund the order", priority=198)
    public void step198_ComparedSeleableStockInWMSAndBOBothAreSameAfterRefundTheOrder() throws Exception
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
    backofficepage.SearchForProductSeleableStockInBO(BarCodeSKU);
    backofficepage.VerifySaleableStockQntyIncBy1InBOAferRefundTheOrder(BarCodeSKU);
   // Assert.assertEquals(BackOfficePage.InitialSaleableStock_BO, WMSPage.InitialSaleableStock_WMS, "Stock in the WMS and the Bo Magento both are same after refund the order");
    } 

  @Test(description="Verify Order Confirmation Mail Contents", priority=199)
  public void step199_VerifyOrderConfirmationMailContents() throws InterruptedException
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


     @Test(description="Verify Shipping Confirmation Mail Contents", priority=200)
     public void step200_VerifyShippingConfirmationMailContents() throws InterruptedException
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

   
  @Test(description="Verify Return Request Confirmation Mail Contents", priority=201)
  public void step201_VerifyReturnRequestConfirmationMailContents() throws InterruptedException
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


   @Test(description="Verify Return Reception Confirmation Mail Contents", priority=202)
   public void step202_VerifyReturnReceptionConfirmationMailContents() throws Exception
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
		Reporter.log("Successfully Verified Return Reception Confirmation Mail & Subject Line : " + Emails.strMailSubject);
		Reporter.log("<p>Successfully Verified Return Reception Confirmation Mail Received Time : " + Emails.strReceivedMailTime);
   }

   @Test(description="Verify Credit Memo Confirmation Mail Contents", priority=203)
   public void step203_VerifyCreditMemoConfirmationMailContents() throws Exception
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

  @Test(description="Verify Order Confirmation Mail for Exchange order Contents", priority=204)
  public void step204_VerifyOrderConfirmationMailContentsForExchangeOrder() throws InterruptedException
  {
	   String EmailID=CustomFun.getUserInfoDSDetails().get().getEmailDomain();
	   String Password=CustomFun.getUserInfoDSDetails().get().getAppPassword();
		if(locale.get().contains("FR_FR"))
		{
		    Emails.verifyEmailSubjectLine(""+EmailID+""+":"+""+Password+"","Christian Louboutin Europe Online Boutique: Nouvelle commande # "+BackOfficePage.NewOrderFor_RMAOffline);
		}
		else
		if(locale.get().contains("UK_EN"))
	    {
			Emails.verifyEmailSubjectLine("" + EmailID + "" + ":" + "" + Password + "", 
					"Christian Louboutin Europe Online Boutique: New order # "+BackOfficePage.NewOrderFor_RMAOffline);
		}
		else
		{
			Emails.verifyEmailSubjectLine("" + EmailID + "" + ":" + "" + Password + "", 
					"Christian Louboutin Europe Online Boutique: New order # "+BackOfficePage.NewOrderFor_RMAOffline);
		}
		Reporter.log("Successfully Verified Refund Confirmation Mail & Subject Line : " + Emails.strMailSubject);
		Reporter.log("<p>Successfully Verified Refund Confirmation Mail Received Time : " + Emails.strReceivedMailTime);	
  }     
  
}
