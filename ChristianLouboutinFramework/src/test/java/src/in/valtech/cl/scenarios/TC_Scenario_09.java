package src.in.valtech.cl.scenarios;
import static src.in.valtech.util.PropertyFileReader.ObjRepoProp;     
import static src.in.valtech.util.PropertyFileReader.TextProp;

import java.time.Duration;

import org.apache.log4j.Logger;

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
 * 
 * @author Gopalaswamy.M
 *
 */

public class TC_Scenario_09 extends BaseTest
{
	public Logger log = Logger.getLogger(this.getClass().getName());
	public String OrderID;
	public String OrderStatus; 
	public static String RMAID;
	public String RefundMemoID;
	public String RMA_ID_FO; 
	public static String RMAIDStatus;
	public static String CreatedRMAOrderID_FromOffline;
	public String ShipmentID;
	public static String ref_searchable_SKUID;
	public static String BarCodeSKU;
	public String BarCodeForScan;
	
	HomePage homepage;
	MyAccountPage myaccountpage;
	BackOfficePage backofficepage;
	CategoryLandingPage categorylandingpage;
	ProductListingPage productlistingpage;
	ProductDetailsPage productdetailspage;
	CheckoutPage checkoutpage;
	ShippingAddressPage shippingaddresspage;
	CartPage cartpage;
	PaymentPage paymentpage;
	OrderConfirmationPage orderconfirmationpage;
	WMSPage wmspage;

	@Test(description="Navigated to CL Home Page")
	public void step01_NavigatedtoCLHomePage() throws Exception
	{
    logtest("Create an RMA and an exchange for the same order with 3DS credit card.");
	System.out.println("Entry to the script ");
	System.out.println("The base url "+ baseUrl.get());
	homepage=HomePage.navigateToCLApplication_URL(driver.get(), baseUrl.get());
	log.info("Successfully navigated to application URL");
	Reporter.log("<p>Successfully navigated to application URL");
	}
	
	@Test(priority=2, description="Mouseover on L1 Category")
	public void step02_MouseoverOnL1Category() throws Exception
	{
		if(locale.get().contains("FR_FR") | bsValue.get().contains("YES") | locale.get().contains("CH_FR") | locale.get().contains("UK_EN") | environmentName.contains("IntegrationEnv") | environmentName.equals("HomoEnv"))
		{
			for (int i = 0; i <= 1; i++)
			{
				Thread.sleep(2000);
				CustomFun.refreshPage(homepage.driver);
				Thread.sleep(2000);
			}
			GUIFunctions.pageScrollToTopOfPage(homepage.driver);
			homepage.mousehoverOnLadiesHeaderNavigation();
		}
		else
		{
		  GUIFunctions.pageScrollToTopOfPage(homepage.driver);
		  homepage.mousehoverOnLadiesHeaderNavigation();
		}
	}
	
	@Test(description="Click on L3 Kate Category under L1 Ladies Category", priority=3)
	public void step03_ClickOnL3KateLadiesCategory() throws Exception
	{
		categorylandingpage=new CategoryLandingPage(homepage.driver);
		// Any L3 Category can be taken as a test data
		if(environmentName.contains("IntegrationEnv"))	
		{
			homepage.ClickOnL2HotChickCategory();
		}
		else
		{
			categorylandingpage.ladiesL3KateCategoryClick();
		}
		log.info("Successfully mouse over on L3 Kate Category under L1 Ladies Category");
		Reporter.log("<p>Successfully mouse over on L3 Kate Category under L1 Ladies Category");
	}
	
	@Test(description="Click on Product Image", priority=4)
	public void step04_ClickOnProductImg() throws Exception
	{
		categorylandingpage.Click_ProductImg();
		productlistingpage=new ProductListingPage(categorylandingpage.driver);
	}
	
	@Test(description="Verified Product Name in Product Details Page", priority=5)
	public void step05_VerifiedProductNameinPDP() throws Exception
	{
		productdetailspage=new ProductDetailsPage(productlistingpage.driver);
		productdetailspage.VerifyProductNametxtInPDP();
	}
	
	@Test(description="Verified Product Brand Name & Product Price in Product Details Page", priority=6)
	public void step06_VerifiedProductBrandNameAndProductPriceinPDP() throws Exception
	{
		productdetailspage.VerifyProductBrandNametxtInPDP();
		productdetailspage.VerifyProductPricetxtInPDP();
	}
	
	@Test(description="Verified Wishlist Icon in Product Details Page", priority=7)
	public void step07_VerifiedWishlistIconinPDP() throws Exception
	{
		productdetailspage.VerifyWishlistIconInPDP();
	}
	
	@Test(description="Click on In_store_availability button and close overlay", priority=8)
	public void step08_ClickOnInStoreAvailabilityButtonAndCloseOverlay() throws Exception
	{
		productdetailspage.ClickonInStoreAvailabilitybtnAndCloseOverlayInPDP();
	}

	@Test(description="Verified Contact Us link & Colour Swatches in Product Details Page", priority=9)
	public void step9_VerifiedContactUslinkAndColourSwatchesInPDP() throws Exception
	{
		productdetailspage.pdpSizeguideInfo();
		productdetailspage.VerifyContactUsLinkInPDP();
		productdetailspage.pdpColorSwatches();
		productdetailspage.ClickOnSelectYourSizeBtnAndSelectAnySizeInPDP();
		productdetailspage.pdpNotification_Closebtn();
	}
	
	@Test(description="Click on Product Info and Verified content under Product Info section", priority=10)
	public void step10_ClickonProductInfoAndVerifiedContent() throws Exception
	{
		productdetailspage.pdpProductInfoBlock();
	}
	
	@Test(description="Click on Product Care and Verified content under Product Care section", priority=11)
	public void step11_ClickonProductCareAndVerifiedContent() throws Exception
	{
		productdetailspage.pdpProductCareBlock();
	}
	
	@Test(description="Click on Shipping, verified content under Shipping section & Verify PDP main and thumbnail image", priority=12)
	public void step12_ClickonShippingAndVerifiedContent() throws Exception
	{
		productdetailspage.pdpShippingBlock();
		productdetailspage.pdpMainimage();
	}
	
	@Test(description="Click on Add To Cart Button", priority=13)
	public void step13_ClickonAddToCartButton() throws Exception
	{
		productdetailspage.pdpAddtoCartbtn();
	}
	
	@Test(description="Verified Content in Confirmation Overlay", priority=14)
	public void step14_VerifiedContentInConfirmationOverlay() throws Exception
	{
		productdetailspage.pdpProductadd_Notification();
	}
	
	@Test(description="Click on 'your cart' link from confirmation pop up", priority=15)
	public void step15_ClickonYourCartLinkInConfirmationOverlay() throws Exception
	{
		productdetailspage.driver.findElement(By.xpath(ObjRepoProp.get().getProperty("MiniCP_YourCart_txt"))).click();
		CustomFun.waitForPageLoaded(productdetailspage.driver);
		log.info("Successfully Clicked on Your Cart link from Confirmation pop up");
		Reporter.log("<p>Successfully Clicked on Your Cart link from Confirmation pop up");
	}

	@Test(description="Verified My Cart Header in My Cart Page", priority=16)
	public void step16_VerifiedMyCartHeaderInMCP() throws Exception
	{
		cartpage=new CartPage(productdetailspage.driver);
		cartpage.VerifyMyCartHeaderHeader();
	}
	
	@Test(description="Click on Proceed To Check Button in My Cart Page", priority=17)
	public void step17_ClickonProceedToCheckOutButtonInMyCart() throws Exception
	{
		cartpage.driver.findElement(By.xpath(ObjRepoProp.get().getProperty("MainCP_ProceedToCheck_btn"))).click();
		CustomFun.waitForPageLoaded(cartpage.driver);
		log.info("Successfully Clicked on Proceed To Check Button in My Cart Page");
		Reporter.log("<p>Successfully Clicked on Proceed To Check Button in My Cart Page");
	}
	
