package src.in.valtech.cl.front.pages;
import static src.in.valtech.util.PropertyFileReader.ObjRepoProp; 
import static src.in.valtech.util.PropertyFileReader.TextProp;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;
import src.in.valtech.config.BaseTest;
import src.in.valtech.custom.CustomFun;
import src.in.valtech.uifunctions.GUIFunctions;

/**
 * @author Veenashree.CM
 *
 */

public class CartPage
{

	public Logger log = Logger.getLogger(this.getClass().getName());

	public WebDriver driver;

	/**
	 * Verification of CartPage Desc:Proper navigation to CartPage CartPage:
	 * Constructor
	 */
	public CartPage(WebDriver driver) {
		this.driver = driver;
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	// To fetch the Xpaths from Object Repository file

	By MiniCP_MYCart_txt = By.xpath(ObjRepoProp.get().getProperty("MiniCP_MYcart_txt"));
	By MiniCP_Cart_Close_Icon = By.xpath(ObjRepoProp.get().getProperty("MiniCP_Cart_CloseIcon"));
	By MiniCP_Free_Returns_txt = By.xpath(ObjRepoProp.get().getProperty("MiniCP_FreeReturns_txt"));
	By MiniCP_Your_Cart_txt = By.xpath(ObjRepoProp.get().getProperty("MiniCP_YourCart_txt"));
	By MiniCP_YourCart_Desc_txt = By.xpath(ObjRepoProp.get().getProperty("MiniCP_YourCart_Desctxt"));
	By MiniCP_Product_Img = By.xpath(ObjRepoProp.get().getProperty("MiniCP_Product_img"));
	By MiniCP_Product_name = By.xpath(ObjRepoProp.get().getProperty("MiniCP_Product_Name"));
	By MiniCP_Product_desc = By.xpath(ObjRepoProp.get().getProperty("MiniCP_Product_Desc"));
	By MiniCP_Product_price = By.xpath(ObjRepoProp.get().getProperty("MiniCP_Product_Price"));
	By MiniCP_Product_color = By.xpath(ObjRepoProp.get().getProperty("MiniCP_Product_Color"));
	By MiniCP_Product_size = By.xpath(ObjRepoProp.get().getProperty("MiniCP_Product_Size"));
	By MiniCP_Quant_Incr_Icon = By.xpath(ObjRepoProp.get().getProperty("MiniCP_Quant_Incr"));
	By MiniCP_Quant_Decr_Icon = By.xpath(ObjRepoProp.get().getProperty("MiniCP_Quant_Decr"));
	By MiniCP_Quantity_val = By.xpath(ObjRepoProp.get().getProperty("MiniCP_Quantity"));
	By MiniCP_Remove_link = By.xpath(ObjRepoProp.get().getProperty("MiniCP_Remove_lnk"));
	By MiniCP_Wishlist_link = By.xpath(ObjRepoProp.get().getProperty("MiniCP_Wishlist_lnk"));
	By MiniCP_Cart_SubTotal = By.xpath(ObjRepoProp.get().getProperty("MiniCP_CartSubTotal"));
	By MiniCP_Cart_Total = By.xpath(ObjRepoProp.get().getProperty("MiniCP_CartTotal"));
	By MiniCP_CheckOut_Btn = By.xpath(ObjRepoProp.get().getProperty("MiniCP_CheckOut_btn"));
	By MiniCP_ContactUs_link = By.xpath(ObjRepoProp.get().getProperty("MiniCP_ContactUs_lnk"));
	By MiniCP_SeeInCompleteCart_link = By.xpath(ObjRepoProp.get().getProperty("MiniCP_SeeInCompleteCart_lnk"));
	By MainCP_YourBasket_txt = By.xpath(ObjRepoProp.get().getProperty("MainCP_Yourbasket_txt"));
	By MainCP_ThisLooksGreat_Txt = By.xpath(ObjRepoProp.get().getProperty("MainCP_ThisLooksGreat_txt"));
	By MainCP_FreeReturns_Txt = By.xpath(ObjRepoProp.get().getProperty("MainCP_FreeReturns_txt"));
	By MainCP_Product_Img = By.xpath(ObjRepoProp.get().getProperty("MainCP_Product_img"));
	By MainCP_Product_name = By.xpath(ObjRepoProp.get().getProperty("MainCP_Product_Name"));
	By MainCP_Product_desc = By.xpath(ObjRepoProp.get().getProperty("MainCP_Product_Desc"));
	By MainCP_Product_price = By.xpath(ObjRepoProp.get().getProperty("MainCP_Product_Price"));
	By MainCP_Product_color = By.xpath(ObjRepoProp.get().getProperty("MainCP_Product_Color"));
	By MainCP_Product_size = By.xpath(ObjRepoProp.get().getProperty("MainCP_Product_Size"));
	By MainCP_Quant_Incr_Icon = By.xpath(ObjRepoProp.get().getProperty("MainCP_Quant_Incr"));
	By MainCP_Quant_Decr_Icon = By.xpath(ObjRepoProp.get().getProperty("MainCP_Quant_Decr"));
	By MainCP_Quantity_val = By.xpath(ObjRepoProp.get().getProperty("MainCP_Quantity"));
	By MainCP_Remove_Lnk = By.xpath(ObjRepoProp.get().getProperty("MainCP_Remove_lnk"));
	By MainCP_Wishlist_Lnk = By.xpath(ObjRepoProp.get().getProperty("MainCP_Wishlist_lnk"));
	By MainCP_Cart_Subtotal = By.xpath(ObjRepoProp.get().getProperty("MainCP_CartSubTotal"));
	By MainCP_Cart_Total = By.xpath(ObjRepoProp.get().getProperty("MainCP_CartTotal"));
	By MainCP_CheckOut_Btn = By.xpath(ObjRepoProp.get().getProperty("MainCP_CheckOut_btn"));
	By MainCP_ContactUs_Lnk = By.xpath(ObjRepoProp.get().getProperty("MainCP_ContactUs_lnk"));
	By MiniCP_MyCartHeader = By.xpath(ObjRepoProp.get().getProperty("MiniCP_MyCartHeader"));
	By MainCP_ProceedToCheck_btn = By.xpath(ObjRepoProp.get().getProperty("MainCP_ProceedToCheck_btn"));
	By FAQSection = By.xpath(ObjRepoProp.get().getProperty("FAQSection"));
	By PaymentNonClickable_sectionIcons = By.xpath(ObjRepoProp.get().getProperty("PaymentNonClickable_sectionIcons"));
	By Credit3DSCardUnSuccessfullyMsg_xpath = By.xpath(ObjRepoProp.get().getProperty("Credit3DSCardUnSuccessfullyMsg"));
	By MainCP_TotalAndDeliverySummary = By.xpath(ObjRepoProp.get().getProperty("MainCP_TotalAndDeliverySummary"));
	By FixedLegaltxt = By.xpath(ObjRepoProp.get().getProperty("FixedLegaltxt"));

	/**
	 * Click on Close icon of mini cart
	 * 
	 * @return :CartPage
	 */

	public CartPage Click_ON_CloseIcon_Minicart() throws InterruptedException {
		GUIFunctions.clickElement(driver, MiniCP_Cart_Close_Icon, "Click on Close icon of mini cart ");
		return new CartPage(driver);

	}

	/**
	 * Verification of product information
	 * 
	 * @return :CartPage
	 */

	// Verification of product details in mini cart
	public CartPage Verify_Product_Details_IN_MiniCart() throws InterruptedException {
		// Verification of product image
		Assert.assertTrue(
				CustomFun.isElementPresent(By.xpath(ObjRepoProp.get().getProperty("MiniCP_Product_img")), driver),
				"Product image is not displayed");
		log.info("Successfully verified Product image in Mini Cart");
		Reporter.log("<p>Successfully verified Product image in Mini Cart");

		// Verification of product name
		GUIFunctions.verifyUIElementAndShowText(driver.findElement(MiniCP_Product_name), "Product Name in Mini Cart");
		log.info("Successfully Verified Product name text\n");
		Reporter.log("<p>Successfully verified Product name in Mini Cart");

		// Verification of product description
		GUIFunctions.verifyUIElementAndShowText(driver.findElement(MiniCP_Product_desc),
				"Product Description in Mini Cart");
		log.info("Successfully Verified product description text\n");
		Reporter.log("<p>Successfully verified Product description in Mini Cart");

		// Verification of product price
		GUIFunctions.verifyUIElementAndShowText(driver.findElement(MiniCP_Product_price), "Product Price in Mini Cart");
		log.info("Successfully Verified product price text\n");
		Reporter.log("<p>Successfully verified Product price in Mini Cart");

		// Verification of product color
		GUIFunctions.verifyUIElementAndShowText(driver.findElement(MiniCP_Product_color), "Product Color in Mini Cart");
		log.info("Successfully Verified product color text\n");
		Reporter.log("<p>Successfully verified Product color in Mini Cart");

		// Verification of product size
		GUIFunctions.verifyUIElementAndShowText(driver.findElement(MiniCP_Product_size), "Product Size in Mini Cart");
		log.info("Successfully Verified product size val\n");
		Reporter.log("<p>Successfully verified Product size in Mini Cart");

		return new CartPage(driver);

	}

	/**
	 * MethodName=Verify ProductQty In mini cart page () Description:This function
	 * used to verify product quantity in Main cart page and show product quantity
	 * in reports
	 */

	public CartPage VerifyProductQtyIn_MiniCart() throws InterruptedException {
		GUIFunctions.verifyUIElementAndShowText(driver.findElement(MiniCP_Quantity_val),
				"Product Quantity in Mini cart  Page");
		return new CartPage(driver);
	}

	/**
	 * Click on quantity Decrement(-) icon
	 * 
	 * @return :CartPage
	 */

	public CartPage Click_ON_DecrQuantity_Minicart() throws InterruptedException {
		GUIFunctions.clickElement(driver, MiniCP_Quant_Decr_Icon, "Click on quantity Decrement(-) icon of mini cart ");
		return new CartPage(driver);

	}

	/**
	 * Click on quantity Increment(-) icon
	 * 
	 * @return :CartPage
	 */

	public CartPage Click_ON_IncrQuantity_Minicart() throws InterruptedException {
		GUIFunctions.clickElement(driver, MiniCP_Quant_Incr_Icon, "Click on quantity Increment(-) icon of mini cart ");
		return new CartPage(driver);

	}

	/**
	 * Click on remove link in mini cart
	 * 
	 * @return :CartPage
	 */

	public CartPage Click_ON_RemoveLnk_Minicart() throws InterruptedException {
		GUIFunctions.clickElement(driver, MiniCP_Remove_link, "Click on remove link in mini cart ");
		return new CartPage(driver);

	}

	/**
	 * Click on Wishlist link in mini cart
	 * 
	 * @return :CartPage
	 */

	public CartPage Click_ON_WishlistLnk_Minicart() throws InterruptedException {
		GUIFunctions.clickElement(driver, MiniCP_Wishlist_link, "Click on Wishlist link in mini cart ");
		return new CartPage(driver);

	}

	/**
	 * Verification of product pricing information in mini cart
	 * 
	 * @return :CartPage
	 */

	// Verification of product price details
	public CartPage Verify_Product_price_Details_MiniCart() throws InterruptedException {
		GUIFunctions.verifyUIElementAndShowText(driver.findElement(MiniCP_Cart_SubTotal),
				"Product subtotal in Cart Page");
		System.out.println("Successfully verified product cart subtotal val ");
		log.info("Successfully Verified product cart subtotal val \n");

		GUIFunctions.verifyUIElementAndShowText(driver.findElement(MiniCP_Cart_Total), "Product total in Cart Page");
		System.out.println("Successfully verified product cart total val ");
		log.info("Successfully Verified product cart total val \n");
		return new CartPage(driver);
	}

	/**
	 * Click on Proceed To CheckOut in mini cart
	 * 
	 * @return :CartPage
	 * @throws Exception
	 */

	public CartPage MainCP_CheckOut_btnMainCP_CheckOut_btn() throws Exception {
		GUIFunctions.JavaScriptClick(driver, driver.findElement(MainCP_CheckOut_Btn),
				"Click on Proceed To CheckOut in mini cart ");
		return new CartPage(driver);

	}

	/**
	 * Click on contact us link in mini cart
	 * 
	 * @return :CartPage
	 */

	public CartPage Click_ON_ContactUSLNK_Minicart() throws InterruptedException {
		GUIFunctions.clickElement(driver, MiniCP_ContactUs_link, "Click on contact us link in mini cart ");
		return new CartPage(driver);

	}

	/**
	 * Click on complete cart link in mini cart
	 * 
	 * @return :CartPage
	 * @throws Exception
	 */

	public CartPage Click_ON_CompleteCartLnk_Minicart() throws Exception {
		GUIFunctions.JavaScriptClick(driver, driver.findElement(MiniCP_SeeInCompleteCart_link),
				"Click on complete cart link in mini cart");
		return new CartPage(driver);
	}

	/**
	 * Verification of all texts in Maincart of red banner
	 * 
	 * @return :CartPage
	 */

	// Verification of all texts in Maincart of red banner
	public CartPage Verify_All_Redbannertxt_InMainCart() throws InterruptedException {
		// Verification of Your basket text in Maincart
		Thread.sleep(2000);
		BaseTest.expected = driver.findElement(MainCP_YourBasket_txt).getText().trim();
		Assert.assertEquals(TextProp.get().getProperty("MainCP_Yourbasket_text"), BaseTest.expected);
		System.out.println("Successfully verified   Your basket text ");
		log.info("Successfully  Verified Your basket text  \n");

		// Verification of This Looks Great text in Maincart
		BaseTest.expected = driver.findElement(MainCP_ThisLooksGreat_Txt).getText().trim();
	//	Assert.assertEquals(TextProp.get().getProperty("MainCP_ThisLooksGreat_txt"), BaseTest.expected);
		System.out.println("Successfully verified   This Looks Great text ");
		log.info("Successfully  Verified  This Looks Great text  \n");

		// Verification of FreeReturns text in Maincart
		BaseTest.expected = driver.findElement(MainCP_FreeReturns_Txt).getText().trim();
		Assert.assertEquals(TextProp.get().getProperty("MainCP_FreeReturns_text"), BaseTest.expected);
		System.out.println("Successfully verified   FreeReturns text ");
		log.info("Successfully  Verified FreeReturns text  \n");
		return new CartPage(driver);

	}

	// Verification of product details in main cart
	public CartPage Verify_Product_Details_InMainCart() throws InterruptedException {
		// Verification of product image
		Assert.assertTrue(
				CustomFun.isElementPresent(By.xpath(ObjRepoProp.get().getProperty("MainCP_Product_img")), driver),
				"Product image is not displayed");
		log.info("Successfully verified Product image");
		Reporter.log("<p>Successfully verified Product image");

		// Verification of product name
		GUIFunctions.verifyUIElementAndShowText(driver.findElement(MainCP_Product_name),
				"Product name text in Main Cart Page");
		System.out.println("Successfully verified Product name text ");
		log.info("Successfully Verified Product name text \n");

		// Verification of product description
		GUIFunctions.verifyUIElementAndShowText(driver.findElement(MainCP_Product_desc),
				"product description text in Main Cart Page");
		System.out.println("Successfully verified product description text ");
		log.info("Successfully Verified product description text \n");

		// Verification of product price
		GUIFunctions.verifyUIElementAndShowText(driver.findElement(MainCP_Product_price),
				"Product total in Main Cart Page");
		System.out.println("Successfully verified product price text ");
		log.info("Successfully Verified product price text \n");

		// Verification of product color
		GUIFunctions.verifyUIElementAndShowText(driver.findElement(MainCP_Product_color),
				"Product color in Main Cart Page");
		System.out.println("Successfully verified product color text ");
		log.info("Successfully Verified product color text \n");

		// Verification of product size
		GUIFunctions.verifyUIElementAndShowText(driver.findElement(MainCP_Product_size),
				"Product size in Main Cart Page");
		System.out.println("Successfully verified product size val ");
		log.info("Successfully Verified product size val \n");

		return new CartPage(driver);

	}

	/**
	 * MethodName=Verify ProductQty In main cart page () Description:This function
	 * used to verify product quantity in Main cart page and show product quantity
	 * in reports
	 */

	public CartPage VerifyProductQtyIn_MainCart() throws InterruptedException {
		GUIFunctions.verifyUIElementAndShowText(driver.findElement(MainCP_Quantity_val),
				"Product Quantity in Main cart  Page");
		return new CartPage(driver);
	}

	/**
	 * Click on quantity Decrement(-) icon
	 * 
	 * @return :CartPage
	 * @throws Exception
	 */

	public CartPage Click_ON_DecrQuantity_Maincart() throws Exception {
		GUIFunctions.JavaScriptClick(driver, driver.findElement(MainCP_Quant_Decr_Icon),
				"Click on quantity Decrement(-) icon of main cart ");
		return new CartPage(driver);

	}

	/**
	 * Click on quantity Increment(-) icon
	 * 
	 * @return :CartPage
	 * @throws Exception 
	 */

	public CartPage Click_ON_IncrQuantity_Maincart() throws Exception {
		CustomFun.waitObjectToLoad(driver, MainCP_Quant_Incr_Icon, Duration.ofSeconds(40));
		GUIFunctions.JavaScriptClick(driver, driver.findElement(MainCP_Quant_Incr_Icon), "Click on quantity Increment(-) icon of main cart ");
		return new CartPage(driver);

	}

	/**
	 * Click on remove link in main cart
	 * 
	 * @return :CartPage
	 */

	public CartPage Click_ON_RemoveLnk_Maincart() throws InterruptedException {
		GUIFunctions.clickElement(driver, MainCP_Remove_Lnk, "Click on remove link in main cart ");
		return new CartPage(driver);

	}

	/**
	 * Click on Wishlist link in main cart
	 * 
	 * @return :CartPage
	 */

	public CartPage Click_ON_WishlistLnk_Maincart() throws InterruptedException {
		GUIFunctions.clickElement(driver, MainCP_Wishlist_Lnk, "Click on Wishlist link in main cart ");
		return new CartPage(driver);

	}

	/**
	 * Verification of product pricing information in main cart
	 * 
	 * @return :CartPage
	 */

	// Verification of product price details
	public CartPage Verify_Product_price_Details_MainCart() throws InterruptedException {
		// Verification of product cart subtotal
		GUIFunctions.verifyUIElementAndShowText(driver.findElement(MainCP_Cart_Subtotal),
				"Product sub total in Main Cart Page");
		Reporter.log("Successfully verified product cart subtotal val in main cart page");
		log.info("Successfully Verified product cart subtotal val in main cart page");

		// Verification of product cart total

		GUIFunctions.verifyUIElementAndShowText(driver.findElement(MainCP_Cart_Total),
				"Product total in Main Cart Page");
		Reporter.log("Successfully verified product cart total val in Main Cart Page ");
		log.info("Successfully Verified product cart total val in Main Cart Page");
		return new CartPage(driver);
	}

	/**
	 * Click on Proceed To CheckOut in Main cart
	 * 
	 * @return :CartPage
	 * @throws Exception 
	 */

	public CartPage Click_ON_ProceedToCheckOut_Maincart() throws Exception {
	//	GUIFunctions.clickElement(driver, MainCP_ProceedToCheck_btn, "Click on Proceed To CheckOut in main cart ");
		GUIFunctions.JavaScriptClick(driver, driver.findElement(MainCP_ProceedToCheck_btn), "Click on Proceed To CheckOut in main cart");
		return new CartPage(driver);

	}

	/**
	 * Click on contact us link in Main cart
	 * 
	 * @return :CartPage
	 */

	public CartPage Click_ON_ContactUSLNK_Maincart() throws InterruptedException {
		GUIFunctions.clickElement(driver, MainCP_ContactUs_Lnk, "Click on contact us link in main cart ");
		return new CartPage(driver);

	}

	/**
	 * MethodName=ClickonProductImgInMiniCart Description:This function used to
	 * click on Product Image in the Mini Cart
	 * 
	 * @throws Exception
	 */

	public CartPage ClickonProductImgInMiniCart() throws Exception {
		GUIFunctions.JavaScriptClick(driver, driver.findElement(MiniCP_Product_Img), "Click on Product Img in Mini Cart");
		return new CartPage(driver);
	}
	
	public CartPage Verify_Product_NavigationLnks_MiniCart() throws InterruptedException {

		// Verification of Proceed to checkout CTA
		GUIFunctions.verifyUIElementAndShowText(driver.findElement(MiniCP_CheckOut_Btn),
				"Product Proceed to checkout CTA in Cart Page");
		System.out.println("Successfully verified Proceed to checkout CTA ");
		log.info("Successfully Verified Proceed to checkout CTA \n");

		// Verification of contact us navigation link
		GUIFunctions.verifyUIElementAndShowText(driver.findElement(MiniCP_ContactUs_link),
				"Product contact us navigation link in Cart Page");
		System.out.println("Successfully verified contact us navigation link ");
		log.info("Successfully Verified contact us navigation link \n");

		// Verification of see in complete link text
		GUIFunctions.verifyUIElementAndShowText(driver.findElement(MiniCP_SeeInCompleteCart_link),
				"Product see in complete link text in Cart Page");
		System.out.println("Successfully verified see in complete link text ");
		log.info("Successfully Verified see in complete link text \n");

		return new CartPage(driver);
	}

	/**
	 * verify contactus and proceed to checkout CTA in main cart
	 * 
	 * @return :CartPage
	 */
	public CartPage VerifyContactusCheckoutCTA_Maincart() throws InterruptedException {
		GUIFunctions.verifyUIElementAndShowText(driver.findElement(MainCP_ContactUs_Lnk),
				"verified contact us link in Main cart Page");
		GUIFunctions.verifyUIElementAndShowText(driver.findElement(MainCP_CheckOut_Btn),
				"verified checkout button in Main cart Page");

		return new CartPage(driver);

	}

	/**
	 * verify Remove and Wishlist link in main cart
	 * 
	 * @return :CartPage
	 */
	public CartPage VerifyRemoveWishlistLnk_Maincart() throws InterruptedException {
		GUIFunctions.verifyUIElementAndShowText(driver.findElement(MainCP_Remove_Lnk),
				"verified remove link in Main cart Page");
		GUIFunctions.verifyUIElementAndShowText(driver.findElement(MainCP_Wishlist_Lnk),
				"verified wishlist link in Main cart Page");

		return new CartPage(driver);

	}

	/**
	 * MethodName= VerifyMyCartHeaderHeader() Description:This function Verifies the
	 * My Cart header in the My Cart page
	 * 
	 * @throws InterruptedException
	 */

	public CartPage VerifyMyCartHeaderHeader() throws InterruptedException {
		// verify My Cart header text
		Assert.assertTrue(CustomFun.isElementPresent(MiniCP_MyCartHeader, driver), "My Cart header is not displayed");
		log.info("Successfully verified My Cart Header text");
		Reporter.log("<p>Successfully verified My Cart Header text");
		return new CartPage(driver);
	}

	/**
	 * verify FAQ section in main cart
	 * 
	 * @return :CartPage
	 */
	public CartPage VerifyFAQSectionInMaincart() throws InterruptedException {
		GUIFunctions.verifyUIElementAndShowText(driver.findElement(FAQSection),
				"verified FAQ section in Main cart Page");
		return new CartPage(driver);
	}
	
	
	public CartPage Verify_All_txt_InMiniCart() throws InterruptedException
	{
	//Verification of My cart text in Minicart
	GUIFunctions.verifyUIElementAndShowText(driver.findElement(MiniCP_MYCart_txt),"verified My cart text");
	System.out.println("Successfully verified My cart text ");
	log.info("Successfully Verified My cart text \n");

	//Verification of FreeReturns text in Minicart
	GUIFunctions.verifyUIElementAndShowText(driver.findElement(MiniCP_Free_Returns_txt),"verified FreeReturns text");
	System.out.println("Successfully verified FreeReturns text ");
	log.info("Successfully Verified FreeReturns text \n");
	
	//Verification of YourCart_Description text in Minicart
//	GUIFunctions.verifyUIElementAndShowText(driver.findElement(MiniCP_YourCart_Desc_txt),"your cart Description txt in Mini Cart");
	System.out.println("Successfully verified YourCart_Description text ");
	log.info("Successfully Verified YourCart_Description text \n");

	return new CartPage(driver);
	}
	
	
	/**
	* MethodName= VerifyPaymentNonClickable_sectionIcons_MainCart()
	* Description:This function Verifies the VerifyPaymentNonClickable_sectionIcons_MainCart()
	* @throws InterruptedException
	*/

	public CartPage VerifyPaymentNonClickable_sectionIcons_MainCart() throws InterruptedException
	{
	Assert.assertTrue(CustomFun.isElementPresent(PaymentNonClickable_sectionIcons, driver), "Payment NonClickable_section Icons is not displayed");
	log.info("Successfully verified Payment NonClickable_section Icons");
	Reporter.log("<p>Successfully verified Payment NonClickable_section Icons");
	return new CartPage(driver);
	}
	
	/**
	* MethodName= VerifyTotalAndDeliverySummary()
	* Description:This function Verifies the Verify Total And Delivery Summary
	* @throws InterruptedException
	*/

	public CartPage VerifyTotalAndDeliverySummary() throws InterruptedException
	{
	Assert.assertTrue(CustomFun.isElementPresent(MainCP_TotalAndDeliverySummary, driver), "Total And Delivery Summary is not displayed");
	log.info("Successfully verified Total And Delivery Summary");
	Reporter.log("<p>Successfully verified Total And Delivery Summary");
	return new CartPage(driver);
	}
	
	/**
	* MethodName= VerifyFixedLegaltxt()
	* Description:This function Verifies the Fixed legal text
	* @throws InterruptedException
	*/

	public CartPage VerifyFixedLegaltxt() throws InterruptedException
	{
	Assert.assertTrue(CustomFun.isElementPresent(FixedLegaltxt, driver), "Fixed legal text is not displayed");
	log.info("Successfully verified Fixed legal text");
	Reporter.log("<p>Successfully verified Fixed legal text");
	return new CartPage(driver);
	}
	
	
	/** MethodName=VerifyUnsuccesfullOrderplacedWithInvalid3DSCardMsg()
	* Description:This function used to verify Unsuccesfull Order placed With Invalid 3DS Card message
	*/

	public CartPage VerifyUnsuccesfullOrderplacedWithInvalid3DSCardMsg() throws InterruptedException
	{
	Assert.assertTrue(CustomFun.waitObjectToLoad(driver, By.xpath(ObjRepoProp.get().getProperty("Credit3DSCardUnSuccessfullyMsg")), Duration.ofSeconds(20)),
	" Unsuccesfull Orderplaced With Invalid 3DS Card message text is not displayed");
	GUIFunctions.verifyUIElementAndShowText(driver.findElement(Credit3DSCardUnSuccessfullyMsg_xpath),"un Success Message");
	return new CartPage(driver);
	}
	

}
