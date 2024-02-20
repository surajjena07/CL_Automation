package src.in.valtech.cl.scenarios;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import src.in.valtech.cl.back.pages.BackOfficePage;
import src.in.valtech.cl.back.pages.PIMPage;
import src.in.valtech.cl.back.pages.WMSPage;
import src.in.valtech.cl.front.pages.CategoryLandingPage;
import src.in.valtech.cl.front.pages.HomePage;
import src.in.valtech.cl.front.pages.ProductDetailsPage;
import src.in.valtech.cl.front.pages.ProductListingPage;
import src.in.valtech.config.BaseTest;
import src.in.valtech.custom.CustomFun;
import src.in.valtech.uifunctions.GUIFunctions;
import static src.in.valtech.util.PropertyFileReader.ObjRepoProp;

public class TC_Scenario2_Phase2 extends BaseTest
{
	public Logger log = Logger.getLogger(this.getClass().getName());
	
	HomePage homepage;
	CategoryLandingPage categorylandingpage;
	ProductListingPage productlistingpage;
	PIMPage pimpage;
	ProductDetailsPage productdetailspage;
	BackOfficePage backofficepage;
	WMSPage wmspage;
	
	public static String BarCodeSKU;
	public static String ref_searchable_SKUID;
	
	@Test(priority=01, description="Precondition: Open browser,Navigate to the CL URL and accept Cookies")
	public void step01_NavigatetoCLHomePage() throws Exception
	{
	logtest("Verify the PIM changes in BO and FO");
	homepage =HomePage.navigateToCLApplication_URL(driver.get(),baseUrl.get());
	log.info("Successfully navigated to application URL \n");
	Reporter.log("<p>Successfully navigated to application URL");
	}
	
	@Test(description = "Mouse Over on Ladies L1 Category", priority = 2)
	public void step02_MouseOverElementOnLadiesL1Category() throws Exception
	{
		if(locale.get().contains("FR_FR") | bsValue.get().contains("YES") | locale.get().contains("CH_FR")| locale.get().contains("UK_EN"))
		{
	       for(int i=1;i<=2;i++)
	       {
	    	   Thread.sleep(5000);
	    	   homepage.driver.navigate().refresh();
	    	   Thread.sleep(5000);
	       }
         GUIFunctions.pageScrollToTopOfPage(homepage.driver);
		}
		categorylandingpage = new CategoryLandingPage(homepage.driver);
		categorylandingpage.mouseOverCategory();
		categorylandingpage.mouseOverCategory();
	}

	@Test(description = "Click on L2 Accessories Category under L1 Ladies Category", priority = 3)
	public void step03_ClickOnL2AccessoriesLadiesCategory() throws Exception
	{
		// Any L2 Category can be taken as a test data
	//	categorylandingpage.driver.findElement(By.xpath(ObjRepoProp.get().getProperty("CLP_LadiesAcc"))).click();
		//CustomFun.waitForPageLoaded(categorylandingpage.driver);
		homepage.driver.findElement(By.xpath("//button[@class='action reset search']")).click();
		Thread.sleep(2000);
		homepage.driver.findElement(By.xpath("//input[@id='search']")).sendKeys("1245011cm53");
		Thread.sleep(2000);
		homepage.driver.findElement(By.xpath("//span[@class='icon icon-search']")).
		click();
		Thread.sleep(15000);
	}
	
	@Test(description = "Click on Sold Out Product Image", priority = 4)
	public void step04_ClickOnSoldOutProductImg() throws Exception
	{
		productlistingpage = new ProductListingPage(homepage.driver);
		//productlistingpage.ClickOnSeeAlllink();
		//Thread.sleep(2000);
		if(locale.get().contains("UK_EN"))
		{
			Thread.sleep(2000);
		    productlistingpage.ClickOnSoldOutProductImg();
		    CustomFun.waitForPageLoaded(productlistingpage.driver);
		}
		else
		{
			Thread.sleep(2000);
			WebElement SoldOutProdImg=productlistingpage.driver.findElement(By.xpath(ObjRepoProp.get().getProperty("PLP_SoldOutProd_FR")));
			SoldOutProdImg.click();
			CustomFun.waitForPageLoaded(productlistingpage.driver);
		}
	}
	
