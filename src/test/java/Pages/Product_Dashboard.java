package Pages;

import java.time.Duration;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

@SuppressWarnings("deprecation")

public class Product_Dashboard {

	WebDriver driver;
	 
	public Product_Dashboard(WebDriver driver)
	{
		this.driver=driver;
	}
	
	//Locator for Add To Cart Button   
//	By Cart_Button = By.xpath("//div[@id='addToCart_feature_div' and @data-csa-c-id='7ex69j-74m27u-786435-uazjtu']");
	By Cart_Btn = By.xpath("//input[@id='add-to-cart-button']");
	//Locator for Buy Now      
	By Buy = By.xpath("//input[@id='buy-now-button']");
	//Locator to verify product is added in cart
	By cart = By.xpath("//div[@class='a-section a-padding-medium sw-atc-message-section']/div/div/div/div/span");
	//Locator for Go to Cart
	By Shopping_Cart = By.xpath("//a[@href='/cart?ref_=sw_gtc' and @data-csa-c-type='button']");
	//Locator for Quantity
	By quantity = By.xpath("//span[@class='a-button-text a-declarative' and @id='a-autoid-0-announce']");
	//Locator to select quantity2
	By quantity2 = By.xpath("//div[@class='a-popover-wrapper']/div/ul/li[3]/a[@id='quantity_2']");
	//Locator to select quantity
	By quantity3 = By.xpath("//span[@class='a-dropdown-container']");
	//Locator for sub total price
	By Total_Price = By.xpath("//form[@id='activeCartViewForm']/div[3]");
	//Locator for proceed to buy button
	By Proceed_Button = By.xpath("//input[@name='proceedToRetailCheckout']");
	//Locator for Buy Now Button
	By Buy_Now = By.xpath("//input[@id='buy-now-button']");
	//Locator for total price
	By Checkout_Price = By.xpath("//table[@id='subtotals-marketplace-table']/tbody/tr[4]/td[2]");
	//Locator for product details
	By Product_Details = By.xpath("//div[@id='detailBullets_feature_div']");
	//Locator for Prechana Product
	By Cleaning_Mop = By.xpath("//img[@alt=\"PRECHANA 360 Rotatable Adjustable Cleaning Mop | Coral Velvet Mop Head for Household Floor Cleaning Wall Cleaning Mops | M...\"]");

	
	//Method to switch frame
	public void switchFrame() throws InterruptedException
	{
		WebElement Frame1 = driver.findElement(By.xpath("//body[contains(@class,'a-aui_72554-c a-aui_a11y_sr_678508-c')]/iframe"));
		driver.switchTo().frame(Frame1);
	}	
	//Method to click on Add To Cart
	public void addToCart() throws InterruptedException
	{
//		try {
//		Thread.sleep(5000);
		//driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		//wait.until(ExpectedConditions.presenceOfElementLocated(Cart_Button));	
//		driver.findElement(By.cssSelector("a.a-js a-audio a-video a-canvas a-svg a-drag-drop a-geolocation a-history a-webworker a-autofocus a-input-placeholder a-textarea-placeholder a-local-storage a-gradients a-transform3d -scrolling a-text-shadow a-text-stroke a-box-shadow a-border-radius a-border-image a-opacity a-transform a-transition a-ember a-ws"));
//		Set<String>windows = driver.getWindowHandles();
//		System.out.println(windows);
		driver.findElement(Cart_Btn).click();
//		Assert.assertTrue(true);
	}	
	//Method to verify that product is added in cart
	public void verifyCart()
	{
		String Add_Cart = driver.findElement(cart).getText();
		System.out.println(Add_Cart);
//		System.out.println(driver.getTitle());
	}
	
	//Method to click on Add To Cart
	public void buy() 
	{
		try {
		//Thread.sleep(5000);
		//driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		//wait.until(ExpectedConditions.presenceOfElementLocated(Cart_Button));	
		driver.findElement(Buy).click();
		}
		catch(Exception TimeoutException)
		{
			System.out.println("Exception: TimeoutException");
		}
	}
	//Method to switch window
	public void switchToWindow()
	{
		Set<String> windows = driver.getWindowHandles();
		System.out.println(windows);
		for(String Product_Window: windows)
		{
			driver.switchTo().window(Product_Window);
		}	
	}
	//Method to verify product is added in cart
	public void verifyProductCart()
	{
		String Product = driver.findElement(cart).getText();
		System.out.println(Product);
		Assert.assertEquals(Product,"Added to Cart");
	}
	//Method to click on Go To Cart
	public void Go_Cart()
	{
		driver.findElement(Shopping_Cart).click();
	}
	//Method to select product quantity
	public void Quantity()
	{
		driver.findElement(quantity3).click();
	}
	//Method to select 2 Quantity
	public void selectQuantity()
	{
		Select product_quantity = new Select(driver.findElement(By.xpath("//select[@name='quantity']")));
		product_quantity.selectByValue("2");
		String Qty = driver.findElement(By.xpath("//select[@name='quantity']")).getText();
		if(Qty.contains("2"))
		{
			System.out.println("Product quantity is verified");
		}
		else
		{
			System.out.println("Product quantity is not verified");
		}
	}
	//Method to verify sub total price
	public void verifyTotalPrice()
	{
		String Price = driver.findElement(Total_Price).getText();
		System.out.println("Total Price is:" + Price);
	}
	//Method to verify shopping cart page
	public void verifyShoppingCart()
	{
		if(driver.getTitle().equals("Amazon.in Shopping Cart"))
		{
			System.out.println("Product is successfully added in cart");
		}
		else
		{
			System.out.println("Product is not added in cart");
		}
	}
	//Method to verify Quantity
	public void proceedBtn()
	{
		driver.findElement(Proceed_Button).click();
	}
	//Method to click on buy now button
	public void buyBtn()
	{
		try {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.presenceOfElementLocated(Buy_Now));
		driver.findElement(Buy_Now).click();
		}
		catch(Exception TimeoutException)
		{
			System.out.println("Unable to click on buy now button in microsoft edge browser. Exception TimeoutException");
		}
	}
	//Method to retrieve total price
	public void verifyCheckoutPrice()
	{
		String checkout_amount = driver.findElement(Checkout_Price).getText();
		System.out.println(checkout_amount);
		System.out.println("Successfully retrieved amount in checkout page");
	}
	//Method to scroll
	public void scrollToProduct()
	{
		WebElement Element = driver.findElement(By.xpath("//div[@id='detailBulletsWrapper_feature_div']/h2"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", Element);		
	}
	//Method to retrieve product details
	public void retrieveProductDetails()
	{
		String ProductDetails = driver.findElement(Product_Details).getText();
		System.out.println(ProductDetails);
		System.out.println("Successfully retrieved product detials in product page");
	}
	//Method to select cleaning mop product
	public void selectMopProduct()
	{
		driver.findElement(Cleaning_Mop).click();
	}
	
}
