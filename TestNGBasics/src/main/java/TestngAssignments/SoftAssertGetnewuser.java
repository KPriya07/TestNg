package TestngAssignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SoftAssertGetnewuser {
	WebDriver driver = new ChromeDriver();

	@BeforeMethod
	public void browserlaunch() {
		driver.manage().window().maximize();
		WebDriverManager.chromedriver().setup();
		driver.get("https://selenium.obsqurazone.com/dynamic-load.php");
		
	}

	@Test
	public void verifynewuser() {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement getnewuserbutton=driver.findElement(By.xpath("//button[@id='save']"));
		wait.until(ExpectedConditions.elementToBeClickable(getnewuserbutton));
		String expectedtext ="Get New User";
		String actualtext = getnewuserbutton.getText();
		System.out.println(actualtext);
		getnewuserbutton.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h5[@class='card-title']")));
		WebElement name=driver.findElement(By.xpath("//h5[@class='card-title']"));
		String txtname=name.getText();
		System.out.println(txtname);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@class='card-text text-center p-3']")));
		WebElement email=driver.findElement(By.xpath("//p[@class='card-text text-center p-3']"));
		String txtemail=email.getText();
		System.out.println(txtemail);
		Assert.assertTrue(true);
		Assert.assertEquals(actualtext, expectedtext);

	}
}
