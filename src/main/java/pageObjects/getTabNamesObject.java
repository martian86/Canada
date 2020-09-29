/**
 * 
 */
package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * @author aniru
 *
 */
public class getTabNamesObject {
	
	private WebDriver driver;
	private By footerLinks = By.cssSelector("div#gf-BIG a");
	private By footer = By.cssSelector("div#gf-BIG");
	private WebElement newFooter;
	private By discountCoupon = By.linkText("Discount Coupons");
	private By restAPI = By.linkText("REST API");
	private By soapUI = By.linkText("SoapUI");
	private By appium = By.linkText("Appium");
	private By JMeter = By.linkText("JMeter");
	
	public getTabNamesObject(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public getTabNamesObject(WebElement newFooter)
	{
		this.newFooter = newFooter;
	}
	
	public List<WebElement> getFooterLinks()
	{
		return driver.findElements(footerLinks);
	}
	
	public WebElement getFooter()
	{
		return driver.findElement(footer);
	}
	
	public WebElement getDiscountCouponTab()
	{
		return  newFooter.findElement(discountCoupon);
	}
	
	public WebElement getRestAPITab()
	{
		return  newFooter.findElement(restAPI);
	}
	
	public WebElement getSoapUITab()
	{
		return  newFooter.findElement(soapUI);
	}
	
	public WebElement getAppiumTab()
	{
		return  newFooter.findElement(appium);
	}
	
	public WebElement getJMeterTab()
	{
		return  newFooter.findElement(JMeter);
	}
	

}
