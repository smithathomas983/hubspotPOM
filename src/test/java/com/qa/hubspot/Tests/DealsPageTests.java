package com.qa.hubspot.Tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.hubspot.BasePage.BasePage;
import com.qa.hubspot.Pages.DealsPage;
import com.qa.hubspot.Pages.HomePage;
import com.qa.hubspot.Pages.LoginPage;
import com.qa.hubspot.constants.Constants;

public class DealsPageTests {

	public BasePage basePage;
	public WebDriver driver;
	public Properties prop;
	public LoginPage loginPage;
	public HomePage homePage;
	public DealsPage dealsPage;
	@BeforeMethod()
	public void setUp() {
		
		
		basePage=new BasePage();
		prop=basePage.init_Properties();
		String browser= prop.getProperty("browser");
		driver=basePage.init_Browser(browser);		
		driver.get(prop.getProperty("url"));
		loginPage= new LoginPage(driver);
		homePage=	loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		dealsPage=new DealsPage(driver);
		dealsPage= homePage.gotoDealsPage();
				
	}
	@Test
	public void verifyDealsPageTitle_Test() {
		Assert.assertEquals(dealsPage.getDealsPageTitle(), Constants.DEAL_PAGE_TITLE);
	}
	
	
	@AfterMethod
	public void tearDown() {
	driver.quit();
	}

}
