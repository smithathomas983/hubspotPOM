package com.qa.hubspot.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.hubspot.BasePage.BasePage;

public class LoginPage extends BasePage{
	
	public WebDriver driver;
	//Creating page objects with the help of PageFactory
	
	@FindBy(id="username")
	WebElement userName;
	
	@FindBy(id="password")
	WebElement password;
	
	@FindBy(id="loginBtn")
	WebElement loginButton;
	
	@FindBy(xpath="//a/i18n-string[contains(text(),'Forgot my password')]")
	WebElement forgetpwdLink;
	
	@FindBy(xpath="//span[@class='private-checkbox__icon private-checkbox__check']")
	WebElement remembermeCheckBox;
	
	//Create a constructor
	
	public LoginPage(WebDriver driver) {
		
		this.driver=driver  ;
		PageFactory.initElements(driver, this);
			}
	
	//methods or actions
	public String getLoginPageTitle() {
		return driver.getTitle();
	}
	
	public boolean verifyForgetPwdLink() {
		return forgetpwdLink.isDisplayed();
	}
	public boolean verifyRememberMeCheckBox() {
		return remembermeCheckBox.isEnabled();
	}
	public  HomePage login(String un,String pwd)  {
	
		userName.sendKeys(un);
		password.sendKeys(pwd);
		loginButton.click();
		return new HomePage(driver);
	}
 
}
