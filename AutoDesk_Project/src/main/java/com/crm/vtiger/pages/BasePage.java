package com.crm.vtiger.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.crm.vtiger.genericUtils.WebdriverUtility;

public class BasePage {
	
	WebDriver driver;
	WebdriverUtility webUtility;
	
	public BasePage(WebDriver driver, WebdriverUtility webUtility) {
		this.driver=driver;
		this.webUtility=webUtility;
		PageFactory.initElements(driver, this);
	}
}