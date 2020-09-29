package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NewWindow {
	
	private WebDriver driver;
	
	private By getNewWindowText = By.cssSelector("div[class='example'] h3");
	
	
	public NewWindow(WebDriver driver)
	{
		this.driver = driver;
	}

	public WebElement getNewWindowText()
	{
		return driver.findElement(getNewWindowText);
	}

}
