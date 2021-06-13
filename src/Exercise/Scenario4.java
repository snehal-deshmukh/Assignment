package Exercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Scenario4 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "E://MySele2021//chromedriver.exe");// sets the system property
		WebDriver driver = new ChromeDriver(); //open the browser
		String Url = "https://www.myntra.com/";
		driver.manage().window().maximize();//maximize the window
		driver.get(Url);//fetch the url
		Actions act = new Actions(driver);
		WebElement catagoies = driver.findElement(By.xpath("//a[contains(text(),'Women')]"));
		act.moveToElement(catagoies).build().perform();
		driver.findElement(By.xpath("//a[contains(text(),'Dress Materials')]")).click();// click on the product type

		WebElement sortBy = driver.findElement(By.cssSelector("div.sort-sortBy"));// sort
		act.moveToElement(sortBy).build().perform();
		sortBy.findElement(By.xpath("//label[contains(text(), \"What's New\")]")).click();// click on the what's new

		WebElement List = driver.findElement(By.xpath("//*[@class='discount-list']"));// discount checkbox
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[contains(text(),'50% and above')]")));
		// click on the discount checkbox as soon as the discount checkbox is visible
		List.findElement(By.xpath("//label[contains(text(),'50% and above')]")).click();

		WebElement brandList = driver.findElement(By.xpath("//*[@class=\"brand-list\"]"));// brand checkbox
		WebDriverWait wait1 = new WebDriverWait(driver, 30);
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label")));
		// click on the brand checkbox as soon as the brand checkbox is visible
		WebElement brandList2 = driver.findElement(By.xpath("//label"));
		act.moveToElement(brandList2).click().build().perform();

		WebDriverWait wait2 = new WebDriverWait(driver, 30);
		wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@class='results-base']/li[2]")));// click
																													// on
																													// product
		driver.findElement(By.xpath("//ul[@class='results-base']/li[2]")).click();

		ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs2.get(1));// window handles

		WebDriverWait wait3 = new WebDriverWait(driver, 30);
		wait3.until(ExpectedConditions.visibilityOfElementLocated((By.xpath("//div[contains(text(),'ADD TO BAG')]"))));
		driver.findElement(By.xpath("//div[contains(text(),'ADD TO BAG')]")).click();// add to bag

		WebDriverWait wait4 = new WebDriverWait(driver, 30);
		wait4.until(ExpectedConditions.visibilityOfElementLocated((By.xpath("//span[contains(text(),'GO TO BAG')]"))));
		driver.findElement(By.xpath("//span[contains(text(),'GO TO BAG')]")).click();// go to cart

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");

		WebDriverWait wait5 = new WebDriverWait(driver, 30);
		wait5.until(ExpectedConditions
				.visibilityOfElementLocated((By.xpath("//div[contains(text(),'Add More From Wishlist')]"))));
		driver.findElement(By.xpath("//div[contains(text(),'Add More From Wishlist')]")).click();// add to wishlist
		driver.quit();
	}

}
