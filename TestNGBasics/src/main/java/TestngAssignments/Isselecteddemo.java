package TestngAssignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Isselecteddemo {
	WebDriver driver = new ChromeDriver();

	@BeforeMethod
	public void browserlaunch() {
		driver.manage().window().maximize();
		WebDriverManager.chromedriver().setup();
		driver.get("https://selenium.obsqurazone.com/check-box-demo.php ");
	}

	@Test
	public void verifycheckboxselected() {
		WebElement checkbox = driver.findElement(By.xpath("//input[@id='gridCheck']"));
		checkbox.click();
		Boolean status = checkbox.isSelected();
		// Assert.assertTrue(status);
		System.out.println(status);

	}
}
