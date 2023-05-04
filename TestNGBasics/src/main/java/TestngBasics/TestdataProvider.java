package TestngBasics;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestdataProvider {
	WebDriver driver = new ChromeDriver();

	@BeforeMethod
	public void browserlaunch() {
		driver.manage().window().maximize();
		WebDriverManager.chromedriver().setup();
		driver.get("https://www.amazon.in/");
	}

	@Test(dataProvider = "amazontestdata", dataProviderClass = DataProviders.class)
	public void verifysearchitem(String product) {

		WebElement searchfield = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
		WebElement searchbutton = driver.findElement(By.xpath("//input[@id='nav-search-submit-button']"));
		searchfield.sendKeys(product);
		searchbutton.click();
		System.out.println(product);
	}

	@Test(dataProvider = "facebooktestdata", dataProviderClass = DataProviders.class)
	public void verifylogin(String username, String pass) {
		driver.get("https://www.facebook.com/");
		WebElement email = driver.findElement(By.xpath("//input[@id='email']"));
		WebElement password = driver.findElement(By.xpath("//input[@id='pass']"));
		email.sendKeys(username);
		password.sendKeys(pass);

	}
}
