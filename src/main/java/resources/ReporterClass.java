package resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ReporterClass {
	static ExtentReports extent;
	public static ExtentReports getReports()
	{
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
