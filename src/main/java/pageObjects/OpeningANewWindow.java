package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OpeningANewWindow {
	
	private WebDriver driver;
	private By clickHere = By.linkText("Click Here");
	private By text = By.cssSelector("div[id='content'] div h3");
	
	
	public OpeningANewWindow(WebDriver driver)
	{
		this.driver = driver;
	}

	public NewWindow getClickHere()
	{
		NewWindow nw = new NewWindow(driver);
		driver.findElement(clickHere).click();
		return nw;
	}
	
	public WebElement getPageText()
	{
		return driver.findElement(text);
	}
	
}
