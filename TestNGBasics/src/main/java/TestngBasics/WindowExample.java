package TestngBasics;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowExample {
	WebDriver driver = new ChromeDriver();
	SoftAssert softassert = new SoftAssert();

	@BeforeMethod
	public void browserlaunch() {
		driver.manage().window().maximize();
		WebDriverManager.chromedriver().setup();
		driver.get("https://the-internet.herokuapp.com/windows");
	}

	@Test
	public void verifywindow() {
		WebElement clickherelink = driver.findElement(By.xpath("//a[text()='Click Here']"));
		String parentwindow = driver.getWindowHandle();// return type is set for this method
		clickherelink.click();
		Set<String> windows = driver.getWindowHandles();// find the values of all the current open windows
		System.out.println(windows.size());
		System.out.println(parentwindow);
		Iterator<String> itr = windows.iterator();
		while (itr.hasNext()) {
			String windowid = itr.next();
			if (!parentwindow.equals(windowid)) {
				driver.switchTo().window(windowid);
			}
		}

		WebElement newwindowtext = driver.findElement(By.xpath("//h3[text()='New Window']"));
		System.out.println(newwindowtext.getText());
		clickherelink.click();
		driver.switchTo().window(parentwindow);
	}

}
