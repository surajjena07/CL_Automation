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
	 * @author Gopalaswamy
	  **/

public class TC_Scenario4_Phase2 extends BaseTest

{

	public Logger log = Logger.getLogger(this.getClass().getName());
	
	BackOfficePage backofficepage;
	HomePage homepage;

	
	@Test(description="Open the browser and navigate to magento" ,priority=01)
	public void step01_naviagteToBO_URL() throws Exception
	{
	   logtest("Create the root category and sub category, add products to the sub category and verify in FO.");
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
	 @Test(description="Enter the category name", priority=9)
	 public void step9_enterRootCategoryName() throws Exception
	 {
	       backofficepage.bo_RootCategoryName("AutomationRootCat4");
		   System.out.println("step 9 end");
	 }
	 @Test(description="Click on save button", priority=10)
	 public void step10_ClickOnSaveBtn() throws Exception
	 {
           backofficepage.bo_SaveBtn();
		   System.out.println("step 10 end");
	 }
	 @Test(description="Drag and drop the root category", priority=11)
	 public void step11_DragAndDropRootCategory() throws Exception
	 {
           backofficepage.bo_DragandDropCategory();
		   System.out.println("step 11 end");
	 }
	 @Test(description="Click on save btn to close the warning popup", priority=12)
	 public void step12_ClickOnOkWarningPopup() throws Exception
	 {
           backofficepage.bo_warningOKBtn();
		   System.out.println("step 12 end");
	 }
	 @Test(description="Click on System menu option", priority=13)
	 public void step13_ClickOnSystemMenu() throws Exception
	 {
		 if(environmentName.contains("Integration6Env"))
         {
         backofficepage.ClickOnSystemIcon_INT6();
         }
         else
         {
      	   backofficepage.ClickOnSystemIcon(environmentName);
         }
		   System.out.println("step 13 end");
	 }
	 @Test(description="Click on Cache Management Sub menu", priority=14)
	 public void step14_ClickOnCacheMngBtn() throws Exception
	 {
           backofficepage.bo_cacheManagementMenu();
		   System.out.println("step 14 end");
	 }
	 @Test(description="Click on Flush Category Cache button", priority=15)
	 public void step15_ClickOnFlushCategoryBtn() throws Exception
	 {
           backofficepage.bo_flushCategoryCache();
		   System.out.println("step 15 end");
	 }
	 @Test(description="Click on flush Magento Cache button", priority=16)
	 public void step16_ClickOnMagentoCacheBtn() throws Exception
	 {
           backofficepage.bo_flushMagentoCache();
		   System.out.println("step 16 end");
	 }
	 @Test(description="Open new tab and navigate to FE url", priority=17)
	 public void step17_openNewTabandaccessFE() throws Exception
	 {
		   homepage=new HomePage(backofficepage.driver);
	       CustomFun.OpenNewTabAndSwitchToNewTab(homepage.driver, "1");
	       HomePage.navigateToCLApplication_URL(driver.get(), baseUrl.get());
		   System.out.println("step 17 end");
	 }
	 @Test(description="Verify created category is dispalyed or not", priority=18)
	 public void step18_verifyCreatedRootCatOnFE() throws Exception
	 {
           backofficepage.bo_verifyCreatedRootCatOnFE();
    	   System.out.println("step 18 end and created root category is dispalyed on FE");
	 }
	 
	 /**Root category creation and verification on FE **/
	 
	 
	 @Test(description="Click on Catalog Icon", priority=19)
	 public void step19_ClickOnCatalogIcon() throws Exception
	 {
		   backofficepage=new BackOfficePage(homepage.driver);
		   CustomFun.SwitchToSpecificTab(backofficepage.driver, "0");
		   backofficepage.CatalogIconClick();
		   System.out.println("step 19 end");
	 }
	 
	 @Test(description="Click on Category Sub menu option", priority=20)
	 public void step20_ClickOnCategorySubMenu() throws Exception
	 {
	       backofficepage.bo_CategoryMenu();
		   System.out.println("step 20 end");
	 }
	 
	 @Test(description="Click on Stores option", priority=21)
	 public void step21_clickOnStores() throws Exception
	 {
		   backofficepage.bo_clickonStores();
		   System.out.println("step 21 end");
	 }
	 @Test(description="Select  Store", priority=22)
	 public void step22_selectStore() throws Exception
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
		   System.out.println("step 22 end");
	 }
	 @Test(description="Click on Ok Button to close the warning mesage", priority=23)
	 public void step23_clickOnOKBtn() throws Exception
	 {
		   backofficepage.bo_clickonOKBtn();
		   System.out.println("step 23 end");
	 }
	 @Test(description="Click on created root category", priority=24)
	 public void step24_ClickOnCreatedRootCategory() throws Exception
	 {
      //   GUIFunctions.pageScrollTobottomOfPage(backofficepage.driver);
		 backofficepage.bo_CreatedRootCategory_Click("AutomationRootCat4");
		   System.out.println("step 24 end");
	 }
	 
