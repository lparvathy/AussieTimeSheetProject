package testngPkg;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pom.AussieHomePage;
import utility.ExcelReader;
import utility.WebDriverManager;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.io.IOException;
import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;

public class LoginPage {

	static WebDriver driver;
	String url = "https://erp.buffalocart.com/login/";
	String title = "Welcome to Codecarrots";
	String browser;
	AussieHomePage objhome;
	WebDriverManager webManager = new WebDriverManager();

	@Test(priority = 1)
	public void urlVerify() {

		String currentURL = driver.getCurrentUrl();
		System.out.println(currentURL);
		System.out.println(url);
		if (url.contains(currentURL)) {
			System.out.println("passed url check");
		} else {
			System.out.println("failed");
		}
		SoftAssert s = new SoftAssert();
		s.assertEquals(url, currentURL);
		System.out.println("url is verified ");
	}

	@Test(priority = 2)
	public void titleVerify() {

		boolean val = false;
		String titleCheck = driver.getTitle();
		if (title.contains(titleCheck)) {
			System.out.println("passed title check");
			val = true;
		} else {
			System.out.println("failed");
			val = false;
		}
		SoftAssert objSoftAssert = new SoftAssert();
		objSoftAssert.assertEquals(val, "title verification");
		System.out.println("value soft assert to be printed");

		AssertJUnit.assertEquals(titleCheck, title);
		System.out.println("value hard assert to be printed");

	}

	@Test(priority = 3)
	@Parameters({ "username", "password" })
	public void loginWithValidCredentials(String username, String password)
			throws MalformedURLException, InterruptedException {

		webManager.loginWithValidCredentials(username, password);

	}

	@BeforeTest
	@Parameters({ "url", "browser" })
	public void launchBrowser(String url, String browser) throws IOException {

		ExcelReader exRead = new ExcelReader();
		String urlFromExcel = exRead.readExcelSheet(1, 0);
		String browser1 = exRead.readExcelSheet(1, 1);

		System.out.println(urlFromExcel + browser1);
		driver = webManager.launchBrowser(url, browser);
		objhome = new AussieHomePage(driver);

	}

	@AfterTest
	public void afterTest() {
		// driver.quit();
	}

}
