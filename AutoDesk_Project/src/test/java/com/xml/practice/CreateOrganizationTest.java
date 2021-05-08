package com.xml.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.crm.vtiger.genericUtils.BaseClass;

public class CreateOrganizationTest extends BaseClass{
	
	@Test(groups = "smokeTest")
	public void createOrganizationTest() throws Throwable
	{
		String orgName=eUtil.getExcelData("org", 1, 2);
		
		//Navigate to organizations
		driver.findElement(By.linkText("Organizations")).click();
		Reporter.log("organization page found",true);
		
		//create organization
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		Reporter.log("click on create organization");
		
		driver.findElement(By.name("accountname")).sendKeys(orgName+jutil.getRandomData());
		Reporter.log("create organization with organization name");
		
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		Reporter.log("click on save");
		
	    //verification
		wUtil.waitForElementVisibility(driver, driver.findElement(By.xpath("//span[@class='dvHeaderText']")));
		String expData=driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
	    //Assert.assertTrue(expData.contains(orgName));
	    
	    Assert.assertTrue(expData.contains(orgName));
	    
	    Reporter.log("the expected data is"+expData , true);	
	}
	
	@Test(groups = "regressionTest" )
	public void createOrgWithIndustryTest() throws Throwable
	{
		
		String orgName=eUtil.getExcelData("org", 4, 2);
		String industryType=eUtil.getExcelData("org", 4, 3);
		
		

		//Navigate to organizations
		driver.findElement(By.linkText("Organizations")).click();

		//create organization
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		driver.findElement(By.name("accountname")).sendKeys(orgName+jutil.getRandomData());
        
		WebElement industry=driver.findElement(By.name("industry"));
		wUtil.selectOption(industry, industryType);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		  //verification
		wUtil.waitForElementVisibility(driver, driver.findElement(By.xpath("//span[@class='dvHeaderText']")));
		String expData=driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
	    //Assert.assertTrue(expData.contains(orgName));
	    
	    Assert.assertTrue(expData.contains(orgName));
	    
	    Reporter.log("the expected data is"+expData , true);	




	}


}
