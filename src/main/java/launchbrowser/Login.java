package launchbrowser;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import pro.pages.AddtoCart;
import pro.pages.Register;
import pro.pages.SortFunctionality;
import pro.pages.TableHandling;


public class Login extends Baseclass {
	
	
	
	@Test(priority = 1, enabled= false)
	public void sort() throws IOException, InterruptedException
	{
		logger=report.createTest(" Window Handling page");
		SortFunctionality so=PageFactory.initElements(driver, SortFunctionality.class);
		logger.info("Starting the application");
		so.sort();
		so.sort_HighToLow();
		so.sort_AtoZ();
		so.sort_ZtoA();
		 logger.pass("Sort Functionality is passed ");
		 Helper.capturescreenshot(driver);
		
	}
	
	

	@Test(priority = 1, enabled= true) 
	public void signin() throws IOException, InterruptedException
	{
		logger=report.createTest("Web Table");
		AddtoCart add=PageFactory.initElements(driver, AddtoCart.class);
		logger.info("Starting the application");
		 add.signin();
		 logger.pass("Web Table Testcase is passed ");
		 Helper.capturescreenshot(driver);
		
	}

}
