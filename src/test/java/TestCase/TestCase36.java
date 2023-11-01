package TestCase;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

import Pages.Checkout_Dashboard;
import Pages.LoginPage;
import Pages.ProductFilter_Dashboard;
import Pages.Product_Dashboard;
import Pages.Search_Dashboard;

@SuppressWarnings("deprecation")

public class TestCase36 {

	//TestCase36: Verify cash on delivery payment and click on address button
	
	WebDriver driver;
	
	@Test(priority=0)  
	public void login()
	{
	System.setProperty("WebDriver.Edge.Driver", "C:\\Selenium Temp\\EdgeDriver\\msedgedriver.exe");
	driver = new EdgeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);	
	driver.get("https://www.amazon.in/");
	//Method to call LoginPage
	LoginPage loginpage = new LoginPage(driver);
	loginpage.move();
	loginpage.signin();
	loginpage.mobilenumber("1234567891");
	loginpage.continueBtn();
	loginpage.loginPassword("abc");
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
	public void payment() throws InterruptedException
	{
		//Method to call Checkout_Dashboard
		Checkout_Dashboard checkout_Dashboard = new Checkout_Dashboard(driver);
		checkout_Dashboard.checkoutLocation();
		checkout_Dashboard.selectCountry();
		checkout_Dashboard.name("Pathange Gaurav");
		checkout_Dashboard.enterNumber("8919876100");
		checkout_Dashboard.enterPincode("500014");
		checkout_Dashboard.enterArea("B-509, Sri Gajanana Homes, Kompally, Hyderabad");
		checkout_Dashboard.enterArea2("Road no5, Ashwini Colony, Sri Gajanana Homes, Kompally Hyderabad");
		checkout_Dashboard.enterCity("Hyderabad");
		checkout_Dashboard.selectState();
		checkout_Dashboard.addressBtn();
		checkout_Dashboard.selectCashOnDelivery();
		checkout_Dashboard.scroll();
		checkout_Dashboard.paymentBtn();	
	}		
}
