package com.citi.testcases;


import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.citi.testBase.TestBase;
import com.citi.testPage.HomePage;
/*
 * This is Home Page Test Class Define All required test cases of home page 
 */
class HomePageTestCase extends TestBase {
	public static HomePage homepage;

	public HomePageTestCase() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		homepage = new HomePage();

		homepage.serch("London");
		
	}

	@Test
	public void verifyTitle() {
		driver.getTitle();
		String title = homepage.verifyHomePageTitle();
		Assert.assertEquals(title, "cc");
	}
	@Test
	public void testHeaderText()
	{
	String text=	homepage.getHeadingText();
	Assert.assertEquals(text, "Property for sale in London");
	}

	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
}
