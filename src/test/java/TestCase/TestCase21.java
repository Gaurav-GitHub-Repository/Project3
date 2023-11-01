package TestCase;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

import Pages.Checkout_Dashboard;
import Pages.Dashboard;
import Pages.LoginPage;
import Pages.LogoutPage;
import Pages.ProductFilter_Dashboard;
import Pages.Product_Dashboard;
import Pages.Search_Dashboard;

@SuppressWarnings("deprecation")
public class TestCase21 {

	//TestCase21: Verify homepage page in microsoft edge and click on sign out button
	
	WebDriver driver;
	
	@Test(priority=0)
	public void intialize()
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
