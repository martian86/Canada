package resources;
import java.io.IOException;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;


public class Listeners extends Base implements ITestListener  {
	
	Logger logFile;
	WebDriver driver;
	ExtentReports extent = ReporterClass.getReports();
	//ExtentReports extent = getReports();   //used the method from the base class itself
	ThreadLocal<ExtentTest> thread = new ThreadLocal<ExtentTest>();
	String basePath;
	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("I am in Listener - onTestStart");
		
		System.out.println(extent.toString());
		
		basePath = System.getProperty("user.dir");
		String testName = result.getMethod().getMethodName();
		try {
			driver = (WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
			logFile = (Logger) result.getTestClass().getRealClass().getDeclaredField("logFile").get(result.getInstance());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		ExtentTest test = extent.createTest(testName);
		thread.set(test);
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		thread.get().log(Status.PASS, "Pass");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("I am in Listener - onTestFailure");
		String failedTest = result.getMethod().getMethodName();
		
		logFile.error("Error occurred in method "+failedTest );
		
		thread.get().log(Status.FAIL, "The method "+failedTest+"() failed!");
		try {
			thread.get().addScreenCaptureFromPath(getScreenshots(driver, failedTest));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		extent.flush();
		
	}


}
