package TestCase;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import Pages.Dashboard;
import Pages.LoginPage;
import Pages.LogoutPage;
import Pages.ProductFilter_Dashboard;
import Pages.Search_Dashboard;

@SuppressWarnings("deprecation")
public class TestCase12 {

	//TestCase12: Verify product filter and click on sign out 
	 
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
	public void SignUp()
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
	public void serach()
	{
	//Method to call Search_Dashboard
	Search_Dashboard search_dashboard = new Search_Dashboard(driver);
	search_dashboard.verifyProduct();		
	search_dashboard.search("polo t shirt");
	search_dashboard.selectProduct();
	}
	@Test(priority=3)
	public void verify() throws IOException, InterruptedException
	{
		//Method to call ProductFilter_Dashboard
		ProductFilter_Dashboard productfilter_dashboard = new ProductFilter_Dashboard(driver);
		productfilter_dashboard.Delivery2();
		productfilter_dashboard.clothing();
		productfilter_dashboard.review();
		productfilter_dashboard.selectBrand();
		productfilter_dashboard.BrandLink();
		productfilter_dashboard.selectDiscount();
		productfilter_dashboard.selectAmazonBrand();
		productfilter_dashboard.selectSize();
		productfilter_dashboard.select_AmazonDelivery();
		productfilter_dashboard.productLength();
		productfilter_dashboard.productType();
		productfilter_dashboard.selectMaterial();
		productfilter_dashboard.selectOccasion(); 
		productfilter_dashboard.VerifyOccasionLink();
		productfilter_dashboard.productPattern();
		productfilter_dashboard.productClosure();
		productfilter_dashboard.verifyProductFeature();
		productfilter_dashboard.selectDescription();  
		productfilter_dashboard.selectProductStock();   
	}
	@Test(priority=4)
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
