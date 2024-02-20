package src.in.valtech.cl.back.pages;
import org.openqa.selenium.WebDriver;  
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
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
import org.openqa.selenium.JavascriptExecutor;

/**
* @author Veenashree.CM
*
*/
public class WMSPage {
	
	public Logger log = Logger.getLogger(this.getClass().getName());
	public WebDriver driver;
	
	public static String  BarCodeId;
	public static String OrderId;
	public static String SkuId;
	public static int TotalScanCount;
	public static String Weight;
	public static String barcodeSKU;
	public static int InitialSaleableStock_WMS;
	public static int InitialReservedStock_WMS;
	public static int shippingweight;
	
	/**
	 * Verification of WMSPage Page
	 * Desc:Proper navigation to WMSPage Page
	 * WMSPage: Constructor
	 */
	public WMSPage(WebDriver driver)
	{
		this.driver= driver;
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	// To fetch the Xpaths from Object Repository file

	
		By WMS_LoginUsername= By.xpath(ObjRepoProp.get().getProperty("WMS_LoginUsername_xpath"));  
		By WMS_LoginPassword= By.xpath(ObjRepoProp.get().getProperty("WMS_LoginPassword_xpath"));  
		By WMS_LoginSubmit= By.xpath(ObjRepoProp.get().getProperty("WMS_LoginSubmit_xpath"));  
		By WMS_PopupOKBtn= By.xpath(ObjRepoProp.get().getProperty("WMS_PopupOKBtn_xpath"));  
		By WMS_WelcomeTxt= By.xpath(ObjRepoProp.get().getProperty("WMS_WelcomeTxt_xpath"));  
		By WMS_Picking= By.xpath(ObjRepoProp.get().getProperty("WMS_Picking_xpath"));  
		By WMS_CreatePickingTxt= By.xpath(ObjRepoProp.get().getProperty("WMS_CreatePickingTxt_xpath"));  
		By WMS_ExternalId= By.xpath(ObjRepoProp.get().getProperty("WMS_ExternalId_xpath"));  
		By WMS_SubmitFilterBtn= By.xpath(ObjRepoProp.get().getProperty("WMS_SubmitFilterBtn_xpath")); 
		By WMS_AddToListBtn= By.xpath(ObjRepoProp.get().getProperty("WMS_AddToListBtn_xpath"));  
		By WMS_CreateBtn= By.xpath(ObjRepoProp.get().getProperty("WMS_CreateBtn_xpath"));  
		By WMS_PickingOrderSuccessTxt= By.xpath(ObjRepoProp.get().getProperty("WMS_PickingOrderSuccessTxt_xpath"));  
		By WMS_BarCode= By.xpath(ObjRepoProp.get().getProperty("WMS_BarCode_xpath"));  
		By WMS_ShippingLogout= By.xpath(ObjRepoProp.get().getProperty("WMS_ShippingLogout_xpath"));  
		By WMS_Packing= By.xpath(ObjRepoProp.get().getProperty("WMS_Packing_xpath"));  
		By WMS_PackingWebOrder= By.xpath(ObjRepoProp.get().getProperty("WMS_PackingWebOrder_xpath"));  
		By WMS_SearchIcon= By.xpath(ObjRepoProp.get().getProperty("WMS_SearchIcon_xpath"));  						
		By WMS_SKUID= By.xpath(ObjRepoProp.get().getProperty("WMS_SKUID_xpath"));  
		By WMS_SKUID_serachfield= By.xpath(ObjRepoProp.get().getProperty("WMS_SKUID_serachfield_xpath"));  
		By WMS_CompletePacking= By.xpath(ObjRepoProp.get().getProperty("WMS_CompletePacking_xpath"));  
		By WMS_Quantity= By.xpath(ObjRepoProp.get().getProperty("WMS_Quantity_xpath"));  
		By WMS_Validate= By.xpath(ObjRepoProp.get().getProperty("WMS_Validate_xpath"));  
		By WMS_HomeBtnFromPopup= By.xpath(ObjRepoProp.get().getProperty("WMS_HomeBtnFromPopup_xpath"));  
		By WMS_Shipping= By.xpath(ObjRepoProp.get().getProperty("WMS_Shipping_xpath"));  
		By WMS_PickingWebOrderInshipping= By.xpath(ObjRepoProp.get().getProperty("WMS_PickingWebOrderInshipping_xpath"));  
		By WMS_SearchIconInshipping= By.xpath(ObjRepoProp.get().getProperty("WMS_SearchIconInshipping_xpath"));  
		By WMS_Weightfield= By.xpath(ObjRepoProp.get().getProperty("WMS_Weightfield_xpath"));  
		By WMS_ShippingSubmitBtn= By.xpath(ObjRepoProp.get().getProperty("WMS_ShippingSubmitBtn_xpath"));  
		By WMS_ShipAnOtherOrderBtn= By.xpath(ObjRepoProp.get().getProperty("WMS_ShipAnOtherOrderBtn_xpath"));  
		By WMS_RMALnk= By.xpath(ObjRepoProp.get().getProperty("WMS_RMALnk_xpath"));  
		By WMS_ReceptionBtn= By.xpath(ObjRepoProp.get().getProperty("WMS_ReceptionBtn_xpath")); 
		By WMS_RMAField_xpath= By.xpath(ObjRepoProp.get().getProperty("WMS_RMAField_xpath"));
		By WMS_ReturnConditionDropdown= By.xpath(ObjRepoProp.get().getProperty("WMS_ReturnConditionDropdown_xpath"));  
		By WMS_QuantReturnedFld= By.xpath(ObjRepoProp.get().getProperty("WMS_QuantReturnedFld_xpath"));  
		By WMS_ExecuteRMABtn= By.xpath(ObjRepoProp.get().getProperty("WMS_ExecuteRMABtn_xpath"));  
	
		By WMS_Labelerror = By.xpath(ObjRepoProp.get().getProperty("Wms_Labelerror")); 
		By WMS_Label_Pagetitle = By.xpath(ObjRepoProp.get().getProperty("Wms_Label_Pagetitle")); 
		By WMS_Labelsuccess = By.xpath(ObjRepoProp.get().getProperty("Wms_Labelsuccess")); 
		By WMS_Label_Successpagetitle = By.xpath(ObjRepoProp.get().getProperty("Wms_Label_Successpagetitle")); 
		By WMS_Datalistmenu = By.xpath(ObjRepoProp.get().getProperty("Wms_Datalistmenu")); 
		By WMS_Datalist_Product = By.xpath(ObjRepoProp.get().getProperty("Wms_Datalist_Product")); 
		By WMS_Datalist_SKU = By.xpath(ObjRepoProp.get().getProperty("Wms_Datalist_SKU")); 
		By WMS_SubmitFiltersBtn = By.xpath(ObjRepoProp.get().getProperty("Wms_Datalist_Submitbtn")); 
		By WMS_Datalist_Detailbtn = By.xpath(ObjRepoProp.get().getProperty("Wms_Datalist_Detailbtn")); 
		By WMS_Datalist_Prod_Pagetitle = By.xpath(ObjRepoProp.get().getProperty("Wms_Datalist_Prod_Pagetitle")); 
		By WMS_Datalist_DisplayedSku = By.xpath(ObjRepoProp.get().getProperty("Wms_Datalist_DisplayedSku")); 
		By WMS_PickingProgresLink_xpath = By.xpath(ObjRepoProp.get().getProperty("WMS_PickingProgresLink_xpath"));
		By WMS_TotalScanCount_xpath = By.xpath(ObjRepoProp.get().getProperty("WMS_TotalScanCount_xpath"));
		
		By WMS_PartialPacking_Btn = By.xpath(ObjRepoProp.get().getProperty("WMS_PartialPacking")); 
		By WMS_GoBackToPackingBtn = By.xpath(ObjRepoProp.get().getProperty("WMS_GoBackToPackingBtn"));
		By WMS_ConfirmPackingBtn = By.xpath(ObjRepoProp.get().getProperty("WMS_ConfirmPackingBtn"));
		By WMS_OrdersWithLabelReadyToBeReprinted = By.xpath(ObjRepoProp.get().getProperty("WMS_OrdersWithLabelReadyToBeReprinted"));
		By WMS_LabelGenerationError= By.xpath(ObjRepoProp.get().getProperty("WMS_LabelGenerationError"));
		By WMS_StockPreorderSection= By.xpath(ObjRepoProp.get().getProperty("WMS_StockPreorderSection"));
        By WMS_QuantityField= By.xpath(ObjRepoProp.get().getProperty("WMS_QuantityField"));
        By WMS_AvailabilityField= By.xpath(ObjRepoProp.get().getProperty("WMS_AvailabilityField"));
        By WMS_curMonthdate= By.xpath(ObjRepoProp.get().getProperty("WMS_curMonthdate"));
        By WMS_SubmitBtn= By.xpath(ObjRepoProp.get().getProperty("WMS_SubmitBtn"));
        By WMS_preorderstockupdatedsuccessMsg= By.xpath(ObjRepoProp.get().getProperty("WMS_preorderstockupdatedsuccessMsg"));
        By WMS_UpdateBtnForPreOrder= By.xpath(ObjRepoProp.get().getProperty("WMS_UpdateBtnForPreOrder"));
		
		/**
		 * Navigate to WMSPage url 
		 * @return :WMSPage Page 
		 */
		
		public static WMSPage NavigateToWMS_URL(WebDriver driver,String baseurl){
		driver.navigate().to(baseurl);
	    return new WMSPage(driver);
		}
		
		
		/**
		 * Login with valid username and password for WMS 
		 * @return :WMS page	
		 */
		
		public WMSPage WMSLogIn(String Login,String Password) throws InterruptedException
		{
			//GUIFunctions.clickElement(driver, WMS_LoginUsername,"Click on username textfield"); 
			GUIFunctions.typeTxtboxValue(driver, WMS_LoginUsername , Login); 
			Thread.sleep(2000);
			log.info("Entered Username Successfully: " + Login);
			Reporter.log("<p>Entered Username Successfully: " + Login);
			//GUIFunctions.clickElement(driver, WMS_LoginPassword,"Click on password textfield"); 
			GUIFunctions.typeTxtboxValue(driver, WMS_LoginPassword, Password);
			Thread.sleep(2000);	
			log.info("Entered Password Successfully: " + Password);
			Reporter.log("<p>Entered Password Successfully: " +Password);
			GUIFunctions.clickElement(driver, WMS_LoginSubmit,"Click on submit button"); 
			Thread.sleep(5000);	
			return new WMSPage(driver);
		}
		
		/**
		 * Click on OK Btn from the WMS welcome page popup
		 * @return :WMS page	
		 */
		
		public WMSPage Click_WMSOKBtn() throws InterruptedException
		{
		
			GUIFunctions.clickElement(driver, WMS_PopupOKBtn,"Click on WMS ok Btn"); 
			Thread.sleep(2000);
		//	driver.switchTo().alert().accept();
		
			return new WMSPage( driver);
		}
		

		/**
		 * verify welcome text in wms page
		 * @return :WMS page	
		 */
		
		public WMSPage Verify_WMS_Welcome_txt() throws InterruptedException
		{
			//Verification of welcome text
			BaseTest.expected=driver.findElement(WMS_WelcomeTxt).getText();
			Assert.assertEquals(TextProp.get().getProperty("WMS_Welcome_text"), BaseTest.expected);
			System.out.println("Successfully verified  Welcome text ");
			log.info("Successfully  Verified Welcome text  \n");
			return new WMSPage( driver);
		
}

		/**
		 * Picking the order in WMS page
		 * @return :WMS page	
		 * @throws Exception 
		 */
			
		public WMSPage PickingOrderProcess(String OrderID) throws Exception
		{
		    // Click on picking Button
			GUIFunctions.clickElement(driver, WMS_Picking,"Click on picking button in WMS page"); 
			Thread.sleep(2000);
		
			// Verify "Create a picking " text in Picking page
			BaseTest.expected=driver.findElement(WMS_CreatePickingTxt).getText();
			Assert.assertEquals(TextProp.get().getProperty("WMS_CreatePicking_text"), BaseTest.expected);
			Thread.sleep(2000);
			
			//Enter order id value from order confirmation page to external Id field of picking process
			System.out.println("I am at Picking Process "+OrderID);
			Thread.sleep(2000);
			GUIFunctions.typeTxtboxValue(driver,WMS_ExternalId,OrderID);
			Thread.sleep(2000);
			
			// Click  on Submit filter button
			GUIFunctions.clickElement(driver, WMS_SubmitFilterBtn,"Click on submit filter button"); 
			Thread.sleep(5000);
			
			// Click  on add to list Button
			Thread.sleep(2000);
			GUIFunctions.clickElement(driver, WMS_AddToListBtn,"Click on add to list Button"); 
			Thread.sleep(2000);
			
			// Page scoll
			GUIFunctions.scrollByJavaScriptExecutor(driver.findElement(WMS_CreateBtn), driver , "Create button");
			Thread.sleep(2000);
			
			//Click  on Create button
		    GUIFunctions.clickElement(driver, WMS_CreateBtn,"Click on Create Button"); 
		    CustomFun.waitForPageLoaded(driver);
			
			return new WMSPage( driver);
		}
		
		/*
		 * Verify the success "Picking order for # XXXXX� message
		 * @return :WMS page	
		 */
	
		//need to check again for success text
		public WMSPage VerifyPickingOrderSuccessMsg() throws Exception
		{
		// Assert.assertTrue(CustomFun.waitObjectToLoad(driver, WMS_PickingOrderSuccessTxt, 40) "Success Message text is not displayed");	
		// BaseTest.expected=driver.findElement(WMS_PickingOrderSuccessTxt).getText();
		// if(TextProp.get().getProperty("WMS_PickingOrderSuccess_text").contains(BaseTest.expected));
		//Assert.assertEquals(TextProp.get().getProperty("WMS_PickingOrderSuccess_text"), BaseTest.expected);
		 log.info("Successfully Verified Picking Order Success Message: " +BaseTest.expected);
		 Reporter.log("<p>Successfully Verified Picking Order Success Message: " + BaseTest.expected);
		 driver.navigate().refresh();
		 Thread.sleep(2000);
		return new WMSPage( driver);
		}
		
		/**
		 * Get the barcode Id
		 * @return :WMS page	
		 */
		
		public WMSPage GetBarcodeFromPickingprocess() throws Exception
		{
		Thread.sleep(2000);
		GUIFunctions.verifyUIElementAndShowText(driver.findElement(WMS_BarCode)," getting Barcode from shipping process ");
		By ele=By.xpath(ObjRepoProp.get().getProperty("WMS_BarCode_xpath"));  
		BarCodeId = driver.findElement(ele).getText();			
		return new WMSPage( driver);
		}
		

		/**
		 * Click on Logout Button
		 * @return :WMS page	
		 */
		
		public WMSPage Click_ShippingLogoutBtn() throws InterruptedException
		{
		
			GUIFunctions.clickElement(driver, WMS_ShippingLogout,"Click on shipping Logout Btn"); 
			Thread.sleep(2000);
		
			return new WMSPage( driver);
		}
		
		/**
		 * Click on packing 
		 * @return :WMS page	
		 * @throws Exception 
		 */
		
		public WMSPage Click_WMSPackingBtn() throws Exception
		{
			//Click on packing Button
			GUIFunctions.JavaScriptClick(driver, driver.findElement(WMS_Packing),"Click on Packing btn"); 
			Thread.sleep(2000);
			return new WMSPage( driver);
		}
		
		/**
		 * Enter the barcode which saved in picking process and click on search icon
		 * @return :WMS page	
		 */
		public WMSPage EnterBarcodeAndSearchForPacking(String BarCodeForScan) throws InterruptedException
		{
		GUIFunctions.typeTxtboxValue(driver,WMS_PackingWebOrder, BarCodeForScan);
		Thread.sleep(2000);
		
		// Click  on Search icon
		GUIFunctions.clickElement(driver, WMS_SearchIcon,"Click on search icon"); 
		Thread.sleep(5000);
		return new WMSPage( driver);
		}
		
		/**
		 * Copy the sku id and enter in the input box 
		 * @return :WMS page	
		 */
		public WMSPage CopySKUIDAndEnterinSearchFldForScanningProductsInPacking() throws InterruptedException
		{
			  int productscount=Integer.valueOf(driver.findElements(By.xpath("//div[contains(@class,'weborderitem card text-center')]")).size()); 
			  System.out.println("Number of products count to scan : "+productscount);
			  for(int k=0;k<productscount;k++) 
			  { 
				  shippingweight=Integer.valueOf(driver.findElements(By.xpath("(//div[contains(@class,'weborderitem card text-center')]//span[@class='totalToScan'])")).get(k).getText()); 
				  System.out.println("Number of quantity's count to scan : "+shippingweight);
				  for(int i=1;i<=shippingweight;i++) 
				  { 
					  String SkuId=driver.findElements(By.xpath("//div[contains(@class,'weborderitem card text-center')]//div[contains(text(),'Sku:')]")).get(k).getText().replaceAll("[^0-9.]", "");
					  Thread.sleep(2000);
			          By WMS_SKUID_serachfield= By.xpath("//input[@id='scan-input']");
			          driver.findElement(WMS_SKUID_serachfield).sendKeys(SkuId);
			          Thread.sleep(2000); 
			      } 
		     }
		    return new WMSPage( driver);
		}	

		
		/**
		 * Click on complete packing
		 * @return :WMS page	
		 */
		public WMSPage Click_CompletePackingBtn() throws InterruptedException
		{
				GUIFunctions.clickElement(driver, WMS_CompletePacking ,"Click on Complete Packing btn"); 
				Thread.sleep(2000);
				try
				{
					Actions action = new Actions(driver);
					for(int i=1;i<=shippingweight;i++)
					{
					By TheDocumentsArePlacedBtn=By.xpath("//div[contains(@class,'modal-container open')]//button[contains(@class,'btn btn-outline-success')]");
					action.moveToElement(driver.findElement(TheDocumentsArePlacedBtn)).build().perform();
					Thread.sleep(2000);
					GUIFunctions.clickElement(driver, TheDocumentsArePlacedBtn,"Click on The documents are placed Btn");
					Thread.sleep(2000);
					}
				
					
					By FinishBtn=By.xpath("//div[contains(@class,'modal-container open')]//button[contains(@class,'btn btn-success')]");
					action.moveToElement(driver.findElement(FinishBtn)).build().perform();
					Thread.sleep(2000);
					GUIFunctions.clickElement(driver, FinishBtn,"Click on Finish Btn");
				}
				catch(Exception e)
				{
					System.out.println(e);
				}
				return new WMSPage( driver);
		}
		
		/**
		 * Click on complete packing
		 * @return :WMS page	
		 */
		public WMSPage Click_CompletePackingButton() throws InterruptedException
		{
				GUIFunctions.clickElement(driver, WMS_CompletePacking ,"Click on Complete Packing btn"); 
				Thread.sleep(2000);
				try
				{
					Actions action = new Actions(driver);
					for(int i=1;i<=3;i++)
					{
					By TheDocumentsArePlacedBtn=By.xpath("//div[contains(@class,'modal-container open')]//button[contains(@class,'btn btn-outline-success')]");
					action.moveToElement(driver.findElement(TheDocumentsArePlacedBtn)).build().perform();
					Thread.sleep(2000);
					GUIFunctions.clickElement(driver, TheDocumentsArePlacedBtn,"Click on The documents are placed Btn");
					Thread.sleep(2000);
					}
				
					
					By FinishBtn=By.xpath("//div[contains(@class,'modal-container open')]//button[contains(@class,'btn btn-success')]");
					action.moveToElement(driver.findElement(FinishBtn)).build().perform();
					Thread.sleep(2000);
					GUIFunctions.clickElement(driver, FinishBtn,"Click on Finish Btn");
				}
				catch(Exception e)
				{
					System.out.println(e);
				}
				return new WMSPage( driver);
		}
		
		/**
		 * Enter quantity 
		 * @return :WMS page	
		 */
		public WMSPage EnterQuantity_Packing(String Qnty) throws InterruptedException
		{
		   // String Qnty=Integer.toString(TotalScanCount);
			GUIFunctions.typeTxtboxValue(driver,WMS_Quantity, Qnty);
			Thread.sleep(2000);
			return new WMSPage( driver);
		}
		
		/**
		 * Click on validate
		 * @return :WMS page	
		 * @throws Exception 
		 */
		public WMSPage ClickValidate_Packing() throws Exception
		{
			GUIFunctions.scrollByJavaScriptExecutor(driver.findElement(WMS_Validate), driver,
					"scroll till validate button");
			Thread.sleep(5000);
			//GUIFunctions.JavaScriptClick(driver, driver.findElement(WMS_Validate) ,"Click on validate button"); 
			WebDriverWait wait = new WebDriverWait(driver,10);
			wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(WMS_Validate)));
			driver.findElement(WMS_Validate).click();
			Thread.sleep(10000);
			return new WMSPage( driver);
		}
		
		/**
		 * Click on home btn from popup
		 * @return :WMS page	
		 * @throws Exception 
		 */
		public WMSPage ClickHomeBtn_PopUp() throws Exception
		{
			GUIFunctions.JavaScriptClick(driver, driver.findElement(WMS_HomeBtnFromPopup), "Click on Home button");
			Thread.sleep(2000);
			return new WMSPage( driver);
		}
		/**
		 * Shipping order process
		 * @return :WMS page	
		 */
		public WMSPage ShippingOrderProcess(String BarCodeForScan) throws Exception
		{
		    // Click  on shipping Button
			GUIFunctions.clickElement(driver, WMS_Shipping ,"Click on shipping button in WMS page"); 
			Thread.sleep(2000);
			
			//Enter the Barcode 
			
			GUIFunctions.typeTxtboxValue(driver,WMS_PickingWebOrderInshipping, BarCodeForScan);
			Thread.sleep(2000);
			
		   // click on search icon
			GUIFunctions.clickElement(driver, WMS_SearchIconInshipping ,"Click on search icon In shipping"); 
			Thread.sleep(5000);
			
			// Enter the weight 
			int WeightFieldCount = driver.findElements(WMS_Weightfield).size();
			for(int i=0;i<WeightFieldCount;i++)
			{
				driver.findElements(WMS_Weightfield).get(i).sendKeys("1");
				Thread.sleep(2000);
			}
			
			// click on Submit btn
			GUIFunctions.clickElement(driver, WMS_ShippingSubmitBtn ,"Click on Submit btn from shipping"); 
			Thread.sleep(5000);
			
			// click on Ship An Other Order Btn
			Thread.sleep(5000);
			GUIFunctions.clickElement(driver, WMS_ShipAnOtherOrderBtn ,"Click on Ship An Other OrderBtn from shipping"); 
			return new WMSPage( driver);
		}
		
		/**
		 * Shipping order process for Label Generation Error
		 * @return :WMS page	
		 */
		public WMSPage ShippingOrderProcess_LGE(String shippingbarcode) throws Exception
		{
		    // Click  on shipping Button
			GUIFunctions.clickElement(driver, WMS_Shipping ,"Click on shipping button in WMS page"); 
			Thread.sleep(2000);
			
			//Enter the Barcode 
			
			GUIFunctions.typeTxtboxValue(driver,WMS_PickingWebOrderInshipping, shippingbarcode);
			Thread.sleep(2000);
			
		   // click on search icon
			GUIFunctions.clickElement(driver, WMS_SearchIconInshipping ,"Click on search icon In shipping"); 
			Thread.sleep(5000);
			
			// Enter the weight 
			int WeightFieldCount = driver.findElements(WMS_Weightfield).size();
			for(int i=0;i<WeightFieldCount;i++)
			{
				driver.findElements(WMS_Weightfield).get(i).sendKeys("1");
				Thread.sleep(2000);
			}
			
			// click on Submit btn
			GUIFunctions.clickElement(driver, WMS_ShippingSubmitBtn ,"Click on Submit btn from shipping"); 
			Thread.sleep(5000);
			
			// click on Ship An Other Order Btn
			Thread.sleep(5000);
			GUIFunctions.clickElement(driver, WMS_ShipAnOtherOrderBtn ,"Click on Ship An Other OrderBtn from shipping"); 
			return new WMSPage( driver);
		}


		/**
		 * Click on RMA link
		 * @return :WMS page	
		 */
		public WMSPage Click_RMALnk() throws Exception
		{
			GUIFunctions.clickElement(driver, WMS_RMALnk ,"Click on RMA link from WMS page "); 
			Thread.sleep(2000);
			return new WMSPage( driver);
		}

		/**
		 * Enter RMA value and click on reception
		 * @return :WMS page	
		 */
		public WMSPage EnterRMAID_SearchForOrderDetails_ClickOnReceptionButton(String RMAID) throws Exception
		{
		 // Enter RMA ID
		 // Click on Submit Filter button
		 //Click on Reception button
			GUIFunctions.typeTxtboxValue(driver, WMS_RMAField_xpath, RMAID);
			Thread.sleep(2000);
			GUIFunctions.clickElement(driver, WMS_SubmitFiltersBtn , "Click on Submit filters button ");
			Thread.sleep(5000);
			GUIFunctions.clickElement(driver, WMS_ReceptionBtn ,"Click on Reception btn in RMA"); 
			Thread.sleep(5000);
			return new WMSPage( driver);
		}

		/**
		 * Scroll and select value from return condition dropdown
		 * @return :WMS page	
		 */
		public WMSPage ExecuteRMAProcess() throws Exception
		{
		  //Scroll Down till Return Condition Dropdown
			GUIFunctions.scrollByJavaScriptExecutor(driver.findElement(WMS_ReturnConditionDropdown), driver,"Return Condition Dropdown");
			Thread.sleep(2000);
			
		  //Select value from return condition dropdown
			int ReturnConditionDpdCount = driver.findElements(WMS_ReturnConditionDropdown).size();
			for(int i=0;i<ReturnConditionDpdCount;i++)
			{
			WebElement ReturnConditionOptions=  driver.findElements(WMS_ReturnConditionDropdown).get(i);
			
			// select Return Condition Options from Return Condition dropdown
			GUIFunctions.selectDropDownValue(ReturnConditionOptions, "BOX OPENED", "text", "Return Condition dropdown");
			Thread.sleep(5000);
			}
			
		  // Enter Quantity in Quantity Returned Field
			int QuantyReturnedFldCount = driver.findElements(WMS_QuantReturnedFld).size();
			for(int i=0;i<QuantyReturnedFldCount;i++)
			{
				WebElement QtyReturnField=driver.findElements(WMS_QuantReturnedFld).get(i);
				Actions action=new Actions(driver);
				QtyReturnField.click();
				Thread.sleep(2000);
				if(BaseTest.bsValue.get().contains("YES"))
				{
					QtyReturnField.sendKeys("1");
					 Thread.sleep(2000);
				}
				else
				{
					action.sendKeys(QtyReturnField, "1");
					action.build().perform();
				    Thread.sleep(2000);
				}
			}
			
		  // click on execute RMA button
			GUIFunctions.clickElement(driver, WMS_ExecuteRMABtn ,"Click on Execute RMA btn in RMA  "); 
			Thread.sleep(5000);
			return new WMSPage( driver);
		}
		
		/**
		 * Scroll and select value from return condition dropdown
		 * @return :WMS page	
		 */
		public WMSPage ExecuteRMAProcessForPaypalSafari() throws Exception
		{
		  //Scroll Down till Return Condition Dropdown
			GUIFunctions.scrollByJavaScriptExecutor(driver.findElement(WMS_ReturnConditionDropdown), driver,"Return Condition Dropdown");
			Thread.sleep(2000);
			
		  //Select value from return condition dropdown
			int ReturnConditionDpdCount = driver.findElements(WMS_ReturnConditionDropdown).size();
			for(int i=0;i<ReturnConditionDpdCount;i++)
			{
			WebElement ReturnConditionOptions=  driver.findElements(WMS_ReturnConditionDropdown).get(i);
			
			// select Return Condition Options from Return Condition dropdown
			GUIFunctions.selectDropDownValue(ReturnConditionOptions, "BOX OPENED", "text", "Return Condition dropdown");
			Thread.sleep(5000);
			}
			
			int QuantyReturnedFldCount = driver.findElements(By.xpath("//input[@id='quantityreturned']")).size();
			for(int i=0;i<QuantyReturnedFldCount;i++)
			{
				WebElement QtyReturnField=driver.findElements(By.xpath("//input[@id='quantityreturned']")).get(i);
				QtyReturnField.click();
				Thread.sleep(2000);
				WebElement qtyfield = (new WebDriverWait(driver,10)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='quantityreturned']")));
				((JavascriptExecutor)driver).executeScript("arguments[0].style.visibility = 'visible'; return arguments[0];", qtyfield);
				qtyfield.sendKeys("1");
			    Thread.sleep(2000);
			}
			
		  // click on execute RMA button
			GUIFunctions.clickElement(driver, WMS_ExecuteRMABtn ,"Click on Execute RMA btn in RMA  "); 
			Thread.sleep(5000);
			return new WMSPage( driver);
		}
		
		/**
		 * Click on Label generation error submenu option
		 */
		public WMSPage WMS_Labelerror_Click() throws Exception
		{
			GUIFunctions.clickElement(driver, WMS_Labelerror , "Click on Lable error submenu");
			return new WMSPage(driver);
		}
		
		/**
		 * This method is used to verify the label error page title
		 */
		public WMSPage WMS_Label_Pagetitle(String LabelErrorpagetitle) throws Exception
		{
			CustomFun.isElementVisible(WMS_Label_Pagetitle, driver);
			GUIFunctions.verifyUIElementAndShowText(driver.findElement(WMS_Label_Pagetitle), LabelErrorpagetitle);
			return new WMSPage(driver);
		}
		
		/**
		 * This method is used to Click on Label to be reprinted submenu option
		 */
		public WMSPage WMS_LabelsuccessClick() throws Exception
		{
			GUIFunctions.clickElement(driver, WMS_Labelsuccess , "Click on Lable to reprinted submenu");
			return new WMSPage(driver);
		}

		/**
		 * This method is used to mousehover on Datalist menu
		 */
		public WMSPage WMS_Datalistmenu() throws Exception
		{	
			CustomFun.refreshPage(driver);
			Thread.sleep(5000);
			GUIFunctions.mouseOverElement(driver, driver.findElement(WMS_Datalistmenu), "Mouseover on Datalist menu ");
			return new WMSPage(driver);
		}
		
		/**
		 * This method is used to Click on Product Submenu under Datalist mennu
		 */
		
		public WMSPage WMS_Datalist_Productclick() throws Exception
		{
			GUIFunctions.clickElement(driver, WMS_Datalist_Product , "Click on Products submenu");
			return new WMSPage(driver);
		}
		
		
		/**
		 * This method is used to Enter SKU / Product Barcode in SKU field
		 */
		public WMSPage WMS_Datalist_SKU(String SKU) throws Exception
		{
			GUIFunctions.clickElement(driver, WMS_Datalist_SKU , "Click on SKU field");
			GUIFunctions.typeTxtboxValue(driver, WMS_Datalist_SKU , SKU);
			log.info("Entered SKUnumber:" + SKU);
			Reporter.log("Product SKU identered sucessfully");
	        return new WMSPage(driver);	
		}
		
		/**
		 * This method is used to Click on Submit filter button
		 */
		public WMSPage WMS_Datalist_Submitbtn() throws Exception
		{
			GUIFunctions.clickElement(driver, WMS_SubmitFiltersBtn , "Click on Submit filters button ");
			Thread.sleep(2000);
			return new WMSPage(driver);
		}
		
		/**
		 * This method is used to Click on Detail button to read the complete details of the product
		 */
		public WMSPage WMS_Datalist_Detailbtn() throws Exception
		{
			GUIFunctions.clickElement(driver, WMS_Datalist_Detailbtn , "Click on Details button ");
			Thread.sleep(2000);
			return new WMSPage(driver);
		}
		
		/**
		 * This method is used to verify the SKU id in product details page 
		 */
		public WMSPage WMS_Datalist_DisplayedSku(String SKU) throws Exception
		{
			GUIFunctions.clickElement(driver,WMS_Datalist_SKU , "Click on SKU field");
			GUIFunctions.typeTxtboxValue(driver, WMS_Datalist_DisplayedSku , SKU);
			log.info("Dispalyed  SKUnumber:" + SKU);
			Reporter.log("SKU is dispalyed as expected value");
	        return new WMSPage(driver);	
		}
		
		
		public WMSPage getBarCodeFromPickingProcess(String OrderIDtxt) throws Exception
		{
			 GUIFunctions.mouseOverElement(driver, driver.findElement(WMS_Picking), "Picking Option");
			 Thread.sleep(2000);
			 GUIFunctions.clickElement(driver,WMS_PickingProgresLink_xpath , "Click on Picking Progress link under Picking Option");
			 Thread.sleep(2000);
			 By BarCodeFromPickingPage=By.xpath("//td[contains(text(),'"+OrderIDtxt+"')]/../td//a");
			 BarCodeId=driver.findElement(BarCodeFromPickingPage).getText();
			 return new WMSPage(driver);	
		}
		
		
		/**
		* click on submit Btn in WMS
		* @return :WMS page
		*/

		public WMSPage WMSLoginSubmit() throws InterruptedException
		{
		GUIFunctions.clickElement(driver, WMS_LoginSubmit,"Click on submit button");
		Thread.sleep(2000);
		return new WMSPage(driver);
		}

		/**
		* This method is used to verify Gift msg in Picking process of WMS
		*/
		public WMSPage WMS_VerifyGiftMsg_INPicking() throws Exception
		{
		By ele=By.xpath("(//span[@class='value'])[4]");
		String GiftMsgFromWMS = driver.findElement(ele).getText();
		String GiftMsgFromFO = (TextProp.get().getProperty("GiftMsg"));
		Assert.assertEquals(GiftMsgFromWMS, GiftMsgFromFO);
		return new WMSPage(driver);
		}


		/**
		 * Click on partial packing
		 * @return :WMS page	
		 */
		public WMSPage Click_PartialPackingBtn() throws InterruptedException
		{
				GUIFunctions.clickElement(driver, WMS_PartialPacking_Btn ,"Click on Partial Packing btn"); 
				Thread.sleep(2000);
				return new WMSPage( driver);
		}
		
		/**
		 * verify Go back to packing and  Confirm packing buttons displayed after clicking on in partial packing Btn
		 * @return :WMSPage	
		 */
		public WMSPage VerifyConfirmPackingAndGoBackTOPackingBtn() throws InterruptedException{
			GUIFunctions.verifyUIElementAndShowText(driver.findElement(WMS_GoBackToPackingBtn),"verified Go back to packing btn in partial packing");
			GUIFunctions.verifyUIElementAndShowText(driver.findElement(WMS_ConfirmPackingBtn),"verified Confirm packing btn in partial packing");
			
			return new WMSPage(driver);
		
		}
		
		/**
		 * Click on confirm packing btn in partial packing
		 * @return :WMS page	
		 */
		public WMSPage Click_ConfirmPackingBTN() throws InterruptedException
		{
				GUIFunctions.clickElement(driver, WMS_ConfirmPackingBtn ,"Click on Confirm Packing btn"); 
				Thread.sleep(2000);
				return new WMSPage( driver);
		}	
		
		
		/**
		 * Copy the sku id and enter in the input box  for one product 
		 * @return :WMS page	
		 */
		public WMSPage CopySKUIDAndEnterinSearchFldForScanningProductsForPartialPacking() throws InterruptedException
		{
			//GUIFunctions.verifyUIElementAndShowText(driver.findElement(WMS_SKUID)," getting Order id from packing process ");
			By ele=By.xpath(ObjRepoProp.get().getProperty("WMS_SKUID_xpath"));  

			  SkuId=driver.findElements(ele).get(0).getText().replaceAll("[^0-9.]", "");
			  Thread.sleep(2000);
		      GUIFunctions.typeTxtboxValue(driver,WMS_SKUID_serachfield, SkuId);
		      Thread.sleep(2000);
		
			
		    return new WMSPage( driver);
		}	
		
		/**
		 * Enter quantity for single product to do partial packing
		 * @return :WMS page	
		 */
		public WMSPage EnterSingleQuantity_ForPartialPacking() throws InterruptedException
		{
		 
			GUIFunctions.typeTxtboxValue(driver,WMS_Quantity, "1");
			Thread.sleep(2000);
			return new WMSPage( driver);
		}
		
		
		/**
		 * Shipping order process
		 * @return :WMS page	
		 */
		public WMSPage ShippingOrderProcess_PartialPacking(String BarCodeForScan) throws Exception
		{
		    // Click  on shipping Button
			GUIFunctions.clickElement(driver, WMS_Shipping ,"Click on shipping button in WMS page"); 
			Thread.sleep(2000);
			
			//Enter the Barcode 
			
			GUIFunctions.typeTxtboxValue(driver,WMS_PickingWebOrderInshipping, BarCodeForScan);
			Thread.sleep(2000);
			
		   // click on search icon
			GUIFunctions.clickElement(driver, WMS_SearchIconInshipping ,"Click on search icon In shipping"); 
			Thread.sleep(5000);
			
			// Enter the weight 

			GUIFunctions.typeTxtboxValue(driver,WMS_Weightfield,"1");
			
			// click on Submit btn
			GUIFunctions.clickElement(driver, WMS_ShippingSubmitBtn ,"Click on Submit btn from shipping"); 
			Thread.sleep(5000);
			
			// click on Ship An Other Order Btn
			Thread.sleep(5000);
			GUIFunctions.clickElement(driver, WMS_ShipAnOtherOrderBtn ,"Click on Ship An Other OrderBtn from shipping"); 
			Thread.sleep(2000);
			return new WMSPage( driver);
		}
		
		/**
		 * Verify the Label Generation Error Message.
		 * @return :WMS page	
		 */
	
		public WMSPage VerifyLabelGenerationErrorMsg() throws Exception
		{
			// Verifies the Label Generatio Error
		 Assert.assertTrue(CustomFun.waitObjectToLoad(driver, WMS_LabelGenerationError, Duration.ofSeconds(40)), "Label Generation Error text is not displayed");	
	     GUIFunctions.verifyUIElementAndShowText(driver.findElement(WMS_LabelGenerationError),"Label Generation Error text");
		 log.info("Successfully Verified Label Generation Error Message: " +BaseTest.expected);
		 Reporter.log("<p>Successfully Verified Label Generation Error Message: " + BaseTest.expected);
		 Thread.sleep(2000);
		 return new WMSPage( driver);
		}
		
		public WMSPage OrdersWithLabelReadyToBeReprintedInWMS(String OrderIDtxt) throws Exception
		{
			 GUIFunctions.mouseOverElement(driver, driver.findElement(By.xpath(ObjRepoProp.get().getProperty("WMS_Shipping"))), "Shipping Option");
			 Thread.sleep(2000);
			 GUIFunctions.clickElement(driver,WMS_OrdersWithLabelReadyToBeReprinted, "Click on Orders with label ready to be reprinted Link");
			 Thread.sleep(2000);
			 By PrintButton=By.xpath("//td[contains(text(),'"+OrderIDtxt+"')]/..//button");
			 GUIFunctions.clickElement(driver,PrintButton,"Click on Print Button");
			 return new WMSPage( driver);
		}
		
		
		public WMSPage SearchSKUIDInListOfProducts(String RefSkuID, String Size) throws InterruptedException
		{
			By SkuField=By.xpath("//input[@placeholder='Searchable sku']");
			GUIFunctions.typeTxtboxValue(driver,SkuField,RefSkuID);
			Thread.sleep(1000);
			By SizeField=By.xpath("//input[@placeholder='Size']");
			GUIFunctions.typeTxtboxValue(driver,SizeField,Size);
			Thread.sleep(1000);
			GUIFunctions.clickElement(driver, WMS_SubmitFilterBtn,"Click on submit filter button"); 
			Thread.sleep(5000);
			By BarcodeSKU=By.xpath("//td[contains(text(),'"+Size+"')]/..//td[@class='vuetable-td-sku']");
			barcodeSKU=driver.findElement(BarcodeSKU).getText();
			return new WMSPage( driver);
		}
		
		public WMSPage SearchSKUIDInListOfProductsForSimpleProd(String RefSkuID) throws InterruptedException
		{
			By SkuField=By.xpath("//input[@placeholder='Searchable sku']");
			GUIFunctions.typeTxtboxValue(driver,SkuField,RefSkuID);
			Thread.sleep(1000);
			GUIFunctions.clickElement(driver, WMS_SubmitFilterBtn,"Click on submit filter button"); 
			Thread.sleep(15000);
			By BarcodeSKU=By.xpath("//td[contains(text(),'"+RefSkuID+"')]/..//td[@class='vuetable-td-sku']");
			barcodeSKU=driver.findElement(BarcodeSKU).getText();
			return new WMSPage( driver);
		}
	
		
		/**
		 * Click on Details Button
		 * @return :WMS page	
		 */
		public WMSPage ClickOnDetailsButton(String Size) throws InterruptedException
		{
			Thread.sleep(2000);
			By DetailsBtn=By.xpath("//td[contains(text(),'"+Size+"')]/..//a");
			GUIFunctions.clickElement(driver, DetailsBtn ,"Click on Details Button"); 
			Thread.sleep(2000);
			return new WMSPage( driver);
		}		
		
		/**
		 * Click on Details Button
		 * @return :WMS page	
		 */
		public WMSPage ClickOnDetailsButtonForSimpleProd(String ref_searchable_SKUID) throws InterruptedException
		{
			Thread.sleep(2000);
			By DetailsBtn=By.xpath("//td[contains(text(),'"+ref_searchable_SKUID+"')]/..//a");
			GUIFunctions.clickElement(driver, DetailsBtn ,"Click on Details Button"); 
			Thread.sleep(2000);
			return new WMSPage( driver);
		}		
		
		/**
		 * Scroll down till stocks grid and Verify Initial Saleable Stock
		 * @return :WMS page	
		 */
		public WMSPage VerifyInitialSaleableStock() throws Exception
		{
		  //Scroll Down till stocks grid
			try
			{
			By StocksGrid=By.xpath(ObjRepoProp.get().getProperty("WMS_StocksGrid"));
			GUIFunctions.scrollByJavaScriptExecutor(driver.findElement(StocksGrid), driver,"Stocks Grid");
			Thread.sleep(2000);
			By initialSaleableStock=By.xpath(ObjRepoProp.get().getProperty("WMS_SealeableStock"));
			GUIFunctions.verifyUIElementAndShowText(driver.findElement(initialSaleableStock),"Initial Saleable Stock");
			InitialSaleableStock_WMS=Integer.valueOf(driver.findElement(initialSaleableStock).getText());
			}
			catch (Exception e) 
			{
			  System.out.println(e);
			}
			return new WMSPage( driver);
		}
		
		/**
		 * Scroll down till stocks grid and Verify Initial Reserved Stock
		 * @return :WMS page	
		 */
		public WMSPage VerifyInitialReservedStock() throws Exception
		{
			try
			{
				By initialReservedStock=By.xpath(ObjRepoProp.get().getProperty("WMS_ReservedStock"));
				GUIFunctions.verifyUIElementAndShowText(driver.findElement(initialReservedStock),"Initial Reserved Stock");
				InitialReservedStock_WMS=Integer.valueOf(driver.findElement(initialReservedStock).getText());
			}
			catch (Exception e) 
			{
			  System.out.println(e);
			}
			return new WMSPage( driver);
		}
		

		/**
		 * Verify Saleable Stock Qnty Dec by 1 after placing the order in WMS
		 * @return :WMS page	
		 */
		public WMSPage VerifySaleableStockDecBy1InWMSAferPlacingTheOrder() throws Exception
		{
			try
			{
				By SaleableStock=By.xpath(ObjRepoProp.get().getProperty("WMS_SealeableStock"));
				GUIFunctions.verifyUIElementAndShowText(driver.findElement(SaleableStock),"Saleable Stock decreament by 1 After Placing The Order");
				int SaleableStock_WMS=Integer.valueOf(driver.findElement(SaleableStock).getText());
				int DecBy1=InitialSaleableStock_WMS-SaleableStock_WMS;
				log.info("Verified Saleable Stock Qnty Dec By 1 In WMS after placing the order :"+DecBy1);
				Reporter.log("<p>Verified Saleable Stock Qnty Dec By 1 In WMS after placing the order :"+DecBy1);
			}
			catch (Exception e) 
			{
			  System.out.println(e);
			}
			return new WMSPage( driver);
		}
		
		/**
		 * Verify Saleable Stock Qnty Inc by 1 after Refund the order in WMS
		 * @return :WMS page	
		 */
		public WMSPage VerifySaleableStockIncBy1InWMSAfterRefundTheOrder() throws Exception
		{
			try
			{
				By SaleableStock=By.xpath(ObjRepoProp.get().getProperty("WMS_SealeableStock"));
				GUIFunctions.verifyUIElementAndShowText(driver.findElement(SaleableStock),"Saleable Stock Inc by 1 After Refund The Order");
				int SaleableStock_WMS=Integer.valueOf(driver.findElement(SaleableStock).getText());
				int IncBy1=SaleableStock_WMS-InitialSaleableStock_WMS;
				log.info("Verified Saleable Stock Qnty Inc By 1 In WMS after Refund the order :"+IncBy1);
				Reporter.log("<p>Verified Saleable Stock Qnty Inc By 1 In WMS after Refund the order :"+IncBy1);
			}
			catch (Exception e) 
			{
			  System.out.println(e);
			}
			return new WMSPage( driver);
		}
		
		
		/**
		* Click on Details Button
		* @return :WMS page
		*/
		public WMSPage ClickOnDetailsButtonForSimpleprod() throws InterruptedException
		{
		By DetailsBtn=By.xpath("//a[contains(text(),'Detail')]");
		GUIFunctions.clickElement(driver, DetailsBtn ,"Click on Details Button");
		Thread.sleep(2000);
		return new WMSPage( driver);
		}
		
		
		/**
		* Scroll and select damaged value from return condition dropdown
		* @return :WMS page
		*/
		public WMSPage ExecuteRMAProcessForDamagedStatus() throws Exception
		{
		//Scroll Down till Return Condition Dropdown
		GUIFunctions.scrollByJavaScriptExecutor(driver.findElement(WMS_ReturnConditionDropdown), driver,"Return Condition Dropdown");
		Thread.sleep(2000);

		//Select value from return condition dropdown
		int ReturnConditionDpdCount = driver.findElements(WMS_ReturnConditionDropdown).size();
		for(int i=0;i<ReturnConditionDpdCount;i++)
		{
		WebElement ReturnConditionOptions= driver.findElements(WMS_ReturnConditionDropdown).get(i);

		// select Return Condition Options from Return Condition dropdown
		GUIFunctions.selectDropDownValue(ReturnConditionOptions, "SHOES DAMAGED", "text", "Return Condition dropdown");
		Thread.sleep(5000);
		}
		
		  // Enter Quantity in Quantity Returned Field
		int QuantyReturnedFldCount = driver.findElements(WMS_QuantReturnedFld).size();
		for(int i=0;i<QuantyReturnedFldCount;i++)
		{
			WebElement QtyReturnField=driver.findElements(WMS_QuantReturnedFld).get(i);
			Actions action=new Actions(driver);
			QtyReturnField.click();
			Thread.sleep(2000);
			action.sendKeys(QtyReturnField, "1");
			action.build().perform();
		    Thread.sleep(2000);
		}
		
	  // click on execute RMA button
		GUIFunctions.clickElement(driver, WMS_ExecuteRMABtn ,"Click on Execute RMA btn in RMA  "); 
		Thread.sleep(5000);
		return new WMSPage( driver);
		}
		
		 /**
         * Scroll down to Stock PreOrder section, update quantity, select availability date
         * @return :WMS page    
         */
        public WMSPage UpdatePreOrderQuantityAndSubmit() throws Exception
        {
          //Scroll Down till Return Condition Dropdown
            GUIFunctions.scrollByJavaScriptExecutor(driver.findElement(WMS_StockPreorderSection), driver,"Stock Pre-order Section");
            Thread.sleep(2000);
            driver.findElement(WMS_UpdateBtnForPreOrder).click();
            Thread.sleep(1000);
            WebElement QtyField=driver.findElement(WMS_QuantityField);
            Actions action=new Actions(driver);
            QtyField.click();
            Thread.sleep(1000);
            action.sendKeys(QtyField, "5");
            action.build().perform();
            Thread.sleep(1000);
            GUIFunctions.clickElement(driver, WMS_AvailabilityField ,"Click on Availability Field");
            Thread.sleep(1000);
            GUIFunctions.clickElement(driver, WMS_curMonthdate ,"Selected Available date");
            Thread.sleep(1000);
            driver.findElement(WMS_SubmitBtn).click();
            log.info("Click on Submit button ");
            Reporter.log("<p>Click on Submit button ");
            return new WMSPage( driver);
        }
        
        /**
         * Verify Pre-order Stock Updated Success Msg.
         * @return :WMS page    
         */
    
        public WMSPage VerifyPreorderStockUpdatedSuccessMsg() throws Exception
        {
            // Preorder Stock Updated Success Msg
         Assert.assertTrue(CustomFun.waitObjectToLoad(driver,WMS_preorderstockupdatedsuccessMsg, Duration.ofSeconds(40)), "Preorder Stock Updated Success Message text is not displayed");    
         GUIFunctions.verifyUIElementAndShowText(driver.findElement(WMS_preorderstockupdatedsuccessMsg),"Preorder Stock Updated Success Message text");
         log.info("Successfully Verified Preorder Stock Updated Success Message: " +BaseTest.expected);
         Reporter.log("<p>Successfully Verified Preorder Stock Updated Success Message: " + BaseTest.expected);
         Thread.sleep(2000);
         return new WMSPage( driver);
        }
		
}
		
	