package src.in.valtech.cl.scenarios;
import static src.in.valtech.util.PropertyFileReader.ObjRepoProp;      
import static src.in.valtech.util.PropertyFileReader.TextProp;    
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
import src.in.valtech.cl.front.pages.CheckoutPage;
import src.in.valtech.cl.front.pages.HomePage;
import src.in.valtech.cl.front.pages.MyAccountPage;
import src.in.valtech.cl.front.pages.MyWishListPage;
import src.in.valtech.cl.front.pages.OrderConfirmationPage;
import src.in.valtech.cl.front.pages.PaymentPage;
import src.in.valtech.cl.front.pages.ProductDetailsPage;
import src.in.valtech.cl.front.pages.ProductListingPage;
import src.in.valtech.cl.front.pages.ShippingAddressPage;
import src.in.valtech.config.BaseTest;
import src.in.valtech.custom.CustomFun;
import src.in.valtech.uifunctions.GUIFunctions;
import src.in.valtech.util.Emails;

public class TC_Scenario_07 extends BaseTest
{
	public Logger log = Logger.getLogger(this.getClass().getName());
	public static String OrderID;
	public String OrderStatus; 
	public String RMAIDStatus; 
	public static String RMAID;
	public String RefundMemoID;
	public String ShipmentID;
	public static String BarCodeSKU;
	public static String Size;
	public static String ref_searchable_SKUID;
	public String ExpProductLineItem;
	public String ExpSubTotal;
	public String BarCodeForScan;
	public String ExpTax;
	public String ExpGrandTotal;
	public String ExpShippingAndHandling;

	HomePage homepage;
	MyAccountPage myaccountpage;
	MyWishListPage mywishlistpage;
	CartPage cartpage;
	ProductListingPage productlistingpage;
	ProductDetailsPage productdetailspage;
	CheckoutPage checkoutpage;
	ShippingAddressPage shippingaddresspage;
	PaymentPage paymentpage;
	OrderConfirmationPage orderconfirmationpage;
	BackOfficePage backofficepage;
	WMSPage wmspage;
	AdyenPage adyenpage;
	Emails email;
	
	@Test(description="Navigated to CL Home Page")
	public void step01_NavigatedtoCLHomePage() throws Exception
	{
	logtest("Create a Refund Credit memo with Paypal Payment Method");
	System.out.println("Entry to the script ");
	System.out.println("The base url "+ baseUrl.get());
	homepage=HomePage.navigateToCLApplication_URL(driver.get(), baseUrl.get());
	}
	
   @Test(description="Click on My Account Icon", priority=1)
	public void step02_ClickOnMyAccountIcon() throws Exception
	{
	    if(locale.get().contains("FR_FR") | bsValue.get().contains("YES") | locale.get().contains("CH_FR") | environmentName.equals("HomoEnv") | locale.get().contains("UK_EN"))
		{
			for (int i = 0; i <= 1; i++)
			{
				Thread.sleep(5000);
				CustomFun.refreshPage(homepage.driver);
				Thread.sleep(5000);
			}
			GUIFunctions.pageScrollToTopOfPage(homepage.driver);
			homepage.clickMyaccountBtn();
		}
		else
		{
			homepage.clickMyaccountBtn();
		}
	}
	
	@Test(description="Entered Email in Address Email Field", priority=2)
	public void step03_EnteredEmailField() throws Exception
	{
		homepage.EnterEmail(CustomFun.getUserInfoDSDetails().get().getEmailDomain());
	}
	
	@Test(description="Entered Password in Password Field", priority=3)
	public void step04_EnteredPasswordField() throws Exception
	{
		homepage.EnterPassword(CustomFun.getUserInfoDSDetails().get().getPassword());
	}
	
	@Test(description="Click on SignIn Button & Verified User is redirected to Home page", priority=4)
	public void step05_ClickOnSignInButtonAndVerifiedUserIsRedirectedToHomePage() throws Exception
	{
		homepage.clickOnSignBtn();
		CustomFun.waitForPageLoaded(homepage.driver);
		myaccountpage=new MyAccountPage(homepage.driver);
		myaccountpage.VerifyMyAccountHeadertxt();
	}
	
	@Test(description="Click on My Account Icon", priority=5)
	public void step06_ClickOnMyAccountIcon() throws Exception
	{
		GUIFunctions.RemoveExistProductsFromMyCartIcon(homepage.driver);
		CustomFun.refreshPage(homepage.driver);
		homepage.driver.findElement(By.xpath(ObjRepoProp.get().getProperty("HP_MyAccount_Icon"))).click();	
		CustomFun.waitForPageLoaded(homepage.driver);
	}

	@Test(description="Verified My Favorite Address Header, NewsLetter Header & Footer in My Account Page", priority=6)
	public void step07_VerifiedMyFavoriteAddressAndNewsLetterHeaders_FootersInMAP() throws Exception
	{
		myaccountpage.Verify_MyFavoriteAddressHeaderInMAP();
		myaccountpage.Verify_NewsLetterHeaderInMAP();
		homepage.Verify_FooterHeader_txt();
		log.info("Successfully Verified Footer Header text in My Account Page");
		Reporter.log("<p>Successfully Verified Footer Header text in My Account Page");
	}
	
	@Test(description="Click on Wishlist Link", priority=7)
	public void step08_ClickOnWishlistLink() throws Exception
	{
		myaccountpage.Wishlist_LnkClick();
		CustomFun.waitForPageLoaded(myaccountpage.driver);
	}
	
	@Test(description="Verified My Wish List Header in My Wish List Page", priority=8)
	public void step09_VerifiedMyWishListHeaderInMWLP() throws Exception
	{
		mywishlistpage=new MyWishListPage(myaccountpage.driver);
		mywishlistpage.VerifyMyWishListHeadertxt();
	}
	
	@Test(description="Verified Product Image in My Wish List Page", priority=9)
	public void step10_VerifiedProductImgInMWLP() throws Exception
	{
		mywishlistpage.VerifyProductImgInMWLP();
	}
	
	
	@Test(description="Verified Product Name in My Wish List Page", priority=10)
	public void step11_VerifiedProductNameInMWLP() throws Exception
	{
		mywishlistpage.VerifyProductNametxtInMWLP();
	}
	
	@Test(description="Verified Product Price in My Wish List Page", priority=11)
	public void step12_VerifiedProductPriceInMWLP() throws Exception
	{
		mywishlistpage.VerifyProductPricetxtInMWLP();
	}
	
	
	@Test(description="Click on Add to Cart Button", priority=12)
	public void step13_ClickOnAddtoCartButtonInMWLP() throws Exception
	{
		mywishlistpage.AddToCartIconClickInMWLP();
	}
	
