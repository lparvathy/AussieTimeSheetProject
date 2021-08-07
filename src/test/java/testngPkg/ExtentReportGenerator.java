package testngPkg;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import pom.AussieHomePage;
import utility.WebDriverManager;

import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class ExtentReportGenerator {

	static ExtentTest test;
	ExtentReports report;
	static WebDriver driver;

	WebDriverManager webManager = new WebDriverManager();

	@Test(priority = 18)
	public static void generateExtentReport() {

		// WebElement allTasks = driver.findElement(By.linkText("Bugs"));
		// allTasks.click();

		System.out.println(driver.getTitle());
		if (driver.getTitle().equals("Welcome to Codecarrots")) {
			test.log(LogStatus.PASS, "Navigated to the specified URL");
		} else {
			test.log(LogStatus.FAIL, "Test Failed");
		}
	}

	@BeforeClass
	public void beforeClass() throws InterruptedException {

		try {
			driver = webManager.getDriver();
			String currentDir = System.getProperty("user.dir");
			report = new ExtentReports(System.getProperty(currentDir+"\\src\\test\\resources\\")
					+ "ExtentReportResults.html");
			test = report.startTest("ExtentReportGenerator");

		} catch (Exception e) {
			System.out.println(e);
		}

	}

	@AfterClass
	public void afterClass() {

		report.endTest(test);
		report.flush();

	}

}
