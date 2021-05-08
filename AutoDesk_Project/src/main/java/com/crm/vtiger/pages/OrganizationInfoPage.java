package com.crm.vtiger.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.crm.vtiger.genericUtils.WebdriverUtility;

public class OrganizationInfoPage extends BasePage {
	

	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement organizationInformationText;
	
	public WebElement getLeadsInformationText() {
		return organizationInformationText;
	}
	public OrganizationInfoPage(WebDriver driver, WebdriverUtility webUtility) {
		super(driver, webUtility);
		// TODO Auto-generated constructor stub
	}
	/**
	 * this method used to get text of organization info page
	 * for verification
	 * @return String
	 */
	public String getOrganizationText() {
		return organizationInformationText.getText();
	}

}
