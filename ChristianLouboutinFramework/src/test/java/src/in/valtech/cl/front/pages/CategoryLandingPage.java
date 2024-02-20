package src.in.valtech.cl.front.pages;
import org.openqa.selenium.WebDriver;  
import org.testng.Assert;
import org.testng.Reporter;
import org.apache.log4j.Logger;
import static src.in.valtech.util.PropertyFileReader.ObjRepoProp;
import static src.in.valtech.util.PropertyFileReader.TextProp;
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

public class CategoryLandingPage {
	public Logger log = Logger.getLogger(this.getClass().getName());

	public WebDriver driver;

	/**
	 * Verification of CategoryLanding Page Desc:Proper navigation to L1 category
	 * page (women, men) CategoryLanding: Constructor
	 */
	public CategoryLandingPage(WebDriver driver) {
		this.driver = driver;
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
	}

// To fetch the Xpaths from Object Repository file
	By L1category = By.xpath(ObjRepoProp.get().getProperty("CLP_L1Category"));
	By LadiesCategoryPage = By.xpath(ObjRepoProp.get().getProperty("CLP_LadiesCategoryPage"));
	By LadiesL2Bags_xpath = By.xpath(ObjRepoProp.get().getProperty("CLP_LadiesL2Bags_xpath"));
	By LadiesL3Kate_xpath = By.xpath(ObjRepoProp.get().getProperty("CLP_LadiesL3Kate_xpath"));
	By KateHeader_xpath = By.xpath(ObjRepoProp.get().getProperty("CLP_KateHeader_xpath"));
	By RefineFiltersBtn_xpath = By.xpath(ObjRepoProp.get().getProperty("CLP_RefineFiltersBtn_xpath"));
	By LadiesCategorypagename = By.xpath(ObjRepoProp.get().getProperty("CLP_LadiesCategorypagename"));
	By CLP_L1BeautyCategory = By.xpath(ObjRepoProp.get().getProperty("CLP_L1BeautyCategory"));
	By CLP_L1GentlemenCategory = By.xpath(ObjRepoProp.get().getProperty("CLP_L1GentlemenCategory"));
	By CLP_L2EyeCategory = By.xpath(ObjRepoProp.get().getProperty("CLP_L2EyeCategory"));
	By CLP_L2LipsCategory = By.xpath(ObjRepoProp.get().getProperty("CLP_L2LipsCategory"));
	By CLP_LadiesL3Louis_xpath = By.xpath(ObjRepoProp.get().getProperty("CLP_LadiesL3Louis_xpath"));
	By CLP_Product_img = By.xpath(ObjRepoProp.get().getProperty("CLP_Product_img"));
	By CLP_Product_img2 = By.xpath(ObjRepoProp.get().getProperty("CLP_Product_img2"));
	By CLP_HeadingTxt = By.xpath(ObjRepoProp.get().getProperty("CLP_HeadingTxt"));
	By CLP_L2HotChickCategory = By.xpath(ObjRepoProp.get().getProperty("CLP_L2HotChickCategory"));
	By CLP_TheEssentiels = By.xpath(ObjRepoProp.get().getProperty("CLP_TheEssentiels"));
	
	/**
	 * Mousehover on L1 category
	 * 
	 * @return :CategoryLandingPage
	 * @throws Exception
	 */

	public CategoryLandingPage mouseOverCategory() throws Exception {
		GUIFunctions.mouseOverElement(driver, driver.findElement(L1category), "Any L1 Category");
		Thread.sleep(2000);
		return new CategoryLandingPage(driver);
	}

	public CategoryLandingPage ladiescategoryClick() throws Exception {
		GUIFunctions.clickElement(driver, LadiesCategoryPage, "Click on All Things Ladies");
		return new CategoryLandingPage(driver);
	}

	public CategoryLandingPage ladiesL2BagsCategoryClick() throws Exception {
		GUIFunctions.clickElement(driver, LadiesL2Bags_xpath, "Click on L2 Ladies-Bags Category");
		return new CategoryLandingPage(driver);
	}
	
	public CategoryLandingPage ladiesL3KateCategoryClick() throws Exception {
		GUIFunctions.JavaScriptClick(driver, driver.findElement(LadiesL3Kate_xpath), "Click on L3 Ladies-Kate Category");
		return new CategoryLandingPage(driver);
	}

	public CategoryLandingPage RefineFilterBtnClick() throws Exception {
		GUIFunctions.JavaScriptClick(driver, driver.findElement(RefineFiltersBtn_xpath),
				"Click on Refine Filter button");
		Thread.sleep(5000);
		return new CategoryLandingPage(driver);
	}

