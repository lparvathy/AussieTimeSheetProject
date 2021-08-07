package testngPkg;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pom.AussieHomePage;
import utility.WebDriverManager;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;

public class Tasks {

	static WebDriver driver;
	AussieHomePage objhome;
	WebDriverManager webManager = new WebDriverManager();

	@BeforeTest
	public void beforeTest() {

		driver = webManager.getDriver();
		objhome = new AussieHomePage(driver);
	}

	@Test(priority = 8)
	public void navigateToTasks() throws InterruptedException {
		webManager.waitImplement(objhome.tasks, driver);

		webManager.navigateToPage(objhome.tasks, driver);

		WebElement newTasksTab = objhome.newTask;
		newTasksTab.click();

	}

	@Test(priority = 9)
	public void newTaskCreate() throws InterruptedException, IOException {

		WebElement taskName = objhome.taskName;
		taskName.sendKeys("Task 9");
		String tskName = taskName.getText();

		System.out.println("taskName" + taskName);
		webManager.getPromptText(objhome.taskName, driver, tskName);

		WebElement relatedTo = objhome.relatedTo;
		Select relatedToSlect = new Select(relatedTo);
		relatedToSlect.selectByIndex(3);
		String relatedToValue = relatedTo.getText();
		webManager.getPromptText(objhome.relatedTo, driver, relatedToValue);

		WebElement hiddenSelectLeads = objhome.hiddenSelectLeads;
		hiddenSelectLeads.isSelected();
		String hiddenSelectLeadsTxt = hiddenSelectLeads.getText();
		webManager.getPromptText(objhome.hiddenSelectLeads, driver, hiddenSelectLeadsTxt);

		WebElement strDate = objhome.taskStartDate;
		strDate.sendKeys("2021-08-07");
		strDate.click();
		String strDateTxt = strDate.getText();
		webManager.getPromptText(objhome.taskStartDate, driver, strDateTxt);

		webManager.scollPageDown(driver);

		WebElement dueDate = objhome.dueDate;
		dueDate.sendKeys("2021-08-07");
		dueDate.click();
		String dueDateTxt = dueDate.getText();
		webManager.getPromptText(objhome.dueDate, driver, dueDateTxt);
		// driver.switchTo().activeElement().findElement(By.name("billing_type"));

		WebElement hourlyRate = objhome.hourlyRate;
		if (hourlyRate.isDisplayed()) {
			hourlyRate.sendKeys("5.01");

			String hourlyrateTxt = hourlyRate.getText();
			webManager.getPromptText(objhome.hourlyRate, driver, hourlyrateTxt);
			System.out.println("estimate hours " + hourlyrateTxt);
		}

		WebElement estimatedHours = objhome.estimatedHours;
		if (estimatedHours.isDisplayed()) {
			estimatedHours.sendKeys("5.01");

			String estimateHoursTxt = estimatedHours.getText();
			webManager.getPromptText(objhome.estimatedHours, driver, estimateHoursTxt);
			System.out.println("estimate hours " + estimateHoursTxt);
		}

		webManager.scolltoView(estimatedHours, driver);

		WebElement progressbar = objhome.progressTaskBar;
		int numberOfPixelsToDragTheScrollbar = 90;
		Actions progressBar = new Actions(driver);
		progressBar.moveToElement(progressbar).clickAndHold().moveByOffset(0, numberOfPixelsToDragTheScrollbar)
				.release().perform();

		WebElement taskStatus = objhome.taskStatusSelect;
		Select statusSelect = new Select(taskStatus);
		if (taskStatus.isEnabled()) {
			statusSelect.selectByIndex(3);

			String statusSelectTxt = taskStatus.getText();
			System.out.println("statusSelectTxt>>" + statusSelectTxt);
			webManager.getPromptText(objhome.taskStatusSelect, driver, statusSelectTxt);
		}

		WebElement taskDescription = objhome.taskDescription;
		taskDescription.sendKeys("Thsi is TEST task .Pleaes proceed");
		String descriptionTxt = taskDescription.getText();
		webManager.getPromptText(objhome.taskDescription, driver, descriptionTxt);
		System.out.println("description " + descriptionTxt);

		WebElement billable = objhome.billable;
		Actions billableCheck = new Actions(driver);
		billableCheck.contextClick(billable);

		String billableTxt = billable.getText();
		System.out.println("billableTxt>>" + billableTxt);
		webManager.getPromptText(objhome.billable, driver, billableTxt);

		webManager.scollPageDown(driver);

		WebElement assignedRadio = objhome.assignedToTaskRadio;

		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("arguments[0].click()", assignedRadio);
		SoftAssert objRadio = new SoftAssert();
		objRadio.assertEquals(assignedRadio, true);
		System.out.println("Radio button is clicked");

		String option1 = null;

		if (assignedRadio.isSelected()) {
			WebElement selectUser = driver.findElement(By.id("permission_user_1"));
			selectUser.isEnabled();

			WebElement multiCheckBox_Option1 = objhome.multiCheckBox_Option1_Task;
			boolean checked = multiCheckBox_Option1.isSelected();
			multiCheckBox_Option1.click();
			if (checked) {

				option1 = multiCheckBox_Option1.getText();
				SoftAssert option1Chk = new SoftAssert();
				option1Chk.assertAll();
				System.out.println("option 4 is checked");
			}

		}

		WebElement saveBtn = objhome.submitTaskBtn;
		saveBtn.submit();
		webManager.takeScreenShot(driver);

	}

	@Test(priority = 10)
	public void switchtoAllTasks() throws InterruptedException, IOException {
		WebElement allTasks = objhome.tasks;
		allTasks.click();

	}

	@Test(priority = 11)
	public void searchTask() throws InterruptedException, IOException {

		

		WebElement searchTask = objhome.dataTableTask;
		searchTask.sendKeys("Task 9");
		Thread.sleep(1000);
		webManager.waitDataTableImplement(objhome.dataTableTask, driver);

	}

	@AfterTest
	public void afterTest() {
	}

}
