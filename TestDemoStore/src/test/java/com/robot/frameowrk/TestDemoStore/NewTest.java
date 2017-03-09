/**
 * 
 */
package com.robot.frameowrk.TestDemoStore;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.DisplayOrder;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

/** 
* ------- NewTest -------
* Author: QA-DART
* Created on: Feb 27, 2017
* History of Changes:
*/
public class NewTest {
	
	
	WebDriver driver;
	public HomePageObject homepage;
	
	private static ExtentReports reporter = new ExtentReports("C:\\NewExtentReports\\TestAutomationReport.html", true, DisplayOrder.NEWEST_FIRST);
	
	//ExtentReports reports;
	//ExtentTest extenttest;

		
	@Parameters({"browser"})
	@BeforeTest
	public void beforeMethod(String Browser) {

		if(Browser.equalsIgnoreCase("firefox")){
			System.out.println("Received firefox browser");
			
			System.setProperty("webdriver.gecko.driver", "C:\\driv\\geckodriver-v0.14.0-win64\\geckodriver.exe");
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		}
		
		if(Browser.equalsIgnoreCase("chrome")){
			
			System.out.println("Received Chrome browser");
			
			System.setProperty("webdriver.chrome.driver", "C:\\driv\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		}
		
		
		homepage = new HomePageObject(driver);

	}
	
	@Parameters({"browser"})
	@Test
	public void Test1(String browser,ITestResult result) throws InterruptedException {

		ExtentTest extenttest1 = reporter.startTest(Thread.currentThread().getStackTrace()[1].getMethodName()+ " : " +browser);
		
		extenttest1.log(LogStatus.INFO, "First Test Started");
		
		extenttest1.log(LogStatus.INFO, "Launching Browser "+browser);
		
		driver.get("http://store.demoqa.com/");
		extenttest1.log(LogStatus.INFO, "Navigated to Store Demo QA Application");
		
		String title = driver.getTitle();
		extenttest1.log(LogStatus.INFO, "Get the WebSite title");
		System.out.println(title);
		
		Assert.assertEquals("1ONLINE STORE | Toolsqa Dummy Test site", title);
		
		if (result.getStatus() == ITestResult.FAILURE) {
			extenttest1.log(LogStatus.FAIL, "Test Failed");

		} else{
			
			extenttest1.log(LogStatus.PASS, "Title verified");
			
		}
		
		
		reporter.endTest(extenttest1);
		reporter.flush();

	}
	
	@Parameters({"browser"})
	@Test
	public void Test2(String browser,ITestResult result) throws InterruptedException {

		ExtentTest extenttest2 = reporter.startTest(Thread.currentThread().getStackTrace()[1].getMethodName()+ " : " +browser);
		extenttest2.log(LogStatus.INFO, "Second Test Started");
		extenttest2.log(LogStatus.INFO, "Launching Browser "+browser);
		driver.get("http://store.demoqa.com/");
		extenttest2.log(LogStatus.INFO, "Navigated to Store Demo QA Application");
		//homepage.NavigateToCategory("iMacs");
		
		String title = driver.getTitle();
		extenttest2.log(LogStatus.INFO, "Get the WebSite title");
		System.out.println(title);
		
		Assert.assertEquals("ONLINE STORE | Toolsqa Dummy Test site", title);
		
		if (result.getStatus() == ITestResult.FAILURE) {
			extenttest2.log(LogStatus.FAIL, "Test Failed");

		} else{
			
			extenttest2.log(LogStatus.PASS, "Title verified");
			
		}
		
		
		reporter.endTest(extenttest2);
		reporter.flush();

	}

	
	@AfterTest
	public void afterTest() {

				
		reporter.close();
		driver.quit();
		
	}
	
}
