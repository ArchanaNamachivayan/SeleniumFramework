package pro.test;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import launchbrowser.Baseclass;
import launchbrowser.Launchbrowser;
import pro.pages.AddtoCart;
import pro.pages.Facebook;
import pro.pages.Register;
import pro.pages.SortFunctionality;
import pro.pages.TableHandling;



public class execute  {

	
	private static WebDriver driver= null;
	public static void main(String[] args) throws IOException, InterruptedException {
		signin();
		sort_lowtohigh();
	}

	
	/*public static void facebook() throws IOException, InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D:\\pro\\Driver\\chromedriver.exe");  
		// Instantiate a ChromeDriver class.     
	    driver=new ChromeDriver();  
	    driver.get("hhttps://www.facebook.com/");
		Facebook fb= new Facebook(driver);
		fb.facebook();
		fb.count_facebook();
		//Launchbrowser.quitBrowser(driver);
	
	}

	@Test(priority = 1, enabled= false)
	public void register() throws InterruptedException, IOException {
		//driver=Launchbrowser.startApplication(driver, "Chrome", "https://accounts.lambdatest.com/register");
		Register reg=PageFactory.initElements(driver, Register.class);
		reg.register();
		reg.verify();
		//Launchbrowser.quitBrowser(driver);

		}


	@Test(priority = 1, enabled= false)
	public void table() throws InterruptedException, IOException {
		driver=Launchbrowser.startApplication(driver, "Chrome", "http://demo.automationtesting.in/WebTable.html");
		TableHandling tb=PageFactory.initElements(driver, TableHandling.class);
		 tb.table();
		Launchbrowser.quitBrowser(driver);

	}

	@Test(priority = 1, enabled= false)
	public void whandle() throws InterruptedException, IOException {
		//driver=Launchbrowser.startApplication(driver, "Chrome", "http://demo.automationtesting.in/Windows.html");
		WindowHandling wh=PageFactory.initElements(driver, WindowHandling.class);
		wh.whandle();
		//Launchbrowser.quitBrowser(driver);
	     
	}
	*/
	
	@Test(priority = 0, enabled= true)
	public static void sort_lowtohigh() throws InterruptedException, IOException {
		driver=Launchbrowser.startApplication(driver, "Chrome", "https://www.saucedemo.com/");
		SortFunctionality so=PageFactory.initElements(driver, SortFunctionality.class);
		so.sort();
		so.sort_HighToLow();
		so.sort_AtoZ();
		so.sort_ZtoA();
		Launchbrowser.quitBrowser(driver);
	     
	}
	@Test(priority = 1, enabled= true)
	public static void signin() throws InterruptedException, IOException {
		driver=Launchbrowser.startApplication(driver, "Chrome", "https://www.saucedemo.com/");
		AddtoCart add=PageFactory.initElements(driver, AddtoCart.class);
		add.signin();
		Launchbrowser.quitBrowser(driver);
	     
	}
	
	
	
	}



