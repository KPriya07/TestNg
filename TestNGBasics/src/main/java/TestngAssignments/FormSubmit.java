package TestngAssignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FormSubmit {
	WebDriver driver = new ChromeDriver();

	@BeforeMethod
	public void browserlaunch() {
		driver.manage().window().maximize();
		WebDriverManager.chromedriver().setup();
		driver.get("https://selenium.obsqurazone.com/ajax-form-submit.php");
	}

	@Test
	public void verifyinputfields() {
		WebElement subject = driver.findElement(By.xpath("//input[@id='subject']"));
		subject.sendKeys("Automation Testing");
		WebElement description = driver.findElement(By.xpath("//textarea[@id='description']"));
		description.sendKeys("Selenium and TestNG basics in Automation");
		WebElement button = driver.findElement(By.xpath("//input[@class='btn btn-primary']"));
		button.click();
		WebElement buttonstatus = driver.findElement(By.xpath("//div[@id='message-one']"));

		Boolean status = buttonstatus.isDisplayed();
		// Assert.assertTrue(status);
		System.out.println(status);

	}
}
