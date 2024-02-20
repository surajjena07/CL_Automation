package src.in.valtech.cl.scenarios;
import static src.in.valtech.util.PropertyFileReader.ObjRepoProp;   
import static src.in.valtech.util.PropertyFileReader.TextProp;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
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

public class TC_Scenario3_Phase2 extends BaseTest
{
	public Logger log = Logger.getLogger(this.getClass().getName());
	
	HomePage homepage;
	CategoryLandingPage categorylandingpage;
	ProductListingPage productlistingpage;
	PIMPage pimpage;
	ProductDetailsPage productdetailspage;
	BackOfficePage backofficepage;
	WMSPage wmspage;
	
	public static String Size;
	public static String ref_searchable_SKUID;
	
	@Test(priority=01, description="Precondition: Open browser,Navigate to the CL URL and accept Cookies")
	public void step01_NavigatetoCLHomePage() throws Exception
	{
	logtest("Changing the product status from sold out to preorder and verify PIM changes in FO.");
	homepage =HomePage.navigateToCLApplication_URL(driver.get(),baseUrl.get());
	log.info("Successfully navigated to application URL \n");
	Reporter.log("<p>Successfully navigated to application URL");
	}
	
	@Test(description = "Mouse Over on Gentlemen L1 Category", priority = 2)
	public void step02_MouseOverElementOnGentlemenL1Category() throws Exception
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
		categorylandingpage.MouseOverOnL1GentlemenCategory();
	}

	@Test(description="Click on Greggo Category", priority=3)
	public void step03_ClickOnGreggoCategory() throws Exception
	{
		homepage.driver.findElement(By.xpath("//button[@class='action reset search']")).click();
		Thread.sleep(2000);
		homepage.driver.findElement(By.xpath("//input[@id='search']")).sendKeys("3130523bk01");
		Thread.sleep(2000);
		homepage.driver.findElement(By.xpath("//span[@class='icon icon-search']")).
		click();
		Thread.sleep(15000);
	} 
	
	@Test(description = "Click on Product Image", priority = 4)
	public void step04_ClickOnProductImg() throws Exception
	{
		productlistingpage = new ProductListingPage(categorylandingpage.driver);
		productlistingpage.Click_ProductImg();
	}
	
	@Test(description="Click on Product Info and Verified content under Product Info section", priority=5)
	public void step05_ClickonProductInfoAndVerifiedContent() throws Exception
	{
		productdetailspage=new ProductDetailsPage(productlistingpage.driver);
		productdetailspage.ClickOnSelectYourSizeBtnAndSelectAnySizeInPDP();
		Size=ProductDetailsPage.GetSizeOfProd;
		productdetailspage.pdpNotification_Closebtn();
		productdetailspage.pdpProductInfoBlock();
		ref_searchable_SKUID=ProductDetailsPage.Ref_searchable_sku;
	}
	
	@Test(description = "Open New Tab and Navigate to the PIM Application", priority = 6)
	public void step06_OpenNewTabAndNavigatedtoPIM() throws Exception
	{
		pimpage = new PIMPage(homepage.driver);
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
	
	@Test(priority=10, description = "Click on EU Locale Category in PIM Home Page")
	public void step10_ClickOnEULocaleCategory() throws Exception
	{
		pimpage.ClickOnEULocaleCategory();
	}
	
	@Test(priority=11, description = "Entered SKU ID in Search Field")
	public void step11_EnterSKUIDInSearchField() throws Exception
	{
		pimpage.SKUIDSearchField("3130523bk01");
	}
	
	@Test(priority=12, description = "Click on Product row from filter results")
	public void step12_ClickOnProductRow() throws Exception
	{
		pimpage.ClickOnProductRow();
	}
	
	@Test(priority=13, description = "Scroll down till Product Description field and change product description")
	public void step13_ScrolldownTillProductDescriptionAndChangeProductDescription() throws Exception
	{
		if(locale.get().contains("FR_FR") | locale.get().contains("CH_FR"))
		{
		  String prod_des_fr_en_text=TextProp.get().getProperty("ProductDescriptiontxt_FR");
		  pimpage.ScrolldownTillProductDescriptionAndChangeProductDescription(prod_des_fr_en_text);
		}
		else
		{
		  String prod_des_uk_en_text=TextProp.get().getProperty("ProductDescriptiontxt_UK");
		  pimpage.ScrolldownTillProductDescriptionAndChangeProductDescription(prod_des_uk_en_text);
		}
	}
	
	@Test(priority=14, description = "upload additional gallery image")
	public void step14_UploadAdditionalGalleryImage() throws Exception
	{
		pimpage.UploadAdditionalGalleryImage();
	}
	
	@Test(priority=15, description = "Enter product Vimeo video link in Description Video Field")
	public void step15_EnterDescriptionVideoLink() throws Exception
	{
		if(locale.get().contains("FR_FR") | locale.get().contains("CH_FR"))
		{
		 String desvideolink_fr_text=TextProp.get().getProperty("DescriptionVideoLinktxt_FR");
		 pimpage.EnterDescriptionVideoLink(desvideolink_fr_text);
		}
		else
		{
		 String desvideolink_uk_text=TextProp.get().getProperty("DescriptionVideoLinktxt_UK");
		 pimpage.EnterDescriptionVideoLink(desvideolink_uk_text);
		}
	}
	
	@Test(priority=16, description = "Click on Save button")
	public void step16_ClickOnSaveButton() throws Exception
	{
		pimpage.ClickOnSaveButton();
		CustomFun.waitForPageLoaded(pimpage.driver);
	}
	
	@Test(priority=17, description = "Click on Back button")
	public void step17_ClickOnBackButton() throws Exception
	{
		pimpage.driver.navigate().back();
		CustomFun.waitForPageLoaded(pimpage.driver);
	}
	
	@Test(priority=18, description = "Click on Exports icon from Left menu")
	public void step18_ClickOnExportsIcon() throws Exception
	{
		pimpage.ClickOnExportsIcon();
	}
	
	@Test(priority=19, description = "Click on 3 dots ( . . .) icons at top right ")
	public void step19_ClickOnThreeDotsIcon() throws Exception
	{
		pimpage.ClickOnThreeDotsIcon();
	}
	
	@Test(priority=20, description = "Select respective store")
	public void step20_SelectRespectiveStoreForExports() throws Exception
	{
	
		pimpage.SelectRespectiveStoreForExports(environmentName);
	}
	
	@Test(priority=21, description = "Click on Start Export CTA")
	public void step21_ClickOnStartExportsButton() throws Exception
	{
		pimpage.ClickOnStartExportsButton();
	}
	
	@Test(priority=22, description = "Click on Activity tab")
	public void step22_ClickOnActivitytab() throws Exception
	{
		pimpage.ClickOnActivitytab();
	}
	
	@Test(priority=23, description = "Click on Process tracker")
	public void step23_ClickOnProcesstracker() throws Exception
	{
		pimpage.ClickOnProcesstracker();
	}
	
	@Test(priority=24, description = "Verify The Jobs Status For Recently Exported Jobs")
	public void step24_VerifyJobsStatusForRecentlyExportedJobs() throws Exception
	{
		pimpage.VerifyJobsStatusForRecentlyExportedJobs();
	} 
	
	@Test(description="Open New Tab and Navigated to Magento BO", priority=25)
    public void step25_OpenNewTabAndNavigatedtoMagentoBO() throws Exception
    {
      backofficepage=new BackOfficePage(homepage.driver);
      CustomFun.OpenNewTabAndSwitchToNewTab(backofficepage.driver, "2");
      backofficepage.driver.navigate().to(CustomFun.getBODSDetails().get().getBO_URL());
    }
    
    @Test(description="Entered Username in Username Field", priority=26)
    public void step26_EnteredUsernameField() throws Exception
    {
    backofficepage.EnterUsername(CustomFun.getBODSDetails().get().getBO_Username());
    }
    
    @Test(description="Entered Password in Password Field", priority=27)
    public void step27_EnteredPasswordField() throws Exception
    {
    backofficepage.EnterPassword(CustomFun.getBODSDetails().get().getBO_Password());
    }
    
    @Test(description="Click on SignIn Button", priority=28)
    public void step28_ClickOnSignInButton() throws Exception
    {
    	backofficepage.SignbtnClick();
    	if(environmentName.contains("IntegrationEnv") | environmentName.contains("HomoEnv1") | environmentName.contains("StagingEnv") | environmentName.contains("Integration6Env"))
	    {
			Thread.sleep(5000);
			CustomFun.refreshPage(backofficepage.driver);
			Thread.sleep(5000);
		}
    }
    
    @Test(description="Verified Dashboard Header & check whether user is in Dashboard page", priority=29)
    public void step29_VerifiedDashboardHeaderInBO() throws Exception
    {
          CustomFun.waitForPageLoaded(backofficepage.driver);
          if(environmentName.contains("StagingEnv"))
  	    {
  			Thread.sleep(5000);
  			CustomFun.refreshPage(backofficepage.driver);
  			Thread.sleep(5000);
  		}
          backofficepage.VerifyDashboardHeader();
    }
    
    @Test(description="Click on System Icon", priority=30)
    public void step30_ClickOnSystemIcon_INT6() throws Exception
    {
          if(environmentName.contains("IntegrationEnv"))
	  	   {
        	  backofficepage.ClickOnSystemIcon_INT6();
	  	   }
          else
          {
        	  backofficepage.ClickOnSystemIcon(environmentName);
          }
    }
    
    @Test(description="Click on Index Management text from System Icon", priority=31)
    public void step31_IndexManagementFromSystemIconClick() throws Exception
    {
          backofficepage.IndexManagementFromSystemIconClick();
          CustomFun.waitForPageLoaded(backofficepage.driver);
    }
    
    @Test(description="Index Launching in Index Management For Exports", priority=32)
    public void step32_IndexLaunchingForExports() throws Exception
    {
          backofficepage.IndexLaunchingForExports();
    }
    
    @Test(description="Click on System Icon", priority=33)
    public void step33_ClickOnSystemIcon_INT6() throws Exception
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
    
    @Test(description="Click on Cache Management text from System Icon", priority=34)
    public void step34_CacheManagementtextFromSystemIconClick() throws Exception
    {
          backofficepage.CacheManagementtxtFromSystemIconClick();
          CustomFun.waitForPageLoaded(backofficepage.driver);
    }
    
    @Test(description="Click on Flush Magento Cache Button", priority=35)
    public void step35_ClickOnFlushMagentoCacheButton() throws Exception
    {
         backofficepage.ClickOnFlushMagentoCacheButton();
         CustomFun.waitForPageLoaded(backofficepage.driver);
    }
    
    @Test(description="Click on Flush Categories Cache button", priority=36)
	public void step36_ClickOnFlushCategoriesCacheButton() throws Exception
	{
	   backofficepage.ClickOnFlushCategoriesCacheButton();
       CustomFun.waitForPageLoaded(backofficepage.driver);
	}
    
    @Test(description="Verify Exports job log's in BO", priority=37)
    public void step37_VerifyExportsJobLogsInBO() throws Exception
    {
    	if(environmentName.contains("Integration6Env"))
        {
        backofficepage.ClickOnSystemIcon_INT6();
        }
        else
        {
     	   backofficepage.ClickOnSystemIcon(environmentName);
        }
          backofficepage.LogFromSystemIconClickAndVerifyExportsJobLogs();
          log.error("Verified Exports job log's processed in BO");
		  Reporter.log("<p>Verified Exports job log's processed in BO");
    }
   	
    @Test(description="Click on Catalog Icon", priority=38)
	 public void step38_NavigatedBackInBOAndClickOnCatalogIcon() throws Exception
	 {
		 CustomFun.SwitchToSpecificTab(backofficepage.driver, "2");
	     backofficepage.CatalogIconClick();
	 }
	    
	 @Test(description="Click on Products text from Catalog Icon", priority=39)
	 public void step39_ClickProductstxtFromCatalogIcon() throws Exception
	 {
	      backofficepage.ProductstxtFromCatalogIconClick();
	      CustomFun.waitForPageLoaded(backofficepage.driver);
	 }
	    
	 @Test(description="enter SKU and select exact store view", priority=45)
     public void step45_FilterProductByEnteringSKUIDAndSelectStoreViewInBO() throws Exception
	 {
	     backofficepage.FilterProductByEnteringSKUIDAndSelectStoreViewInBO(ref_searchable_SKUID, locale.get());
	 }
	 
	 @Test(description="Click on the Product Row in the Product Field & verify the Scope of Store view", priority=46)
	 public void step46_ClickOnProductRowFromFilterResult() throws Exception
    {
		 backofficepage.driver.findElement(By.xpath(ObjRepoProp.get().getProperty("BO_ProductRow"))).click();
		 CustomFun.waitForPageLoaded(backofficepage.driver);
		 Thread.sleep(5000);
		 String ExpectedStroreView=backofficepage.driver.findElement(By.xpath(ObjRepoProp.get().getProperty("BO_ExpectedStoreView"))).getText().trim();
		 Assert.assertEquals(BackOfficePage.ActualStoreView, ExpectedStroreView);
		 log.info("Successfully Click on the Product Row and verify the Scope of Store view");
		 Reporter.log("<p>Successfully Click on the Product Row and verify the Scope of Store view");
	 }
	
	 @Test(description="Scroll down and click on the Images And Videos Tab", priority=47)
	 public void step47_ScrollDownAndClickOnTheImagesAndVideosTab() throws Exception
     {
		 backofficepage.ScrollDownAndClickOnImagesAndVideosTab();
	 }
	 
	 @Test(description="Verify the added Image and Product Video link under Images And Videos Tab", priority=48)
	 public void step48_VerifiedTheAddedImageAndProductVideolinkkUnderImagesAndVideosTab() throws Exception
	 {
		 Assert.assertEquals(true, backofficepage.driver.findElement(By.xpath("(//img[@class='product-image'])[3]")).isDisplayed());
		 log.info("Successfully Verified the added Image and Product Video link under Images And Videos Tab");
		 Reporter.log("<p>Successfully Verified the added Image and Product Video link under Images And Videos Tab");
	 }
	 
	 @Test(description="Scroll down and click on the Description Tab", priority=49)
	 public void step49_ScrollDownAndClickOnTheDescriptionTab() throws Exception
     {
		 backofficepage.ScrollDownAndClickOnDescriptionTab();
		 Thread.sleep(5000);
	 }
	 
	 @Test(description="Verify the added Product Description under Description Tab", priority=50)
	 public void step50_VerifyTheAddedProductDescriptionUnderDescriptionTab() throws Exception
	 {
		 String ExpDes=backofficepage.driver.findElement(By.xpath("//*[@class='admin__control-textarea mgz-hidden']")).getText();
		 if(locale.get().contains("UK_EN"))
		 {
		     String ActDes=TextProp.get().getProperty("ProductDescriptiontxt_UK");
		     Assert.assertEquals(true, ActDes.contains(ExpDes));
		 }
		 else
		 {
			 String ActDes=TextProp.get().getProperty("ProductDescriptiontxt_FR"); 
			 Assert.assertEquals(true, ActDes.contains(ExpDes));
		 }
         log.info("Successfully Verified the added Product Description under Description Tab");
		 Reporter.log("<p>Successfully Verified the added Product Description under Description Tab");
	 }
	 
	 @Test(description="Navigated Into FO", priority=51)
     public void step51_NaviagtedIntoFO() throws Exception
	 {
	  CustomFun.SwitchToSpecificTab(homepage.driver, "0");
	  backofficepage.driver.navigate().refresh();
	  CustomFun.waitForPageLoaded(homepage.driver);
	 }  
	 
	 @Test(description="Verify newly added product img & product description in FO", priority=52)
     public void step52_VerifiedNewlyAddedProductImgAndDescriptionInFO() throws Exception
	 {
		 productdetailspage=new ProductDetailsPage(backofficepage.driver);
		 productdetailspage.ClickOnAllJuicyDetailsBlock();
		 String ExpDes_FO=ProductDetailsPage.juicydetails;
		 if(locale.get().contains("UK_EN"))
		 {
			  // Verify Product Img
			  Assert.assertEquals(true, productdetailspage.driver.findElement(By.xpath("//div[contains(@class,'thumbs')]//img[contains(@src,'auto')]")).isDisplayed());
			  // Verify Product Description
		      String ActDes_FO=TextProp.get().getProperty("ProductDescriptiontxt_UK");
		      Assert.assertEquals(true, ActDes_FO.contains(ExpDes_FO));
		 }
		 else
		 {
			 // Verify Product Img
			  Assert.assertEquals(true, productdetailspage.driver.findElement(By.xpath("//div[contains(@class,'thumbs')]//img[contains(@src,'auto')]")).isDisplayed());
			 // Verify Product Description
			 String ActDes_FO=TextProp.get().getProperty("ProductDescriptiontxt_FR"); 
			 Assert.assertEquals(true, ActDes_FO.contains(ExpDes_FO));
		 }
         log.info("Successfully Verified the newly added Product Img & Product Description in FO");
		 Reporter.log("<p>Successfully Verified the newly added Product Img & Product Description in FO");
	 }  
}
