package TestCase;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import Pages.Dashboard;
import Pages.LoginPage;
import Pages.LogoutPage;
import Pages.Search_Dashboard;

@SuppressWarnings("deprecation")
public class TestCase5 {

		//TestCase5: Verify clothing & accessories in product dropdown and click on sign out button
		
		WebDriver driver;
		
		@Test(priority=0)
		public void intialize()
		{
		System.setProperty("WebDriver.Chrome.Driver", "C:\\Selenium Temp\\ChromeDriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("https://www.amazon.in/");
		}
		@Test(priority=1)
		public void SignIn()
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
		public void verify()
		{
		//Method to call Search_Dashboard
		Search_Dashboard search_dashboard = new Search_Dashboard(driver);
		search_dashboard.verifyProduct();
		}
		@Test(priority=3)
		public void SignOut()
		{
		//Method to call Dashboard
		Dashboard dashboard = new Dashboard(driver);
		dashboard.moveToSignout();
		//Method to call LogoutPage
		LogoutPage logoutpage = new LogoutPage(driver);
		logoutpage.button();
		}
	}

