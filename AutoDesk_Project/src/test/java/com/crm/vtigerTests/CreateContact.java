package com.crm.vtigerTests;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.crm.vtiger.genericUtils.BaseClass;

public class CreateContact extends BaseClass {
	@Test
	public void createContactandOrg() throws Throwable {
//		WebDriver driver = new ChromeDriver();
//		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//		Actions actions = new Actions(driver);
//		
//		
//		//Step 1: Get Url
//		driver.get("http://localhost:8888");
//		
//		//Step 2: Login to application
//		driver.findElement(By.name("user_name")).sendKeys("admin");
//		driver.findElement(By.name("user_password")).sendKeys("admin");
//		driver.findElement(By.id("submitButton")).click();
		
		//Step 3: click to Contacts
		driver.findElement(By.linkText("Contacts")).click();
		
		//Step 4: create contact
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		driver.findElement(By.name("lastname")).sendKeys("ram");
		
		String parentwid=driver.getWindowHandle();
		String selectOrg="TYSS3";
		
		//Step 3: click on organization
		driver.findElement(By.xpath("//input[@name='account_name']/../img")).click();
		
		 Set<String> allWid = driver.getWindowHandles();
		 
		 
		 for(String wid:allWid) {
			 driver.switchTo().window(wid);
			 List<WebElement> orgList = driver.findElements(By.xpath("//div[@style='overflow:auto;height:348px;']/table//td[1]/a")); //td[@class='lvtCol']/../..//a(we can write this xpath also
			 for(WebElement org:orgList) {
				 if(org.getText().equalsIgnoreCase(selectOrg)) {
					 org.click();
					 break;
				 }
			 }
//			 Thread.sleep(5000);
//			 driver.close();
		 }
		 driver.switchTo().window(parentwid);
		 
		 driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
//		//Step 5: Sign out
//		actions.moveToElement(driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"))).perform();
//		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();

}
}
