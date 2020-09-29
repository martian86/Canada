package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class sortPageObject {
	
	private By tableHeader = By.xpath("//tr //th[1]");
	private By listOfElements = By.cssSelector("tr td:nth-child(1)");
	private WebDriver driver;
	private By pageSize = By.cssSelector("select[id='page-menu']");
	
	public sortPageObject(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public WebElement getTableHeader()
	{
		return driver.findElement(tableHeader);
	}
	
	public List<WebElement> getTableData()
	{
		return driver.findElements(listOfElements);
	}
	
	public Select getPageSize()
	{
		Select pageSizeValue = new Select(driver.findElement(pageSize));
		return pageSizeValue;
	}

}