	 @Test(description="Scroll the page to top", priority=25)
	 public void step25_scrollToTopOfThePage() throws Exception
	 {
		   backofficepage.bo_scrollToTop();
		   System.out.println("step 25 end");
	 }
	 
   @Test(description="Unselect the use default value checkbox below the enable category", priority=26)
	 public void step26_unSelectUseDefaultvalue() throws Exception
	 {
		   backofficepage.bo_unselectEnableCatCheckbox();
		   System.out.println("step 26 end");
	 }
	 @Test(description="Click on Enable Category ", priority=27)
	 public void step27_enablecategoryClick() throws Exception
	 {
		   backofficepage.bo_enableCategory_Click();
		   System.out.println("step 27 end");
	 }
	 
	 @Test(description="Click on save button", priority=28)
	 public void step28_ClickOnSaveBtn() throws Exception
	 {
           backofficepage.bo_SaveBtn();
		   System.out.println("step 28 end");
	 }
	 @Test(description="Click on System menu option", priority=29)
	 public void step29_ClickOnSystemMenu() throws Exception
	 {
		 if(environmentName.contains("Integration6Env"))
         {
         backofficepage.ClickOnSystemIcon_INT6();
         }
         else
         {
      	   backofficepage.ClickOnSystemIcon(environmentName);
         }
		   System.out.println("step 29 end");
	 }
	 @Test(description="Click on Cache Management Sub menu", priority=30)
	 public void step30_ClickOnCacheMngBtn() throws Exception
	 {
           backofficepage.bo_cacheManagementMenu();
		   System.out.println("step 30 end");
	 }
	 @Test(description="Click on Flush Category Cache button", priority=31)
	 public void step31_ClickOnFlushCategoryBtn() throws Exception
	 {
           backofficepage.bo_flushCategoryCache();
		   System.out.println("step 31 end");
	 }
	 @Test(description="Click on flush Magento Cache button", priority=32)
	 public void step32_ClickOnMagentoCacheBtn() throws Exception
	 {
           backofficepage.bo_flushMagentoCache();
		   System.out.println("step 32 end");
	 }
	 @Test(description="Switch to FE tab and refesh the page", priority=33)
	 public void step33_openNewTabandaccessFE() throws Exception
	 {
		   CustomFun.SwitchToSpecificTab(homepage.driver, "1");
		   homepage.driver.navigate().refresh();
		   CustomFun.waitForPageLoaded(homepage.driver);
		   System.out.println("step 33 end");
	 }
	 @Test(description="Verify created category is dispalyed or not", priority=34)
	 public void step34_verifyCreatedRootCatOnFE() throws Exception
	 {
          backofficepage.bo_unverifyCreatedRootCatOnFE();
           
           
    	   System.out.println("step 34 end and created root category is not dispalyed on FE");
	 }
	 
	 /**Root category disable  and verification on FE **/
	 
	 
	 @Test(description="Click on Catalog Icon", priority=35)
	 public void step35_ClickOnCatalogIcon() throws Exception
	 {
		   backofficepage=new BackOfficePage(homepage.driver);
		   CustomFun.SwitchToSpecificTab(backofficepage.driver, "0");
		   backofficepage.CatalogIconClick();
		   System.out.println("step 35 end");
	 }
	 
