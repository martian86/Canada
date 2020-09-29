package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Base {
	
	public WebDriver driver;
	public Logger logFile;
	
	public WebDriver initializeDriver() throws IOException
	{
		String basePath = System.getProperty("user.dir");
		logFile = LogManager.getLogger(Base.class.getName());
		FileInputStream fis = new FileInputStream(new File(basePath + "\\src\\main\\java\\resources\\props.properties"));
		Properties props = new Properties();
		props.load(fis);
		
		//String browser = props.getProperty("browser");
		String browser = System.getProperty("browser");
		if (browser.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\aniru\\Documents\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if (browser.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\aniru\\Documents\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		
		else if (browser.equalsIgnoreCase("IE"))
		{
			System.setProperty("webdriver.ie.driver", "C:\\Users\\aniru\\Documents\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
		
		return driver;
		
	}
	
	public static String getScreenshots(WebDriver driver, String failedTest) throws IOException
	{
		String basePath = System.getProperty("user.dir")+"\\Screenshots\\"+failedTest;
		TakesScreenshot ts = ((TakesScreenshot)driver);
		File fil = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(fil, new File(basePath+".jpg"));
		return basePath+".jpg";
		
	}
	

	
	public static ExtentReports getReports()
	{
		ExtentReports extent;
		String reportPath = System.getProperty("user.dir")+"\\Reports\\report.html";
				
		ExtentSparkReporter reports = new ExtentSparkReporter(reportPath);
		reports.config().setReportName("UAT Testing");
		reports.config().setDocumentTitle("Test Results");
		System.out.println("I am in getReports method");
		System.out.println(reports.toString());
		extent = new ExtentReports();
		extent.attachReporter(reports);
		extent.setSystemInfo("Tester", "Aniruddha Parlikar");
		return extent;
		
		
		
	}

}