	@Test(description="Click on Product Info and Verified content under Product Info section", priority=5)
	public void step05_ClickonProductInfoAndVerifiedContent() throws Exception
	{
		productdetailspage=new ProductDetailsPage(productlistingpage.driver);
		productdetailspage.pdpProductInfoBlock();
		ref_searchable_SKUID=ProductDetailsPage.Ref_searchable_sku;
	}
	
	@Test(description = "Open New Tab and Navigate to the PIM Application", priority = 6)
	public void step06_OpenNewTabAndNavigatedtoPIM() throws Exception
	{
		pimpage = new PIMPage(productdetailspage.driver);
		CustomFun.OpenNewTabAndSwitchToNewTab(pimpage.driver, "1");
		pimpage.driver.navigate().to(CustomFun.getPIMInfoDSDetails().get().getpimUrl());
		log.info("Successfully navigated to PIM Application \n");
		Reporter.log("<p>Successfully navigated to PIM Application");
	}
	
	@Test(priority=7, description="Logged into PIM with valid crendentials")
	public void step07_LoggedIntoPIM() throws Exception
	{
		pimpage.PIMLogIn(CustomFun.getPIMInfoDSDetails().get().getpimUsername(),CustomFun.getPIMInfoDSDetails().get().getpimPassword());
	}
	
	@Test(priority=8, description = "Click on Products Icon in PIM Home Page")
	public void step08_ClickOnProductsIcon() throws Exception
	{
		pimpage.ClickOnProductsIcon();
	}
	
	@Test(priority=9,description = "Select Store and then Click on Category in PIM Home Page")
	public void step09_SelectStoreAndThenClickOnCategory() throws Exception
	{
		if(locale.get().contains("FR_FR") | locale.get().contains("CH_FR"))
		{
			GUIFunctions.JavaScriptClick(pimpage.driver, pimpage.driver.findElement(By.xpath(ObjRepoProp.get().getProperty("pim_localeicon"))),
					"Clicked on Locale Icon");
			GUIFunctions.JavaScriptClick(pimpage.driver, pimpage.driver.findElement(By.xpath(ObjRepoProp.get().getProperty("pim_fr_frlocale"))),
					"Selected FR Locale");
			CustomFun.waitForPageLoaded(pimpage.driver);
			pimpage.ClickOnCategory();
		}
		else
		{
			GUIFunctions.JavaScriptClick(pimpage.driver, pimpage.driver.findElement(By.xpath(ObjRepoProp.get().getProperty("pim_localeicon"))),
					"Clicked on Locale Icon");
			GUIFunctions.JavaScriptClick(pimpage.driver, pimpage.driver.findElement(By.xpath("//div[@data-locale='en_GB']")),
					"Selected FR Locale");
			CustomFun.waitForPageLoaded(pimpage.driver);
		    pimpage.ClickOnCategory();
		}
	}
	
	@Test(priority=10, description = "Click on EU Locale Category from Master category in PIM Home Page")
	public void step10_ClickOnEULocaleCategoryFromMasterCategory() throws Exception
	{
		pimpage.ClickOnEULocaleCategory();
	}
	
	@Test(priority=11, description = "Entered SKU ID in Search Field")
	public void step11_EnterSKUIDInSearchField() throws Exception
	{
		pimpage.SKUIDSearchField(ref_searchable_SKUID);
	}
	
	@Test(priority=12, description = "Click on Product row from filter results")
	public void step12_ClickOnProductRow() throws Exception
	{
		pimpage.ClickOnProductRow();
		CustomFun.waitForPageLoaded(pimpage.driver);
	}
	
	@Test(priority=13, description = "Scroll down till Pre_Order Toggle & Turn on the Pre-order Toggle")
	public void step13_ScrolldownAndTurnOnPre_orderToggle() throws Exception
	{
		pimpage.ScrolldownAndTurnOnPre_orderToggle();
	}
	
