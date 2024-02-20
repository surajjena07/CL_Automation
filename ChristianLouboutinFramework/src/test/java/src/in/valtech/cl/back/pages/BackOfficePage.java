package src.in.valtech.cl.back.pages;
import static src.in.valtech.util.PropertyFileReader.ObjRepoProp; 
import static src.in.valtech.util.PropertyFileReader.TextProp;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import src.in.valtech.cl.front.pages.MyAccountPage;
import src.in.valtech.cl.front.pages.OrderConfirmationPage;
import src.in.valtech.config.BaseTest;
import src.in.valtech.custom.CustomFun;
import src.in.valtech.uifunctions.GUIFunctions;

/**
 * @author Gopalaswamy.M
 *
 */
public class BackOfficePage {

	public Logger log = Logger.getLogger(this.getClass().getName());
	public WebDriver driver;
	public static String OrderStatus;
	public static String RMAIDStatus;
	public static String SkuId_ForProduct;
	public static String NewOrderFor_RMAOffline;
	public static String SKUIDVal;
	public static int InitialSaleableStock_BO;
	public static String ActualStoreView;
	
	/**
	 * BackOfficePage : Constructor
	 */
	public BackOfficePage(WebDriver driver) {
		this.driver = driver;
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	/**
	 * To fetch the Xpath's from Object Repository file - Dashboard Page
	 */

	By ImgBOLogo_xpath = By.xpath(ObjRepoProp.get().getProperty("ImgBOLogo_xpath"));
	By EnterUsernameField_xpath = By.xpath(ObjRepoProp.get().getProperty("EnterUsernameField_xpath"));
	By EnterPasswordField_xpath = By.xpath(ObjRepoProp.get().getProperty("EnterPasswordField_xpath"));
	By SigInbtn_xpath = By.xpath(ObjRepoProp.get().getProperty("SigInbtn_xpath"));
	By Dashboardtxt_xpath = By.xpath(ObjRepoProp.get().getProperty("Dashboardtxt_xpath"));
	By SalesIcon_xpath = By.xpath(ObjRepoProp.get().getProperty("SalesIcon_xpath"));
	By OrderstxtFromSales_xpath = By.xpath(ObjRepoProp.get().getProperty("OrderstxtFromSales_xpath"));
	By OrdersHeadertxt_xpath = By.xpath(ObjRepoProp.get().getProperty("OrdersHeadertxt_xpath"));
	By SearchByKeyboard_xpath = By.xpath(ObjRepoProp.get().getProperty("SearchByKeyboard_xpath"));
	By SearchIcon_xpath = By.xpath(ObjRepoProp.get().getProperty("SearchIcon_xpath"));
	By ReturnstxtFromSales_xpath = By.xpath(ObjRepoProp.get().getProperty("ReturnstxtFromSales_xpath"));
	By ReturnsHeadertxt_xpath = By.xpath(ObjRepoProp.get().getProperty("ReturnsHeadertxt_xpath"));
	By CatalogIcon_xpath = By.xpath(ObjRepoProp.get().getProperty("CatalogIcon_xpath"));
	By ProductstxtFromCatalog_xpath = By.xpath(ObjRepoProp.get().getProperty("ProductstxtFromCatalog_xpath"));
	By ProductsHeadertxt_xpath = By.xpath(ObjRepoProp.get().getProperty("ProductsHeadertxt_xpath"));
	By Filtersbtn_xpath = By.xpath(ObjRepoProp.get().getProperty("Filtersbtn_xpath"));
	By ProductBarcodeSku_xpath = By.xpath(ObjRepoProp.get().getProperty("ProductBarcodeSku_xpath"));
	By ApplyFiltersbtn_xpath = By.xpath(ObjRepoProp.get().getProperty("ApplyFiltersbtn_xpath"));
	By OrderRowFromGridResult_xpath = By.xpath(ObjRepoProp.get().getProperty("OrderRowFromGridResult_xpath"));
	By CreateReturnsbtn_xpath = By.xpath(ObjRepoProp.get().getProperty("CreateReturnsbtn_xpath"));
	By NewReturnHeadertxt_xpath = By.xpath(ObjRepoProp.get().getProperty("NewReturnHeadertxt_xpath"));
	By PickupdateRadiobtn_xpath = By.xpath(ObjRepoProp.get().getProperty("PickupdateRadiobtn_xpath"));
	By ReturnItemstxt_xpath = By.xpath(ObjRepoProp.get().getProperty("ReturnItemstxt_xpath"));
	By AddProductsbtn_xpath = By.xpath(ObjRepoProp.get().getProperty("AddProductsbtn_xpath"));
	By CheckboxProdToAdd_xpath = By.xpath(ObjRepoProp.get().getProperty("CheckboxProdToAdd_xpath"));
	By AddSelProdToReturnsBtn_xpath = By.xpath(ObjRepoProp.get().getProperty("AddSelProdToReturnsBtn_xpath"));
	By RequestedField_xpath = By.xpath(ObjRepoProp.get().getProperty("RequestedField_xpath"));
	By ReturnReasondpn_xpath = By.xpath(ObjRepoProp.get().getProperty("ReturnReasondpn_xpath"));
	By ItemConditiondpn_xpath = By.xpath(ObjRepoProp.get().getProperty("ItemConditiondpn_xpath"));
	By Resolutiondpn_xpath = By.xpath(ObjRepoProp.get().getProperty("Resolutiondpn_xpath"));
	By SubmitReturnsBtn_xpath = By.xpath(ObjRepoProp.get().getProperty("SubmitReturnsBtn_xpath"));
	By RMASuccessfulMsg_xpath = By.xpath(ObjRepoProp.get().getProperty("RMASuccessfulMsg_xpath"));
	By RMAAddressUpdate_xpath = By.xpath(ObjRepoProp.get().getProperty("RMAAddressUpdate_xpath"));
	By OrderFieldinFiltersPopup_xpath = By.xpath(ObjRepoProp.get().getProperty("OrderFieldinFiltersPopup_xpath"));
	By Editlink_xpath = By.xpath(ObjRepoProp.get().getProperty("Editlink_xpath"));
	By StreetField_xpath = By.xpath(ObjRepoProp.get().getProperty("StreetField_xpath"));
	By PostCodeField_xpath = By.xpath(ObjRepoProp.get().getProperty("PostCodeField_xpath"));
	By CityField_xpath = By.xpath(ObjRepoProp.get().getProperty("CityField_xpath"));
	By PhoneNumField_xpath = By.xpath(ObjRepoProp.get().getProperty("PhoneNumField_xpath"));
	By SaveRMAAddressBtn_xpath = By.xpath(ObjRepoProp.get().getProperty("SaveRMAAddressBtn_xpath"));
	By ApprovedField_xpath = By.xpath(ObjRepoProp.get().getProperty("ApprovedField_xpath"));
	By Statusdpn_xpath = By.xpath(ObjRepoProp.get().getProperty("Statusdpn_xpath"));
	By SaveButton_xpath = By.xpath(ObjRepoProp.get().getProperty("SaveButton_xpath"));
	By RefundOrExchangeBtn_xpath = By.xpath(ObjRepoProp.get().getProperty("Refund/ExchangeBtn_xpath"));
	By RefundButton_xpath = By.xpath(ObjRepoProp.get().getProperty("RefundButton_xpath"));
	By Qnt_ToRefund_xpath = By.xpath(ObjRepoProp.get().getProperty("Qnt_ToRefund"));
	By Update_Qty_xpath = By.xpath(ObjRepoProp.get().getProperty("Update_Qty"));
	By TotalShippingPrice_xpath = By.xpath(ObjRepoProp.get().getProperty("TotalShippingPrice"));
	By ShippingFee_inputFld_xpath = By.xpath(ObjRepoProp.get().getProperty("ShippingFee_inputFld"));
	By Update_totals_xpath = By.xpath(ObjRepoProp.get().getProperty("Update_totals_btn"));
	By View_btn_xpath = By.xpath(ObjRepoProp.get().getProperty("View_btn"));
	By BO_BackBtn_Xpath = By.xpath(ObjRepoProp.get().getProperty("BO_BackBtn_xpath"));

	By ContactEmailAddress_Fld = By.xpath(ObjRepoProp.get().getProperty("ContactEmailAddress_Fld"));
	By ReturnID_OrderDetailsAfterCreatingRMAFromBO = By
			.xpath(ObjRepoProp.get().getProperty("ReturnID_OrderDetailsAfterCreatingRMAFromBO"));
	By OrderID_OrderDetailsAfterCreatingRMAFromBO = By
			.xpath(ObjRepoProp.get().getProperty("OrderID_OrderDetailsAfterCreatingRMAFromBO"));
	By CustomerName_OrderDetailsAfterCreatingRMAFromBO = By
			.xpath(ObjRepoProp.get().getProperty("CustomerName_OrderDetailsAfterCreatingRMAFromBO"));
	By EmailAddr_OrderDetailsAfterCreatingRMAFromBO = By
			.xpath(ObjRepoProp.get().getProperty("EmailAddr_OrderDetailsAfterCreatingRMAFromBO"));
	By PickUPDate_OrderDetailsAfterCreatingRMAFromBO = By
			.xpath(ObjRepoProp.get().getProperty("PickUPDate_OrderDetailsAfterCreatingRMAFromBO"));
	By Click_RefundOffline_Btn_xpath = By.xpath(ObjRepoProp.get().getProperty("Click_RefundOffline_Btn"));

	By AddProductBySKU_Btn_xpath = By.xpath(ObjRepoProp.get().getProperty("AddProductBySKU_Btn"));
	By EnterSKUID_INFld_xpath = By.xpath(ObjRepoProp.get().getProperty("EnterSKUID_INFld"));
	By SKUID_FromBOProduct_xpath = By.xpath(ObjRepoProp.get().getProperty("SKUID_FromBOProduct"));
	By EnterQty_INFld_xpath = By.xpath(ObjRepoProp.get().getProperty("EnterQty_INFld"));
	By AddToOrder_Btn_xpath = By.xpath(ObjRepoProp.get().getProperty("AddToOrder_Btn"));
	By BillingAddress_FromBOProduct_xpath = By.xpath(ObjRepoProp.get().getProperty("BillingAddress_FromBOProduct"));
	By ShippingAddress_FromBOProduct_xpath = By.xpath(ObjRepoProp.get().getProperty("ShippingAddress_FromBOProduct"));
	By ExchangeOffline_RadioBtn_xpath = By.xpath(ObjRepoProp.get().getProperty("ExchangeOffline_RadioBtn"));
	By ShippingMethod_Lnk_RMA_xpath = By.xpath(ObjRepoProp.get().getProperty("ShippingMethod_Lnk_RMA"));
	By First_ShippingMethod_RadioBtn_RMA_xpath = By
			.xpath(ObjRepoProp.get().getProperty("First_ShippingMethod_RadioBtn_RMA"));
	By Second_ShippingMethod_RadioBtn_RMA_xpath = By
			.xpath(ObjRepoProp.get().getProperty("Second_ShippingMethod_RadioBtn_RMA"));

	By OrderTotals_HeaderTxt_RMA_xpath = By.xpath(ObjRepoProp.get().getProperty("OrderTotals_HeaderTxt_RMA"));
	By OrderTotals_SubTotalVal_RMA_xpath = By.xpath(ObjRepoProp.get().getProperty("OrderTotals_SubTotalVal_RMA"));
	By OrderTotals_ShippingAndHandlingVal_RMA_xpath = By
			.xpath(ObjRepoProp.get().getProperty("OrderTotals_ShippingAndHandlingVal_RMA"));
	By SubmitOrderForExchange_Btn_RMA_xpath = By.xpath(ObjRepoProp.get().getProperty("SubmitOrderForExchange_Btn_RMA"));
	By RMACreatedOrderSuccess_msg_xpath = By.xpath(ObjRepoProp.get().getProperty("RMACreatedOrderSuccess_msg"));
	By RMACreatedOrder_xpath = By.xpath(ObjRepoProp.get().getProperty("RMACreatedOrder"));
	By RetryCreateOrderExchangeBtn_xpath = By.xpath(ObjRepoProp.get().getProperty("RetryCreateOrderExchangeBtn"));

	By CustomersIcon_xpath = By.xpath(ObjRepoProp.get().getProperty("CustomersIcon_xpath"));
	By AllCustomerstxtFromCustomers_xpath = By
			.xpath(ObjRepoProp.get().getProperty("AllCustomerstxtFromCustomers_xpath"));
	By CustomersHeadertxt_xpath = By.xpath(ObjRepoProp.get().getProperty("CustomersHeadertxt_xpath"));
	By CustomerChk_xpath = By.xpath(ObjRepoProp.get().getProperty("CustomerChk_xpath"));
	By ActionsDdp_xpath = By.xpath(ObjRepoProp.get().getProperty("ActionsDdp_xpath"));
	By Deletetxt_xpath = By.xpath(ObjRepoProp.get().getProperty("Deletetxt_xpath"));
	By StatusdpnReject_xpath = By.xpath(ObjRepoProp.get().getProperty("StatusdpnReject_xpath"));
	By SystemIcon_xpath = By.xpath(ObjRepoProp.get().getProperty("SystemIcon_xpath"));
	By SystemIcon_xpath2 = By.xpath(ObjRepoProp.get().getProperty("SystemIcon_xpath2"));
    By IndexManagementtxt_xpath = By.xpath(ObjRepoProp.get().getProperty("IndexManagementtxt_xpath"));
    By CacheManagementtxt_xpath = By.xpath(ObjRepoProp.get().getProperty("CacheManagementtxt_xpath"));
    By FlushMagentoCachetxt_xpath = By.xpath(ObjRepoProp.get().getProperty("FlushMagentoCachetxt_xpath"));
    By FlushCategoriesCache_xpath = By.xpath(ObjRepoProp.get().getProperty("FlushCategoriesCache_xpath"));
    
/* Phase2**/
	
	By BO_categoriesSubMenu = By.xpath(ObjRepoProp.get().getProperty("BO_categoriesSubMenu"));
	By BO_rootCategoryBtn = By.xpath(ObjRepoProp.get().getProperty("BO_rootCategoryBtn"));
	By BO_categoryPageTitle = By.xpath(ObjRepoProp.get().getProperty("BO_categoryPageTitle"));
	By BO_curentlyActiveSection = By.xpath(ObjRepoProp.get().getProperty("BO_curentlyActiveSection"));
	By BO_catEnableField = By.xpath(ObjRepoProp.get().getProperty("BO_catEnableField"));
	By BO_includeInMenuField = By.xpath(ObjRepoProp.get().getProperty("BO_includeInMenuField"));
	By BO_toMerchField = By.xpath(ObjRepoProp.get().getProperty("BO_toMerchField"));
	By BO_ContentSection = By.xpath(ObjRepoProp.get().getProperty("BO_ContentSection"));
	By BO_displaySettingsSection = By.xpath(ObjRepoProp.get().getProperty("BO_displaySettingsSection"));
	By BO_SEOSection = By.xpath(ObjRepoProp.get().getProperty("BO_SEOSection"));
	By BO_productsInCategorysection = By.xpath(ObjRepoProp.get().getProperty("BO_productsInCategorysection"));
	By BO_designSection = By.xpath(ObjRepoProp.get().getProperty("BO_designSection"));
	By BO_RootCategoryName = By.xpath(ObjRepoProp.get().getProperty("BO_RootCategoryName"));
	By BO_saveBtn = By.xpath(ObjRepoProp.get().getProperty("BO_saveBtn"));
	By BO_categorySource = By.xpath(ObjRepoProp.get().getProperty("BO_categorySource"));
	By BO_categoryTarget = By.xpath(ObjRepoProp.get().getProperty("BO_categoryTarget"));
	By BO_warningMessage = By.xpath(ObjRepoProp.get().getProperty("BO_warningMessage"));
	By BO_okBtn = By.xpath(ObjRepoProp.get().getProperty("BO_okBtn"));
	By BO_pageTitle = By.xpath(ObjRepoProp.get().getProperty("BO_pageTitle"));
	By BO_subCategoryBtn = By.xpath(ObjRepoProp.get().getProperty("BO_subCategoryBtn"));
	By BO_leftMenuExpand = By.xpath(ObjRepoProp.get().getProperty("BO_leftMenuExpand"));
	By BO_allStoresScope = By.xpath(ObjRepoProp.get().getProperty("BO_allStoresScope"));
	By BO_scopeStore = By.xpath(ObjRepoProp.get().getProperty("BO_scopeStore"));
	By BO_ScopeOKBtn = By.xpath(ObjRepoProp.get().getProperty("BO_ScopeOKBtn"));
	By BO_hideAndDisplaay = By.xpath(ObjRepoProp.get().getProperty("BO_hideAndDisplaay"));
	By BO_addProduct = By.xpath(ObjRepoProp.get().getProperty("BO_addProduct"));
	By BO_merchFiltersBtn = By.xpath(ObjRepoProp.get().getProperty("BO_merchFiltersBtn"));
	By BO_qntyFrom = By.xpath(ObjRepoProp.get().getProperty("BO_qntyFrom"));
	By BO_qntyTo = By.xpath(ObjRepoProp.get().getProperty("BO_qntyTo"));
	By BO_applyFiltersBtn = By.xpath(ObjRepoProp.get().getProperty("BO_applyFiltersBtn"));
	By BO_product1 = By.xpath(ObjRepoProp.get().getProperty("BO_product1"));
	By BO_product2 = By.xpath(ObjRepoProp.get().getProperty("BO_product2"));
	By BO_saveAndCloseBtn = By.xpath(ObjRepoProp.get().getProperty("BO_saveAndCloseBtn"));
	By BO_merchTileViewBtn = By.xpath(ObjRepoProp.get().getProperty("BO_merchTileViewBtn"));
	By BO_merchSelectCheckbox = By.xpath(ObjRepoProp.get().getProperty("BO_merchSelectCheckbox"));
	By BO_merchPool = By.xpath(ObjRepoProp.get().getProperty("BO_merchPool"));
	By BO_productPool = By.xpath(ObjRepoProp.get().getProperty("BO_productPool"));
	By BO_selectMerchProduct = By.xpath(ObjRepoProp.get().getProperty("BO_selectMerchProduct"));
	By BO_rootCatUseDefaultValue = By.xpath(ObjRepoProp.get().getProperty("BO_rootCatUseDefaultValue"));
	By BO_saveSucessMsg = By.xpath(ObjRepoProp.get().getProperty("BO_saveSucessMsg"));
	//By BO_createdSubCategory = By.xpath(ObjRepoProp.get().getProperty("BO_createdSubCategory"));
	By BO_createdRootCategory = By.xpath(ObjRepoProp.get().getProperty("BO_createdRootCategory"));
	By BO_systemMenu = By.xpath(ObjRepoProp.get().getProperty("BO_systemMenu"));
	By BO_cacheMenu = By.xpath(ObjRepoProp.get().getProperty("BO_cacheMenu"));
	By BO_flushMagentoCacheBtn = By.xpath(ObjRepoProp.get().getProperty("BO_flushMagentoCacheBtn"));
	By BO_flushCategoryCacheBtn = By.xpath(ObjRepoProp.get().getProperty("BO_flushCategoryCacheBtn"));
	By BO_cacheFlushMsg = By.xpath(ObjRepoProp.get().getProperty("BO_cacheFlushMsg"));
	By BO_accountIcon = By.xpath(ObjRepoProp.get().getProperty("BO_accountIcon"));
	By BO_signoutBtn = By.xpath(ObjRepoProp.get().getProperty("BO_signoutBtn"));
	By BO_catUseDefaultVlaue = By.xpath(ObjRepoProp.get().getProperty("BO_catUseDefaultVlaue"));
	By BO_URLKey_Usedefault = By.xpath(ObjRepoProp.get().getProperty("BO_URLKey_Usedefault"));
	By BO_URLName = By.xpath(ObjRepoProp.get().getProperty("BO_URLName"));
	By BO_segmentableField = By.xpath(ObjRepoProp.get().getProperty("BO_segmentableField"));
	By BO_ExpandAll = By.xpath(ObjRepoProp.get().getProperty("BO_ExpandAll"));
	By BO_CollapseAll = By.xpath(ObjRepoProp.get().getProperty("BO_CollapseAll"));
	By BO_CatDeleteBtn = By.xpath(ObjRepoProp.get().getProperty("BO_CatDeleteBtn"));
	By BO_productTileViewBtn = By.xpath(ObjRepoProp.get().getProperty("BO_productTileViewBtn"));
	By BO_MarketingTab = By.xpath(ObjRepoProp.get().getProperty("BO_MarketingTab"));
	By BO_AllowPreOrderToggle = By.xpath(ObjRepoProp.get().getProperty("BO_AllowPreOrderToggle"));
	By BO_ImagesAndVideosTab = By.xpath(ObjRepoProp.get().getProperty("BO_ImagesAndVideosTab"));
	By BO_DescriptionTab = By.xpath(ObjRepoProp.get().getProperty("BO_DescriptionTab"));
	By BO_enableCatDefaultValue = By.xpath(ObjRepoProp.get().getProperty("BO_enableCatDefaultValue"));
	By BO_displayedProducts = By.xpath(ObjRepoProp.get().getProperty("BO_displayedProducts"));
	By BO_searchAllProdsBtn = By.xpath(ObjRepoProp.get().getProperty("BO_searchAllProdsBtn"));
	By BO_addProdBySkuTab = By.xpath(ObjRepoProp.get().getProperty("BO_addProdBySkuTab"));
	By BO_addProdBySkuTextarea = By.xpath(ObjRepoProp.get().getProperty("BO_addProdBySkuTextarea"));
	By BO_addProdBySkuAssignbtn = By.xpath(ObjRepoProp.get().getProperty("BO_addProdBySkuAssignbtn"));
	By BO_productPoolselect = By.xpath(ObjRepoProp.get().getProperty("BO_productPoolselect"));
	By BO_productRemovePool = By.xpath(ObjRepoProp.get().getProperty("BO_productRemovePool"));
	By BO_productPoolSrc = By.xpath(ObjRepoProp.get().getProperty("BO_productPoolSrc"));
	By BO_productPoolTarget = By.xpath(ObjRepoProp.get().getProperty("BO_productPoolTarget"));
	

	/**
	 * MethodName = navigateToBOApplication_URL() Description = Navigate to BO
	 * application and Check Login page is loaded or not
	 * 
	 * @return :BackOfficePage
	 * @throws InterruptedException 
	 */

	public static BackOfficePage navigateToBOApplication_URL(WebDriver driver, String baseurl) throws InterruptedException {
		driver.navigate().to(baseurl);
		CustomFun.waitForPageLoaded(driver);
		return new BackOfficePage(driver);
	}

	/**
	 * MethodName = VerifyMagentoLogoImg(); Description = Verify Magento_logo exist
	 * or not in Magento Login page
	 * 
	 * @return :BackOfficePage
	 */

	public BackOfficePage VerifyMagentoLogoImg() throws InterruptedException {
		Assert.assertTrue(CustomFun.isElementPresent(ImgBOLogo_xpath, driver), "Magento_logo is not displayed");
		Thread.sleep(1000);
		log.info("Successfully verified Magento_logo");
		Reporter.log("<p>Successfully verified Magento_logo");
		return new BackOfficePage(driver);
	}

	/**
	 * MethodName=EnterUsername Description:This function used to enters username in
	 * the username field
	 */

	public BackOfficePage EnterUsername(String Username) throws InterruptedException {
		GUIFunctions.typeTxtboxValue(driver, EnterUsernameField_xpath, Username.trim());
		Thread.sleep(2000);
		log.info("Entered Username Successfully: " + Username);
		Reporter.log("<p>Entered Username Successfully: " + Username);
		return new BackOfficePage(driver);
	}

	/**
	 * MethodName=EnterPassword Description:This function used to enters Password
	 */

	public BackOfficePage EnterPassword(String password) throws InterruptedException {
		GUIFunctions.typeTxtboxValue(driver, EnterPasswordField_xpath, password.trim());
		Thread.sleep(2000);
		log.info("Entered Password Successfully: " + password);
		Reporter.log("<p>Entered Password Successfully: " + password);
		return new BackOfficePage(driver);
	}

	/**
	 * MethodName=click on Sign in Button Description:This function used to Clicks
	 * On Sign in Button
	 */

	public BackOfficePage SignbtnClick() throws InterruptedException {
		GUIFunctions.clickElement(driver, SigInbtn_xpath, "Click on Sign In button");
		Thread.sleep(2000);
		return new BackOfficePage(driver);
	}

	/**
	 * MethodName=VerifyDashboardHeader() Description:This function used to verifies
	 * the Dashboard text and check whether user is in Dashboard page
	 */

	public BackOfficePage VerifyDashboardHeader() throws InterruptedException {
		Thread.sleep(10000);
		BaseTest.expected = driver.findElement(Dashboardtxt_xpath).getText();
		Assert.assertEquals(TextProp.get().getProperty("Dashboard_txt"), BaseTest.expected);
		log.info("Verified Dashboard Header and Successfully navigated to Dashboard page");
		Reporter.log("<p>Verified Dashboard Header and Successfully navigated to Dashboard page");
		return new BackOfficePage(driver);
	}

	/**
	 * MethodName=click on Sales Icon Description:This function used to Click On
	 * Sales Icon
	 */

	public BackOfficePage SalesIconClick() throws InterruptedException {
		GUIFunctions.clickElement(driver, SalesIcon_xpath, "Click on Sales Icon");
		return new BackOfficePage(driver);
	}

	/**
	 * MethodName=OrderstxtFromSalesIconClick() Description:This function used to
	 * click on orders text from Sales Icon
	 */

	public BackOfficePage OrderstxtFromSalesIconClick() throws InterruptedException {
		GUIFunctions.clickElement(driver, OrderstxtFromSales_xpath, "Click on orders text from Sales Icon");
		return new BackOfficePage(driver);
	}

	/**
	 * MethodName=VerifyOrdersHeadertxt() Description:This function used to verifies
	 * the Orders Header text and check whether user is in Order details page
	 */

	public BackOfficePage VerifyOrdersHeadertxt() throws InterruptedException {
		CustomFun.waitObjectToLoad(driver, OrdersHeadertxt_xpath, Duration.ofSeconds(50));
		BaseTest.expected = driver.findElement(OrdersHeadertxt_xpath).getText();
		Assert.assertEquals(TextProp.get().getProperty("OrdersHeadertxt"), BaseTest.expected);
		Thread.sleep(10000);
		log.info("Verified Orders header text and Successfully navigated to Order details page");
		Reporter.log("<p>Verified Orders header text and Successfully navigated to Order details page");
		return new BackOfficePage(driver);
	}

	/**
	 * MethodName=EnterOrderId() Description:This function used to enters order id
	 * in search field
	 */

	public BackOfficePage EnterOrderId(String OrderIDtxt) throws InterruptedException {
		GUIFunctions.typeTxtboxValue(driver, SearchByKeyboard_xpath, OrderIDtxt);
		Thread.sleep(2000);
		log.info("Entered OrderID Successfully in search field: " + OrderIDtxt);
		Reporter.log("<p>Entered OrderID Successfully in search field: " + OrderIDtxt);
		return new BackOfficePage(driver);
	}

	/**
	 * MethodName=SearchIconClick() Description:This function used to Click on
	 * Search Icon
	 */

	public BackOfficePage SearchIconClick() throws InterruptedException {
		GUIFunctions.clickElement(driver, SearchIcon_xpath, "Click on Search Icon");
		Thread.sleep(2000);
		return new BackOfficePage(driver);
	}

	/**
	 * MethodName=VerifyOrderStatusInBO_OrdersPage() Description:This function
	 * verifies the order status in orders page in BO
	 * 
	 * @throws Exception
	 */

	public BackOfficePage VerifyOrderStatusInBO_OrdersPage(String OrderIDtxt) throws Exception {
		Thread.sleep(10000);
		By ele = By.xpath("//div[contains(text(),'" + OrderIDtxt
				+ "')]/../following-sibling::td[contains(@class,'status')]//div");
		Thread.sleep(10000);
		OrderStatus = driver.findElement(ele).getText();
		GUIFunctions.VerifyOrderStatusInBO(OrderStatus, OrderIDtxt);
		Thread.sleep(1000);
		return new BackOfficePage(driver);
	}

	/**
	 * MethodName=ClickOnOrderGrid() Description:This function used to open specific
	 * order row
	 * 
	 * @throws Exception
	 */

	public BackOfficePage ClickOnOrderGrid(String OrderIDtxt) throws Exception {
		By OrderGridRow = By.xpath("//div[contains(text(),'" + OrderIDtxt + "')]/../following-sibling::td");
		GUIFunctions.JavaScriptClick(driver, driver.findElement(OrderGridRow), "Click on Order Grid Row");
		Thread.sleep(2000);
		return new BackOfficePage(driver);
	}

	/**
	 * MethodName=ReturnstxtFromSalesIconClick() Description:This function used to
	 * click on Returns text from Sales Icon
	 */

	public BackOfficePage ReturnstxtFromSalesIconClick() throws InterruptedException {
		GUIFunctions.clickElement(driver, ReturnstxtFromSales_xpath, "Click on Returns text from Sales Icon");
		Thread.sleep(2000);
		return new BackOfficePage(driver);
	}

	/**
	 * MethodName=VerifyReturnsHeadertxt() Description:This function used to
	 * verifies the Returns Header text and check whether user is in Returns page
	 */

	public BackOfficePage VerifyReturnsHeadertxt() throws InterruptedException {
		BaseTest.expected = driver.findElement(ReturnsHeadertxt_xpath).getText();
		Assert.assertEquals(TextProp.get().getProperty("ReturnsHeadertxt"), BaseTest.expected);
		log.info("Verified Returns header text and Successfully navigated to Returns page");
		Reporter.log("<p>Verified Returns header text and Successfully navigated to Returns page");
		return new BackOfficePage(driver);
	}

	/**
	 * MethodName=VerifyReturnsStatusInBO_ReturnsPage() Description:This function
	 * verifies the returns status in returns page in BO
	 * 
	 * @throws Exception
	 */

	public BackOfficePage VerifyReturnsStatusInBO_ReturnsPage(String ReturnsIDtxt) throws Exception {
		By ele = By.xpath("(//div[contains(text(),'" + ReturnsIDtxt + "')]/../following-sibling::td//div)[4]");
		CustomFun.waitObjectToLoad(driver, ele, Duration.ofSeconds(50));
		RMAIDStatus = driver.findElement(ele).getText();
		GUIFunctions.VerifyReturnsStatusInBO(RMAIDStatus, ReturnsIDtxt);
		return new BackOfficePage(driver);
	}

	/**
	 * MethodName=CatalogIconClick() Description:This function used to Click On
	 * Catalog Icon
	 */

	public BackOfficePage CatalogIconClick() throws InterruptedException {
		GUIFunctions.clickElement(driver, CatalogIcon_xpath, "Click on Catalog Icon");
		return new BackOfficePage(driver);
	}

	/**
	 * MethodName=ProductstxtFromCatalogIconClick() Description:This function used
	 * to click on Products text from Catalog Icon
	 */

	public BackOfficePage ProductstxtFromCatalogIconClick() throws InterruptedException {
		GUIFunctions.clickElement(driver, ProductstxtFromCatalog_xpath, "Click on Products text from Catalog Icon");
		CustomFun.waitForPageLoaded(driver);
		return new BackOfficePage(driver);
	}

	/**
	 * MethodName=VerifyProductsHeadertxt() Description:This function used to
	 * verifies the Products Header text and check whether user is in Products page
	 */

	public BackOfficePage VerifyProductsHeadertxt() throws InterruptedException {
		BaseTest.expected = driver.findElement(ProductsHeadertxt_xpath).getText();
		Assert.assertEquals(TextProp.get().getProperty("ProductsHeadertxt"), BaseTest.expected);
		log.info("Verified Products header text and Successfully navigated to Products page");
		Reporter.log("<p>Verified Products header text and Successfully navigated to Products page");
		return new BackOfficePage(driver);
	}

	/**
	 * MethodName=FiltersBtnClick() Description:This function used to click on
	 * Filters button
	 */

	public BackOfficePage FiltersBtnClick() throws InterruptedException {
		GUIFunctions.clickElement(driver, Filtersbtn_xpath, "click on Filters button");
		Thread.sleep(2000);
		return new BackOfficePage(driver);
	}

	/**
	 * MethodName=SearchForRMAOrder() Description:This function used to click on
	 * Filters button
	 * 
	 * @throws Exception
	 */

	public BackOfficePage SearchForRMAOrder(String OrderID) throws Exception
	{
		GUIFunctions.JavaScriptClick(driver, driver.findElement(Filtersbtn_xpath), "click on Filters button");
		Thread.sleep(2000);
		Actions action = new Actions(driver);
		WebElement OrderField = driver.findElement(OrderFieldinFiltersPopup_xpath);
		Thread.sleep(2000);
		OrderField.click();
		Thread.sleep(2000);
		action.sendKeys(OrderField, OrderID).perform();
		Thread.sleep(2000);
		GUIFunctions.JavaScriptClick(driver, driver.findElement(ApplyFiltersbtn_xpath),
				"click on Apply Filters button");
		Thread.sleep(2000);
		return new BackOfficePage(driver);
	}
	
	/**
	 * MethodName=SearchForRMAOrder() Description:This function used to click on
	 * Filters button
	 * 
	 * @throws Exception
	 */

	public BackOfficePage SearchForRMAOrder_BS(String OrderID) throws Exception
	{
		GUIFunctions.JavaScriptClick(driver, driver.findElement(Filtersbtn_xpath), "click on Filters button");
		Thread.sleep(2000);
		WebElement OrderField = driver.findElement(By.xpath("(//div[@class='admin__data-grid-header'])[2]//div//input[@name='order_increment_id']"));
		Thread.sleep(2000);
		OrderField.click();
		Thread.sleep(2000);
		OrderField.sendKeys(OrderID);
		Thread.sleep(2000);
		GUIFunctions.JavaScriptClick(driver, driver.findElement(ApplyFiltersbtn_xpath),
				"click on Apply Filters button");
		Thread.sleep(2000);
		return new BackOfficePage(driver);
	}
	
	/**
	 * MethodName=SearchForRMAOrder() Description:This function used to click on
	 * Filters button
	 * 
	 * @throws Exception
	 */

	public BackOfficePage SearchForRMAOrderForSafari(String OrderID) throws Exception
	{
		GUIFunctions.JavaScriptClick(driver, driver.findElement(Filtersbtn_xpath), "click on Filters button");
		Thread.sleep(2000);
		WebElement OrderField = driver.findElement(OrderFieldinFiltersPopup_xpath);
		Thread.sleep(2000);
		OrderField.click();
		Thread.sleep(2000);
		WebElement signup_email = (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(OrderFieldinFiltersPopup_xpath));
		((JavascriptExecutor)driver).executeScript("arguments[0].value='"+OrderID+"'", signup_email);
		Thread.sleep(2000);
		GUIFunctions.JavaScriptClick(driver, driver.findElement(ApplyFiltersbtn_xpath),
				"click on Apply Filters button");
		Thread.sleep(2000);
		return new BackOfficePage(driver);
	}

	/**
	 * MethodName=EnterProdBarcodeSkuID() Description:This function used to enters
	 * product barcode in the product barcode(sku) field
	 */

	public BackOfficePage EnterProdBarcodeSkuID(String ProdBarCodeSku) throws InterruptedException {
		GUIFunctions.typeTxtboxValue(driver, ProductBarcodeSku_xpath, ProdBarCodeSku);
		Thread.sleep(2000);
		log.info("Entered Product Barcode (Sku) Successfully:" + ProdBarCodeSku);
		Reporter.log("<p>Entered Product Barcode (Sku) Successfully:" + ProdBarCodeSku);
		return new BackOfficePage(driver);
	}

	/**
	 * MethodName=ApplyFiltersbtnClick() Description:This function used to click on
	 * Apply Filters button
	 * 
	 * @throws Exception
	 */

	public BackOfficePage ApplyFiltersbtnClick() throws Exception {
		GUIFunctions.JavaScriptClick(driver, driver.findElement(ApplyFiltersbtn_xpath),
				"click on Apply Filters button");
		return new BackOfficePage(driver);
	}

	/**
	 * MethodName=VerifyQuantityvalue() Description:This function used to verify
	 * quantity value
	 */

	public BackOfficePage VerifyQuantityvalue(String ProdBarCodeSku) throws InterruptedException {
		By Qtyvalue = By.xpath("//div[contains(text(),'" + ProdBarCodeSku + "')]/../following-sibling::td[3]");
		GUIFunctions.verifyUIElementAndShowText(driver.findElement(Qtyvalue), "quantity value");
		return new BackOfficePage(driver);
	}

	/**
	 * MethodName=OrderRowFromGridResultClick() Description:This function used to
	 * click on Order Row From Grid Result
	 */

	public BackOfficePage OrderRowFromGridResultClick() throws InterruptedException {
		GUIFunctions.clickElement(driver, OrderRowFromGridResult_xpath, "Click on Order Row From Grid Result");
		Thread.sleep(2000);
		return new BackOfficePage(driver);
	}

	/**
	 * MethodName=CreateReturnsBtnClick() Description:This function used to click on
	 * Create Returns button
	 * 
	 * @throws Exception
	 */

	public BackOfficePage CreateReturnsBtnClick() throws Exception {
		GUIFunctions.JavaScriptClick(driver, driver.findElement(CreateReturnsbtn_xpath),
				"Click on Create Returns button");
		return new BackOfficePage(driver);
	}

	/**
	 * MethodName=VerifyNewReturnHeader() Description:This function used to verifies
	 * the New Return header and check whether user is in New Return Page
	 */

	public BackOfficePage VerifyNewReturnHeader() throws InterruptedException {
		BaseTest.expected = driver.findElement(NewReturnHeadertxt_xpath).getText();
		Assert.assertEquals(TextProp.get().getProperty("NewReturnHeadertxt"), BaseTest.expected);
		log.info("Verified New Return header and Successfully navigated to New Return Page");
		Reporter.log("<p>Verified New Return header and Successfully navigated to New Return Page");
		return new BackOfficePage(driver);
	}

	/**
	 * MethodName=PickupdateRadioBtnClick() Description:This function used to Click
	 * on Pickup date radio button
	 * 
	 * @throws Exception
	 */

	public BackOfficePage PickupdateRadioBtnClick() throws Exception {
		GUIFunctions.scrollByJavaScriptExecutor(driver.findElement(PickupdateRadiobtn_xpath), driver,
				"Pickup date radio button");
		Thread.sleep(2000);
		GUIFunctions.JavaScriptClick(driver, driver.findElement(PickupdateRadiobtn_xpath),
				"Click on Pickup date radio button");
		Thread.sleep(2000);
		return new BackOfficePage(driver);
	}

	/**
	 * MethodName=ReturnsItemsClick() Description:This function used to Click on
	 * Returns Items button
	 * 
	 * @throws Exception
	 */

	public BackOfficePage ReturnsItemsClick() throws Exception {
		GUIFunctions.scrollByJavaScriptExecutor(driver.findElement(ReturnItemstxt_xpath), driver,
				"Returns Items button");
		Thread.sleep(2000);
		GUIFunctions.JavaScriptClick(driver, driver.findElement(ReturnItemstxt_xpath), "Click on Returns Items button");
		Thread.sleep(2000);
		return new BackOfficePage(driver);
	}

	/**
	 * MethodName=AddProductsBtnClick() Description:This function used to Click on
	 * Add Products button
	 * 
	 * @throws Exception
	 */

	public BackOfficePage AddProductsBtnClick() throws Exception {
		GUIFunctions.JavaScriptClick(driver, driver.findElement(AddProductsbtn_xpath), "Click on Add Products button");
		Thread.sleep(2000);
		return new BackOfficePage(driver);
	}

	/**
	 * MethodName=CheckboxProdToAddClick Description:This function used to Click on
	 * Checkbox under Please Select Products to Add
	 * 
	 * @throws Exception
	 */

	public BackOfficePage CheckboxProdToAddClick() throws Exception {
		int CheckboxSizeCount = driver.findElements(CheckboxProdToAdd_xpath).size();
		for (int i = 0; i < CheckboxSizeCount; i++) {
			GUIFunctions.JavaScriptClick(driver, driver.findElements(CheckboxProdToAdd_xpath).get(i),
					"Click on Checkbox");
			Thread.sleep(2000);
		}
		return new BackOfficePage(driver);
	}

	/**
	 * MethodName=AddSelProdToReturnsBtnClick() Description:This function used to
	 * Click on Add Selected Product(s) to returns button
	 * 
	 * @throws Exception
	 */

	public BackOfficePage AddSelProdToReturnsBtnClick() throws Exception {
		GUIFunctions.JavaScriptClick(driver, driver.findElement(AddSelProdToReturnsBtn_xpath),
				"Click on Add Selected Product(s) to returns button");
		Thread.sleep(10000);
		return new BackOfficePage(driver);
	}

	/**
	 * MethodName=EnterValueInRequestedField() Description:This function used to
	 * enters Requested value in the Requested field
	 */

	public BackOfficePage EnterValueInRequestedField(String RequestedValue) throws InterruptedException {
		int RequestFieldCount = driver.findElements(RequestedField_xpath).size();
		for (int i = 0; i < RequestFieldCount; i++) {
			driver.findElements(RequestedField_xpath).get(i).sendKeys(RequestedValue);
			Thread.sleep(2000);
		}
		log.info("Entered Requested Value Successfully:" + RequestedValue);
		Reporter.log("<p>Entered Requested Value Successfully:" + RequestedValue);
		return new BackOfficePage(driver);
	}

	/**
	 * MethodName :SelectOptionFromReturnReasonDropdown() Description :Select
	 * options from Return Reason dropdown
	 * 
	 * @return :BackOfficePage
	 * @throws Exception
	 */

	public BackOfficePage SelectOptionFromReturnReasonDropdown(String Reasontxt) throws Exception {
		int ReturnReasonDpdCount = driver.findElements(ReturnReasondpn_xpath).size();
		for (int i = 0; i < ReturnReasonDpdCount; i++) {
			WebElement ReturnReasonOptions = driver.findElements(ReturnReasondpn_xpath).get(i);
			// select Changed Mind Options from Return Reason dropdown
			GUIFunctions.selectDropDownValue(ReturnReasonOptions, Reasontxt , "text", "Return Reason dropdown");
			Thread.sleep(2000);
		}
		return new BackOfficePage(driver);
	}

	/**
	 * MethodName :SelectOptionFromItemConditionDropdown() Description :Select
	 * options from Item Condition dropdown
	 * 
	 * @return :BackOfficePage
	 * @throws Exception
	 */

	public BackOfficePage SelectOptionFromItemConditionDropdown() throws Exception {
		int ItemConditiondpnCount = driver.findElements(ItemConditiondpn_xpath).size();
		for (int i = 0; i < ItemConditiondpnCount; i++) {
			WebElement ItemConditionOptions = driver.findElements(ItemConditiondpn_xpath).get(i);
			;

			// select Box Opened Options from Item Condition dropdown
			GUIFunctions.selectDropDownValue(ItemConditionOptions, "Box Opened", "text", "Item Condition dropdown");
			Thread.sleep(2000);
		}
		return new BackOfficePage(driver);
	}

	/**
	 * MethodName :SelectOptionFromResolutionDropdown() Description :Select options
	 * from Resolution dropdown
	 * 
	 * @return :BackOfficePage
	 * @throws Exception
	 */

	public BackOfficePage SelectOptionFromResolutionDropdown(String Resolutiontxt) throws Exception {
		int ResolutiondpnCount = driver.findElements(Resolutiondpn_xpath).size();
		for (int i = 0; i < ResolutiondpnCount; i++) {
			WebElement ResolutionOptions = driver.findElements(Resolutiondpn_xpath).get(i);
			;

			// select Refund Options from Resolution dropdown
			GUIFunctions.selectDropDownValue(ResolutionOptions, Resolutiontxt, "text", "Resolution dropdown");
			Thread.sleep(2000);
		}
		return new BackOfficePage(driver);
	}

	/**
	 * MethodName=SubmitReturnsBtnClick() Description:This function used to Click on
	 * Submit Returns button
	 * 
	 * @throws Exception
	 */

	public BackOfficePage SubmitReturnsBtnClick() throws Exception {
		GUIFunctions.JavaScriptClick(driver, driver.findElement(SubmitReturnsBtn_xpath),
				"Click on Submit Returns button");
		Thread.sleep(2000);
		return new BackOfficePage(driver);
	}

	/**
	 * MethodName=VerifySuccessfulMsgForRMARequest() Description:This function used
	 * to verifies the You submitted the RMA request Message
	 */

	public BackOfficePage VerifySuccessfulMsgForRMARequest() throws InterruptedException {
		BaseTest.expected = driver.findElement(RMASuccessfulMsg_xpath).getText();
		Assert.assertEquals(TextProp.get().getProperty("RMARequestMsgtxt"), BaseTest.expected);
		log.info("Verified successfully You submitted the RMA request Message");
		Reporter.log("<p>Verified successfully You submitted the RMA request Message");
		return new BackOfficePage(driver);
	}

	/**
	 * MethodName=VerifySuccessfulMsgForRMARequest() Description:This function used
	 * to verifies success message for RMA Address update
	 */

	public BackOfficePage VerifySuccessMsgForRMAAddressUpdate() throws InterruptedException {
		BaseTest.expected = driver.findElement(RMAAddressUpdate_xpath).getText();
		Assert.assertEquals(TextProp.get().getProperty("RMAUpdatedMsgtxt"), BaseTest.expected);
		log.info("Verified successfully You updated the RMA address");
		Reporter.log("<p>Verified successfully You updated the RMA address");
		return new BackOfficePage(driver);
	}

	/*
	 * MethodName=EditExistShippingAddressWithNewShippingAddressForRMA()
	 * Description:This function used to Edit Exist Shipping Address With Different
	 * Shipping Address For RMA
	 */

	public BackOfficePage EditExistShippingAddressWithNewShippingAddressForRMA() throws Exception {
		GUIFunctions.scrollByJavaScriptExecutor(driver.findElement(Editlink_xpath), driver,
				"Edit button under Address Informations Grid");
		Thread.sleep(2000);
		GUIFunctions.JavaScriptClick(driver, driver.findElement(Editlink_xpath), "Click on Edit button");
		Thread.sleep(10000);
		GUIFunctions.scrollByJavaScriptExecutor(driver.findElement(StreetField_xpath), driver, "Street Field");
		Thread.sleep(2000);
		GUIFunctions.typeTxtboxValue(driver, StreetField_xpath, " 24 Quai des Belges");
		Thread.sleep(2000);
		GUIFunctions.typeTxtboxValue(driver, CityField_xpath, "Maubeuge");
		Thread.sleep(2000);
		GUIFunctions.typeTxtboxValue(driver, PhoneNumField_xpath, "02.09.03.27.88");
		Thread.sleep(2000);
		GUIFunctions.JavaScriptClick(driver, driver.findElement(SaveRMAAddressBtn_xpath),
				"Click on Save RMA Address button");
		Thread.sleep(10000);
		log.info("Edited Exist Shipping Address with New Shipping Address");
		Reporter.log("<p>Edited Exist Shipping Address with New Shipping Address");
		return new BackOfficePage(driver);
	}

	/**
	 * MethodName=EnterValueInApprovedField() Description:This function used to
	 * enters Approved value in the Approved field
	 */

	public BackOfficePage EnterValueInApprovedField(String ApprovedValue) throws InterruptedException {
		int ApprovedFieldCount = driver.findElements(ApprovedField_xpath).size();
		for (int i = 0; i < ApprovedFieldCount; i++) {
			driver.findElements(ApprovedField_xpath).get(i).sendKeys(ApprovedValue);
			Thread.sleep(2000);
		}
		log.info("Entered Approved Value Successfully:" + ApprovedValue);
		Reporter.log("<p>Entered Approved Value Successfully:" + ApprovedValue);
		return new BackOfficePage(driver);
	}

	/**
	 * MethodName :SelectApprovedOptionFromStatusDropdown() Description :Select
	 * Approved options from Status dropdown
	 * 
	 * @return :BackOfficePage
	 * @throws Exception
	 */

	public BackOfficePage SelectApprovedOptionFromStatusDropdown() throws Exception {
		int StatusDpdCount = driver.findElements(Statusdpn_xpath).size();
		for (int i = 0; i < StatusDpdCount; i++) {
			WebElement OrderStatusOptions = driver.findElements(Statusdpn_xpath).get(i);
			;

			// select Approved Options from Status dropdown
			GUIFunctions.selectDropDownValue(OrderStatusOptions, "Approved", "text", "Status dropdown");
			Thread.sleep(2000);
		}
		return new BackOfficePage(driver);
	}

	/**
	 * MethodName=ClickOnSaveButton() Description:This function used to Click on
	 * Save button
	 * 
	 * @throws Exception
	 */

	public BackOfficePage ClickOnSaveButton() throws Exception {
		GUIFunctions.JavaScriptClick(driver, driver.findElement(SaveButton_xpath), "Click on Save button");
		Thread.sleep(2000);
		return new BackOfficePage(driver);
	}

	/**
	 * MethodName=VerifySuccessMsgForSavedRMARequest() Description:This function
	 * used to verifies You saved the RMA request success message
	 */

	public BackOfficePage VerifySuccessMsgForSavedRMARequest() throws InterruptedException {
		BaseTest.expected = driver.findElement(RMAAddressUpdate_xpath).getText();
		Assert.assertEquals(TextProp.get().getProperty("RMASaveMsgtxt"), BaseTest.expected);
		log.info("Verified successfully You saved the RMA request.");
		Reporter.log("<p>Verified successfully You saved the RMA request.");
		return new BackOfficePage(driver);
	}

	/**
	 * MethodName=ClickOnRefundOrExchangeButton() Description:This function used to
	 * Click on Refund / Exchange Button
	 * 
	 * @throws Exception
	 */

	public BackOfficePage ClickOnRefundOrExchangeButton() throws Exception {
		GUIFunctions.JavaScriptClick(driver, driver.findElement(RefundOrExchangeBtn_xpath),
				"Click on Refund / Exchange Button");
		Thread.sleep(2000);
		return new BackOfficePage(driver);
	}

	/**
	 * MethodName=ClickOnRefundButtonInNewMemoPage() Description:This function used
	 * to Scroll down till Refund Button and Click on Refund Button
	 * 
	 * @throws Exception
	 */

	public BackOfficePage ClickOnRefundButtonInNewMemoPage() throws Exception {
		GUIFunctions.scrollByJavaScriptExecutor(driver.findElement(RefundButton_xpath), driver, "Refund Button");
		Thread.sleep(2000);
		GUIFunctions.JavaScriptClick(driver, driver.findElement(RefundButton_xpath), "Click on Refund Button");
		Thread.sleep(2000);
		return new BackOfficePage(driver);
	}

	/**
	 * MethodName=VerifySuccessMsgForCreateCreditMemo() Description:This function
	 * used to verifies You saved the RMA request success message
	 */

	public BackOfficePage VerifySuccessMsgForCreateCreditMemo() throws InterruptedException {
		BaseTest.expected = driver.findElement(RMAAddressUpdate_xpath).getText();
		Assert.assertEquals(TextProp.get().getProperty("CreatedCreditMemoMsg"), BaseTest.expected);
		log.info("Verified successfully You created the credit memo.");
		Reporter.log("<p>Verified successfully You created the credit memo.");
		return new BackOfficePage(driver);
	}

	/**
	 * MethodName= Verify order details in BO after placing an order
	 * Description:This function verifies the order details in BO after placing an
	 * order
	 * 
	 * @return :BackOfficePage
	 */

	public BackOfficePage Verify_OrderDetails_BO() throws Exception {

		By ele1 = By.xpath("//div[@class='admin__page-section-item-title']");
		String OrderID_FromBO = driver.findElement(ele1).getText().replaceAll("[^0-9.]", "");
		System.out.println(OrderID_FromBO);
		Assert.assertEquals(OrderConfirmationPage.OrderConfirmationId, OrderID_FromBO);
		System.out.println("Successfully verified order id in BO with the order confirmation ID FO ");
		log.info("Successfully verified order id in BO \n");

		By ele3 = By.xpath("//a[contains(text(),'gmail.com')]");
		String EmailID_FromBO = driver.findElement(ele3).getText();
		Assert.assertEquals(CustomFun.userInfoDSDetails.get().getEmailDomain(), EmailID_FromBO);
		System.out.println(EmailID_FromBO);
		System.out.println("Successfully verified email id in BO with the email id in FO ");
		log.info("Successfully verified email id in BO \n");

		By ele4 = By.xpath("//div[@class='product-title']");
		String ProductName_FromBO = driver.findElement(ele4).getText();
		System.out.println(ProductName_FromBO);

		System.out.println("Successfully verified product name in BO with the product name in FO ");
		log.info("Successfully verified product name in BO \n");

		return new BackOfficePage(driver);
	}

	/**
	 * Description:clear the Qnt to refund field and click on update quantity
	 * 
	 * @throws Exception
	 */

	public BackOfficePage ClearQuntAndClickOnUpdateQTY_CreditMemo() throws Exception {
		driver.findElement(Qnt_ToRefund_xpath).clear();
		if(BaseTest.environment.get().contains("StagingEnv1"))
		{
	    GUIFunctions.JavaScriptClick(driver, driver.findElement(By.xpath("//td[contains(@class,'col-return-to-stock')]//input[contains(@name,'creditmemo[items]')]")), "Click on return to stock btn");
		Thread.sleep(1000);
		}
		GUIFunctions.JavaScriptClick(driver, driver.findElement(Update_Qty_xpath), "Click on update quantity btn ");
		Thread.sleep(2000);
		return new BackOfficePage(driver);
	}

	/**
	 * Description:Get the shipping fee and save it in variable and enter that in
	 * shipping fee field and click on Update total
	 * 
	 * @throws Exception
	 */

	public BackOfficePage EnterShippingFeeAndClickOnUpdate_CreditMemo() throws Exception {
		String shippingFee = driver.findElement(TotalShippingPrice_xpath).getText().replaceAll("[^0-9.]", "");
		Actions action = new Actions(driver);
		driver.findElement(ShippingFee_inputFld_xpath).click();
		Thread.sleep(2000);
		action.sendKeys(driver.findElement(ShippingFee_inputFld_xpath), shippingFee).perform();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='creditmemo_comment_text']")).click();
		Thread.sleep(2000);
		GUIFunctions.JavaScriptClick(driver, driver.findElement(Update_totals_xpath), "Click on update totals btn ");
		return new BackOfficePage(driver);
	}

