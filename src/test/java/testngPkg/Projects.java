package testngPkg;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pom.AussieHomePage;

import utility.WebDriverManager;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.io.IOException;
import java.net.MalformedURLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterTest;

public class Projects {

	static WebDriver driver;
	AussieHomePage objhome;
	WebDriverManager webManager = new WebDriverManager();

	@BeforeTest
	public void beforeTest() {

		driver = webManager.getDriver();
		objhome = new AussieHomePage(driver);

	}

	@Test(priority = 4)
	public void navigateToProjects() throws InterruptedException {

		webManager.waitImplement(objhome.projectsXpath, driver);

		try {
			webManager.navigateToPage(objhome.projectsXpath, driver);
			webManager.navigateToPage(objhome.newProject, driver);
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	@Test(priority = 5)
	public void newProjectCreate() throws InterruptedException, IOException {

		try {

			webManager.waitImplement(objhome.projNo, driver);

			// driver.switchTo().frame(newProjectTab);

			WebElement projectNo = objhome.projNo;

			webManager.navigateToPage(projectNo, driver);
			String projNo = projectNo.getText();

			System.out.println("projNo" + projNo);

			WebElement projectName = objhome.projectName;
			projectName.sendKeys("iMng");
			String projName = projectName.getText();

			/*
			 * if(projName.isBlank()) { WebElement
			 * alert_ProjectName=driver.findElement(By.xpath("//*[@id=\'parsley-id-15\']/li"
			 * )); alert_ProjectName.isEnabled();
			 * 
			 * } else {
			 */
			System.out.println("projectName" + projName);
			webManager.getPromptText(objhome.projectName, driver, projName);
			// }

			WebElement selectClient = objhome.selectClient;
			Select clientDrop = new Select(selectClient);
			clientDrop.selectByIndex(1);
			// clientDrop.selectByVisibleText("Shell");

			String clientValue = selectClient.getText();
			webManager.getPromptText(objhome.selectClient, driver, clientValue);

			WebElement progressbar = objhome.progressBar;
			int numberOfPixelsToDragTheScrollbar = 80;
			Actions progressBar = new Actions(driver);
			progressBar.moveToElement(progressbar).clickAndHold().moveByOffset(0, numberOfPixelsToDragTheScrollbar)
					.release().perform();

			WebElement strDate = objhome.startDate;

			strDate.sendKeys("2021-08-07");
			strDate.click();
			String strDateTxt = strDate.getText();
			webManager.getPromptText(objhome.startDate, driver, strDateTxt);

			webManager.scollPageDown(driver);

			WebElement endDate = objhome.endDate;
			endDate.sendKeys("2021-08-07");
			endDate.click();
			String endDateTxt = endDate.getText();
			webManager.getPromptText(objhome.endDate, driver, endDateTxt);
			// driver.switchTo().activeElement().findElement(By.name("billing_type"));

			WebElement billType = objhome.billType;
			Select newBillType = new Select(billType);
			newBillType.selectByVisibleText("Only Task Hours");
			billType.isSelected();

			String billTypeTxt = billType.getText();
			System.out.println("billTypeTxt>>" + billTypeTxt);
			webManager.getPromptText(objhome.billType, driver, billTypeTxt);
			
			WebElement hiddentxt =objhome.hiddenText;
			hiddentxt.isEnabled();

			WebElement estimateHours = objhome.estimateHours;
			if (estimateHours.isDisplayed()) {
				estimateHours.sendKeys("3.01");

				String estimateHoursTxt = estimateHours.getText();
				webManager.getPromptText(objhome.estimateHours, driver, estimateHoursTxt);
				System.out.println("estimate hours " + estimateHoursTxt);
			}
			WebElement status = objhome.statusSelect;
			Select statusSelect = new Select(status);
			if (status.isEnabled()) {
				statusSelect.selectByIndex(2);

				String statusSelectTxt = status.getText();
				System.out.println("statusSelectTxt>>" + statusSelectTxt);
				webManager.getPromptText(objhome.billType, driver, statusSelectTxt);
			}
			WebElement demoURL = objhome.demoURL;
			demoURL.sendKeys("https://www.uat.com");
			String demoURLTxt = demoURL.getText();
			webManager.getPromptText(objhome.demoURL, driver, demoURLTxt);
			System.out.println("demoURL " + demoURLTxt);

			webManager.scollPageDown(driver);

			WebElement assignedRadio = objhome.assignedToRadio;

			JavascriptExecutor js1 = (JavascriptExecutor) driver;
			js1.executeScript("arguments[0].click()", assignedRadio);
			SoftAssert objRadio = new SoftAssert();
			objRadio.assertEquals(assignedRadio, true);
			System.out.println("Radio button is clicked");

			String option1 = null;
			String option2 = null;
			if (assignedRadio.isSelected()) {
				WebElement selectUser = driver.findElement(By.id("permission_user_1"));
				selectUser.isEnabled();

				WebElement multiCheckBox_Option3 = objhome.checkBoxOption3;
				boolean checked = multiCheckBox_Option3.isSelected();
				multiCheckBox_Option3.click();
				if (checked) {

					option1 = multiCheckBox_Option3.getText();
					SoftAssert option1Chk = new SoftAssert();
					option1Chk.assertAll();
					System.out.println("option 3 is checked");
				}

				WebElement multiCheckBox_Option5 = objhome.checkBoxOption5;
				boolean checked1 = multiCheckBox_Option5.isSelected();
				multiCheckBox_Option5.click();
				if (checked1) {
					option2 = multiCheckBox_Option5.getText();
					SoftAssert option1Chk = new SoftAssert();
					option1Chk.assertAll();
					System.out.println("option 5 is checked");
				}

			}

			WebElement description = objhome.description;
			description.sendKeys("Thsi is TEST.Pleaes proceed");
			String descriptionTxt = description.getText();
			webManager.getPromptText(objhome.description, driver, descriptionTxt);
			System.out.println("description " + descriptionTxt);

			WebElement submitBtn = objhome.submitBtn;

			submitBtn.submit();
			webManager.takeScreenShot(driver);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	@Test(priority = 6)
	public void switchtoAllProjects() throws InterruptedException, IOException {
		WebElement allProjects = objhome.project;
		webManager.navigateToPage(allProjects, driver);

	}

	@Test(priority = 7)
	public void searchProject() throws InterruptedException, IOException {

		WebElement searchProject = objhome.searchTable;
		searchProject.sendKeys("iM");
		Thread.sleep(1000);
		webManager.waitDataTableImplement(objhome.searchTable, driver);

	}

	@AfterTest
	public void afterTest() {
	}

}