	@Test(priority=14, description = "Click on Save button")
	public void step14_ClickOnSaveButton() throws Exception
	{
		pimpage.ClickOnSaveButton();
		CustomFun.waitForPageLoaded(pimpage.driver);
	}
	
	@Test(priority=15, description = "Click on Back button")
	public void step15_ClickOnBackButton() throws Exception
	{
		pimpage.driver.navigate().back();
		CustomFun.waitForPageLoaded(pimpage.driver);
	}
	
	@Test(priority=16, description = "click on the checkbox and select the Product row")
	public void step16_ClickOnCheckboxAndSelectTheProductRow() throws Exception
	{
		pimpage.ClickOnCheckboxAndSelectTheProduct();
	}
	
	@Test(priority=17, description = "verified Magento and Quick exports dropdowns")
	public void step17_VerifyMagentoAndQuickexportDropdowns() throws Exception
	{
		pimpage.VerifyMagentoAndQuickexportDropdowns();
	}
	
	@Test(priority=18, description = "Click on Magento Dropdown and select particular any locale")
	public void step18_ClickOnMagentoDpnAndSelectParticularLocale() throws Exception
	{
		pimpage.ClickOnMagentoDpnAndSelectParticularLocale(environmentName);
	}
	
	@Test(priority=19, description = "Click on Quick export Dropdown and select CSV Grid Context")
	public void step19_ClickOnQuickexportDpnAndSelectCSVGridContext() throws Exception
	{
		pimpage.ClickOnQuickexportDpnAndSelectCSVGridContext();
	}
	
	@Test(priority=20, description = "Click on Activity tab")
	public void step20_ClickOnActivitytab() throws Exception
	{
		pimpage.ClickOnActivitytab();
	}
	
	@Test(priority=21, description = "Click on Process tracker")
	public void step21_ClickOnProcesstracker() throws Exception
	{
		pimpage.ClickOnProcesstracker();
	}
	
	@Test(priority=22, description = "Verify The Jobs Status For Magento And QuickStart")
	public void step22_VerifyJobsStatusForMagentoAndQuickStart() throws Exception
	{
		pimpage.VerifyJobsStatusForMagentoAndQuickStart();
	}
	
	@Test(description="Open New Tab and Navigated to Magento BO", priority=23)
    public void step23_OpenNewTabAndNavigatedtoMagentoBO() throws Exception
    {
      backofficepage=new BackOfficePage(homepage.driver);
      CustomFun.OpenNewTabAndSwitchToNewTab(backofficepage.driver, "2");
      backofficepage.driver.navigate().to(CustomFun.getBODSDetails().get().getBO_URL());
    }
    
    @Test(description="Entered Username in Username Field", priority=24)
    public void step24_EnteredUsernameField() throws Exception
    {
    backofficepage.EnterUsername(CustomFun.getBODSDetails().get().getBO_Username());
    }
    
    @Test(description="Entered Password in Password Field", priority=25)
    public void step25_EnteredPasswordField() throws Exception
    {
    backofficepage.EnterPassword(CustomFun.getBODSDetails().get().getBO_Password());
    }
    
    @Test(description="Click on SignIn Button", priority=26)
    public void step26_ClickOnSignInButton() throws Exception
    {

  		backofficepage.SignbtnClick();
  		if(environmentName.contains("IntegrationEnv") | environmentName.contains("HomoEnv1") | environmentName.contains("StagingEnv") | environmentName.contains("Integration6Env"))
	    {
			Thread.sleep(5000);
			CustomFun.refreshPage(backofficepage.driver);
			Thread.sleep(5000);
		}
    }
    
    @Test(description="Verified Dashboard Header & check whether user is in Dashboard page", priority=27)
    public void step27_VerifiedDashboardHeaderInBO() throws Exception
    {
          CustomFun.waitForPageLoaded(backofficepage.driver);
          backofficepage.VerifyDashboardHeader();
    }
   
