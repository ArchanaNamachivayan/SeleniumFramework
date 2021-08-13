package pro.pages;


import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import launchbrowser.Baseclass;



public class SortFunctionality extends Baseclass {
	WebDriver driver;
	@FindBy(xpath="//div[contains(@class,'login_logo')]")
	public WebElement HomePageLogo;
	@FindBy(xpath="//input[contains(@placeholder,'Username')]")
	public WebElement Username;
	@FindBy(xpath="//input[contains(@placeholder,'Password')]")
	public WebElement Password;
	@FindBy(xpath="//input[contains(@id,'login-button')]")
	public WebElement Login;
	@FindBy(xpath="///div[contains(@class,'login_credentials_wrap-inner')]")
	public WebElement LoginCredentials;
	@FindBy(xpath="//div[contains(@class,'inventory_item_description')]")
	public List<WebElement> ItemDescription;
	
	@FindBy(xpath="//div[contains(@class,'inventory_item_name')]")
	public List<WebElement> ItemName;
	
	@FindBy(xpath="//button[contains(text(),'Add to cart')]")
	public List<WebElement> Addtocart;
	
	@FindBy(xpath="//a[contains(@class,'shopping_cart_link')]")
	public WebElement Shoppingcarticon;
	
	@FindBy(xpath="//button[contains(@class,'btn btn_action btn_medium checkout_button')]")
	public WebElement Checkout;
	
	@FindBy(xpath="//div[contains(@class,'inventory_item_price')]")
	public List<WebElement> ItemPrice;
	
	public SortFunctionality(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	static public String getFloatingnumbersFromDesiredString(String desiredstring)
	{
		if(desiredstring.contains(","))
		{
			desiredstring=desiredstring.replace(",", " ");
		}
		String regex="([-\\+]?[0-9] ([0-9]*) (\\.[0-9]+)?) | (^0$)";
		 Pattern pattern = Pattern.compile(regex);
		 Matcher matcher = pattern.matcher(desiredstring);
		 while(matcher.find())
		 {
			 return matcher.group(0);
		 }
		return "";
		
	}
	public void sort()throws IOException, InterruptedException
	{
		logger.info("***Step 1 : SauceDemo Home page is displayed");
		HomePageLogo.isDisplayed();
		Username.sendKeys("standard_user");
		Password.sendKeys("secret_sauce");
		Login.click();
		Thread.sleep(2000);
		logger.pass("Login is done successfully");
		
		WebDriverWait wait=new WebDriverWait(driver,20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(@class,'shopping_cart_link')]")));

		logger.info("***Step 2 : Product List is displayed");
		
		
		for( WebElement product : ItemDescription){
			System.out.println("List of product displayed :" +product.getText());	
		}
		logger.pass("List of product Description is displayed");
		
		for( WebElement product : ItemName){
			System.out.println("List of product displayed :" +product.getText());
		}
		logger.pass("List of product name is displayed");
		
		
    	
        Select select = new Select(driver.findElement(By.xpath("//select[contains(@class,'product_sort_container')]")));
        select.selectByVisibleText("Price (low to high)");
        java.util.List<WebElement> price = driver.findElements(By.xpath("//div[contains(@class,'inventory_item_price')]"));
        System.out.println(price.size());
        for (int i = 0; i<price.size(); i=i+1) 
        {
        System.out.println(price.get(i).getText());    
       
        } 
        logger.pass("Sorting the list of products from price low to high");
        Thread.sleep(2000);
      
        
       /* if(ItemDescription.size()!=1)
        {
        	for(int i=0;i<=(ItemPrice.size()-2);i++)
        	{
        		String UnitPriceNext=ItemPrice.get(i).getText();
        		double UnitPricePrevious =Double.parseDouble(getFloatingnumbersFromDesiredString(ItemPrice.get(i).getText().trim().replace(",", " ")));
        		double UnitPriceNext1 =Double.parseDouble(getFloatingnumbersFromDesiredString(ItemPrice.get(i+1).getText().trim().replace(",", " ")));
        	   logger.info("UnitPricePrevious"+UnitPricePrevious+"UnitPriceNext: "+UnitPriceNext1);
        	   Assert.assertTrue(UnitPricePrevious<=UnitPriceNext1,"UnitPricePrevious: "+UnitPricePrevious+"UnitPriceNext :"+"Unit price should be in ascending order");
        	}
        }*/
        
        
        
        
	}
	public void sort_HighToLow()throws IOException, InterruptedException
	{
		logger.info("Sort high to Low");
		
		
        Select select = new Select(driver.findElement(By.xpath("//select[contains(@class,'product_sort_container')]")));
        select.selectByVisibleText("Price (high to low)");
        java.util.List<WebElement> price = driver.findElements(By.xpath("//div[contains(@class,'inventory_item_price')]"));
        System.out.println(price.size());
        for (int i = 0; i<price.size(); i=i+1) 
        {
        System.out.println(price.get(i).getText());          
        } 
        
        logger.pass("Sorting the list of products from price high to low");
		
	}
	public void sort_AtoZ()throws IOException, InterruptedException
	{
		logger.info("Sort A to Z");
		
		
        Select select = new Select(driver.findElement(By.xpath("//select[contains(@class,'product_sort_container')]")));
        select.selectByVisibleText("Name (A to Z)");
        java.util.List<WebElement> name = driver.findElements(By.xpath("//div[contains(@class,'inventory_item_name')]"));
        System.out.println(name.size());
        for (int i = 0; i<name.size(); i=i+1) 
        {
        System.out.println(name.get(i).getText());          
        }  

        logger.pass("Sorting the list of products from Z to A");
	
	}
	public void sort_ZtoA()throws IOException, InterruptedException
	{
		logger.info("Sort Z to A");
		
		
        Select select = new Select(driver.findElement(By.xpath("//select[contains(@class,'product_sort_container')]")));
        select.selectByVisibleText("Name (Z to A)");
        java.util.List<WebElement> name = driver.findElements(By.xpath("//div[contains(@class,'inventory_item_name')]"));
        System.out.println(name.size());
        for (int i = 0; i<name.size(); i=i+1) 
        {
        System.out.println(name.get(i).getText());          
        } 
        logger.pass("Sorting the list of products from Z to A");
        
	}
	
	
}