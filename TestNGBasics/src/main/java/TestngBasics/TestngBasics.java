package TestngBasics;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestngBasics {

	WebDriver driver = new ChromeDriver();
	SoftAssert softassert = new SoftAssert();

	@BeforeMethod
	public void browserlaunch() {
		driver.manage().window().maximize();
		WebDriverManager.chromedriver().setup();
		driver.get("https://selenium.obsqurazone.com/check-box-demo.php");
	}

	@Test
	public void verifyurl() {
		String expectedurl = "https://selenium.obsqurazone.com/simple-form-demo.php";
		String actualurl = driver.getCurrentUrl();
		Assert.assertEquals(actualurl, expectedurl);
	}

	@Test
	public void verifybuttontext() {
		WebElement showmsg = driver.findElement(By.xpath("//button[@id='button-one']"));
		String expectedtext = "Show Messageone";
		String actualbuttontext = showmsg.getText();
		System.out.println(actualbuttontext);
		Assert.assertEquals(actualbuttontext, expectedtext, "test case failed");
	}

	@Test(enabled = false) // not enable the testcase
	public void checkboxdemopage() {
		WebElement checkboxpage = driver.findElement(By.xpath("//a[@href='check-box-demo.php']"));
		checkboxpage.click();
		WebElement singlecheckbox = driver.findElement(By.xpath("//input[@id='gridCheck']"));
		Boolean status = singlecheckbox.isDisplayed();
		// Assert.assertEquals(false, status);
		Assert.assertTrue(status);// verifies it is true

	}

	@Test(priority = 2, dependsOnMethods = "verifybuttontext")

	public void softassert() {
		driver.get("https://selenium.obsqurazone.com/check-box-demo.php");
		WebElement labelcheckbox = driver.findElement(By.xpath("//label[@for='gridCheck']"));
		WebElement checkboxone = driver.findElement(By.xpath("//label[@for='check-box-one']"));
		String labelcheckboxname = "one";
		String checkboxonename = "three";
		String actuallabelcheckbox = labelcheckbox.getText();
		String actualcheckbox = checkboxone.getText();
		softassert.assertEquals(actuallabelcheckbox, labelcheckboxname);
		softassert.assertEquals(actualcheckbox, checkboxonename);
		softassert.assertAll();// method which is used in soft assert to make tc fail /pass depends on the
								// testcase
	}

}