	@Test(description="Verified Login page of checkout step1 ", priority=18)
	public void step18_VerifiedLoginPageOfCheckoutStep1() throws Exception
	{
		checkoutpage=new CheckoutPage(cartpage.driver);
		checkoutpage.VerifyLoginHeadertxt_AsGU();
	}
	
	@Test(description="Entered Email in Address Email Field", priority=19)
	public void step19_EnteredEmailField() throws Exception
	{
		checkoutpage.EnterEmailAddress_asGU(CustomFun.getUserInfoDSDetails().get().getEmailDomain());
	}
	
	@Test(description="Entered Password in Password Field", priority=20)
	public void step20_EnteredPasswordField() throws Exception
	{
		checkoutpage.EnterPassword_asGU(CustomFun.getUserInfoDSDetails().get().getPassword());
	}
	
	@Test(description="Click on SignIn Button, Verify Gift Section", priority=21)
	public void step21_ClickOnSignInButtonAndVerifyGiftSection() throws Exception
	{
		checkoutpage.LoginBtnClick_AsGU();
		CustomFun.waitForPageLoaded(checkoutpage.driver);
		homepage.VerifyLoginSuccessMsg();
		checkoutpage.VerifyGiftHeadertxt();
		checkoutpage.VerifyNoWarpImgIsSelected();
	}
	
	@Test(description="Entered Gift text, Click on Update Button & Verified Shipping Address Header in Checkout Page", priority=22)
	public void step22_EnterMsgInGiftMsgFld() throws Exception
	{
		checkoutpage.ScrollDowntillYourMsgField_EnterMsg("test");
		checkoutpage.UpdatebtnClick();
	}
	@Test(description = "Mouse Over on Ladies L1 Category", priority = 23)
	public void step23_MouseOverElementOnLadiesL1Category() throws Exception
	{
		GUIFunctions.RemoveExistProductsFromMyCartIconAsGU(homepage.driver);
		CustomFun.refreshPage(homepage.driver);
		CustomFun.waitForPageLoaded(homepage.driver);
		categorylandingpage = new CategoryLandingPage(homepage.driver);
		categorylandingpage.mouseOverCategory();
	}

	@Test(description = "Click on L2 Accessoires Category under L1 Ladies Category", priority = 24)
	public void step24_ClickOnL2AccessoiresLadiesCategory() throws Exception {
		// Any L2 Category can be taken as a test data
		categorylandingpage.driver.findElement(By.xpath("//a[contains(@id,'cat')]//span[contains(text(),'Accesso')]"))
				.click();
	}
	
	@Test(description = "Applied Color Filter", priority = 25)
	public void step25_AppliedColorFilter() throws Exception
	{
		productlistingpage = new ProductListingPage(categorylandingpage.driver);
		productlistingpage.ClickOnSeeAlllink();
		if(environmentName.contains("HomoEnv"))
		{
		    productlistingpage.ClickOnSimpleProductImgFromCategory();
		}
		else
		if(environmentName.contains("IntegrationEnv"))
		{
			if(locale.get().contains("FR_FR"))
			{
		       productlistingpage.Click_ProductImg();
			}
			else
			{
				productlistingpage.Click_ProductImg3();
			}
		}
		else
		if(environmentName.contains("StagingEnv"))
		{
		if(locale.get().contains("FR_FR") | locale.get().contains("CH_FR"))
		{
		    productlistingpage.Click_ProductImg();
		}
		else
		{
		    productlistingpage.ClickOnProductImg2();
		}
		}
	}
	
	@Test(description="Click on Add To Cart Button", priority=26)
	public void step26_ClickonAddToCartButton() throws Exception
	{
		productdetailspage.VerifyContactUsLinkInPDP();
		//productdetailspage.pdpColorSwatches();
		productdetailspage.pdpProductInfoBlockForSimpleProd();
		ref_searchable_SKUID=ProductDetailsPage.Ref_searchable_sku_SimpleProd;
		productdetailspage.pdpAddtoCartbtn();
	}
	
	@Test(description="Verified Content in Confirmation Overlay", priority=27)
	public void step27_VerifiedContentInConfirmationOverlay() throws Exception
	{
		productdetailspage.pdpProductadd_Notification();
	}
	
	@Test(description="Click on 'your cart' link from confirmation pop up", priority=28)
	public void step28_ClickonYourCartLinkInConfirmationOverlay() throws Exception
	{
		productdetailspage.driver.findElement(By.xpath(ObjRepoProp.get().getProperty("MiniCP_YourCart_txt"))).click();
		log.info("Successfully Clicked on Your Cart link from Confirmation pop up");
		Reporter.log("<p>Successfully Clicked on Your Cart link from Confirmation pop up");
	}

	@Test(description="Verified My Cart Header & Click on increase qty(+) icon of product present in My Cart Page", priority=29)
	public void step29_VerifiedMyCartHeaderInMCP() throws Exception
	{
		cartpage=new CartPage(productdetailspage.driver);
		cartpage.VerifyMyCartHeaderHeader();
		cartpage.Click_ON_IncrQuantity_Maincart();
		CustomFun.waitForPageLoaded(cartpage.driver);
	}
	
	@Test(description="Click on Proceed To Check Button in My Cart Page", priority=30)
	public void step30_ClickonProceedToCheckOutButtonInMyCart() throws Exception
	{
		cartpage.driver.findElement(By.xpath(ObjRepoProp.get().getProperty("MainCP_ProceedToCheck_btn"))).click();
		log.info("Successfully Clicked on Proceed To Check Button in My Cart Page");
		Reporter.log("<p>Successfully Clicked on Proceed To Check Button in My Cart Page");
	}
	
	@Test(description="Verify Gift Section in Checkout Page", priority=31)
	public void step31_VerifiedGiftSectionHeaderInCP() throws Exception
	{
		Thread.sleep(2000);
		checkoutpage.VerifyGiftHeadertxt();
		checkoutpage.VerifyNoWarpImgIsSelected();
		checkoutpage.ScrollDowntillYourMsgField_EnterMsg("test");
		checkoutpage.UpdatebtnClick();
		shippingaddresspage=new ShippingAddressPage(checkoutpage.driver);
		shippingaddresspage.VerifyShippingAddressHeader();
	}
	
	@Test(description="Verified Product Name under Order summary in Checkout Page at Shipping Address Section", priority=32)
	public void step32_VerifiedProductNameinPDP() throws Exception
	{
		checkoutpage.VerifyProductNametxtInCP();
	}
	
	@Test(description="Verified Product Price under order summary in Checkout Page at Shipping Address Section", priority=33)
	public void step33_VerifiedProductPriceinPDP() throws Exception
	{
		checkoutpage.VerifyProductPricetxtInCP();
	}
	

	@Test(description = "Open New Tab and Navigated to WMS", priority = 37)
	public void step37_OpenNewTabAndNavigatedtoWMS() throws Exception {
		wmspage = new WMSPage(productdetailspage.driver);
		CustomFun.OpenNewTabAndSwitchToNewTab(wmspage.driver, "1");
		wmspage.driver.navigate().to(CustomFun.getWMSInfoDSDetails().get().getWMSURL());
	}

	@Test(description = "Logged into WMS with valid crendentials", priority = 38)
	public void step38_LoggedIntoWMS() throws Exception {
		wmspage.WMSLogIn(CustomFun.getWMSInfoDSDetails().get().getWmsUsername(),
				CustomFun.getWMSInfoDSDetails().get().getWmsPassword());
	}

	@Test(description = "Click on OK button in WMS", priority = 39)
	public void step39_ClickOnOKbutton() throws Exception {
		wmspage.Click_WMSOKBtn();
	}

	@Test(description = "Mouse Over on Data Lists Menu", priority = 40)
	public void step40_MouseOverElementOnDataListsMenu() throws Exception {
		wmspage.WMS_Datalistmenu();
	}

	@Test(description = "Click on Products from Data Lists", priority = 41)
	public void step41_ClickOnProductsFromDataLists() throws Exception {
		wmspage.WMS_Datalist_Productclick();
	}

