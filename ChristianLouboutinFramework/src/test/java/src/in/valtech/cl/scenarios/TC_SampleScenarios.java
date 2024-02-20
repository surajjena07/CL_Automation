package src.in.valtech.cl.scenarios;

import org.apache.log4j.Logger;
import org.testng.Reporter;
import org.testng.annotations.Test;

import src.in.valtech.cl.front.pages.HomePage;
import src.in.valtech.config.BaseTest;
import src.in.valtech.custom.CustomFun;

public class TC_SampleScenarios extends BaseTest
{
	
	public Logger log = Logger.getLogger(this.getClass().getName());
	
	HomePage homepage;
	
	@Test(priority=01, description="Precondition: Open browser,Navigate to the CL FO URL and accept Cookies")
	public void step01_NavigatetoCLHomePage() throws Exception
	{
	logtest("Create a refund credit memo with only shipping fees");
	System.out.println("step 1 begin");
	homepage =HomePage.navigateToCLApplication_URL(driver.get(),baseUrl.get());
	System.out.println("SKUID :"+CustomFun.getBODSDetails().get().getBO_URL());
	log.info("Successfully navigated to application URL \n");
	Reporter.log("<p>Successfully navigated to application URL");
	System.out.println("step 1 end");
	}

}
