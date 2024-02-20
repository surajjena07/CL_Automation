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

public class TC_Scenario_02 extends BaseTest {
	public Logger log = Logger.getLogger(this.getClass().getName());
	public String OrderID;
	public String OrderStatus;
	public static String RMAID;
	public String RefundMemoID;
	public String RMA_ID_FO;
	public String RMAIDStatus;
	public String ShipmentID;
	public String OrderPrice;
	public String BarCodeForScan;
	
	public static String BarCodeSKU;
	public static String Size;
	public static String ref_searchable_SKUID;

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
	Emails email;
	AdyenPage adyenpage;
	WMSPage wmspage;

	@Test(description = "Navigated to CL Home Page")
	public void step01_NavigatedtoCLHomePage() throws Exception {
		
		logtest("Create a refund credit memo with 3DS credit card");
		System.out.println("Entry to the script ");
		System.out.println("The base url " + baseUrl.get());
		homepage = HomePage.navigateToCLApplication_URL(driver.get(), baseUrl.get());
	}

	@Test(description = "Mouse Over on Beauty L1 Category", priority = 1)
	public void step02_MouseOverElementOnBeautyL1Category() throws Exception {
		if(locale.get().contains("FR_FR") | bsValue.get().contains("YES") | locale.get().contains("CH_FR") | environmentName.equals("HomoEnv1") | environmentName.equals("HomoEnv")|locale.get().contains("UK_EN"))
		{
			for (int i = 0; i <= 1; i++)
			{
				Thread.sleep(5000);
				CustomFun.refreshPage(homepage.driver);
				Thread.sleep(5000);
			}
			categorylandingpage = new CategoryLandingPage(homepage.driver);
			GUIFunctions.pageScrollToTopOfPage(categorylandingpage.driver);
			categorylandingpage.MouseOverOnL1BeautyCategory();
			categorylandingpage.MouseOverOnL1BeautyCategory();
		}
		else
		{
			categorylandingpage = new CategoryLandingPage(homepage.driver);
			categorylandingpage.MouseOverOnL1BeautyCategory();
			categorylandingpage.MouseOverOnL1BeautyCategory();
		}
	}

	@Test(description = "Click on L2 Eyes Category under L1 Beauty Category", priority = 2)
	public void step03_ClickOnL2EyesBeautyCategory() throws Exception {
		// Any L2 Category can be taken as a test data
		categorylandingpage.BeautyL2EyeCategoryClick();
	}

	@Test(description = "Click on My Account Icon", priority = 3)
	public void step04_ClickOnMyAccountIcon() throws Exception {
		homepage.clickMyaccountBtn();
	}

	@Test(description = "Entered Email in Address Email Field", priority = 4)
	public void step05_EnteredEmailField() throws Exception {
		homepage.EnterEmail(CustomFun.getUserInfoDSDetails().get().getEmailDomain());
	}

	@Test(description = "Entered Password in Password Field", priority = 5)
	public void step06_EnteredPasswordField() throws Exception {
		homepage.EnterPassword(CustomFun.getUserInfoDSDetails().get().getPassword());
	}

	@Test(description = "Click on SignIn Button & Verify Login Success Message", priority = 6)
	public void step07_ClickOnSignInButtonAndVerifyLoginSuccessMsg() throws Exception {
		homepage.clickOnSignBtn();
		CustomFun.waitForPageLoaded(homepage.driver);
		homepage.VerifyLoginSuccessMsg();
	}

	@Test(description = "Mouse Over on Ladies L1 Category", priority = 7)
	public void step08_MouseOverElementOnLadiesL1Category() throws Exception {
		GUIFunctions.RemoveExistProductsFromMyCartIcon(homepage.driver);
		CustomFun.refreshPage(homepage.driver);
		categorylandingpage = new CategoryLandingPage(homepage.driver);
		categorylandingpage.mouseOverCategory();
	}

	@Test(description = "Click on L2 Accessoires Category under L1 Ladies Category", priority = 8)
	public void step09_ClickOnL2AccessoiresLadiesCategory() throws Exception {
		// Any L2 Category can be taken as a test data
		categorylandingpage.driver.findElement(By.xpath("//a[contains(@id,'cat')]//span[contains(text(),'Accesso')]"))
				.click();
	}
	
	@Test(description = "Applied Color Filter & Click on Product Image", priority = 9)
	public void step10_AppliedColorFilterAndClickOnProductImg() throws Exception {
		productlistingpage = new ProductListingPage(categorylandingpage.driver);
		productlistingpage.ClickOnSeeAlllink();
		productlistingpage.Click_Filter_btn();
	    productlistingpage.Verify_ShopBy_txt();
	    productlistingpage.ClickonRadioBtn_ForBlackColor();
	    productlistingpage.Click_Filter_btn();
	    productlistingpage.VerifyDeleteAllActiveFilterButton();
	    if(environmentName.contains("HomoEnv"))
	    {
		productlistingpage.ClickOnSimpleProductImgFromCategory();
	    }
	    else
	    if(environmentName.contains("StagingEnv"))
	    {
	    productlistingpage.ClickOnSimpleProductImgFromCategory();
	    }
	    else
	    {
	    	productlistingpage.Click_ProductImg3();
	    }    
	}

	@Test(description = "Verified Product Name in Product Details Page", priority = 10)
	public void step11_VerifiedProductNameinPDP() throws Exception {
		productdetailspage = new ProductDetailsPage(productlistingpage.driver);
		productdetailspage.VerifyProductNametxtInPDP();
	}

	@Test(description = "Verified Product Price & Currency Symbol in Product Details Page", priority = 11)
	public void step12_VerifiedProductPriceAndCurrencySymbolInPDP() throws Exception {
		productdetailspage.VerifyProductPricetxtInPDP();
	}

	@Test(description = "Verified Wishlist Icon in Product Details Page", priority = 12)
	public void step13_VerifiedWishlistIconinPDP() throws Exception {
		productdetailspage.VerifyWishlistIconInPDP();
	}

	@Test(description = "Click on In_store_availability button and close overlay", priority = 13)
	public void step14_ClickOnInStoreAvailabilityButtonAndCloseOverlay() throws Exception {
		//productdetailspage.ClickonInStoreAvailabilitybtnAndCloseOverlayForSimpleProductInPDP();
	}

	@Test(description = "Verified Contact Us link", priority = 14)
	public void step15_VerifiedContactUslink() throws Exception {
		productdetailspage.VerifyContactUsLinkInPDP();
	}
	
	@Test(description = "Click on Product Info and Verified content under Product Info section", priority = 15)
	public void step16_ClickonProductInfoAndVerifiedContent() throws Exception {
		CustomFun.refreshPage(homepage.driver);
		productdetailspage.pdpProductInfoBlockForSimpleProd();
		ref_searchable_SKUID=ProductDetailsPage.Ref_searchable_sku_SimpleProd;
	}