   @Test(description="Click on System Icon", priority=28)
    public void step28_ClickOnSystemIcon_INT6() throws Exception
    {
         if(environmentName.contains("Integration6Env"))
         {
         backofficepage.ClickOnSystemIcon_INT6();
         }
         else
         {
      	   backofficepage.ClickOnSystemIcon(environmentName);
         }
    }
    
    @Test(description="Click on Index Management text from System Icon", priority=29)
    public void step29_IndexManagementFromSystemIconClick() throws Exception
    {
          backofficepage.IndexManagementFromSystemIconClick();
          CustomFun.waitForPageLoaded(backofficepage.driver);
    }
    
    @Test(description="Indexing in Index Management", priority=30)
    public void step30_IndexLaunching() throws Exception
    {
          backofficepage.IndexLaunching();
    } 
 
    @Test(description="Click on System Icon", priority=31)
    public void step31_ClickOnSystemIcon_INT6() throws Exception
    {
    	if(environmentName.contains("Integration6Env"))
        {
        backofficepage.ClickOnSystemIcon_INT6();
        }
        else
        {
     	   backofficepage.ClickOnSystemIcon(environmentName);
        }
    }
    
    @Test(description="Click on Cache Management text from System Icon", priority=32)
    public void step32_CacheManagementtextFromSystemIconClick() throws Exception
    {
          backofficepage.CacheManagementtxtFromSystemIconClick();
          CustomFun.waitForPageLoaded(backofficepage.driver);
    }
    
    @Test(description="Click on Flush Magento Cache Button", priority=33)
    public void step33_ClickOnFlushMagentoCacheButton() throws Exception
    {
          backofficepage.ClickOnFlushMagentoCacheButton();
          CustomFun.waitForPageLoaded(backofficepage.driver);
    }
    
    @Test(description="Open New Tab and Navigated to WMS", priority=34)
	public void step34_OpenNewTabAndNavigatedtoWMS() throws Exception
	{
	wmspage=new WMSPage(productdetailspage.driver);
	CustomFun.OpenNewTabAndSwitchToNewTab(wmspage.driver, "3");
	wmspage.driver.navigate().to(CustomFun.getWMSInfoDSDetails().get().getWMSURL());
	}

	@Test(description="Logged into WMS with valid crendentials", priority=35)
	public void step35_LoggedIntoWMS() throws Exception
	{
	wmspage.WMSLogIn(CustomFun.getWMSInfoDSDetails().get().getWmsUsername(),CustomFun.getWMSInfoDSDetails().get().getWmsPassword());
	}

	@Test(description="Click on OK button in WMS", priority=36)
	public void step36_ClickOnOKbutton() throws Exception
	{
	wmspage.Click_WMSOKBtn();
	}

	@Test(description="Mouse Over on Data Lists Menu", priority=37)
	public void step37_MouseOverElementOnDataListsMenu() throws Exception
	{
	wmspage.WMS_Datalistmenu();
	}

	@Test(description="Click on Products from Data Lists", priority=38)
	public void step38_ClickOnProductsFromDataLists() throws Exception
	{
	wmspage.WMS_Datalist_Productclick();
	}

	@Test(description="Enter Searchable SKU & Click on Submit Filter", priority=39)
	public void step39_EnterSearchableSKUAndClickOnSubmitFilter() throws Exception
	{
	  wmspage.SearchSKUIDInListOfProductsForSimpleProd(ref_searchable_SKUID);
	  BarCodeSKU=WMSPage.barcodeSKU;
	}
	
	 @Test(description="Navigated back to BO and then Click on Catalog Icon", priority=40)
	 public void step40_NavigatedBackInBOAndClickOnCatalogIcon() throws Exception
	 {
		 CustomFun.SwitchToSpecificTab(backofficepage.driver, "2");
	     backofficepage.CatalogIconClick();
	 }
	    
	 @Test(description="Click on Products text from Catalog Icon", priority=41)
	 public void step41_ClickProductstxtFromCatalogIcon() throws Exception
	 {
	      backofficepage.ProductstxtFromCatalogIconClick();
	      CustomFun.waitForPageLoaded(backofficepage.driver);
	 }
	    
