package calenderpopup;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CalenderPopUp {
	
	@Test
	public void cleartrip() throws InterruptedException, AWTException
	{
		ChromeOptions op=new ChromeOptions();
		op.addArguments("--disable-notifications");
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver(op);
		driver.manage().window().maximize();
		driver.get("https://www.cleartrip.com/");
		//Actions  act=new Actions(driver);
		//act.moveByOffset(20, 20).perform();
		Robot ro=new Robot();
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.id("FromTag")).sendKeys("blr");
		Thread.sleep(2000);
		ro.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
		ro.keyRelease(KeyEvent.VK_ENTER);
		driver.findElement(By.id("ToTag")).sendKeys("ixd");
		Thread.sleep(2000);
		ro.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
		ro.keyRelease(KeyEvent.VK_ENTER);
		
		
		//particular date
	//	driver.findElement(By.xpath("(//a[.='30'])[1]")).click();
//==============================================================================================================		
		//For current date
	/*	 Date dObj=new Date();
		int getdate=dObj.getDate();
		 int getmonth=dObj.getMonth();
		
		String currentdate=dObj.toString();
		System.out.println(currentdate);
		String[] arr=currentdate.split(" ");
		//Tue Apr 27 17:08:24 IST 2021 
		  //0    1    2   3   4    5 
		String day=arr[0];
		//String month=arr[1];
		//String date=arr[2];
		String time=arr[3];
		String timezone=arr[4];
		String year=arr[5];
		
	//String presentdate=date+" "+month+" "+year;
	//System.out.println(day+" "+month+" "+date+" "+year);
	//System.out.println(presentdate);
		
	
	driver.findElement(By.xpath("//td[@data-month='"+getmonth+"' and @data-year='"+year+"']/a[text()='"+getdate+"']")).click();
	//	driver.findElement(By.id("SearchBtn")).click();
	*/
	//==================================================================================================================	
		//for Future Date
		   while (true){
			   try {
				   driver.findElement(By.xpath("//td[@data-month='6' and @data-year='2021']/a[text()='24']")).click();
				   break;
			   }
			   catch(Exception  e) {
				   driver.findElement(By.xpath("(//a[@title='Next'])[2]")).click();
			   }
		   }
		
	}

}