	@Test(description = "Click on Product Care and Verified content under Product Care section", priority = 16)
	public void step17_ClickonProductCareAndVerifiedContent() throws Exception {
		productdetailspage.pdpProductCareBlock();
	}

	@Test(description = "Click on Shipping and Verified content under Shipping section", priority = 17)
	public void step18_ClickonShippingAndVerifiedContent() throws Exception {
		productdetailspage.pdpShippingBlock();
	}

	@Test(description = "Click on Add To Cart Button", priority = 18)
	public void step19_ClickonAddToCartButton() throws Exception {
		productdetailspage.pdpAddtoCartbtn();
	}

	@Test(description = "Verified Content in Confirmation Overlay", priority = 19)
	public void step20_VerifiedContentInConfirmationOverlay() throws Exception {
		productdetailspage.pdpProductadd_Notification();
	}

	@Test(description = "Click on Continue Shopping Button & Verify remains in same page", priority = 20)
	public void step21_ClickonContinueShoppingButtonAndVerifyRemainsInSamePage() throws Exception {
		productdetailspage.pdpNotification_Continebtn();
		productdetailspage.VerifyAddtoCartbtnInPDP();
	}

	@Test(description = "Updated Product Quantity till Maximun limit in My Cart", priority = 21)
	public void step22_UpdatedProductQntyTillMaxLimitInMyCart() throws Exception {
		WebElement AddtoCartBtn = productdetailspage.driver
				.findElement(By.xpath("//button[contains(@id,'addtocart')]"));
		for (int i = 0; i < 1; i++) {
			GUIFunctions.JavaScriptClick(productdetailspage.driver, AddtoCartBtn,
					"click on Add ti cart button");
			Thread.sleep(5000);
		}
		log.info("Successfully Updated Product Quantity till Maximun limit In My Cart");
		Reporter.log("<p>Successfully Updated Product Quantity till Maximun limit In My Cart");
	}

	@Test(description = "Click on Order Now Button", priority = 22)
	public void step23_ClickonOrderNowButton() throws Exception {
		productdetailspage.pdpNotification_Ordernowbtn();
	}

	@Test(description = "Verified Gift Options Header & No Warp Img Is Selected in Checkout Page", priority = 23)
	public void step24_VerifiedGiftOptionsHeaderInCP() throws Exception {
		checkoutpage = new CheckoutPage(productdetailspage.driver);
		checkoutpage.VerifyGiftHeadertxt();
		checkoutpage.VerifyNoWarpImgIsSelected();
	}

	@Test(description = "Open New Tab and Navigated to WMS", priority = 24)
	public void step25_OpenNewTabAndNavigatedtoWMS() throws Exception {
		wmspage = new WMSPage(productdetailspage.driver);
		CustomFun.OpenNewTabAndSwitchToNewTab(wmspage.driver, "1");
		wmspage.driver.navigate().to(CustomFun.getWMSInfoDSDetails().get().getWMSURL());
	}

	@Test(description = "Logged into WMS with valid crendentials", priority = 25)
	public void step26_LoggedIntoWMS() throws Exception {
		wmspage.WMSLogIn(CustomFun.getWMSInfoDSDetails().get().getWmsUsername(),
				CustomFun.getWMSInfoDSDetails().get().getWmsPassword());
	}

	@Test(description = "Click on OK button in WMS", priority = 26)
	public void step27_ClickOnOKbutton() throws Exception {
		wmspage.Click_WMSOKBtn();
	}

	@Test(description = "Mouse Over on Data Lists Menu", priority = 27)
	public void step28_MouseOverElementOnDataListsMenu() throws Exception {
		wmspage.WMS_Datalistmenu();
	}

	@Test(description = "Click on Products from Data Lists", priority = 28)
	public void step29_ClickOnProductsFromDataLists() throws Exception {
		wmspage.WMS_Datalist_Productclick();
	}

	@Test(description = "Enter Searchable SKU & Click on Submit Filter", priority = 29)
	public void step30_EnterSearchableSKUAndClickOnSubmitFilter() throws Exception {
		wmspage.SearchSKUIDInListOfProductsForSimpleProd(ref_searchable_SKUID);
		BarCodeSKU=WMSPage.barcodeSKU;
	}

	@Test(description = "Click on Details Button", priority = 30)
	public void step31_ClickOnDetailsButtonForSimpleProd() throws Exception {
		wmspage.ClickOnDetailsButtonForSimpleProd(ref_searchable_SKUID);
	}

	@Test(description = "Scroll down till stocks grid and Verify Initial Saleable Stock", priority = 31)
	public void step32_VerifyInitialSaleableStock() throws Exception {
		wmspage.VerifyInitialSaleableStock();
	}

	@Test(description = "Verify Reserved Stock", priority = 32)
	public void step33_VerifyReservedStock() throws Exception {
		wmspage.VerifyInitialReservedStock();
	}

	@Test(description = "Open New Tab and Navigated to Magento BO", priority = 33)
	public void step34_OpenNewTabAndNavigatedtoMagentoBO() throws Exception {
		backofficepage = new BackOfficePage(homepage.driver);
		CustomFun.OpenNewTabAndSwitchToNewTab(backofficepage.driver, "2");
		backofficepage.driver.navigate().to(CustomFun.getBODSDetails().get().getBO_URL());
	}

	@Test(description = "Entered Username in Username Field", priority = 34)
	public void step35_EnteredUsernameField() throws Exception {
		backofficepage.EnterUsername(CustomFun.getBODSDetails().get().getBO_Username());
	}

	@Test(description = "Entered Password in Password Field", priority = 35)
	public void step36_EnteredPasswordField() throws Exception {
		backofficepage.EnterPassword(CustomFun.getBODSDetails().get().getBO_Password());
	}

	@Test(description = "Click on SignIn Button", priority = 36)
	public void step37_ClickOnSignInButton() throws Exception {
		backofficepage.SignbtnClick();
		if(environmentName.contains("IntegrationEnv") | environmentName.contains("HomoEnv1") | environmentName.contains("StagingEnv") | environmentName.contains("Integration6Env"))
  	    {
  			Thread.sleep(5000);
  			CustomFun.refreshPage(backofficepage.driver);
  			Thread.sleep(5000);
  		}
	}

	@Test(description = "Verified Dashboard Header & check whether user is in Dashboard page", priority = 37)
	public void step38_VerifiedDashboardHeaderInBO() throws Exception {
		CustomFun.waitForPageLoaded(backofficepage.driver);
		backofficepage.VerifyDashboardHeader();
	}

	@Test(description = "Click on Catalog Icon", priority = 38)
	public void step39_ClickOnCatalogIcon() throws Exception {
		backofficepage.CatalogIconClick();
	}

