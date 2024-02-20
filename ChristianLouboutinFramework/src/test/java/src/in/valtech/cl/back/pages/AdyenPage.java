package src.in.valtech.cl.back.pages;
import static src.in.valtech.util.PropertyFileReader.ObjRepoProp;  
import static src.in.valtech.util.PropertyFileReader.TextProp;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import src.in.valtech.config.BaseTest;
import src.in.valtech.custom.CustomFun;
import src.in.valtech.uifunctions.GUIFunctions;

/**
* @author Veenashree.CM
*
*/
public class AdyenPage {

public Logger log = Logger.getLogger(this.getClass().getName());
	
	public WebDriver driver;
	public String OrderPlacedID;
	public static String OrderStatusFromAdyen;
	public static String OrderID_FromAdyen;
	
	/**
	 * Verification of Adyen Page
	 * Desc:Proper navigation to Adyen Page
	 * AdyenPage: Constructor
	 */
	public AdyenPage(WebDriver driver)
	{
		this.driver= driver;
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	// To fetch the Xpaths from Object Repository file

	
	By Adyen_PageLogo = By.xpath(ObjRepoProp.get().getProperty("Adyen_PageLogo_xpath"));   
	By Adyen_LoginLnk = By.xpath(ObjRepoProp.get().getProperty("Adyen_LoginLnk_xpath"));  
	By Adyen_TestTab = By.xpath(ObjRepoProp.get().getProperty("Adyen_TestTab_xpath"));  
	By Adyen_UserNameTxtFld = By.xpath(ObjRepoProp.get().getProperty("Adyen_UserNameTxtFld_xpath"));  
	By Adyen_NextBtn = By.xpath(ObjRepoProp.get().getProperty("Adyen_NextBtn_xpath"));  
	By Adyen_AccountTxtFld = By.xpath(ObjRepoProp.get().getProperty("Adyen_AccountTxtFld_xpath"));  
	By Adyen_RememberCheckbox = By.xpath(ObjRepoProp.get().getProperty("Adyen_RememberCheckbox_xpath"));  
	By Adyen_PasswordTxtFld = By.xpath(ObjRepoProp.get().getProperty("Adyen_PasswordTxtFld_xpath"));
	By Adyen_SubmitBtn = By.xpath(ObjRepoProp.get().getProperty("Adyen_SubmitBtn_xpath"));
	By Adyen_SwitchUserTab = By.xpath(ObjRepoProp.get().getProperty("Adyen_SwitchUserTab_xpath"));
	By Adyen_ForgetPwdLnk = By.xpath(ObjRepoProp.get().getProperty("Adyen_ForgetPwdLnk_xpath"));
	By Adyen_RiskTab = By.xpath(ObjRepoProp.get().getProperty("Adyen_RiskTab_xpath"));
	By Adyen_CaseMgmtTab = By.xpath(ObjRepoProp.get().getProperty("Adyen_CaseMgmtTab_xpath"));
	By Adyen_Accept = By.xpath(ObjRepoProp.get().getProperty("Adyen_Accept_xpath"));
	By Adyen_Reject = By.xpath(ObjRepoProp.get().getProperty("Adyen_Reject_xpath"));
	By Adyen_ConfirmOKPopup = By.xpath(ObjRepoProp.get().getProperty("Adyen_ConfirmOKPopup_xpath"));
	By Adyen_ConfirmCancelPopup = By.xpath(ObjRepoProp.get().getProperty("Adyen_ConfirmCancelPopup_xpath"));
	By Adyen_TransactionTab = By.xpath(ObjRepoProp.get().getProperty("Adyen_TransactionTab_xpath"));
	By Adyen_PaymentTab = By.xpath(ObjRepoProp.get().getProperty("Adyen_PaymentTab_xpath"));
	By Adyen_PaymentTabSearchFld = By.xpath(ObjRepoProp.get().getProperty("Adyen_PaymentTabSearchFld_xpath"));
	By Adyen_DateRemoveFilter = By.xpath(ObjRepoProp.get().getProperty("Adyen_DateRemoveFilter_xpath"));
	By Adyen_OrderIdStatus = By.xpath(ObjRepoProp.get().getProperty("Adyen_OrderIdStatus_xpath"));
	By Adyen_OrderIdVal_inCaseMgmt = By.xpath(ObjRepoProp.get().getProperty("Adyen_OrderIdVal_inCaseMgmt_xpath"));
	By Adyen_SearchTab_xpath = By.xpath(ObjRepoProp.get().getProperty("Adyen_SearchTab"));
	By Adyen_SelectFirstRowofSelectedID_xpath = By.xpath(ObjRepoProp.get().getProperty("Adyen_SelectFirstRowofSelectedID"));
	By Adyen_Credit3DSVisaCardFirstOrderID_xpath = By.xpath(ObjRepoProp.get().getProperty("Adyen_Credit3DSVisaCardFirstOrderID"));
	By Adyen_Credit3DSAmericanExpressCardFirstOrderID_xpath = By.xpath(ObjRepoProp.get().getProperty("Adyen_Credit3DSAmericanExpressCardFirstOrderID"));
	By Adyen_Credit3DSPaypalCardFirstOrderID_xpath = By.xpath(ObjRepoProp.get().getProperty("Adyen_Credit3DSPaypalCardFirstOrderID"));
	
	/**
	 * Navigate to Adyen Page url 
	 * @return :Adyen Page 
	 */
	
	public static AdyenPage NavigateToAdyen_URL(WebDriver driver,String baseurl,String drivername){
	driver.navigate().to(baseurl);
    return new AdyenPage(driver);
	}
	
	/**
	 * Click on Login for Adyen 
	 * @return :AdyenPage	
	 * @throws Exception 
	 */
	
	public AdyenPage AdyenLogIn(String Username,String Account,String Password) throws Exception
	{
		GUIFunctions.clickElement(driver, Adyen_TestTab,"Click on Test Tab"); 
    	GUIFunctions.typeTxtboxValue(driver, Adyen_UserNameTxtFld,Username); 
		GUIFunctions.clickElement(driver,Adyen_NextBtn,"Click on Next button"); 
		GUIFunctions.typeTxtboxValue(driver, Adyen_AccountTxtFld,Account);
    	GUIFunctions.typeTxtboxValue(driver, Adyen_PasswordTxtFld,Password); 
		GUIFunctions.clickElement(driver, Adyen_SubmitBtn,"Click on submit button"); 
		CustomFun.waitForPageLoaded(driver);
		
		if(GUIFunctions.isElementPresent((By.xpath("//button[contains(text(),'Skip for 14 days')]")), driver))
		{	
			WebDriverWait wait = new WebDriverWait(driver, 40);
			WebElement element1 = driver.findElement(By.xpath("//button[contains(text(),'Skip for 14 days')]"));
			WebElement element = wait.until(ExpectedConditions.visibilityOf(element1));
			// Click on element
			element.click();
		}
		
		/*
		 * By CLInterSABtn=By.
		 * xpath("//button[contains(@class,'app-sidebar-account-trigger adl-button adl-button')]"
		 * ); GUIFunctions.JavaScriptClick(driver,
		 * driver.findElement(CLInterSABtn),"Click on CLInternationalSA button"); By
		 * CLInterSALink=By.xpath("//a[@title='CLInternationalSA']");
		 * GUIFunctions.JavaScriptClick(driver,
		 * driver.findElement(CLInterSALink),"Click on CLInternationalSA link");
		 * CustomFun.waitForPageLoaded(driver);
		 */
		return new AdyenPage(driver);
	
	}
	
	/**
	 * Click on Login switch user tab in  Adyen 
	 * @return :AdyenPage	
	 */
	
	public AdyenPage Click_AdyenSwitchUserTab() throws InterruptedException
	{
	
		GUIFunctions.clickElement(driver, Adyen_SwitchUserTab,"Click on Adyen Switch user tab"); 
		return new AdyenPage( driver);
	}
	
	/**
	 * Click on Login Forgot password link in  Adyen 
	 * @return :AdyenPage	
	 */
	
	public AdyenPage Click_AdyenForgetPwdLnk() throws InterruptedException
	{
	
		GUIFunctions.clickElement(driver, Adyen_ForgetPwdLnk,"Click on Adyen Forgot password link"); 
		Thread.sleep(2000);
		return new AdyenPage( driver);
	}
	
	/**
	 * Click on Risk tab in  Adyen 
	 * @return :AdyenPage	
	 * @throws Exception 
	 */
	
	public AdyenPage Click_AdyenRiskTab() throws Exception
	{
	
		GUIFunctions.JavaScriptClick(driver, driver.findElement(Adyen_RiskTab),"Click on Risk tab"); 
		Thread.sleep(2000);
		return new AdyenPage( driver);
	}

	/**
	 * Click on Case Management tab in  Adyen 
	 * @return :AdyenPage	
	 * @throws Exception 
	 */
	
	public AdyenPage Click_AdyenCaseMgmtTab() throws Exception
	{
		GUIFunctions.JavaScriptClick(driver, driver.findElement(Adyen_CaseMgmtTab),"Click on Adyen Case Management tab"); 
		return new AdyenPage( driver);
	}
	
	
	/**
	 * Click on Adyen Order Accept Btn 
	 * @return :AdyenPage	
	 */
	
	public AdyenPage Click_AdyenOrderAcceptBtn() throws InterruptedException
	{

	GUIFunctions.clickElement(driver, Adyen_Accept,"Click on Adyen Order Accept Btn");
	Thread.sleep(2000);
	GUIFunctions.clickElement(driver, Adyen_ConfirmOKPopup,"Click on Adyen confirmation ok Btn");
	Thread.sleep(2000);

	return new AdyenPage( driver);
	}
	
	/**
	 * Click on Adyen Order Reject Btn 
	 * @return :AdyenPage	
	 */
	
	public AdyenPage Click_AdyenOrderRejectBtn() throws InterruptedException
	{
	
		GUIFunctions.clickElement(driver, Adyen_Reject,"Click on Adyen Order Reject Btn"); 
		Thread.sleep(2000);
		GUIFunctions.clickElement(driver, Adyen_ConfirmOKPopup,"Click on Adyen confirmation ok Btn");
		Thread.sleep(2000);
		return new AdyenPage( driver);
	}
	
	/**
	 * Click on Transaction tab in  Adyen 
	 * @return :AdyenPage	
	 * @throws Exception 
	 */
	
	public AdyenPage Click_AdyenTransactionTab() throws Exception
	{
	
		GUIFunctions.clickElement(driver, Adyen_TransactionTab,"Click on Adyen Transaction tab"); 
		Thread.sleep(2000);
		return new AdyenPage( driver);
	}
	/**
	 * Click on Transaction payment tab in  Adyen 
	 * @return :AdyenPage	
	 */
	
	public AdyenPage Click_AdyenTransactionPaymentTab() throws InterruptedException
	{
	
		GUIFunctions.clickElement(driver, Adyen_PaymentTab,"Click on Adyen Transaction payment tab"); 
		Thread.sleep(2000);
		return new AdyenPage( driver);
	}
	
	/**
	 * Enter order id in Adyen payment search tab and click on filter remove icon 
	 * @return :AdyenPage	
	 */
	
	public AdyenPage Enter_AdyenPaymentSearchField(String OrderID) throws InterruptedException
	{
		
     	GUIFunctions.typeTxtboxValue(driver,Adyen_PaymentTabSearchFld, OrderID);
		GUIFunctions.clickElement(driver, Adyen_DateRemoveFilter,"Click on Adyen click on filter remove icon "); 
		Thread.sleep(2000);
		return new AdyenPage( driver);
	}
	

	/**
	 * Verify order status of the searched order ID
	 * @return :AdyenPage	
	 */
	
	public AdyenPage Verify_AdyenOrderIDStatus() throws InterruptedException
	{
		
		BaseTest.expected=driver.findElement(Adyen_OrderIdStatus).getText();
		Assert.assertEquals(TextProp.get().getProperty("Adyen_OrderStatus"), BaseTest.expected);
		System.out.println("Successfully verified  Adyen order status  ");
		log.info("Successfully verified Adyen order status   \n");
		return new AdyenPage( driver);
	}
	
    
	public AdyenPage Verify_OrderIDandClickCheckbox(String OrderPlacedID) throws InterruptedException
	{
	By Adyen_OrderIDCheckbox = By.xpath("//span[contains(text(),'"+OrderPlacedID+"')]/..//preceding-sibling::td/..//td[3]");
	GUIFunctions.clickElement(driver, Adyen_OrderIDCheckbox,"Click on ordered product ID checkbox");
	return new AdyenPage( driver);
	}
	
	/**
	* MethodName= Verify order amount in Adyen
	* Description:This function verifies the order amount in Adyen
	* @return :AdyenPage
	*/

	public AdyenPage Verify_AdyenOrderAmount(String OrderID,String OrderPriceFromFO) throws Exception
	{
		By ele=By.xpath("//td[contains(text(),'"+OrderID+"')]//following-sibling::td[3]");
		String OrderAmount_ADyen=driver.findElement(ele).getText().replaceAll("[^0-9.]", "").replace(".", "");
		System.out.println("OrderAmount_ADyen=" + OrderAmount_ADyen);
		System.out.println("MyAccountPage.PriceVal_OrderPage=" + OrderPriceFromFO);
		Assert.assertEquals(OrderPriceFromFO.replaceAll("[^0-9.]", "").replace(".", ""), OrderAmount_ADyen);
		System.out.println("Successfully verified Adyen order amount with the total order amount ");
		return new AdyenPage( driver);
	}

	/**
	* MethodName= Verify order status of the searched order ID in Adyen
	* Description:This function verifies the order status of the searched order ID in Adyen
	* @return :AdyenPage
	*/


	public AdyenPage Verify_AdyenOrderIDStatus(String OrderID) throws Exception
	{
	By ele=By.xpath("//td[contains(text(),'"+OrderID+"')]//following-sibling::td[5]");
	CustomFun.waitObjectToLoad(driver, ele, Duration.ofSeconds(50));
	OrderStatusFromAdyen=driver.findElement(ele).getText();
	GUIFunctions.VerifyOrderStatusInAdyen(OrderStatusFromAdyen,OrderID);
	return new AdyenPage(driver);
	}
	
	
	public AdyenPage GetOrderIDFromAdyenForInvalid3DSCard() throws InterruptedException
	{
	GUIFunctions.verifyUIElementAndShowText(driver.findElement(Adyen_Credit3DSAmericanExpressCardFirstOrderID_xpath),"Order ID value from Adyen page ");
	By ele=By.xpath(ObjRepoProp.get().getProperty("Adyen_Credit3DSAmericanExpressCardFirstOrderID"));
	OrderID_FromAdyen = driver.findElement(ele).getText();
	System.out.println("OrderID_FromAdyen " + OrderID_FromAdyen);
	return new AdyenPage(driver);
	}
	
}
