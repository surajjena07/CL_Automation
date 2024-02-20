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
* @author Veena
*
*/
public class TC_Scenario_08 extends BaseTest
{

	public Logger log = Logger.getLogger(this.getClass().getName());
	public static String OrderID=OrderConfirmationPage.OrderConfirmationId;
	public String OrderStatus; 
	public MyAccountPage RMA_ID_FO;
	public String RefundMemoID;
	public static String RMAIDStatus;
	public static String RMAID;
	public static String CreatedRMAOrderID_FromOffline=BackOfficePage.NewOrderFor_RMAOffline;
	public String ShipmentID;
	public static String ref_searchable_SKUID;
	public static String BarCodeSKU;
	public String ExpProductLineItem;
	public String ExpSubTotal;
	public String ExpTax;
	public String ExpGrandTotal;
	public String ExpShippingAndHandling;
	public String OrderPrice;
	public String BarCodeForScan;
	
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
	
	@Test(description="Navigated to CL Home Page", priority=1)
	public void step01_NavigatedtoCLHomePage() throws Exception
	{
    logtest("Create a Refund Credit memo with approving the first product and rejecting the second product with 3DS credit card and newly created user");
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
		for (int i = 0; i <= 2; i++)
		{
			Thread.sleep(2000);
			CustomFun.refreshPage(homepage.driver);
			Thread.sleep(2000);
		}
		GUIFunctions.pageScrollToTopOfPage(homepage.driver);
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
		CustomFun.refreshPage(myaccountpage.driver);
		Thread.sleep(2000);
		myaccountpage.VerifySuccessMsgForRegister();
	}  
	
	
	@Test(priority=23, description=" Verify username text  ")
	public void step23_VerifyUserNameInMYAccount() throws Exception
	{	
	CustomFun.waitForPageLoaded(myaccountpage.driver);
	CustomFun.refreshPage(myaccountpage.driver);
	Thread.sleep(2000);
	myaccountpage.Verify_Usernametxt();
    } 
    
