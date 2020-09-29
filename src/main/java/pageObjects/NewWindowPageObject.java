package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NewWindowPageObject {
	
	private WebDriver driver;
	private By multWindow = By.linkText("Multiple Windows");
	
	public NewWindowPageObject(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public OpeningANewWindow getNewWindow()
	{
		OpeningANewWindow op = new OpeningANewWindow(driver);
		driver.findElement(multWindow).click();
		return op;
		
		
	}

}
