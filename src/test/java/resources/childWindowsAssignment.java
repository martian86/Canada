package resources;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.NewWindow;
import pageObjects.NewWindowPageObject;
import pageObjects.OpeningANewWindow;
public class childWindowsAssignment extends Base {
	
public WebDriver driver;
	
	@BeforeTest
	public void init() throws IOException
	{
		this.driver = initializeDriver();
	}
	
	@Test
	public void childWindows()
	{
		driver.get("https://the-internet.herokuapp.com/");
		driver.manage().window().maximize();
		
		NewWindowPageObject np = new NewWindowPageObject(driver);
		
		OpeningANewWindow op = np.getNewWindow();
		System.out.println(op.getPageText().getText());
		
		NewWindow nw = op.getClickHere();
		Set<String>str =  driver.getWindowHandles();
		Iterator ite = str.iterator();
		String windowNames[] = new String[str.size()];
		
		int i=0;
			while(ite.hasNext())
			{
				windowNames[i] = (String) ite.next();
				i++;
			}
			
		
		driver.switchTo().window(windowNames[1]);
		System.out.println(nw.getNewWindowText().getText());
		driver.switchTo().window(windowNames[0]);
		System.out.println(op.getPageText().getText());
		
	}
	
	

}
