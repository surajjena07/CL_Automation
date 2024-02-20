package src.in.valtech.cl.front.pages;
import static src.in.valtech.util.PropertyFileReader.ObjRepoProp;
import static src.in.valtech.util.PropertyFileReader.TextProp;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import src.in.valtech.config.BaseTest;
import src.in.valtech.custom.CustomFun;
import src.in.valtech.uifunctions.GUIFunctions;

/**
 * @author Veenashree.CM
 *
 */
public class ProductListingPage {

	public Logger log = Logger.getLogger(this.getClass().getName());

	public WebDriver driver;

	/**
	 * Verification of ProductListingPage Desc:Proper navigation to
	 * ProductListingPage ProductListingPage: Constructor
	 */
	public ProductListingPage(WebDriver driver) {
		this.driver = driver;
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

// To fetch the Xpaths from Object Repository file

	By PLP_Product_Header_txt = By.xpath(ObjRepoProp.get().getProperty("PLP_Product_Header"));
	By PLP_Product_image = By.xpath(ObjRepoProp.get().getProperty("PLP_Product_image"));
	By PLP_Filter_Btn = By.xpath(ObjRepoProp.get().getProperty("PLP_Filter_Btn"));
	By PLP_ShopBy_txt = By.xpath(ObjRepoProp.get().getProperty("PLP_ShopBy_txt"));
	By PLP_RadioBtn_black = By.xpath(ObjRepoProp.get().getProperty("PLP_RadioBtn_black"));
	By PLP_Checkbox_leather_Material = By.xpath(ObjRepoProp.get().getProperty("PLP_Checkbox_Material_leather"));
	By PLP_Checkbox_40_Size = By.xpath(ObjRepoProp.get().getProperty("PLP_Checkbox_Size_40"));
	By PLP_ApplyBtn = By.xpath(ObjRepoProp.get().getProperty("PLP_ApplyBtn"));
	By PLP_CloseIcon = By.xpath(ObjRepoProp.get().getProperty("PLP_CloseIcon"));
	By PLP_TopSellers_tab = By.xpath(ObjRepoProp.get().getProperty("PLP_TopSellers_tab"));
	By PLP_ClearAll_Btn = By.xpath(ObjRepoProp.get().getProperty("PLP_ClearAll_Btn"));
	By PLP_ListView = By.xpath(ObjRepoProp.get().getProperty("PLP_ListView"));
	By PLP_GridView = By.xpath(ObjRepoProp.get().getProperty("PLP_GridView"));
	By PLP_ProductName = By.xpath(ObjRepoProp.get().getProperty("PLP_ProductName"));
	By PLP_ProductPrice = By.xpath(ObjRepoProp.get().getProperty("PLP_ProductPrice"));
	By PLP_Product_AddtoWhislist = By.xpath(ObjRepoProp.get().getProperty("PLP_Product_AddtoWhislist"));
	By PLP_PageNext_Arrow = By.xpath(ObjRepoProp.get().getProperty("PLP_pageNext_Arrow"));
	By PLP_PagePrevious_Arrow = By.xpath(ObjRepoProp.get().getProperty("PLP_pagePrevious_Arrow"));
	By PLP_pagination2_Btn = By.xpath(ObjRepoProp.get().getProperty("PLP_pagination2_btn"));
	By PLP_FirstColorSwatch_RadioBtn = By.xpath(ObjRepoProp.get().getProperty("PLP_FirstColorSwatch"));
	By PLP_FirstColorSwatch_extra_option = By.xpath(ObjRepoProp.get().getProperty("PLP_FirstColorSwatch_extra-option"));
	By PLP_Product_img2 = By.xpath(ObjRepoProp.get().getProperty("PLP_Product_image2"));
	By PLP_Product_img3 = By.xpath(ObjRepoProp.get().getProperty("PLP_Product_image3"));
	By PLP_LastProduct_img = By.xpath(ObjRepoProp.get().getProperty("PLP_LastProduct_image"));
	By PLP_SoldOutProdImg = By.xpath(ObjRepoProp.get().getProperty("PLP_SoldOutProdImg"));

	/**
	 * Verification of Product header text
	 * 
	 * @return :ProductListingPage
	 */

	// Verification of Product header text
	public ProductListingPage Verify_ProductHeader_txt() throws InterruptedException {
		BaseTest.expected = driver.findElement(PLP_Product_Header_txt).getText();
		Assert.assertEquals(TextProp.get().getProperty("PLP_ProductHeader_text"), BaseTest.expected);
		System.out.println("Successfully verified   product header text ");
		log.info("Successfully  Verified HeaderNavigation_LatestCollection text  \n");
		return new ProductListingPage(driver);

	}

	/**
	 * Click on List View
	 * 
	 * @return :ProductListingPage
	 */

	public ProductListingPage Click_ON_ListView() throws InterruptedException {
		GUIFunctions.clickElement(driver, PLP_ListView, "Click on ListView button  ");
		return new ProductListingPage(driver);

	}

	/**
	 * Click on Grid View
	 * 
	 * @return :ProductListingPage
	 */

	public ProductListingPage Click_ON_GridView() throws InterruptedException {
		GUIFunctions.clickElement(driver, PLP_GridView, "Click on GridView button  ");
		return new ProductListingPage(driver);
	}

	/**
	 * Click on Filter btn
	 * 
	 * @return :ProductListingPage
	 * @throws Exception
	 */

	public ProductListingPage Click_Filter_btn() throws Exception {
		GUIFunctions.JavaScriptClick(driver, driver.findElement(PLP_Filter_Btn), "Click on Refine Filter button");
		return new ProductListingPage(driver);
	}
	
	/**
	 * Verify VerifyDeleteAllActiveFilterButton
	 * 
	 * @return :ProductListingPage
	 */

	public ProductListingPage VerifyDeleteAllActiveFilterButton() throws InterruptedException {

		Assert.assertTrue(
				CustomFun.isElementPresent(By.xpath(ObjRepoProp.get().getProperty("PLP_DeleteAllBtn")), driver),
				"Delete All Active Filter Button is not displayed");
		Thread.sleep(1000);
		log.info("Successfully verified Delete All Active Filter Button");
		Reporter.log("<p>Successfully verified Delete All Active Filter Button");
		return new ProductListingPage(driver);
	}

	/**
	 * Verification of ShopBY text
	 * 
	 * @return :ProductListingPage
	 */

	// Verification of ShopBY text
	public ProductListingPage Verify_ShopBy_txt() throws InterruptedException {
		Assert.assertTrue(CustomFun.isElementPresent(By.xpath(ObjRepoProp.get().getProperty("PLP_ShopBy_txt")), driver),
				"Shop By is not displayed");
		System.out.println("Successfully verified  Shop by text ");
		log.info("Successfully  Verified Shop by text  \n");
		return new ProductListingPage(driver);
	}

	/**
	 * Selecting radio button for color
	 * 
	 * @return :ProductListingPage
	 */

	public ProductListingPage Select_RadioBtn_ForColor() throws InterruptedException {
		GUIFunctions.selectRadioButton(driver, PLP_RadioBtn_black, "selecting product color from filter");
		return new ProductListingPage(driver);
	}

	/**
	 * Click on Black Color filter
	 * 
	 * @return :ProductListingPage
	 * @throws Exception
	 */

	public ProductListingPage ClickonRadioBtn_ForBlackColor() throws Exception {
		GUIFunctions.JavaScriptClick(driver, driver.findElement(PLP_RadioBtn_black), "Click on BLACK Radio Button");
		Thread.sleep(2000);
		return new ProductListingPage(driver);
	}

	/**
	 * Selecting checkbox for Material
	 * 
	 * @return :ProductListingPage
	 */

	public ProductListingPage Select_Checkbox_ForMaterial() throws InterruptedException {
		GUIFunctions.clickElement(driver, PLP_Checkbox_leather_Material, "selecting product material from checkbox");
		return new ProductListingPage(driver);
	}

	/**
	 * Selecting checkbox for size 40
	 * 
	 * @return :ProductListingPage
	 */

	public ProductListingPage Select_Checkbox_ForSize() throws InterruptedException {
		GUIFunctions.clickElement(driver, PLP_Checkbox_40_Size, "selecting product size from checkbox");
		return new ProductListingPage(driver);
	}

	/**
	 * Click on Clear All link
	 * 
	 * @return :ProductListingPage
	 */

	public ProductListingPage Click_ClearAll_Link() throws InterruptedException {
		GUIFunctions.clickElement(driver, PLP_ClearAll_Btn, "Click on Clear All link");
		return new ProductListingPage(driver);
	}

	/**
	 * Click on Apply button
	 * 
	 * @return :ProductListingPage
	 */

	public ProductListingPage Click_Apply_Btn() throws InterruptedException {
		GUIFunctions.clickElement(driver, PLP_ApplyBtn, "Click on Apply button");
		return new ProductListingPage(driver);
	}

	/**
	 * Click on Top Sellers button
	 * 
	 * @return :ProductListingPage
	 */

	public ProductListingPage Click_TopSellers_Btn() throws InterruptedException {
		GUIFunctions.clickElement(driver, PLP_TopSellers_tab, " Top Sellers button");
		return new ProductListingPage(driver);
	}

	/**
	 * Click on Close icon
	 * 
	 * @return :ProductListingPage
	 */

	public ProductListingPage Click_Close_Icon() throws InterruptedException {
		GUIFunctions.clickElement(driver, PLP_CloseIcon, "Click on Close icon");
		return new ProductListingPage(driver);
	}

	/**
	 * Verify Product image
	 * 
	 * @return :ProductListingPage
	 */

	public ProductListingPage Verify_ProductImg() throws InterruptedException {

		Assert.assertTrue(
				CustomFun.isElementPresent(By.xpath(ObjRepoProp.get().getProperty("PLP_Product_image")), driver),
				"Product image is not displayed");
		Thread.sleep(1000);
		log.info("Successfully verified  Product image");
		Reporter.log("<p>Successfully verified Product image");
		return new ProductListingPage(driver);
	}

	/**
	 * Verification of Product name
	 * 
	 * @return :ProductListingPage
	 */

	// Verification of Product name
	public ProductListingPage Verify_ProductName() throws InterruptedException {
		BaseTest.expected = driver.findElement(PLP_ProductName).getText();
		Assert.assertEquals(TextProp.get().getProperty("PLP_ProductName_txt"), BaseTest.expected);
		System.out.println("Successfully verified  Product name  ");
		log.info("Successfully  Verified Product name  \n");
		return new ProductListingPage(driver);

	}

	/**
	 * Verification of Product price
	 * 
	 * @return :ProductListingPage
	 */

	// Verification of Product price
	public ProductListingPage Verify_ProductPrice() throws InterruptedException {
		BaseTest.expected = driver.findElement(PLP_ProductPrice).getText();
		Assert.assertEquals(TextProp.get().getProperty("PLP_Product_Price"), BaseTest.expected);
		System.out.println("Successfully verified  Product price  ");
		log.info("Successfully  Verified Product price  \n");
		return new ProductListingPage(driver);

	}

	/**
	 * Click on wishlist icon
	 * 
	 * @return :ProductListingPage
	 */

	public ProductListingPage Click_Wishlist_Icon() throws InterruptedException {
		GUIFunctions.clickElement(driver, PLP_Product_AddtoWhislist, "Click on Wishlist icon");
		return new ProductListingPage(driver);
	}

	/**
	 * Click on First ColorSwatch Radio Button
	 * 
	 * @return :ProductListingPage
	 */

	public ProductListingPage Click_FirstColorSwatch_RadioBtn() throws InterruptedException {
		GUIFunctions.clickElement(driver, PLP_FirstColorSwatch_RadioBtn, "First ColorSwatch Radio Button");
		return new ProductListingPage(driver);
	}

	/**
	 * Click on First ColorSwatch extra option Button
	 * 
	 * @return :ProductListingPage
	 */

	public ProductListingPage Click_FirstColorSwatch_extra_option() throws InterruptedException {
		GUIFunctions.clickElement(driver, PLP_FirstColorSwatch_extra_option, "First ColorSwatch extra option  Button");
		return new ProductListingPage(driver);
	}

	/**
	 * Click on Page Next Arrow
	 * 
	 * @return :ProductListingPage
	 */

	public ProductListingPage Click_PageNext_Arrow() throws InterruptedException {
		GUIFunctions.scrollByJavaScriptExecutor(driver.findElement(PLP_PageNext_Arrow), driver,
				"scroll till pagination section");
		Thread.sleep(2000);
		GUIFunctions.clickElement(driver, PLP_PageNext_Arrow, "Click on Page Next Arrow");
		return new ProductListingPage(driver);
	}

	/**
	 * Click on Page Previous Arrow
	 * 
	 * @return :ProductListingPage
	 */

	public ProductListingPage Click_PagePrevious_Arrow() throws InterruptedException {
		GUIFunctions.scrollByJavaScriptExecutor(driver.findElement(PLP_PagePrevious_Arrow), driver,
				"scroll till pagination section");
		Thread.sleep(2000);
		GUIFunctions.clickElement(driver, PLP_PagePrevious_Arrow, "Click on Page Previous Arrow");
		return new ProductListingPage(driver);
	}

	/**
	 * Click on Pagination 2
	 * 
	 * @return :ProductListingPage
	 */

	public ProductListingPage Click_Pagination2_Btn() throws InterruptedException {
		GUIFunctions.scrollByJavaScriptExecutor(driver.findElement(PLP_pagination2_Btn), driver,
				"scroll till pagination section");
		Thread.sleep(2000);
		GUIFunctions.clickElement(driver, PLP_pagination2_Btn, "Click on Pagination 2");
		return new ProductListingPage(driver);
	}

	/**
	 * Click on Product image
	 * 
	 * @return :ProductListingPage
	 * @throws Exception
	 */

	public ProductListingPage Click_ProductImg() throws Exception {
		GUIFunctions.JavaScriptClick(driver, driver.findElement(PLP_Product_image),
				"Click on Product Image and Navigated to Product Details Page");
		Thread.sleep(2000);
		return new ProductListingPage(driver);
	}

	/**
	 * Click on Product image for Simple Product Under Ladies Category
	 * 
	 * @return :ProductListingPage
	 * @throws Exception
	 */

	public ProductListingPage ClickOnSimpleProductImgFromCategory() throws Exception {
		GUIFunctions.JavaScriptClick(driver,
				driver.findElement(By.xpath("(//img[@class='photo image product-image-photo'])[1]")),
				"Click on Product Image and Navigated to Product Details Page");
		Thread.sleep(2000);
		return new ProductListingPage(driver);
	}

	/**
	 * Click on See All link
	 * 
	 * @return :ProductListingPage
	 * @throws Exception
	 */

	public ProductListingPage ClickOnSeeAlllink() throws Exception
	{
		By SeeAllLink=By.xpath("//h2[contains(text(),'sac') or contains(text(),'Keychains')]/../following-sibling::div//div[@class='see-all-link']");
		GUIFunctions.scrollByJavaScriptExecutor(driver.findElement(SeeAllLink), driver, "See All Link");
		Thread.sleep(20000);
		WebElement element = driver.findElement(By.xpath("(//a[contains(text(),'See all') or contains(text(),'Tout voir')])[5]"));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", element);
		Thread.sleep(20000);
		return new ProductListingPage(driver);
	}
	
	/**
	 * Click on second Product image
	 * 
	 * @return :ProductListingPage
	 * @throws Exception 
	 */

	public ProductListingPage ClickOnProductImg2() throws Exception {
		GUIFunctions.JavaScriptClick(driver, driver.findElement(PLP_Product_img2), "Click on Product Image");
		return new ProductListingPage(driver);
	}
	
	/**
	 * Click on Product image3
	 * 
	 * @return :ProductListingPage
	 * @throws Exception 
	 */

	public ProductListingPage Click_ProductImg3() throws Exception {
		GUIFunctions.JavaScriptClick(driver, driver.findElement(PLP_Product_img3), "Click on Product Image");
		return new ProductListingPage(driver);
	}
	
	/**
     * Click on Sold Out Product image
     *
     * @return :ProductListingPage
     * @throws Exception
     */



   public ProductListingPage ClickOnSoldOutProductImg() throws Exception
    {
        GUIFunctions.clickElement(driver, PLP_SoldOutProdImg,
                "Click on Sold Out Product image and Navigated to Product Details Page");
        Thread.sleep(2000);
        return new ProductListingPage(driver);
    }

}