package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ActionsObject {
	
	private WebDriver driver;
	private By searchBox = By.id("twotabsearchtextbox");
	private By searchBtn = By.cssSelector("input[value='Go']");
	private By signIN = By.cssSelector("a[data-nav-role='signin']");
	private By signINbtn = By.className("nav-action-inner");
	
	public ActionsObject(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public WebElement getSearchBox()
	{
		return driver.findElement(searchBox);
	}
	
	public WebElement getGoButton()
	{
		return driver.findElement(searchBtn);
	}
	
	public WebElement signIN()
	{
		return driver.findElement(signIN);
	}
	
	public WebElement clickSignIN()
	{
		return driver.findElement(signINbtn);
	}


}
