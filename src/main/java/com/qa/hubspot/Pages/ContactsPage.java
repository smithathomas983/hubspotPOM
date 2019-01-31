package com.qa.hubspot.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.hubspot.BasePage.BasePage;

public class ContactsPage extends BasePage {

	@FindBy(xpath = "//span[text()='Create contact']")
	WebElement createContactBtn;

	@FindBy(id = "uid-ctrl-1")
	WebElement email;

	@FindBy(id = "uid-ctrl-2")
	WebElement firstName;

	@FindBy(id = "uid-ctrl-3")
	WebElement lastName;

	@FindBy(id = "uid-ctrl-5")
	WebElement jobTitle;

	@FindBy(xpath = "//li//span[text()='Create contact']")
	WebElement createContactSecondBtn;
	
	@FindBy(xpath="//div[@class='text-left UIColumn-spreads']//span[text()='Smitha T']")
	WebElement firstContactName;

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
	WebDriverWait wait= new WebDriverWait(driver,30);
	wait.until(ExpectedConditions.elementToBeClickable(firstContactName));
	return firstContactName.getText();
			
}
}