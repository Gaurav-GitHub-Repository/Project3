package TestCase;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import Pages.Dashboard;
import Pages.LoginPage;

@SuppressWarnings("deprecation")
public class TestCase1 {

	//TestCase1: Verify amazon account with valid OTP in Google Chrome	

	@Test(priority=0)
	public void SignUp() throws InterruptedException
	{
	System.setProperty("WebDriver.Chrome.Driver", "C:\Selenium Temp\ChromeDriver\V120\chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	driver.get("https://www.amazon.in/");
	//Method to call LoginPage
	LoginPage loginpage = new LoginPage(driver);
	loginpage.move();
	loginpage.signin();
	loginpage.account();
	loginpage.name("abc");
	loginpage.number("0000000000");
	loginpage.email("abc@gmail.com");
	loginpage.password("abc");
	loginpage.verifyNumberButton();
	loginpage.OTP("439457");
	loginpage.button();	
	}
}
