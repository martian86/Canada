package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class HomePageObjects {
	
	WebDriver driver;
	private By sourceCityDrpDown = By.xpath("//input[@name='ctl00_mainContent_ddl_originStation1_CTXT']");
	//private By sourceCityName = By.xpath("//a[@value='BOM']");
	private By sourceCityName = By.xpath("//div[@class='dropdownDiv']/ul/li/a");
	//private By destCityName = By.xpath("(//a[@value='PNQ'])[2]");
	//private By destCityName = By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='PNQ']");
	private By destCityName = By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a");
	private By month = By.xpath("//div[@class='ui-datepicker-title']/span");
	private By startDates = By.className("ui-state-default");
	private By navigateToNextMonth = By.cssSelector("a.ui-datepicker-next.ui-corner-all");
	private By noOfPassengers = By.id("divpaxinfo");
	private By drpDownAdult = By.id("ctl00_mainContent_ddl_Adult");
	private By drpDownChild = By.id("ctl00_mainContent_ddl_Child");
	private By searchFlights = By.xpath("//input[@value='Search']");
	
	
	
	public HomePageObjects(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public WebElement getSourceCityDropDown()
	{
		return driver.findElement(sourceCityDrpDown);
	}
	
	public List<WebElement> getSourceCityName()
	{
		return driver.findElements(sourceCityName);
	}
	
	public List<WebElement> getDestCityName()
	{
		return driver.findElements(destCityName);
	}
	
	
	public WebElement getMonth()
	{
		return driver.findElement(month);
	}
	
	public WebElement clickOnNextMonth()
	{
		return driver.findElement(navigateToNextMonth);
	}
	
	public List <WebElement> getStartDates()
	{
		return driver.findElements(startDates);
	}
	
	public WebElement getNoOfPassengers()
	{
		return driver.findElement(noOfPassengers);
	}
	
	public Select getNoOfAdults()
	{
		Select adults = new Select(driver.findElement(drpDownAdult));
		return adults;
	}
	
	public Select getNoOfChildren()
	{
		Select child = new Select(driver.findElement(drpDownChild));
		return child;
	}
	
	public WebElement searchFlights()
	{
		return driver.findElement(searchFlights);
	}
	
}