	@Test(description = "Enter Searchable SKU & Click on Submit Filter", priority = 42)
	public void step42_EnterSearchableSKUAndClickOnSubmitFilter() throws Exception {
		wmspage.SearchSKUIDInListOfProductsForSimpleProd(ref_searchable_SKUID);
		BarCodeSKU=WMSPage.barcodeSKU;
	}

	@Test(description = "Click on Details Button", priority = 43)
	public void step43_ClickOnDetailsButtonForSimpleProd() throws Exception {
		wmspage.ClickOnDetailsButtonForSimpleProd(ref_searchable_SKUID);
	}

	@Test(description = "Scroll down till stocks grid and Verify Initial Saleable Stock", priority = 44)
	public void step44_VerifyInitialSaleableStock() throws Exception {
		wmspage.VerifyInitialSaleableStock();
	}

	@Test(description = "Verify Reserved Stock", priority = 45)
	public void step45_VerifyReservedStock() throws Exception {
		wmspage.VerifyInitialReservedStock();
	}

	@Test(description = "Open New Tab and Navigated to Magento BO", priority = 46)
	public void step46_OpenNewTabAndNavigatedtoMagentoBO() throws Exception {
		backofficepage = new BackOfficePage(homepage.driver);
		CustomFun.OpenNewTabAndSwitchToNewTab(backofficepage.driver, "2");
		backofficepage.driver.navigate().to(CustomFun.getBODSDetails().get().getBO_URL());
	}

	@Test(description = "Entered Username in Username Field", priority = 47)
	public void step47_EnteredUsernameField() throws Exception {
		backofficepage.EnterUsername(CustomFun.getBODSDetails().get().getBO_Username());
	}

	@Test(description = "Entered Password in Password Field", priority = 48)
	public void step48_EnteredPasswordField() throws Exception {
		backofficepage.EnterPassword(CustomFun.getBODSDetails().get().getBO_Password());
	}

	@Test(description = "Click on SignIn Button", priority = 49)
	public void step49_ClickOnSignInButton() throws Exception {
		backofficepage.SignbtnClick();
		if(environmentName.contains("IntegrationEnv") | environmentName.contains("HomoEnv1") | environmentName.contains("StagingEnv") | environmentName.contains("Integration6Env"))
	    {
			Thread.sleep(5000);
			CustomFun.refreshPage(backofficepage.driver);
			Thread.sleep(5000);
		}
	}

	@Test(description = "Verified Dashboard Header & check whether user is in Dashboard page", priority = 50)
	public void step50_VerifiedDashboardHeaderInBO() throws Exception {
		CustomFun.waitForPageLoaded(backofficepage.driver);
		backofficepage.VerifyDashboardHeader();
	}

	@Test(description = "Click on Catalog Icon", priority = 51)
	public void step51_ClickOnCatalogIcon() throws Exception {
		backofficepage.CatalogIconClick();
	}

	@Test(description = "Click on Products text from Catalog Icon", priority = 52)
	public void step52_ClickProductstxtFromCatalogIcon() throws Exception {
		backofficepage.ProductstxtFromCatalogIconClick();
	}

	@Test(description = "Search For Product Seleable Stock In BO", priority = 53)
	public void step53_SearchForProductSeleableStockInBO() throws Exception {
        backofficepage.SearchForProductSeleableStockInBO(BarCodeSKU);
	}

	@Test(description = "Verify Initial Saleable Stock", priority = 54)
	public void step54_VerifyInitialSaleableStock() throws Exception {
		backofficepage.VerifyInitialSaleableStockInBO(BarCodeSKU);
	}  
	
	@Test(description="Navigated Into FO & Verified Shipping Method Section", priority=55)
	public void step55_NavigatedIntoFOAndVerifiedShippingMethodSectionInCP() throws Exception
	{
	    CustomFun.SwitchToSpecificTab(homepage.driver, "0");
		shippingaddresspage=new ShippingAddressPage(homepage.driver);
		shippingaddresspage.VerifyShippingMethodLabel();
		checkoutpage.UpdatebtnClick();
	}
	
	@Test(description="Click on First Shipping Method radio button in Checkout page", priority=56)
	public void step56_ClickOnFirstShipMethodRadioButton() throws Exception
	{
		shippingaddresspage.VerifyAndClickOnSecondShippingmethod();
	}
	
	@Test(description="Click on Continue To Payemnt button in Checkout page", priority=57)
	public void step57_ClickOnContinueToPayemntButton() throws Exception
	{
		shippingaddresspage.ContinuetopaymentbtnClick();
	}
	
	@Test(description="Scroll down till Payment options and Verified Payment options in Checkout Page", priority=58)
	public void step58_VerifiedPaymentoptions() throws Exception
	{
		paymentpage=new PaymentPage(shippingaddresspage.driver);
		paymentpage.checkout_Paymentoptions();
	}
	
	@Test(description="Click on Credit card Radio button under Payment option", priority=59)
	public void step59_ClickOnCreditCardRadioBtn() throws Exception
	{
		paymentpage.checkout_Creditcard();
	}
	
	@Test(description="Verified My billing and shipping address are the same checkbox is auto selected", priority=60)
	public void step60_VerifiedMyBAandSABothSame_CheckboxIsAutoSelected() throws Exception
	{
		
	}

	@Test(description="Entered Credit Number in Credit Number Field", priority=61)
	public void step61_EnteredCreditNumberField() throws Exception
	{
		paymentpage.checkout_CCCardnumber(CustomFun.getPaymentDSDetails().get().getCardNumber());
	}
		
	@Test(description="Entered Expiry Date in Expiry Date Field", priority=62)
	public void step62_EnteredExpiryDateField() throws Exception
	{
		paymentpage.checkout_CCExpirydate(CustomFun.getPaymentDSDetails().get().getCardExpiryDate());
	}
	
	@Test(description="Entered CVV in CVV Field", priority=63)
	public void step63_EnteredCVVField() throws Exception
	{
		paymentpage.checkout_CCV(CustomFun.getPaymentDSDetails().get().getCardCVV());
	}	
	
	@Test(description="Entered CardHolder Name in CardHolder Name Field", priority=64)
	public void step64_EnteredCardHolderField() throws Exception
	{
		paymentpage.checkout_Cardholdername(CustomFun.getPaymentDSDetails().get().getCardHolderName());
	}
	
	@Test(description="Checked on Privacy Policy and Return Policy checkbox", priority=65)
	public void step65_CheckedOnPrivacyPolicyAndReturnPolicyCheckbox() throws Exception
	{
			paymentpage.checkout_Agreements_CreditCard();
	}
	
	@Test(description = "Click on Proceed button in Checkout page at Payment Section & Entered 3DS Credentials", priority = 66)
	public void step66_ClickOnProceedButtonAndEntered3DSCredentials() throws Exception {
		  if(environmentName.contains("IntegrationEnv"))
		  {
			  paymentpage.driver.findElement(By.xpath("(//button[contains(@class,'action primary checkout')])[1]")).click();
			  Thread.sleep(1000);
		  }
		  else
		  {
			  paymentpage.checkout_CC_ProceedbtnForCreditCard();
		  }
		    CustomFun.waitForPageLoaded(paymentpage.driver);
			//paymentpage.checkout_3DSUsername(CustomFun.getPaymentDSDetails().get().get3DS_Username());
			paymentpage.checkout_3DSPassword(CustomFun.getPaymentDSDetails().get().get3DS_Password());
			paymentpage.checkout_ClickOnSubmitButton();
			CustomFun.waitForPageLoaded(paymentpage.driver); 
	}
	
	@Test(description="Verified Success Message in Order Confirmation page after placing the order", priority=67)
	public void step67_VerifiedSuccessMsgAfterPlacingOrder() throws Exception
	{
		orderconfirmationpage=new OrderConfirmationPage(paymentpage.driver);
		orderconfirmationpage.Verify_SuccessOrder_Msg_txt();
	}
	