	 @Test(description="enter SKU and select exact store view", priority=42)
     public void step42_FilterProductByEnteringSKUIDAndSelectStoreViewInBO() throws Exception
	 {
	     backofficepage.FilterProductByEnteringSKUIDAndSelectStoreViewInBO(BarCodeSKU,locale.get());
	 }
	 
	 @Test(description="Verify the product will be displayed in the Product Field", priority=43)
	 public void step43_VerifyTheProductFromFilterResult() throws Exception
     {
		 By ProductRow=By.xpath(ObjRepoProp.get().getProperty("BO_ProductRow"));
		 CustomFun.isElementPresent(ProductRow,  backofficepage.driver);
		 log.info("Successfully Verified Product Row From Filter Result");
		 Reporter.log("<p>Successfully Verified Product Row From Filter Result");
	 }
	 
	 @Test(description="Click on the Product Row in the Product Field & verify the Scope of Store view", priority=44)
	 public void step44_ClickOnProductRowFromFilterResult() throws Exception
     {
		 backofficepage.driver.findElement(By.xpath(ObjRepoProp.get().getProperty("BO_ProductRow"))).click();
		 CustomFun.waitForPageLoaded(backofficepage.driver);
		 Thread.sleep(5000);
		 String ExpectedStroreView=backofficepage.driver.findElement(By.xpath(ObjRepoProp.get().getProperty("BO_ExpectedStoreView"))).getText().trim();
		 Assert.assertEquals(BackOfficePage.ActualStoreView, ExpectedStroreView);
		 log.info("Successfully Click on the Product Row and verified the Scope of Store view");
		 Reporter.log("<p>Successfully Click on the Product Row and verified the Scope of Store view");
	 }
	
	 @Test(description="Scroll down and click on the marketing Tab", priority=45)
	 public void step45_ScrollDownAndClickOnTheMarketingTab() throws Exception
     {
		 backofficepage.ScrollDownAndClickOnTheMarketingTab();
	 }
	 
	 @Test(description="Verify the Allow Pre-order Toggle in BO", priority=46)
	 public void step46_VerifyTheAllowPreOrderToggleInBO() throws Exception
     {
		 By AllowPreOrderToggle=By.xpath(ObjRepoProp.get().getProperty("BO_AllowPreOrderToggle"));
		 boolean allowpreordertoggle_enabled=backofficepage.driver.findElement(AllowPreOrderToggle).isDisplayed();
		 Assert.assertEquals(true, allowpreordertoggle_enabled);
		 log.info("Successfully Verified Allow Pre-order Toggle Enabled");
		 Reporter.log("<p>Successfully Verified Allow Pre-order Toggle Enabled");
	 }

	@Test(description="Navigated into WMS & Click on Details Button", priority=47)
	public void step47_NavigatedBackIntoWMSAndClickOnDetailsButton() throws Exception
	{
	  CustomFun.SwitchToSpecificTab(wmspage.driver, "3");
	  wmspage.ClickOnDetailsButtonForSimpleProd(ref_searchable_SKUID);
	}
	
	@Test(description="Click on Update PreOrder Quantity & Submit", priority=48)
	public void step48_UpdatePreOrderQuantityAndSubmit() throws Exception
	{
	  wmspage.UpdatePreOrderQuantityAndSubmit();
	}
	
	@Test(description="Verify Pre-order Stock Updated Success Msg", priority=49)
	public void step49_VerifyPreorderStockUpdatedSuccessMsg() throws Exception
	{
	  wmspage.VerifyPreorderStockUpdatedSuccessMsg();
	}
	
	 @Test(description="Navigated Back to Magento & Click On Flush Magento Cache Button", priority=50)
	 public void step50_NavigatedBackToBOAndClickOnFlushMagentoCacheButton() throws Exception
	 {
	    CustomFun.SwitchToSpecificTab(backofficepage.driver, "2");
	    if(environmentName.contains("Integration6Env"))
        {
        backofficepage.ClickOnSystemIcon_INT6();
        }
        else
        {
     	   backofficepage.ClickOnSystemIcon(environmentName);
        }
	    backofficepage.CacheManagementtxtFromSystemIconClick();
        CustomFun.waitForPageLoaded(backofficepage.driver);
	    backofficepage.ClickOnFlushMagentoCacheButton();
        CustomFun.waitForPageLoaded(backofficepage.driver);
	 }
	 