	@Test(description="Click on Cart Icon", priority=13)
	public void step14_ClickonCartIcon() throws Exception
	{
		homepage.ScrollTillMinicartAndclickOn_Minicart_Icon();
	}
	
	@Test(description="Verified All The UI Element in Mini Cart", priority=14)
	public void step15_VerifiedAllElementInMiniCart() throws Exception
	{
		myaccountpage.Verify_Product_Details_IN_MiniCart();
	}
	
	@Test(description="Click on Product Image in Mini Cart", priority=15)
	public void step16_ClickOnProductImginMiniCart() throws Exception
	{
		cartpage=new CartPage(myaccountpage.driver);
		cartpage.ClickonProductImgInMiniCart();
		CustomFun.waitForPageLoaded(cartpage.driver);
	}
	
	@Test(description="Verified Product Image and Thumbnail Image in Product Details Page", priority=16)
	public void step17_VerifiedProductImageAndThumbnailImageinPDP() throws Exception
	{
		productdetailspage=new ProductDetailsPage(cartpage.driver);
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
		Thread.sleep(2000);
		productdetailspage.ClickonInStoreAvailabilitybtnAndCloseOverlayInPDP();
	}
	
	@Test(description="Verified Contact Us link & Colour Swatches in Product Details Page", priority=23)
	public void step24_VerifiedContactUslinkAndColourSwatchesInPDP() throws Exception
	{
		productdetailspage.VerifyContactUsLinkInPDP();
		productdetailspage.pdpColorSwatches();
	}
	
	@Test(description="Click on Product Info and Verified content under Product Info section", priority=24)
	public void step25_ClickonProductInfoAndVerifiedContent() throws Exception
	{
		productdetailspage.pdpProductInfoBlock();
		ref_searchable_SKUID=ProductDetailsPage.Ref_searchable_sku;
	}
	
	@Test(description="Click on Product Care and Verified content under Product Care section", priority=25)
	public void step26_ClickonProductCareAndVerifiedContent() throws Exception
	{
		productdetailspage.pdpProductCareBlock();
	}
	
	@Test(description="Click on Shipping and Verified content under Shipping section", priority=26)
	public void step27_ClickonShippingAndVerifiedContent() throws Exception
	{
		productdetailspage.pdpShippingBlock();
	}
	
	@Test(description="Click on Add To Cart Button", priority=27)
	public void step28_ClickonAddToCartButton() throws Exception
	{
		GUIFunctions.pageScrollToTopOfPage(productdetailspage.driver);
		productdetailspage.driver.findElement(By.xpath(ObjRepoProp.get().getProperty("PDP_Sizebtn"))).click();
		Thread.sleep(2000);
		productdetailspage.driver.findElement(By.xpath(ObjRepoProp.get().getProperty("PDP_SelectedSecondSize"))).click();
		productdetailspage.pdpAddtoCartbtn();
	}
	
	@Test(description="Verified Content in Confirmation Overlay", priority=28)
	public void step29_VerifiedContentInConfirmationOverlay() throws Exception
	{
		productdetailspage.pdpProductadd_Notification();
	}

	@Test(description="Click on Order Now Button", priority=29)
	public void step30_ClickonOrderNowButton() throws Exception
	{
		productdetailspage.pdpNotification_Ordernowbtn();
		CustomFun.waitForPageLoaded(productdetailspage.driver);
	}
	
	@Test(description="Verified Gift Options Header in Checkout Page", priority=30)
	public void step31_VerifiedGiftOptionsHeaderInCP() throws Exception
	{
		checkoutpage=new CheckoutPage(productdetailspage.driver);
		checkoutpage.VerifyGiftHeadertxt();
	}

	@Test(description="Open New Tab and Navigated to WMS", priority=31)
	public void step32_OpenNewTabAndNavigatedtoWMS() throws Exception
	{
	wmspage=new WMSPage(checkoutpage.driver);
	CustomFun.OpenNewTabAndSwitchToNewTab(wmspage.driver, "1");
	wmspage.driver.navigate().to(CustomFun.getWMSInfoDSDetails().get().getWMSURL());
	}

	@Test(description="Logged into WMS with valid crendentials", priority=32)
	public void step33_LoggedIntoWMS() throws Exception
	{
	wmspage.WMSLogIn(CustomFun.getWMSInfoDSDetails().get().getWmsUsername(),CustomFun.getWMSInfoDSDetails().get().getWmsPassword());
	}

	@Test(description="Click on OK button in WMS", priority=33)
	public void step34_ClickOnOKbutton() throws Exception
	{
	wmspage.Click_WMSOKBtn();
	}

	@Test(description="Mouse Over on Data Lists Menu", priority=34)
	public void step35_MouseOverElementOnDataListsMenu() throws Exception
	{
	wmspage.WMS_Datalistmenu();
	}

	@Test(description="Click on Products from Data Lists", priority=35)
	public void step36_ClickOnProductsFromDataLists() throws Exception
	{
	wmspage.WMS_Datalist_Productclick();
	}

	@Test(description="Enter Searchable SKU & Click on Submit Filter", priority=36)
	public void step37_EnterSearchableSKUAndClickOnSubmitFilter() throws Exception
	{
	wmspage.SearchSKUIDInListOfProducts(ref_searchable_SKUID, Size);
	BarCodeSKU=WMSPage.barcodeSKU;
	}

	@Test(description="Click on Details Button", priority=37)
	public void step38_ClickOnDetailsButton() throws Exception
	{
	wmspage.ClickOnDetailsButton(Size);
	}

	@Test(description="Scroll down till stocks grid and Verify Initial Saleable Stock", priority=38)
	public void step39_VerifyInitialSaleableStock() throws Exception
	{
	wmspage.VerifyInitialSaleableStock();
	}

	@Test(description="Verify Reserved Stock", priority=39)
	public void step40_VerifyReservedStock() throws Exception
	{
	wmspage.VerifyInitialReservedStock();
	}
	
	@Test(description="Open New Tab and Navigated to Magento BO", priority=40)
    public void step41_OpenNewTabAndNavigatedtoMagentoBO() throws Exception
    {
      backofficepage=new BackOfficePage(wmspage.driver);
      CustomFun.OpenNewTabAndSwitchToNewTab(backofficepage.driver, "2");
      backofficepage.driver.navigate().to(CustomFun.getBODSDetails().get().getBO_URL());
    }
    
    @Test(description="Entered Username in Username Field", priority=41)
    public void step42_EnteredUsernameField() throws Exception
    {
    backofficepage.EnterUsername(CustomFun.getBODSDetails().get().getBO_Username());
    }
    
    @Test(description="Entered Password in Password Field", priority=42)
    public void step43_EnteredPasswordField() throws Exception
    {
    backofficepage.EnterPassword(CustomFun.getBODSDetails().get().getBO_Password());
    }
    
