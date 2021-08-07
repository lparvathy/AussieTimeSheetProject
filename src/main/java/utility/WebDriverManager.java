package utility;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.google.common.io.Files;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;

public class WebDriverManager {

	static WebDriver driver;

	public WebDriver getDriver() {

		return driver;

	}

	public WebDriver launchBrowser(String url, String browserType) {

		switch (browserType.toLowerCase()) {
		case "chrome":

		{
			System.setProperty("webdriver.chrome.driver", "E:\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.get(url);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			break;
		}
		case "ie":

		{
			System.setProperty("webdriver.ie.driver", "E:\\IEDriverServer_x64_3.150.1\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			driver.get(url);
			driver.manage().window().maximize();
			break;
		}
		case "edge":

		{
			System.setProperty("webdriver.edge.driver", "E:\\edgedriver_win64\\msedgedriver.exe");
			driver = new EdgeDriver();
			driver.get(url);
			driver.manage().window().maximize();
			break;
		}
		}

		return driver;

	}

	public void loginWithValidCredentials(String username, String passsword)
			throws MalformedURLException, InterruptedException {

		WebElement userName = driver.findElement(By.name("user_name"));
		userName.sendKeys(username);

		String userTxt = driver.findElement(By.name("user_name")).getText();
		if (userTxt == "admin") {
			SoftAssert objUsr = new SoftAssert();
			objUsr.assertEquals(userTxt, "admin");
			System.out.println("User is valid");
		}
		WebElement password = driver.findElement(By.name("password"));
		password.sendKeys(passsword);

		String passwordTxt = driver.findElement(By.name("password")).getText();
		if (passwordTxt == "123456") {
			SoftAssert objPwd = new SoftAssert();
			objPwd.assertEquals(passwordTxt, "123456");
			System.out.println("password is valid");
		}
		WebElement submitBtn = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[3]/div[2]/form/button[1]"));
		submitBtn.submit();

		if ((((userTxt == null) || (passwordTxt == null) || (userTxt == "") || (passwordTxt == "")))) {

			WebElement errorMsg = driver.findElement(By.xpath("//*[@id=\'parsley-id-6\']/li"));
			errorMsg.isDisplayed();

		}

		if (((userTxt != null) && (userTxt != "admin")) || ((passwordTxt != null) && (passwordTxt != "123456"))) {

			WebElement errorLoginMsg = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div"));
			errorLoginMsg.isDisplayed();

		}

	}

	public void navigateToPage(WebElement element, WebDriver driver) throws InterruptedException {
		System.out.println(element);
		try {
			element.click();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public boolean elementStatus(By value, WebDriver driver) {
		boolean status = driver.findElement(value).isEnabled();
		return status;
	}

	public void getPromptText(WebElement element, WebDriver driver, String text) {
		String textDisplay = element.getText();
		SoftAssert s = new SoftAssert();
		s.assertEquals(textDisplay, text);
		System.out.println("strings  are equal");
	}

	/*
	 * public void screenShot(WebDriver driver) throws IOException,
	 * InterruptedException { TakesScreenshot ts = (TakesScreenshot) driver; File
	 * source = ts.getScreenshotAs(OutputType.FILE); File destination = new File(
	 * "E:\\Eclipse_Workspace\\AussieTimeSheet\\src\\test\\resources\\screenshots/screenshot_"
	 * + timestamp() + ".jpeg"); Files.copy(source, destination);
	 * 
	 * }
	 */

	public static String timestamp() {
		return new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date());
	}

	public void waitImplement(WebElement elemnet, WebDriver driver) {

		WebDriverWait wait = new WebDriverWait(driver, 20);

		wait.until(ExpectedConditions.visibilityOfAllElements(elemnet));

	}

	public void waitDataTableImplement(WebElement elemnet, WebDriver driver) {

		WebDriverWait wait = new WebDriverWait(driver, 10);

		wait.until(ExpectedConditions.visibilityOfAllElements(elemnet));

	}

	public void scollPageDown(WebDriver driver) {
		// Vertical scroll down by 600 pixels starts here
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,600)");
		// Vertical scroll down by 600 pixels ends here
	}

	public void scolltoView(WebElement elemnet, WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", elemnet);
	}

	public static void takeScreenShot(WebDriver driver) {
		try {
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

			String currentDir = System.getProperty("user.dir");

			String filename = new SimpleDateFormat("dd_MM_yyyy HH-mm-ss").format(new Date());

			String fileWithPath = currentDir + "\\src\\test\\resources\\screenshots/" + "_" + filename + ".png";

			File dest = new File(fileWithPath);
			Files.copy(scrFile, dest);

			System.out.println(":Test Success & Screenshot has been taken");
		} catch (IOException e) {
			System.out.println("Capture Failed " + e.getMessage());
		}

	}

}
