package src.in.valtech.cl.scenarios;
import static src.in.valtech.util.PropertyFileReader.ObjRepoProp;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.Reporter;
import org.testng.annotations.Test;

import src.in.valtech.cl.back.pages.BackOfficePage;
import src.in.valtech.cl.back.pages.WMSPage;
import src.in.valtech.cl.front.pages.CategoryLandingPage;
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

public class TC_Placing2000_Orders extends BaseTest
{
	
    public static String OrderID;
    public String OrderStatus; 
    public String BarCodeForScan;
    public String ShippingWeight;
    public String RMAIDStatus; 
	public static String RMAID;
	public String RefundMemoID;
	public String ShipmentID;
    
    WMSPage wmspage;
	
	HomePage homepage;
	MyAccountPage myaccountpage;
	ProductListingPage productlistingpage;
	CategoryLandingPage categorylandingpage;
	ProductDetailsPage productdetailspage;
	CheckoutPage checkoutpage;
	ShippingAddressPage shippingaddresspage;
	PaymentPage paymentpage;
	OrderConfirmationPage orderconfirmationpage;
	BackOfficePage backofficepage;
	
	public static String[] Products= {"1225240CN14"};
	
	public Logger log = Logger.getLogger(this.getClass().getName());
	
	@Test(priority=01, description="Precondition: Open browser,Navigate to the CL URL and accept Cookies")
	public void step01_InititiatingTheBrowserrs() throws Exception
	{
		homepage =HomePage.navigateToCLApplication_URL(driver.get(),baseUrl.get());
		log.info("Successfully navigated to application URL");
		Reporter.log("<p>Successfully navigated to application URL");
		System.out.println("step 1 end");
		homepage.clickMyaccountBtn();
		homepage.EnterEmail(CustomFun.getUserInfoDSDetails().get().getEmailDomain());
		log.info("Successfully Entered Email Address in Login field");
		Reporter.log("<p>Successfully Entered Email Address in Login field");

		homepage.EnterPassword(CustomFun.getUserInfoDSDetails().get().getPassword());
		log.info("Successfully Entered password in Login field ");
		Reporter.log("<p>Successfully Entered password in Login field");
         
		homepage.clickOnSignBtn();
		GUIFunctions.RemoveExistProductsFromMyCartIcon(homepage.driver);
	}
	
