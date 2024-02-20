package src.in.valtech.cl.front.pages;
import static src.in.valtech.util.PropertyFileReader.ObjRepoProp; 
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.Reporter;
import src.in.valtech.custom.CustomFun;
import src.in.valtech.uifunctions.GUIFunctions;

/**
 * @author Gopalaswamy M
 *
 */

public class MyAccountPage {
	public Logger log = Logger.getLogger(this.getClass().getName());

	public WebDriver driver;
	public static String PriceVal_OrderPage;
	public static String OrderDate_OrderPage;
	public static String RMAID_FromFO;
	public static String OrderStatus;
	public static String BillingAddress_ForProduct;
	public static String ShippingAddress_ForProduct;
	public static String OrderStatusFromFO;

	/**
	 * Verification of MyAccountPage Desc:Proper navigation to MyAccountPage
	 * MyAccountPage : Constructor
	 */
	public MyAccountPage(WebDriver driver) {
		this.driver = driver;
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	/**
	 * To fetch the Xpath's from Object Repository file - My Account Page
	 */

	By MyOrderslnk_xpath = By.xpath(ObjRepoProp.get().getProperty("MyOrderslnk_xpath"));
	By MyReturnslnk_xpath = By.xpath(ObjRepoProp.get().getProperty("MyReturnslnk_xpath"));
	By Wishlistlnk_xpath = By.xpath(ObjRepoProp.get().getProperty("Wishlistlnk_xpath"));
	By AddressBooklnk_xpath = By.xpath(ObjRepoProp.get().getProperty("AddressBooklnk_xpath"));
	By SignOutlnk_xpath = By.xpath(ObjRepoProp.get().getProperty("SignOutlnk_xpath"));

	By MiniCP_Product_Img = By.xpath(ObjRepoProp.get().getProperty("MiniCP_Product_img"));
	By MiniCP_Product_name = By.xpath(ObjRepoProp.get().getProperty("MiniCP_Product_Name"));
	By MiniCP_Product_desc = By.xpath(ObjRepoProp.get().getProperty("MiniCP_Product_Desc"));
	By MiniCP_Product_price = By.xpath(ObjRepoProp.get().getProperty("MiniCP_Product_Price"));
	By MiniCP_Product_color = By.xpath(ObjRepoProp.get().getProperty("MiniCP_Product_Color"));
	By MiniCP_Product_size = By.xpath(ObjRepoProp.get().getProperty("MiniCP_Product_Size"));
	By MiniCP_Quantity_val = By.xpath(ObjRepoProp.get().getProperty("MiniCP_Quantity"));
	By MiniCP_Remove_link = By.xpath(ObjRepoProp.get().getProperty("MiniCP_Remove_lnk"));
	By MiniCP_Wishlist_link = By.xpath(ObjRepoProp.get().getProperty("MiniCP_Wishlist_lnk"));
	By MiniCP_Quant_Incr_Icon = By.xpath(ObjRepoProp.get().getProperty("MiniCP_Quant_Incr"));
	By MiniCP_Quant_Decr_Icon = By.xpath(ObjRepoProp.get().getProperty("MiniCP_Quant_Decr"));
	By MiniCP_Cart_SubTotal = By.xpath(ObjRepoProp.get().getProperty("MiniCP_CartSubTotal"));
	By MiniCP_Cart_Total = By.xpath(ObjRepoProp.get().getProperty("MiniCP_CartTotal"));
	By Myorders_RMAProductReturnBtn_Xpath = By
			.xpath(ObjRepoProp.get().getProperty("Myorders_RMAProductReturnBtn_xpath"));
	By Myorders_RMAProductReturnChkbox_Xpath = By
			.xpath(ObjRepoProp.get().getProperty("Myorders_RMAProductReturnChkbox_xpath"));
	By Myorders_RMAProductReturnReasonDropdown_Xpath = By
			.xpath(ObjRepoProp.get().getProperty("Myorders_RMAProductReturnReasonDropdown_xpath"));
	By Myorders_RMAProductReturnReason_Xpath = By
			.xpath(ObjRepoProp.get().getProperty("Myorders_RMAProductReturnReason_xpath"));
	By Myorders_RMAProductReturnReason_SubmitBtn = By
			.xpath(ObjRepoProp.get().getProperty("Myorders_RMAProductReturnReason_submitBtn"));
	By Myorders_RMAProductReturnDate_Drpdown = By
			.xpath(ObjRepoProp.get().getProperty("Myorders_RMAProductReturnDate_Drpdown"));
	By Myorders_RMAProductReturnDate = By.xpath(ObjRepoProp.get().getProperty("Myorders_RMAProductReturnDate"));
	By Myorders_RMAProductReturnValidate_Btn = By
			.xpath(ObjRepoProp.get().getProperty("Myorders_RMAProductReturnValidate_Btn"));
	By Myorders_RMAProductReturnID = By.xpath(ObjRepoProp.get().getProperty("Myorders_RMAProductReturnID"));
	By MyFavoriteAddressHeader = By.xpath(ObjRepoProp.get().getProperty("MyFavoriteAddressHeader"));
	By Myorders_RMAProductReturnReason_SubmitBtn2 = By
			.xpath(ObjRepoProp.get().getProperty("Myorders_RMAProductReturnReason_submitBtn2"));
	By Address_book_xpath = By.xpath(ObjRepoProp.get().getProperty("Address_book"));
	By RegisterSuccessMsg_xpath = By.xpath(ObjRepoProp.get().getProperty("RegisterSuccessMsg_xpath"));
	By Myorders_RMAProductReturnResolutionDropdown_xpath = By.xpath(ObjRepoProp.get().getProperty("Myorders_RMAProductReturnResolutionDropdown_xpath"));
	By Myorders_RMAProductReturnReasonDropdown_xpath1 = By.xpath(ObjRepoProp.get().getProperty("Myorders_RMAProductReturnReasonDropdown_xpath1"));
	By Myorders_RMAProductReasonToReturn_xpath = By.xpath(ObjRepoProp.get().getProperty("Myorders_RMAProductReasonToReturn_xpath"));

	/**
	 * MethodName=VerifyMyAccountHeadertxt Description:This function Verifies the My
	 * Account Header text in My Account Page
	 */

	public MyAccountPage VerifyMyAccountHeadertxt() {
		// verify My Account Header text
		Assert.assertTrue(
				CustomFun.isElementPresent(By.xpath(ObjRepoProp.get().getProperty("MyAccounttxt_xpath")), driver),
				"My Account Header text is not displayed");
		log.info("Successfully verified My Account Header text in My Account Page");
		Reporter.log("<p>Successfully verified My Account Header text in My Account Page");
		return new MyAccountPage(driver);
	}

	/**
	 * MethodName=Verify_Usernametxt Description:This function Verifies the UserName
	 * text in the MyAccount Page
	 */

	public MyAccountPage Verify_Usernametxt() {
		// verify UserName text
		Assert.assertTrue(
				CustomFun.isElementPresent(By.xpath(ObjRepoProp.get().getProperty("Usernametxt_xpath")), driver),
				"Username text is not displayed");
		log.info("Successfully verified UserName text");
		Reporter.log("<p>Successfully verified UserName text");
		return new MyAccountPage(driver);
	}

	/**
	 * MethodName=Verify_ConsentCheckbox Description:This function Verifies the
	 * Consent Checkbox in the MyAccount Page
	 */

	public MyAccountPage Verify_ConsentCheckbox() {
		// verify Consent Checkbox text
		Assert.assertTrue(
				CustomFun.isElementPresent(By.xpath(ObjRepoProp.get().getProperty("ConsentChk_xpath")), driver),
				"Username text is not displayed");
		log.info("Successfully verified Consent Checkbox");
		Reporter.log("<p>Successfully verified Consent Checkbox");
		return new MyAccountPage(driver);
	}

	/**
	 * MethodName=MyOrders_LnkClick Description:This function click on My Orders
	 * link in the MyAccount Page
	 * @throws Exception 
	 */

	public MyAccountPage MyOrders_LnkClick() throws Exception {
		GUIFunctions.JavaScriptClick(driver, driver.findElement(MyOrderslnk_xpath), "Click on My Orders link");
		return new MyAccountPage(driver);
	}

	/**
	 * MethodName=VerifyMyOrdersLink Description:This function used to verify My
	 * Orders link in the MyAccount Page
	 */

	public MyAccountPage VerifyMyOrdersLink() {
		// verify My Orders link
		Assert.assertTrue(
				CustomFun.isElementPresent(By.xpath(ObjRepoProp.get().getProperty("MyOrderslnk_xpath")), driver),
				"Username text is not displayed");
		log.info("Successfully verified My Orders Link");
		Reporter.log("<p>Successfully verified My Orders Link");
		return new MyAccountPage(driver);
	}

	/**
	 * MethodName=MyReturns_LnkClick Description:This function click on My Returns
	 * link in the MyAccount Page
	 */

	public MyAccountPage MyReturns_LnkClick() throws InterruptedException {
		GUIFunctions.clickElement(driver, MyReturnslnk_xpath, "Click on My Returns link");
		return new MyAccountPage(driver);
	}

	/**
	 * MethodName=VerifyMyReturnsLink Description:This function used to verify My
	 * Returns link in the MyAccount Page
	 */
	public MyAccountPage VerifyMyReturnsLink() {
		// verify My Returns link
		Assert.assertTrue(
				CustomFun.isElementPresent(By.xpath(ObjRepoProp.get().getProperty("MyReturnslnk_xpath")), driver),
				"Username text is not displayed");
		log.info("Successfully verified My Returns Link");
		Reporter.log("<p>Successfully verified My Returns link");
		return new MyAccountPage(driver);
	}

	/**
	 * MethodName=Wishlist_LnkClick Description:This function click on Wishlist link
	 * in the MyAccount Page
	 * 
	 * @throws Exception
	 */

	public MyAccountPage Wishlist_LnkClick() throws Exception {
		GUIFunctions.JavaScriptClick(driver, driver.findElement(Wishlistlnk_xpath), "Click on Wishlist link");
		return new MyAccountPage(driver);
	}

	/**
	 * MethodName=VerifyWishlist() Description:This function use to verify Wishlist
	 * link in the MyAccount Page
	 * 
	 * @throws Exception
	 */

	public MyAccountPage VerifyWishlistLink() throws Exception {
		Assert.assertTrue(
				CustomFun.isElementPresent(By.xpath(ObjRepoProp.get().getProperty("Wishlistlnk_xpath")), driver),
				"Product image is not displaying in wishlist page");
		log.info("Successfully verified Wishlist Link in Wishlist page");
		Reporter.log("<p>Successfully verified Wishlist Link in Wishlist page ");
		return new MyAccountPage(driver);
	}

	/**
	 * MethodName=VerifyProductImgInWP Description:This function used to verify
	 * product image in Wishlist page
	 */

	public MyAccountPage VerifyProductImgInWP() throws InterruptedException {
		Assert.assertTrue(
				CustomFun.isElementPresent(By.xpath(ObjRepoProp.get().getProperty("ProductImgInWP_xpath")), driver),
				"Product image is not displaying in wishlist page");
		log.info("Successfully verified Product image in Wishlist page");
		Reporter.log("<p>Successfully verified Product image in Wishlist page ");
		return new MyAccountPage(driver);
	}

	/**
	 * MethodName=AddressBook_LnkClick Description:This function click on Address
	 * Book link in the MyAccount Page
	 * 
	 * @throws Exception
	 */

	public MyAccountPage AddressBook_LnkClick() throws Exception {
		GUIFunctions.JavaScriptClick(driver, driver.findElement(AddressBooklnk_xpath), "Click on Address Book link");
		return new MyAccountPage(driver);
	}

	/**
	 * MethodName=Signout_LnkClick Description:This function click on Sign Out link
	 * in the MyAccount Page
	 * 
	 * @throws Exception
	 */

	public MyAccountPage Signout_LnkClick() throws Exception {
		GUIFunctions.JavaScriptClick(driver, driver.findElement(SignOutlnk_xpath), "Click on Sign Out link");
		return new MyAccountPage(driver);
	}

	/**
	 * MethodName=VerifyOrderStatus Description:This function verifies the order
	 * status in my orders page
	 * 
	 * @throws Exception
	 */

	public MyAccountPage VerifyOrderStatus(String OrderIDtxt) throws Exception {
		By ele = By.xpath("//*[contains(text(),'" + OrderIDtxt + "')]/..//p[contains(@class, 'status')]");
		OrderStatusFromFO=driver.findElement(ele).getText();
		GUIFunctions.VerifyOrderStatusInFO(driver.findElement(ele).getText(), OrderIDtxt);
		return new MyAccountPage(driver);
	}

	/**
	 * Verification of product information
	 * 
	 * @return :CartPage
	 */

	// Verification of product details in mini cart
	public MyAccountPage Verify_Product_Details_IN_MiniCart() throws InterruptedException {
		// Verification of product image
		Assert.assertTrue(
				CustomFun.isElementPresent(By.xpath(ObjRepoProp.get().getProperty("MiniCP_Product_img")), driver),
				"Product image is not displayed");
		log.info("Successfully verified Product image in Mini Cart");
		Reporter.log("<p>Successfully verified Product image in Mini Cart");

		// Verification of product name
		GUIFunctions.verifyUIElementAndShowText(driver.findElement(MiniCP_Product_name), "Product Name in Mini Cart");

		// Verification of product description
		GUIFunctions.verifyUIElementAndShowText(driver.findElement(MiniCP_Product_desc),
				"Product Description in Mini Cart");

		// Verification of product price
		GUIFunctions.verifyUIElementAndShowText(driver.findElement(MiniCP_Product_price), "Product Price in Mini Cart");

		// Verification of product color
		GUIFunctions.verifyUIElementAndShowText(driver.findElement(MiniCP_Product_color), "Product Color in Mini Cart");

		// Verification of product size
		GUIFunctions.verifyUIElementAndShowText(driver.findElement(MiniCP_Product_size), "Product Size in Mini Cart");

		// Verification of Product quantity
		GUIFunctions.verifyUIElementAndShowText(driver.findElement(MiniCP_Quantity_val),
				"Product Quantity in Mini cart");

		// Verification of Remove link
		GUIFunctions.verifyUIElementAndShowText(driver.findElement(MiniCP_Remove_link), "Remove link in Mini cart");

		// Verification of Quantity Increment button
		GUIFunctions.verifyUIElementAndShowText(driver.findElement(MiniCP_Quant_Incr_Icon),
				"Quantity Incre button in Mini cart");

		// Verification of Quantity Decrement button
		GUIFunctions.verifyUIElementAndShowText(driver.findElement(MiniCP_Quant_Decr_Icon),
				"Quantity Decre button in Mini cart");

		// Verification of SubTotal text
		GUIFunctions.verifyUIElementAndShowText(driver.findElement(MiniCP_Cart_SubTotal), "SubTotal text in Mini cart");

		// Verification of Total text
		GUIFunctions.verifyUIElementAndShowText(driver.findElement(MiniCP_Cart_Total), "Total text in Mini cart");

		return new MyAccountPage(driver);

	}

	public MyAccountPage VerifyOrderPriceInOrderspage(String OrderIDtxt) throws Exception {
		By ele = By.xpath("//*[contains(text(),'" + OrderIDtxt + "')]/..//p[contains(@class, 'price')]");
		PriceVal_OrderPage = driver.findElement(ele).getText().replaceAll("[^0-9.]", "");
		log.info("Verified Order Price In Orders Page " + PriceVal_OrderPage);
		Reporter.log("<p>Verified Order Price In Orders Page " + PriceVal_OrderPage);
		return new MyAccountPage(driver);
	}

	public MyAccountPage VerifyOrderDateInOrderspage(String OrderIDtxt) throws Exception {
		By ele = By.xpath("//*[contains(text(),'" + OrderIDtxt + "')]/..//p[contains(@class, 'date')]");
		String OrderDate_OrderPage = driver.findElement(ele).getText();
		log.info("Verified Order Date In Orders Page " + OrderDate_OrderPage);
		Reporter.log("<p>Verified Order Date In Orders Page " + OrderDate_OrderPage);
		return new MyAccountPage(driver);
	}

	/**
	 * click on Myorders RMA Product Return Btn
	 * 
	 * @return :MyAccountPage
	 */
	public MyAccountPage ClickOnMyorders_RMAProductReturnBtn(String OrderIDtxt) throws Exception {
		By ele = By.xpath("//*[contains(text(),'" + OrderIDtxt + "')]/../a//span");
		GUIFunctions.scrollByJavaScriptExecutor(driver.findElement(ele), driver, "RMAProductReturnBtn from FO");
		Thread.sleep(2000);
		GUIFunctions.JavaScriptClick(driver, driver.findElement(ele), "Click on Myorders_RMAProductReturnBtn ");
		Thread.sleep(2000);
		return new MyAccountPage(driver);
	}

	/**
	 * click on Myorders RMA Product Return checkbox
	 * 
	 * @return :MyAccountPage
	 */
	public MyAccountPage ClickOnMyorders_RMAProductReturnChkbox() throws Exception {
		GUIFunctions.scrollByJavaScriptExecutor(driver.findElement(By.xpath("//h2")), driver,
				"RMAProductReturn chkbox");
		Thread.sleep(2000);
		//int ChkboxCount = driver.findElements(Myorders_RMAProductReturnChkbox_Xpath).size();
		for (int i = 0; i < 1; i++) {
			GUIFunctions.JavaScriptClick(driver, driver.findElement(Myorders_RMAProductReturnChkbox_Xpath),
					"Click on Myorders_RMAProductReturn chkbox ");
			Thread.sleep(2000);
		}
		return new MyAccountPage(driver);
	}

	/**
	 * click on Myorders RMA Product Return reason dropdown
	 * 
	 * @return :MyAccountPage
	 */
	public MyAccountPage ClickOnMyorders_RMAProductReturnReasonDrpdown() throws Exception {
		Actions action = new Actions(driver);
		WebElement Cardnumber = driver.findElement(Myorders_RMAProductReturnReasonDropdown_Xpath);
		action.moveToElement(Cardnumber).build().perform();
		Thread.sleep(2000);
		//int DrpCount = driver.findElements(Myorders_RMAProductReturnReasonDropdown_Xpath).size();
		for (int i = 0; i < 1; i++) {
			action.moveToElement(driver.findElements(Myorders_RMAProductReturnReasonDropdown_Xpath).get(i)).click()
					.perform();
			Thread.sleep(2000);
			action.moveToElement(driver.findElement(Myorders_RMAProductReturnReason_Xpath)).click().perform();
			Thread.sleep(2000);
		}
		return new MyAccountPage(driver);
	}
	
	/**
	 * click on Myorders RMA Product Return reason dropdown
	 * 
	 * @return :MyAccountPage
	 */
	
	public MyAccountPage CreateRMAReturnsinFOForStagingEU1() throws Exception {
		ClickOnMyorders_RMAProductReturnChkbox();
		Actions action = new Actions(driver);
		WebElement Cardnumber = driver.findElement(Myorders_RMAProductReturnReasonDropdown_Xpath);
		action.moveToElement(Cardnumber).build().perform();
		Thread.sleep(2000);
		driver.findElement(Myorders_RMAProductReturnReasonDropdown_Xpath).click();
	    Thread.sleep(2000);
	    driver.findElement(Myorders_RMAProductReturnReason_Xpath).click();
		Thread.sleep(2000);
		driver.findElement(Myorders_RMAProductReturnReasonDropdown_xpath1).click();
	    Thread.sleep(2000);
		driver.findElement(Myorders_RMAProductReasonToReturn_xpath).click();
		Thread.sleep(2000);
		ClickMyorders_RMAProductReturnReasonSubmit_Btn();
		Thread.sleep(2000);
		WebElement ContactAddressField=driver.findElement(By.xpath(ObjRepoProp.get().getProperty("MyOrders_RMAContactEmailAddressField_xpath")));
        ContactAddressField.sendKeys(CustomFun.getUserInfoDSDetails().get().getEmailDomain());
        Thread.sleep(2000);
        GUIFunctions.JavaScriptClick(driver,  driver.findElement(By.xpath(ObjRepoProp.get().getProperty("Myorders_RMAProductReturnReason_submitBtn2"))),
				"click on Myorders RMA Product Return reason submit Btn");
        Thread.sleep(2000);
        ClickMyorders_RMAProductReturnReasonDateDrpdown();
        Thread.sleep(2000);
        ClickMyorders_RMAProductReturnValidateBtn(); 
        Thread.sleep(2000);
		return new MyAccountPage(driver);
	}

	/**
	 * select on Myorders RMA Product Return reason
	 * 
	 * @return :MyAccountPage
	 */
	public MyAccountPage SelectMyorders_RMAProductReturnReason() throws Exception {
		GUIFunctions.clickElement(driver, Myorders_RMAProductReturnReason_Xpath,
				"select on Myorders RMA Product Return reason ");
		return new MyAccountPage(driver);
	}

	/**
	 * click on Myorders RMA Product Return reason submit Btn
	 * 
	 * @return :MyAccountPage
	 */
	public MyAccountPage ClickMyorders_RMAProductReturnReasonSubmit_Btn() throws Exception {
		GUIFunctions.JavaScriptClick(driver, driver.findElement(Myorders_RMAProductReturnReason_SubmitBtn),
				"click on Myorders RMA Product Return reason submit Btn");
		Thread.sleep(2000);
		return new MyAccountPage(driver);
	}

	/**
	 * click on Myorders RMA Product Return reason date dropdown
	 * 
	 * @return
	 */
	public MyAccountPage ClickMyorders_RMAProductReturnReasonDateDrpdown() throws Exception {
		int DrpCount = driver.findElements(Myorders_RMAProductReturnDate_Drpdown).size();
		for (int i = 0; i < DrpCount; i++) {
			GUIFunctions.clickElement(driver, Myorders_RMAProductReturnDate_Drpdown,
					"click on Myorders RMA Product Return reason date dropdown ");
			Thread.sleep(2000);
			GUIFunctions.clickElement(driver, Myorders_RMAProductReturnDate,
					"click on Myorders RMA Product Return reason date");
			Thread.sleep(2000);
		}
		return new MyAccountPage(driver);
	}

	/**
	 * click on Myorders RMA Product Return reason date
	 * 
	 * @return :MyAccountPage
	 */
	public MyAccountPage ClickMyorders_RMAProductReturnReasonDate() throws Exception {
		GUIFunctions.clickElement(driver, Myorders_RMAProductReturnDate,
				"click on Myorders RMA Product Return reason date");
		return new MyAccountPage(driver);
	}

	/**
	 * click on Myorders RMA Product Return validate btn
	 * 
	 * @return :MyAccountPage
	 */
	public MyAccountPage ClickMyorders_RMAProductReturnValidateBtn() throws Exception {
		GUIFunctions.clickElement(driver, Myorders_RMAProductReturnValidate_Btn,
				"click on Myorders RMA Product Return validate btn");
		return new MyAccountPage(driver);
	}

	public MyAccountPage VerifyOrderItemInOrderspage(String OrderIDtxt) throws Exception {
		By ele = By.xpath("//*[contains(text(),'" + OrderIDtxt + "')]/..//p[contains(@class, 'item')]");
		String ItemVal_OrderPage = driver.findElement(ele).getText();
		log.info("Verified Order Item In Orders Page " + ItemVal_OrderPage);
		Reporter.log("<p>Verified Order Item In Orders Page " + ItemVal_OrderPage);
		return new MyAccountPage(driver);
	}

	/**
	 * save Myorders RMA Product Return id and store in variable
	 * 
	 * @return :MyAccountPage
	 */
	public MyAccountPage SaveANdStore_RMAProductReturnID_FO() throws Exception {
		GUIFunctions.verifyUIElementAndShowText(driver.findElement(Myorders_RMAProductReturnID), "RMA id from FO ");
		By ele = By.xpath(ObjRepoProp.get().getProperty("Myorders_RMAProductReturnID"));
		RMAID_FromFO = driver.findElement(ele).getText().replaceAll("[^0-9.]", "");
		return new MyAccountPage(driver);
	}

	/**
	 * Verification of MyFavoriteAddressHeader
	 * 
	 * @return :HomePage
	 */

	public MyAccountPage Verify_MyFavoriteAddressHeaderInMAP() throws InterruptedException {
		Assert.assertTrue(CustomFun.waitObjectToLoad(driver,
				By.xpath(ObjRepoProp.get().getProperty("MyFavoriteAddressHeader")), Duration.ofSeconds(10)),
				"My Favorite Address Header is not displayed");
		log.info("Successfully My Favorite Address Header is verified in My Account Page");
		Reporter.log("<p>Successfully My Favorite Address Header is verified in My Account Page");
		return new MyAccountPage(driver);
	}

	/**
	 * Verification of NewsLetterHeader
	 * 
	 * @return :HomePage
	 */

	public MyAccountPage Verify_NewsLetterHeaderInMAP() throws InterruptedException {
		Thread.sleep(2000);
		Assert.assertTrue(
				CustomFun.waitObjectToLoad(driver, By.xpath(ObjRepoProp.get().getProperty("NewsLetterHeader")), Duration.ofSeconds(10)),
				"NewsLetter Header is not displayed");
		log.info("Successfully NewsLetter Header is verified in My Account Page");
		Reporter.log("<p>Successfully NewsLetter Header is verified in My Account Page");
		return new MyAccountPage(driver);
	}

	/**
	 * click on My address book link
	 * 
	 * @return :MyAccountPage
	 */
	public MyAccountPage ClickAddressBook_Lnk() throws Exception {
		GUIFunctions.clickElement(driver, Address_book_xpath, "click on Address book link");
		return new MyAccountPage(driver);
	}

	/**
	 * MethodName=VerifySuccessMsgForRegister() Description:This function used to
	 * verify success message for register
	 */

	public MyAccountPage VerifySuccessMsgForRegister() throws InterruptedException {
		Assert.assertTrue(CustomFun.waitObjectToLoad(driver,
				By.xpath(ObjRepoProp.get().getProperty("RegisterSuccessMsg_xpath")), Duration.ofSeconds(20)),
				"Success Message text is not displayed");
		GUIFunctions.verifyUIElementAndShowText(driver.findElement(RegisterSuccessMsg_xpath),
				"Register Success Message");
		return new MyAccountPage(driver);
	}

	/**
	 * Verify all right side sections in My account page
	 * 
	 * @return :MyAccountPage
	 */

	public MyAccountPage VerifyAllRightSideProductSectionsDetailsINMAP() throws InterruptedException {
		Assert.assertTrue(
				CustomFun.isElementPresent(By.xpath(ObjRepoProp.get().getProperty("MyReturnsSection")), driver),
				"My Returns Section are not displayed");
		Assert.assertTrue(
				CustomFun.isElementPresent(By.xpath(ObjRepoProp.get().getProperty("MyOrdersSection")), driver),
				"My Orders Section are not displayed");
		Assert.assertTrue(
				CustomFun.isElementPresent(By.xpath(ObjRepoProp.get().getProperty("MyWishlistSection")), driver),
				"My Wishlist Section are not displayed");
		Assert.assertTrue(
				CustomFun.isElementPresent(By.xpath(ObjRepoProp.get().getProperty("MyAddressSection")), driver),
				"My Address Section are not displayed");
		Assert.assertTrue(
				CustomFun.isElementPresent(By.xpath(ObjRepoProp.get().getProperty("MyNewsletterSection")), driver),
				"My Newsletter Section are not displayed");

		log.info("Successfully verified all Right Side Product Sections Details in My account page");
		Reporter.log("<p>Successfully verified all Right Side Product Sections Details in My account page");
		return new MyAccountPage(driver);
	}

	/**
	 * Verify all left side sections in My account page
	 * 
	 * @return :MyAccountPage
	 */

	public MyAccountPage VerifyAllLeftSideProductSectionsDetailsINMAP() throws InterruptedException {
		Assert.assertTrue(CustomFun.isElementPresent(By.xpath(ObjRepoProp.get().getProperty("MAP_HomeLnk")), driver),
				"Home Lnk Section are not displayed");
		Assert.assertTrue(
				CustomFun.isElementPresent(By.xpath(ObjRepoProp.get().getProperty("MAP_MyInformationLnk")), driver),
				"My Information Lnk Section are not displayed");
		Assert.assertTrue(
				CustomFun.isElementPresent(By.xpath(ObjRepoProp.get().getProperty("MyOrderslnk_xpath")), driver),
				"My orders lnk Section are not displayed");
		Assert.assertTrue(
				CustomFun.isElementPresent(By.xpath(ObjRepoProp.get().getProperty("MyReturnslnk_xpath")), driver),
				"My Returns lnk Section are not displayed");
		Assert.assertTrue(
				CustomFun.isElementPresent(By.xpath(ObjRepoProp.get().getProperty("Wishlistlnk_xpath")), driver),
				"wishlists lnk Section are not displayed");
		Assert.assertTrue(
				CustomFun.isElementPresent(By.xpath(ObjRepoProp.get().getProperty("MAP_MyProductAlertsLnk")), driver),
				"My product alert link Section are not displayed");
	    Assert.assertTrue(CustomFun.isElementPresent(By.xpath(ObjRepoProp.get().getProperty("MAP_MyAddressBookLnk")), driver),"address book link Section are not displayed");
		Assert.assertTrue(CustomFun.isElementPresent(By.xpath(ObjRepoProp.get().getProperty("MAP_MyPreferencesLnk")), driver),"Newsletter lnk Section are not displayed");
		Assert.assertTrue(
				CustomFun.isElementPresent(By.xpath(ObjRepoProp.get().getProperty("SignOutlnk_xpath")), driver),
				"Sign out lnk Section are not displayed");

		log.info("Successfully verified all Left Side Product Sections Details in My account page");
		Reporter.log("<p>Successfully verified all Left Side Product Sections Details in My account page");
		return new MyAccountPage(driver);
	}
	
	/**
	*Verify user is in MyAccountpage
	* @return :MyAccountpage
	*/

	public MyAccountPage VerifyUserIsInMyAccountpage() throws InterruptedException
	{
	if(!(CustomFun.isElementPresent(By.xpath(ObjRepoProp.get().getProperty("MyAccountpageType_xpath")),
	driver))) 
	{
	log.info("Successfully verified user is in MyAccountpage ");
	Reporter.log("<p>Successfully verified user is in MyAccountpage ");
	// If not throw IllegalStateException
	throw new IllegalStateException("User is not in MyAccountpage ");
	}
	return new MyAccountPage(driver);

	}

}
