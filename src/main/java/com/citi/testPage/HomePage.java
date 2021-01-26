package com.citi.testPage;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.citi.testBase.TestBase;

public class HomePage extends TestBase {
	@FindBy(xpath = "//input[@type='text']")
	WebElement searchField;

	@FindBy(xpath = "//button[@value='Search']")
	WebElement searchBtn;

	

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

	

	}

