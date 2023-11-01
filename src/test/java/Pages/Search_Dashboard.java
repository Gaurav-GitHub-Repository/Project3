package Pages;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Search_Dashboard { 

	WebDriver driver;
	
	public Search_Dashboard(WebDriver driver)
	{
		this.driver=driver;
	}
	//Locator for product dropdown
	By Product_Dropdown = By.id("searchDropdownBox");
	//Locator for Search	
	By Search = By.xpath("//input[@id='twotabsearchtextbox']");
	
	
	//Method to search product
	public void search(String value)
	{
		driver.findElement(Search).sendKeys(value);
	}
	//Method to select product
	public void selectProduct()
	{
		driver.findElement(Search).sendKeys(Keys.ENTER);
	}
	//Method to verify product dropdown
	public void verifyProduct()
	{
	  Select select = new Select(driver.findElement(Product_Dropdown));
	  select.selectByVisibleText("Clothing & Accessories");
	  List<WebElement> var = select.getOptions();
	  for(WebElement options: var)
	  {
		  if(options.getText().equals("Clothing & Accessories"))
		  {
			  System.out.println("Product dropdown is selected");
			  break;
		  }	 
	  }
	}
	
	
}