	@Test(description="Verified Continue Shopping Button in Order Confirmation page", priority=68)
	public void step68_VerifiedContinueShoppingButton() throws Exception
	{
		orderconfirmationpage.VerifyContinueShopping_Btn();
	}
	
	@Test(description="Verified Your OrderID in Order Confirmation page", priority=69)
	public void step69_VerifiedYourOrderID() throws Exception
	{
		orderconfirmationpage.VerifyOrderIDInOCP();
	}
	
	@Test(description="Initialised OrderID in OrderID variable for further execution", priority=70)
	public void step70_InitialisedOrderID() throws Exception
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
	
	@Test(description="Navigated back into BO & Click on Sales Icon", priority=71)
	public void step71_NavigatedBackIntoBOClickOnSalesIcon() throws Exception
	{
		CustomFun.SwitchToSpecificTab(backofficepage.driver, "2");
		backofficepage.SalesIconClick();
	}
	
	@Test(description="Click on Orders text from Sales Icon", priority=72)
	public void step72_ClickOrderstxtFromSalesIcon() throws Exception
	{
		backofficepage.OrderstxtFromSalesIconClick();
	}
	
	@Test(description="Verified Orders Header & check whether user is in Orders page", priority=73)
	public void step73_VerifiedOrdersHeaderInBO() throws Exception
	{
		backofficepage.VerifyOrdersHeadertxt();
	}
	
