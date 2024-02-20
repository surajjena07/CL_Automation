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
*
* @author Gopalaswamy.M
*
*/

public class TC_Scenario_03 extends BaseTest
{
	public Logger log = Logger.getLogger(this.getClass().getName());
	public String OrderID;
	public String OrderStatus;
	public String TotalAmountSummary;
	
	public String ExpProductLineItem;
	public String ExpSubTotal;
	public String ExpTax;
	public String ExpGrandTotal;
	public String ExpShippingAndHandling;
	
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
	NewCustomerAccountPage newcustomeraccountpage;
	AdyenPage adyenpage;
	
	public static String BarCodeSKU;
	public static String Size;
	public static String ref_searchable_SKUID;
	
	@Test(description="Navigated to CL Home Page")
	public void step01_NavigatedtoCLHomePage() throws Exception
	{
	logtest("Reject the order from adyen for newly created user in FO");
	System.out.println("Entry to the script ");
	System.out.println("The base url "+ baseUrl.get());
	homepage=HomePage.navigateToCLApplication_URL(driver.get(), baseUrl.get());
	}
	
	@Test(priority=1, description="Verification of Homepage Pictures")
	public void step02_VerificationOfHomepageLogo() throws Exception
	{
		if(locale.get().contains("FR_FR") | bsValue.get().contains("YES") | locale.get().contains("CH_FR") | environmentName.equals("HomoEnv1") | environmentName.equals("HomoEnv"))
		{
			for (int i = 0; i <= 1; i++)
			{
				Thread.sleep(5000);
				CustomFun.refreshPage(homepage.driver);
				Thread.sleep(5000);
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
	
	@Test(description="Open New Tab and Navigated to Magento BO", priority=7)
	public void step08_OpenNewTabAndNavigatedtoMagentoBO() throws Exception
	{
		backofficepage=new BackOfficePage(homepage.driver);
		CustomFun.OpenNewTabAndSwitchToNewTab(backofficepage.driver, "1");
		backofficepage.driver.navigate().to(CustomFun.getBODSDetails().get().getBO_URL());
	}
	
	@Test(description="Entered Username in Username Field", priority=8)
	public void step09_EnteredUsernameField() throws Exception
	{
		backofficepage.EnterUsername(CustomFun.getBODSDetails().get().getBO_Username());
	}
	
	@Test(description="Entered Password in Password Field", priority=9)
	public void step10_EnteredPasswordField() throws Exception
	{
		backofficepage.EnterPassword(CustomFun.getBODSDetails().get().getBO_Password());
	}
	
	@Test(description="Click on SignIn Button", priority=10)
	public void step11_ClickOnSignInButton() throws Exception
	{
		backofficepage.SignbtnClick();
		if(environmentName.contains("IntegrationEnv") | environmentName.contains("HomoEnv1") | environmentName.contains("StagingEnv") | environmentName.contains("Integration6Env"))
  	    {
  			Thread.sleep(5000);
  			CustomFun.refreshPage(backofficepage.driver);
  			Thread.sleep(5000);
  		}
	}

	@Test(description="Verified Dashboard Header & check whether user is in Dashboard page", priority=11)
	public void step12_VerifiedDashboardHeaderInBO() throws Exception
	{
		backofficepage.VerifyDashboardHeader();
	}
	
	@Test(description="Click on Customers Icon", priority=12)
	public void step13_ClickOnCustomersIcon() throws Exception
	{
		backofficepage.CustomersIconClick();
	}
	
	@Test(description="Click on All Customers text from Customers Icon", priority=13)
	public void step14_ClickAllCustomerstxtFromCustomersIcon() throws Exception
	{
		backofficepage.AllCustomerstxtFromCustomersIconClick();
	}
	
	@Test(description="Verified Customers Header & check whether user is in Customers page", priority=14)
	public void step15_VerifyCustomersHeadertxtInBO() throws Exception
	{
		backofficepage.VerifyCustomersHeadertxt();
	}
	
	@Test(description="Enter Customer EmailID in Search Field and Search For Customer Account", priority=15)
	public void step16_SearchForCustomerAccount() throws Exception
	{
		CustomFun.waitObjectToLoad(backofficepage.driver, By.xpath("//button[text()='Clear all']"),Duration.ofSeconds(10));
		if(!backofficepage.driver.findElement(By.xpath("//button[text()='Clear all']")).isDisplayed())
		{
			backofficepage.driver.findElement(By.xpath("//input[@id='fulltext']")).sendKeys(CustomFun.getUserInfoDSDetails().get().getEmailDomain());
			CustomFun.waitObjectToLoad(backofficepage.driver, By.xpath("(//button[@class='action-submit'])[2]"),Duration.ofSeconds(10));
			backofficepage.driver.findElement(By.xpath("(//button[@class='action-submit'])[2]")).click();
			CustomFun.waitForPageLoaded(backofficepage.driver);
		}
		else
		{
		  GUIFunctions.JavaScriptClick(backofficepage.driver,backofficepage.driver.findElement(By.xpath("//button[text()='Clear all']")),"Click on Clear All button");
		  backofficepage.driver.findElement(By.xpath("//input[@id='fulltext']")).sendKeys(CustomFun.getUserInfoDSDetails().get().getEmailDomain());
	      CustomFun.waitObjectToLoad(backofficepage.driver, By.xpath("(//button[@class='action-submit'])[2]"),Duration.ofSeconds(10));
		  GUIFunctions.JavaScriptClick(backofficepage.driver,backofficepage.driver.findElement(By.xpath("(//button[@class='action-submit'])[2]")),"Click on Search Icon");
		  CustomFun.waitForPageLoaded(backofficepage.driver);
		}
	}
	
	@Test(description="Delete The Existing Customer Account from Customer Grid Result", priority=16)
	public void step17_DeletedExistCustomerAccountFromCustomerGridResultInBO() throws Exception
	{
		backofficepage.DeletedExistCustomerAccountFromCustomerGridResultInBO();
	} 
	
	@Test(priority=17, description=" Clicking on My Account Icon")
	public void step18_ClickMyAccountBtn() throws Exception
	{
	CustomFun.SwitchToSpecificTab(homepage.driver, "0");
	homepage.ScrollTillMyAccountAndclickOnMyAccount_Icon();
	log.info("Successfully clicked on My account Icon from Homepage");
	Reporter.log("<p>Successfully clicked on My account Icon from Homepage");
	}  
	
	@Test(priority=18, description=" Verification of All text ,links and buttons in My Account Modal ")
	public void step19_VerificationOfAllTxtLnkBtn_InMyAccountModal() throws Exception
	{
	homepage.Verify_LoginCreateAccount_Btn();	
	log.info("Successfully Verified All text ,links and buttons in My Account Modal");
	Reporter.log("<p>Successfully Verified on All text ,links and buttons in My Account Modal");
	} 
	
	@Test(priority=19, description=" Clicking on Account create button & Verified navigated to Create New Customer Account Page")
	public void step20_ClickAccountCreateBtn() throws Exception
	{
	homepage.clickOn_Create_Account_btn();
	Reporter.log("<p>Successfully clicked on Account create button from Homepage");
	newcustomeraccountpage=new NewCustomerAccountPage(homepage.driver);
	//newcustomeraccountpage.VerifyNewCustomerAccHeadertxt();
	if(environmentName.equals("StagingEnv") | environmentName.equals("HomoEnv"))
	{
		for (int i = 0; i <= 1; i++)
		{
			Thread.sleep(5000);
			CustomFun.refreshPage(homepage.driver);
			Thread.sleep(5000);
		}
	}
	}

	@Test(priority=20, description="Verified Prefix Dropdown Is Auto Selected")
	public void step21_VerifiedPrefixDropdownIsAutoSelected() throws Exception
	{
	newcustomeraccountpage.VerifyPrefixDropdownIsAutoSelected(CustomFun.getUserInfoDSDetails().get().getNamePrefix());
	}

	@Test(priority=22, description=" Enter last name field ")
	public void step23_EnterLastNameField() throws Exception
	{
	System.out.println(CustomFun.getUserInfoDSDetails().get().getLastName());
	newcustomeraccountpage.EnterLastNameField(CustomFun.getUserInfoDSDetails().get().getLastName());
	}

	@Test(priority=23, description=" Enter first name field ")
	public void step24_EnterFirstNameField() throws Exception
	{
	newcustomeraccountpage.EnterFirstNameField(CustomFun.getUserInfoDSDetails().get().getFirstName());
	}

	@Test(priority=24, description=" Enter email address field ")
	public void step25_EnterEmailAddressField() throws Exception
	{
	newcustomeraccountpage.EnterEmailAddress(CustomFun.getUserInfoDSDetails().get().getUserName());
	}

	@Test(priority=25, description=" Enter password field ")
	public void step26_EnterPasswordField() throws Exception
	{
	newcustomeraccountpage.EnterPassword(CustomFun.getUserInfoDSDetails().get().getPassword());
	}

	@Test(priority=27, description=" Enter confirm password field")
	public void step28_EnterConfirmPasswordField() throws Exception
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

	@Test(priority=28, description=" click on Terms and conditions 2 checkboxes")
	public void step29_ClickTermsConditionCheckbox() throws Exception
	{
			newcustomeraccountpage.AgreementCheckbox();
	}

	@Test(priority=29, description=" click on create customer account button")
	public void step30_ClickCreateCustomerAccountBtn() throws Exception
	{
	newcustomeraccountpage.ClickOnCreateCLAccountBtn();
	}

	@Test(priority=30, description=" verify registered successfully msg text ")
	public void step31_VerifyRegisteredSuccessMsgTxt() throws Exception
	{
	 myaccountpage=new MyAccountPage(newcustomeraccountpage.driver);
	 CustomFun.waitForPageLoaded(myaccountpage.driver);
	 myaccountpage.VerifySuccessMsgForRegister();
	} 

	@Test(priority=31, description=" Verify username text")
	public void step32_VerifyUserNameInMYAccount() throws Exception
	{
     CustomFun.waitForPageLoaded(myaccountpage.driver);
	 myaccountpage.Verify_Usernametxt();
	}
	
	@Test(priority=32, description="Verified My account page content's")
	public void step33_VerifiedMyAccountPageContents() throws Exception
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
	
	@Test(priority=34, description="Mouseover on L1 Category")
	public void step35_MouseoverOnL1Category() throws Exception
	{
		homepage.mousehoverOnLadiesHeaderNavigation();
	}
	
	@Test(description="Click on L2 The Essentiels under L1 Ladies Category", priority=35)
	public void step36_ClickOnL2KateLadiesCategory() throws Exception
	{
		categorylandingpage=new CategoryLandingPage(homepage.driver);
		// Any L2 Category can be taken as a test data
		homepage.ClickOnL2KateCategory();
		log.info("Successfully mouse over on L2 The Essentiels under L1 Ladies Category");
		Reporter.log("<p>Successfully mouse over on L2 The Essentiels under L1 Ladies Category");
	}
	
	@Test(priority=36, description="Verification of Category Page")
	public void step37_VerificationOfCategoryPage() throws Exception
	{
	 homepage.VerifyProductWidgets();
	}
	
	@Test(description="Click on Product Image", priority=37)
	public void step38_ClickOnProductImg() throws Exception
	{
	categorylandingpage.Click_ProductImg();
	}
	
	@Test(description="Verified Product Name in Product Details Page", priority=38)
	public void step39_VerifiedProductNameinPDP() throws Exception
	{
	productdetailspage=new ProductDetailsPage(categorylandingpage.driver);
	productdetailspage.VerifyProductNametxtInPDP();
	}
	
	@Test(description="Verified Product Price in Product Details Page", priority=39)
	public void step40_VerifiedProductPriceinPDP() throws Exception
	{
		productdetailspage.VerifyProductPricetxtInPDP();
	}
	
	@Test(description="Verified Brand name in Product Details Page", priority=40)
	public void step41_VerifiedBrandnameinPDP() throws Exception
	{
		productdetailspage.VerifyProductBrandNametxtInPDP();
	}
	
	@Test(priority=41,description="Verified Color swatches in PDP")
	public void step42_VerifiedColorSwatches() throws Exception
	{
	productdetailspage.pdpColorSwatches();
	}
	
	@Test(priority=42, description="Verified Add to cart button in Product Details Page" )
	public void step43_VerifiedAddtoCartbtnInPDP() throws Exception
	{
	productdetailspage.VerifyAddtoCartbtnInPDP();
	}
	
	@Test(description="Click on In_store_availability button and close overlay", priority=43)
	public void step44_ClickOnInStoreAvailabilityButtonAndCloseOverlay() throws Exception
	{
		productdetailspage.ClickonInStoreAvailabilitybtnAndCloseOverlayInPDP();
	}
	
	@Test(description="Verified Contact Us link", priority=44)
	public void step45_VerifiedContactUslink() throws Exception
	{
		productdetailspage.VerifyContactUsLinkInPDP();
	}
	
	@Test(description="Verified Size Guide option, Click on Size Guide and close overlay", priority=45)
	public void step46_ClickOnSizeGuideAndCloseOverlay() throws Exception
	{
	 productdetailspage.pdpSizeguideInfo();
	}
	
	@Test(description="Click On Select_Your_Size Button and Select any Size", priority=46)
	public void step47_ClickOnSelectYourSizeButtonAndSelectAnySize() throws Exception
	{	
		productdetailspage.ClickOnSelectYourSizeBtnAndSelectAnySizeInPDP();
		Size=ProductDetailsPage.GetSizeOfProd;
		productdetailspage.pdpNotification_Closebtn();
	}
	
	@Test(description="Click on Product Info and Verified content under Product Info section", priority=47)
	public void step48_ClickonProductInfoAndVerifiedContent() throws Exception
	{
		productdetailspage.pdpProductInfoBlock();
		ref_searchable_SKUID=ProductDetailsPage.Ref_searchable_sku;
	}
	
	@Test(description="Click on Product Care and Verified content under Product Care section", priority=48)
	public void step49_ClickonProductCareAndVerifiedContent() throws Exception
	{
		productdetailspage.pdpProductCareBlock();
	}
	
	@Test(description="Click on Shipping and Verified content under Shipping section", priority=49)
	public void step50_ClickonShippingAndVerifiedContent() throws Exception
	{
		productdetailspage.pdpShippingBlock();
	}  
	
	@Test(priority=50,description="Verify PDP main and thumbnail image")
	public void step51_VerifyMainThumbnailImg() throws Exception
	{
	productdetailspage.pdpMainimage();
	}
	
	@Test(description="Click on Add To Cart Button", priority=51)
	public void step52_ClickonAddToCartButton() throws Exception
	{
		productdetailspage.pdpAddtoCartbtn();
	} 
	
	@Test(priority=52,description="Verification of PDP notification block")
	public void step53_VerifiedPDPConfirmationMessagePopUPModal() throws Exception
	{
		productdetailspage.pdpProductadd_Notification();
	} 
	
	@Test(priority=53,description="close the Confirmation Message PopUP Modal")
	public void step54_ClosePDPConfirmationMessagePopUPModal() throws Exception
	{
	productdetailspage.pdpNotification_Closebtn();
	}
	
	@Test(description="Select different size & Click on Add To Cart Button", priority=54)
	public void step55_ClickonAddToCartButton() throws Exception
	{
		productdetailspage.driver.findElement(By.xpath(ObjRepoProp.get().getProperty("PDP_Sizebtn"))).click();
		Thread.sleep(2000);
		productdetailspage.driver.findElement(By.xpath(ObjRepoProp.get().getProperty("PDP_SelectedSecondSize"))).click();
		Thread.sleep(2000);
		productdetailspage.pdpAddtoCartbtn();
	} 
	
	@Test(priority=55,description="Verification of PDP notification block")
	public void step56_VerifiedPDPConfirmationMessagePopUPModal() throws Exception
	{
		productdetailspage.pdpProductadd_Notification();
	} 

	@Test(description="Click on 'your cart' link from confirmation pop up", priority=56)
	public void step57_ClickonYourCartLinkInConfirmationOverlay() throws Exception
	{
		productdetailspage.driver.findElement(By.xpath(ObjRepoProp.get().getProperty("MiniCP_YourCart_txt"))).click();
		log.info("Successfully Clicked on Your Cart link from Confirmation pop up");
		Reporter.log("<p>Successfully Clicked on Your Cart link from Confirmation pop up");
	}

	@Test(description="Verified My Cart Header in My Cart Page", priority=57)
	public void step58_VerifiedMyCartHeaderInMCP() throws Exception
	{
		cartpage=new CartPage(productdetailspage.driver);
		cartpage.VerifyMyCartHeaderHeader();
	}
	
	@Test(priority=58,description="verify product details in main cart")
	public void step59_VerifyDetails_MainCart() throws Exception
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
	
	@Test(priority=59,description="Click on Decrease qty(-) icon")
	public void step60_ClickOnDecreaseQtyIcon() throws Exception
	{	
		cartpage.Click_ON_DecrQuantity_Maincart();
		CustomFun.waitForPageLoaded(cartpage.driver);
		cartpage.driver.findElement(By.xpath("//input[contains(@class,'input-text qty')]")).click();
		Assert.assertEquals(cartpage.driver.findElements(By.xpath("//img[@class='photo image product-image-photo']")).size(),1);
		log.info("Successfully Verified reduced quantity of product by 1");
		Reporter.log("<p>Successfully Verified reduced quantity of product by 1");
	}
	
	@Test(priority=60,description="Comparing Total Correct Summary Amount After Removing One Product Qnty in My Cart Page")
	public void step61_ComparingTotalCorrectSummaryAmountAfterRemovingOneProductQnty() throws Exception
	{	
		GUIFunctions.ComparingTotalCorrectSummaryAmountAfterRemovingOneProductQnty(cartpage.driver, TotalAmountSummary);
	}
	
	@Test(priority=61,description="click on proceed to checkout CTA")
	public void step62_ClickOnProceedToCheckOutCTA() throws Exception
	{	
		cartpage.Click_ON_ProceedToCheckOut_Maincart();
		CustomFun.waitForPageLoaded(cartpage.driver);
	}
	
	@Test(priority=62,description="Verify First & Last Name, Email and Logout text at Checkout Step 1")
	public void step63_VerifyLoginSectionAtCheckoutStep1() throws Exception
	{	
		checkoutpage=new CheckoutPage(cartpage.driver);
		checkoutpage.VerifyLoginSectionAtCheckoutStep1();
	}
	
	@Test(description="Verified Gift Options Header in Checkout Page", priority=63)
	public void step64_VerifiedGiftOptionsHeaderInCP() throws Exception
	{
		checkoutpage=new CheckoutPage(productdetailspage.driver);
		checkoutpage.VerifyGiftHeadertxt();
	}
	
	@Test(description="Verify No Wrap Img is auto selected", priority=64)
	public void step65_ScrollDownTillGiftWrappingImgAndSelectedInCP() throws Exception
	{
		checkoutpage.VerifyNoWarpImgIsSelected();
	}
	
	@Test(description="Click on Update Button in Checkout Page at Gift Section", priority=65)
	public void step66_ClickOnUpdateButtonInCP() throws Exception
	{
		checkoutpage.UpdatebtnClick();
	} 
	
	@Test(description="Shipping Address Header in Checkout Page at Shipping Address Section", priority=66)
	public void step67_VerifiedShippingAddressHeaderInCP() throws Exception
	{
		shippingaddresspage=new ShippingAddressPage(checkoutpage.driver);
		shippingaddresspage.VerifyShippingAddressHeader();
	}
	
	@Test(description = "Open New Tab and Navigated to WMS", priority = 67)
	public void step68_OpenNewTabAndNavigatedtoWMS() throws Exception {
		wmspage = new WMSPage(homepage.driver);
		CustomFun.OpenNewTabAndSwitchToNewTab(wmspage.driver, "2");
		wmspage.driver.navigate().to(CustomFun.getWMSInfoDSDetails().get().getWMSURL());
	}

	@Test(description = "Logged into WMS with valid crendentials", priority = 68)
	public void step69_LoggedIntoWMS() throws Exception {
		wmspage.WMSLogIn(CustomFun.getWMSInfoDSDetails().get().getWmsUsername(),
				CustomFun.getWMSInfoDSDetails().get().getWmsPassword());
	}

	@Test(description = "Click on OK button in WMS", priority = 69)
	public void step70_ClickOnOKbutton() throws Exception {
		    wmspage.Click_WMSOKBtn();
	}

	@Test(description = "Mouse Over on Data Lists Menu", priority = 70)
	public void step71_MouseOverElementOnDataListsMenu() throws Exception {
		wmspage.WMS_Datalistmenu();
	}

	@Test(description = "Click on Products from Data Lists", priority = 71)
	public void step72_ClickOnProductsFromDataLists() throws Exception {
		wmspage.WMS_Datalist_Productclick();
	}

	@Test(description = "Enter Searchable SKU & Click on Submit Filter", priority = 72)
	public void step73_EnterSearchableSKUAndClickOnSubmitFilter() throws Exception {
		wmspage.SearchSKUIDInListOfProducts(ref_searchable_SKUID, Size);
		BarCodeSKU=WMSPage.barcodeSKU;
	}

	@Test(description = "Click on Details Button", priority = 73)
	public void step74_ClickOnDetailsButtonForSimpleProd() throws Exception {
		wmspage.ClickOnDetailsButton(Size);
	}

	@Test(description = "Scroll down till stocks grid and Verify Initial Saleable Stock", priority = 74)
	public void step75_VerifyInitialSaleableStock() throws Exception {
		wmspage.VerifyInitialSaleableStock();
	}

	@Test(description = "Verify Reserved Stock", priority = 75)
	public void step76_VerifyReservedStock() throws Exception {
		wmspage.VerifyInitialReservedStock();
	}

	@Test(description = "Navigated back into Magento BO & Click on Catalog Icon", priority = 81)
	public void step82_NavigatedIntoMagentoBOAndClickOnCatalogIcon() throws Exception {
		CustomFun.SwitchToSpecificTab(wmspage.driver, "1");
		backofficepage.CatalogIconClick();
	}

	@Test(description = "Click on Products text from Catalog Icon", priority = 82)
	public void step83_ClickProductstxtFromCatalogIcon() throws Exception {
		backofficepage.ProductstxtFromCatalogIconClick();
	}

	@Test(description = "Search For Product Seleable Stock In BO", priority = 83)
	public void step84_SearchForProductSeleableStockInBO() throws Exception {
        backofficepage.SearchForProductSeleableStockInBO(BarCodeSKU);
	}

	@Test(description = "Verify Initial Saleable Stock", priority = 84)
	public void step85_VerifyInitialSaleableStock() throws Exception {
		backofficepage.VerifyInitialSaleableStockInBO(BarCodeSKU);
	}
	
	@Test(description="Navigated Into FO & Verified Product Name under Order summary in Checkout Page at Shipping Address Section", priority=85)
	public void step86_NavigatedIntoFOAndVerifiedProductNameinPDP() throws Exception
	{
		CustomFun.SwitchToSpecificTab(homepage.driver, "0");
		checkoutpage=new CheckoutPage(productdetailspage.driver);
		checkoutpage.VerifyProductNametxtInCP();
	}
	
	@Test(description="Verified Product Price under order summary in Checkout Page at Shipping Address Section", priority=86)
	public void step87_VerifiedProductPriceinPDP() throws Exception
	{
		checkoutpage.VerifyProductPricetxtInCP();
	}
	
	@Test(description="Entered Address Name in Address Name Field", priority=88)
	public void step89_EnteredAddressNameField() throws Exception
	{
		shippingaddresspage.EnterAddressName_AsEU(CustomFun.getAddressDSDetails().get().getAddressName());
	}
	
	@Test(description="Verified Prefix Name Dropdown is Auto Selected or not at Shipping Address Section", priority=89)
	public void step90_VerifiedPrefixNameDpdIsAutoSelectedOrNot() throws Exception
	{
		shippingaddresspage.VerifyPrefixDpdIsAutoSelected_AsEU(CustomFun.getAddressDSDetails().get().getNamePrefix());
	}
	
	@Test(description="Entered First Name in First Name Field", priority=90)
	public void step91_EnteredFirstNameField() throws Exception
	{
		shippingaddresspage.EnterFirstNameField_AsEU(CustomFun.getAddressDSDetails().get().getFirstName());
	}
	
	@Test(description="Entered Last Name in Last Name Field", priority=91)
	public void step92_EnteredLastNameField() throws Exception
	{
		shippingaddresspage.EnterLastNameField_AsEU(CustomFun.getAddressDSDetails().get().getLastName());
	}
	
	@Test(description="Entered Address in Address Field", priority=92)
	public void step93_EnteredAddressField() throws Exception
	{
		shippingaddresspage.EnterAddressDetails_AsEU(CustomFun.getAddressDSDetails().get().getAddress1());
	}
	
	@Test(description="Entered PostCode in PostCode Field", priority=93)
	public void step94_EnteredPostCodeField() throws Exception
	{
		shippingaddresspage.EnterPostcode_AsEU(CustomFun.getAddressDSDetails().get().getPostcode());
	}
	
	@Test(description="Entered City in City Field", priority=94)
	public void step95_EnteredCityField() throws Exception
	{
		if(locale.get().contains("CH_FR"))
		  {
			  shippingaddresspage.EnterCity_AsEU(CustomFun.getAddressDSDetails().get().getCity());
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
			  shippingaddresspage.EnterCity_AsEU(CustomFun.getBillingAddressDSDetails().get().getCity());
		  }
	}
	
	@Test(description="Entered Phone Number in Phone Number Field", priority=95)
	public void step96_EnteredPhoneNumberField() throws Exception
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
	
	@Test(description="Verified Shipping Methods Header in Checkout Page at Shipping Methods Section", priority=97)
	public void step98_VerifiedShippingMethodsHeaderInCP() throws Exception
	{
		shippingaddresspage.VerifyShippingMethodLabel();
	}
	
	@Test(description="Click on Second Shipping Method radio button in Checkout page", priority=98)
	public void step99_ClickOnSecondShipMethodRadioButton() throws Exception
	{
		if(environmentName.equals("StagingEnv1"))
		{
		 //  shippingaddresspage.driver.findElement(By.xpath("(//span[contains(@data-bind, 'My billing and shipping address are the same')])[1]")).click();
		 // Thread.sleep(1000);
		 // shippingaddresspage.AddBillingAddressatShippingAddressPage();
		}
		shippingaddresspage.VerifyAndClickOnSecondShippingmethod();
	}
	
	@Test(description="Click on Continue To Payemnt button in Checkout page", priority=99)
	public void step100_ClickOnContinueToPayemntButton() throws Exception
	{
		shippingaddresspage.ContinuetopaymentbtnClick();
	}
	
	@Test(description="Scroll down till Payment options and Verified Payment options in Checkout Page", priority=100)
	public void step101_VerifiedPaymentoptions() throws Exception
	{
		paymentpage=new PaymentPage(shippingaddresspage.driver);
		paymentpage.checkout_Paymentoptions();
	}
	
	@Test(description="Click on Credit card Radio button under Payment option", priority=101)
	public void step102_ClickOnCreditCardRadioBtn() throws Exception
	{
		paymentpage.checkout_Creditcard();
	}
	
	@Test(description="Verified My billing and shipping address are the same checkbox is auto selected or not", priority=102)
	public void step103_VerifiedMyBAandSABothSame_CheckboxIsAutoSelected() throws Exception
	{
		shippingaddresspage=new ShippingAddressPage(paymentpage.driver);
	}
	
	@Test(description="Unchecked My billing and shipping address are the same checkbox", priority=103)
	public void step104_UncheckMyBAandSABothSame_Checkbox() throws Exception
	{
		
	}
	
	@Test(priority=104,description="Entered Address Name in Address Name Field")
	public void step105_EnteredAddressNameField() throws Exception
	{
		
	}
	
	@Test(priority=105,description="select Prefix Name Dropdown in Shipping Address Section")
	public void step106_SelectPrefixNameDpdn() throws Exception
	{
		
	}

	@Test(priority=106,description="Entered First Name in First Name Field")
	public void step107_EnteredFirstNameField() throws Exception
	{
		
	}

	@Test(priority=107,description="Entered Last Name in Last Name Field")
	public void step108_EnteredLastNameField() throws Exception
	{
		
	}

	@Test(priority=108,description="Entered Address in Address Field")
	public void step109_EnteredAddressField() throws Exception
	{
		
	}

	@Test(priority=109,description="Entered PostCode in PostCode Field")
	public void step110_EnteredPostCodeField() throws Exception
	{
		
	}

	@Test(priority=110,description="Entered City in City Field")
	public void step111_EnteredCityField() throws Exception
	{
		
	}

	@Test(priority=111,description="verified default Country selected in country Field")
	public void step112_VerifiedCountryField() throws Exception
	{
		 
	}
	
	@Test(priority=112,description="Entered Phone Number in Phone Number Field")
	public void step113_EnterPhoneNumField() throws Exception
	{

	}
	
	@Test(priority=113,description="click on update btn")
	public void step114_ClickOnUpdateBtn() throws Exception
	{
	   paymentpage=new PaymentPage(shippingaddresspage.driver);
	}
	
	@Test(priority=114,description="Entered Credit Number in Credit Number Field")
	public void step115_EnteredCreditNumberField() throws Exception
	{
		GUIFunctions.scrollByJavaScriptExecutor(paymentpage.driver.findElement(By.xpath("//li[@id='payment']")), paymentpage.driver, "Payment Options");
		paymentpage.checkout_CCCardnumber(CustomFun.getPaymentDSDetails().get().getCardNumber());
	}
	
	@Test(priority=115,description="Entered Expiry Date in Expiry Date Field")
	public void step116_EnteredExpiryDateField() throws Exception
	{
		paymentpage.checkout_CCExpirydate(CustomFun.getPaymentDSDetails().get().getCardExpiryDate());
	}
	
	@Test(priority=116,description="Entered CVV in CVV Field")
	public void step117_EnteredCVVField() throws Exception
	{
		paymentpage.checkout_CCV(CustomFun.getPaymentDSDetails().get().getCardCVV());
	}	
	
	@Test(priority=117,description="Entered CardHolder Name in CardHolder Name Field")
	public void step118_EnteredCardHolderField() throws Exception
	{
		paymentpage.checkout_Cardholdername(CustomFun.getPaymentDSDetails().get().getCardHolderName());
	}
	
	@Test(priority=118,description="Checked on Privacy Policy and Return Policy checkbox")
	public void step119_CheckedOnPrivacyPolicyAndReturnPolicyCheckbox() throws Exception
	{
			paymentpage.checkout_Agreements_CreditCard();
	}
	
	@Test(priority=119,description="Click on Proceed button in Checkout page at Payment Section")
	public void step120_ClickOnProceedButtonAtPaymentSection() throws Exception
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
	
	@Test(priority=120,description="Verified Success Message in Order Confirmation page after placing the order")
	public void step121_VerifiedSuccessMsgAfterPlacingOrder() throws Exception
	{
	orderconfirmationpage=new OrderConfirmationPage(paymentpage.driver);
	CustomFun.waitForPageLoaded(orderconfirmationpage.driver);
	orderconfirmationpage.Verify_SuccessOrder_Msg_txt();
	}
	
	@Test(priority=121,description="Verified Your OrderID in Order Confirmation page")
	public void step122_VerifiedYourOrderID() throws Exception
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
	
	@Test(description="Click on My Account Icon", priority=122)
	public void step123_ClickOnMyAccountIcon() throws Exception
	{
		homepage.driver.findElement(By.xpath(ObjRepoProp.get().getProperty("HP_MyAccount_Icon"))).click();
	}
	
	@Test(description="Click on My Orders Link", priority=123)
	public void step124_ClickOnMyOrdersLink() throws Exception
	{
		myaccountpage=new MyAccountPage(orderconfirmationpage.driver);
		myaccountpage.MyOrders_LnkClick();
	}
	
	@Test(description = "Verified Order Status & Other Details in My Orders page", priority = 124)
	public void step125_VerifiedOrderStatusInMyOrdersPage() throws Exception {
		myaccountpage.VerifyOrderStatus(OrderID);
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
		myaccountpage.VerifyOrderPriceInOrderspage(OrderID);
		myaccountpage.VerifyOrderItemInOrderspage(OrderID);
		myaccountpage.VerifyOrderDateInOrderspage(OrderID);
	}
	
	@Test(description="Navigated Back to Magento & Click on Sales Icon", priority=126)
	public void step127_NavigatedBackToMagentoAndClickOnSalesIcon() throws Exception
	{
		CustomFun.SwitchToSpecificTab(backofficepage.driver, "1");
		backofficepage.SalesIconClick();
	}
	
	@Test(description="Click on Orders text from Sales Icon", priority=127)
	public void step128_ClickOrderstxtFromSalesIcon() throws Exception
	{
		backofficepage.OrderstxtFromSalesIconClick();
	}
	
	@Test(description="Verified Orders Header & check whether user is in Orders page", priority=128)
	public void step129_VerifiedOrdersHeaderInBO() throws Exception
	{
		backofficepage.VerifyOrdersHeadertxt();
	}
	
	@Test(priority=129,description="Verified Order Status in Orders page")
	public void step130_VerifiedOrderStatusInOrdersPage() throws Exception
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
	   //  CustomFun.waitObjectToLoad(backofficepage.driver, By.xpath("//button[text()='Clear all']"), 20000);
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
		for(int i=0;i<=5;i++)
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
	
	@Test(priority=130,description="Open New Tab and Navigated to Adyen")
	public void step131_OpenNewTabAndNavigatedtoAdyen() throws Exception
	{
	   adyenpage=new AdyenPage(backofficepage.driver);
       CustomFun.OpenNewTabAndSwitchToNewTab(adyenpage.driver, "3");
       adyenpage.driver.navigate().to(CustomFun.getAdyenInfoDSDetails().get().getAdyenUrl());
	} 

	
	@Test(priority=131,description="Logged into Adyen with valid crendentials")
	public void step132_LoggedIntoAdyen() throws Exception
	{
		adyenpage=new AdyenPage(backofficepage.driver);
		adyenpage.AdyenLogIn(CustomFun.getAdyenInfoDSDetails().get().getAdyenUsername(),CustomFun.getAdyenInfoDSDetails().get().getAdyenAccount(),CustomFun.getAdyenInfoDSDetails().get().getAdyenPassword());
	}
	
     @Test(priority=132,description="Click on Risk option from Case management")
	public void step133_ClickCaseMgmtOPtionINAdyen() throws Exception
	{
    	adyenpage.Click_AdyenRiskTab();
		adyenpage.Click_AdyenCaseMgmtTab();
	}
	
	
	@Test(priority=133,description="verify the order id in Adyen and select the checkbox")
	public void step134_ClickOrderIDCheckbox() throws Exception
	{
		adyenpage.Verify_OrderIDandClickCheckbox(OrderID);	
	}  
	
	@Test(priority=134,description="Click on accept and ok in Adyen")
	public void step135_ClickOnRejectedBtn() throws Exception
	{
		adyenpage.Click_AdyenOrderRejectBtn();
	} 
	
	 @Test(description="Click on payment option from Transaction", priority=135)
	 public void step136_ClickOnPaymentOptionFromTransaction() throws Exception
	 {
	    adyenpage.Click_AdyenTransactionTab();
	    adyenpage.Click_AdyenTransactionPaymentTab();
	 }
	    
	 @Test(description="Enter order Id in serach bar ", priority=136)
	 public void step137_EnterOrderIDinPaymentTab_adyen() throws Exception
	 {
	   adyenpage.Enter_AdyenPaymentSearchField(OrderID);
	   CustomFun.waitForPageLoaded(adyenpage.driver);
	 }

	 @Test(description="Verify order status of SentForRefund in Adyen ", priority=137)
	 public void step138_VerifyOrderRMAStatusIN_adyen() throws Exception
	 {
	    	for(int i=0;i<=5;i++)
	    	{
	    	Thread.sleep(60000);
	    	CustomFun.refreshPage(adyenpage.driver);
	    	Thread.sleep(5000);
	    	adyenpage.Verify_AdyenOrderIDStatus(OrderID);
	    	OrderStatus=AdyenPage.OrderStatusFromAdyen;
	    	if(OrderStatus.contains(TextProp.get().getProperty("Adyen_Cancelled")))
	    	{
	    		OrderStatus=AdyenPage.OrderStatusFromAdyen;
	    		Assert.assertEquals(TextProp.get().getProperty("Adyen_Cancelled"), OrderStatus);
		    	log.info("Successfully Verified Order Status is Cancelled after rejecting the order: " + OrderStatus);
		    	Reporter.log("<p>Successfully Verified Order Status is Cancelled after rejecting the order: " + OrderStatus);
		    	break;
	    	}
	        } 
	  }
	 
	 @Test(description="Navigated Into Magento and Click on Sales Icon", priority=138)
	 public void step139_NavigatedIntoMangetoAndVerifiedOrderStatusInOrdersPage() throws Exception
	 {
		  CustomFun.SwitchToSpecificTab(backofficepage.driver, "1");
		  backofficepage.SalesIconClick();
	 }
	 
	 @Test(description="Click on Orders text from Sales Icon", priority=139)
	 public void step140_ClickOrderstxtFromSalesIcon() throws Exception
	 {
		  backofficepage.OrderstxtFromSalesIconClick();
	 }
	 
	 @Test(description="Verified Order Status in Orders page", priority=140)
     public void step141_VerifiedOrderStatusInOrdersPage() throws Exception
	 {	
	    	for(int i=0;i<=2;i++)
			{
			  Thread.sleep(10000);
			  backofficepage.ClearTheFilterInBO(OrderID);
				backofficepage.VerifyOrderStatusInBO_OrdersPage(OrderID);
			  OrderStatus=BackOfficePage.OrderStatus;
			  if(OrderStatus.contains(TextProp.get().getProperty("Canceltxt")))
			  {
				  OrderStatus=BackOfficePage.OrderStatus;
				  Assert.assertEquals(TextProp.get().getProperty("Canceltxt"), OrderStatus);
				  log.info("Successfully Verified Order Status in Magento After Rejecting the order in Adyen: " + OrderStatus);
				  Reporter.log("<p>Successfully Verified Order Status in Magento After Rejecting the order in Adyen: " + OrderStatus);
				  break;
			  }
			}
	  }
	 
	 @Test(description="Navigated back into FO & Click on My Account Icon", priority=141)
	 public void step142_ClickOnMyAccountIcon() throws Exception
	 {
		 CustomFun.SwitchToSpecificTab(backofficepage.driver, "0");
		 homepage.driver.findElement(By.xpath(ObjRepoProp.get().getProperty("HP_MyAccount_Icon"))).click();
	 }
		
	 @Test(description="Click on My Orders Link", priority=142)
	 public void step143_ClickOnMyOrdersLink() throws Exception
	 {
			myaccountpage=new MyAccountPage(orderconfirmationpage.driver);
			myaccountpage.MyOrders_LnkClick();
	 }
		
	 @Test(description = "Verified Order Status & Other Details in My Orders page", priority = 143)
	 public void step144_VerifiedOrderStatusInMyOrdersPage() throws Exception
	 {
			myaccountpage.VerifyOrderStatus(OrderID);
		/*	if(locale.get().contains("FR_FR") | locale.get().contains("CH_FR"))
			{
			Assert.assertEquals(MyAccountPage.OrderStatusFromFO,TextProp.get().getProperty("CancelledOrdertxt_FR"));
			}
			else
			{
				Assert.assertEquals(MyAccountPage.OrderStatusFromFO,TextProp.get().getProperty("CancelledOrdertxt_UK"));
			} */
	 }
	 
	 @Test(description="Comparing the Seleable stock in the WMS and the BO Magento after Rejecting the order", priority=144)
	 public void step145_ComparedSeleableStockInWMSAndBOBothAreSameAfterRejectingTheOrder() throws Exception
	 {
	    //Verify Seleable Stock in WMS after Rejecting the order
	    CustomFun.SwitchToSpecificTab(wmspage.driver, "2");
	    wmspage.WMS_Datalistmenu();
	    wmspage.WMS_Datalist_Productclick();
	    wmspage.ClickOnDetailsButton(Size);
	    wmspage.VerifySaleableStockIncBy1InWMSAfterRefundTheOrder();
	    wmspage.VerifyInitialReservedStock();
	    //Verify Seleable Stock in BO after Rejecting the order
	    CustomFun.SwitchToSpecificTab(backofficepage.driver, "1");
	    backofficepage.CatalogIconClick();
	    backofficepage.ProductstxtFromCatalogIconClick();
	    backofficepage.SearchForProductSeleableStockInBO(BarCodeSKU);
	    backofficepage.VerifySaleableStockQntyIncBy1InBOAferRefundTheOrder(BarCodeSKU);
	    //Assert.assertEquals(BackOfficePage.InitialSaleableStock_BO, WMSPage.InitialSaleableStock_WMS, "Stock in the WMS and the Bo Magento both are same after Rejecting the order");
	  }
        
        @Test(description="Verify Account creation Confirmation Mail Contents", priority=146)
	    public void step147_VerifyAccountCreationConfirmationMailContents() throws InterruptedException
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
		
		@Test(description="Verify Order Confirmation Mail Contents", priority=147)
		public void step148_VerifyOrderConfirmationMailContents() throws InterruptedException
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
}