	@Test(description = "Click on Products text from Catalog Icon", priority = 39)
	public void step40_ClickProductstxtFromCatalogIcon() throws Exception {
		backofficepage.ProductstxtFromCatalogIconClick();
		CustomFun.waitForPageLoaded(backofficepage.driver);
	}

	@Test(description = "Search For Product Seleable Stock In BO", priority = 40)
	public void step41_SearchForProductSeleableStockInBO() throws Exception {
		if(bsValue.get().contains("YES"))
		{
            backofficepage.SearchForProductSeleableStockInBO_BS(BarCodeSKU);
		}
		else
		{
			backofficepage.SearchForProductSeleableStockInBO(BarCodeSKU);
		}
	}

	@Test(description = "Verify Initial Saleable Stock", priority = 41)
	public void step42_VerifyInitialSaleableStock() throws Exception {
		backofficepage.VerifyInitialSaleableStockInBO(BarCodeSKU);
	}
	
	@Test(description = "Navigated Into FO & Click on Update Button in Checkout Page at Gift Section", priority = 42)
	public void step43_NavigatedBackIntoFOClickOnUpdateButtonInCP() throws Exception {
		CustomFun.SwitchToSpecificTab(homepage.driver, "0");
		checkoutpage.UpdatebtnClick();
	}

	@Test(description = "Verify Gift Wrap section should be colapsed", priority = 43)
	public void step44_VerifyGiftWrapSectionIsDisappearOrNot() throws Exception {
		checkoutpage.VerifyGiftSectionIsDisAppearOrNot();
	}

	@Test(description = "Shipping Address Header in Checkout Page at Shipping Address Section", priority = 44)
	public void step45_VerifiedShippingAddressHeaderInCP() throws Exception {
		shippingaddresspage = new ShippingAddressPage(checkoutpage.driver);
		shippingaddresspage.VerifyShippingAddressHeader();
	}

	@Test(description = "Verified Product Name under Order summary in Checkout Page at Shipping Address Section", priority = 45)
	public void step46_VerifiedProductNameinPDP() throws Exception {
		checkoutpage = new CheckoutPage(productdetailspage.driver);
		checkoutpage.VerifyProductNametxtInCP();
	}

	@Test(description = "Verified Product Price under order summary in Checkout Page", priority = 46)
	public void step47_VerifiedProductPriceInPDP() throws Exception {
		checkoutpage.VerifyProductPricetxtInCP();
		shippingaddresspage.VerfiedSAAndBABothSameCheckboxIsAutoSelectedForCredit();
	}

	@Test(description="Click on New Address Button in Checkout Page at Shipping Address Section", priority=47)
	public void step48_ClickOnNewAddressButtonInSAP() throws Exception
	{
		shippingaddresspage.NewAddressbtnClick_AsEU();
	}
	
	@Test(description="Entered Address Name in Address Name Field", priority=48)
	public void step49_EnteredAddressNameField() throws Exception
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
	
	@Test(description="Verified Prefix Name Dropdown is Auto Selected or not at Shipping Address Section", priority=49)
	public void step50_VerifiedPrefixNameDpdIsAutoSelectedOrNot() throws Exception
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
	
	@Test(description="Entered First Name in First Name Field", priority=50)
	public void step51_EnteredFirstNameField() throws Exception
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
	
	@Test(description="Entered Last Name in Last Name Field", priority=51)
	public void step52_EnteredLastNameField() throws Exception
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
	
	@Test(description="Entered Address in Address Field", priority=52)
	public void step53_EnteredAddressField() throws Exception
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
	
	@Test(description="Entered PostCode in PostCode Field", priority=53)
	public void step54_EnteredPostCodeField() throws Exception
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
	
	@Test(description="Entered City in City Field", priority=54)
	public void step55_EnteredCityField() throws Exception
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
	
	@Test(description="Entered Phone Number in Phone Number Field", priority=55)
	public void step56_EnteredPhoneNumberField() throws Exception
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
	
	@Test(description="Click on SHIP HERE button in shipping address Overlay and Verify Address Updated Message", priority=56)
	public void step57_ClickOnSHIPHEREButton() throws Exception
	{
		shippingaddresspage.ShipHerebtnClick();
		//Verify Success Message
		shippingaddresspage.VerifyAddressUpdatedSuccessMsg();
	}
	
	@Test(description = "Verified Shipping Methods Header in Checkout Page at Shipping Methods Section", priority = 57)
	public void step58_VerifiedShippingMethodsHeaderInCP() throws Exception {
		shippingaddresspage.VerifyShippingMethodLabel();
	}

	@Test(description = "Click on First Shipping Method radio button in Checkout page", priority = 58)
	public void step59_ClickOnFirstShipMethodRadioButton() throws Exception {
		if(environmentName.contains("Integration6Env"))
		{
			WebElement ele=shippingaddresspage.driver.findElement(By.xpath(ObjRepoProp.get().getProperty("ConfirmThisAddress_xpath")));
			GUIFunctions.JavaScriptClick(shippingaddresspage.driver,
					ele,"Click on Confirm This Address button");
		}
		shippingaddresspage.VerifyAndClickOnSecondShippingmethod();
		//shippingaddresspage.VerifyAndClickOnThirdShippingmethod();
	}

	@Test(description = "Click on Continue To Payemnt button in Checkout page", priority = 59)
	public void step60_ClickOnContinueToPayemntButton() throws Exception {
		shippingaddresspage.ContinuetopaymentbtnClick();
	}

	@Test(description = "Scroll down till Payment options and Verified Payment options in Checkout Page", priority = 60)
	public void step61_VerifiedPaymentoptions() throws Exception {
		paymentpage = new PaymentPage(shippingaddresspage.driver);
		paymentpage.checkout_Paymentoptions();
	}

	@Test(description = "Click on Credit card Radio button under Payment option", priority = 61)
	public void step62_ClickOnCreditCardRadioBtn() throws Exception {
		paymentpage.checkout_Creditcard();
	}

	@Test(description = "Verified My billing and shipping address are the same checkbox is auto selected or not", priority = 62)
	public void step63_VerifiedMyBAandSABothSame_CheckboxIsAutoSelected() throws Exception {
	/*	if(environmentName.equals("HomoEnv1"))	
		{
		  paymentpage.VerfiedSAAndBABothSameCheckboxIsAutoSelected();
		} */
	}

	@Test(description = "Entered Credit Number in Credit Number Field", priority = 63)
	public void step64_EnteredCreditNumberField() throws Exception {
		paymentpage.checkout_CCCardnumber(CustomFun.getPaymentDSDetails().get().getCardNumber());
	}

	@Test(description = "Entered Expiry Date in Expiry Date Field", priority = 64)
	public void step65_EnteredExpiryDateField() throws Exception {
		paymentpage.checkout_CCExpirydate(CustomFun.getPaymentDSDetails().get().getCardExpiryDate());
	}

