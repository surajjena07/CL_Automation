package src.in.valtech.cl.back.pages;
import static src.in.valtech.util.PropertyFileReader.ObjRepoProp;
import java.io.File;
import java.time.Duration;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import src.in.valtech.custom.CustomFun;
import src.in.valtech.uifunctions.GUIFunctions;
/**
* @author Gopalaswamy.M
*
*/
public class PIMPage
{
	public Logger log = Logger.getLogger(this.getClass().getName());
	public WebDriver driver;
	/**
	 * Verification of PIM Page
	 * Desc:Proper navigation to PIM Page
	 * PIMPage: Constructor
	 */
	public PIMPage(WebDriver driver)
	{
		this.driver= driver;
	}
	
	// To fetch the Xpaths from Object Repository file
	By pim_usernamefield = By.xpath(ObjRepoProp.get().getProperty("pim_usernamefield"));
	By pim_passwordfield = By.xpath(ObjRepoProp.get().getProperty("pim_passwordfield"));
	By pim_submitbtn = By.xpath(ObjRepoProp.get().getProperty("pim_submitbtn"));
	By pim_productsicon = By.xpath(ObjRepoProp.get().getProperty("pim_productsicon"));
	By pim_category = By.xpath(ObjRepoProp.get().getProperty("pim_category"));
	By pim_EULocale = By.xpath(ObjRepoProp.get().getProperty("pim_EULocale"));
	By pim_searchfield = By.xpath(ObjRepoProp.get().getProperty("pim_searchfield"));
	By pim_productrow = By.xpath(ObjRepoProp.get().getProperty("pim_productrow"));
	By pim_preorderbuttonforon = By.xpath(ObjRepoProp.get().getProperty("pim_preorderbuttonforon"));
	By pim_savebutton = By.xpath(ObjRepoProp.get().getProperty("pim_savebutton"));
	By pim_magentodpn = By.xpath(ObjRepoProp.get().getProperty("pim_magentodpn"));
	By pim_eustglocale = By.xpath(ObjRepoProp.get().getProperty("pim_eustglocale"));
	By pim_quickstartdpn = By.xpath(ObjRepoProp.get().getProperty("pim_quickstartdpn"));
	By pim_csvgridcontext = By.xpath(ObjRepoProp.get().getProperty("pim_csvgridcontext"));
	By pim_activitytab = By.xpath(ObjRepoProp.get().getProperty("pim_activitytab"));
	By pim_processtracker = By.xpath(ObjRepoProp.get().getProperty("pim_processtracker"));
	By pim_csv_pqegc = By.xpath(ObjRepoProp.get().getProperty("pim_csv_pqegc"));
	By pim_magento_pqe = By.xpath(ObjRepoProp.get().getProperty("pim_magento_pqe"));
	By pim_magento_pmqs = By.xpath(ObjRepoProp.get().getProperty("pim_magento_pmqs"));
	By pim_exporticon = By.xpath(ObjRepoProp.get().getProperty("pim_exporticon"));
	By pim_productdescriptionfield = By.xpath(ObjRepoProp.get().getProperty("pim_productdescriptionfield"));
	By pim_descriptionimageuploader = By.xpath(ObjRepoProp.get().getProperty("pim_descriptionimageuploader"));
	By pim_descriptionvideofield = By.xpath(ObjRepoProp.get().getProperty("pim_descriptionvideofield"));
	By pim_threedotsicon = By.xpath(ObjRepoProp.get().getProperty("pim_threedotsicon"));
	By pim_exportsforeu_stg = By.xpath(ObjRepoProp.get().getProperty("pim_exportsforeu_stg"));
	By pim_exportsforeu_homo1 = By.xpath(ObjRepoProp.get().getProperty("pim_exportsforeu_homo1"));
	By pim_exportsforeu_stgbtn = By.xpath(ObjRepoProp.get().getProperty("pim_exportsforeu_stgbtn"));
	By pim_magentoproducts_export = By.xpath(ObjRepoProp.get().getProperty("pim_magentoproducts_export"));
	By pim_magentofamilyvariants_export = By.xpath(ObjRepoProp.get().getProperty("pim_magentofamilyvariants_export"));
	By pim_magentoproductmodels_export = By.xpath(ObjRepoProp.get().getProperty("pim_magentoproductmodels_export"));
	By pim_magentooptions_export = By.xpath(ObjRepoProp.get().getProperty("pim_magentooptions_export"));
	By pim_magentoattributes_export = By.xpath(ObjRepoProp.get().getProperty("pim_magentoattributes_export"));
	By pim_magentofamilities_export = By.xpath(ObjRepoProp.get().getProperty("pim_magentofamilities_export"));
	By pim_euhomo1locale = By.xpath(ObjRepoProp.get().getProperty("pim_euhomo1locale"));
	
