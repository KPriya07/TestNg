package TestngAssignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment1 {
	WebDriver driver = new ChromeDriver();

	@BeforeMethod
	public void browserlaunch() {
		driver.manage().window().maximize();
		WebDriverManager.chromedriver().setup();
		driver.get("https://selenium.obsqurazone.com/javascript-alert.php");
	}

	@Test
	public void verifybuttonclick() {
		WebElement clickmebutton = driver.findElement(By.xpath("//button[@class='btn btn-success']"));
		clickmebutton.click();
		String AlertText = driver.switchTo().alert().getText();
		System.out.println(AlertText);
		driver.switchTo().alert().accept();
	}

}
