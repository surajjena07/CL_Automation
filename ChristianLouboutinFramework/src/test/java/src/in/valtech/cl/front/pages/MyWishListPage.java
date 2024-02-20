package src.in.valtech.cl.front.pages; 
import static src.in.valtech.util.PropertyFileReader.ObjRepoProp;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;
import src.in.valtech.custom.CustomFun;
import src.in.valtech.uifunctions.GUIFunctions;

public class MyWishListPage {
	public Logger log = Logger.getLogger(this.getClass().getName());

	public WebDriver driver;

	/**
	 * Verification of MyWishListPage Desc:Proper navigation to MyWishListPage
	 * MyWishListPage : Constructor
	 */
	public MyWishListPage(WebDriver driver) {
		this.driver = driver;
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	/**
	 * To fetch the Xpath's from Object Repository file - My Wish list Page
	 */

	By Wishlistlnk_xpath = By.xpath(ObjRepoProp.get().getProperty("Wishlistlnk_xpath"));
	By ProductNametxt_xpath = By.xpath(ObjRepoProp.get().getProperty("ProductNametxt_xpath"));
	By ProductPricetxt_xpath = By.xpath(ObjRepoProp.get().getProperty("ProductPricetxt_xpath"));
	By RemoveItemtxt_xpath = By.xpath(ObjRepoProp.get().getProperty("RemoveItemtxt_xpath"));
	By AddToCarttxtInWP_xpath = By.xpath(ObjRepoProp.get().getProperty("AddToCarttxtInWP_xpath"));

	/**
	 * MethodName=VerifyMyWishListHeadertxt Description:This function Verifies the
	 * My WishList text in My WishList Page
	 */

	public MyWishListPage VerifyMyWishListHeadertxt() {
		// verify My Wish List Header text
		Assert.assertTrue(
				CustomFun.isElementPresent(By.xpath(ObjRepoProp.get().getProperty("MyWishListtxt_xpath")), driver),
				"My Wish List text is not displayed");
		log.info("Successfully verified My Wish List Header text in My Wish List Page");
		Reporter.log("<p>Successfully verified My Wish List Header text in My Wish List Page");
		return new MyWishListPage(driver);
	}

	/**
	 * MethodName=VerifyProductImgInCP Description:This function used to verify
	 * product image in My Wish List Page
	 */

	public MyWishListPage VerifyProductImgInMWLP() throws InterruptedException {
		Assert.assertTrue(
				CustomFun.isElementPresent(By.xpath(ObjRepoProp.get().getProperty("ProductImgInWP_xpath")), driver),
				"Product image is not displaying in My Wish List Page");
		log.info("Successfully verified Product image in My Wish List Page");
		Reporter.log("<p>Successfully verified Product image in My Wish List Page");
		return new MyWishListPage(driver);
	}

	/**
	 * MethodName=VerifyProductNametxt Description:This function used to verify
	 * product name in My Wish list page and show product name in reports
	 */

	public MyWishListPage VerifyProductNametxtInMWLP() throws InterruptedException {
		GUIFunctions.verifyUIElementAndShowText(driver.findElement(ProductNametxt_xpath),
				"Product Name in My Wish List Page");
		return new MyWishListPage(driver);
	}

	/**
	 * MethodName=VerifyProductPricetxt Description:This function used to verify
	 * product price in My Wish list page and show product price in reports
	 */

	public MyWishListPage VerifyProductPricetxtInMWLP() throws InterruptedException {
		GUIFunctions.verifyUIElementAndShowText(driver.findElement(ProductPricetxt_xpath),
				"Product Price in My Wish List Page");
		return new MyWishListPage(driver);
	}

	/**
	 * MethodName=RemoveItemtxtClick() Description:This function click on Remove
	 * Item option in My Wish list page
	 * 
	 * @throws Exception
	 */

	public MyWishListPage RemoveItemIconClickInMWLP() throws Exception {
		GUIFunctions.JavaScriptClick(driver, driver.findElement(RemoveItemtxt_xpath), "Click on Remove Item option");
		return new MyWishListPage(driver);
	}

	/**
	 * MethodName=AddToCarttxtInWPClick() Description:This function click on Add to
	 * cart option in My Wish list page
	 * 
	 * @throws Exception
	 */

	public MyWishListPage AddToCartIconClickInMWLP() throws Exception {
		GUIFunctions.JavaScriptClick(driver, driver.findElement(AddToCarttxtInWP_xpath), "Click on Add to cart option");
		return new MyWishListPage(driver);
	}
}