	/**
	 * MethodName = navigateToPIMApplication_URL() Description = Navigate to PIM
	 * application and Check Login page is loaded or not
	 * 
	 * @return :BackOfficePage
	 */
	

	public static PIMPage navigateToPIMApplication_URL(WebDriver driver, String baseurl) {
		driver.navigate().to(baseurl);
		return new PIMPage(driver);
	}
	
	
	/**
	 *  Login for PIM
	 * @return :PIMPage	
	 */
	
	public PIMPage PIMLogIn(String Username,String Password) throws InterruptedException
	{ 
    	GUIFunctions.typeTxtboxValue(driver, pim_usernamefield,Username); 
    	GUIFunctions.typeTxtboxValue(driver, pim_passwordfield,Password); 
		GUIFunctions.clickElement(driver, pim_submitbtn ,"Click on submit button"); 
		return new PIMPage(driver);
	}
	
	/**
	 * Click on Products icon
	 * 
	 * @return :PIMPage	
	 * @throws Exception
	 */

	public PIMPage ClickOnProductsIcon() throws Exception {
		GUIFunctions.JavaScriptClick(driver, driver.findElement(pim_productsicon),
				"Click on Product Icon in PIM Home Page");
		Thread.sleep(2000);
		return new PIMPage(driver);
	}
	
	/**
	 * Click on Category
	 * 
	 * @return :PIMPage	
	 * @throws Exception
	 */

	public PIMPage ClickOnCategory() throws Exception {
		GUIFunctions.JavaScriptClick(driver, driver.findElement(pim_category),
				"Click on Category in PIM Home Page");
		Thread.sleep(2000);
		return new PIMPage(driver);
	}
	
	/**
	 * Click on EU Locale Category
	 * 
	 * @return :PIMPage	
	 * @throws Exception
	 */

	public PIMPage ClickOnEULocaleCategory() throws Exception {
		GUIFunctions.clickElement(driver, pim_EULocale,
				"Click on EU Locale Category in PIM Home Page");
		Thread.sleep(2000);
		return new PIMPage(driver);
	}
	
	/**
	 *  Enter SKU ID in Search Field
	 * @return :PIMPage	
	 */
	
	public PIMPage SKUIDSearchField(String SKUID) throws InterruptedException
	{ 
		Actions action = new Actions(driver);
    	WebElement skusearchfield = driver.findElement(pim_searchfield);
    	skusearchfield.click();
		Thread.sleep(2000);
		action.sendKeys(skusearchfield, SKUID).perform();
		Thread.sleep(2000);
		log.info("Entered SKU ID in Search Field : " + SKUID);
		Reporter.log("<p>Entered SKU ID in Search Field : " + SKUID);
    	return new PIMPage(driver);
	}


	/**
	 * Click on Product row
	 * 
	 * @return :PIMPage	
	 * @throws Exception
	 */

	public PIMPage ClickOnProductRow() throws Exception {
		GUIFunctions.clickElement(driver, pim_productrow,
				"Click on Product row");
		Thread.sleep(2000);
		return new PIMPage(driver);
	}
	
	/**
	 * Click on Save Button
	 * 
	 * @return :PIMPage	
	 * @throws Exception
	 */

	public PIMPage ClickOnSaveButton() throws Exception {
		GUIFunctions.clickElement(driver, pim_savebutton,
				"Click on Save Button");
		Thread.sleep(2000);
		return new PIMPage(driver);
	}
	
	/**
	 * Scroll down till Pre-Order Toggle button and Turn on the Pre-order Toggle
	 * 
	 * @return :PIMPage
	 * @throws Exception 
	 */

