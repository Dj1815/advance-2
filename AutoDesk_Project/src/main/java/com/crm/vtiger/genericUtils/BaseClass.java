package com.crm.vtiger.genericUtils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.crm.vtiger.pages.HomePage;
import com.crm.vtiger.pages.LoginPage;

public class BaseClass {
	public WebDriver driver;
	public ExcelUtility eUtil = new ExcelUtility();
	public FileUtility fUtil = new FileUtility();
	public WebdriverUtility wUtil = new WebdriverUtility();
	public JavaUtility jutil = new JavaUtility();
	public static WebDriver sdriver;

	@BeforeSuite(groups = { "smokeTest", "regressionTest" })
	public void configBS() {
		// connect to DB
	}

	@BeforeTest(groups = { "smokeTest", "regressionTest" })
	public void configBT() {
		// launch browser in parallel mode
	}

	// @Parameters("browser")
	@BeforeClass(groups = { "smokeTest", "regressionTest" })
	public void configBC(/* String browserName */) throws Throwable {
		String browserName = fUtil.getPropertyValue("browser");
		if (browserName.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else if (browserName.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else {
			System.out.println("browser not supported");
		}
		sdriver = driver;
		wUtil.maximizeWindow(driver);
		wUtil.waitUntillPageLoad(driver);
	}

	@BeforeMethod(groups = { "smokeTest", "regressionTest" })
	public void setUp() throws Throwable {
		String url = fUtil.getDatafromJason("url");
		String username = fUtil.getDatafromJason("username");
		String password = fUtil.getDatafromJason("password");
		driver.get(url);
		// login to the application
		LoginPage login = new LoginPage(driver, wUtil);
		login.loginToVtiger(username, password);
	}

	@AfterMethod(groups = { "smokeTest", "regressionTest" })
	public void tearDown() throws Throwable {
		HomePage homepage = new HomePage(driver, wUtil);
		homepage.hoverOnAdministrator("user");
	}

	@AfterClass(groups = { "smokeTest", "regressionTest" })
	public void configAC() {
		driver.quit();
	}

	@AfterTest(groups = { "smokeTest", "regressionTest" })
	public void configAT() {
		// close driver ref in parallel mode
	}

	@AfterSuite(groups = { "smokeTest", "regressionTest" })
	public void configAS() {
		// close DB connection
	}

}