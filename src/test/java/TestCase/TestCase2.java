package TestCase;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import Pages.Dashboard;
import Pages.LoginPage;

@SuppressWarnings("deprecation")
public class TestCase2 {

	//TestCase2: Verify amazon account with invalid OTP/Verify Invalid OTP
		
		WebDriver driver;
	
		@Test(priority=0)
		public void initialize()
		{
		System.setProperty("WebDriver.Chrome.Driver", "C:\Selenium Temp\ChromeDriver\V120\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("https://www.amazon.in/");
		}
		@Test(priority=1)
		public void verify() throws InterruptedException
		{
		//Method to call Button_Dashboard 
		LoginPage loginpage = new LoginPage(driver);
		loginpage.move();
		loginpage.signin();
		loginpage.account();
		loginpage.name("abc");
		loginpage.number("1000000000");
		loginpage.email("abc@gmail.com");
		loginpage.password("abc");
		loginpage.verifyNumberButton();
		loginpage.OTP("439457");
		loginpage.button();	
		loginpage.verifyOTP();
		}
}
