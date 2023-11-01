package TestCase;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import Pages.Checkout_Dashboard;
import Pages.LoginPage;
import Pages.ProductFilter_Dashboard;
import Pages.Product_Dashboard;
import Pages.Search_Dashboard;

@SuppressWarnings("deprecation")
public class TestCase16 {

	//TestCase16: Verify debit card payment and retrieve error message
	
	WebDriver driver;
	
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
	search_dashboard.verifyProduct();		
	search_dashboard.search("polo t shirt");
	search_dashboard.selectProduct();
	}
	@Test(priority=2)  
	public void addProduct() throws InterruptedException
	{
	//Method to call ProductFilter_Dashboard
	ProductFilter_Dashboard productfilter_dashboard = new ProductFilter_Dashboard(driver);
	productfilter_dashboard.scroll();
	productfilter_dashboard.minPrice("1000");
	productfilter_dashboard.maxPrice("1500");
	productfilter_dashboard.go();
	productfilter_dashboard.product();
	}	          
	@Test(priority=3)
	public void addToCart() throws InterruptedException
	{
	//Method to call Product_Dashboard
	Product_Dashboard product_dashboard = new Product_Dashboard(driver);	
	product_dashboard.switchToWindow();
	product_dashboard.addToCart();		
	product_dashboard.verifyProductCart();
	product_dashboard.Go_Cart();
	product_dashboard.verifyShoppingCart();
	product_dashboard.selectQuantity();
	product_dashboard.verifyTotalPrice();
	product_dashboard.proceedBtn();	
	}	
	@Test(priority=4)
	public void payment() throws InterruptedException
	{
		//Method to call Checkout_Dashboard
		Checkout_Dashboard checkout_dashboard = new Checkout_Dashboard(driver);
		checkout_dashboard.shippingAddress();
		checkout_dashboard.Payment_Method();
		checkout_dashboard.selectDebitCardRadio();
	}
}
