package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.How;

public class AussieHomePage {

	static WebDriver driver;

	public AussieHomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	
	
	
	@FindBy(how = How.LINK_TEXT, using = "Projects")
	public WebElement projects;
	
	@FindBy(how = How.XPATH, using = "/html/body/div[1]/section/div/div[2]/div/div[3]/div/div[2]/ul/li[2]/a")
	public WebElement newProject;

	@FindBy(how = How.XPATH, using = "/html/body/div[1]/aside[1]/div/nav/ul[2]/li[5]/a")
	public WebElement projectsXpath;

	@FindBy(how = How.XPATH, using = "//*[@id=\'create\']/form/div/div[1]/div[1]/div/input")
	public WebElement projNo;

	@FindBy(how = How.XPATH, using = "//*[@id=\'create\']/form/div/div[1]/div[2]/div/input")
	public WebElement projectName;

	@FindBy(how = How.XPATH, using = "//*[@id=\'create\']/form/div/div[1]/div[3]/div/div/select")
	public WebElement selectClient;

	@FindBy(how = How.XPATH, using = "//*[@id=\'create\']/form/div/div[1]/div[4]/div/div[1]/span")
	public WebElement progressBar;

	@FindBy(how = How.XPATH, using = "//*[@id=\'create\']/form/div/div[1]/div[5]/div/div/input")
	public WebElement startDate;

	@FindBy(how = How.XPATH, using = "//*[@id=\'create\']/form/div/div[1]/div[6]/div/div/input")
	public WebElement endDate;

	@FindBy(how = How.XPATH, using = "//*[@id=\'create\']/form/div/div[1]/div[7]/div/select")
	public WebElement billType;

	@FindBy(how = How.XPATH, using = "//*[@id=\'create\']/form/div/div[1]/div[11]/div/select")
	public WebElement statusSelect;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\'create\']/form/div/div[1]/div[10]/div/input")
	public WebElement estimateHours;

	@FindBy(how = How.NAME, using = "demo_url")
	public WebElement demoURL;

	@FindBy(how = How.XPATH, using = "//*[@id=\'permission_user_1\']/div/div[3]/label/input")
	public WebElement selectuser;

	@FindBy(how = How.XPATH, using = "//*[@id=\'create\']/form/div/div[3]/div[1]/div/div/div[6]")
	public WebElement description;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\'border-none\']/div/div[2]/label/input")
	public WebElement assignedToRadio;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\'permission_user_1\']/div/div[5]/label/input")
	public WebElement checkBoxOption3;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\'permission_user_1\']/div/div[9]/label/input")
	public WebElement checkBoxOption5;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\'create\']/form/div/div[3]/div[2]/button")
	public WebElement submitBtn;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\'DataTables_filter\']/label/input")
	public WebElement searchTable; 
	
	@FindBy(how = How.XPATH, using = "/html/body/div[1]/section/div/div[1]/a")
	public WebElement project;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\'create\']/form/div/div[1]/div[7]/div/small")
	public WebElement hiddenText;
	
	
	/* tasks POM starts here */
	@FindBy(how = How.XPATH, using = "/html/body/div[1]/aside[1]/div/nav/ul[2]/li[6]/a")
	public WebElement tasks;

	
	@FindBy(how = How.XPATH, using = "/html/body/div[1]/section/div/div[2]/div/div[4]/div/div[2]/ul/li[2]/a")
	public WebElement newTask;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\'assign_task\']/div/div/form/div[1]/div/input")
	public WebElement taskName;

	@FindBy(how = How.XPATH, using = "//*[@id=\'check_related\']")
	public WebElement relatedTo;

	@FindBy(how = How.XPATH, using = "//*[@id=\'related_to\']/div/div/button/span[1]")
	public WebElement hiddenSelectLeads;

	@FindBy(how = How.XPATH, using = "//*[@id=\'assign_task\']/div/div/form/div[9]/div/div[1]")
	public WebElement progressTaskBar;

	@FindBy(how = How.XPATH, using = "//*[@id=\'assign_task\']/div/div/form/div[5]/div/div/input")
	public WebElement taskStartDate;

	@FindBy(how = How.XPATH, using = "//*[@id=\'assign_task\']/div/div/form/div[6]/div/div/input")
	public WebElement dueDate;

	@FindBy(how = How.XPATH, using = "//*[@id=\'assign_task\']/div/div/form/div[8]/div/input")
	public WebElement estimatedHours;

	@FindBy(how = How.XPATH, using = "//*[@id=\'assign_task\']/div/div/form/div[8]/div/input")
	public WebElement hourlyRate;

	@FindBy(how = How.XPATH, using = "//*[@id=\'assign_task\']/div/div/form/div[12]/div/div/input")
	public WebElement billable;

	@FindBy(how = How.XPATH, using = "//*[@id=\'border-none\']/div/select")
	public WebElement taskStatusSelect;

	@FindBy(how = How.XPATH, using = "//*[@id=\'assign_task\']/div/div/form/div[11]/div/div/div[6]")
	public WebElement taskDescription;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\'border-none\']/div/div[2]/label/input")
	public WebElement assignedToTaskRadio;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\'permission_user_1\']/div/div[7]/label/input")
	public WebElement multiCheckBox_Option1_Task;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\'assign_task\']/div/div/form/div[15]/button")
	public WebElement submitTaskBtn;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\'DataTables_filter\']/label/input")
	public WebElement dataTableTask;
	
	/* tasks POM ends here */

	/* Bugs POM starts here */
	@FindBy(how = How.LINK_TEXT, using = "Bugs")
	public WebElement bugs;
	
	@FindBy(how = How.LINK_TEXT, using = "New Bugs")
	public WebElement newBugs;

	@FindBy(how = How.XPATH, using = "//*[@id=\'assign_task\']/div/div/form/div[2]/div/input")
	public WebElement bugTitle;

	@FindBy(how = How.XPATH, using = "//*[@id=\'check_related\']")
	public WebElement relatedToBug;

	@FindBy(how = How.XPATH, using = "//*[@id=\'related_to\']/div/div/button")
	public WebElement hiddenSelectProjects;

	@FindBy(how = How.XPATH, using = "//*[@id=\'border-none\']/div/select")
	public WebElement reporter;

	@FindBy(how = How.XPATH, using = "//*[@id=\'assign_task\']/div/div/form/div[6]/div/div/select")
	public WebElement priority;

	@FindBy(how = How.XPATH, using = "//*[@id=\'assign_task\']/div/div/form/div[7]/div/div/select")
	public WebElement severity;

	@FindBy(how = How.XPATH, using = "//*[@id=\'assign_task\']/div/div/form/div[8]/div/div/div[6]")
	public WebElement bugDescription;

	@FindBy(how = How.XPATH, using = "//*[@id=\'assign_task\']/div/div/form/div[8]/div/div/div[6]")
	public WebElement reproducibility;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\'border-none\']/div/div[1]/label/input")
	public WebElement assignedToBugRadio;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\'assign_task\']/div/div/form/div[13]/button")
	public WebElement saveBugBtn;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\'DataTables_filter\']/label/input")
	public WebElement bugDataTable;
	
	@FindBy(how = How.XPATH, using = "/html/body/div[1]/header/nav/div[2]/ul[2]/li[3]/a/span")
	public WebElement demoLink;
	
	@FindBy(how = How.XPATH, using = "/html/body/div[1]/header/nav/div[2]/ul[2]/li[3]/ul/li[3]/form/div/button")
	public WebElement logOutBtn;

}
