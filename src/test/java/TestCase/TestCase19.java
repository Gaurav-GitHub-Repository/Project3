package TestCase;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import Pages.Checkout_Dashboard;
import Pages.Dashboard;
import Pages.LoginPage;
import Pages.ProductFilter_Dashboard;
import Pages.Product_Dashboard;
import Pages.Search_Dashboard;

@SuppressWarnings("deprecation")
public class TestCase19 {

	WebDriver driver;

	//TestCase19: Verify shipping address in checkout and click on address button 
	
	@Test(priority=0)  
	public void login()
	{
	System.setProperty("WebDriver.Chrome.Driver", "C:\\Selenium Temp\\ChromeDriver\\chromedriver.exe");
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	driver.get("https://www.amazon.in/");	
	//Method to call LoginPage
	LoginPage loginpage = new LoginPage(driver);
	loginpage.move();
	loginpage.signin();
	loginpage.mobilenumber("6281482399");
	loginpage.continueBtn();
	loginpage.loginPassword("pathangeGaurav");
	loginpage.loginBtn();
	}
	@Test(priority=1)
	public void search()
	{
	//Method to call Search_Dashboard
	Search_Dashboard search_dashboard = new Search_Dashboard(driver);		
	search_dashboard.search("Mop for wall cleaning");
	search_dashboard.selectProduct();
	}
	@Test(priority=2)  
	public void addProduct() throws InterruptedException
	{
	//Method to call ProductFilter_Dashboard
	ProductFilter_Dashboard productfilter_dashboard = new ProductFilter_Dashboard(driver);
	productfilter_dashboard.scroll();
	//Method to call Product_Dashboard
	Product_Dashboard product_dashboard = new Product_Dashboard(driver);
	product_dashboard.selectMopProduct();
	product_dashboard.switchToWindow();
	product_dashboard.buyBtn();
	}	          
	@Test(priority=3)
	public void Payment() throws InterruptedException 
	{
		//Method to call Checkout_Dashboard 
		Checkout_Dashboard checkout_dashboard = new Checkout_Dashboard(driver);
		checkout_dashboard.checkoutLocation();
		checkout_dashboard.selectCountry();
		checkout_dashboard.name("Pathange Gaurav");
		checkout_dashboard.enterNumber("1234567891");
		checkout_dashboard.enterPincode("500014");
		checkout_dashboard.enterArea("B-509, Sri Gajanana Homes, Kompally");
		checkout_dashboard.enterArea2("B-509, Road no 5, Ashwini Colony, Sri Gajanana Homes, Kompally, Hyderabad");
		checkout_dashboard.enterCity("Hyderabad");
		checkout_dashboard.selectState();
		checkout_dashboard.addressBtn();
		checkout_dashboard.selectCashDelivery();
	}		
}