	/**
	 * MethodName=click on view btn for particular order Description:This function
	 * used to Click on view btn for particular order
	 * 
	 * @throws Exception
	 */

	public BackOfficePage Click_viewBtnForPdt() throws Exception {
		GUIFunctions.JavaScriptClick(driver, driver.findElement(View_btn_xpath),
				"Click on view btn for particular order");
		Thread.sleep(2000);
		return new BackOfficePage(driver);
	}

	/**
	 * MethodName= Verify order details in BO after placing an order
	 * Description:This function verifies the order details in BO after placing an
	 * order
	 * 
	 * @return :BackOfficePage
	 */
	public BackOfficePage Verify_OderDetails_BO(String OrderID) throws Exception {
		if(BaseTest.environment.get().contains("IntegrationEnv"))
		{
		By ele1 = By.xpath("//div[@class='admin__page-section-item-title']");
		String OrderID_FromBO = driver.findElement(ele1).getText().replaceAll("[^0-9.]", "").substring(1);
		System.out.println(OrderID_FromBO);
		Assert.assertEquals(OrderID, OrderID_FromBO);
		}
		else
		{
			By ele1 = By.xpath("//div[@class='admin__page-section-item-title']");
			String OrderID_FromBO = driver.findElement(ele1).getText().replaceAll("[^0-9.]", "");
			System.out.println(OrderID_FromBO);
			Assert.assertEquals(OrderID, OrderID_FromBO);
		}
		System.out.println("Successfully verified order id in BO with the order confirmation ID FO ");
		log.info("Successfully verified order id in BO \n");

		By ele3 = By.xpath("//a[contains(text(),'com')]");
		String EmailID_FromBO = driver.findElement(ele3).getText();
		Assert.assertEquals(CustomFun.userInfoDSDetails.get().getEmailDomain(), EmailID_FromBO);
		System.out.println(EmailID_FromBO);
		System.out.println("Successfully verified email id in BO with the email id in FO ");
		log.info("Successfully verified email id in BO \n");

		return new BackOfficePage(driver);
	}

