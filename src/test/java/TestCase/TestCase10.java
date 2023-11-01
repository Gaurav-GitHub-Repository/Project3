package TestCase;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.Dashboard;
import Pages.LoginPage;
import Pages.LogoutPage;

@SuppressWarnings("deprecation")
public class TestCase10 {

		//TestCase10: Verify location is saved and click on sign out
	
		WebDriver driver;
		
		@Test(priority=0)
		public void initialize() 
		{
		System.setProperty("WebDriver.Chrome.Driver", "C:\\Selenium Temp\\ChromeDriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("https://www.amazon.in/");
		}
		@Test(priority=1)
		public void login()
		{ 
		//Method to call LoginPage
		LoginPage loginpage = new LoginPage(driver);
		loginpage.move();
		loginpage.signin();
		loginpage.mobilenumber("1234567891");
		loginpage.continueBtn();
		loginpage.loginPassword("abc");
		loginpage.loginBtn();
		}
		@Test(priority=2)
		public void updateLocation()
		{
		//Method to call Dashboard
		Dashboard dashboard = new Dashboard(driver);
		dashboard.location();
		dashboard.addAddress1();
		dashboard.addAddress2();
		dashboard.country();
		dashboard.name("Pathange Gaurav");
		dashboard.number("1234567891");
		dashboard.postalCode("500032");
		dashboard.street("Road No 5, Sri Gajanana Homes");
		dashboard.streetAddress("Kompally, Hyderabad");
		dashboard.city("Hyderabad");
		dashboard.state();
		dashboard.addressbtn();
		dashboard.verifyAddress();
		dashboard.address1();
		dashboard.address2();
		dashboard.address3();
		}
 		@Test(priority=3)
		public void logout()
		{
		//Method to call Dashboard
		Dashboard dashboard = new Dashboard(driver);
		dashboard.moveToSignout();
		//Method to call LogoutPage
		LogoutPage logoutpage = new LogoutPage(driver);
		logoutpage.button();
		}
	}

