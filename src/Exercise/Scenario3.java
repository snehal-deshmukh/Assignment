package Exercise;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Scenario3 {
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "E://MySele2021//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		String Url = "https://in.yahoo.com/";
		driver.manage().window().maximize();

		driver.get(Url);
		Thread.sleep(2000L);
		// verify the Trending Now
		if (driver.getPageSource().contains("Trending Now")) {
			System.out.println("Trending Now is present");
		} else {
			System.out.println("Trending Now is absent");
		}
		// Limiting webdriver
		// scope

		WebElement headerdriver = driver.findElement(By.xpath("//div[@class='trending-container Mb(24px)']"));// using
																												// relative
																												// x-path
		System.out.println(headerdriver.findElements(By.tagName("a")).size());//total no.of links
		// System.out.println(headerdriver.getText());

		for (int i = 0; i < headerdriver.findElements(By.tagName("a")).size(); i++) {

			String clickonlinkTab = Keys.chord(Keys.CONTROL, Keys.ENTER);

			headerdriver.findElements(By.tagName("a")).get(i).sendKeys(clickonlinkTab);
			Thread.sleep(5000L);

		} // opens all the tabs
		Set<String> abc = driver.getWindowHandles();
		Iterator<String> it = abc.iterator();

		while (it.hasNext()) {

			driver.switchTo().window(it.next());// Navigate to each link
			System.out.println(driver.getTitle());

		}
		driver.navigate().to(Url);
		driver.findElement(By.xpath("/html/body/header/div[2]/div/div/div/div/div[4]/div/div/ul/li[2]")).click();// using
																													// absolute
																													// x-path
		WebElement A = driver.findElement(By.id("leadRegion-1-Rmp-Proxy"));// Get the all content of cases overview
		System.out.println("Text content: " + A.getText());
		driver.quit();// Exit the browser

	}

}
