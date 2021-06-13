package Exercise;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Scenario1 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "E://MySele2021//chromedriver.exe");//sets the system property
		WebDriver driver = new ChromeDriver();//open the browser
		driver.manage().window().maximize();//maximize the window
		driver.get("https://qatechhub.com/");//getch the url
		System.out.println(driver.getTitle());//ptint title of page
		System.out.println(driver.getCurrentUrl());//print the current URL
		Thread.sleep(2000);
		driver.navigate().to("https://www.facebook.com");// navigate th url
		driver.navigate().back();//Navigate back to the QA Tech Hub website
		System.out.println(driver.getCurrentUrl());//Print the URL of the current page.
		driver.navigate().forward();//Navigate forward.
		driver.navigate().refresh();//Reload the page.
		driver.close();//Close the Browser.

	}

}