    @Test(description="Click on SignIn Button", priority=43)
    public void step44_ClickOnSignInButton() throws Exception
    {
    	backofficepage.SignbtnClick();
    	if(environmentName.contains("IntegrationEnv") | environmentName.contains("HomoEnv1") | environmentName.contains("StagingEnv") | environmentName.contains("Integration6Env"))
	    {
			Thread.sleep(5000);
			CustomFun.refreshPage(backofficepage.driver);
			Thread.sleep(5000);
		}
    }
    
    @Test(description="Verified Dashboard Header & check whether user is in Dashboard page", priority=44)
    public void step45_VerifiedDashboardHeaderInBO() throws Exception
    {
          CustomFun.waitForPageLoaded(backofficepage.driver);
          if(environmentName.contains("StagingEnv") | environmentName.contains("Integration6Env"))
  	     {
  			Thread.sleep(5000);
  			CustomFun.refreshPage(backofficepage.driver);
  			Thread.sleep(5000);
  		 }
          backofficepage.VerifyDashboardHeader();
    }
    
    @Test(description="Click on Catalog Icon", priority=45)
    public void step46_ClickOnCatalogIcon() throws Exception
    {
          backofficepage.CatalogIconClick();
          CustomFun.waitForPageLoaded(backofficepage.driver);
    }
    
    @Test(description="Click on Products text from Catalog Icon", priority=46)
    public void step47_ClickProductstxtFromCatalogIcon() throws Exception
    {
          backofficepage.ProductstxtFromCatalogIconClick();
          CustomFun.waitForPageLoaded(backofficepage.driver);
    }
    
    @Test(description="Search For Product Seleable Stock In BO", priority=47)
    public void step48_SearchForProductSeleableStockInBO() throws Exception
    {
        backofficepage.SearchForProductSeleableStockInBO(BarCodeSKU);
    }
    
    @Test(description="Verify Initial Saleable Stock", priority=48)
    public void step49_VerifyInitialSaleableStock() throws Exception
    {
       backofficepage.VerifyInitialSaleableStockInBO(BarCodeSKU);
    }
	
	@Test(description="Selected Gift Wrapping Img in Checkout Page at Gift Section", priority=49)
	public void step50_ScrollDownTillGiftWrappingImgAndSelectedInCP() throws Exception
	{
		CustomFun.SwitchToSpecificTab(homepage.driver, "0");
	}
	
	@Test(description="Entered wishes Message in Your Message Field in Checkout Page at Gift Section", priority=50)
	public void step51EnteredMsgInYourMsgFieldInCP() throws Exception
	{
		checkoutpage.ScrollDowntillYourMsgField_EnterMsg("HBD");
	}
		
	@Test(description="Click on Update Button in Checkout Page at Gift Section", priority=51)
	public void step52_ClickOnUpdateButtonInCP() throws Exception
	{
		checkoutpage.UpdatebtnClick();
	}
	
	@Test(description="Verified Shipping Address Header in Checkout Page at Shipping Address Section", priority=52)
	public void step53_VerifiedShippingAddressHeaderInCP() throws Exception
	{
		shippingaddresspage=new ShippingAddressPage(checkoutpage.driver);
		shippingaddresspage.VerifyShippingAddressHeader();
	}
	
	@Test(description="Click on New Address Button in Checkout Page at Shipping Address Section", priority=53)
	public void step54_ClickOnNewAddressButtonInSAP() throws Exception
	{
		shippingaddresspage.NewAddressbtnClick_AsEU();
	}
	
	@Test(description="Entered Address Name in Address Name Field", priority=54)
	public void step55_EnteredAddressNameField() throws Exception
	{
		if(environmentName.equals("StagingEnv1"))	
		{
			shippingaddresspage.EnterAddressNameAsEUToAddNewSA(CustomFun.getAddressDSDetails().get().getAddressName());
		}
		else
		{
		    //shippingaddresspage.EnterAddressName_AsEU(CustomFun.getAddressDSDetails().get().getAddressName());
			 shippingaddresspage.driver.findElement(By.xpath("(//input[contains(@name,'address_name')])[2]")).sendKeys(CustomFun.getAddressDSDetails().get().getAddressName());
			 Thread.sleep(1000);
		}
	}
	
	@Test(description="Verified Prefix Name Dropdown is Auto Selected or not at Shipping Address Section", priority=55)
	public void step56_VerifiedPrefixNameDpdIsAutoSelectedOrNot() throws Exception
	{
		if(environmentName.equals("StagingEnv1"))	
		{
			 shippingaddresspage.VerifyPrefixDpdIsAutoSelected_AsEU(CustomFun.getAddressDSDetails().get().getNamePrefix());
		}
		else
		{
			 shippingaddresspage.driver.findElement(By.xpath("(//select[@name='prefix'])[2]")).sendKeys(CustomFun.getAddressDSDetails().get().getNamePrefix());
			 Thread.sleep(1000);
		}
	}
	
	@Test(description="Entered First Name in First Name Field", priority=56)
	public void step57_EnteredFirstNameField() throws Exception
	{
		if(environmentName.equals("StagingEnv1"))	
		{
			shippingaddresspage.EnterFirstNameAsEUToAddNewSA(CustomFun.getAddressDSDetails().get().getFirstName());
		}
		else
		{
			//shippingaddresspage.EnterFirstNameField_AsEU(CustomFun.getAddressDSDetails().get().getFirstName());
			shippingaddresspage.driver.findElement(By.xpath("(//input[@name='firstname'])[2]")).sendKeys(CustomFun.getAddressDSDetails().get().getFirstName());
			Thread.sleep(1000);
		}
	}
	
	@Test(description="Entered Last Name in Last Name Field", priority=57)
	public void step58_EnteredLastNameField() throws Exception
	{
		if(environmentName.equals("StagingEnv1"))	
		{
			shippingaddresspage.EnterLastNameAsEUToAddNewSA(CustomFun.getAddressDSDetails().get().getLastName());
		}
		else
		{
			//shippingaddresspage.EnterLastNameField_AsEU(CustomFun.getAddressDSDetails().get().getLastName());
			shippingaddresspage.driver.findElement(By.xpath("(//input[@name='lastname'])[2]")).sendKeys(CustomFun.getAddressDSDetails().get().getLastName());
			Thread.sleep(1000);
		}
	}
	
	@Test(description="Entered Address in Address Field", priority=58)
	public void step59_EnteredAddressField() throws Exception
	{
		if(environmentName.equals("StagingEnv1"))	
		{
			shippingaddresspage.EnterAddressDetailsAsEUToAddNewSA(CustomFun.getAddressDSDetails().get().getAddress1());
		}
		else
		{
			//shippingaddresspage.EnterAddressDetails_AsEU(CustomFun.getAddressDSDetails().get().getAddress1());
			shippingaddresspage.driver.findElement(By.xpath("(//input[contains(@name,'street')])[4]")).sendKeys(CustomFun.getAddressDSDetails().get().getAddress1());
			Thread.sleep(1000);
		}
	}
	
