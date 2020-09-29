package resources;

import java.io.IOException;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Cricbuzz extends Base{
	
	WebDriver driver;
	Logger logFile;
	
	@BeforeTest
	public void init() throws IOException
	{
		this.driver = initializeDriver();
		this.logFile = super.logFile;
	}
	
	@Test
	public void getScore()
	{
		driver.get("https://www.cricbuzz.com");
		driver.manage().window().maximize();
	}

}
