package resources;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.getTabNamesObject;

public class GetTabNames extends Base {
	
	public WebDriver driver;
	
	
	@BeforeTest
	public void init() throws IOException
	{
		this.driver = initializeDriver();
	}
	
	@Test
	public void getTabNames()
	{
		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		
		getTabNamesObject getFooter = new getTabNamesObject(driver);
		System.out.println("The number of hyperlinks in the footer section are: "+ getFooter.getFooterLinks().size());
		
		WebElement newFooter = getFooter.getFooter();
		getTabNamesObject newFooterObject = new getTabNamesObject(newFooter);
		newFooterObject.getDiscountCouponTab().sendKeys(Keys.LEFT_CONTROL,Keys.ENTER);
		String keysSeq = Keys.chord(Keys.LEFT_CONTROL,Keys.ENTER);
		///System.out.println(keysSeq);
		newFooterObject.getRestAPITab().sendKeys(keysSeq);
		newFooterObject.getSoapUITab().sendKeys(Keys.LEFT_CONTROL,Keys.ENTER);
		newFooterObject.getAppiumTab().sendKeys(Keys.LEFT_CONTROL,Keys.ENTER);
		newFooterObject.getJMeterTab().sendKeys(Keys.LEFT_CONTROL,Keys.ENTER);
		
		Set<String>childWindows = driver.getWindowHandles();
		Iterator ite = childWindows.iterator();
		
		

		
		System.out.println("The parent window title is: "+driver.getTitle());
		ite.next();
		for(int i=1;i<childWindows.size();i++)
		{
			driver.switchTo().window((String) ite.next());
			System.out.println("The title for tab no "+i+" is: "+driver.getTitle());
		}
	}

}
