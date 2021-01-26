package com.citi.testPage;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.citi.testBase.TestBase;



/*
 * This is POM Home Page Claas 
 */
public class HomePage extends TestBase {
	
	//Devie All Web Elements as Centralize Repository
	@FindBy(xpath = "//input[@type='text']")
	WebElement searchField;

	@FindBy(xpath = "//button[@value='Search']")
	WebElement searchBtn;

	@FindBy(xpath = "//h1[contains(text(),'London')]")
	WebElement headertext;

	// Initializing the Page Objects:
	public HomePage() {

		PageFactory.initElements(driver, this);
	}

	// Actions
	public String verifyHomePageTitle() {
		return driver.getTitle();
	}

	public void serch(String location) {
		System.out.println("search calles + " + location + " " + searchField);
		searchField.sendKeys(location);
		searchBtn.click();
	}

	public String getHeadingText() {
		return headertext.getText();
	}

}