	@Test(description="Verified Order Status in Orders page", priority=74)
	public void step74_VerifiedOrderStatusInOrdersPage() throws Exception
	{
		CustomFun.waitObjectToLoad(backofficepage.driver, By.xpath(ObjRepoProp.get().getProperty("ClearAllLink_xpath")),Duration.ofSeconds(10));
		if(!backofficepage.driver.findElement(By.xpath(ObjRepoProp.get().getProperty("ClearAllLink_xpath"))).isDisplayed())
		{
			backofficepage.driver.findElement(By.xpath(ObjRepoProp.get().getProperty("FulltextField_xpath"))).sendKeys(OrderID);
			CustomFun.waitObjectToLoad(backofficepage.driver, By.xpath(ObjRepoProp.get().getProperty("SearchIcon_xpath")),Duration.ofSeconds(10));
			backofficepage.driver.findElement(By.xpath(ObjRepoProp.get().getProperty("SearchIcon_xpath"))).click();
			backofficepage.VerifyOrderStatusInBO_OrdersPage(OrderID);
		}
		else
		{
		  backofficepage.driver.findElement(By.xpath(ObjRepoProp.get().getProperty("ClearAllLink_xpath"))).click();
		  CustomFun.waitForPageLoaded(backofficepage.driver);
		  CustomFun.waitObjectToLoad(backofficepage.driver, By.xpath(ObjRepoProp.get().getProperty("FulltextField_xpath")),Duration.ofSeconds(10));
		  backofficepage.driver.findElement(By.xpath(ObjRepoProp.get().getProperty("FulltextField_xpath"))).sendKeys(OrderID);
		  CustomFun.waitObjectToLoad(backofficepage.driver, By.xpath(ObjRepoProp.get().getProperty("SearchIcon_xpath")),Duration.ofSeconds(10));
		  backofficepage.driver.findElement(By.xpath(ObjRepoProp.get().getProperty("SearchIcon_xpath"))).click();
		  backofficepage.VerifyOrderStatusInBO_OrdersPage(OrderID);
		}
		
    	for(int i=0;i<=10;i++)
		{
		  Thread.sleep(60000);
		  CustomFun.refreshPage(backofficepage.driver);
		  Thread.sleep(5000);
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
	
	@Test(description="Switch back to FO & Click on My Account Icon", priority=75)
	public void step75_ClickOnMyAccountIcon() throws Exception
	{
		CustomFun.SwitchToSpecificTab(homepage.driver, "0");
		homepage.driver.findElement(By.xpath(ObjRepoProp.get().getProperty("HP_MyAccount_Icon"))).click();
		CustomFun.waitForPageLoaded(homepage.driver);
	}
	
	@Test(description="Click on My Orders Link", priority=76)
	public void step76_ClickOnMyOrdersLink() throws Exception
	{
		myaccountpage=new MyAccountPage(homepage.driver);
		myaccountpage.MyOrders_LnkClick();
		CustomFun.waitForPageLoaded(myaccountpage.driver);
	}
	
	@Test(description="Verified Order Status & Other Details in My Orders page", priority=77)
	public void step77_VerifiedOrderStatusInMyOrdersPage() throws Exception
	{
		myaccountpage.VerifyOrderStatus(OrderID);
		myaccountpage.VerifyOrderPriceInOrderspage(OrderID);
        myaccountpage.VerifyOrderItemInOrderspage(OrderID);
		myaccountpage.VerifyOrderDateInOrderspage(OrderID);
		if(locale.get().contains("FR_FR") | locale.get().contains("CH_FR"))
		{
		myaccountpage.VerifyOrderStatus(OrderID);
		Assert.assertEquals(MyAccountPage.OrderStatusFromFO,TextProp.get().getProperty("OrderInPreparationtxt_FR"));
		}
		else
		{
	    myaccountpage.VerifyOrderStatus(OrderID);
		Assert.assertEquals(MyAccountPage.OrderStatusFromFO,TextProp.get().getProperty("Processingtxt_UK"));	
		}
	}
	
	@Test(description = "Verified Seleable Stock Quantity Decremented By 1", priority = 79)
	public void step79_VerifiedSaleableStockQntyDecBy1InBOAferPlacingTheOrder() throws Exception {
		CustomFun.SwitchToSpecificTab(backofficepage.driver, "2");
		backofficepage.CatalogIconClick();
		backofficepage.ProductstxtFromCatalogIconClick();
		backofficepage.SearchForProductSeleableStockInBO(BarCodeSKU);
		backofficepage.VerifySaleableStockQntyDecBy1InBOAferPlacingTheOrder(BarCodeSKU);
	}

	@Test(description = "Navigated Into WMS and Verified Seleable Stock Quantity Decremented By 1", priority = 80)
	public void step80_VerifySaleableStockDecBy1InWMSAferPlacingTheOrder() throws Exception {
		CustomFun.SwitchToSpecificTab(wmspage.driver, "1");
		CustomFun.refreshPage(wmspage.driver);
		CustomFun.waitForPageLoaded(wmspage.driver);
		wmspage.ClickOnDetailsButtonForSimpleProd(ref_searchable_SKUID);
		wmspage.VerifySaleableStockDecBy1InWMSAferPlacingTheOrder();
	}

	@Test(description = "Comparing the Seleable stock in the WMS and the BO Magento", priority = 81)
	public void step81_ComparedSeleableStockInWMSAndBOBothAreSame() throws Exception {
		CustomFun.SwitchToSpecificTab(wmspage.driver, "1");
		CustomFun.refreshPage(wmspage.driver);
		CustomFun.waitForPageLoaded(wmspage.driver);
		wmspage.VerifyInitialSaleableStock();
		CustomFun.SwitchToSpecificTab(backofficepage.driver, "2");
		backofficepage.CatalogIconClick();
		backofficepage.ProductstxtFromCatalogIconClick();
		backofficepage.SearchForProductSeleableStockInBO(BarCodeSKU);
		backofficepage.VerifyInitialSaleableStockInBO(BarCodeSKU);
	//	Assert.assertEquals(BackOfficePage.InitialSaleableStock_BO, WMSPage.InitialSaleableStock_WMS);
	}
	
	@Test(description="Picking Order Process", priority=82)
	public void step82_PickingOrderProcess() throws Exception
	{
		CustomFun.SwitchToSpecificTab(wmspage.driver, "1");
		wmspage.PickingOrderProcess(OrderID);
	}
	
	@Test(description="Verified Picking order for # XXXXX", priority=83)
	public void step83_VerifiedPickingOrderSuccessMsg() throws Exception
	{
		wmspage.VerifyPickingOrderSuccessMsg();
	}
	
	@Test(description="Navigated Into Magento and Verified Order Status in Orders page", priority=84)
	public void step84_NaviagtedIntoMangetoAndVerifiedOrderStatusInOrdersPage() throws Exception
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
	
	@Test(description="Switch to FO Tab & Click on My Account Icon", priority=85)
	public void step85_SwitchToFOTabAndClickOnMyAccountIcon() throws Exception
	{
		CustomFun.SwitchToSpecificTab(backofficepage.driver, "0");
		homepage.driver.findElement(By.xpath(ObjRepoProp.get().getProperty("HP_MyAccount_Icon"))).click();
		CustomFun.waitForPageLoaded(homepage.driver);
	}
	
	@Test(description="Click on My Orders Link", priority=86)
	public void step86_ClickOnMyOrdersLink() throws Exception
	{
		myaccountpage.MyOrders_LnkClick();
		CustomFun.waitForPageLoaded(myaccountpage.driver);
	}
	
	@Test(description="Verified Order Status in My Orders page", priority=87)
	public void step87_VerifiedOrderStatusInMyOrdersPage() throws Exception
	{
		myaccountpage.VerifyOrderStatus(OrderID);
		if(locale.get().contains("FR_FR") | locale.get().contains("CH_FR"))
		{
		Assert.assertEquals(MyAccountPage.OrderStatusFromFO,TextProp.get().getProperty("OrderInPreparationtxt_FR"));
		}
		else
		{
		Assert.assertEquals(MyAccountPage.OrderStatusFromFO,TextProp.get().getProperty("Processingtxt_UK"));	
		}
	}
	
	@Test(description="Navigated Into WMS and Get BarCode From Picking Process", priority=88)
	public void step88_NavigatedIntoWMSAndGetBarcodeFromPickingProcess() throws Exception
	{
		CustomFun.SwitchToSpecificTab(wmspage.driver, "1");
		wmspage.getBarCodeFromPickingProcess(OrderID);
		BarCodeForScan=WMSPage.BarCodeId;
	}
	
	@Test(description="Navigated Into WMS and Click on Packing Button", priority=89)
	public void step89_NavigatedIntoWMSAndClickOnPackingBtn() throws Exception
	{
		wmspage.Click_WMSPackingBtn();
	}
	
	@Test(description="Entered BarcodeID in Barcode Field And Search For Packing", priority=90)
	public void step90_EnteredBarcodeAndSearchForPacking() throws Exception
	{
		wmspage.EnterBarcodeAndSearchForPacking(BarCodeForScan);
	}
	
	@Test(description="Copy SKUID And Enter in Search Field For Scanning Products In Packing", priority=91)
	public void step91_CopySKUIDAndEnterinSearchFeildForScanningProductsInPacking() throws Exception
	{
		wmspage.CopySKUIDAndEnterinSearchFldForScanningProductsInPacking();
	}
	
	@Test(description="Click on Complete Packing button", priority=92)
	public void step92_ClickOnCompletePackingBtn() throws Exception
	{
		wmspage.Click_CompletePackingBtn();
	}
	
	@Test(description="Enter quantity in front of any row", priority=93)
	public void step93_EnteredQuantityInAnyRow() throws Exception
	{
		wmspage.EnterQuantity_Packing("1");
	}
	
	@Test(description="Click on Validate button", priority=94)
	public void step94_ClickOnValidateBtn() throws Exception
	{
		wmspage.ClickValidate_Packing();
	}
	
	@Test(description="Click on Home Popup button", priority=95)
	public void step95_ClickOnHomePopupBtn() throws Exception
	{
		wmspage.ClickHomeBtn_PopUp();
	}
	
	@Test(description="Navigated Into Magento and Verified Order Status in Orders page", priority=96)
	public void step96_NavigatedIntoMangetoAndVerifiedOrderStatusInOrdersPage() throws Exception
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
	
	@Test(description="Switch to FO Tab & Click on My Account Icon", priority=97)
	public void step97_SwitchToFOTabAndClickOnMyAccountIcon() throws Exception
	{
		CustomFun.SwitchToSpecificTab(backofficepage.driver, "0");
		homepage.clickMyaccountBtn();
	}
	
	@Test(description="Click on My Orders Link", priority=98)
	public void step98_ClickOnMyOrdersLink() throws Exception
	{
		myaccountpage.MyOrders_LnkClick();
		CustomFun.waitForPageLoaded(myaccountpage.driver);
	}
	
	@Test(description="Verified Order Status in My Orders page", priority=99)
	public void step99_VerifiedOrderStatusInMyOrdersPage() throws Exception
	{
		myaccountpage.VerifyOrderStatus(OrderID);
		if(locale.get().contains("FR_FR") | locale.get().contains("CH_FR"))
		{
		Assert.assertEquals(MyAccountPage.OrderStatusFromFO,TextProp.get().getProperty("OrderInPreparationtxt_FR"));
		}
		else
		{
		Assert.assertEquals(MyAccountPage.OrderStatusFromFO,TextProp.get().getProperty("Processingtxt_UK"));	
		}
	}
	
	@Test(description="Navigated Into WMS and Processed with Shipping Process", priority=100)
	public void step100_NavigatedIntoWMSAndProcessedwithShippingProcess() throws Exception
	{
		CustomFun.SwitchToSpecificTab(wmspage.driver, "1");
		wmspage.ShippingOrderProcess(BarCodeForScan);
	}
	
	@Test(description="Navigated Into Magento and Verified Order Status in Orders page", priority=101)
	public void step101_NavigatedIntoMangetoAndVerifiedOrderStatusInOrdersPage() throws Exception
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
		backofficepage.Click_viewBtnForPdt();  
	    CustomFun.waitForPageLoaded(backofficepage.driver);
	}
	
	@Test(description="Switch to FO Tab & Click on My Account Icon", priority=102)
	public void step102_SwitchToFOTabAndClickOnMyAccountIcon() throws Exception
	{
		CustomFun.SwitchToSpecificTab(backofficepage.driver, "0");
		homepage.driver.findElement(By.xpath(ObjRepoProp.get().getProperty("HP_MyAccount_Icon"))).click();
		CustomFun.waitForPageLoaded(myaccountpage.driver);
	}
	
	@Test(description="Click on My Orders Link", priority=103)
	public void step103_ClickOnMyOrdersLink() throws Exception
	{
		myaccountpage.MyOrders_LnkClick();
		CustomFun.waitForPageLoaded(myaccountpage.driver);
	}
	
	@Test(description="Verified Order Status in My Orders page", priority=104)
	public void step104_VerifiedOrderStatusInMyOrdersPage() throws Exception
	{
		myaccountpage.VerifyOrderStatus(OrderID);
		if(locale.get().contains("FR_FR") | locale.get().contains("CH_FR"))
		{
		Assert.assertEquals(MyAccountPage.OrderStatusFromFO,TextProp.get().getProperty("OrderShippedtxt_FR"));
		}
		else
		{
		Assert.assertEquals(MyAccountPage.OrderStatusFromFO,TextProp.get().getProperty("OrderShippedtxt_UK"));	
		}
	}
	
	@Test(description="Comparing the Seleable stock in the WMS and the BO Magento after shipping the order", priority=105)
	public void step105_ComparedSeleableStockInWMSAndBOBothAreSameAfterShippingTheOrder() throws Exception
	{
	  //Verify Seleable Stock in WMS after Shipping the order
	    CustomFun.SwitchToSpecificTab(wmspage.driver, "1");
	    wmspage.WMS_Datalistmenu();
	    wmspage.WMS_Datalist_Productclick();
	 // wmspage.SearchSKUIDInListOfProduct();
	    wmspage.ClickOnDetailsButtonForSimpleProd(ref_searchable_SKUID);
	    wmspage.VerifyInitialSaleableStock();
	    wmspage.VerifyInitialReservedStock();
	    //Verify Seleable Stock in BO after Shipping the order
	    CustomFun.SwitchToSpecificTab(backofficepage.driver, "2");
	    backofficepage.CatalogIconClick();
	    backofficepage.ProductstxtFromCatalogIconClick();
	    backofficepage.SearchForProductSeleableStockInBO(BarCodeSKU);
	    backofficepage.VerifyInitialSaleableStockInBO(BarCodeSKU);
    }
	
	@Test(description="Click on RMA Product Return Btn ", priority=106)
	public void step106_ClickOnRMAProductReturnBtn() throws Exception
	{
		CustomFun.SwitchToSpecificTab(backofficepage.driver, "0");
		myaccountpage.MyOrders_LnkClick();
		myaccountpage.ClickOnMyorders_RMAProductReturnBtn(OrderID);
	}
	
	@Test(description="Creating RMA from FO  ", priority=107)
	public void step107_CreatingRMAFromFO() throws Exception
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
	
	@Test(description="Navigated back to BO and click on Returns from sales tab", priority=108)
	public void step108_NavigatedIntoMangetoAndClickOnReturnsFromSales() throws Exception
	{
	CustomFun.SwitchToSpecificTab(backofficepage.driver, "2");
	backofficepage.SalesIconClick();
	backofficepage.ReturnstxtFromSalesIconClick();
	}

	@Test(description="Click on filters and enter RMA ID", priority=109)
	public void step109_ClickONFiltersAndEnterRMAID() throws Exception
	{
	if(!backofficepage.driver.findElement(By.xpath(ObjRepoProp.get().getProperty("ClearAllLink_xpath"))).isDisplayed())
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
	 backofficepage.ClearTheFilterInBOForReturnsOrder(OrderID);
     backofficepage.VerifyReturnsStatusInBO_ReturnsPage(OrderID);

	for(int i=0;i<=5;i++)
	{
	 backofficepage.ClearTheFilterInBOForReturnsOrder(OrderID);
     backofficepage.VerifyReturnsStatusInBO_ReturnsPage(OrderID);
	 RMAIDStatus=BackOfficePage.RMAIDStatus;
	if(RMAIDStatus.contains(TextProp.get().getProperty("Authorizedtxt")))
	{
		RMAIDStatus=BackOfficePage.RMAIDStatus;
	    Assert.assertEquals(TextProp.get().getProperty("Authorizedtxt"), RMAIDStatus);
	    log.info("Successfully Verified Order Status in Returns Page After Returns submit is completed: " + RMAIDStatus);
	    Reporter.log("<p>Successfully Verified Order Status in Returns Page After Returns submit is completed: " + RMAIDStatus);
	    break;
	}
  }
}
	
	@Test(description="Click on Sales Icon", priority=111)
	public void step111_ClickOnSalesIcon() throws Exception
	{
	backofficepage.SalesIconClick();
	}

	@Test(description="Click on Orders text from Sales Icon", priority=112)
	public void step112_ClickOrderstxtFromSalesIcon() throws Exception
	{
	backofficepage.OrderstxtFromSalesIconClick();
	}

	@Test(description="Verified Order Status in Orders page", priority=113)
	public void step113_VerifiedOrderStatusInOrdersPage() throws Exception
	{
	backofficepage.ClearTheFilterInBO(OrderID);
	backofficepage.VerifyOrderStatusInBO_OrdersPage(OrderID);
	OrderStatus=BackOfficePage.OrderStatus;
	Assert.assertEquals(TextProp.get().getProperty("ProcessingRMAtxt"), OrderStatus);
	log.info("Successfully Verified Order Status in Orders Page After Returns submit is completed: " + OrderStatus);
	Reporter.log("<p>Successfully Verified Order Status in Orders Page After Returns submit is completed: " + OrderStatus);
	}
	
	@Test(description="Navigated Into WMS and Validate the RMA reception in the WMS", priority=115)
	public void step115_ClickOnRMALink() throws Exception
	{
		CustomFun.SwitchToSpecificTab(homepage.driver, "1");
		wmspage.Click_RMALnk();
	}

	@Test(description="Enter RMA ID in RMA Field, Click on Submit Filter button & Reception button in WMS", priority=116)
	public void step116_EnterRMAID_SearchForOrderDetails_ClickOnReceptionButton() throws Exception
	{
		for (int i = 0; i <= 6; i++)
		{
			Thread.sleep(60000);
			CustomFun.refreshPage(wmspage.driver);
			Thread.sleep(10000);
			String ExpectedRMAID=wmspage.driver.findElement(By.xpath(ObjRepoProp.get().getProperty("OrderIDtxt_xpath"))).getText();
			if(ExpectedRMAID.contains(RMAID))
			{
			break;
			}
		}
		wmspage.EnterRMAID_SearchForOrderDetails_ClickOnReceptionButton(RMAID);
	}

		@Test(description="Execute RMA Process in WMS", priority=117)
		public void step117_ExecuteRMAProcessinWMS() throws Exception
		{
		wmspage.ExecuteRMAProcess();
		} 

		@Test(description="Navigated Into Magento and Click on Sales Icon", priority=119)
		public void step119_NavigatedIntoMangetoAndVerifiedOrderStatusInOrdersPage() throws Exception
		{
		  CustomFun.SwitchToSpecificTab(backofficepage.driver, "2");
		  backofficepage.SalesIconClick();
		}

		@Test(description="Click on Returns link from Sales Tab", priority=120)
		public void step120_ReturnstxtFromSalesIconClick() throws Exception
		{
		backofficepage.ReturnstxtFromSalesIconClick();
		}

		@Test(description="Verified Order Status in Returns page", priority=121)
		public void step121_VerifiedOrderStatusInReturnsPage() throws Exception
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
		
		@Test(description="Click on View option under order grid", priority=122)
		public void step122_ClickonViewOptioninOrderGrid() throws Exception
		{
		backofficepage.ClickOnOrderGrid(OrderID);
		CustomFun.waitForPageLoaded(backofficepage.driver);
		}

		@Test(description="Click on Return Items Tab", priority=123)
		public void step123_ClickOnReturnItems() throws Exception
		{
		backofficepage.ReturnsItemsClick();
		}

		@Test(description="Entered Approved value in Approved Field under RMA Items Requested for Grid", priority=124)
		public void step124_EnterValueInApprovedField() throws Exception
		{
		backofficepage.EnterValueInApprovedField("1");
		}
		
		@Test(description="Select any Resolution Reason option from Resolution Dropdown", priority=125)
		public void step125_SelectOptionFromResolutionDropdown() throws Exception
		{
			backofficepage.SelectOptionFromResolutionDropdown("Size Exchange");
		}

		@Test(description="Select Approved option from Status Dropdown", priority=126)
		public void step126_SelectApprovedOptionFromStatusDropdown() throws Exception
		{
		backofficepage.SelectApprovedOptionFromStatusDropdown();
		}

		@Test(description="Click on Save Button", priority=127)
		public void step127_ClickOnSaveButton() throws Exception
		{
		backofficepage.ClickOnSaveButton();
		}

		@Test(description="Verify Success Msg For RMA Request after submit returns", priority=128)
		public void step128_VerifySuccessMsgForSavedRMARequest() throws Exception
		{
		backofficepage.VerifySuccessMsgForSavedRMARequest();
		}

		@Test(description="Click on Sales Icon", priority=129)
		public void step129_ClickOnSalesIcon() throws Exception
		{
		backofficepage.SalesIconClick();
		}

		@Test(description="Click on Orders text from Sales Icon", priority=130)
		public void step130_ClickOrderstxtFromSalesIcon() throws Exception
		{
		backofficepage.OrderstxtFromSalesIconClick();
		}

		@Test(description="Verified Order Status in Orders page", priority=131)
		public void step131_VerifiedOrderStatusInOrdersPage() throws Exception
		{
		backofficepage.ClearTheFilterInBO(OrderID);
		backofficepage.VerifyOrderStatusInBO_OrdersPage(OrderID);
		OrderStatus=BackOfficePage.OrderStatus;
		Assert.assertEquals(TextProp.get().getProperty("WaitingForCreditMemotxt"), OrderStatus);
		log.info("Successfully Verified Order Status in Orders Page After RMA Approved: " + OrderStatus);
		Reporter.log("<p>Successfully Verified Order Status in Orders Page After RMA Approved: " + OrderStatus);
		}

		@Test(description="Click on Sales Icon", priority=132)
		public void step132_ClickOnSalesIcon() throws Exception
		{
		backofficepage.SalesIconClick();
		}

		@Test(description="Click on Returns link from Sales Tab", priority=133)
		public void step133_ReturnstxtFromSalesIconClick() throws Exception
		{
		backofficepage.ReturnstxtFromSalesIconClick();
		}

		@Test(description="Verified Order Status in Returns page", priority=134)
		public void step134_VerifiedOrderStatusInReturnsPage() throws Exception
		{
			 backofficepage.ClearTheFilterInBOForReturnsOrder(OrderID);
	         backofficepage.VerifyReturnsStatusInBO_ReturnsPage(OrderID);
		RMAIDStatus=BackOfficePage.RMAIDStatus;
		Assert.assertEquals(TextProp.get().getProperty("Approvedtxt"), RMAIDStatus);
		log.info("Successfully Verified Order Status in Returns Page After RMA Approved : " + RMAIDStatus);
		Reporter.log("<p>Successfully Verified Order Status in Returns Page After RMA Approved : " + RMAIDStatus);
		}
	
		@Test(description="Click on View option under order grid", priority=135)
		public void step135_ClickonViewOptioninOrderGrid() throws Exception
		{
		backofficepage.ClickOnOrderGrid(OrderID);
		CustomFun.waitForPageLoaded(backofficepage.driver);
		}
		
		@Test(description="Click On Refund/Exchange Button in Order Details Page", priority=136)
		public void step136_ClickOnRefundOrExchangeButton() throws Exception
		{
			backofficepage.ClickOnRefundOrExchangeButton();
			CustomFun.waitForPageLoaded(backofficepage.driver);
			String[] NewMemoID=backofficepage.driver.findElement(By.xpath("//h1")).getText().split(" ");
			RefundMemoID=NewMemoID[3];
		}
		
		@Test(description="Scroll down till Refund button in New Memo Page & Click on Refund Button", priority=137)
		public void step137_ClickOnRefundButtonInNewMemoPage() throws Exception
		{
			backofficepage.ClickOnRefundButtonInNewMemoPage();
		}
		
		@Test(description="Verify Success Msg For Create Credit Memo after Refund created", priority=138)
		public void step138_VerifySuccessMsgForCreateCreditMemo() throws Exception
		{
			backofficepage.VerifySuccessMsgForCreateCreditMemo();
		}	
		
		@Test(description="Click on Sales Icon", priority=139)
		public void step139_ClickOnSalesIcon() throws Exception
		{
		  backofficepage.SalesIconClick();
		}

		@Test(description="Click on Orders text from Sales Icon",priority=140)
		public void step140_ClickOrderstxtFromSalesIcon() throws Exception
		{
		 backofficepage.OrderstxtFromSalesIconClick();
		}
		
		@Test(description="Verified Order Status in Orders page",priority=141)
		public void step141_VerifiedOrderStatusInOrdersPage() throws Exception
		{
			for (int i = 0; i <= 3; i++)
			{
				Thread.sleep(30000);
				CustomFun.refreshPage(backofficepage.driver);
				Thread.sleep(5000);
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
			backofficepage.Click_viewBtnForPdt();	
		    CustomFun.waitForPageLoaded(backofficepage.driver);
		    backofficepage.driver.findElement(By.xpath("//span[contains(text(),'Comments History')]")).click();
			Thread.sleep(2000);
			ShipmentID=backofficepage.driver.findElement(By.xpath("//span[contains(text(),'Shipment #')]")).getText().replaceAll("[^0-9.]", "");
			backofficepage.Click_BackBtnForBOPrct();
		}  
		
		@Test(description="Get SKUID from orderspage and save the value and click on order back btn",priority=142)
		public void step142_GetSKUIDFromOrdersPage() throws Exception
		{
			backofficepage.ClickOnOrderGrid(OrderID);
			BackOfficePage.SKUIDVal= backofficepage.driver.findElement(By.xpath("//div[@class='product-sku-block']")).getText().replaceAll("[^0-9.]", ""); 
			backofficepage.Click_BackBtnForBOPrct();
		}
		
		@Test(description="Click on Sales Icon", priority=144)
		public void step144_ClickOnSalesIcon() throws Exception
		{
			backofficepage.SalesIconClick();
		}
		
		@Test(description="Click on Returns link from Sales Tab", priority=145)
		public void step145_ReturnstxtFromSalesIconClick() throws Exception
		{
			backofficepage.ReturnstxtFromSalesIconClick();
		}
		
		@Test(description="Verified Order Status in Returns page", priority=146)
		public void step146_VerifiedOrderStatusInReturnsPage() throws Exception
		{
			 backofficepage.ClearTheFilterInBOForReturnsOrder(OrderID);
	         backofficepage.VerifyReturnsStatusInBO_ReturnsPage(OrderID);
			RMAIDStatus=BackOfficePage.RMAIDStatus;
		    Assert.assertEquals(TextProp.get().getProperty("ProcessedandClosedtxt"), RMAIDStatus);
		    log.info("Successfully Verified Order Status in Returns Page After Refund Created : " + RMAIDStatus);
			Reporter.log("<p>Successfully Verified Order Status in Returns Page After Refund Created : " + RMAIDStatus);
		}
		
		@Test(description="Click on  order grid", priority=147)
		public void step147_ClickonOrderGrid() throws Exception
		{
		backofficepage.ClickOnOrderGrid(OrderID);	
		}
		
		@Test(priority=148,description="Click on  retry create order exchange Btn")
		public void step148_ClickOnRetryCreateOrderExchangeBtn() throws Exception
		{
		backofficepage.	ClickOnRetryCreateOrderExchangeBtn();
		}
		
		@Test(priority=149,description="Navigated Into Magento and click on Add products By SKU CTA ")
		public void step149_NavigatedIntoMangetoAndClickAddPctsBySKU() throws Exception
		{
		backofficepage.Click_AddProductsBySKUBtnForRMA();
		}
		
		@Test(priority=150,description="Enter SKU ID in the field")
		public void step150_EnterSKUIDINAddPctsBySKUFld() throws Exception
		{
		backofficepage.EnterSKUID_InFld();
		}
		
		@Test(priority=151,description="Enter Quantity in the field")
		public void step151_EnterQutyINAddPctsByQTYFld() throws Exception
		{
		backofficepage.EnterQTY_InFld();
		}
		
		@Test(priority=152,description=" Click on Add to order btn ")
		public void step152_ClickOnAddToOrderBtn() throws Exception
		{
		backofficepage.Click_AddToOrderBtnForRefundoffline();
		}
		
		@Test(priority=153,description=" Verify existing Billing & Shipping Address in Exchange Page")
		public void step153_VerifyBillingAndShippingAddressInBO() throws Exception
		{
		backofficepage.VerifyExistingBillingAndShippingAddressInBO();
		}
		
		@Test(priority=154,description=" Click On Exchange Payment Radio Btn in  BO from RMA ")
		public void step154_ClickOnExchangePaymentRadioBtn() throws Exception
		{
		backofficepage.ExchangePaymentRadioBtn();
		}
		
		@Test(priority=155,description=" Click On_Shipping Method_Link For Refundoffline in RMA ")
		public void step155_Click_ShippingMethod_LinkForRefundoffline() throws Exception
		{
		backofficepage.Click_ShippingMethod_LinkForRefundoffline();
		}
		
		@Test(priority=156,description=" Verify_ShippingMethods_RadioOption For Refundoffline in RMA ")
		public void step156_Verify_ShippingMethods_RadioOptionForRefundofflineAndClickOnShippingMethod() throws Exception
		{
		backofficepage.Verify_ShippingMethods_RadioOptionForRefundoffline();
		backofficepage.Click_FirstShippingMethod_BtnForRefundoffline();
		}
			
		@Test(priority=157,description=" Verify Order Totals For Refundoffline in RMA ")
		public void step157_Verify_OrderTotals_ForRefundoffline() throws Exception
		{
		backofficepage.Verify_OrderTotals_ForRefundoffline();
		}
		
		@Test(priority=158,description=" Click on Submit Order For Exchange Btn For Refund offline ")
		public void step158_Click_SubmitOrderForExchange_BtnForRefundoffline() throws Exception
		{
		backofficepage.Click_SubmitOrderForExchange_BtnForRefundoffline();
		}
		
		@Test(priority=159,description="  Click on OK from Alert popup  For Exchange Btn For Refund offline")
		public void step159_Click_OKFromAlertPopupForRefundoffline() throws Exception
		{
		backofficepage.Click_OKFromAlertPopupForRefundoffline();
		}
		
		@Test(priority=160,description=" Verify Success Msg For Created Order For RMA Offline Request")
		public void step160_VerifySuccessMsgForCreatedOrderForRMAOfflineRequest() throws Exception
		{
		backofficepage.VerifySuccessMsgForCreatedOrderForRMAOfflineRequest();
		}
		
		@Test(priority=161,description=" Verify created order with -1 value")
		public void step161_VerifyCreatedOrderInRMAOfflineWithNewVal() throws Exception
		{
		backofficepage.VerifyCreatedOrderInRMAOffline();
		}
			
		@Test(priority=162,description="Refresh the BO page and Verify the order status")
		public void step162_RefreshAndVerifyOrderStatusInOrdersPage() throws Exception
		{
			backofficepage.Click_BackBtnForBOPrct();
			CreatedRMAOrderID_FromOffline=BackOfficePage.NewOrderFor_RMAOffline;
			for(int i=0;i<=6;i++)
			{
			    Thread.sleep(30000);
				CustomFun.refreshPage(backofficepage.driver);
				Thread.sleep(5000);		
				backofficepage.driver.findElement(By.xpath("//button[text()='Clear all']")).click();
				  backofficepage.EnterOrderId(CreatedRMAOrderID_FromOffline);
				  backofficepage.SearchIconClick();
				backofficepage.VerifyOrderStatusInBO_OrdersPage(CreatedRMAOrderID_FromOffline);
				OrderStatus=BackOfficePage.OrderStatus;
			if(OrderStatus.contains(TextProp.get().getProperty("SenttoLogistictxt")))
			{
			OrderStatus=BackOfficePage.OrderStatus;
			Assert.assertEquals(TextProp.get().getProperty("SenttoLogistictxt"), OrderStatus);
			log.info("Successfully Verified Order Status in Magento After created order from RMA offline : " + OrderStatus);
			Reporter.log("<p>Successfully Verified Order Status in Magento After created order from RMA offline: " + OrderStatus);
			break;
			}
			}
		}  
		
		
		@Test(priority=163,description="Swich to FO Tab & Click on My Account Icon")
		public void step163_SwitchToFOTabAndClickOnMyAccountIcon() throws Exception
		{
		CustomFun.SwitchToSpecificTab(homepage.driver, "0");
		homepage.driver.findElement(By.xpath(ObjRepoProp.get().getProperty("HP_MyAccount_Icon"))).click();
		CustomFun.waitForPageLoaded(homepage.driver);
		}

		@Test(priority=164,description="Click on My Orders Link")
		public void step164_ClickOnMyOrdersLink() throws Exception
		{
		myaccountpage=new MyAccountPage(backofficepage.driver);
		myaccountpage.MyOrders_LnkClick();
		CustomFun.waitForPageLoaded(myaccountpage.driver);
		}

		@Test(priority=165,description="Verified Order Status in My Orders page after Exchange completed Successfully")
		public void step165_VerifiedOrderStatusInMyOrdersPageAfterExchangeCompleted() throws Exception
		{
			if(locale.get().contains("FR_FR") | locale.get().contains("CH_FR"))
			{
			for(int i=0;i<=2;i++)
			{
			  Thread.sleep(30000);
			  CustomFun.refreshPage(myaccountpage.driver);
			  Thread.sleep(5000);
			  myaccountpage.VerifyOrderStatus(CreatedRMAOrderID_FromOffline);
			  OrderStatus=MyAccountPage.OrderStatusFromFO;
			  if(OrderStatus.contains(TextProp.get().getProperty("OrderInPreparationtxt_FR")))
			  {
		       myaccountpage.VerifyOrderStatus(CreatedRMAOrderID_FromOffline);
		       Assert.assertEquals(MyAccountPage.OrderStatusFromFO,TextProp.get().getProperty("OrderInPreparationtxt_FR"));
		       break;
			  }
			}
			}
			else
			{
				for(int i=0;i<=2;i++)
				{
				  Thread.sleep(30000);
				  CustomFun.refreshPage(myaccountpage.driver);
				  Thread.sleep(5000);
				  myaccountpage.VerifyOrderStatus(CreatedRMAOrderID_FromOffline);
				  OrderStatus=MyAccountPage.OrderStatusFromFO;
				  if(OrderStatus.contains(TextProp.get().getProperty("Processingtxt_UK")))
				  {
			       myaccountpage.VerifyOrderStatus(CreatedRMAOrderID_FromOffline);
			       Assert.assertEquals(MyAccountPage.OrderStatusFromFO,TextProp.get().getProperty("Processingtxt_UK"));
			       break;
				  }
				}
			}
		} 
		
		 @Test(description="Comparing the Seleable stock in the WMS and the BO Magento after Exchange the order", priority=166)
		 public void step166_ComparedSeleableStockInWMSAndBOBothAreSameAfterRefundTheOrder() throws Exception
		 {
		    //Verify Seleable Stock in WMS after Exchange the order
		    CustomFun.SwitchToSpecificTab(wmspage.driver, "1");
		    wmspage.WMS_Datalistmenu();
		    wmspage.WMS_Datalist_Productclick();
		    wmspage.ClickOnDetailsButtonForSimpleProd(ref_searchable_SKUID);
		    for(int i=0;i<=0;i++)
		    {
		    Thread.sleep(30000);
		    CustomFun.refreshPage(wmspage.driver);
		    Thread.sleep(5000);
		    CustomFun.waitForPageLoaded(wmspage.driver);   
		    }
		    wmspage.VerifyInitialSaleableStock();
		    wmspage.VerifyInitialReservedStock();
		    //Verify Seleable Stock in BO after Exchange the order
		    CustomFun.SwitchToSpecificTab(backofficepage.driver, "2");
		    backofficepage.CatalogIconClick();
		    backofficepage.ProductstxtFromCatalogIconClick();
		    backofficepage.SearchForProductSeleableStockInBO(BarCodeSKU);
		    backofficepage.VerifyInitialSaleableStockInBO(BarCodeSKU);
		  //  Assert.assertEquals(BackOfficePage.InitialSaleableStock_BO, WMSPage.InitialSaleableStock_WMS);
		  }

     	@Test(description="Verify Order Confirmation Mail Contents", priority=169)
     	public void step169_VerifyOrderConfirmationMailContents() throws InterruptedException
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


     	     @Test(description="Verify Shipping Confirmation Mail Contents", priority=170)
     	     public void step170_VerifyShippingConfirmationMailContents() throws InterruptedException
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

     	   
     	  @Test(description="Verify Return Request Confirmation Mail Contents", priority=171)
     	  public void step171_VerifyReturnRequestConfirmationMailContents() throws InterruptedException
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


     	 @Test(description="Verify Return Reception Confirmation Mail Contents", priority=172)
     	 public void step172_VerifyReturnReceptionConfirmationMailContents() throws Exception
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

     	@Test(description="Verify Credit Memo Confirmation Mail Contents", priority=173)
     	public void step173_VerifyCreditMemoConfirmationMailContents() throws Exception
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

     	@Test(description="Verify Order Confirmation Mail for Exchange order Contents", priority=174)
     	public void step174_VerifyOrderConfirmationMailContentsForExchangeOrder() throws InterruptedException
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
