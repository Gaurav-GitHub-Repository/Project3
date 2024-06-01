package Pages;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

@SuppressWarnings("deprecation")

public class Checkout_Dashboard {

	WebDriver driver;
	
	public Checkout_Dashboard(WebDriver driver) 
	{
		this.driver=driver;
	}
	 
	//Locator to update location in checkout
	By Add_Address = By.xpath("//form[@method='post']/div/div/div/div/span[1]/a");
	//Locator for name
	By Name = By.xpath("//div[@class='a-input-text-group a-spacing-medium a-spacing-top-medium']/parent::div/div/div[4]/input");
	//Locator for number
	By number = By.xpath("//div[@class='a-input-text-group a-spacing-medium a-spacing-top-medium']/parent::div/div/div[6]/input");
	//Locator for pincode
	By Pincode = By.xpath("//div[@class='a-input-text-group a-spacing-medium a-spacing-top-medium']/parent::div/div/div[8]/input");
	//Locator for area
	By Area = By.xpath("//div[@class='a-input-text-group a-spacing-medium a-spacing-top-medium']/parent::div/div/div[10]/input");
	//Locator for area2
	By Area2 = By.xpath("//div[@class='a-input-text-group a-spacing-medium a-spacing-top-medium']/parent::div/div/div[12]/input");
	//Locator for city
	By City = By.xpath("//div[@class='a-input-text-group a-spacing-medium a-spacing-top-medium']/parent::div/div/div[15]/div/div[2]/input");
	//Locator to select address button
	By Address_Button = By.xpath("//*[@id="address-ui-widgets-form-submit-button"]/span/input");
	//Locator to save address
	By Checkout_SaveAddress = By.xpath("//input[@name='address-ui-widgets-saveOriginalOrSuggestedAddress']");
	//Locator for payment method
	By Payment = By.xpath("//div[@aria-label='Payment method ' and @role='form']/div/div/span/h3/span[2]");
	//Locator to select debit card
	By Radio = By.xpath("//form[@id='address-list' and @method='post']/div/div/div/fieldset/div[2]/span/div/label/input");
	//Locator to select card
	By Card = By.xpath("//a[text()='Enter card details']");
	//Locator to select checkout address
	By Checkout_ShippingAddress = By.xpath("//input[@data-testid='Address_selectShipToThisAddress']");
	//Locator to select cash on delivery
	By Cash_Delivery = By.xpath("//input[@id='pp-HZo3Tg-132']");
	//Locator for payment method
	By Pay_Method = By.xpath("//input[@name='ppw-widgetEvent:SetPaymentPlanSelectContinueEvent']");
	//Locator cash on delivery button
	By Cash_On_Delivery = By.xpath("//div[@id='pp-Z0R8g0-131']");
	//Locator for payment method button
	By Payment_Button = By.xpath("//span[@id='pp-Z0R8g0-134-announce']");
	//Locator for Payment Method2
	By Payment_Method2 = By.xpath("//input[@class='a-button-input' and @aria-labelledby='orderSummaryPrimaryActionBtn-announce']");
	//Locator for credit or debit card
	By DebitCard_Radio = By.xpath("//input[@id='pp-yYtZqr-96'and @value='SelectableAddCreditCard']");
	
	
	//Method to click on checkout location
	public void checkoutLocation()
	{
		driver.findElement(Add_Address).click();
	}
	//Method to select country
	public void selectCountry()
	{
		Select var = new Select(driver.findElement(By.xpath("//select[@name='address-ui-widgets-countryCode']")));
		var.selectByVisibleText("India");	
		if(var.equals("India"))
		{
			System.out.println("Country is selected:" + " " + "India");
		}
		else
		{
			System.out.println("Country is not selected");
		}
		
	}
	//Method to call name
	public void name(String value)
	{
		driver.findElement(Name).clear();
		driver.findElement(Name).sendKeys(value);
	}
	//Method to enter number
	public void enterNumber(String value2)
	{
		driver.findElement(number).clear();
		driver.findElement(number).sendKeys(value2);
	}
	//Method to enter number
	public void enterPincode(String value3)
	{
		driver.findElement(Pincode).clear();
		driver.findElement(Pincode).sendKeys(value3);
	}
	//Method to enter area1
	public void enterArea(String value4)
	{
		driver.findElement(Area).clear();
		driver.findElement(Area).sendKeys(value4);
	}	
	//Method to enter area2
	public void enterArea2(String value5)
	{
		driver.findElement(Area2).clear();
		driver.findElement(Area2).sendKeys(value5);
	}
	//Method to enter city
	public void enterCity(String value6)
	{
		driver.findElement(City).clear();
		driver.findElement(City).sendKeys(value6);
	}
	//Method to select state
	public void selectState()
	{
		Select var = new Select(driver.findElement(By.xpath("//select[@name='address-ui-widgets-enterAddressStateOrRegion']")));
		var.selectByVisibleText("TELANGANA");
		List<WebElement> State = driver.findElements(By.xpath("//select[@name='address-ui-widgets-enterAddressStateOrRegion']"));
		for(WebElement TotalNumberOfState:State)
		{
			if(TotalNumberOfState.equals("TELANGANA"))
			{
				System.out.println("Country dropdown is selected:"+ " " +"TELANGANA");
				break;
			}
		}
	}
	//Method to click on address button
	public void addressBtn() throws InterruptedException
	{
		try 
		{
//		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
//		wait.until(ExpectedConditions.presenceOfElementLocated(Address_Button));
		Thread.sleep(5000);	
		driver.findElement(Address_Button).click();
		}
		catch(TimeoutException e)
		{
			System.out.println("Unable to click on checkout address button. Exception: TimeoutException");
		}
	}
	//Method to save checkout address
	public void SaveAddress() 
	{
		try {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.presenceOfElementLocated(Address_Button));	
		driver.findElement(Checkout_SaveAddress).click();
		}
		catch(TimeoutException e)
		{
			System.out.println("Exception: TimeoutException");
		}
	}
	//Method to select checkout shipping address 
	public void shippingAddress() throws InterruptedException
	{
		Thread.sleep(5000);
		driver.findElement(Checkout_ShippingAddress).click();
	}
	//Method to click on payment method
	public void Payment_Method()
	{
		try
		{
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
			wait.until(ExpectedConditions.presenceOfElementLocated(Payment));	
			driver.findElement(Payment).click();
		}
		catch(TimeoutException e)
		{
			System.out.println("Unable to click on debit card radio.Exception: TimeoutException");
		}
	}
	//Method to select radio
	public void selectRadio() throws InterruptedException
	{
		driver.findElement(Radio).click();
		boolean RadioButton = driver.findElement(Radio).isDisplayed();
		System.out.println(RadioButton);
	}
	//Method to select debit card
	public void selectCardDetails()
	{
		driver.findElement(Card).click();
	}
	//Method to select net banking
	public void NetBanking()
	{
		Select var = new Select(driver.findElement(By.xpath("//select[@name='ppw-bankSelection_dropdown']")));
		var.selectByVisibleText("ICICI Bank");	
		List<WebElement> SelectNetBanking = driver.findElements(By.xpath("//*[@id='pp-9f70cZ-107']"));
		for(WebElement Product:SelectNetBanking)
		{
			if(Product.equals("ICICI Bank"))
			{
				System.out.println("Net banking is selected:" + " " + "ICICI Bank");
				break;
			}
		}
	}
	//Method to click on cash on delivery payment
	public void selectCashDelivery()
	{
		try 
		{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));	
		wait.until(ExpectedConditions.presenceOfElementLocated(Cash_Delivery));
		driver.findElement(Cash_Delivery).click();
		System.out.println(driver.findElement(Cash_Delivery).isDisplayed());
		}
		catch(TimeoutException e)
		{
			System.out.println("Unbale to click on checkout address button");
		}
	}
	//Method to click on payment method
	public void selectPaymentMethod()
	{
		driver.findElement(Pay_Method).click();
	}
	//Method to select cash on delivery
	public void selectCashOnDelivery() throws InterruptedException
	{
		try {
//		Thread.sleep(5000);
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));	
		wait.until(ExpectedConditions.presenceOfElementLocated(Cash_On_Delivery));
		driver.findElement(Cash_On_Delivery).click();
		}
		catch(TimeoutException e)
		{
			System.out.println("Unable to click on cash on delivery. Exception: TimeoutException");
		}
	}
	//Method to click on payment method
	public void paymentBtn() throws InterruptedException
	{
		try {
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));	
			wait.until(ExpectedConditions.presenceOfElementLocated(Cash_On_Delivery));
			driver.findElement(Payment_Button).click();
		} catch (TimeoutException e) {
			System.out.println("Unable to click on checkout payment button. Exception: TimeoutException");
		}		
	}
	//Method to scroll
	public void scroll()
	{	
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("window.scrollBy(0,850)", "");
	}
	//Method to switch window
	public void switchToWindow()
	{
		Set<String> windows = driver.getWindowHandles();
		for(String Product_Window: windows)
		{
			driver.switchTo().window(Product_Window);
		}
	}
	//Method to click on payment method 2
	public void paymentBtn2()
	{
		driver.findElement(Payment_Method2).click();
	}
	//Method to switch frame
	public void switchToFrame()
	{
		driver.findElement(By.xpath("//iframe[@id='pp-Z0R8g0-100']"));
	}
	//Method to select Debit Card Radio
	public void selectDebitCardRadio()
	{
		try {
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));	
			wait.until(ExpectedConditions.presenceOfElementLocated(DebitCard_Radio));	
			driver.findElement(DebitCard_Radio).click();
		}
		catch(TimeoutException e)
		{
			System.out.println("Unable to click on Debit Card Radio Button. Exception: TimeoutException");
		}
		}
	}
	

