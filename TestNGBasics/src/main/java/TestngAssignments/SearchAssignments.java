package TestngAssignments;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SearchAssignments {
	WebDriver driver = new ChromeDriver();
	int i=0;
	
	@BeforeMethod
	public void browserlaunch() {
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebDriverManager.chromedriver().setup();
		driver.get("https://selenium.obsqurazone.com/table-sort-search.php");
	}

	@Test
	public void verifysearchname() {
		
		WebElement search = driver.findElement(By.xpath("//input[@type='search']"));
		search.sendKeys("Ashton Cox");
		WebElement searchresult = driver.findElement(By.xpath("//tr[@class='odd']"));
		String[] expectedtext = {"Ashton Cox ,Junior Technical, Author, San Francisco ,66 2009/01/12, $86,000"};
		String actualsearchtext = searchresult.getText();
		String text=searchresult.getText();
		System.out.println(text);
		Assert.assertEquals(actualsearchtext, expectedtext);
			
}
}