	/**
	 * MethodName=click on back btn in BO view page Description:This function used
	 * to Click on back btn in BO view page
	 * 
	 * @throws Exception
	 */
	public BackOfficePage Click_BackBtnForBOPrct() throws Exception {
		GUIFunctions.JavaScriptClick(driver, driver.findElement(BO_BackBtn_Xpath), "Click on back btn in BO view page");
		Thread.sleep(2000);
		return new BackOfficePage(driver);
	}

	/**
	 * MethodName=Enter contact email address in create returns Description:This
	 * function used to enters contact email address in create returns
	 */

	public BackOfficePage EnterContactEmailAdd_CreateReturns(String Email) throws InterruptedException {
		GUIFunctions.typeTxtboxValue(driver, ContactEmailAddress_Fld, Email);
		Thread.sleep(2000);
		log.info("Entered Contact Email address Successfully in create returns: " + Email);
		Reporter.log("<p>Entered Contact Email address Successfully create returns: " + Email);
		return new BackOfficePage(driver);
	}

	/**
	 * MethodName :SelectOptionFromResolutionDropdown() Description :Select options
	 * from Resolution dropdown
	 * 
	 * @return :BackOfficePage
	 * @throws Exception
	 */

	public BackOfficePage SelectOptionFromResolutionDropdown() throws Exception {
		int ResolutiondpnCount = driver.findElements(Resolutiondpn_xpath).size();
		for (int i = 0; i < ResolutiondpnCount; i++) {
			WebElement ResolutionOptions = driver.findElements(Resolutiondpn_xpath).get(i);
			;

			// select Refund Options from Resolution dropdown
			GUIFunctions.selectDropDownValue(ResolutionOptions, "Refund", "text", "Resolution dropdown");
			Thread.sleep(2000);
		}
		return new BackOfficePage(driver);
	}

