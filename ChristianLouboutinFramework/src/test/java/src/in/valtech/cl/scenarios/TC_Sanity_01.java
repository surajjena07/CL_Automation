package src.in.valtech.cl.scenarios;
import static src.in.valtech.util.PropertyFileReader.ObjRepoProp; 
import static src.in.valtech.util.PropertyFileReader.TextProp;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import src.in.valtech.cl.back.pages.BackOfficePage;
import src.in.valtech.cl.back.pages.WMSPage;
import src.in.valtech.cl.front.pages.CheckoutPage;
import src.in.valtech.cl.front.pages.HomePage;
import src.in.valtech.cl.front.pages.MyAccountPage;
import src.in.valtech.cl.front.pages.OrderConfirmationPage;
import src.in.valtech.cl.front.pages.PaymentPage;
import src.in.valtech.cl.front.pages.ProductDetailsPage;
import src.in.valtech.cl.front.pages.ProductListingPage;
import src.in.valtech.cl.front.pages.ShippingAddressPage;
import src.in.valtech.config.BaseTest;
import src.in.valtech.custom.CustomFun;
import src.in.valtech.uifunctions.GUIFunctions;
import src.in.valtech.util.Emails;

public class TC_Sanity_01 extends BaseTest
{
	public static String OrderID;
	public String OrderStatus; 
	public String BarCodeForScan;
	public MyAccountPage RMA_ID_FO;
	public String RefundMemoID;
	public static String RMAID;
	public String RMAIDStatus;
	public String ShipmentID;
	
	public Logger log = Logger.getLogger(this.getClass().getName());
	
	HomePage homepage;
	MyAccountPage myaccountpage;
	ProductListingPage productlistingpage;
	ProductDetailsPage productdetailspage;
	CheckoutPage checkoutpage;
	ShippingAddressPage shippingaddresspage;
	PaymentPage paymentpage;
	OrderConfirmationPage orderconfirmationpage;
	BackOfficePage backofficepage;
	WMSPage wmspage;
	
	@Test(priority=01, description="Precondition: Open browser,Navigate to the CL URL and accept Cookies")
	public void step01_NavigatetoCLHomePage() throws Exception
	{
	  logtest("Create a refund credit memo");
	  System.out.println("step 1 begin");
	  homepage =HomePage.navigateToCLApplication_URL(driver.get(),baseUrl.get());
      log.info("Successfully navigated to application URL \n");
      Reporter.log("<p>Successfully navigated to application URL");
	  System.out.println("step 1 end");
	}
	
	
	@Test(priority=02, description=" Mouseover on Men Header navigation ")
	public void step02_MouseOverOnMenHeaderNavigation() throws Exception
	{
		if(locale.get().contains("FR_FR") | bsValue.get().contains("YES") | locale.get().contains("CH_FR"))
		{
			for (int i = 0; i <= 1; i++)
			{
				Thread.sleep(10000);
				CustomFun.refreshPage(homepage.driver);
				Thread.sleep(10000);
			}
			 GUIFunctions.pageScrollToTopOfPage(homepage.driver);
		}
    	myaccountpage=new MyAccountPage(homepage.driver);
	    if(environmentName.contains("HomoEnv"))
     	{
	    GUIFunctions.pageScrollToTopOfPage(homepage.driver);
		homepage.mousehoverOnHeaderNavigation();
		log.info("Mouseover on Men Header navigation");
	    }
	    else
	    {
	    GUIFunctions.pageScrollToTopOfPage(homepage.driver);
		homepage.mousehoverOnLadiesHeaderNavigation();
		log.info("Mouseover on Ladies Header navigation");
	    }
	} 
	
	@Test(priority=03, description=" Click On shoes Subcategory ")
	public void step03_ClickOnShoesSubcategory() throws Exception
	{
	if(environmentName.contains("HomoEnv"))
	{
		homepage.ClickOnSubcategory();
		log.info("Click On shoes Subcategory");
	}
	else
	{
		homepage.ClickOnL2KateCategory();
		log.info("Click On shoes Subcategory");
	}
	} 
	
	@Test(priority=04, description=" Click on product from PLP ")
	public void step04_ClickOnProductImg() throws Exception
	{
      productlistingpage=new ProductListingPage(homepage.driver);
      productlistingpage.Click_ProductImg();
	}
	
	@Test( priority=05,description="Click On Select_Your_Size Button and Select any Size")
	public void step05_ClickOnSelectYourSizeButtonAndSelectAnySize() throws Exception
	{
      productdetailspage=new ProductDetailsPage(productlistingpage.driver);
	  productdetailspage.ClickOnSelectYourSizeBtnAndSelectAnySizeInPDP();
	}
	
	@Test(priority=06,description="Click on Add To Cart Button")
	public void step06_ClickonAddToCartButton() throws Exception
	{
	  productdetailspage.pdpAddtoCartbtn();	
	  productdetailspage.pdpNotification_Ordernowbtn();
	}
	
	@Test(priority=07,description="Enter Username for Login field from checkout page  ")
	public void step07_EnterUsername_ForLoginINCheckoutpage() throws Exception
	{
		checkoutpage=new CheckoutPage(productdetailspage.driver);	
		checkoutpage.EnterEmailAddress_asGU(CustomFun.getUserInfoDSDetails().get().getEmailDomain());
	}
	
	@Test(priority=8,description="Enter password for Login field from checkout page  ")
	public void step08_EnterPassword_ForLoginINCheckoutpage() throws Exception
	{	
		checkoutpage.EnterPassword_asGU(CustomFun.getUserInfoDSDetails().get().getPassword());
	}
	
