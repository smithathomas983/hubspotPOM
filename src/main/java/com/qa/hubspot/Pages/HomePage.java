package com.qa.hubspot.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.hubspot.BasePage.BasePage;
import com.qa.hubspot.constants.Constants;
import com.qa.hubspot.util.TestUtil;

public class HomePage extends BasePage {

	@FindBy(xpath = "//h1[text()='Sales Dashboard']")
	WebElement homePageHeader;

	@FindBy(id = "nav-primary-contacts-branch")
	WebElement contactsTab;

	@FindBy(id = "nav-secondary-contacts")
	WebElement contactLink;

	@FindBy(id = "nav-primary-sales-branch")
	WebElement salesTab;

	@FindBy(id = "nav-secondary-deals")
	WebElement dealsLink;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public String getHomePageTitle() {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.titleContains(Constants.HOME_PAGE_TITLE));

		return driver.getTitle();

	}

	public boolean verifyHomePageHeader() {
		return homePageHeader.isDisplayed();
	}

	public ContactsPage gotoDealsPage() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(salesTab));

		salesTab.click();
		TestUtil.shortWait();

		dealsLink.click();

		return new ContactsPage(driver);

	}

	public ContactsPage gotoContactsPage() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(contactsTab));

		contactsTab.click();
		TestUtil.shortWait();

		contactLink.click();

		return new ContactsPage(driver);

	}
}