	public CategoryLandingPage verifyladiesCategoryName() throws Exception {
		CustomFun.isElementVisible(LadiesCategorypagename, driver);

		// Verification of Ladies text
		BaseTest.expected = driver.findElement(LadiesCategorypagename).getText();
		Assert.assertEquals(TextProp.get().getProperty("CLP_LadiesCategoryname"), BaseTest.expected);
		System.out.println("Successfully verified CategoryHeaderNavigation_Ladies text  ");
		log.info("Successfully  Verified HeaderNavigation_Ladies text   \n");
		return new CategoryLandingPage(driver);
	}

	public CategoryLandingPage verifyKateHeader() throws Exception {
		// Verification of Kate Header text
		BaseTest.expected = driver.findElement(KateHeader_xpath).getText();
		Assert.assertEquals(TextProp.get().getProperty("KateHeader"), BaseTest.expected);
		log.info("<p>Successfully Verified Kate Header");
		Reporter.log("<p>Successfully Verified Kate Header");
		return new CategoryLandingPage(driver);
	}

	public CategoryLandingPage MouseOverOnL1BeautyCategory() throws Exception {
		GUIFunctions.mouseOverElement(driver, driver.findElement(CLP_L1BeautyCategory), "L1 Beauty Category");
		return new CategoryLandingPage(driver);
	}

	public CategoryLandingPage BeautyL2EyeCategoryClick() throws Exception {
		GUIFunctions.JavaScriptClick(driver, driver.findElement(CLP_L2EyeCategory), "Click on L2 Eyes Category");
		return new CategoryLandingPage(driver);
	}
	
	public CategoryLandingPage BeautyL2LipsCategoryClick() throws Exception {
		GUIFunctions.JavaScriptClick(driver, driver.findElement(CLP_L2LipsCategory), "Click on L2 Lips Category");
		return new CategoryLandingPage(driver);
	}

	public CategoryLandingPage MouseOverOnL1GentlemenCategory() throws Exception {
		GUIFunctions.mouseOverElement(driver, driver.findElement(CLP_L1GentlemenCategory), "L1 Gentlemen Category");
		log.info("Successfully mouse over on L1 Gentlemen Category");
		Reporter.log("<p>Successfully mouse over on L1 Gentlemen Category");
		return new CategoryLandingPage(driver);
	}

	public CategoryLandingPage GentlemenL3LouisCategoryClick() throws Exception {
		GUIFunctions.JavaScriptClick(driver, driver.findElement(CLP_LadiesL3Louis_xpath), "Click on L3 Louis Category");
		return new CategoryLandingPage(driver);
	}

	/**
	 * Click on Product image
	 * 
	 * @return :ProductListingPage
	 * @throws Exception
	 */

	public CategoryLandingPage Click_ProductImg() throws Exception {

		GUIFunctions.scrollByJavaScriptExecutor(driver.findElement(CLP_Product_img), driver,
				"scroll till Product Image");
		Thread.sleep(2000);
		GUIFunctions.JavaScriptClick(driver, driver.findElement(CLP_Product_img), "Click on Product Image");
		return new CategoryLandingPage(driver);
	}
	
	/**
	* Click on Product image
	* @return :ProductListingPage
	* @throws Exception
	*/

	public CategoryLandingPage Click_ProductImg2() throws Exception
	{
	GUIFunctions.scrollByJavaScriptExecutor(driver.findElement(CLP_Product_img2), driver , "scroll till Product Image");
	Thread.sleep(2000);
	GUIFunctions.JavaScriptClick(driver, driver.findElement(CLP_Product_img2), "Click on Product Image");
	Thread.sleep(2000);
	return new CategoryLandingPage(driver) ;
	}
	
	/**
	* Verify Product Widgets and Hero image exist or not
	* @return :CategoryLandingPage
	*/

	public CategoryLandingPage VerifyProductWidgets() throws InterruptedException
	{
	GUIFunctions.verifyUIElementAndShowText(driver.findElement(CLP_HeadingTxt),"CLP Heading text");
	log.info("Successfully verified all Product Widgets and Hero image in CategoryLandingPage");
	Reporter.log("<p>Successfully verified all Product Widgets and Hero image in CategoryLandingPage");
	return new CategoryLandingPage(driver);
	}
	
	/**
	* Select Hot chick from Ladies category
	* @return :CategoryLandingPage
	* @throws Exception
	*/
	public CategoryLandingPage ladiesL3HotChickCategoryClick() throws Exception
	{
	GUIFunctions.JavaScriptClick(driver, driver.findElement(CLP_L2HotChickCategory) , "Click on L3 Ladies-HotChick Category");
	return new CategoryLandingPage(driver);
	}
	
	public CategoryLandingPage ladiesL2TheEssentielsClick() throws Exception {
		GUIFunctions.clickElement(driver, CLP_TheEssentiels, "Click on L2 The Essentiels Category");
		return new CategoryLandingPage(driver);
	}

}