	@Test(priority=9, description="Click on SignIn Button for Login field from checkout page")
	public void step09_ClickOnLoginInButton_ForLoginINCheckoutpage() throws Exception
	{
		checkoutpage.LoginBtnClick_AsGU();	
	}
	
	@Test(priority=10,description="Verify Gift header text and default no wrap img selected ")
	public void step10_VerifyGiftHeadertextAndDefaultGiftWrapSelected() throws Exception
	{
		checkoutpage.VerifyGiftHeadertxt();
		checkoutpage.VerifyNoWarpImgIsSelected();
	}
	
	@Test(priority=11,description="Enter message in Gift msg fld ")
	public void step11_EnterMsgInGiftMsgFld() throws Exception
	{
		checkoutpage.ScrollDowntillYourMsgField_EnterMsg("HBD");
	}
	
	@Test(priority=12,description="Click on update button ")
	public void step12_ClickUpdateBtn() throws Exception
	{	
		checkoutpage.UpdatebtnClick();
	}

	@Test(priority=13,description="Click on any existing address")
	public void step13_ClickonExistingAdressinShipping() throws Exception
	{
		shippingaddresspage=new ShippingAddressPage(checkoutpage.driver);	
		shippingaddresspage.VerifyShippingAddressHeader();		
		if(!GUIFunctions.isElementPresent((By.xpath(ObjRepoProp.get().getProperty("ExistShippingAddress_xpath"))), shippingaddresspage.driver))
    	{
			for(int i=0;i<=2;i++)
			{
			 CustomFun.refreshPage(shippingaddresspage.driver);
			 Thread.sleep(5000);
	    	 CustomFun.waitForPageLoaded(shippingaddresspage.driver);
			}
			GUIFunctions.JavaScriptClick(shippingaddresspage.driver, shippingaddresspage.driver.findElement(By.xpath(ObjRepoProp.get().getProperty("ExistShippingAddress_xpath"))),
					 "click on Exist Shipping Address");
    	}
    	else
    	{
    		GUIFunctions.JavaScriptClick(shippingaddresspage.driver, shippingaddresspage.driver.findElement(By.xpath(ObjRepoProp.get().getProperty("ExistShippingAddress_xpath"))),
					 "click on Exist Shipping Address");
    	}
	}

	@Test(priority=14,description="Click on first Shipping method  ")
	public void step14_ClickOnShippingmethod() throws Exception
	{		
		shippingaddresspage.FirstShippingMethodRadioBtnClick();
	}  
	
	@Test(priority=15,description="Click on Continue to payment btn  ")
	public void step15_ClickOnContinuetopaymentbtn() throws Exception
	{	
		shippingaddresspage.ContinuetopaymentbtnClick();
	}  
	
	@Test(priority=16,description="Click on Credit card Radio button under Payment option")
	public void step16_ClickOnCreditCardRadioBtnAndVerifyPaymentoptions() throws Exception
	{
	paymentpage=new PaymentPage(shippingaddresspage.driver);	
	paymentpage.checkout_Paymentoptions();
	paymentpage.checkout_Creditcard();
	}
	
	@Test(priority=17,description="Entered Credit Number in Credit Number Field" )
	public void step17_EnteredCreditNumberField() throws Exception
	{
	paymentpage.checkout_CCCardnumber(CustomFun.getPaymentDSDetails().get().getCardNumber());
	}
	
	@Test(priority=18,description="Entered Expiry Date in Expiry Date Field")
	public void step18_EnteredExpiryDateField() throws Exception
	{
	paymentpage.checkout_CCExpirydate(CustomFun.getPaymentDSDetails().get().getCardExpiryDate());
	}
	
	@Test(priority=19,description="Entered CVV in CVV Field")
	public void step19_EnteredCVVField() throws Exception
	{
	paymentpage.checkout_CCV(CustomFun.getPaymentDSDetails().get().getCardCVV());
	}	
	
	@Test(priority=20,description="Entered CardHolder Name in CardHolder Name Field")
	public void step20_EnteredCardHolderField() throws Exception
	{
	paymentpage.checkout_Cardholdername(CustomFun.getPaymentDSDetails().get().getCardHolderName());
	}

	@Test(priority=21,description="Verified privacy policy checkbox 1 and 2 text ")
	public void step21_VerifiedAndCheckedPaymentPrivacyPolicyCheckbox() throws Exception
	{
//	paymentpage.checkout_VerifyCheckboxText();
	paymentpage.checkout_Agreements_CreditCard();
	}
	
	@Test( priority=22,description="Click on Proceed button in Checkout page at Payment Section")
	public void step22_ClickOnProceedButton() throws Exception
	{
	 if(environmentName.contains("IntegrationEnv"))
	  {
		  paymentpage.driver.findElement(By.xpath("(//button[contains(@class,'action primary checkout')])[1]")).click();
		  Thread.sleep(1000);
	  }
	  else
	  {
	    paymentpage.checkout_CC_Proceedbtn_credit();
	  }
	}

	@Test(priority=23,description="Verified Success Message in Order Confirmation page after placing the order")
	public void step23_VerifiedSuccessMsgAfterPlacingOrder() throws Exception
	{		
	orderconfirmationpage=new OrderConfirmationPage(paymentpage.driver);
	CustomFun.waitForPageLoaded(orderconfirmationpage.driver);
	orderconfirmationpage.Verify_SuccessOrder_Msg_txt();
	}
	