	@Test(description="Entered PostCode in PostCode Field", priority=59)
	public void step60_EnteredPostCodeField() throws Exception
	{
		if(environmentName.equals("StagingEnv1"))	
		{
			shippingaddresspage.EnterPostcodeAsEUToAddNewSA(CustomFun.getAddressDSDetails().get().getPostcode());
		}
		else
		{
			//shippingaddresspage.EnterPostcode_AsEU(CustomFun.getAddressDSDetails().get().getPostcode());
			shippingaddresspage.driver.findElement(By.xpath("(//input[contains(@name,'postcode')])[2]")).sendKeys(CustomFun.getAddressDSDetails().get().getPostcode());
			Thread.sleep(1000);
		}
	}
	
	@Test(description="Entered City in City Field", priority=60)
	public void step61_EnteredCityField() throws Exception
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
	
	@Test(description="Entered Phone Number in Phone Number Field", priority=61)
	public void step62_EnteredPhoneNumberField() throws Exception
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
	
	@Test(description="Click on SHIP HERE button in shipping address Overlay and Verify Address Updated Message", priority=62)
	public void step63_ClickOnSHIPHEREButton() throws Exception
	{
		shippingaddresspage.ShipHerebtnClick();
		//Verify Success Message
		shippingaddresspage.VerifyAddressUpdatedSuccessMsg();
	}
	
	@Test(description="Verified Shipping Methods Header in Checkout Page at Shipping Methods Section", priority=63)
	public void step64_VerifiedShippingMethodsHeaderInCP() throws Exception
	{
		shippingaddresspage.VerifyShippingMethodLabel();
	}
	
	@Test(description="Click on First Shipping Method radio button in Checkout page", priority=64)
	public void step65_ClickOnFirstShipMethodRadioButton() throws Exception
	{
		if(environmentName.contains("Integration6Env"))
		{
			WebElement ele=shippingaddresspage.driver.findElement(By.xpath(ObjRepoProp.get().getProperty("ConfirmThisAddress_xpath")));
			GUIFunctions.JavaScriptClick(shippingaddresspage.driver,
					ele,"Click on Confirm This Address button");
		}
		shippingaddresspage.VerifyAndClickOnSecondShippingmethod();
	}
	
	@Test(description="Click on Continue To Payemnt button in Checkout page", priority=65)
	public void step66_ClickOnContinueToPayemntButton() throws Exception
	{
		shippingaddresspage.ContinuetopaymentbtnClick();
	}
	
	@Test(description="Scroll down till Payment options and Verified Payment options in Checkout Page", priority=66)
	public void step67_VerifiedPaymentoptions() throws Exception
	{
		paymentpage=new PaymentPage(shippingaddresspage.driver);
		paymentpage.checkout_Paymentoptions();
	}
	
	@Test(description="Click on Paypal card Radio button under Payment option", priority=67)
	public void step68_ClickOnPaypalCardRadioBtn() throws Exception
	{
		paymentpage.checkout_PaypalCard();
	}
	
	@Test(description="Verified 'My billing and shipping address are the same' checkbox is auto selected or not", priority=68)
	public void step69_VerifiedMyBAandSABothSame_CheckboxIsAutoSelected() throws Exception
	{
	  
	}

	@Test(description="Unchecked the checkbox & select existing billing address from dropdown ", priority=69)
	public void step70_UncheckedMyBAandSABothSameCheckbox() throws Exception
	{
	
	}
	
	@Test(description="Checked on Privacy Policy and Return Policy checkbox", priority=70)
	public void step71_CheckedOnPrivacyPolicyAndReturnPolicyCheckbox() throws Exception
	{
			paymentpage.checkout_Agreements();
	}
	
	@Test(description="Click on Proceed button in Checkout page at Payment Section", priority=71)
	public void step72_ClickOnProceedButton() throws Exception
	{
	     paymentpage.checkout_CC_Proceedbtn();
		 CustomFun.waitForPageLoaded(paymentpage.driver);
	}
	
	@Test(description="Navigated to Paypal Payament Page & Closed Accept Cookies PopUp", priority=72)
	public void step73_NavigatedToPPPandCloseAcceptCookiesPopUp() throws Exception
	{
	//	paymentpage.CloseOnAcceptCookiesInPPP();
	}
	
	@Test(description="Entered Email ID in Email ID Field", priority=73)
	public void step74_EnteredEmailField() throws Exception
	{
		paymentpage.EnterEmailIDInPPP(CustomFun.payPalPaymentDSDetails.get().getPayPalUsername());
	}
	
	@Test(description="Entered Password in Password Field", priority=74)
	public void step75_EnteredPasswordField() throws Exception
	{
        paymentpage.EnterPasswordInPPP(CustomFun.payPalPaymentDSDetails.get().getPayPalPassword());
	}
	
	@Test(description="Click on SignIn Button", priority=75)
	public void step76_ClickOnSignInButton() throws Exception
	{
		paymentpage.clickOnLoginBtnInPPP();
		CustomFun.waitForPageLoaded(paymentpage.driver);
	}
	
	@Test(description="Verified Paypal Logo in Paypal Payment Page", priority=76)
	public void step77_VerifiedPaypalLogo() throws Exception
	{
		//paymentpage.VerifyPaypalLogo();
	}
	
	@Test(description="Select Existing Paypal Card", priority=77)
	public void step78_SelectBankOfVisaCard() throws Exception
	{
		paymentpage.BankOfCardVisaClick();
	}
	
	@Test(description="Click on Pay Button", priority=78)
	public void step79_PayButtonClick() throws Exception
	{
		paymentpage.PayButtonClick();
		CustomFun.waitForPageLoaded(paymentpage.driver);
	}
	
	@Test(description="Verified Success Message in Order Confirmation page after placing the order", priority=79)
	public void step80_VerifiedSuccessMsgAfterPlacingOrder() throws Exception
	{
		orderconfirmationpage=new OrderConfirmationPage(paymentpage.driver);
		orderconfirmationpage.Verify_SuccessOrder_Msg_txt();
	}
	
	@Test(description="Verified Continue Shopping Button in Order Confirmation page", priority=80)
	public void step81_VerifiedContinueShoppingButton() throws Exception
	{
		orderconfirmationpage.VerifyContinueShopping_Btn();
	}
	
	@Test(description="Verified Your OrderID in Order Confirmation page", priority=81)
	public void step82_VerifiedYourOrderID() throws Exception
	{
		orderconfirmationpage.VerifyOrderIDInOCP();
	    
	}
	
