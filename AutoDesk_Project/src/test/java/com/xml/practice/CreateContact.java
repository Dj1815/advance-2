package com.xml.practice;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.crm.vtiger.genericUtils.BaseClass;

public class CreateContact extends BaseClass{

	@Test(groups = "smokeTest")  
	public void createContact() throws Throwable
	{
		
		String lastName=eUtil.getExcelData("contact", 1, 2)+"_"+jutil.getRandomData();
		//Navigate to contacts
		driver.findElement(By.linkText("Contacts")).click();
		
		//Create Contact with organization
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		driver.findElement(By.name("lastname")).sendKeys(lastName);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
	}

	
	
	@Test(groups = "regressionTest")
	public void createContactWithOrg() throws Throwable
	{
		String orgName=eUtil.getExcelData("contact", 4, 3);
		String lastName=eUtil.getExcelData("contact", 4, 2)+"_"+jutil.getRandomData();
		
		
		//Navigate to contacts
		driver.findElement(By.linkText("Contacts")).click();
		
		//Create Contact with organization
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		driver.findElement(By.name("lastname")).sendKeys(lastName);
		driver.findElement(By.xpath("//input[@name='account_name']/following-sibling::img[@alt='Select']")).click();
		wUtil.switchToWindow(driver, "Accounts");
		driver.findElement(By.id("search_txt")).sendKeys(orgName);
		driver.findElement(By.name("search")).click();
		driver.findElement(By.linkText(orgName)).click();
		wUtil.switchToWindow(driver, "Contacts");
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
	}

}
