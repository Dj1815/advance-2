package com.crm.vtiger.pages;

import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.crm.vtiger.genericUtils.WebdriverUtility;

public class ConvertLeadLink extends BasePage {
	
	@FindBy(xpath = "//input[@type='checkbox' and @value='Potentials']")
	private WebElement opportunityCheckBox;
	
	@FindBy(name = "closingdate")
	private WebElement closingDateTextField;
	
	@FindBy(name = "sales_stage")
	private WebElement salesStageDropDown;
	
	@FindBy(name = "Save")
	private WebElement saveButton;
	
	@FindBy(name = " Cancel")
	private WebElement cancelButton;
	
	@FindBy(xpath = "//td[contains(text(),'Convert Lead')]")
	private WebElement convertLeadInfoText;
	
	public WebElement getConvertLeadInfoText() {
		return convertLeadInfoText;
	}

	public WebElement getCancelButton() {
		return cancelButton;
	}

	public WebElement getOpportunityCheckBox() {
		return opportunityCheckBox;
	}

	public WebElement getClosingDateTextField() {
		return closingDateTextField;
	}

	public WebElement getSalesStageDropDown() {
		return salesStageDropDown;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}

	public ConvertLeadLink(WebDriver driver, WebdriverUtility webUtility) {
		super(driver, webUtility);
	}
	/**
	 * to select opportunity checkbox
	 * date should be in the format YYYY-MM-DD
	 * select dropdown option using the dropdown num
	 * @param date
	 * @param num
	 * @throws InterruptedException
	 */
	public void selectOpportunityCheckBox(String date,int num) throws InterruptedException {
		opportunityCheckBox.click();
		closingDateTextField.sendKeys(date);
		webUtility.selectOption(salesStageDropDown, num);
		
		try {
			webUtility.waitAndClick(saveButton);
		}catch(UnhandledAlertException e) {
			webUtility.acceptAlert(driver);
			getCancelButton().click();
		}
	}
	
	public String getConvertLeadPageInfo() {
		return convertLeadInfoText.getText();
	}

}
