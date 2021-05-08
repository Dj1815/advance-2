package dynamicwebtale;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Capture3 {
	
	@Test
	public void deleteOrgName() throws InterruptedException {
		//System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		WebDriverWait wait=new WebDriverWait(driver, 10);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		//Step1: get url
		driver.get("http://localhost:8888/");
		
		//step2:login to application
		
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		
		//step3:navigate to organization
		
		driver.findElement(By.linkText("Organizations")).click();
		
		String xpathorganization="//table[@class='lvt small']//a[@title='Organizations']";
		
		List <WebElement> list = driver.findElements(By.xpath(xpathorganization));
		
		String expectedText="TYSS";
		
		for(WebElement ele:list) {
			System.out.println(ele.getText());
			Thread.sleep(5000);
			if(ele.getText().equalsIgnoreCase(expectedText)) {
				driver.findElement(By.linkText("del")).click();
				break;
			}
			wait.until(ExpectedConditions.alertIsPresent());
			driver.switchTo().alert().accept();
		}
		
		Thread.sleep(5000);
		driver.quit();
		
	}

}
