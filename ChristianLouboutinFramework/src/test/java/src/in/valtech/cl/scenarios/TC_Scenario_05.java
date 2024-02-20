package src.in.valtech.cl.scenarios;
import org.apache.log4j.Logger;    
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import static src.in.valtech.util.PropertyFileReader.ObjRepoProp;
import static src.in.valtech.util.PropertyFileReader.TextProp;
import java.time.Duration;
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

public class TC_Scenario_05 extends BaseTest
{
	public Logger log = Logger.getLogger(this.getClass().getName());
	public String OrderID;
	public String OrderStatus;
	public static String RMAID;
	public String RefundMemoID;
	public String ShipmentID;
	public static String BarCodeSKU;
	public static String Size;
	public static String ref_searchable_SKUID;
	public String TotalAmountSummary;
	public String ExpProductLineItem;
	public String ExpSubTotal;
	public String ExpTax;
	public String ExpGrandTotal;
	public String ExpShippingAndHandling;
	public String ShippingBarCode;
	
	
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
	logtest("Process the order from label generation error to shipped status.");
	System.out.println("Entry to the script ");
	System.out.println("The base url "+ baseUrl.get());
	homepage=HomePage.navigateToCLApplication_URL(driver.get(), baseUrl.get());
	}
	
	@Test(priority=1, description="Verification of Homepage Pictures")
	public void step02_VerificationOfHomepageLogo() throws Exception
	{
		if(locale.get().contains("FR_FR") | bsValue.get().contains("YES") | locale.get().contains("CH_FR") | locale.get().contains("UK_EN") | environmentName.equals("HomoEnv"))
		{
			for (int i = 0; i <= 2; i++)
			{
				Thread.sleep(2000);
				CustomFun.refreshPage(homepage.driver);
				Thread.sleep(2000);
			}
			homepage.VerifyPictures();
		}
		else
		{
			homepage.VerifyPictures();
		}
	}
	
	@Test(priority=2, description="Verification of Product Widgets")
	public void step03_VerificationOfProductWidgets() throws Exception
	{
	 homepage.VerifyProductWidgets();
	}
	
	@Test(priority=3, description="Verification of Footer header text")
	public void step04_VerificationOfFooterHeaderText() throws Exception
	{
	homepage.Verify_FooterHeader_txt();
	log.info("Successfully Verified Footer Header text");
	Reporter.log("<p>Successfully Verified Footer  Header text");
	}
	
	@Test(priority=4, description="Verification of Footer links")
	public void step05_VerificationOfFooterLinks() throws Exception
	{
	homepage.Verify_Footer_lnk();
	log.info("Successfully Verified Footer links");
	Reporter.log("<p>Successfully Verified Footer links");
	}      
	
	@Test(priority=5, description="Verification of Social Icon_text")
	public void step06_VerificationOfFooterSocialIconText() throws Exception 
	{
	homepage.Verify_SocialIcon_txt();
	log.info("Successfully Verified Footer Social Icon_txt");
	Reporter.log("<p>Successfully Verified Footer Social Icon_txt");
	}  
	
	@Test(priority=6, description="Verification of Social Icons")
	public void step07_VerificationOfFooterSocialIcons() throws Exception
	{
	homepage.Verify_Footer_Social_lnk();
	log.info("Successfully Verified Footer Social Icons");
	Reporter.log("<p>Successfully Verified Footer Social Icons");
	}  
	
	@Test(priority=7, description=" Clicking on My Account Icon ")
	public void step08_ClickMyAccountBtn() throws Exception
	{
	homepage.clickMyaccountBtn();
	log.info("Successfully clicked on My account Icon from Homepage");
	Reporter.log("<p>Successfully clicked on My account Icon from Homepage");
	}  
	
	
	@Test(priority=8, description=" Verification of All text ,links and buttons in My Account Modal ")
	public void step09_VerificationOfAllTxtLnkBtn_InMyAccountModal() throws Exception
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
	
	@Test(priority=9, description=" Enter the Email in login field  ")
	public void step10_EnterEmailAddressInLogin() throws Exception
	{
	homepage.EnterEmail(CustomFun.getUserInfoDSDetails().get().getEmailDomain());
	log.info("Successfully Entered Email Address in Login field");
	Reporter.log("<p>Successfully Entered Email Address in Login field");
    }
	
	@Test(priority=10, description=" Enter the password in login field")
	public void step11_EnterPasswordInLogin() throws Exception
	{
	homepage.EnterPassword(CustomFun.getUserInfoDSDetails().get().getPassword());
	log.info("Successfully Entered password in Login field");
	Reporter.log("<p>Successfully Entered password in Login field");
    }
	
	@Test(priority=11, description=" Click on sign in Btn  in login field")
	public void step12_ClickOnSignInBtn() throws Exception
	{
	homepage.clickOnSignBtn();
	log.info("Successfully Clicked on sign in Btn in Login field");
	Reporter.log("<p>Successfully Clicked on sign in Btn in Login field");
    }
	
	@Test(description="Verified ConsentPolicy_Checkbox, MyFavoriteAddress_Header, NewsLetter_Header & Footer in My Account Page", priority=12)
	public void step13_VerifiedMyAccountInfoInMAP() throws Exception
	{
		GUIFunctions.RemoveExistProductsFromMyCartIcon(homepage.driver);
		CustomFun.refreshPage(homepage.driver);
		myaccountpage=new MyAccountPage(homepage.driver);
		myaccountpage.VerifyWishlistLink();
		/*
		 * Defect ID :- ECOM-15832 - [Revamp_Homo] - FR_FR : Consent Checkbox is not getting displayed in My Account page 
		 * Verify Consent Checkbox step and mention comment as per the defect requirement , 
		 * this checkbox is removed from Application .Hence not automated
		 */
     	//myaccountpage.Verify_ConsentCheckbox(); (Out Of Scope For Revamp Environment)
     	myaccountpage.Verify_MyFavoriteAddressHeaderInMAP();
		myaccountpage.Verify_NewsLetterHeaderInMAP();
		homepage.Verify_FooterHeader_txt();
		log.info("Successfully Verified Footer Header text in My Account Page");
		Reporter.log("<p>Successfully Verified Footer Header text in My Account Page");
	}
	
	@Test(description="Mouse Over on Gentlemen L1 Category", priority=13)
	public void step14_MouseOverElementOnGentlemenL1Category() throws Exception
	{
		categorylandingpage=new CategoryLandingPage(homepage.driver);
		categorylandingpage.MouseOverOnL1GentlemenCategory();
	}
	
	@Test(description="Click on L3 Louis Category under L1 Gentlemen Category", priority=14)
	public void step15_ClickOnL3LouisGentlemenCategory() throws Exception
	{
		System.out.println(environmentName);
		if(environmentName.contains("HomoEnv"))
		{
		  categorylandingpage.driver.findElement(By.xpath("//span[contains(text(),'Louis')]")).click();
		  Thread.sleep(2000);
		}
		else
		if(environmentName.contains("StagingEnv"))
		{
			categorylandingpage.driver.findElement(By.xpath("//span[contains(text(),'Louis')]")).click();
		  Thread.sleep(2000);
		}
		else
		if(environmentName.contains("IntegrationEnv"))
		{
			 categorylandingpage.driver.findElement(By.xpath("//span[contains(text(),'Louis')]")).click();
			  Thread.sleep(2000);
		}
		else
			categorylandingpage.driver.findElement(By.xpath("//span[contains(text(),'Louis Junior')]")).click();
			Thread.sleep(2000);
	}
	
	@Test(description="Scroll down till last sealable product & Click on Sealable Product In Category Landing Page", priority=15)
	public void step16_ScrollDownTillLastSealableProdAndClickOnLastSealableProductInCategoryLandingPage() throws Exception
	{
		GUIFunctions.ClickOnLastSealableProduct(categorylandingpage.driver);
		CustomFun.waitForPageLoaded(categorylandingpage.driver);
	}
	
	@Test(description="Verified Product Image and Thumbnail Image in Product Details Page", priority=16)
	public void step17_VerifiedProductImageAndThumbnailImageinPDP() throws Exception
	{
		productdetailspage=new ProductDetailsPage(categorylandingpage.driver);
		productdetailspage.pdpMainimage();
	}
	
	@Test(description="Verified Product Name in Product Details Page", priority=17)
	public void step18_VerifiedProductNameinPDP() throws Exception
	{
		productdetailspage.VerifyProductNametxtInPDP();
	}
	
	@Test(description="Verified Product Brand Name & Product Price in Product Details Page", priority=18)
	public void step19_VerifiedProductBrandNameAndProductPriceinPDP() throws Exception
	{
		productdetailspage.VerifyProductBrandNametxtInPDP();
		productdetailspage.VerifyProductPricetxtInPDP();
	}
	
	
	@Test(description="Verified Wishlist Icon in Product Details Page", priority=19)
	public void step20_VerifiedWishlistIconinPDP() throws Exception
	{
		productdetailspage.VerifyWishlistIconInPDP();
		productlistingpage=new ProductListingPage(homepage.driver);
	}
	
	@Test(description="Verified Size Guide option, Click on Size Guide and close overlay", priority=20)
	public void step21_ClickOnSizeGuideAndCloseOverlay() throws Exception
	{
		productdetailspage.pdpSizeguideInfo();
	}
	
	@Test(description="Click On Select_Your_Size Button and Select any Size", priority=21)
	public void step22_ClickOnSelectYourSizeButtonAndSelectAnySize() throws Exception
	{
		productdetailspage.ClickOnSelectYourSizeBtnAndSelectAnySizeInPDP();
		Size=ProductDetailsPage.GetSizeOfProd;
	}
	
	@Test(description="Click on In_store_availability button and close overlay", priority=22)
	public void step23_ClickOnInStoreAvailabilityButtonAndCloseOverlay() throws Exception
	{
		productdetailspage.pdpNotification_Closebtn();
		Thread.sleep(1000);
		productdetailspage.ClickonInStoreAvailabilitybtnAndCloseOverlayInPDP();
	}
	
	@Test(description="Verified Contact Us link & Colour Swatches in Product Details Page", priority=23)
	public void step24_VerifiedContactUslinkAndColourSwatchesInPDP() throws Exception
	{
		productdetailspage.VerifyContactUsLinkInPDP();
		GUIFunctions.mouseOverElement(productdetailspage.driver, productdetailspage.driver.findElement(By.xpath("//div[contains(@class,'login-wrapper')]/..//a")),"My Account");
		productdetailspage.pdpColorSwatches();
	}
	
	@Test(description="Click on Product Info and Verified content under Product Info section", priority=24)
	public void step25_ClickonProductInfoAndVerifiedContent() throws Exception
	{
		productdetailspage.pdpProductInfoBlock();
		ref_searchable_SKUID=ProductDetailsPage.Ref_searchable_sku;
	}
	
	@Test(description="Click on Shipping and Verified content under Shipping section", priority=25)
	public void step26_ClickonShippingAndVerifiedContent() throws Exception
	{
		productdetailspage.pdpShippingBlock();
	}
	
	@Test(description="Click on Product care and Verified content under Product care section", priority=26)
	public void step27_ClickonProductCareAndVerifiedContent() throws Exception
	{
		productdetailspage.pdpProductCareBlock();
	}

	@Test(description="Click on Add To Cart Button", priority=27)
	public void step28_ClickonAddToCartButton() throws Exception
	{
		productdetailspage.pdpAddtoCartbtn();
	}
	
	@Test(description="Verified Content in Confirmation Overlay", priority=28)
	public void step29_VerifiedContentInConfirmationOverlay() throws Exception
	{
		productdetailspage.pdpProductadd_Notification();
		productdetailspage.pdpNotification_Closebtn();
	}

	@Test(description="Click on Add To Cart Button", priority=29)
	public void step30_ClickonAddToCartButton() throws Exception
	{
		if(environmentName.contains("IntegrationEnv") | environmentName.equals("StagingEnv1"))
		{
			Thread.sleep(2000);
			productdetailspage.driver.findElement(By.xpath(ObjRepoProp.get().getProperty("PDP_Sizebtn"))).click();
			Thread.sleep(2000);
			productdetailspage.driver.findElement(By.xpath(ObjRepoProp.get().getProperty("PDP_SelectedSecondSize"))).click();
			productdetailspage.pdpAddtoCartbtn();
		}
		else
		{
		homepage.mousehoverOnLadiesHeaderNavigation();
		categorylandingpage.ladiesL3KateCategoryClick();
		categorylandingpage.Click_ProductImg();
		Thread.sleep(2000);
		productdetailspage.driver.findElement(By.xpath(ObjRepoProp.get().getProperty("PDP_Sizebtn"))).click();
		Thread.sleep(2000);
		productdetailspage.driver.findElement(By.xpath(ObjRepoProp.get().getProperty("PDP_SelectedSecondSize"))).click();
		productdetailspage.pdpAddtoCartbtn();
		}
	}
	
	@Test(description="Click on 'your cart' link from confirmation pop up", priority=30)
	public void step31_ClickonYourCartLinkInConfirmationOverlay() throws Exception
	{
		productdetailspage.driver.findElement(By.xpath(ObjRepoProp.get().getProperty("MiniCP_YourCart_txt"))).click();
		log.info("Successfully Clicked on Your Cart link from Confirmation pop up");
		Reporter.log("<p>Successfully Clicked on Your Cart link from Confirmation pop up");
	}

	@Test(description="Verified My Cart Header in My Cart Page", priority=31)
	public void step32_VerifiedMyCartHeaderInMCP() throws Exception
	{
		cartpage=new CartPage(productdetailspage.driver);
		cartpage.VerifyMyCartHeaderHeader();
	}
	
	@Test(priority=32,description="verify product details in main cart")
	public void step33_VerifyDetails_MainCart() throws Exception
	{
	cartpage.Verify_All_Redbannertxt_InMainCart();
	cartpage.Verify_Product_Details_InMainCart();
	cartpage.VerifyRemoveWishlistLnk_Maincart();
	cartpage.Verify_Product_price_Details_MainCart();
	Thread.sleep(5000);
	TotalAmountSummary=cartpage.driver.findElement(By.xpath("//*[contains(@class,'grand totals')]//td")).getText().replaceAll("[^0-9]","");
	System.out.println(TotalAmountSummary);
	cartpage.VerifyContactusCheckoutCTA_Maincart();
	cartpage.VerifyProductQtyIn_MainCart();
	}
	
	@Test(priority=33,description="Click on Decrease qty(-) icon")
	public void step34_ClickOnDecreaseQtyIcon() throws Exception
	{	
		cartpage.Click_ON_DecrQuantity_Maincart();
		CustomFun.waitForPageLoaded(cartpage.driver);
		cartpage.driver.findElement(By.xpath("//input[contains(@class,'input-text qty')]")).click();
		Assert.assertEquals(cartpage.driver.findElements(By.xpath("//img[@class='photo image product-image-photo']")).size(),1);
		log.info("Successfully Verified reduced quantity of product by 1");
		Reporter.log("<p>Successfully Verified reduced quantity of product by 1");
	}
	
	@Test(priority=34,description="Comparing Total Correct Summary Amount After Removing One Product Qnty in My Cart Page")
	public void step35_ComparingTotalCorrectSummaryAmountAfterRemovingOneProductQnty() throws Exception
	{	
		GUIFunctions.ComparingTotalCorrectSummaryAmountAfterRemovingOneProductQnty(cartpage.driver, TotalAmountSummary);
	}
	
	@Test(priority=35,description="click on proceed to checkout CTA")
	public void step36_ClickOnProceedToCheckOutCTA() throws Exception
	{	
		cartpage.Click_ON_ProceedToCheckOut_Maincart();
		CustomFun.waitForPageLoaded(cartpage.driver);
	}

	@Test(priority=36,description="Verify First & Last Name, Email and Logout text at Checkout Step 1")
	public void step37_VerifyLoginSectionAtCheckoutStep1() throws Exception
	{	
		checkoutpage=new CheckoutPage(cartpage.driver);
		checkoutpage.VerifyLoginSectionAtCheckoutStep1();
	}
	
	@Test(description="Verified Gift Options Header in Checkout Page", priority=37)
	public void step38_VerifiedGiftOptionsHeaderInCP() throws Exception
	{
		checkoutpage=new CheckoutPage(productdetailspage.driver);
		checkoutpage.VerifyGiftHeadertxt();
	}
	
	@Test(description="Verify No Wrap Img is auto selected", priority=38)
	public void step39_ScrollDownTillGiftWrappingImgAndSelectedInCP() throws Exception
	{
		checkoutpage.VerifyNoWarpImgIsSelected();
	}
	
	@Test(description="Click on Update Button in Checkout Page at Gift Section", priority=39)
	public void step40_ClickOnUpdateButtonInCP() throws Exception
	{
		checkoutpage.UpdatebtnClick();
	}
	
	@Test(description="Shipping Address Header in Checkout Page at Shipping Address Section", priority=40)
	public void step41_VerifiedShippingAddressHeaderInCP() throws Exception
	{
		shippingaddresspage=new ShippingAddressPage(checkoutpage.driver);
		shippingaddresspage.VerifyShippingAddressHeader();
	}
	
	@Test(description = "Open New Tab and Navigated to WMS", priority = 41)
	public void step42_OpenNewTabAndNavigatedtoWMS() throws Exception {
		wmspage = new WMSPage(shippingaddresspage.driver);
		CustomFun.OpenNewTabAndSwitchToNewTab(wmspage.driver, "1");
		wmspage.driver.navigate().to(CustomFun.getWMSInfoDSDetails().get().getWMSURL());
	}

	@Test(description = "Logged into WMS with valid crendentials", priority = 42)
	public void step43_LoggedIntoWMS() throws Exception {
		wmspage.WMSLogIn(CustomFun.getWMSInfoDSDetails().get().getWmsUsername(),
				CustomFun.getWMSInfoDSDetails().get().getWmsPassword());
	}

	@Test(description = "Click on OK button in WMS", priority = 43)
	public void step44_ClickOnOKbutton() throws Exception {
		wmspage.Click_WMSOKBtn();
	}

	@Test(description = "Mouse Over on Data Lists Menu", priority = 44)
	public void step45_MouseOverElementOnDataListsMenu() throws Exception {
		wmspage.WMS_Datalistmenu();
	}

	@Test(description = "Click on Products from Data Lists", priority = 45)
	public void step46_ClickOnProductsFromDataLists() throws Exception {
		wmspage.WMS_Datalist_Productclick();
	}

	@Test(description = "Enter Searchable SKU & Click on Submit Filter", priority = 46)
	public void step47_EnterSearchableSKUAndClickOnSubmitFilter() throws Exception {
		wmspage.SearchSKUIDInListOfProducts(ref_searchable_SKUID, Size);
		BarCodeSKU=WMSPage.barcodeSKU;
	}

	@Test(description = "Click on Details Button", priority = 47)
	public void step48_ClickOnDetailsButton() throws Exception {
		wmspage.ClickOnDetailsButton(Size);
	}

	@Test(description = "Scroll down till stocks grid and Verify Initial Saleable Stock", priority = 48)
	public void step49_VerifyInitialSaleableStock() throws Exception {
		wmspage.VerifyInitialSaleableStock();
	}

	@Test(description = "Verify Reserved Stock", priority = 49)
	public void step50_VerifyReservedStock() throws Exception {
		wmspage.VerifyInitialReservedStock();
	}

	@Test(description = "Open New Tab and Navigated to Magento BO", priority = 50)
	public void step51_OpenNewTabAndNavigatedtoMagentoBO() throws Exception {
		backofficepage = new BackOfficePage(homepage.driver);
		CustomFun.OpenNewTabAndSwitchToNewTab(backofficepage.driver, "2");
		backofficepage.driver.navigate().to(CustomFun.getBODSDetails().get().getBO_URL());
	}

	@Test(description = "Entered Username in Username Field", priority = 51)
	public void step52_EnteredUsernameField() throws Exception {
		backofficepage.EnterUsername(CustomFun.getBODSDetails().get().getBO_Username());
	}

	@Test(description = "Entered Password in Password Field", priority = 52)
	public void step53_EnteredPasswordField() throws Exception {
		backofficepage.EnterPassword(CustomFun.getBODSDetails().get().getBO_Password());
	}

	@Test(description = "Click on SignIn Button", priority = 53)
	public void step54_ClickOnSignInButton() throws Exception {
		backofficepage.SignbtnClick();
		if(environmentName.contains("IntegrationEnv") | environmentName.contains("HomoEnv1") | environmentName.contains("StagingEnv") | environmentName.contains("Integration6Env"))
  	    {
  			Thread.sleep(5000);
  			CustomFun.refreshPage(backofficepage.driver);
  			Thread.sleep(5000);
  		}
	}

	@Test(description = "Verified Dashboard Header & check whether user is in Dashboard page", priority = 54)
	public void step55_VerifiedDashboardHeaderInBO() throws Exception {
		CustomFun.waitForPageLoaded(backofficepage.driver);
		backofficepage.VerifyDashboardHeader();
	}

	@Test(description = "Click on Catalog Icon", priority = 55)
	public void step56_ClickOnCatalogIcon() throws Exception {
		backofficepage.CatalogIconClick();
	}

	@Test(description = "Click on Products text from Catalog Icon", priority = 56)
	public void step57_ClickProductstxtFromCatalogIcon() throws Exception {
		backofficepage.ProductstxtFromCatalogIconClick();
	}

	@Test(description = "Search For Product Seleable Stock In BO", priority = 57)
	public void step58_SearchForProductSeleableStockInBO() throws Exception {
        backofficepage.SearchForProductSeleableStockInBO(BarCodeSKU);
	}

	@Test(description = "Verify Initial Saleable Stock", priority = 58)
	public void step59_VerifyInitialSaleableStock() throws Exception {
		backofficepage.VerifyInitialSaleableStockInBO(BarCodeSKU);
	}
	
	@Test(description="Navigated Into FO & Verified Product Name under Order summary in Checkout Page at Shipping Address Section", priority=59)
	public void step60_NavigatedIntoFOAndVerifiedProductNameinPDP() throws Exception
	{
		CustomFun.SwitchToSpecificTab(homepage.driver, "0");
		checkoutpage=new CheckoutPage(productdetailspage.driver);
		checkoutpage.VerifyProductNametxtInCP();
	}
	
	@Test(description="Verified Product Price under order summary in Checkout Page at Shipping Address Section", priority=60)
	public void step61_VerifiedProductPriceinPDP() throws Exception
	{
		checkoutpage.VerifyProductPricetxtInCP();
	}
	
	@Test(description="Click on New Address Button in Checkout Page at Shipping Address Section", priority=61)
	public void step62_ClickOnNewAddressButtonInSAP() throws Exception
	{
		shippingaddresspage.VerfiedSAAndBABothSameCheckboxIsAutoSelectedForCredit();
		shippingaddresspage.NewAddressbtnClick_AsEU();
	}
	
	@Test(description="Entered Address Name in Address Name Field", priority=62)
	public void step63_EnteredAddressNameField() throws Exception
	{
			shippingaddresspage.EnterAddressNameAsEUToAddNewSA(CustomFun.getAddressDSDetails().get().getAddressName());
	}
	
	@Test(description="Verified Prefix Name Dropdown is Auto Selected or not at Shipping Address Section", priority=63)
	public void step64_VerifiedPrefixNameDpdIsAutoSelectedOrNot() throws Exception
	{
			 shippingaddresspage.driver.findElement(By.xpath("(//select[@name='prefix'])[2]")).sendKeys(CustomFun.getAddressDSDetails().get().getNamePrefix());
			 Thread.sleep(1000);
	}
	
	@Test(description="Entered First Name in First Name Field", priority=64)
	public void step65_EnteredFirstNameField() throws Exception
	{
			shippingaddresspage.EnterFirstNameAsEUToAddNewSA(CustomFun.getAddressDSDetails().get().getFirstName());
	}
	
	@Test(description="Entered Last Name in Last Name Field", priority=65)
	public void step66_EnteredLastNameField() throws Exception
	{
			shippingaddresspage.EnterLastNameAsEUToAddNewSA(CustomFun.getAddressDSDetails().get().getLastName());
	}
	
	@Test(description="Entered Address in Address Field", priority=66)
	public void step67_EnteredAddressField() throws Exception
	{
			shippingaddresspage.EnterAddressDetailsAsEUToAddNewSA(CustomFun.getAddressDSDetails().get().getAddress1());
	}
	
	@Test(description="Entered PostCode in PostCode Field", priority=67)
	public void step68_EnteredPostCodeField() throws Exception
	{
			shippingaddresspage.EnterPostcodeAsEUToAddNewSA(CustomFun.getAddressDSDetails().get().getPostcode());
	}
	
	@Test(description="Entered City in City Field", priority=68)
	public void step69_EnteredCityField() throws Exception
	{
		if(locale.get().contains("CH_FR") & environmentName.equals("HomoEnv1"))
		{
			 // shippingaddresspage.EnterCity_AsEU(CustomFun.getAddressDSDetails().get().getCity());
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
	
	@Test(description="Entered Phone Number in Phone Number Field", priority=69)
	public void step70_EnteredPhoneNumberField() throws Exception
	{
		if(environmentName.equals("StagingEnv1") | environmentName.equals("IntegrationEnv"))	
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
	
	@Test(description="Click on SHIP HERE button in shipping address Overlay and Verify Address Updated Message", priority=70)
	public void step71_ClickOnSHIPHEREButton() throws Exception
	{
		shippingaddresspage.ShipHerebtnClick();
		//Verify Success Message
		shippingaddresspage.VerifyAddressUpdatedSuccessMsg();
	}
	
	@Test(description="Verified Shipping Methods Header in Checkout Page at Shipping Methods Section", priority=71)
	public void step72_VerifiedShippingMethodsHeaderInCP() throws Exception
	{
		shippingaddresspage.VerifyShippingMethodLabel();
	}
	
	@Test(description="Click on Third Shipping Method radio button in Checkout page", priority=72)
	public void step73_ClickOnThirdShippingMethodRadioButton() throws Exception
	{
		if(environmentName.contains("Integration6Env"))
		{
			WebElement ele=shippingaddresspage.driver.findElement(By.xpath(ObjRepoProp.get().getProperty("ConfirmThisAddress_xpath")));
			GUIFunctions.JavaScriptClick(shippingaddresspage.driver,
					ele,"Click on Confirm This Address button");
		}
		//shippingaddresspage.VerifyAndClickOnSecondShippingmethod();
		shippingaddresspage.VerifyAndClickOnSecondShippingmethod();
	}
	
	@Test(description="Click on Continue To Payemnt button in Checkout page", priority=73)
	public void step74_ClickOnContinueToPayemntButton() throws Exception
	{
		shippingaddresspage.ContinuetopaymentbtnClick();
	}
	
	@Test(description="Scroll down till Payment options and Verified Payment options in Checkout Page", priority=74)
	public void step75_VerifiedPaymentoptions() throws Exception
	{
		paymentpage=new PaymentPage(shippingaddresspage.driver);
		paymentpage.checkout_Paymentoptions();
	}
	
	@Test(description="Click on Credit card Radio button under Payment option", priority=75)
	public void step76_ClickOnCreditCardRadioBtn() throws Exception
	{
		paymentpage.checkout_Creditcard();
	}
	
	@Test(description="Verified My billing and shipping address are the same checkbox is auto selected or not", priority=76)
	public void step77_VerifiedMyBAandSABothSame_CheckboxIsAutoSelected() throws Exception
	{
	/*	if(environmentName.equals("HomoEnv1"))	
		{
		  paymentpage.VerfiedSAAndBABothSameCheckboxIsAutoSelected();
		}  */
	}
	
	@Test(description="Entered Credit Number in Credit Number Field", priority=77)
	public void step78_EnteredCreditNumberField() throws Exception
	{
		paymentpage.checkout_CCCardnumber(CustomFun.getPaymentDSDetails().get().getCardNumber());
	}
	
	@Test(description="Entered Expiry Date in Expiry Date Field", priority=78)
	public void step79_EnteredExpiryDateField() throws Exception
	{
		paymentpage.checkout_CCExpirydate(CustomFun.getPaymentDSDetails().get().getCardExpiryDate());
	}
	
	@Test(description="Entered CVV in CVV Field", priority=79)
	public void step80_EnteredCVVField() throws Exception
	{
		paymentpage.checkout_CCV(CustomFun.getPaymentDSDetails().get().getCardCVV());
	}	
	
	@Test(description="Entered CardHolder Name in CardHolder Name Field", priority=80)
	public void step81_EnteredCardHolderField() throws Exception
	{
		paymentpage.checkout_Cardholdername(CustomFun.getPaymentDSDetails().get().getCardHolderName());
	}
	
	@Test(description="Checked on Privacy Policy and Return Policy checkbox", priority=81)
	public void step82_CheckedOnPrivacyPolicyAndReturnPolicyCheckbox() throws Exception
	{
		 paymentpage.checkout_Agreements_CreditCard();
	}
	
	@Test(description="Click on Proceed button in Checkout page at Payment Section", priority=82)
	public void step83_ClickOnProceedButton() throws Exception
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
	
	@Test(description="Verified Success Message in Order Confirmation page after placing the order", priority=83)
	public void step84_VerifiedSuccessMsgAfterPlacingOrder() throws Exception
	{
		orderconfirmationpage=new OrderConfirmationPage(paymentpage.driver);
		orderconfirmationpage.Verify_SuccessOrder_Msg_txt();
	}
	
	@Test(description="Verified Continue Shopping Button in Order Confirmation page", priority=84)
	public void step85_VerifiedContinueShoppingButton() throws Exception
	{
		orderconfirmationpage.VerifyContinueShopping_Btn();
	}
	
	@Test(description="Verified Your OrderID in Order Confirmation page", priority=85)
	public void step86_VerifiedYourOrderID() throws Exception
	{
		orderconfirmationpage.VerifyOrderIDInOCP();
	}
	
	@Test(description="Initialised OrderID in OrderID variable for further execution", priority=86)
	public void step87_InitialisedOrderID() throws Exception
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
	
	@Test(description="Click on My Account Icon", priority=87)
	public void step88_ClickOnMyAccountIcon() throws Exception
	{
		homepage.driver.findElement(By.xpath(ObjRepoProp.get().getProperty("HP_MyAccount_Icon"))).click();	
	}
	
	@Test(description="Click on My Orders Link", priority=88)
	public void step89_ClickOnMyOrdersLink() throws Exception
	{
		myaccountpage=new MyAccountPage(orderconfirmationpage.driver);
		myaccountpage.MyOrders_LnkClick();
	}
	
	@Test(description = "Verified Order Status & Other Details in My Orders page", priority = 89)
	public void step90_VerifiedOrderStatusInMyOrdersPage() throws Exception {
		myaccountpage.VerifyOrderStatus(OrderID);
		myaccountpage.VerifyOrderPriceInOrderspage(OrderID);
		MyAccountPage.PriceVal_OrderPage = myaccountpage.driver
				.findElement(By.xpath("//*[contains(text(),'" + OrderID + "')]/..//p[contains(@class, 'price')]"))
				.getText().replaceAll(",", "\\.").replaceAll("[^0-9.]", "");
		myaccountpage.VerifyOrderItemInOrderspage(OrderID);
		myaccountpage.VerifyOrderDateInOrderspage(OrderID);
		if(locale.get().contains("FR_FR") | locale.get().contains("CH_FR"))
		{
		Assert.assertEquals(MyAccountPage.OrderStatusFromFO,TextProp.get().getProperty("OrderBeingValidatedtxt_FR"));
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
		    	if(OrderStatus.contains(TextProp.get().getProperty("OrderPendingSecurityChecktxt_UK")))
				{
		    	Assert.assertEquals(MyAccountPage.OrderStatusFromFO,TextProp.get().getProperty("OrderPendingSecurityChecktxt_UK"));
		    	break;
				}
			 }
		}
	}
	
	@Test(description="Navigated Back to Magento & Click on Sales Icon", priority=91)
	public void step92_NavigatedBackToMagentoAndClickOnSalesIcon() throws Exception
	{
		CustomFun.SwitchToSpecificTab(backofficepage.driver, "2");
		backofficepage.SalesIconClick();
	}
	
	@Test(description="Click on Orders text from Sales Icon", priority=92)
	public void step93_ClickOrderstxtFromSalesIcon() throws Exception
	{
		backofficepage.OrderstxtFromSalesIconClick();
	}
	
	@Test(description="Verified Orders Header & check whether user is in Orders page", priority=93)
	public void step94_VerifiedOrdersHeaderInBO() throws Exception
	{
		backofficepage.VerifyOrdersHeadertxt();
	}
	
	@Test(description="Verified Order Status in Orders page", priority=94)
	public void step95_VerifiedOrderStatusInOrdersPage() throws Exception
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
	
	@Test(description = "Navigated Into FO & Click on My Account Icon", priority = 95)
	public void step96_NavigatedIntoFOAndClickOnMyAccountIcon() throws Exception {
		CustomFun.SwitchToSpecificTab(homepage.driver, "0");
		homepage.clickMyaccountBtn();
	}

	@Test(description = "Click on My Orders Link", priority = 96)
	public void step97_ClickOnMyOrdersLink() throws Exception {
		myaccountpage = new MyAccountPage(orderconfirmationpage.driver);
		myaccountpage.MyOrders_LnkClick();
	}

	@Test(description = "Verified Order Status", priority = 97)
	public void step98_VerifiedOrderStatusInMyOrdersPage() throws Exception {
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
	
	@Test(description = "Navigated Into Magento & Verified Seleable Stock Quantity Decremented By 1", priority = 98)
	public void step99_NavigatedIntoMagentoAndVerifiedSaleableStockQntyDecBy1InBOAferPlacingTheOrder() throws Exception {
		CustomFun.SwitchToSpecificTab(backofficepage.driver, "2");
		backofficepage.CatalogIconClick();
		backofficepage.ProductstxtFromCatalogIconClick();
		backofficepage.SearchForProductSeleableStockInBO(BarCodeSKU);
		backofficepage.VerifySaleableStockQntyDecBy1InBOAferPlacingTheOrder(BarCodeSKU);
	}

	@Test(description = "Navigated Into WMS and Verified Seleable Stock Quantity Decremented By 1", priority = 99)
	public void step100_VerifySaleableStockDecBy1InWMSAferPlacingTheOrder() throws Exception {
		CustomFun.SwitchToSpecificTab(wmspage.driver, "1");
		CustomFun.refreshPage(wmspage.driver);
		CustomFun.waitForPageLoaded(wmspage.driver);
		wmspage.ClickOnDetailsButton(Size);
		wmspage.VerifySaleableStockDecBy1InWMSAferPlacingTheOrder();
	}

	@Test(description = "Comparing the Seleable stock in the WMS and the BO Magento", priority = 100)
	public void step101_ComparedSeleableStockInWMSAndBOBothAreSame() throws Exception {
		CustomFun.SwitchToSpecificTab(wmspage.driver, "1");
		CustomFun.refreshPage(wmspage.driver);
		CustomFun.waitForPageLoaded(wmspage.driver);
		wmspage.VerifyInitialSaleableStock();
		CustomFun.SwitchToSpecificTab(backofficepage.driver, "2");
		backofficepage.CatalogIconClick();
		backofficepage.ProductstxtFromCatalogIconClick();
		 backofficepage.SearchForProductSeleableStockInBO(BarCodeSKU);
		backofficepage.VerifyInitialSaleableStockInBO(BarCodeSKU);
		//Assert.assertEquals(BackOfficePage.InitialSaleableStock_BO, WMSPage.InitialSaleableStock_WMS);
	}
	
	@Test(description="Navigated Into WMS and Picking Order Process", priority=101)
	public void step102_NavigatedIntoWMSAndPickingOrderProcess() throws Exception
	{
		CustomFun.SwitchToSpecificTab(wmspage.driver, "1");
		wmspage.PickingOrderProcess(OrderID);
	}
	
	@Test(description="Verified Picking order for # XXXXX", priority=102)
	public void step103_VerifiedPickingOrderSuccessMsg() throws Exception
	{
		wmspage.VerifyPickingOrderSuccessMsg();
	}
	
	@Test(description="Navigated Into Magento and Verified Order Status in Orders page", priority=103)
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
	
	@Test(description = "Navigated Into FO & Click on My Account Icon", priority = 104)
	public void step105_NavigatedIntoFOAndClickOnMyAccountIcon() throws Exception {
		CustomFun.SwitchToSpecificTab(homepage.driver, "0");
		homepage.driver.findElement(By.xpath(ObjRepoProp.get().getProperty("HP_MyAccount_Icon"))).click();	
	}
	
	@Test(description="Click on My Orders Link", priority=105)
	public void step106_ClickOnMyOrdersLink() throws Exception
	{
		myaccountpage.MyOrders_LnkClick();
	}
	
	@Test(description="Verified Order Status in My Orders page", priority=106)
	public void step107_VerifiedOrderStatusInMyOrdersPage() throws Exception
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
	    log.info("Successfully Verified Order Status in My orders page: " + MyAccountPage.OrderStatusFromFO);
		Reporter.log("<p>Successfully Verified Order Status in My orders page: " + MyAccountPage.OrderStatusFromFO);
	}
	
	@Test(description="Navigated Into WMS and Get BarCode From Picking Process", priority=107)
	public void step108_NavigatedIntoWMSAndGetBarcodeFromPickingProcess() throws Exception
	{
		CustomFun.SwitchToSpecificTab(myaccountpage.driver, "1");
		wmspage.getBarCodeFromPickingProcess(OrderID);
		ShippingBarCode=WMSPage.BarCodeId;
	}
	
	@Test(description="Navigated Into WMS and Click on Packing Button", priority=108)
	public void step109_NavigatedIntoWMSAndClickOnPackingBtn() throws Exception
	{
		wmspage.Click_WMSPackingBtn();
	}
	
	@Test(description="Entered BarcodeID in Barcode Field And Search For Packing", priority=109)
	public void step110_EnteredBarcodeAndSearchForPacking() throws Exception
	{
		wmspage.EnterBarcodeAndSearchForPacking(ShippingBarCode);
	}
	
	@Test(description="Copy SKUID And Enter in Search Field For Scanning Products In Packing", priority=110)
	public void step111_CopySKUIDAndEnterinSearchFeildForScanningProductsInPacking() throws Exception
	{
		wmspage.CopySKUIDAndEnterinSearchFldForScanningProductsInPacking();
	}
	
	@Test(description="Click on Complete Packing button", priority=111)
	public void step112_ClickOnCompletePackingBtn() throws Exception
	{
		wmspage.Click_CompletePackingBtn();
	}
	
	@Test(description="Enter quantity in front of any row", priority=112)
	public void step113_EnteredQuantityInAnyRow() throws Exception
	{
		wmspage.EnterQuantity_Packing("1");
	}
	
	@Test(description="Click on Validate button", priority=113)
	public void step114_ClickOnValidateBtn() throws Exception
	{
		wmspage.ClickValidate_Packing();
	}
	
	@Test(description="Click on Home Popup button", priority=114)
	public void step115_ClickOnHomePopupBtn() throws Exception
	{
		wmspage.ClickHomeBtn_PopUp();
	}
	
	@Test(description="Navigated Into Magento and Verified Order Status in Orders page", priority=115)
	public void step116_NavigatedIntoMangetoAndVerifiedOrderStatusInOrdersPage() throws Exception
	{
		CustomFun.SwitchToSpecificTab(backofficepage.driver, "2");
		CustomFun.refreshPage(backofficepage.driver);
		backofficepage.ClearTheFilterInBO(OrderID);
		backofficepage.VerifyOrderStatusInBO_OrdersPage(OrderID);
	    OrderStatus=BackOfficePage.OrderStatus;
	    Assert.assertEquals(TextProp.get().getProperty("Invoicedtxt"), OrderStatus);
	    log.info("Successfully Verified Order Status in Magento After Packing Process is completed: " + OrderStatus);
		Reporter.log("<p>Successfully Verified Order Status in Magento After Packing Process is completed: " + OrderStatus);
	 }
	
	@Test(description="Switch to FO Tab & Click on My Account Icon", priority=116)
	public void step117_SwitchToFOTabAndClickOnMyAccountIcon() throws Exception
	{
		CustomFun.SwitchToSpecificTab(backofficepage.driver, "0");
		homepage.driver.findElement(By.xpath(ObjRepoProp.get().getProperty("HP_MyAccount_Icon"))).click();
	}
	
	@Test(description="Click on My Orders Link", priority=117)
	public void step118_ClickOnMyOrdersLink() throws Exception
	{
		myaccountpage.MyOrders_LnkClick();
	}
	
	@Test(description="Verified Order Status in My Orders page", priority=118)
	public void step119_VerifiedOrderStatusInMyOrdersPage() throws Exception
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
	    log.info("Successfully Verified Order Status in My orders page: " + MyAccountPage.OrderStatusFromFO);
		Reporter.log("<p>Successfully Verified Order Status in My orders page: " + MyAccountPage.OrderStatusFromFO);
	}
	
	@Test(description="Navigated Into WMS and Processed with Shipping Process", priority=119)
	public void step120_NavigatedIntoWMSAndProcessedwithShippingProcess() throws Exception
	{
		CustomFun.SwitchToSpecificTab(wmspage.driver, "1");
		wmspage.ShippingOrderProcess_LGE(ShippingBarCode);
	}
	
	@Test(description="Verified Label Generation Error Message", priority=120)
	public void step121_VerifiedLabelGenerationErrorMessageMsg() throws Exception
	{
		wmspage.VerifyLabelGenerationErrorMsg();
	}
	
	@Test(description="Navigated Into Magento and Verified Order Status in Orders page", priority=121)
	public void step122_NaviagtedIntoMangetoAndVerifiedOrderStatusInOrdersPage() throws Exception
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
	
	@Test(description="Switch to FO Tab & Click on My Account Icon", priority=122)
	public void step123_SwitchToFOTabAndClickOnMyAccountIcon() throws Exception
	{
		CustomFun.SwitchToSpecificTab(backofficepage.driver, "0");
		homepage.driver.findElement(By.xpath(ObjRepoProp.get().getProperty("HP_MyAccount_Icon"))).click();
	}
	
	@Test(description="Verified Order Status in My Orders page", priority=123)
	public void step124_VerifiedOrderStatusInMyOrdersPage() throws Exception
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
	    log.info("Successfully Verified Order Status in My orders page: " + MyAccountPage.OrderStatusFromFO);
		Reporter.log("<p>Successfully Verified Order Status in My orders page: " + MyAccountPage.OrderStatusFromFO);
	}
	
	@Test(description="Navigated Into Magento", priority=124)
	public void step125_NavigatedIntoMangetoAndClickOnSaleIcon() throws Exception
	{
		CustomFun.SwitchToSpecificTab(backofficepage.driver, "2");
		CustomFun.refreshPage(backofficepage.driver);
		CustomFun.waitForPageLoaded(backofficepage.driver);
	}
	
	@Test(description="Click on View option under order grid", priority=125)
	public void step126_ClickonViewOptioninOrderGrid() throws Exception
	{
		backofficepage.ClearTheFilterInBO(OrderID);
	backofficepage.ClickOnOrderGrid(OrderID);
	}
	
	@Test(description="Edited Exist Shipping & Billing Address with New Shipping Address For RMA", priority=126)
	public void step127_EditExistShippingAndBillingAddressWithNewShippingAddressForRMA() throws Exception
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
	
	@Test(description="Naviagted Back Into WMS & Generate Orders With Label Ready To Be Reprinted In WMS", priority=127)
	public void step128_GenerateOrdersWithLabelReadyToBeReprintedInWMS() throws Exception
	{
		CustomFun.SwitchToSpecificTab(wmspage.driver, "1");
		wmspage.OrdersWithLabelReadyToBeReprintedInWMS(OrderID);
	}
	
	@Test(description=" Navigated Into Magento and Click on Sales Icon", priority=128)
	public void step129_NavigatedIntoMangetoAndClickOnSalesIcon() throws Exception
	{
		CustomFun.SwitchToSpecificTab(backofficepage.driver, "2");
		backofficepage.SalesIconClick();
	}
	
	@Test(description="Click on Orders text from Sales Icon", priority=129)
	public void step130_ClickOrderstxtFromSalesIcon() throws Exception
	{
		backofficepage.OrderstxtFromSalesIconClick();
		CustomFun.waitForPageLoaded(backofficepage.driver);
	}
	
	@Test(description="Verified Orders Header & check whether user is in Orders page", priority=130)
	public void step131_VerifiedOrdersHeaderInBO() throws Exception
	{
		backofficepage.VerifyOrdersHeadertxt();
	}
	
	@Test(description="Verified Order Status in Orders page", priority=131)
	public void step132_VerifiedOrderStatusInOrdersPage() throws Exception
	{
	    for(int i=0;i<=10;i++)
		{
		  Thread.sleep(60000);
		  CustomFun.refreshPage(backofficepage.driver);
		  Thread.sleep(5000);
		  backofficepage.ClearTheFilterInBO(OrderID);
		  backofficepage.VerifyOrderStatusInBO_OrdersPage(OrderID);
		  OrderStatus=BackOfficePage.OrderStatus;
		  if(OrderStatus.contains(TextProp.get().getProperty("Shippedtxt")))
		  {
			  OrderStatus=BackOfficePage.OrderStatus;
			  Assert.assertEquals(TextProp.get().getProperty("Shippedtxt"), OrderStatus);
			  break;
		  }
		}
	    log.info("Successfully Verified Order Status in Magento After Shipping Process is completed: " + OrderStatus);
		Reporter.log("<p>Successfully Verified Order Status in Magento After Shipping Process is completed: " + OrderStatus);
/*		backofficepage.Click_viewBtnForPdt();	
	    CustomFun.waitForPageLoaded(backofficepage.driver);
	    backofficepage.driver.findElement(By.xpath("//span[contains(text(),'Comments History')]")).click();
	    Thread.sleep(2000);
	    ShipmentID=backofficepage.driver.findElement(By.xpath("//span[contains(text(),'Shipment #')]")).getText().replaceAll("[^0-9.]", "");
	    backofficepage.Click_BackBtnForBOPrct();  */
	}
	
	@Test(description = "Switch to FO Tab & Click on My Account Icon", priority = 132)
	public void step133_SwitchToFOTabAndClickOnMyAccountIcon() throws Exception {
		CustomFun.SwitchToSpecificTab(backofficepage.driver, "0");
		homepage.driver.findElement(By.xpath(ObjRepoProp.get().getProperty("HP_MyAccount_Icon"))).click();
	}

	@Test(description = "Click on My Orders Link", priority = 133)
	public void step134_ClickOnMyOrdersLink() throws Exception {
		myaccountpage.MyOrders_LnkClick();
	}

	@Test(description = "Verified Order Status in My Orders page", priority = 134)
	public void step135_VerifiedOrderStatusInMyOrdersPage() throws Exception {
		myaccountpage.VerifyOrderStatus(OrderID);
		if(locale.get().contains("FR_FR") | locale.get().contains("CH_FR"))
		{
		Assert.assertEquals(MyAccountPage.OrderStatusFromFO,TextProp.get().getProperty("OrderShippedtxt_FR"));
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
	    	if(OrderStatus.contains(TextProp.get().getProperty("OrderShippedtxt_UK")))
			{
	    	Assert.assertEquals(MyAccountPage.OrderStatusFromFO,TextProp.get().getProperty("OrderShippedtxt_UK"));
	    	break;
			}
		 }	
		}
	}
	
	    @Test(description="Comparing the Seleable stock in the WMS and the BO Magento after shipping the order", priority=135)
	    public void step136_ComparedSeleableStockInWMSAndBOBothAreSameAfterShippingTheOrder() throws Exception
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
	    
	    
	    @Test(description="Verify Order Confirmation Mail Contents", priority=136)
		public void step137_VerifyOrderConfirmationMailContents() throws InterruptedException
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
	    
	    
	    @Test(description="Verify Shipping Confirmation Mail Contents", priority=137)
	    public void step138_VerifyShippingConfirmationMailContents() throws Exception
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
}
