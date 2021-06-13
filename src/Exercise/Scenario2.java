package Exercise;

import java.util.Iterator;
import java.util.Set;

import javax.print.attribute.standard.NumberOfDocuments;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Scenario2 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "E://MySele2021//chromedriver.exe");//sets the system property
		WebDriver driver = new ChromeDriver();
		String Url = "https://in.yahoo.com/";
		driver.manage().window().maximize();

		driver.get(Url);//fetch the URL
		Thread.sleep(2000L);
		// verify the Trending Now
		if (driver.getPageSource().contains("Trending Now")) {
			System.out.println("Trending Now is present");
		} else {
			System.out.println("Trending Now is absent");// verify the Trending Now
		}
		WebElement headerDriver = driver.findElement(By.cssSelector("div.trending-container"));// Limiting webdriver
																								// scope

		int b = headerDriver.findElements(By.tagName("a")).size();// total no.of links
		System.out.println("Total Number of Links is=" + b);
		// System.out.println(headerdriver.getText());

		for (int i = 0; i < headerDriver.findElements(By.tagName("a")).size(); i++) {

			String clickonlinkTab = Keys.chord(Keys.CONTROL, Keys.ENTER);

			headerDriver.findElements(By.tagName("a")).get(i).sendKeys(clickonlinkTab);
			Thread.sleep(5000L);

		} // open the links
		Set<String> abc = driver.getWindowHandles();
		Iterator<String> it = abc.iterator();

		while (it.hasNext()) {

			driver.switchTo().window(it.next());// Navigate to each link
			System.out.println(driver.getTitle());

		}
		driver.navigate().to(Url);
		driver.findElement(By.xpath("//a[@id='root_1']")).click();// click on Coronavirus menu bar link.
		WebElement A = driver.findElement(By.id("leadRegion-1-Rmp-Proxy"));
		System.out.println("Text content: " + A.getText());// Get the all content of cases overview
		driver.quit();// Exit the browser

	}

}