	@Test(priority=24,description="Verified Your OrderID in Order Confirmation page")
	public void step24_VerifiedYourOrderID() throws Exception
	{	
	orderconfirmationpage.VerifyOrderIDInOCP();
	OrderID=OrderConfirmationPage.OrderConfirmationId.replaceAll("[^0-9.]", "");
	System.out.println("Successfully Saved Order ID for further execution - "+OrderID);
	}
	
	@Test(description="Open New Tab and Navigated to Magento BO", priority=25)
    public void step25_OpenNewTabAndNavigatedtoMagentoBO() throws Exception
    {
      backofficepage=new BackOfficePage(homepage.driver);
      CustomFun.OpenNewTabAndSwitchToNewTab(backofficepage.driver, "1");
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
          CustomFun.waitForPageLoaded(backofficepage.driver);
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
          backofficepage.VerifyDashboardHeader();
    }
    
    @Test(description="Navigated Back to Magento & Click on Sales Icon", priority=30)
   	public void step30_NavigatedBackToBOAndClickOnSalesIcon() throws Exception
   	{
   		backofficepage.SalesIconClick();
   	}
   	
   	@Test(description="Click on Orders text from Sales Icon", priority=31)
   	public void step31_ClickOrderstxtFromSalesIcon() throws Exception
   	{
   		backofficepage.OrderstxtFromSalesIconClick();
   	}
   	
   	@Test(description="Enter order Id in serach bar and click on search ", priority=32)
   	public void step32_EnterOrderIDInBOSearchFld() throws Exception
   	{
   		backofficepage.EnterOrderId(OrderID);
   		backofficepage.SearchIconClick();	
   	}   
   	
   	@Test(description="Verified Order Status in Orders page", priority=33)
   	public void step33_VerifiedOrderStatusInOrdersPage() throws Exception
   	{
   		backofficepage.VerifyOrderStatusInBO_OrdersPage(OrderID);
   		OrderStatus=BackOfficePage.OrderStatus;
   		for(int i=0;i<=4;i++)
		{
		Thread.sleep(10000);
		CustomFun.refreshPage(backofficepage.driver);
		Thread.sleep(5000);
		backofficepage.VerifyOrderStatusInBO_OrdersPage(OrderID);	
		OrderStatus=BackOfficePage.OrderStatus;
		if(OrderStatus.contains(TextProp.get().getProperty("SenttoLogistictxt")))
        {
             Assert.assertEquals(TextProp.get().getProperty("SenttoLogistictxt"), OrderStatus);
             break;
        }
		}
   	} 
   	
 	@Test(description="Trigger Cron Job lists in BO if order status not changed from Payment Authorized", priority=34)
   	public void step34_TriggerCronJobListsInBOIfOrderStatusNotChanged() throws Exception
   	{
		if(OrderStatus.contains(TextProp.get().getProperty("SenttoLogistictxt")))
        {
             Assert.assertEquals(TextProp.get().getProperty("SenttoLogistictxt"), OrderStatus);
             log.info("Successfully Verified Order Status in Magento After accepted order in adyen: " + OrderStatus);
             Reporter.log("<p>Successfully Verified Order Status in Magento After accepted order in adyen: " + OrderStatus);
        }
		else
		{     
			backofficepage.TriggerCronJobListsInBOIfOrderStatusNotChanged();
		}
		backofficepage.SalesIconClick();
    	backofficepage.OrderstxtFromSalesIconClick();
		for(int i=0;i<=12;i++)
		{
		Thread.sleep(10000);
		CustomFun.refreshPage(backofficepage.driver);
		Thread.sleep(5000);
		backofficepage.VerifyOrderStatusInBO_OrdersPage(OrderID);	
		OrderStatus=BackOfficePage.OrderStatus;
		if(OrderStatus.contains(TextProp.get().getProperty("SenttoLogistictxt")))
        {
             Assert.assertEquals(TextProp.get().getProperty("SenttoLogistictxt"), OrderStatus);
             break;
        }
		}
   	}
 	
 	
 	@Test(description = "Verified Order Confirmation Mail and Subject line of Mail in Customer Gmail Account", priority = 35)
	public void step35_VerifiedOrderConfirmationMailAndSubjectLineInCustomerGmailAccount() throws Exception
    {
    	String EmailID=CustomFun.getUserInfoDSDetails().get().getEmailDomain();
    	String Password=CustomFun.getUserInfoDSDetails().get().getAppPassword();	
		if(locale.get().contains("FR_FR"))
		{
		    Emails.verifyEmailSubjectLine("" + EmailID + "" + ":" + "" + Password + "", "Christian Louboutin Europe Online Boutique: Nouvelle commande # " + OrderID);
		}
		else
		if(locale.get().contains("UK_EN"))
		{
			Emails.verifyEmailSubjectLine("" + EmailID + "" + ":" + "" + Password + "", "Christian Louboutin Europe Online Boutique: New order # " + OrderID);
		}
		else
		{
			Emails.verifyEmailSubjectLine("" + EmailID + "" + ":" + "" + Password + "", "Christian Louboutin Europe Online Boutique: New order # " + OrderID);
		}
		Reporter.log("Successfully Verified Order Confirmation Mail & Subject Line : " + Emails.strMailSubject);
		Reporter.log("<p>Successfully Verified Order Confirmation Mail Received Time : " + Emails.strReceivedMailTime);
    }
 	
