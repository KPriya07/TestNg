package TestngAssignments;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SoftAssert {

	WebDriver driver = new ChromeDriver();
	int i=0;
	
	@BeforeMethod
	public void browserlaunch() {
		driver.manage().window().maximize();
		WebDriverManager.chromedriver().setup();
		driver.get("https://selenium.obsqurazone.com/bootstrap-dual-list.php");
	}

	@Test
	public void verifyoptionstext() {
		
		List<WebElement> options=driver.findElements(By.xpath("//select[@id='bootstrap-duallistbox-nonselected-list_duallistbox_demo1[]']"));
		int s=options.size();
		for(i=0;i<s;i++) {
			String text=options.get(i).getText();
			System.out.println(text);
		}
		

	}
}
