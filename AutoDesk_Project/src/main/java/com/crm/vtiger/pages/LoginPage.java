package com.crm.vtiger.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.crm.vtiger.genericUtils.WebdriverUtility;

/**
 * this method contains login page elements and methods
 * @author rohit
 *
 */
public class LoginPage extends BasePage {
	
	
	@FindBy(name = "user_name")
	private WebElement userNameTextField;
	
	@FindBy(name = "user_password")
	private WebElement passwordTextField;
	
	@FindBy(id = "submitButton")
	private WebElement loginButton;
	

	public WebElement getUserNameTextField() {
		return userNameTextField;
	}


	public WebElement getPasswordTextField() {
		return passwordTextField;
	}


	public WebElement getLoginButton() {
		return loginButton;
	}


	public LoginPage(WebDriver driver, WebdriverUtility webUtility) {
		super(driver, webUtility);
	}
	
	/**
	 * use this method to login to vtiger application
	 * @param userName
	 * @param password
	 * @return
	 */
	//action methods for login page
	public HomePage loginToVtiger(String userName,String password) {
		webUtility.enterData(userNameTextField, userName);
		webUtility.enterData(passwordTextField, password);
		loginButton.click();
		return new HomePage(driver,webUtility);
		
	}
}
