package com.qa.hubspot.Tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.hubspot.BasePage.BasePage;
import com.qa.hubspot.Pages.ContactsPage;
import com.qa.hubspot.Pages.HomePage;
import com.qa.hubspot.Pages.LoginPage;

public class ContactsPageTests {
	

	public BasePage basePage;
	public WebDriver driver;
	public Properties prop;
	public LoginPage loginPage;
	public HomePage homePage;
	public ContactsPage contactsPage;
	@BeforeMethod()
	public void setUp() {
		
		
		basePage=new BasePage();
		prop=basePage.init_Properties();
		String browser= prop.getProperty("browser");
		driver=basePage.init_Browser(browser);		
		driver.get(prop.getProperty("url"));
		loginPage= new LoginPage(driver);
		homePage=	loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		contactsPage=homePage.gotoContactsPage();
		
		
	}
	
	@Test
	public void verifyCreateContacts_Test() {
		contactsPage.createNewContact("SmithaT@gmail.com", "Smitha", "T", "QA Lead");
		Assert.assertEquals("Smitha T", contactsPage.firstContactName());
	}
	
	@Test
	public void verifyCreateContactsDataDriven_Test() {
		contactsPage.createContactsDataDriven("Contacts");
			
	}
	
	@AfterMethod
	public void tearDown() {
	driver.quit();
	}

}
