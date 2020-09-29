package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CricketObject {
	
	private WebDriver driver;
	private By schedule = By.xpath("//a[@title='Live Cricket Score']/following-sibling::a[1]");
	
	public CricketObject(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public WebElement getSchedule()
	{
		return driver.findElement(schedule);
	}

}
