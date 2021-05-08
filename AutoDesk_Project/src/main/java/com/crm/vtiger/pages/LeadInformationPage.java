package com.crm.vtiger.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.crm.vtiger.genericUtils.WebdriverUtility;

public class LeadInformationPage extends BasePage{
	
	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement LeadsInformationText;
	
	public WebElement getLeadsInformationText() {
		return LeadsInformationText;
	}
	
	public LeadInformationPage(WebDriver driver, WebdriverUtility webUtility) {
		super(driver, webUtility);
		// TODO Auto-generated constructor stub
	}
	/**
	 * this method used to get text of lead info page
	 * for verification
	 * @return String
	 */
	public String getLeadText() {
		return LeadsInformationText.getText();
	}

}