	@Test(priority=24, description="Verified My account page content's")
	public void step24_VerifiedMyAccountPageContents() throws Exception
	{
		CustomFun.refreshPage(myaccountpage.driver);
		Thread.sleep(2000);
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
	
	@Test(priority=25, description="Mouseover on L1 beauty category  ")
	public void step25_MouseoverOnL1BeautyCategory() throws Exception
	{
	    homepage.mousehoverOnL1BeautyHeaderNavigation();
    }
	
	@Test(priority=26, description="CLick on L2 lips category  ")
	public void step26_ClickOnL2LipsCategory() throws Exception
	{
	if(environmentName.contains("HomoEnv"))	
	{
	homepage.ClickOnL2LipsNavigation();
	}
	else
    if(environmentName.contains("IntegrationEnv"))
	{
    	homepage.ClickOnL2LipsNavigation();
	}
    else
    {
    	categorylandingpage=new CategoryLandingPage(homepage.driver);
    	categorylandingpage.BeautyL2EyeCategoryClick();
    }
    }
	
	@Test(priority=28, description=" Click on image from PLP ")
	public void step28_ClickOnProductImg() throws Exception
	{
		System.out.println(environmentName);
		if(environmentName.contains("HomoEnv"))	
		{
		    productlistingpage=new ProductListingPage(homepage.driver);
		    productlistingpage.Click_ProductImg3();
		}
		else
		if(environmentName.contains("IntegrationEnv"))
		{
			productlistingpage=new ProductListingPage(homepage.driver);
		    productlistingpage.Click_ProductImg();
		}
		else
		if(environmentName.contains("StagingEnv1"))
		{
			productlistingpage=new ProductListingPage(homepage.driver);
			productlistingpage.Click_ProductImg3();
		}
		else
		{
			productlistingpage=new ProductListingPage(homepage.driver);
			productlistingpage.driver.findElement(By.xpath("((//h2[contains(text(),'Mascara') or contains(text(),'sourcils') or contains(text(),'pencils')])/../following-sibling::div//div)[8]")).click();
		}
	}
	
	@Test( priority=29, description="Verified Product Name in Product Details Page")
	public void step29_VerifiedProductNameinPDP() throws Exception
	{
	productdetailspage=new ProductDetailsPage(productlistingpage.driver);
	productdetailspage.VerifyProductNametxtInPDP();
	}    

	@Test(priority=30, description="Verified Product brand name in Product Details Page" )
	public void step30_VerifiedProductBrandNametxtInPDP() throws Exception
	{
	productdetailspage.VerifyProductBrandNametxtInPDP();
	}
	
	@Test(priority=31, description="Verified Product Price in Product Details Page" )
	public void step31_VerifiedProductPriceinPDP() throws Exception
	{
	productdetailspage.VerifyProductPricetxtInPDP();
	}
	
	@Test(priority=32, description="Verified Add to cart button in Product Details Page" )
	public void step32_VerifiedAddtoCartbtnInPDP() throws Exception
	{
	productdetailspage.VerifyAddtoCartbtnInPDP();
	}
	
	@Test(priority=33,description="Click on In_store_availability button and close overlay" )
	public void step33_ClickOnInStoreAvailabilityButtonAndCloseOverlay() throws Exception
	{
	productdetailspage.ClickonInStoreAvailabilitybtnAndCloseOverlayForSimpleProductInPDP();
	}

	@Test(priority=34,description="Verified Contact Us link")
	public void step34_VerifiedContactUslink() throws Exception
	{
	productdetailspage.VerifyContactUsLinkInPDP();
	}

	@Test(priority=35,description="Verified Color swatches in PDP")
	public void step35_VerifiedColorSwatches() throws Exception
	{
	productdetailspage.pdpColorSwatches();
	}
	
	@Test(priority=36,description="Click on Product Info and Verified content under Product Info section")
	public void step36_ClickonProductInfoAndVerifiedContent() throws Exception
	{
	productdetailspage.pdpProductInfoBlockForBeautyProd();
	ref_searchable_SKUID=ProductDetailsPage.Ref_searchable_sku_SimpleProd;
	}

	@Test(priority=37,description="Click on Shipping and Verified content under Shipping section")
	public void step37_ClickonShippingAndVerifiedContent() throws Exception
	{
	productdetailspage.pdpShippingBlock();
	}

	@Test(priority=38,description="Verify PDP main and thumbnail image ")
	public void step38_VerifyMainThumbnailImg() throws Exception
	{
	productdetailspage.pdpMainimage();
	}
	
	@Test(priority=39,description="Click on Add To Cart Button")
	public void step39_ClickonAddToCartButton() throws Exception
	{
	productdetailspage.pdpAddtoCartbtn();
	
	}  
	
	@Test(priority=40,description="Verification of PDP notification block")
	public void step40_VerifiedPDPConfirmationMessagePopUPModal() throws Exception
	{
		productdetailspage.pdpProductadd_Notification();
	} 
	
	@Test(priority=41,description="Verification of Continue shopping and  order now btn in PDP notification block")
	public void step41_VerifiedContinueShoppingAndOrderNowBTn() throws Exception
	{
		productdetailspage.pdpNotification_ContinebtnOrderNow();
	}
	
	
	@Test(priority=42,description="Click on continue shopping btn")
	public void step42_ClickOnContinueShoppingBtn() throws Exception
	{
		productdetailspage.pdpNotification_Continebtn();
	}  
	
	
	@Test(priority=43, description=" Mouseover on Men Header navigation ")
	public void step43_MouseOverOnMenHeaderNavigation() throws Exception
	{
	GUIFunctions.pageScrollToTopOfPage(productdetailspage.driver);
	homepage=new HomePage(productdetailspage.driver);
	if(environmentName.contains("IntegrationEnv"))	
	{
		homepage.mousehoverOnLadiesHeaderNavigation();
		log.info("Mouseover on Ladies Header navigation");
	}
	else
	{
		homepage.mousehoverOnLadiesHeaderNavigation();
		log.info("Mouseover on Ladies Header navigation");
	}
	} 
	
	@Test(priority=44, description=" Click On shoes Subcategory ")
	public void step44_ClickOnShoesSubcategory() throws Exception
	{	
		if(environmentName.contains("IntegrationEnv"))	
		{
			homepage.ClickOnL2IrizaCategory();
		}
		else
		{
			homepage.ClickOnL2IrizaCategory();
		}
	} 
	
	@Test(priority=45, description=" Click on product from PLP ")
	public void step45_ClickOnProductImg() throws Exception
	{
		productlistingpage=new ProductListingPage(homepage.driver);
		productlistingpage.Click_ProductImg();
	}
	
	@Test( priority=46,description="Click On Select_Your_Size Button and Select any Size")
	public void step46_ClickOnSelectYourSizeButtonAndSelectAnySize() throws Exception
	{
	productdetailspage=new ProductDetailsPage(productlistingpage.driver);
	productdetailspage.ClickOnSelectYourSizeBtnAndSelectAnySizeInPDP();
	}
	
	@Test(priority=47,description="Click on Add To Cart Button")
	public void step47_ClickonAddToCartButton() throws Exception
	{
	productdetailspage.pdpAddtoCartbtn();
	
	}

	@Test(priority=48,description="Click on Your cart link")
	public void step48_ClickonYourCartLnk() throws Exception
	{
		productdetailspage.Click_ON_YourCartLnk_Minicart();
	} 
	
	@Test(priority=49,description="Verify product details in Main cart page")
	public void step49_VerifyProductDetailsInMainCart() throws Exception
	{
		cartpage=new CartPage(productdetailspage.driver);
		cartpage.Verify_Product_Details_InMainCart();
		cartpage.VerifyContactusCheckoutCTA_Maincart();
	
	} 
	
	@Test(priority=50,description="click on proceed to checkout CTA")
	public void step50_ClickOnProceedToCheckOutCTA() throws Exception
	{
		cartpage.Click_ON_ProceedToCheckOut_Maincart();
	}
	
	
	@Test(description="Open New Tab and Navigated to WMS", priority=51)
	public void step51_OpenNewTabAndNavigatedtoWMS() throws Exception
	{
	wmspage=new WMSPage(cartpage.driver);
	CustomFun.OpenNewTabAndSwitchToNewTab(wmspage.driver, "2");
	wmspage.driver.navigate().to(CustomFun.getWMSInfoDSDetails().get().getWMSURL());
	}

	@Test(description="Logged into WMS with valid crendentials", priority=52)
	public void step52_LoggedIntoWMS() throws Exception
	{
	wmspage.WMSLogIn(CustomFun.getWMSInfoDSDetails().get().getWmsUsername(),CustomFun.getWMSInfoDSDetails().get().getWmsPassword());
	}

	@Test(description="Click on OK button in WMS", priority=53)
	public void step53_ClickOnOKbutton() throws Exception
	{
	wmspage.Click_WMSOKBtn();
	}

	@Test(description="Mouse Over on Data Lists Menu", priority=54)
	public void step54_MouseOverElementOnDataListsMenu() throws Exception
	{
	wmspage.WMS_Datalistmenu();
	}

	@Test(description="Click on Products from Data Lists", priority=55)
	public void step55_ClickOnProductsFromDataLists() throws Exception
	{
	wmspage.WMS_Datalist_Productclick();
	}

	@Test(description="Enter Searchable SKU & Click on Submit Filter", priority=56)
	public void step56_EnterSearchableSKUAndClickOnSubmitFilter() throws Exception
	{
	wmspage.SearchSKUIDInListOfProductsForSimpleProd(ref_searchable_SKUID);
	BarCodeSKU=WMSPage.barcodeSKU;
	}

	@Test(description="Click on Details Button", priority=57)
	public void step57_ClickOnDetailsButton() throws Exception
	{
	wmspage.ClickOnDetailsButtonForSimpleprod();
	}

	@Test(description="Scroll down till stocks grid and Verify Initial Saleable Stock", priority=58)
	public void step58_VerifyInitialSaleableStock() throws Exception
	{
	wmspage.VerifyInitialSaleableStock();
	}

	@Test(description="Verify Reserved Stock", priority=59)
	public void step59_VerifyReservedStock() throws Exception
	{
	wmspage.VerifyInitialReservedStock();
	}
	
	
	@Test(description="Switch to Magento BO and click on Catalog Icon", priority=60)
    public void step60_OpenNewTabAndNavigatedtoMagentoBO() throws Exception
    {
	  CustomFun.SwitchToSpecificTab(backofficepage.driver, "1");		  
      backofficepage=new BackOfficePage(wmspage.driver);
      backofficepage.CatalogIconClick();
   
    }
     
    @Test(description="Click on Products text from Catalog Icon", priority=61)
    public void step61_ClickProductstxtFromCatalogIcon() throws Exception
    {
       backofficepage.ProductstxtFromCatalogIconClick();
    }
    
    @Test(description="Search For Product Seleable Stock In BO", priority=62)
    public void step62_SearchForProductSeleableStockInBO() throws Exception
    {
       backofficepage.SearchForProductSeleableStockInBO(BarCodeSKU);
    }
    
    @Test(description="Verify Initial Saleable Stock", priority=63)
    public void step63_VerifyInitialSaleableStock() throws Exception
    {
       backofficepage.VerifyInitialSaleableStockInBO(BarCodeSKU);
    }

	@Test(priority=64,description="Verify Gift default no wrap img selected ")
	public void step64_VerifyGiftHeadertextAndDefaultGiftWrapSelected() throws Exception
	{
		CustomFun.SwitchToSpecificTab(homepage.driver, "0");
		checkoutpage=new CheckoutPage(cartpage.driver);
		checkoutpage.VerifyNoWarpImgIsSelected();
	}
	
	
	@Test(priority=65,description="Enter message in Gift msg fld ")
	public void step65_EnterMsgInGiftMsgFld() throws Exception
	{
		checkoutpage.ScrollDowntillYourMsgField_EnterMsg("test");
	}
	
	@Test(priority=66,description="Click on update button ")
	public void step66_ClickUpdateBtn() throws Exception
	{
		checkoutpage.UpdatebtnClick();
	}
	
	@Test(description="Verified Shipping Address Header in Checkout Page at Shipping Address Section", priority=67)
	public void step67_VerifiedShippingAddressHeaderInCP() throws Exception
	{
	shippingaddresspage=new ShippingAddressPage(checkoutpage.driver);
	shippingaddresspage.VerifyShippingAddressHeader();
	}
	

	@Test(description="Entered Address Name in Address Name Field", priority=68)
	public void step68_EnteredAddressNameField() throws Exception
	{
	shippingaddresspage.EnterAddressName_AsEU(CustomFun.getAddressDSDetails().get().getAddressName());
	}

	@Test(description="Verified Prefix Name Dropdown is Auto Selected or not at Shipping Address Section", priority=69)
	public void step69_VerifiedPrefixNameDpdIsAutoSelectedOrNot() throws Exception
	{
	shippingaddresspage.VerifyPrefixDpdIsAutoSelected_AsEU(CustomFun.getAddressDSDetails().get().getNamePrefix());
	}

	@Test(description="Entered First Name in First Name Field", priority=70)
	public void step70_EnteredFirstNameField() throws Exception
	{
	shippingaddresspage.EnterFirstNameField_AsEU(CustomFun.getAddressDSDetails().get().getFirstName());
	}

	@Test(description="Entered Last Name in Last Name Field", priority=71)
	public void step71_EnteredLastNameField() throws Exception
	{
	shippingaddresspage.EnterLastNameField_AsEU(CustomFun.getAddressDSDetails().get().getLastName());
	}

	@Test(description="Entered Address in Address Field", priority=72)
	public void step72_EnteredAddressField() throws Exception
	{
	shippingaddresspage.EnterAddressDetails_AsEU(CustomFun.getAddressDSDetails().get().getAddress1());
	}

	@Test(description="Entered PostCode in PostCode Field", priority=73)
	public void step73_EnteredPostCodeField() throws Exception
	{
	shippingaddresspage.EnterPostcode_AsEU(CustomFun.getAddressDSDetails().get().getPostcode());
	}

	@Test(description="Entered City in City Field", priority=74)
	public void step74_EnteredCityField() throws Exception
	{
	shippingaddresspage.EnterCity_AsEU(CustomFun.getAddressDSDetails().get().getCity());
	}

	@Test(description="verified default Country selected in country Field", priority=75)
	public void step75_VerifiedCountryField() throws Exception
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
	
	@Test(description="Entered Phone Number in Phone Number Field", priority=76)
	public void step76_EnteredPhoneNumberField() throws Exception
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

	@Test(description="Verify and click on second shipping method", priority=77)
	public void step77_VerifyAndClickOnSecondShippingMethod() throws Exception
	{
		if(environmentName.contains("Integration6Env"))
		{
			WebElement ele=shippingaddresspage.driver.findElement(By.xpath(ObjRepoProp.get().getProperty("ConfirmThisAddress_xpath")));
			GUIFunctions.JavaScriptClick(shippingaddresspage.driver,
					ele,"Click on Confirm This Address button");
		}
	shippingaddresspage.VerifyAndClickOnSecondShippingmethod();
	}   
	
	@Test(description="Click on Continue To Payemnt button in Checkout page", priority=78)
	public void step78_ClickOnContinueToPayemntButton() throws Exception
	{
	shippingaddresspage.ContinuetopaymentbtnClick();
	}
	
	@Test(description="Scroll down till Payment options and Verified Payment options in Checkout Page", priority=79)
	public void step79_VerifyPaymentOptions() throws Exception
	{
		paymentpage=new PaymentPage(shippingaddresspage.driver);
		paymentpage.checkout_Paymentoptions();
	}
	
	@Test(description="Click on Credit card Radio button under Payment option", priority=80)
	public void step80_ClickOnCreditCardRadioBtn() throws Exception
	{
		paymentpage.checkout_Creditcard();
	
	}
	

	@Test(description="Verify Credit Card Details under Payment option", priority=81)
	public void step81_VerifyCreditCardDetailsInPayment() throws Exception
	{
		paymentpage.VerifyCreditCardDetails();

	}
	
	@Test(description="Verified My billing and shipping address are the same checkbox is auto selected", priority=82)
	public void step82_VerifiedMyBAandSABothSame_CheckboxIsAutoSelected() throws Exception
	{
		shippingaddresspage=new ShippingAddressPage(paymentpage.driver);
	}
	
	@Test(description="uncheck My billing and shipping address are the same checkbox", priority=83)
	public void step83_UncheckMyBAandSABothSame_Checkbox() throws Exception
	{
		
	}
	
	@Test(priority=84,description="Entered Address Name in Address Name Field")
	public void step84_EnteredAddressNameField() throws Exception
	{
		
	}
	
	@Test(priority=85,description="select Prefix Name Dropdown in Shipping Address Section")
	public void step85_SelectPrefixNameDpdn() throws Exception
	{
		
	}

	@Test(priority=86,description="Entered First Name in First Name Field")
	public void step86_EnteredFirstNameField() throws Exception
	{
		
	}

	@Test(priority=87,description="Entered Last Name in Last Name Field")
	public void step87_EnteredLastNameField() throws Exception
	{
		
	}

	@Test(priority=88,description="Entered Address in Address Field")
	public void step88_EnteredAddressField() throws Exception
	{
		
	}

	@Test(priority=89,description="Entered PostCode in PostCode Field")
	public void step89_EnteredPostCodeField() throws Exception
	{
		
	}

	@Test(priority=90,description="Entered City in City Field")
	public void step90_EnteredCityField() throws Exception
	{
		
	}

	@Test(priority=91,description="verified default Country selected in country Field")
	public void step91_VerifiedCountryField() throws Exception
	{
		
	}
	
	@Test(priority=92,description="Entered Phone Number in Phone Number Field")
	public void step92_EnterPhoneNumField() throws Exception
	{
	
	}
	
	@Test(priority=93,description="click on update btn")
	public void step93_ClickOnUpdateBtn() throws Exception
	{
	   paymentpage=new PaymentPage(shippingaddresspage.driver);
	}
	
	@Test(priority=94,description="Entered Credit Number in Credit Number Field")
	public void step94_EnteredCreditNumberField() throws Exception
	{
		GUIFunctions.scrollByJavaScriptExecutor(paymentpage.driver.findElement(By.xpath("//li[@id='payment']")), paymentpage.driver, "Payment Options");
		paymentpage.checkout_CCCardnumber(CustomFun.getPaymentDSDetails().get().getCardNumber());
	}
	
	@Test(priority=95,description="Entered Expiry Date in Expiry Date Field")
	public void step95_EnteredExpiryDateField() throws Exception
	{
		paymentpage.checkout_CCExpirydate(CustomFun.getPaymentDSDetails().get().getCardExpiryDate());
	}
	
	@Test(priority=96,description="Entered CVV in CVV Field")
	public void step96_EnteredCVVField() throws Exception
	{
		paymentpage.checkout_CCV(CustomFun.getPaymentDSDetails().get().getCardCVV());
	}	
	
	@Test(priority=97,description="Entered CardHolder Name in CardHolder Name Field")
	public void step97_EnteredCardHolderField() throws Exception
	{
		paymentpage.checkout_Cardholdername(CustomFun.getPaymentDSDetails().get().getCardHolderName());
	}
	
	@Test(priority=98,description="Checked on Privacy Policy and Return Policy checkbox")
	public void step98_CheckedOnPrivacyPolicyAndReturnPolicyCheckbox() throws Exception
	{
			 paymentpage.checkout_Agreements_CreditCard();
	}
	
	@Test(priority=99,description="Click on Proceed button in Checkout page at Payment Section")
	public void step99_ClickOnProceedButtonAtPaymentSection() throws Exception
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
	
	@Test(priority = 100,description = "Click on Proceed button in Checkout page at Payment Section & Entered 3DS Credentials")
	public void step100_ClickOnProceedButtonAndEntered3DSCredentials() throws Exception 
	{
	CustomFun.waitForPageLoaded(paymentpage.driver);
	//paymentpage.checkout_3DSUsername(CustomFun.getPaymentDSDetails().get().get3DS_Username());
	paymentpage.checkout_3DSPassword(CustomFun.getPaymentDSDetails().get().get3DS_Password());
	paymentpage.checkout_ClickOnSubmitButton();
	CustomFun.waitForPageLoaded(paymentpage.driver); 
	}
	
	@Test(priority=101,description="Verified Success Message in Order Confirmation page after placing the order")
	public void step101_VerifiedSuccessMsgAfterPlacingOrder() throws Exception
	{
	orderconfirmationpage=new OrderConfirmationPage(paymentpage.driver);
	CustomFun.waitForPageLoaded(orderconfirmationpage.driver);
	orderconfirmationpage.Verify_SuccessOrder_Msg_txt();
	}
	
	@Test(priority=102,description="Verified Your OrderID in Order Confirmation page")
	public void step102_VerifiedYourOrderID() throws Exception
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
	
	@Test(priority=103, description=" Clicking on My Account Icon ")
	public void step103_ClickMyAccountBtn() throws Exception
	{
	homepage=new HomePage(orderconfirmationpage.driver);
	homepage.driver.findElement(By.xpath(ObjRepoProp.get().getProperty("HP_MyAccount_Icon"))).click();	
	} 
	
	
	@Test(priority=104, description=" Verify Order Details In Myorders Page ")
	public void step104_VerifyOrderdetailsInOrderspage() throws Exception
	{
		myaccountpage.MyOrders_LnkClick();	
		myaccountpage.VerifyOrderStatus(OrderID);
		myaccountpage.VerifyOrderPriceInOrderspage(OrderID);
		OrderPrice=MyAccountPage.PriceVal_OrderPage;
		MyAccountPage.PriceVal_OrderPage= myaccountpage.driver.findElement(By.xpath("//*[contains(text(),'"+OrderID+"')]/..//p[contains(@class, 'price')]")).getText().replaceAll(",","\\.").replaceAll("[^0-9.]", ""); 
		myaccountpage.VerifyOrderItemInOrderspage(OrderID);
		myaccountpage.VerifyOrderDateInOrderspage(OrderID);
		if(locale.get().contains("FR_FR") | locale.get().contains("CH_FR"))
		{
		myaccountpage.VerifyOrderStatus(OrderID);
		if(TextProp.get().getProperty("OrderBeingValidatedtxt_FR").contains(MyAccountPage.OrderStatusFromFO))
	    Assert.assertEquals(MyAccountPage.OrderStatusFromFO,TextProp.get().getProperty("OrderBeingValidatedtxt_FR"));
		else
		Assert.assertEquals(MyAccountPage.OrderStatusFromFO,TextProp.get().getProperty("OrderInPreparationtxt_FR"));
		}
		else
		{
	    myaccountpage.VerifyOrderStatus(OrderID);
		Assert.assertEquals(MyAccountPage.OrderStatusFromFO,TextProp.get().getProperty("OrderPendingSecurityChecktxt_UK"));	
		}
	} 
	
	@Test(description="Click on Sales Icon", priority=106)
	public void step106_ClickOnSalesIcon() throws Exception
	{
		CustomFun.SwitchToSpecificTab(backofficepage.driver, "1");
		backofficepage.SalesIconClick();
	}
	
	@Test(description="Click on Orders text from Sales Icon", priority=107)
	public void step107_ClickOrderstxtFromSalesIcon() throws Exception
	{
		backofficepage.OrderstxtFromSalesIconClick();
	}
	
	@Test(description="Enter order Id in serach bar and click on search ", priority=108)
	public void step108_EnterOrderIDInBOSearchFld() throws Exception
	{
		backofficepage.EnterOrderId(OrderID);
		backofficepage.SearchIconClick();	
	}   
	
	@Test(description="Verified Order Status in Orders page", priority=109)
	public void step109_VerifiedOrderStatusInOrdersPage() throws Exception
	{
		if(!backofficepage.driver.findElement(By.xpath("//button[text()='Clear all']")).isDisplayed())
		{
			backofficepage.ClearTheFilterInBO(OrderID);
			for(int i=0;i<=3;i++)
			{
			Thread.sleep(30000);
			CustomFun.refreshPage(backofficepage.driver);
			Thread.sleep(5000);
			backofficepage.driver.findElement(By.xpath("//button[text()='Clear all']")).click();
			  backofficepage.EnterOrderId(OrderID);
			  backofficepage.SearchIconClick();
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
		else
		{
			backofficepage.ClearTheFilterInBO(OrderID);	
			for(int i=0;i<=3;i++)
			{
			Thread.sleep(30000);
			CustomFun.refreshPage(backofficepage.driver);
			Thread.sleep(5000);
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
	
	}
	
	@Test(description="Verify order details in Orders page ", priority=110)
	public void step110_VerifyOrderDetailsInOrderPage() throws Exception
	{
		backofficepage.ClearTheFilterInBO(OrderID);
		backofficepage.Click_viewBtnForPdt();	
		CustomFun.waitForPageLoaded(backofficepage.driver);
		backofficepage.Verify_OderDetails_BO(OrderID);
		backofficepage.Click_BackBtnForBOPrct();
	}  
		
	@Test(description="Open New Tab and Navigated to Adyen", priority=111)
	public void step111_OpenNewTabAndNavigatedtoAdyen() throws Exception
	{
		 adyenpage=new AdyenPage(backofficepage.driver);
	     CustomFun.OpenNewTabAndSwitchToNewTab(adyenpage.driver, "3");
	     adyenpage.driver.navigate().to(CustomFun.getAdyenInfoDSDetails().get().getAdyenUrl());
	}

	
	@Test(description="Logged into Adyen with valid crendentials", priority=112)
	public void step112_LoggedIntoAdyen() throws Exception
	{
		adyenpage=new AdyenPage(backofficepage.driver);
		adyenpage.AdyenLogIn(CustomFun.getAdyenInfoDSDetails().get().getAdyenUsername(),CustomFun.getAdyenInfoDSDetails().get().getAdyenAccount(),CustomFun.getAdyenInfoDSDetails().get().getAdyenPassword());
	}
	
	@Test(description="Click on Risk option from Case management", priority=113)
	public void step113_ClickCaseMgmtOPtionINAdyen() throws Exception
	{
		 CustomFun.waitForPageLoaded(backofficepage.driver);
		 adyenpage.Click_AdyenRiskTab();
		adyenpage.Click_AdyenCaseMgmtTab();
	}
	
	
	@Test(description="verify the order id in Adyen and select the checkbox", priority=114)
	public void step114_ClickOrderIDCheckbox() throws Exception
	{
		adyenpage.Verify_OrderIDandClickCheckbox(OrderID);	
	}  
	
	@Test(description="Click on accept and ok in Adyen", priority=115)
	public void step115_ClickOnAcceptBtn() throws Exception
	{
		adyenpage.Click_AdyenOrderAcceptBtn();
	} 
	
	@Test(description="Navigated Into Magento and Verified Order Status in Orders page", priority=116)
	public void step116_NavigatedIntoMangetoAndVerifiedOrderStatusInOrdersPage() throws Exception
	{
		CustomFun.SwitchToSpecificTab(backofficepage.driver, "1");
        backofficepage.SalesIconClick();
        backofficepage.OrderstxtFromSalesIconClick();
        CustomFun.waitForPageLoaded(backofficepage.driver);
        for(int i=0;i<=15;i++)
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
	
	    @Test(description="Navigated Into BO and Verified Seleable Stock Quantity Decremented By 1", priority=117)
	    public void step117_VerifiedSaleableStockQntyDecBy1InBOAferPlacingTheOrder() throws Exception
	    {
	          CustomFun.refreshPage(backofficepage.driver);
	          CustomFun.waitForPageLoaded(backofficepage.driver);
	          backofficepage.CatalogIconClick();
	          backofficepage.ProductstxtFromCatalogIconClick();
	          backofficepage.SearchForProductSeleableStockInBO(BarCodeSKU);
	          backofficepage.VerifySaleableStockQntyDecBy1InBOAferPlacingTheOrder(BarCodeSKU);
	    }
	    
	    @Test(description="Navigated Into WMS and Verified Seleable Stock Quantity Decremented By 1", priority=118)
	    public void step118_VerifySaleableStockDecBy1InWMSAferPlacingTheOrder() throws Exception
	    {
	          CustomFun.SwitchToSpecificTab(wmspage.driver, "2");
	          CustomFun.refreshPage(wmspage.driver);
	          CustomFun.waitForPageLoaded(wmspage.driver);
	          wmspage.VerifySaleableStockDecBy1InWMSAferPlacingTheOrder();
	    }
	    
	    @Test(description="Comparing the Seleable stock in the WMS and the BO Magento", priority=119)
	    public void step119_ComparedSeleableStockInWMSAndBOBothAreSame() throws Exception
	    {
	    for(int i=0;i<=0;i++)
	    {
	        Thread.sleep(30000);
	    CustomFun.refreshPage(wmspage.driver);
	    Thread.sleep(5000);
	    CustomFun.waitForPageLoaded(wmspage.driver);   
	    }
	    wmspage.VerifyInitialSaleableStock();
	    CustomFun.SwitchToSpecificTab(backofficepage.driver, "1");
	    backofficepage.CatalogIconClick();
	    backofficepage.ProductstxtFromCatalogIconClick();
	    backofficepage.SearchForProductSeleableStockInBO(BarCodeSKU);
	    backofficepage.VerifyInitialSaleableStockInBO(BarCodeSKU);
	   // Assert.assertEquals(BackOfficePage.InitialSaleableStock_BO, WMSPage.InitialSaleableStock_WMS, "Stock in the WMS and the Bo Magento both are same");
	    }
  
	
	@Test(description="Picking Order Process", priority=120)
	public void step120_PickingOrderProcess() throws Exception
	{
		  CustomFun.SwitchToSpecificTab(wmspage.driver, "2");
		wmspage.PickingOrderProcess(OrderID);
	}
	
	@Test(description="Verified Picking order for # XXXXX", priority=121)
	public void step121_VerifiedPickingOrderSuccessMsg() throws Exception
	{
		wmspage.VerifyPickingOrderSuccessMsg();
	}
	
	@Test(description="Verified Gift Msg from Picking in Wms", priority=122)
	public void step122_VerifiedGiftMsg_INPicking() throws Exception
	{
		//wmspage.WMS_VerifyGiftMsg_INPicking();
	}
	
	@Test(description=" Get BarCode From Picking Process", priority=123)
	public void step123_NavigatedIntoWMSAndGetBarcodeFromPickingProcess() throws Exception
	{
		wmspage.getBarCodeFromPickingProcess(OrderID);
		BarCodeForScan=WMSPage.BarCodeId;
	}    
	
	
	@Test(description="Navigated Into Magento and Verified Order Status in Orders page", priority=124)
	public void step124_NaviagtedIntoMangetoAndVerifiedOrderStatusInOrdersPage() throws Exception
	{
		CustomFun.SwitchToSpecificTab(backofficepage.driver, "1");
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
	
	
	@Test(description="Navigated Into FO and Verified Order Status in My Orders page", priority=125)
	public void step125_NaviagtedIntoFOAndVerifiedOrderStatusInMyOrdersPage() throws Exception
	{
		CustomFun.SwitchToSpecificTab(homepage.driver, "0");
		CustomFun.refreshPage(homepage.driver);
		CustomFun.waitForPageLoaded(homepage.driver);
		myaccountpage=new MyAccountPage(homepage.driver);
		myaccountpage.VerifyOrderStatus(OrderID);
	    OrderStatus=MyAccountPage.OrderStatus;
	    Assert.assertEquals(TextProp.get().getProperty("MyOrdersPage_PickingProgresstxt"), OrderStatus);
	    log.info("Successfully Verified Order Status in My orders page: " + OrderStatus);
		Reporter.log("<p>Successfully Verified Order Status in My orders page: " + OrderStatus);
	 } 
	
	
   @Test(description="Navigated Into WMS and Click on Packing Button", priority=126)
	public void step126_NavigatedIntoWMSAndClickOnPackingBtn() throws Exception
	{
	   CustomFun.SwitchToSpecificTab(wmspage.driver, "2");
	   wmspage.Click_WMSPackingBtn();
	}
	
	@Test(description="Entered BarcodeID in Barcode Field And Search For Packing", priority=127)
	public void step127_EnteredBarcodeAndSearchForPacking() throws Exception
	{
		wmspage.EnterBarcodeAndSearchForPacking(BarCodeForScan);
	}
	
	@Test(description="Copy SKUID And Enter in Search Field For Scanning Products In Packing", priority=128)
	public void step128_CopySKUIDAndEnterinSearchFeildForScanningProductsInPacking() throws Exception
	{
		wmspage.CopySKUIDAndEnterinSearchFldForScanningProductsInPacking();
	}
	
	@Test(description="Click on Complete Packing button", priority=129)
	public void step129_ClickOnCompletePackingBtn() throws Exception
	{
		wmspage.Click_CompletePackingBtn();
	}
	
	@Test(description="Enter quantity in front of any row", priority=130)
	public void step130_EnteredQuantityInAnyRow() throws Exception
	{
		wmspage.EnterQuantity_Packing("1");
	}
	
	@Test(description="Click on Validate button", priority=131)
	public void step131_ClickOnValidateBtn() throws Exception
	{	
		wmspage.ClickValidate_Packing();
	}
	
	
	@Test(description="Click on Home Popup button", priority=132)
	public void step132_ClickOnHomePopupBtn() throws Exception
	{
		wmspage.ClickHomeBtn_PopUp();
	}   
	
	@Test(description="Navigated Into Magento and Verified Order Status in Orders page", priority=133)
	public void step133_NavigatedIntoMangetoAndVerifiedOrderStatusInOrdersPage() throws Exception
	{
		CustomFun.SwitchToSpecificTab(backofficepage.driver, "1");
        CustomFun.refreshPage(backofficepage.driver);
        CustomFun.waitForPageLoaded(backofficepage.driver);
        backofficepage.ClearTheFilterInBO(OrderID);
        backofficepage.VerifyOrderStatusInBO_OrdersPage(OrderID);
        OrderStatus=BackOfficePage.OrderStatus;
        Assert.assertEquals(TextProp.get().getProperty("Invoicedtxt"), OrderStatus);
        log.info("Successfully Verified Order Status in Magento After Packing Process is completed: " + OrderStatus);
        Reporter.log("<p>Successfully Verified Order Status in Magento After Packing Process is completed: " + OrderStatus);
	 }
	

	@Test(description="Navigated Into FO and Verified Order Status in My Orders page", priority=134)
	public void step134_NaviagtedIntoFOAndVerifiedOrderStatusInMyOrdersPage() throws Exception
	{
		CustomFun.SwitchToSpecificTab(homepage.driver, "0");
		CustomFun.refreshPage(homepage.driver);
        CustomFun.waitForPageLoaded(homepage.driver);
		myaccountpage=new MyAccountPage(homepage.driver);
		myaccountpage.VerifyOrderStatus(OrderID);
	    OrderStatus=MyAccountPage.OrderStatus;
	    Assert.assertEquals(TextProp.get().getProperty("MyOrdersPage_Invoiced_text"), OrderStatus);
	    log.info("Successfully Verified Order Status in My orders page: " + OrderStatus);
		Reporter.log("<p>Successfully Verified Order Status in My orders page: " + OrderStatus);
	 } 
	
	@Test(description="Navigated Into WMS and Processed with Shipping Process", priority=135)
	public void step135_NavigatedIntoWMSAndProcessedwithShippingProcess() throws Exception
	{
        CustomFun.SwitchToSpecificTab(wmspage.driver, "2");
        wmspage.ShippingOrderProcess(BarCodeForScan);
	}
	
	@Test(description="Navigated Into Magento and Verified Order Status in Orders page", priority=136)
	public void step136_NavigatedIntoMangetoAndVerifiedOrderStatusInOrdersPage() throws Exception
	{
		CustomFun.SwitchToSpecificTab(backofficepage.driver, "1");
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
	
	
	@Test(description="Navigated Into FO and Verified Order Status in My Orders page", priority=137)
	public void step137_NaviagtedIntoFOAndVerifiedOrderStatusInMyOrdersPage() throws Exception
	{
		CustomFun.SwitchToSpecificTab(homepage.driver, "0");
		CustomFun.refreshPage(homepage.driver);
		CustomFun.waitForPageLoaded(homepage.driver);
		myaccountpage=new MyAccountPage(homepage.driver);
		myaccountpage.VerifyOrderStatus(OrderID);
	    OrderStatus=MyAccountPage.OrderStatus;
	    log.info("Successfully Verified Order Status in My orders page: " + OrderStatus);
	    Reporter.log("<p>Successfully Verified Order Status in My orders page: " + OrderStatus);
	
	 } 
	
	
	@Test(description="Navigated back to Adyen and click on payment tab ", priority=138)
	public void step138_NavigatedIntoAdyenAndClickOnPaymentTab() throws Exception
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
	

	
	@Test(description="Enter order Id in serach bar  ", priority=139)
	public void step139_EnterOrderIDinPaymentTab_adyen() throws Exception
	{
		adyenpage.Enter_AdyenPaymentSearchField(OrderID);
	
	} 
	
	@Test(description="Verify order total amount in Adyen ", priority=140)
	public void step140_VerifyOrderTotalAmtIN_adyen() throws Exception
	{
		
		adyenpage.Verify_AdyenOrderAmount(OrderID,OrderPrice);
	}  
	
	 @Test(description="Comparing the Seleable stock in the WMS and the BO Magento after shipping the order", priority=141)
	    public void step141_ComparedSeleableStockInWMSAndBOBothAreSameAfterShippingTheOrder() throws Exception
	    {
	    //Verify Seleable Stock in WMS after Shipping the order
	    CustomFun.SwitchToSpecificTab(wmspage.driver, "2");
	    wmspage.WMS_Datalistmenu();
	    wmspage.WMS_Datalist_Productclick();
	    wmspage.ClickOnDetailsButtonForSimpleprod();
	    wmspage.VerifyInitialSaleableStock();
	    wmspage.VerifyInitialReservedStock();
	    //Verify Seleable Stock in BO after Shipping the order
	    CustomFun.SwitchToSpecificTab(backofficepage.driver, "1");
	    backofficepage.CatalogIconClick();
	    backofficepage.ProductstxtFromCatalogIconClick();
	    backofficepage.SearchForProductSeleableStockInBO(BarCodeSKU);
	    backofficepage.VerifyInitialSaleableStockInBO(BarCodeSKU);
	    }
	
	@Test(priority=143,description="Click on Order Grid and Verified Order details page")
	public void step143_ClickOnOrderGridAndVerifiedOrderDetailsPage() throws Exception
	{
		CustomFun.SwitchToSpecificTab(backofficepage.driver, "1");
		backofficepage.SalesIconClick();
		backofficepage.OrderstxtFromSalesIconClick();
		backofficepage.ClearTheFilterInBO(OrderID);
		backofficepage.ClickOnOrderGrid(OrderID);
	}
	
	@Test(priority=144,description="Click on Create Returns button to create New Return")
	public void step144_ClickOnCreateReturnsButton() throws Exception
	{
		backofficepage.CreateReturnsBtnClick();
	}
	
	@Test(priority=145,description="Select Pickup date to create New Return")
	public void step145_SelectPickupDate() throws Exception
	{
		backofficepage.PickupdateRadioBtnClick();
	}
	
	@Test(priority=146,description="Click on Return Items Tab")
	public void step146_ClickOnReturnItems() throws Exception
	{
		backofficepage.ReturnsItemsClick();
	}
	
	@Test(priority=147,description="Click on Add Product Button")
	public void step147_ClickOnAddProductButton() throws Exception
	{
		backofficepage.AddProductsBtnClick();
	}
	
	@Test(priority=148,description="Click on Checkbox to select the product")
	public void step148_ClickOnCheckboxToSelectTheProduct() throws Exception
	{
		backofficepage.CheckboxProdToAddClick();
	}
	
	@Test(priority=149,description="Click on Add Select Product To Returns Button")
	public void step149_ClickOnAddSelProdToReturnsBtn() throws Exception
	{
		backofficepage.AddSelProdToReturnsBtnClick();
		CustomFun.waitForPageLoaded(backofficepage.driver);
	}
	
	@Test(priority=150,description="Entered Requested value in Requested Field under RMA Items Requested for Grid")
	public void step150_EnterValueInRequestedField() throws Exception
	{
		backofficepage.EnterValueInRequestedField("1");
	}
	
	@Test(priority=151,description="Select any Return Reason option from Return Reason Dropdown")
	public void step152_SelectAnyOptionFromReturnReasonDropdown() throws Exception
	{
		backofficepage.SelectOptionFromReturnReasonDropdown();
	}
	
	@Test(priority=153,description="Select any Item Condition option from Item Condition Dropdown")
	public void step153_SelectOptionFromItemConditionDropdown() throws Exception
	{
		backofficepage.SelectOptionFromItemConditionDropdown();
	}
	
	@Test(priority=154,description="Select any Resolution Reason option from Resolution Dropdown")
	public void step154_SelectOptionFromResolutionDropdown() throws Exception
	{
		backofficepage.SelectOptionFromResolutionDropdown("Refund");
	}
	
	@Test(priority=155,description="Click on Submit Returns Button")
	public void step155_ClickOnSubmitReturnsButton() throws Exception
	{
		backofficepage.SubmitReturnsBtnClick();
		CustomFun.waitForPageLoaded(backofficepage.driver);
	}
	
	@Test(priority=156,description="Verify Success Msg For RMA Request after submit returns")
	public void step156_VerifySuccessMsgForRMARequest() throws Exception
	{	
		backofficepage.VerifySuccessfulMsgForRMARequest();
	}
	
	@Test(priority=157,description="Verified Order Status in Returns page")
	public void step157_VerifiedOrderStatusInReturnsPage() throws Exception
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
		 backofficepage.ClearTheFilterInBOForReturnsOrder(OrderID);
         backofficepage.VerifyReturnsStatusInBO_ReturnsPage(OrderID);
		
		for(int i=0;i<=6;i++)
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
	
	@Test(priority=159,description="Click on Sales Icon")
	public void step159_ClickOnSalesIcon() throws Exception
	{
		backofficepage.SalesIconClick();
	}
	
	@Test(priority=160,description="Click on Orders text from Sales Icon")
	public void step160_ClickOrderstxtFromSalesIcon() throws Exception
	{
		backofficepage.OrderstxtFromSalesIconClick();
	}
	
	@Test(priority=161,description="Verified Order Status in Orders page")
	public void step161_VerifiedOrderStatusInOrdersPage() throws Exception
	{
		backofficepage.ClearTheFilterInBO(OrderID);
		backofficepage.VerifyOrderStatusInBO_OrdersPage(OrderID);
	    OrderStatus=BackOfficePage.OrderStatus;
	    Assert.assertEquals(TextProp.get().getProperty("ProcessingRMAtxt"), OrderStatus);
	    log.info("Successfully Verified Order Status in Orders Page After Returns submit is completed: " + OrderStatus);
		Reporter.log("<p>Successfully Verified Order Status in Orders Page After Returns submit is completed: " + OrderStatus);
	}
	
	@Test(description="Navigated Into FO and Verified Order Status in My Orders page", priority=162)
   	public void step162_NaviagtedIntoFOAndVerifiedOrderStatusInMyOrdersPage() throws Exception
   	{
   		CustomFun.SwitchToSpecificTab(homepage.driver, "0");
   		homepage.clickMyaccountBtn();
   		CustomFun.waitForPageLoaded(homepage.driver);
   		myaccountpage=new MyAccountPage(homepage.driver);
   		myaccountpage.MyOrders_LnkClick();
   		CustomFun.waitForPageLoaded(homepage.driver);
   		myaccountpage.VerifyOrderStatus(OrderID);
   	 }  
	
	@Test(priority=163,description="Navigated Into WMS and Validate the RMA reception in the WMS")
	public void step163_ClickOnRMALink() throws Exception
	{
		CustomFun.SwitchToSpecificTab(wmspage.driver, "2");		
		wmspage.Click_RMALnk();
	}
	
	@Test(priority=164,description="Enter RMA ID in RMA Field, Click on Submit Filter button & Reception button in WMS")
	public void step164_EnterRMAID_SearchForOrderDetails_ClickOnReceptionButton() throws Exception
	{
	for (int i = 0; i <= 4; i++)
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
	
	@Test(priority=165,description="Execute RMA Process in WMS")
	public void step165_ExecuteRMAProcessinWMS() throws Exception
	{
		wmspage.ExecuteRMAProcessForDamagedStatus();
	}

	@Test(priority=167,description="Navigated Into Magento and Click on Sales Icon")
	public void step167_NavigatedIntoMangetoAndClickONSalesIcon() throws Exception
	{
		CustomFun.SwitchToSpecificTab(backofficepage.driver, "1");
		backofficepage.SalesIconClick();
	}
	
	@Test(priority=168,description="Click on Returns link from Sales Tab")
	public void step168_ReturnstxtFromSalesIconClick() throws Exception
	{
		backofficepage.ReturnstxtFromSalesIconClick();
	}
	
	@Test(priority=169,description="Verified Order Status in Returns page")
	public void step169_VerifiedOrderStatusInReturnsPage() throws Exception
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
	
	@Test(priority=170,description="Click on View option under order grid")
	public void step170_ClickonViewOptioninOrderGrid() throws Exception
	{
		backofficepage.ClickOnOrderGrid(OrderID);
	}
	
	@Test(priority=171,description="Click on Return Items Tab")
	public void step171_ClickOnReturnItems() throws Exception
	{
		backofficepage.ReturnsItemsClick();
	}
	
	@Test(priority=172,description="Entered Approved value in Approved Field under RMA Items Requested for Grid")
	public void step172_EnterValueInApprovedField() throws Exception
	{
		backofficepage.EnterValueInApprovedField("1");
	}
	
	@Test(priority=173,description="Select Approved option from Status Dropdown")
	public void step173_SelectApprovedOptionFromStatusDropdown() throws Exception
	{
		backofficepage.SelectApprovedOptionFromStatusDropdownForSingleProduct();
	}
	
	@Test(priority=174,description="Select Rejected option from Status Dropdown for 2nd Product")
	public void step174_SelectRejectedOptionFromStatusDropdown() throws Exception
	{
		backofficepage.SelectRejectedOptionFromStatusDropdownForSecondProduct();
	}
	
	@Test(priority=175,description="Click on Save Button")
	public void step175_ClickOnSaveButton() throws Exception
	{
		backofficepage.ClickOnSaveButton();
	}
	
	@Test(priority=176,description="Verify Success Msg For RMA Request after submit returns")
	public void step176_VerifySuccessMsgForSavedRMARequest() throws Exception
	{
		backofficepage.VerifySuccessMsgForSavedRMARequest();
	}
	
	@Test(priority=177,description="Click on Sales Icon")
	public void step177_ClickOnSalesIcon() throws Exception
	{
		backofficepage.SalesIconClick();
	}
	
	@Test(priority=178,description="Click on Orders text from Sales Icon")
	public void step178_ClickOrderstxtFromSalesIcon() throws Exception
	{
		backofficepage.OrderstxtFromSalesIconClick();
	}
	
	@Test(priority=179,description="Verified Order Status in Orders page")
	public void step179_VerifiedOrderStatusInOrdersPage() throws Exception
	{
		backofficepage.ClearTheFilterInBO(OrderID);
		backofficepage.VerifyOrderStatusInBO_OrdersPage(OrderID);
	    OrderStatus=BackOfficePage.OrderStatus;
	    Assert.assertEquals(TextProp.get().getProperty("WaitingForCreditMemotxt"), OrderStatus);
	    log.info("Successfully Verified Order Status in Orders Page After RMA Approved : " + OrderStatus);
		Reporter.log("<p>Successfully Verified Order Status in Orders Page After RMA Approved: " + OrderStatus);
	/*	backofficepage.Click_viewBtnForPdt();	
		CustomFun.waitForPageLoaded(backofficepage.driver);
		backofficepage.driver.findElement(By.xpath("//span[contains(text(),'Comments History')]")).click();
		Thread.sleep(2000);
		ShipmentID=backofficepage.driver.findElement(By.xpath("//span[contains(text(),'Shipment #')]")).getText().replaceAll("[^0-9.]", "");  */
	}
	
	@Test(priority=180,description="Click on Sales Icon")
	public void step180_ClickOnSalesIcon() throws Exception
	{
		backofficepage.SalesIconClick();
	}
	
	@Test(priority=181,description="Click on Returns link from Sales Tab")
	public void step181_ReturnstxtFromSalesIconClick() throws Exception
	{
		backofficepage.ReturnstxtFromSalesIconClick();
	}
	
	@Test(priority=182,description="Verified Order Status in Returns page")
	public void step182_VerifiedOrderStatusInReturnsPage() throws Exception
	{
		 backofficepage.ClearTheFilterInBOForReturnsOrder(OrderID);
         backofficepage.VerifyReturnsStatusInBO_ReturnsPage(OrderID);
		OrderStatus=BackOfficePage.RMAIDStatus;
		Assert.assertEquals(TextProp.get().getProperty("Approvedtxt"), OrderStatus);
		log.info("Successfully Verified Order Status in Returns Page After RMA Approved : " + OrderStatus);
		Reporter.log("<p>Successfully Verified Order Status in Returns Page After RMA Approved : " + OrderStatus);
	}
	
	@Test(priority=183,description="Click on View option under order grid")
	public void step183_ClickonViewOptioninOrderGrid() throws Exception
	{
		backofficepage.ClickOnOrderGrid(OrderID);
	}	

	@Test(priority=184,description="Click On Refund/Exchange Button in Order Details Page")
	public void step184_ClickOnRefundOrExchangeButton() throws Exception
	{
		backofficepage.ClickOnRefundOrExchangeButton();
		CustomFun.waitForPageLoaded(backofficepage.driver);
		String[] NewMemoID=backofficepage.driver.findElement(By.xpath("//h1")).getText().split(" ");
		RefundMemoID=NewMemoID[3];
	}
	
	@Test(priority=185,description="Scroll down till Refund button in New Memo Page & Click on Refund Button")
	public void step185_ClickOnRefundButtonInNewMemoPage() throws Exception
	{
		backofficepage.ClickOnRefundButtonInNewMemoPage();
		CustomFun.waitForPageLoaded(backofficepage.driver);
	}
	
	@Test(priority=186,description="Verify Success Msg For Create Credit Memo after Refund created")
	public void step186_VerifySuccessMsgForCreateCreditMemo() throws Exception
	{
		backofficepage.VerifySuccessMsgForCreateCreditMemo();
	}
	
	@Test(priority=187,description="Click on Sales Icon")
	public void step187_ClickOnSalesIcon() throws Exception
	{
		backofficepage.SalesIconClick();
	}
	
	@Test(priority=188,description="Click on Orders text from Sales Icon")
	public void step188_ClickOrderstxtFromSalesIcon() throws Exception
	{
		backofficepage.OrderstxtFromSalesIconClick();
	
	}
	
	@Test(priority=189,description="Verified Order Status in Orders page")
	public void step189_VerifiedOrderStatusInOrdersPage() throws Exception
	{
		for (int i = 0; i <= 5; i++)
		{
			Thread.sleep(60000);
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
	}
	
	@Test(priority=190,description="Click on Sales Icon")
	public void step190_ClickOnSalesIcon() throws Exception
	{
		backofficepage.SalesIconClick();
	}
	
	@Test(priority=191,description="Click on Returns link from Sales Tab")
	public void step191_ReturnstxtFromSalesIconClick() throws Exception
	{
		backofficepage.ReturnstxtFromSalesIconClick();
	}
	
	@Test(priority=192,description="Verified Order Status in Returns page")
	public void step192_VerifiedOrderStatusInReturnsPage() throws Exception
	{
		 backofficepage.ClearTheFilterInBOForReturnsOrder(OrderID);
         backofficepage.VerifyReturnsStatusInBO_ReturnsPage(OrderID);
		OrderStatus=BackOfficePage.RMAIDStatus;
	    Assert.assertEquals(TextProp.get().getProperty("ProcessedandClosedtxt"), OrderStatus);
	    log.info("Successfully Verified Order Status in Returns Page After Refund Created : " + OrderStatus);
		Reporter.log("<p>Successfully Verified Order Status in Returns Page After Refund Created : " + OrderStatus);
	}

	@Test(priority=194,description="Navigated back to Adyen and click on payment tab ")
	public void step194_NavigatedIntoAdyenAndClickOnPaymentTab() throws Exception
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
	
	@Test(priority=195,description="Verify order total amount in Adyen ")
	public void step195_VerifyOrderTotalAmtIN_adyen() throws Exception
	{
	adyenpage.Verify_AdyenOrderAmount(OrderID, OrderPrice);
	}

	@Test(priority=196,description="Swich to FO Tab & Click on My Account Icon")
	public void step196_SwitchToFOTabAndClickOnMyAccountIcon() throws Exception
	{
		CustomFun.SwitchToSpecificTab(homepage.driver, "0");
		homepage.clickMyaccountBtn();

	}
	
	@Test(priority=197,description="Click on My Orders Link")
	public void step197_ClickOnMyOrdersLink() throws Exception
	{
		myaccountpage=new MyAccountPage(backofficepage.driver);
		myaccountpage.MyOrders_LnkClick();
	
	}
	
	@Test(priority=198,description="Verified Order Status in My Orders page")
	public void step198_VerifiedOrderStatusInMyOrdersPage() throws Exception
	{
		if(locale.get().contains("FR_FR") | locale.get().contains("CH_FR"))
		{
		for(int i=0;i<=3;i++)
		{
		  Thread.sleep(30000);
		  CustomFun.refreshPage(myaccountpage.driver);
		  Thread.sleep(5000);
		  myaccountpage.VerifyOrderStatus(OrderID);
		  OrderStatus=MyAccountPage.OrderStatusFromFO;
		  if(OrderStatus.contains(TextProp.get().getProperty("Refundedtxt_FR")))
		  {
			myaccountpage.VerifyOrderStatus(OrderID);
		    Assert.assertEquals(MyAccountPage.OrderStatusFromFO,TextProp.get().getProperty("Refundedtxt_FR"));
	       break;
		  }
		}
		}
		else
			for(int i=0;i<=3;i++)
			{
			  Thread.sleep(30000);
			  CustomFun.refreshPage(myaccountpage.driver);
			  Thread.sleep(5000);
			  myaccountpage.VerifyOrderStatus(OrderID);
			  OrderStatus=MyAccountPage.OrderStatusFromFO;
			  if(OrderStatus.contains(TextProp.get().getProperty("Refundedtxt_UK")))
			  {
				myaccountpage.VerifyOrderStatus(OrderID);
			    Assert.assertEquals(MyAccountPage.OrderStatusFromFO,TextProp.get().getProperty("Refundedtxt_UK"));
		       break;
			  }
			}
	}
	
	@Test(priority=199,description="Click on Sign out btn")
	public void step199_ClickOnSignOutBtn() throws Exception
	{
		myaccountpage=new MyAccountPage(homepage.driver);
		myaccountpage.Signout_LnkClick();
	}
	
	@Test(priority=200,description="Verify Sign out msg")
	public void step200_VerifySignOutMsg() throws Exception
	{
		homepage=new HomePage(myaccountpage.driver);
		CustomFun.waitForPageLoaded(homepage.driver);
		homepage.VerifySignOutMsg();
	}
	
	@Test(priority=201,description="Verify user is in Homepage")
	public void step201_VerifyUserIsInHomepage() throws Exception
	{
		homepage.VerifyUserIsInHomepage();
	} 
	
	@Test(description="Comparing the Seleable stock in the WMS and the BO Magento after Refund the order", priority=202)
    public void step202_ComparedSeleableStockInWMSAndBOBothAreSameAfterRefundTheOrder() throws Exception
    {
    //Verify Seleable Stock in WMS after Refund the order
    CustomFun.SwitchToSpecificTab(wmspage.driver, "2");
    wmspage.WMS_Datalistmenu();
    wmspage.WMS_Datalist_Productclick();
    wmspage.ClickOnDetailsButtonForSimpleprod();
    wmspage.VerifySaleableStockIncBy1InWMSAfterRefundTheOrder();
    wmspage.VerifyInitialReservedStock();
    //Verify Seleable Stock in BO after Refund the order
    CustomFun.SwitchToSpecificTab(backofficepage.driver, "1");
    backofficepage.CatalogIconClick();
    backofficepage.ProductstxtFromCatalogIconClick();
    backofficepage.SearchForProductSeleableStockInBO(BarCodeSKU);
    backofficepage.VerifySaleableStockQntyIncBy1InBOAferRefundTheOrder(BarCodeSKU);
   // Assert.assertEquals(BackOfficePage.InitialSaleableStock_BO, WMSPage.InitialSaleableStock_WMS, "Stock in the WMS and the Bo Magento both are same after refund the order");
    } 
     
        @Test(description="Verify Account creation Confirmation Mail Contents", priority=203)
	    public void step203_VerifyAccountCreationConfirmationMailContents() throws InterruptedException
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
        
        @Test(description="Verify Order Confirmation Mail Contents", priority=204)
    	public void step204_VerifyOrderConfirmationMailContents() throws InterruptedException
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
    	
    	
    	@Test(description="Verify Shipping Confirmation Mail Contents", priority=205)
    	public void step205_VerifyShippingConfirmationMailContents() throws InterruptedException
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
    	
    	   
    	@Test(description="Verify Return Request Confirmation Mail Contents", priority=206)
    	public void step206_VerifyReturnRequestConfirmationMailContents() throws InterruptedException
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
    	
    	
    	@Test(description="Verify Return Reception Confirmation Mail Contents", priority=207)
    	public void step207_VerifyReturnReceptionConfirmationMailContents() throws Exception
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
    	
    	@Test(description="Verify Credit Memo Confirmation Mail Contents", priority=208)
    	public void step208_VerifyCreditMemoConfirmationMailContents() throws Exception
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
    	
    	  @Test(description="Verify Order Confirmation Mail for Exchange order Contents", priority=209)
    	  public void step209_VerifyOrderConfirmationMailContentsForExchangeOrder() throws InterruptedException
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
