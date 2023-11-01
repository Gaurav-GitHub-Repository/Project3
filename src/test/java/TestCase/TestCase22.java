package TestCase;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

import Pages.Dashboard;
import Pages.LoginPage;
import Pages.LogoutPage;

@SuppressWarnings("deprecation")
public class TestCase22 {

	//TestCase22: Verify amazon logo in mircosoft edge browser and click on sign out button

	WebDriver driver;

	@Test(priority=0)
	public void initialize()
	{
	System.setProperty("WebDriver.Edge.Driver", "C:\\Selenium Temp\\EdgeDriver\\msedgedriver.exe");
	driver = new EdgeDriver();
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
	//Method to call DashboardPage
	Dashboard dashboard = new Dashboard(driver);
	dashboard.verifyLogo();
	}
	@Test(priority=3)
	public void SignOut()
	{
	Dashboard dashboard = new Dashboard(driver);
	dashboard.moveToSignout();
	//Method to call LogoutPage
	LogoutPage logoutpage = new LogoutPage(driver);
	logoutpage.button();
	}	
}