 	@Test(description="Open New Tab and Navigated to WMS", priority=36)
	public void step36_OpenNewTabAndNavigatedtoWMS() throws Exception
	{
	wmspage=new WMSPage(productdetailspage.driver);
	CustomFun.OpenNewTabAndSwitchToNewTab(wmspage.driver, "2");
	wmspage.driver.navigate().to(CustomFun.getWMSInfoDSDetails().get().getWMSURL());
	}

	@Test(description="Logged into WMS with valid crendentials", priority=37)
	public void step37_LoggedIntoWMS() throws Exception
	{
	wmspage.WMSLogIn(CustomFun.getWMSInfoDSDetails().get().getWmsUsername(),CustomFun.getWMSInfoDSDetails().get().getWmsPassword());
	}

	@Test(description="Click on OK button in WMS", priority=38)
	public void step38_ClickOnOKbutton() throws Exception
	{
		    wmspage.Click_WMSOKBtn();
	}
	
	    @Test(description="Navigated into WMS & Picking Order Process", priority=39)
	    public void step39_NavigatedBackIntoWMSANDPickingOrderProcess() throws Exception
	    {
	          wmspage.PickingOrderProcess(OrderID);
	    }
	    
	    @Test(description="Verified Picking order for # XXXXX", priority=40)
	    public void step40_VerifiedPickingOrderSuccessMsg() throws Exception
	    {
	          wmspage.VerifyPickingOrderSuccessMsg();
	    }
	    
	    @Test(description=" Get BarCode From Picking Process", priority=41)
	    public void step41_GetBarcodeFromPickingProcess() throws Exception
	    {
	          wmspage.getBarCodeFromPickingProcess(OrderID);
	          BarCodeForScan=WMSPage.BarCodeId;
	    }
	    
	    @Test(description="Navigated Into Magento and Verified Order Status in Orders page", priority=42)
	    public void step42_NaviagtedIntoMangetoAndVerifiedOrderStatusInOrdersPage() throws Exception
	    {
	    	CustomFun.SwitchToSpecificTab(backofficepage.driver, "1");
	    	CustomFun.refreshPage(backofficepage.driver);
			CustomFun.waitForPageLoaded(backofficepage.driver);
			backofficepage.VerifyOrderStatusInBO_OrdersPage(OrderID);
		    OrderStatus=BackOfficePage.OrderStatus;
		    Assert.assertEquals(TextProp.get().getProperty("PickingProgresstxt"), OrderStatus);
		    log.info("Successfully Verified Order Status in Magento After Picking Process: " + OrderStatus);
			Reporter.log("<p>Successfully Verified Order Status in Magento After Picking Process: " + OrderStatus);
	    }
	    
	    @Test(description="Navigated Into WMS and Click on Packing Button", priority=43)
	    public void step43_NavigatedIntoWMSAndClickOnPackingBtn() throws Exception
	    {
	          CustomFun.SwitchToSpecificTab(wmspage.driver, "2");
	          wmspage.Click_WMSPackingBtn();
	    }
	    
	    @Test(description="Entered BarcodeID in Barcode Field And Search For Packing", priority=44)
	    public void step44_EnteredBarcodeAndSearchForPacking() throws Exception
	    {
	          wmspage.EnterBarcodeAndSearchForPacking(BarCodeForScan);
	    }
	    
	    @Test(description="Copy SKUID And Enter in Search Field For Scanning Products In Packing", priority=45)
	    public void step45_CopySKUIDAndEnterinSearchFeildForScanningProductsInPacking() throws Exception
	    {
	            By ele=By.xpath(ObjRepoProp.get().getProperty("WMS_SKUID_xpath"));  
				int TotalScanCount = wmspage.driver.findElements(By.xpath(ObjRepoProp.get().getProperty("WMS_TotalScanCount_xpath"))).size();
				for(int i=0;i<TotalScanCount;i++)
				{
				  String SkuId=wmspage.driver.findElements(ele).get(i).getText().replaceAll("[^0-9.]", "");
				  Thread.sleep(2000);
				  By WMS_SKUID_serachfield= By.xpath(ObjRepoProp.get().getProperty("WMS_SKUID_serachfield_xpath"));  
			      GUIFunctions.typeTxtboxValue(wmspage.driver,WMS_SKUID_serachfield, SkuId);
			      Thread.sleep(2000);
				}
	    }
	    
	    @Test(description="Click on Complete Packing button", priority=46)
	    public void step46_ClickOnCompletePackingBtn() throws Exception
	    {
	          wmspage.Click_CompletePackingBtn();
	    }
	    
	    @Test(description="Enter quantity in front of any row", priority=47)
	    public void step47_EnteredQuantityInAnyRow() throws Exception
	    {
	          wmspage.EnterQuantity_Packing("1");
	    }
	    
	    @Test(description="Click on Validate button", priority=48)
	    public void step48_ClickOnValidateBtn() throws Exception
	    {
	          wmspage.ClickValidate_Packing();
	    }
	    
	    @Test(description="Click on Home Popup button", priority=49)
	    public void step49_ClickOnHomePopupBtn() throws Exception
	    {
	          wmspage.ClickHomeBtn_PopUp();
	    }   
	    