	 @Test(description="Click on Flush Categories Cache button", priority=51)
	 public void step51_ClickOnFlushCategoriesCacheButton() throws Exception
	 {
	    backofficepage.ClickOnFlushCategoriesCacheButton();
        CustomFun.waitForPageLoaded(backofficepage.driver);
	 }
	 
	  
	 @Test(description="Navigated Into FO and verify the status of the Product", priority=52)
     public void step52_NavigatedIntoFOAndVerifiedProductStatusChangedToPreOrderInFO() throws Exception
	 {
	  CustomFun.SwitchToSpecificTab(homepage.driver, "0");
	  GUIFunctions.pageScrollToTopOfPage(homepage.driver);
	  CustomFun.waitForPageLoaded(homepage.driver);
	  homepage.driver.findElement(By.xpath(ObjRepoProp.get().getProperty("HP_SearchField_xpath"))).click();
	  Thread.sleep(2000);
	  homepage.driver.findElement(By.xpath(ObjRepoProp.get().getProperty("HP_SearchField1_xpath"))).sendKeys(ProductDetailsPage.Ref_searchable_sku_SimpleProd);
	  Thread.sleep(2000);
	  homepage.driver.findElement(By.xpath(ObjRepoProp.get().getProperty("HP_searchicon_xpath"))).click();
	  CustomFun.waitForPageLoaded(homepage.driver);
	  Thread.sleep(2000);
	  if(locale.get().contains("UK_EN"))
	  {
		  for(int i=0;i<=4;i++)
		  {
			  Thread.sleep(30000);
			  CustomFun.refreshPage(backofficepage.driver);
			  Thread.sleep(5000);
			  CustomFun.waitForPageLoaded(backofficepage.driver);
			  String PreOrder =productlistingpage.driver.findElement(By.xpath(ObjRepoProp.get().getProperty("PDP_ProdStatus_xpath"))).getText().trim();
			  if(PreOrder.contains("PRE-ORDER"))
			  {
				  Assert.assertEquals(true, PreOrder.contains("PRE-ORDER"));
				  log.info("Successfully Verified Product Status changed to Pre-order in FO After Pre-Order Process in PIM : " + PreOrder);
				  Reporter.log("<p>Successfully Verified Product Status changed to Pre-order in FO After Pre-Order Process in PIM : " + PreOrder);
	      	      break;
			  }
	      }
	  }
	  else
	  {
		  for(int i=0;i<=4;i++)
		  {
		  Thread.sleep(30000);
		  CustomFun.refreshPage(backofficepage.driver);
		  Thread.sleep(5000);
		  CustomFun.waitForPageLoaded(backofficepage.driver);
		  String PreOrder =productlistingpage.driver.findElement(By.xpath(ObjRepoProp.get().getProperty("PDP_ProdStatus_xpath"))).getText().trim();
		  if(PreOrder.contains("COMMANDE"))
		  {
			  Assert.assertEquals(true, PreOrder.contains("COMMANDE"));
			  log.info("Successfully Verified Product Status changed to Pre-order in FO After Pre-Order Process in PIM : " + PreOrder);
			  Reporter.log("<p>Successfully Verified Product Status changed to Pre-order in FO After Pre-Order Process in PIM : " + PreOrder);
      	      break;
		  }
		  }
	  }
	 }
	 
