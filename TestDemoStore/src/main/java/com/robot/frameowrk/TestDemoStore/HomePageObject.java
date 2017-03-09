/**
 * 
 */
package com.robot.frameowrk.TestDemoStore;

import org.openqa.selenium.WebDriver;

/**
 * ------- HomePageObject ------- Author: QA-DART Created on: Sep 7, 2016
 * History of Changes:
 */
public class HomePageObject extends ProductCategory {

	WebDriver driver;

	public HomePageObject(WebDriver driver) {

		super(driver);

		this.driver = driver;
	}

}
