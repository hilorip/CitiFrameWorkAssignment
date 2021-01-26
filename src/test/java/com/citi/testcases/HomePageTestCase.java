package com.citi.testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.citi.testBase.TestBase;
import com.citi.testPage.HomePage;

class HomePageTestCase extends TestBase {
	HomePage homepage;

	public HomePageTestCase() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		// driver.switchTo().alert().accept();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		homepage = new HomePage();

		homepage.serch("London");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void verifyTitle() {
		driver.getTitle();
		String title = homepage.verifyHomePageTitle();
		Assert.assertEquals(title, "cc");
	}

	@Test
	public void mydemotest2()
	{
		System.out.println("this is just a positive test case");
	}
	
}