	 @Test(description="Click on Category Sub menu option", priority=36)
	 public void step36_ClickOnCategorySubMenu() throws Exception
	 {
	       backofficepage.bo_CategoryMenu();
	       CustomFun.waitForPageLoaded(backofficepage.driver);
	       Thread.sleep(5000);
		   System.out.println("step 36 end");
	 }
	 @Test(description="Click on Stores option", priority=37)
	 public void step37_clickOnStores() throws Exception
	 {
		   backofficepage.bo_clickonStores();
		   System.out.println("step 37 end");
	 }
	 @Test(description="Select  Store", priority=38)
	 public void step38_selectStore() throws Exception
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
		   System.out.println("step 38 end");
	 }
	 @Test(description="Click on Ok Button to close the warning mesage", priority=39)
	 public void step39_clickOnOKBtn() throws Exception
	 {
		   backofficepage.bo_clickonOKBtn();
		   System.out.println("step 39 end");
	 }
	 @Test(description="Click on created root category", priority=40)
	 public void step40_ClickOnCreatedRootCategory() throws Exception
	 {
      //   GUIFunctions.pageScrollTobottomOfPage(backofficepage.driver);
		 backofficepage.bo_CreatedRootCategory_Click("AutomationRootCat4");
		   System.out.println("step 40 end");
	 }
	 @Test(description="Scroll the top to bottom", priority=41)
	 public void step41_scrollToTopOfThePage() throws Exception
	 {
		   backofficepage.bo_scrollToTop();
		   System.out.println("step 41 end");
	 }
	 @Test(description="Click on Enable Category ", priority=42)
	 public void step42_enablecategoryClick() throws Exception
	 {
		   backofficepage.bo_enableCategory_Click();
		   System.out.println("step 42 end");
	 }
	 
	 @Test(description="Click on save button", priority=43)
	 public void step43_ClickOnSaveBtn() throws Exception
	 {
           backofficepage.bo_SaveBtn();
		   System.out.println("step 43 end");
	 }
	 @Test(description="Click on System menu option", priority=44)
	 public void step44_ClickOnSystemMenu() throws Exception
	 {
		 if(environmentName.contains("Integration6Env"))
         {
         backofficepage.ClickOnSystemIcon_INT6();
         }
         else
         {
      	   backofficepage.ClickOnSystemIcon(environmentName);
         }
		   System.out.println("step 44 end");
	 }
	 @Test(description="Click on Cache Management Sub menu", priority=45)
	 public void step45_ClickOnCacheMngBtn() throws Exception
	 {
           backofficepage.bo_cacheManagementMenu();
		   System.out.println("step 45 end");
	 }
	 @Test(description="Click on Flush Category Cache button", priority=46)
	 public void step46_ClickOnFlushCategoryBtn() throws Exception
	 {
           backofficepage.bo_flushCategoryCache();
		   System.out.println("step 46 end");
	 }
	 @Test(description="Click on flush Magento Cache button", priority=47)
	 public void step47_ClickOnMagentoCacheBtn() throws Exception
	 {
           backofficepage.bo_flushMagentoCache();
		   System.out.println("step 47 end");
	 }
	 @Test(description="Swtich to FE and refresh the page", priority=48)
	 public void step48_swithtoTabandaccessFE() throws Exception
	 {
		   CustomFun.SwitchToSpecificTab(homepage.driver, "1");
		   homepage.driver.navigate().refresh();
		   CustomFun.waitForPageLoaded(homepage.driver);
		   System.out.println("step 48 end");
	 }
	 @Test(description="Verify created category is dispalyed or not", priority=49)
	 public void step49_verifyCreatedRootCatOnFE() throws Exception
	 {
           backofficepage.bo_verifyCreatedRootCatOnFE();
    	   System.out.println("step 49 end and created root category is  dispalyed on FE");
	 }
	 
	 /**Root category enable and verification on FE **/
	 
	 @Test(description="Click on Catalog Icon", priority=50)
	 public void step50_ClickOnCatalogIcon() throws Exception
	 {
		   backofficepage=new BackOfficePage(homepage.driver);
		   CustomFun.SwitchToSpecificTab(backofficepage.driver, "0");
		   backofficepage.CatalogIconClick();
		   System.out.println("step 50 end");
	 }
	 
	 @Test(description="Click on Category Sub menu option", priority=51)
	 public void step51_ClickOnCategorySubMenu() throws Exception
	 {
	       backofficepage.bo_CategoryMenu();
		   System.out.println("step 51 end");
	 }
	 @Test(description="Click on created root category", priority=52)
	 public void step52_ClickOnCreatedRootCategory() throws Exception
	 {
   //      GUIFunctions.pageScrollTobottomOfPage(backofficepage.driver);
		 backofficepage.bo_CreatedRootCategory_Click("AutomationRootCat4");
		   System.out.println("step 52 end");
	 }
	 @Test(description="Scroll the page to top", priority=53)
	 public void step53_scrollToTopOfThePage() throws Exception
	 {
		   backofficepage.bo_scrollToTop();
		   System.out.println("step 53 end");
	 }
	 @Test(description="Click on Add sub category button", priority=54)
	 public void step54_ClickOnAddsUBCategory() throws Exception
	 {
           backofficepage.bo_addSubCategoryBtn_click();
		   System.out.println("step 54 end");
	 
	 }
	 @Test(description="Enter the sub category name", priority=55)
	 public void step55_enterSubCategoryname() throws Exception
	 {
           backofficepage.bo_SubCategoryName("AutomationSubCat4");
           backofficepage.bo_displaySettings_Click();
           backofficepage.bo_leftMenuExpand_Click();
		   System.out.println("step 55 end");
	 
	 }
	 @Test(description="Click on save button", priority=56)
	 public void step56_ClickOnSaveBtn() throws Exception
	 {
           backofficepage.bo_SaveBtn();
		   System.out.println("step 56 end");
	 }
	 @Test(description="Click on System menu option", priority=57)
	 public void step57_ClickOnSystemMenu() throws Exception
	 {
		 if(environmentName.contains("Integration6Env"))
         {
         backofficepage.ClickOnSystemIcon_INT6();
         }
         else
         {
      	   backofficepage.ClickOnSystemIcon(environmentName);
         }
		   System.out.println("step 57 end");
	 }
	 @Test(description="Click on Cache Management Sub menu", priority=58)
	 public void step58_ClickOnCacheMngBtn() throws Exception
	 {
           backofficepage.bo_cacheManagementMenu();
		   System.out.println("step 58 end");
	 }
	 @Test(description="Click on Flush Category Cache button", priority=59)
	 public void step59_ClickOnFlushCategoryBtn() throws Exception
	 {
           backofficepage.bo_flushCategoryCache();
		   System.out.println("step 59 end");
	 }
	 @Test(description="Click on flush Magento Cache button", priority=60)
	 public void step60_ClickOnMagentoCacheBtn() throws Exception
	 {
           backofficepage.bo_flushMagentoCache();
		   System.out.println("step 60 end");
	 }
	 @Test(description="switch to  to FE url", priority=61)
	 public void step61_accessFE() throws Exception
	 {
		   CustomFun.SwitchToSpecificTab(homepage.driver, "1");
		   homepage.driver.navigate().refresh();
		   CustomFun.waitForPageLoaded(homepage.driver);
		   System.out.println("step 61 end");
	 }
	 @Test(description="Verify created sub category is dispalyed or not", priority=62)
	 public void step62_verifyCreatedSubCatOnFE() throws Exception
	 {
           backofficepage.bo_verifySubCatOnFE();
    	   System.out.println("step 62 end and created sub category is dispalyed on FE");
	 }
	 
	 /**Sub category creation and verification on FE **/
	 
	 @Test(description="Click on Catalog Icon", priority=63)
	 public void step63_ClickOnCatalogIcon() throws Exception
	 {
		   backofficepage=new BackOfficePage(homepage.driver);
		   CustomFun.SwitchToSpecificTab(backofficepage.driver, "0");
		   backofficepage.CatalogIconClick();
		   System.out.println("step 63 end");
	 }
	 
	 @Test(description="Click on Category Sub menu option", priority=64)
	 public void step64_ClickOnCategorySubMenu() throws Exception
	 {
	       backofficepage.bo_CategoryMenu();
		   System.out.println("step 64 end");
	 }
	 
	 @Test(description="Click on Stores option", priority=65)
	 public void step65_clickOnStores() throws Exception
	 {
		   backofficepage.bo_clickonStores();
		   System.out.println("step 65 end");
	 }
	 @Test(description="Select Store", priority=66)
	 public void step66_selectStore() throws Exception
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
		   System.out.println("step 66 end");
	 }
	 @Test(description="Click on Ok Button to close the warning mesage", priority=67)
	 public void step67_clickOnOKBtn() throws Exception
	 {
		   backofficepage.bo_clickonOKBtn();
		   System.out.println("step 67 end");
	 }
	 @Test(description="Click on expand all", priority=68)
	 public void step68_ClickOnExpandAll() throws Exception
	 {
          backofficepage.bo_clickExpandAll();
		   System.out.println("step 68 end");
	 }
	 @Test(description="Click on created subcategory", priority=69)
	 public void step69_ClickOnCreatedSubCategory() throws Exception
	 {
          GUIFunctions.pageScrollTobottomOfPage(backofficepage.driver);
		 backofficepage.bo_clickOnSubCategory();
		   System.out.println("step 69 end");
	 }
	 @Test(description="Scroll the page to top", priority=70)
	 public void step70_scrollToTopOfThePage() throws Exception
	 {
		   backofficepage.bo_scrollToTop();
		   System.out.println("step 70 end");
	 }
	 @Test(description="Unselect the use default value checkbox below the enable category", priority=71)
	 public void step71_unSelectUseDefaultvalue() throws Exception
	 {
		   backofficepage.bo_unselectEnableCatCheckbox();
		   System.out.println("step 71 end");
	 }
	 @Test(description="Click on Enable Category ", priority=72)
	 public void step72_enablecategoryClick() throws Exception
	 {
		   backofficepage.bo_enableCategory_Click();
		   System.out.println("step 72 end");
	 }
	 
	 @Test(description="Click on save button", priority=73)
	 public void step73_ClickOnSaveBtn() throws Exception
	 {
           backofficepage.bo_SaveBtn();
		   System.out.println("step 73 end");
	 }
	 @Test(description="Click on System menu option", priority=74)
	 public void step74_ClickOnSystemMenu() throws Exception
	 {
           CustomFun.waitForPageLoaded(backofficepage.driver);
           if(environmentName.contains("Integration6Env"))
           {
           backofficepage.ClickOnSystemIcon_INT6();
           }
           else
           {
        	   backofficepage.ClickOnSystemIcon(environmentName);
           }
           
		   System.out.println("step 74 end");
	 }
	 @Test(description="Click on Cache Management Sub menu", priority=75)
	 public void step75_ClickOnCacheMngBtn() throws Exception
	 {
           backofficepage.bo_cacheManagementMenu();
		   System.out.println("step 75 end");
	 }
	 @Test(description="Click on Flush Category Cache button", priority=76)
	 public void step76_ClickOnFlushCategoryBtn() throws Exception
	 {
           backofficepage.bo_flushCategoryCache();
		   System.out.println("step 76 end");
	 }
	 @Test(description="Click on flush Magento Cache button", priority=77)
	 public void step77_ClickOnMagentoCacheBtn() throws Exception
	 {
           backofficepage.bo_flushMagentoCache();
		   System.out.println("step 77 end");
	 }
	 @Test(description="Switch to FE url", priority=78)
	 public void step78_accessFE() throws Exception
	 {
		   CustomFun.SwitchToSpecificTab(homepage.driver, "1");
		   homepage.driver.navigate().refresh();
		   CustomFun.waitForPageLoaded(homepage.driver);
		   System.out.println("step 78 end");
	 }
	 @Test(description="Verify created sub category is dispalyed or not", priority=79)
	 public void step79_verifyCreatedSubCatOnFE() throws Exception
	 {
           backofficepage.bo_unverifysubCategoryPage();
    	   System.out.println("step 79 end and created sub category is not dispalyed on FE");
	 }
	 
	 /**Sub category disable and verification on FE **/
	 
	 @Test(description="Click on Catalog Icon", priority=80)
	 public void step80_ClickOnCatalogIcon() throws Exception
	 {
		   backofficepage=new BackOfficePage(homepage.driver);
		   CustomFun.SwitchToSpecificTab(backofficepage.driver, "0");
		   backofficepage.CatalogIconClick();
		   System.out.println("step 80 end");
	 }
	 
	 @Test(description="Click on Category Sub menu option", priority=81)
	 public void step81_ClickOnCategorySubMenu() throws Exception
	 {
	       backofficepage.bo_CategoryMenu();
		   System.out.println("step 81 end");
	 }
	 @Test(description="Click on Stores option", priority=82)
	 public void step82_clickOnStores() throws Exception
	 {
		   backofficepage.bo_clickonStores();
		   System.out.println("step 82 end");
	 }
	 @Test(description="Select Store", priority=83)
	 public void step83_selectStore() throws Exception
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
		   System.out.println("step 83 end");
	 }
	 @Test(description="Click on Ok Button to close the warning mesage", priority=84)
	 public void step84_clickOnOKBtn() throws Exception
	 {
		   backofficepage.bo_clickonOKBtn();
		   System.out.println("step 84 end");
	 }
	 @Test(description="Click on expand all", priority=85)
	 public void step85_ClickOnExpandAll() throws Exception
	 {
          backofficepage.bo_clickExpandAll();
		   System.out.println("step 85 end");
	 }
	 @Test(description="Click on created subcategory", priority=86)
	 public void step86_ClickOnCreatedSubCategory() throws Exception
	 {
          GUIFunctions.pageScrollTobottomOfPage(backofficepage.driver);
		  backofficepage.bo_clickOnSubCategory();
		  System.out.println("step 86 end");
	 }
	 @Test(description="Click on Enable Category ", priority=87)
	 public void step87_enablecategoryClick() throws Exception
	 {
		  GUIFunctions.pageScrollToTopOfPage(backofficepage.driver);
		  backofficepage.bo_enableCategory_Click();
		  System.out.println("step 87 end");
	 }
	 
	 @Test(description="Click on save button", priority=88)
	 public void step88_ClickOnSaveBtn() throws Exception
	 {
           backofficepage.bo_SaveBtn();
		   System.out.println("step 88 end");
	 }
	 @Test(description="Click on System menu option", priority=89)
	 public void step89_ClickOnSystemMenu() throws Exception
	 {
		 if(environmentName.contains("Integration6Env"))
         {
         backofficepage.ClickOnSystemIcon_INT6();
         }
         else
         {
      	   backofficepage.ClickOnSystemIcon(environmentName);
         }
		   System.out.println("step 89 end");
	 }
	 @Test(description="Click on Cache Management Sub menu", priority=90)
	 public void step90_ClickOnCacheMngBtn() throws Exception
	 {
           backofficepage.bo_cacheManagementMenu();
		   System.out.println("step 90 end");
	 }
	 @Test(description="Click on Flush Category Cache button", priority=91)
	 public void step91_ClickOnFlushCategoryBtn() throws Exception
	 {
           backofficepage.bo_flushCategoryCache();
		   System.out.println("step 91 end");
	 }
	 @Test(description="Click on flush Magento Cache button", priority=92)
	 public void step92_ClickOnMagentoCacheBtn() throws Exception
	 {
           backofficepage.bo_flushMagentoCache();
		   System.out.println("step 92 end");
	 }
	 @Test(description="navigate to FE url", priority=93)
	 public void step93_accessFE() throws Exception
	 {
		   CustomFun.SwitchToSpecificTab(homepage.driver, "1");
		   homepage.driver.navigate().refresh();
		   CustomFun.waitForPageLoaded(homepage.driver);
		   System.out.println("step 93 end");
	 }
	 @Test(description="Verify created sub category is dispalyed or not", priority=94)
	 public void step94_verifyCreatedSubCatOnFE() throws Exception
	 {
           backofficepage.bo_verifySubCatOnFE();
    	   System.out.println("step 94 end and created sub category is  dispalyed on FE");
	 }
	 
	 /**Sub category enable and verification on FE **/
	 
	 @Test(description="Click on Catalog Icon", priority=97)
	 public void step97_ClickOnCatalogIcon() throws Exception
	 {
		   backofficepage=new BackOfficePage(homepage.driver);
		   CustomFun.SwitchToSpecificTab(backofficepage.driver, "0");
		   backofficepage.CatalogIconClick();
		   System.out.println("step 97 end");
	 }
	 @Test(description="Click on Category Sub menu option", priority=98)
	 public void step98_ClickOnCategorySubMenu() throws Exception
	 {
	       backofficepage.bo_CategoryMenu();
		   System.out.println("step 98 end");
	 }
	 @Test(description="Click on Stores option", priority=99)
	 public void step99_clickOnStores() throws Exception
	 {
		   backofficepage.bo_clickonStores();
		   System.out.println("step 99 end");
	 }
	 @Test(description="Select Store", priority=100)
	 public void step100_selectStore() throws Exception
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
		   System.out.println("step 100 end");
	 }
	 @Test(description="Click on Ok Button to close the warning mesage", priority=101)
	 public void step101_clickOnOKBtn() throws Exception
	 {
		   backofficepage.bo_clickonOKBtn();
		   System.out.println("step 101 end");
	 }
	 @Test(description="Click on expand all", priority=102)
	 public void step102_ClickOnExpandAll() throws Exception
	 {
          backofficepage.bo_clickExpandAll();
		   System.out.println("step 102 end");
	 }
	 @Test(description="Click on created subcategory", priority=103)
	 public void step103_ClickOnCreatedSubCategory() throws Exception
	 {
          GUIFunctions.pageScrollTobottomOfPage(backofficepage.driver);
		 backofficepage.bo_clickOnSubCategory();
		   System.out.println("step 103 end");
	 }
	 @Test(description="Unselect the default value checkbox", priority=104)
	 public void step104_unselectCatCheckBox() throws Exception
	 {
		   backofficepage.bo_unselectCatCheckbox();
		   System.out.println("step 104 end");
	 }
	 @Test(description="Enter the updated sub category name", priority=105)
	 public void step105_enterUpdatedSubCatName() throws Exception
	 {
		 backofficepage.bo_UpdateSubCatName("AutomationSubCat4");
			System.out.println("step 105 end"); 
	 }
	 @Test(description="Expand the SEO Section", priority=106)
	 public void step106_expandSEOSection() throws Exception
	 {
            backofficepage.bo_ClickOnSEO();
			System.out.println("step 106 end");
		 
	 }
	 @Test(description="Unselect the URL Keydefault value checkbox", priority=107)
	 public void step107_unselectURLKeyCheckBox() throws Exception
	 {
		   backofficepage.bo_unselectURLKey();
		   System.out.println("step 107 end");
	 }
	 @Test(description="Update the URL data", priority=108)
	 public void step108_updateURLData() throws Exception
	 {
		   backofficepage.bo_urlName("AutomationSubCat4");
		   System.out.println("step 108 end");
	 }
	 @Test(description="Click on save button", priority=109)
	 public void step109_ClickOnSaveBtn() throws Exception
	 {
           backofficepage.bo_SaveBtn();
		   System.out.println("step 109 end");
	 }
	 @Test(description="Click on System menu option", priority=110)
	 public void step110_ClickOnSystemMenu() throws Exception
	 {
		 if(environmentName.contains("Integration6Env"))
         {
         backofficepage.ClickOnSystemIcon_INT6();
         }
         else
         {
      	   backofficepage.ClickOnSystemIcon(environmentName);
         }
		   System.out.println("step 110 end");
	 }
	 @Test(description="Click on Cache Management Sub menu", priority=111)
	 public void step111_ClickOnCacheMngBtn() throws Exception
	 {
           backofficepage.bo_cacheManagementMenu();
		   System.out.println("step 111 end");
	 }
	 @Test(description="Click on Flush Category Cache button", priority=112)
	 public void step112_ClickOnFlushCategoryBtn() throws Exception
	 {
           backofficepage.bo_flushCategoryCache();
		   System.out.println("step 112 end");
	 }
	 @Test(description="Click on flush Magento Cache button", priority=113)
	 public void step113_ClickOnMagentoCacheBtn() throws Exception
	 {
           backofficepage.bo_flushMagentoCache();
		   System.out.println("step 113 end");
	 }
	 @Test(description="navigate to FE url", priority=114)
	 public void ste114_accessFE() throws Exception
	 {
		   CustomFun.SwitchToSpecificTab(homepage.driver, "1");
		   homepage.driver.navigate().refresh();
		   CustomFun.waitForPageLoaded(homepage.driver);
		   System.out.println("step 114 end");
	 }
	 @Test(description="Verify created sub category name is updated or not", priority=115)
	 public void step115_verifyUpdatedSubCatOnFE() throws Exception
	 {
           backofficepage.bo_verifyCreatedCatOnFE();
    	   System.out.println("step 115 end and created sub name category is  dispalyed on FE");
	 }
	 @Test(description="Verify created sub category is dispalyed or not", priority=116)
	 public void step116_verifyUpdatedSubCatURLOnFE() throws Exception
	 {
           backofficepage.bo_verifySubCatUpdatedURL();
    	   System.out.println("step 116 end and sub category URL is  dispalyed on FE");
	 }
	 
	 /**Sub category name upodate and URL update and verification on FE **/
	 
	 @Test(description="Click on Catalog Icon", priority=117)
	 public void step117_ClickOnCatalogIcon() throws Exception
	 {
		   backofficepage=new BackOfficePage(homepage.driver);
		   CustomFun.SwitchToSpecificTab(backofficepage.driver, "0");
		   backofficepage.CatalogIconClick();
		   System.out.println("step 117 end");
	 }
	 @Test(description="Click on Category Sub menu option", priority=118)
	 public void step118_ClickOnCategorySubMenu() throws Exception
	 {
	       backofficepage.bo_CategoryMenu();
		   System.out.println("step 118 end");
	 }
	 @Test(description="Click on Stores option", priority=119)
	 public void step119_clickOnStores() throws Exception
	 {
		   backofficepage.bo_clickonStores();
		   System.out.println("step 119 end");
	 }
	 @Test(description="Select Store", priority=120)
	 public void step120_selectStore() throws Exception
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
		   System.out.println("step 120 end");
	 }
	 @Test(description="Click on Ok Button to close the warning mesage", priority=121)
	 public void step121_clickOnOKBtn() throws Exception
	 {
		   backofficepage.bo_clickonOKBtn();
		   System.out.println("step 121 end");
	 }
	 @Test(description="Click on expand all", priority=122)
	 public void step122_ClickOnExpandAll() throws Exception
	 {
          backofficepage.bo_clickExpandAll();
		   System.out.println("step 122 end");
	 }
	 @Test(description="Click on created subcategory", priority=123)
	 public void step123_ClickOnCreatedSubCategory() throws Exception
	 {
          GUIFunctions.pageScrollTobottomOfPage(backofficepage.driver);
          backofficepage.bo_clickOnCreatedSubCategory("AutomationSubCat4");
		   System.out.println("step 123 end");
	 }
	 @Test(description="Click on products in category", priority=124)
	 public void step124_clickOnProductsInCategory() throws Exception
	 {
		   backofficepage.bo_expandProductsInCategory();
		   System.out.println("step 124 end");
	 }
	 @Test(description="Click on Add product", priority=125)
	 public void step125_clickOnAddProduct() throws Exception
	 {
		   backofficepage.bo_clickOnAddProducts();
		   System.out.println("step 125 end");
	 }
	 @Test(description="Click on Merch Filter button", priority=126)
	 public void step126_clickOnMerchFilter() throws Exception
	 {
		   backofficepage.bo_clickOnMerchFilter();
		   System.out.println("step 126 end");
	 }
	 @Test(description="Enter the From value", priority=127)
	 public void step127_enterFromValue() throws Exception
	 {
		   backofficepage.bo_enterFromValue("100");
		   System.out.println("step 127 end");
	 }
	 @Test(description="Enter To value", priority=128)
	 public void step128_enterToValue() throws Exception
	 {
		   backofficepage.bo_enterToValue("400");
		   System.out.println("step 128 end");
	 }
	 @Test(description="Click on apply filter button", priority=129)
	 public void step129_clickOnApplyFilter() throws Exception
	 {
		   backofficepage.bo_clickOnApplyFilter();
		   System.out.println("step 129 end");
	 }
	 @Test(description="Select products", priority=130)
	 public void step130_selectProducts() throws Exception
	 {
		   backofficepage.bo_selectProducts();
		   System.out.println("step 130 end");
	 }
	 @Test(description="Click on save and close button", priority=131)
	 public void step131_clickOnApplyFilter() throws Exception
	 {
		   backofficepage.bo_clickOnSaveAndCloseBtn();
		   System.out.println("step 131 end");
	 }
	 @Test(description="Click on merch tile view", priority=132)
	 public void step132_clickOnMerchTileView() throws Exception
	 {
		   backofficepage.bo_clickOnMerchTileView();
		   System.out.println("step 132 end");
	 }
	 @Test(description="Click on product tile view", priority=134)
	 public void step134_clickOnProductTileView() throws Exception
	 {
		   backofficepage.bo_clickOnProductTileView();
		   System.out.println("step 134 end");
	 }
	 @Test(description="select the products checkbox in merch pool area", priority=135)
	 public void step135_selectProductsCheckBox() throws Exception
	 {
		   backofficepage.bo_selectProductsInMerchPool();
		   System.out.println("step 135 end");
	 }
	 @Test(description="Drag and drop the products", priority=136)
	 public void step136_dragAndDropProducts() throws Exception
	 {
		   backofficepage.bo_DragandDropProduct();
		   System.out.println("step 136 end");
	 }
	 @Test(description="Click on save button", priority=137)
	 public void step137_ClickOnSaveBtn() throws Exception
	 {
           backofficepage.bo_SaveBtn();
		   System.out.println("step 137 end");
	 }
	 @Test(description="Click on System menu option", priority=137)
	 public void step137_ClickOnSystemMenu() throws Exception
	 {
		 if(environmentName.contains("Integration6Env"))
         {
         backofficepage.ClickOnSystemIcon_INT6();
         }
         else
         {
      	   backofficepage.ClickOnSystemIcon(environmentName);
         }
		   System.out.println("step 137 end");
	 }
	 @Test(description="Click on Cache Management Sub menu", priority=138)
	 public void step138_ClickOnCacheMngBtn() throws Exception
	 {
           backofficepage.bo_cacheManagementMenu();
		   System.out.println("step 138 end");
	 }
	 @Test(description="Click on Flush Category Cache button", priority=139)
	 public void step139_ClickOnFlushCategoryBtn() throws Exception
	 {
           backofficepage.bo_flushCategoryCache();
		   System.out.println("step 139 end");
	 }
	 @Test(description="Click on flush Magento Cache button", priority=140)
	 public void step140_ClickOnMagentoCacheBtn() throws Exception
	 {
           backofficepage.bo_flushMagentoCache();
		   System.out.println("step 140 end");
	 }
	 @Test(description="navigate to FE url", priority=141)
	 public void ste141_accessFE() throws Exception
	 {
		   CustomFun.SwitchToSpecificTab(homepage.driver, "1");
		   homepage.driver.navigate().refresh();
		   CustomFun.waitForPageLoaded(homepage.driver);
		   System.out.println("step 141 end");
	 }
	 @Test(description="Click on Created Sub category", priority=141)
	 public void step141_verifyUpdatedSubCatOnFE() throws Exception
	 {
           backofficepage.bo_verifyCreatedCatOnFE();
    	   System.out.println("step 141 end and created sub name category is  dispalyed on FE");
	 }
	 @Test(description="Verify created sub category is dispalyed or not", priority=142)
	 public void step142_clickOnCreatedSubCategoy() throws Exception
	 {
           backofficepage.bo_createdSubCat_Click("AutomationRootCat4","AutomationSubCat4");
    	   System.out.println("step 142 end and sub category page displayed");
	 }
	 @Test(description="Verify products are dispalyed or not", priority=143)
	 public void step143_verifyproductsLOnFE() throws Exception
	 {
           backofficepage.bo_verifyProductsOnFE();
    	   System.out.println("step 143 end and products are dispalyed in the sub category page");
	 }
	 @Test(description="Click on Catalog menu", priority=144)
	 public void step144_ClickOnCatalogMenu() throws Exception
	 {
		   backofficepage=new BackOfficePage(homepage.driver);
		   CustomFun.SwitchToSpecificTab(backofficepage.driver, "0");
		   backofficepage.CatalogIconClick();
		   System.out.println("step 144 end");
	 }
	 @Test(description="Click on categories sub menu", priority=145)
	 public void step145_ClickOnCategorySubMenu() throws Exception
	 {
           backofficepage.bo_CategoryMenu();
		   System.out.println("step 145 end");
	 } 
	 @Test(description="Click on Stores option", priority=146)
	 public void step146_clickOnStores() throws Exception
	 {
		  GUIFunctions.pageScrollToTopOfPage(backofficepage.driver);
		  backofficepage.bo_clickonStores();
		   System.out.println("step 146 end");
	 }
	 @Test(description="Select Store", priority=147)
	 public void step147_selectStore() throws Exception
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
		   System.out.println("step 74 end");
	 }
	 
	 @Test(description="Click on Ok Button to close the warning mesage", priority=148)
	 public void step148_clickOnOKBtn() throws Exception
	 {
		   backofficepage.bo_clickonOKBtn();
		   System.out.println("step 148 end");
	 }
	 
	 @Test(description="Click on expand all", priority=149)
	 public void step149_ClickOnExpandAll() throws Exception
	 {
          backofficepage.bo_clickExpandAll();
		   System.out.println("step 149 end");
	 }
	 @Test(description="Click on created subcategory", priority=150)
	 public void step150_ClickOnCreatedSubCategory() throws Exception
	 {
          GUIFunctions.pageScrollTobottomOfPage(backofficepage.driver);
		 backofficepage.bo_clickOnCreatedSubCategory("AutomationSubCat4");
		   System.out.println("step 150 end");
	 }

	 @Test(description="Click on delete subcategory", priority=151)
	 public void step151_ClickOnDeleteSubCategory() throws Exception
	 {
          backofficepage.bo_clickOnDeleteCat();
		   System.out.println("step 151 end and subcategory has been deleted");
	 }
	 
	 @Test(description="Click on ok btn", priority=152)
	 public void step152_ClickOnOkBtn() throws Exception
	 {
          backofficepage.bo_clickonOKBtn();
		   System.out.println("step 152 end");
	 }
	 @Test(description="Click on delete rootcategory", priority=153)
	 public void step153_ClickOnDeleteRootCategory() throws Exception
	 {
          backofficepage.bo_clickOnDeleteCat();
		   System.out.println("step 153 end and root category has been deleted");
	 }
	 
	 @Test(description="Click on ok btn", priority=154)
	 public void step154_ClickOnOkBtn() throws Exception
	 {
          backofficepage.bo_clickonOKBtn();
		   System.out.println("step 154 end");
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
	 
	 @Test(description="Click on account icon", priority=155)
	 public void step155_ClickOnAcountIcon() throws Exception
	 {
          backofficepage.bo_clickOnAccountIcon();
		   System.out.println("step 155 end");
	 }
	 
	 @Test(description="Click on signout option", priority=156)
	 public void step156_ClickOnSignOut() throws Exception
	 {
          backofficepage.bo_clickOnSignOutOption();
		   System.out.println("step 156 end");
	 }  
	 
}