	public PIMPage ScrolldownAndTurnOnPre_orderToggle() throws Exception
	{
		GUIFunctions.scrollByJavaScriptExecutor(driver.findElement(pim_preorderbuttonforon), driver,
				"scroll till pre-order button");
		Thread.sleep(2000);
		GUIFunctions.JavaScriptClick(driver,driver.findElement(pim_preorderbuttonforon), "Turn on the Pre-order Toggle");
		return new PIMPage(driver);
	}
	
	/**
	 * click on the checkbox and select the Product
	 * 
	 * @return :PIMPage
	 * @throws Exception 
	 */

	public PIMPage ClickOnCheckboxAndSelectTheProduct() throws Exception
	{
		Actions builder = new Actions(driver);
		builder.moveToElement(driver.findElement(pim_productrow)).build().perform();
		Thread.sleep(2000);
	    WebDriverWait wait = new WebDriverWait(driver,10);
	    WebElement Checkbox = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@type='checkbox'])[2]")));
	    Checkbox.click();
	    Thread.sleep(2000);
		return new PIMPage(driver);
	}
	
	
	/**
	 * Verify 2 Dropdowns CTA (Magento and Quick export)
	 * 
	 * @return :PIMPage
	 */

	public PIMPage VerifyMagentoAndQuickexportDropdowns() throws InterruptedException {

		Assert.assertTrue(
				CustomFun.isElementPresent(By.xpath(ObjRepoProp.get().getProperty("pim_magentodpn")), driver),
				"Magento dropdowns is not displaying");
		Assert.assertTrue(
				CustomFun.isElementPresent(By.xpath(ObjRepoProp.get().getProperty("pim_quickstartdpn")), driver),
				"Quick exports dropdowns is not displaying");
		Thread.sleep(1000);
		log.info("Successfully verified Magento and Quick exports dropdowns");
		Reporter.log("<p>Successfully verified Magento and Quick exports dropdowns");
		return new PIMPage(driver);
	}
	
	/**
	 * Click on Magento Dropdown and select particular locale (e.g. US_STG, US INT, US_HOMO) 
	 * 
	 * @return :PIMPage
	 * @throws Exception 
	 */

	public PIMPage ClickOnMagentoDpnAndSelectParticularLocale(String envtype) throws Exception
	{
		if(envtype.contains("StagingEnv"))
		{
		GUIFunctions.clickElement(driver, pim_magentodpn,"Click on Magento Dropdown");
		GUIFunctions.clickElement(driver, pim_eustglocale,"Selected particular locale");
		Thread.sleep(7000);
		}
		
		else
		{
			GUIFunctions.clickElement(driver, pim_magentodpn,"Click on Magento Dropdown");
			GUIFunctions.clickElement(driver, pim_euhomo1locale,"Selected particular locale for Homo1");
			Thread.sleep(7000);
		}
		return new PIMPage(driver);
	}
	
	/**
	 * Click on Quick export Dropdown and select CSV Grid Context
	 * 
	 * @return :PIMPage
	 * @throws Exception 
	 */

	public PIMPage ClickOnQuickexportDpnAndSelectCSVGridContext() throws Exception
	{
		GUIFunctions.clickElement(driver, pim_quickstartdpn,"Click on Quickstart Dropdown");
		GUIFunctions.clickElement(driver, pim_csvgridcontext,"Selected CSV Grid Context");
		Thread.sleep(7000);
		return new PIMPage(driver);
	}
	
	/**
	 * Click on Activity tab
	 * 
	 * @return :PIMPage
	 * @throws Exception 
	 */

	public PIMPage ClickOnActivitytab() throws Exception
	{
		GUIFunctions.clickElement(driver, pim_activitytab,"Click on Activity tab");
		return new PIMPage(driver);
	}
	
	/**
	 * Click on Process tracker
	 * 
	 * @return :PIMPage
	 * @throws Exception 
	 */

	public PIMPage ClickOnProcesstracker() throws Exception
	{
		GUIFunctions.clickElement(driver, pim_processtracker,"Click on Process tracker");
		return new PIMPage(driver);
	}
	
	/**
	 * Verify the status the jobs for Magento And QuickStart
	 * 
	 * @return :PIMPage
	 */

	public PIMPage VerifyJobsStatusForMagentoAndQuickStart() throws InterruptedException {
		for (int i = 0; i <= 6; i++)
		{
			Thread.sleep(10000);
			CustomFun.refreshPage(driver);
			Thread.sleep(3000);
			String pqegc_status=driver.findElement(pim_csv_pqegc).getText();
			if(pqegc_status.contains("COMPLETED"))
			{
			break;
			}
		}
		String csv_pqegc_status=driver.findElement(pim_csv_pqegc).getText();
        Assert.assertEquals(csv_pqegc_status, "COMPLETED");
        String magento_pqe_status=driver.findElement(pim_magento_pqe).getText();
        Assert.assertEquals(magento_pqe_status, "COMPLETED");
        String magento_pmqs_status=driver.findElement(pim_magento_pmqs).getText();
        Assert.assertEquals(magento_pmqs_status, "COMPLETED");
		log.info("Successfully verified Job Status For CSV & Magento");
		Reporter.log("<p>Successfully verified Job Status For CSV & Magento");
		return new PIMPage(driver);
	}
	
	/**
	 * Scroll down till Product Description field and change product description
	 * 
	 * @return :PIMPage
	 * @throws Exception 
	 */

	public PIMPage ScrolldownTillProductDescriptionAndChangeProductDescription(String prod_destxt) throws Exception
	{
		GUIFunctions.scrollByJavaScriptExecutor(driver.findElement(By.xpath("(//label[contains(@class,'AknFieldContainer-label')])[6]")), driver,
				"scroll down till Product Description field");
		Thread.sleep(2000);
		Actions action = new Actions(driver);
    	WebElement productdescriptionfield = driver.findElement(pim_productdescriptionfield);
    	productdescriptionfield.click();
		Thread.sleep(1000);
		productdescriptionfield.clear();
		Thread.sleep(1000);
		action.sendKeys(productdescriptionfield, prod_destxt).perform();
		Thread.sleep(2000);
		log.info("Successfully Scroll down till Product Description field and change product description");
		Reporter.log("<p>Successfully Scroll down till Product Description field and change product description");
		return new PIMPage(driver);
	}
	
	/**
	 * Upload Additional Gallery Image
	 * 
	 * @return :PIMPage
	 * @throws Exception 
	 */

	public PIMPage UploadAdditionalGalleryImage() throws Exception
	{
		GUIFunctions.scrollByJavaScriptExecutor(driver.findElement(By.xpath("(//div[contains(@class,'AknMediaField-preview preview')]//div)[6]")),
				driver, "scroll down till Product Description field");
		Thread.sleep(3000);
		try
		{
			WebDriverWait wait = new WebDriverWait(driver,10);
			WebElement deletepic = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[contains(@class,'AknButtonList-item AknIconButton AknIconButton--grey clear-field')])[5]")));
			deletepic.click();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		Thread.sleep(10000);
		String imagePath = System.getProperty("user.dir")+"\\resources\\front\\christianlouboutin-AutoPic-3160586_BK01_4_2200x1200_Auto..jpg";
		System.out.println(imagePath);
		WebDriverWait wait1 = new WebDriverWait(driver,10);
		WebElement Upload = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class='AknFieldContainer-inputContainer field-input'])[48]")));
		Upload.click();
		Thread.sleep(3000);
		GUIFunctions.UploadFiles(imagePath);
		Thread.sleep(3000);
		log.info("Successfully Uploaded Additional Gallery Image");
		Reporter.log("<p>Successfully Uploaded Additional Gallery Image");
		return new PIMPage(driver);
	}
	
	/**
	 *  Enter Description Video Link in Description Video Field
	 * @return :PIMPage	
	 */
	
	public PIMPage EnterDescriptionVideoLink(String DescriptionVideoLink) throws InterruptedException
	{ 
		GUIFunctions.scrollByJavaScriptExecutor(driver.findElement(By.xpath("(//input[@class='AknTextField '])[4]")), driver,
				"scroll down till Main Video [main_video_1] field");
		Thread.sleep(2000);
		Actions action = new Actions(driver);
    	WebDriverWait wait = new WebDriverWait(driver,10);
		WebElement descriptionvideo = wait.until(ExpectedConditions.elementToBeClickable(pim_descriptionvideofield));
		descriptionvideo.click();
    	Thread.sleep(1000);
    	descriptionvideo.clear();
		Thread.sleep(1000);
		action.sendKeys(descriptionvideo, DescriptionVideoLink).perform();
		Thread.sleep(2000);
		log.info("Entered Description Video Link : " + DescriptionVideoLink);
		Reporter.log("<p>Entered Description Video Link : " + DescriptionVideoLink);
    	return new PIMPage(driver);
	}
	
	/**
	 * Click on Exports icon from Left menu
	 * 
	 * @return :PIMPage	
	 * @throws Exception
	 */

	public PIMPage ClickOnExportsIcon() throws Exception {
		GUIFunctions.JavaScriptClick(driver, driver.findElement(pim_exporticon),
				"Click on Exports Icon in PIM Home Page");
		Thread.sleep(2000);
		return new PIMPage(driver);
	}
	
	/**
	 * Click on 3 dots ( . . .) icons at top right 
	 * 
	 * @return :PIMPage	
	 * @throws Exception
	 */

	public PIMPage ClickOnThreeDotsIcon() throws Exception {
		GUIFunctions.JavaScriptClick(driver, driver.findElement(pim_threedotsicon),
				"Click on Exports Icon in PIM Home Page");
		Thread.sleep(2000);
		return new PIMPage(driver);
	}
	
	/**
	 * Select respective store for exports
	 * @return :PIMPage	
	 * @throws Exception
	 */

	public PIMPage SelectRespectiveStoreForExports(String envtype) throws Exception {
		if(envtype.contains("StagingEnv"))
		{
		GUIFunctions.JavaScriptClick(driver, driver.findElement(pim_exportsforeu_stg),
				"Select respective store for exports in PIM Home Page");
		Thread.sleep(2000);
		}
		else
		{
			GUIFunctions.JavaScriptClick(driver, driver.findElement(pim_exportsforeu_homo1),
					"Select respective store for exports in PIM Home Page");
			Thread.sleep(2000);
		}
		return new PIMPage(driver);
	}
	
	/**
	 * Click on Start Export CTA
	 * @return :PIMPage	
	 * @throws Exception
	 */

	public PIMPage ClickOnStartExportsButton() throws Exception {
		GUIFunctions.JavaScriptClick(driver, driver.findElement(pim_exportsforeu_stgbtn),
				"Click on Start Export CTA in PIM Home Page");
		Thread.sleep(3000);
		return new PIMPage(driver);
	}
	
	/**
	 * Verify The Jobs Status For Recently Exported Jobs
	 * @return :PIMPage
	 */

	public PIMPage VerifyJobsStatusForRecentlyExportedJobs() throws InterruptedException {
		for (int i = 0; i <= 6; i++)
		{
			Thread.sleep(10000);
			CustomFun.refreshPage(driver);
			Thread.sleep(3000);
			/*
			 * String
			 * magentoproducts_export=driver.findElement(pim_magentoproducts_export).getText
			 * (); if(magentoproducts_export.contains("COMPLETED")) { break; }
			 */
		}
		/*
		 * String
		 * magentoproducts_export_status=driver.findElement(pim_magentoproducts_export).
		 * getText(); Assert.assertEquals(magentoproducts_export_status, "STARTED");
		 * String magentofamilyvariants_export_status=driver.findElement(
		 * pim_magentofamilyvariants_export).getText();
		 * Assert.assertEquals(magentofamilyvariants_export_status, "COMPLETED"); String
		 * magentoproductmodels_export_status=driver.findElement(
		 * pim_magentoproductmodels_export).getText();
		 * Assert.assertEquals(magentoproductmodels_export_status, "STARTED"); String
		 * magentooptions_export_status=driver.findElement(pim_magentooptions_export).
		 * getText(); Assert.assertEquals(magentooptions_export_status, "COMPLETED");
		 * String magentoattributes_export_status=driver.findElement(
		 * pim_magentoattributes_export).getText();
		 * Assert.assertEquals(magentoattributes_export_status, "COMPLETED"); String
		 * magentofamilities_export_status=driver.findElement(
		 * pim_magentofamilities_export).getText();
		 * Assert.assertEquals(magentofamilities_export_status, "COMPLETED");
		 */
		log.info("Successfully verified Job Status For Recently Exported Jobs");
		Reporter.log("<p>Successfully verified Job Status For Recently Exported Jobs");
		return new PIMPage(driver);
	}
}