	    @Test(description="Navigated Into Magento and Verified Order Status in Orders page", priority=50)
	    public void step50_NavigatedIntoMangetoAndVerifiedOrderStatusInOrdersPage() throws Exception
	    {
	          CustomFun.SwitchToSpecificTab(backofficepage.driver, "1");
	          CustomFun.refreshPage(backofficepage.driver);
	          CustomFun.waitForPageLoaded(backofficepage.driver);
	          backofficepage.VerifyOrderStatusInBO_OrdersPage(OrderID);
	          OrderStatus=BackOfficePage.OrderStatus;
	          Assert.assertEquals(TextProp.get().getProperty("Invoicedtxt"), OrderStatus);
	          log.info("Successfully Verified Order Status in Magento After Packing Process is completed: " + OrderStatus);
	          Reporter.log("<p>Successfully Verified Order Status in Magento After Packing Process is completed: " + OrderStatus);
	    }
	    
	    @Test(description="Navigated Into WMS and Processed with Shipping Process", priority=51)
	    public void step51_NavigatedIntoWMSAndProcessedwithShippingProcess() throws Exception
	    {
	          CustomFun.SwitchToSpecificTab(wmspage.driver, "2");
	          wmspage.ShippingOrderProcess(BarCodeForScan);
	    }
	    
	    @Test(description="Navigated Into Magento and Verified Order Status in Orders page", priority=52)
	    public void step52_NavigatedIntoMangetoAndVerifiedOrderStatusInOrdersPage() throws Exception
	    {
	          CustomFun.SwitchToSpecificTab(backofficepage.driver, "1");
	          CustomFun.refreshPage(backofficepage.driver);
	          CustomFun.waitForPageLoaded(backofficepage.driver);
	          backofficepage.VerifyOrderStatusInBO_OrdersPage(OrderID);
	          OrderStatus=BackOfficePage.OrderStatus;
	          Assert.assertEquals(TextProp.get().getProperty("Shippedtxt"), OrderStatus);
	          log.info("Successfully Verified Order Status in Magento After Shipping Process is completed: " + OrderStatus);
	          Reporter.log("<p>Successfully Verified Order Status in Magento After Shipping Process is completed: " + OrderStatus);
	    }
	    
	    @Test(description = "Switch to FO Tab & Click on My Account Icon", priority = 53)
		public void step53_SwitchToFOTabAndClickOnMyAccountIcon() throws Exception {
			CustomFun.SwitchToSpecificTab(backofficepage.driver, "0");
			homepage.driver.findElement(By.xpath(ObjRepoProp.get().getProperty("HP_MyAccount_Icon"))).click();
		}

		@Test(description = "Click on My Orders Link", priority = 54)
		public void step54_ClickOnMyOrdersLink() throws Exception {
			myaccountpage.MyOrders_LnkClick();
		}

		@Test(description = "Verified Order Status in My Orders page", priority = 55)
		public void step55_VerifiedOrderStatusInMyOrdersPageAfterShippingProcessIsCompletedInWMS() throws Exception {
			myaccountpage.VerifyOrderStatus(OrderID);
			if(locale.get().contains("FR_FR") | locale.get().contains("CH_FR"))
			{
			Assert.assertEquals(MyAccountPage.OrderStatusFromFO,TextProp.get().getProperty("OrderShippedtxt_FR"));
			}
			else
			{
			Assert.assertEquals(MyAccountPage.OrderStatusFromFO,TextProp.get().getProperty("OrderShippedtxt_UK"));	
			}
		    log.info("Successfully Verified Order Status in My orders page: " + MyAccountPage.OrderStatusFromFO);
		    Reporter.log("<p>Successfully Verified Order Status in My orders page: " + MyAccountPage.OrderStatusFromFO);
		}
		
		
		
		

	    @Test(description="Navigated back to Fo and click on RMA Product Return Btn", priority=56)
	    public void step56_ClickOnRMAProductReturnBtn() throws Exception
	    {         
	          CustomFun.refreshPage(homepage.driver);
	          CustomFun.waitForPageLoaded(homepage.driver);
	          myaccountpage.ClickOnMyorders_RMAProductReturnBtn(OrderID);
	    }
	    
	    @Test(description="Creating RMA from FO", priority=57)
	    public void step57_CreatingRMAFromFO() throws Exception
	    {    
	          myaccountpage.ClickOnMyorders_RMAProductReturnChkbox();
	          myaccountpage.ClickOnMyorders_RMAProductReturnReasonDrpdown();
	          myaccountpage.ClickMyorders_RMAProductReturnReasonSubmit_Btn();
	          WebElement ContactAddressField=myaccountpage.driver.findElement(By.xpath(ObjRepoProp.get().getProperty("MyOrders_RMAContactEmailAddressField_xpath")));
	          ContactAddressField.sendKeys(CustomFun.getUserInfoDSDetails().get().getEmailDomain());
	          myaccountpage.driver.findElement(By.xpath(ObjRepoProp.get().getProperty("Myorders_RMAProductReturnReason_submitBtn2"))).click();
	          myaccountpage.ClickMyorders_RMAProductReturnReasonDateDrpdown();
	          myaccountpage.ClickMyorders_RMAProductReturnValidateBtn();
	          }	
		
		
	    @Test(description="Saved RMA from FO  ", priority=58)
	    public void step58_SavedRMAFromFO() throws Exception
	    {
	        RMA_ID_FO=  myaccountpage.SaveANdStore_RMAProductReturnID_FO();
	        System.out.println("Successfully Saved RMA ID for further execution - "+RMA_ID_FO);
	    } 

