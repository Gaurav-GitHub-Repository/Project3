package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class LoginPage {

	WebDriver driver;
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	//Locator for Amazon Account Button
	By Amazon_Account = By.xpath("//a[@id='createAccountSubmit']");
	//Locator for Register Name
	By Register_Name = By.xpath("//input[@name='customerName']");
	//Locator for Register Number
	By Register_Number = By.xpath("//input[@id='ap_phone_number']");
	//Locator for Register Email
	By Register_Email = By.xpath("//input[@id='ap_email']");
	//Locator for Register Password
	By Register_Password = By.xpath("//input[@id='ap_password']");
	//Locator to verify number
	By Number = By.xpath("//input[@id='continue']");
	//Locator for OTP
	By Register_OTP = By.xpath("//form[@id='auth-pv-form']/input[5]");
	//Locator for Account Button
	By Account_Button = By.xpath("//form[@id='auth-pv-form']/span");
	//Locator to verify Invalid OTP
	By Invalid_OTP = By.xpath("//ul[contains(@class,'a-unordered-list a-nostyle a-vertical a-spacing-none')]");
	//Locator for Mobile Number
	By SignInNumber = By.xpath("//input[@name='email']");
	//Locator for SignIn Button
	By SignInButton = By.xpath("//span[text()='Sign in']");
	//Locator to click on continue button
	By ContinueButton = By.xpath("//input[@id='continue']");
	//Locator to enter password
	By Password = By.xpath("//input[@name='password']");
	//Locator to click on sign in button
	By LoginButton = By.xpath("//input[@id='signInSubmit']");
	
	//Method to Mousehover
	public void move()
	{
		Actions action = new Actions(driver);
		WebElement a = driver.findElement(By.xpath("//span[text()='Hello, sign in']"));
		action.moveToElement(a).build().perform();
	}	
	//Method to click on SignIn button
	public void signin()
	{
		driver.findElement(SignInButton).click();
	}	
	//Method to click on Amazon Account
	public void account()
	{
		driver.findElement(Amazon_Account).click();
	}
	//Method to click on Name
	public void name(String value)
	{
		driver.findElement(Register_Name).sendKeys(value);
	}
	//Method to click on number
	public void number(String value1)
	{
		driver.findElement(Register_Number).sendKeys(value1);
	}
	//Method to click on email
	public void email(String value3)
	{
		driver.findElement(Register_Email).sendKeys(value3);
	}
	//Method to click on password
	public void password(String value4)
	{
		driver.findElement(Register_Password).sendKeys(value4);
	}
	//Method to click on verify number button
	public void verifyNumberButton()
	{
		driver.findElement(Number).click();
	}
	//Method to enter OTP
	public void OTP(String value5) throws InterruptedException
	{
		Thread.sleep(8000);
		driver.findElement(Register_OTP).sendKeys(value5);
	}
	//Method to create amazon account
	public void button()
	{
		driver.findElement(Account_Button).click();
	}	
	//Method to create amazon account
	public void verifyOTP()
	{
		String InvalidOTPError = driver.findElement(By.xpath("//ul[contains(@class,'a-unordered-list a-nostyle a-vertical a-spacing-none')]")).getText();
		System.out.println(InvalidOTPError);
		if(InvalidOTPError.equals("The One Time Password (OTP) you entered is not valid. Please try again."))
		{
			System.out.println("Invalid OTP functionality is verified");
		}
		else
		{
			System.out.println("Invalid OTP functionality is not verified");
		}
	}	
	//Method to enter mobile number
	public void mobilenumber(String value6)
	{
		driver.findElement(SignInNumber).sendKeys(value6);
	}
	//Method to click on continue button
	public void continueBtn()
	{
		driver.findElement(ContinueButton).click();
	}
	//Method to enter password
	public void loginPassword(String value7)
	{
		driver.findElement(Password).sendKeys(value7);
	}	
	public void loginBtn()
	{
		driver.findElement(LoginButton).click();
	}
	
}
