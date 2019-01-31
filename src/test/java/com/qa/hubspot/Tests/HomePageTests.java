package com.qa.hubspot.Tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.hubspot.BasePage.BasePage;
import com.qa.hubspot.Pages.HomePage;
import com.qa.hubspot.Pages.LoginPage;
import com.qa.hubspot.constants.Constants;

import junit.framework.Assert;

public class HomePageTests {
	
	
	
	public BasePage basePage;
	public WebDriver driver;
	public Properties prop;
	public LoginPage loginPage;
	public HomePage homePage;
	@BeforeMethod()
	public void setUp() {
		
		
		basePage=new BasePage();
		prop=basePage.init_Properties();
		String browser= prop.getProperty("browser");
		driver=basePage.init_Browser(browser);		
		driver.get(prop.getProperty("url"));
		loginPage= new LoginPage(driver);
		homePage=	loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		
		
	}
	@Test
	public void verifyHomePageTitle_Test() {
		String title= homePage.getHomePageTitle();
		System.out.println("Home Page Title is:"+ title);
		Assert.assertEquals(Constants.HOME_PAGE_TITLE,title);
	}
	@Test
	public void verifyHomePageHeader_Test() {
		Assert.assertTrue(homePage.verifyHomePageHeader());
	}
	
	@AfterMethod
	public void tearDown() {
	driver.quit();
	}
	

}