	    @Test(description="Navigated back to BO and click on Returns from sales tab", priority=59)
	    public void step59_NavigatedIntoMangetoAndClickOnReturnsFromSales() throws Exception
	    {
	    CustomFun.SwitchToSpecificTab(backofficepage.driver, "1");
	    CustomFun.waitForPageLoaded(backofficepage.driver);
	    backofficepage.SalesIconClick();
	    backofficepage.ReturnstxtFromSalesIconClick();
	    }

	    @Test(description="Click on filters and enter RMA ID", priority=60)
	    public void step60_ClickONFiltersAndEnterRMAID() throws Exception
	    {
	          Thread.sleep(5000);
	          if(!backofficepage.driver.findElement(By.xpath("//button[text()='Clear all']")).isDisplayed())
	          {
	          Thread.sleep(5000);
	          backofficepage.SearchForRMAOrder(OrderID);
	          Thread.sleep(2000);
	          CustomFun.refreshPage(backofficepage.driver);
	          CustomFun.waitForPageLoaded(backofficepage.driver);
	          }
	          else
	          {
	            backofficepage.driver.findElement(By.xpath("//button[text()='Clear all']")).click();
	            Thread.sleep(5000);
	            backofficepage.SearchForRMAOrder(OrderID);
	            Thread.sleep(2000);
	            CustomFun.refreshPage(backofficepage.driver);
	            Thread.sleep(5000);
	          }
	          //Fetch RMAID From BO
	          RMAID=backofficepage.driver.findElement(By.xpath("//div[contains(text(),'"+OrderID+"')]/../preceding-sibling::td//div")).getText();
	          Thread.sleep(2000);
	          backofficepage.VerifyReturnsStatusInBO_ReturnsPage(OrderID);
	          
	          for(int i=0;i<=5;i++)
	          {
	        	Thread.sleep(30000);
	    		CustomFun.refreshPage(backofficepage.driver);
	    		Thread.sleep(5000);
	            backofficepage.VerifyReturnsStatusInBO_ReturnsPage(OrderID);
	  			OrderStatus=BackOfficePage.RMAIDStatus;
	  		    if(OrderStatus.contains(TextProp.get().getProperty("Authorizedtxt")))
	  		    {
	  	          Assert.assertEquals(TextProp.get().getProperty("Authorizedtxt"), OrderStatus);
	  	          OrderStatus=BackOfficePage.RMAIDStatus;
	  	          log.info("Successfully Verified Order Status in Returns Page After Returns submit is completed: " + OrderStatus);
	  			  Reporter.log("<p>Successfully Verified Order Status in Returns Page After Returns submit is completed: " + OrderStatus);
	  			  break;
	  		    }
	          }
	    }

	    @Test(description="Click on Sales Icon", priority=61)
	    public void step61_ClickOnSalesIcon() throws Exception
	    {
	    backofficepage.SalesIconClick();
	    }

	    @Test(description="Click on Orders text from Sales Icon", priority=62)
	    public void step62_ClickOrderstxtFromSalesIcon() throws Exception
	    {
	    backofficepage.OrderstxtFromSalesIconClick();
	    }

	    @Test(description="Verified Order Status in Orders page", priority=63)
	    public void step63_VerifiedOrderStatusInOrdersPage() throws Exception
	    { 
	    CustomFun.waitForPageLoaded(backofficepage.driver);
	    backofficepage.VerifyOrderStatusInBO_OrdersPage(OrderID);
	    OrderStatus=BackOfficePage.OrderStatus;
	    Assert.assertEquals(TextProp.get().getProperty("ProcessingRMAtxt"), OrderStatus);
	    log.info("Successfully Verified Order Status in Orders Page After Returns submit is completed: " + OrderStatus);
	    Reporter.log("<p>Successfully Verified Order Status in Orders Page After Returns submit is completed: " + OrderStatus);
	    }

	    
	   
	    
	    @Test(description="Navigated Into WMS and Validate the RMA reception in the WMS", priority=64)
	    public void step64_ClickOnRMALink() throws Exception
	    {
	    CustomFun.SwitchToSpecificTab(wmspage.driver, "2");
	    CustomFun.waitForPageLoaded(wmspage.driver);
	    wmspage.Click_RMALnk();
	    }

	    @Test(description="Enter RMA ID in RMA Field, Click on Submit Filter button & Reception button in WMS", priority=65)
	    public void step65_EnterRMAID_SearchForOrderDetails_ClickOnReceptionButton() throws Exception
	    {
	    	for (int i = 0; i <= 6; i++)
			{
				Thread.sleep(60000);
				CustomFun.refreshPage(wmspage.driver);
				Thread.sleep(5000);
				String ExpectedRMAID=wmspage.driver.findElement(By.xpath(ObjRepoProp.get().getProperty("OrderIDtxt_xpath"))).getText();
				if(ExpectedRMAID.contains(RMAID))
				{
				break;
				}
			}
			wmspage.EnterRMAID_SearchForOrderDetails_ClickOnReceptionButton(RMAID);
	    }

	    @Test(description="Execute RMA Process in WMS", priority=66)
	    public void step66_ExecuteRMAProcessinWMS() throws Exception
	    {
	    wmspage.ExecuteRMAProcess();
	    } 
	    
	    @Test(description="Navigated Into Magento and Click on Sales Icon", priority=67)
	    public void step67_NavigatedIntoMangetoAndVerifiedOrderStatusInOrdersPage() throws Exception
	    {
	    CustomFun.SwitchToSpecificTab(backofficepage.driver, "1");
	    backofficepage.SalesIconClick();
	    }

