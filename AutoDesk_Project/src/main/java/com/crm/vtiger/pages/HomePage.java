package com.crm.vtiger.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.crm.vtiger.genericUtils.WebdriverUtility;
/**
 * object repository of home page
 * @author rohit
 *
 */
public class HomePage extends BasePage {
	
	@FindBy(xpath = "//img[@src='themes/softed/images/Home.PNG']/following::td[@class='tabUnSelected']/a")
	private List<WebElement> menuLinks;
	
	@FindBy(xpath = "//span[text()=' Administrator']/../..//img")
	private List<WebElement> administratorMenu;
	
	@FindBy(xpath = "//a[text()='Sign Out']")
	private WebElement signoutLink;
	

	public List<WebElement> getMenuLinks() {
		return menuLinks;
	}


	public List<WebElement> getAdministratorMenu() {
		return administratorMenu;
	}


	public HomePage(WebDriver driver, WebdriverUtility webUtility) {
		super(driver, webUtility);
	}
	
	/**
	 * This method used to click on a particular link in homepage menu
	 * @param menuName
	 * @return
	 */
	public BasePage clickOnMenuLink(String menuName) {
		for(WebElement menuLink:menuLinks) {
			if(menuLink.getText().equalsIgnoreCase(menuName)) {
				menuLink.click();
				break;
			}
		}
		switch(menuName.toLowerCase()) {
		case "calender":return new CalenderPage(driver,webUtility);
		case "leads":return new LeadsPage(driver,webUtility);
		case "organization":return new OrganizationPage(driver,webUtility);
		case "contacts":return new ContactsPage(driver,webUtility);
		default: return null;
		}
		
	}
	
	/**
	 * this method is used to click on administrator menu options
	 * @param name
	 * @throws Throwable
	 */
	public void hoverOnAdministrator(String name) throws Throwable {
		for(WebElement admin:administratorMenu) {
			if(admin.getAttribute("src").contains(name)) {
				webUtility.mouseHover(driver, admin);
				webUtility.waitAndClick(signoutLink);
				break;
			}
		}
		
	}

}
