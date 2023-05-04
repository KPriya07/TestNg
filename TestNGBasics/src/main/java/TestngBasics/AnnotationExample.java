package TestngBasics;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AnnotationExample {

	@BeforeSuite

	public void showbeforesuit() {

		System.out.println("Inside Before suit");
	}

	@BeforeTest

	public void showbeforetest() {

		System.out.println("Inside Before test");
	}

	@BeforeClass

	public void showbeforeclass() {

		System.out.println("Inside Before class");
	}

	@BeforeMethod

	public void showbeforemethod() {

		System.out.println("Inside Before method");
	}

	@Test

	public void testcase1() {

		System.out.println("Inside testcase");
	}

	@Test

	public void testcase2() {

		System.out.println("Inside testcase2");
	}

	@Test

	public void testcase3() {

		System.out.println("Inside testcase3");
	}

	@AfterMethod

	public void showaftermethod() {

		System.out.println("Inside after method");
	}

	@AfterClass

	public void showafterclass() {

		System.out.println("Inside after class");
	}

	@AfterTest

	public void showaftertest() {

		System.out.println("Inside after test");
	}

	@AfterSuite

	public void showaftersuite() {

		System.out.println("Inside after suite");
	}

}
