package com.qa.hubspot.Tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.hubspot.BasePage.BasePage;
import com.qa.hubspot.Pages.LoginPage;

public class LoginTest {
	
	public BasePage basePage;
	public WebDriver driver;
	public Properties prop;
	public LoginPage loginPage;
	
	
	@BeforeMethod()
	public void setUp() {
		
		
		basePage=new BasePage();
		prop=basePage.init_Properties();
		String browser= prop.getProperty("browser");
		driver=basePage.init_Browser(browser);		
		driver.get(prop.getProperty("url"));
		loginPage= new LoginPage(driver);
		 
		
		
	}
	
	
	@Test(invocationCount=2,priority=1)
	public void loginPageTitle_Test() {
		String title=loginPage.getLoginPageTitle();	
		System.out.println("Title of the page is: "+title);
		Assert.assertEquals(title,"HubSpot Login");
		}
	
	@Test(priority=2)
	public void verifyForgotPasswordLink_Test() {
		Assert.assertTrue(loginPage.verifyForgetPwdLink(),"Forgot Password link is not found");
		
	}
	@Test(priority=3)
	public void verifyRememberMeCheckBos_Test() {
		Assert.assertTrue(loginPage.verifyRememberMeCheckBox(),"'Remember Me' check box is not found");
		
	}
	@Test(priority=4)
	public void login_Test()  {
		loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	@AfterMethod
	public void tearDown() {
	driver.quit();
	}

}
