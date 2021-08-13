package launchbrowser;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;


public class Baseclass {

	public static WebDriver driver;
	public static ExtentReports report;
    public static ExtentTest logger;
  //  private static ThreadLocal<ExtentTest> extentTest = new  ThreadLocal<ExtentTest>();
	@BeforeSuite
	public void setUpsuite()
	{
		ExtentSparkReporter extent =new ExtentSparkReporter(new File(System.getProperty("user.dir")+"/Reports/Result"+Helper.getCurrentDateTime()+".html"));
		 extent.config().setEncoding("utf-8");
		 extent.config().setDocumentTitle("Automation Report"); // Tile of report
		 extent.config().setReportName("Automation Test Results"); // Name of the report
		 extent.config().setTheme(Theme.DARK);
		  
		report=new ExtentReports();
		report.attachReporter(extent);
	}
	@BeforeClass
	public void setup()
	{
		Reporter.log("Launching the browser", true);
		driver=Launchbrowser.startApplication(driver, "Chrome", "https://www.saucedemo.com/inventory.html");
		Reporter.log("Browser is up and running", true);
	}
	
	
	@AfterClass
	public void teardown()
	{
		Launchbrowser.quitBrowser(driver);
	}
	@AfterMethod
	public void teardownMethod(ITestResult result) throws IOException
	{
		if(result.getStatus()==ITestResult.FAILURE)
		{
			logger.fail("Test Case Failed", MediaEntityBuilder.createScreenCaptureFromPath(Helper.capturescreenshot(driver)).build());
			 logger.log(Status.FAIL, result.getThrowable()); //get the exceptions
			logger.fail("Test case got failed");
			
		}
		else if(result.getStatus()==ITestResult.SUCCESS)
		{
			 logger.pass("Test case got passed");
		}
		else if(result.getStatus()==ITestResult.SKIP)
		{
			logger.skip("Test case got skipped");
		}
		report.flush();
		
	}

}
