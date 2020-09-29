package resources;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.sortPageObject;

public class sortTableData extends Base{
	
	public WebDriver driver;
	
	@BeforeTest
	public void init() throws IOException
	{
		this.driver = initializeDriver();
	}
	
	@Test
	public void sortData()
	{
		
		driver.get("https://www.rahulshettyacademy.com/seleniumPractise/#/offers");
		driver.manage().window().maximize();
		sortPageObject sort = new sortPageObject(driver);
		
		sort.getPageSize().selectByValue("20");
		
		ArrayList <String> originalList = new ArrayList <String>();
		ArrayList <String> sortedList = new ArrayList<String>();
		for(int i=0;i<sort.getTableData().size();i++)
		{
			originalList.add(sort.getTableData().get(i).getText());
		}
		
		System.out.println("The original list is: "+originalList);
		Collections.sort(originalList);
		System.out.println("The expected sorted list is: "+originalList);
		
		//sort.getTableHeader().click();
		sort.getTableHeader().click();
		for(int i=0;i<sort.getTableData().size();i++)
		{
			sortedList.add(sort.getTableData().get(i).getText());
		}
		
		System.out.println("The actual sorted list is: "+sortedList);
		Assert.assertTrue(originalList.equals(sortedList));
		
		
		
	}

}