	/**
	 * MethodName=Verify_OrderDetailsAfterCreatingRMAFromBO() Description:This
	 * function used to Verify order details in returns page after creating RMA from
	 * BO
	 * 
	 * @throws Exception
	 */

	public BackOfficePage Verify_OrderDetailsAfterCreatingRMAFromBO() throws Exception {

		GUIFunctions.verifyUIElementAndShowText(driver.findElement(ReturnID_OrderDetailsAfterCreatingRMAFromBO),
				"Verified Return ID from RMA order BO");
		GUIFunctions.verifyUIElementAndShowText(driver.findElement(OrderID_OrderDetailsAfterCreatingRMAFromBO),
				"Verified order ID from RMA order BO");
		GUIFunctions.verifyUIElementAndShowText(driver.findElement(CustomerName_OrderDetailsAfterCreatingRMAFromBO),
				"Verified cust name from RMA order BO");
		GUIFunctions.verifyUIElementAndShowText(driver.findElement(EmailAddr_OrderDetailsAfterCreatingRMAFromBO),
				"Verified eamil addr from RMA order BO");
		GUIFunctions.verifyUIElementAndShowText(driver.findElement(PickUPDate_OrderDetailsAfterCreatingRMAFromBO),
				"Verified pick up date from RMA order BO");

		log.info("Verified_ order details in returns page after creating RMA from BO ");
		Reporter.log("<p>Verified_ order details in returns page after creating RMA from BO");
		return new BackOfficePage(driver);

	}

	/**
	 * MethodName=click on Refund offline Btn in RMA Description:This function used
	 * to Click on Refund offline btn
	 * 
	 * @throws Exception
	 */

	public BackOfficePage Click_RefundOfflineBtnForRMA() throws Exception {
		GUIFunctions.JavaScriptClick(driver, driver.findElement(Click_RefundOffline_Btn_xpath),
				"Click on view btn for particular order");
		Thread.sleep(2000);
		return new BackOfficePage(driver);
	}

	/**
	 * MethodName=click on Add products by SKU in RMA Description:This function used
	 * to Click on Add products by SKU in RMA
	 * 
	 * @throws Exception
	 */

	public BackOfficePage Click_AddProductsBySKUBtnForRMA() throws Exception {
		GUIFunctions.clickElement(driver, AddProductBySKU_Btn_xpath, "Click on  Add products by SKU in RMA");
		return new BackOfficePage(driver);
	}

	/**
	 * MethodName=Enter SKU ID in the field Description:This function used to Enter
	 * SKU ID in the field
	 * 
	 * @throws Exception
	 */

	public BackOfficePage EnterSKUID_InFld() throws Exception {
		GUIFunctions.typeTxtboxValue(driver, EnterSKUID_INFld_xpath, SKUIDVal);
		System.out.println("SKUIDVal " + SKUIDVal);
		Thread.sleep(2000);

		return new BackOfficePage(driver);
	}

	/**
	 * MethodName=Enter Qty in the field Description:This function used to Enter QTY
	 * in the field
	 * 
	 * @throws Exception
	 */

	public BackOfficePage EnterQTY_InFld() throws Exception {
		GUIFunctions.typeTxtboxValue(driver, EnterQty_INFld_xpath, "1");
		Thread.sleep(2000);

		return new BackOfficePage(driver);
	}

	/**
	 * MethodName=click on Add to order btn in RMA refund offline Description:This
	 * function used to Click on Add to order btn in RMA refund offline
	 * 
	 * @throws Exception
	 */

	public BackOfficePage Click_AddToOrderBtnForRefundoffline() throws Exception {

		GUIFunctions.clickElement(driver, AddToOrder_Btn_xpath, "Click on Add to order btn  in RMA refund offline");
		return new BackOfficePage(driver);
	}

	/**
	 * MethodName= Verify_AddressDetails_BOInNRMA() Description:This function Verify
	 * shipping and billing adress details in BO after processing RMA
	 * 
	 * @return :BackOfficePage
	 */

	public BackOfficePage VerifyExistingBillingAndShippingAddressInBO() throws Exception {
		WebElement ele = driver.findElement(By.xpath("//select[@id='order-billing_address_customer_address_id']"));
		Select dropDown = new Select(ele);
		String BillingAdress_FromBO = dropDown.getFirstSelectedOption().getText();

		WebElement ele1 = driver.findElement(By.xpath("//select[@id='order-shipping_address_customer_address_id']"));
		Select dropDown2 = new Select(ele1);
		String ShippingAdress_FromBO = dropDown2.getFirstSelectedOption().getText();
		Assert.assertEquals(BillingAdress_FromBO, ShippingAdress_FromBO);
		Reporter.log("<p>Successfully verified shipping and billing adress details in BO after processing RMA");
		log.info("Successfully verified shipping and billing adress details in BO after processing RMA");
		return new BackOfficePage(driver);
	}

	/**
	 * Select the Exchange offline payment method
	 * 
	 */
	public BackOfficePage ExchangePaymentRadioBtn() throws Exception {
		Thread.sleep(2000);
		GUIFunctions.scrollByJavaScriptExecutor(driver.findElement(ExchangeOffline_RadioBtn_xpath), driver,
				"Exchange Payment RadioBtn");
		Thread.sleep(2000);
		GUIFunctions.JavaScriptClick(driver, driver.findElement(ExchangeOffline_RadioBtn_xpath),
				"Click on Exchange Payment  Radio  Button");
		return new BackOfficePage(driver);
	}

	/**
	 * MethodName=Click_ShippingMethod_LinkForRefundoffline() Description:This
	 * function used to Click on Shipping Method_Link in RMA refund offline
	 * 
	 * @throws Exception
	 */

	public BackOfficePage Click_ShippingMethod_LinkForRefundoffline() throws Exception {
		GUIFunctions.JavaScriptClick(driver, driver.findElement(ShippingMethod_Lnk_RMA_xpath),
				"Click on ShippingMethod_Link  in RMA refund offline");
		return new BackOfficePage(driver);
	}

	/**
	 * MethodName=Click_FirstShippingMethod_BtnForRefundoffline() Description:This
	 * function used to Click on first Shipping Method_Btn in RMA refund offline
	 * 
	 * @throws Exception
	 */

	public BackOfficePage Click_FirstShippingMethod_BtnForRefundoffline() throws Exception {
		GUIFunctions.scrollByJavaScriptExecutor(driver.findElement(First_ShippingMethod_RadioBtn_RMA_xpath), driver,
				"scroll till shipping method link");
		Thread.sleep(2000);
		GUIFunctions.JavaScriptClick(driver, driver.findElement(First_ShippingMethod_RadioBtn_RMA_xpath),
				"Click on First ShippingMethod_Btn  in RMA refund offline");
		return new BackOfficePage(driver);
	}

	/**
	 * MethodName=Click_SecondShippingMethod_BtnForRefundoffline() Description:This
	 * function used to Click on second Shipping Method_Btn in RMA refund offline
	 * 
	 * @throws Exception
	 */

	public BackOfficePage Click_SecondShippingMethod_BtnForRefundoffline() throws Exception {

		GUIFunctions.clickElement(driver, Second_ShippingMethod_RadioBtn_RMA_xpath,
				"Click on Second ShippingMethod_Btn  in RMA refund offline");
		return new BackOfficePage(driver);
	}

	/**
	 * MethodName=Verify_ShippingMethods_RadioOptionForRefundoffline()
	 * Description:This function used to Verify_ShippingMethods_RadioOption in RMA
	 * refund offline
	 * 
	 * @throws Exception
	 */

	public BackOfficePage Verify_ShippingMethods_RadioOptionForRefundoffline() throws Exception {
		Thread.sleep(2000);
		GUIFunctions.verifyUIElementAndShowText(driver.findElement(First_ShippingMethod_RadioBtn_RMA_xpath),
				"Verified_First ShippingMethods_RadioOptionForRefundoffline");
		Thread.sleep(2000);
		GUIFunctions.verifyUIElementAndShowText(driver.findElement(Second_ShippingMethod_RadioBtn_RMA_xpath),
				"Verified_SecondShippingMethods_RadioOptionForRefundoffline");
		Thread.sleep(2000);
		return new BackOfficePage(driver);
	}

	/**
	 * MethodName=Verify_OrderTotals_ForRefundoffline() Description:This function
	 * used to Verify_order totals in RMA refund offline
	 * 
	 * @throws Exception
	 */

	public BackOfficePage Verify_OrderTotals_ForRefundoffline() throws Exception {

		GUIFunctions.verifyUIElementAndShowText(driver.findElement(OrderTotals_HeaderTxt_RMA_xpath),
				"Verified order totals header text");
		GUIFunctions.verifyUIElementAndShowText(driver.findElement(OrderTotals_SubTotalVal_RMA_xpath),
				"Verified order totals sub total val");
		GUIFunctions.verifyUIElementAndShowText(driver.findElement(OrderTotals_ShippingAndHandlingVal_RMA_xpath),
				"Verified order totals shipping and handling val");
		log.info("Verified_ order totals For Refundoffline: ");
		Reporter.log("<p>Verified_ order totals For Refundoffline:");
		return new BackOfficePage(driver);

	}

	/**
	 * MethodName=Click_SubmitOrderForExchange_BtnForRefundoffline()
	 * Description:This function used to Click on Submit Order For Exchange_Btn in
	 * RMA refund offline
	 * 
	 * @throws Exception
	 */

	public BackOfficePage Click_SubmitOrderForExchange_BtnForRefundoffline() throws Exception {

		GUIFunctions.clickElement(driver, SubmitOrderForExchange_Btn_RMA_xpath,
				"Click on Submit Order For Exchange_Btn  in RMA refund offline");
		return new BackOfficePage(driver);
	}

	/**
	 * MethodName=Click_OKFromAlertPopupForRefundoffline() Description:This function
	 * used to Click on OK from Alert popup
	 * 
	 * @throws Exception
	 */

	public BackOfficePage Click_OKFromAlertPopupForRefundoffline() throws Exception {
		Alert al = driver.switchTo().alert();
		al.accept();
		Thread.sleep(10000);
		return new BackOfficePage(driver);
	}

	/**
	 * MethodName=VerifySuccessMsgForCreatedOrderForRMAOfflineRequest()
	 * Description:This function used to verifies You saved the RMA request success
	 * message for created order id
	 */

	public BackOfficePage VerifySuccessMsgForCreatedOrderForRMAOfflineRequest() throws InterruptedException {
		BaseTest.expected = driver.findElement(RMACreatedOrderSuccess_msg_xpath).getText();
		Assert.assertEquals(TextProp.get().getProperty("RMACreatedOrderMsgtxt"), BaseTest.expected);
		log.info("Verified successfully You Created order for the RMA request.");
		Reporter.log("<p>Verified successfully You Created order for the RMA request.");
		return new BackOfficePage(driver);
	}

	/**
	 * MethodName= VerifyCreatedOrderInRMAOffline() Description:This function used
	 * to Verify newly created order in Refund offline RMA
	

	public BackOfficePage VerifyCreatedOrderInRMAOffline() throws InterruptedException {
		GUIFunctions.verifyUIElementAndShowText(driver.findElement(RMACreatedOrder_xpath),
				"Created order for RMA offline  ");
		NewOrderFor_RMAOffline = driver.findElement(RMACreatedOrder_xpath).getText().replaceAll("#", "");
		boolean NewOrderContains = NewOrderFor_RMAOffline.contains("-1");
		System.out.println("successfully verified-NewOrderContains -1 in the order" + NewOrderContains);
		return new BackOfficePage(driver);
	}*/

	/**
	 * MethodName=ClickOnRetryCreateOrderExchangeBtn() Description:This function
	 * used to Click on retry create order exchange Btn
	 */

	public BackOfficePage ClickOnRetryCreateOrderExchangeBtn() throws InterruptedException {
		GUIFunctions.clickElement(driver, RetryCreateOrderExchangeBtn_xpath,
				"Click on retry create order exchange Btn");
		Thread.sleep(2000);
		return new BackOfficePage(driver);
	}

	/*
	 * MethodName=EditExistShippingAddressWithCorrectZipCodeForRMA()
	 * Description:This function used to Edit Exist Shipping Address With Correct
	 * ZipCode For RMA
	 */

	public BackOfficePage EditExistShippingAddressWithCorrectZipCodeForRMA(String Zipcode) throws Exception {
		By ShippingAddressEdit = By.xpath("//span[text()='Shipping Address']/..//a[text()='Edit']");
		GUIFunctions.scrollByJavaScriptExecutor(driver.findElement(ShippingAddressEdit), driver,
				"Edit button under Address Informations Grid");
		Thread.sleep(2000);
		GUIFunctions.JavaScriptClick(driver, driver.findElement(ShippingAddressEdit), "Click on Edit button");
		Thread.sleep(10000);
		GUIFunctions.scrollByJavaScriptExecutor(driver.findElement(PostCodeField_xpath), driver, "PostCode Field");
		Thread.sleep(2000);
		GUIFunctions.typeTxtboxValue(driver, PostCodeField_xpath, Zipcode);
		Thread.sleep(2000);
		GUIFunctions.JavaScriptClick(driver, driver.findElement(SaveRMAAddressBtn_xpath),
				"Click on Save RMA Address button");
		Thread.sleep(10000);
		log.info("Edited Exist Shipping Address with Correct Zipcode");
		Reporter.log("<p>Edited Exist Shipping Address with Correct Zipcode");
		return new BackOfficePage(driver);
	}

	/*
	 * MethodName=EditExistBillingAddressWithCorrectZipCodeForRMA() Description:This
	 * function used to Edit Exist Billing Address With Correct ZipCode For RMA
	 */

	public BackOfficePage EditExistBillingAddressWithCorrectZipCodeForRMA(String Zipcode) throws Exception {
		By BillingAddressEdit = By.xpath("//span[text()='Billing Address']/..//a[text()='Edit']");
		GUIFunctions.scrollByJavaScriptExecutor(driver.findElement(BillingAddressEdit), driver,
				"Edit button under Address Informations Grid");
		Thread.sleep(2000);
		GUIFunctions.JavaScriptClick(driver, driver.findElement(BillingAddressEdit), "Click on Edit button");
		Thread.sleep(10000);
		GUIFunctions.scrollByJavaScriptExecutor(driver.findElement(PostCodeField_xpath), driver, "PostCode Field");
		Thread.sleep(2000);
		GUIFunctions.typeTxtboxValue(driver, PostCodeField_xpath, Zipcode);
		Thread.sleep(2000);
		GUIFunctions.JavaScriptClick(driver, driver.findElement(SaveRMAAddressBtn_xpath),
				"Click on Save RMA Address button");
		Thread.sleep(10000);
		log.info("Edited Exist Billing Address with Correct Zipcode");
		Reporter.log("<p>Edited Exist Billing Address with Correct Zipcode");
		return new BackOfficePage(driver);
	}

	/**
	 * MethodName=click on Customers Icon Description:This function used to Click On
	 * Customers Icon
	 */

	public BackOfficePage CustomersIconClick() throws InterruptedException {
		GUIFunctions.clickElement(driver, CustomersIcon_xpath, "Click on Customers Icon");
		Thread.sleep(2000);
		return new BackOfficePage(driver);
	}

	/**
	 * MethodName=AllCustomerstxtFromCustomersIconClick() Description:This function
	 * used to click on All Customers text from Customers Icon
	 */

	public BackOfficePage AllCustomerstxtFromCustomersIconClick() throws InterruptedException {
		GUIFunctions.clickElement(driver, AllCustomerstxtFromCustomers_xpath,
				"Click on All Customers text from Customers Icon");
		return new BackOfficePage(driver);
	}

	/**
	 * MethodName=VerifyCustomersHeadertxt() Description:This function used to
	 * verifies the Customers Header text and check whether user is in Customers
	 * details page
	 */

	public BackOfficePage VerifyCustomersHeadertxt() throws InterruptedException {
		CustomFun.waitObjectToLoad(driver, CustomersHeadertxt_xpath, Duration.ofSeconds(50));
		BaseTest.expected = driver.findElement(CustomersHeadertxt_xpath).getText();
		Assert.assertEquals(TextProp.get().getProperty("CustomersHeadertxt"), BaseTest.expected);
		Thread.sleep(10000);
		log.info("Verified Customers header text and Successfully navigated to Customers details page");
		Reporter.log("<p>Verified Customers header text and Successfully navigated to Customers details page");
		return new BackOfficePage(driver);
	}

	/**
	 * MethodName=DeletedExistCustomerAccountFromCustomerGridResultInBO()
	 * Description:This function used to delete exist customer account from customer
	 * grid result
	 * @throws Exception 
	 */

	public BackOfficePage DeletedExistCustomerAccountFromCustomerGridResultInBO() throws Exception {
		Thread.sleep(2000);
		GUIFunctions.clickElement(driver, CustomerChk_xpath, "Click on Customer Checkbox");
		GUIFunctions.clickElement(driver, ActionsDdp_xpath, "Click on Actions dropdown");
		Thread.sleep(1000);
		GUIFunctions.clickElement(driver, Deletetxt_xpath, "Click on Delete option From Actions Dropdown");
		CustomFun.waitObjectToLoad(driver, By.xpath("(//h1)[2]"), Duration.ofSeconds(50));
		GUIFunctions.JavaScriptClick(driver,driver.findElement(By.xpath("//span[text()='OK']")), "Click on OK button");
		CustomFun.waitForPageLoaded(driver);
		return new BackOfficePage(driver);
	}

	/**
	 * MethodName=SearchForProductSeleableStockInBO() Description:This function used
	 * to Search For Product Seleable Stock
	 * 
	 * @throws Exception
	 */

	public BackOfficePage SearchForProductSeleableStockInBO(String SKUIDBarcode) throws Exception {
		Thread.sleep(10000);
		if (!driver.findElement(By.xpath("//button[text()='Clear all']")).isDisplayed()) {
			GUIFunctions.JavaScriptClick(driver, driver.findElement(Filtersbtn_xpath), "click on Filters button");
			Thread.sleep(2000);
			Actions action = new Actions(driver);
			WebElement SKUField = driver
					.findElement(By.xpath("//span[text()='Product Barcode (sku)']/../following-sibling::div"));
			CustomFun.waitObjectToLoad(driver, By.xpath("//span[text()='Product Barcode (sku)']/../following-sibling::div"), Duration.ofSeconds(20000));
			SKUField.click();
			Thread.sleep(2000);
			//action.sendKeys(SKUField, SKUIDBarcode).perform();
			JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;  
			// set the text
			jsExecutor.executeScript("arguments[0].value='"+SKUIDBarcode+"'", SKUField); 
			action.sendKeys(SKUField, SKUIDBarcode).perform();
			//GUIFunctions.typeTxtboxValue(driver, By.xpath("//span[text()='Product Barcode (sku)']/../following-sibling::div"), SKUIDBarcode);
			Thread.sleep(2000);
			GUIFunctions.JavaScriptClick(driver, driver.findElement(ApplyFiltersbtn_xpath),
					"click on Apply Filters button");
			Thread.sleep(2000);
		} else {
			CustomFun.waitObjectToLoad(driver, By.xpath("//button[text()='Clear all']"), Duration.ofSeconds(20000));
			driver.findElement(By.xpath("//button[text()='Clear all']")).click();
			Thread.sleep(2000);
			GUIFunctions.JavaScriptClick(driver, driver.findElement(Filtersbtn_xpath), "click on Filters button");
			Thread.sleep(2000);
			Actions action = new Actions(driver);
			WebElement SKUField = driver
					.findElement(By.xpath("//span[text()='Product Barcode (sku)']/../following-sibling::div"));
			CustomFun.waitObjectToLoad(driver, By.xpath("//span[text()='Product Barcode (sku)']/../following-sibling::div"), Duration.ofSeconds(20000));
			SKUField.click();
			Thread.sleep(2000);
			action.sendKeys(SKUField, SKUIDBarcode).perform();
			//GUIFunctions.typeTxtboxValue(driver, By.xpath("//span[text()='Product Barcode (sku)']/../following-sibling::div"), SKUIDBarcode);
			Thread.sleep(2000);
			GUIFunctions.JavaScriptClick(driver, driver.findElement(ApplyFiltersbtn_xpath),
					"click on Apply Filters button");
			Thread.sleep(2000);
		}
		return new BackOfficePage(driver);
	}
	
