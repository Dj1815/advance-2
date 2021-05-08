package com.crm.vtiger.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.crm.vtiger.genericUtils.WebdriverUtility;
/**
 * object repository of create new lead
 * @author rohit
 *
 */
public class CreateNewLead extends BasePage {
	
	@FindBy(name = "lastname")
	private WebElement lastNameTextField;
	
	@FindBy(name="company")
	private WebElement companyNameTextField;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveButton;
	
	@FindBy(linkText = "Leads")
	private WebElement leadsLink;
	
	@FindBy(linkText = "Convert Lead")
	private WebElement convertLeadLink;
	
	public WebElement getConvertLeadLink() {
		return convertLeadLink;
	}

	public WebElement getLeadsLink() {
		return leadsLink;
	}

	public WebElement getLastNameTextField() {
		return lastNameTextField;
	}

	public WebElement getCompanyNameTextField() {
		return companyNameTextField;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}

	public CreateNewLead(WebDriver driver, WebdriverUtility webUtility) {
		super(driver, webUtility);
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * this method used to send data to last name and company name(mandatory fields)
	 * @param lastName
	 * @param companyName
	 * @return LeadInformationPage
	 */
	public LeadInformationPage createNewLead(String lastName,String companyName) {
		lastNameTextField.sendKeys(lastName);
		companyNameTextField.sendKeys(companyName);
		saveButton.click();
		return new LeadInformationPage(driver,webUtility);
	}
	
	/**
	 * used to click on leads link
	 * @param lead
	 */
	public void clickOnLeadLink(String lead) {
		leadsLink.click();
	}
	
	/**
	 * used to click on convert leads link in leads info page
	 * @return ConvertLeadLink
	 */
	public ConvertLeadLink clickOnConvertLeadLink() {
		convertLeadLink.click();
		return new ConvertLeadLink(driver,webUtility);
	}
}