	@Test(description="Initialised OrderID in OrderID variable for further execution", priority=82)
	public void step83_InitialisedOrderID() throws Exception
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
	
	@Test(description="Navigated Back to Magento & Click on Sales Icon", priority=83)
	public void step84_NavigatedBackToBOAndClickOnSalesIcon() throws Exception
	{
		CustomFun.SwitchToSpecificTab(backofficepage.driver, "2");
		backofficepage.SalesIconClick();
	}
	
	@Test(description="Click on Orders text from Sales Icon", priority=84)
	public void step85_ClickOrderstxtFromSalesIcon() throws Exception
	{
		backofficepage.OrderstxtFromSalesIconClick();
		CustomFun.waitForPageLoaded(backofficepage.driver);
	}
	
	@Test(description="Verified Orders Header & check whether user is in Orders page", priority=85)
	public void step86_VerifiedOrdersHeaderInBO() throws Exception
	{
		backofficepage.VerifyOrdersHeadertxt();
		Thread.sleep(5000);
	}
	
	@Test(description="Verified Order Status in BO after placing the order in FO with Different Billing & Shipping Address", priority=86)
	public void step87_VerifiedOrderStatusInOrderspage() throws Exception
	{
		if(!backofficepage.driver.findElement(By.xpath("//button[text()='Clear all']")).isDisplayed())
		{
			backofficepage.driver.findElement(By.xpath("//input[@id='fulltext']")).sendKeys(OrderID);
			backofficepage.driver.findElement(By.xpath("(//button[@class='action-submit'])[2]")).click();
			CustomFun.waitForPageLoaded(backofficepage.driver);
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
		  backofficepage.VerifyOrderStatusInBO_OrdersPage(OrderID);
		}
		
		for(int i=0;i<=2;i++)
		{
		  Thread.sleep(30000);
		  CustomFun.refreshPage(backofficepage.driver);
		  Thread.sleep(5000);
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
	
	@Test(description="Open New Tab and Navigated to Adyen", priority=87)
	public void step88_OpenNewTabAndNavigatedtoAdyen() throws Exception
	{
		CustomFun.OpenNewTabAndSwitchToNewTab(backofficepage.driver, "3");
		adyenpage=new AdyenPage(backofficepage.driver);
		adyenpage.driver.navigate().to(CustomFun.getAdyenInfoDSDetails().get().getAdyenUrl());
	}
	@Test(description="Logged into Adyen with valid crendentials", priority=88)
	public void step89_LoggedIntoAdyen() throws Exception
	{
	  adyenpage.AdyenLogIn(CustomFun.getAdyenInfoDSDetails().get().getAdyenUsername(),CustomFun.getAdyenInfoDSDetails().get().getAdyenAccount(),CustomFun.getAdyenInfoDSDetails().get().getAdyenPassword());
	} 
	
	@Test(description="Click on Risk option", priority=89)
	public void step90_ClickOnAdyenRiskTab() throws Exception
	{
	adyenpage.Click_AdyenRiskTab();
	}
	
	@Test(description="Click on Case management from Risk option", priority=90)
	public void step91_ClickCaseMgmtOPtionINAdyen() throws Exception
	{
	adyenpage.Click_AdyenCaseMgmtTab();
	}

	@Test(description="verify the order id in Adyen and select the checkbox", priority=91)
	public void step92_ClickOrderIDCheckbox() throws Exception
	{
	adyenpage.Verify_OrderIDandClickCheckbox(OrderID);
	}

	@Test(description="Click on accept and ok in Adyen", priority=92)
	public void step93_ClickOnAcceptBtn() throws Exception
	{
	  adyenpage.Click_AdyenOrderAcceptBtn();
	  CustomFun.refreshPage(adyenpage.driver);
	  CustomFun.waitForPageLoaded(adyenpage.driver);
	} 
	
	@Test(description="Navigated Back to Magento & Verified Order Status in Orders page", priority=93)
	public void step94_NavigatedBackToMagentoAndVerifiedOrderStatusInOrdersPage() throws Exception
	{
		CustomFun.SwitchToSpecificTab(backofficepage.driver, "2");
		for(int i=0;i<=15;i++)
		{
		  Thread.sleep(50000);
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
	

	@Test(description="Switch to FO Tab & Click on My Account Icon", priority=95)
	public void step96_SwitchToFOTabAndClickOnMyAccountIcon() throws Exception
	{
		CustomFun.SwitchToSpecificTab(homepage.driver, "0");	
		homepage.driver.findElement(By.xpath(ObjRepoProp.get().getProperty("HP_MyAccount_Icon"))).click();	
	    Thread.sleep(5000);
	}
	
	@Test(description="Click on My Orders Link", priority=96)
	public void step97_ClickOnMyOrdersLink() throws Exception
	{
		myaccountpage.MyOrders_LnkClick();
	}
	
	@Test(description="Verified Order Status in My Orders page", priority=97)
	public void step98_VerifiedOrderStatusInMyOrdersPage() throws Exception
	{
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
	
	 @Test(description="Navigated Into BO and Verified Seleable Stock Quantity Decremented By 1", priority=98)
	    public void step99_VerifiedSaleableStockQntyDecBy1InBOAferPlacingTheOrder() throws Exception
	    {
		      CustomFun.SwitchToSpecificTab(backofficepage.driver, "2");
	          backofficepage.CatalogIconClick();
	          backofficepage.ProductstxtFromCatalogIconClick();
	          backofficepage.SearchForProductSeleableStockInBO(BarCodeSKU);
	          backofficepage.VerifySaleableStockQntyDecBy1InBOAferPlacingTheOrder(BarCodeSKU);
	    }
	    
	    @Test(description="Navigated Into WMS and Verified Seleable Stock Quantity Decremented By 1", priority=99)
	    public void step100_VerifySaleableStockDecBy1InWMSAferPlacingTheOrder() throws Exception
	    {
	          CustomFun.SwitchToSpecificTab(wmspage.driver, "1");
	          CustomFun.refreshPage(wmspage.driver);
	          CustomFun.waitForPageLoaded(wmspage.driver);
	          wmspage.VerifySaleableStockDecBy1InWMSAferPlacingTheOrder();
	    }

		@Test(description="Comparing the Seleable stock in the WMS and the BO Magento", priority=100)
	    public void step101_ComparedSeleableStockInWMSAndBOBothAreSame() throws Exception
	    {
	    wmspage.VerifyInitialSaleableStock();
	    CustomFun.SwitchToSpecificTab(backofficepage.driver, "2");
	    backofficepage.CatalogIconClick();
	    backofficepage.ProductstxtFromCatalogIconClick();
	    backofficepage.SearchForProductSeleableStockInBO(BarCodeSKU);
	    backofficepage.VerifyInitialSaleableStockInBO(BarCodeSKU);
	    //Assert.assertEquals(BackOfficePage.InitialSaleableStock_BO, WMSPage.InitialSaleableStock_WMS);
	    }
	
	@Test(description="Navigated Back to WMS & Picking Order Process", priority=101)
	public void step102_PickingOrderProcess() throws Exception
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
	
	@Test(description="Switch to FO Tab & Click on My Account Icon", priority=104)
	public void step105_SwitchToFOTabAndClickOnMyAccountIcon() throws Exception
	{
		CustomFun.SwitchToSpecificTab(backofficepage.driver, "0");
		Thread.sleep(2000);
		CustomFun.refreshPage(homepage.driver);
		Thread.sleep(2000);
		homepage.driver.findElement(By.xpath(ObjRepoProp.get().getProperty("HP_MyAccount_Icon"))).click();	
	}
	
	@Test(description="Click on My Orders Link", priority=105)
	public void step106_ClickOnMyOrdersLink() throws Exception
	{
		//myaccountpage=new MyAccountPage(backofficepage.driver);
		myaccountpage=new MyAccountPage(homepage.driver);
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
	}
	
	@Test(description="Navigated Into WMS and Get BarCode From Picking Process", priority=107)
	public void step108_NavigatedIntoWMSAndGetBarcodeFromPickingProcess() throws Exception
	{
		CustomFun.SwitchToSpecificTab(wmspage.driver, "1");
		wmspage.getBarCodeFromPickingProcess(OrderID);
		BarCodeForScan=WMSPage.BarCodeId;
	}
	
	@Test(description="Navigated Into WMS and Click on Packing Button", priority=108)
	public void step109_NavigatedIntoWMSAndClickOnPackingBtn() throws Exception
	{
		wmspage.Click_WMSPackingBtn();
	}
	
	@Test(description="Entered BarcodeID in Barcode Field And Search For Packing", priority=109)
	public void step110_EnteredBarcodeAndSearchForPacking() throws Exception
	{
		wmspage.EnterBarcodeAndSearchForPacking(BarCodeForScan);
	}
	
	@Test(description="Copy SKUID And Enter in Search Field For Scanning Products In Packing", priority=110)
	public void step111_CopySKUIDAndEnterinSearchFeildForScanningProductsInPacking() throws Exception
	{
		wmspage.CopySKUIDAndEnterinSearchFldForScanningProductsInPacking();
	}
	
	@Test(description="Click on Complete Packing button", priority=111)
	public void step112_ClickOnCompletePackingBtn() throws Exception
	{
		wmspage.Click_CompletePackingButton();
	}
	
	@Test(description="Enter quantity in front of any row", priority=112)
	public void step113_EnteredQuantityInAnyRow() throws Exception
	{
		wmspage.EnterQuantity_Packing("2");
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
	}
	
	@Test(description="Navigated Into WMS and Processed with Shipping Process", priority=119)
	public void step120_NavigatedIntoWMSAndProcessedwithShippingProcess() throws Exception
	{
		CustomFun.SwitchToSpecificTab(wmspage.driver, "1");
		wmspage.ShippingOrderProcess(BarCodeForScan);
	}
	
	@Test(description="Navigated Into Magento and Verified Order Status in Orders page", priority=120)
	public void step121_NavigatedIntoMangetoAndVerifiedOrderStatusInOrdersPage() throws Exception
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
		backofficepage.Click_BackBtnForBOPrct();
	}
	
	@Test(description="Switch to FO Tab & Click on My Account Icon", priority=121)
	public void step122_SwitchToFOTabAndClickOnMyAccountIcon() throws Exception
	{
		CustomFun.SwitchToSpecificTab(homepage.driver, "0");
		homepage.clickMyaccountBtn();
	}
	
	@Test(description="Click on My Orders Link", priority=122)
	public void step123_ClickOnMyOrdersLink() throws Exception
	{
		myaccountpage.MyOrders_LnkClick();
	}
	
	@Test(description="Verified Order Status in My Orders page", priority=123)
	public void step124_VerifiedOrderStatusInMyOrdersPage() throws Exception
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
	
	 @Test(description="Comparing the Seleable stock in the WMS and the BO Magento after shipping the order", priority=124)
	 public void step125_ComparedSeleableStockInWMSAndBOBothAreSameAfterShippingTheOrder() throws Exception
	    {
	    //Verify Seleable Stock in WMS after Shipping the order
	    CustomFun.SwitchToSpecificTab(wmspage.driver, "1");
	    wmspage.WMS_Datalistmenu();
	    wmspage.WMS_Datalist_Productclick();
	 //   wmspage.SearchSKUIDInListOfProduct();
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
	
	@Test(description="Click on Order Grid and Verified Order details page", priority=125)
	public void step126_ClickOnOrderGridAndVerifiedOrderDetailsPage() throws Exception
	{
		backofficepage.SalesIconClick();
		backofficepage.OrderstxtFromSalesIconClick();
		backofficepage.ClearTheFilterInBO(OrderID);
		backofficepage.ClickOnOrderGrid(OrderID);
	}
	
	@Test(description="Click on Create Returns button to create New Return", priority=126)
	public void step127_ClickOnCreateReturnsButton() throws Exception
	{
		backofficepage.CreateReturnsBtnClick();
	}
	
	@Test(description="Edited Exist Shipping Address with New Shipping Address For RMA", priority=127)
	public void step128_EditExistShippingAddressWithNewShippingAddressForRMA() throws Exception
	{
		backofficepage.EditExistShippingAddressWithNewShippingAddressForRMA();
	}
	
	@Test(description="Verify Success Msg For RMA Updated Address", priority=128)
	public void step129_VerifySuccessMsgForRMAAddressUpdate() throws Exception
	{
		backofficepage.VerifySuccessMsgForRMAAddressUpdate();
	}
	
	@Test(description="Select Pickup date to create New Return", priority=129)
	public void step130_SelectPickupDate() throws Exception
	{
		backofficepage.PickupdateRadioBtnClick();
	}
	
	@Test(description="Click on Return Items Tab", priority=130)
	public void step131_ClickOnReturnItems() throws Exception
	{
		backofficepage.ReturnsItemsClick();
	}
	
	@Test(description="Click on Add Product Button", priority=131)
	public void step132_ClickOnAddProductButton() throws Exception
	{
		backofficepage.AddProductsBtnClick();
	}
	
	@Test(description="Click on Checkbox to select the product", priority=132)
	public void step133_ClickOnCheckboxToSelectTheProduct() throws Exception
	{
		backofficepage.CheckboxProdToAddClick();
	}
	
	@Test(description="Click on Add Select Product To Returns Button", priority=133)
	public void step134_ClickOnAddSelProdToReturnsBtn() throws Exception
	{
		backofficepage.AddSelProdToReturnsBtnClick();
	}
	
	@Test(description="Entered Requested value in Requested Field under RMA Items Requested for Grid", priority=134)
	public void step135_EnterValueInRequestedField() throws Exception
	{
		backofficepage.EnterValueInRequestedField("1");
	}
	
	@Test(description="Select any Return Reason option from Return Reason Dropdown", priority=135)
	public void step136_SelectAnyOptionFromReturnReasonDropdown() throws Exception
	{
		backofficepage.SelectOptionFromReturnReasonDropdown("Changed Mind");
	}
	
	@Test(description="Select any Item Condition option from Item Condition Dropdown", priority=136)
	public void step137_SelectOptionFromItemConditionDropdown() throws Exception
	{
		backofficepage.SelectOptionFromItemConditionDropdown();
	}
	
	@Test(description="Select any Resolution Reason option from Resolution Dropdown", priority=137)
	public void step138_SelectOptionFromResolutionDropdown() throws Exception
	{
		backofficepage.SelectOptionFromResolutionDropdown("Refund");
	}
	
	@Test(description="Click on Submit Returns Button", priority=138)
	public void step139_ClickOnSubmitReturnsButton() throws Exception
	{
		backofficepage.SubmitReturnsBtnClick();
	}
	
	@Test(description="Verify Success Msg For RMA Request after submit returns", priority=139)
	public void step140_VerifySuccessMsgForRMARequest() throws Exception
	{
		backofficepage.VerifySuccessfulMsgForRMARequest();
	}
	
	@Test(description="Verified Order Status in Returns page", priority=141)
	public void step142_VerifiedOrderStatusInReturnsPage() throws Exception
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
	
	@Test(description="Click on Sales Icon", priority=142)
	public void step143_ClickOnSalesIcon() throws Exception
	{
		backofficepage.SalesIconClick();
	}
	
	@Test(description="Click on Orders text from Sales Icon", priority=143)
	public void step144_ClickOrderstxtFromSalesIcon() throws Exception
	{
		backofficepage.OrderstxtFromSalesIconClick();
	}
	
	@Test(description="Verified Order Status in Orders page", priority=144)
	public void step145_VerifiedOrderStatusInOrdersPage() throws Exception
	{
		backofficepage.ClearTheFilterInBO(OrderID);
		backofficepage.VerifyOrderStatusInBO_OrdersPage(OrderID);
	    OrderStatus=BackOfficePage.OrderStatus;
	    Assert.assertEquals(TextProp.get().getProperty("ProcessingRMAtxt"), OrderStatus);
	    log.info("Successfully Verified Order Status in Orders Page After Returns submit is completed: " + OrderStatus);
		Reporter.log("<p>Successfully Verified Order Status in Orders Page After Returns submit is completed: " + OrderStatus);
	}
	
	@Test(description="Navigated Into WMS and Validate the RMA reception in the WMS", priority=146)
	public void step147_ClickOnRMALink() throws Exception
	{
		CustomFun.SwitchToSpecificTab(wmspage.driver, "1");
		wmspage.Click_RMALnk();
	}
	
	@Test(description="Enter RMA ID in RMA Field, Click on Submit Filter button & Reception button in WMS", priority=147)
	public void step148_EnterRMAID_SearchForOrderDetails_ClickOnReceptionButton() throws Exception
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
	
	@Test(description="Execute RMA Process in WMS", priority=148)
	public void step149_ExecuteRMAProcessinWMS() throws Exception
	{
		wmspage.ExecuteRMAProcess();
		Thread.sleep(90000);
	}

	@Test(description="Navigated Into Magento and Click on Sales Icon", priority=150)
	public void step151_NavigatedIntoMangetoAndVerifiedOrderStatusInOrdersPage() throws Exception
	{
		CustomFun.SwitchToSpecificTab(backofficepage.driver, "2");
		Thread.sleep(10000);
		backofficepage.SalesIconClick();
	}
	
	@Test(description="Click on Returns link from Sales Tab", priority=151)
	public void step152_ReturnstxtFromSalesIconClick() throws Exception
	{
		backofficepage.ReturnstxtFromSalesIconClick();
	}
	
	@Test(description="Verified Order Status in Returns page", priority=152)
	public void step153_VerifiedOrderStatusInReturnsPage() throws Exception
	{
		for(int i=0;i<=3;i++)
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
	
	@Test(description="Click on View option under order grid", priority=153)
	public void step154_ClickonViewOptioninOrderGrid() throws Exception
	{
		backofficepage.ClickOnOrderGrid(OrderID);
	}
	
	@Test(description="Click on Return Items Tab", priority=154)
	public void step155_ClickOnReturnItems() throws Exception
	{
		backofficepage.ReturnsItemsClick();
	}
	
	@Test(description="Entered Approved value in Approved Field under RMA Items Requested for Grid", priority=155)
	public void step156_EnterValueInApprovedField() throws Exception
	{
		backofficepage.EnterValueInApprovedField("1");
	}
	
	@Test(description="Select Approved option from Status Dropdown", priority=156)
	public void step157_SelectApprovedOptionFromStatusDropdown() throws Exception
	{
		backofficepage.SelectApprovedOptionFromStatusDropdown();
	}
	
	@Test(description="Click on Save Button", priority=157)
	public void step158_ClickOnSaveButton() throws Exception
	{
		backofficepage.ClickOnSaveButton();
	}
	
	@Test(description="Verify Success Msg For RMA Request after submit returns", priority=158)
	public void step159_VerifySuccessMsgForSavedRMARequest() throws Exception
	{
		backofficepage.VerifySuccessMsgForSavedRMARequest();
	}
	
	@Test(description="Click on Sales Icon", priority=159)
	public void step160_ClickOnSalesIcon() throws Exception
	{
		backofficepage.SalesIconClick();
	}
	
	@Test(description="Click on Orders text from Sales Icon", priority=160)
	public void step161_ClickOrderstxtFromSalesIcon() throws Exception
	{
		backofficepage.OrderstxtFromSalesIconClick();
	}
	
	@Test(description="Verified Order Status in Orders page", priority=161)
	public void step162_VerifiedOrderStatusInOrdersPage() throws Exception
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
	
	@Test(description="Click on Sales Icon", priority=162)
	public void step163_ClickOnSalesIcon() throws Exception
	{
		backofficepage.SalesIconClick();
	}
	
	@Test(description="Click on Returns link from Sales Tab", priority=163)
	public void step164_ReturnstxtFromSalesIconClick() throws Exception
	{
		backofficepage.ReturnstxtFromSalesIconClick();
	}
	
	@Test(description="Verified Order Status in Returns page", priority=164)
	public void step165_VerifiedOrderStatusInReturnsPage() throws Exception
	{
		 backofficepage.ClearTheFilterInBOForReturnsOrder(OrderID);
         backofficepage.VerifyReturnsStatusInBO_ReturnsPage(OrderID);
		OrderStatus=BackOfficePage.RMAIDStatus;
	    Assert.assertEquals(TextProp.get().getProperty("Approvedtxt"), OrderStatus);
	    log.info("Successfully Verified Order Status in Returns Page After RMA Approved : " + OrderStatus);
		Reporter.log("<p>Successfully Verified Order Status in Returns Page After RMA Approved : " + OrderStatus);
	}
	
	@Test(description="Click on View option under order grid", priority=165)
	public void step166_ClickonViewOptioninOrderGrid() throws Exception
	{
		backofficepage.ClickOnOrderGrid(OrderID);
	}	

	@Test(description="Click On Refund/Exchange Button in Order Details Page", priority=166)
	public void step167_ClickOnRefundOrExchangeButton() throws Exception
	{
		backofficepage.ClickOnRefundOrExchangeButton();
		String[] NewMemoID=backofficepage.driver.findElement(By.xpath("//h1")).getText().split(" ");
		RefundMemoID=NewMemoID[3];
	}
	
	@Test(description="Scroll down till Refund button in New Memo Page & Click on Refund Button", priority=167)
	public void step168_ClickOnRefundButtonInNewMemoPage() throws Exception
	{
		backofficepage.ClickOnRefundButtonInNewMemoPage();
	}
	
	@Test(description="Verify Success Msg For Create Credit Memo after Refund created", priority=168)
	public void step169_VerifySuccessMsgForCreateCreditMemo() throws Exception
	{
		backofficepage.VerifySuccessMsgForCreateCreditMemo();
	}
	
	@Test(description="Click on Sales Icon", priority=169)
	public void step170_ClickOnSalesIcon() throws Exception
	{
		backofficepage.SalesIconClick();
	}
	
	@Test(description="Click on Orders text from Sales Icon", priority=170)
	public void step171_ClickOrderstxtFromSalesIcon() throws Exception
	{
		backofficepage.OrderstxtFromSalesIconClick();
	}
	
	@Test(description="Verified Order Status in Orders page", priority=171)
	public void step172_VerifiedOrderStatusInOrdersPage() throws Exception
	{
		for (int i = 0; i <= 2; i++)
		{
			Thread.sleep(30000);
			CustomFun.refreshPage(backofficepage.driver);
			Thread.sleep(50000);
			CustomFun.refreshPage(backofficepage.driver);
			Thread.sleep(2000);
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
	
	@Test(description="Click on Sales Icon", priority=172)
	public void step173_ClickOnSalesIcon() throws Exception
	{
		backofficepage.SalesIconClick();
	}
	
	@Test(description="Click on Returns link from Sales Tab", priority=173)
	public void step174_ReturnstxtFromSalesIconClick() throws Exception
	{
		backofficepage.ReturnstxtFromSalesIconClick();
	}
	
	@Test(description="Verified Order Status in Returns page", priority=174)
	public void step175_VerifiedOrderStatusInReturnsPage() throws Exception
	{
		 backofficepage.ClearTheFilterInBOForReturnsOrder(OrderID);
         backofficepage.VerifyReturnsStatusInBO_ReturnsPage(OrderID);
		OrderStatus=BackOfficePage.RMAIDStatus;
	    Assert.assertEquals(TextProp.get().getProperty("ProcessedandClosedtxt"), OrderStatus);
	    log.info("Successfully Verified Order Status in Returns Page After Refund Created : " + OrderStatus);
		Reporter.log("<p>Successfully Verified Order Status in Returns Page After Refund Created : " + OrderStatus);
	}
	
	@Test(description="Switch to FO Tab & Click on My Account Icon", priority=175)
	public void step176_SwitchToFOTabAndClickOnMyAccountIcon() throws Exception
	{
		CustomFun.SwitchToSpecificTab(backofficepage.driver, "0");
		homepage.driver.findElement(By.xpath(ObjRepoProp.get().getProperty("HP_MyAccount_Icon"))).click();
	}
	
	@Test(description="Click on My Orders Link", priority=176)
	public void step177_ClickOnMyOrdersLink() throws Exception
	{
		myaccountpage=new MyAccountPage(backofficepage.driver);
		CustomFun.refreshPage(homepage.driver);
		Thread.sleep(3000);
		CustomFun.refreshPage(homepage.driver);
		Thread.sleep(5000);
		myaccountpage.MyOrders_LnkClick();
	}
	
	@Test(description="Verified Order Status in My Orders page", priority=177)
	public void step178_VerifiedOrderStatusInMyOrdersPage() throws Exception
	{
		myaccountpage.VerifyOrderStatus(OrderID);
		if(locale.get().contains("FR_FR") | locale.get().contains("CH_FR"))
		{
		Assert.assertEquals(MyAccountPage.OrderStatusFromFO,TextProp.get().getProperty("Refundedtxt_FR"));
		}
		else
		{
		Assert.assertEquals(MyAccountPage.OrderStatusFromFO,TextProp.get().getProperty("Refundedtxt_UK"));	
		}
	}
	
	 @Test(description="Comparing the Seleable stock in the WMS and the BO Magento after Refund the order", priority=178)
	    public void step179_ComparedSeleableStockInWMSAndBOBothAreSameAfterRefundTheOrder() throws Exception
	    {
	    //Verify Seleable Stock in WMS after Refund the order
	    CustomFun.SwitchToSpecificTab(wmspage.driver, "1");
	    Thread.sleep(2000);
	    CustomFun.refreshPage(wmspage.driver);
	    Thread.sleep(2000);
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
	   // Assert.assertEquals(BackOfficePage.InitialSaleableStock_BO, WMSPage.InitialSaleableStock_WMS);
	    }
		
	    @Test(description="Verify Order Confirmation Mail Contents", priority=179)
		public void step180_VerifyOrderConfirmationMailContents() throws InterruptedException
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
		
		
		@Test(description="Verify Shipping Confirmation Mail Contents", priority=180)
		public void step181_VerifyShippingConfirmationMailContents() throws InterruptedException
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
		
		   
		@Test(description="Verify Return Request Confirmation Mail Contents", priority=181)
		public void step182_VerifyReturnRequestConfirmationMailContents() throws InterruptedException
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
		
		
		@Test(description="Verify Return Reception Confirmation Mail Contents", priority=182)
		public void step183_VerifyReturnReceptionConfirmationMailContents() throws Exception
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
		
		@Test(description="Verify Credit Memo Confirmation Mail Contents", priority=183)
		public void step184_VerifyCreditMemoConfirmationMailContents() throws Exception
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

