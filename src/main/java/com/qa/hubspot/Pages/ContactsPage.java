 package com.qa.hubspot.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.hubspot.BasePage.BasePage;
import com.qa.hubspot.util.TestUtil;

import excelReaders.Xls_Reader;

public class ContactsPage extends BasePage {

	@FindBy(xpath = "//span[text()='Create contact']")
	WebElement createContactBtn;

	@FindBy(xpath = "//input[contains(@id,'uid-ctrl-') and contains(@data-field,'email')] ") 
	WebElement email;

	@FindBy(xpath = "//input[contains(@id,'uid-ctrl-') and contains(@data-field,'firstname')]")
	WebElement firstName;

	@FindBy(xpath= "//input[contains(@id,'uid-ctrl-') and contains(@data-field,'lastname')]")
	WebElement lastName;

	@FindBy(xpath = "//input[contains(@id,'uid-ctrl-') and contains(@data-field,'jobtitle')]")
	WebElement jobTitle;

	@FindBy(xpath = "//li//span[text()='Create contact']")
	WebElement createContactSecondBtn;
	
	@FindBy(xpath="//div[@class='text-left UIColumn-spreads']//span[text()='Smitha T']")
	WebElement firstContactName;
	
	@FindBy(xpath = "//span[contains(text(),'Create and add another')]")
	WebElement createAndAddAnotherContactBtn;

	public ContactsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void createNewContact(String emailV,String firstNameV,String lastNameV,String jobTitleV) {

		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(createContactBtn));
		createContactBtn.click();
		
		wait.until(ExpectedConditions.elementToBeClickable(email));
		email.sendKeys(emailV);
		
		wait.until(ExpectedConditions.elementToBeClickable(firstName));
		firstName.sendKeys(firstNameV);
		
		wait.until(ExpectedConditions.elementToBeClickable(lastName));
		lastName.sendKeys(lastNameV);
		
		wait.until(ExpectedConditions.elementToBeClickable(jobTitle));
		jobTitle.sendKeys(jobTitleV);
		
		wait.until(ExpectedConditions.elementToBeClickable(createContactSecondBtn));
		createContactSecondBtn.click();		

	}


public String firstContactName() {
	//driver.navigate().refresh();
	WebDriverWait wait= new WebDriverWait(driver,20);
	wait.until(ExpectedConditions.elementToBeClickable(firstContactName));
	return firstContactName.getText();
			
}
/**
 * This method is to create contacts using dataDriven
 * @param sheetName
 */
public void createContactsDataDriven(String sheetName) {
	
	//Xls_Reader reader=new Xls_Reader(("user.dir")+Constants.CONTACTS_TEST_DATA);
	String filePath=System.getProperty("user.dir")+"/scr/main/resources/excelReaders/contactsData.xlsx";
	Xls_Reader reader=new Xls_Reader(filePath);
	
	//Xls_Reader reader=new Xls_Reader("C:/Users/Balu/Desktop/QA/Eclipse/Naveen/hubPOM/scr/main/resources/contactsData.xlsx");

	
	int rowCount=reader.getRowCount(sheetName);
	
	
	WebDriverWait wait = new WebDriverWait(driver, 30);
	wait.until(ExpectedConditions.elementToBeClickable(createContactBtn));
	createContactBtn.click();
	
	for (int rowNum=2;rowNum<=rowCount;rowNum++) {
		String emailV= reader.getCellData(sheetName, "email",rowNum);
		String firstNameV= reader.getCellData(sheetName, "firstName",rowNum);	
		String lastNameV= reader.getCellData(sheetName, "lastName",rowNum);
		String jobTitleV= reader.getCellData(sheetName, "jobTitle",rowNum);
	
				
		wait.until(ExpectedConditions.elementToBeClickable(email));
		email.clear();
		TestUtil.shortWait();
		email.sendKeys(emailV);
		
		wait.until(ExpectedConditions.elementToBeClickable(firstName));
		firstName.clear();
		firstName.sendKeys(firstNameV);
		
		wait.until(ExpectedConditions.elementToBeClickable(lastName));
		lastName.clear();
		lastName.sendKeys(lastNameV);
		
		wait.until(ExpectedConditions.elementToBeClickable(jobTitle));
		jobTitle.clear();
		jobTitle.sendKeys(jobTitleV);
		
		wait.until(ExpectedConditions.elementToBeClickable(createAndAddAnotherContactBtn));
		createAndAddAnotherContactBtn.click();		
		
			
	}
	
	
}
}