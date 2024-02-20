package src.in.valtech.cl.front.pages;

import org.openqa.selenium.WebDriver; 
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;
import org.apache.log4j.Logger;
import static src.in.valtech.util.PropertyFileReader.ObjRepoProp;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import src.in.valtech.config.BaseTest;
import src.in.valtech.custom.CustomFun;
import src.in.valtech.uifunctions.GUIFunctions;
import org.openqa.selenium.By;

/**
 * @author Priyanka
 *
 */

public class ProductDetailsPage extends BaseTest
{
	public Logger log = Logger.getLogger(this.getClass().getName());

	public WebDriver driver;
	HomePage homepage;
	CategoryLandingPage categorylandingpage;
	public static String ProductName_FO;
	public static String Ref_searchable_sku;
	public static String Ref_searchable_sku_SimpleProd;
	public static String GetSizeOfProd;
	public static String juicydetails;

	/**
	 * Verification of ProductDetailPage Desc:Verofy product Detail page
	 * ProductDetail: Constructor
	 */

	public ProductDetailsPage(WebDriver driver) {
		this.driver = driver;
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	// To fetch the Xpaths from Object Repository file
	By PDP_Productname = By.xpath(ObjRepoProp.get().getProperty("PDP_Productname"));
	By PDP_ProductPrice = By.xpath(ObjRepoProp.get().getProperty("PDP_ProductPrice"));
	By PDP_Sizebtn = By.xpath(ObjRepoProp.get().getProperty("PDP_Sizebtn"));
	By PDP_SelectedSize = By.xpath(ObjRepoProp.get().getProperty("PDP_SelectedSize"));
	By PDP_SelectedSecondSize = By.xpath(ObjRepoProp.get().getProperty("PDP_SelectedSecondSize"));
	By PDP_Sizeguide = By.xpath(ObjRepoProp.get().getProperty("PDP_Sizeguide"));
	By PDP_Sizeguidetable = By.xpath(ObjRepoProp.get().getProperty("PDP_Sizeguidetable"));
	By PDP_AddtoCart = By.xpath(ObjRepoProp.get().getProperty("PDP_AddtoCart"));
	By PDP_Colors = By.xpath(ObjRepoProp.get().getProperty("PDP_Colors"));
	By PDP_CheckStoreAvailability = By.xpath(ObjRepoProp.get().getProperty("PDP_CheckStoreAvailability"));
	By PDP_ContactUS = By.xpath(ObjRepoProp.get().getProperty("PDP_ContactUS"));
	By PDP_JuicyDetails = By.xpath(ObjRepoProp.get().getProperty("PDP_JuicyDetails"));
	By PDP_ProductInfo = By.xpath(ObjRepoProp.get().getProperty("PDP_ProductInfo"));
	By PDP_ProductCare = By.xpath(ObjRepoProp.get().getProperty("PDP_ProductCare"));
	By PDP_Shipping = By.xpath(ObjRepoProp.get().getProperty("PDP_Shipping"));
	By PDP_AllJucityDetailContent = By.xpath(ObjRepoProp.get().getProperty("PDP_AllJucityDetailContent"));
	By PDP_ProductInfoContent = By.xpath(ObjRepoProp.get().getProperty("PDP_ProductInfoContent"));
	By PDP_ProductCareContent = By.xpath(ObjRepoProp.get().getProperty("PDP_ProductCareContent"));
	By PDP_ShippingContent = By.xpath(ObjRepoProp.get().getProperty("PDP_ShippingContent"));
	By PDP_WishlistIcon = By.xpath(ObjRepoProp.get().getProperty("PDP_WishlistIcon"));
	By PDP_Checkstore_Zipcode = By.xpath(ObjRepoProp.get().getProperty("PDP_Checkstore_Zipcode"));
	By PDP_Checkstore_Contactus = By.xpath(ObjRepoProp.get().getProperty("PDP_Checkstore_Contactus"));
	By PDP_Checskstore_Needhelp = By.xpath(ObjRepoProp.get().getProperty("PDP_Checskstore_Needhelp"));
	By PDP_Checkstore_Closebtn = By.xpath(ObjRepoProp.get().getProperty("PDP_Checkstore_Closebtn"));
	By PDP_Sizeguide_Closebtn = By.xpath(ObjRepoProp.get().getProperty("PDP_Sizeguide_Closebtn"));
	By PDP_Upsell = By.xpath(ObjRepoProp.get().getProperty("PDP_Upsell"));
	By PDP_Mainimage = By.xpath(ObjRepoProp.get().getProperty("PDP_Mainimage"));
	By PDP_ThumbnailimageBlock = By.xpath(ObjRepoProp.get().getProperty("PDP_ThumbnailimageBlock"));
	By PDP_SecondThumbnailimage = By.xpath(ObjRepoProp.get().getProperty("PDP_SecondThumbnailimage"));
	By PDP_Notification = By.xpath(ObjRepoProp.get().getProperty("PDP_Notification"));
	By PDP_Notification_Amazing = By.xpath(ObjRepoProp.get().getProperty("PDP_Notification_Amazing"));
	By PDP_Notification_Productadded = By.xpath(ObjRepoProp.get().getProperty("PDP_Notification_Productadded"));
	By PDP_Notification_Productname = By.xpath(ObjRepoProp.get().getProperty("PDP_Notification_Productname"));
	By PDP_Notification_Productprice = By.xpath(ObjRepoProp.get().getProperty("PDP_Notification_Productprice"));
	By PDP_Notification_ProductImage = By.xpath(ObjRepoProp.get().getProperty("PDP_Notification_ProductImage"));
	By PDP_Notification_Productoptions = By.xpath(ObjRepoProp.get().getProperty("PDP_Notification_Productoptions"));
	By PDP_Notification_Closebtn = By.xpath(ObjRepoProp.get().getProperty("PDP_Notification_Closebtn"));
	By PDP_Notification_ContineShopping = By.xpath(ObjRepoProp.get().getProperty("PDP_Notification_ContineShopping"));
	By PDP_Notification_Ordernowbtn = By.xpath(ObjRepoProp.get().getProperty("PDP_Notification_Ordernowbtn"));
	By PDP_InStoreAvailabilityClosebtn = By.xpath(ObjRepoProp.get().getProperty("PDP_InStoreAvailabilityClosebtn"));
	By PDP_InStoreAvailabilityClosebtn2 = By.xpath(ObjRepoProp.get().getProperty("PDP_InStoreAvailabilityClosebtn2"));
	By PDP_ProductBrandName_xpath = By.xpath(ObjRepoProp.get().getProperty("PDP_ProductBrandName"));
	By PDP_Searchable_Sku = By.xpath(ObjRepoProp.get().getProperty("PDP_Searchable_Sku"));
	By PDP_Searchable_Sku_SimpleProd = By.xpath(ObjRepoProp.get().getProperty("PDP_Searchable_Sku_SimpleProd"));
	By PDP_Searchable_Sku_BeautyProd = By.xpath(ObjRepoProp.get().getProperty("PDP_Searchable_Sku_BeautyProd"));
	By PDP_YourCart_Lnk = By.xpath(ObjRepoProp.get().getProperty("PDP_YourCart_lnk"));

	/**
	 * Verification of product details like Product name, Price and Brand
	 */
	public ProductDetailsPage pdpProductdetails() throws Exception {
		CustomFun.isElementVisible(PDP_Productname, driver);
		CustomFun.isElementVisible(PDP_ProductPrice, driver);
		log.info("Product name and Product price are displaying at expected position");
		Reporter.log("Product name and Product price are displaying at expected position");
		return new ProductDetailsPage(driver);
	}

	/**
	 * Verification of Size guide block and information
	 */
	public ProductDetailsPage pdpSizeguideInfo() throws Exception {
		CustomFun.waitObjectToLoad(driver, PDP_Sizeguide, Duration.ofSeconds(10));
		CustomFun.isElementVisible(PDP_Sizeguide, driver);
		log.info("Successfully Verified Size Guide in PDP");
		Reporter.log("<p>Successfully Verified Size Guide in PDP");
		GUIFunctions.JavaScriptClick(driver, driver.findElement(PDP_Sizeguide), "Click on sizeguide button");
		Thread.sleep(1000);
		CustomFun.isElementVisible(PDP_Sizeguidetable, driver);
		log.info("Successfully Verified Size Guide Table in PDP");
		Reporter.log("<p>Successfully Verified Size Guide Table in PDP");
		Thread.sleep(1000);
		if(environmentName.contains("IntegrationEnv") | environmentName.equals("StagingEnv"))
		{
			driver.findElement(By.xpath("(//*[contains(@id,'modal-title')]/following-sibling::button[contains(@class,'action-close')])[3]"))
		    .click();
		    Thread.sleep(1000);
		}
		else
		if(environmentName.equals("StagingEnv1"))
		{
			GUIFunctions.JavaScriptClick(driver, driver.findElement(PDP_Sizeguide_Closebtn),
					"Click on close icon to close the size guide overlay");
		    Thread.sleep(1000);
		}
		else
		{
			driver.findElement(By.xpath("(//*[contains(@id,'modal-title')]/following-sibling::button[contains(@class,'action-close')])[3]"))
		    .click();
		    Thread.sleep(1000);
		}
		return new ProductDetailsPage(driver);
	}

	/**
	 * Click on Add to cart button
	 */
	public ProductDetailsPage pdpAddtoCartbtn() throws Exception {
		GUIFunctions.scrollByJavaScriptExecutor(driver.findElement(PDP_Productname), driver, "Add To Cart button");
		GUIFunctions.JavaScriptClick(driver, driver.findElement(PDP_AddtoCart), "Click on Add To Cart button");
		Thread.sleep(2000);
		return new ProductDetailsPage(driver);
	}

	/**
	 * Click on In store availability button and verify the boutique overlay
	 * displays
	 */
	public ProductDetailsPage ClickonInStoreAvailabilitybtnAndCloseOverlayInPDP() throws Exception {
	/*	GUIFunctions.clickElement(driver, PDP_CheckStoreAvailability , "Click on check store availability option");
		Thread.sleep(1000);
		if(environmentName.equals("StagingEnv"))
		{
			System.out.println("StagingEnv");
			GUIFunctions.clickElement(driver, PDP_InStoreAvailabilityClosebtn,
					"Click on close icon to close the availability in boutique overlay");
		}
		else 
		if(environmentName.contains("HomoEnv1") | environmentName.contains("StagingEnv1") | environmentName.contains("IntegrationEnv"))
		{
			System.out.println("StagingEnv1");
			driver.findElement(By.xpath("//*[contains(text(),'Disponibilit') or contains(text(),'Availability in boutique')]/following-sibling::button[@class='action-close']"))
		    .click();
		    Thread.sleep(1000);
		}
		else
		{
			System.out.println("StagingEnv3");
			driver.findElement(By.xpath("(//h1[contains(@class,'modal-title')]/following-sibling::button[@class='action-close'])[4]"))
		    .click();
		    Thread.sleep(1000);
		}   */
		return new ProductDetailsPage(driver);
	}

	/**
	 * Click on In store availability button and verify the boutique overlay
	 * displays
	 */
	public ProductDetailsPage ClickonInStoreAvailabilitybtnAndCloseOverlayForSimpleProductInPDP() throws Exception {
	/*	GUIFunctions.clickElement(driver, PDP_CheckStoreAvailability, "Click on check store availability option");
		if(environmentName.contains("StagingEnv"))
		{
			GUIFunctions.clickElement(driver, PDP_InStoreAvailabilityClosebtn2,
					"Click on close icon to close the availability in boutique overlay");
		}
		else 
		if(environmentName.contains("HomoEnv") | environmentName.contains("StagingEnv1"))
		{
			By closebtn=By.xpath("(//h1[contains(@class,'modal-title')]/following-sibling::button[@class='action-close'])[1]");
			GUIFunctions.clickElement(driver, closebtn,
					"Click on close icon to close the availability in boutique overlay");
		    Thread.sleep(1000);
		}
		else
		{
			By closebtn=By.xpath("(//h1[contains(@class,'modal-title')]/following-sibling::button[@class='action-close'])[2]");
			GUIFunctions.clickElement(driver, closebtn,
					"Click on close icon to close the availability in boutique overlay");
		    Thread.sleep(1000);
		}  */
		return new ProductDetailsPage(driver);
	}

	/**
	 * Enter Zipcode and select the value from dropdown
	 */
	public ProductDetailsPage pdpZipcodeValue(String Zipcode) throws Exception {
		GUIFunctions.typeTxtboxValue(driver, PDP_Checkstore_Zipcode, Zipcode);
		CustomFun.isElementVisible(PDP_Checskstore_Needhelp, driver);
		return new ProductDetailsPage(driver);
	}

	/**
	 * Click on Contact us button which displays in boutique overlay
	 */
	public ProductDetailsPage pdpCheckStoreContactusBtn() throws Exception {
		GUIFunctions.clickElement(driver, PDP_Checkstore_Contactus, "Click on contactus button");
		return new ProductDetailsPage(driver);
	}

	/**
	 * Click on close button to close the boutique overlay
	 */
	public ProductDetailsPage pdpCheckStoreCloseBtn() throws Exception {
		GUIFunctions.clickElement(driver, PDP_Checkstore_Closebtn, "Click on close icon to close the boutique overlay");
		return new ProductDetailsPage(driver);
	}

	/**
	 * Verify juicy details block and info
	 */
	
	public ProductDetailsPage pdpAllJuicyDetailsBlock() throws Exception 
	{
		CustomFun.isElementVisible(PDP_JuicyDetails, driver);
		CustomFun.isElementVisible(PDP_AllJucityDetailContent, driver);
		log.info("All juicy details block and content displayed as expected");
		Reporter.log("All juicy details block and content displayed as expected");
		return new ProductDetailsPage(driver);
	}
	
	/**
	 * Verify all juicy details block
	 */
	
	public ProductDetailsPage ClickOnAllJuicyDetailsBlock() throws Exception {
		CustomFun.waitObjectToLoad(driver, PDP_JuicyDetails, Duration.ofSeconds(10));
		CustomFun.isElementVisible(PDP_JuicyDetails, driver);
		GUIFunctions.JavaScriptClick(driver, driver.findElement(PDP_JuicyDetails), "Click on all juicy details block option");
		CustomFun.waitObjectToLoad(driver, PDP_AllJucityDetailContent, Duration.ofSeconds(10));
		juicydetails = driver.findElement(PDP_AllJucityDetailContent).getText().trim();
		Thread.sleep(1000);
		log.info("Verified content displayed as expected under all juicy details block");
		Reporter.log("<p>Verified content displayed as expected under all juicy details blocks");
		return new ProductDetailsPage(driver);
	}

	/**
	 * Verify Product details block and info
	 */
	public ProductDetailsPage pdpProductInfoBlock() throws Exception {
		GUIFunctions.mouseOverElement(driver, driver.findElement(By.xpath(ObjRepoProp.get().getProperty("HP_MyAccount_Icon"))),"My Account");
		CustomFun.waitObjectToLoad(driver, PDP_ProductInfo, Duration.ofSeconds(10));
		CustomFun.isElementVisible(PDP_ProductInfo, driver);
		Thread.sleep(1000);
		GUIFunctions.clickElement(driver, PDP_ProductInfo, "Click on product information option");
		CustomFun.waitObjectToLoad(driver, PDP_ProductInfoContent, Duration.ofSeconds(10));
		String[] RefIDs = driver.findElement(PDP_Searchable_Sku).getText().split(":");
		Ref_searchable_sku = RefIDs[1].replaceAll(" ", "");
		System.out.println("Reference SKUID : " + Ref_searchable_sku);
		Thread.sleep(1000);
		log.info("Verified content displayed as expected under Product Information");
		Reporter.log("<p>Verified content displayed as expected under Product Information");
		return new ProductDetailsPage(driver);
	}
	
	/**
	 * Verify Product details block and info for Simple Prod
	 */
	public ProductDetailsPage pdpProductInfoBlockForSimpleProd() throws Exception {
		CustomFun.waitObjectToLoad(driver, PDP_ProductInfo, Duration.ofSeconds(10));
		CustomFun.isElementVisible(PDP_ProductInfo, driver);
		GUIFunctions.JavaScriptClick(driver, driver.findElement(PDP_ProductInfo), "Click on product information option");
		CustomFun.waitObjectToLoad(driver, PDP_ProductInfoContent, Duration.ofSeconds(10));
		String[] RefIDs = driver.findElement(PDP_Searchable_Sku_SimpleProd).getText().split(":");
		Ref_searchable_sku_SimpleProd = RefIDs[1].replaceAll(" ", "");
		System.out.println("Reference SKUID : " + Ref_searchable_sku_SimpleProd);
		log.info("Verified content displayed as expected under Product Information");
		Reporter.log("<p>Verified content displayed as expected under Product Information");
		return new ProductDetailsPage(driver);
	}
	
	/**
	 * Verify Product details block and info for Beauty Prod
	 */
	public ProductDetailsPage pdpProductInfoBlockForBeautyProd() throws Exception {
		CustomFun.waitObjectToLoad(driver, PDP_ProductInfo,Duration.ofSeconds(20));
		CustomFun.isElementVisible(PDP_ProductInfo, driver);
		GUIFunctions.clickElement(driver, PDP_ProductInfo, "Click on product information option");
		CustomFun.waitObjectToLoad(driver, PDP_ProductInfoContent, Duration.ofSeconds(30));
		String[] RefIDs = driver.findElement(PDP_Searchable_Sku_BeautyProd).getText().split(":");
		Ref_searchable_sku_SimpleProd = RefIDs[1].replaceAll(" ", "");
		System.out.println("Reference SKUID : " + Ref_searchable_sku_SimpleProd);
		log.info("Verified content displayed as expected under Product Information");
		Reporter.log("<p>Verified content displayed as expected under Product Information");
		return new ProductDetailsPage(driver);
	}
	
	/**
	 * Verify Product care block and info
	 */
	public ProductDetailsPage pdpProductCareBlock() throws Exception {
		CustomFun.waitObjectToLoad(driver, PDP_ProductCare, Duration.ofSeconds(10));
		CustomFun.isElementVisible(PDP_ProductCare, driver);
		GUIFunctions.JavaScriptClick(driver, driver.findElement(PDP_ProductCare), "Click on Product Care option");
		CustomFun.waitObjectToLoad(driver, PDP_ProductCareContent, Duration.ofSeconds(10));
		CustomFun.isElementVisible(PDP_ProductCareContent, driver);
		log.info("Verified content displayed as expected under Product Care");
		Reporter.log("<p>Verified content displayed as expected under Product Care");
		return new ProductDetailsPage(driver);
	}

	/**
	 * Verify Product Shipping block and info
	 */
	public ProductDetailsPage pdpShippingBlock() throws Exception {
		CustomFun.isElementVisible(PDP_Shipping, driver);
		GUIFunctions.JavaScriptClick(driver, driver.findElement(PDP_Shipping), "Click on Shipping option");
		CustomFun.isElementVisible(PDP_ShippingContent, driver);
		log.info("Verified content displayed as expected under Shipping");
		Reporter.log("<p>Verified content displayed as expected under Shipping");
		return new ProductDetailsPage(driver);
	}

	/**
	 * Verify color swatches displays
	 */
	public ProductDetailsPage pdpColorSwatches() throws Exception {
		
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(CustomFun.isElementVisible(PDP_Colors, driver), true);
		Thread.sleep(2000);
		log.info("Successfully Verified Color Swatches in Product details page");
		Reporter.log("Successfully Verified Color Swatches in Product details page");
		return new ProductDetailsPage(driver);
	}

	/**
	 * Click on Wishlist button
	 */
	public ProductDetailsPage pdpWishlistBtn() throws Exception {
		GUIFunctions.clickElement(driver, PDP_WishlistIcon, "Click on add to wishlist button");
		log.info("Product is marked as wishlist product");
		Reporter.log("Sucessfully added the product as Wishlist product");
		return new ProductDetailsPage(driver);
	}

	/**
	 * Click on Contct us button
	 */
	public ProductDetailsPage pdpContactUsBtn() throws Exception {
		GUIFunctions.clickElement(driver, PDP_ContactUS, "Click on contact us button");
		return new ProductDetailsPage(driver);
	}

	/**
	 * Verify Upsell block displays
	 */
	public ProductDetailsPage pdpUpsellBlock() throws Exception {
		CustomFun.isElementVisible(PDP_Upsell, driver);
		return new ProductDetailsPage(driver);
	}

	/**
	 * Verify images section
	 */
	public ProductDetailsPage pdpMainimage() throws Exception {
		CustomFun.isElementVisible(PDP_Mainimage, driver);
		CustomFun.isElementVisible(PDP_ThumbnailimageBlock, driver);
		log.info("Product Image and Thumbnail Image are displaying in Product details page");
		Reporter.log("<p>Product Image and Thumbnail Image are displaying in Product details page");
		return new ProductDetailsPage(driver);
	}

	/**
	 * Click on Thubnail image
	 */
	public ProductDetailsPage pdpSecondThumbnailimgClick() throws Exception {
		GUIFunctions.clickElement(driver, PDP_SecondThumbnailimage, "Click on secondthumbnail image");
		log.info("Dispalyed Second thubnail image as Main image at image section");
		Reporter.log("Sucessfully Dispalyed Second thubnail image as Main image at image section");
		return new ProductDetailsPage(driver);
	}

	/**
	 * Verify product add notification overlay and content
	 */
	public ProductDetailsPage pdpProductadd_Notification() throws Exception {
		CustomFun.isElementVisible(PDP_Notification, driver);
		GUIFunctions.verifyUIElementAndShowText(driver.findElement(PDP_Notification_Amazing),
				"Amazing text in Confirmation Overlay");
		GUIFunctions.verifyUIElementAndShowText(driver.findElement(PDP_Notification_Productadded),
				"A product has been added to text in Confirmation Overlay");
		GUIFunctions.verifyUIElementAndShowText(driver.findElement(PDP_Notification_Productname),
				"Product Name text in Confirmation Overlay");
		GUIFunctions.verifyUIElementAndShowText(driver.findElement(PDP_Notification_Productprice),
				"Product Price text in Confirmation Overlay");
		CustomFun.isElementVisible(PDP_Notification_ProductImage, driver);
		CustomFun.isElementVisible(PDP_Notification_Productoptions, driver);
		CustomFun.isElementVisible(PDP_Notification_Closebtn, driver);
		return new ProductDetailsPage(driver);
	}

	/**
	 * Click on Close button to close the notification overlay
	 */
	public ProductDetailsPage pdpNotification_Closebtn() throws Exception {
		GUIFunctions.JavaScriptClick(driver, driver.findElement(PDP_Notification_Closebtn), "Click on close button to clse the notification");
		return new ProductDetailsPage(driver);
	}

	/**
	 * Click on Continue shopping button to close the overlay
	 */
	public ProductDetailsPage pdpNotification_Continebtn() throws Exception {
		Assert.assertTrue(CustomFun
				.isElementPresent(By.xpath(ObjRepoProp.get().getProperty("PDP_Notification_ContineShopping")), driver),
				"continue shopping CTA is not displayed");
		GUIFunctions.clickElement(driver, PDP_Notification_ContineShopping, "Click on continue shopping CTA");
		return new ProductDetailsPage(driver);
	}

	/**
	 * Click on Order now button
	 */
	public ProductDetailsPage pdpNotification_Ordernowbtn() throws Exception {
		Thread.sleep(1000);
		GUIFunctions.JavaScriptClick(driver, driver.findElement(PDP_Notification_Ordernowbtn), "Click on Order now CTA");
		return new ProductDetailsPage(driver);
	}

	/**
	 * MethodName=VerifyProductNametxtInPDP Description:This function used to verify
	 * product name in Product Details Page and show product name in reports
	 */

	public ProductDetailsPage VerifyProductNametxtInPDP() throws InterruptedException {
		GUIFunctions.verifyUIElementAndShowText(driver.findElement(PDP_Productname),
				"Product Name in PDP & Product Name is");
		return new ProductDetailsPage(driver);
	}

	/**
	 * MethodName=VerifyProductPricetxtInPDP Description:This function used to
	 * verify product price in Product Details Page and show product price in
	 * reports
	 */

	public ProductDetailsPage VerifyProductPricetxtInPDP() throws InterruptedException {
		GUIFunctions.verifyUIElementAndShowText(driver.findElement(PDP_ProductPrice),
				"Product Price in PDP & Product Price is");
		return new ProductDetailsPage(driver);
	}
	
	/**
	 * MethodName=VerifyWishlistIconInPDP Description:This function used to verify
	 * wishlist icon in Product Details Page
	 */
	public ProductDetailsPage VerifyWishlistIconInPDP() throws Exception {
		Assert.assertTrue(CustomFun.isElementPresent(PDP_WishlistIcon, driver),
				"Wishlist Icon is not displaying in PDP");
		Thread.sleep(1000);
		log.info("Successfully verified  Wishlist Icon in Product Details Page");
		Reporter.log("<p>Successfully verified Wishlist Icon in Product Details Page");
		return new ProductDetailsPage(driver);
	}

	/**
	 * MethodName=ClickOnSelectYourSizeBtnAndSelectAnySizeInPDP Description:This
	 * function used to click on select your size button and select any size
	 */
	public ProductDetailsPage ClickOnSelectYourSizeBtnAndSelectAnySizeInPDP() throws Exception {
		CustomFun.waitObjectToLoad(driver, PDP_Sizebtn, Duration.ofSeconds(30));
		WebDriverWait wait = new WebDriverWait(driver,40);
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("(//div[contains(@class,'product-add-form')]//button)[2]"))));
		WebElement sizebtn=driver.findElement(By.xpath("(//div[contains(@class,'product-add-form')]//button)[2]"));
		GUIFunctions.JavaScriptClick(driver, sizebtn, "Click on Size Button ");
		Thread.sleep(1000);
		if(!GUIFunctions.isElementPresent((PDP_SelectedSize), driver))
		{
			driver.findElement(By.xpath("(//button[@class='action-close'])[2]")).click();
			categorylandingpage=new CategoryLandingPage(driver);
			categorylandingpage.MouseOverOnL1GentlemenCategory();
			driver.findElement(By.xpath("//span[contains(text(),'Louis')]")).click();
			Thread.sleep(2000);
			categorylandingpage.Click_ProductImg2();
			Thread.sleep(2000);
			GUIFunctions.clickElement(driver, PDP_Sizebtn, "Click on Select Your Size Button");
			String Size = driver.findElement(PDP_SelectedSize).getText();
			System.out.println("First"+ Size);
			GetSizeOfProd= Size.replace(".", "_");
			GUIFunctions.clickElement(driver, PDP_SelectedSize, "Selected Size");
			Thread.sleep(1000);
		}
		else
		{
		String Size = driver.findElement(PDP_SelectedSize).getText();
		GetSizeOfProd= Size.replace(".", "_");
		System.out.println("Selected Size : " + GetSizeOfProd);
		GUIFunctions.clickElement(driver, PDP_SelectedSize, "Selected Size");
		Thread.sleep(1000);
		}
		return new ProductDetailsPage(driver);
	}
	
	/**
	 * MethodName=ClickOnSelectYourSizeBtnAndSelectSecondSizeInPDP Description:This
	 * function used to click on select your size button and select any size
	 */
	public ProductDetailsPage ClickOnSelectYourSizeBtnAndSelectSecondSizeInPDP() throws Exception {
		Thread.sleep(1000);
		GUIFunctions.clickElement(driver, PDP_Sizebtn, "Click on Select Your Size Button");
		if(!GUIFunctions.isElementPresent((PDP_SelectedSize), driver))
		{
			driver.findElement(By.xpath("(//button[@class='action-close'])[2]")).click();
			homepage=new HomePage(driver);
			homepage.mousehoverOnLadiesHeaderNavigation();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//span[contains(text(),'Vieira')]")).click();
			Thread.sleep(2000);
			categorylandingpage=new CategoryLandingPage(driver);
			categorylandingpage.Click_ProductImg();
			Thread.sleep(2000);
			GUIFunctions.clickElement(driver, PDP_Sizebtn, "Click on Select Your Size Button");
			GUIFunctions.clickElement(driver, PDP_SelectedSecondSize, "Selected Second Size");
			Thread.sleep(1000);
		}
		else
		{
			GUIFunctions.clickElement(driver, PDP_SelectedSecondSize, "Selected Size");
		    Thread.sleep(1000);
		}
		return new ProductDetailsPage(driver);
	}

	/**
	 * MethodName=VerifyContactUsLinkInPDP Description:This function used to verify
	 * Contact Us link in Product Details Page
	 */
	public ProductDetailsPage VerifyContactUsLinkInPDP() throws Exception {
		Assert.assertTrue(CustomFun.isElementPresent(PDP_ContactUS, driver),"Contact Us link is not displaying in PDP");
		log.info("Successfully verified  Contact Us link in Product Details Page");
		Reporter.log("<p>Successfully verified Contact Us link in Product Details Page");
		return new ProductDetailsPage(driver);
	}

	public ProductDetailsPage VerifyProductBrandNametxtInPDP() throws InterruptedException {
		GUIFunctions.verifyUIElementAndShowText(driver.findElement(PDP_ProductBrandName_xpath),
				"Product Brand Name in PDP & Product brand Name is");
		return new ProductDetailsPage(driver);
	}

	/**
	 * Verify Addto Cart btn
	 * 
	 * @return :ProductDetailsPage
	 */

	public ProductDetailsPage VerifyAddtoCartbtnInPDP() throws Exception {
		Assert.assertTrue(CustomFun.isElementPresent(By.xpath(ObjRepoProp.get().getProperty("PDP_AddtoCart")), driver),
				"add to cart CTA is not displayed");
		log.info("Successfully verified add to cart CTA");
		return new ProductDetailsPage(driver);
	}

	/**
	 * Verify continue and order now button in PDP overlay
	 */
	public ProductDetailsPage pdpNotification_ContinebtnOrderNow() throws Exception {
		Assert.assertTrue(CustomFun
				.isElementPresent(By.xpath(ObjRepoProp.get().getProperty("PDP_Notification_Ordernowbtn")), driver),
				"order now CTA is not displayed");
		Assert.assertTrue(CustomFun
				.isElementPresent(By.xpath(ObjRepoProp.get().getProperty("PDP_Notification_ContineShopping")), driver),
				"continue shopping CTA is not displayed");
		return new ProductDetailsPage(driver);
	}
	
	
	/**
	* Click on your cart link in mini cart model
	* @return :CartPage
	 * @throws Exception 
	*/

	public ProductDetailsPage Click_ON_YourCartLnk_Minicart() throws Exception{
	GUIFunctions.JavaScriptClick(driver, driver.findElement(PDP_YourCart_Lnk) ,"Click on your cart link in mini cart ");
	return new ProductDetailsPage(driver);

	}
}
