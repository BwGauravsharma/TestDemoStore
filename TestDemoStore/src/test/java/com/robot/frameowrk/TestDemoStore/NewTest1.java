/**
 * 
 */
package com.robot.frameowrk.TestDemoStore;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

/** 
* ------- NewTest1 -------
* Author: QA-DART
* Created on: Feb 28, 2017
* History of Changes:
*/
public class NewTest1 {
	
	public WebDriver driver;
	public HomePageObject homepage;
	
	
	private static ExtentReports reporter = new ExtentReports("C:\\NewExtentReports\\TestAutomationReport.html", true);
	
	String browserName = null;
	Capabilities cap;
	
	
	@Parameters({"browser"})
	@BeforeMethod
	public void beforeMethod(String Browser) {
		
		if(Browser.equalsIgnoreCase("firefox")){
			
			System.out.println("Received firefox browser");
			
			System.setProperty("webdriver.gecko.driver", "C:\\driv\\geckodriver-v0.14.0-win64\\geckodriver.exe");
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			cap = ((RemoteWebDriver) driver).getCapabilities();

		}
		
		if(Browser.equalsIgnoreCase("chrome")){
			
			System.out.println("Received Chrome browser");
			
			System.setProperty("webdriver.chrome.driver", "C:\\driv\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			cap = ((RemoteWebDriver) driver).getCapabilities();
			
		}
		
		driver.get("http://store.demoqa.com/");
		homepage = new HomePageObject(driver);

	}
	
	@Test
	public void Test1() throws InterruptedException {
		
		browserName = cap.getBrowserName();
		
		ExtentTest extenttest = reporter.startTest(Thread.currentThread().getStackTrace()[1].getMethodName()+ " : " +browserName);
		
		extenttest.log(LogStatus.INFO, "First Test Started");
		
		extenttest.log(LogStatus.INFO, "Launching Browser "+browserName);
		
		extenttest.log(LogStatus.INFO, "Navigated to Store Demo QA Application");
		
		String title = driver.getTitle();
		extenttest.log(LogStatus.INFO, "Get the WebSite title");
		System.out.println(title);
		
		String expectedTitle = "ONLINE STORE | Toolsqa Dummy Test site";
		
		
		//Assert.assertEquals("1ONLINE STORE | Toolsqa Dummy Test site", title);
		
		if(title.equals("1ONLINE STORE | Toolsqa Dummy Test site")){
			
			extenttest.log(LogStatus.PASS, "Title verified");
			
		} else{
			
			
			extenttest.log(LogStatus.FAIL, "Test Failed");
		}
		
		reporter.endTest(extenttest);
		reporter.flush();

	}
	
	@Parameters({"browser"})
	@Test(enabled = false)
	public void Test2(String browser) throws InterruptedException {

		ExtentTest extenttest1 = reporter.startTest(Thread.currentThread().getStackTrace()[1].getMethodName()+ " : " +browser);
		
		extenttest1.log(LogStatus.INFO, "Second Test Started");
		
		extenttest1.log(LogStatus.INFO, "Launching Browser "+browser);
		
		//driver.get("http://store.demoqa.com/");
		extenttest1.log(LogStatus.INFO, "Navigated to Store Demo QA Application");
		
		String title = driver.getTitle();
		extenttest1.log(LogStatus.INFO, "Get the WebSite title");
		System.out.println(title);
		
		
		
		//Assert.assertEquals("ONLINE STORE | Toolsqa Dummy Test site", title);
		
		if(title.equals("ONLINE STORE | Toolsqa Dummy Test site")){
			
			extenttest1.log(LogStatus.PASS, "Title verified");
			
		} else{
			
			extenttest1.log(LogStatus.FAIL, "Test Failed");
		}
		
		
		
		reporter.endTest(extenttest1);
		reporter.flush();
		
	}

	
	@AfterMethod
	public void afterMethod(ITestResult result){
		
		/*if (result.getStatus() == ITestResult.FAILURE) {
			extenttest.log(LogStatus.FAIL, "Test Failed");

		}*/
		
		
		
		//driver.quit();
		
		
	}
	
	@AfterSuite
	public void afterTest() {

		
		//reporter.close();
		//driver.quit();
		
		
	}

}