	@Test(description = "Entered CVV in CVV Field", priority = 65)
	public void step66_EnteredCVVField() throws Exception {
		paymentpage.checkout_CCV(CustomFun.getPaymentDSDetails().get().getCardCVV());
	}

	@Test(description = "Entered CardHolder Name in CardHolder Name Field", priority = 66)
	public void step67_EnteredCardHolderField() throws Exception {
		paymentpage.checkout_Cardholdername(CustomFun.getPaymentDSDetails().get().getCardHolderName());
	}

	@Test(description = "Checked on Privacy Policy and Return Policy checkbox", priority = 67)
	public void step68_CheckedOnPrivacyPolicyAndReturnPolicyCheckbox() throws Exception {
			paymentpage.checkout_Agreements_CreditCard();	
	}

	@Test(description = "Click on Proceed button in Checkout page at Payment Section & Entered 3DS Credentials", priority = 68)
	public void step69_ClickOnProceedButtonAndEntered3DSCredentials() throws Exception {
		paymentpage.checkout_CC_ProceedbtnForCreditCard();
		CustomFun.waitForPageLoaded(paymentpage.driver);
		//paymentpage.checkout_3DSUsername(CustomFun.getPaymentDSDetails().get().get3DS_Username());
		paymentpage.checkout_3DSPassword(CustomFun.getPaymentDSDetails().get().get3DS_Password());
		paymentpage.checkout_ClickOnSubmitButton();
		CustomFun.waitForPageLoaded(paymentpage.driver);
	}

	@Test(description = "Verified Success Message in Order Confirmation page after placing the order", priority = 69)
	public void step70_VerifiedSuccessMsgAfterPlacingOrder() throws Exception {
		orderconfirmationpage = new OrderConfirmationPage(paymentpage.driver);
		orderconfirmationpage.Verify_SuccessOrder_Msg_txt();
	}

	@Test(description = "Verified Continue Shopping Button in Order Confirmation page", priority = 70)
	public void step71_VerifiedContinueShoppingButton() throws Exception {
		orderconfirmationpage.VerifyContinueShopping_Btn();
	}

	@Test(description = "Verified Your OrderID in Order Confirmation page", priority = 71)
	public void step72_VerifiedYourOrderID() throws Exception {
		orderconfirmationpage.VerifyOrderIDInOCP();
	}

