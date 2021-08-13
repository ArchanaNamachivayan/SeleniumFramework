package pro.pages;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import launchbrowser.Baseclass;



public class AddtoCart extends Baseclass {
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
	
	public AddtoCart(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	public void signin()throws IOException, InterruptedException
	{
		logger.info("***Step 1 : SauceDemo Home page is displayed");
		//Assert.assertEquals(HomePageLogo.isDisplayed(), true,"Homepage Logo is present");
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
		
		logger.info("***Step 3 : Add products to the cart");
		
		Addtocart.get(1).click();
		Addtocart.get(0).click();
		
		logger.info("***Step 4 : Navigate to shopping cart icon");
		Assert.assertEquals(Shoppingcarticon.isDisplayed(), true,"Shopping cart is present");
		Shoppingcarticon.isDisplayed();
		Shoppingcarticon.click();
		
		logger.info("***Step 5 : Verify the product added in shopping cart");
	 String Item_name_1=driver.findElement(By.xpath("(//div[contains(@class,'inventory_item_name')])[1]")).getText();
	 String Item_name_2=driver.findElement(By.xpath("(//div[contains(@class,'inventory_item_name')])[2]")).getText();
		
		Assert.assertEquals("Sauce Labs Bike Light", Item_name_1);
		Assert.assertEquals("Sauce Labs Backpack", Item_name_2);
		logger.pass("Product added is available in cart");
		
		Assert.assertEquals(Checkout.isDisplayed(), true,"Checkout option is present");
		
		
		
		
		
	
}
}