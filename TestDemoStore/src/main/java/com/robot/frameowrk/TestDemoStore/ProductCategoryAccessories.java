/**
 * 
 */
package com.robot.frameowrk.TestDemoStore;

import org.openqa.selenium.WebDriver;

/** 
* ------- ProductCategoryAccessories -------
* Author: QA-DART
* Created on: Sep 7, 2016
* History of Changes:
*/
public class ProductCategoryAccessories extends ProductCategory{
	
	WebDriver driver;
	
	public ProductCategoryAccessories(WebDriver driver){
		
		super(driver);
		this.driver = driver;
		
	}

}