	 @Test(description="Navigate back Into WMS, clear quantity for pre-order product so product status change again to Sold Out", priority=53)
     public void step53_NaviagtedBackIntoWMSAndClearedTheQuantityForSameProduct() throws Exception
	 {
	   CustomFun.SwitchToSpecificTab(wmspage.driver, "3");
	   wmspage.driver.findElement(By.xpath(ObjRepoProp.get().getProperty("WMS_UpdateBtnForPreOrder"))).click();
       Thread.sleep(1000);
       WebElement QntyField=wmspage.driver.findElement(By.xpath(ObjRepoProp.get().getProperty("WMS_QuantityField")));
       QntyField.clear();
       Thread.sleep(1000);
       QntyField.sendKeys("0");
       Thread.sleep(1000);
       GUIFunctions.clickElement(wmspage.driver,By.xpath(ObjRepoProp.get().getProperty("WMS_AvailabilityField")) ,"Click on Availability Field");
       Thread.sleep(1000);
       GUIFunctions.clickElement(wmspage.driver, By.xpath("(//td[@class='curMonth'])") ,"Selected Available date");
       Thread.sleep(1000);
       wmspage.driver.findElement(By.xpath(ObjRepoProp.get().getProperty("WMS_SubmitBtn"))).click();
       Thread.sleep(2000);
	 }
	 
	 @Test(description="Navigated Back to Magento & Click On Flush Magento Cache Button", priority=54)
	 public void step54_NavigatedBackToBOAndClickOnFlushMagentoCacheButton() throws Exception
	 {
	    CustomFun.SwitchToSpecificTab(backofficepage.driver, "2");
	    CustomFun.refreshPage(backofficepage.driver);
	    CustomFun.waitForPageLoaded(backofficepage.driver);
	    backofficepage.ClickOnFlushMagentoCacheButton();
        CustomFun.waitForPageLoaded(backofficepage.driver);
	 }
	 
	 @Test(description="Click on Flush Categories Cache button", priority=55)
	 public void step55_ClickOnFlushCategoriesCacheButton() throws Exception
	 {
	    backofficepage.ClickOnFlushCategoriesCacheButton();
        CustomFun.waitForPageLoaded(backofficepage.driver);
	 }
	 
	 @Test(description="Navigated Into FO and verify the status of the Product", priority=56)
     public void step56_NaviagtedIntoFOAndVerifiedProductStatusChangedToAgainSoldOutInFO() throws Exception
	 {
	  CustomFun.SwitchToSpecificTab(homepage.driver, "0");
	  if(locale.get().contains("UK_EN"))
	  {
		  for(int i=0;i<=3;i++)
		  {
			  Thread.sleep(30000);
			  CustomFun.refreshPage(backofficepage.driver);
			  Thread.sleep(5000);
			  CustomFun.waitForPageLoaded(backofficepage.driver);
			  String SoldOut =productlistingpage.driver.findElement(By.xpath(ObjRepoProp.get().getProperty("PDP_ProdStatus_xpath"))).getText().trim();
			  if(SoldOut.contains("SOLD OUT"))
			  {
	            Assert.assertEquals("SOLD OUT", SoldOut);
	            log.info("Successfully Verified Product Status changed to Sold out in FO After Pre-Order quantity cleared in WMS : " + SoldOut);
	      	    Reporter.log("<p>Successfully Verified Product Status changed to Sold out in FO After Pre-Order quantity cleared in WMS : " + SoldOut);
	      	    break;
			  }
	      }
	  }
	  else
	  {
		  for(int i=0;i<=3;i++)
		  {
			  Thread.sleep(30000);
			  CustomFun.refreshPage(backofficepage.driver);
			  Thread.sleep(5000);
			  CustomFun.waitForPageLoaded(backofficepage.driver);
			  String SoldOut =productlistingpage.driver.findElement(By.xpath(ObjRepoProp.get().getProperty("PDP_ProdStatus_xpath"))).getText().trim();
			  if(SoldOut.contains("PUIS"))
			  {
				Assert.assertEquals(true, SoldOut.contains("PUIS"));
	            log.info("Successfully Verified Product Status changed to Sold out in FO After Pre-Order quantity cleared in WMS : " + SoldOut);
	      	    Reporter.log("<p>Successfully Verified Product Status changed to Sold out in FO After Pre-Order quantity cleared in WMS : " + SoldOut);
	      	    break;
			  }
	      }
	  }
	 
	 }  
}
