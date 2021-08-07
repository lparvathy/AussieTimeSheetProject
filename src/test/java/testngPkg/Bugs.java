package testngPkg;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.relevantcodes.extentreports.LogStatus;

import pom.AussieHomePage;

import utility.WebDriverManager;

import org.testng.annotations.BeforeTest;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;

public class Bugs {

	static WebDriver driver;
	AussieHomePage objhome;
	WebDriverManager webManager = new WebDriverManager();

	@Test(priority = 12)
	public void navigateToBugs() throws InterruptedException {
		try {

			driver = webManager.getDriver();
			objhome = new AussieHomePage(driver);

			webManager.navigateToPage(objhome.bugs, driver);
			webManager.waitImplement(objhome.bugs, driver);

			WebElement newBugsTab = objhome.newBugs;
			newBugsTab.click();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e);
		}
	}

	@Test(priority = 13)
	public void newBugCreate() throws InterruptedException, IOException {

		

		WebElement bugTitle = objhome.bugTitle;
		bugTitle.sendKeys("list button not working");
		String bugTitle1 = bugTitle.getText();
		System.out.println("bugTitle" + bugTitle1);
		webManager.getPromptText(objhome.bugTitle, driver, bugTitle1);

		WebElement relatedTo = objhome.relatedToBug;
		Select relatedToSlect = new Select(relatedTo);
		relatedToSlect.selectByIndex(1);
		String relatedToValue = relatedTo.getText();
		webManager.getPromptText(objhome.relatedToBug, driver, relatedToValue);
		System.out.println("relatedToValue " + relatedToValue);

		WebElement hiddenSelectProjects = objhome.hiddenSelectProjects;
		hiddenSelectProjects.isEnabled();
		hiddenSelectProjects.click();
		
		String hiddenSelectProjectsTxt = hiddenSelectProjects.getText();
		webManager.getPromptText(objhome.hiddenSelectProjects, driver, hiddenSelectProjectsTxt);
		System.out.println("hiddenSelectProjectsTxt " + hiddenSelectProjectsTxt);

		WebElement reporter = objhome.reporter;
		Select reporterSlct = new Select(reporter);
		reporterSlct.selectByIndex(1);
		String reporterVal = reporter.getText();
		webManager.getPromptText(objhome.relatedToBug, driver, reporterVal);
		System.out.println("reporterVal " + reporterVal);

		WebElement priority = objhome.priority;
		Select prioritySelct = new Select(priority);
		prioritySelct.selectByIndex(1);
		String priorityVal = priority.getText();
		webManager.getPromptText(objhome.priority, driver, priorityVal);
		System.out.println("priorityVal " + priorityVal);

		WebElement severity = objhome.severity;
		Select severitySelct = new Select(severity);
		severitySelct.selectByIndex(1);
		String severityVal = severity.getText();
		webManager.getPromptText(objhome.severity, driver, severityVal);
		System.out.println("severityVal " + severityVal);

		webManager.scolltoView(severity, driver);

		WebElement bugDescription = objhome.bugDescription;
		bugDescription.sendKeys("save button not working on multipel sessions");
		String descriptionTxt = bugDescription.getText();
		webManager.getPromptText(objhome.bugDescription, driver, descriptionTxt);
		System.out.println("bugDescription " + descriptionTxt);

		WebElement reproducibility = objhome.reproducibility;
		reproducibility.sendKeys("Yes");
		String reproducibilityTxt = reproducibility.getText();
		webManager.getPromptText(objhome.reproducibility, driver, reproducibilityTxt);
		System.out.println("reproducibility " + reproducibilityTxt);

		webManager.scollPageDown(driver);

		WebElement assignedRadio = objhome.assignedToBugRadio;
		assignedRadio.click();

		SoftAssert objRadio = new SoftAssert();
		objRadio.assertEquals(assignedRadio, true);
		System.out.println("Radio button is clicked");

		WebElement saveBtn = objhome.saveBugBtn;
		saveBtn.submit();
		webManager.takeScreenShot(driver);

	}

	@Test(priority = 14, enabled = true)
	public void switchtoAllBugs() throws InterruptedException, IOException {
		WebElement allTasks = objhome.bugs;
		allTasks.click();

	}

	@Test(priority = 15)
	public void searchBug() throws InterruptedException, IOException {
		
		

		WebElement searchBug = objhome.bugDataTable;
		searchBug.sendKeys("list");
		Thread.sleep(1000);
		webManager.waitDataTableImplement(objhome.bugDataTable, driver);

	}

	@Test(priority = 16)
	public void generateExtentReport() {

		ExtentReportGenerator.generateExtentReport();

	}

	@Test(priority = 17)
	public void logOut() throws InterruptedException, IOException {
		
		
		WebElement demoLink = objhome.demoLink;
		demoLink.click();
		
		webManager.waitImplement(objhome.demoLink,driver);

		WebElement logOutBtn = objhome.logOutBtn;
		logOutBtn.click();

	}

	@AfterTest
	public void afterTest() {
	}

}