	    @Test(description="Click on Returns link from Sales Tab", priority=68)
	    public void step68_ReturnstxtFromSalesIconClick() throws Exception
	    {
	    backofficepage.ReturnstxtFromSalesIconClick();
	    }

	    @Test(description="Verified Order Status in Returns page", priority=69)
	    public void step69_VerifiedOrderStatusInReturnsPage() throws Exception
	    {
	    CustomFun.waitForPageLoaded(backofficepage.driver);
	    backofficepage.VerifyReturnsStatusInBO_ReturnsPage(OrderID);
	    OrderStatus=BackOfficePage.RMAIDStatus;
	    Assert.assertEquals(TextProp.get().getProperty("ReturnReceivedtxt"), OrderStatus);
	    log.info("Successfully Verified Order Status in Returns Page After RMA Reception Process is done : " + OrderStatus);
	    Reporter.log("<p>Successfully Verified Order Status in Returns Page After RMA Reception Process is done : " + OrderStatus);
	    }

	    @Test(description="Click on View option under order grid", priority=70)
	    public void step70_ClickonViewOptioninOrderGrid() throws Exception
	    {
	    backofficepage.ClickOnOrderGrid(OrderID);     
	    }

	    @Test(description="Click on Return Items Tab", priority=71)
	    public void step71_ClickOnReturnItems() throws Exception
	    {
	    backofficepage.ReturnsItemsClick();
	    }

	    @Test(description="Entered Approved value in Approved Field under RMA Items Requested for Grid", priority=72)
	    public void step72_EnterValueInApprovedField() throws Exception
	    {
	    CustomFun.waitForPageLoaded(backofficepage.driver);
	    backofficepage.EnterValueInApprovedField("1");
	    }

	    @Test(description="Select Approved option from Status Dropdown", priority=73)
	    public void step73_SelectApprovedOptionFromStatusDropdown() throws Exception
	    {
	    backofficepage.SelectApprovedOptionFromStatusDropdown();
	    }

	    @Test(description="Click on Save Button", priority=74)
	    public void step74_ClickOnSaveButton() throws Exception
	    {
	    backofficepage.ClickOnSaveButton();
	    }

	    @Test(description="Verify Success Msg For RMA Request after submit returns", priority=75)
	    public void step75_VerifySuccessMsgForSavedRMARequest() throws Exception
	    {
	    backofficepage.VerifySuccessMsgForSavedRMARequest();
	    }

	    @Test(description="Click on Sales Icon", priority=76)
	    public void step76_ClickOnSalesIcon() throws Exception
	    {
	    backofficepage.SalesIconClick();
	    }

	    @Test(description="Click on Orders text from Sales Icon", priority=77)
	    public void step77_ClickOrderstxtFromSalesIcon() throws Exception
	    {
	    backofficepage.OrderstxtFromSalesIconClick();
	    }

	    @Test(description="Verified Order Status in Orders page", priority=78)
	    public void step78_VerifiedOrderStatusInOrdersPage() throws Exception
	    {    
	    CustomFun.waitForPageLoaded(backofficepage.driver);
	    backofficepage.VerifyOrderStatusInBO_OrdersPage(OrderID);
	    OrderStatus=BackOfficePage.OrderStatus;
	    Assert.assertEquals(TextProp.get().getProperty("WaitingForCreditMemotxt"), OrderStatus);
	    log.info("Successfully Verified Order Status in Orders Page After RMA Approved : " + OrderStatus);
	    Reporter.log("<p>Successfully Verified Order Status in Orders Page After RMA Approved: " + OrderStatus);
	    backofficepage.Click_viewBtnForPdt();	
		CustomFun.waitForPageLoaded(backofficepage.driver);
		backofficepage.driver.findElement(By.xpath("//span[contains(text(),'Comments History')]")).click();
		Thread.sleep(2000);
		ShipmentID=backofficepage.driver.findElement(By.xpath("//span[contains(text(),'Shipment #')]")).getText().replaceAll("[^0-9.]", "");
	    }
	    
	    @Test(description="Click on Sales Icon", priority=79)
	    public void step79_ClickOnSalesIcon() throws Exception
	    {
	    backofficepage.SalesIconClick();
	    }

	    @Test(description="Click on Returns link from Sales Tab", priority=80)
	    public void step80_ReturnstxtFromSalesIconClick() throws Exception
	    {
	    backofficepage.ReturnstxtFromSalesIconClick();
	    }

	    @Test(description="Verified Order Status in Returns page", priority=81)
	    public void step81_VerifiedOrderStatusInReturnsPage() throws Exception
	    {
	          CustomFun.waitForPageLoaded(backofficepage.driver);
	          backofficepage.VerifyReturnsStatusInBO_ReturnsPage(OrderID);
	          OrderStatus=BackOfficePage.RMAIDStatus;
	          Assert.assertEquals(TextProp.get().getProperty("Approvedtxt"), OrderStatus);
	          log.info("Successfully Verified Order Status in Returns Page After RMA Approved : " + OrderStatus);
	          Reporter.log("<p>Successfully Verified Order Status in Returns Page After RMA Approved : " + OrderStatus);
	    }
	    
	    @Test(description="Click on View option under order grid", priority=82)
	    public void step82_ClickonViewOptioninOrderGrid() throws Exception
	    {
	    backofficepage.ClickOnOrderGrid(OrderID);
	    CustomFun.waitForPageLoaded(backofficepage.driver);
	    }

