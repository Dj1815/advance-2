package com.crm.vtiger.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.crm.vtiger.genericUtils.WebdriverUtility;
/**
 * object repository of Leads Page
 * @author rohit
 *
 */
public class LeadsPage extends BasePage {
	
	public LeadsPage(WebDriver driver, WebdriverUtility webUtility) {
		super(driver, webUtility);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath = "//img[@alt='Create Lead...']")
	private WebElement createLeadButton;
	
	@FindBy(xpath = "//input[@name='search_text']")
	private WebElement searchTextField;
	
	@FindBy(xpath = "//span[text()='Search']/../..//select[@id='bas_searchfield']")
	private WebElement leadsSearchDropDown;
	
	@FindBy(xpath = "//span[text()='Search']/../..//input[@value=' Search Now ']")
	private WebElement searchNowButton;
	
	@FindBy(xpath = "//a[text()='Last Name']/following::a[@title='Leads']")
	private WebElement lastNameSelection;
	
	public WebElement getLastNameSelection() {
		return lastNameSelection;
	}

	public WebElement getCreateLeadButton() {
		return createLeadButton;
	}

	public WebElement getSearchTextField() {
		return searchTextField;
	}

	public WebElement getLeadsSearchDropDown() {
		return leadsSearchDropDown;
	}

	public WebElement getSearchNowButton() {
		return searchNowButton;
	}


	/**
	 * this method used to click on add button/create lead button
	 * @return
	 * @throws InterruptedException
	 */
	public CreateNewLead clickOnLeadsMenu() throws InterruptedException {
		webUtility.waitAndClick(createLeadButton);
		return new CreateNewLead(driver, webUtility);
	}
	
	/**
	 * this method is used to search for the recently created lead 
	 * from the leads list
	 * @param expectedLead
	 * @param lastName
	 * @throws InterruptedException
	 */
	public void searchForParticularLead(String expectedLead,String lastName) throws InterruptedException {
		searchTextField.sendKeys(expectedLead);
		webUtility.selectOption(leadsSearchDropDown, lastName);
		webUtility.waitAndClick(searchNowButton);
		Thread.sleep(2-000);
		webUtility.waitAndClick(lastNameSelection);
	}

}
