package TestngAssignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TableAssertionDemo {
	WebDriver driver = new ChromeDriver();
	SoftAssert softassert = new SoftAssert();

	@BeforeMethod
	public void browserlaunch() {
		driver.manage().window().maximize();
		WebDriverManager.chromedriver().setup();
		driver.get("https://selenium.obsqurazone.com/table-pagination.php");
	}

	@Test
	public void verifysoftassert() {
		WebElement tableheader = driver.findElement(By.xpath("//tr[@role='row']"));
		String[] expectedtext = { "Name", "Position", "Office", "Age", "Start date", "Salary" };
		String actualheadertext = tableheader.getText();
		System.out.println(actualheadertext);
		softassert.assertEquals(actualheadertext, expectedtext);
	}

	@Test
	public void verifyhardassert() {
		WebElement name = driver.findElement(By.xpath("//tr[4]//td[1]"));
		String expectedtext = "Cedric Kelly";
		String actualheadertext = name.getText();
		WebElement office = driver.findElement(By.xpath("//tr[4]//td[3]"));
		String expectedofficetext = "Edinburgh";
		String actualofficetext = office.getText();
		Assert.assertEquals(actualheadertext, expectedtext, actualofficetext);
		Assert.assertEquals(actualofficetext, expectedofficetext);
	}
}