	@Test(description = "Initialised OrderID in OrderID variable for further execution", priority = 72)
	public void step73_InitialisedOrderID() throws Exception {
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

	@Test(description = "Click on My Account Icon", priority = 73)
	public void step74_ClickOnMyAccountIcon() throws Exception {
		homepage.driver.findElement(By.xpath(ObjRepoProp.get().getProperty("HP_MyAccount_Icon"))).click();
	}

	@Test(description = "Click on My Orders Link", priority = 74)
	public void step75_ClickOnMyOrdersLink() throws Exception {
		myaccountpage = new MyAccountPage(orderconfirmationpage.driver);
		myaccountpage.MyOrders_LnkClick();
	}

	@Test(description = "Verified Order Status & Other Details in My Orders page", priority = 75)
	public void step76_VerifiedOrderStatusInMyOrdersPage() throws Exception {
		myaccountpage.VerifyOrderStatus(OrderID);
		if(locale.get().contains("FR_FR") | locale.get().contains("CH_FR"))
		{
		Assert.assertEquals(MyAccountPage.OrderStatusFromFO,TextProp.get().getProperty("OrderBeingValidatedtxt_FR"));
		}
		else
		{
		Assert.assertEquals(MyAccountPage.OrderStatusFromFO,TextProp.get().getProperty("OrderPendingSecurityChecktxt_UK"));	
		}
		myaccountpage.VerifyOrderPriceInOrderspage(OrderID);
		OrderPrice=MyAccountPage.PriceVal_OrderPage;
		MyAccountPage.PriceVal_OrderPage = myaccountpage.driver
				.findElement(By.xpath("//*[contains(text(),'" + OrderID + "')]/..//p[contains(@class, 'price')]"))
				.getText().replaceAll(",", "\\.").replaceAll("[^0-9.]", "");
		myaccountpage.VerifyOrderItemInOrderspage(OrderID);
		myaccountpage.VerifyOrderDateInOrderspage(OrderID);
	}

	@Test(description = "Navigated into BO", priority = 77)
	public void step78_NavigatedIntoBO() throws Exception {
		CustomFun.SwitchToSpecificTab(backofficepage.driver, "2");
	}

	@Test(description = "Click on Sales Icon", priority = 78)
	public void step79_ClickOnSalesIcon() throws Exception {
		backofficepage.SalesIconClick();
	}

	@Test(description = "Click on Orders text from Sales Icon", priority = 79)
	public void step80_ClickOrderstxtFromSalesIcon() throws Exception {
		backofficepage.OrderstxtFromSalesIconClick();
	}

	@Test(description = "Verified Orders Header & check whether user is in Orders page", priority = 80)
	public void step81_VerifiedOrdersHeaderInBO() throws Exception {
		backofficepage.VerifyOrdersHeadertxt();
	}

	@Test(description = "Verified Order Status in Orders page", priority = 81)
	public void step82_VerifiedOrderStatusInOrdersPage() throws Exception {
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

	@Test(description = "Verified Seleable Stock Quantity Decremented By 1", priority = 82)
	public void step83_VerifiedSaleableStockQntyDecBy1InBOAferPlacingTheOrder() throws Exception {
		backofficepage.CatalogIconClick();
		backofficepage.ProductstxtFromCatalogIconClick();
		backofficepage.SearchForProductSeleableStockInBO(BarCodeSKU);
		backofficepage.VerifySaleableStockQntyDecBy1InBOAferPlacingTheOrder(ref_searchable_SKUID);
	}

	@Test(description = "Navigated Into WMS and Verified Seleable Stock Quantity Decremented By 1", priority = 83)
	public void step84_VerifySaleableStockDecBy1InWMSAferPlacingTheOrder() throws Exception {
		CustomFun.SwitchToSpecificTab(wmspage.driver, "1");
		CustomFun.refreshPage(wmspage.driver);
		CustomFun.waitForPageLoaded(wmspage.driver);
		wmspage.ClickOnDetailsButtonForSimpleProd(ref_searchable_SKUID);
		wmspage.VerifySaleableStockDecBy1InWMSAferPlacingTheOrder();
	}

	@Test(description = "Comparing the Seleable stock in the WMS and the BO Magento", priority = 84)
	public void step85_ComparedSeleableStockInWMSAndBOBothAreSame() throws Exception {
		CustomFun.SwitchToSpecificTab(wmspage.driver, "1");
		CustomFun.refreshPage(wmspage.driver);
		CustomFun.waitForPageLoaded(wmspage.driver);
		wmspage.VerifyInitialSaleableStock();
		CustomFun.SwitchToSpecificTab(backofficepage.driver, "2");
		backofficepage.CatalogIconClick();
		backofficepage.ProductstxtFromCatalogIconClick();
		backofficepage.SearchForProductSeleableStockInBO(BarCodeSKU);
		backofficepage.VerifyInitialSaleableStockInBO(ref_searchable_SKUID);
		//Assert.assertEquals(BackOfficePage.InitialSaleableStock_BO, WMSPage.InitialSaleableStock_WMS);
	}

	@Test(description = "Picking Order Process", priority = 85)
	public void step86_PickingOrderProcess() throws Exception {
		CustomFun.SwitchToSpecificTab(wmspage.driver, "1");
		wmspage.PickingOrderProcess(OrderID);
	}

	@Test(description = "Verified Picking order for # XXXXX", priority = 86)
	public void step87_VerifiedPickingOrderSuccessMsg() throws Exception {
		wmspage.VerifyPickingOrderSuccessMsg();
	}

	@Test(description = "Navigated Into Magento and Verified Order Status in Orders page", priority = 87)
	public void step88_NaviagtedIntoMangetoAndVerifiedOrderStatusInOrdersPage() throws Exception {
		CustomFun.SwitchToSpecificTab(backofficepage.driver, "2");
		backofficepage.SalesIconClick();
        backofficepage.OrderstxtFromSalesIconClick();
		CustomFun.waitForPageLoaded(backofficepage.driver);
		for(int i=0;i<=2;i++)
		{
			Thread.sleep(60000);
			CustomFun.refreshPage(backofficepage.driver);
			Thread.sleep(5000);
			backofficepage.ClearTheFilterInBO(OrderID);
			backofficepage.VerifyOrderStatusInBO_OrdersPage(OrderID);
			OrderStatus=BackOfficePage.OrderStatus;
			if(OrderStatus.contains(TextProp.get().getProperty("PickingProgresstxt")))
			{
			OrderStatus=BackOfficePage.OrderStatus;
			Assert.assertEquals(TextProp.get().getProperty("PickingProgresstxt"), OrderStatus);
			log.info("Successfully Verified Order Status in Magento After Picking Process: " + OrderStatus);
			Reporter.log("<p>Successfully Verified Order Status in Magento After Picking Process: " + OrderStatus);
			break;
			}
		}
	}

	@Test(description = "Switch to FO Tab & Click on My Account Icon", priority = 88)
	public void step89_SwitchToFOTabAndClickOnMyAccountIcon() throws Exception {
		CustomFun.SwitchToSpecificTab(homepage.driver, "0");
		homepage.driver.findElement(By.xpath(ObjRepoProp.get().getProperty("HP_MyAccount_Icon"))).click();
		CustomFun.waitForPageLoaded(homepage.driver);
	}

	@Test(description = "Click on My Orders Link", priority = 89)
	public void step90_ClickOnMyOrdersLink() throws Exception {
		myaccountpage.MyOrders_LnkClick();
	}

	@Test(description = "Verified Order Status in My Orders page", priority = 90)
	public void step91_VerifiedOrderStatusInMyOrdersPage() throws Exception {
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

	@Test(description = "Navigated Into WMS and Get BarCode From Picking Process", priority = 91)
	public void step92_NavigatedIntoWMSAndGetBarcodeFromPickingProcess() throws Exception {
		CustomFun.SwitchToSpecificTab(wmspage.driver, "1");
		wmspage.getBarCodeFromPickingProcess(OrderID);
		BarCodeForScan=WMSPage.BarCodeId;
	}

	@Test(description = "Navigated Into WMS and Click on Packing Button", priority = 92)
	public void step93_NavigatedIntoWMSAndClickOnPackingBtn() throws Exception {
		wmspage.Click_WMSPackingBtn();
	}

	@Test(description = "Entered BarcodeID in Barcode Field And Search For Packing", priority = 93)
	public void step94_EnteredBarcodeAndSearchForPacking() throws Exception {
		wmspage.EnterBarcodeAndSearchForPacking(BarCodeForScan);
	}

	@Test(description = "Copy SKUID And Enter in Search Field For Scanning Products In Packing", priority = 94)
	public void step95_CopySKUIDAndEnterinSearchFeildForScanningProductsInPacking() throws Exception
	{
		wmspage.CopySKUIDAndEnterinSearchFldForScanningProductsInPacking();	
	}

	@Test(description = "Click on Complete Packing button", priority = 95)
	public void step96_ClickOnCompletePackingBtn() throws Exception {
		wmspage.Click_CompletePackingBtn();
	}

	@Test(description = "Enter quantity in front of any row", priority = 96)
	public void step97_EnteredQuantityInAnyRow() throws Exception {
		wmspage.EnterQuantity_Packing("1");
	}

	@Test(description = "Click on Validate button", priority = 97)
	public void step98_ClickOnValidateBtn() throws Exception {
		wmspage.ClickValidate_Packing();
	}

	@Test(description = "Click on Home Popup button", priority = 98)
	public void step99_ClickOnHomePopupBtn() throws Exception {
		wmspage.ClickHomeBtn_PopUp();
	}

	@Test(description = "Navigated Into Magento and Verified Order Status in Orders page", priority = 99)
	public void step100_NavigatedIntoMangetoAndVerifiedOrderStatusInOrdersPage() throws Exception {
		CustomFun.SwitchToSpecificTab(wmspage.driver, "2");
		CustomFun.refreshPage(wmspage.driver);
		CustomFun.waitForPageLoaded(wmspage.driver);
		backofficepage.ClearTheFilterInBO(OrderID);
		backofficepage.VerifyOrderStatusInBO_OrdersPage(OrderID);
		OrderStatus = BackOfficePage.OrderStatus;
		Assert.assertEquals(TextProp.get().getProperty("Invoicedtxt"), OrderStatus);
		log.info("Successfully Verified Order Status in Magento After Packing Process is completed: " + OrderStatus);
		Reporter.log("<p>Successfully Verified Order Status in Magento After Packing Process is completed: " + OrderStatus);
	}

	@Test(description = "Switch to FO Tab & Click on My Account Icon", priority = 100)
	public void step101_SwitchToFOTabAndClickOnMyAccountIcon() throws Exception {
		CustomFun.SwitchToSpecificTab(backofficepage.driver, "0");
		homepage.driver.findElement(By.xpath(ObjRepoProp.get().getProperty("HP_MyAccount_Icon"))).click();
	}

	@Test(description = "Click on My Orders Link", priority = 101)
	public void step102_ClickOnMyOrdersLink() throws Exception {
		myaccountpage.MyOrders_LnkClick();
	}

	@Test(description = "Verified Order Status in My Orders page", priority = 102)
	public void step103_VerifiedOrderStatusInMyOrdersPage() throws Exception {
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

	@Test(description = "Navigated Into WMS and Processed with Shipping Process", priority = 103)
	public void step104_NavigatedIntoWMSAndProcessedwithShippingProcess() throws Exception {
		CustomFun.SwitchToSpecificTab(wmspage.driver, "1");
		wmspage.ShippingOrderProcess(BarCodeForScan);
	}

	@Test(description = "Navigated Into Magento and Verified Order Status in Orders page", priority = 104)
    public void step105_NavigatedIntoMangetoAndVerifiedOrderStatusInOrdersPage() throws Exception {
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
        backofficepage.ClearTheFilterInBO(OrderID);
		backofficepage.VerifyOrderStatusInBO_OrdersPage(OrderID);
        OrderStatus = BackOfficePage.OrderStatus;
        Assert.assertEquals(TextProp.get().getProperty("Shippedtxt"), OrderStatus);
        log.info("Successfully Verified Order Status in Magento After Shipping Process is completed: " + OrderStatus);
        Reporter.log(
                "<p>Successfully Verified Order Status in Magento After Shipping Process is completed: " + OrderStatus);
    }

	@Test(description = "Switch to FO Tab & Click on My Account Icon", priority = 105)
	public void step106_SwitchToFOTabAndClickOnMyAccountIcon() throws Exception {
		CustomFun.SwitchToSpecificTab(backofficepage.driver, "0");
		homepage.clickMyaccountBtn();
	}

	@Test(description = "Click on My Orders Link", priority = 106)
	public void step107_ClickOnMyOrdersLink() throws Exception {
		myaccountpage.MyOrders_LnkClick();
	}

	@Test(description = "Verified Order Status in My Orders page", priority = 107)
	public void step108_VerifiedOrderStatusInMyOrdersPage() throws Exception {
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
	
	  @Test(description="Comparing the Seleable stock in the WMS and the BO Magento after shipping the order", priority=108)
	    public void step109_ComparedSeleableStockInWMSAndBOBothAreSameAfterShippingTheOrder() throws Exception
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

	@Test(description = "Open New tab & Navigated to Adyen", priority = 109)
	public void step110_NavigatedIntoAdyenAndClickOnPaymentTab() throws Exception {
		CustomFun.SwitchToSpecificTab(myaccountpage.driver, "2");
		CustomFun.OpenNewTabAndSwitchToNewTab(myaccountpage.driver, "3");
		adyenpage = new AdyenPage(myaccountpage.driver);
		adyenpage.driver.navigate().to(CustomFun.getAdyenInfoDSDetails().get().getAdyenUrl());
	}

	@Test(description = "Logged into Adyen with valid crendentials & Click On Payment Tab", priority = 110)
	public void step111_LoggedIntoAdyen() throws Exception {
		adyenpage.AdyenLogIn(CustomFun.getAdyenInfoDSDetails().get().getAdyenUsername(),
				CustomFun.getAdyenInfoDSDetails().get().getAdyenAccount(),
				CustomFun.getAdyenInfoDSDetails().get().getAdyenPassword());
		adyenpage.Click_AdyenTransactionTab();
		Thread.sleep(1000);
		adyenpage.Click_AdyenTransactionPaymentTab();
	}

	@Test(description = "Enter order Id in serach bar  ", priority = 111)
	public void step112_EnterOrderIDinPaymentTab_adyen() throws Exception {
		adyenpage.Enter_AdyenPaymentSearchField(OrderID);
	}

	@Test(description = "Verify order total amount in Adyen ", priority = 112)
	public void step113_VerifyOrderTotalAmtIN_adyen() throws Exception {
		adyenpage.Verify_AdyenOrderAmount(OrderID,OrderPrice);
	}

	@Test(description = "Navigated back to FO and click on RMA Product Return Btn ", priority = 113)
	public void step114_ClickOnRMAProductReturnBtn() throws Exception {
		CustomFun.SwitchToSpecificTab(homepage.driver, "0");
		myaccountpage.MyOrders_LnkClick();
		myaccountpage.ClickOnMyorders_RMAProductReturnBtn(OrderID);
	}

	@Test(description = "Creating RMA from FO  ", priority = 114)
	public void step115_CreatingRMAFromFO() throws Exception
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

	@Test(description = "Navigated back to BO and click on Returns from sales tab", priority = 115)
	public void step116_NavigatedIntoMangetoAndClickOnReturnsFromSales() throws Exception {
		CustomFun.SwitchToSpecificTab(backofficepage.driver, "2");
		backofficepage.SalesIconClick();
		backofficepage.ReturnstxtFromSalesIconClick();
	}

	@Test(description = "Click on filters and enter RMA ID", priority = 116)
	public void step117_ClickONFiltersAndEnterRMAID() throws Exception {
		if (!backofficepage.driver.findElement(By.xpath("//button[text()='Clear all']")).isDisplayed()) {
			Thread.sleep(5000);
			if(bsValue.get().contains("YES"))
			{
				backofficepage.ClearTheFilterInBOForReturnsOrder(OrderID);
			}
			else
			{
				backofficepage.ClearTheFilterInBOForReturnsOrder(OrderID);
			}
			Thread.sleep(2000);
			CustomFun.refreshPage(backofficepage.driver);
			Thread.sleep(5000);
		} else {
			Thread.sleep(5000);
			backofficepage.ClearTheFilterInBOForReturnsOrder(OrderID);
			Thread.sleep(5000);
			if(bsValue.get().contains("YES"))
			{
				backofficepage.ClearTheFilterInBOForReturnsOrder(OrderID);
			}
			else
			{
				backofficepage.ClearTheFilterInBOForReturnsOrder(OrderID);
			}
			Thread.sleep(2000);
		}
		// Fetch RMAID From BO
		RMAID = backofficepage.driver.findElement(By.xpath("//div[contains(text(),'" + OrderID + "')]/../preceding-sibling::td//div")).getText();
		Thread.sleep(2000);
		backofficepage.ClearTheFilterInBOForReturnsOrder(OrderID);
         backofficepage.VerifyReturnsStatusInBO_ReturnsPage(OrderID);

		for (int i = 0; i <= 5; i++)
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

	@Test(description = "Click on Sales Icon", priority = 118)
	public void step119_ClickOnSalesIcon() throws Exception 
	{
		backofficepage.SalesIconClick();
	}

	@Test(description = "Click on Orders text from Sales Icon", priority = 119)
	public void step120_ClickOrderstxtFromSalesIcon() throws Exception {
		backofficepage.OrderstxtFromSalesIconClick();
		CustomFun.waitForPageLoaded(backofficepage.driver);
	}

	@Test(description = "Verified Order Status in Orders page", priority = 120)
	public void step121_VerifiedOrderStatusInOrdersPage() throws Exception {
		backofficepage.ClearTheFilterInBO(OrderID);
		backofficepage.VerifyOrderStatusInBO_OrdersPage(OrderID);
		OrderStatus = BackOfficePage.OrderStatus;
		Assert.assertEquals(TextProp.get().getProperty("ProcessingRMAtxt"), OrderStatus);
		log.info("Successfully Verified Order Status in Orders Page After Returns submit is completed: " + OrderStatus);
		Reporter.log("<p>Successfully Verified Order Status in Orders Page After Returns submit is completed: "
				+ OrderStatus);
	}
	
	@Test(description = "Swich to FO Tab & Click on My Account Icon", priority = 121)
	public void step122_SwitchToFOTabAndClickOnMyAccountIcon() throws Exception {
		CustomFun.SwitchToSpecificTab(homepage.driver, "0");
		CustomFun.refreshPage(homepage.driver);
		//GUIFunctions.JavaScriptClick(homepage.driver, homepage.driver.findElement(By.xpath("//img[@class='logo-desktop']")), "CL LOGO");
		//Thread.sleep(2000);
		//GUIFunctions.mouseOverElement(homepage.driver, homepage.driver.findElement(By.xpath(ObjRepoProp.get().getProperty("HP_MyAccount_Icon1"))),"My Account");
		homepage.driver.findElement(By.xpath(ObjRepoProp.get().getProperty("HP_MyAccount_Icon"))).click();	
		Thread.sleep(2000);
		
	}

	@Test(description = "Click on My Orders Link", priority = 122)
	public void step123_ClickOnMyOrdersLink() throws Exception {
		myaccountpage.MyOrders_LnkClick();
	}

	@Test(description = "Verified Order Status in My Orders page", priority = 123)
	public void step124_VerifiedOrderStatusInMyOrdersPage() throws Exception {
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
	
	@Test(description = "Navigated Into WMS and Validate the RMA reception in the WMS", priority = 125)
	public void step126_ClickOnRMALink() throws Exception {
		CustomFun.SwitchToSpecificTab(homepage.driver, "1");
		wmspage.Click_RMALnk();
	}

	@Test(description = "Enter RMA ID in RMA Field, Click on Submit Filter button & Reception button in WMS", priority = 126)
	public void step127_EnterRMAID_SearchForOrderDetails_ClickOnReceptionButton() throws Exception
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

	@Test(description = "Execute RMA Process in WMS", priority = 127)
	public void step128_ExecuteRMAProcessinWMS() throws Exception {
		wmspage.ExecuteRMAProcess();
			Thread.sleep(5000);
	}

	@Test(description = "Navigated Into Magento and Click on Sales Icon", priority = 129)
	public void step130_NavigatedIntoMangetoAndVerifiedOrderStatusInOrdersPage() throws Exception {
		CustomFun.SwitchToSpecificTab(backofficepage.driver, "2");
		backofficepage.SalesIconClick();
		Thread.sleep(5000);
	}

	@Test(description = "Click on Returns link from Sales Tab", priority = 130)
	public void step131_ReturnstxtFromSalesIconClick() throws Exception {
		backofficepage.ReturnstxtFromSalesIconClick();
	}

	@Test(description = "Verified Order Status in Returns page", priority = 131)
	public void step132_VerifiedOrderStatusInReturnsPage() throws Exception {
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

	@Test(description = "Click on View option under order grid", priority = 132)
	public void step133_ClickonViewOptioninOrderGrid() throws Exception {
		backofficepage.ClickOnOrderGrid(OrderID);
	}

	@Test(description = "Click on Return Items Tab", priority = 133)
	public void step134_ClickOnReturnItems() throws Exception {
		backofficepage.ReturnsItemsClick();
	}

	@Test(description = "Entered Approved value in Approved Field under RMA Items Requested for Grid", priority = 134)
	public void step135_EnterValueInApprovedField() throws Exception {
		backofficepage.EnterValueInApprovedField("1");
	}

	@Test(description = "Select Approved option from Status Dropdown", priority = 135)
	public void step136_SelectApprovedOptionFromStatusDropdown() throws Exception {
		backofficepage.SelectApprovedOptionFromStatusDropdown();
	}

	@Test(description = "Click on Save Button", priority = 136)
	public void step137_ClickOnSaveButton() throws Exception {
		backofficepage.ClickOnSaveButton();
	}

	@Test(description = "Verify Success Msg For RMA Request after submit returns", priority = 137)
	public void step138_VerifySuccessMsgForSavedRMARequest() throws Exception {
		backofficepage.VerifySuccessMsgForSavedRMARequest();
	}

	@Test(description = "Click on Sales Icon", priority = 138)
	public void step139_ClickOnSalesIcon() throws Exception {
		backofficepage.SalesIconClick();
	}

	@Test(description = "Click on Orders text from Sales Icon", priority = 139)
	public void step140_ClickOrderstxtFromSalesIcon() throws Exception {
		backofficepage.OrderstxtFromSalesIconClick();
	}

	@Test(description = "Verified Order Status in Orders page", priority = 140)
	public void step141_VerifiedOrderStatusInOrdersPage() throws Exception {
		backofficepage.ClearTheFilterInBO(OrderID);
		backofficepage.VerifyOrderStatusInBO_OrdersPage(OrderID);
		OrderStatus = BackOfficePage.OrderStatus;
		Assert.assertEquals(TextProp.get().getProperty("WaitingForCreditMemotxt"), OrderStatus);
		log.info("Successfully Verified Order Status in Orders Page After RMA Approved : " + OrderStatus);
		Reporter.log("<p>Successfully Verified Order Status in Orders Page After RMA Approved: " + OrderStatus);
		backofficepage.Click_viewBtnForPdt();	
	    CustomFun.waitForPageLoaded(backofficepage.driver);
	    backofficepage.driver.findElement(By.xpath("//span[contains(text(),'Comments History')]")).click();
		Thread.sleep(2000);
		ShipmentID=backofficepage.driver.findElement(By.xpath("//span[contains(text(),'Shipment #')]")).getText().replaceAll("[^0-9.]", "");
		}

	@Test(description = "Click on Sales Icon", priority = 141)
	public void step142_ClickOnSalesIcon() throws Exception {
		backofficepage.SalesIconClick();
	}

	@Test(description = "Click on Returns link from Sales Tab", priority = 142)
	public void step143_ReturnstxtFromSalesIconClick() throws Exception {
		backofficepage.ReturnstxtFromSalesIconClick();
		CustomFun.waitForPageLoaded(backofficepage.driver);
	}

	@Test(description = "Verified Order Status in Returns page", priority = 143)
	public void step144_VerifiedOrderStatusInReturnsPage() throws Exception {
		 backofficepage.ClearTheFilterInBOForReturnsOrder(OrderID);
         backofficepage.VerifyReturnsStatusInBO_ReturnsPage(OrderID);
		RMAIDStatus = BackOfficePage.RMAIDStatus;
		Assert.assertEquals(TextProp.get().getProperty("Approvedtxt"), RMAIDStatus);
		log.info("Successfully Verified Order Status in Returns Page After RMA Approved : " + RMAIDStatus);
		Reporter.log("<p>Successfully Verified Order Status in Returns Page After RMA Approved : " + RMAIDStatus);
	}

	@Test(description = "Click on View option under order grid", priority = 144)
	public void step145_ClickonViewOptioninOrderGrid() throws Exception {
		backofficepage.ClickOnOrderGrid(OrderID);
		CustomFun.waitForPageLoaded(backofficepage.driver);
	}

	@Test(description = "Click On Refund/Exchange Button in Order Details Page", priority = 145)
	public void step146_ClickOnRefundOrExchangeButton() throws Exception {
		backofficepage.ClickOnRefundOrExchangeButton();
		Thread.sleep(10000);
		String[] NewMemoID = backofficepage.driver.findElement(By.xpath("//h1")).getText().split(" ");
		RefundMemoID = NewMemoID[3];
	}

	@Test(description = "Scroll down till Refund button in New Memo Page & Click on Refund Button", priority = 146)
	public void step147_ClickOnRefundButtonInNewMemoPage() throws Exception {
		backofficepage.ClickOnRefundButtonInNewMemoPage();
	}

	@Test(description = "Verify Success Msg For Create Credit Memo after Refund created", priority = 147)
	public void step148_VerifySuccessMsgForCreateCreditMemo() throws Exception {
		backofficepage.VerifySuccessMsgForCreateCreditMemo();
	}

	@Test(description = "Click on Sales Icon", priority = 148)
	public void step149_ClickOnSalesIcon() throws Exception {
		backofficepage.SalesIconClick();
	}

	@Test(description = "Click on Orders text from Sales Icon", priority = 149)
	public void step150_ClickOrderstxtFromSalesIcon() throws Exception {
		backofficepage.OrderstxtFromSalesIconClick();
		CustomFun.waitForPageLoaded(backofficepage.driver);
	}

	@Test(description = "Verified Order Status in Orders page", priority = 150)
	public void step151_VerifiedOrderStatusInOrdersPage() throws Exception
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
	}

	@Test(description = "Click on Sales Icon", priority = 151)
	public void step152_ClickOnSalesIcon() throws Exception {
		backofficepage.SalesIconClick();
	}

	@Test(description = "Click on Returns link from Sales Tab", priority = 152)
	public void step153_ReturnstxtFromSalesIconClick() throws Exception {
		backofficepage.ReturnstxtFromSalesIconClick();
		CustomFun.waitForPageLoaded(backofficepage.driver);
	}

	@Test(description = "Verified Order Status in Returns page", priority = 153)
	public void step154_VerifiedOrderStatusInReturnsPage() throws Exception {
		 backofficepage.ClearTheFilterInBOForReturnsOrder(OrderID);
         backofficepage.VerifyReturnsStatusInBO_ReturnsPage(OrderID);
		RMAIDStatus = BackOfficePage.RMAIDStatus;
		Assert.assertEquals(TextProp.get().getProperty("ProcessedandClosedtxt"), RMAIDStatus);
		log.info("Successfully Verified Order Status in Returns Page After Refund Created : " + RMAIDStatus);
		Reporter.log("<p>Successfully Verified Order Status in Returns Page After Refund Created : " + RMAIDStatus);
	}

	@Test(description = "Swich to FO Tab & Click on My Account Icon", priority = 154)
	public void step155_SwitchToFOTabAndClickOnMyAccountIcon() throws Exception {
		CustomFun.SwitchToSpecificTab(homepage.driver, "0");
		//GUIFunctions.mouseOverElement(homepage.driver, homepage.driver.findElement(By.xpath(ObjRepoProp.get().getProperty("HP_MyAccount_Icon"))),"My Account");
		homepage.driver.findElement(By.xpath(ObjRepoProp.get().getProperty("HP_MyAccount_Icon"))).click();	
	}

	@Test(description = "Click on My Orders Link", priority = 155)
	public void step156_ClickOnMyOrdersLink() throws Exception {
		myaccountpage.MyOrders_LnkClick();
	}

	@Test(description = "Verified Order Status in My Orders page", priority = 156)
	public void step157_VerifiedOrderStatusInMyOrdersPage() throws Exception {
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
	
	 @Test(description="Comparing the Seleable stock in the WMS and the BO Magento after Refund the order", priority=157)
	    public void step158_ComparedSeleableStockInWMSAndBOBothAreSameAfterRefundTheOrder() throws Exception
	    {
	    //Verify Seleable Stock in WMS after Refund the order
	    CustomFun.SwitchToSpecificTab(wmspage.driver, "1");
	    Thread.sleep(2000);
		CustomFun.refreshPage(wmspage.driver);
		Thread.sleep(2000);
	    wmspage.WMS_Datalistmenu();
	    wmspage.WMS_Datalist_Productclick();
	    wmspage.ClickOnDetailsButtonForSimpleProd(ref_searchable_SKUID);
	    wmspage.VerifySaleableStockIncBy1InWMSAfterRefundTheOrder();
	    wmspage.VerifyInitialReservedStock();
	    //Verify Seleable Stock in BO after Refund the order
	    CustomFun.SwitchToSpecificTab(backofficepage.driver, "2");
	    backofficepage.CatalogIconClick();
	    backofficepage.ProductstxtFromCatalogIconClick();
	    backofficepage.SearchForProductSeleableStockInBO(BarCodeSKU);
	    backofficepage.VerifySaleableStockQntyIncBy1InBOAferRefundTheOrder(BarCodeSKU);
	    //Assert.assertEquals(BackOfficePage.InitialSaleableStock_BO, WMSPage.InitialSaleableStock_WMS);
	    }
	
	
	@Test(description="Verify Order Confirmation Mail Contents", priority=158)
  	public void step159_VerifyOrderConfirmationMailContents() throws Exception
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
  	
  	@Test(description="Verify Shipping Confirmation Mail Contents", priority=159)
  	public void step160_VerifyShippingConfirmationMailContents() throws InterruptedException
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
  	   
  	@Test(description="Verify Return Request Confirmation Mail Contents", priority=160)
  	public void step161_VerifyReturnRequestConfirmationMailContents() throws InterruptedException
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
  	
  	@Test(description="Verify Return Reception Confirmation Mail Contents", priority=161)
  	public void step162_VerifyReturnReceptionConfirmationMailContents() throws Exception
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
  	
  	@Test(description="Verify Credit Memo Confirmation Mail Contents", priority=162)
  	public void step163_VerifyCreditMemoConfirmationMailContents() throws Exception
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
