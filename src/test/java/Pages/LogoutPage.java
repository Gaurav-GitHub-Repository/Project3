package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LogoutPage {

	WebDriver driver;
	
	public LogoutPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	//Locator to click on sign out
	By SignOut = By.xpath("//span[text()='Sign Out']");
	
	//Method to click on Sign Out
	public void button()
	{
		driver.findElement(SignOut).click();
	}
}
