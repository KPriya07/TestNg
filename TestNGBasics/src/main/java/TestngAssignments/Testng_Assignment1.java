package TestngAssignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Testng_Assignment1 {

	WebDriver driver = new ChromeDriver();

	@BeforeMethod
	public void browserlaunch() {
		driver.manage().window().maximize();
		WebDriverManager.chromedriver().setup();
		driver.get("https://selenium.obsqurazone.com/radio-button-demo.php");
	}

	@Test
	public void verifybuttonsdisplayed() {
		WebElement button = driver.findElement(By.xpath("//button[@id='button-one']"));
		Boolean status = button.isDisplayed();
		Assert.assertTrue(status);

	}

	@Test
	public void verifybuttonstext() {
		WebElement showtext = driver.findElement(By.xpath("//button[@id='button-one']"));
		String expectedtext = "No Text";
		String actualbuttontext = showtext.getText();
		System.out.println(actualbuttontext);
		Assert.assertEquals(actualbuttontext, expectedtext, "test case passed");
		System.out.println("Hello");
	}
}
