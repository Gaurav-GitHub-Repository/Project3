package TestCase;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import Pages.Dashboard;
import Pages.LoginPage;
import Pages.LogoutPage;

@SuppressWarnings("deprecation")
public class TestCase3 {

		//TestCase3: Verify amazon homepage page and click on sign out button

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
		public void SignOut() throws InterruptedException
		{
		//Method to call Dashboard
		Dashboard dashboard = new Dashboard(driver);
		dashboard.verifyPage();
		dashboard.moveToSignout();
		//Method to call LogoutPage
		LogoutPage logoutpage = new LogoutPage(driver);
		logoutpage.button();
	}
}
