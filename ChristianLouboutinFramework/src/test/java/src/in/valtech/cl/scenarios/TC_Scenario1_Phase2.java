package src.in.valtech.cl.scenarios;
import org.apache.log4j.Logger;    
import org.openqa.selenium.By;
import org.testng.Reporter;
import org.testng.annotations.Test;
import static src.in.valtech.util.PropertyFileReader.ObjRepoProp;
import src.in.valtech.cl.back.pages.BackOfficePage;
import src.in.valtech.cl.front.pages.HomePage;
import src.in.valtech.config.BaseTest;
import src.in.valtech.custom.CustomFun;
import src.in.valtech.uifunctions.GUIFunctions;

  /**
	 * 
	 * @author Gopalaswamy
	 * 
	 *  **/

	public class TC_Scenario1_Phase2 extends BaseTest
	{

		public Logger log = Logger.getLogger(this.getClass().getName());
		
		BackOfficePage backofficepage;
		HomePage homepage;

		
		@Test(description="Open the browser and navigate to magento" ,priority=01)
		public void step01_naviagteToBO_URL() throws Exception
		{
		   logtest("Create the root category and sub category and verify in FO.");
		   backofficepage = BackOfficePage.navigateToBOApplication_URL(driver.get(), CustomFun.getBODSDetails().get().getBO_URL());
		   log.info("Successfully opened the Magento backend url \n");
		   Reporter.log("<p>Successfully opened the Magento backend url ");
		   System.out.println("step 1 end");
		}
		
		 @Test(description="Entered Username in Username Field", priority=02)
		 public void step02_EnteredUsernameField() throws Exception
		 {
		    backofficepage.EnterUsername(CustomFun.getBODSDetails().get().getBO_Username());
		    log.info("Entered user name \n");
			Reporter.log("<p>Entered user name ");
			System.out.println("step 2 end");
		 }
		    
		 @Test(description="Entered Password in Password Field", priority=03)
		 public void step03_EnteredPasswordField() throws Exception
		 {
		    backofficepage.EnterPassword(CustomFun.getBODSDetails().get().getBO_Password());
		    log.info("Entered password \n");
			Reporter.log("<p>Entered password ");
			System.out.println("step 3 end");
		 }
		    
		 @Test(description="Click on SignIn Button", priority=04)
		 public void step04_ClickOnSignInButton() throws Exception
		 {
		     backofficepage.SignbtnClick();
		     CustomFun.waitForPageLoaded(backofficepage.driver);
		     if(environmentName.contains("IntegrationEnv") | environmentName.contains("HomoEnv1") | environmentName.contains("StagingEnv") | environmentName.contains("Integration6Env"))
			    {
					Thread.sleep(5000);
					CustomFun.refreshPage(backofficepage.driver);
					Thread.sleep(5000);
				}
			 log.info("User is Signed In \n");
		     Reporter.log("<p>User is Signed in");
			 System.out.println("step 4 end");
		 }
		    
		 @Test(description="Verified Dashboard Header & check whether user is in Dashboard page", priority=05)
		 public void step05_VerifiedDashboardHeaderInBO() throws Exception
		 {
		      backofficepage.VerifyDashboardHeader();
		      log.info("Dashboard page displays \n");
			  Reporter.log("<p>Dashboard page displays");
			  System.out.println("step 5 end");
		 }
		    
		 @Test(description="Click on Catalog Icon", priority=06)
		 public void step06_ClickOnCatalogIcon() throws Exception
		 {
		       backofficepage.CatalogIconClick();
			   System.out.println("step 6 end");
		 }
		 
		 @Test(description="Click on Category Sub menu option", priority=07)
		 public void step07_ClickOnCategorySubMenu() throws Exception
		 {
		       backofficepage.bo_CategoryMenu();
			   System.out.println("step 7 end");
		 }
		 
		 @Test(description="Click on Add root category", priority=8)
		 public void step08_ClickOnAddRootCategoryBtn() throws Exception
		 {
			   backofficepage.bo_AddRootCategory();
			   System.out.println("step 8 end");
		 }
		 @Test(description="Verify Page sections in category page", priority=9)
		 public void step09_VerifyCategoryPageFields() throws Exception
		 {
			   backofficepage.bo_verifyCategoryPageFields();
				log.info("Successfully Verified page elements in the new category page \n");
				Reporter.log("<p>Successfully Verified page elements in the new category page");
			   System.out.println("step 9 end");
		 }  
		 
		 @Test(description="Click on save button", priority=10)
		 public void step10_ClickOnSaveBtn() throws Exception
		 {
	           backofficepage.bo_SaveBtn();
			   System.out.println("step 10 end");
		 }
		 
		 @Test(description="verify error message", priority=11)
		 public void step11_verifyErrorMsg() throws Exception
		 {
	           backofficepage.bo_RootCategoryErrorMsg();
			   System.out.println("step 11 end");
		 }
		 
		 @Test(description="Enter the category name", priority=12)
		 public void step12_enterRootCategoryName() throws Exception
		 {
		       backofficepage.bo_RootCategoryName("AutomationRootCat1");
			   System.out.println("step 12 end");
		 }
		 
		 @Test(description="Click on save button", priority=13)
		 public void step13_ClickOnSaveBtn() throws Exception
		 {
	           backofficepage.bo_SaveBtn();
			   System.out.println("step 13 end");
		 }
		 @Test(description="Drag and drop the root category", priority=14)
		 public void step14_DragAndDropRootCategory() throws Exception
		 {
               backofficepage.bo_DragandDropCategory();
			   System.out.println("step 14 end");
		 }
		 @Test(description="Click on save btn to close the warning popup", priority=15)
		 public void step15_ClickOnOkWarningPopup() throws Exception
		 {
               backofficepage.bo_warningOKBtn();
			   System.out.println("step 15 end");
		 }
		 @Test(description="Click on System menu option", priority=16)
		 public void step16_ClickOnSystemMenu() throws Exception
		 {
			 if(environmentName.contains("Integration6Env"))
	           {
	           backofficepage.ClickOnSystemIcon_INT6();
	           }
	           else
	           {
	        	   backofficepage.ClickOnSystemIcon(environmentName);
	           }
               
			   System.out.println("step 16 end");
		 }
		 @Test(description="Click on Cache Management Sub menu", priority=17)
		 public void step17_ClickOnCacheMngBtn() throws Exception
		 {
               backofficepage.bo_cacheManagementMenu();
			   System.out.println("step 17 end");
		 }
		 @Test(description="Click on Flush Category Cache button", priority=18)
		 public void step18_ClickOnFlushCategoryBtn() throws Exception
		 {
               backofficepage.bo_flushCategoryCache();
			   System.out.println("step 18 end");
		 }
		 @Test(description="Click on flush Magento Cache button", priority=19)
		 public void step19_ClickOnMagentoCacheBtn() throws Exception
		 {
               backofficepage.bo_flushMagentoCache();
			   System.out.println("step 19 end");
		 }
		 
		 @Test(description="Click on Catalog menu", priority=20)
		 public void step20_ClickOnCatalogMenu() throws Exception
		 {
			  backofficepage.CatalogIconClick();
			  System.out.println("step 20 end");
		 }
		 
		 @Test(description="Click on categories sub menu", priority=21)
		 public void step21_ClickOnCategorySubMenu() throws Exception
		 {
               backofficepage.bo_CategoryMenu();
			   System.out.println("step 21 end");
		 }
		 @Test(description="Click on created root category", priority=22)
		 public void step22_ClickOnCreatedRootCategory() throws Exception
		 {
              backofficepage.bo_CreatedRootCategory_Click("AutomationRootCat1");
			   System.out.println("step 22 end");
		 }
		 @Test(description="Scroll the page to top", priority=23)
		 public void step23_scrollToTopOfThePage() throws Exception
		 {
			   backofficepage.bo_scrollToTop();
			   System.out.println("step 23 end");
		 }
		 @Test(description="Click on Add sub category button", priority=24)
		 public void step24_ClickOnAddSUBCategory() throws Exception
		 {
               backofficepage.bo_addSubCategoryBtn_click();
			   System.out.println("step 24 end");
		 
		 }
		 @Test(description="Enter the sub category name", priority=25)
		 public void step25_enterSubCategoryname() throws Exception
		 {
               backofficepage.bo_SubCategoryName("AutomationSubCat1");
			   System.out.println("step 25 end");
		 
		 }
		 @Test(description="Click on save button", priority=26)
		 public void step26_ClickOnSaveBtn() throws Exception
		 {
	           backofficepage.bo_SaveBtn();
			   System.out.println("step 26 end");
		 }
		 @Test(description="Expand the Display Settings button", priority=27)
		 public void step27_expandDisplaySettings() throws Exception
		 {
	           backofficepage.bo_displaySettings_Click();
			   System.out.println("step 27 end");
		 }
		 @Test(description="Select the left menu option", priority=28)
		 public void step28_leftMenu_Click() throws Exception
		 {
	           backofficepage.bo_leftMenuExpand_Click();
			   System.out.println("step 28 end");
		 }
		 @Test(description="Click on save button", priority=29)
		 public void step29_ClickOnSaveBtn() throws Exception
		 {
	           backofficepage.bo_SaveBtn();
			   System.out.println("step 29 end");
		 }
		 @Test(description="Scroll the page to top", priority=30)
		 public void step30_scrollToTopOfThePage() throws Exception
		 {
			   backofficepage.bo_scrollToTop();
			   System.out.println("step 30 end");
		 }
		 @Test(description="Click on Stores option", priority=31)
		 public void step31_clickOnStores() throws Exception
		 {
			   backofficepage.bo_clickonStores();
			   System.out.println("step 31 end");
		 }
		 @Test(description="Select France Store", priority=32)
		 public void step32_selectStore() throws Exception
		 {
			    if(locale.get().contains("FR_FR"))
				{
				 backofficepage.driver.findElement(By.xpath(ObjRepoProp.get().getProperty("BO_scopeStore"))).click();
				 Thread.sleep(2000);
				}
				else
				if(locale.get().contains("UK_EN"))
				{
					backofficepage.driver.findElement(By.xpath(ObjRepoProp.get().getProperty("BO_UkStore"))).click();
					CustomFun.waitForPageLoaded(backofficepage.driver);
				}
				else
				{
					backofficepage.driver.findElement(By.xpath(ObjRepoProp.get().getProperty("BO_CHStore"))).click();
					CustomFun.waitForPageLoaded(backofficepage.driver);
				}
			   System.out.println("step 32 end");
		 }
		 @Test(description="Click on Ok Button to close the warning mesage", priority=33)
		 public void step33_clickOnOKBtn() throws Exception
		 {
			   backofficepage.bo_clickonOKBtn();
			   System.out.println("step 33 end");
		 }
		 @Test(description="Unselect the default value checkbox", priority=34)
		 public void step34_unselectCatCheckBox() throws Exception
		 {
			   backofficepage.bo_unselectCatCheckbox();
			   System.out.println("step 34 end");
		 }
		 @Test(description="Enter the updated category name", priority=35)
		 public void step35_enterUpdatedSubCatName() throws Exception
		 {
	            backofficepage.bo_UpdateSubCatName("AutomationSubCat1");
				System.out.println("step 35 end");
			 
		 }
		 @Test(description="Expand the SEO Section", priority=36)
		 public void step36_expandSEOSection() throws Exception
		 {
	            backofficepage.bo_ClickOnSEO();
				System.out.println("step 36 end");
			 
		 }
		 @Test(description="Unselect the URL Keydefault value checkbox", priority=37)
		 public void step37_unselectURLKeyCheckBox() throws Exception
		 {
			   backofficepage.bo_unselectURLKey();
			   System.out.println("step 37 end");
		 }
		 @Test(description="Update the URL data", priority=38)
		 public void step38_updateURLData() throws Exception
		 {
			   backofficepage.bo_urlName("AutomationSubCat1");
			   System.out.println("step 38 end");
		 }
		 @Test(description="Click on save button", priority=39)
		 public void step39_ClickOnSaveBtn() throws Exception
		 {
	           backofficepage.bo_SaveBtn();
			   System.out.println("step 39 end");
		 }
		 
		 @Test(description="Expand the DisplaySettings", priority=40)
		 public void step40_ClickOnDisplaySettings() throws Exception
		 {
			
			 backofficepage.bo_displaySettings_Click();
			   System.out.println("step 40 end");
		 }
		 
		 @Test(description="Verify the Segmentable Field", priority=41)
		 public void step41_verifySegmentableField() throws Exception
		 {
	           backofficepage.bo_verifySegmentableField();
			   System.out.println("step 41 end");
		 }
		 @Test(description="Click on System menu option", priority=42)
		 public void step42_ClickOnSystemMenu() throws Exception
		 {
			 if(environmentName.contains("Integration6Env"))
	           {
	           backofficepage.ClickOnSystemIcon_INT6();
	           }
	           else
	           {
	        	   backofficepage.ClickOnSystemIcon(environmentName);
	           }
			   System.out.println("step 42 end");
		 }
		 @Test(description="Click on Cache Management Sub menu", priority=43)
		 public void step43_ClickOnCacheMngBtn() throws Exception
		 {
               backofficepage.bo_cacheManagementMenu();
			   System.out.println("step 43 end");
		 }
		 @Test(description="Click on Flush Category Cache button", priority=44)
		 public void step44_ClickOnFlushCategoryBtn() throws Exception
		 {
               backofficepage.bo_flushCategoryCache();
			   System.out.println("step 44 end");
		 }
		 @Test(description="Click on flush Magento Cache button", priority=45)
		 public void step45_ClickOnMagentoCacheBtn() throws Exception
		 {
               backofficepage.bo_flushMagentoCache();
			   System.out.println("step 45 end");
		 }
		 
		 @Test(description="Click on Catalog menu", priority=46)
		 public void step46_ClickOnCatalogMenu() throws Exception
		 {
			  backofficepage.CatalogIconClick();
			  System.out.println("step 46 end");
		 }
		 @Test(description="Click on categories sub menu", priority=47)
		 public void step47_ClickOnCategorySubMenu() throws Exception
		 {
               backofficepage.bo_CategoryMenu();
			   System.out.println("step 47 end");
		 }
		 @Test(description="Click on Stores option", priority=48)
		 public void step48_clickOnStores() throws Exception
		 {
			  GUIFunctions.pageScrollToTopOfPage(backofficepage.driver);
			  backofficepage.bo_clickonStores();
			   System.out.println("step 48 end");
		 }
		 @Test(description="Select Store", priority=49)
		 public void step49_selectStore() throws Exception
		 {
			    if(locale.get().contains("FR_FR"))
				{
				 backofficepage.driver.findElement(By.xpath(ObjRepoProp.get().getProperty("BO_scopeStore"))).click();
				 Thread.sleep(2000);
				}
				else
				if(locale.get().contains("UK_EN"))
				{
					backofficepage.driver.findElement(By.xpath(ObjRepoProp.get().getProperty("BO_UkStore"))).click();
					CustomFun.waitForPageLoaded(backofficepage.driver);
				}
				else
				{
					backofficepage.driver.findElement(By.xpath(ObjRepoProp.get().getProperty("BO_CHStore"))).click();
					CustomFun.waitForPageLoaded(backofficepage.driver);
				}
			   System.out.println("step 49 end");
		 }
		 @Test(description="Click on Ok Button to close the warning mesage", priority=50)
		 public void step50_clickOnOKBtn() throws Exception
		 {
			   backofficepage.bo_clickonOKBtn();
			   System.out.println("step 50 end");
		 }
		 @Test(description="Click on expand all", priority=51)
		 public void step51_ClickOnExpandAll() throws Exception
		 {
              backofficepage.bo_clickExpandAll();
			   System.out.println("step 51 end");
		 }
		 @Test(description="Click on created subcategory", priority=52)
		 public void step52_ClickOnCreatedSubCategory() throws Exception
		 {
              GUIFunctions.pageScrollTobottomOfPage(backofficepage.driver);
			 backofficepage.bo_clickOnCreatedSubCategory("AutomationSubCat1");
			   System.out.println("step 52 end");
		 }
		 @Test(description="Click on products in category", priority=53)
		 public void step53_clickOnProductsInCategory() throws Exception
		 {
			   backofficepage.bo_expandProductsInCategory();
			   System.out.println("step 53 end");
		 }
		 @Test(description="Click on Add product", priority=54)
		 public void step54_clickOnAddProduct() throws Exception
		 {
			   backofficepage.bo_clickOnAddProducts();
			   System.out.println("step 54 end");
		 }
		 @Test(description="Click on Add product by SKU tab", priority=55)
		 public void step55_clickOnAddProductBySKUTab() throws Exception
		 {
			   backofficepage.bo_addProdBySKUTab_click();
			   System.out.println("step 55 end");
		 }
		 @Test(description="Enter the products in text area", priority=56)
		 public void step56_enterProductSKU() throws Exception
		 {
			   backofficepage.bo_enterProductSku1("8435415051323", "3615485023719");
			   System.out.println("step 56 end");
		 }
		 
		 @Test(description="Click on Assign button", priority=58)
		 public void step58_clickOnAssignBtn() throws Exception
		 {
			   backofficepage.bo_clickOnAssignBtn();
			   System.out.println("step 58 end");
		 }
		 
		 @Test(description="Click on save and close button", priority=59)
		 public void step59_clickOnSaveandCloseBtn() throws Exception
		 {
			   backofficepage.bo_clickOnSaveAndCloseBtn();
			   CustomFun.waitForPageLoaded(backofficepage.driver);
			   System.out.println("step 59 end");
		 }
		 
		 
		 @Test(description="Click on Add product", priority=60)
		 public void step60_clickOnAddProduct() throws Exception
		 {
			   backofficepage.bo_clickOnAddProducts();
			   System.out.println("step 60 end");
		 }
		 @Test(description="Click on search all products tab", priority=61)
		 public void step61_clickOnSearchAllProdstab() throws Exception
		 {
			   backofficepage.bo_searchAllProds_click();
			   System.out.println("step 61 end");
		 }
		 

		 @Test(description="Click on Merch Filter button", priority=62)
		 public void step62_clickOnMerchFilter() throws Exception
		 {
			   backofficepage.bo_clickOnMerchFilter();
			   System.out.println("step 62 end");
		 }
		 @Test(description="Enter the From value", priority=63)
		 public void step63_enterFromValue() throws Exception
		 {
			   backofficepage.bo_enterFromValue("100");
			   System.out.println("step 63 end");
		 }
		 @Test(description="Enter To value", priority=64)
		 public void step64_enterToValue() throws Exception
		 {
			   backofficepage.bo_enterToValue("200");
			   System.out.println("step 64 end");
		 }
		 @Test(description="Click on apply filter button", priority=65)
		 public void step65_clickOnApplyFilter() throws Exception
		 {
			   backofficepage.bo_clickOnApplyFilter();
			   System.out.println("step 65 end");
		 }
		 @Test(description="Select products", priority=66)
		 public void step66_selectProducts() throws Exception
		 {
			   backofficepage.bo_selectProducts();
			   System.out.println("step 66 end");
		 }
		 @Test(description="Click on save and close button", priority=67)
		 public void step67_clickOnApplyFilter() throws Exception
		 {
			   backofficepage.bo_clickOnSaveAndCloseBtn();
			   System.out.println("step 67 end");
		 }
		 @Test(description="Click on merch tile view", priority=68)
		 public void step68_clickOnMerchTileView() throws Exception
		 {
			   backofficepage.bo_clickOnMerchTileView();
			   System.out.println("step 68 end");
		 }
		 @Test(description="Click on product tile view", priority=69)
		 public void step69_clickOnProductTileView() throws Exception
		 {
			   backofficepage.bo_clickOnProductTileView();
			   System.out.println("step 69 end");
		 }
		 @Test(description="select the products checkbox in merch pool area", priority=70)
		 public void step70_selectProductsCheckBox() throws Exception
		 {
			   backofficepage.bo_selectProductsInMerchPool();
			   Thread.sleep(3000);
			   System.out.println("step 70 end");
		 }
		 @Test(description="Drag and drop the products", priority=71)
		 public void step71_dragAndDropProducts() throws Exception
		 {
			 backofficepage.bo_DragandDropProduct();
			 Thread.sleep(3000);
			 System.out.println("step 71 end");
		 }
		 @Test(description="seelct one product in product pool area", priority=72)
		 public void step72_selectProductinPPool() throws Exception
		 {
               backofficepage.bo_selectProdInProdPool();
			   System.out.println("step 72 end");
		 }
		 @Test(description="Click on cross icon", priority=73)
		 public void step73_ClickOnCrossIcon() throws Exception
		 {
               backofficepage.bo_deleteProdInProdPool();
			   System.out.println("step 73 end");
		 }
		 @Test(description="Chnage the product position", priority=74)
		 public void step74_ChangeProductPosition() throws Exception
		 {
               backofficepage.bo_DragandDropProdsInPool();
			   System.out.println("step 74 end");
		 }
		 
		 @Test(description="Click on save button", priority=75)
		 public void step75_ClickOnSaveBtn() throws Exception
		 {
	           backofficepage.bo_SaveBtn();
			   System.out.println("step 75 end");
		 }
		 @Test(description="Click on System menu option", priority=76)
		 public void step76_ClickOnSystemMenu() throws Exception
		 {
			 if(environmentName.contains("Integration6Env"))
	           {
	           backofficepage.ClickOnSystemIcon_INT6();
	           }
	           else
	           {
	        	   backofficepage.ClickOnSystemIcon(environmentName);
	           }
			   System.out.println("step 76 end");
		 }
		 
		@Test(description="Click on Cache Management Sub menu", priority=83)
		 public void step83_ClickOnCacheMngBtn() throws Exception
		 {
               backofficepage.bo_cacheManagementMenu();
			   System.out.println("step 83 end");
		 }
		 @Test(description="Click on Flush Category Cache button", priority=84)
		 public void step84_ClickOnFlushCategoryBtn() throws Exception
		 {
               backofficepage.bo_flushCategoryCache();
			   System.out.println("step 84 end");
		 }
		 
		 @Test(description="Click on flush Magento Cache button", priority=85)
		 public void step85_ClickOnMagentoCacheBtn() throws Exception
		 {
               backofficepage.bo_flushMagentoCache();
			   System.out.println("step 85 end");
		 }
		 
		@Test(description="Open new tab and navigate to FE url", priority=86)
		 public void step86_openNewTabandaccessFE() throws Exception
		 {
			   homepage=new HomePage(backofficepage.driver);
		       CustomFun.OpenNewTabAndSwitchToNewTab(homepage.driver, "1");
		       HomePage.navigateToCLApplication_URL(driver.get(), baseUrl.get());
			   System.out.println("step 86 end");
		 }
		
		@Test(description="Verify created category is dispalyed or not", priority=87)
        public void step87_verifyCreatedCatOnFE() throws Exception
        {
              backofficepage.bo_verifyCreatedSubCatOnFE();
              System.out.println("step 87 end and created root, Sub category is dispalyed on FE");
        }
		
		 @Test(description="Click on created sub category", priority=88)
		 public void step88_clickOnCreatedCategory() throws Exception
		 {
			 backofficepage.bo_createdSubCat_Click("AutomationRootCat1","AutomationSubCat1");
        	 System.out.println("step 88 end");
		 }
		 @Test(description="verfiy products in category page", priority=89)
		 public void step89_verofyProductsInCat() throws Exception
		 {
			   backofficepage.bo_verifyProductsOnFE();
        	   System.out.println("step 89 end");
		 }
		
		 @Test(description="Click on Catalog menu", priority=90)
		 public void step90_ClickOnCatalogMenu() throws Exception
		 {
			   backofficepage=new BackOfficePage(homepage.driver);
			   CustomFun.SwitchToSpecificTab(backofficepage.driver, "0");
			   backofficepage.CatalogIconClick();
			   System.out.println("step 90 end");
		 }
		 @Test(description="Click on categories sub menu", priority=91)
		 public void step91_ClickOnCategorySubMenu() throws Exception
		 {
               backofficepage.bo_CategoryMenu();
			   System.out.println("step 91 end");
		 } 
		 @Test(description="Click on Stores option", priority=92)
		 public void step92_clickOnStores() throws Exception
		 {
			  GUIFunctions.pageScrollToTopOfPage(backofficepage.driver);
			  backofficepage.bo_clickonStores();
			   System.out.println("step 92 end");
		 }
		 @Test(description="Select France Store", priority=93)
		 public void step93_selectFrenchStore() throws Exception
		 {
			   backofficepage.bo_clickonFranceStore();
			   System.out.println("step 93 end");
		 }
		 @Test(description="Click on Ok Button to close the warning mesage", priority=94)
		 public void step94_clickOnOKBtn() throws Exception
		 {
			   backofficepage.bo_clickonOKBtn();
			   System.out.println("step 94 end");
		 }
		 @Test(description="Click on expand all", priority=95)
		 public void step95_ClickOnExpandAll() throws Exception
		 {
              backofficepage.bo_clickExpandAll();
			   System.out.println("step 95 end");
		 }
		 @Test(description="Click on created subcategory", priority=96)
		 public void step96_ClickOnCreatedSubCategory() throws Exception
		 {
              GUIFunctions.pageScrollTobottomOfPage(backofficepage.driver);
			 backofficepage.bo_clickOnCreatedSubCategory("AutomationSubCat1");
			   System.out.println("step 96 end");
		 }

		 @Test(description="Click on delete subcategory", priority=97)
		 public void step97_ClickOnDeleteSubCategory() throws Exception
		 {
              backofficepage.bo_clickOnDeleteCat();
			   System.out.println("step 97 end an subcategory has been deleted");
		 }
		 
		 @Test(description="Click on ok btn", priority=98)
		 public void step98_ClickOnOkBtn() throws Exception
		 {
              backofficepage.bo_clickonOKBtn();
			   System.out.println("step 98 end");
		 }
		 @Test(description="Click on delete rootcategory", priority=99)
		 public void step99_ClickOnDeleteRootCategory() throws Exception
		 {
              backofficepage.bo_clickOnDeleteCat();
			   System.out.println("step 99 end and root category has been deleted");
		 }
		 @Test(description="Click on ok btn", priority=100)
		 public void step100_ClickOnOkBtn() throws Exception
		 {
              backofficepage.bo_clickonOKBtn();
			   System.out.println("step 100 end");
			   		   
			   if(environmentName.contains("Integration6Env"))
	           {
	           backofficepage.ClickOnSystemIcon_INT6();
	           }
	           else
	           {
	        	   backofficepage.ClickOnSystemIcon(environmentName);
	           }
			   backofficepage.bo_cacheManagementMenu();
			   backofficepage.bo_flushCategoryCache();
			   backofficepage.bo_flushMagentoCache();
			   
		 }
		 
		 
		 
		 @Test(description="Click on account icon", priority=101)
		 public void step101_ClickOnAcountIcon() throws Exception
		 {
              backofficepage.bo_clickOnAccountIcon();
			   System.out.println("step 101 end");
		 }
		 @Test(description="Click on signout option", priority=102)
		 public void step102_ClickOnSignOut() throws Exception
		 {
              backofficepage.bo_clickOnSignOutOption();
			   System.out.println("step 102 end");
		 } 
		
}