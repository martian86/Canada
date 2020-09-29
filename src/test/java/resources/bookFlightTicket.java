package resources;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.HomePageObjects;

public class bookFlightTicket extends Base {
	WebDriver driver;
	Logger logFile;
	
	@BeforeTest
	public void init() throws IOException
	{
		this.driver = initializeDriver();
		this.logFile = super.logFile;
	}
	
	@Test(dataProvider = "provideData")
	public void bookTicket(String src, String dest) throws IOException
	{
		//this.driver = initializeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.spicejet.com/");
		System.out.println("Site opened successfully");
		logFile.info("Site opened successfully!");
		HomePageObjects homePage = new HomePageObjects(driver);
		homePage.getSourceCityDropDown().click();
		List <WebElement> source = homePage.getSourceCityName();
		for(int i=0;i<source.size();i++)
		{
			if(source.get(i).getText().contains(src))
			{
				source.get(i).click();
			}
		}
		
		
		List <WebElement> destination = homePage.getDestCityName();
		for(int i=0;i<destination.size();i++)
		{
			if(destination.get(i).getText().contains(dest))
			{
				destination.get(i).click();
			}
		}
		
		while(!(homePage.getMonth().getText().equalsIgnoreCase("December")))
		{
			homePage.clickOnNextMonth().click();
		}
		
		homePage.getStartDates().get(21).click();
		homePage.getNoOfPassengers().click();
		homePage.getNoOfAdults().selectByValue("5");
		homePage.getNoOfChildren().selectByValue("2");
		//Assert.assertTrue(false);
		homePage.searchFlights().click();
		
	}
	
	@DataProvider
	public String[][] provideData() throws SQLException
	{
		String connectionURL = "jdbc:mysql://localhost:3306/demo";
		Connection con = DriverManager.getConnection(connectionURL, "root", "admin");
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM CITIES;");
		
		int rows=0;
		while(rs.next())
		{
			rows++;
		}
		int cols = rs.getMetaData().getColumnCount();
		
		rs.first();
		
		String [][]str = new String[rows][cols];
		
		
			for(int i=1;i<=rows;i++)
			{
				for(int j=1;j<=cols;j++)
				{
					str[i-1][j-1] = rs.getString(j);
				}
				rs.next();
			}
		
		con.close();
		return str;
		
		
		
	}

}