	public BackOfficePage SearchForProductSeleableStockInBO_BS(String SKUIDBarcode) throws Exception {
		Thread.sleep(10000);
		if (!driver.findElement(By.xpath("//button[text()='Clear all']")).isDisplayed()) {
			GUIFunctions.JavaScriptClick(driver, driver.findElement(Filtersbtn_xpath), "click on Filters button");
			Thread.sleep(2000);
			WebElement SKUField = (new WebDriverWait(driver,20)).until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class='admin__data-grid-header'])[2]//div//input[@name='sku']")));
			Actions action = new Actions(driver);
			action.moveToElement(SKUField).click().perform();
			Thread.sleep(3000);
			SKUField.sendKeys(SKUIDBarcode);
			//action.sendKeys(SKUField, SKUIDBarcode).perform();
			Thread.sleep(2000);
			GUIFunctions.JavaScriptClick(driver, driver.findElement(ApplyFiltersbtn_xpath),
					"click on Apply Filters button");
			Thread.sleep(2000);
		} else {
			CustomFun.waitObjectToLoad(driver, By.xpath("//button[text()='Clear all']"), Duration.ofSeconds(20000));
			driver.findElement(By.xpath("//button[text()='Clear all']")).click();
			Thread.sleep(2000);
			GUIFunctions.JavaScriptClick(driver, driver.findElement(Filtersbtn_xpath), "click on Filters button");
			Thread.sleep(2000);
			WebElement SKUField = (new WebDriverWait(driver,20)).until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class='admin__data-grid-header'])[2]//div//input[@name='sku']")));
			Actions action = new Actions(driver);
			action.moveToElement(SKUField).click().perform();
			Thread.sleep(3000);
			SKUField.sendKeys(SKUIDBarcode);
			Thread.sleep(2000);
			GUIFunctions.JavaScriptClick(driver, driver.findElement(ApplyFiltersbtn_xpath),
					"click on Apply Filters button");
			Thread.sleep(2000);
		}
		return new BackOfficePage(driver);
	}
	
	/**
	 * MethodName=FilterProductByEnteringSKUIDAndSelectStoreViewInBO() Description:This function used
	 * to Search For Product Seleable Stock
	 * 
	 * @throws Exception
	 */

	public BackOfficePage FilterProductByEnteringSKUIDAndSelectStoreViewInBO(String SKUIDBarcode, String Locale) throws Exception {
		Thread.sleep(10000);
		if (!driver.findElement(By.xpath("//button[text()='Clear all']")).isDisplayed()) {
			GUIFunctions.JavaScriptClick(driver, driver.findElement(Filtersbtn_xpath), "click on Filters button");
			Thread.sleep(2000);
			Actions action = new Actions(driver);
			WebElement SKUField = driver
					.findElement(By.xpath("//span[text()='Product Barcode (sku)']/../following-sibling::div"));
			CustomFun.waitObjectToLoad(driver, By.xpath("//span[text()='Product Barcode (sku)']/../following-sibling::div"), Duration.ofSeconds(20000));
			SKUField.click();
			Thread.sleep(2000);
			JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;  
			// set the text
			jsExecutor.executeScript("arguments[0].value='"+SKUIDBarcode+"'", SKUField); 
			action.sendKeys(SKUField, SKUIDBarcode).perform();
			Thread.sleep(2000);
			WebDriverWait wait = new WebDriverWait(driver,20);
			WebElement storeviewdpd = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Store View']/../following-sibling::div//select")));
			storeviewdpd .click();
			Thread.sleep(1000);
			if(Locale.contains("UK_EN"))
			{
			   ActualStoreView=driver.findElement(By.xpath("//select//option[contains(text(),'English')]")).getText().trim();
			   WebElement localtxt = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//select//option[contains(text(),'English')]")));
			   localtxt.click();
			   Thread.sleep(1000);
			   log.info("click on UK English locale");
			   Reporter.log("<p>click on UK English locale");
			}
			else
			if(Locale.contains("FR_FR"))
			{
				ActualStoreView=driver.findElement(By.xpath("//select//option[contains(@data-title,'France/France Group/Fran')]")).getText().trim();
				WebElement localtxt = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//select//option[contains(@data-title,'France/France Group/Fran')]")));
				localtxt.click();
				Thread.sleep(1000);
				log.info("click on FR French locale");
				Reporter.log("<p>click on FR French locale");	
			}
			else
			{
				ActualStoreView=driver.findElement(By.xpath("//select//option[contains(@data-title,'Switzerland/Switzerland Group/French')]")).getText().trim();
				WebElement localtxt = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//select//option[contains(@data-title,'Switzerland/Switzerland Group/French')]")));
				localtxt.click();
				Thread.sleep(1000);
				log.info("click on Switzerland French locale");
				Reporter.log("<p>click on Switzerland French locale");	
			}
			WebElement Typetxt = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//select[@class='admin__control-select'])[2]")));
			Typetxt.click();
			Thread.sleep(1000);
			/*
			 * WebElement Configprod =
			 * wait.until(ExpectedConditions.elementToBeClickable(By.
			 * xpath("//select//option[contains(@data-title,'Configurable Product')]")));
			 * Configprod.click(); Thread.sleep(1000);
			 */
			GUIFunctions.JavaScriptClick(driver, driver.findElement(ApplyFiltersbtn_xpath),
					"click on Apply Filters button");
			Thread.sleep(2000);
		} 
		else 
		{
			CustomFun.waitObjectToLoad(driver, By.xpath("//button[text()='Clear all']"), Duration.ofSeconds(20000));
			driver.findElement(By.xpath("//button[text()='Clear all']")).click();
			Thread.sleep(2000);
			GUIFunctions.JavaScriptClick(driver, driver.findElement(Filtersbtn_xpath), "click on Filters button");
			Thread.sleep(2000);
			Actions action = new Actions(driver);
			WebElement SKUField = driver
					.findElement(By.xpath("//span[text()='Product Barcode (sku)']/../following-sibling::div"));
			CustomFun.waitObjectToLoad(driver, By.xpath("//span[text()='Product Barcode (sku)']/../following-sibling::div"), Duration.ofSeconds(20000));
			SKUField.click();
			Thread.sleep(2000);
			action.sendKeys(SKUField, SKUIDBarcode).perform();
			Thread.sleep(2000);
			WebDriverWait wait = new WebDriverWait(driver, 10);
			 WebElement storeviewdpd = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Store View']/../following-sibling::div//select")));
			 storeviewdpd .click();
			Thread.sleep(1000);
			if(Locale.contains("UK_EN"))
			{
			ActualStoreView=driver.findElement(By.xpath("//select//option[contains(text(),'English')]")).getText().trim();
			WebElement localtxt = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//select//option[contains(text(),'English')]")));
			localtxt.click();
			Thread.sleep(1000);
			log.info("click on UK English locale");
			Reporter.log("<p>click on UK English locale");
			}
			else
			{
				ActualStoreView=driver.findElement(By.xpath("//select//option[contains(@data-title,'France/France Group/Fran')]")).getText().trim();
				WebElement localtxt = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//select//option[contains(@data-title,'France/France Group/Fran')]")));
				localtxt.click();
				Thread.sleep(1000);
				log.info("click on FR French locale");
				Reporter.log("<p>click on FR French locale");	
			}
			GUIFunctions.JavaScriptClick(driver, driver.findElement(ApplyFiltersbtn_xpath),
					"click on Apply Filters button");
			Thread.sleep(2000);
		}
		return new BackOfficePage(driver);
	}

	/**
	 * Verify Initial Saleable Stock in BO
	 * 
	 * @return :BackOfficePage
	 */
	public BackOfficePage VerifyInitialSaleableStockInBO(String BarcodeSKUID) throws Exception {
		By initialSaleableStock = By.xpath("//div[text()='"+BarcodeSKUID+"']/../following-sibling::td[4]");
		GUIFunctions.verifyUIElementAndShowText(driver.findElement(initialSaleableStock), "Initial Saleable Stock");
		String[] Stocks = driver.findElement(initialSaleableStock).getText().split("\\.");
		log.info("Verified Initial Saleable Stock Qnty in BO :" +Stocks[0]);
        Reporter.log("<p>Verified Initial Saleable Stock Qnty in BO :" +Stocks[0]);
		return new BackOfficePage(driver);
	}

	/**
	 * Verify Saleable Stock in BO after placing the order
	 * 
	 * @return :BackOfficePage
	 */
	public BackOfficePage VerifySaleableStockQntyDecBy1InBOAferPlacingTheOrder(String BarcodeSKUID) throws Exception {
		By SaleableStock = By.xpath("//div[text()='"+BarcodeSKUID+"']/../following-sibling::td[4]");
		GUIFunctions.verifyUIElementAndShowText(driver.findElement(SaleableStock),
				"Saleable Stock decreament by 1 After Placing The Order");
		String[] Stocks=driver.findElement(SaleableStock).getText().split("\\.");
		log.info("Verified Saleable Stock Qnty Dec By 1 In BO Afer Placing The Order :" +Stocks[0]);
		Reporter.log("<p>Verified Saleable Stock Qnty Dec By 1 In BO Afer Placing The Order :" +Stocks[0]);
		return new BackOfficePage(driver);
	}

	/**
	 * Verify Saleable Stock in BO after Refund the order
	 * 
	 * @return :WMS page
	 */
	public BackOfficePage VerifySaleableStockQntyIncBy1InBOAferRefundTheOrder(String SKUID) throws Exception {
		By SaleableStock = By.xpath("//div[text()='"+SKUID+"']/../following-sibling::td[4]");
		GUIFunctions.verifyUIElementAndShowText(driver.findElement(SaleableStock),
				"Saleable Stock decreament by 1 After Refund The Order");
		String[] Stocks=driver.findElement(SaleableStock).getText().split("\\.");
		log.info("Verified Saleable Stock Qnty Inc By 1 In BO after Refund the order :"+Stocks[0]);
		Reporter.log("<p>Verified Saleable Stock Qnty Inc By 1 In BO after Refund the order :"+Stocks[0]);
		return new BackOfficePage(driver);
	}
	
	
	/** MethodName= VerifyOrderReturnDetailsInNewMemoPage()
	* Description:This function used to Verify Orde rReturn Details in New Memo Page
	*/

	public BackOfficePage VerifyOrderReturnDetailsInNewMemoPage() throws InterruptedException
	{

	GUIFunctions.verifyUIElementAndShowText(driver.findElement(RMACreatedOrder_xpath),"Created order for RMA offline ");
	By ele=By.xpath("//th[text()='Order Date']/..//td");
	String OrderDate_ReturnPage= driver.findElement(ele).getText();
	System.out.println("OrderDate_ReturnPage"+ OrderDate_ReturnPage);
	By ele2=By.xpath("//th[text()='Order Status']/..//td");
	String OrderStatus_ReturnPage= driver.findElement(ele2).getText();
	System.out.println("OrderStatus_ReturnPage"+ OrderStatus_ReturnPage);
	By ele3=By.xpath("//th[text()='Purchased From']/..//td");
	String OrderPurchasedFrom_ReturnPage= driver.findElement(ele3).getText();
	System.out.println("OrderPurchasedFrom_ReturnPage"+ OrderPurchasedFrom_ReturnPage);
	log.info("Verified Product Details In New Memo page ");
	Reporter.log("<p>Verified Product Details In New Memo page");
	return new BackOfficePage(driver);
	}
	
	/**
	* MethodName :SelectOptionFromReturnReasonDropdown()
	* Description :Select options from Return Reason dropdown
	* @return :BackOfficePage
	* @throws Exception
	*/

	public BackOfficePage SelectTooSmallOptionFromReturnReasonDropdown() throws Exception
	{
	int ReturnReasonDpdCount = driver.findElements(ReturnReasondpn_xpath).size();
	for(int i=0;i<ReturnReasonDpdCount;i++)
	{
	WebElement ReturnReasonOptions= driver.findElements(ReturnReasondpn_xpath).get(i);
	// select Changed Mind Options from Return Reason dropdown
	GUIFunctions.selectDropDownValue(ReturnReasonOptions, "Too Small", "text", "Return Reason dropdown");
	Thread.sleep(2000);
	}
	return new BackOfficePage(driver);
	}
	
	public BackOfficePage SelectExchangeOptionFromResolutionDropdown() throws Exception
	{
	int ResolutiondpnCount = driver.findElements(Resolutiondpn_xpath).size();
	for(int i=0;i<ResolutiondpnCount;i++)
	{
	WebElement ResolutionOptions= driver.findElements(Resolutiondpn_xpath).get(i);;

	// select Refund Options from Resolution dropdown
	GUIFunctions.selectDropDownValue(ResolutionOptions, "Size Exchange", "text", "Resolution dropdown");
	Thread.sleep(2000);
	}
	return new BackOfficePage(driver);
	}
	
	public BackOfficePage VerifyGrandTotalAndOrderToralInNewMemopage() throws Exception
	{
	By ele4=By.xpath("//td[@class='label']/..//span[@class='price']");
	String GrandTotal= driver.findElement(ele4).getText().replaceAll(",","\\.").replaceAll("[^0-9.]", "");
	System.out.println("MyAccountPage.PriceVal_OrderPage"+ MyAccountPage.PriceVal_OrderPage);
	System.out.println("GrandTotal in New Memo Page"+ GrandTotal);
	GUIFunctions.verifyUIElementAndShowText(driver.findElement(ele4),"Grand Total value");
	log.info("Verified Grand total In New Memo Page ");
	Reporter.log("<p>Verified Grand total In New Memo Page ");
	return new BackOfficePage(driver);
	}
	
	/**
	* MethodName= Verify_AddressDetails_BOInNRMA()
	* Description:This function Verify shipping and billing adress details in BO after processing RMA
	* @return :BackOfficePage
	*/

	public BackOfficePage Verify_AddressDetails_BOInRMA() throws Exception
	{
	By Adress1=By.xpath("//select[@id='order-billing_address_customer_address_id']");
	GUIFunctions.scrollByJavaScriptExecutor(driver.findElement(Adress1), driver , "scroll till billing addr");
	WebElement ele= driver.findElement(By.xpath("//select[@id='order-billing_address_customer_address_id']"));
	Select dropDown = new Select(ele);
	String BillingAdress_FromBO=dropDown.getFirstSelectedOption().getText();
	System.out.println("BillingAdress_FromBO" + BillingAdress_FromBO);

	By Adress2=By.xpath("//select[@id='order-shipping_address_customer_address_id']");
	GUIFunctions.scrollByJavaScriptExecutor(driver.findElement(Adress2), driver , "scroll till shipping addr");
	WebElement ele1= driver.findElement(By.xpath("//select[@id='order-shipping_address_customer_address_id']"));
	Select dropDown2 = new Select(ele1);
	String ShippingAdress_FromBO=dropDown2.getFirstSelectedOption().getText();
	System.out.println("ShippingAdress_FromBO" + ShippingAdress_FromBO);

	System.out.println("Successfully verified shipping and billing adress details in BO after processing RMA ");
	log.info("Successfully verified shipping and billing adress details in BO after processing RMA \n");
	return new BackOfficePage(driver);
	}
	
	/** MethodName= VerifyCreatedOrderInRMAOffline()
	* Description:This function used to Verify newly created order in Refund offline RMA
	*/

	public BackOfficePage VerifyCreatedOrderInRMAOffline() throws InterruptedException
	{
	GUIFunctions.verifyUIElementAndShowText(driver.findElement(RMACreatedOrder_xpath),"Created order for RMA offline");
	NewOrderFor_RMAOffline = driver.findElement(RMACreatedOrder_xpath).getText().substring(1);
	System.out.println("NewOrderFor_RMAOffline " + NewOrderFor_RMAOffline);
	boolean NewOrderContains = NewOrderFor_RMAOffline.contains("-1");
	System.out.println("successfully verified-NewOrderContains -1 in the order" + NewOrderContains);
	return new BackOfficePage(driver);
	}
	
	
	/**
	* MethodName :SelectOptionFromReturnReasonDropdown()
	* Description :Select options from Return Reason dropdown 
	* @return :BackOfficePage
	* @throws Exception
	*/

	public BackOfficePage SelectOptionFromReturnReasonDropdown() throws Exception
	{
	int ReturnReasonDpdCount = driver.findElements(ReturnReasondpn_xpath).size();
	for(int i=0;i<ReturnReasonDpdCount;i++)
	{
	WebElement ReturnReasonOptions= driver.findElements(ReturnReasondpn_xpath).get(i);
	// select Changed Mind Options from Return Reason dropdown
	GUIFunctions.selectDropDownValue(ReturnReasonOptions, "Changed Mind", "text", "Return Reason dropdown");
	Thread.sleep(2000);
	}
	return new BackOfficePage(driver);
	}
	
	
	/**
	* MethodName :SelectApprovedOptionFromStatusDropdown()
	* Description :Select Approved options from Status dropdown
	* @return :BackOfficePage
	* @throws Exception
	*/

	public BackOfficePage SelectApprovedOptionFromStatusDropdownForSingleProduct() throws Exception
	{
	WebElement OrderStatusOptions= driver.findElement(Statusdpn_xpath);
	// select Approved Options from Status dropdown
	GUIFunctions.selectDropDownValue(OrderStatusOptions, "Approved", "text", "Status dropdown");
	return new BackOfficePage(driver);
	}

	/**
	* MethodName :SelectRejectedOptionFromStatusDropdown()
	* Description :Select Approved options from Status dropdown
	* @return :BackOfficePage
	* @throws Exception
	*/

	public BackOfficePage SelectRejectedOptionFromStatusDropdownForSecondProduct() throws Exception
	{
	WebElement OrderStatusOptions= driver.findElement(StatusdpnReject_xpath);
	// select Approved Options from Status dropdown
	GUIFunctions.selectDropDownValue(OrderStatusOptions, "Rejected", "text", "Status dropdown");
	return new BackOfficePage(driver);
	}
	
	/*
	* MethodName=EditExistShippingAddressWithWrongZipCodeForRMA()
	* Description:This function used to Edit Exist Shipping Address With Wrong ZipCode For RMA
	*/
	public BackOfficePage EditExistShippingAddressWithWrongZipCodeForRMA() throws Exception
	{
	By ShippingAddressEdit=By.xpath("//span[text()='Order Shipping Address']/..//a[text()='Edit']");
	GUIFunctions.scrollByJavaScriptExecutor(driver.findElement(ShippingAddressEdit), driver,"Edit button under Address Informations Grid");
	Thread.sleep(2000);
	GUIFunctions.JavaScriptClick(driver, driver.findElement(ShippingAddressEdit), "Click on Edit button");
	Thread.sleep(10000);
	GUIFunctions.scrollByJavaScriptExecutor(driver.findElement(PostCodeField_xpath), driver,"PostCode Field");
	Thread.sleep(2000);
	GUIFunctions.typeTxtboxValue(driver,PostCodeField_xpath, "ABCDEF123");
	Thread.sleep(2000);
	GUIFunctions.JavaScriptClick(driver, driver.findElement(SaveRMAAddressBtn_xpath), "Click on Save RMA Address button");
	Thread.sleep(10000);
	log.info("Edited Exist Shipping Address with Correct Zipcode");
	Reporter.log("<p>Edited Exist Shipping Address with INCorrect Zipcode");
	return new BackOfficePage(driver);
	}
	
	/**
     * MethodName=click on System Icon Description:This function used to Click On
     * System Icon
     * @throws Exception
     */



	public BackOfficePage ClickOnSystemIcon(String envtype) throws Exception {

		if(envtype.contains("IntegrationEnv") | envtype.contentEquals("HomoEnv1") | envtype.contains("StagingEnv1"))
		{
		GUIFunctions.scrollByJavaScriptExecutor(driver.findElement(By.xpath("//span[text()='Stores']")), driver,
		"System Icon");
		Thread.sleep(2000);
		GUIFunctions.clickElement(driver, SystemIcon_xpath2, "Click on System Icon");
		}
		else
		{
		GUIFunctions.scrollByJavaScriptExecutor(driver.findElement(By.xpath("//span[text()='Stores']")), driver,
		"System Icon");
		Thread.sleep(2000);
		GUIFunctions.clickElement(driver, SystemIcon_xpath, "Click on System Icon");
		}
		return new BackOfficePage(driver);

		}
   
   public BackOfficePage ClickOnSystemIcon_INT6() throws Exception {
	        Thread.sleep(2000);
	        GUIFunctions.scrollByJavaScriptExecutor(driver.findElement(By.xpath("//li[@id='menu-magento-backend-system']//a")), driver,
	         "scroll till System Icon");
	          Thread.sleep(2000);
	          GUIFunctions.clickElement(driver, SystemIcon_xpath, "Click on System Icon");
	       return new BackOfficePage(driver);
   }
    
    /**
     * MethodName=IndexManagementFromSystemIconClick() Description:This function used to
     * click on Index Management text from System Icon
     */



   public BackOfficePage IndexManagementFromSystemIconClick() throws InterruptedException {
        GUIFunctions.clickElement(driver, IndexManagementtxt_xpath, "click on Index Management text from System Icon");
        Thread.sleep(2000);
        return new BackOfficePage(driver);
    }
   
   /**
    * MethodName=LogFromSystemIconClickAndVerifyExportsJobLogs() Description:This function used to
    * click on Index Management text from System Icon
    */



  public BackOfficePage LogFromSystemIconClickAndVerifyExportsJobLogs() throws InterruptedException {
       GUIFunctions.clickElement(driver, By.xpath("//span[text()='Log']"), "click on Log text from System Icon");
       Thread.sleep(2000);
       for(int i=1;i<=3;i++)
       {
    	   Thread.sleep(20000);
    	   driver.navigate().refresh();
       }
       return new BackOfficePage(driver);
   }
    
    /**
     * MethodName=CacheManagementtxtFromSystemIconClick() Description:This function used to
     * click on Cache Management text from System Icon
     */



   public BackOfficePage CacheManagementtxtFromSystemIconClick() throws InterruptedException {
        GUIFunctions.clickElement(driver, CacheManagementtxt_xpath, "click on Cache Management text from System Icon");
        Thread.sleep(2000);
        return new BackOfficePage(driver);
    }
    
    /**
     * MethodName=ClickOnFlushMagentoCacheButton() Description:This function used to
     * Click on Flush Magento Cache button
     */



   public BackOfficePage ClickOnFlushMagentoCacheButton() throws InterruptedException {
        GUIFunctions.clickElement(driver, FlushMagentoCachetxt_xpath, "Click on Flush Magento Cache button");
        Thread.sleep(2000);
        return new BackOfficePage(driver);
    }
   
   /**
    * MethodName=ClickOnFlushMagentoCacheButton() Description:This function used to
    * Click on Flush Categories Cache button
    */



  public BackOfficePage ClickOnFlushCategoriesCacheButton() throws InterruptedException {
       GUIFunctions.clickElement(driver, FlushCategoriesCache_xpath, "Click on Flush Categories Cache button");
       Thread.sleep(2000);
       return new BackOfficePage(driver);
   }
    
    
    /**
     * MethodName=IndexLaunching() Description:This function used to Index Launching in Index Management Page
     * @throws Exception
     */



   public BackOfficePage IndexLaunching() throws Exception
    {
        for(int i=1;i<=5;i++)
        {
         driver.findElement(By.xpath("//input[@name='indexer_ids']")).click();
         Thread.sleep(1000);
        }
         
        WebElement ActionsDropdown=driver.findElement(By.xpath("//select[@id='gridIndexer_massaction-select']"));
        
        // select Launch Selected Options from Actions dropdown
        GUIFunctions.selectDropDownValue(ActionsDropdown, "Launch Selected" , "text", "Launch Selected dropdown");
        Thread.sleep(1000);
        
        driver.findElement(By.xpath("//button[@title='Submit']")).click();
        Thread.sleep(2000);
        return new BackOfficePage(driver);
    }
   
   /**
    * MethodName=IndexLaunchingForExports() Description:This function used to Index Launching For Exports in Index Management Page
    * @throws Exception
    */



   public BackOfficePage IndexLaunchingForExports() throws Exception
   {
        driver.findElement(By.xpath("//td[contains(text(),'Category Products')]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//td[contains(text(),'Product Categories')]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//td[contains(text(),'Catalog Rule Product')]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//td[contains(text(),'Stock')]")).click();
        Thread.sleep(1000);
        log.info("Successfully Category Products, Product Categories, Catalog Rule Product and Stock Checkboxs checked");
 	    Reporter.log("<p>Successfully Category Products, Product Categories, Catalog Rule Product and Stock Checkboxs checked");
        
        WebElement ActionsDropdown=driver.findElement(By.xpath("//select[@id='gridIndexer_massaction-select']")); 
        // select Launch Selected Options from Actions dropdown
        GUIFunctions.selectDropDownValue(ActionsDropdown, "Launch Selected" , "text", "Launch Selected dropdown");
        Thread.sleep(1000);
        log.info("Successfully Click on Actions Dropdown and then Selected Launch Selected option");
	    Reporter.log("<p>Successfully Click on Actions Dropdown and then Selected Launch Selected option");
       
        driver.findElement(By.xpath("//button[@title='Submit']")).click();
        Thread.sleep(2000);
        log.info("Successfully Click on Submit CTA");
	    Reporter.log("<p>Successfully Click on Submit CTA");
        return new BackOfficePage(driver);
   }
   
   /**
	 * MethodName=bo_CategoryMenu
	 * Description:This function used to Click on Category sub menu option
	 * @return :BackOfficePage
	 */
	public BackOfficePage bo_CategoryMenu() throws InterruptedException 
	{
		GUIFunctions.clickElement(driver, BO_categoriesSubMenu, "Click on Category sub menu");
		CustomFun.waitForPageLoaded(driver);
		Thread.sleep(2000);
		return new BackOfficePage(driver);
	}
	
	/**
	 * MethodName=bo_AddRootCategory
	 * Description:This function used to Create root catgeory
	 * @return :BackOfficePage
	 */
	public BackOfficePage bo_AddRootCategory() throws InterruptedException 
	{
		GUIFunctions.clickElement(driver, BO_rootCategoryBtn, "Click on Add root category button");
		CustomFun.waitForPageLoaded(driver);
		return new BackOfficePage(driver);
	}
	/**
	 * MethodName=bo_verifyCategoryPage
	 * Description:This function used to Create root catgeory
	 */
   public BackOfficePage bo_verifyCategoryPageFields() throws InterruptedException

	{
		// verify page title
		Assert.assertTrue(CustomFun.isElementPresent(By.xpath(ObjRepoProp.get().getProperty("BO_categoryPageTitle")), driver),
				"Page is not  displayed");
		log.info("Successfully verified new category page title");
		Reporter.log("<p>Successfully verified new category page title");
		
		// verify Currently active section
		Assert.assertTrue(CustomFun.isElementPresent(By.xpath(ObjRepoProp.get().getProperty("BO_curentlyActiveSection")), driver),
						"Currently Active field/section is not  displayed");
		log.info("Successfully verified Currently Active Field element");
		Reporter.log("<p>Successfully verified Currently Active Field element");
		
		// verify Enable Category Element
		Assert.assertTrue(CustomFun.isElementPresent(By.xpath(ObjRepoProp.get().getProperty("BO_catEnableField")), driver),
						"Enable category element is not available");
		log.info("Successfully Enable Category Element is displayed in the page");
		Reporter.log("<p>Successfully Enable Category Element is displayed in the page");
				
		// verify Include in menu Element
		Assert.assertTrue(CustomFun.isElementPresent(By.xpath(ObjRepoProp.get().getProperty("BO_includeInMenuField")), driver),
				"Include in Menu element is not available");
       log.info("Successfully Include in menu Element is displayed in the page");
       Reporter.log("<p>Successfully Include in Menu Element is displayed in the page");
       
      // verify ToMerchElement
    	Assert.assertTrue(CustomFun.isElementPresent(By.xpath(ObjRepoProp.get().getProperty("BO_toMerchField")), driver),
    				"To Merch element is not available");
       log.info("Successfully To MerchElement is displayed in the page");
       Reporter.log("<p>Successfully To MerchElement is displayed in the page");
       
       // verify Content section
      	Assert.assertTrue(CustomFun.isElementPresent(By.xpath(ObjRepoProp.get().getProperty("BO_ContentSection")), driver),
      				"Content Section is not available");
       log.info("Successfully Content Section is displayed in the page");
       Reporter.log("<p>Successfully Content Section is displayed in the page");
			
       // verify DisplaySettings section
      	Assert.assertTrue(CustomFun.isElementPresent(By.xpath(ObjRepoProp.get().getProperty("BO_displaySettingsSection")), driver),
      				"DisplaySettings is not available");
       log.info("Successfully DisplaySettings Section is displayed in the page");
       Reporter.log("<p>Successfully DisplaySettings Section is displayed in the page");
			
       // verify SEO section
      	Assert.assertTrue(CustomFun.isElementPresent(By.xpath(ObjRepoProp.get().getProperty("BO_SEOSection")), driver),
      				"SEO Section is not available");
       log.info("Successfully SEO Section is displayed in the page");
       Reporter.log("<p>Successfully SEO Section is displayed in the page");
			
       // verify Products in category section
      	Assert.assertTrue(CustomFun.isElementPresent(By.xpath(ObjRepoProp.get().getProperty("BO_productsInCategorysection")), driver),
      				"Products in Category Section is not available");
       log.info("Successfully Products in Category Section is displayed in the page");
       Reporter.log("<p>Successfully Products in Category Section is displayed in the page");
			
       // verify Design section
		GUIFunctions.scrollByJavaScriptExecutor(driver.findElement(BO_designSection), driver,
				"scroll to section");
		Thread.sleep(2000);
      	Assert.assertTrue(CustomFun.isElementPresent(By.xpath(ObjRepoProp.get().getProperty("BO_designSection")), driver),
      				"Design Section is not available");
       log.info("Successfully Design Section is displayed in the page");
       Reporter.log("<p>Successfully Design Section is displayed in the page");


		return new BackOfficePage(driver);
		
		
	}
	
	/**
	 * MethodName=bo_RootCategoryName
	 * Description:This function used to enter the root category name
	 * @return :BackOfficePage
	 */
	public BackOfficePage bo_RootCategoryName(String Username) throws InterruptedException 
	{
		GUIFunctions.typeTxtboxValue(driver, BO_RootCategoryName, Username);
		Thread.sleep(2000);
		log.info("Entered Username Successfully: " + Username);
		Reporter.log("<p>Entered Username Successfully: " + Username);
		return new BackOfficePage(driver);	
		
	}
	/**
	 * MethodName=bo_SubCategoryName
	 * Description:This function used to enter the sub category name
	 * @return :BackOfficePage
	 * @throws Exception 
	 */
	public BackOfficePage bo_SubCategoryName(String Username) throws Exception 
	{
		GUIFunctions.pageScrollToTopOfPage(driver);
		CustomFun.waitForPageLoaded(driver);
		GUIFunctions.JavaScriptClick(driver, driver.findElement(BO_RootCategoryName), "Click on Category name");
		GUIFunctions.typeTxtboxValue(driver, BO_RootCategoryName, Username);
		Thread.sleep(2000);
		log.info("Entered Username Successfully: " + Username);
		Reporter.log("<p>Entered Username Successfully: " + Username);
		return new BackOfficePage(driver);	
		
	}
	
	/**
	 * MethodName=bo_SaveBtn
	 * Description:This function used to save the category
	 * @return :BackOfficePage
	 */
	public BackOfficePage bo_SaveBtn() throws InterruptedException 
	{
		GUIFunctions.clickElement(driver, BO_saveBtn, "Click on Save button");
		CustomFun.waitForPageLoaded(driver);
		return new BackOfficePage(driver);
	}
	
	/**
	 * MethodName=bo_DragandDropCategory
	 * Description:This function used to drag and drop the category
	 * @return :BackOfficePage
	 */
	public BackOfficePage bo_DragandDropCategory() throws InterruptedException 
	{
		CustomFun.waitForPageLoaded(driver);
		GUIFunctions.dragAndDropCategory(driver, BO_categorySource, BO_categoryTarget, BO_warningMessage, "source Element", "target Element", "warningmessage");
		CustomFun.waitForPageLoaded(driver);
		return new BackOfficePage(driver);
	}
	/**
	 * MethodName=bo_warningOKBtn()
	 * Description:This function used to close the warning popup
	 * @return :BackOfficePage
	 */
	public BackOfficePage bo_warningOKBtn() throws InterruptedException 
	{
		GUIFunctions.clickElement(driver, BO_okBtn, "Click on ok button");
		CustomFun.waitForPageLoaded(driver);
		return new BackOfficePage(driver);
	}

	/**
	 * MethodName=bo_systemMenu
	 * Description:This function used to select the System menu
	 * @return :BackOfficePage
	 */
	public BackOfficePage bo_systemMenu() throws InterruptedException 
	{
		GUIFunctions.scrollByJavaScriptExecutor(driver.findElement(BO_systemMenu), driver,
				"scroll to System Icon");
		Thread.sleep(2000);
		GUIFunctions.clickElement(driver, BO_systemMenu, "Click on System option");
		Thread.sleep(2000);
		return new BackOfficePage(driver);
	}
	/**
	 * MethodName=bo_cacheManagementMenu
	 * Description:This function used to select the cache management sub menu
	 * @return :BackOfficePage
	 */
	public BackOfficePage bo_cacheManagementMenu() throws InterruptedException 
	{
		GUIFunctions.clickElement(driver, BO_cacheMenu, "Click on cache management sub menu option");
		Thread.sleep(2000);
		return new BackOfficePage(driver);
	}
	/**
	 * MethodName=bo_flushMagentoCache
	 * Description:This function used to click on flush category cache button
	 * @return :BackOfficePage
	 */
	public BackOfficePage bo_flushCategoryCache() throws InterruptedException 
	{
		GUIFunctions.clickElement(driver, BO_flushCategoryCacheBtn, "Click on flush category cache button");
		CustomFun.waitForPageLoaded(driver);
		return new BackOfficePage(driver);
	}
	/**
	 * MethodName=bo_flushMagentoCache
	 * Description:This function used to click on flush magento cache button
	 * @return :BackOfficePage
	 */
	public BackOfficePage bo_flushMagentoCache() throws InterruptedException 
	{
		GUIFunctions.clickElement(driver, BO_flushMagentoCacheBtn, "Click on flush magento cache button");
		CustomFun.waitForPageLoaded(driver);
		return new BackOfficePage(driver);
	}
	
	/**
	 * MethodName=bo_CreatedRootCategory_Click()
	 * Description:This function used to scroll and click the create root category
	 * @return :BackOfficePage
	 * @throws Exception 
	 */
	public BackOfficePage bo_CreatedRootCategory_Click(String RootCat) throws Exception 
	{
		By createdRootcategory = By.xpath("//span[contains(text(),'" + RootCat + "')]");
		GUIFunctions.scrollByJavaScriptExecutor(driver.findElement(createdRootcategory), driver,
				"scroll down to created root category");
		Thread.sleep(2000);
		GUIFunctions.JavaScriptClick(driver, driver.findElement(createdRootcategory), "Click on Created Root category");
		Thread.sleep(2000);
		return new BackOfficePage(driver);
	}
	
	
	/**
	 * MethodName=bo_scrollToTop
	 * Description:This function used to scrollthe page to the top
	 * @return :BackOfficePage
	 * @throws Exception 
	 */
	public BackOfficePage bo_scrollToTop() throws Exception 
	{
		
		GUIFunctions.scrollByJavaScriptExecutor(driver.findElement(BO_pageTitle), driver,
				"scroll to top of the page");
		Thread.sleep(2000);
		return new BackOfficePage(driver);
	}
	/**
	 * MethodName=bo_addSubCategoryBtn
	 * Description:This function used to click on flush magento cache button
	 * @return :BackOfficePage
	 */
	public BackOfficePage bo_addSubCategoryBtn_click() throws InterruptedException 
	{
		GUIFunctions.clickElement(driver, BO_subCategoryBtn, "Click on add sub category button");
		CustomFun.waitForPageLoaded(driver);
		return new BackOfficePage(driver);
	}
	/**
	 * MethodName=bo_scrollToBottom
	 * Description:This function used to scroll the page to the bottom
	 * @return :BackOfficePage
	 * @throws Exception 
	 */
	public BackOfficePage bo_scrollToBottom() throws Exception 
	{
		
		GUIFunctions.scrollByJavaScriptExecutor(driver.findElement(BO_pageTitle), driver,
				"scroll to top of the page");
		Thread.sleep(2000);
		return new BackOfficePage(driver);
	}
	/**
	 * MethodName=bo_displaySettings_Click
	 * Description:This function used to expand the Display Settings
	 * @return :BackOfficePage
	 */
	public BackOfficePage bo_displaySettings_Click() throws Exception 
	{
		GUIFunctions.scrollByJavaScriptExecutor(driver.findElement(BO_displaySettingsSection), driver,
				"scroll to th section");
		Thread.sleep(2000);
		GUIFunctions.JavaScriptClick(driver, driver.findElement(BO_displaySettingsSection), "Click on Display Settings Button");
		Thread.sleep(2000);
		return new BackOfficePage(driver);
	}
	/**
	 * MethodName=bo_leftMenuExpand_Click
	 * Description:This function used to seelct the left menu
	 * @throws Exception 
	 */
	public BackOfficePage bo_leftMenuExpand_Click() throws Exception 
	{
		
		GUIFunctions.clickElement(driver, BO_leftMenuExpand, "Click on Left menu expand");
		Thread.sleep(2000);
		return new BackOfficePage(driver);
	}
	/**
	 * MethodName=bo_clickonStores
	 * Description:This function used to seelct the left menu
	 * @throws Exception 
	 */
	public BackOfficePage bo_clickonStores() throws Exception 
	{
		
		GUIFunctions.clickElement(driver, BO_allStoresScope, "Click on all stores option");
		Thread.sleep(2000);
		return new BackOfficePage(driver);
	}
	/**
	 * MethodName=bo_clickonFranceStore
	 * Description:This function used to select the France Store
	 * @throws Exception 
	 */
	public BackOfficePage bo_clickonFranceStore() throws Exception 
	{
		
		GUIFunctions.clickElement(driver, BO_scopeStore, "Click on france store option");
		Thread.sleep(2000);
		return new BackOfficePage(driver);
	}
	
	/**
	 * MethodName=bo_clickonOKBtn
	 * Description:This function used to select the France Store
	 * @throws Exception 
	 */
	public BackOfficePage bo_clickonOKBtn() throws Exception 
	{
		
		GUIFunctions.clickElement(driver, BO_ScopeOKBtn, "Click on ok Button");
		CustomFun.waitForPageLoaded(driver);
		return new BackOfficePage(driver);
	}
	/**
	 * MethodName=bo_unselectCatCheckbox
	 * Description:This function used to unselect the use default value checkbox below the Category name field
	 * @throws Exception 
	 */
	public BackOfficePage bo_unselectCatCheckbox() throws Exception 
	{
		GUIFunctions.clickElement(driver, BO_catUseDefaultVlaue, "Click on checkbox");
		Thread.sleep(2000);
		return new BackOfficePage(driver);
	}
	/**
	 * MethodName=bo_UpdateSubCatName
	 * Description:This function used to update the sub category name
	 * @return :BackOfficePage
	 * @throws Exception 
	 */
	public BackOfficePage bo_UpdateSubCatName(String Username) throws Exception 
	{
		GUIFunctions.clearAndEnterTxtboxValue(driver, BO_RootCategoryName, Username);
		Thread.sleep(2000);
		log.info("Entered Username Successfully: " + Username);
		Reporter.log("<p>Entered Username Successfully: " + Username);
		return new BackOfficePage(driver);	
		
	}
	/**
	 * MethodName=bo_ClickOnSEO
	 * Description:This function used to unselect the use default value checkbox below the Category name field
	 * @throws Exception 
	 */
	public BackOfficePage bo_ClickOnSEO() throws Exception 
	{
		GUIFunctions.clickElement(driver, BO_SEOSection, "Click on SEO section");
		Thread.sleep(2000);
		return new BackOfficePage(driver);
	}
	
	/**
	 * MethodName=bo_unselectURLKey
	 * Description:This function used to unselect the use default value checkbox below the URLKey field
	 * @throws Exception 
	 */
	public BackOfficePage bo_unselectURLKey() throws Exception 
	{
		Actions actions = new Actions(driver);
		actions.moveToElement(driver.findElement(BO_URLKey_Usedefault)).build().perform();
		//GUIFunctions.scrollByJavaScriptExecutor(driver.findElement(BO_URLKey_Usedefault), driver,
				//"scroll to section");
		Thread.sleep(2000);
		GUIFunctions.clickElement(driver, BO_URLKey_Usedefault, "Click on checkbox");
		Thread.sleep(2000);
		return new BackOfficePage(driver);
	}
	/**
	 * MethodName=bo_urlName
	 * Description:This function used to enter the urlname
	 * @return :BackOfficePage
	 * @throws Exception 
	 */
	public BackOfficePage bo_urlName(String UserName) throws Exception 
	{
		GUIFunctions.clearAndEnterTxtboxValue(driver, BO_URLName, UserName);
		Thread.sleep(2000);
		log.info("Entered Username Successfully: " + UserName);
		Reporter.log("<p>Entered Username Successfully: " + UserName);
		return new BackOfficePage(driver);	
		
	}
	/**
	 * MethodName=bo_verifySegmentableField
	 * Description:This function used to Create root catgeory
	 */
  public BackOfficePage bo_verifySegmentableField() throws InterruptedException

	{
		// verify page title
		GUIFunctions.scrollByJavaScriptExecutor(driver.findElement(BO_segmentableField), driver,
				"scroll to section");
		Thread.sleep(2000);
		Assert.assertTrue(CustomFun.isElementPresent(By.xpath(ObjRepoProp.get().getProperty("BO_segmentableField")), driver),
				"Segmentable Field  is not  displayed");
		log.info("Successfully verified Segmentable Field is displayed");
		Reporter.log("<p>Successfully verified Segmentable Field is displayed");
		return new BackOfficePage(driver);	
	}
	
  /**
	 * MethodName=bo_clickExpandAll
	 * Description:This function used to click on expand all
	 * @return :BackOfficePage
	 */
	public BackOfficePage bo_clickExpandAll() throws InterruptedException 
	{
		GUIFunctions.clickElement(driver, BO_ExpandAll, "Click on Expand All");
		Thread.sleep(2000);
		return new BackOfficePage(driver);
	}
	/**
	 * MethodName=bo_clickOnCreatedSubCategory
	 * Description:This function used to Create root catgeory
	 * @throws Exception 
	 */
   public BackOfficePage bo_clickOnCreatedSubCategory(String SubCat) throws Exception
	{
	    Thread.sleep(1000);
		// verify page title
		By createdSubcategoryUpdate = By.xpath("//span[contains(text(),'" + SubCat + "')]");
		GUIFunctions.JavaScriptClick(driver, driver.findElement(createdSubcategoryUpdate), "Click on Created Sub category");
		return new BackOfficePage(driver);	
	}
   /**
	 * MethodName=bo_clickCollapseAll
	 * Description:This function used to click on collapse all
	 * @return :BackOfficePage
	 */
	 public BackOfficePage bo_clickCollapseAll() throws InterruptedException 
	 {
		GUIFunctions.clickElement(driver, BO_CollapseAll, "Click on Collapse All");
		Thread.sleep(2000);
		return new BackOfficePage(driver);
	 }
	 /**
		 * MethodName=bo_expandProductsInCategory
		 * Description:This function used to click on expand products in category
		 * @return :BackOfficePage
		 */
		public BackOfficePage bo_expandProductsInCategory() throws InterruptedException 
		{
			GUIFunctions.scrollByJavaScriptExecutor(driver.findElement(BO_productsInCategorysection), driver,
					"scroll to section");
			GUIFunctions.clickElement(driver, BO_productsInCategorysection, "Click on expand in category");
			Thread.sleep(2000);
			return new BackOfficePage(driver);
		}
		/**
		 * MethodName=bo_clickOnAddProducts
		 * Description:This function used to click on add products
		 * @return :BackOfficePage
		 * @throws Exception 
		 */
		public BackOfficePage bo_clickOnAddProducts() throws Exception 
		{
			GUIFunctions.scrollByJavaScriptExecutor(driver.findElement(BO_addProduct), driver,
					"scroll to section");
			Thread.sleep(2000);
			GUIFunctions.JavaScriptClick(driver, driver.findElement(BO_addProduct), "Click on All product");
			Thread.sleep(2000);
			return new BackOfficePage(driver);
		}
		/**
		 * MethodName=bo_clickOnMerchFilter
		 * Description:This function used to click on ApplyFilter
		 * @return :BackOfficePage
		 */
		public BackOfficePage bo_clickOnMerchFilter() throws InterruptedException 
		{
			GUIFunctions.clickElement(driver, BO_merchFiltersBtn, "Click on Filter");
			Thread.sleep(2000);
			return new BackOfficePage(driver);
		}
		/**
		 * MethodName=bo_enterFromValue
		 * Description:This function used to enter the from value
		 * @return :BackOfficePage
		 * @throws Exception 
		 */
		public BackOfficePage bo_enterFromValue(String value) throws Exception 
		{
			GUIFunctions.clearAndEnterTxtboxValue(driver, BO_qntyFrom, value);
			Thread.sleep(2000);
			log.info("Entered From Value : " + value);
			Reporter.log("<p>Entered To Value: " + value);
			return new BackOfficePage(driver);	
			
		}
		/**
		 * MethodName=bo_enterToValue
		 * Description:This function used to enter the from value
		 * @return :BackOfficePage
		 * @throws Exception 
		 */
		public BackOfficePage bo_enterToValue(String value) throws Exception 
		{
			GUIFunctions.clearAndEnterTxtboxValue(driver, BO_qntyTo, value);
			Thread.sleep(2000);
			log.info("Entered To value : " + value);
			Reporter.log("<p>Entered To Value: " + value);
			return new BackOfficePage(driver);	
			
		}
		
		/**
		 * MethodName=bo_clickOnApplyFilter
		 * Description:This function used to click on ApplyFilter
		 * @return :BackOfficePage
		 */
		public BackOfficePage bo_clickOnApplyFilter() throws InterruptedException 
		{
			GUIFunctions.clickElement(driver, BO_applyFiltersBtn, "Click on Filter");
			Thread.sleep(2000);
			return new BackOfficePage(driver);
		}
		
		/**
		 * MethodName=bo_selectProducts
		 * Description:This function used to select products
		 * @return :BackOfficePage
		 */
		public BackOfficePage bo_selectProducts() throws InterruptedException 
		{
			GUIFunctions.clickElement(driver, BO_product1, "Click on Product1");
			GUIFunctions.clickElement(driver, BO_product2, "Click on Product2");
			Thread.sleep(2000);
			return new BackOfficePage(driver);
		}
		
		/**
		 * MethodName=bo_clickOnSaveAndCloseBtn
		 * Description:This function used to click on save and close btn
		 * @return :BackOfficePage
		 */
		public BackOfficePage bo_clickOnSaveAndCloseBtn() throws InterruptedException 
		{
			GUIFunctions.scrollByJavaScriptExecutor(driver.findElement(BO_saveAndCloseBtn), driver, "Click on save and close btn");
			GUIFunctions.clickElement(driver, BO_saveAndCloseBtn, "Click on save and close btn");
			Thread.sleep(2000);
			return new BackOfficePage(driver);
		}
		
		/**
		 * MethodName=bo_clickOnTileViewInMerchPool
		 * Description:This function used to click on tile view in merch pool area
		 * @return :BackOfficePage
		 */
		public BackOfficePage bo_clickOnMerchTileView() throws InterruptedException 
		{
			GUIFunctions.clickElement(driver, BO_merchTileViewBtn, "Click on Merch Tile View");
			Thread.sleep(2000);
			return new BackOfficePage(driver);
		}
	
		/**
		 * MethodName=bo_clickOnTileViewInProductPool
		 * Description:This function used to click on tile view in product pool area
		 * @return :BackOfficePage
		 */
		public BackOfficePage bo_clickOnProductTileView() throws InterruptedException 
		{
			GUIFunctions.clickElement(driver, BO_productTileViewBtn, "Click on product Tile View");
			Thread.sleep(2000);
			return new BackOfficePage(driver);
		}
		/**
		 * MethodName=bo_selectProductsInMerchPool
		 * Description:This function used to select Products In MerchPool
		 * @return :BackOfficePage
		 */
		public BackOfficePage bo_selectProductsInMerchPool() throws InterruptedException 
		{
			GUIFunctions.clickElement(driver, BO_merchSelectCheckbox, "select Products In MerchPool");
			Thread.sleep(2000);
			return new BackOfficePage(driver);
		}
		
		/**
		 * MethodName=bo_DragandDropProduct
		 * Description:This function used to drag and drop the products from Merch area to Product area
		 * @return :BackOfficePage
		 */
		public BackOfficePage bo_DragandDropProduct() throws InterruptedException 
		{
			CustomFun.waitForPageLoaded(driver);
			GUIFunctions.dragAndDropProduct(driver, BO_merchPool, BO_productPool, "source Element", "target Element");
			Thread.sleep(2000);
			return new BackOfficePage(driver);
		}
		/**
		 * MethodName=bo_clickOnDeleteCTA
		 * Description:This function used to click on delete button to delete the category
		 * @return :BackOfficePage
		 */
		public BackOfficePage bo_clickOnDeleteCat() throws InterruptedException 
		{
			GUIFunctions.clickElement(driver, BO_CatDeleteBtn, "Click on delete button");
			Thread.sleep(2000);
			return new BackOfficePage(driver);
		}
		/**
		 * MethodName=bo_clickOnAccountIcon
		 * Description:This function used to click on Account icon
		 * @return :BackOfficePage
		 * @throws Exception 
		 */
		public BackOfficePage bo_clickOnAccountIcon() throws Exception 
		{
			GUIFunctions.JavaScriptClick(driver, driver.findElement(BO_accountIcon), "Click on Account Icon");
			Thread.sleep(2000);
			return new BackOfficePage(driver);
		}
		/**
		 * MethodName=bo_clickOnSignOut button
		 * Description:This function used to click on signout button
		 * @return :BackOfficePage
		 */
		public BackOfficePage bo_clickOnSignOutOption() throws InterruptedException 
		{
			GUIFunctions.clickElement(driver, BO_signoutBtn, "Click on signout button");
			Thread.sleep(2000);
			return new BackOfficePage(driver);
		}
		/**
		 * MethodName=bo_verifyCategoryPage
		 * Description:This function used to Create root catgeory
		 * @throws Exception 
		 */
	    public BackOfficePage bo_verifyCreatedCatOnFE() throws Exception

		{
			// verify page title
	    	// verify page title
		    String createdCategoryFE = "AutomationRootCat4";
			By createdRootCategoryFE = By.xpath("//span[contains(text(),'" + createdCategoryFE + "')]");
			Assert.assertTrue(CustomFun.isElementPresent(createdRootCategoryFE, driver),
					"RootCategory is not  displayed");
			log.info("Successfully dispalyed the created rootcategory" +"createdRootCategoryFE+" );
			Reporter.log("<p>Successfully dispalyed the created rootcategory" +"createdRootCategoryFE+");
			
		    String createdSubCatFE = "AutomationSubCat4";
			By createdSubCategoryFE = By.xpath("//span[contains(text(),'" + createdSubCatFE + "')]");
           GUIFunctions.mouseOverElement(driver, driver.findElement(createdRootCategoryFE), "Created Root Category");
			Thread.sleep(2000);
		    Assert.assertTrue(CustomFun.isElementPresent(createdSubCategoryFE, driver),
					"SubCategory is not  displayed");
			log.info("Successfully dispalyed the created subcategory" +"createdSubCategoryFE+" );
			Reporter.log("<p>Successfully dispalyed the created subcategory" +"createdSubCategoryFE+");
			
			return new BackOfficePage(driver);	
		}
	    
	    /**
		 * MethodName=ScrollDownAndClickOnTheMarketingTab
		 * Description:Scroll down and click on the marketing Tab
		 * @return :BackOfficePage
		 */
		public BackOfficePage ScrollDownAndClickOnTheMarketingTab() throws Exception 
		{
			GUIFunctions.scrollByJavaScriptExecutor(driver.findElement(BO_MarketingTab), driver,
					"scroll to marketing Tab");
			Thread.sleep(2000);
			GUIFunctions.JavaScriptClick(driver, driver.findElement(BO_MarketingTab), "Click on Marketing Tab");
			Thread.sleep(2000);
			return new BackOfficePage(driver);
		}
		
		  /**
				 * MethodName=ScrollDownAndClickOnImagesAndVideosTab
				 * Description:Scroll down and click on Images And Videos Tab
				 * @return :BackOfficePage
				 */
		
				public BackOfficePage ScrollDownAndClickOnImagesAndVideosTab() throws Exception 
				{
					GUIFunctions.scrollByJavaScriptExecutor(driver.findElement(BO_ImagesAndVideosTab), driver,
							"scroll to Images And Videos Tab");
					Thread.sleep(2000);
					GUIFunctions.JavaScriptClick(driver, driver.findElement(BO_ImagesAndVideosTab), "Click on Images And Videos Tab");
					Thread.sleep(2000);
					return new BackOfficePage(driver);
				}
				
				  /**
				 * MethodName=ScrollDownAndClickOnDescriptionTab
				 * Description:Scroll down and click on Description Tab
				 * @return :BackOfficePage
				 */
		
				public BackOfficePage ScrollDownAndClickOnDescriptionTab() throws Exception 
				{
					GUIFunctions.scrollByJavaScriptExecutor(driver.findElement(BO_DescriptionTab), driver,
							"scroll to Description Tab");
					Thread.sleep(2000);
					GUIFunctions.JavaScriptClick(driver, driver.findElement(BO_DescriptionTab), "Click on Description Tab");
					Thread.sleep(2000);
					return new BackOfficePage(driver);
				}
				
				/**
				 * MethodName=bo_unselectEnableCatCheckbox
				 * Description:This function used to unselect the use default value checkbox below the enable categoryfield
				 * @throws Exception 
				 */
				public BackOfficePage bo_unselectEnableCatCheckbox() throws Exception 
				{
					GUIFunctions.clickElement(driver, BO_enableCatDefaultValue, "Click on checkbox");
					Thread.sleep(2000);
					return new BackOfficePage(driver);
				}
				/**
				 * MethodName=bo_enableCategory_Click
				 * Description:This function used to click on the enable categoryfield
				 * @throws Exception 
				 */
				public BackOfficePage bo_enableCategory_Click() throws Exception 
				{
					GUIFunctions.clickElement(driver, BO_catEnableField, "Click on enable category");
					Thread.sleep(2000);
					return new BackOfficePage(driver);
				}
				/**
				 * MethodName=bo_unverifyRootCategoryPage
				 * Description:This function used to verify the created root category is not dispalyed
				 * @throws Exception 
				 */
			    public BackOfficePage bo_unverifyCreatedRootCatOnFE() throws Exception
				{
			    	for (int i = 0; i <= 0; i++)
					{
						Thread.sleep(2000);
						CustomFun.refreshPage(driver);
						Thread.sleep(10000);
					}
					GUIFunctions.pageScrollToTopOfPage(driver);
					// verify page title
				    String createdCategoryFE = "AutomationRootCat4";
					By createdRootCategoryFE = By.xpath("//span[contains(text(),'" + createdCategoryFE + "')]");
					Assert.assertFalse(CustomFun.isElementPresent(createdRootCategoryFE, driver),
							"RootCategory is  displayed");
					log.info("Successfully not dispalyed the created rootcategory" +"createdRootCategoryFE+" );
					Reporter.log("<p>Successfully  not dispalyed the created rootcategory" +"createdRootCategoryFE+");
					return new BackOfficePage(driver);
				}
			    /**
				 * MethodName=bo_verifyRootCategoryPage
				 * Description:This function used to verify the created root category is  dispalyed
				 * @throws Exception 
				 */
			    public BackOfficePage bo_verifyCreatedRootCatOnFE() throws Exception
				{
			    	for (int i = 0; i <= 1; i++)
					{
						Thread.sleep(2000);
						CustomFun.refreshPage(driver);
						Thread.sleep(10000);
					}
					GUIFunctions.pageScrollToTopOfPage(driver);
					// verify page title
				    String createdCategoryFE = "AutomationRootCat4";
					By createdRootCategoryFE = By.xpath("//span[contains(text(),'" + createdCategoryFE + "')]");
					Assert.assertTrue(CustomFun.isElementPresent(createdRootCategoryFE, driver),
							"RootCategory is  displayed");
					log.info("Successfully  dispalyed the created rootcategory" +"createdRootCategoryFE+" );
					Reporter.log("<p>Successfully  dispalyed the created rootcategory" +"createdRootCategoryFE+");
					return new BackOfficePage(driver);
				}
			    /**
				 * MethodName=bo_unverifysubCategoryPage
				 * Description:This function used to verify the created sub category is not dispalyed
				 * @throws Exception 
				 */
			    public BackOfficePage bo_unverifysubCategoryPage() throws Exception
				{
			    	
					// verify page title
				    String createdCategoryFE = "AutomationSubCat4";
					By createdRootCategoryFE = By.xpath("//span[contains(text(),'" + createdCategoryFE + "')]");
					Assert.assertFalse(CustomFun.isElementPresent(createdRootCategoryFE, driver),
							"SubCategory is  displayed");
					log.info("Successfully not dispalyed the created sub category" +"createdRootCategoryFE+" );
					Reporter.log("<p>Successfully  not dispalyed the created sub category" +"createdRootCategoryFE+");
					return new BackOfficePage(driver);
				}
			    /**
				 * MethodName=bo_verifySubCategoryPage
				 * Description:This function used to Create Sub catgeory
				 * @throws Exception 
				 */
			    public BackOfficePage bo_verifyCreatedSubCatOnFE() throws Exception
				{
			    	for (int i = 0; i <= 2; i++)
					{
						Thread.sleep(2000);
						CustomFun.refreshPage(driver);
						Thread.sleep(2000);
					}
					GUIFunctions.pageScrollToTopOfPage(driver);
				    String createdCategoryFE = "AutomationRootCat1";
					By createdRootCategoryFE = By.xpath("//*[contains(text(),'" + createdCategoryFE + "')]");
					Assert.assertTrue(CustomFun.isElementPresent(createdRootCategoryFE, driver),
							"RootCategory is not  displayed");
					log.info("Successfully dispalyed the created rootcategory" +"createdRootCategoryFE+" );
					Reporter.log("<p>Successfully dispalyed the created rootcategory" +"createdRootCategoryFE+");
					
				    String createdSubCatFE = "AutomationSubCat1";
					By createdSubCategoryFE = By.xpath("//*[contains(text(),'" + createdSubCatFE + "')]");
		            GUIFunctions.mouseOverElement(driver, driver.findElement(createdRootCategoryFE), "Created Root Category");
					Thread.sleep(2000);
				    Assert.assertTrue(CustomFun.isElementPresent(createdSubCategoryFE, driver),
							"SubCategory is not  displayed");
					log.info("Successfully dispalyed the created subcategory" +"createdSubCategoryFE+" );
					Reporter.log("<p>Successfully dispalyed the created subcategory" +"createdSubCategoryFE+");
					
					return new BackOfficePage(driver);
				}
	     
			    /**
				 * MethodName=bo_verifySubCategoryPage
				 * Description:This function used to Create Sub catgeory
				 * @throws Exception 
				 */
			    public BackOfficePage bo_verifySubCatOnFE() throws Exception

				{
			    	for (int i = 0; i <= 0; i++)
					{
						Thread.sleep(2000);
						CustomFun.refreshPage(driver);
						Thread.sleep(10000);
					}
					GUIFunctions.pageScrollToTopOfPage(driver);
				    String createdCategoryFE = "AutomationRootCat4";
					By createdRootCategoryFE = By.xpath("//span[contains(text(),'" + createdCategoryFE + "')]");
				    String createdSubCatFE = "AutomationSubCat4";
					By createdSubCategoryFE = By.xpath("//span[contains(text(),'" + createdSubCatFE + "')]");
		            GUIFunctions.mouseOverElement(driver, driver.findElement(createdRootCategoryFE), "Created Root Category");
					Thread.sleep(2000);
				    Assert.assertTrue(CustomFun.isElementPresent(createdSubCategoryFE, driver),
							"SubCategory is not  displayed");
					log.info("Successfully dispalyed the created subcategory" +"createdSubCategoryFE+" );
					Reporter.log("<p>Successfully dispalyed the created subcategory" +"createdSubCategoryFE+");
					
					return new BackOfficePage(driver);
				}
			    
			    /**
			       * MethodName=bo_clickOnCreatedSubCategory
			       * Description:This function used to Create root catgeory
			       * @throws Exception 
			       */
			    
			       public BackOfficePage bo_clickOnSubCategory() throws Exception
			       {
				        // verify page title
			          String createdSubCategory = "AutomationSubCat4";
				      By createdSubcategory = By.xpath("//span[contains(text(),'" + createdSubCategory + "')]");
				      GUIFunctions.clickElement(driver, createdSubcategory, "Click on Created Sub category");
				      Thread.sleep(2000);
				      return new BackOfficePage(driver);	
			      }
			       
			       /**
			        * MethodName=bo_verifySubCatUpdatedURL
			        * Description:This function used to Create root catgeory
			        * @throws Exception 
			        */
			        public BackOfficePage bo_verifySubCatUpdatedURL() throws Exception
			        {
			 	        // verify page title
			     	  
			     	  String url=driver.getCurrentUrl();
			     	  if(url.contains("AutomationSubCat4"))
			     	  {
			     		 System.out.println("Url contains the updated category name"+ url);
			     	  } 
			     	  else
			     	  {
			     		  System.out.println("Url does not contains the updated category name"+ url);
			     	  }
			 	      return new BackOfficePage(driver);	
			       }
			        
			        /**
			         * MethodName=bo_createdSubCat_Click()
			         * Description:This function used to Click on created sub category
			         * @throws Exception 
			         */
			         public BackOfficePage bo_createdSubCat_Click(String RootCat, String SubCat) throws Exception
			         {
			  	        // verify page title
			 			By createdRootCategoryFE = By.xpath("//span[contains(text(),'" + RootCat + "')]");
			 			By createdSubCategoryFE = By.xpath("//span[contains(text(),'" + SubCat + "')]");
			            GUIFunctions.mouseOverElement(driver, driver.findElement(createdRootCategoryFE), "Created Root Category");
			            GUIFunctions.JavaScriptClick(driver, driver.findElement(createdSubCategoryFE), "Subcategory update name");
			 			CustomFun.waitForPageLoaded(driver);
			  	        return new BackOfficePage(driver);	
			        }
			         
			         /**
			          * MethodName=bo_verifyProductsOnFE()
			          * Description:This function used to verify products in created sub category
			          * @throws Exception 
			          */
			          public BackOfficePage bo_verifyProductsOnFE() throws Exception
			          {
			   	        // verify page title BO_displayedProducts
			  			CustomFun.waitForPageLoaded(driver);
			  			Assert.assertTrue(CustomFun.isElementPresent(BO_displayedProducts, driver),
			 					"Products are  displayed");
			 			log.info("Products dislayed in created subcategory" );
			 			Reporter.log("<p>Products dislayed in created subcategory");
			   	      return new BackOfficePage(driver);	
			         }
			          
			          /**
			           * MethodName=bo_RootCategoryErrorMsg
			           * Description:This function used to enter the root category name
			           * @return :BackOfficePage
			           */
			          public BackOfficePage bo_RootCategoryErrorMsg() throws InterruptedException
			          {
			              By errorMessage = By.xpath(ObjRepoProp.get().getProperty("BO_errorMessage"));
			              Assert.assertTrue(CustomFun.isElementPresent(By.xpath(ObjRepoProp.get().getProperty("BO_errorMessage")), driver),
			                         "error message is not available");
			              Thread.sleep(2000);
			              
			              log.info("Error message displayed Successfully: " + errorMessage);
			              Reporter.log("<p>Error message displayed Successfully: " + errorMessage);
			              return new BackOfficePage(driver);    
			              
			          }
			          
			          /**
			  		 * MethodName=bo_searchAllProds_click
			  		 * Description:This function used to click on search all products tab
			  		 * @return :BackOfficePage
			  		 * @throws Exception 
			  		 */
			  		public BackOfficePage bo_searchAllProds_click() throws Exception 
			  		{
			  	        CustomFun.waitForPageLoaded(driver);
			  			GUIFunctions.JavaScriptClick(driver, driver.findElement(BO_searchAllProdsBtn), "Click on search all products tab");
			  			CustomFun.waitForPageLoaded(driver);
			  			return new BackOfficePage(driver);
			  		}
			  		
			  		
			  		/**
					 * MethodName=bo_addProdBySKUTab_click
					 * Description:This function used to click on add products by sku tab
					 * @return :BackOfficePage
					 * @throws Exception 
					 */
					public BackOfficePage bo_addProdBySKUTab_click() throws Exception 
					{
				        CustomFun.waitForPageLoaded(driver);
						GUIFunctions.JavaScriptClick(driver, driver.findElement(BO_addProdBySkuTab), "Click on All product by sku tab");
						CustomFun.waitForPageLoaded(driver);
						return new BackOfficePage(driver);
					}

					
					/**
					 * MethodName=bo_enterProductSkus
					 * Description:This function used to enter the product sku's in the add by sku text area
					 * @return :BackOfficePage
					 * @throws Exception 
					 */
					public BackOfficePage bo_enterProductSku1(String SKU1 , String SKU2) throws Exception 
					{
						GUIFunctions.typeTxtboxValue(driver, BO_addProdBySkuTextarea, SKU1);
						Actions action = new Actions(driver);
						action.sendKeys(Keys.ENTER, SKU2).build().perform();
						//GUIFunctions.typeTxtboxValue(driver, BO_addProdBySkuTextarea, SKU2);
						return new BackOfficePage(driver);
					}
					/**
					 * MethodName=bo_clickOnAssignBtn
					 * Description:This function used to click on Assign btn
					 * @return :BackOfficePage
					 */
					public BackOfficePage bo_clickOnAssignBtn() throws InterruptedException 
					{
						GUIFunctions.scrollByJavaScriptExecutor(driver.findElement(BO_addProdBySkuAssignbtn), driver, "Click on Assign btn");
						GUIFunctions.clickElement(driver, BO_addProdBySkuAssignbtn, "Click on Asignbtn");
						CustomFun.waitForPageLoaded(driver);
						return new BackOfficePage(driver);
					}
					
					/**
					 * MethodName=bo_selectProdInProdPool
					 * Description:This function used to select the product
					 * @return :BackOfficePage
					 */
					public BackOfficePage bo_selectProdInProdPool() throws InterruptedException 
					{
						GUIFunctions.clickElement(driver, BO_productPoolselect, "Select the  Product in Pool");
						CustomFun.waitForPageLoaded(driver);
						return new BackOfficePage(driver);
					}
							
					/**
					 * MethodName=bo_deleteProdInProdPool
					 * Description:This function used to delete the product
					 * @return :BackOfficePage
					 */
					public BackOfficePage bo_deleteProdInProdPool() throws InterruptedException 
					{
						GUIFunctions.clickElement(driver, BO_productRemovePool, "delete the  Product in Pool");
						CustomFun.waitForPageLoaded(driver);
						return new BackOfficePage(driver);
					}
					
					/**
					 * MethodName=bo_DragandDropProdsInPool
					 * Description:This function used to drag and drop the category
					 * @return :BackOfficePage
					 */
					public BackOfficePage bo_DragandDropProdsInPool() throws InterruptedException 
					{
						CustomFun.waitForPageLoaded(driver);
						GUIFunctions.dragAndDropProduct(driver, BO_productPoolSrc, BO_productPoolTarget, "source Element", "target Element");
						CustomFun.waitForPageLoaded(driver);
						return new BackOfficePage(driver);
					}
					
					
					public BackOfficePage TriggerCronJobListsInBOIfOrderStatusNotChanged() throws Exception 
					{
						  By ClearAllLink_xpath = By.xpath(ObjRepoProp.get().getProperty("ClearAllLink_xpath"));
						  if(!driver.findElement(ClearAllLink_xpath).isDisplayed()) 
					       {
						   CustomFun.waitObjectToLoad(driver, ClearAllLink_xpath, Duration.ofSeconds(50));
						   driver.findElement(By.xpath("//button[text()='Clear all']")).click();
						   Thread.sleep(2000);
					       }
						   GUIFunctions.scrollByJavaScriptExecutor(driver.findElement(BO_systemMenu), driver,
								"scroll to System Icon");
						   Thread.sleep(2000);
						   GUIFunctions.clickElement(driver, BO_systemMenu, "Click on System option");
						   Thread.sleep(2000);
						   if(BaseTest.environment.get().contains("IntegrationEnv"))
                           {
                              driver.findElement(By.xpath("(//li[contains(@class,'item-jobs-scheduler')])[1]")).click();
                               Thread.sleep(2000);
                           }
                          else
                          {
                              driver.findElement(By.xpath("(//li[contains(@class,'item-jobs-scheduler')])[2]")).click();
                              Thread.sleep(2000);
                          }
						   if(driver.findElement(ClearAllLink_xpath).isDisplayed()) 
					       {
						   CustomFun.waitObjectToLoad(driver, ClearAllLink_xpath, Duration.ofSeconds(50));
						   driver.findElement(By.xpath("//button[text()='Clear all']")).click();
						   Thread.sleep(2000);
					       }
						   GUIFunctions.JavaScriptClick(driver, driver.findElement(By.xpath("//button[text()='Filters']")), "click on Filters button");
						   Thread.sleep(2000);
						   Actions action = new Actions(driver);
						   WebElement SKUField = (new WebDriverWait(driver, 10)).
								   until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='admin__data-grid-filters-wrap _show']/..//span[text()='Job Code']/../following-sibling::div")));
							SKUField.click();
							Thread.sleep(2000);
							action.sendKeys(SKUField, "Adyen").perform();
							Thread.sleep(2000);
							GUIFunctions.JavaScriptClick(driver, driver.findElement(By.xpath("//span[text()='Apply Filters']")),
									"click on Apply Filters button");
							Thread.sleep(2000);
							int checkboxes=driver.findElements(By.xpath("//td[@class='data-grid-checkbox-cell']")).size();
							for(int i=0;i<checkboxes;i++)
					        {
								driver.findElements(By.xpath("//td[@class='data-grid-checkbox-cell']")).get(i).click();
					            Thread.sleep(1000);
					        }
					        
					        driver.findElement(By.xpath("//button[@id='add']")).click();
					        Thread.sleep(15000);
					        String successtxt= driver.findElement(By.xpath("//div[@class='message message-success success']//div")).getText().trim();
					        Assert.assertEquals(successtxt, "Job's generation started");
					        
					        GUIFunctions.scrollByJavaScriptExecutor(driver.findElement(By.xpath("//li[@id='menu-synolia-standard-all']")),
					        		driver,
									"scroll to System option");
							Thread.sleep(2000);
							GUIFunctions.clickElement(driver, By.xpath("//li[@id='menu-synolia-standard-all']"), 
									"Click on synolia option");
							driver.findElement(By.xpath("(//span[contains(text(),'Dashboard')])[5]")).click();
							Thread.sleep(15000);
							GUIFunctions.scrollByJavaScriptExecutor(driver.findElement(By.xpath("//div[contains(text(),'send_order_to_wms')]/../..//div[@class='action-select-wrap']")),
					        	driver,
									"scroll to System option");
							Thread.sleep(2000);
							GUIFunctions.clickElement(driver, By.xpath("//div[contains(text(),'send_order_to_wms')]/../..//div[@class='action-select-wrap']"), 
									"Click on synolia option");
							driver.findElement(By.xpath("(//li//a[@class='action-menu-item'][contains(text(),'View')])[6]")).click();
							Thread.sleep(10000);
							String SuccessTxt= driver.findElement(By.xpath("//div[@class='flow-status']//span[2]")).getText().trim();
						    for (int i = 0; i <= 2; i++)
							{
						    	Thread.sleep(2000);
								CustomFun.refreshPage(driver);
								Thread.sleep(10000);
						    	if(SuccessTxt.contains("success"))
								{
					               Assert.assertEquals(SuccessTxt, "success");
					               break;
								}
							}
						return new BackOfficePage(driver);
					}
					
					
					/**
					 * MethodName=VerifyOrderStatusInBO_OrdersPage() Description:This function
					 * verifies the order status in orders page in BO
					 * 
					 * @throws Exception
					 */

					public BackOfficePage VerifyOrderStatusInOrdersDetailsPageOnBO(String OrderIDtxt) throws Exception {
						Thread.sleep(10000);
						By ele = By.xpath("//span[contains(@id,'order_status')]");
						CustomFun.waitObjectToLoad(driver, ele, Duration.ofSeconds(50));
						OrderStatus = driver.findElement(ele).getText();
						GUIFunctions.VerifyOrderStatusInBO(OrderStatus, OrderIDtxt);
						Thread.sleep(1000);
						return new BackOfficePage(driver);
					}
					
					public BackOfficePage ClearTheFilterInBO(String OrderIDtxt) throws Exception
					{
					WebElement Filter=driver.findElement(By.xpath("//button[text()='Clear all']"));
					GUIFunctions.JavaScriptClick(driver, Filter, "Successfully cleared filter");
					Thread.sleep(2000);
					EnterOrderId(OrderIDtxt);
					Thread.sleep(2000);
					SearchIconClick();
					Thread.sleep(10000);
					return new BackOfficePage(driver);
					}
					
					public BackOfficePage ClearTheFilterInBOForReturnsOrder(String OrderIDtxt) throws Exception
					{
					WebElement Filter=driver.findElement(By.xpath("//button[text()='Clear all']"));
					GUIFunctions.JavaScriptClick(driver, Filter, "Successfully cleared filter");
					Thread.sleep(2000);
				    SearchForRMAOrder(OrderIDtxt);
					Thread.sleep(10000);
					return new BackOfficePage(driver);
					}
					
					public BackOfficePage SearchFor_ERPID(String envtype , String locale) throws Exception
					{
					GUIFunctions.JavaScriptClick(driver, driver.findElement(Filtersbtn_xpath), "click on Filters button");
					Thread.sleep(2000);
					WebElement ERPIDField = driver.findElement(By.xpath("//input[@name='erp_id']"));
					Thread.sleep(2000);
					ERPIDField.click();
					Thread.sleep(2000);
					if(envtype.equals("StagingEnv") && locale.equals("FR_FR"))
					{
					ERPIDField.sendKeys("B520003316130"); 
					}
					
					if(envtype.equals("StagingEnv") && locale.equals("CH_FR"))
					{
					ERPIDField.sendKeys("B520003316140");
					}

					else if(envtype.equals("StagingEnv") && locale.equals("UK_EN"))
					{
					ERPIDField.sendKeys("B520003316120");
					}

					if(envtype.equals("StagingEnv1")&& locale.equals("FR_FR"))
					{
					ERPIDField.sendKeys("B520003317891"); 
					}

					if(envtype.equals("StagingEnv1")&& locale.equals("CH_FR"))
					{
					ERPIDField.sendKeys("B520003317900"); 
					}

					else if (envtype.equals("StagingEnv1") && locale.equals("UK_EN"))
					{
					ERPIDField.sendKeys("B520003317881");
					}
					else if (envtype.equals("HomoEnv1") && locale.equals("UK_EN"))
					{
					ERPIDField.sendKeys("B520004241175");
					}
					else if (envtype.equals("HomoEnv1") && locale.equals("FR_FR"))
					{
					ERPIDField.sendKeys("B520004241187");
					}
					else if (envtype.equals("HomoEnv1") && locale.equals("CH_FR"))
					{
					ERPIDField.sendKeys("B520004241205");
					}

					Thread.sleep(2000);
					GUIFunctions.JavaScriptClick(driver, driver.findElement(ApplyFiltersbtn_xpath),
					"click on Apply Filters button");
					Thread.sleep(2000);
					return new BackOfficePage(driver);
					}
}
