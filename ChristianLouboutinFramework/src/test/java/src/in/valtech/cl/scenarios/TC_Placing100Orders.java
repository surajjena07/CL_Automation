package src.in.valtech.cl.scenarios;
import static src.in.valtech.util.PropertyFileReader.ObjRepoProp;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.Reporter;
import org.testng.annotations.Test;
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

public class TC_Placing100Orders extends BaseTest
{
	public static String OrderID;
	
	HomePage homepage;
	MyAccountPage myaccountpage;
	ProductListingPage productlistingpage;
	CategoryLandingPage categorylandingpage;
	ProductDetailsPage productdetailspage;
	CheckoutPage checkoutpage;
	ShippingAddressPage shippingaddresspage;
	PaymentPage paymentpage;
	OrderConfirmationPage orderconfirmationpage;
	
	public static String[] Products= {"8210009X125","Louis Junior Spikes"};
			
	public Logger log = Logger.getLogger(this.getClass().getName());
	
	@Test(priority=01, description="Precondition: Open browser,Navigate to the CL URL and accept Cookies")
	public void step01_NavigatetoCLHomePage() throws Exception
	{
	System.out.println("step 1 begin");
	homepage =HomePage.navigateToCLApplication_URL(driver.get(),baseUrl.get());
	log.info("Successfully navigated to application URL");
	Reporter.log("<p>Successfully navigated to application URL");
	System.out.println("step 1 end");
	}
	
	@Test(priority=02, description=" Clicking on My Account Icon ")
	public void step02_ClickMyAccountBtn() throws Exception
	{
	homepage.clickMyaccountBtn();
	log.info("Successfully clicked on My account Icon from Homepage");
	Reporter.log("<p>Successfully clicked on My account Icon from Homepage");
	}  
	
	@Test(priority=3, description=" Enter the Email in login field  ")
	public void step3_EnterEmailAddressInLogin() throws Exception
	{
	homepage.EnterEmail(CustomFun.getUserInfoDSDetails().get().getEmailDomain());
	log.info("Successfully Entered Email Address in Login field");
	Reporter.log("<p>Successfully Entered Email Address in Login field");
    }
	
	@Test(priority=4, description=" Enter the password in login field  ")
	public void step4_EnterPasswordInLogin() throws Exception
	{
	homepage.EnterPassword(CustomFun.getUserInfoDSDetails().get().getPassword());
	log.info("Successfully Entered password in Login field ");
	Reporter.log("<p>Successfully Entered password in Login field");
    }
	
	@Test(priority=5, description=" Click on sign in Btn in login field & Placing the order")
	public void step5_ClickOnSignInBtnAndPlaceOrder() throws Exception
	{
	homepage.clickOnSignBtn();
	log.info("Successfully Clicked on sign in Btn in Login field");
	Reporter.log("<p>Successfully Clicked on sign in Btn in Login field ");
	GUIFunctions.RemoveExistProductsFromMyCartIcon(homepage.driver);
	CustomFun.refreshPage(homepage.driver);
	for(int i=1;i<=101;i++)
	{
	homepage.driver.findElement(By.xpath("//button[@class='action reset search']")).click();
	Thread.sleep(2000);
	homepage.driver.findElement(By.xpath("//input[@id='search']")).sendKeys(Products[0]);
	Thread.sleep(2000);
	homepage.driver.findElement(By.xpath("//span[@class='icon icon-search']")).click();
	Thread.sleep(10000);
	productlistingpage=new ProductListingPage(homepage.driver);
	productlistingpage.Click_ProductImg();
	Thread.sleep(5000);
	productdetailspage=new ProductDetailsPage(productlistingpage.driver);
	//productdetailspage.ClickOnSelectYourSizeBtnAndSelectAnySizeInPDP();
	Thread.sleep(5000);
	productdetailspage.pdpAddtoCartbtn();
	Thread.sleep(5000);
	productdetailspage.pdpNotification_Ordernowbtn();
	Thread.sleep(5000);
	checkoutpage=new CheckoutPage(productlistingpage.driver);
	//checkoutpage.UpdatebtnClick();
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
	homepage.driver.findElement(By.xpath(ObjRepoProp.get().getProperty("HP_MyAccount_Icon"))).click();
	CustomFun.waitForPageLoaded(homepage.driver);
	}
    }

}
