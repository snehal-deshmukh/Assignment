package Exercise;

import java.util.ArrayList;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Scenario5IE {
	public static void main(String[] args) {
	System.setProperty("webdriver.ie.driver","E://MySele2021//IEDriverServer.exe");// sets the system property
	 //set desiredcapabilites for calling ie driver
	DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
	capabilities.setCapability (InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);
	WebDriver driver = new InternetExplorerDriver(capabilities);
	
	String Url = "https://www.myntra.com/";
	driver.manage().window().maximize();
	driver.get(Url);
	Actions act = new Actions(driver);
	WebElement catagoies = driver.findElement(By.xpath("//a[contains(text(),'Women')]"));
	act.moveToElement(catagoies).build().perform();
	driver.findElement(By.xpath("//a[contains(text(),'Dress Materials')]")).click();// click on the product type
	
    WebElement sortBy = driver.findElement(By.cssSelector("div.sort-sortBy"));//sort
    act.moveToElement(sortBy).build().perform();
    sortBy.findElement(
			By.xpath("//label[contains(text(), \"What's New\")]")).click();// click on the what's new
	
	WebElement List = driver.findElement(By.xpath("//*[@class='discount-list']"));//discount checkbox
	WebDriverWait wait = new WebDriverWait(driver,30);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[contains(text(),'50% and above')]")));
	// click on the discount checkbox as soon as the discount checkbox is visible
	List.findElement(By.xpath("//label[contains(text(),'50% and above')]")).click();
	
	
	WebElement brandList = driver.findElement(By.xpath("//*[@class=\"brand-list\"]"));//brand checkbox
	WebDriverWait wait1 = new WebDriverWait(driver,30);
	wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label")));
	// click on the brand checkbox as soon as the brand checkbox is visible
	brandList.findElement(By.xpath("//label")).click();
	

	
	WebDriverWait wait2 = new WebDriverWait(driver,30);
	wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@class='results-base']/li[2]")));//click on product
	driver.findElement(By.xpath("//ul[@class='results-base']/li[2]")).click();
	
	
	ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
	driver.switchTo().window(tabs2.get(1));// window handles
	
	WebDriverWait wait3 = new WebDriverWait(driver,30);
	wait3.until(ExpectedConditions.visibilityOfElementLocated((By.xpath("//div[contains(text(),'ADD TO BAG')]"))));
	driver.findElement(By.xpath("//div[contains(text(),'ADD TO BAG')]")).click();// add to bag
	
	 
	WebDriverWait wait4 = new WebDriverWait(driver,30);
	wait4.until(ExpectedConditions.visibilityOfElementLocated((By.xpath("//span[contains(text(),'GO TO BAG')]"))));
	driver.findElement(By.xpath("//span[contains(text(),'GO TO BAG')]")).click();// go to cart 
	
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("window.scrollBy(0,500)");
	
	
	
	 
	WebDriverWait wait5 = new WebDriverWait(driver,30);
	wait5.until(ExpectedConditions.visibilityOfElementLocated((By.cssSelector("div.addToWishlist-base-wishlistText"))));
	driver.findElement(By.cssSelector("div.addToWishlist-base-wishlistText")).click();// add to wishlist 
	driver.quit();

}
}
