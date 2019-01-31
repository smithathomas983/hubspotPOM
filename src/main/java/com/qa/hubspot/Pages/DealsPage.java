package com.qa.hubspot.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.hubspot.BasePage.BasePage;
import com.qa.hubspot.constants.Constants;

public class DealsPage extends BasePage {
	@FindBy(xpath = "//span[text()='Create deal']")
	WebElement createDealBtn;

	@FindBy(id = "uid-ctrl-1")
	WebElement dealName;

	@FindBy(id = "uid-ctrl-3")
	WebElement dealsStage;

	@FindBy(id = "uid-ctrl-4")
	WebElement dealAmount;

	@FindBy(className = "hs-pickadate private-date-picker")
	WebElement calander;

	public DealsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	public String getDealsPageTitle() {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.titleContains(Constants.DEAL_PAGE_TITLE));
		return driver.getTitle();

	}

	public void createNewDeal(String dealNameV, String dealsStageV, String dealAmountV) {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		
		wait.until(ExpectedConditions.elementToBeClickable(createDealBtn));
		createDealBtn.click();

		wait.until(ExpectedConditions.elementToBeClickable(dealName));
		dealName.sendKeys(dealNameV);

		wait.until(ExpectedConditions.elementToBeClickable(dealsStage));
		dealsStage.sendKeys(dealsStageV);

		wait.until(ExpectedConditions.elementToBeClickable(dealAmount));
		dealAmount.sendKeys(dealAmountV);

		wait.until(ExpectedConditions.elementToBeClickable(calander));
		calander.click();

	}

}
