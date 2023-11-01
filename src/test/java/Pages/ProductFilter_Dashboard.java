package Pages;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.Set; 
import java.util.concurrent.TimeUnit;
import java.util.logging.FileHandler;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

@SuppressWarnings("deprecation")

public class ProductFilter_Dashboard {
	
	WebDriver driver;
	
	public ProductFilter_Dashboard(WebDriver driver)
	{
		this.driver=driver;
	}
	
	//Locator to select delivery day
	By Delivery_Day = By.xpath("//span[text()='Get It Today']");
	//Locator to select delivery day2
	By Delivery_Day2 = By.xpath("//span[text()='Get It in 2 Days']"); 
	//Locator to select men clothing 
	By Men_Clothing = By.xpath("//div[@id='departments']/ul/span[2]/li[3]");
	//Locator for customer review 
	By Customer_Review = By.xpath("//div[@id='reviewsRefinements']/ul/span/li/span/a/section[@aria-label='4 Stars & Up']");	
	//Locator to select brand
	By Brand = By.xpath("//ul[@data-csa-c-content-id='3837712031']/span/li[@aria-label='Allen Solly']");
	//Locator to verify discount
	By Discount = By.xpath("//span[text()='All Discounts']");
	//Locator to select top brands
	By Top_Brand = By.xpath("//div[@id='filters']/ul[1]/span[1]");
	//Locator to select size
	By Size = By.xpath("//ul[@data-csa-c-content-id='1974882031']/span[3]/li");
	//Locator to pay on delivery
	By Pay_Delivery = By.xpath("//span[text()='Eligible for Pay On Delivery']");
	//Locator for min price
	By Price1 = By.xpath("//input[@id='low-price']");
	//Locator for max price
	By Price2 = By.xpath("//input[@id='high-price']");
	//Locator for Go
	By Button = By.xpath("//input[@class='a-button-input']");
	//Locator for product length
	By Length = By.xpath("//ul[@data-csa-c-content-id='1974917031']/span[2]/li/span/a");	
	//Locator to select fit type
	By Fit_Type = By.xpath("//ul[@data-csa-c-content-id='28207568031']/span/li/span/a[@href='/s?k=polo+t+shirts+for+men&i=apparel&rh=n%3A1968120031%2Cp_n_feature_three_browse-bin%3A1974918031%2Cp_n_feature_six_browse-bin%3A56613290031&dc&crid=3A5M38JV6UUTV&qid=1698562558&rnid=28207568031&sprefix=Polo%2Capparel%2C212&ref=sr_nr_p_n_feature_six_browse-bin_1&ds=v1%3AsvJS93rN4lAYhuz0ERSexbmJmXeExW7Krld6mK6AMY8']"); 
	//Locator to verify material
	By Material = By.xpath("//ul[@data-csa-c-content-id='1974774031']/span/li/span/a/div/label/i[@class='a-icon a-icon-checkbox']");
	//Locator for occasion
	By Occasion = By.xpath("//ul[@data-csa-c-content-id='48812337031']/span[2]/li/span/a/div/label/i");
	//Locato for occasion link
	By Occasion_Link = By.xpath("//a[@aria-label='See more, Occasion']/span");
	//Locator to select pattern
	By Pattern = By.xpath("//ul[@data-csa-c-content-id='28972527031']/span[3]/li/span/a/div/label/i");			
	//Locator for product closure
	By Product_Closure = By.xpath("//ul[@data-csa-c-content-id='30540768031']/span/li/span/a/div/label/i");
	//Locator for feature link 
	By Feature_Link = By.xpath("//ul[@data-csa-c-content-id='48812335031']/span[3]/li/span/a/div/label/i");
	//Locator to select product feature
	By Product_Feature = By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[3]/span[1]/div[1]/div[1]/div[1]/div[6]/ul[11]/span[4]/li[1]/span[1]/a[1]/div[1]/label[1]/i[1]");
	//Locator to slect product description
	By Description = By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[3]/span[1]/div[1]/div[1]/div[1]/div[6]/ul[12]/span[5]/li[1]/span[1]/a[1]/div[1]/label[1]/i[1]");
	//Locator to select stock
	By Stock = By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[3]/span[1]/div[1]/div[1]/div[1]/div[6]/ul[15]/span[1]/li[1]/span[1]/a[1]/div[1]/label[1]/i[1]");
	//Locator for size
	By Medium = By.xpath("//button[@type='button' and @value='M']");
	//Locator to select product
	By Product1 = By.xpath("//img[@class='s-image']");
	//Locator to verify product
	By PoloProduct = By.xpath("//span[contains(text(),'Van Heusen Athleisure Men Polo T-Shirt')]");
	//Locator to retreive details
	By Product_Details = By.xpath("//div[@id='productFactsDesktopExpander']");
	//Locator to verify sort by filter
	By Sort_By = By.xpath("//select[@id='s-result-sort-select']");
	//Locator to select brand see more link
	By See_More = By.xpath("//li[@class='a-spacing-micro']/span/div/a/span[text()='See more']");
	//Locator to select jockey brand
	By Jockey = By.xpath("//ul[@class='a-unordered-list a-nostyle a-vertical a-spacing-none']/span[13]/li/span/a/div/label/i");
	