	@Test(priority=2, description=" Click on sign in Btn in login field & Placing the order")
	public void step2_SwitchIntoFOAndPlaceOrder() throws Exception
	{
	for(int i=1;i<=100;i++)
	{	
	try 
	{
	CustomFun.SwitchToSpecificTab(homepage.driver, "0");
	System.out.println("Loop No : "+ i +" Started...");
	homepage.driver.findElement(By.xpath("//button[@class='action reset search']")).click();
	Thread.sleep(2000);
	homepage.driver.findElement(By.xpath("//input[@id='search']")).sendKeys(Products[0]);
	Thread.sleep(2000);
	homepage.driver.findElement(By.xpath("//span[@class='icon icon-search']")).click();
	Thread.sleep(5000);
	productlistingpage=new ProductListingPage(homepage.driver);
	productlistingpage.Click_ProductImg();
	Thread.sleep(2000);
	GUIFunctions.RemoveExistProductsFromMyCartIcon(homepage.driver);
	productdetailspage=new ProductDetailsPage(productlistingpage.driver);
	Thread.sleep(2000);
	productdetailspage.pdpAddtoCartbtn();
	Thread.sleep(2000);
	productdetailspage.pdpNotification_Ordernowbtn();
	Thread.sleep(2000);
	checkoutpage=new CheckoutPage(productlistingpage.driver);
	checkoutpage.UpdatebtnClick();
	Thread.sleep(2000);
	shippingaddresspage=new ShippingAddressPage(checkoutpage.driver);
	shippingaddresspage.driver.findElement(By.xpath(ObjRepoProp.get().getProperty("ExistShippingAddress_xpath"))).click();
	shippingaddresspage.FirstShippingMethodRadioBtnClick();
	shippingaddresspage.ContinuetopaymentbtnClick();
	paymentpage=new PaymentPage(shippingaddresspage.driver);
	paymentpage.checkout_Paymentoptions();
	paymentpage.checkout_Creditcard();
	paymentpage.checkout_CCCardnumber(CustomFun.getPaymentDSDetails().get().getCardNumber());
	paymentpage.checkout_CCExpirydate(CustomFun.getPaymentDSDetails().get().getCardExpiryDate());
	paymentpage.checkout_CCV(CustomFun.getPaymentDSDetails().get().getCardCVV());
	paymentpage.checkout_Cardholdername(CustomFun.getPaymentDSDetails().get().getCardHolderName());
	 paymentpage.checkout_Agreements_CreditCard();
	paymentpage.checkout_CC_ProceedbtnForCreditCard();
	CustomFun.waitForPageLoaded(paymentpage.driver);
	orderconfirmationpage=new OrderConfirmationPage(paymentpage.driver);
	orderconfirmationpage.VerifyOrderIDInOCP();
	OrderID=OrderConfirmationPage.OrderConfirmationId.replaceAll("[^0-9.]", "");
	System.out.println("Successfully Placed "+i+" Order - "+OrderID);
	homepage.StoreOrderIDInPropertiesFIle(OrderID, Integer.toString(i));
	
	// Verifying the Order Status in BO
/*	
	  CustomFun.SwitchToSpecificTab(backofficepage.driver, "1");
 	  backofficepage.SalesIconClick();
 	  backofficepage.OrderstxtFromSalesIconClick();
 	  backofficepage.EnterOrderId(OrderID);
 	  backofficepage.SearchIconClick();	
 		backofficepage.VerifyOrderStatusInBO_OrdersPage(OrderID);
 		OrderStatus=BackOfficePage.OrderStatus;
 		for(int j=0;j<=5;j++)
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
 		
 		// If order status is not changing then run cron jobs in BO
 		
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
		for(int k=0;k<=12;k++)
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
		
		// Picking, Packing and Shipping in WMS
		
		 CustomFun.SwitchToSpecificTab(wmspage.driver, "2");
         wmspage.PickingOrderProcess(OrderID);
         wmspage.VerifyPickingOrderSuccessMsg();
         wmspage.driver.navigate().refresh();
         Thread.sleep(2000);
         wmspage.getBarCodeFromPickingProcess(OrderID);
         BarCodeForScan=WMSPage.BarCodeId;
         wmspage.Click_WMSPackingBtn();
         wmspage.EnterBarcodeAndSearchForPacking(BarCodeForScan);
         // wmspage.CopySKUIDAndEnterinSearchFldForScanningProductsInPacking();
           By ele=By.xpath(ObjRepoProp.get().getProperty("WMS_SKUID_xpath"));  
			int TotalScanCount = wmspage.driver.findElements(By.xpath(ObjRepoProp.get().getProperty("WMS_TotalScanCount_xpath"))).size();
			ShippingWeight= Integer.toString(wmspage.driver.findElements(By.xpath(ObjRepoProp.get().getProperty("WMS_TotalScanCount_xpath"))).size());
			for(int l=0;l<TotalScanCount;l++)
			{
			  String SkuId=wmspage.driver.findElements(ele).get(l).getText().replaceAll("[^0-9.]", "");
			  Thread.sleep(2000);
			  By WMS_SKUID_serachfield= By.xpath(ObjRepoProp.get().getProperty("WMS_SKUID_serachfield_xpath"));  
		      GUIFunctions.typeTxtboxValue(wmspage.driver,WMS_SKUID_serachfield, SkuId);
		      Thread.sleep(2000);
			}
         wmspage.Click_CompletePackingBtn();
         wmspage.EnterQuantity_Packing("1");
         wmspage.ClickValidate_Packing();
         wmspage.ClickHomeBtn_PopUp();
         wmspage.ShippingOrderProcess(BarCodeForScan, ShippingWeight);
         
        
         // Create RMA Returns in BO
         
         CustomFun.OpenNewTabAndSwitchToNewTab(backofficepage.driver, "1");
 		backofficepage.ClickOnOrderGrid(OrderID);
 		backofficepage.CreateReturnsBtnClick();
 		backofficepage.PickupdateRadioBtnClick();
 		backofficepage.ReturnsItemsClick();
 		backofficepage.AddProductsBtnClick();
 		backofficepage.CheckboxProdToAddClick();
 		backofficepage.AddSelProdToReturnsBtnClick();
 		backofficepage.EnterValueInRequestedField("1");
 		backofficepage.SelectOptionFromReturnReasonDropdown("Changed Mind");
 		backofficepage.SelectOptionFromItemConditionDropdown();
 		backofficepage.SelectOptionFromResolutionDropdown("Refund");
 		backofficepage.SubmitReturnsBtnClick();
 		backofficepage.VerifySuccessfulMsgForRMARequest();
 			if(!backofficepage.driver.findElement(By.xpath("//button[text()='Clear all']")).isDisplayed())
 			{
 			 Thread.sleep(5000);
 			 backofficepage.SearchForRMAOrder(OrderID);
 			 Thread.sleep(2000);
 			 CustomFun.refreshPage(backofficepage.driver);
 			 Thread.sleep(5000);
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
 			
 			for(int m=0;m<=5;m++)
 			{
 			  Thread.sleep(60000);
 			  CustomFun.refreshPage(backofficepage.driver);
 			  Thread.sleep(5000);
 			  backofficepage.VerifyReturnsStatusInBO_ReturnsPage(OrderID);
 			  RMAIDStatus=BackOfficePage.RMAIDStatus;
 			  if(RMAIDStatus.contains(TextProp.get().getProperty("Authorizedtxt")))
 			  {
 				RMAIDStatus=BackOfficePage.RMAIDStatus;
 		        Assert.assertEquals(TextProp.get().getProperty("Authorizedtxt"), RMAIDStatus);
 		        log.info("Successfully Verified Order Status in Returns Page After Returns submit is completed: " + RMAIDStatus);
 				Reporter.log("<p>Successfully Verified Order Status in Returns Page After Returns submit is completed: " + RMAIDStatus);
 				break;
 			  }
 			}
 			
 			//Execute RMA Reception in WMS
 			
 			CustomFun.SwitchToSpecificTab(wmspage.driver, "2");
 			wmspage.Click_RMALnk();
 			wmspage.driver.findElement(By.xpath("//button[@id='reset-filter']")).click();
 			Thread.sleep(5000);
 			for (int n = 0; n <= 4; n++)
 			{
 			Thread.sleep(60000);
 			CustomFun.refreshPage(wmspage.driver);
 			Thread.sleep(5000);
 			String ExpectedRMAID=wmspage.driver.findElement(By.xpath("//td[contains(@class,'vuetable-td-incrementId')]")).getText();
 			if(ExpectedRMAID.contains(RMAID))
 			{
 			break;
 			}
 			}
 			wmspage.EnterRMAID_SearchForOrderDetails_ClickOnReceptionButton(RMAID);
 			wmspage.ExecuteRMAProcess();
 			Thread.sleep(2000);
 			
 			// Create Credit Memo and verify the RMA ID Status
 			
 			CustomFun.SwitchToSpecificTab(backofficepage.driver, "1");
 			backofficepage.ClickOnOrderGrid(OrderID);
 	        backofficepage.ReturnsItemsClick();
 			backofficepage.EnterValueInApprovedField("1");
 			backofficepage.SelectApprovedOptionFromStatusDropdown();
 			backofficepage.ClickOnSaveButton();
 			backofficepage.VerifySuccessMsgForSavedRMARequest();
 			backofficepage.ClickOnOrderGrid(OrderID);
 			backofficepage.ClickOnRefundOrExchangeButton();
 			String[] NewMemoID=backofficepage.driver.findElement(By.xpath("//h1")).getText().split(" ");
 			RefundMemoID=NewMemoID[3];
 			backofficepage.ClickOnRefundButtonInNewMemoPage();
 			backofficepage.VerifySuccessMsgForCreateCreditMemo();
 			backofficepage.SalesIconClick();
 			backofficepage.OrderstxtFromSalesIconClick();
 			for (int g = 0; g <= 2; g++)
 			{
 				Thread.sleep(10000);
 				CustomFun.refreshPage(backofficepage.driver);
 				Thread.sleep(5000);
 				CustomFun.refreshPage(backofficepage.driver);
 				Thread.sleep(2000);
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

 			backofficepage.SalesIconClick();
 			backofficepage.ReturnstxtFromSalesIconClick();
 		
 			backofficepage.VerifyReturnsStatusInBO_ReturnsPage(OrderID);
 			OrderStatus=BackOfficePage.RMAIDStatus;
 		    Assert.assertEquals(TextProp.get().getProperty("ProcessedandClosedtxt"), OrderStatus);
 		    log.info("Successfully Verified Order Status in Returns Page After Refund Created : " + OrderStatus);
 			Reporter.log("<p>Successfully Verified Order Status in Returns Page After Refund Created : " + OrderStatus);  */
	}
	catch(Exception e)
	{
		log.info("Failure Reason "+e);
		Reporter.log("<p>Failure Reason "+e);
		continue;
	}
	}
    }
 
}
