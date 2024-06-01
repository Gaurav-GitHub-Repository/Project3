package Pages;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

@SuppressWarnings("deprecation")
public class Dashboard {

	WebDriver driver;  
	
	public Dashboard(WebDriver driver)
	{ 
		this.driver=driver;
	}
	
	//Locator for Dashboard Button
	By Button = By.cssSelector("i.hm-icon");
	//Locator to scroll
	By Element = By.xpath("//div[text()='help & settings']");
	//Locator for SignIn
	By SignInBtn = By.xpath("//div[@id='hmenu-content']/ul/li[32]/a[@class='hmenu-item']");
	//Locator to verify logo 
	By Logo = By.xpath("//a[@href='/ref=nav_logo']");
	//Locator for location
	By Location = By.cssSelector("div#nav-global-location-slot");
	//Locator to add address
	By Address = By.cssSelector("div.a-spacing-top-base");
	//Locator to add address
	By Add_Address = By.xpath("//*[text()='Add address']");
	//Locator for Full Name
	By Name = By.xpath("//div[@class='a-input-text-group a-spacing-medium a-spacing-top-medium']/parent::div/div/div[4]/input");
	//Locator for Street Number
	By Street = By.xpath("//div[@class='a-input-text-group a-spacing-medium a-spacing-top-medium']/parent::div/div/div[10]/input");
	//Locator for Street Address
	By Street_Address = By.xpath("//div[@class='a-input-text-group a-spacing-medium a-spacing-top-medium']/parent::div/div/div[12]/input");
	//Locator for City
	By City = By.xpath("//div[@class='a-input-text-group a-spacing-medium a-spacing-top-medium']/parent::div/div/div[15]/div[1]/div[2]");
	//Locator for state
	By State = By.xpath("//div[@class='a-input-text-group a-spacing-medium a-spacing-top-medium']/parent::div/div/div[15]/div[2]/div[2]/span");
	//Locator for postal code
	By Postal_Code = By.xpath("//div[@class='a-input-text-group a-spacing-medium a-spacing-top-medium']/parent::div/div/div[8]/input");
	//Locator for mobile number
	By Mobile_Number = By.xpath("//div[@class='a-input-text-group a-spacing-medium a-spacing-top-medium']/parent::div/div/div[6]/input");
	//Locator for add address button
	By Address_Button = By.xpath("//*[@id="address-ui-widgets-form-submit-button"]/span/input");
	//Locator to verify address
	By Address_Saved = By.xpath("//div[@class='a-box a-alert a-alert-success a-spacing-small']/div/h4");
	//Locator to retrieve address details
	By Address_Details1 = By.xpath("//ul[@class='a-unordered-list a-nostyle a-vertical']/li[2]");
	//Locator to retrieve address details
	By Address_Details2 = By.xpath("//ul[@class='a-unordered-list a-nostyle a-vertical']/li[3]");
	//Locator to retrieve address details
	By Address_Details3 = By.xpath("//ul[@class='a-unordered-list a-nostyle a-vertical']/li[4]");
	//Locator to select flight tickets 
	By Select_Flight = By.xpath("//a[normalize-space()='Flight Tickets']");
	
	
	//Method to call Dashboard Button
	public void button()
	{
		driver.findElement(Button).click();
	}
	//Method to click on flight
	public void Flight_Ticket()
	{
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
//		wait.until(ExpectedConditions.visibilityOfElementLocated(Select_Flight));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(Select_Flight).click();
	}
	//Method to Mousehover
	public void move()
	{
		Actions action = new Actions(driver);
		WebElement a = driver.findElement(By.xpath("//span[text()='Hello, sign in']"));
		action.moveToElement(a).build().perform();
	}	
	//Method to move signout in dashboard page
	public void moveToSignout()
	{
		Actions action = new Actions(driver);
		WebElement a = driver.findElement(By.xpath("//div[@id='nav-belt']/div/div/a/div/span"));
		action.moveToElement(a).build().perform();	
	}
	public void verifyPage() throws InterruptedException
	{
		Thread.sleep(5000);
		if(driver.getTitle().equals("Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in"))
		{
			System.out.println("Page Title is verified");
		}
		else
		{
			System.out.println("Page Title is not verified");
		}	
	}
	//Method to verify Logo
	public void verifyLogo()
	{
		driver.findElement(Logo).click();
		String AmazonLogo = driver.findElement(Logo).getText();
		if(AmazonLogo.contains(".in"))
		{
			System.out.println("Amazon Logo is verified");
		}
		else
		{
			System.out.println("Amazon Logo is not verified");
		}
	}
	//Method to click on Location
	public void location()
	{
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(Location).click();
	}
	//Method to add address
	public void addAddress1()
	{
		try {
		Thread.sleep(5000);	
		driver.findElement(Address).click();
		}
		catch(Exception NoSuchElementException)
		{
			System.out.println("Exception: NoSuchElementException");
		}
	}
	//Method to Add Address
	public void addAddress2()
	{
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(Add_Address).click();
	}
	//Method to select country
	public void country()
	{
		Select var = new Select(driver.findElement(By.xpath("//select[@name='address-ui-widgets-countryCode']")));
		var.selectByVisibleText("India");		
	}
	//Method to enter full name
	public void name(String value)
	{
		driver.findElement(Name).clear();
		driver.findElement(Name).sendKeys(value);
	}
	//Method to enter street number
	public void street(String value1)
	{
		driver.findElement(Street).clear();
		driver.findElement(Street).sendKeys(value1);
	}
	//Method to enter street address
	public void streetAddress(String value2)
	{
		driver.findElement(Street_Address).clear();
		driver.findElement(Street_Address).sendKeys(value2);
	}
	//Method to enter city
	public void city(String value3)
	{
		driver.findElement(City).clear();
		driver.findElement(City).sendKeys(value3);
	}
	//Method to enter state
	public void state()
	{
		Select var = new Select(driver.findElement(State));
		var.selectByVisibleText("TELANGANA");
	}
	//Method to enter postal code
	public void postalCode(String value5)
	{
		driver.findElement(Postal_Code).clear();
		driver.findElement(Postal_Code).sendKeys(value5);
	}
	//Method to enter mobile number
	public void number(String value6)
	{
		driver.findElement(Mobile_Number).clear();
		driver.findElement(Mobile_Number).sendKeys(value6);
	}
	//Method to click on address button
	public void addressbtn()
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.presenceOfElementLocated(Address_Button));
		driver.findElement(Address_Button).click();
	}
	//Method to verify address
	public void verifyAddress()
	{
		String var = driver.findElement(Address_Saved).getText();
		System.out.println(var);
		Assert.assertEquals(var, "Address saved");
	}
	//Method to retrieve address details
	public void address1()
	{
		String Street = driver.findElement(Address_Details1).getText();
		System.out.println(Street);
	}
	//Method to retrieve address details
	public void address2()
	{
		String Area = driver.findElement(Address_Details2).getText();
		System.out.println(Area);
	}	
	//Method to retrieve address details
	public void address3()
	{
		String City = driver.findElement(Address_Details3).getText();
		System.out.println(City);
	}			
	//Method to select flight ticket
	public void selectFlightTicket()
	{
//		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
//		wait.until(ExpectedConditions.presenceOfElementLocated(Select_Flight));
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(Select_Flight).click();
	}
}