	//Method to select delivery day
	public void Delivery()
	{
		driver.findElement(Delivery_Day).click();
	}
	//Method to select Delivery Day
	public void Delivery2()
	{
		driver.findElement(Delivery_Day2).click();
	}
	//Method to select Men's clothing
	public void clothing()
	{	
		try {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(Men_Clothing));
		driver.findElement(Men_Clothing).click();	
		}
		catch(TimeoutException e)
		{
			System.out.println("Men's Clothing & Accessories is not selected. Exception: TimeoutException");
		}
	}
	//Method to select customer review
	public void review()
	{
		driver.findElement(Customer_Review).click();
	}
	//Method to click on see more link
	public void BrandLink()
	{
		driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[3]/span[1]/div[1]/div[1]/div[1]/div[4]/ul[1]/li[1]/span[1]/div[1]/a[1]/span[1]")).click();
		String Seemore_Link = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[3]/span[1]/div[1]/div[1]/div[1]/div[4]/ul[1]/li[1]/span[1]/div[1]/a[1]/span[1]")).getText();
		System.out.println(Seemore_Link);
		if(Seemore_Link.equals("See more"))
		{
			try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
			wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(Material));
			System.out.println("See more link functionality is working");
			}
			catch(TimeoutException e)
			{
 				System.out.println("See more link functionality in brand is not working. Exception: TimeoutException");
			}
		}
	}
	//Method to select Brand
	public void selectBrand()
	{
		String Brands = driver.findElement(By.xpath("//ul[@data-csa-c-content-id='3837712031']")).getText();
//		System.out.println(Brands);
		if(Brands.equals("Allen Solly"))
		{                   
			System.out.println("Brand is verified");
		}
		else
		{
			System.out.println("Brand is not verified");
		}
	}
	//Method to select discount
	public void selectDiscount()
	{
		driver.findElement(Discount).click();
	}
	//Method to select top brands
	public void selectAmazonBrand()
	{
		driver.findElement(Top_Brand).click();
	}
	//Method to select size
	public void selectSize()
	{
		driver.findElement(Size).click();
	}
	//Method to select Amazon Pay
	public void select_AmazonDelivery()
	{
		driver.findElement(Pay_Delivery).click();
	}
	//Method to select product length
	public void productLength()
	{
		driver.findElement(Length).click();
	}
	//Method to select product fit type
	public void productType() throws IOException, InterruptedException
	{
		try {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(Fit_Type));	
		driver.findElement(Fit_Type).click();
		}
		catch(TimeoutException e)
		{
			System.out.println("Type in product filter is not selected. Exception: TimeoutException");
		}
	}
	//Method to select material
	public void selectMaterial() throws IOException, InterruptedException
	{
		try {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(Material));
		driver.findElement(Material).click();
		}
		catch(TimeoutException e)
		{
			System.out.println("Material in product filter is not selected. Exception: TimeoutException ");
		}
	}
	//Method to select occasion
	public void selectOccasion() throws InterruptedException, IOException
	{
		try {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(Occasion));	
		driver.findElement(Occasion).click();
		}
		catch(TimeoutException e)
		{
			System.out.println("Unable to select occasion. Exception: TimeoutException");
		}
	}
	//Method to select product occasion
	public void VerifyOccasionLink() throws IOException, InterruptedException
	{
		try{
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
			wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(Occasion_Link));		
			driver.findElement(Occasion_Link).click();
		}
		catch(TimeoutException e)
		{
			System.out.println("Unable to select occasion more link. Exception: TimeoutException");
		}
	}
	//Method to select pattern 
	public void productPattern()
	{	try {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(Pattern));
		driver.findElement(Pattern).click();
		}
		catch(TimeoutException e)
	{
		System.out.println("Unable to pattern. Exception: TimeoutException");
	}
	}
	//Method to select product closure
	public void productClosure() throws InterruptedException, IOException
	{
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
			wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(Product_Closure));			
			driver.findElement(Product_Closure).click();
		}
		catch(TimeoutException e)
		{
			System.out.println("Unable to select closure type. Exception: TimeoutException");
		}
	}
	//Method to verify product feature link 
	public void verifyProductFeature()
	{
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
			wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(Feature_Link));			
			driver.findElement(Feature_Link).click();
		}
		catch(TimeoutException e)
		{
			System.out.println("Unable to select feature see more link. Exception: TimeoutException");
		}
	}
	//Method to select product feature
	public void selectFeature()
	{
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
			wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(Product_Feature));	
			driver.findElement(Product_Feature).click();	
		}
		catch(TimeoutException e)
		{
			System.out.println("Product feature is not selected. Exception: TimeoutException");
		}
	}
	//Method to select product description
	public void selectDescription()
	{
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
			wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(Description));	
			driver.findElement(Description).click();
		}
		catch(TimeoutException e)
		{
			System.out.println("Pocket description is not selected. Exception: TimeoutException");
		}
	}
	//Method to select product description
	public void selectProductStock() throws InterruptedException
	{
		try {
//		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(Stock));		
		driver.findElement(Stock).click();
		}
		catch(TimeoutException e)
		{
			System.out.println("Unable to click on availability stock. Exceptiom: TimeoutException");
		}
	}
	//Method to scroll
	public void scroll() throws InterruptedException
	{	
		try {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,850)", "");
		}
		catch(NullPointerException e)
		{
			System.out.println("Exception: NullPointerException");
		}
	}
	//Method to scroll to search element
	public void scrollToHeader() throws InterruptedException
	{
		WebElement Element = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", Element);
		Thread.sleep(5000);
	}
	//Method to select min price
	public void minPrice(String value1)
	{
		driver.findElement(Price1).sendKeys(value1);
	}
	//Method to select max price
	public void maxPrice(String value2)
	{
		driver.findElement(Price2).sendKeys(value2);
	}	
	//Method to select max price
	public void go()
	{
		driver.findElement(Button).click();
	}		
	//Method to select size
	public void size()
	{
		driver.findElement(Medium).click();
	}
	//Method to select product 
	public void product() throws InterruptedException
	{
		driver.findElement(Product1).click();
	}
	//Method to scroll
	public void scrollToElement()
	{
		WebElement Element = driver.findElement(By.xpath("//div[@id='detailBulletsWrapper_feature_div']/h2"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", Element);		
	}
	//Method to scroll
	public void scrollToPrice()
	{
		WebElement Element = driver.findElement(By.xpath("//span[text()='Price']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", Element);		
	}
	//Method for product details
	public void productDetails()
	{
		String ProductDetails = driver.findElement(Product_Details).getText();
		System.out.println(ProductDetails);
	}
	//Method to verify product page
	public void verifyProductPage() throws InterruptedException
	{
		Thread.sleep(5000);
		if(driver.getTitle().contains("Amazon.in : polo t shirt"))
		{
			System.out.println("Product page is verified");
		}
		else
		{
			System.out.println("Product page is not verified");
		}
	}
	//Method to select sort by filter
	public void filter() throws InterruptedException
	{
	  Select var = new Select(driver.findElement(Sort_By));
	  var.selectByVisibleText("Price: High to Low");
	  System.out.println("Sort by filter is selected");
	}
	//Method to select see more link 
	public void seemoreBrand()
	{
		//driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(See_More).click();
	}
	//Method to select jockey brand
	public void selectJockey() throws InterruptedException
	{
		driver.findElement(Jockey).click();
		String Jockey_Brand = driver.findElement(Jockey).getText();
		if(Jockey_Brand.equals("Jockey"))
		{
			System.out.println("Jockey brand is selected");
		}
		else
		{
			System.out.println("Jockey brand is not selected. Products are not in correct order. They are frequently changing.");
		}
	}
}