	    @Test(description="Click On Refund/Exchange Button in Order Details Page", priority=83)
	    public void step83_ClickOnRefundOrExchangeButton() throws Exception
	    {
	    backofficepage.ClickOnRefundOrExchangeButton();
	    String[] NewMemoID=backofficepage.driver.findElement(By.xpath("//h1")).getText().split(" ");
	    RefundMemoID=NewMemoID[3];
	    }
	    
	    
	    @Test(description="Scroll down till Refund button in New Memo Page & Click on Refund Button", priority=84)
	    public void step84_ClickOnRefundButtonInNewMemoPage() throws Exception
	    {
	    backofficepage.ClickOnRefundButtonInNewMemoPage();
	    }

	    @Test(description="Verify Success Msg For Create Credit Memo after Refund created", priority=85)
	    public void step85_VerifySuccessMsgForCreateCreditMemo() throws Exception
	    {  
	    CustomFun.waitForPageLoaded(backofficepage.driver);
	    backofficepage.VerifySuccessMsgForCreateCreditMemo();
	    }

	    @Test(description="Click on Sales Icon", priority=86)
	    public void step86_ClickOnSalesIcon() throws Exception
	    {
	    backofficepage.SalesIconClick();
	    }

	    @Test(description="Click on Orders text from Sales Icon", priority=87)
	    public void step87_ClickOrderstxtFromSalesIcon() throws Exception
	    {
	    backofficepage.OrderstxtFromSalesIconClick();
	    }

	    @Test(description="Verified Order Status in Orders page", priority=88)
	    public void step88_VerifiedOrderStatusInOrdersPage() throws Exception
	    {
	    	for (int i = 0; i <= 3; i++)
			{
				Thread.sleep(30000);
				CustomFun.refreshPage(backofficepage.driver);
				Thread.sleep(10000);
				backofficepage.VerifyOrderStatusInBO_OrdersPage(OrderID);
				OrderStatus = BackOfficePage.OrderStatus;
				if(OrderStatus.contains(TextProp.get().getProperty("CreditOrRefundedtxt")))
				{
				Assert.assertEquals(TextProp.get().getProperty("CreditOrRefundedtxt"), OrderStatus);
				log.info("Successfully Verified Order Status in Orders Page After Refund Created: " + OrderStatus);
				Reporter.log("<p>Successfully Verified Order Status in Orders Page After Refund Created: " + OrderStatus);
				break;
				}
			}
	    }

	    @Test(description="Click on Sales Icon", priority=89)
	    public void step89_ClickOnSalesIcon() throws Exception
	    {
	    backofficepage.SalesIconClick();
	    }

	    @Test(description="Click on Returns link from Sales Tab", priority=90)
	    public void step90_ReturnstxtFromSalesIconClick() throws Exception
	    {
	    backofficepage.ReturnstxtFromSalesIconClick();
	    }

	    @Test(description="Verified Order Status in Returns page", priority=91)
	    public void step91_VerifiedOrderStatusInReturnsPage() throws Exception
	    {
	    CustomFun.waitForPageLoaded(backofficepage.driver);
	    backofficepage.VerifyReturnsStatusInBO_ReturnsPage(OrderID);
	    OrderStatus=BackOfficePage.RMAIDStatus;
	    Assert.assertEquals(TextProp.get().getProperty("ProcessedandClosedtxt"), OrderStatus);
	    log.info("Successfully Verified Order Status in Returns Page After Refund Created : " + OrderStatus);
	    Reporter.log("<p>Successfully Verified Order Status in Returns Page After Refund Created : " + OrderStatus);
	    }
	    
	    @Test(description="Swich to FO Tab & Click on My Account Icon", priority=92)
	    public void step92_SwitchToFOTabAndClickOnMyAccountIcon() throws Exception
	    {
	    CustomFun.SwitchToSpecificTab(homepage.driver, "0");
	    homepage.clickMyaccountBtn();
	    }

	    @Test(description="Click on My Orders Link", priority=93)
	    public void step93_ClickOnMyOrdersLink() throws Exception
	    {
	    myaccountpage.MyOrders_LnkClick();
	    CustomFun.waitForPageLoaded(myaccountpage.driver);
	    }

	    @Test(description="Verified Order Status in My Orders page", priority=94)
	    public void step94_VerifiedOrderStatusInMyOrdersPage() throws Exception
	    {
		if(locale.get().contains("FR_FR") | locale.get().contains("CH_FR"))
		{
			for (int i = 0; i <= 3; i++)
			{
			Thread.sleep(30000);
		    CustomFun.refreshPage(homepage.driver);
			Thread.sleep(10000);
		    myaccountpage.VerifyOrderStatus(OrderID);
		    if(MyAccountPage.OrderStatusFromFO.contains(TextProp.get().getProperty("Refundedtxt_FR")))
		    {
		    Assert.assertEquals(MyAccountPage.OrderStatusFromFO,TextProp.get().getProperty("Refundedtxt_FR"));
		    break;
		    }
			}
		}
		else
		{
			for (int i = 0; i <= 3; i++)
			{
			Thread.sleep(30000);
		    CustomFun.refreshPage(homepage.driver);
			Thread.sleep(10000);
		    myaccountpage.VerifyOrderStatus(OrderID);
		    if(MyAccountPage.OrderStatusFromFO.contains(TextProp.get().getProperty("Refundedtxt_UK")))
		    {
	        	Assert.assertEquals(MyAccountPage.OrderStatusFromFO,TextProp.get().getProperty("Refundedtxt_UK"));	
		    }
		    }
		}
	  } 

	    
		
}
