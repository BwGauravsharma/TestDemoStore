/**
 * 
 */
package com.robot.frameowrk.TestDemoStore;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

/**
 * ------- ProductCategory ------- Author: QA-DART Created on: Sep 7, 2016
 * History of Changes:
 */
public abstract class ProductCategory {

	WebDriver driver;
	private ProductCategory product;

	@FindBys({ @FindBy(id = "menu-item-33"), @FindBy(xpath = "//*[@id='menu-item-33']/ul"), @FindBy(tagName = "li"),
			@FindBy(tagName = "a") })
	List<WebElement> menuItems;

	public ProductCategory(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public ProductCategory NavigateToCategory(String ProducyCategoryName) throws InterruptedException {

		WebElement productCategoryToBeSelected = null;
		Actions action = new Actions(driver);

		WebElement productCategory = driver.findElement(By.id("menu-item-33"));

		action.moveToElement(productCategory).build().perform();

		Thread.sleep(2000);

		System.out.println(menuItems.size());
		// menuItems.stream().forEach(e -> System.out.println(e.getText()));
		System.out.println(menuItems.get(0).getText());

		for (WebElement element : menuItems) {
			if (ProducyCategoryName.equalsIgnoreCase(element.getText())) {

				if (ProducyCategoryName == "Accessories") {

					productCategoryToBeSelected = element;
					productCategoryToBeSelected.click();
					product = new ProductCategoryAccessories(driver);
					break;
				}

				if (ProducyCategoryName == "iMacs") {

					productCategoryToBeSelected = element;
					productCategoryToBeSelected.click();
					product = new ProductCategoryiMacs(driver);
					break;

				}
			}

		}
		return product;

	}

}
