package launchbrowser;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;


public class Helper {

	public static String capturescreenshot(WebDriver driver) throws IOException
	{
		
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String ScreenshotPath=System.getProperty("user.dir")+"/screenshots/Results"+getCurrentDateTime()+".png";
		try
		{
		FileHandler.copy(src, new File("./screenshots/Results"+getCurrentDateTime() +".png"));
		}catch(IOException e) {
			System.out.println("Unable to capture screenshot "+e.getMessage());
		}
		return ScreenshotPath;
		
	}
	public static String getCurrentDateTime()
	{
		DateFormat customFormat=new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
		Date currentDate =new Date();
		return customFormat.format(currentDate);
	}
}
