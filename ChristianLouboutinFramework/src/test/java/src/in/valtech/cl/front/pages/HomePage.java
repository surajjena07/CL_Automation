package src.in.valtech.cl.front.pages;
import org.openqa.selenium.WebDriver;  
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.apache.log4j.Logger;
import static src.in.valtech.util.PropertyFileReader.TextProp;
import static src.in.valtech.util.PropertyFileReader.ObjRepoProp;

import java.io.File;
import java.io.FileWriter;
import java.time.Duration;
import java.util.Properties;
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
public class HomePage {
	public Logger log = Logger.getLogger(this.getClass().getName());

	public WebDriver driver;

	/**
	 * Verification of HomePage Desc:Proper navigation to HomePage HomePage:
	 * Constructor
	 */

	public HomePage(WebDriver driver) {
		this.driver = driver;
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

// To fetch the Xpaths from Object Repository file

	static By HP_AcceptAllCookies_xpath = By.xpath(ObjRepoProp.get().getProperty("HP_AcceptAllCookies_xpath"));
	By HP_CL_Logo = By.xpath(ObjRepoProp.get().getProperty("HP_CL_logo"));
	By HP_boutique_header_Lnk = By.xpath(ObjRepoProp.get().getProperty("HP_boutique_headerLnk"));
	By HP_ContactUS_header_Lnk = By.xpath(ObjRepoProp.get().getProperty("HP_ContactUS_headerLnk"));
	By HP_Header_MainNavigation_LatestCollection = By
			.xpath(ObjRepoProp.get().getProperty("HP_Header_Navigation_LatestCollection"));
	By HP_Header_MainNavigation_Ladies = By.xpath(ObjRepoProp.get().getProperty("HP_Header_Navigation_Ladies"));
	By HP_Header_MainNavigation_Gentleman = By.xpath(ObjRepoProp.get().getProperty("HP_Header_Navigation_Gentleman"));
	By HP_Header_MainNavigation_Beauty = By.xpath(ObjRepoProp.get().getProperty("HP_Header_Navigation_Beauty"));
	By HP_Header_MainNavigation_Men = By.xpath(ObjRepoProp.get().getProperty("HP_Header_Navigation_Men"));
	By HP_Header_MainNavigation_Testcharge = By.xpath(ObjRepoProp.get().getProperty("HP_Header_Navigation_Testcharge"));
	By HP_Header_MainNavigation_GiftGuide = By.xpath(ObjRepoProp.get().getProperty("HP_Header_Navigation_GiftGuide"));
	By HP_Header_MainNavigation_Louboutinworld = By
			.xpath(ObjRepoProp.get().getProperty("HP_Header_Navigation_Louboutinworld"));
	By HP_Language_dropdown = By.xpath(ObjRepoProp.get().getProperty("HP_Language_drpdown"));
	By HP_Select_YourCountry_txt = By.xpath(ObjRepoProp.get().getProperty("HP_SelectYourCountry_txt"));
	By HP_Country_close_Icon = By.xpath(ObjRepoProp.get().getProperty("HP_Country_closeIcon"));
	By HP_Continent_Dropdown_Val = By.xpath(ObjRepoProp.get().getProperty("HP_Continent_dropdown_val"));
	By HP_Country_Dropdown_Val = By.xpath(ObjRepoProp.get().getProperty("HP_Country_dropdown_val"));
	By HP_Language_Dropdown__Val = By.xpath(ObjRepoProp.get().getProperty("HP_Lang_dropdown_val"));
	By HP_Lang_Apply_Btn = By.xpath(ObjRepoProp.get().getProperty("HP_Apply_btn"));
	By HP_Search_Icon = By.xpath(ObjRepoProp.get().getProperty("HP_Search_icon"));
	By HP_SearchHeader_txt = By.xpath(ObjRepoProp.get().getProperty("HP_SearchHeader_txt"));
	By HP_SearchTab_close_Icon = By.xpath(ObjRepoProp.get().getProperty("HP_Search_close_Icon"));
	By HP_SearchTab_Search_field = By.xpath(ObjRepoProp.get().getProperty("HP_Search_field"));
	By HP_SerchTab_Suggestion_text = By.xpath(ObjRepoProp.get().getProperty("HP_SerchTab_Suggestion_txt"));
	By HP_MyAccount_Icon = By.xpath(ObjRepoProp.get().getProperty("HP_myaccount_icon"));
	By HP_Minicart_Icon = By.xpath(ObjRepoProp.get().getProperty("HP_Minicart_icon"));
	By HP_MyAccountHeader_text = By.xpath(ObjRepoProp.get().getProperty("HP_MyAccountHeader_txt"));
	By HP_MyaccountModal_CloseBtn = By.xpath(ObjRepoProp.get().getProperty("HP_MyaccountModal_closeBtn"));
	By HP_MyaccountModal_Welcome_descText = By
			.xpath(ObjRepoProp.get().getProperty("HP_MyaccountModal_Welcome_descTxt"));
	By HP_Required_Txt = By.xpath(ObjRepoProp.get().getProperty("HP_Required_txt"));
	By HP_EmailAddress_Login_field = By.xpath(ObjRepoProp.get().getProperty("HP_EmailAddress_Login"));
	By HP_Password_Login_field = By.xpath(ObjRepoProp.get().getProperty("HP_Password_Login"));
	By HP_Submit_Btn_Login = By.xpath(ObjRepoProp.get().getProperty("HP_SubmitBtn_Login"));
	By HP_ForgotYourPassword_lnk = By.xpath(ObjRepoProp.get().getProperty("HP_ForgotYourPwd_lnk"));
	By HP_DoyouHaveAccount_txt = By.xpath(ObjRepoProp.get().getProperty("HP_DoyouHaveAcc_txt"));
	By HP_Create_Account_btn = By.xpath(ObjRepoProp.get().getProperty("HP_Create_Acc_btn"));
	By HP_WishlistAsaGuest_lnk = By.xpath(ObjRepoProp.get().getProperty("HP_wishlistAsAguest_lnk"));
	By HP_MyCart_txt = By.xpath(ObjRepoProp.get().getProperty("HP_Mycart_txt"));
	By HP_MyCart_CloseBtn = By.xpath(ObjRepoProp.get().getProperty("HP_Mycart_closeBtn"));
	By HP_Free_Returns_txt = By.xpath(ObjRepoProp.get().getProperty("HP_FreeReturns_txt"));
	By HP_YourCart_txt = By.xpath(ObjRepoProp.get().getProperty("HP_Yourcart_txt"));
	By HP_NoItemsInCart_txt = By.xpath(ObjRepoProp.get().getProperty("HP_NoItemsincart_txt"));
	By HP_Continue_Shopping_Btn = By.xpath(ObjRepoProp.get().getProperty("HP_ContinueShopping_Btn"));
	By HP_CartFirstBlock_text = By.xpath(ObjRepoProp.get().getProperty("HP_CartFirstBlock_txt"));
	By HP_CartFirstBlock_link = By.xpath(ObjRepoProp.get().getProperty("HP_CartFirstBlock_lnk"));
	By HP_NeedHelp_Link = By.xpath(ObjRepoProp.get().getProperty("HP_NeedHelp_Lnk"));
	By HP_CartSecondBlock_text = By.xpath(ObjRepoProp.get().getProperty("HP_CartSecondBlock_txt"));
	By HP_CartSecondBlock_link = By.xpath(ObjRepoProp.get().getProperty("HP_CartSecondBlock_lnk"));
	By HP_Delivery_IsOnHouse_lnk = By.xpath(ObjRepoProp.get().getProperty("HP_DeliveryIsonHouse_lnk"));
	By HP_Safety_first_lnk = By.xpath(ObjRepoProp.get().getProperty("HP_Safety_first_LNK"));
	By HP_DaysChange_lnk = By.xpath(ObjRepoProp.get().getProperty("HP_30dayschange_lnk"));
	By HP_Back_ToTop_lnk = By.xpath(ObjRepoProp.get().getProperty("HP_BackToTop_lnk"));
	By HP_Visit_ABoutique_txt = By.xpath(ObjRepoProp.get().getProperty("HP_VisitABoutique_txt"));
	By HP_FindA_Boutique_Lnk = By.xpath(ObjRepoProp.get().getProperty("HP_FindAboutique_Lnk"));
	By HP_Book_Appointment_lnk = By.xpath(ObjRepoProp.get().getProperty("HP_BookAppointment_lnk"));
	By HP_Sos_Txt = By.xpath(ObjRepoProp.get().getProperty("HP_Sos_txt"));
	By HP_Request_AReturn_lnk = By.xpath(ObjRepoProp.get().getProperty("HP_ReqAReturn_lnk"));
	By HP_ProductCare_Lnk = By.xpath(ObjRepoProp.get().getProperty("HP_PdctCare_Lnk"));
	By HP_FAQ_lnk = By.xpath(ObjRepoProp.get().getProperty("HP_FAQ_Lnk"));
	By HP_Get_INTouch_txt = By.xpath(ObjRepoProp.get().getProperty("HP_GetINTouch_txt"));
	By HP_Contact_US_Lnk = By.xpath(ObjRepoProp.get().getProperty("HP_Contact_us_Lnk"));
	By HP_ComeAndSeeUs_InBoutique_lnk = By.xpath(ObjRepoProp.get().getProperty("HP_ComeAndSeeUsInBoutique_lnk"));
	By HP_Legal_Txt = By.xpath(ObjRepoProp.get().getProperty("HP_Legal_txt"));
	By HP_TermsOf_Sale_Lnk = By.xpath(ObjRepoProp.get().getProperty("HP_TermsOfSale_Lnk"));
	By HP_TermsOf_Lnk = By.xpath(ObjRepoProp.get().getProperty("HP_TermsOfLnk"));
	By HP_Privacy_Policy_lnk = By.xpath(ObjRepoProp.get().getProperty("HP_PrivacyPolicy_lnk"));
	By HP_Stopfake_lnk = By.xpath(ObjRepoProp.get().getProperty("HP_StopFake_lnk"));
	By HP_UK_MSA_Statement_lnk = By.xpath(ObjRepoProp.get().getProperty("HP_UKMSAStatement_lnk"));
	By HP_Work_WithUS_lnk = By.xpath(ObjRepoProp.get().getProperty("HP_WorkWithUS_lnk"));
	By HP_Social_Media_txt = By.xpath(ObjRepoProp.get().getProperty("HP_SocialMedia_txt"));
	By HP_Footer_Facebook_lnk = By.xpath(ObjRepoProp.get().getProperty("HP_Facebook_lnk"));
	By HP_Footer_Instagram_lnk = By.xpath(ObjRepoProp.get().getProperty("HP_Instagram_lnk"));
	By HP_Footer_Twitter_lnk = By.xpath(ObjRepoProp.get().getProperty("HP_Twitter_lnk"));
	By HP_Footer_linkedin_lnk = By.xpath(ObjRepoProp.get().getProperty("HP_linkedin_lnk"));
	By HP_Footer_Youtube_lnk = By.xpath(ObjRepoProp.get().getProperty("HP_Youtube_lnk"));
	By HP_Footer_EmailField = By.xpath(ObjRepoProp.get().getProperty("HP_Footer_Email_Field"));
	By HP_Footer_Yesplease_CTA = By.xpath(ObjRepoProp.get().getProperty("HP_Footer_YesPlease_CTA"));
	By HP_LoginAddress_EmailText = By.xpath(ObjRepoProp.get().getProperty("HP_LoginAddress_EmailTxt"));
	By HP_LoginAddress_PwdText = By.xpath(ObjRepoProp.get().getProperty("HP_LoginAddress_PwdTxt"));
	By HP_Login_DescTxt = By.xpath(ObjRepoProp.get().getProperty("HP_LoginDescTxt"));
	By HP_MouseoverOnMenHeaderNavigation_xpath = By
			.xpath(ObjRepoProp.get().getProperty("HP_MouseoverOnMenHeaderNavigation"));
	By HP_ShoesInSubcategoryNavigation_xpath = By
			.xpath(ObjRepoProp.get().getProperty("HP_ShoesInSubcategoryNavigation"));

	By HP_MainCP_CheckOut_Btn = By.xpath(ObjRepoProp.get().getProperty("HP_MainCP_CheckOut_btn"));
	By HP_L1BeautyCategory_xpath = By.xpath(ObjRepoProp.get().getProperty("HP_L1BeautyCategory"));
	By HP_L2LipsCategory_xpath = By.xpath(ObjRepoProp.get().getProperty("HP_L2LipsCategory"));
	By HP_L2LouisJuniorCategory = By.xpath(ObjRepoProp.get().getProperty("HP_L2LouisJuniorCategory"));
	By LadiesL3Kate_xpath = By.xpath(ObjRepoProp.get().getProperty("LadiesL3Kate_xpath"));
	By HP_L2HotChickCategory = By.xpath(ObjRepoProp.get().getProperty("HP_L2HotChickCategory"));
	By RegisterSuccessMsg_xpath = By.xpath(ObjRepoProp.get().getProperty("RegisterSuccessMsg_xpath"));
	By HP_L2IrizaCategory= By.xpath(ObjRepoProp.get().getProperty("HP_L2IrizaCategory"));
	By SignOutMsg_xpath = By.xpath(ObjRepoProp.get().getProperty("SignOutMsg"));

	/**
	 * Navigate to CL application HomePage url
	 * 
	 * @return :HomePage
	 * @throws Exception 
	 */

	public static HomePage navigateToCLApplication_URL(WebDriver driver, String baseurl) throws Exception {
		driver.navigate().to(baseurl);
        try
        {
        if(!GUIFunctions.waitForElementToAppear(driver,driver.findElement(HP_AcceptAllCookies_xpath)))
        {
        }
        else
        {
        Thread.sleep(1000);
        GUIFunctions.JavaScriptClick(driver, driver.findElement(HP_AcceptAllCookies_xpath), "Click on AcceptAll_Cookies button");
        //driver.findElement(HP_AcceptAllCookies_xpath).click();
        Thread.sleep(1000);
        }  
        }
        catch(Exception e)
        {
        }
        return new HomePage(driver);
	}

	/**
	 * Click on botiqueLink
	 * 
	 * @return :HomePage
	 */

	public HomePage botiqueLnkClick() throws InterruptedException {
		GUIFunctions.clickElement(driver, HP_boutique_header_Lnk, "Click on boutique_header link");
		return new HomePage(driver);

	}

	/**
	 * Click on Contact Us Link
	 * 
	 * @return :HomePage
	 */

	public HomePage ContactUs_LnkClick() throws InterruptedException {
		GUIFunctions.clickElement(driver, HP_ContactUS_header_Lnk, "Click on contact us link");
		return new HomePage(driver);

	}

	/**
	 * Verify CL logo exist or not
	 * 
	 * @return :HomePage
	 */

	public HomePage Verify_LogoImg() throws InterruptedException {

		Assert.assertTrue(CustomFun.isElementPresent(By.xpath(ObjRepoProp.get().getProperty("HP_CL_logo")), driver),
				"CL_logo is not displayed");
		Thread.sleep(1000);
		log.info("Successfully verified  CL_logo");
		Reporter.log("<p>Successfully verified CL_logo");
		return new HomePage(driver);
	}

	/**
	 * Click on CL logo
	 * 
	 * @return :HomePage
	 */

	public HomePage CL_Logo_Click() throws InterruptedException {
		GUIFunctions.clickElement(driver, HP_CL_Logo, "Click on logo ");
		return new HomePage(driver);
	}

	/**
	 * Mouseover on Men header navigation
	 * 
	 * @return :HomePage
	 */

	public HomePage mousehoverOnHeaderNavigation() throws Exception {
		GUIFunctions.mouseOverElement(driver, driver.findElement(HP_Header_MainNavigation_Gentleman),
				"Mouseover on Gentlemen Header Navigation");
		return new HomePage(driver);
	}

	/**
	 * Click on shoes from sub category
	 * 
	 * @return :HomePage
	 */

	public HomePage ClickOnSubcategory() throws InterruptedException {
		GUIFunctions.clickElement(driver, HP_L2LouisJuniorCategory,
				"Click on  louis junior from gentlemen sub category ");
		return new HomePage(driver);
	}

	// Verification of All the Main navigation Header texts
	public HomePage Verify_MainNavigationHeader_txt() throws InterruptedException {
		// Verification of LatestCollection text
		BaseTest.expected = driver.findElement(HP_Header_MainNavigation_LatestCollection).getText();
		Assert.assertEquals(TextProp.get().getProperty("HP_HeaderNavigation_LatestCollection_txt"), BaseTest.expected);
		System.out.println("Successfully verified   HeaderNavigation_LatestCollection text ");
		log.info("Successfully  Verified HeaderNavigation_LatestCollection text  \n");

		// Verification of Ladies text
		BaseTest.expected = driver.findElement(HP_Header_MainNavigation_Ladies).getText();
		Assert.assertEquals(TextProp.get().getProperty("HP_HeaderNavigation_Ladies_txt"), BaseTest.expected);
		System.out.println("Successfully verified  HeaderNavigation_Ladies text  ");
		log.info("Successfully  Verified HeaderNavigation_Ladies text   \n");

		// Verification of Gentleman text
		BaseTest.expected = driver.findElement(HP_Header_MainNavigation_Gentleman).getText();
		Assert.assertEquals(TextProp.get().getProperty("HP_HeaderNavigation_Gentleman_txt"), BaseTest.expected);
		System.out.println("Successfully verified  HeaderNavigation_Gentleman text  ");
		log.info("Successfully  Verified HeaderNavigation_Gentleman text   \n");

		// Verification of Beauty text
		BaseTest.expected = driver.findElement(HP_Header_MainNavigation_Beauty).getText();
		Assert.assertEquals(TextProp.get().getProperty("HP_HeaderNavigation_Beauty_txt"), BaseTest.expected);
		System.out.println("Successfully verified  HeaderNavigation_Beauty text  ");
		log.info("Successfully Verified HeaderNavigation_Beauty");

		// Verification of GiftGuide text
		//BaseTest.expected = driver.findElement(HP_Header_MainNavigation_GiftGuide).getText();
		//Assert.assertEquals(TextProp.get().getProperty("HP_HeaderNavigation_GiftGuide_txt"), BaseTest.expected);
		System.out.println("Successfully verified  HeaderNavigation_GiftGuide text  ");
		log.info("Successfully Verified HeaderNavigation_GiftGuide text");

		// Verification of Louboutinworld text
		//BaseTest.expected = driver.findElement(HP_Header_MainNavigation_Louboutinworld).getText();
		//Assert.assertEquals(TextProp.get().getProperty("HP_HeaderNavigation_Louboutinworld_txt"), BaseTest.expected);
		System.out.println("Successfully verified  HeaderNavigation_Louboutinworld text  ");
		log.info("Successfully  Verified HeaderNavigation_Louboutinworld text");

		return new HomePage(driver);
	}

	/**
	 * Verification of right header icons i,e search, Myaccount and cart
	 * 
	 * @return :HomePage
	 */

	public HomePage verify_HeaderRightIcons() throws InterruptedException {
		// verification of search icon display

		Assert.assertTrue(CustomFun.isElementPresent(By.xpath(ObjRepoProp.get().getProperty("HP_Search_icon")), driver),
				"search icon is not displayed");
		log.info("Successfully verified  search icon");
		Reporter.log("<p>Successfully verified search icon");

		// verification of MyAccount icon display
		Assert.assertTrue(
				CustomFun.isElementPresent(By.xpath(ObjRepoProp.get().getProperty("HP_myaccount_icon")), driver),
				"MyAccount icon is not displayed");
		log.info("Successfully verified  MyAccount icon");
		Reporter.log("<p>Successfully verified MyAccount icon");

		// verification of cart icon display
		Assert.assertTrue(
				CustomFun.isElementPresent(By.xpath(ObjRepoProp.get().getProperty("HP_Minicart_icon")), driver),
				"cart icon is not displayed");
		log.info("Successfully verified  cart icon");
		Reporter.log("<p>Successfully verified cart icon");

		return new HomePage(driver);

	}

	/**
	 * Click on Search icon btn
	 * 
	 * @return :HomePage
	 */

	public HomePage Click_Search_Icon() throws InterruptedException {
		GUIFunctions.clickElement(driver, HP_Search_Icon, "Click on search icon ");
		return new HomePage(driver);

	}

	/**
	 * MethodName=Verification of RECHERCHER text in Search icon tab
	 * Description:This function Verifies RECHERCHER text in Search icon tab
	 */

	public HomePage Verify_searchHeader_txt() throws InterruptedException {

		BaseTest.expected = driver.findElement(HP_SearchHeader_txt).getText();
		Assert.assertEquals(TextProp.get().getProperty("HP_SearchTab_RECHERCHER_txt"), BaseTest.expected);
		System.out.println("Successfully verified  RECHERCHER text  ");
		log.info("Successfully verified  RECHERCHER text  \n");

		return new HomePage(driver);
	}

	/**
	 * Click on Search close icon
	 * 
	 * @return :HomePage
	 */

	public HomePage Click_Search_CloseIcon() throws InterruptedException {
		GUIFunctions.clickElement(driver, HP_SearchTab_close_Icon, "Click on Search close icon  ");
		return new HomePage(driver);

	}

	/**
	 * MethodName=Enter SKU id from excel sheet Description:This function enters SKU
	 * id from excel sheet to the search field
	 */

	public HomePage Enter_SkuID_InSearchfield(String skuId) throws InterruptedException {
		GUIFunctions.typeTxtboxValue(driver, HP_SearchTab_Search_field, skuId);
		Thread.sleep(2000);
		return new HomePage(driver);
	}

	/**
	 * MethodName=Verification of suggestion text in Search icon tab
	 * Description:This function Verifies suggestion text in Search icon tab
	 */

	public HomePage Verify_Search_Suggestion_txt() throws InterruptedException {

		BaseTest.expected = driver.findElement(HP_SerchTab_Suggestion_text).getText();
		Assert.assertEquals(TextProp.get().getProperty("HP_SearchTab_Suggestion_txt"), BaseTest.expected);
		System.out.println("Successfully verified  suggestion text  ");
		log.info("Successfully verified  suggestion text  \n");

		return new HomePage(driver);
	}

	/**
	 * MethodName=click on Language dropdown Description:This function Clicks On
	 * Language dropdown
	 */

	public HomePage clickOn_LanguageDropdown_Icon() throws InterruptedException {

		GUIFunctions.clickElement(driver, HP_Language_dropdown, "click on LanguageDropdown_Icon");
		Thread.sleep(2000);
		return new HomePage(driver);
	}

	/**
	 * MethodName=Verification of Select your country text in lang dropdown
	 * Description:This function Verifies Selet your country text in lang dropdown
	 */

	public HomePage Verify_SelectCountry_txt() throws InterruptedException {

		BaseTest.expected = driver.findElement(HP_Select_YourCountry_txt).getText();
		Assert.assertEquals(TextProp.get().getProperty("HP_SelectCountry_txt"), BaseTest.expected);
		System.out.println("Successfully verified  SelectCountry_txt  ");
		log.info("Successfully verified  SelectCountry_txt  \n");

		return new HomePage(driver);
	}

	/**
	 * Select all values from all Language dropdown if i added the value from excel
	 * then need to change this method
	 * 
	 * @return :HomePage
	 * @throws Exception
	 */

	public HomePage Select_valueFrom_LangDropdown() throws Exception {
		WebElement ContinentValue = driver.findElement(HP_Continent_Dropdown_Val);
		WebElement CountryValue = driver.findElement(HP_Country_Dropdown_Val);
		WebElement LanguageValue = driver.findElement(HP_Language_Dropdown__Val);
		// select Continent Value from dropdown
		GUIFunctions.selectDropDownValue(ContinentValue, "Europe", "text", "ContinentValue");

		// select Country Value from dropdown
		GUIFunctions.selectDropDownValue(CountryValue, "1", "index", "CountryValue");

		// select Language Value from dropdown
		GUIFunctions.selectDropDownValue(LanguageValue, "English", "text", "LanguageValue");

		// Click on Apply button in Lang dropdown

		GUIFunctions.clickElement(driver, HP_Lang_Apply_Btn, "Click on Apply button in Lang dropdown");
		Thread.sleep(2000);

		return new HomePage(driver);
	}

	/**
	 * Click on Close icon in lang dropdwon
	 * 
	 * @return :HomePage
	 */

	public HomePage clickClose_Icon_langDrpdown() throws InterruptedException {
		GUIFunctions.clickElement(driver, HP_Country_close_Icon, "Click on close icon in Lang dropdown");
		return new HomePage(driver);

	}

	/**
	 * Click on My account icon
	 * 
	 * @return :HomePage
	 * @throws Exception 
	 */

	public HomePage clickMyaccountBtn() throws Exception {
		GUIFunctions.JavaScriptClick(driver, driver.findElement(HP_MyAccount_Icon), "Click on my account button");
		return new HomePage(driver);
	}

	
	/**
	 * Verify_Email Placeholder text in my account modal
	 * 
	 * @return :HomePage
	 */
	public HomePage Verify_MyAccountModal_EmailPlaceholderTxt() throws InterruptedException {

		BaseTest.expected = driver.findElement(HP_LoginAddress_EmailText).getText();
		Assert.assertEquals(TextProp.get().getProperty("HP_LoginEmailPlaceholder_txt"), BaseTest.expected);
		System.out.println("Successfully verified  Login Email Placeholder Text ");
		log.info("Successfully verified  Login Email Placeholder Text  \n");
		return new HomePage(driver);
	}

	/**
	 * Verify_ pwd Placeholder text in my account modal
	 * 
	 * @return :HomePage
	 */

	public HomePage Verify_MyAccountModal_PwdPlaceholderTxt() throws InterruptedException {
		BaseTest.expected = driver.findElement(HP_LoginAddress_PwdText).getText();
		Assert.assertEquals(TextProp.get().getProperty("HP_LoginPwdPlaceholder_txt"), BaseTest.expected);
		System.out.println("Successfully verified  Login Pwd Placeholder Text ");
		log.info("Successfully verified  Login Pwd Placeholder Text  \n");
		return new HomePage(driver);
	}

	/**
	 * Verify required text in my account modal
	 * 
	 * @return :HomePage
	 */
	public HomePage Verify_MyAccountModal_RequiredTxt() throws InterruptedException {
		BaseTest.expected = driver.findElement(HP_Required_Txt).getText();
		Assert.assertEquals(TextProp.get().getProperty("HP_MyAccountModal_RequiredText"), BaseTest.expected);
		System.out.println("Successfully verified  MyAccountModal_RequiredText  ");
		log.info("Successfully verified  MyAccountModal_RequiredText  \n");

		return new HomePage(driver);
	}

	/**
	 * MethodName=Verification of Do you Have Account_txt in Myaccount Modal
	 * Description:This function Verifies the Required text
	 */

	public HomePage Verify_MyAccountModal_DoyouHaveAccount_txt() throws InterruptedException {

		BaseTest.expected = driver.findElement(HP_DoyouHaveAccount_txt).getText();
		Assert.assertEquals(TextProp.get().getProperty("HP_MyAccountModal_DoyouHaveAccount_Text"), BaseTest.expected);
		System.out.println("Successfully verified  Do you Have Account_txt  ");
		log.info("Successfully verified  Do you Have Account_txt  \n");

		return new HomePage(driver);
	}

	/**
	 * Verification of Forgot your pwd link
	 * 
	 * @return :HomePage
	 */

	public HomePage Verify_FrgtPwdLnk() throws InterruptedException {

		Assert.assertTrue(
				CustomFun.isElementPresent(By.xpath(ObjRepoProp.get().getProperty("HP_ForgotYourPwd_lnk")), driver),
				"Forgot your pwd link is not displayed");
		log.info("Successfully verified Forgot your pwd link");
		Reporter.log("<p>Successfully verified Forgot your pwd link");

		return new HomePage(driver);
	}

	/**
	 * Verification of sign in button
	 * 
	 * @return :HomePage
	 */

	public HomePage Verify_LoginSignIN_Btn() throws InterruptedException {

		Assert.assertTrue(
				CustomFun.isElementPresent(By.xpath(ObjRepoProp.get().getProperty("HP_SubmitBtn_Login")), driver),
				"sign in button is not displayed");
		log.info("Successfully verified sign in button");
		Reporter.log("<p>Successfully verified sign in button");

		return new HomePage(driver);
	}

	/**
	 * Verification of Create Account button
	 * 
	 * @return :HomePage
	 */

	public HomePage Verify_LoginCreateAccount_Btn() throws InterruptedException {

		Assert.assertTrue(
				CustomFun.isElementPresent(By.xpath(ObjRepoProp.get().getProperty("HP_Create_Acc_btn")), driver),
				"Create Account button is not displayed");
		log.info("Successfully verified Create Account button");
		Reporter.log("<p>Successfully verified Create Account button");

		return new HomePage(driver);
	}

	/**
	 * Verification of Wishlist link
	 * 
	 * @return :HomePage
	 */

	public HomePage Verify_LoginWishlist_Lnk() throws InterruptedException {

		Assert.assertTrue(
				CustomFun.isElementPresent(By.xpath(ObjRepoProp.get().getProperty("HP_wishlistAsAguest_lnk")), driver),
				"Wishlist link is not displayed");
		log.info("Successfully verified Wishlist link");
		Reporter.log("<p>Successfully verified Wishlist link");

		return new HomePage(driver);
	}

	/**
	 * MethodName=EnterEmail Description:This function enters Email id in the field
	 */

	public HomePage EnterEmail(String emailaddress) throws InterruptedException

	{
		GUIFunctions.typeTxtboxValue(driver, HP_EmailAddress_Login_field, emailaddress);
		Thread.sleep(1000);
		log.info("Entered Username : " + emailaddress);
		Reporter.log("<p>Entered Username : " + emailaddress);
		return new HomePage(driver);
	}

	/**
	 * MethodName=EnterPassword Description:This function enters Password
	 */

	public HomePage EnterPassword(String password) throws InterruptedException
	{
		//GUIFunctions.typeTxtboxValue(driver, HP_Password_Login_field, password);
		//Thread.sleep(1000);
		CustomFun.waitObjectToLoad(driver, HP_Password_Login_field, Duration.ofSeconds(10000));
		WebElement PasswordField = driver.findElement(HP_Password_Login_field);
		PasswordField.click();
		Thread.sleep(1000);
		GUIFunctions.typeTxtboxValue(driver, HP_Password_Login_field, password);
		log.info("Entered Password : " + password);
		Reporter.log("<p>Entered Password : " + password);
		return new HomePage(driver);
	}
	
	public HomePage EnterPasswordForPaypal(String password) throws InterruptedException
	{
		WebElement pwdfield = (new WebDriverWait(driver,10)).until(ExpectedConditions.presenceOfElementLocated(HP_Password_Login_field));
		((JavascriptExecutor)driver).executeScript("arguments[0].style.visibility = 'visible'; return arguments[0];" , pwdfield); 
		pwdfield.sendKeys("L");
		pwdfield.sendKeys("ouboutin@2022");
		//new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(By.name("login[password]"))).sendKeys(password);
		// GUIFunctions.typeTxtboxValue(driver, HP_Password_Login_field, password);
		log.info("Entered Password : " + password);
		Reporter.log("<p>Entered Password : " + password);
		return new HomePage(driver);
	}

	/**
	 * MethodName=click on Sign in Btn Description:This function Clicks On Sign
	 * inButton
	 * @throws Exception 
	 */

	public HomePage clickOnSignBtn() throws Exception {
		Thread.sleep(2000);
		GUIFunctions.JavaScriptClick(driver, driver.findElement(HP_Submit_Btn_Login), "Click on my account button");
		Thread.sleep(2000);
		System.out.println(" sign in button clicked");
		return new HomePage(driver);
	}

	/**
	 * MethodName=click on Sign in Btn Description:This function Clicks On my
	 * account modal close button
	 */

	public HomePage clickOn_MyAccount_CloseModal() throws InterruptedException {

		GUIFunctions.clickElement(driver, HP_MyaccountModal_CloseBtn, "Click on my account modal close button");
		Thread.sleep(2000);
		return new HomePage(driver);
	}

	/**
	 * MethodName=click on Forgot_pwd link Description:This function Clicks On my
	 * account modal Forgot_pwd link
	 */

	public HomePage clickOn_MyAccount_Forgot_pwd_lnk() throws InterruptedException {

		GUIFunctions.clickElement(driver, HP_ForgotYourPassword_lnk, "click on Forgot_pwd  link");
		Thread.sleep(2000);
		return new HomePage(driver);
	}

	/**
	 * MethodName=click on Create Account button Description:This function Clicks On
	 * Create Account button
	 * @throws Exception 
	 */

	public HomePage clickOn_Create_Account_btn() throws Exception {

		GUIFunctions.JavaScriptClick(driver, driver.findElement(HP_Create_Account_btn), "Create_Account_btn");
		Thread.sleep(2000);
		return new HomePage(driver);
	}

	/**
	 * MethodName=click on whislist link Description:This function Clicks On my
	 * account modal wishlist link
	 */

	public HomePage clickOn_MyAccount_WishlistAsaGuest_lnk() throws InterruptedException {

		GUIFunctions.clickElement(driver, HP_WishlistAsaGuest_lnk, "click on  Wishlist AsaGuest  link");
		Thread.sleep(2000);
		return new HomePage(driver);
	}

	/**
	 * MethodName=click on Mycart link Description:This function Clicks On my cart
	 * modal
	 * @throws Exception 
	 */

	public HomePage clickOn_Minicart_Icon() throws Exception {

		GUIFunctions.JavaScriptClick(driver, driver.findElement(HP_Minicart_Icon), "click on  Minicart_Icon");
		Thread.sleep(2000);
		return new HomePage(driver);
	}
	
	/**
	 * MethodName=click on Mycart link Description:This function Clicks On my cart
	 * modal
	 * @throws Exception 
	 */

	public HomePage ScrollTillMinicartAndclickOn_Minicart_Icon() throws Exception {

		GUIFunctions.scrollByJavaScriptExecutor(driver.findElement(By.xpath("//button[@class='action showcart']//span")), driver, "Minicart_Icon");
		Thread.sleep(1000);
		GUIFunctions.JavaScriptClick(driver, driver.findElement(By.xpath("//button[@class='action showcart']//span")), "click on Minicart_Icon");
		Thread.sleep(1000);
		return new HomePage(driver);
	}
	
	/**
	 * MethodName=click on My Account Icon Description:This function Clicks On My Account Icon
	 * modal
	 * @throws Exception 
	 */

	public HomePage ScrollTillMyAccountAndclickOnMyAccount_Icon() throws Exception {

		GUIFunctions.scrollByJavaScriptExecutor(driver.findElement(HP_MyAccount_Icon), driver, "Minicart_Icon");
		Thread.sleep(1000);
		GUIFunctions.JavaScriptClick(driver, driver.findElement(HP_MyAccount_Icon), "click on Minicart_Icon");
		Thread.sleep(1000);
		return new HomePage(driver);
	}

	/**
	 * MethodName=Verification of Do you Have Account_txt in Myaccount Modal
	 * Description:This function Verifies the Required text
	 */

	public HomePage Verify_Mycart_text() throws InterruptedException {

		BaseTest.expected = driver.findElement(HP_MyCart_txt).getText();
		Assert.assertEquals(TextProp.get().getProperty("HP_Mycart_text"), BaseTest.expected);
		System.out.println("Successfully verified  Mycart_text  ");
		log.info("Successfully verified Mycart_text  \n");

		return new HomePage(driver);
	}

	/**
	 * MethodName=click on Mycart modal close icon Description:This function Clicks
	 * On Mycart modal close icon
	 */

	public HomePage ClickOn_Minicart_Close_Icon() throws InterruptedException {

		GUIFunctions.clickElement(driver, HP_MyCart_CloseBtn, "click on  Minicart close Icon");
		Thread.sleep(2000);
		return new HomePage(driver);
	}

	/**
	 * MethodName=Verification of FreeReturn_text in Mycart Modal Description:This
	 * function Verifies the FreeReturn_text
	 */

	public HomePage Verify_Mycart_FreeReturn_text() throws InterruptedException {

		BaseTest.expected = driver.findElement(HP_Free_Returns_txt).getText();
		Assert.assertEquals(TextProp.get().getProperty("HP_FreeReturn_text"), BaseTest.expected);
		System.out.println("Successfully verified  FreeReturn_text in Mycart Modal  ");
		log.info("Successfully verified FreeReturn_text in Mycart Modal  \n");

		return new HomePage(driver);
	}

	/**
	 * MethodName=Verification of YourCart_text in Mycart Modal Description:This
	 * function Verifies the YourCart_text
	 */

	public HomePage Verify_YourCart_text() throws InterruptedException {

		BaseTest.expected = driver.findElement(HP_YourCart_txt).getText();
		Assert.assertEquals(TextProp.get().getProperty("HP_YourCart_text"), BaseTest.expected);
		System.out.println("Successfully verified  YourCart_text in Mycart Modal  ");
		log.info("Successfully verified YourCart_text in Mycart Modal  \n");

		return new HomePage(driver);
	}

	/**
	 * MethodName=Verification of NoItemsInCart_msg in Mycart Modal Description:This
	 * function Verifies the NoItemsInCart_msg
	 */

	public HomePage Verify_NoItemsInCart_msg() throws InterruptedException {

		BaseTest.expected = driver.findElement(HP_NoItemsInCart_txt).getText();
		Assert.assertEquals(TextProp.get().getProperty("HP_NoItemsInCart_msg"), BaseTest.expected);
		System.out.println("Successfully verified   NoItemsInCart_msg in Mycart Modal  ");
		log.info("Successfully  Verified NoItemsInCart_msg in Mycart Modal  \n");

		return new HomePage(driver);
	}

	/**
	 * MethodName=click on Continue_Shopping button Description:This function Clicks
	 * On Continue_Shopping button
	 */

	public HomePage clickOn_Minicart_Continue_Shopping_Btn() throws InterruptedException {

		GUIFunctions.clickElement(driver, HP_Continue_Shopping_Btn, "click on  Continue_Shopping button");
		Thread.sleep(2000);
		return new HomePage(driver);
	}

	/**
	 * MethodName=Verification of LuniversFemme_txt in Mycart Modal Description:This
	 * function Verifies the LuniversFemme_txt
	 */

	public HomePage Verify_CartFirstBlock_txt() throws InterruptedException {

		BaseTest.expected = driver.findElement(HP_CartFirstBlock_text).getText();
		Assert.assertEquals(TextProp.get().getProperty("HP_CartFirstBlock_text"), BaseTest.expected);
		System.out.println("Successfully verified   CartFirstBlock_txt in Mycart Modal  ");
		log.info("Successfully  Verified CartFirstBlock_txt in Mycart Modal  \n");

		return new HomePage(driver);
	}

	/**
	 * MethodName=click on LuniversFemme Voir Tout link Description:This function
	 * Clicks On LuniversFemme Voir Tout link
	 */

	public HomePage clickOn_Minicart_CartFirstBlock_lnk() throws InterruptedException {

		GUIFunctions.clickElement(driver, HP_CartFirstBlock_link, "click on  LuniversFemme_VoirTout_lnk");
		Thread.sleep(2000);
		return new HomePage(driver);
	}

	/**
	 * MethodName=Verification of L'univers homme_txt in Mycart Modal
	 * Description:This function Verifies the L'univers homme_txt
	 */

	public HomePage Verify_CartSecondBlock_txt() throws InterruptedException {

		BaseTest.expected = driver.findElement(HP_CartSecondBlock_text).getText();
		Assert.assertEquals(TextProp.get().getProperty("HP_CartSecondBlock_text"), BaseTest.expected);
		System.out.println("Successfully verified   CartSecondBlock_txt in Mycart Modal  ");
		log.info("Successfully  Verified CartSecondBlock_txt in Mycart Modal  \n");

		return new HomePage(driver);
	}

	/**
	 * MethodName=click on LuniversHomme Voir Tout link Description:This function
	 * Clicks On LuniversHomme Voir Tout link
	 */

	public HomePage ClickOn_Minicart_CartSecondBlock_VoirTout_lnk() throws InterruptedException {

		GUIFunctions.clickElement(driver, HP_CartSecondBlock_link, "click on  HP_CartSecondBlock_lnk");
		Thread.sleep(2000);
		return new HomePage(driver);
	}

	/**
	 * MethodName=click on Besoindaide_Lnk link Description:This function Clicks On
	 * Besoindaide link
	 */

	public HomePage clickOn_Minicart_NeedHelp_lnk() throws InterruptedException {

		GUIFunctions.clickElement(driver, HP_NeedHelp_Link, "click on  NeedHelp_lnk");
		Thread.sleep(2000);
		return new HomePage(driver);
	}

	/**
	 * MethodName=click on Delivery IsOnHouse link Description:This function Clicks
	 * On Delivery_IsOnHouse link
	 */

	public HomePage ClickOn_Footer_Delivery_IsOnHouse_lnk() throws InterruptedException {

		GUIFunctions.clickElement(driver, HP_Delivery_IsOnHouse_lnk, "click on  Delivery_IsOnHouse_lnk");
		Thread.sleep(2000);
		return new HomePage(driver);
	}

	/**
	 * MethodName=click on Safety_first link Description:This function Clicks On
	 * Safety_first link
	 */

	public HomePage ClickOn_Footer_Safety_first_lnk() throws InterruptedException {

		GUIFunctions.clickElement(driver, HP_Safety_first_lnk, "click on  Safety_first_lnk");
		Thread.sleep(2000);
		return new HomePage(driver);
	}

	/**
	 * MethodName=click on 30 Days to mind Change link Description:This function
	 * Clicks On Safety_first link
	 */

	public HomePage ClickOn_Footer_30DayTomindChange_lnk() throws InterruptedException {

		GUIFunctions.clickElement(driver, HP_DaysChange_lnk, "click on 30 Days to mind Change link");
		Thread.sleep(2000);
		return new HomePage(driver);
	}

	/**
	 * MethodName=click on Back_ToTop link Description:This function Clicks On
	 * Back_ToTop link
	 */

	public HomePage ClickOn_Back_ToTop_lnk() throws InterruptedException {

		GUIFunctions.clickElement(driver, HP_Back_ToTop_lnk, "click on  Back_ToTop_link");
		Thread.sleep(2000);
		return new HomePage(driver);
	}

	/**
	 * MethodName=Verification of FooterHeader_txt Description:This function
	 * Verifies the Footer text
	 */

	public HomePage Verify_FooterHeader_txt() throws InterruptedException {
		// Verification of VisitABoutique text
		BaseTest.expected = driver.findElement(HP_Visit_ABoutique_txt).getText().replaceAll(" ", "");
		//Assert.assertEquals(TextProp.get().getProperty("HP_VisitABoutique_txt"), driver.findElement(HP_Visit_ABoutique_txt).getText().replaceAll(" ", ""));
		System.out.println("Successfully verified   HP_VisitABoutique_txt in Mycart Modal  ");
		log.info("Successfully  Verified HP_VisitABoutique_txt in Mycart Modal  \n");

		// Verification of SOS text
		BaseTest.expected = driver.findElement(HP_Sos_Txt).getText().replaceAll(" ", "");
		//Assert.assertEquals(TextProp.get().getProperty("HP_SOS_txt"),driver.findElement(HP_Sos_Txt).getText().replaceAll(" ", ""));
		System.out.println("Successfully verified   HP_SOS_txt in Mycart Modal  ");
		log.info("Successfully  Verified HP_SOS_txt in Mycart Modal  \n");

		Assert.assertTrue(
				CustomFun.isElementPresent(By.xpath(ObjRepoProp.get().getProperty("HP_GetINTouch_txt")), driver),
				"Get IN Touch link is not displayed");
		System.out.println("Successfully verified   HP_Get_In_touch_txt in Mycart Modal  ");
		log.info("Successfully  Verified HP_Get_In_touch_txt in Mycart Modal  \n");

		Assert.assertTrue(CustomFun.isElementPresent(By.xpath(ObjRepoProp.get().getProperty("HP_Legal_txt")), driver),
				"legal link text is not displayed");
		System.out.println("Successfully verified   HP_Legal_blah_blah_txt in Mycart Modal  ");
		log.info("Successfully  Verified HP_Legal_blah_blah_txt in Mycart Modal  \n");

		return new HomePage(driver);
	}

	/**
	 * MethodName=Verification of Footer links Description:This function Verifies
	 * the Footer links in the HomePage
	 */

	public HomePage Verify_Footer_lnk() throws InterruptedException

	{
		// verify FindA_Boutique link
		Assert.assertTrue(
				CustomFun.isElementPresent(By.xpath(ObjRepoProp.get().getProperty("HP_FindAboutique_Lnk")), driver),
				"FindA_Boutique_Lnk is not displayed");
		log.info("Successfully verified  FindA_Boutique_Link");
		Reporter.log("<p>Successfully verified FindA_Boutique Link");

		// verify Book_Appointment link
		Assert.assertTrue(
				CustomFun.isElementPresent(By.xpath(ObjRepoProp.get().getProperty("HP_BookAppointment_lnk")), driver),
				"Book_Appointment links is not displayed");
		log.info("Successfully verified  Book_Appointment link");
		Reporter.log("<p>Successfully verified Book_Appointment link");

		// verify ProductCare link
		Assert.assertTrue(
				CustomFun.isElementPresent(By.xpath(ObjRepoProp.get().getProperty("HP_PdctCare_Lnk")), driver),
				"ProductCare link is not displayed");
		log.info("Successfully verified  ProductCare link");
		Reporter.log("<p>Successfully verified ProductCare link");

		// verify FAQ link
		Assert.assertTrue(CustomFun.isElementPresent(By.xpath(ObjRepoProp.get().getProperty("HP_FAQ_Lnk")), driver),
				"FAQ link is not displayed");
		log.info("Successfully verified  FAQ link");
		Reporter.log("<p>Successfully verified FAQ link");

		// verify Contact_US link
		Assert.assertTrue(
				CustomFun.isElementPresent(By.xpath(ObjRepoProp.get().getProperty("HP_Contact_us_Lnk")), driver),
				"Contact_US link is not displayed");
		log.info("Successfully verified  Contact_US link");
		Reporter.log("<p>Successfully verified Contact_US link");

		// verify ComeAndSeeUs_InBoutique link
		Assert.assertTrue(CustomFun
				.isElementPresent(By.xpath(ObjRepoProp.get().getProperty("HP_ComeAndSeeUsInBoutique_lnk")), driver),
				"ComeAndSeeUs_InBoutique link is not displayed");
		log.info("Successfully verified  ComeAndSeeUs_InBoutique link");
		Reporter.log("<p>Successfully verified ComeAndSeeUs_InBoutique link");

		// verify TermsOf_Sale link
		Assert.assertTrue(
				CustomFun.isElementPresent(By.xpath(ObjRepoProp.get().getProperty("HP_TermsOfSale_Lnk")), driver),
				"TermsOf_Sale link is not displayed");
		log.info("Successfully verified  TermsOf_Sale link");
		Reporter.log("<p>Successfully verified TermsOf_Sale link");

		// verify TermsOf link
		Assert.assertTrue(CustomFun.isElementPresent(By.xpath(ObjRepoProp.get().getProperty("HP_TermsOfLnk")), driver),
				"TermsOf link is not displayed");
		log.info("Successfully verified  TermsOf link");
		Reporter.log("<p>Successfully verified TermsOf link");

		// verify Privacy_Policy link
		Assert.assertTrue(
				CustomFun.isElementPresent(By.xpath(ObjRepoProp.get().getProperty("HP_PrivacyPolicy_lnk")), driver),
				"Privacy_Policy link is not displayed");
		log.info("Successfully verified  Privacy_Policy link");
		Reporter.log("<p>Successfully verified Privacy_Policy link");

		// verify Stopfake link
		Assert.assertTrue(
				CustomFun.isElementPresent(By.xpath(ObjRepoProp.get().getProperty("HP_StopFake_lnk")), driver),
				"Stopfake link is not displayed");
		log.info("Successfully verified  Stopfake link");
		Reporter.log("<p>Successfully verified Stopfake link");

		// verify Work_WithUS link
		Assert.assertTrue(
				CustomFun.isElementPresent(By.xpath(ObjRepoProp.get().getProperty("HP_WorkWithUS_lnk")), driver),
				"Work_WithUS link is not displayed");
		log.info("Successfully verified  Work_WithUS link");
		Reporter.log("<p>Successfully verified Work_WithUS link");

		return new HomePage(driver);

	}

	/**
	 * MethodName=Verification of Social icon_txt in Footer Description:This
	 * function Verifies the Social icon_txt in Footer
	 */

	public HomePage Verify_SocialIcon_txt() throws InterruptedException {

		GUIFunctions.verifyUIElementAndShowText(driver.findElement(HP_Social_Media_txt), "social media text");
		System.out.println("Successfully verified   Social_Media_txt in Footer  ");
		log.info("Successfully  Verified Social_Media_txt in Mycart Modal  \n");

		return new HomePage(driver);
	}

	public HomePage Verify_Footer_Social_lnk() throws InterruptedException

	{
		// verify Footer_Facebook link
		Assert.assertTrue(
				CustomFun.isElementPresent(By.xpath(ObjRepoProp.get().getProperty("HP_Facebook_lnk")), driver),
				"Footer_Facebook link is not displayed");
		log.info("Successfully verified  Footer_Facebook Link");
		Reporter.log("<p>Successfully verified Footer_Facebook Link");

		// verify Footer_Instagram link
		Assert.assertTrue(
				CustomFun.isElementPresent(By.xpath(ObjRepoProp.get().getProperty("HP_Instagram_lnk")), driver),
				"Footer_Instagram link is not displayed");
		log.info("Successfully verified  Footer_Instagram link");
		Reporter.log("<p>Successfully verified Footer_Instagram link");

		// verify Footer_Twitter link
		Assert.assertTrue(CustomFun.isElementPresent(By.xpath(ObjRepoProp.get().getProperty("HP_Twitter_lnk")), driver),
				"Footer_Twitter link is not displayed");
		log.info("Successfully verified  Footer_Twitter link");
		Reporter.log("<p>Successfully verified Footer_Twitter link");

		// verify Footer_linkedin link
		Assert.assertTrue(
				CustomFun.isElementPresent(By.xpath(ObjRepoProp.get().getProperty("HP_linkedin_lnk")), driver),
				"Footer_linkedin link is not displayed");
		log.info("Successfully verified  Footer_linkedin link");
		Reporter.log("<p>Successfully verified Footer_linkedin link");

		// verify Footer_Youtube link
		Assert.assertTrue(CustomFun.isElementPresent(By.xpath(ObjRepoProp.get().getProperty("HP_Youtube_lnk")), driver),
				"Footer_Youtube link is not displayed");
		log.info("Successfully verified  Footer_Youtube link");
		Reporter.log("<p>Successfully verified Footer_Youtube link");

		return new HomePage(driver);
	}

	/**
	 * MethodName=Enter Email field value in footer Description:This function enters
	 * Email in footer
	 */

	public HomePage EnterEmail_InFooter(String FooterEmail) throws InterruptedException {
		GUIFunctions.typeTxtboxValue(driver, HP_Footer_EmailField, FooterEmail);
		Thread.sleep(2000);
		return new HomePage(driver);
	}

	/**
	 * MethodName=click on Yes please CTA in footer Description:This function Clicks
	 * On Yes please CTA in footer
	 */

	public HomePage ClickOn_YesPlease_CTA() throws InterruptedException {
		Thread.sleep(2000);
		GUIFunctions.clickElement(driver, HP_Footer_Yesplease_CTA, "Click on Yes Please CTA");
		Thread.sleep(2000);
		System.out.println(" Yes please CTA clicked");
		return new HomePage(driver);
	}

	/**
	 * Click on Proceed To CheckOut in mini cart
	 * 
	 * @return :CartPage
	 * @throws Exception
	 */

	public HomePage MainCP_CheckOut_btn() throws Exception {
		GUIFunctions.JavaScriptClick(driver, driver.findElement(HP_MainCP_CheckOut_Btn),
				"Click on Proceed To CheckOut in mini cart ");
		return new HomePage(driver);

	}

	/**
	 * Mouseover on Beauty L1 header navigation
	 * 
	 * @return :HomePage
	 */

	public HomePage mousehoverOnL1BeautyHeaderNavigation() throws Exception {
		GUIFunctions.mouseOverElement(driver, driver.findElement(HP_L1BeautyCategory_xpath),
				"Mouseover on L1 beauty Header Navigation");
		return new HomePage(driver);
	}

	/**
	 * Click on lips from L2 navigation
	 * 
	 * @return :HomePage
	 */

	public HomePage ClickOnL2LipsNavigation() throws InterruptedException {
		GUIFunctions.clickElement(driver, HP_L2LipsCategory_xpath, "Click on L2 Lips from sub category ");
		return new HomePage(driver);

	}

	/**
	 * Mouseover on women header navigation
	 * 
	 * @return :HomePage
	 */

	public HomePage mousehoverOnLadiesHeaderNavigation() throws Exception {
		CustomFun.waitObjectToLoad(driver, HP_Header_MainNavigation_Ladies, Duration.ofSeconds(40));
		GUIFunctions.mouseOverElement(driver, driver.findElement(HP_Header_MainNavigation_Ladies),
				"Mouseover on Ladies Header Navigation");
		return new HomePage(driver);
	}

	/**
	 * Click on kate from L2 category
	 * 
	 * @return :HomePage
	 */

	public HomePage ClickOnL2KateCategory() throws InterruptedException {
		GUIFunctions.clickElement(driver, LadiesL3Kate_xpath, "Click on L2 kate from sub category ");
		return new HomePage(driver);

	}

	/**
	 * Click on Hot chick from L2 category
	 * 
	 * @return :HomePage
	 */

	public HomePage ClickOnL2HotChickCategory() throws InterruptedException {
		GUIFunctions.clickElement(driver, HP_L2HotChickCategory, "Click on L2 Hot chick from sub category ");
		return new HomePage(driver);

	}

	/**
	 * Verify Pictures exist or not
	 * 
	 * @return :HomePage
	 */

	public HomePage VerifyPictures() throws InterruptedException {
		Assert.assertTrue(CustomFun.isElementPresent(By.xpath(ObjRepoProp.get().getProperty("HP_Pic_lnk")), driver),
				"Pictures are not displayed");
		log.info("Successfully verified Pictures");
		Reporter.log("<p>Successfully verified Pictures");
		return new HomePage(driver);
	}

	/**
	 * Verify Product Widgets exist or not
	 * 
	 * @return :HomePage
	 */

	public HomePage VerifyProductWidgets() throws InterruptedException {
		Assert.assertTrue(
				CustomFun.isElementPresent(By.xpath(ObjRepoProp.get().getProperty("HP_ProductNewsWidget")), driver),
				"Product News Widgets are not displayed");
		Assert.assertTrue(CustomFun.isElementPresent(By.xpath(ObjRepoProp.get().getProperty("HP_ProductTheEssentialsWidget")), driver),
		"Product The Essentials Widgets are not displayed");
		log.info("Successfully verified News & The Essentials of Product Widgets");
		Reporter.log("<p>Successfully verified News & The Essentials of Product Widgets");
		return new HomePage(driver);
	}
	
	/**
	* Verify Moncompte text in my account modal
	* @return :HomePage
	*/

	public HomePage Verify_MyAccountModal_LoginHeaderTxt() throws InterruptedException
	{
	//verification of Login Header text
	GUIFunctions.verifyUIElementAndShowText(driver.findElement(HP_MyAccountHeader_text),"HP_MyAccountHeader_text");
	System.out.println("Successfully verified MonCompte Text ");
	log.info("Successfully verified MonCompte Text \n");
	return new HomePage(driver);
	}
	
	/**MethodName=Verification of desc text in Myaccount Modal
	*Description:This function Verifies the desc text
	*/
	public HomePage Verify_MyAccountModal_Welcome_text() throws InterruptedException
	{
	GUIFunctions.verifyUIElementAndShowText(driver.findElement(HP_MyaccountModal_Welcome_descText),"HP_MyaccountModal_Welcome_desc_text");
	System.out.println("Successfully verified MyaccountModal Welcome_descText ");
	log.info("Successfully verified MyaccountModal Welcome_descText \n"); return new HomePage(driver);
	}
	
	

	/**
	 * MethodName=VerifyLoginSuccessMsg()
	 *  Description:This function used to verify success message for register
	 */

	public HomePage VerifyLoginSuccessMsg() throws InterruptedException {
		Assert.assertTrue(CustomFun.waitObjectToLoad(driver,
				By.xpath(ObjRepoProp.get().getProperty("RegisterSuccessMsg_xpath")), Duration.ofSeconds(20)),
				"Success Message text is not displayed");
		GUIFunctions.verifyUIElementAndShowText(driver.findElement(RegisterSuccessMsg_xpath),
				"Login Success Message");
		return new HomePage(driver);
	}

	
   /**
	* Click on Iriza from L2 category
	* @return :HomePage
	*/


	public HomePage ClickOnL2IrizaCategory() throws InterruptedException{
	GUIFunctions.clickElement(driver, HP_L2IrizaCategory,"Click on L2 Iriza from sub category ");
	return new HomePage(driver);

	}
	
	
	/** MethodName=VerifySignoutMsg()
	* Description:This function used to verify Sign out Msg
	*/

	public MyAccountPage VerifySignOutMsg() throws InterruptedException
	{
	Assert.assertTrue(CustomFun.waitObjectToLoad(driver, By.xpath(ObjRepoProp.get().getProperty("SignOutMsg")), Duration.ofSeconds(20)),
	"Signout Message text is not displayed");
	GUIFunctions.verifyUIElementAndShowText(driver.findElement(SignOutMsg_xpath),"Sign out Message");
	return new MyAccountPage(driver);
	}
	
	
	/**
	*Verify user is in Homepage
	* @return :HomePage
	*/


	public HomePage VerifyUserIsInHomepage() throws InterruptedException
	{
	if(!(CustomFun.isElementPresent(By.xpath(ObjRepoProp.get().getProperty("HomepageType_xpath")),driver)))
	{
	log.info("Successfully verified user is in Homepage");
	Reporter.log("<p>Successfully verified user is in Homepage");
	// If not throw IllegalStateException
	throw new IllegalStateException("User is not in HomePage ");
	}
	return new HomePage(driver);

	}
	
	
	public HomePage StoreOrderIDInPropertiesFIle(String OrderIDtxt, String index) throws Exception
	{
		 File file = new File("Store_Order_ID_Details");
		 File parent = file.getAbsoluteFile();
         System.out.println(parent);     
         FileWriter writer = new FileWriter(parent, true);
		 Properties p = new Properties();
		 writer.write("Line Added on: " + new java.util.Date()+"\n");
		 p.setProperty(index,OrderIDtxt);
		 p.store(writer, "OrderID Details");
		 writer.close();
		 return new HomePage(driver);
	}


}