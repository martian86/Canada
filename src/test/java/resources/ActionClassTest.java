package resources;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.ActionsObject;

public class ActionClassTest extends Base{
	
	public WebDriver driver;
	
	@BeforeTest
	public void init() throws IOException
	{
		this.driver=initializeDriver();
	}
	
	
	@Test
	public void testAction()
	{
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		
		ActionsObject obj = new ActionsObject(driver);
		
		Actions act = new Actions(driver);
		act.moveToElement(obj.getSearchBox()).click().keyDown(Keys.LEFT_SHIFT).sendKeys("induction cooktop").build().perform();
		obj.getGoButton().click();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		act.moveToElement(obj.signIN()).build().perform();
		
		act.moveToElement(obj.clickSignIN()).click().build().perform();
		
		
		
		
	}

}
