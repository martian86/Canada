package resources;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.CricketObject;

public class CricBuzzTest extends Base {
	
	WebDriver driver;
	
	@BeforeTest
	public void init() throws IOException
	{
		this.driver = initializeDriver();
	}
	
	
	@Test
	public void testLiveScore()
	{
		driver.get("https://cricbuzz.com/");
		driver.manage().window().maximize();
		CricketObject cric = new CricketObject(driver);
		cric.getSchedule().click();
	}

}
